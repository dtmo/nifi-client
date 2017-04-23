package com.tibtech.nifi.client;

import java.util.function.Function;

import groovy.lang.Closure;

public abstract class EditableComponent<T extends EditableComponent<T, B>, B> extends Component
{
	private long version;

	public EditableComponent(final Transport transport, final long version)
	{
		super(transport);

		this.version = version;
	}

	public long getVersion()
	{
		return version;
	}

	protected void setVersion(long version)
	{
		this.version = version;
	}

	public abstract void delete() throws InvokerException;

	public abstract T refresh() throws InvokerException;

	public abstract T update(Function<B, B> configurator) throws InvokerException;

	public T update(final Closure<B> closure) throws InvokerException
	{
		return update(c ->
		{
			final Closure<B> code = closure.rehydrate(c, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return c;
		});
	}
}
