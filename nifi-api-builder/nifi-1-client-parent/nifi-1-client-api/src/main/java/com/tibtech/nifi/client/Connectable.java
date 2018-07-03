package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.ConnectableDTO;

import com.tibtech.nifi.web.api.dto.ConnectableDTOBuilder;
import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public interface Connectable extends Component
{
    String getParentGroupId();

    ConnectableType getConnectableType();

    default public Connection connectTo(final Connectable destination, Collection<String> selectedRelationships,
                                final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
    {
        return Connection.createConnection(getTransport(), this, destination, selectedRelationships, configurator);
    }

    default Connection connectTo(final Connectable destination, final Collection<String> selectedRelationships,
                                        @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure)
            throws InvokerException
    {
        return connectTo(destination, selectedRelationships, configurator ->
        {
            final Closure<ConnectionDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    default ConnectableDTO asConnectableDTO()
    {
        return new ConnectableDTOBuilder()
                .setId(getId())
                .setGroupId(getParentGroupId())
                .setType(getConnectableType().name())
                .build();
    }
}
