package com.tibtech.nifi.controller;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MonitorMemory {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.controller.MonitorMemory";

  /**
   * The name of the JVM Memory Pool to monitor
   */
  public static final String MEMORY_POOL_PROPERTY = "Memory Pool";

  /**
   * Indicates the threshold at which warnings should be generated
   */
  public static final String USAGE_THRESHOLD_PROPERTY = "Usage Threshold";

  /**
   * Indicates how often this reporting task should report bulletins while the memory utilization exceeds the configured threshold
   */
  public static final String REPORTING_INTERVAL_PROPERTY = "Reporting Interval";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The name of the JVM Memory Pool to monitor
   */
  public final String getMemoryPool() {
    return properties.get(MEMORY_POOL_PROPERTY);
  }

  /**
   * The name of the JVM Memory Pool to monitor
   */
  public final MonitorMemory setMemoryPool(final String memoryPool) {
    properties.put(MEMORY_POOL_PROPERTY, memoryPool);
    return this;
  }

  /**
   * The name of the JVM Memory Pool to monitor
   */
  public final MonitorMemory removeMemoryPool() {
    properties.remove(MEMORY_POOL_PROPERTY);
    return this;
  }

  /**
   * Indicates the threshold at which warnings should be generated
   */
  public final String getUsageThreshold() {
    return properties.get(USAGE_THRESHOLD_PROPERTY);
  }

  /**
   * Indicates the threshold at which warnings should be generated
   */
  public final MonitorMemory setUsageThreshold(final String usageThreshold) {
    properties.put(USAGE_THRESHOLD_PROPERTY, usageThreshold);
    return this;
  }

  /**
   * Indicates the threshold at which warnings should be generated
   */
  public final MonitorMemory removeUsageThreshold() {
    properties.remove(USAGE_THRESHOLD_PROPERTY);
    return this;
  }

  /**
   * Indicates how often this reporting task should report bulletins while the memory utilization exceeds the configured threshold
   */
  public final String getReportingInterval() {
    return properties.get(REPORTING_INTERVAL_PROPERTY);
  }

  /**
   * Indicates how often this reporting task should report bulletins while the memory utilization exceeds the configured threshold
   */
  public final MonitorMemory setReportingInterval(final String reportingInterval) {
    properties.put(REPORTING_INTERVAL_PROPERTY, reportingInterval);
    return this;
  }

  /**
   * Indicates how often this reporting task should report bulletins while the memory utilization exceeds the configured threshold
   */
  public final MonitorMemory removeReportingInterval() {
    properties.remove(REPORTING_INTERVAL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MonitorMemory setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MonitorMemory removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<MonitorMemory, MonitorMemory> configurator) {
    return configurator.apply(new MonitorMemory()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MonitorMemory.class) final Closure<MonitorMemory> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.controller.MonitorMemory> code = closure.rehydrate(c, com.tibtech.nifi.controller.MonitorMemory.class, com.tibtech.nifi.controller.MonitorMemory.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
