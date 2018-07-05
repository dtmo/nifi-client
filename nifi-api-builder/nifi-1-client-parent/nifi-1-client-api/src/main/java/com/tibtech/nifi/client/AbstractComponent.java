package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

import java.util.List;

public abstract class AbstractComponent<E extends ComponentEntity> implements Component
{
    private final Transport transport;

    private E componentEntity;

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

    public E getComponentEntity()
    {
        return componentEntity;
    }

    protected void setComponentEntity(E componentEntity)
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
}
