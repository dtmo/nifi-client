package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.connection.DeleteConnectionInvoker;
import com.tibtech.nifi.web.api.connection.GetConnectionInvoker;
import com.tibtech.nifi.web.api.connection.UpdateConnectionInvoker;
import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ConnectionEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateConnectionInvoker;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.ConnectableDTO;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.ConnectionEntity;

import java.util.*;
import java.util.function.Consumer;

/**
 * Connection represents a connection between two components in a NiFi flow.
 */
public class Connection extends UpdatableComponent<Connection, ConnectionEntity, ConnectionDTOBuilder>
        implements Deletable, Refreshable<Connection, ConnectionDTOBuilder>
{
    /**
     * Creates a new instance of Connection.
     *
     * @param transport             The transport with which to communicate with the NiFi server.
     * @param source                The source component from which flow files will be collected.
     * @param destination           The destination component to which flow files will be delivered.
     * @param selectedRelationships The source component relationships for which flow files will travel on the connection.
     * @param configurator          A {@link Consumer} that accepts an instance of {@link ConnectionDTOBuilder} on which connection configuration may be set.
     * @return A new connection.
     * @throws InvokerException if there is a problem creating the connection.
     */
    public static Connection createConnection(final Transport transport, final Connectable source,
                                              final Connectable destination, final Collection<String> selectedRelationships,
                                              final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
    {
        final ConnectionDTOBuilder connectionDTOBuilder = new ConnectionDTOBuilder()
                .setSource(new ConnectableDTOBuilder()
                        .setId(source.getId())
                        .setGroupId(source.getParentGroupId())
                        .setType(source.getConnectableType().name())
                        .build())
                .setDestination(new ConnectableDTOBuilder()
                        .setId(destination.getId())
                        .setGroupId(destination.getParentGroupId())
                        .setType(destination.getConnectableType().name())
                        .build())
                .setSelectedRelationships(new HashSet<>(selectedRelationships));

        configurator.accept(connectionDTOBuilder);

        final ConnectionEntity connectionEntity = new CreateConnectionInvoker(transport, 0)
                .setId(source.getParentGroupId())
                .setConnectionEntity(new ConnectionEntityBuilder()
                        .setComponent(connectionDTOBuilder.build())
                        .build())
                .invoke();
        return new Connection(transport, connectionEntity);
    }

    /**
     * Constructs a new instance of Connection.
     *
     * @param transport        The transport with which to communicate with the NiFi server.
     * @param connectionEntity The entity that represents the connection.
     */
    public Connection(final Transport transport, final ConnectionEntity connectionEntity)
    {
        super(transport, connectionEntity);
    }

    private ConnectionDTO getConnectionDTO()
    {
        return getComponentEntity().getComponent();
    }

    /**
     * Returns the relationships that the source of the connection currently supports.
     *
     * @return The relationships that the source of the connection currently supports.
     */
    public Set<String> getAvailableRelationships()
    {
        return Collections.unmodifiableSet(getConnectionDTO().getAvailableRelationships());
    }

    /**
     * Returns the object data size threshold for determining when back pressure is applied. Updating this value is a
     * passive change in the sense that it won't impact whether existing files over the limit are affected but it does
     * help feeder processors to stop pushing too much into this work queue.
     *
     * @return The object data size threshold for determining when back pressure is applied.
     */
    public String getBackPressureDataSizeThreshold()
    {
        return getConnectionDTO().getBackPressureDataSizeThreshold();
    }

    /**
     * Returns the object count threshold for determining when back pressure is applied. Updating this value is a
     * passive change in the sense that it won't impact whether existing files over the limit are affected but it does
     * help feeder processors to stop pushing too much into this work queue.
     *
     * @return The object count threshold for determining when back pressure is applied.
     */
    public long getBackPressureObjectThreshold()
    {
        return getConnectionDTO().getBackPressureObjectThreshold();
    }

    /**
     * Returns the positions of the bend points on this connection.
     *
     * @return The positions of the bend points on this connection.
     */
    public List<PositionDTO> getBends()
    {
        return Collections.unmodifiableList(getConnectionDTO().getBends());
    }

    /**
     * Returns the destination of this connection.
     *
     * @return The destination of this connection.
     */
    public ConnectableDTO getDestination()
    {
        return getConnectionDTO().getDestination();
    }

    /**
     * Returns the amount of time a flow file may be in the flow before it will be automatically aged out of the flow.
     * Once a flow file reaches this age it will be terminated from the flow the next time a processor attempts to start
     * work on it.
     *
     * @return The amount of time a flow file may be in the flow before it will be automatically aged out of the flow.
     */
    public String getFlowFileExpiration()
    {
        return getConnectionDTO().getFlowFileExpiration();
    }

    /**
     * Returns the index of control point that the connection label should be placed over.
     *
     * @return The index of control point that the connection label should be placed over.
     */
    public int getLabelIndex()
    {
        return getConnectionDTO().getLabelIndex();
    }

    /**
     * Returns the name of the connection.
     *
     * @return The name of the connection.
     */
    public String getName()
    {
        return getConnectionDTO().getName();
    }

    /**
     * Returns the ID of the process group that contains this connection.
     *
     * @return The ID of the process group that contains this connection.
     */
    public String getParentGroupId()
    {
        return getConnectionDTO().getParentGroupId();
    }

    /**
     * Returns the prioritizers this connection is using.
     *
     * @return The prioritizers this connection is using.
     */
    public List<String> getPrioritizers()
    {
        return Collections.unmodifiableList(getConnectionDTO().getPrioritizers());
    }

    /**
     * Returns the relationships that make up this connection.
     *
     * @return The relationships that make up this connection.
     */
    public Set<String> getSelectedRelationships()
    {
        return Collections.unmodifiableSet(getConnectionDTO().getSelectedRelationships());
    }

    /**
     * Returns the source of this connection.
     *
     * @return The source of this connection.
     */
    public ConnectableDTO getSource()
    {
        return getConnectionDTO().getSource();
    }

    /**
     * Returns the z index for this connection.
     *
     * @return The z index for this connection.
     */
    public long getzIndex()
    {
        return getConnectionDTO().getzIndex();
    }

    @Override
    public void delete() throws InvokerException
    {
        new DeleteConnectionInvoker(getTransport(), getVersion()).setId(getId()).invoke();
    }

    @Override
    public Connection refresh() throws InvokerException
    {
        setComponentEntity(new GetConnectionInvoker(getTransport(), getVersion()).setId(getId()).invoke());

        return this;
    }

    @Override
    public Connection update(final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
    {
        final ConnectionDTOBuilder connectionDTOBuilder = ConnectionDTOBuilder.of(getConnectionDTO());

        configurator.accept(connectionDTOBuilder);

        setComponentEntity(new UpdateConnectionInvoker(getTransport(), getVersion())
                .setId(getId())
                .setConnectionEntity(new ConnectionEntityBuilder()
                        .setComponent(connectionDTOBuilder.build())
                        .build())
                .invoke());
        return this;
    }

    @Override
    public Connection update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
            throws InvokerException
    {
        return super.update(closure);
    }

    /**
     * Reconnects the connection to the specified destination.
     *
     * @param destination The new destination for the connection.
     * @return The updated connection.
     * @throws InvokerException if there is a problem updating the connection destination.
     */
    public Connection reconnectTo(final Connectable destination) throws InvokerException
    {
        setComponentEntity(new UpdateConnectionInvoker(getTransport(), getVersion()).setId(getId())
                .setConnectionEntity(new ConnectionEntityBuilder()
                        .setComponent(ConnectionDTOBuilder.of(getConnectionDTO())
                                .setDestination(destination.asConnectableDTO())
                                .build())
                        .build())
                .invoke());

        return this;
    }

    /**
     * Gets the connection with the specified ID.
     *
     * @param transport The transport with which to communicate with the NiFi server.
     * @param id        The ID of the connection to get.
     * @return The connection with the specified ID.
     * @throws InvokerException if there is a problem getting the connection.
     */
    public static Connection get(final Transport transport, final String id) throws InvokerException
    {
        return new Connection(transport, new GetConnectionInvoker(transport, 0)
                .setId(id)
                .invoke());
    }
}
