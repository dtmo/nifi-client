package com.tibtech.nifi.client;

/**
 * Deletable represents a component that may be deleted from the NiFi flow.
 */
public interface Deletable extends Component
{
	/**
	 * Deletes the component from the flow.
	 * 
	 * @throws InvokerException if there was a problem deleting the component.
	 */
	void delete() throws InvokerException;
}
