package com.tibtech.nifi.client;

import java.time.Duration;
import java.time.Instant;

public interface AsynchronousRequest<T extends AsynchronousRequest<T>> extends Refreshable<T>
{
    boolean isFinished();

    T refresh();

    default T pollUntilFinished(final Duration pollingInterval, final Duration pollingDuration)
    {
        if (isFinished() == false)
        {
            final Instant end = Instant.now().plus(pollingDuration);
            do
            {
                try
                {
                    Thread.sleep(pollingDuration.toMillis());
                } catch (final InterruptedException e)
                {
                    // We were interrupted, so continue.
                }
                refresh();
            } while (isFinished() == false && Instant.now().isBefore(end));
        }
        return (T) this;
    }
}
