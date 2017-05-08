package com.tibtech.nifi.client;

import java.util.List;

import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

public abstract class Component<T extends ComponentEntity>
{
	private final Transport transport;

	private T componentEntity;

	public Component(final Transport transport, final T componentEntity)
	{
		this.transport = transport;
		this.componentEntity = componentEntity;
	}

	protected Transport getTransport()
	{
		return transport;
	}
	
	protected T getComponentEntity()
	{
		return componentEntity;
	}
	
	protected void setComponentEntity(T componentEntity)
	{
		this.componentEntity = componentEntity;
	}

	public String getId()
	{
		return componentEntity.getId();
	}

	public PermissionsDTO getPermissions()
	{
		return componentEntity.getPermissions();
	}

	public List<BulletinEntity> getBulletins()
	{
		return componentEntity.getBulletins();
	}

	public PositionDTO getPosition()
	{
		return componentEntity.getPosition();
	}
	
	public long getVersion()
	{
		return componentEntity.getRevision().getVersion();
	}

	public abstract void delete() throws InvokerException;
}
