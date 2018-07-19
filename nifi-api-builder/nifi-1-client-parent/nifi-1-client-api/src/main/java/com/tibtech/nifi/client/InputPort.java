package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.inputport.GetInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.RemoveInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.UpdateInputPortInvoker;
import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.entity.PortEntity;

import java.util.function.Consumer;

/**
 * InputPort represents a NiFi flow input port which provides a mechanism for transferring data into a Process Group.
 */
public class InputPort extends Port<InputPort>
{
    /**
     * Constructs a new instance of InputPort.
     *
     * @param transport  The transport with which to communicate with the NiFi server.
     * @param portEntity The entity that represents the input port.
     */
    public InputPort(final Transport transport, final PortEntity portEntity)
    {
        super(transport, portEntity);
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.INPUT_PORT;
    }

    @Override
    public InputPort refresh() throws InvokerException
    {
        setComponentEntity(new GetInputPortInvoker(getTransport(), getVersion()).setId(getId()).invoke());

        return this;
    }

    @Override
    public InputPort update(final Consumer<PortDTOBuilder> configurator) throws InvokerException
    {
        final PortDTOBuilder portDTOBuilder = PortDTOBuilder.of(getPortDTO());

        configurator.accept(portDTOBuilder);

        setComponentEntity(new UpdateInputPortInvoker(getTransport(), getVersion())
                .setId(getId())
                .setPortEntity(new PortEntityBuilder()
                        .setComponent(portDTOBuilder.build())
                        .build())
                .invoke());

        return this;
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveInputPortInvoker(getTransport(), getVersion()).setId(getId());
    }

    /**
     * Gets the input port with a specific ID.
     *
     * @param transport The transport with which to communicate with the NiFi server.
     * @param id        The ID of the input port to get.
     * @return The input port with the specified ID.
     * @throws InvokerException if there is a problem getting the input port.
     */
    public static InputPort get(final Transport transport, final String id) throws InvokerException
    {
        return new InputPort(transport, new GetInputPortInvoker(transport, 0)
                .setId(id)
                .invoke());
    }
}
