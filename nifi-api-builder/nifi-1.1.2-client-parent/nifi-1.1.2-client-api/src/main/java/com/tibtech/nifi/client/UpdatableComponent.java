package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.entity.ComponentEntity;

import groovy.lang.Closure;

public abstract class UpdatableComponent<T extends UpdatableComponent<T, E, B>, E extends ComponentEntity, B>
		extends Component<E>
{
	public UpdatableComponent(final Transport transport, final E componentEntity)
	{
		super(transport, componentEntity);
	}

	public abstract T refresh() throws InvokerException;

	public abstract T update(Function<B, B> configurator) throws InvokerException;

	protected T update(final Closure<B> closure) throws InvokerException
	{
		return update(configurator ->
		{
			final Closure<B> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return configurator;
		});
	}
}
