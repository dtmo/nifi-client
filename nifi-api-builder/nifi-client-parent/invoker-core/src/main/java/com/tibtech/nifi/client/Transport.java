package com.tibtech.nifi.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class Transport
{
	private final WebTarget baseWebTarget;

	private String clientId = null;

	public Transport(final Client client, final String baseUri)
	{
		this.baseWebTarget = client.target(baseUri);
	}
	
	public WebTarget getBaseWebTarget()
	{
		return baseWebTarget;
	}

	public String getClientId()
	{
		return clientId;
	}

	public void registerClientId(final String clientId)
	{
		if (this.clientId == null)
		{
			this.clientId = clientId;
		}
		else if (this.clientId.equals(clientId) == false)
		{
			throw new IllegalStateException("Cannot register an inconsistent client ID. Current client ID: "
					+ this.clientId + ", inconsistent client ID: " + clientId);
		}
	}
}
