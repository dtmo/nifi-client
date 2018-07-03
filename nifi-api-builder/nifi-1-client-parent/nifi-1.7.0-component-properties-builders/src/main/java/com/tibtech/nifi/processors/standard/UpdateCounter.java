package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class UpdateCounter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.UpdateCounter";

  /**
   * The name of the counter you want to set the value off - supports expression language like ${counterName}
   */
  public static final String COUNTER_NAME_PROPERTY = "counter-name";

  /**
   * Adjusts the counter by the specified delta for each flow file received. May be a positive or negative integer.
   */
  public static final String DELTA_PROPERTY = "delta";

  private final Map<String, String> properties;

  public UpdateCounter() {
    this.properties = new HashMap<>();
  }

  public UpdateCounter(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the counter you want to set the value off - supports expression language like ${counterName}
   */
  public final String getCounterName() {
    return properties.get(COUNTER_NAME_PROPERTY);
  }

  /**
   * The name of the counter you want to set the value off - supports expression language like ${counterName}
   */
  public final UpdateCounter setCounterName(final String counterName) {
    properties.put(COUNTER_NAME_PROPERTY, counterName);
    return this;
  }

  /**
   * The name of the counter you want to set the value off - supports expression language like ${counterName}
   */
  public final UpdateCounter removeCounterName() {
    properties.remove(COUNTER_NAME_PROPERTY);
    return this;
  }

  /**
   * Adjusts the counter by the specified delta for each flow file received. May be a positive or negative integer.
   */
  public final String getDelta() {
    return properties.get(DELTA_PROPERTY);
  }

  /**
   * Adjusts the counter by the specified delta for each flow file received. May be a positive or negative integer.
   */
  public final UpdateCounter setDelta(final String delta) {
    properties.put(DELTA_PROPERTY, delta);
    return this;
  }

  /**
   * Adjusts the counter by the specified delta for each flow file received. May be a positive or negative integer.
   */
  public final UpdateCounter removeDelta() {
    properties.remove(DELTA_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final UpdateCounter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final UpdateCounter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<UpdateCounter, UpdateCounter> configurator) {
    return configurator.apply(new UpdateCounter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateCounter.class) final Closure<UpdateCounter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.UpdateCounter> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.UpdateCounter.class, com.tibtech.nifi.processors.standard.UpdateCounter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<UpdateCounter, UpdateCounter> configurator) {
    return configurator.apply(new UpdateCounter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateCounter.class) final Closure<UpdateCounter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.UpdateCounter> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.UpdateCounter.class, com.tibtech.nifi.processors.standard.UpdateCounter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
