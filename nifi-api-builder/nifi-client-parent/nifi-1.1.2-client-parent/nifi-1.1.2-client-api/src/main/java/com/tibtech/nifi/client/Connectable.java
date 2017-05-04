package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.function.Function;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public interface Connectable
{
	String getId();

	String getParentGroupId();

	ConnectableType getConnectableType();

	Connection connectTo(Connectable destination, Collection<String> selectedRelationships,
			Function<ConnectionDTOBuilder, ConnectionDTOBuilder> configurator) throws InvokerException;

	default public Connection connectTo(final Connectable destination, Collection<String> selectedRelationships,
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
