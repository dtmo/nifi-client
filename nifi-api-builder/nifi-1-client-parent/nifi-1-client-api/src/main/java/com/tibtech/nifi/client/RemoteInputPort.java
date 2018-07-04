package com.tibtech.nifi.client;

import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupPortEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupInputPortInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class RemoteInputPort extends RemotePort<RemoteInputPort>
{
    public RemoteInputPort(final RemoteProcessGroup remoteProcessGroup,
                           final RemoteProcessGroupPortDTO remoteProcessGroupPortDto)
    {
        super(remoteProcessGroup, remoteProcessGroupPortDto);
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.REMOTE_INPUT_PORT;
    }

    @Override
    public RemoteInputPort update(final Consumer<RemoteProcessGroupPortDTOBuilder> configurator) throws InvokerException
    {
        final RemoteProcessGroupPortDTOBuilder remoteProcessGroupPortDTOBuilder = RemoteProcessGroupPortDTOBuilder
                .of(getRemoteProcessGroupPortDto()).setGroupId(getParentGroupId());

        configurator.accept(remoteProcessGroupPortDTOBuilder);

        final RemoteProcessGroupPortDTO remoteProcessGroupPortDto = new UpdateRemoteProcessGroupInputPortInvoker(
                getTransport(), getVersion()).setId(getParentGroupId()).setPortId(getId())
                .setRemoteProcessGroupPortEntity(new RemoteProcessGroupPortEntityBuilder()
                        .setRemoteProcessGroupPort(remoteProcessGroupPortDTOBuilder.build()).build())
                .invoke().getRemoteProcessGroupPort();
        setRemoteProcessGroupPortDto(remoteProcessGroupPortDto);
        
        // Updating the remote port causes the version of the remote process group to be updated.
        // We need to refresh the remote process group to keep it up to date.

        getRemoteProcessGroup().refresh();

        return this;
    }

    public RemoteInputPort update(
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