package com.tibtech.nifi.client;

import groovy.lang.Closure;
import org.apache.nifi.web.api.entity.ComponentEntity;

/**
 * UpdatableComponent may be extended by a component that can be
 * updated.
 *
 * @param <T> The type of component.
 * @param <E> The type of component entity returned when an update is performed.
 * @param <B> The type of DTO builder used during component updates.
 */
public abstract class UpdatableComponent<T extends UpdatableComponent<T, E, B>, E extends ComponentEntity, B>
        extends AbstractComponent<E> implements Updatable<T, B>
{
    /**
     * Constructs a new instance of UpdatableComponent
     *
     * @param transport       The transport with which to communicate with the NiFi
     *                        server.
     * @param componentEntity The component entity.
     */
    protected UpdatableComponent(final Transport transport, final E componentEntity)
    {
        super(transport, componentEntity);
    }

    /*
     * Subclasses are advised to override this method so that the @DelegatesTo
     * annotation may be used on method arguments.
     */
    @Override
    public T update(final Closure<B> closure) throws InvokerException
    {
        return update(configurator -> {
            final Closure<B> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }
}
