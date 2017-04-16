package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessorConfigDTO;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.RelationshipDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.processors.DeleteProcessorInvoker;
import com.tibtech.nifi.web.api.processors.GetProcessorInvoker;

public class Processor extends Component
{
	private ProcessorDTO processorDTO;

	public Processor(final Transport transport, final ProcessorDTO processorDTO)
	{
		super(transport, processorDTO);

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

	public ProcessorUpdater startUpdate()
	{
		return new ProcessorUpdater(getTransport(), this, processorDTO);
	}

	protected void setProcessorDTO(final ProcessorDTO processorDTO)
	{
		this.processorDTO = processorDTO;
	}

	public void refresh() throws InvokerException
	{
		final ProcessorEntity processorEntity = new GetProcessorInvoker(getTransport()).setId(processorDTO.getId())
				.invoke();
		this.processorDTO = processorEntity.getComponent();
	}

	public void delete() throws InvokerException
	{
		new DeleteProcessorInvoker(getTransport()).setId(processorDTO.getId()).invoke();
	}
}
