package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

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
	public Connection update(final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
	{
		final ConnectionDTOBuilder connectionDTOBuilder = ConnectionDTOBuilder.of(getConnectionDTO());

		configurator.accept(connectionDTOBuilder);

		setComponentEntity(new UpdateConnectionInvoker(getTransport(), getVersion()).setId(getId())
				.setConnectionEntity(new ConnectionEntityBuilder().setComponent(connectionDTOBuilder.build()).build())
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

	public static Connection createConnection(final Transport transport, final Connectable source,
			final Connectable destination, final Collection<String> selectedRelationships,
			final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
	{
		final ConnectionDTOBuilder connectionDTOBuilder = new ConnectionDTOBuilder()
				.setSource(new ConnectableDTOBuilder().setId(source.getId()).setGroupId(source.getParentGroupId())
						.setType(source.getConnectableType().name()).build())
				.setDestination(new ConnectableDTOBuilder().setId(destination.getId())
						.setGroupId(destination.getParentGroupId()).setType(destination.getConnectableType().name())
						.build())
				.setSelectedRelationships(new HashSet<>(selectedRelationships));

		configurator.accept(connectionDTOBuilder);

		final ConnectionEntity connectionEntity = new CreateConnectionInvoker(transport, 0)
				.setId(source.getParentGroupId())
				.setConnectionEntity(new ConnectionEntityBuilder().setComponent(connectionDTOBuilder.build()).build())
				.invoke();
		return new Connection(transport, connectionEntity);
	}
}
