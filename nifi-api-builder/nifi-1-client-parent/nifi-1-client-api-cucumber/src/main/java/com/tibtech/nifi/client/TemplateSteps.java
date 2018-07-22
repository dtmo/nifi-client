package com.tibtech.nifi.client;

import com.tibtech.nifi.processors.standard.GenerateFlowFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Set;

import static org.junit.Assert.*;

public class TemplateSteps
{
    private final TestState testState;

    public TemplateSteps(final TestState testState)
    {
        this.testState = testState;
    }

    @Given("^a Snippet has been created$")
    public void a_snippet_has_been_created() throws Exception
    {
        final Controller controller = testState.getController();
        final ProcessGroup rootProcessGroup = controller.getRootProcessGroup();
        final Processor processor = rootProcessGroup.createProcessor(0, 0, GenerateFlowFile.COMPONENT_TYPE, processorDTOBuilder -> {
        });
        final Snippet snippet = rootProcessGroup.createSnippet(snippetDTOBuilder -> snippetDTOBuilder.addProcessor(processor));
        testState.setCreatedSnippet(snippet);
    }

    @Given("^a Template has been created$")
    public void a_template_has_been_created() throws Exception
    {
        final Controller controller = testState.getController();
        final ProcessGroup rootProcessGroup = controller.getRootProcessGroup();
        final Processor processor = rootProcessGroup.createProcessor(0, 0, GenerateFlowFile.COMPONENT_TYPE, processorDTOBuilder -> {
        });
        final Snippet snippet = rootProcessGroup.createSnippet(snippetDTOBuilder -> snippetDTOBuilder.addProcessor(processor));
        final Template template = snippet.createTemplate("template");
        testState.setCreatedTemplate(template);
        processor.delete();
    }

    @Given("^there is no Template called 'Template_Upload_Test'$")
    public void there_is_no_template_called_template_upload_test() throws Throwable
    {
        final Controller controller = testState.getController();
        controller.getTemplates().stream()
                .filter(template -> template.getName().equals("Template_Upload_Test"))
                .forEach(template -> template.delete());
    }

    @When("^create a Template$")
    public void create_a_template() throws Exception
    {
        final Template testTemplate = testState.getCreatedSnippet().createTemplate("test template");
        testState.setCreatedTemplate(testTemplate);
    }

    @When("^the Template is instantiated in the Root Process Group$")
    public void the_template_is_instantiated_in_the_root_process_group() throws Exception
    {
        final Controller controller = testState.getController();
        final ProcessGroup rootProcessGroup = controller.getRootProcessGroup();
        final Flow instantiatedComponents = rootProcessGroup.instantiateTemplate(0, 0, testState.getCreatedTemplate());
        testState.setInstantiatedComponents(instantiatedComponents);
    }

    @When("^the Template is deleted$")
    public void the_template_is_deleted() throws Exception
    {
        testState.getCreatedTemplate().delete();
    }

    @When("^export the Template$")
    public void export_the_template() throws Exception
    {
        final String exportedTemplate = testState.getCreatedTemplate().export();
        testState.setExportedTemplate(exportedTemplate);
    }

    @When("^the 'Template_Upload_Test' Template is uploaded$")
    public void the_template_upload_test_template_is_uploaded() throws Throwable
    {
        final Template template = testState.getController()
                .getRootProcessGroup()
                .uploadTemplate(TemplateSteps.class.getResourceAsStream("Template_Upload_Test.xml"));
        testState.setCreatedTemplate(template);
    }

    @Then("^getting all Templates includes the Template$")
    public void getting_all_templates_includes_the_template() throws Exception
    {
        final Controller controller = testState.getController();
        final Set<Template> gotTemplates = controller.getTemplates();

        assertTrue(gotTemplates.contains(testState.getCreatedTemplate()));
    }

    @Then("^the Root Process Group contains the Template components$")
    public void the_root_process_group_contains_the_template_components() throws Exception
    {
        final Controller controller = testState.getController();
        final ProcessGroup rootProcessGroup = controller.getRootProcessGroup();
        testState.getInstantiatedComponents().getConnections()
                .forEach(connection -> assertTrue(rootProcessGroup.getConnections().contains(connection)));
        testState.getInstantiatedComponents().getFunnels()
                .forEach(funnel -> assertTrue(rootProcessGroup.getFunnels().contains(funnel)));
        testState.getInstantiatedComponents().getInputPorts()
                .forEach(inputPort -> assertTrue(rootProcessGroup.getInputPorts().contains(inputPort)));
        testState.getInstantiatedComponents().getLabels()
                .forEach(label -> assertTrue(rootProcessGroup.getLabels().contains(label)));
        testState.getInstantiatedComponents().getOutputPorts()
                .forEach(outputPort -> assertTrue(rootProcessGroup.getOutputPorts().contains(outputPort)));
        testState.getInstantiatedComponents().getProcessGroups()
                .forEach(processGroup -> assertTrue(rootProcessGroup.getProcessGroups().contains(processGroup)));
        testState.getInstantiatedComponents().getProcessors()
                .forEach(processor -> assertTrue(rootProcessGroup.getProcessors().contains(processor)));
        testState.getInstantiatedComponents().getRemoteProcessGroups()
                .forEach(remoteProcessGroup -> assertTrue(rootProcessGroup.getRemoteProcessGroups().contains(remoteProcessGroup)));
    }

    @Then("^getting all Templates does not include the Template$")
    public void getting_all_templates_does_not_include_the_template() throws Exception
    {
        final Controller controller = testState.getController();
        final Set<Template> gotTemplates = controller.getTemplates();

        assertFalse(gotTemplates.contains(testState.getCreatedTemplate()));
    }

    @Then("^the template is exported")
    public void the_template_is_exported() throws Exception
    {
        assertNotNull(testState.getExportedTemplate());
    }

    @Then("^there is a Template called 'Template_Upload_Test'$")
    public void there_is_a_template_called_template_upload_test() throws Throwable
    {
        final Controller controller = testState.getController();
        assertTrue(controller.getTemplates().stream()
                .anyMatch(template -> template.getName().equals("Template_Upload_Test")));
    }
}
