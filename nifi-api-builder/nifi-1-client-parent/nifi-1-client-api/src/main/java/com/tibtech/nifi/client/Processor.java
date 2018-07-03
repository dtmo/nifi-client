package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.ProcessorConfigDTO;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.RelationshipDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.processor.DeleteProcessorInvoker;
import com.tibtech.nifi.web.api.processor.GetProcessorInvoker;
import com.tibtech.nifi.web.api.processor.UpdateProcessorInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Processor extends ConnectableComponent<Processor, ProcessorEntity, ProcessorDTOBuilder>
{
	public Processor(final Transport transport, final ProcessorEntity processorEntity)
	{
		super(transport, processorEntity);
	}

	protected ProcessorDTO getProcessorDTO()
	{
		return getComponentEntity().getComponent();
	}

	public String getParentGroupId()
	{
		return getProcessorDTO().getParentGroupId();
	}

	public String getName()
	{
		return getProcessorDTO().getName();
	}

	public String getType()
	{
		return getProcessorDTO().getType();
	}

	public String getState()
	{
		return getProcessorDTO().getState();
	}

	public Map<String, String> getStyle()
	{
		return getProcessorDTO().getStyle();
	}

	public Boolean getSupportsParallelProcessing()
	{
		return getProcessorDTO().getSupportsParallelProcessing();
	}

	public Boolean getPersistsState()
	{
		return getProcessorDTO().getPersistsState();
	}

	public Boolean getRestricted()
	{
		return getProcessorDTO().getRestricted();
	}

	public String getInputRequirement()
	{
		return getProcessorDTO().getInputRequirement();
	}

	public Boolean getSupportsEventDriven()
	{
		return getProcessorDTO().getSupportsEventDriven();
	}

	public Boolean getSupportsBatching()
	{
		return getProcessorDTO().getSupportsBatching();
	}

	public List<RelationshipDTO> getRelationships()
	{
		return getProcessorDTO().getRelationships();
	}

	public ProcessorConfigDTO getConfig()
	{
		return getProcessorDTO().getConfig();
	}

	public Collection<String> getValidationErrors()
	{
		return getProcessorDTO().getValidationErrors();
	}

	public String getDescription()
	{
		return getProcessorDTO().getDescription();
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.PROCESSOR;
	}

	public void delete() throws InvokerException
	{
		new DeleteProcessorInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public Processor refresh() throws InvokerException
	{
		setComponentEntity(new GetProcessorInvoker(getTransport(), 0).setId(getId()).invoke());

		return this;
	}

	@Override
	public Processor update(final Consumer<ProcessorDTOBuilder> configurator) throws InvokerException
	{
		final ProcessorDTOBuilder processorDTOBuilder = ProcessorDTOBuilder.of(getProcessorDTO());

		configurator.accept(processorDTOBuilder);

		setComponentEntity(new UpdateProcessorInvoker(getTransport(), getVersion()).setId(getId())
				.setProcessorEntity(new ProcessorEntityBuilder().setComponent(processorDTOBuilder.build()).build())
				.invoke());

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
