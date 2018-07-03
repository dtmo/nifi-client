package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.RemoteProcessGroupContentsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupContentsDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.GetRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.RemoveRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class RemoteProcessGroup
        extends UpdatableComponent<RemoteProcessGroup, RemoteProcessGroupEntity, RemoteProcessGroupDTOBuilder>
{
    public RemoteProcessGroup(final Transport transport, final RemoteProcessGroupEntity remoteProcessGroupEntity)
    {
        super(transport, remoteProcessGroupEntity);
    }

    protected RemoteProcessGroupDTO getRemoteProcessGroupDTO()
    {
        return getComponentEntity().getComponent();
    }

    public RemoteProcessGroupDTO getComponent()
    {
        return getComponentEntity().getComponent();
    }

    public Integer getInputPortCount()
    {
        return getComponentEntity().getInputPortCount();
    }

    public Integer getOutputPortCount()
    {
        return getComponentEntity().getOutputPortCount();
    }

    public RevisionDTO getRevision()
    {
        return getComponentEntity().getRevision();
    }

    public RemoteProcessGroupStatusDTO getStatus()
    {
        return getComponentEntity().getStatus();
    }

    public String getUri()
    {
        return getComponentEntity().getUri();
    }

    public Integer getActiveRemoteInputPortCount()
    {
        return getRemoteProcessGroupDTO().getActiveRemoteInputPortCount();
    }

    public Integer getActiveRemoteOutputPortCount()
    {
        return getRemoteProcessGroupDTO().getActiveRemoteOutputPortCount();
    }

    public Collection<String> getAuthorizationIssues()
    {
        return getRemoteProcessGroupDTO().getAuthorizationIssues();
    }

    public String getComments()
    {
        return getRemoteProcessGroupDTO().getComments();
    }

    public String getCommunicationsTimeout()
    {
        return getRemoteProcessGroupDTO().getCommunicationsTimeout();
    }

    public RemoteProcessGroupContentsDTO getContents()
    {
        return getRemoteProcessGroupDTO().getContents();
    }

    public Date getFlowRefreshed()
    {
        return getRemoteProcessGroupDTO().getFlowRefreshed();
    }

    public Integer getInactiveRemoteInputPortCount()
    {
        return getRemoteProcessGroupDTO().getInactiveRemoteInputPortCount();
    }

    public Integer getInactiveRemoteOutputPortCount()
    {
        return getRemoteProcessGroupDTO().getInactiveRemoteOutputPortCount();
    }

    public String getName()
    {
        return getRemoteProcessGroupDTO().getName();
    }

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

    public String getTargetUri()
    {
        return getRemoteProcessGroupDTO().getTargetUri();
    }

    public String getTransportProtocol()
    {
        return getRemoteProcessGroupDTO().getTransportProtocol();
    }

    public String getYieldDuration()
    {
        return getRemoteProcessGroupDTO().getYieldDuration();
    }

    public RemoteProcessGroup enableTransmission() throws InvokerException
    {
        return setTransmitting(true);
    }

    public RemoteProcessGroup disableTransmission() throws InvokerException
    {
        return setTransmitting(false);
    }

    public RemoteProcessGroup setTransmitting(final boolean transmitting) throws InvokerException
    {
        refresh();

        final RemoteProcessGroupContentsDTOBuilder remoteProcessGroupContentsDTOBuilder = RemoteProcessGroupContentsDTOBuilder
                .of(getContents());

        final Set<RemoteProcessGroupPortDTO> remoteInputPortDTOs = getContents().getInputPorts();
        if (remoteInputPortDTOs != null)
        {
            remoteProcessGroupContentsDTOBuilder
                    .setInputPorts(
                            remoteInputPortDTOs
                                    .stream().map(remoteInputPortDTO -> RemoteProcessGroupPortDTOBuilder
                                    .of(remoteInputPortDTO).setTransmitting(transmitting).build())
                                    .collect(Collectors.toSet()));
        }

        final Set<RemoteProcessGroupPortDTO> remoteOutputPortDTOs = getContents().getOutputPorts();
        if (remoteInputPortDTOs != null)
        {
            remoteProcessGroupContentsDTOBuilder
                    .setOutputPorts(remoteOutputPortDTOs
                            .stream().map(remoteOutputPortDTO -> RemoteProcessGroupPortDTOBuilder
                                    .of(remoteOutputPortDTO).setTransmitting(transmitting).build())
                            .collect(Collectors.toSet()));
        }

        return update(configurator -> configurator.setContents(remoteProcessGroupContentsDTOBuilder.build()));
    }

    @Override
    public RemoteProcessGroup refresh() throws InvokerException
    {
        setComponentEntity(new GetRemoteProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke());

        return this;
    }

    public Set<RemoteInputPort> getRemoteInputPorts()
    {
        return getContents().getInputPorts().stream()
                .map(inputPortDTO -> new RemoteInputPort(this, inputPortDTO))
                .collect(Collectors.toSet());
    }

    public Set<RemoteOutputPort> getRemoteOutputPorts()
    {
        return getContents().getOutputPorts().stream().map(
                outputPortDTO -> new RemoteOutputPort(this, outputPortDTO))
                .collect(Collectors.toSet());
    }

    @Override
    public RemoteProcessGroup update(final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
    {
        final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = RemoteProcessGroupDTOBuilder
                .of(getRemoteProcessGroupDTO());

        configurator.accept(remoteProcessGroupDTOBuilder);

        setComponentEntity(new UpdateRemoteProcessGroupInvoker(getTransport(), getVersion()).setId(getId())
                .setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder()
                        .setComponent(remoteProcessGroupDTOBuilder.build()).build())
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

    public void delete() throws InvokerException
    {
        new RemoveRemoteProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke();
    }
}
