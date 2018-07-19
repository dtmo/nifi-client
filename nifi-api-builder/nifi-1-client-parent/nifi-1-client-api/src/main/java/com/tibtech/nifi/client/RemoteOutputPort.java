package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupPortEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupOutputPortInvoker;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

import java.util.function.Consumer;

/**
 * RemoteOutputPort represents an output port in a remote NiFi instance.
 */
public class RemoteOutputPort extends RemotePort<RemoteOutputPort>
{
    /**
     * Constructs a new instance of RemoteOutputPort.
     *
     * @param remoteProcessGroup        The remote process group to which the remote output port belongs.
     * @param remoteProcessGroupPortDto The DTO that describes the remote output port.
     */
    public RemoteOutputPort(final RemoteProcessGroup remoteProcessGroup,
                            final RemoteProcessGroupPortDTO remoteProcessGroupPortDto)
    {
        super(remoteProcessGroup, remoteProcessGroupPortDto);
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.REMOTE_OUTPUT_PORT;
    }

    @Override
    public RemoteOutputPort update(final Consumer<RemoteProcessGroupPortDTOBuilder> configurator)
            throws InvokerException
    {
        final RemoteProcessGroupPortDTOBuilder remoteProcessGroupPortDTOBuilder = RemoteProcessGroupPortDTOBuilder
                .of(getRemoteProcessGroupPortDTO()).setGroupId(getParentGroupId());

        configurator.accept(remoteProcessGroupPortDTOBuilder);

        final RemoteProcessGroupPortDTO remoteProcessGroupPortDto = new UpdateRemoteProcessGroupOutputPortInvoker(
                getTransport(), getVersion())
                .setId(getParentGroupId())
                .setPortId(getId())
                .setRemoteProcessGroupPortEntity(new RemoteProcessGroupPortEntityBuilder()
                        .setRemoteProcessGroupPort(remoteProcessGroupPortDTOBuilder.build())
                        .build())
                .invoke()
                .getRemoteProcessGroupPort();
        setRemoteProcessGroupPortDto(remoteProcessGroupPortDto);

        // Updating the remote port causes the version of the remote process group to be updated.
        // We need to refresh the remote process group to keep it up to date.

        getRemoteProcessGroup().refresh();

        return this;
    }

    @Override
    public RemoteOutputPort update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroupPortDTOBuilder.class) final Closure<RemoteProcessGroupPortDTOBuilder> closure)
            throws InvokerException
    {
        return update(configurator ->
        {
            final Closure<RemoteProcessGroupPortDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }
}