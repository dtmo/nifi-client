package com.tibtech.nifi.client;

import java.util.Map;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessorConfigDTO;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;

public abstract class ProcessorBuilder<T extends ProcessorBuilder<T>>
{
	private final ProcessorDTOBuilder processorDTOBuilder;

	public ProcessorBuilder(final ProcessorDTOBuilder processorDTOBuilder)
	{
		this.processorDTOBuilder = processorDTOBuilder;
	}

	public T setPosition(PositionDTO position)
	{
		processorDTOBuilder.setPosition(position);
		return (T) this;
	}

	public T setConfig(ProcessorConfigDTO config)
	{
		processorDTOBuilder.setConfig(config);
		return (T) this;
	}

	public T setDescription(String description)
	{
		processorDTOBuilder.setDescription(description);
		return (T) this;
	}

	public T setInputRequirement(String inputRequirement)
	{
		processorDTOBuilder.setInputRequirement(inputRequirement);
		return (T) this;
	}

	public T setName(String name)
	{
		processorDTOBuilder.setName(name);
		return (T) this;
	}

	public T setPersistsState(Boolean persistsState)
	{
		processorDTOBuilder.setPersistsState(persistsState);
		return (T) this;
	}

	public T setRestricted(Boolean restricted)
	{
		processorDTOBuilder.setRestricted(restricted);
		return (T) this;
	}

	public T setState(String state)
	{
		processorDTOBuilder.setState(state);
		return (T) this;
	}

	public T setStyle(Map<String, String> style)
	{
		processorDTOBuilder.setStyle(style);
		return (T) this;
	}

	public T setType(String type)
	{
		processorDTOBuilder.setType(type);
		return (T) this;
	}
	
	protected ProcessorDTOBuilder getProcessorDTOBuilder()
	{
		return processorDTOBuilder;
	}
}
