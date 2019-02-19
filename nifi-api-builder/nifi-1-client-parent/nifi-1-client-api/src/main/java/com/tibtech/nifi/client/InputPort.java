package com.tibtech.nifi.client;

import java.util.function.Consumer;

import org.apache.nifi.web.api.entity.PortEntity;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.inputport.GetInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.RemoveInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.UpdateInputPortInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

/**
 * InputPort represents a NiFi flow input port which provides a mechanism for
 * transferring data into a Process Group.
 */
public class InputPort extends Port<InputPort>
{
    /**
     * Constructs a new instance of InputPort.
     *
     * @param controller The controller to which the input port belongs.
     * @param portEntity The entity that represents the input port.
     */
    public InputPort(final Controller controller, final PortEntity portEntity)
    {
        super(controller, portEntity);
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.INPUT_PORT;
    }

    @Override
    public InputPort refresh() throws InvokerException
    {
        setComponentEntity(new GetInputPortInvoker(getController().getTransport()).setId(getId()).invoke());

        return this;
    }

    @Override
    public InputPort update(final Consumer<PortDTOBuilder> configurator) throws InvokerException
    {
        final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setId(getId());

        configurator.accept(portDTOBuilder);

        setComponentEntity(new UpdateInputPortInvoker(getController().getTransport()).setId(getId()).setPortEntity(
                new PortEntityBuilder().setComponent(portDTOBuilder.build()).setRevision(getRevisionDTO()).build())
                .invoke());

        return this;
    }

    @Override
    public InputPort update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InputPort.class) final Closure<PortDTOBuilder> closure)
            throws InvokerException
    {
        return super.update(closure);
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveInputPortInvoker(getController().getTransport()).setId(getId())
                .setVersion(getRevisionDTO().getVersion()).invoke();
    }
    
    @Override
    public SetScheduledStateRequest<InputPort> createSetScheduledStateRequest(final boolean running)
    {
        final String scheduledState = running ? ScheduledStates.RUNNING : ScheduledStates.STOPPED;
        
        update(portDtoBuilder -> portDtoBuilder.setState(scheduledState));
        
        return new SetScheduledStateRequest<InputPort>(this, running);
    }
}
