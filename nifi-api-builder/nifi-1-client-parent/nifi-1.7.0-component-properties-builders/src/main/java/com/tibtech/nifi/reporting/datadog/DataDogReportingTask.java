package com.tibtech.nifi.reporting.datadog;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DataDogReportingTask {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.reporting.datadog.DataDogReportingTask";

  /**
   * Prefix to be added before every metric
   */
  public static final String METRICS_PREFIX_PROPERTY = "Metrics prefix";

  /**
   * Environment, dataflow is running in. This property will be included as metrics tag.
   */
  public static final String ENVIRONMENT_PROPERTY = "Environment";

  /**
   * Datadog API key. If specified value is 'agent', local Datadog agent will be used.
   */
  public static final String API_KEY_PROPERTY = "API key";

  /**
   * Transport through which metrics will be sent to Datadog
   */
  public static final String DATADOG_TRANSPORT_PROPERTY = "Datadog transport";

  private final Map<String, String> properties;

  public DataDogReportingTask() {
    this.properties = new HashMap<>();
  }

  public DataDogReportingTask(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Prefix to be added before every metric
   */
  public final String getMetricsPrefix() {
    return properties.get(METRICS_PREFIX_PROPERTY);
  }

  /**
   * Prefix to be added before every metric
   */
  public final DataDogReportingTask setMetricsPrefix(final String metricsPrefix) {
    properties.put(METRICS_PREFIX_PROPERTY, metricsPrefix);
    return this;
  }

  /**
   * Prefix to be added before every metric
   */
  public final DataDogReportingTask removeMetricsPrefix() {
    properties.remove(METRICS_PREFIX_PROPERTY);
    return this;
  }

  /**
   * Environment, dataflow is running in. This property will be included as metrics tag.
   */
  public final String getEnvironment() {
    return properties.get(ENVIRONMENT_PROPERTY);
  }

  /**
   * Environment, dataflow is running in. This property will be included as metrics tag.
   */
  public final DataDogReportingTask setEnvironment(final String environment) {
    properties.put(ENVIRONMENT_PROPERTY, environment);
    return this;
  }

  /**
   * Environment, dataflow is running in. This property will be included as metrics tag.
   */
  public final DataDogReportingTask removeEnvironment() {
    properties.remove(ENVIRONMENT_PROPERTY);
    return this;
  }

  /**
   * Datadog API key. If specified value is 'agent', local Datadog agent will be used.
   */
  public final String getApiKey() {
    return properties.get(API_KEY_PROPERTY);
  }

  /**
   * Datadog API key. If specified value is 'agent', local Datadog agent will be used.
   */
  public final DataDogReportingTask setApiKey(final String apiKey) {
    properties.put(API_KEY_PROPERTY, apiKey);
    return this;
  }

  /**
   * Datadog API key. If specified value is 'agent', local Datadog agent will be used.
   */
  public final DataDogReportingTask removeApiKey() {
    properties.remove(API_KEY_PROPERTY);
    return this;
  }

  /**
   * Transport through which metrics will be sent to Datadog
   */
  public final String getDatadogTransport() {
    return properties.get(DATADOG_TRANSPORT_PROPERTY);
  }

  /**
   * Transport through which metrics will be sent to Datadog
   */
  public final DataDogReportingTask setDatadogTransport(final String datadogTransport) {
    properties.put(DATADOG_TRANSPORT_PROPERTY, datadogTransport);
    return this;
  }

  /**
   * Transport through which metrics will be sent to Datadog
   */
  public final DataDogReportingTask removeDatadogTransport() {
    properties.remove(DATADOG_TRANSPORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DataDogReportingTask setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DataDogReportingTask removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DataDogReportingTask, DataDogReportingTask> configurator) {
    return configurator.apply(new DataDogReportingTask()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DataDogReportingTask.class) final Closure<DataDogReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.reporting.datadog.DataDogReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.datadog.DataDogReportingTask.class, com.tibtech.nifi.reporting.datadog.DataDogReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DataDogReportingTask, DataDogReportingTask> configurator) {
    return configurator.apply(new DataDogReportingTask(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DataDogReportingTask.class) final Closure<DataDogReportingTask> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.reporting.datadog.DataDogReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.datadog.DataDogReportingTask.class, com.tibtech.nifi.reporting.datadog.DataDogReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
