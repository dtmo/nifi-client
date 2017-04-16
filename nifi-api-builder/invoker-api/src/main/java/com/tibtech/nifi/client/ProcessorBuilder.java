package com.tibtech.nifi.client;

import java.util.List;
import java.util.Map;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessorConfigDTO;
import org.apache.nifi.web.api.dto.RelationshipDTO;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;

public abstract class ProcessorBuilder extends AbstractComponentBuilder<ProcessorBuilder>
{
	private final ProcessorDTOBuilder processorDTOBuilder;

	public ProcessorBuilder(final Transport transport, final ProcessorDTOBuilder processorDTOBuilder)
	{
		super(transport);
		
		this.processorDTOBuilder = processorDTOBuilder;
	}

	public PositionDTO getPosition()
	{
		return processorDTOBuilder.getPosition();
	}

	public ProcessorConfigDTO getConfig()
	{
		return processorDTOBuilder.getConfig();
	}

	public ProcessorBuilder setPosition(PositionDTO position)
	{
		processorDTOBuilder.setPosition(position);
		return this;
	}

	public ProcessorBuilder setConfig(ProcessorConfigDTO config)
	{
		processorDTOBuilder.setConfig(config);
		return this;
	}

	public String getDescription()
	{
		return processorDTOBuilder.getDescription();
	}

	public ProcessorBuilder setDescription(String description)
	{
		processorDTOBuilder.setDescription(description);
		return this;
	}

	public String getInputRequirement()
	{
		return processorDTOBuilder.getInputRequirement();
	}

	public ProcessorBuilder setInputRequirement(String inputRequirement)
	{
		processorDTOBuilder.setInputRequirement(inputRequirement);
		return this;
	}

	public String getName()
	{
		return processorDTOBuilder.getName();
	}

	public ProcessorBuilder setName(String name)
	{
		processorDTOBuilder.setName(name);
		return this;
	}

	public Boolean getPersistsState()
	{
		return processorDTOBuilder.getPersistsState();
	}

	public ProcessorBuilder setPersistsState(Boolean persistsState)
	{
		processorDTOBuilder.setPersistsState(persistsState);
		return this;
	}

	public List<RelationshipDTO> getRelationships()
	{
		return processorDTOBuilder.getRelationships();
	}

	public ProcessorBuilder setRelationships(List<RelationshipDTO> relationships)
	{
		processorDTOBuilder.setRelationships(relationships);
		return this;
	}

	public Boolean getRestricted()
	{
		return processorDTOBuilder.getRestricted();
	}

	public ProcessorBuilder setRestricted(Boolean restricted)
	{
		processorDTOBuilder.setRestricted(restricted);
		return this;
	}

	public String getState()
	{
		return processorDTOBuilder.getState();
	}

	public ProcessorBuilder setState(String state)
	{
		processorDTOBuilder.setState(state);
		return this;
	}

	public Map<String, String> getStyle()
	{
		return processorDTOBuilder.getStyle();
	}

	public ProcessorBuilder setStyle(Map<String, String> style)
	{
		processorDTOBuilder.setStyle(style);
		return this;
	}

	public Boolean getSupportsBatching()
	{
		return processorDTOBuilder.getSupportsBatching();
	}

	public ProcessorBuilder setSupportsBatching(Boolean supportsBatching)
	{
		processorDTOBuilder.setSupportsBatching(supportsBatching);
		return this;
	}

	public Boolean getSupportsEventDriven()
	{
		return processorDTOBuilder.getSupportsEventDriven();
	}

	public ProcessorBuilder setSupportsEventDriven(Boolean supportsEventDriven)
	{
		processorDTOBuilder.setSupportsEventDriven(supportsEventDriven);
		return this;
	}

	public Boolean getSupportsParallelProcessing()
	{
		return processorDTOBuilder.getSupportsParallelProcessing();
	}

	public ProcessorBuilder setSupportsParallelProcessing(Boolean supportsParallelProcessing)
	{
		processorDTOBuilder.setSupportsParallelProcessing(supportsParallelProcessing);
		return this;
	}

	public String getType()
	{
		return processorDTOBuilder.getType();
	}

	public ProcessorBuilder setType(String type)
	{
		processorDTOBuilder.setType(type);
		return this;
	}
	
	protected ProcessorDTOBuilder getProcessorDTOBuilder()
	{
		return processorDTOBuilder;
	}

	public abstract Processor commit() throws InvokerException;
}
