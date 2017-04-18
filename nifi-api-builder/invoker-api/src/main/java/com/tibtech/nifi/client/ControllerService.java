package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.controller.service.ControllerServiceState;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;

import com.tibtech.nifi.web.api.controller.services.GetControllerServiceInvoker;
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
