package com.tibtech.nifi.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.Response.Status.Family;

import org.apache.nifi.web.api.dto.RevisionDTO;

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

	public Long getVersion()
	{
		return transport.getVersion();
	}

	protected void updateVersion(Long version)
	{
		transport.updateVersion(version);
	}
	
	protected RevisionDTO createRevisionDto()
	{
		final RevisionDTO revision = new RevisionDTO();
		revision.setClientId(getClientId());
		revision.setVersion(getVersion());
		return revision;
	}

	public abstract T invoke() throws InvokerException;

	protected T handleResponse(final Response response, final Class<T> entityClass)
			throws InvokerException
	{
		StatusType statusInfo = response.getStatusInfo();
		if (statusInfo.getFamily() == Family.SUCCESSFUL)
		{
			final T entity = response.readEntity(entityClass);

			return entity;
		}
		else
		{
			final String errorMessage = response.readEntity(String.class);
			throw new InvokerException("Invocation failed (" + statusInfo.getReasonPhrase() + "): " + errorMessage);
		}
	}
}
