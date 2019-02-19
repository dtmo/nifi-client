package com.tibtech.nifi.client;

public class SetEnabledStateRequest implements AsynchronousRequest<SetEnabledStateRequest>
{
    private ControllerService controllerService;

    private final boolean enabled;

    public SetEnabledStateRequest(final ControllerService controllerService, final boolean enabled)
    {
        this.controllerService = controllerService;
        this.enabled = enabled;
    }

    @Override
    public boolean isFinished()
    {
        return controllerService.getEnabledState().equals(EnabledStates.ENABLED) == enabled;
    }

    @Override
    public SetEnabledStateRequest refresh()
    {
        controllerService = controllerService.refresh();
        return this;
    }
}
