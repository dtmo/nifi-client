package com.tibtech.nifi.client;

/**
 * Parented marks a component as having a parent process group.
 */
public interface Parented extends Component
{
    /**
     * Returns the ID of process group containing the component.
     * 
     * @return The ID of process group containing the component.
     */
    String getParentGroupId();

    /**
     * Returns the parent process group.
     * 
     * @return The parent process group.
     */
    default ProcessGroup getParent()
    {
        return getController().getProcessGroup(getParentGroupId());
    }
}
