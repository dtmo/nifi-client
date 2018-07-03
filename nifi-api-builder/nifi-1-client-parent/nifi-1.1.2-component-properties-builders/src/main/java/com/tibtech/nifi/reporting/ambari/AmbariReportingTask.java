package com.tibtech.nifi.reporting.ambari;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AmbariReportingTask {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.reporting.ambari.AmbariReportingTask";

  /**
   * The URL of the Ambari Metrics Collector Service
   */
  public static final String METRICS_COLLECTOR_URL_PROPERTY = "Metrics Collector URL";

  /**
   * The Application ID to be included in the metrics sent to Ambari
   */
  public static final String APPLICATION_ID_PROPERTY = "Application ID";

  /**
   * The Hostname of this NiFi instance to be included in the metrics sent to Ambari
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  private final Map<String, String> properties;

  public AmbariReportingTask() {
    this.properties = new HashMap<>();
  }

  public AmbariReportingTask(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The URL of the Ambari Metrics Collector Service
   */
  public final String getMetricsCollectorUrl() {
    return properties.get(METRICS_COLLECTOR_URL_PROPERTY);
  }

  /**
   * The URL of the Ambari Metrics Collector Service
   */
  public final AmbariReportingTask setMetricsCollectorUrl(final String metricsCollectorUrl) {
    properties.put(METRICS_COLLECTOR_URL_PROPERTY, metricsCollectorUrl);
    return this;
  }

  /**
   * The URL of the Ambari Metrics Collector Service
   */
  public final AmbariReportingTask removeMetricsCollectorUrl() {
    properties.remove(METRICS_COLLECTOR_URL_PROPERTY);
    return this;
  }

  /**
   * The Application ID to be included in the metrics sent to Ambari
   */
  public final String getApplicationId() {
    return properties.get(APPLICATION_ID_PROPERTY);
  }

  /**
   * The Application ID to be included in the metrics sent to Ambari
   */
  public final AmbariReportingTask setApplicationId(final String applicationId) {
    properties.put(APPLICATION_ID_PROPERTY, applicationId);
    return this;
  }

  /**
   * The Application ID to be included in the metrics sent to Ambari
   */
  public final AmbariReportingTask removeApplicationId() {
    properties.remove(APPLICATION_ID_PROPERTY);
    return this;
  }

  /**
   * The Hostname of this NiFi instance to be included in the metrics sent to Ambari
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The Hostname of this NiFi instance to be included in the metrics sent to Ambari
   */
  public final AmbariReportingTask setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The Hostname of this NiFi instance to be included in the metrics sent to Ambari
   */
  public final AmbariReportingTask removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AmbariReportingTask setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AmbariReportingTask removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<AmbariReportingTask, AmbariReportingTask> configurator) {
    return configurator.apply(new AmbariReportingTask()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AmbariReportingTask.class) final Closure<AmbariReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.reporting.ambari.AmbariReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.ambari.AmbariReportingTask.class, com.tibtech.nifi.reporting.ambari.AmbariReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AmbariReportingTask, AmbariReportingTask> configurator) {
    return configurator.apply(new AmbariReportingTask(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AmbariReportingTask.class) final Closure<AmbariReportingTask> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.reporting.ambari.AmbariReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.ambari.AmbariReportingTask.class, com.tibtech.nifi.reporting.ambari.AmbariReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
