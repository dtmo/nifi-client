package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.nifi.controller.service.ControllerServiceState;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

import com.tibtech.nifi.web.api.controllerservice.GetControllerServiceInvoker;
import com.tibtech.nifi.web.api.controllerservice.RemoveControllerServiceInvoker;
import com.tibtech.nifi.web.api.controllerservice.UpdateControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ControllerService
		extends UpdatableComponent<ControllerService, ControllerServiceEntity, ControllerServiceDTOBuilder>
{
	public ControllerService(final Transport transport, final ControllerServiceEntity controllerServiceEntity)
	{
		super(transport, controllerServiceEntity);
	}

	protected ControllerServiceDTO getControllerServiceDTO()
	{
		return getComponentEntity().getComponent();
	}

	public String getParentGroupId()
	{
		return getControllerServiceDTO().getParentGroupId();
	}

	public String getName()
	{
		return getControllerServiceDTO().getName();
	}

	public String getType()
	{
		return getControllerServiceDTO().getType();
	}

	public String getComments()
	{
		return getControllerServiceDTO().getComments();
	}

	public Boolean getPersistsState()
	{
		return getControllerServiceDTO().getPersistsState();
	}

	public Boolean getRestricted()
	{
		return getControllerServiceDTO().getRestricted();
	}

	public String getState()
	{
		return getControllerServiceDTO().getState();
	}

	public Map<String, String> getProperties()
	{
		return getControllerServiceDTO().getProperties();
	}

	public Map<String, PropertyDescriptorDTO> getDescriptors()
	{
		return getControllerServiceDTO().getDescriptors();
	}

	public String getCustomUiUrl()
	{
		return getControllerServiceDTO().getCustomUiUrl();
	}

	public String getAnnotationData()
	{
		return getControllerServiceDTO().getAnnotationData();
	}

	public Set<ControllerServiceReferencingComponentEntity> getReferencingComponents()
	{
		return getControllerServiceDTO().getReferencingComponents();
	}

	public Collection<String> getValidationErrors()
	{
		return getControllerServiceDTO().getValidationErrors();
	}

	@Override
	public ControllerService refresh() throws InvokerException
	{
		setComponentEntity(new GetControllerServiceInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	@Override
	public ControllerService update(
			final Function<ControllerServiceDTOBuilder, ControllerServiceDTOBuilder> configurator)
			throws InvokerException
	{
		setComponentEntity(new UpdateControllerServiceInvoker(getTransport(), getVersion()).setId(getId())
				.setControllerServiceEntity(new ControllerServiceEntityBuilder().setId(getId())
						.setComponent(
								configurator.apply(ControllerServiceDTOBuilder.of(getControllerServiceDTO())).build())
						.build())
				.invoke());

		return this;
	}

	@Override
	public ControllerService update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveControllerServiceInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	public void enable() throws InvokerException
	{
		setEnabled(true);
	}

	public void disable() throws InvokerException
	{
		setEnabled(false);
	}

	public void setEnabled(final boolean enabled) throws InvokerException
	{
		final String controllerServiceState = enabled ? ControllerServiceState.ENABLED.name()
				: ControllerServiceState.DISABLED.name();

		update(c -> c.setState(controllerServiceState));
	}
}
