package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.nifi.controller.service.ControllerServiceState;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

import com.tibtech.nifi.web.api.controller.services.GetControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.services.RemoveControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.services.UpdateControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;

public class ControllerService
{
	private final Transport transport;

	private ControllerServiceDTO controllerServiceDTO;

	public ControllerService(final Transport transport, final ControllerServiceDTO controllerServiceDTO)
	{
		this.transport = transport;
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

	public void update(final Function<ControllerServiceDTOBuilder, ControllerServiceDTOBuilder> function)
			throws InvokerException
	{
		this.controllerServiceDTO = new UpdateControllerServiceInvoker(transport).setId(controllerServiceDTO.getId())
				.setControllerServiceEntity(new ControllerServiceEntityBuilder().setId(controllerServiceDTO.getId())
						.setComponent(function.apply(ControllerServiceDTOBuilder.of(controllerServiceDTO)).build())
						.build())
				.invoke().getComponent();
	}

	public void enable() throws InvokerException
	{
		setEnabled(true);
	}
	
	public void remove() throws InvokerException
	{
		new RemoveControllerServiceInvoker(transport).setId(getId()).invoke();
	}

	public void disable() throws InvokerException
	{
		setEnabled(false);
	}

	public void setEnabled(final boolean enabled) throws InvokerException
	{
		final String controllerServiceState = enabled ? ControllerServiceState.ENABLED.name()
				: ControllerServiceState.DISABLED.name();

		ControllerServiceDTO updatedControllerServiceDTO = new UpdateControllerServiceInvoker(transport)
				.setId(controllerServiceDTO
						.getId())
				.setControllerServiceEntity(new ControllerServiceEntityBuilder().setId(controllerServiceDTO.getId())
						.setComponent(ControllerServiceDTOBuilder.of(controllerServiceDTO)
								.setState(controllerServiceState).build())
						.build())
				.invoke().getComponent();

		while (ControllerServiceState.ENABLED.name().equalsIgnoreCase(updatedControllerServiceDTO.getState()) == false)
		{
			updatedControllerServiceDTO = new GetControllerServiceInvoker(transport).setId(controllerServiceDTO.getId())
					.invoke().getComponent();
		}

		this.controllerServiceDTO = updatedControllerServiceDTO;
	}
}
