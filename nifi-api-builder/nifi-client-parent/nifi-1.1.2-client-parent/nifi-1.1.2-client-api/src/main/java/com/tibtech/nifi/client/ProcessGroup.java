package com.tibtech.nifi.client;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
import com.tibtech.nifi.web.api.processgroup.GetFunnelsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessorsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetRemoteProcessGroupsInvoker;
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

	public Set<Funnel> getFunnels() throws InvokerException
	{
		return new GetFunnelsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getFunnels().stream()
				.map(funnelEntity -> new Funnel(getTransport(), funnelEntity)).collect(Collectors.toSet());
	}

	public Set<Funnel> findFunnels(final Predicate<Funnel> filter) throws InvokerException
	{
		return getFunnels().stream().filter(filter).collect(Collectors.toSet());
	}

	public Set<Funnel> findFunnels(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Funnel.class) final Closure<Boolean> closure)
			throws InvokerException
	{
		return findFunnels(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
		});
	}

	public Funnel getFunnel(final Predicate<Funnel> filter) throws InvokerException
	{
		final Set<Funnel> funnels = findFunnels(filter);

		if (funnels.isEmpty())
		{
			return null;
		}
		else if (funnels.size() == 1)
		{
			return funnels.iterator().next();
		}
		else
		{
			throw new IllegalArgumentException("Filter matched more than one funnel: " + funnels);
		}
	}

	public Funnel getFunnel(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Funnel.class) final Closure<Boolean> closure)
			throws InvokerException
	{
		return getFunnel(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
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

	public Set<Processor> getProcessors() throws InvokerException
	{
		return new GetProcessorsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getProcessors().stream()
				.map(processorEntity -> new Processor(getTransport(), processorEntity)).collect(Collectors.toSet());
	}

	public Set<Processor> findProcessors(final Predicate<Processor> filter) throws InvokerException
	{
		return getProcessors().stream().filter(filter).collect(Collectors.toSet());
	}

	public Set<Processor> findProcessors(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Processor.class) final Closure<Boolean> closure)
			throws InvokerException
	{
		return findProcessors(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
		});
	}

	public Processor getProcessor(final Predicate<Processor> filter) throws InvokerException
	{
		final Set<Processor> processors = findProcessors(filter);

		if (processors.isEmpty())
		{
			return null;
		}
		else if (processors.size() == 1)
		{
			return processors.iterator().next();
		}
		else
		{
			throw new IllegalArgumentException("Filter matched more than one processor: " + processors);
		}
	}

	public Processor getProcessor(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Processor.class) final Closure<Boolean> closure)
			throws InvokerException
	{
		return getProcessor(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
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

	public Set<ProcessGroup> getProcessGroups() throws InvokerException
	{
		return new GetProcessGroupsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getProcessGroups()
				.stream().map(processGroupEntity -> new ProcessGroup(getTransport(), processGroupEntity))
				.collect(Collectors.toSet());
	}

	public Set<ProcessGroup> findProcessGroups(final Predicate<ProcessGroup> filter) throws InvokerException
	{
		return getProcessGroups().stream().filter(filter).collect(Collectors.toSet());
	}

	public Set<ProcessGroup> findProcessGroups(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroup.class) final Closure<Boolean> closure)
			throws InvokerException
	{
		return findProcessGroups(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
		});
	}

	public ProcessGroup getProcessGroup(final Predicate<ProcessGroup> filter) throws InvokerException
	{
		final Set<ProcessGroup> processGroups = findProcessGroups(filter);

		if (processGroups.isEmpty())
		{
			return null;
		}
		else if (processGroups.size() == 1)
		{
			return processGroups.iterator().next();
		}
		else
		{
			throw new IllegalArgumentException("Filter matched more than one process group: " + processGroups);
		}
	}

	public ProcessGroup getProcessGroup(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroup.class) final Closure<Boolean> closure)
			throws InvokerException
	{
		return getProcessGroup(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
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

	public Set<RemoteProcessGroup> getRemoteProcessGroups() throws InvokerException
	{
		return new GetRemoteProcessGroupsInvoker(getTransport(), getVersion()).setId(getId()).invoke()
				.getRemoteProcessGroups().stream()
				.map(remoteProcessGroupEntity -> new RemoteProcessGroup(getTransport(), remoteProcessGroupEntity))
				.collect(Collectors.toSet());
	}

	public Set<RemoteProcessGroup> findRemoteProcessGroups(final Predicate<RemoteProcessGroup> filter)
			throws InvokerException
	{
		return getRemoteProcessGroups().stream().filter(filter).collect(Collectors.toSet());
	}

	public Set<RemoteProcessGroup> findRemoteProcessGroups(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroup.class) final Closure<Boolean> closure)
			throws IllegalArgumentException, InvokerException
	{
		return findRemoteProcessGroups(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
		});
	}

	public RemoteProcessGroup getRemoteProcessGroup(final Predicate<RemoteProcessGroup> filter)
			throws IllegalArgumentException, InvokerException
	{
		final Set<RemoteProcessGroup> remoteProcessGroups = findRemoteProcessGroups(filter);

		if (remoteProcessGroups.isEmpty())
		{
			return null;
		}
		else if (remoteProcessGroups.size() == 1)
		{
			return remoteProcessGroups.iterator().next();
		}
		else
		{
			throw new IllegalArgumentException(
					"Filter matched more than one remote process group: " + remoteProcessGroups);
		}
	}

	public RemoteProcessGroup getRemoteProcessGroup(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroup.class) final Closure<Boolean> closure)
			throws IllegalArgumentException, InvokerException
	{
		return getRemoteProcessGroup(filter ->
		{
			final Closure<Boolean> code = closure.rehydrate(filter, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			return code.call();
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
