package com.tibtech.nifi.client;

import java.util.Date;

import org.apache.nifi.web.api.dto.DropRequestDTO;
import org.apache.nifi.web.api.entity.DropRequestEntity;

import com.tibtech.nifi.web.api.flowfilequeue.GetDropRequestInvoker;

/**
 * DropRequest represents a request to drop queued flow files from a connection.
 */
public class DropRequest implements AsynchronousRequest<DropRequest>
{
    private final Connection connection;
    private DropRequestEntity dropRequestEntity;

    /**
     * Constructs a new instance of DropRequest.
     * 
     * @param connection        The connection from which to drop queued flow files.
     * @param dropRequestEntity The entity that represents the drop request.
     */
    public DropRequest(final Connection connection, final DropRequestEntity dropRequestEntity)
    {
        this.connection = connection;
        this.dropRequestEntity = dropRequestEntity;
    }

    /**
     * Returns the DTO that describes this drop request.
     * 
     * @return The DTO that describes this drop request.
     */
    public DropRequestDTO getDropRequestDto()
    {
        return dropRequestEntity.getDropRequest();
    }

    /**
     * Returns the ID for this drop request.
     * 
     * @return The ID for this drop request.
     */
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

    /**
     * Returns the URI for linking to this drop request in this NiFi.
     * 
     * @return The URI for linking to this drop request in this NiFi.
     */
    public String getUri()
    {
        return getDropRequestDto().getUri();
    }

    /**
     * Returns the timestamp when the query was submitted.
     * 
     * @return The timestamp when the query was submitted.
     */
    public Date getSubmissionTime()
    {
        return getDropRequestDto().getSubmissionTime();
    }

    /**
     * Returns the current percent complete.
     * 
     * @return The current percent complete.
     */
    public Integer getPercentCompleted()
    {
        return getDropRequestDto().getPercentCompleted();
    }

    /**
     * Returns the reason, if any, that this drop request failed.
     * 
     * @return The reason, if any, that this drop request failed.
     */
    public String getFailureReason()
    {
        return getDropRequestDto().getFailureReason();
    }

    /**
     * Returns the time this request was last updated.
     * 
     * @return The time this request was last updated
     */
    public Date getLastUpdated()
    {
        return getDropRequestDto().getLastUpdated();
    }

    /**
     * Returns the number of flow files currently queued.
     * 
     * @return The number of flow files currently queued.
     */
    public Integer getCurrentCount()
    {
        return getDropRequestDto().getCurrentCount();
    }

    /**
     * Returns the size of the flow files currently queued in bytes.
     * 
     * @return The size of the flow files currently queued in bytes.
     */
    public Long getCurrentSize()
    {
        return getDropRequestDto().getCurrentSize();
    }

    /**
     * Returns the count and size of the currently queued flow files.
     * 
     * @return The count and size of the currently queued flow files.
     */
    public String getCurrent()
    {
        return getDropRequestDto().getCurrent();
    }

    /**
     * Returns the number of flow files to be dropped as a result of this request.
     * 
     * @return The number of flow files to be dropped as a result of this request.
     */
    public Integer getOriginalCount()
    {
        return getDropRequestDto().getOriginalCount();
    }

    /**
     * Returns the size of the flow files to be dropped as a result of this request
     * in bytes.
     * 
     * @return The size of the flow files to be dropped as a result of this request
     *         in bytes.
     */
    public Long getOriginalSize()
    {
        return getDropRequestDto().getOriginalSize();
    }

    /**
     * Returns the count and size of flow files to be dropped as a result of this
     * request.
     * 
     * @return The count and size of flow files to be dropped as a result of this
     *         request.
     */
    public String getOriginal()
    {
        return getDropRequestDto().getOriginal();
    }

    /**
     * Returns the number of flow files that have been dropped thus far.
     * 
     * @return The number of flow files that have been dropped thus far.
     */
    public Integer getDroppedCount()
    {
        return getDropRequestDto().getDroppedCount();
    }

    /**
     * Returns the size of the flow files that have been dropped thus far in bytes.
     * 
     * @return The size of the flow files that have been dropped thus far in bytes.
     */
    public Long getDroppedSize()
    {
        return getDropRequestDto().getDroppedSize();
    }

    /**
     * Returns the count and size of the flow files that have been dropped thus far.
     * 
     * @return The count and size of the flow files that have been dropped thus far.
     */
    public String getDropped()
    {
        return getDropRequestDto().getDropped();
    }

    /**
     * Returns the current state of the drop request.
     * 
     * @return The current state of the drop request.
     */
    public String getState()
    {
        return getDropRequestDto().getState();
    }
}
