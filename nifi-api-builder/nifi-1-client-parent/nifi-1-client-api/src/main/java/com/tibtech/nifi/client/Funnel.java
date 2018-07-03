package com.tibtech.nifi.client;

import java.util.function.Consumer;

import org.apache.nifi.web.api.entity.FunnelEntity;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.funnel.GetFunnelInvoker;
import com.tibtech.nifi.web.api.funnel.RemoveFunnelInvoker;
import com.tibtech.nifi.web.api.funnel.UpdateFunnelInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Funnel extends ConnectableComponent<Funnel, FunnelEntity, FunnelDTOBuilder>
{
	public Funnel(final Transport transport, final FunnelEntity funnelEntity)
	{
		super(transport, funnelEntity);
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

	public void delete() throws InvokerException
	{
		new RemoveFunnelInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public Funnel refresh() throws InvokerException
	{
		setComponentEntity(new GetFunnelInvoker(getTransport(), getVersion()).setId(getId()).invoke());
		return this;
	}

	@Override
	public Funnel update(final Consumer<FunnelDTOBuilder> configurator) throws InvokerException
	{
		final FunnelDTOBuilder funnelDTOBuilder = FunnelDTOBuilder.of(getComponentEntity().getComponent());

		configurator.accept(funnelDTOBuilder);

		setComponentEntity(new UpdateFunnelInvoker(getTransport(), getVersion()).setId(getId())
				.setFunnelEntity(
						new FunnelEntityBuilder().setId(getId()).setComponent(funnelDTOBuilder.build()).build())
				.invoke());
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
