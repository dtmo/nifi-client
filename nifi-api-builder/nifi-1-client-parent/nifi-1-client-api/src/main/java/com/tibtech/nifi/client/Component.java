package com.tibtech.nifi.client;

public interface Component
{
	Transport getTransport();

	String getId();
	
	long getVersion();
}
