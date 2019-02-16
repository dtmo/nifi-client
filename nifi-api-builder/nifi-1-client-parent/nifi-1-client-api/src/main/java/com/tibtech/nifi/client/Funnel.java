package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.funnel.GetFunnelInvoker;
import com.tibtech.nifi.web.api.funnel.RemoveFunnelInvoker;
import com.tibtech.nifi.web.api.funnel.UpdateFunnelInvoker;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.FunnelDTO;
import org.apache.nifi.web.api.entity.FunnelEntity;

import java.util.function.Consumer;

/**
 * Funnel represents a NiFi funnel used to combine the data from several
 * connections into a single connection.
 */
public class Funnel extends AbstractComponent<FunnelEntity>
        implements Connectable, Deletable, Refreshable<Funnel>, Updatable<Funnel, FunnelDTOBuilder>
{
    /**
     * Constructs a new instance of Funnel.
     *
     * @param controller   The controller to which the funnel belongs.
     * @param funnelEntity The funnel entity.
     */
    public Funnel(final Controller controller, final FunnelEntity funnelEntity)
    {
        super(controller, funnelEntity);
    }

    /**
     * Returns the FunnelDTO that describes the funnel.
     *
     * @return The FunnelDTO that describes the funnel.
     */
    public FunnelDTO getFunnelDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getFunnelDTO().getId();
    }

    @Override
    public String getParentGroupId()
    {
        return getComponentEntity().getComponent().getParentGroupId();
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.FUNNEL;
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveFunnelInvoker(getController().getTransport()).setId(getId()).setVersion(getRevisionDTO().getVersion())
                .invoke();
    }

    @Override
    public Funnel refresh() throws InvokerException
    {
        setComponentEntity(new GetFunnelInvoker(getController().getTransport()).setId(getId()).invoke());
        return this;
    }

    @Override
    public Funnel update(final Consumer<FunnelDTOBuilder> configurator) throws InvokerException
    {
        final FunnelDTOBuilder funnelDTOBuilder = new FunnelDTOBuilder().setId(getId());

        configurator.accept(funnelDTOBuilder);

        setComponentEntity(
                new UpdateFunnelInvoker(getController().getTransport())
                        .setId(getId()).setFunnelEntity(new FunnelEntityBuilder().setId(getId())
                                .setComponent(funnelDTOBuilder.build()).setRevision(getRevisionDTO()).build())
                        .invoke());
        return this;
    }

    @Override
    public Funnel update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FunnelDTOBuilder.class) final Closure<FunnelDTOBuilder> closure)
            throws InvokerException
    {
        return Updatable.super.update(closure);
    }
}
