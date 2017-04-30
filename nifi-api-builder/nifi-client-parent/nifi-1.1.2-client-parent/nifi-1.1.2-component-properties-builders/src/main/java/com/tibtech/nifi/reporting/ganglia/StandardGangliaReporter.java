package com.tibtech.nifi.reporting.ganglia;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StandardGangliaReporter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.reporting.ganglia.StandardGangliaReporter";

  /**
   * The fully-qualified name of the host on which Ganglia is running
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The Port on which Ganglia is listening for incoming connections
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * Specifies whether or not JVM Metrics should be gathered and sent, in addition to NiFi-specific metrics
   */
  public static final String SEND_JVM_METRICS_PROPERTY = "Send JVM Metrics";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The fully-qualified name of the host on which Ganglia is running
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The fully-qualified name of the host on which Ganglia is running
   */
  public final StandardGangliaReporter setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully-qualified name of the host on which Ganglia is running
   */
  public final StandardGangliaReporter removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The Port on which Ganglia is listening for incoming connections
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The Port on which Ganglia is listening for incoming connections
   */
  public final StandardGangliaReporter setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The Port on which Ganglia is listening for incoming connections
   */
  public final StandardGangliaReporter removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not JVM Metrics should be gathered and sent, in addition to NiFi-specific metrics
   */
  public final String getSendJvmMetrics() {
    return properties.get(SEND_JVM_METRICS_PROPERTY);
  }

  /**
   * Specifies whether or not JVM Metrics should be gathered and sent, in addition to NiFi-specific metrics
   */
  public final StandardGangliaReporter setSendJvmMetrics(final String sendJvmMetrics) {
    properties.put(SEND_JVM_METRICS_PROPERTY, sendJvmMetrics);
    return this;
  }

  /**
   * Specifies whether or not JVM Metrics should be gathered and sent, in addition to NiFi-specific metrics
   */
  public final StandardGangliaReporter removeSendJvmMetrics() {
    properties.remove(SEND_JVM_METRICS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final StandardGangliaReporter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final StandardGangliaReporter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<StandardGangliaReporter, StandardGangliaReporter> configurator) {
    return configurator.apply(new StandardGangliaReporter()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardGangliaReporter.class) final Closure<StandardGangliaReporter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.reporting.ganglia.StandardGangliaReporter> code = closure.rehydrate(c, com.tibtech.nifi.reporting.ganglia.StandardGangliaReporter.class, com.tibtech.nifi.reporting.ganglia.StandardGangliaReporter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
