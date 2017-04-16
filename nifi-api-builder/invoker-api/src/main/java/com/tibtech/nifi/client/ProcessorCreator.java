package com.tibtech.nifi.client;

import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.CreateProcessorInvoker;

public class ProcessorCreator extends ProcessorBuilder<ProcessorCreator>
{
	private final Transport transport;
	private final ProcessGroup parentProcessGroup;

	public ProcessorCreator(final Transport transport, final ProcessGroup parentProcessGroup)
	{
		super(new ProcessorDTOBuilder());

		this.transport = transport;
		this.parentProcessGroup = parentProcessGroup;
	}

	public Processor create() throws InvokerException
	{
		final ProcessorEntity processorEntity = new CreateProcessorInvoker(transport).setId(parentProcessGroup.getId())
				.setProcessorEntity(new ProcessorEntityBuilder()
						.setComponent(getProcessorDTOBuilder().setParentGroupId(parentProcessGroup.getId()).build()).build())
				.invoke();

		return new Processor(transport, processorEntity.getComponent());
	}
}
