package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.ConnectableDTO;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Connectable represents a component that can be connected to another
 * component.
 */
public interface Connectable extends Parented
{
    /**
     * Returns the connectable type that represents this component.
     * 
     * @return The connectable type that represents this component.
     */
    ConnectableType getConnectableType();

    /**
     * Creates a connection between this component as a source and another component
     * as a destination.
     * 
     * @param destination           The destination component to which to create a
     *                              connection.
     * @param selectedRelationships The relationships for which flow files will be
     *                              put on this connection.
     * @param configurator          A consumer that accepts an instance of
     *                              {@link ConnectionDTOBuilder} on which connection
     *                              settings may be set.
     * @return The created connection.
     * @throws InvokerException if there is a problem creating a connection.
     */
    default public Connection connectTo(final Connectable destination, Collection<String> selectedRelationships,
            final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
    {
        return Connection.createConnection(getController(), this, destination, selectedRelationships, configurator);
    }

    /**
     * Creates a connection between this component as a source and another component
     * as a destination.
     * 
     * @param destination           The destination component to which to create a
     *                              connection.
     * @param selectedRelationships The relationships for which flow files will be
     *                              put on this connection.
     * @param closure               A consumer that delegates to an instance of
     *                              {@link ConnectionDTOBuilder} on which connection
     *                              settings may be set.
     * @return The created connection.
     * @throws InvokerException if there is a problem creating a connection.
     */
    default Connection connectTo(final Connectable destination, final Collection<String> selectedRelationships,
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
            throws InvokerException
    {
        return connectTo(destination, selectedRelationships, configurator -> {
            final Closure<ConnectionDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    /**
     * Returns a {@link ConnectableDTO} that represents this connectable component.
     * 
     * @return A {@link ConnectableDTO} that represents this connectable component.
     */
    default ConnectableDTO asConnectableDTO()
    {
        return new ConnectableDTOBuilder().setId(getId()).setGroupId(getParentGroupId())
                .setType(getConnectableType().name()).build();
    }
}
