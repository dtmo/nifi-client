package com.tibtech.nifi.client;

import java.time.Duration;
import java.time.Instant;

/**
 * AsynchronousRequest represents a request that is processed asynchronously by
 * NiFi and may be periodically refreshed to update its status.
 *
 * @param <T> The type of request.
 */
public interface AsynchronousRequest<T extends AsynchronousRequest<T>> extends Refreshable<T>
{
    /**
     * Returns whether the request is finished or not.
     * 
     * @return Whether the request is finished or not.
     */
    boolean isFinished();

    /**
     * Refreshes the state of the request.
     */
    T refresh();

    /**
     * Polls the request until it is finished or until the polling duration is
     * exceeded. This method is useful for synchronous code that needs to trigger an
     * asynchronous request an not proceed until the request is finished.
     * 
     * @param pollingInterval The interval to wait between refreshing the state of
     *                        the request.
     * @param pollingDuration The amount of time to spent refreshing the request if
     *                        it is not finished.
     * @return This request.
     */
    default T pollUntilFinished(final Duration pollingInterval, final Duration pollingDuration)
    {
        refresh();

        if (isFinished() == false)
        {
            final Instant end = Instant.now().plus(pollingDuration);
            do
            {
                try
                {
                    Thread.sleep(pollingDuration.toMillis());
                }
                catch (final InterruptedException e)
                {
                    // We were interrupted, so continue.
                }
                refresh();
            } while (isFinished() == false && Instant.now().isBefore(end));
        }
        return (T) this;
    }
}
