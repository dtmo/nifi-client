package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.template.ExportTemplateInvoker;
import com.tibtech.nifi.web.api.template.RemoveTemplateInvoker;
import org.apache.nifi.web.api.dto.TemplateDTO;
import org.apache.nifi.web.api.entity.TemplateEntity;

import java.util.Date;

/**
 * Template represents an snippet of flow components that may be instantiated
 * within a NiFi flow.
 */
public class Template extends AbstractComponent<TemplateEntity> implements Deletable
{
    /**
     * Constructs a new instance of Template.
     *
     * @param transport       The transport with which to communicate with the NiFi
     *                        server.
     * @param componentEntity The component entity.
     */
    public Template(final Transport transport, final TemplateEntity componentEntity)
    {
        super(transport, componentEntity);
    }

    /**
     * Returns the DTO that describes the template.
     *
     * @return The DTO that describes the template.
     */
    public TemplateDTO getTemplateDTO()
    {
        return getComponentEntity().getTemplate();
    }

    @Override
    public String getId()
    {
        return getTemplateDTO().getId();
    }

    public String getUri()
    {
        return getTemplateDTO().getUri();
    }

    public ProcessGroup getProcessGroup()
    {
        return ProcessGroup.get(getTransport(), getTemplateDTO().getGroupId());
    }

    public String getName()
    {
        return getTemplateDTO().getName();
    }

    public String getDescription()
    {
        return getTemplateDTO().getDescription();
    }

    public Date getTimestamp()
    {
        return getTemplateDTO().getTimestamp();
    }

    public String getEncodingVersion()
    {
        return getTemplateDTO().getEncodingVersion();
    }

//    public FlowSnippetDTO snippet;

    /**
     * Exports the template as an XML string.
     *
     * @return The XML string representing the template.
     * @throws InvokerException if there is a problem exporting the template.
     */
    public String export() throws InvokerException
    {
        return new ExportTemplateInvoker(getTransport(), 0)
                .setId(getId())
                .invoke();
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveTemplateInvoker(getTransport(), 0)
                .setId(getId())
                .invoke();
    }
}
