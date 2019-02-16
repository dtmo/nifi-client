package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.RevisionDTO;

/**
 * Component represents an item in a NiFi Controller.
 */
public interface Component
{
    /**
     * Returns the controller to which the component belongs.
     *
     * @return The controller to which the component belongs.
     */
    Controller getController();

    /**
     * Returns the component ID.
     *
     * @return The component ID.
     */
    String getId();

    /**
     * Returns the component revision DTO.
     *
     * @return The component revision DTO.
     */
    RevisionDTO getRevisionDTO();
}
