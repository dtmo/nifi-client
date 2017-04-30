package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.RemoteProcessGroupContentsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;
import org.apache.nifi.web.api.entity.RemoteProcessGroupPortEntity;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupPortEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.GetRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.RemoveRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupInputPortInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupOutputPortInvoker;

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

	@Override
	public RemoteProcessGroup refresh() throws InvokerException
	{
		setComponentEntity(new GetRemoteProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	public Set<RemoteProcessGroupInputPort> getInputPorts()
	{
		return getContents().getInputPorts().stream().map(inputPortDTO -> new RemoteProcessGroupInputPort(inputPortDTO))
				.collect(Collectors.toSet());
	}

	public Set<RemoteProcessGroupOutputPort> getOutputPorts()
	{
		return getContents().getOutputPorts().stream()
				.map(outputPortDTO -> new RemoteProcessGroupOutputPort(outputPortDTO)).collect(Collectors.toSet());
	}

	@Override
	public RemoteProcessGroup update(
			final Function<RemoteProcessGroupDTOBuilder, RemoteProcessGroupDTOBuilder> configurator)
			throws InvokerException
	{
		setComponentEntity(new UpdateRemoteProcessGroupInvoker(getTransport(), getVersion()).setId(getId())
				.setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder()
						.setComponent(
								configurator.apply(RemoteProcessGroupDTOBuilder.of(getRemoteProcessGroupDTO())).build())
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
		new RemoveRemoteProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	protected abstract class RemoteProcessGroupPort implements Connectable
	{
		private RemoteProcessGroupPortDTO remoteProcessGroupPortDTO;

		public RemoteProcessGroupPort(final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
		{
			this.remoteProcessGroupPortDTO = remoteProcessGroupPortDTO;
		}

		protected RemoteProcessGroupPortDTO getRemoteProcessGroupPortDTO()
		{
			return remoteProcessGroupPortDTO;
		}

		protected void setRemoteProcessGroupPortDTO(final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
		{
			this.remoteProcessGroupPortDTO = remoteProcessGroupPortDTO;
		}

		public String getComments()
		{
			return remoteProcessGroupPortDTO.getComments();
		}

		public Integer getConcurrentlySchedulableTaskCount()
		{
			return remoteProcessGroupPortDTO.getConcurrentlySchedulableTaskCount();
		}

		public Boolean getExists()
		{
			return remoteProcessGroupPortDTO.getExists();
		}

		@Override
		public String getParentGroupId()
		{
			return RemoteProcessGroup.this.getId();
		}

		@Override
		public String getId()
		{
			return remoteProcessGroupPortDTO.getId();
		}

		public String getName()
		{
			return remoteProcessGroupPortDTO.getName();
		}

		public Boolean getUseCompression()
		{
			return remoteProcessGroupPortDTO.getUseCompression();
		}

		@Override
		public Connection connectTo(final Connectable destination, final Collection<String> selectedRelationships,
				final Function<ConnectionDTOBuilder, ConnectionDTOBuilder> configurator) throws InvokerException
		{
			return Connection.createConnection(getTransport(), this, destination, selectedRelationships, configurator);
		}

		@Override
		public Connection connectTo(final Connectable destination, final Collection<String> selectedRelationships,
				@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
				throws InvokerException
		{
			return connectTo(destination, selectedRelationships, configurator ->
			{
				final Closure<ConnectionDTOBuilder> code = closure.rehydrate(configurator, this, this);
				code.setResolveStrategy(Closure.DELEGATE_ONLY);
				code.call();
				return configurator;
			});
		}
	}

	public class RemoteProcessGroupInputPort extends RemoteProcessGroupPort
	{
		public RemoteProcessGroupInputPort(final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
		{
			super(remoteProcessGroupPortDTO);
		}

		@Override
		public ConnectableType getConnectableType()
		{
			return ConnectableType.REMOTE_INPUT_PORT;
		}

		public RemoteProcessGroupInputPort update(
				final Function<RemoteProcessGroupPortDTOBuilder, RemoteProcessGroupPortDTOBuilder> configurator)
				throws InvokerException
		{
			final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity = new UpdateRemoteProcessGroupInputPortInvoker(
					getTransport(), getVersion()).setId(getParentGroupId())
							.setPortId(getId())
							.setRemoteProcessGroupPortEntity(
									new RemoteProcessGroupPortEntityBuilder().setRemoteProcessGroupPort(configurator
											.apply(RemoteProcessGroupPortDTOBuilder.of(getRemoteProcessGroupPortDTO()))
											.build()).build())
							.invoke();
			return this;
		}
	}

	public class RemoteProcessGroupOutputPort extends RemoteProcessGroupPort
	{
		public RemoteProcessGroupOutputPort(final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
		{
			super(remoteProcessGroupPortDTO);
		}

		@Override
		public ConnectableType getConnectableType()
		{
			return ConnectableType.REMOTE_OUTPUT_PORT;
		}

		public RemoteProcessGroupOutputPort update(
				final Function<RemoteProcessGroupPortDTOBuilder, RemoteProcessGroupPortDTOBuilder> configurator)
				throws InvokerException
		{
			final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity = new UpdateRemoteProcessGroupOutputPortInvoker(
					getTransport(), getVersion()).setId(getParentGroupId())
							.setPortId(getId())
							.setRemoteProcessGroupPortEntity(
									new RemoteProcessGroupPortEntityBuilder().setRemoteProcessGroupPort(configurator
											.apply(RemoteProcessGroupPortDTOBuilder.of(getRemoteProcessGroupPortDTO()))
											.build()).build())
							.invoke();
			return this;
		}
	}
}
