package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.CreateProcessorInvoker;

public class ProcessorUpdater extends ProcessorBuilder<ProcessorUpdater>
{
	private final Transport transport;

	private final Processor processorToUpdate;

	public ProcessorUpdater(final Transport transport, final Processor processorToUpdate,
			final ProcessorDTO processorDTO)
	{
		super(ProcessorDTOBuilder.of(processorDTO));

		this.transport = transport;
		this.processorToUpdate = processorToUpdate;
	}

	public ProcessorUpdater setParentGroupId(String parentGroupId)
	{
		getProcessorDTOBuilder().setParentGroupId(parentGroupId);
		return this;
	}

	public void commit() throws InvokerException
	{
		final ProcessorDTO processorDTO = getProcessorDTOBuilder().build();

		final ProcessorEntity processorEntity = new CreateProcessorInvoker(transport)
				.setId(processorDTO.getParentGroupId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(processorDTO).build()).invoke();

		processorToUpdate.setProcessorDTO(processorEntity.getComponent());
	}
}
