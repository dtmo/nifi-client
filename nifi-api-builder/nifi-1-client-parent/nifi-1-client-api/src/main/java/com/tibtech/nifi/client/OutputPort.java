package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.outputport.GetOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.RemoveOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.UpdateOutputPortInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import org.apache.nifi.web.api.entity.PortEntity;

import java.util.function.Consumer;

/**
 * OutputPort represents a NiFi flow output port which provides a mechanism for
 * transferring data from a Process Group to destinations outside of the Process
 * Group.
 */
public class OutputPort extends Port<OutputPort>
{
    /**
     * Constructs a new instance of OutputPort.
     *
     * @param controller The controller to which the output port belongs.
     * @param portEntity The entity that represents the output port.
     */
    public OutputPort(final Controller controller, final PortEntity portEntity)
    {
        super(controller, portEntity);
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.OUTPUT_PORT;
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveOutputPortInvoker(getController().getTransport()).setId(getId())
                .setVersion(getRevisionDTO().getVersion()).invoke();
    }

    @Override
    public OutputPort refresh() throws InvokerException
    {
        setComponentEntity(new GetOutputPortInvoker(getController().getTransport()).setId(getId()).invoke());

        return this;
    }

    @Override
    public OutputPort update(final Consumer<PortDTOBuilder> configurator) throws InvokerException
    {
        final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setId(getId());

        configurator.accept(portDTOBuilder);

        setComponentEntity(new UpdateOutputPortInvoker(getController().getTransport()).setId(getId()).setPortEntity(
                new PortEntityBuilder().setComponent(portDTOBuilder.build()).setRevision(getRevisionDTO()).build())
                .invoke());

        return this;
    }

    @Override
    public OutputPort update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = OutputPort.class) final Closure<PortDTOBuilder> closure)
            throws InvokerException
    {
        return super.update(closure);
    }
}
