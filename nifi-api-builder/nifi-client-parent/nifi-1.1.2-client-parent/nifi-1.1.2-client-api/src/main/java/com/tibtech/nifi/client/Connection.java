package com.tibtech.nifi.client;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.nifi.web.api.dto.ConnectableDTO;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.ConnectionEntity;

import com.tibtech.nifi.web.api.connection.DeleteConnectionInvoker;
import com.tibtech.nifi.web.api.connection.GetConnectionInvoker;
import com.tibtech.nifi.web.api.connection.UpdateConnectionInvoker;
import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ConnectionEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateConnectionInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Connection extends EditableComponent<Connection, ConnectionDTOBuilder>
{
	private ConnectionDTO connectionDTO;

	public Connection(final Transport transport, final long version, final ConnectionDTO connectionDTO)
	{
		super(transport, version);

		this.connectionDTO = connectionDTO;
	}

	public Set<String> getAvailableRelationships()
	{
		return connectionDTO.getAvailableRelationships();
	}

	public String getBackPressureDataSizeThreshold()
	{
		return connectionDTO.getBackPressureDataSizeThreshold();
	}

	public Long getBackPressureObjectThreshold()
	{
		return connectionDTO.getBackPressureObjectThreshold();
	}

	public List<PositionDTO> getBends()
	{
		return connectionDTO.getBends();
	}

	public ConnectableDTO getDestination()
	{
		return connectionDTO.getDestination();
	}

	public String getFlowFileExpiration()
	{
		return connectionDTO.getFlowFileExpiration();
	}

	public String getId()
	{
		return connectionDTO.getId();
	}

	public Integer getLabelIndex()
	{
		return connectionDTO.getLabelIndex();
	}

	public String getName()
	{
		return connectionDTO.getName();
	}

	public String getParentGroupId()
	{
		return connectionDTO.getParentGroupId();
	}

	public PositionDTO getPosition()
	{
		return connectionDTO.getPosition();
	}

	public List<String> getPrioritizers()
	{
		return connectionDTO.getPrioritizers();
	}

	public Set<String> getSelectedRelationships()
	{
		return connectionDTO.getSelectedRelationships();
	}

	public ConnectableDTO getSource()
	{
		return connectionDTO.getSource();
	}

	public Long getzIndex()
	{
		return connectionDTO.getzIndex();
	}

	@Override
	public void delete() throws InvokerException
	{
		new DeleteConnectionInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public Connection refresh() throws InvokerException
	{
		this.connectionDTO = new GetConnectionInvoker(getTransport(), getVersion()).setId(getId()).invoke()
				.getComponent();
		return this;
	}

	@Override
	public Connection update(Function<ConnectionDTOBuilder, ConnectionDTOBuilder> configurator) throws InvokerException
	{
		this.connectionDTO = new UpdateConnectionInvoker(getTransport(), getVersion()).setId(getId())
				.setConnectionEntity(new ConnectionEntityBuilder()
						.setComponent(configurator.apply(ConnectionDTOBuilder.of(connectionDTO)).build()).build())
				.invoke().getComponent();
		return this;
	}

	@Override
	public Connection update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}
}
