package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

import java.util.List;

public abstract class AbstractComponent<T extends ComponentEntity> implements Deletable
{
    private final Transport transport;

    private T componentEntity;

    public AbstractComponent(final Transport transport, final T componentEntity)
    {
        this.transport = transport;
        this.componentEntity = componentEntity;
    }

    @Override
    public Transport getTransport()
    {
        return transport;
    }

    public T getComponentEntity()
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
}
