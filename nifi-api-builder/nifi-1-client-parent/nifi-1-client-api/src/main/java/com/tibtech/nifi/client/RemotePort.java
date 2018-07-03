package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;

public abstract class RemotePort<T extends RemotePort<T>>
        implements Connectable, Updatable<T, RemoteProcessGroupPortDTOBuilder>
{
    // RemotePort does not extend AbstractComponent as it is a component from a remote NiFi instance.
    // The DTOs are available from an instance of RemoteProcessGroup, but we have no entity with which to construct it.
    // Also, it does not follow the same rules for updates, etc. as it is outside of the control of the local NiFi
    // instance.
    private final RemoteProcessGroup remoteProcessGroup;

    private RemoteProcessGroupPortDTO remoteProcessGroupPortDto;

    public RemotePort(final RemoteProcessGroup remoteProcessGroup,
                      final RemoteProcessGroupPortDTO remoteProcessGroupPortDto)
    {
        this.remoteProcessGroup = remoteProcessGroup;
        this.remoteProcessGroupPortDto = remoteProcessGroupPortDto;
    }

    @Override
    public Transport getTransport()
    {
        return remoteProcessGroup.getTransport();
    }

    @Override
    public long getVersion()
    {
        return remoteProcessGroup.getVersion();
    }

    @Override
    public String getId()
    {
        return remoteProcessGroupPortDto.getId();
    }

    public RemoteProcessGroup getRemoteProcessGroup()
    {
        return remoteProcessGroup;
    }

    protected RemoteProcessGroupPortDTO getRemoteProcessGroupPortDto()
    {
        return remoteProcessGroupPortDto;
    }

    protected void setRemoteProcessGroupPortDto(final RemoteProcessGroupPortDTO remoteProcessGroupPortDto)
    {
        this.remoteProcessGroupPortDto = remoteProcessGroupPortDto;
    }

    public String getComments()
    {
        return getRemoteProcessGroupPortDto().getComments();
    }

    public Integer getConcurrentlySchedulableTaskCount()
    {
        return getRemoteProcessGroupPortDto().getConcurrentlySchedulableTaskCount();
    }

    public Boolean getExists()
    {
        return getRemoteProcessGroupPortDto().getExists();
    }

    @Override
    public String getParentGroupId()
    {
        return remoteProcessGroup.getId();
    }

    public String getName()
    {
        return getRemoteProcessGroupPortDto().getName();
    }

    public Boolean getUseCompression()
    {
        return getRemoteProcessGroupPortDto().getUseCompression();
    }

    public T setTransmitting(final boolean transmitting) throws InvokerException
    {
        return update(configurator -> configurator.setTransmitting(Boolean.valueOf(transmitting)));
    }
}