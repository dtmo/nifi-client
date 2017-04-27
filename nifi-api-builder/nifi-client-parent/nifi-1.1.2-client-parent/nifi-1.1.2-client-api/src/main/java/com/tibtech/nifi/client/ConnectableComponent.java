package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.entity.ConnectionEntity;

import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ConnectionEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateConnectionInvoker;

public abstract class ConnectableComponent<T extends ConnectableComponent<T, B>, B> extends EditableComponent<T, B>
{
	public ConnectableComponent(final Transport transport, final long version)
	{
		super(transport, version);
	}

	public abstract String getParentGroupId();

	public abstract ConnectableType getConnectableType();

	public Connection connectTo(final ConnectableComponent<?, ?> destination,
			final Function<ConnectionDTOBuilder, ConnectionDTOBuilder> configurator) throws InvokerException
	{
		final ConnectionEntity connectionEntity = new CreateConnectionInvoker(
				getTransport(), 0)
						.setId(this
								.getParentGroupId())
						.setConnectionEntity(
								new ConnectionEntityBuilder()
										.setComponent(
												configurator
														.apply(new ConnectionDTOBuilder()
																.setSource(
																		new ConnectableDTOBuilder().setId(this.getId())
																				.setGroupId(this.getParentGroupId())
																				.setType(this.getConnectableType()
																						.name())
																				.build())
																.setDestination(new ConnectableDTOBuilder()
																		.setId(destination.getId())
																		.setGroupId(destination.getParentGroupId())
																		.setType(
																				destination.getConnectableType().name())
																		.build()))
														.build())
										.build())
						.invoke();
		return new Connection(getTransport(), connectionEntity.getRevision().getVersion(),
				connectionEntity.getComponent());
	}
}
