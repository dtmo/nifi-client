package com.tibtech.nifi.client;

import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.CreateProcessorInvoker;

public class ProcessorCreator extends ProcessorBuilder
{
	private final ProcessGroup processGroup;

	public ProcessorCreator(final Transport transport, final ProcessGroup processGroup)
	{
		super(transport, new ProcessorDTOBuilder());
		
		this.processGroup = processGroup;
	}

	@Override
	public Processor commit() throws InvokerException
	{
		final ProcessorEntity processorEntity = new CreateProcessorInvoker(getTransport())
				.setId(processGroup.getId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(getProcessorDTOBuilder().build()).build())
				.invoke();

		final Processor processor = new Processor(getTransport(), processorEntity.getComponent());
		return processor;
	}
}
