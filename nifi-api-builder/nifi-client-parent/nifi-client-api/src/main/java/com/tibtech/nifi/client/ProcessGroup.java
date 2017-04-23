package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.CreateProcessGroupInvoker;
import com.tibtech.nifi.web.api.process.groups.CreateProcessorInvoker;
import com.tibtech.nifi.web.api.process.groups.GetProcessGroupInvoker;
import com.tibtech.nifi.web.api.process.groups.RemoveProcessGroupInvoker;
import com.tibtech.nifi.web.api.process.groups.UpdateProcessGroupInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ProcessGroup extends EditableComponent<ProcessGroup, ProcessGroupDTOBuilder>
{
	private ProcessGroupDTO processGroupDTO;

	public ProcessGroup(final Transport transport, final long version, final ProcessGroupDTO processGroupDTO)
	{
		super(transport, version);

		this.processGroupDTO = processGroupDTO;
	}

	public String getId()
	{
		return processGroupDTO.getId();
	}

	public String getParentGroupId()
	{
		return processGroupDTO.getParentGroupId();
	}

	public String getName()
	{
		return processGroupDTO.getName();
	}

	public PositionDTO getPosition()
	{
		return processGroupDTO.getPosition();
	}

	public String getComments()
	{
		return processGroupDTO.getComments();
	}

	public FlowSnippetDTO getContents()
	{
		return processGroupDTO.getContents();
	}

	public Integer getInputPortCount()
	{
		return processGroupDTO.getInputPortCount();
	}

	public Integer getInvalidCount()
	{
		return processGroupDTO.getInvalidCount();
	}

	public Integer getOutputPortCount()
	{
		return processGroupDTO.getOutputPortCount();
	}

	public Integer getRunningCount()
	{
		return processGroupDTO.getRunningCount();
	}

	public Integer getStoppedCount()
	{
		return processGroupDTO.getStoppedCount();
	}

	public Integer getDisabledCount()
	{
		return processGroupDTO.getDisabledCount();
	}

	public Integer getActiveRemotePortCount()
	{
		return processGroupDTO.getActiveRemotePortCount();
	}

	public Integer getInactiveRemotePortCount()
	{
		return processGroupDTO.getInactiveRemotePortCount();
	}

	public Processor createProcessor(final Function<ProcessorDTOBuilder, ProcessorDTOBuilder> function)
			throws InvokerException
	{
		final ProcessorDTO processorDTO = function
				.apply(new ProcessorDTOBuilder().setParentGroupId(processGroupDTO.getId())).build();
		final ProcessorEntity processorEntity = new CreateProcessorInvoker(getTransport(), 0)
				.setId(processorDTO.getParentGroupId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(processorDTO).build()).invoke();

		return new Processor(getTransport(), processorEntity.getRevision().getVersion(),
				processorEntity.getComponent());
	}

	public Processor createProcessor(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessor(p ->
		{
			final Closure<ProcessorDTOBuilder> code = closure.rehydrate(p, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return p;
		});
	}

	public ProcessGroup createProcessGroup(final Function<ProcessGroupDTOBuilder, ProcessGroupDTOBuilder> function)
			throws InvokerException
	{
		final ProcessGroupDTO childProcessGroup = function
				.apply(new ProcessGroupDTOBuilder().setParentGroupId(processGroupDTO.getParentGroupId())).build();

		final ProcessGroupEntity processGroupEntity = new CreateProcessGroupInvoker(getTransport(), 0)
				.setId(childProcessGroup.getParentGroupId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder().setComponent(childProcessGroup).build())
				.invoke();

		return new ProcessGroup(getTransport(), processGroupEntity.getRevision().getVersion(),
				processGroupEntity.getComponent());
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public ProcessGroup refresh() throws InvokerException
	{
		this.processGroupDTO = new GetProcessGroupInvoker(getTransport(), 0).setId(getId()).invoke().getComponent();
		return this;
	}

	@Override
	public ProcessGroup update(final Function<ProcessGroupDTOBuilder, ProcessGroupDTOBuilder> function)
			throws InvokerException
	{
		final ProcessGroupDTO updatedProcessGroupDTO = function.apply(ProcessGroupDTOBuilder.of(processGroupDTO))
				.build();

		final ProcessGroupEntity processGroupEntity = new UpdateProcessGroupInvoker(getTransport(), getVersion())
				.setId(updatedProcessGroupDTO.getId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder().setComponent(updatedProcessGroupDTO).build())
				.invoke();

		this.setVersion(processGroupEntity.getRevision().getVersion());

		this.processGroupDTO = processGroupEntity.getComponent();

		return this;
	}

	@Override
	public ProcessGroup update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}
}
