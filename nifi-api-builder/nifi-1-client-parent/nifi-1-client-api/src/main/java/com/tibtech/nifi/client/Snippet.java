package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.entity.CreateTemplateRequestEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateTemplateInvoker;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.SnippetDTO;
import org.apache.nifi.web.api.entity.SnippetEntity;

import java.util.*;
import java.util.stream.Collectors;

public class Snippet
{
    private final ProcessGroup processGroup;

    private SnippetEntity snippetEntity;

    public Snippet(final ProcessGroup processGroup, final SnippetEntity snippetEntity)
    {
        this.processGroup = processGroup;
        this.snippetEntity = snippetEntity;
    }

    protected SnippetDTO getSnippetDTO()
    {
        return snippetEntity.getSnippet();
    }

    /**
     * Returns the ID of the snippet.
     *
     * @return The ID of the snippet.
     */
    public String getId()
    {
        return getSnippetDTO().getId();
    }

    /**
     * Returns the URI of the snippet.
     *
     * @return The URI of the snippet.
     */
    public String getUri()
    {
        return getSnippetDTO().getUri();
    }

    /**
     * Returns the parent process group.
     *
     * @return The parent process group.
     */
    public ProcessGroup getProcessGroup()
    {
        return processGroup;
    }

    public Set<Connection> getConnections()
    {
        return getSnippetDTO().getConnections().keySet().stream()
                .map(id -> Connection.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<Funnel> getFunnels()
    {
        return getSnippetDTO().getFunnels().keySet().stream()
                .map(id -> Funnel.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<InputPort> getInputPorts()
    {
        return getSnippetDTO().getInputPorts().keySet().stream()
                .map(id -> InputPort.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<Label> getLabels()
    {
        return getSnippetDTO().getLabels().keySet().stream()
                .map(id -> Label.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<OutputPort> getOutputPorts()
    {
        return getSnippetDTO().getOutputPorts().keySet().stream()
                .map(id -> OutputPort.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<ProcessGroup> getProcessGroups()
    {
        return getSnippetDTO().getProcessGroups().keySet().stream()
                .map(id -> ProcessGroup.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<Processor> getProcessors()
    {
        return getSnippetDTO().getProcessors().keySet().stream()
                .map(id -> Processor.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Set<RemoteProcessGroup> getRemoteProcessGroups()
    {
        return getSnippetDTO().getRemoteProcessGroups().keySet().stream()
                .map(id -> RemoteProcessGroup.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    public Template createTemplate(final String name, final String description) throws InvokerException
    {
        return new Template(processGroup.getTransport(), new CreateTemplateInvoker(processGroup.getTransport(), 0)
                .setId(processGroup.getId())
                .setCreateTemplateRequestEntity(new CreateTemplateRequestEntityBuilder()
                        .setName(name)
                        .setSnippetId(getId())
                        .setDescription(description)
                        .build())
                .invoke());
    }

    public Template createTemplate(final String name) throws InvokerException
    {
        return createTemplate(name, null);
    }

    public static class SnippetDTOBuilder
    {
        private String id;
        private String uri;
        private String parentGroupId;

        private Set<ProcessGroup> processGroups = new HashSet<>();
        private Set<RemoteProcessGroup> remoteProcessGroups = new HashSet<>();
        private Set<Processor> processors = new HashSet<>();
        private Set<InputPort> inputPorts = new HashSet<>();
        private Set<OutputPort> outputPorts = new HashSet<>();
        private Set<Connection> connections = new HashSet<>();
        private Set<Label> labels = new HashSet<>();
        private Set<Funnel> funnels = new HashSet<>();

        public SnippetDTOBuilder setId(final String id)
        {
            this.id = id;
            return this;
        }

        public String getId()
        {
            return this.id;
        }

        public SnippetDTOBuilder setUri(final String uri)
        {
            this.uri = uri;
            return this;
        }

        public String getUri()
        {
            return this.uri;
        }

        public SnippetDTOBuilder setParentGroupId(final String parentGroupId)
        {
            this.parentGroupId = parentGroupId;
            return this;
        }

        public String getParentGroupId()
        {
            return parentGroupId;
        }

        public SnippetDTOBuilder addProcessGroup(final ProcessGroup processGroup)
        {
            this.processGroups.add(processGroup);
            return this;
        }

        public SnippetDTOBuilder setProcessGroups(final Collection<ProcessGroup> processGroups)
        {
            this.processGroups.clear();
            this.processGroups.addAll(processGroups);
            return this;
        }

        public Set<ProcessGroup> getProcessGroups()
        {
            return this.processGroups;
        }

        public SnippetDTOBuilder addRemoteProcessGroup(final RemoteProcessGroup remoteProcessGroup)
        {
            this.remoteProcessGroups.add(remoteProcessGroup);
            return this;
        }

        public SnippetDTOBuilder setRemoteProcessGroups(final Collection<RemoteProcessGroup> remoteProcessGroups)
        {
            this.remoteProcessGroups.clear();
            this.remoteProcessGroups.addAll(remoteProcessGroups);
            return this;
        }

        public Set<RemoteProcessGroup> getRemoteProcessGroups()
        {
            return this.remoteProcessGroups;
        }

        public SnippetDTOBuilder addProcessor(final Processor processor)
        {
            this.processors.add(processor);
            return this;
        }

        public SnippetDTOBuilder setProcessors(final Collection<Processor> processors)
        {
            this.processors.clear();
            this.processors.addAll(processors);
            return this;
        }

        public Set<Processor> getProcessors()
        {
            return this.processors;
        }

        public SnippetDTOBuilder addInputPort(final InputPort inputPort)
        {
            this.inputPorts.add(inputPort);
            return this;
        }

        public SnippetDTOBuilder setInputPorts(final Collection<InputPort> inputPorts)
        {
            this.inputPorts.clear();
            this.inputPorts.addAll(inputPorts);
            return this;
        }

        public Set<InputPort> getInputPorts()
        {
            return this.inputPorts;
        }

        public SnippetDTOBuilder addOutputPort(final OutputPort outputPort)
        {
            this.outputPorts.add(outputPort);
            return this;
        }

        public SnippetDTOBuilder setOutputPorts(final Collection<OutputPort> outputPorts)
        {
            this.outputPorts.clear();
            this.outputPorts.addAll(outputPorts);
            return this;
        }

        public Set<OutputPort> getOutputPorts()
        {
            return this.outputPorts;
        }

        public SnippetDTOBuilder addConnection(final Connection connection)
        {
            this.connections.add(connection);
            return this;
        }

        public SnippetDTOBuilder setConnections(final Collection<Connection> connections)
        {
            this.connections.clear();
            this.connections.addAll(connections);
            return this;
        }

        public Set<Connection> getConnections()
        {
            return this.connections;
        }

        public SnippetDTOBuilder addLabel(final Label label)
        {
            this.labels.add(label);
            return this;
        }

        public SnippetDTOBuilder setLabels(final Collection<Label> labels)
        {
            this.labels.clear();
            this.labels.addAll(labels);
            return this;
        }

        public Set<Label> getLabels()
        {
            return this.labels;
        }

        public SnippetDTOBuilder addFunnel(final Funnel funnel)
        {
            this.funnels.add(funnel);
            return this;
        }

        public SnippetDTOBuilder setFunnels(final Collection<Funnel> funnels)
        {
            this.funnels.clear();
            this.funnels.addAll(funnels);
            return this;
        }

        public Set<Funnel> getFunnels()
        {
            return this.funnels;
        }

        public SnippetDTO build()
        {
            final SnippetDTO snippetDTO = new SnippetDTO();

            snippetDTO.setId(this.id);

            snippetDTO.setUri(this.uri);

            snippetDTO.setParentGroupId(this.parentGroupId);

            final Map<String, RevisionDTO> processGroups = new HashMap<>();
            for (final ProcessGroup processGroup : this.processGroups)
            {
                processGroups.put(processGroup.getId(), processGroup.getRevision());
            }
            snippetDTO.setProcessGroups(processGroups);

            final Map<String, RevisionDTO> remoteProcessGroups = new HashMap<>();
            for (final RemoteProcessGroup remoteProcessGroup : this.remoteProcessGroups)
            {
                remoteProcessGroups.put(remoteProcessGroup.getId(), remoteProcessGroup.getRevision());
            }
            snippetDTO.setRemoteProcessGroups(remoteProcessGroups);

            final Map<String, RevisionDTO> processors = new HashMap<>();
            for (final Processor processor : this.processors)
            {
                remoteProcessGroups.put(processor.getId(), processor.getRevision());
            }
            snippetDTO.setProcessors(processors);


            final Map<String, RevisionDTO> inputPorts = new HashMap<>();
            for (final InputPort inputPort : this.inputPorts)
            {
                remoteProcessGroups.put(inputPort.getId(), inputPort.getRevision());
            }
            snippetDTO.setInputPorts(inputPorts);


            final Map<String, RevisionDTO> outputPorts = new HashMap<>();
            for (final OutputPort outputPort : this.outputPorts)
            {
                remoteProcessGroups.put(outputPort.getId(), outputPort.getRevision());
            }
            snippetDTO.setOutputPorts(outputPorts);


            final Map<String, RevisionDTO> connections = new HashMap<>();
            for (final Connection connection : this.connections)
            {
                remoteProcessGroups.put(connection.getId(), connection.getRevision());
            }
            snippetDTO.setConnections(connections);


            final Map<String, RevisionDTO> labels = new HashMap<>();
            for (final Label label : this.labels)
            {
                remoteProcessGroups.put(label.getId(), label.getRevision());
            }
            snippetDTO.setLabels(labels);


            final Map<String, RevisionDTO> funnels = new HashMap<>();
            for (final Funnel funnel : this.funnels)
            {
                remoteProcessGroups.put(funnel.getId(), funnel.getRevision());
            }
            snippetDTO.setFunnels(funnels);

            return snippetDTO;
        }
    }
}
