package com.tibtech.nifi.client;

/**
 * EnabledStates defines the different enabled states.
 */
public class EnabledStates
{
    /**
     * Controller Service is disabled and cannot be used.
     */
    public static final String DISABLED = "DISABLED";

    /**
     * Controller Service has been disabled but has not yet finished its lifecycle
     * methods.
     */
    public static final String DISABLING = "DISABLING";

    /**
     * Controller Service has been enabled but has not yet finished its lifecycle
     * methods.
     */
    public static final String ENABLING = "ENABLING";

    /**
     * Controller Service has been enabled and has finished its lifecycle methods.
     * The Controller Service is ready to be used.
     */
    public static final String ENABLED = "ENABLED";

    private EnabledStates()
    {
        // Private constructor.
    }
}
