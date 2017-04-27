package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessorConfigDTO;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.RelationshipDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateProcessorInvoker;
import com.tibtech.nifi.web.api.processor.DeleteProcessorInvoker;
import com.tibtech.nifi.web.api.processor.GetProcessorInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Processor extends ConnectableComponent<Processor, ProcessorDTOBuilder>
{
	private ProcessorDTO processorDTO;

	public Processor(final Transport transport, final long version, final ProcessorDTO processorDTO)
	{
		super(transport, version);

		this.processorDTO = processorDTO;
	}

	public String getId()
	{
		return processorDTO.getId();
	}

	public String getParentGroupId()
	{
		return processorDTO.getParentGroupId();
	}

	public String getName()
	{
		return processorDTO.getName();
	}

	public PositionDTO getPosition()
	{
		return processorDTO.getPosition();
	}

	public String getType()
	{
		return processorDTO.getType();
	}

	public String getState()
	{
		return processorDTO.getState();
	}

	public Map<String, String> getStyle()
	{
		return processorDTO.getStyle();
	}

	public Boolean getSupportsParallelProcessing()
	{
		return processorDTO.getSupportsParallelProcessing();
	}

	public Boolean getPersistsState()
	{
		return processorDTO.getPersistsState();
	}

	public Boolean getRestricted()
	{
		return processorDTO.getRestricted();
	}

	public String getInputRequirement()
	{
		return processorDTO.getInputRequirement();
	}

	public Boolean getSupportsEventDriven()
	{
		return processorDTO.getSupportsEventDriven();
	}

	public Boolean getSupportsBatching()
	{
		return processorDTO.getSupportsBatching();
	}

	public List<RelationshipDTO> getRelationships()
	{
		return processorDTO.getRelationships();
	}

	public ProcessorConfigDTO getConfig()
	{
		return processorDTO.getConfig();
	}

	public Collection<String> getValidationErrors()
	{
		return processorDTO.getValidationErrors();
	}

	public String getDescription()
	{
		return processorDTO.getDescription();
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.PROCESSOR;
	}

	@Override
	public void delete() throws InvokerException
	{
		new DeleteProcessorInvoker(getTransport(), getVersion()).setId(processorDTO.getId()).invoke();
	}

	@Override
	public Processor refresh() throws InvokerException
	{
		this.processorDTO = new GetProcessorInvoker(getTransport(), 0).setId(processorDTO.getId()).invoke()
				.getComponent();
		return this;
	}

	@Override
	public Processor update(final Function<ProcessorDTOBuilder, ProcessorDTOBuilder> function) throws InvokerException
	{
		final ProcessorDTO updatedProcessorDTO = function.apply(ProcessorDTOBuilder.of(processorDTO)).build();

		final ProcessorEntity processorEntity = new CreateProcessorInvoker(getTransport(), 0)
				.setId(updatedProcessorDTO.getParentGroupId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(updatedProcessorDTO).build()).invoke();

		this.setVersion(processorEntity.getRevision().getVersion());
		this.processorDTO = processorEntity.getComponent();

		return this;
	}

	@Override
	public Processor update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}
}
