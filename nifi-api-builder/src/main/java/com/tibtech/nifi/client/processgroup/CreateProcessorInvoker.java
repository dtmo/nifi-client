package com.tibtech.nifi.client.processgroup;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;

public class CreateProcessorInvoker extends ComponentEntityInvoker<ProcessorEntity>
{
	private String groupId;
	private ProcessorDTO component;
	private String inputRequirement;
	private ProcessorStatusDTO status;

	public CreateProcessorInvoker(final Transport transport)
	{
		super(transport);
	}

	@Override
	public ProcessorEntity invoke() throws InvokerException
	{
		final ProcessorEntity processorEntity = new ProcessorEntity();

		setEntityValues(processorEntity);

		processorEntity.setComponent(component);
		processorEntity.setInputRequirement(inputRequirement);
		processorEntity.setStatus(status);

		final Entity<ProcessorEntity> jsonEntity = Entity.json(processorEntity);

		final Response response = getBaseWebTarget().path("process-groups").path(groupId).path("processors")
				.request(MediaType.APPLICATION_JSON).post(jsonEntity);

		return handleComponentEntityResponse(response, ProcessorEntity.class);
	}
}
