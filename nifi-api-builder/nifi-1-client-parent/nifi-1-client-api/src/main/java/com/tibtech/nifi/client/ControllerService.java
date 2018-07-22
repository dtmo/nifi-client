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

import java.util.*;
import java.util.function.Consumer;

/**
 * Controller service represents a NiFi flow controller service which is an extension point that, after being added and
 * configured by a DFM in the User Interface, will start up when NiFi starts up and provide information for use by other
 * components (such as processors or other controller services).
 */
public class ControllerService
        extends UpdatableComponent<ControllerService, ControllerServiceEntity, ControllerServiceDTOBuilder>
        implements Deletable, Refreshable<ControllerService, ControllerServiceDTOBuilder>
{
    /**
     * Controller Service is disabled and cannot be used.
     */
    public static final String STATE_DISABLED = "DISABLED";

    /**
     * Controller Service has been disabled but has not yet finished its
     * lifecycle methods.
     */
    public static final String STATE_DISABLING = "DISABLING";

    /**
     * Controller Service has been enabled but has not yet finished its
     * lifecycle methods.
     */
    public static final String STATE_ENABLING = "ENABLING";

    /**
     * Controller Service has been enabled and has finished its lifecycle
     * methods. The Controller Service is ready to be used.
     */
    public static final String STATE_ENABLED = "ENABLED";

    /**
     * Constructs a new instance of ControllerService.
     *
     * @param transport               The transport with which to communicate with the NiFi server.
     * @param controllerServiceEntity The entity that represents the controller service.
     */
    public ControllerService(final Transport transport, final ControllerServiceEntity controllerServiceEntity)
    {
        super(transport, controllerServiceEntity);
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
     * Returns the state of this controller service. Possible values are ENABLED, ENABLING, DISABLED, DISABLING.
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
     * Returns the URL for this controller services custom configuration UI if applicable. Null otherwise.
     *
     * @return The URL for this controller services custom configuration UI if applicable.
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

        for (final ControllerServiceReferencingComponentEntity entity : getControllerServiceDTO().getReferencingComponents())
        {
            final ControllerServiceReferencingComponentDTO component = entity.getComponent();
            final String referenceType = component.getReferenceType();
            switch (referenceType)
            {
                case "ControllerService":
                    controllerServices.add(ControllerService.get(getTransport(), component.getId()));
                    break;

                case "Processor":
                    processors.add(Processor.get(getTransport(), component.getId()));
                    break;

                case "ReportingTask":
                    reportingTasks.add(ReportingTask.get(getTransport(), component.getId()));
                    break;

                default:
                    throw new IllegalStateException("Unrecognised referencing component type: " + referenceType);
            }
        }

        return new ReferencingComponents(controllerServices, processors, reportingTasks);
    }

    /**
     * Returns the validation errors from this controller service. These validation errors represent the problems with
     * the controller service that must be resolved before it can be enabled.
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
        setComponentEntity(new GetControllerServiceInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke());

        return this;
    }

    @Override
    public ControllerService update(final Consumer<ControllerServiceDTOBuilder> configurator) throws InvokerException
    {
        final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder()
                .setId(getId());

        configurator.accept(controllerServiceDTOBuilder);

        setComponentEntity(new UpdateControllerServiceInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .setControllerServiceEntity(new ControllerServiceEntityBuilder()
                        .setId(getId())
                        .setComponent(controllerServiceDTOBuilder.build())
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
        new RemoveControllerServiceInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke();
    }

    /**
     * Enables the controller service.
     *
     * @throws InvokerException if the controller service could not be enabled.
     */
    public ControllerService enable() throws InvokerException
    {
        return setEnabled(true);
    }

    /**
     * Disables the controller service.
     *
     * @throws InvokerException if the controller service could not be disabled.
     */
    public ControllerService disable() throws InvokerException
    {
        return setEnabled(false);
    }

    /**
     * Sets the enabled state of the controller service.
     *
     * @param enabled The enabled state to set.
     * @throws InvokerException if the enabled state of the controller service could not be changed.
     */
    public ControllerService setEnabled(final boolean enabled) throws InvokerException
    {
        final String controllerServiceState = enabled ? STATE_ENABLED : STATE_DISABLED;

        return update(c -> c.setState(controllerServiceState));
    }

    /**
     * Returns the controller service with a specific ID.
     *
     * @param transport The transport with which to communicate with the NiFi server.
     * @param id        The ID of the controller service to return.
     * @return The controller service with the specified ID.
     * @throws InvokerException if there is a problem getting the controller service.
     */
    public static ControllerService get(final Transport transport, final String id) throws InvokerException
    {
        return new ControllerService(transport, new GetControllerServiceInvoker(transport, 0)
                .setId(id)
                .invoke());
    }

}
