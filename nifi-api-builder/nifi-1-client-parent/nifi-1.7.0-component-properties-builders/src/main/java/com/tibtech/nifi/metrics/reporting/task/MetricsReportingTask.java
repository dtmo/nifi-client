package com.tibtech.nifi.metrics.reporting.task;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MetricsReportingTask {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.metrics.reporting.task.MetricsReportingTask";

  /**
   * The service that provides a reporter for the gathered metrics
   */
  public static final String METRIC_REPORTER_SERVICE_PROPERTY = "metric reporter service";

  /**
   * The id of the process group to report. If not specified, metrics of the root process groupare reported.
   */
  public static final String PROCESS_GROUP_ID_PROPERTY = "process group id";

  private final Map<String, String> properties;

  public MetricsReportingTask() {
    this.properties = new HashMap<>();
  }

  public MetricsReportingTask(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The service that provides a reporter for the gathered metrics
   */
  public final String getMetricReporterService() {
    return properties.get(METRIC_REPORTER_SERVICE_PROPERTY);
  }

  /**
   * The service that provides a reporter for the gathered metrics
   */
  public final MetricsReportingTask setMetricReporterService(final String metricReporterService) {
    properties.put(METRIC_REPORTER_SERVICE_PROPERTY, metricReporterService);
    return this;
  }

  /**
   * The service that provides a reporter for the gathered metrics
   */
  public final MetricsReportingTask removeMetricReporterService() {
    properties.remove(METRIC_REPORTER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The id of the process group to report. If not specified, metrics of the root process groupare reported.
   */
  public final String getProcessGroupId() {
    return properties.get(PROCESS_GROUP_ID_PROPERTY);
  }

  /**
   * The id of the process group to report. If not specified, metrics of the root process groupare reported.
   */
  public final MetricsReportingTask setProcessGroupId(final String processGroupId) {
    properties.put(PROCESS_GROUP_ID_PROPERTY, processGroupId);
    return this;
  }

  /**
   * The id of the process group to report. If not specified, metrics of the root process groupare reported.
   */
  public final MetricsReportingTask removeProcessGroupId() {
    properties.remove(PROCESS_GROUP_ID_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MetricsReportingTask setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MetricsReportingTask removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<MetricsReportingTask, MetricsReportingTask> configurator) {
    return configurator.apply(new MetricsReportingTask()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MetricsReportingTask.class) final Closure<MetricsReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.metrics.reporting.task.MetricsReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.metrics.reporting.task.MetricsReportingTask.class, com.tibtech.nifi.metrics.reporting.task.MetricsReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<MetricsReportingTask, MetricsReportingTask> configurator) {
    return configurator.apply(new MetricsReportingTask(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MetricsReportingTask.class) final Closure<MetricsReportingTask> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.metrics.reporting.task.MetricsReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.metrics.reporting.task.MetricsReportingTask.class, com.tibtech.nifi.metrics.reporting.task.MetricsReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
