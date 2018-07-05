package com.tibtech.nifi.client;

import java.util.function.Consumer;

import groovy.lang.Closure;

/**
 * Updatable indicates that a NiFi component may be updated.
 * 
 * @param <T> The type of component.
 * @param <B> The type of builder used to create an update component DTO.
 */
public interface Updatable<T extends Updatable<T, B>, B> extends Component
{
	/**
	 * Requests that an update is made to the component configuration.
	 * 
	 * @param configurator A consumer which will be invoked with a builder, on which
	 *        the new component configuration may be set.
	 * @return The component instance with its state updated.
	 * @throws InvokerException if there is a problem updating the component.
	 */
	T update(Consumer<B> configurator) throws InvokerException;

	/**
	 * Requests that an update is made to the component configuration.
	 * 
	 * @param closure A closure which will delegate to a builder, on which the new
	 *        component configuration may be set.
	 * @return The component instance with its state updated.
	 * @throws InvokerException if there is a problem updating the component.
	 */
	default T update(final Closure<B> closure) throws InvokerException
	{
		return update(configurator ->
		{
			final Closure<B> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}
}
