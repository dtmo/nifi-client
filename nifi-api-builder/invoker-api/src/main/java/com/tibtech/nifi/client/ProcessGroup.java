package com.tibtech.nifi.client;

import java.util.function.Function;

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

public class ProcessGroup extends Component
{
	private ProcessGroupDTO processGroupDTO;

	public ProcessGroup(final Transport transport, final ProcessGroupDTO processGroupDTO)
	{
		super(transport, processGroupDTO);

		this.processGroupDTO = processGroupDTO;
	}

	public Processor createProcessor(final Function<ProcessorDTOBuilder, ProcessorDTOBuilder> function)
			throws InvokerException
	{
		final ProcessorDTO processorDTO = function
				.apply(new ProcessorDTOBuilder().setParentGroupId(processGroupDTO.getParentGroupId())).build();
		final ProcessorEntity processorEntity = new CreateProcessorInvoker(getTransport())
				.setId(processorDTO.getParentGroupId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(processorDTO).build()).invoke();

		return new Processor(getTransport(), processorEntity.getComponent());
	}

	public ProcessGroup createProcessGroup(final Function<ProcessGroupDTOBuilder, ProcessGroupDTOBuilder> function)
			throws InvokerException
	{
		final ProcessGroupDTO childProcessGroup = function
				.apply(new ProcessGroupDTOBuilder().setParentGroupId(processGroupDTO.getParentGroupId())).build();

		final ProcessGroupEntity processGroupEntity = new CreateProcessGroupInvoker(getTransport())
				.setId(childProcessGroup.getParentGroupId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder().setComponent(childProcessGroup).build())
				.invoke();

		return new ProcessGroup(getTransport(), processGroupEntity.getComponent());
	}

	public void update(final Function<ProcessGroupDTOBuilder, ProcessGroupDTOBuilder> function) throws InvokerException
	{
		final ProcessGroupDTO updatedProcessGroupDTO = function.apply(ProcessGroupDTOBuilder.of(processGroupDTO))
				.build();

		final ProcessGroupEntity processGroupEntity = new UpdateProcessGroupInvoker(getTransport())
				.setId(updatedProcessGroupDTO.getId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder().setComponent(updatedProcessGroupDTO).build())
				.invoke();

		this.processGroupDTO = processGroupEntity.getComponent();
	}

	public void refresh() throws InvokerException
	{
		final ProcessGroupEntity processGroupEntity = new GetProcessGroupInvoker(getTransport()).setId(getId())
				.invoke();
		this.processGroupDTO = processGroupEntity.getComponent();
	}

	public void delete() throws InvokerException
	{
		new RemoveProcessGroupInvoker(getTransport()).setId(getId()).invoke();
	}
}
