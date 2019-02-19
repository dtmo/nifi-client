package com.tibtech.nifi.client;

public class SetScheduledStateRequest<T extends Schedulable<T>>
        implements AsynchronousRequest<SetScheduledStateRequest<T>>
{
    private T schedulable;

    private final boolean requestedRunning;

    public SetScheduledStateRequest(final T schedulable, final boolean requestedRunning)
    {
        this.schedulable = schedulable;
        this.requestedRunning = requestedRunning;
    }
    
    public T getSchedulable()
    {
        return schedulable;
    }

    public boolean isRequestedRunning()
    {
        return requestedRunning;
    }
    
    @Override
    public boolean isFinished()
    {
        return schedulable.getScheduledState().equals(ScheduledStates.RUNNING) == requestedRunning;
    }

    @Override
    public SetScheduledStateRequest<T> refresh()
    {
        schedulable = schedulable.refresh();
        return this;
    }
}
