package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.function.Consumer;

import org.apache.nifi.web.api.entity.ComponentEntity;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;

public abstract class ConnectableComponent<T extends ConnectableComponent<T, E, B>, E extends ComponentEntity, B>
		extends UpdatableComponent<T, E, B> implements Connectable
{
	public ConnectableComponent(final Transport transport, final E componentEntity)
	{
		super(transport, componentEntity);
	}

	@Override
	public Connection connectTo(final Connectable destination, Collection<String> selectedRelationships,
			final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
	{
		return Connection.createConnection(getTransport(), this, destination, selectedRelationships, configurator);
	}
}
