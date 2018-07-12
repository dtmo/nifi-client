package com.tibtech.nifi.client;

import java.util.List;

import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

/**
 * AbstractComponent implements {@link Component} to hold a shared reference to
 * {@link Transport} to facilitate communications with the NiFi server.
 * 
 * @param <E> The type of {@link ComponentEntity} that describes the component.
 */
public abstract class AbstractComponent<E extends ComponentEntity> implements Component
{
	private final Transport transport;

	private E componentEntity;

	/**
	 * Constructs a new instance of AbstractComponent.
	 * 
	 * @param transport The transport with which to communicate with the NiFi
	 *        server.
	 * @param componentEntity The component entity which describes the component and
	 *        records its version.
	 */
	protected AbstractComponent(final Transport transport, final E componentEntity)
	{
		this.transport = transport;
		this.componentEntity = componentEntity;
	}

	@Override
	public Transport getTransport()
	{
		return transport;
	}

	@Override
	public String getId()
	{
		return componentEntity.getId();
	}

	@Override
	public long getVersion()
	{
		return componentEntity.getRevision().getVersion();
	}

	/**
	 * Returns the component entity which describes the component and records its
	 * version.
	 * 
	 * @return The component entity which describes the component and records its
	 *         version.
	 */
	protected E getComponentEntity()
	{
		return componentEntity;
	}

	/**
	 * Sets the component entity which describes the component and records its
	 * version.
	 * 
	 * @param componentEntity The component entity to set.
	 */
	protected void setComponentEntity(E componentEntity)
	{
		this.componentEntity = componentEntity;
	}

	/**
	 * Returns the permissions for this component.
	 * 
	 * @return The permissions for this component.
	 */
	public PermissionsDTO getPermissions()
	{
		return componentEntity.getPermissions();
	}

	/**
	 * Returns the bulletins for this component.
	 * 
	 * @return The bulletins for this component.
	 */
	public List<BulletinEntity> getBulletins()
	{
		return componentEntity.getBulletins();
	}

	/**
	 * Returns the position of this component in the UI if applicable, null
	 * otherwise.
	 * 
	 * @return The position of this component in the UI if applicable, null
	 *         otherwise.
	 */
	public PositionDTO getPosition()
	{
		return componentEntity.getPosition();
	}
}
