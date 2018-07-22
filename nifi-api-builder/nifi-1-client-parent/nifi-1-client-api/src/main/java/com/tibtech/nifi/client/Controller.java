package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.controller.CreateControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.CreateReportingTaskInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.dto.ReportingTaskDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;
import com.tibtech.nifi.web.api.entity.ReportingTaskEntityBuilder;
import com.tibtech.nifi.web.api.flow.*;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupInvoker;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Controller represents the NiFi Controller from which may be obtained
 * references to the root process group, controller services, reporting tasks,
 * etc.
 */
public class Controller
{
    /**
     * The static ID that may be used to obtain a reference to the root process
     * group.
     */
    public static final String ROOT_PROCESS_GROUP_ID = "root";

    private final Transport transport;

    private Controller(final Transport transport)
    {
        this.transport = transport;
    }

    /**
     * Returns a reference to the root process group.
     *
     * @return The root process group.
     * @throws InvokerException if there is a problem getting details of the root
     *                          process group.
     */
    public ProcessGroup getRootProcessGroup() throws InvokerException
    {
        return new ProcessGroup(transport,
                new GetProcessGroupInvoker(transport, 0).setId(ROOT_PROCESS_GROUP_ID).invoke());
    }

    /**
     * Gets the set of all Reporting Task scope Controller Services.
     *
     * @return The set of all controller services.
     * @throws InvokerException if there is a problem getting all controller services.
     */
    public Set<ControllerService> getControllerServices() throws InvokerException
    {
        return new GetControllerServicesFromControllerInvoker(transport, 0)
                .invoke()
                .getControllerServices().stream()
                .map(controllerServiceEntity -> new ControllerService(transport, controllerServiceEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new Reporting Task scoped Controller Service.
     *
     * @param type         The fully qualified class name of the controller service to
     *                     create.
     * @param configurator A consumer that accepts an instance of
     *                     {@link ControllerServiceDTOBuilder} on which controller service
     *                     settings may be set.
     * @return The new controller service.
     * @throws InvokerException if there is a problem creating the controller
     *                          service.
     * @see #getControllerServiceTypeDTOs()
     */
    public ControllerService createControllerService(final String type,
                                                     final Consumer<ControllerServiceDTOBuilder> configurator) throws InvokerException
    {
        final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder()
                .setType(type);

        configurator.accept(controllerServiceDTOBuilder);

        return new ControllerService(transport, new CreateControllerServiceInvoker(transport, 0)
                .setControllerServiceEntity(new ControllerServiceEntityBuilder()
                        .setComponent(controllerServiceDTOBuilder.build())
                        .build())
                .invoke());
    }

    /**
     * Creates a new Reporting Task scoped Controller Service.
     *
     * @param type    The fully qualified class name of the type of controller service
     *                to create.
     * @param closure A closure that delegates to an instance of
     *                {@link ControllerServiceDTOBuilder} on which controller service
     *                settings may be set.
     * @return The new controller service.
     * @throws InvokerException if there is a problem creating the controller
     *                          service.
     * @see #getControllerServiceTypeDTOs()
     */
    public ControllerService createControllerService(final String type,
                                                     @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
            throws InvokerException
    {
        return createControllerService(type, configurator -> {
            final Closure<ControllerServiceDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    /**
     * Gets the set of all templates.
     *
     * @return The set of all templates.
     * @throws InvokerException if there is a problem getting all templates.
     */
    public Set<Template> getTemplates() throws InvokerException
    {
        return new GetTemplatesInvoker(transport, 0)
                .invoke()
                .getTemplates().stream()
                .map(templateEntity -> new Template(transport, templateEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns a set containing the types of controller service available to be
     * created.
     *
     * @return A set of available controller service types.
     * @throws InvokerException if there is a problem getting the set of available
     *                          controller service types.
     */
    public Set<DocumentedTypeDTO> getControllerServiceTypeDTOs() throws InvokerException
    {
        return new GetControllerServiceTypesInvoker(transport, 0).invoke().getControllerServiceTypes();
    }

    /**
     * Returns a set containing the types of processor available to be created.
     *
     * @return A set of available processor types.
     * @throws InvokerException if there is a problem getting the set of available
     *                          processor types.
     */
    public Set<DocumentedTypeDTO> getProcessorTypeDTOs() throws InvokerException
    {
        return new GetProcessorTypesInvoker(transport, 0).invoke().getProcessorTypes();
    }

    /**
     * Returns a set containing the types of reporting task available to be created.
     *
     * @return A set of available reporting task types.
     * @throws InvokerException if there is a problem getting the set of available
     *                          reporting task types.
     */
    public Set<DocumentedTypeDTO> getReportingTaskTypeDTOs() throws InvokerException
    {
        return new GetReportingTaskTypesInvoker(transport, 0).invoke().getReportingTaskTypes();
    }

    /**
     * Gets the set of all reporting tasks.
     *
     * @return The set of all reporting tasks.
     * @throws InvokerException if there is a problem getting the reporting tasks.
     */
    public Set<ReportingTask> getReportingTasks() throws InvokerException
    {
        return new GetReportingTasksInvoker(transport, 0).invoke().getReportingTasks().stream()
                .map(reportingTaskEntity -> new ReportingTask(transport, reportingTaskEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a reporting task.
     *
     * @param type         The fully qualified class name of the type of reporting task to
     *                     create.
     * @param configurator A consumer that accepts an instance of
     *                     {@link ReportingTaskDTOBuilder} on which reporting task settings may
     *                     be set.
     * @return The new reporting task.
     * @throws InvokerException if there is a problem creating the new reporting
     *                          task.
     */
    public ReportingTask createReportingTask(final String type, final Consumer<ReportingTaskDTOBuilder> configurator)
            throws InvokerException
    {
        final ReportingTaskDTOBuilder reportingTaskDTOBuilder = new ReportingTaskDTOBuilder().setType(type);

        configurator.accept(reportingTaskDTOBuilder);

        return new ReportingTask(transport,
                new CreateReportingTaskInvoker(transport, 0)
                        .setReportingTaskEntity(new ReportingTaskEntityBuilder()
                                .setComponent(reportingTaskDTOBuilder.build())
                                .build())
                        .invoke());
    }

    /**
     * Creates a reporting task.
     *
     * @param type    The fully qualified class name of the type of reporting task to
     *                create.
     * @param closure A closure that delegates to an instance of
     *                {@link ReportingTaskDTOBuilder} on which reporting task settings may
     *                be set.
     * @return The new reporting task.
     * @throws InvokerException if there is a problem creating the new reporting
     *                          task.
     */
    public ReportingTask createReportingTask(final String type,
                                             @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReportingTaskDTOBuilder.class) final Closure<ReportingTaskDTOBuilder> closure)
            throws InvokerException
    {
        return createReportingTask(type, configurator -> {
            final Closure<ReportingTaskDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    /**
     * Connects to an instance of a NiFi Controller.
     *
     * @param clientBuilder The client builder with which to create a client to communicate with the NiFi Controller.
     * @param baseUri       The base URI of the NiFi instance. This is the usual NiFi URL
     *                      without the '/nifi' suffix.
     * @return A new instance of Controller.
     * @throws InvokerException if there is a problem connecting to the NiFi Controllers.
     */
    public static Controller connect(final ClientBuilder clientBuilder, final String baseUri) throws InvokerException
    {
        clientBuilder.register(MultiPartFeature.class);
        final Client client = clientBuilder.build();
        final Transport transport = new Transport(client, baseUri);

        new GenerateClientIdInvoker(transport, 0).invoke();

        final Controller controller = new Controller(transport);
        return controller;
    }

    /**
     * Connects to an instance of a NiFi Controller Controller.
     *
     * @param baseUri The base URI of the NiFi instance. This is the usual NiFi URL
     *                without the '/nifi' suffix.
     * @return A new instance of Controller.
     * @throws InvokerException if there is a problem connecting to the NiFi Controller.
     */
    public static Controller connect(final String baseUri) throws InvokerException
    {
        final ClientBuilder clientBuilder = ClientBuilder.newBuilder();

        return connect(clientBuilder, baseUri);
    }
}
