package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

/**
 * RemotePort represents a port that has been exposed by a remote NiFi instance.
 *
 * @param <T> The type of remote port.
 */
public abstract class RemotePort<T extends RemotePort<T>>
        implements Connectable, Updatable<T, RemoteProcessGroupPortDTOBuilder>
{
    // RemotePort does not extend AbstractComponent as it is a component from a remote NiFi instance.
    // The DTOs are available from an instance of RemoteProcessGroup, but we have no entity with which to construct it.
    // Also, it does not follow the same rules for updates, etc. as it is outside of the control of the local NiFi
    // instance.
    private final RemoteProcessGroup remoteProcessGroup;

    private RemoteProcessGroupPortDTO remoteProcessGroupPortDto;

    /**
     * Constructs a new instance of RemotePort.
     *
     * @param remoteProcessGroup        The remote process group to which this remote port belongs.
     * @param remoteProcessGroupPortDto The DTO that describes the remote process group.
     */
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

    /**
     * Returns the remote process group to which this report port belongs.
     *
     * @return The remote process group to which this report port belongs.
     */
    public RemoteProcessGroup getRemoteProcessGroup()
    {
        return remoteProcessGroup;
    }

    /**
     * Returns the DTO that describes the remote process group port.
     *
     * @return The DTO that describes the remote process group port.
     */
    protected RemoteProcessGroupPortDTO getRemoteProcessGroupPortDto()
    {
        return remoteProcessGroupPortDto;
    }

    /**
     * Sets the DTO that describes the remote process group port.
     *
     * @param remoteProcessGroupPortDto The DTO to set.
     */
    protected void setRemoteProcessGroupPortDto(final RemoteProcessGroupPortDTO remoteProcessGroupPortDto)
    {
        this.remoteProcessGroupPortDto = remoteProcessGroupPortDto;
    }

    /**
     * Returns the user comments for the remote port.
     *
     * @return The user comments for the remote port.
     */
    public String getComments()
    {
        return getRemoteProcessGroupPortDto().getComments();
    }

    /**
     * Returns the number tasks that may transmit flow files to the target port concurrently.
     *
     * @return The number tasks that may transmit flow files to the target port concurrently.
     */
    public int getConcurrentlySchedulableTaskCount()
    {
        return getRemoteProcessGroupPortDto().getConcurrentlySchedulableTaskCount();
    }

    /**
     * Returns whether or not the target port exists.
     *
     * @return whether or not the target port exists.
     */
    public boolean getExists()
    {
        return getRemoteProcessGroupPortDto().getExists();
    }

    @Override
    public String getParentGroupId()
    {
        return remoteProcessGroup.getId();
    }

    /**
     * Returns the name of the remote port.
     *
     * @return The name of the remote port.
     */
    public String getName()
    {
        return getRemoteProcessGroupPortDto().getName();
    }

    /**
     * Returns whether or not flow file are compressed when sent to this target port.
     *
     * @return Whether or not flow file are compressed when sent to this target port.
     */
    public boolean getUseCompression()
    {
        return getRemoteProcessGroupPortDto().getUseCompression();
    }

    /**
     * Sets whether or not the remote port is transmitting.
     *
     * @param transmitting {@code true} if the port should be transmitting and {@code false} if not.
     * @return This remote port.
     * @throws InvokerException if there is a problem setting whether or not the port is transmitting.
     */
    public T setTransmitting(final boolean transmitting) throws InvokerException
    {
        return update(configurator -> configurator.setTransmitting(Boolean.valueOf(transmitting)));
    }

    /**
     * Enables transmission for the remote port.
     *
     * @return This remote port.
     * @throws InvokerException if there is a problem enabling transmission.
     */
    public T enableTransmission() throws InvokerException
    {
        return setTransmitting(true);
    }

    /**
     * Disables transmission for the remote port.
     *
     * @return This remote port.
     * @throws InvokerException if there is a problem disabling transmission.
     */
    public T disableTransmission() throws InvokerException
    {
        return setTransmitting(false);
    }
}