package com.tibtech.nifi.client;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfter
{
    private final TestState testState;

    public BeforeAndAfter(final TestState testState)
    {
        this.testState = testState;
    }

    @Before
    public void before() throws Exception
    {
        final Controller controller = Controller.connect("http://localhost:8080");
        testState.setController(controller);
    }

    @After
    public void after() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getReportingTasks().forEach(reportingTask -> reportingTask.stop().delete());
        controller.getControllerServices().forEach(controllerService -> controllerService.disable().delete());
        final ProcessGroup rootProcessGroup = controller.getRootProcessGroup();

        // First, stop anything that's running.
        rootProcessGroup.getProcessors().forEach(processor -> processor.stop());
        rootProcessGroup.getInputPorts().forEach(inputPort -> inputPort.stop());
        rootProcessGroup.getOutputPorts().forEach(outputPort -> outputPort.stop());
        rootProcessGroup.getProcessGroups().forEach(processGroup -> processGroup.stopComponents());
        rootProcessGroup.getControllerServices(true, true).forEach(controllerService -> controllerService.disable());

        // Next, clear the connections.

        // Now the connections can be deleted

        // Now everything else can be deleted.
        controller.getTemplates().forEach(template -> template.delete());
    }
}
