package com.tibtech.nifi.client;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.nifi.web.api.dto.status.ProcessorStatusSnapshotDTO;

public class SetProcessorScheduledStateRequest extends SetScheduledStateRequest<Processor>
{
    private static final String RUN_STATUS_RUNNING = "Running";

    private ProcessorStatusSnapshotDTO processorStatusSnapshotDto;

    public SetProcessorScheduledStateRequest(final Processor processor, final boolean running)
    {
        super(processor, running);
    }

    @Override
    public boolean isFinished()
    {
        final boolean running = RUN_STATUS_RUNNING.equals(processorStatusSnapshotDto.getRunStatus());

        if (isRequestedRunning())
        {
            return running;
        }
        else
        {
            return running == false && processorStatusSnapshotDto.getActiveThreadCount() == 0;
        }
    }

    @Override
    public SetScheduledStateRequest<Processor> refresh()
    {
        final Processor processor = getSchedulable();
        final ProcessGroup processGroup = processor.getParent().refresh();
        final ProcessGroupStatus processGroupStatus = processGroup.getStatus(false);
        final List<ProcessorStatusSnapshotDTO> processorStatusSnapshotDtos = processGroupStatus
                .getProcessorStatusSnapshotDtos();
        processorStatusSnapshotDto = processorStatusSnapshotDtos.stream()
                .filter(snapshot -> snapshot.getId().equals(processor.getId())).findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Could not find processor snapshot status for processor " + processor.getId()));
        return this;
    }
}
