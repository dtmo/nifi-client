package com.tibtech.nifi.client;

import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.ComponentEntity;

public abstract class ComponentEntityInvoker<T extends ComponentEntity> extends AbstractInvoker<T>
{
	public ComponentEntityInvoker(final Transport transport)
	{
		super(transport);
	}

	protected T handleComponentEntityResponse(final Response response, final Class<T> entityClass)
			throws InvokerException
	{
		final T entity = handleResponse(response, entityClass);

		final RevisionDTO revision = entity.getRevision();
		if (revision != null)
		{
			registerClientId(revision.getClientId());
		}

		return entity;
	}
}
