package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.controllerservice.GetControllerServiceInvoker;
import com.tibtech.nifi.web.api.controllerservice.RemoveControllerServiceInvoker;
import com.tibtech.nifi.web.api.controllerservice.UpdateControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.ControllerServiceReferencingComponentDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;

/**
 * Controller service represents a NiFi flow controller service which is an
 * extension point that, after being added and configured by a DFM in the User
 * Interface, will start up when NiFi starts up and provide information for use
 * by other components (such as processors or other controller services).
 */
public class ControllerService extends AbstractComponent<ControllerServiceEntity>
        implements Refreshable<ControllerService>, Updatable<ControllerService, ControllerServiceDTOBuilder>, Deletable
{
    /**
     * Constructs a new instance of ControllerService.
     *
     * @param controller              The controller to which the controller service
     *                                belongs.
     * @param controllerServiceEntity The entity that represents the controller
     *                                service.
     */
    public ControllerService(final Controller controller, final ControllerServiceEntity controllerServiceEntity)
    {
        super(controller, controllerServiceEntity);
    }

    /**
     * Returns the DTO that describes the controller service.
     *
     * @return The DTO that describes the controller service.
     */
    public ControllerServiceDTO getControllerServiceDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getControllerServiceDTO().getId();
    }

    /**
     * Returns the controller service name.
     *
     * @return The controller service name.
     */
    public String getName()
    {
        return getControllerServiceDTO().getName();
    }

    /**
     * Returns the fully qualified type of the controller service.
     *
     * @return The fully qualified type of the controller service.
     */
    public String getType()
    {
        return getControllerServiceDTO().getType();
    }

    /**
     * Returns the user provided comments for the controller service.
     *
     * @return The user provided comments for the controller service.
     */
    public String getComments()
    {
        return getControllerServiceDTO().getComments();
    }

    /**
     * Returns whether the controller service persists state.
     *
     * @return Whether the controller service persists state.
     */
    public boolean isPersistsState()
    {
        return getControllerServiceDTO().getPersistsState();
    }

    /**
     * Returns whether this controller service requires elevated permissions.
     *
     * @return Whether this controller service requires elevated permissions.
     */
    public boolean isRestricted()
    {
        return getControllerServiceDTO().getRestricted();
    }

    /**
     * Returns the state of this controller service. Possible values are ENABLED,
     * ENABLING, DISABLED, DISABLING.
     *
     * @return The state of this controller service.
     */
    public String getState()
    {
        return getControllerServiceDTO().getState();
    }

    /**
     * Returns the controller service properties.
     *
     * @return The controller service properties.
     */
    public Map<String, String> getProperties()
    {
        return Collections.unmodifiableMap(getControllerServiceDTO().getProperties());
    }

    /**
     * Returns the descriptors for the controller service properties.
     *
     * @return The descriptors for the controller service properties.
     */
    public Map<String, PropertyDescriptorDTO> getDescriptors()
    {
        return Collections.unmodifiableMap(getControllerServiceDTO().getDescriptors());
    }

    /**
     * Returns the URL for this controller services custom configuration UI if
     * applicable. Null otherwise.
     *
     * @return The URL for this controller services custom configuration UI if
     *         applicable.
     */
    public String getCustomUiUrl()
    {
        return getControllerServiceDTO().getCustomUiUrl();
    }

    /**
     * Returns the annotation data for the controller service.
     *
     * @return The annotation data for the controller service.
     */
    public String getAnnotationData()
    {
        return getControllerServiceDTO().getAnnotationData();
    }

    /**
     * Returns references to all components referencing the controller service.
     *
     * @return references to all components referencing the controller service.
     */
    public ReferencingComponents getReferencingComponents() throws InvokerException
    {
        final Set<ControllerService> controllerServices = new HashSet<>();
        final Set<Processor> processors = new HashSet<>();
        final Set<ReportingTask> reportingTasks = new HashSet<>();

        for (final ControllerServiceReferencingComponentEntity entity : getControllerServiceDTO()
                .getReferencingComponents())
        {
            final ControllerServiceReferencingComponentDTO component = entity.getComponent();
            final String referenceType = component.getReferenceType();
            switch (referenceType)
            {
                case "ControllerService":
                    controllerServices.add(getController().getControllerService(component.getId()));
                    break;

                case "Processor":
                    processors.add(getController().getProcessor(component.getId()));
                    break;

                case "ReportingTask":
                    reportingTasks.add(getController().getReportingTask(component.getId()));
                    break;

                default:
                    throw new IllegalStateException("Unrecognised referencing component type: " + referenceType);
            }
        }

        return new ReferencingComponents(controllerServices, processors, reportingTasks);
    }

    /**
     * Returns the validation errors from this controller service. These validation
     * errors represent the problems with the controller service that must be
     * resolved before it can be enabled.
     *
     * @return The validation errors from this controller service.
     */
    public Collection<String> getValidationErrors()
    {
        return getControllerServiceDTO().getValidationErrors();
    }

    @Override
    public ControllerService refresh() throws InvokerException
    {
        setComponentEntity(new GetControllerServiceInvoker(getController().getTransport()).setId(getId()).invoke());

        return this;
    }

    @Override
    public ControllerService update(final Consumer<ControllerServiceDTOBuilder> configurator) throws InvokerException
    {
        final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder()
                .setId(getId());

        configurator.accept(controllerServiceDTOBuilder);

        setComponentEntity(new UpdateControllerServiceInvoker(getController().getTransport()).setId(getId())
                .setControllerServiceEntity(new ControllerServiceEntityBuilder().setId(getId())
                        .setComponent(controllerServiceDTOBuilder.build()).setRevision(getRevisionDTO()).build())
                .invoke());

        return this;
    }

    @Override
    public ControllerService update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
            throws InvokerException
    {
        return Updatable.super.update(closure);
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveControllerServiceInvoker(getController().getTransport()).setId(getId())
                .setVersion(getRevisionDTO().getVersion()).invoke();
    }

    /**
     * Returns the state of this controller service. Possible values are ENABLED,
     * ENABLING, DISABLED, DISABLING.
     *
     * @return The state of this controller service.
     */
    public String getEnabledState()
    {
        return getControllerServiceDTO().getState();
    }

    /**
     * Creates a request to set the enabled state of the controller service.
     * 
     * @param enabled <code>true</code> if the controller service should be enabled
     *                and <code>false</code> if disabled.
     * @return The new {@link SetEnabledStateRequest}.
     */
    public SetEnabledStateRequest createSetEnabledStateRequest(final boolean enabled)
    {
        final String enabledState = enabled ? EnabledStates.ENABLED : EnabledStates.DISABLED;

        update(controllerServiceDtoBuilder -> controllerServiceDtoBuilder.setState(enabledState));
        return new SetEnabledStateRequest(this, enabled);
    }

    /**
     * Enables the controller service.
     * 
     * @param pollingInterval The interval to wait between refreshing the state of
     *                        the controller service until it is enabled.
     * @param pollingDuration The time to spend waiting for the controller service
     *                        to become enabled before giving up refreshing its
     *                        state.
     * @return This controller service.
     */
    public ControllerService enable(final Duration pollingInterval, final Duration pollingDuration)
    {
        createSetEnabledStateRequest(true).pollUntilFinished(pollingInterval, pollingDuration);
        return this;
    }

    /**
     * Enables the controller service. This method will wait for up to 2 minutes for
     * the controller service to become enabled, checking every 500 ms.
     * 
     * @return This controller service.
     */
    public ControllerService enable()
    {
        return enable(Duration.ofMillis(500), Duration.ofMinutes(2));
    }

    /**
     * Disables the controller service.
     * 
     * @param pollingInterval The interval to wait between refreshing the state of
     *                        the controller service until it is disabled.
     * @param pollingDuration The time to spend waiting for the controller service
     *                        to become disabled before giving up refreshing its
     *                        state.
     * @return This controller service.
     */
    public ControllerService disable(final Duration pollingInterval, final Duration pollingDuration)
    {
        createSetEnabledStateRequest(false).pollUntilFinished(pollingInterval, pollingDuration);
        return this;
    }

    /**
     * Disables the controller service. This method will wait for up to 2 minutes
     * for the controller service to become disabled, checking every 500 ms.
     * 
     * @return This controller service.
     */
    public ControllerService disable()
    {
        return disable(Duration.ofMillis(500), Duration.ofMinutes(2));
    }
}
