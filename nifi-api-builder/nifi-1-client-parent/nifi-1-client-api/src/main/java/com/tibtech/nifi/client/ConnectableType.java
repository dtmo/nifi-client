package com.tibtech.nifi.client;

/**
 * ConnectableType represents a type of connectable component.
 */
public enum ConnectableType
{
    /**
     * A processor.
     */
    PROCESSOR,

    /**
     * A remote input port.
     */
    REMOTE_INPUT_PORT,

    /**
     * A remote output port.
     */
    REMOTE_OUTPUT_PORT,

    /**
     * An input port.
     */
    INPUT_PORT,

    /**
     * An output port.
     */
    OUTPUT_PORT,

    /**
     * A funnel.
     */
    FUNNEL,
}
