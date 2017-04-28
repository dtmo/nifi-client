package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateFunnelInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateProcessorInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.RemoveProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.UpdateProcessGroupInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ProcessGroup extends UpdatableComponent<ProcessGroup, ProcessGroupEntity, ProcessGroupDTOBuilder>
{
	public ProcessGroup(final Transport transport, final ProcessGroupEntity processGroupEntity)
	{
		super(transport, processGroupEntity);
	}

	protected ProcessGroupDTO getProcessGroupDTO()
	{
		return getComponentEntity().getComponent();
	}

	public String getParentGroupId()
	{
		return getProcessGroupDTO().getParentGroupId();
	}

	public String getName()
	{
		return getProcessGroupDTO().getName();
	}

	public String getComments()
	{
		return getProcessGroupDTO().getComments();
	}

	public FlowSnippetDTO getContents()
	{
		return getProcessGroupDTO().getContents();
	}

	public Integer getInputPortCount()
	{
		return getProcessGroupDTO().getInputPortCount();
	}

	public Integer getInvalidCount()
	{
		return getProcessGroupDTO().getInvalidCount();
	}

	public Integer getOutputPortCount()
	{
		return getProcessGroupDTO().getOutputPortCount();
	}

	public Integer getRunningCount()
	{
		return getProcessGroupDTO().getRunningCount();
	}

	public Integer getStoppedCount()
	{
		return getProcessGroupDTO().getStoppedCount();
	}

	public Integer getDisabledCount()
	{
		return getProcessGroupDTO().getDisabledCount();
	}

	public Integer getActiveRemotePortCount()
	{
		return getProcessGroupDTO().getActiveRemotePortCount();
	}

	public Integer getInactiveRemotePortCount()
	{
		return getProcessGroupDTO().getInactiveRemotePortCount();
	}

	public Funnel createFunnel(final Function<FunnelDTOBuilder, FunnelDTOBuilder> configurator) throws InvokerException
	{
		return new Funnel(getTransport(), new CreateFunnelInvoker(getTransport(), 0).setId(getId())
				.setFunnelEntity(new FunnelEntityBuilder()
						.setComponent(configurator.apply(new FunnelDTOBuilder().setParentGroupId(getId())).build())
						.build())
				.invoke());
	}

	public Funnel createFunnel(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FunnelDTOBuilder.class) final Closure<FunnelDTOBuilder> closure)
			throws InvokerException
	{
		return createFunnel(configurator ->
		{
			final Closure<FunnelDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return configurator;
		});
	}

	public Processor createProcessor(final Function<ProcessorDTOBuilder, ProcessorDTOBuilder> configurator)
			throws InvokerException
	{
		return new Processor(getTransport(), new CreateProcessorInvoker(getTransport(), 0).setId(getId())
				.setProcessorEntity(new ProcessorEntityBuilder()
						.setComponent(configurator.apply(new ProcessorDTOBuilder().setParentGroupId(getId())).build())
						.build())
				.invoke());
	}

	public Processor createProcessor(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessor(configurator ->
		{
			final Closure<ProcessorDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return configurator;
		});
	}

	public ProcessGroup createProcessGroup(final Function<ProcessGroupDTOBuilder, ProcessGroupDTOBuilder> configurator)
			throws InvokerException
	{
		return new ProcessGroup(getTransport(),
				new CreateProcessGroupInvoker(getTransport(), 0).setId(getParentGroupId())
						.setProcessGroupEntity(new ProcessGroupEntityBuilder().setComponent(configurator
								.apply(new ProcessGroupDTOBuilder().setParentGroupId(getParentGroupId())).build())
								.build())
						.invoke());
	}

	public ProcessGroup createProcessGroup(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessGroup(p ->
		{
			final Closure<ProcessGroupDTOBuilder> code = closure.rehydrate(p, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return p;
		});
	}

	public RemoteProcessGroup createRemoteProcessGroup(
			final Function<RemoteProcessGroupDTOBuilder, RemoteProcessGroupDTOBuilder> configurator)
			throws InvokerException
	{
		return new RemoteProcessGroup(getTransport(),
				new CreateRemoteProcessGroupInvoker(getTransport(), 0).setId(getId())
						.setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder().setComponent(configurator
								.apply(new RemoteProcessGroupDTOBuilder().setParentGroupId(getParentGroupId())).build())
								.build())
						.invoke());
	}

	public RemoteProcessGroup createRemoteProcessGroup(final Closure<RemoteProcessGroup> closure)
			throws InvokerException
	{
		return createRemoteProcessGroup(configurator ->
		{
			final Closure<RemoteProcessGroup> code = closure.rehydrate(closure, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return configurator;
		});
	}

	@Override
	public ProcessGroup refresh() throws InvokerException
	{
		setComponentEntity(new GetProcessGroupInvoker(getTransport(), 0).setId(getId()).invoke());

		return this;
	}

	@Override
	public ProcessGroup update(final Function<ProcessGroupDTOBuilder, ProcessGroupDTOBuilder> configurator)
			throws InvokerException
	{
		setComponentEntity(new UpdateProcessGroupInvoker(getTransport(), getVersion()).setId(getId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder()
						.setComponent(configurator.apply(ProcessGroupDTOBuilder.of(getProcessGroupDTO())).build())
						.build())
				.invoke());

		return this;
	}

	@Override
	public ProcessGroup update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}
}
