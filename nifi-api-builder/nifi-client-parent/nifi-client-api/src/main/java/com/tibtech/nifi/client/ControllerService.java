package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.nifi.controller.service.ControllerServiceState;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

import com.tibtech.nifi.web.api.controller.services.GetControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.services.RemoveControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.services.UpdateControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ControllerService extends EditableComponent<ControllerService, ControllerServiceDTOBuilder>
{
	private ControllerServiceDTO controllerServiceDTO;

	public ControllerService(final Transport transport, final long version,
			final ControllerServiceDTO controllerServiceDTO)
	{
		super(transport, version);

		this.controllerServiceDTO = controllerServiceDTO;
	}

	public String getId()
	{
		return controllerServiceDTO.getId();
	}

	public String getParentGroupId()
	{
		return controllerServiceDTO.getParentGroupId();
	}

	public String getName()
	{
		return controllerServiceDTO.getName();
	}

	public PositionDTO getPosition()
	{
		return controllerServiceDTO.getPosition();
	}

	public String getType()
	{
		return controllerServiceDTO.getType();
	}

	public String getComments()
	{
		return controllerServiceDTO.getComments();
	}

	public Boolean getPersistsState()
	{
		return controllerServiceDTO.getPersistsState();
	}

	public Boolean getRestricted()
	{
		return controllerServiceDTO.getRestricted();
	}

	public String getState()
	{
		return controllerServiceDTO.getState();
	}

	public Map<String, String> getProperties()
	{
		return controllerServiceDTO.getProperties();
	}

	public Map<String, PropertyDescriptorDTO> getDescriptors()
	{
		return controllerServiceDTO.getDescriptors();
	}

	public String getCustomUiUrl()
	{
		return controllerServiceDTO.getCustomUiUrl();
	}

	public String getAnnotationData()
	{
		return controllerServiceDTO.getAnnotationData();
	}

	public Set<ControllerServiceReferencingComponentEntity> getReferencingComponents()
	{
		return controllerServiceDTO.getReferencingComponents();
	}

	public Collection<String> getValidationErrors()
	{
		return controllerServiceDTO.getValidationErrors();
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveControllerServiceInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}

	@Override
	public ControllerService refresh() throws InvokerException
	{
		controllerServiceDTO = new GetControllerServiceInvoker(getTransport(), getVersion()).setId(getId()).invoke()
				.getComponent();
		return this;
	}

	@Override
	public ControllerService update(
			final Function<ControllerServiceDTOBuilder, ControllerServiceDTOBuilder> configurator)
			throws InvokerException
	{
		final ControllerServiceEntity controllerServiceEntity = new UpdateControllerServiceInvoker(getTransport(),
				getVersion())
						.setId(controllerServiceDTO.getId())
						.setControllerServiceEntity(
								new ControllerServiceEntityBuilder().setId(controllerServiceDTO.getId())
										.setComponent(configurator
												.apply(ControllerServiceDTOBuilder.of(controllerServiceDTO)).build())
										.build())
						.invoke();

		this.setVersion(controllerServiceEntity.getRevision().getVersion());

		this.controllerServiceDTO = controllerServiceEntity.getComponent();

		return this;
	}

	@Override
	public ControllerService update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
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
