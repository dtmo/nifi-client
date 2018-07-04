package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.dto.ReportingTaskDTO;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

import com.tibtech.nifi.web.api.dto.ReportingTaskDTOBuilder;
import com.tibtech.nifi.web.api.entity.ReportingTaskEntityBuilder;
import com.tibtech.nifi.web.api.reportingtask.GetReportingTaskInvoker;
import com.tibtech.nifi.web.api.reportingtask.RemoveReportingTaskInvoker;
import com.tibtech.nifi.web.api.reportingtask.UpdateReportingTaskInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ReportingTask extends UpdatableComponent<ReportingTask, ReportingTaskEntity, ReportingTaskDTOBuilder>
{
	public ReportingTask(final Transport transport, final ReportingTaskEntity reportingTaskEntity)
	{
		super(transport, reportingTaskEntity);
	}

	protected ReportingTaskDTO getReportingTaskDTO()
	{
		return getComponentEntity().getComponent();
	}

	public String getId()
	{
		return getReportingTaskDTO().getId();
	}

	public String getParentGroupId()
	{
		return getReportingTaskDTO().getParentGroupId();
	}

	public String getName()
	{
		return getReportingTaskDTO().getName();
	}

	public PositionDTO getPosition()
	{
		return getReportingTaskDTO().getPosition();
	}

	public String getComments()
	{
		return getReportingTaskDTO().getComments();
	}

	public String getType()
	{
		return getReportingTaskDTO().getType();
	}

	public String getSchedulingPeriod()
	{
		return getReportingTaskDTO().getSchedulingPeriod();
	}

	public Boolean getPersistsState()
	{
		return getReportingTaskDTO().getPersistsState();
	}

	public Boolean getRestricted()
	{
		return getReportingTaskDTO().getRestricted();
	}

	public String getState()
	{
		return getReportingTaskDTO().getState();
	}

	public String getSchedulingStrategy()
	{
		return getReportingTaskDTO().getSchedulingStrategy();
	}

	public Map<String, String> getProperties()
	{
		return getReportingTaskDTO().getProperties();
	}

	public Map<String, PropertyDescriptorDTO> getDescriptors()
	{
		return getReportingTaskDTO().getDescriptors();
	}

	public String getCustomUiUrl()
	{
		return getReportingTaskDTO().getCustomUiUrl();
	}

	public String getAnnotationData()
	{
		return getReportingTaskDTO().getAnnotationData();
	}

	public Collection<String> getValidationErrors()
	{
		return getReportingTaskDTO().getValidationErrors();
	}

	public Map<String, String> getDefaultSchedulingPeriod()
	{
		return getReportingTaskDTO().getDefaultSchedulingPeriod();
	}

	public Integer getActiveThreadCount()
	{
		return getReportingTaskDTO().getActiveThreadCount();
	}

	@Override
	public ReportingTask refresh() throws InvokerException
	{
		setComponentEntity(new GetReportingTaskInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	@Override
	public ReportingTask update(final Consumer<ReportingTaskDTOBuilder> configurator) throws InvokerException
	{
		final ReportingTaskDTOBuilder reportingTaskDTOBuilder = ReportingTaskDTOBuilder.of(getReportingTaskDTO());

		configurator.accept(reportingTaskDTOBuilder);

		setComponentEntity(new UpdateReportingTaskInvoker(getTransport(), getVersion()).setId(getId())
				.setReportingTaskEntity(
						new ReportingTaskEntityBuilder().setComponent(reportingTaskDTOBuilder.build()).build())
				.invoke());

		return this;
	}

	@Override
	public ReportingTask update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReportingTaskDTOBuilder.class) final Closure<ReportingTaskDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveReportingTaskInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}
}
