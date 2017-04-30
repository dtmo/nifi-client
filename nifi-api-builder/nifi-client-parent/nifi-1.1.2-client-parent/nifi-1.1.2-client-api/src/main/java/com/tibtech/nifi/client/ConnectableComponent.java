package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

import org.apache.nifi.web.api.entity.ComponentEntity;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public abstract class ConnectableComponent<T extends ConnectableComponent<T, E, B>, E extends ComponentEntity, B>
		extends UpdatableComponent<T, E, B> implements Connectable
{
	public ConnectableComponent(final Transport transport, final E componentEntity)
	{
		super(transport, componentEntity);
	}

	@Override
	public Connection connectTo(final Connectable destination, Collection<String> selectedRelationships,
			final Function<ConnectionDTOBuilder, ConnectionDTOBuilder> configurator) throws InvokerException
	{
		return Connection.createConnection(getTransport(), this, destination, selectedRelationships, configurator);
	}

	@Override
	public Connection connectTo(final Connectable destination, Collection<String> selectedRelationships,
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
