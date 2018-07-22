package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.dto.ReportingTaskDTOBuilder;
import com.tibtech.nifi.web.api.entity.ReportingTaskEntityBuilder;
import com.tibtech.nifi.web.api.reportingtask.GetReportingTaskInvoker;
import com.tibtech.nifi.web.api.reportingtask.RemoveReportingTaskInvoker;
import com.tibtech.nifi.web.api.reportingtask.UpdateReportingTaskInvoker;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.dto.ReportingTaskDTO;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Reporting Task represents a NiFi flow reporting task that runs in the
 * background to provide statistical reports about what is happening in the NiFi
 * instance.
 */
public class ReportingTask extends UpdatableComponent<ReportingTask, ReportingTaskEntity, ReportingTaskDTOBuilder>
        implements Deletable, Refreshable<ReportingTask, ReportingTaskDTOBuilder>
{
    public static final String STATE_RUNNING = "RUNNING";
    public static final String STATE_STOPPED = "STOPPED";
    public static final String STATE_DISABLED = "DISABLED";

    /**
     * Constructs a new instance of ReportingTask.
     *
     * @param transport           The transport with which to communicate with the NiFi
     *                            server.
     * @param reportingTaskEntity The entity that describes the reporting task.
     */
    public ReportingTask(final Transport transport, final ReportingTaskEntity reportingTaskEntity)
    {
        super(transport, reportingTaskEntity);
    }

    /**
     * Returns the DTO that describes the reporting task.
     *
     * @return The DTO that describes the reporting task.
     */
    public ReportingTaskDTO getReportingTaskDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getReportingTaskDTO().getId();
    }

    /**
     * Returns the user defined name of the reporting task.
     *
     * @return The user defined name of the reporting task.
     */
    public String getName()
    {
        return getReportingTaskDTO().getName();
    }

    /**
     * Returns the user defined comments for the reporting task.
     *
     * @return The user defined comments for the reporting task.
     */
    public String getComments()
    {
        return getReportingTaskDTO().getComments();
    }

    /**
     * Returns the fully qualified type of the reporting task.
     *
     * @return The fully qualified type of the reporting task.
     */
    public String getType()
    {
        return getReportingTaskDTO().getType();
    }

    /**
     * Returns the frequency with which to schedule the reporting task. The format
     * of the value will depend on the value of the schedulingStrategy.
     *
     * @return The frequency with which to schedule the reporting task.
     */
    public String getSchedulingPeriod()
    {
        return getReportingTaskDTO().getSchedulingPeriod();
    }

    /**
     * Returns whether the reporting task persists state.
     *
     * @return Whether the reporting task persists state.
     */
    public Boolean getPersistsState()
    {
        return getReportingTaskDTO().getPersistsState();
    }

    /**
     * Returns whether the reporting task requires elevated privileges.
     *
     * @return Whether the reporting task requires elevated privileges.
     */
    public Boolean getRestricted()
    {
        return getReportingTaskDTO().getRestricted();
    }

    /**
     * Returns the state of the reporting task. Allowable values are: {@value #STATE_RUNNING},
     * {@value #STATE_STOPPED}, {@value #STATE_DISABLED}.
     *
     * @return The state of the reporting task.
     */
    public String getState()
    {
        return getReportingTaskDTO().getState();
    }

    /**
     * Returns the scheduling strategy that determines how the scheduling period
     * value should be interpreted.
     *
     * @return The scheduling strategy that determines how the scheduling period
     * value should be interpreted.
     */
    public String getSchedulingStrategy()
    {
        return getReportingTaskDTO().getSchedulingStrategy();
    }

    /**
     * Returns the properties of the reporting task.
     *
     * @return The properties of the reporting task.
     */
    public Map<String, String> getProperties()
    {
        return Collections.unmodifiableMap(getReportingTaskDTO().getProperties());
    }

    /**
     * Returns the descriptors for the reporting tasks properties.
     *
     * @return The descriptors for the reporting tasks properties.
     */
    public Map<String, PropertyDescriptorDTO> getDescriptors()
    {
        return Collections.unmodifiableMap(getReportingTaskDTO().getDescriptors());
    }

    /**
     * Returns the URL for this reporting task custom configuration UI if
     * applicable. Null otherwise.
     *
     * @return The URL for this reporting task custom configuration UI if
     * applicable.
     */
    public String getCustomUiUrl()
    {
        return getReportingTaskDTO().getCustomUiUrl();
    }

    /**
     * Returns the annotation data for the repoting task. This is how the custom UI
     * relays configuration to the reporting task.
     *
     * @return The annotation data for the repoting task.
     */
    public String getAnnotationData()
    {
        return getReportingTaskDTO().getAnnotationData();
    }

    /**
     * Returns the validation errors from the reporting task. These validation
     * errors represent the problems with the reporting task that must be resolved
     * before it can be scheduled to run.
     *
     * @return The validation errors from the reporting task.
     */
    public Collection<String> getValidationErrors()
    {
        return getReportingTaskDTO().getValidationErrors();
    }

    /**
     * Returns the default scheduling period for the different scheduling
     * strategies.
     *
     * @return The default scheduling period for the different scheduling
     * strategies.
     */
    public Map<String, String> getDefaultSchedulingPeriod()
    {
        return getReportingTaskDTO().getDefaultSchedulingPeriod();
    }

    /**
     * Returns the number of active threads for the reporting task.
     *
     * @return The number of active threads for the reporting task.
     */
    public Integer getActiveThreadCount()
    {
        return getReportingTaskDTO().getActiveThreadCount();
    }

    @Override
    public ReportingTask refresh() throws InvokerException
    {
        setComponentEntity(new GetReportingTaskInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke());

        return this;
    }

    @Override
    public ReportingTask update(final Consumer<ReportingTaskDTOBuilder> configurator) throws InvokerException
    {
        final ReportingTaskDTOBuilder reportingTaskDTOBuilder = new ReportingTaskDTOBuilder()
                .setId(getId());

        configurator.accept(reportingTaskDTOBuilder);

        setComponentEntity(new UpdateReportingTaskInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .setReportingTaskEntity(new ReportingTaskEntityBuilder()
                        .setComponent(reportingTaskDTOBuilder.build())
                        .build())
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

    /**
     * Starts the reporting task.
     *
     * @throws InvokerException if the reporting task could not be started.
     */
    public ReportingTask start() throws InvokerException
    {
        return setRunning(true);
    }

    /**
     * Stops the reporting task.
     *
     * @throws InvokerException if the reporting task could not be stopped.
     */
    public ReportingTask stop() throws InvokerException
    {
        return setRunning(false);
    }

    /**
     * Sets the state of the reporting task.
     *
     * @param running The state to set.
     * @throws InvokerException if the state of the reporting task could not be changed.
     */
    public ReportingTask setRunning(final boolean running) throws InvokerException
    {
        final String reportingTaskState = running ? STATE_RUNNING : STATE_STOPPED;

        return update(c -> c.setState(reportingTaskState));
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveReportingTaskInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke();
    }

    /**
     * Returns the reporting task with a specific ID.
     *
     * @param transport The transport with which to communicate with the NiFi server.
     * @param id        The ID of the reporting task to return.
     * @return The reporting task with the specified ID.
     * @throws InvokerException if there is a problem getting the reporting task.
     */
    public static ReportingTask get(final Transport transport, final String id) throws InvokerException
    {
        return new ReportingTask(transport, new GetReportingTaskInvoker(transport, 0)
                .setId(id)
                .invoke());
    }
}
