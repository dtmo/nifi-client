package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.RevisionDTO;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public abstract class AbstractInvoker<T>
{
	private final Transport transport;

	public AbstractInvoker(final Transport transport)
	{
		this.transport = transport;
	}

	public WebTarget getBaseWebTarget()
	{
		return transport.getBaseWebTarget();
	}

	public String getClientId()
	{
		return transport.getClientId();
	}

	protected void registerClientId(String clientId)
	{
		transport.registerClientId(clientId);
	}

	public abstract T invoke() throws InvokerException;

	protected T handleResponse(final Response response, final Class<T> entityClass) throws InvokerException
	{
		final StatusType statusInfo = response.getStatusInfo();
		if (statusInfo.getFamily() == Family.SUCCESSFUL)
		{
			final T entity = response.readEntity(entityClass);

			return entity;
		}
		else
		{
			final String errorMessage = response.readEntity(String.class);
			throw new InvokerException("Invocation failed (" + statusInfo.getReasonPhrase() + "): " + errorMessage,
					statusInfo);
		}
	}
}
