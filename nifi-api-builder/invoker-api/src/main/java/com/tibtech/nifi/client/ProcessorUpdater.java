package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.CreateProcessorInvoker;

public class ProcessorUpdater extends ProcessorBuilder
{
	public ProcessorUpdater(final Transport transport, final ProcessorDTO processorDTO)
	{
		super(transport, ProcessorDTOBuilder.of(processorDTO));
	}

	@Override
	public Processor commit() throws InvokerException
	{
		final ProcessorDTO processorDTO = getProcessorDTOBuilder().build();

		final ProcessorEntity processorEntity = new CreateProcessorInvoker(getTransport())
				.setId(processorDTO.getParentGroupId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(processorDTO).build()).invoke();

		return new Processor(getTransport(), processorEntity.getComponent());
	}
}
