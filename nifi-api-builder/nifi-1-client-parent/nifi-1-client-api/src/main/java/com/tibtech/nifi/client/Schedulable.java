package com.tibtech.nifi.client;

import java.time.Duration;

public interface Schedulable<T extends Schedulable<T>> extends Refreshable<T>
{
    String getScheduledState();

    SetScheduledStateRequest<T> createSetScheduledStateRequest(boolean running);

    default T start(final Duration pollingInterval, final Duration pollingDuration)
    {
        createSetScheduledStateRequest(true).pollUntilFinished(pollingInterval, pollingDuration);
        return (T) this;
    }

    default T start()
    {
        return start(Duration.ofMillis(500), Duration.ofMinutes(2));
    }

    default T stop(final Duration pollingInterval, final Duration pollingDuration)
    {
        createSetScheduledStateRequest(false).pollUntilFinished(pollingInterval, pollingDuration);
        return (T) this;
    }

    default T stop()
    {
        return stop(Duration.ofMillis(500), Duration.ofMinutes(2));
    }
}
