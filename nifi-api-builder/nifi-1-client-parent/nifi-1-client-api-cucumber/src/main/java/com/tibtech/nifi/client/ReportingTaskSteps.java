package com.tibtech.nifi.client;

import com.tibtech.nifi.controller.MonitorMemory;
import com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReportingTaskSteps
{
    private final TestState testState;

    public ReportingTaskSteps(final TestState testState)
    {
        this.testState = testState;
    }

    @Given("^there are Reporting Task Controller Services$")
    public void there_are_reporting_task_controller_services() throws Exception
    {
        final Controller controller = testState.getController();
        final ControllerService controllerService = controller.createControllerService(DistributedMapCacheServer.COMPONENT_TYPE, controllerServiceDTOBuilder -> {
        });
        testState.addCreatedControllerService(controllerService);
    }

    @Given("^a Reporting Task has been created$")
    public void a_reporting_task_has_been_created() throws Exception
    {
        final Controller controller = testState.getController();
        final ReportingTask reportingTask = controller.createReportingTask(MonitorMemory.COMPONENT_TYPE, reportingTaskDTOBuilder -> {
        });
        testState.addCreatedReportingTask(reportingTask);
    }

    @Given("^there are no Reporting Task Controller Services$")
    public void there_are_no_reporting_task_controller_services() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getControllerServices().forEach(controllerService -> controllerService.delete());
    }

    @Given("^a Reporting Task has not been created$")
    public void a_reporting_task_has_not_been_created() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getReportingTasks().forEach(reportingTask -> reportingTask.delete());
    }

    @When("^create a Reporting Task Controller Service$")
    public void create_a_reporting_task_controller_service() throws Exception
    {
        final Controller controller = testState.getController();
        final ControllerService controllerService = controller.createControllerService(DistributedMapCacheServer.COMPONENT_TYPE, controllerServiceDTOBuilder -> {
        });
        testState.addCreatedControllerService(controllerService);
    }

    @When("^create a Reporting Task$")
    public void create_a_reporting_task() throws Exception
    {
        final Controller controller = testState.getController();
        final ReportingTask reportingTask = controller.createReportingTask(MonitorMemory.COMPONENT_TYPE, reportingTaskDTOBuilder -> {});
        testState.addCreatedReportingTask(reportingTask);
    }

    @When("^get all Reporting Task Controller Services$")
    public void all_reporting_task_controller_services_are_requested() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getControllerServices().stream()
                .forEach(controllerService -> testState.addGotControllerService(controllerService));
    }

    @When("^get all Reporting Tasks$")
    public void get_all_reporting_tasks() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getReportingTasks().stream()
                .forEach(reportingTask -> testState.addGotReportingTask(reportingTask));
    }

    @When("^delete the Reporting Task$")
    public void delete_the_reporting_task() throws Exception
    {
        testState.getCreatedReportingTasks().stream()
                .forEach(reportingTask -> reportingTask.delete());
    }

    @Then("^all Reporting Task Controller Services are returned$")
    public void all_reporting_task_controller_services_are_returned() throws Exception
    {
        final Set<String> createdIds = testState.getCreatedControllerServices().stream()
                .map(controllerService -> controllerService.getId())
                .collect(Collectors.toSet());
        final Set<String> gotIds = testState.getGotControllerServices().stream()
                .map(controllerService -> controllerService.getId())
                .collect(Collectors.toSet());

        assertEquals(createdIds, gotIds);
    }

    @Then("^all Reporting Tasks are returned$")
    public void all_reporting_tasks_are_returned() throws Exception
    {
        final Set<String> createdIds = testState.getCreatedReportingTasks().stream()
                .map(reportingTask -> reportingTask.getId())
                .collect(Collectors.toSet());
        final Set<String> gotIds = testState.getGotReportingTasks().stream()
                .map(reportingTask -> reportingTask.getId())
                .collect(Collectors.toSet());

        assertEquals(createdIds, gotIds);
    }

    @Then("^a Reporting Task Controller Service exists")
    public void a_reporting_task_controller_service_exists() throws Exception
    {
        assertFalse(testState.getCreatedControllerServices().isEmpty());
    }

    @Then("^a Reporting Task exists")
    public void a_reporting_task_exists() throws Exception
    {
        assertFalse(testState.getController().getReportingTasks().isEmpty());
    }

    @Then("^no Reporting Task exists")
    public void no_reporting_task_exists() throws Exception
    {
        assertTrue(testState.getController().getReportingTasks().isEmpty());
    }
}
