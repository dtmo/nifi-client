package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.connection.GetConnectionInvoker;
import com.tibtech.nifi.web.api.controller.CreateControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.CreateReportingTaskInvoker;
import com.tibtech.nifi.web.api.controllerservice.GetControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.dto.ReportingTaskDTOBuilder;
import com.tibtech.nifi.web.api.dto.RevisionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;
import com.tibtech.nifi.web.api.entity.ReportingTaskEntityBuilder;
import com.tibtech.nifi.web.api.flow.*;
import com.tibtech.nifi.web.api.funnel.GetFunnelInvoker;
import com.tibtech.nifi.web.api.inputport.GetInputPortInvoker;
import com.tibtech.nifi.web.api.label.GetLabelInvoker;
import com.tibtech.nifi.web.api.outputport.GetOutputPortInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupInvoker;
import com.tibtech.nifi.web.api.processor.GetProcessorInvoker;
import com.tibtech.nifi.web.api.remoteprocessgroup.GetRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.reportingtask.GetReportingTaskInvoker;

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
     * Returns the transport with which to communicate with the NiFi instance.
     * 
     * @return The transport with which to communicate with the NiFi instance.
     */
    public Transport getTransport()
    {
        return transport;
    }

    /**
     * Gets the connection with the specified ID.
     *
     * @param id The ID of the connection to get.
     * @return The connection with the specified ID.
     * @throws InvokerException if there is a problem getting the connection.
     */
    public Connection getConnection(final String id) throws InvokerException
    {
        return new Connection(this, new GetConnectionInvoker(transport).setId(id).invoke());
    }

    /**
     * Returns the controller service with a specific ID.
     *
     * @param id The ID of the controller service to return.
     * @return The controller service with the specified ID.
     * @throws InvokerException if there is a problem getting the controller
     *                          service.
     */
    public ControllerService getControllerService(final String id) throws InvokerException
    {
        return new ControllerService(this, new GetControllerServiceInvoker(transport).setId(id).invoke());
    }

    /**
     * Gets the funnel with a specific ID.
     *
     * @param id The ID of the funnel to get.
     * @return The funnel with the specified ID.
     * @throws InvokerException if there is a problem getting the funnel.
     */
    public Funnel getFunnel(final String id) throws InvokerException
    {
        return new Funnel(this, new GetFunnelInvoker(transport).setId(id).invoke());
    }

    /**
     * Gets the input port with a specific ID.
     *
     * @param id The ID of the input port to get.
     * @return The input port with the specified ID.
     * @throws InvokerException if there is a problem getting the input port.
     */
    public InputPort getInputPort(final String id) throws InvokerException
    {
        return new InputPort(this, new GetInputPortInvoker(transport).setId(id).invoke());
    }

    /**
     * Gets the label with a specific ID.
     *
     * @param id The ID of the label to get.
     * @return The label with the specified ID.
     * @throws InvokerException if there is a problem getting the label.
     */
    public Label getLabel(final String id) throws InvokerException
    {
        return new Label(this, new GetLabelInvoker(transport).setId(id).invoke());
    }

    /**
     * Gets the output port with a specific ID.
     *
     * @param id The ID of the output port to get.
     * @return The output port with the specified ID.
     * @throws InvokerException if there is a problem getting the output port.
     */
    public OutputPort getOutputPort(final String id) throws InvokerException
    {
        return new OutputPort(this, new GetOutputPortInvoker(transport).setId(id).invoke());
    }

    /**
     * Gets the process group with a specific ID.
     *
     * @param id The ID of the process group to get.
     * @return The process group with the specified ID.
     * @throws InvokerException if there is a problem getting the process group.
     */
    public ProcessGroup getProcessGroup(final String id) throws InvokerException
    {
        return new ProcessGroup(this, new GetProcessGroupInvoker(transport).setId(id).invoke());
    }

    /**
     * Returns the processor with a specific ID.
     *
     * @param id The ID of the processor to return.
     * @return The processor with the specified ID.
     * @throws InvokerException if there is a problem getting the processor.
     */
    public Processor getProcessor(final String id) throws InvokerException
    {
        return new Processor(this, new GetProcessorInvoker(transport).setId(id).invoke());
    }

    /**
     * Gets the remote process group with a specific ID.
     *
     * @param id The ID of the remote process group to get.
     * @return The remote process group with the specified ID.
     * @throws InvokerException if there is a problem getting the remote process
     *                          group.
     */
    public RemoteProcessGroup getRemoteProcessGroup(final String id) throws InvokerException
    {
        return new RemoteProcessGroup(this, new GetRemoteProcessGroupInvoker(transport).setId(id).invoke());
    }

    /**
     * Returns the reporting task with a specific ID.
     *
     * @param id The ID of the reporting task to return.
     * @return The reporting task with the specified ID.
     * @throws InvokerException if there is a problem getting the reporting task.
     */
    public ReportingTask getReportingTask(final String id) throws InvokerException
    {
        return new ReportingTask(this, new GetReportingTaskInvoker(transport).setId(id).invoke());
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
        return getProcessGroup(ROOT_PROCESS_GROUP_ID);
    }

    /**
     * Gets the set of all Reporting Task scope Controller Services.
     *
     * @return The set of all controller services.
     * @throws InvokerException if there is a problem getting all controller
     *                          services.
     */
    public Set<ControllerService> getControllerServices() throws InvokerException
    {
        return new GetControllerServicesFromControllerInvoker(transport).invoke().getControllerServices().stream()
                .map(controllerServiceEntity -> new ControllerService(this, controllerServiceEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new Reporting Task scoped Controller Service.
     *
     * @param type         The fully qualified class name of the controller service
     *                     to create.
     * @param configurator A consumer that accepts an instance of
     *                     {@link ControllerServiceDTOBuilder} on which controller
     *                     service settings may be set.
     * @return The new controller service.
     * @throws InvokerException if there is a problem creating the controller
     *                          service.
     * @see #getControllerServiceTypeDTOs()
     */
    public ControllerService createControllerService(final String type,
            final Consumer<ControllerServiceDTOBuilder> configurator) throws InvokerException
    {
        final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder().setType(type);

        configurator.accept(controllerServiceDTOBuilder);

        return new ControllerService(this, new CreateControllerServiceInvoker(transport)
                .setControllerServiceEntity(new ControllerServiceEntityBuilder()
                        .setRevision(
                                new RevisionDTOBuilder().setClientId(transport.getClientId()).setVersion(0L).build())
                        .setComponent(controllerServiceDTOBuilder.build()).build())
                .invoke());
    }

    /**
     * Creates a new Reporting Task scoped Controller Service.
     *
     * @param type    The fully qualified class name of the type of controller
     *                service to create.
     * @param closure A closure that delegates to an instance of
     *                {@link ControllerServiceDTOBuilder} on which controller
     *                service settings may be set.
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
        return new GetTemplatesInvoker(transport).invoke().getTemplates().stream()
                .map(templateEntity -> new Template(this, templateEntity)).collect(Collectors.toSet());
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
        return new GetControllerServiceTypesInvoker(transport).invoke().getControllerServiceTypes();
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
        return new GetProcessorTypesInvoker(transport).invoke().getProcessorTypes();
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
        return new GetReportingTaskTypesInvoker(transport).invoke().getReportingTaskTypes();
    }

    /**
     * Gets the set of all reporting tasks.
     *
     * @return The set of all reporting tasks.
     * @throws InvokerException if there is a problem getting the reporting tasks.
     */
    public Set<ReportingTask> getReportingTasks() throws InvokerException
    {
        return new GetReportingTasksInvoker(transport).invoke().getReportingTasks().stream()
                .map(reportingTaskEntity -> new ReportingTask(this, reportingTaskEntity)).collect(Collectors.toSet());
    }

    /**
     * Creates a reporting task.
     *
     * @param type         The fully qualified class name of the type of reporting
     *                     task to create.
     * @param configurator A consumer that accepts an instance of
     *                     {@link ReportingTaskDTOBuilder} on which reporting task
     *                     settings may be set.
     * @return The new reporting task.
     * @throws InvokerException if there is a problem creating the new reporting
     *                          task.
     */
    public ReportingTask createReportingTask(final String type, final Consumer<ReportingTaskDTOBuilder> configurator)
            throws InvokerException
    {
        final ReportingTaskDTOBuilder reportingTaskDTOBuilder = new ReportingTaskDTOBuilder().setType(type);

        configurator.accept(reportingTaskDTOBuilder);

        return new ReportingTask(this,
                new CreateReportingTaskInvoker(transport).setReportingTaskEntity(new ReportingTaskEntityBuilder()
                        .setRevision(
                                new RevisionDTOBuilder().setClientId(transport.getClientId()).setVersion(0L).build())
                        .setComponent(reportingTaskDTOBuilder.build()).build()).invoke());
    }

    /**
     * Creates a reporting task.
     *
     * @param type    The fully qualified class name of the type of reporting task
     *                to create.
     * @param closure A closure that delegates to an instance of
     *                {@link ReportingTaskDTOBuilder} on which reporting task
     *                settings may be set.
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
     * @param clientBuilder The client builder with which to create a client to
     *                      communicate with the NiFi Controller.
     * @param baseUri       The base URI of the NiFi instance. This is the usual
     *                      NiFi URL without the '/nifi' suffix.
     * @return A new instance of Controller.
     * @throws InvokerException if there is a problem connecting to the NiFi
     *                          Controllers.
     */
    public static Controller connect(final ClientBuilder clientBuilder, final String baseUri) throws InvokerException
    {
        clientBuilder.register(MultiPartFeature.class);
        final Client client = clientBuilder.build();
        final Transport transport = new Transport(client, baseUri);

        new GenerateClientIdInvoker(transport).invoke();

        final Controller controller = new Controller(transport);
        return controller;
    }

    /**
     * Connects to an instance of a NiFi Controller Controller.
     *
     * @param baseUri The base URI of the NiFi instance. This is the usual NiFi URL
     *                without the '/nifi' suffix.
     * @return A new instance of Controller.
     * @throws InvokerException if there is a problem connecting to the NiFi
     *                          Controller.
     */
    public static Controller connect(final String baseUri) throws InvokerException
    {
        final ClientBuilder clientBuilder = ClientBuilder.newBuilder();

        return connect(clientBuilder, baseUri);
    }
}
