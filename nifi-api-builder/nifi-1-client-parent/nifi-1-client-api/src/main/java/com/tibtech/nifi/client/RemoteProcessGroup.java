package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupContentsDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.GetRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.RemoveRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupInvoker;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.RemoteProcessGroupContentsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * RemoteProcessGroup represents a remote process group in a NiFi flow.
 */
public class RemoteProcessGroup
        extends UpdatableComponent<RemoteProcessGroup, RemoteProcessGroupEntity, RemoteProcessGroupDTOBuilder>
        implements Deletable, Refreshable<RemoteProcessGroup, RemoteProcessGroupDTOBuilder>
{
    /**
     * Constructs a new instance of RemoteProcessGroup.
     *
     * @param transport                The transport with which to communicate with the NiFi server.
     * @param remoteProcessGroupEntity The entity that represents the remote process group.
     */
    public RemoteProcessGroup(final Transport transport, final RemoteProcessGroupEntity remoteProcessGroupEntity)
    {
        super(transport, remoteProcessGroupEntity);
    }

    /**
     * Returns the DTO that describes the remote process group.
     *
     * @return The DTO that describes the remote process group.
     */
    public RemoteProcessGroupDTO getRemoteProcessGroupDTO()
    {
        return getComponentEntity().getComponent();
    }

    /**
     * Returns the number of Remote Input Ports currently available in the remote NiFi instance.
     *
     * @return The number of Remote Input Ports currently available in the remote NiFi instance.
     */
    public int getInputPortCount()
    {
        return getComponentEntity().getInputPortCount();
    }

    /**
     * Returns the number of Remote Output Ports currently available in the remote NiFi instance.
     *
     * @return The number of Remote Output Ports currently available in the remote NiFi instance.
     */
    public int getOutputPortCount()
    {
        return getComponentEntity().getOutputPortCount();
    }

    /**
     * Returns the remote process group status.
     *
     * @return The remote process group status.
     */
    public RemoteProcessGroupStatusDTO getStatus()
    {
        return getComponentEntity().getStatus();
    }

    /**
     * Returns the URI for linking to this component in this NiFi.
     *
     * @return The URI for linking to this component in this NiFi.
     */
    public String getUri()
    {
        return getComponentEntity().getUri();
    }

    /**
     * Returns the number of active remote input ports.
     *
     * @return The number of active remote input ports.
     */
    public int getActiveRemoteInputPortCount()
    {
        return getRemoteProcessGroupDTO().getActiveRemoteInputPortCount();
    }

    /**
     * Returns the number of active remote output ports.
     *
     * @return The number of active remote output ports.
     */
    public int getActiveRemoteOutputPortCount()
    {
        return getRemoteProcessGroupDTO().getActiveRemoteOutputPortCount();
    }

    /**
     * Returns any remote authorization issues for this remote process group.
     *
     * @return Any remote authorization issues for this remote process group.
     */
    public Collection<String> getAuthorizationIssues()
    {
        return Collections.unmodifiableCollection(getRemoteProcessGroupDTO().getAuthorizationIssues());
    }

    /**
     * Returns the user comments for the process group.
     *
     * @return The user comments for the process group.
     */
    public String getComments()
    {
        return getRemoteProcessGroupDTO().getComments();
    }

    /**
     * Returns the time period used for the timeout when communicating with this remote process group.
     *
     * @return The time period used for the timeout when communicating with this remote process group.
     */
    public String getCommunicationsTimeout()
    {
        return getRemoteProcessGroupDTO().getCommunicationsTimeout();
    }

    /**
     * Returns the time the flow for this remote group was last refreshed.
     *
     * @return The time the flow for this remote group was last refreshed.
     */
    public Date getFlowRefreshed()
    {
        return getRemoteProcessGroupDTO().getFlowRefreshed();
    }

    /**
     * Returns the number of inactive remote input ports.
     *
     * @return The number of inactive remote input ports.
     */
    public int getInactiveRemoteInputPortCount()
    {
        return getRemoteProcessGroupDTO().getInactiveRemoteInputPortCount();
    }

    /**
     * Returns the number of inactive remote output ports.
     *
     * @return The number of inactive remote output ports.
     */
    public int getInactiveRemoteOutputPortCount()
    {
        return getRemoteProcessGroupDTO().getInactiveRemoteOutputPortCount();
    }

    public String getLocalNetworkInterface()
    {
        return getRemoteProcessGroupDTO().getLocalNetworkInterface();
    }

    /**
     * Returns the name of the remote process group.
     *
     * @return The name of the remote process group.
     */
    public String getName()
    {
        return getRemoteProcessGroupDTO().getName();
    }

    /**
     * Returns the ID of process group containing the remote process group.
     *
     * @return The ID of process group containing the remote process group.
     */
    public String getParentGroupId()
    {
        return getRemoteProcessGroupDTO().getParentGroupId();
    }

    public String getProxyHost()
    {
        return getRemoteProcessGroupDTO().getProxyHost();
    }

    public String getProxyPassword()
    {
        return getRemoteProcessGroupDTO().getProxyPassword();
    }

    public Integer getProxyPort()
    {
        return getRemoteProcessGroupDTO().getProxyPort();
    }

    public String getProxyUser()
    {
        return getRemoteProcessGroupDTO().getProxyUser();
    }

    /**
     * Returns the target URI of this remote process group. If target URI is not set, but URIs are set, then returns the
     * first URI in the URIs. If neither target URI nor URIs are set, then returns null.
     *
     * @return the target URI of this remote process group.
     */
    public String getTargetUri()
    {
        return getRemoteProcessGroupDTO().getTargetUri();
    }

    /**
     * Returns the target URIs of this remote process group. If target URIs was not set but target URI was set, then
     * returns a collection containing the single URI. If neither target URIs nor URI were set, then returns null.
     *
     * @return the target URIs of this remote process group.
     */
    public String getTargetUris()
    {
        return getRemoteProcessGroupDTO().getTargetUris();
    }

    public String getTransportProtocol()
    {
        return getRemoteProcessGroupDTO().getTransportProtocol();
    }

    public Collection<String> getValidationErrors()
    {
        return getRemoteProcessGroupDTO().getValidationErrors();
    }

    public String getVersionedComponentId()
    {
        return getRemoteProcessGroupDTO().getVersionedComponentId();
    }

    /**
     * Returns the amount of time that must elapse, when yielding, before this remote process group is scheduled again.
     *
     * @return The amount of time that must elapse, when yielding, before this remote process group is scheduled again.
     */
    public String getYieldDuration()
    {
        return getRemoteProcessGroupDTO().getYieldDuration();
    }

    /**
     * Returns whether or not this remote process group is actively transmitting.
     *
     * @return Whether or not this remote process group is actively transmitting.
     */
    public boolean isTransmitting()
    {
        return getRemoteProcessGroupDTO().isTransmitting();
    }

    /**
     * Returns whether or not the target is running securely.
     *
     * @return Whether or not the target is running securely.
     */
    public boolean isTargetSecure()
    {
        return getRemoteProcessGroupDTO().isTargetSecure();
    }

    /**
     * Enables transmission for the remote process group.
     *
     * @return This remote process group.
     * @throws InvokerException if there is a problem enabling transmission.
     */
    public RemoteProcessGroup enableTransmission() throws InvokerException
    {
        return setTransmitting(true);
    }

    /**
     * Disables transmission for the remote process group.
     *
     * @return This remote process group.
     * @throws InvokerException if there is a problem disabling transmission.
     */
    public RemoteProcessGroup disableTransmission() throws InvokerException
    {
        return setTransmitting(false);
    }

    /**
     * Sets whether or not the remote process group should be transmitting.
     *
     * @param transmitting The transmitting state to set.
     * @return This remote process group.
     * @throws InvokerException if there is a problem setting the transmitting state.
     */
    public RemoteProcessGroup setTransmitting(final boolean transmitting) throws InvokerException
    {
        refresh();

        final RemoteProcessGroupContentsDTO contents = getRemoteProcessGroupDTO().getContents();

        final RemoteProcessGroupContentsDTOBuilder remoteProcessGroupContentsDTOBuilder = RemoteProcessGroupContentsDTOBuilder
                .of(contents);

        final Set<RemoteProcessGroupPortDTO> remoteInputPortDTOs = contents.getInputPorts();
        if (remoteInputPortDTOs != null)
        {
            remoteProcessGroupContentsDTOBuilder.setInputPorts(remoteInputPortDTOs.stream()
                    .map(remoteInputPortDTO -> RemoteProcessGroupPortDTOBuilder.of(remoteInputPortDTO)
                            .setTransmitting(transmitting)
                            .build())
                    .collect(Collectors.toSet()));
        }

        final Set<RemoteProcessGroupPortDTO> remoteOutputPortDTOs = contents.getOutputPorts();
        if (remoteInputPortDTOs != null)
        {
            remoteProcessGroupContentsDTOBuilder.setOutputPorts(remoteOutputPortDTOs.stream()
                    .map(remoteOutputPortDTO -> RemoteProcessGroupPortDTOBuilder.of(remoteOutputPortDTO)
                            .setTransmitting(transmitting)
                            .build())
                    .collect(Collectors.toSet()));
        }

        return update(configurator -> configurator.setContents(remoteProcessGroupContentsDTOBuilder.build()));
    }

    @Override
    public RemoteProcessGroup refresh() throws InvokerException
    {
        setComponentEntity(new GetRemoteProcessGroupInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke());

        return this;
    }

    /**
     * Returns the remote input ports.
     *
     * @return The remote input ports.
     */
    public Set<RemoteInputPort> getRemoteInputPorts()
    {
        return Collections.unmodifiableSet(getRemoteProcessGroupDTO().getContents().getInputPorts().stream()
                .map(inputPortDTO -> new RemoteInputPort(this, inputPortDTO))
                .collect(Collectors.toSet()));
    }

    /**
     * Returns the remote output ports.
     *
     * @return The remote output ports.
     */
    public Set<RemoteOutputPort> getRemoteOutputPorts()
    {
        return Collections.unmodifiableSet(getRemoteProcessGroupDTO().getContents().getOutputPorts().stream()
                .map(outputPortDTO -> new RemoteOutputPort(this, outputPortDTO))
                .collect(Collectors.toSet()));
    }

    @Override
    public RemoteProcessGroup update(final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
    {
        final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = new RemoteProcessGroupDTOBuilder()
                .setId(getId());

        configurator.accept(remoteProcessGroupDTOBuilder);

        setComponentEntity(new UpdateRemoteProcessGroupInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder()
                        .setComponent(remoteProcessGroupDTOBuilder.build())
                        .build())
                .invoke());

        return this;
    }

    @Override
    public RemoteProcessGroup update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroupDTOBuilder.class) final Closure<RemoteProcessGroupDTOBuilder> closure)
            throws InvokerException
    {
        return super.update(closure);
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveRemoteProcessGroupInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke();
    }

    /**
     * Gets the remote process group with a specific ID.
     *
     * @param transport The transport with which to communicate with the NiFi server.
     * @param id        The ID of the remote process group to get.
     * @return The remote process group with the specified ID.
     * @throws InvokerException if there is a problem getting the remote process group.
     */
    public static RemoteProcessGroup get(final Transport transport, final String id) throws InvokerException
    {
        return new RemoteProcessGroup(transport, new GetRemoteProcessGroupInvoker(transport, 0)
                .setId(id)
                .invoke());
    }
}
