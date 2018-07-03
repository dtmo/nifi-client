package com.tibtech.nifi.metrics.reporting.reporter.service;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GraphiteMetricReporterService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService";

  /**
   * The hostname of the carbon listener
   */
  public static final String HOST_PROPERTY = "host";

  /**
   * The port on which carbon listens
   */
  public static final String PORT_PROPERTY = "port";

  /**
   * The charset used by the graphite server
   */
  public static final String CHARSET_PROPERTY = "charset";

  /**
   * A prefix that will be used for all metric names sent by reporters provided by this service.
   */
  public static final String METRIC_NAME_PREFIX_PROPERTY = "metric name prefix";

  private final Map<String, String> properties;

  public GraphiteMetricReporterService() {
    this.properties = new HashMap<>();
  }

  public GraphiteMetricReporterService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The hostname of the carbon listener
   */
  public final String getHost() {
    return properties.get(HOST_PROPERTY);
  }

  /**
   * The hostname of the carbon listener
   */
  public final GraphiteMetricReporterService setHost(final String host) {
    properties.put(HOST_PROPERTY, host);
    return this;
  }

  /**
   * The hostname of the carbon listener
   */
  public final GraphiteMetricReporterService removeHost() {
    properties.remove(HOST_PROPERTY);
    return this;
  }

  /**
   * The port on which carbon listens
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port on which carbon listens
   */
  public final GraphiteMetricReporterService setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port on which carbon listens
   */
  public final GraphiteMetricReporterService removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The charset used by the graphite server
   */
  public final String getCharset() {
    return properties.get(CHARSET_PROPERTY);
  }

  /**
   * The charset used by the graphite server
   */
  public final GraphiteMetricReporterService setCharset(final String charset) {
    properties.put(CHARSET_PROPERTY, charset);
    return this;
  }

  /**
   * The charset used by the graphite server
   */
  public final GraphiteMetricReporterService removeCharset() {
    properties.remove(CHARSET_PROPERTY);
    return this;
  }

  /**
   * A prefix that will be used for all metric names sent by reporters provided by this service.
   */
  public final String getMetricNamePrefix() {
    return properties.get(METRIC_NAME_PREFIX_PROPERTY);
  }

  /**
   * A prefix that will be used for all metric names sent by reporters provided by this service.
   */
  public final GraphiteMetricReporterService setMetricNamePrefix(final String metricNamePrefix) {
    properties.put(METRIC_NAME_PREFIX_PROPERTY, metricNamePrefix);
    return this;
  }

  /**
   * A prefix that will be used for all metric names sent by reporters provided by this service.
   */
  public final GraphiteMetricReporterService removeMetricNamePrefix() {
    properties.remove(METRIC_NAME_PREFIX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GraphiteMetricReporterService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final GraphiteMetricReporterService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GraphiteMetricReporterService, GraphiteMetricReporterService> configurator) {
    return configurator.apply(new GraphiteMetricReporterService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GraphiteMetricReporterService.class) final Closure<GraphiteMetricReporterService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService> code = closure.rehydrate(c, com.tibtech.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService.class, com.tibtech.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GraphiteMetricReporterService, GraphiteMetricReporterService> configurator) {
    return configurator.apply(new GraphiteMetricReporterService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GraphiteMetricReporterService.class) final Closure<GraphiteMetricReporterService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService> code = closure.rehydrate(c, com.tibtech.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService.class, com.tibtech.nifi.metrics.reporting.reporter.service.GraphiteMetricReporterService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
