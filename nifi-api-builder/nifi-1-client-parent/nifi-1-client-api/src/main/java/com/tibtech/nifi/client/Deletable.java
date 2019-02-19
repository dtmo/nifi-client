package com.tibtech.nifi.client;

/**
 * Deletable represents a component that may be deleted from NiFi.
 */
public interface Deletable extends Component
{
    /**
     * Deletes the component from NiFi.
     * 
     * @throws InvokerException if there was a problem deleting the component.
     */
    void delete() throws InvokerException;
}
