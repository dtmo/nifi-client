package com.tibtech.nifi.client;

import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.Entity;

public abstract class EntityInvoker<T extends Entity> extends AbstractInvoker<T>
{
	public EntityInvoker(final Transport transport, final long version)
	{
		super(transport, version);
	}

	protected void setEntityValues(T componentEntity)
	{
		componentEntity.setRevision(createRevisionDto());
	}

	protected T handleComponentEntityResponse(final Response response, final Class<T> entityClass)
			throws InvokerException
	{
		final T entity = handleResponse(response, entityClass);

		final RevisionDTO revision = entity.getRevision();
		if (revision != null)
		{
			registerClientId(revision.getClientId());
			updateVersion(revision.getVersion());
		}

		return entity;
	}
}
