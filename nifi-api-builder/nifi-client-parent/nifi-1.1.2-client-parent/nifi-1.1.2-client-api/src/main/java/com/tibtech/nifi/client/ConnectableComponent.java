package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.entity.ComponentEntity;
import org.apache.nifi.web.api.entity.ConnectionEntity;

import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ConnectionEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateConnectionInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public abstract class ConnectableComponent<T extends ConnectableComponent<T, E, B>, E extends ComponentEntity, B>
		extends UpdatableComponent<T, E, B>
{
	public ConnectableComponent(final Transport transport, final E componentEntity)
	{
		super(transport, componentEntity);
	}

	public abstract String getParentGroupId();

	public abstract ConnectableType getConnectableType();

	public Connection connectTo(final ConnectableComponent<?, ?, ?> destination,
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
		return new Connection(getTransport(), connectionEntity);
	}

	public Connection connectTo(final ConnectableComponent<?, ?, ?> destination,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
			throws InvokerException
	{
		return connectTo(destination, configurator ->
		{
			final Closure<ConnectionDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return configurator;
		});
	}
}
