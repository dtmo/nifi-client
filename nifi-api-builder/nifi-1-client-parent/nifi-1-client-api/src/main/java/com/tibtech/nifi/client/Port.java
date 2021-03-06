package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.dto.status.PortStatusDTO;
import org.apache.nifi.web.api.entity.PortEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Port represents an abstract NiFi flow port.
 *
 * @param <T> The type of port.
 */
public abstract class Port<T extends Port<T>> extends AbstractComponent<PortEntity>
        implements Connectable, Deletable, Updatable<T, PortDTOBuilder>, Schedulable<T>
{
    /**
     * Constructs a new instance of Port.
     *
     * @param controller The controller to which the port belongs.
     * @param portEntity The entity that represents the port.
     */
    public Port(final Controller controller, final PortEntity portEntity)
    {
        super(controller, portEntity);
    }

    /**
     * Returns the DTO that describes the port.
     *
     * @return The DTO that describes the port.
     */
    public PortDTO getPortDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getPortDTO().getId();
    }

    /**
     * Returns the ID of the parent process group.
     *
     * @return The ID of the parent process group.
     */
    @Override
    public String getParentGroupId()
    {
        return getPortDTO().getParentGroupId();
    }

    /**
     * Returns the port type name.
     * 
     * @return The port type name.
     */
    public String getPortType()
    {
        return getComponentEntity().getPortType();
    }

    /**
     * Returns the status of the port.
     *
     * @return The status of the port.
     */
    public PortStatusDTO getStatus()
    {
        return getComponentEntity().getStatus();
    }

    /**
     * Returns the URI for linking to this component in this NiFi.
     *
     * @return The URI for linking to this component in this NiFi.
     */
    public String getUri()
    {
        return getComponentEntity().getUri();
    }

    /**
     * Returns the user comments for the port.
     *
     * @return The user comments for the port.
     */
    public String getComments()
    {
        return getPortDTO().getComments();
    }

    /**
     * Returns the number of tasks that should be concurrently scheduled for this
     * port.
     *
     * @return The number of tasks that should be concurrently scheduled for this
     *         port.
     */
    public int getConcurrentlySchedulableTaskCount()
    {
        return getPortDTO().getConcurrentlySchedulableTaskCount();
    }

    /**
     * Returns the groups that are allowed to access this port.
     *
     * @return The groups that are allowed to access this port
     */
    public Set<String> getGroupAccessControl()
    {
        return Collections.unmodifiableSet(getPortDTO().getGroupAccessControl());
    }

    /**
     * Returns the name of the port.
     *
     * @return The name of the port.
     */
    public String getName()
    {
        return getPortDTO().getName();
    }

    /**
     * Returns the state of this port. Possible states are 'RUNNING', 'STOPPED', and
     * 'DISABLED'
     *
     * @return The state of this port.
     */
    public String getState()
    {
        return getPortDTO().getState();
    }

    /**
     * Returns the type of port. Possible values are 'INPUT_PORT' or 'OUTPUT_PORT'.
     *
     * @return The type of port.
     */
    public String getType()
    {
        return getPortDTO().getType();
    }

    /**
     * Returns the users that are allowed to access this port.
     *
     * @return The users that are allowed to access this port.
     */
    public Set<String> getUserAccessControl()
    {
        return Collections.unmodifiableSet(getPortDTO().getUserAccessControl());
    }

    /**
     * Returns the validation errors from this port. These validation errors
     * represent the problems with the port that must be resolved before it can be
     * started.
     *
     * @return The validation errors from this port.
     */
    public Collection<String> getValidationErrors()
    {
        return Collections.unmodifiableCollection(getPortDTO().getValidationErrors());
    }

    @Override
    public String getScheduledState()
    {
        return getPortDTO().getState();
    }
}
