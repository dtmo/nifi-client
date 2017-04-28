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
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ConnectionEntityBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Connection extends UpdatableComponent<Connection, ConnectionEntity, ConnectionDTOBuilder>
{
	public Connection(final Transport transport, final ConnectionEntity connectionEntity)
	{
		super(transport, connectionEntity);
	}

	private ConnectionDTO getConnectionDTO()
	{
		return getComponentEntity().getComponent();
	}

	public Set<String> getAvailableRelationships()
	{
		return getConnectionDTO().getAvailableRelationships();
	}

	public String getBackPressureDataSizeThreshold()
	{
		return getConnectionDTO().getBackPressureDataSizeThreshold();
	}

	public Long getBackPressureObjectThreshold()
	{
		return getConnectionDTO().getBackPressureObjectThreshold();
	}

	public List<PositionDTO> getBends()
	{
		return getConnectionDTO().getBends();
	}

	public ConnectableDTO getDestination()
	{
		return getConnectionDTO().getDestination();
	}

	public String getFlowFileExpiration()
	{
		return getConnectionDTO().getFlowFileExpiration();
	}

	public Integer getLabelIndex()
	{
		return getConnectionDTO().getLabelIndex();
	}

	public String getName()
	{
		return getConnectionDTO().getName();
	}

	public String getParentGroupId()
	{
		return getConnectionDTO().getParentGroupId();
	}

	public List<String> getPrioritizers()
	{
		return getConnectionDTO().getPrioritizers();
	}

	public Set<String> getSelectedRelationships()
	{
		return getConnectionDTO().getSelectedRelationships();
	}

	public ConnectableDTO getSource()
	{
		return getConnectionDTO().getSource();
	}

	public Long getzIndex()
	{
		return getConnectionDTO().getzIndex();
	}

	@Override
	public void delete() throws InvokerException
	{
		new DeleteConnectionInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public Connection refresh() throws InvokerException
	{
		setComponentEntity(new GetConnectionInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	@Override
	public Connection update(Function<ConnectionDTOBuilder, ConnectionDTOBuilder> configurator) throws InvokerException
	{
		setComponentEntity(new UpdateConnectionInvoker(getTransport(), getVersion()).setId(getId())
				.setConnectionEntity(new ConnectionEntityBuilder()
						.setComponent(configurator.apply(ConnectionDTOBuilder.of(getConnectionDTO())).build()).build())
				.invoke());
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
