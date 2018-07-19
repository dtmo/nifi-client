package com.tibtech.nifi.client;

/**
 * Component represents an item in a NiFi Controller.
 */
public interface Component
{
	/**
	 * Returns the transport used to communicate with the NiFi Controller.
	 * 
	 * @return The transport used to communicate with the NiFi Controller.
	 */
	Transport getTransport();

	/**
	 * Returns the component ID.
	 * 
	 * @return The component ID.
	 */
	String getId();

	/**
	 * Returns the component version.
	 * 
	 * @return The component version.
	 */
	long getVersion();
}
