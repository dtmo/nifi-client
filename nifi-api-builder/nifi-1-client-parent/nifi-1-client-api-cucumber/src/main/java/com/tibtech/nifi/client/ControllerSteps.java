package com.tibtech.nifi.client;

import com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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

    @After
    public void after() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getControllerServices().forEach(controllerService -> controllerService.delete());
    }

    @Given("^NiFi is available$")
    public void nifi_is_available() throws Exception
    {
        final Controller controller = Controller.connect("http://localhost:8080");
        testState.setController(controller);
    }

    @Given("^there are Controller Services$")
    public void there_are_controller_services() throws Exception
    {
        final Controller controller = testState.getController();
        final ControllerService controllerService = controller.createControllerService(DistributedMapCacheServer.COMPONENT_TYPE, controllerServiceDTOBuilder -> {
        });
        testState.addCreatedControllerService(controllerService);
    }

    @Given("^there are no Controller Services$")
    public void there_are_no_controller_services() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getControllerServices().forEach(controllerService -> controllerService.delete());
    }

    @When("^create Controller Service$")
    public void create_controller_service() throws Exception
    {
        final Controller controller = testState.getController();
        final ControllerService controllerService = controller.createControllerService(DistributedMapCacheServer.COMPONENT_TYPE, controllerServiceDTOBuilder -> {
        });
        testState.addCreatedControllerService(controllerService);
    }

    @When("^get all Controller Services$")
    public void all_controller_services_are_requested() throws Exception
    {
        final Controller controller = testState.getController();
        controller.getControllerServices().stream()
                .forEach(controllerService -> testState.addGotControllerService(controllerService));
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

    @Then("^a Controller Service exists")
    public void a_controller_service_exists() throws Exception
    {
        assertFalse(testState.getCreatedControllerServices().isEmpty());
    }
}
