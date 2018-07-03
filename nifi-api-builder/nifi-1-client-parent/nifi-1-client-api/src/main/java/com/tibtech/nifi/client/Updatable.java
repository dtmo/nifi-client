package com.tibtech.nifi.client;

import java.util.function.Consumer;

public interface Updatable<T, B>
{
	T update(Consumer<B> configurator) throws InvokerException;
}
