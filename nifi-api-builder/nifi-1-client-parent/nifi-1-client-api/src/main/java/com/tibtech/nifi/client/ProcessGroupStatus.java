package com.tibtech.nifi.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.nifi.web.api.dto.status.ConnectionStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.PortStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusSnapshotDTO;

public class ProcessGroupStatus
{
    private List<ConnectionStatusSnapshotDTO> connectionStatusSnapshotDtos;
    private List<ProcessorStatusSnapshotDTO> processorStatusSnapshotDtos;
    private List<ProcessGroupStatusSnapshotDTO> processGroupStatusSnapshotDtos;
    private List<RemoteProcessGroupStatusSnapshotDTO> remoteProcessGroupStatusSnapshotDtos;
    private List<PortStatusSnapshotDTO> inputPortStatusSnapshotDtos;
    private List<PortStatusSnapshotDTO> outputPortStatusSnapshotDtos;

    public List<ConnectionStatusSnapshotDTO> getConnectionStatusSnapshotDtos()
    {
        return connectionStatusSnapshotDtos;
    }

    public List<ProcessorStatusSnapshotDTO> getProcessorStatusSnapshotDtos()
    {
        return processorStatusSnapshotDtos;
    }

    public List<ProcessGroupStatusSnapshotDTO> getProcessGroupStatusSnapshotDtos()
    {
        return processGroupStatusSnapshotDtos;
    }

    public List<RemoteProcessGroupStatusSnapshotDTO> getRemoteProcessGroupStatusSnapshotDtos()
    {
        return remoteProcessGroupStatusSnapshotDtos;
    }

    public List<PortStatusSnapshotDTO> getInputPortStatusSnapshotDtos()
    {
        return inputPortStatusSnapshotDtos;
    }

    public List<PortStatusSnapshotDTO> getOutputPortStatusSnapshotDtos()
    {
        return outputPortStatusSnapshotDtos;
    }

    public static class Builder
    {
        private final List<ConnectionStatusSnapshotDTO> connectionStatusSnapshotDtos = new ArrayList<>();
        private final List<ProcessorStatusSnapshotDTO> processorStatusSnapshotDtos = new ArrayList<>();
        private final List<ProcessGroupStatusSnapshotDTO> processGroupStatusSnapshotDtos = new ArrayList<>();
        private final List<RemoteProcessGroupStatusSnapshotDTO> remoteProcessGroupStatusSnapshotDtos = new ArrayList<>();
        private final List<PortStatusSnapshotDTO> inputPortStatusSnapshotDtos = new ArrayList<>();
        private final List<PortStatusSnapshotDTO> outputPortStatusSnapshotDtos = new ArrayList<>();

        public Builder addConnectionStatusSnapshotDto(final ConnectionStatusSnapshotDTO connectionStatusSnapshotDto)
        {
            this.connectionStatusSnapshotDtos.add(connectionStatusSnapshotDto);
            return this;
        }

        public Builder addConnectionStatusSnapshotDtos(
                final Collection<ConnectionStatusSnapshotDTO> connectionStatusSnapshotDtos)
        {
            this.connectionStatusSnapshotDtos.addAll(connectionStatusSnapshotDtos);
            return this;
        }

        public Builder addProcessorStatusSnapshotDto(final ProcessorStatusSnapshotDTO processorStatusSnapshotDto)
        {
            this.processorStatusSnapshotDtos.add(processorStatusSnapshotDto);
            return this;
        }

        public Builder addProcessorStatusSnapshotDtos(final Collection<ProcessorStatusSnapshotDTO> processorStatusSnapshotDtos)
        {
            this.processorStatusSnapshotDtos.addAll(processorStatusSnapshotDtos);
            return this;
        }

        public Builder addProcessGroupStatusSnapshotDto(
                final ProcessGroupStatusSnapshotDTO processGroupStatusSnapshotDto)
        {
            this.processGroupStatusSnapshotDtos.add(processGroupStatusSnapshotDto);
            return this;
        }

        public Builder addProcessGroupStatusSnapshotDtos(
                final Collection<ProcessGroupStatusSnapshotDTO> processGroupStatusSnapshotDtos)
        {
            this.processGroupStatusSnapshotDtos.addAll(processGroupStatusSnapshotDtos);
            return this;
        }

        public Builder addRemoteProcessGroupStatusSnapshotDto(
                final RemoteProcessGroupStatusSnapshotDTO remoteProcessGroupStatusSnapshotDto)
        {
            this.remoteProcessGroupStatusSnapshotDtos.add(remoteProcessGroupStatusSnapshotDto);
            return this;
        }

        public Builder addRemoteProcessGroupStatusSnapshotDtos(
                final Collection<RemoteProcessGroupStatusSnapshotDTO> remoteProcessGroupStatusSnapshotDtos)
        {
            this.remoteProcessGroupStatusSnapshotDtos.addAll(remoteProcessGroupStatusSnapshotDtos);
            return this;
        }

        public Builder addInputPortStatusSnapshotDto(final PortStatusSnapshotDTO portStatusSnapshotDto)
        {
            this.inputPortStatusSnapshotDtos.add(portStatusSnapshotDto);
            return this;
        }

        public Builder addInputPortStatusSnapshotDtos(final Collection<PortStatusSnapshotDTO> portStatusSnapshotDtos)
        {
            this.inputPortStatusSnapshotDtos.addAll(portStatusSnapshotDtos);
            return this;
        }

        public Builder addOutputPortStatusSnapshotDto(final PortStatusSnapshotDTO portStatusSnapshotDto)
        {
            this.outputPortStatusSnapshotDtos.add(portStatusSnapshotDto);
            return this;
        }

        public Builder addOutputPortStatusSnapshotDtos(final Collection<PortStatusSnapshotDTO> portStatusSnapshotDtos)
        {
            this.outputPortStatusSnapshotDtos.addAll(portStatusSnapshotDtos);
            return this;
        }

        public ProcessGroupStatus build()
        {
            final ProcessGroupStatus processGroupStatus = new ProcessGroupStatus();
            processGroupStatus.connectionStatusSnapshotDtos = new ArrayList<>(this.connectionStatusSnapshotDtos);
            processGroupStatus.processorStatusSnapshotDtos = new ArrayList<>(this.processorStatusSnapshotDtos);
            processGroupStatus.processGroupStatusSnapshotDtos = new ArrayList<>(this.processGroupStatusSnapshotDtos);
            processGroupStatus.remoteProcessGroupStatusSnapshotDtos = new ArrayList<>(
                    this.remoteProcessGroupStatusSnapshotDtos);
            processGroupStatus.inputPortStatusSnapshotDtos = new ArrayList<>(this.inputPortStatusSnapshotDtos);
            processGroupStatus.outputPortStatusSnapshotDtos = new ArrayList<>(this.outputPortStatusSnapshotDtos);
            return processGroupStatus;
        }
    }
}
