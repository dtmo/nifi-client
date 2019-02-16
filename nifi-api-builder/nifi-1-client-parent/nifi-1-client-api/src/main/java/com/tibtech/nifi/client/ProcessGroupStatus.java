package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.status.*;

import java.util.Collection;

public class ProcessGroupStatus
{
    private Collection<ConnectionStatusSnapshotDTO> connectionStatusSnapshots;
    private Collection<ProcessorStatusSnapshotDTO> processorStatusSnapshots;
    private Collection<ProcessGroupStatusSnapshotDTO> processGroupStatusSnapshots;
    private Collection<RemoteProcessGroupStatusSnapshotDTO> remoteProcessGroupStatusSnapshots;
    private Collection<PortStatusSnapshotDTO> inputPortStatusSnapshots;
    private Collection<PortStatusSnapshotDTO> outputPortStatusSnapshots;
}
