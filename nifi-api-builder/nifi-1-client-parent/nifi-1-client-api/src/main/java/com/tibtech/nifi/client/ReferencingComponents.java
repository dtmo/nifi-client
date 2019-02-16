package com.tibtech.nifi.client;

import java.util.Set;

/**
 * ReferencingComponents represents the set of components referencing a
 * controller service.
 */
public class ReferencingComponents
{
    private final Set<ControllerService> controllerServices;
    private final Set<Processor> processors;
    private final Set<ReportingTask> reportingTasks;

    /**
     * Constructs a new instance of ReferencingComponents.
     *
     * @param controllerServices The set of other referencing controller services.
     * @param processors         The set of referencing processors.
     * @param reportingTasks     The set of referencing reporting tasks.
     */
    public ReferencingComponents(final Set<ControllerService> controllerServices, final Set<Processor> processors,
            final Set<ReportingTask> reportingTasks)
    {
        this.controllerServices = controllerServices;
        this.processors = processors;
        this.reportingTasks = reportingTasks;
    }

    /**
     * Returns the set of referencing controller services.
     *
     * @return The set of referencing controller services.
     */
    public Set<ControllerService> getControllerServices()
    {
        return controllerServices;
    }

    /**
     * Returns the set of referencing processors.
     *
     * @return The set of referencing processors.
     */
    public Set<Processor> getProcessors()
    {
        return processors;
    }

    /**
     * Returns the set of referencing reporting tasks.
     *
     * @return The set of referencing reporting tasks.
     */
    public Set<ReportingTask> getReportingTasks()
    {
        return reportingTasks;
    }
}
