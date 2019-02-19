package com.tibtech.nifi.client;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.ConnectableDTO;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.DropRequestDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.ConnectionEntity;
import org.apache.nifi.web.api.entity.DropRequestEntity;

import com.tibtech.nifi.web.api.connection.DeleteConnectionInvoker;
import com.tibtech.nifi.web.api.connection.GetConnectionInvoker;
import com.tibtech.nifi.web.api.connection.UpdateConnectionInvoker;
import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.dto.RevisionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ConnectionEntityBuilder;
import com.tibtech.nifi.web.api.flowfilequeue.CreateDropRequestInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateConnectionInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

/**
 * Connection represents a connection between two components in a NiFi flow.
 */
public class Connection extends AbstractComponent<ConnectionEntity>
        implements Parented, Refreshable<Connection>, Updatable<Connection, ConnectionDTOBuilder>, Deletable
{
    /**
     * Creates a new instance of Connection.
     *
     * @param transport             The transport with which to communicate with the
     *                              NiFi server.
     * @param source                The source component from which flow files will
     *                              be collected.
     * @param destination           The destination component to which flow files
     *                              will be delivered.
     * @param selectedRelationships The source component relationships for which
     *                              flow files will travel on the connection.
     * @param configurator          A {@link Consumer} that accepts an instance of
     *                              {@link ConnectionDTOBuilder} on which connection
     *                              configuration may be set.
     * @return A new connection.
     * @throws InvokerException if there is a problem creating the connection.
     */
    public static Connection createConnection(final Controller controller, final Connectable source,
            final Connectable destination, final Collection<String> selectedRelationships,
            final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
    {
        final ConnectionDTOBuilder connectionDTOBuilder = new ConnectionDTOBuilder()
                .setSource(new ConnectableDTOBuilder().setId(source.getId()).setGroupId(source.getParentGroupId())
                        .setType(source.getConnectableType().name()).build())
                .setDestination(new ConnectableDTOBuilder().setId(destination.getId())
                        .setGroupId(destination.getParentGroupId()).setType(destination.getConnectableType().name())
                        .build())
                .setSelectedRelationships(new HashSet<>(selectedRelationships));

        configurator.accept(connectionDTOBuilder);

        final Transport transport = controller.getTransport();
        final ConnectionEntity connectionEntity = new CreateConnectionInvoker(transport)
                .setId(source.getParentGroupId())
                .setConnectionEntity(new ConnectionEntityBuilder()
                        .setRevision(
                                new RevisionDTOBuilder().setClientId(transport.getClientId()).setVersion(0L).build())
                        .setComponent(connectionDTOBuilder.build()).build())
                .invoke();
        return new Connection(controller, connectionEntity);
    }

    /**
     * Constructs a new instance of Connection.
     *
     * @param controller       The controller to which the connection belongs.
     * @param connectionEntity The entity that represents the connection.
     */
    public Connection(final Controller controller, final ConnectionEntity connectionEntity)
    {
        super(controller, connectionEntity);
    }

    /**
     * Returns the DTO that describes the connection.
     *
     * @return The DTO that describes the connection.
     */
    public ConnectionDTO getConnectionDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getConnectionDTO().getId();
    }

    /**
     * Returns the relationships that the source of the connection currently
     * supports.
     *
     * @return The relationships that the source of the connection currently
     *         supports.
     */
    public Set<String> getAvailableRelationships()
    {
        return Collections.unmodifiableSet(getConnectionDTO().getAvailableRelationships());
    }

    /**
     * Returns the object data size threshold for determining when back pressure is
     * applied. Updating this value is a passive change in the sense that it won't
     * impact whether existing files over the limit are affected but it does help
     * feeder processors to stop pushing too much into this work queue.
     *
     * @return The object data size threshold for determining when back pressure is
     *         applied.
     */
    public String getBackPressureDataSizeThreshold()
    {
        return getConnectionDTO().getBackPressureDataSizeThreshold();
    }

    /**
     * Returns the object count threshold for determining when back pressure is
     * applied. Updating this value is a passive change in the sense that it won't
     * impact whether existing files over the limit are affected but it does help
     * feeder processors to stop pushing too much into this work queue.
     *
     * @return The object count threshold for determining when back pressure is
     *         applied.
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
    public List<PositionDTO> getBendPositionDTOs()
    {
        return Collections.unmodifiableList(getConnectionDTO().getBends());
    }

    /**
     * Returns the destination of this connection.
     *
     * @return The destination of this connection.
     */
    public ConnectableDTO getDestinationConnectableDTO()
    {
        return getConnectionDTO().getDestination();
    }

    /**
     * Returns the amount of time a flow file may be in the flow before it will be
     * automatically aged out of the flow. Once a flow file reaches this age it will
     * be terminated from the flow the next time a processor attempts to start work
     * on it.
     *
     * @return The amount of time a flow file may be in the flow before it will be
     *         automatically aged out of the flow.
     */
    public String getFlowFileExpiration()
    {
        return getConnectionDTO().getFlowFileExpiration();
    }

    /**
     * Returns the index of control point that the connection label should be placed
     * over.
     *
     * @return The index of control point that the connection label should be placed
     *         over.
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

    @Override
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
    public ConnectableDTO getSourceConnectableDTO()
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
        new DeleteConnectionInvoker(getController().getTransport()).setId(getId())
                .setVersion(getRevisionDTO().getVersion()).invoke();
    }

    @Override
    public Connection refresh() throws InvokerException
    {
        setComponentEntity(new GetConnectionInvoker(getController().getTransport()).setId(getId()).invoke());
        return this;
    }

    @Override
    public Connection update(final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
    {
        final ConnectionDTOBuilder connectionDTOBuilder = new ConnectionDTOBuilder().setId(getId());

        configurator.accept(connectionDTOBuilder);

        setComponentEntity(new UpdateConnectionInvoker(getController().getTransport()).setId(getId())
                .setConnectionEntity(new ConnectionEntityBuilder().setRevision(getRevisionDTO())
                        .setComponent(connectionDTOBuilder.build()).build())
                .invoke());
        return this;
    }

    @Override
    public Connection update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
            throws InvokerException
    {
        return Updatable.super.update(closure);
    }

    /**
     * Reconnects the connection to the specified destination.
     *
     * @param destination The new destination for the connection.
     * @return The updated connection.
     * @throws InvokerException if there is a problem updating the connection
     *                          destination.
     */
    public Connection reconnectTo(final Connectable destination) throws InvokerException
    {
        setComponentEntity(
                new UpdateConnectionInvoker(getController().getTransport()).setId(getId())
                        .setConnectionEntity(
                                new ConnectionEntityBuilder().setRevision(getRevisionDTO())
                                        .setComponent(ConnectionDTOBuilder.of(getConnectionDTO())
                                                .setDestination(destination.asConnectableDTO()).build())
                                        .build())
                        .invoke());

        return this;
    }

    /**
     * Creates a {@link DropRequest} with which to drop the flow files queued on the
     * connection.
     * 
     * @return A {@link DropRequest} with which to drop the flow files queued on the
     *         connection.
     */
    public DropRequest createDropRequest()
    {
        final DropRequestEntity dropRequestEntity = new CreateDropRequestInvoker(getController().getTransport())
                .setId(getId()).invoke();
        return new DropRequest(this, dropRequestEntity);
    }

    /**
     * Drops the flow flow files queued on the connection.
     * 
     * @param pollingInterval The time to wait between each refresh of the drop
     *                        request.
     * @param pollingDuration The time to wait for the drop request to finish before
     *                        giving up refreshing its state.
     * @return The {@link DropRequest} with which the queued flow files were
     *         dropped.
     */
    public DropRequest dropContents(final Duration pollingInterval, final Duration pollingDuration)
    {
        return createDropRequest().pollUntilFinished(pollingInterval, pollingDuration);
    }
}
