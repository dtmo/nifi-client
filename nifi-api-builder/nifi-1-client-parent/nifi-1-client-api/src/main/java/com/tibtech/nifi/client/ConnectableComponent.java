package com.tibtech.nifi.client;

import org.apache.nifi.web.api.entity.ComponentEntity;

public abstract class ConnectableComponent<T extends ConnectableComponent<T, E, B>, E extends ComponentEntity, B>
		extends UpdatableComponent<T, E, B> implements Connectable
{
	public ConnectableComponent(final Transport transport, final E componentEntity)
	{
		super(transport, componentEntity);
	}
}
