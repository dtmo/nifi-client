package com.tibtech.nifi.client;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

public abstract class ComponentEntityInvoker<T extends ComponentEntity> extends AbstractInvoker<T>
{
	private String id;
	private String uri;
	private PositionDTO position;
	private PermissionsDTO permissions;
	private List<BulletinEntity> bulletins;

	public ComponentEntityInvoker(final Transport transport)
	{
		super(transport);
	}

	protected void setEntityValues(T componentEntity)
	{
		componentEntity.setRevision(createRevisionDto());
		componentEntity.setId(id);
		componentEntity.setUri(uri);
		componentEntity.setPosition(position);
		componentEntity.setPermissions(permissions);
		componentEntity.setBulletins(bulletins);
	}

	protected T handleComponentEntityResponse(final Response response, final Class<T> entityClass)
			throws InvokerException
	{
		final T entity = handleResponse(response, entityClass);

		final RevisionDTO revision = entity.getRevision();
		registerClientId(revision.getClientId());
		updateVersion(revision.getVersion());

		return entity;
	}
}
