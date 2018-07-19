package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.entity.CreateTemplateRequestEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateTemplateInvoker;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.SnippetDTO;
import org.apache.nifi.web.api.entity.SnippetEntity;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Snippet represents a collection of components from a process group.
 */
public class Snippet
{
    private final ProcessGroup processGroup;

    private SnippetEntity snippetEntity;

    /**
     * Constructs a new instance of Snippet.
     *
     * @param processGroup  The process group containing the snippet components.
     * @param snippetEntity The snippet entity representing the snippet.
     */
    public Snippet(final ProcessGroup processGroup, final SnippetEntity snippetEntity)
    {
        this.processGroup = processGroup;
        this.snippetEntity = snippetEntity;
    }

    /**
     * Returns the DTO describing the snippet.
     *
     * @return The DTO describing the snippet.
     */
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

    /**
     * Returns the connections included in the snippet.
     *
     * @return The connections included in the snippet.
     */
    public Set<Connection> getConnections()
    {
        return getSnippetDTO().getConnections().keySet().stream()
                .map(id -> Connection.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the funnels included in the snippet.
     *
     * @return The funnels included in the snippet.
     */
    public Set<Funnel> getFunnels()
    {
        return getSnippetDTO().getFunnels().keySet().stream()
                .map(id -> Funnel.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the input ports included in the snippet.
     *
     * @return The input ports included in the snippet.
     */
    public Set<InputPort> getInputPorts()
    {
        return getSnippetDTO().getInputPorts().keySet().stream()
                .map(id -> InputPort.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the labels included in the snippet.
     *
     * @return The labels included in the snippet.
     */
    public Set<Label> getLabels()
    {
        return getSnippetDTO().getLabels().keySet().stream()
                .map(id -> Label.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the output ports included in the snippet.
     *
     * @return The output ports included in the snippet.
     */
    public Set<OutputPort> getOutputPorts()
    {
        return getSnippetDTO().getOutputPorts().keySet().stream()
                .map(id -> OutputPort.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the process groups included in the snippet.
     *
     * @return The process groups included in the snippet.
     */
    public Set<ProcessGroup> getProcessGroups()
    {
        return getSnippetDTO().getProcessGroups().keySet().stream()
                .map(id -> ProcessGroup.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the processors included in the snippet.
     *
     * @return The processors included in the snippet.
     */
    public Set<Processor> getProcessors()
    {
        return getSnippetDTO().getProcessors().keySet().stream()
                .map(id -> Processor.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the remote process groups included in the snippet.
     *
     * @return The remote process groups included in the snippet.
     */
    public Set<RemoteProcessGroup> getRemoteProcessGroups()
    {
        return getSnippetDTO().getRemoteProcessGroups().keySet().stream()
                .map(id -> RemoteProcessGroup.get(processGroup.getTransport(), id))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new template representing the contents of the snippet.
     *
     * @param name        The name for the template.
     * @param description A description of the template.
     * @return The new template.
     * @throws InvokerException if there is a problem creating the template.
     */
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

    /**
     * Creates a new template representing the contents of the snippet.
     *
     * @param name The name for the template.
     * @return The new template.
     * @throws InvokerException if there is a problem creating the template.
     */
    public Template createTemplate(final String name) throws InvokerException
    {
        return createTemplate(name, null);
    }

    /**
     * SnippetDTOBuilder provides a convenient API with which to construct instances of {@link SnippetDTO} from
     * instances of client API components.
     */
    public static class SnippetDTOBuilder
    {
        private String id;
        private String uri;
        private ProcessGroup parentGroup;

        private Set<ProcessGroup> processGroups = new HashSet<>();
        private Set<RemoteProcessGroup> remoteProcessGroups = new HashSet<>();
        private Set<Processor> processors = new HashSet<>();
        private Set<InputPort> inputPorts = new HashSet<>();
        private Set<OutputPort> outputPorts = new HashSet<>();
        private Set<Connection> connections = new HashSet<>();
        private Set<Label> labels = new HashSet<>();
        private Set<Funnel> funnels = new HashSet<>();

        /**
         * Sets the snippet ID.
         *
         * @param id The ID to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setId(final String id)
        {
            this.id = id;
            return this;
        }

        /**
         * Returns the snippet ID.
         *
         * @return The snippet ID.
         */
        public String getId()
        {
            return this.id;
        }

        /**
         * Sets the snippet URI.
         *
         * @param uri The URI to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setUri(final String uri)
        {
            this.uri = uri;
            return this;
        }

        /**
         * Returns the snippet URI.
         *
         * @return The snippet URI.
         */
        public String getUri()
        {
            return this.uri;
        }

        /**
         * Sets the parent process group containing the snippet components.
         *
         * @param parentGroup The parent process group to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setParentGroup(final ProcessGroup parentGroup)
        {
            this.parentGroup = parentGroup;
            return this;
        }

        /**
         * Returns the parent process group containing the snippet components.
         *
         * @return The parent process group containing the snippet components.
         */
        public ProcessGroup getParentGroup()
        {
            return parentGroup;
        }

        /**
         * Adds a process group to the set to include in the built SnippetDTO.
         *
         * @param processGroup The process group to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addProcessGroup(final ProcessGroup processGroup)
        {
            this.processGroups.add(processGroup);
            return this;
        }

        /**
         * Sets the set of process groups to include in the built SnippetDTO.
         *
         * @param processGroups The process groups to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setProcessGroups(final Collection<ProcessGroup> processGroups)
        {
            this.processGroups.clear();
            this.processGroups.addAll(processGroups);
            return this;
        }

        /**
         * Returns the set of process groups to include in the built SnippetDTO.
         *
         * @return The set of process groups to include in the built SnippetDTO.
         */
        public Set<ProcessGroup> getProcessGroups()
        {
            return this.processGroups;
        }

        /**
         * Adds a remote process group to the set to include in the built SnippetDTO.
         *
         * @param remoteProcessGroup The remote process group to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addRemoteProcessGroup(final RemoteProcessGroup remoteProcessGroup)
        {
            this.remoteProcessGroups.add(remoteProcessGroup);
            return this;
        }

        /**
         * Sets the set of remote process groups to include in the built SnippetDTO.
         *
         * @param remoteProcessGroups The remote process groups to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setRemoteProcessGroups(final Collection<RemoteProcessGroup> remoteProcessGroups)
        {
            this.remoteProcessGroups.clear();
            this.remoteProcessGroups.addAll(remoteProcessGroups);
            return this;
        }

        /**
         * Returns the set of remote process groups to include in the built SnippetDTO.
         *
         * @return The set of remote process groups to include in the built SnippetDTO.
         */
        public Set<RemoteProcessGroup> getRemoteProcessGroups()
        {
            return this.remoteProcessGroups;
        }

        /**
         * Adds a processor to the set to include in the built SnippetDTO.
         *
         * @param processor The processor to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addProcessor(final Processor processor)
        {
            this.processors.add(processor);
            return this;
        }

        /**
         * Sets the set of processors to include in the built SnippetDTO.
         *
         * @param processors The processors to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setProcessors(final Collection<Processor> processors)
        {
            this.processors.clear();
            this.processors.addAll(processors);
            return this;
        }

        /**
         * Returns the set of processors to include in the built SnippetDTO.
         *
         * @return The set of processors to include in the built SnippetDTO.
         */
        public Set<Processor> getProcessors()
        {
            return this.processors;
        }

        /**
         * Adds an input port to the set to include in the built SnippetDTO.
         *
         * @param inputPort The input port to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addInputPort(final InputPort inputPort)
        {
            this.inputPorts.add(inputPort);
            return this;
        }

        /**
         * Sets the set of input ports to include in the built SnippetDTO.
         *
         * @param inputPorts The input ports to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setInputPorts(final Collection<InputPort> inputPorts)
        {
            this.inputPorts.clear();
            this.inputPorts.addAll(inputPorts);
            return this;
        }

        /**
         * Returns the set of input ports to include in the built SnippetDTO.
         *
         * @return The set of input ports to include in the built SnippetDTO.
         */
        public Set<InputPort> getInputPorts()
        {
            return this.inputPorts;
        }

        /**
         * Adds an output port to the set to include in the built SnippetDTO.
         *
         * @param outputPort The output port to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addOutputPort(final OutputPort outputPort)
        {
            this.outputPorts.add(outputPort);
            return this;
        }

        /**
         * Sets the set of output ports to include in the built SnippetDTO.
         *
         * @param outputPorts The output ports to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setOutputPorts(final Collection<OutputPort> outputPorts)
        {
            this.outputPorts.clear();
            this.outputPorts.addAll(outputPorts);
            return this;
        }

        /**
         * Returns the set of output ports to include in the built SnippetDTO.
         *
         * @return The set of output ports to include in the built SnippetDTO.
         */
        public Set<OutputPort> getOutputPorts()
        {
            return this.outputPorts;
        }

        /**
         * Adds a connection to the set to include in the built SnippetDTO.
         *
         * @param connection The connection to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addConnection(final Connection connection)
        {
            this.connections.add(connection);
            return this;
        }

        /**
         * Sets the set of connections to include in the built SnippetDTO.
         *
         * @param connections The connections to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setConnections(final Collection<Connection> connections)
        {
            this.connections.clear();
            this.connections.addAll(connections);
            return this;
        }

        /**
         * Returns the set of connections to include in the built SnippetDTO.
         *
         * @return The set of connections to include in the built SnippetDTO.
         */
        public Set<Connection> getConnections()
        {
            return this.connections;
        }

        /**
         * Adds a label to the set to include in the built SnippetDTO.
         *
         * @param label The label to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addLabel(final Label label)
        {
            this.labels.add(label);
            return this;
        }

        /**
         * Sets the set of labels to include in the built SnippetDTO.
         *
         * @param labels The labels to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setLabels(final Collection<Label> labels)
        {
            this.labels.clear();
            this.labels.addAll(labels);
            return this;
        }

        /**
         * Returns the set of labels to include in the built SnippetDTO.
         *
         * @return The set of labels to include in the built SnippetDTO.
         */
        public Set<Label> getLabels()
        {
            return this.labels;
        }

        /**
         * Adds a funnel to the set to include in the built SnippetDTO.
         *
         * @param funnel The funnel to add.
         * @return This builder.
         */
        public SnippetDTOBuilder addFunnel(final Funnel funnel)
        {
            this.funnels.add(funnel);
            return this;
        }

        /**
         * Sets the set of funnels to include in the built SnippetDTO.
         *
         * @param funnels The funnels to set.
         * @return This builder.
         */
        public SnippetDTOBuilder setFunnels(final Collection<Funnel> funnels)
        {
            this.funnels.clear();
            this.funnels.addAll(funnels);
            return this;
        }

        /**
         * Returns the set of funnels to include in the built SnippetDTO.
         *
         * @return The set of funnels to include in the built SnippetDTO.
         */
        public Set<Funnel> getFunnels()
        {
            return this.funnels;
        }

        /**
         * Builds a new instance of SnippetDTO based on the builder configuration.
         *
         * @return A new instance of SnippetDTO.
         */
        public SnippetDTO build()
        {
            final SnippetDTO snippetDTO = new SnippetDTO();

            snippetDTO.setId(this.id);

            snippetDTO.setUri(this.uri);

            snippetDTO.setParentGroupId(this.parentGroup.getId());

            final Map<String, RevisionDTO> processGroups = new HashMap<>();
            for (final ProcessGroup processGroup : this.processGroups)
            {
                processGroups.put(processGroup.getId(), processGroup.getRevisionDTO());
            }
            snippetDTO.setProcessGroups(processGroups);

            final Map<String, RevisionDTO> remoteProcessGroups = new HashMap<>();
            for (final RemoteProcessGroup remoteProcessGroup : this.remoteProcessGroups)
            {
                remoteProcessGroups.put(remoteProcessGroup.getId(), remoteProcessGroup.getRevisionDTO());
            }
            snippetDTO.setRemoteProcessGroups(remoteProcessGroups);

            final Map<String, RevisionDTO> processors = new HashMap<>();
            for (final Processor processor : this.processors)
            {
                remoteProcessGroups.put(processor.getId(), processor.getRevisionDTO());
            }
            snippetDTO.setProcessors(processors);


            final Map<String, RevisionDTO> inputPorts = new HashMap<>();
            for (final InputPort inputPort : this.inputPorts)
            {
                remoteProcessGroups.put(inputPort.getId(), inputPort.getRevisionDTO());
            }
            snippetDTO.setInputPorts(inputPorts);


            final Map<String, RevisionDTO> outputPorts = new HashMap<>();
            for (final OutputPort outputPort : this.outputPorts)
            {
                remoteProcessGroups.put(outputPort.getId(), outputPort.getRevisionDTO());
            }
            snippetDTO.setOutputPorts(outputPorts);


            final Map<String, RevisionDTO> connections = new HashMap<>();
            for (final Connection connection : this.connections)
            {
                remoteProcessGroups.put(connection.getId(), connection.getRevisionDTO());
            }
            snippetDTO.setConnections(connections);


            final Map<String, RevisionDTO> labels = new HashMap<>();
            for (final Label label : this.labels)
            {
                remoteProcessGroups.put(label.getId(), label.getRevisionDTO());
            }
            snippetDTO.setLabels(labels);


            final Map<String, RevisionDTO> funnels = new HashMap<>();
            for (final Funnel funnel : this.funnels)
            {
                remoteProcessGroups.put(funnel.getId(), funnel.getRevisionDTO());
            }
            snippetDTO.setFunnels(funnels);

            return snippetDTO;
        }
    }
}
