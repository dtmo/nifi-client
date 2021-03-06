package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Collections;
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

/**
 * Processor represents a NiFi processor which is the main component for
 * performing work in a NiFi flow.
 */
public class Processor extends AbstractComponent<ProcessorEntity>
        implements Connectable, Deletable, Updatable<Processor, ProcessorDTOBuilder>, Schedulable<Processor>
{
    /**
     * Constructs a new instance of Processor.
     *
     * @param controller      The controller to which the processor belongs.
     * @param processorEntity The entity that represents the processor.
     */
    public Processor(final Controller controller, final ProcessorEntity processorEntity)
    {
        super(controller, processorEntity);
    }

    /**
     * Returns the DTO that describes the processor.
     *
     * @return The DTO that describes the processor.
     */
    public ProcessorDTO getProcessorDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getProcessorDTO().getId();
    }

    @Override
    public String getParentGroupId()
    {
        return getProcessorDTO().getParentGroupId();
    }

    /**
     * Returns the name of the processor.
     *
     * @return The name of the processor.
     */
    public String getName()
    {
        return getProcessorDTO().getName();
    }

    /**
     * Returns the fully qualified type of the processor.
     *
     * @return The fully qualified type of the processor.
     */
    public String getType()
    {
        return getProcessorDTO().getType();
    }

    /**
     * Returns the state of this processor. Possible states are 'RUNNING',
     * 'STOPPED', and 'DISABLED'.
     *
     * @return The state of this processor.
     */
    public String getState()
    {
        return getProcessorDTO().getState();
    }

    /**
     * Returns the styles for this processor. (Currently only supports color)
     *
     * @return The styles for this processor.
     */
    public Map<String, String> getStyle()
    {
        return Collections.unmodifiableMap(getProcessorDTO().getStyle());
    }

    /**
     * Returns whether this processor supports parallel processing.
     *
     * @return Whether this processor supports parallel processing.
     */
    public boolean getSupportsParallelProcessing()
    {
        return getProcessorDTO().getSupportsParallelProcessing();
    }

    /**
     * Returns whether this processor persists state.
     *
     * @return Whether this processor persists state.
     */
    public boolean getPersistsState()
    {
        return getProcessorDTO().getPersistsState();
    }

    /**
     * Returns whether this processor requires elevated privileges.
     *
     * @return Whether this processor requires elevated privileges.
     */
    public boolean getRestricted()
    {
        return getProcessorDTO().getRestricted();
    }

    /**
     * Returns the input requirement of this processor.
     *
     * @return The input requirement of this processor.
     */
    public String getInputRequirement()
    {
        return getProcessorDTO().getInputRequirement();
    }

    /**
     * Returns whether this processor supports event driven scheduling.
     *
     * @return Whether this processor supports event driven scheduling.
     */
    public boolean getSupportsEventDriven()
    {
        return getProcessorDTO().getSupportsEventDriven();
    }

    /**
     * Returns whether this processor supports batching.
     *
     * @return Whether this processor supports batching.
     */
    public boolean getSupportsBatching()
    {
        return getProcessorDTO().getSupportsBatching();
    }

    /**
     * Returns the available relationships that this processor currently supports.
     *
     * @return The available relationships that this processor currently supports.
     */
    public List<RelationshipDTO> getRelationships()
    {
        return Collections.unmodifiableList(getProcessorDTO().getRelationships());
    }

    /**
     * Returns the processor configuration details.
     * 
     * @return The processor configuration details.
     */
    public ProcessorConfigDTO getConfig()
    {
        return getProcessorDTO().getConfig();
    }

    /**
     * Returns the validation errors from this processor. These validation errors
     * represent the problems with the processor that must be resolved before it can
     * be started.
     *
     * @return The validation errors from this processor.
     */
    public Collection<String> getValidationErrors()
    {
        return getProcessorDTO().getValidationErrors();
    }

    /**
     * Returns the description for this processor.
     *
     * @return The description for this processor.
     */
    public String getDescription()
    {
        return getProcessorDTO().getDescription();
    }

    @Override
    public ConnectableType getConnectableType()
    {
        return ConnectableType.PROCESSOR;
    }

    @Override
    public void delete() throws InvokerException
    {
        new DeleteProcessorInvoker(getController().getTransport()).setId(getId())
                .setVersion(getRevisionDTO().getVersion()).invoke();
    }

    @Override
    public Processor refresh() throws InvokerException
    {
        setComponentEntity(new GetProcessorInvoker(getController().getTransport()).setId(getId()).invoke());

        return this;
    }

    @Override
    public Processor update(final Consumer<ProcessorDTOBuilder> configurator) throws InvokerException
    {
        final ProcessorDTOBuilder processorDTOBuilder = new ProcessorDTOBuilder().setId(getId());

        configurator.accept(processorDTOBuilder);

        setComponentEntity(
                new UpdateProcessorInvoker(getController().getTransport())
                        .setId(getId()).setProcessorEntity(new ProcessorEntityBuilder()
                                .setComponent(processorDTOBuilder.build()).setRevision(getRevisionDTO()).build())
                        .invoke());

        return this;
    }

    @Override
    public Processor update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
            throws InvokerException
    {
        return Updatable.super.update(closure);
    }

    @Override
    public String getScheduledState()
    {
        return getProcessorDTO().getState();
    }

    @Override
    public SetScheduledStateRequest<Processor> createSetScheduledStateRequest(final boolean running)
    {
        final String scheduledState = running ? ScheduledStates.RUNNING : ScheduledStates.STOPPED;
        update(processorDtoBuilder -> processorDtoBuilder.setState(scheduledState));
        return new SetProcessorScheduledStateRequest(this, running);
    }
}
