package com.tibtech.nifi.client;

/**
 * Component represents an item in a NiFi Flow Controller.
 */
public interface Component
{
	/**
	 * Returns the transport used to communicate with the NiFi Flow Controller.
	 * 
	 * @return The transport used to communicate with the NiFi Flow Controller.
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
