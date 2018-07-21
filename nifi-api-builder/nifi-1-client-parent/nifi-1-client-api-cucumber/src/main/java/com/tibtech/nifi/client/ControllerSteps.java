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

public class ControllerSteps
{
    private final TestState testState;

    public ControllerSteps(final TestState testState)
    {
        this.testState = testState;
    }

    @Given("^there are Controller Services$")
    public void there_are_controller_services() throws Exception
    {
        final Controller controller = testState.getController();
        final ControllerService controllerService = controller.createControllerService(DistributedMapCacheServer.COMPONENT_TYPE, controllerServiceDTOBuilder -> {
        });
        testState.addCreatedControllerService(controllerService);
    }

    @Given("^there are Reporting Tasks$")
    public void there_are_reporting_tasks() throws Exception
    {
        final Controller controller = testState.getController();
        final ReportingTask reportingTask = controller.createReportingTask(MonitorMemory.COMPONENT_TYPE, reportingTaskDTOBuilder -> {
        });
        testState.addCreatedReportingTask(reportingTask);
    }

    @Given("^there are no Controller Services$")
    public void there_are_no_controller_services() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getControllerServices().forEach(controllerService -> controllerService.delete());
    }

    @Given("^there are no Reporting Tasks$")
    public void there_are_no_reporting_tasks() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getReportingTasks().forEach(reportingTask -> reportingTask.delete());
    }

    @When("^create a Controller Service$")
    public void create_a_controller_service() throws Exception
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

    @When("^get all Controller Services$")
    public void all_controller_services_are_requested() throws Exception
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

    @Then("^all Controller Services are returned$")
    public void all_controller_services_are_returned() throws Exception
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

    @Then("^a Controller Service exists")
    public void a_controller_service_exists() throws Exception
    {
        assertFalse(testState.getCreatedControllerServices().isEmpty());
    }

    @Then("^a Reporting Task exists")
    public void a_reporting_task_exists() throws Exception
    {
        assertFalse(testState.getCreatedReportingTasks().isEmpty());
    }
}
