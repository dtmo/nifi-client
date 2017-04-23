package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Map;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.dto.ReportingTaskDTO;

import com.tibtech.nifi.web.api.reporting.tasks.RemoveReportingTaskInvoker;

public class ReportingTask extends Component
{
	private final ReportingTaskDTO reportingTaskDTO;

	public ReportingTask(final Transport transport, final long version, final ReportingTaskDTO reportingTaskDTO)
	{
		super(transport, version);

		this.reportingTaskDTO = reportingTaskDTO;
	}

	public String getId()
	{
		return reportingTaskDTO.getId();
	}

	public String getParentGroupId()
	{
		return reportingTaskDTO.getParentGroupId();
	}

	public String getName()
	{
		return reportingTaskDTO.getName();
	}

	public PositionDTO getPosition()
	{
		return reportingTaskDTO.getPosition();
	}

	public String getComments()
	{
		return reportingTaskDTO.getComments();
	}

	public String getType()
	{
		return reportingTaskDTO.getType();
	}

	public String getSchedulingPeriod()
	{
		return reportingTaskDTO.getSchedulingPeriod();
	}

	public Boolean getPersistsState()
	{
		return reportingTaskDTO.getPersistsState();
	}

	public Boolean getRestricted()
	{
		return reportingTaskDTO.getRestricted();
	}

	public String getState()
	{
		return reportingTaskDTO.getState();
	}

	public String getSchedulingStrategy()
	{
		return reportingTaskDTO.getSchedulingStrategy();
	}

	public Map<String, String> getProperties()
	{
		return reportingTaskDTO.getProperties();
	}

	public Map<String, PropertyDescriptorDTO> getDescriptors()
	{
		return reportingTaskDTO.getDescriptors();
	}

	public String getCustomUiUrl()
	{
		return reportingTaskDTO.getCustomUiUrl();
	}

	public String getAnnotationData()
	{
		return reportingTaskDTO.getAnnotationData();
	}

	public Collection<String> getValidationErrors()
	{
		return reportingTaskDTO.getValidationErrors();
	}

	public Map<String, String> getDefaultSchedulingPeriod()
	{
		return reportingTaskDTO.getDefaultSchedulingPeriod();
	}

	public Integer getActiveThreadCount()
	{
		return reportingTaskDTO.getActiveThreadCount();
	}

	public void delete() throws InvokerException
	{
		new RemoveReportingTaskInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}
}
