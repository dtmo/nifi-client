package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.outputport.GetOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.RemoveOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.UpdateOutputPortInvoker;
import org.apache.nifi.web.api.entity.PortEntity;

import java.util.function.Consumer;

/**
 * OutputPort represents a NiFi flow output port which provides a mechanism for transferring data from a Process Group
 * to destinations outside of the Process Group.
 */
public class OutputPort extends Port<OutputPort>
{
    /**
     * Constructs a new instance of OutputPort.
     *
     * @param transport  The transport with which to communicate with the NiFi server.
     * @param portEntity The entity that represents the output port.
     */
    public OutputPort(final Transport transport, final PortEntity portEntity)
    {
        super(transport, portEntity);
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.OUTPUT_PORT;
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveOutputPortInvoker(getTransport(), getVersion()).setId(getId());
    }

    @Override
    public OutputPort refresh() throws InvokerException
    {
        setComponentEntity(new GetOutputPortInvoker(getTransport(), getVersion()).setId(getId()).invoke());

        return this;
    }

    @Override
    public OutputPort update(final Consumer<PortDTOBuilder> configurator) throws InvokerException
    {
        final PortDTOBuilder portDTOBuilder = PortDTOBuilder.of(getPortDTO());

        configurator.accept(portDTOBuilder);

        setComponentEntity(new UpdateOutputPortInvoker(getTransport(), getVersion())
                .setId(getId())
                .setPortEntity(new PortEntityBuilder()
                        .setComponent(portDTOBuilder.build())
                        .build())
                .invoke());

        return this;
    }
}
