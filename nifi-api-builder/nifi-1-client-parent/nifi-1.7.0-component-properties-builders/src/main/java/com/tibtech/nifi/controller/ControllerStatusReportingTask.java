package com.tibtech.nifi.controller;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ControllerStatusReportingTask {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.controller.ControllerStatusReportingTask";

  /**
   * Specifies whether or not to show the difference in values between the current status and the previous status
   */
  public static final String SHOW_DELTAS_PROPERTY = "Show Deltas";

  private final Map<String, String> properties;

  public ControllerStatusReportingTask() {
    this.properties = new HashMap<>();
  }

  public ControllerStatusReportingTask(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies whether or not to show the difference in values between the current status and the previous status
   */
  public final String getShowDeltas() {
    return properties.get(SHOW_DELTAS_PROPERTY);
  }

  /**
   * Specifies whether or not to show the difference in values between the current status and the previous status
   */
  public final ControllerStatusReportingTask setShowDeltas(final String showDeltas) {
    properties.put(SHOW_DELTAS_PROPERTY, showDeltas);
    return this;
  }

  /**
   * Specifies whether or not to show the difference in values between the current status and the previous status
   */
  public final ControllerStatusReportingTask removeShowDeltas() {
    properties.remove(SHOW_DELTAS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ControllerStatusReportingTask setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final ControllerStatusReportingTask removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ControllerStatusReportingTask, ControllerStatusReportingTask> configurator) {
    return configurator.apply(new ControllerStatusReportingTask()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerStatusReportingTask.class) final Closure<ControllerStatusReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.controller.ControllerStatusReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.controller.ControllerStatusReportingTask.class, com.tibtech.nifi.controller.ControllerStatusReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ControllerStatusReportingTask, ControllerStatusReportingTask> configurator) {
    return configurator.apply(new ControllerStatusReportingTask(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerStatusReportingTask.class) final Closure<ControllerStatusReportingTask> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.controller.ControllerStatusReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.controller.ControllerStatusReportingTask.class, com.tibtech.nifi.controller.ControllerStatusReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
