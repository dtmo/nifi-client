package com.tibtech.nifi.client;

/**
 * Refreshable represents a NiFi flow component that may be refreshed to obtain
 * updated state.
 * 
 * @param <T> The type of component.
 */
public interface Refreshable<T extends Refreshable<T>>
{
    /**
     * Refreshes the state of the component.
     * 
     * @return The component with its internal state updated.
     * @throws InvokerException if there is a problem refreshing the component.
     */
    T refresh() throws InvokerException;
}
