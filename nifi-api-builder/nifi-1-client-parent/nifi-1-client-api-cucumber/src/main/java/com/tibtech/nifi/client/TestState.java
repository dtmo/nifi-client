package com.tibtech.nifi.client;

import java.util.HashSet;
import java.util.Set;

public class TestState
{
    private Controller controller = null;

    private Set<ControllerService> createdControllerServices = new HashSet<>();
    private Set<ControllerService> gotControllerServices = new HashSet<>();

    public void setController(final Controller controller)
    {
        if (this.controller == null)
        {
            this.controller = controller;
        }
        else
        {
            throw new IllegalStateException("Controller is already set");
        }
    }

    public Controller getController()
    {
        return this.controller;
    }

    public void addCreatedControllerService(final ControllerService controllerService)
    {
        this.createdControllerServices.add(controllerService);
    }

    public Set<ControllerService> getCreatedControllerServices()
    {
        return this.createdControllerServices;
    }

    public void addGotControllerService(final ControllerService controllerService)
    {
        this.gotControllerServices.add(controllerService);
    }

    public Set<ControllerService> getGotControllerServices()
    {
        return gotControllerServices;
    }
}
