package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.PositionDTO;

import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;

public abstract class ProcessGroupBuilder<T extends ProcessGroupBuilder<T>>
{
	private final ProcessGroupDTOBuilder processGroupDTOBuilder;

	public ProcessGroupBuilder(final ProcessGroupDTOBuilder processGroupDTOBuilder)
	{
		this.processGroupDTOBuilder = processGroupDTOBuilder;
	}

	public T setPosition(PositionDTO position)
	{
		processGroupDTOBuilder.setPosition(position);
		return (T) this;
	}

	public T setComments(String comments)
	{
		processGroupDTOBuilder.setComments(comments);
		return (T) this;
	}

	public T setContents(FlowSnippetDTO contents)
	{
		processGroupDTOBuilder.setContents(contents);
		return (T) this;
	}

	public T setName(String name)
	{
		processGroupDTOBuilder.setName(name);
		return (T) this;
	}

	protected ProcessGroupDTOBuilder getProcessGroupDTOBuilder()
	{
		return processGroupDTOBuilder;
	}
}
