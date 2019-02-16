package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.DropRequestDTO;
import org.apache.nifi.web.api.entity.DropRequestEntity;

import com.tibtech.nifi.web.api.flowfilequeue.GetDropRequestInvoker;

public class DropRequest implements AsynchronousRequest<DropRequest>
{
    private final Connection connection;
    private DropRequestEntity dropRequestEntity;

    public DropRequest(final Connection connection, final DropRequestEntity dropRequestEntity)
    {
        this.connection = connection;
        this.dropRequestEntity = dropRequestEntity;
    }

    public DropRequestDTO getDropRequestDto()
    {
        return dropRequestEntity.getDropRequest();
    }

    public String getId()
    {
        return getDropRequestDto().getId();
    }

    @Override
    public DropRequest refresh()
    {
        dropRequestEntity = new GetDropRequestInvoker(connection.getController().getTransport())
                .setDropRequestId(getId()).setId(connection.getId()).invoke();
        return this;
    }

    @Override
    public boolean isFinished()
    {
        return getDropRequestDto().isFinished();
    }
}
