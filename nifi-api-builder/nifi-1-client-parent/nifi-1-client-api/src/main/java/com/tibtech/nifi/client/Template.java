package com.tibtech.nifi.client;

import com.tibtech.nifi.web.api.template.ExportTemplateInvoker;
import com.tibtech.nifi.web.api.template.RemoveTemplateInvoker;
import org.apache.nifi.web.api.dto.TemplateDTO;
import org.apache.nifi.web.api.entity.TemplateEntity;

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

    /**
     * Exports the template as an XML string.
     *
     * @return The XML string representing the template.
     * @throws InvokerException if there is a problem exporting the template.
     */
    public String export() throws InvokerException
    {
        return new ExportTemplateInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke();
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveTemplateInvoker(getTransport(), getRevisionDTO().getVersion())
                .setId(getId())
                .invoke();
    }
}
