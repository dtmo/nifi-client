package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.dto.ReportingTaskDTO;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

import com.tibtech.nifi.web.api.dto.ReportingTaskDTOBuilder;
import com.tibtech.nifi.web.api.entity.ReportingTaskEntityBuilder;
import com.tibtech.nifi.web.api.reporting.tasks.GetReportingTaskInvoker;
import com.tibtech.nifi.web.api.reporting.tasks.RemoveReportingTaskInvoker;
import com.tibtech.nifi.web.api.reporting.tasks.UpdateReportingTaskInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ReportingTask extends EditableComponent<ReportingTask, ReportingTaskDTOBuilder>
{
	private ReportingTaskDTO reportingTaskDTO;

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

	@Override
	public void delete() throws InvokerException
	{
		new RemoveReportingTaskInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public ReportingTask refresh() throws InvokerException
	{
		reportingTaskDTO = new GetReportingTaskInvoker(getTransport(), getVersion()).setId(getId()).invoke()
				.getComponent();
		return this;
	}

	@Override
	public ReportingTask update(final Function<ReportingTaskDTOBuilder, ReportingTaskDTOBuilder> configurator)
			throws InvokerException
	{
		final ReportingTaskEntity reportingTaskEntity = new UpdateReportingTaskInvoker(getTransport(), getVersion())
				.setId(getId())
				.setReportingTaskEntity(new ReportingTaskEntityBuilder()
						.setComponent(configurator.apply(new ReportingTaskDTOBuilder().setId(getId())).build()).build())
				.invoke();
		setVersion(reportingTaskEntity.getRevision().getVersion());
		reportingTaskDTO = reportingTaskEntity.getComponent();
		return this;
	}

	@Override
	public ReportingTask update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReportingTaskDTOBuilder.class) final Closure<ReportingTaskDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}
}
