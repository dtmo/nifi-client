package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.dto.FunnelDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.entity.FunnelEntity;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.funnel.GetFunnelInvoker;
import com.tibtech.nifi.web.api.funnel.RemoveFunnelInvoker;
import com.tibtech.nifi.web.api.funnel.UpdateFunnelInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Funnel extends ConnectableComponent<Funnel, FunnelDTOBuilder>
{
	private FunnelDTO funnelDTO;

	public Funnel(final Transport transport, final long version, final FunnelDTO funnelDTO)
	{
		super(transport, version);

		this.funnelDTO = funnelDTO;
	}

	public String getId()
	{
		return funnelDTO.getId();
	}

	public String getParentGroupId()
	{
		return funnelDTO.getParentGroupId();
	}

	public PositionDTO getPosition()
	{
		return funnelDTO.getPosition();
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.FUNNEL;
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveFunnelInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public Funnel refresh() throws InvokerException
	{
		this.funnelDTO = new GetFunnelInvoker(getTransport(), getVersion()).setId(getId()).invoke().getComponent();
		return this;
	}

	@Override
	public Funnel update(final Function<FunnelDTOBuilder, FunnelDTOBuilder> configurator) throws InvokerException
	{
		final FunnelEntity funnelEntity = new UpdateFunnelInvoker(getTransport(), getVersion()).setId(getId())
				.setFunnelEntity(new FunnelEntityBuilder().setId(getId())
						.setComponent(configurator.apply(FunnelDTOBuilder.of(funnelDTO)).build()).build())
				.invoke();
		setVersion(funnelEntity.getRevision().getVersion());
		this.funnelDTO = funnelEntity.getComponent();
		return this;
	}

	@Override
	public Funnel update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FunnelDTOBuilder.class) final Closure<FunnelDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}
}
