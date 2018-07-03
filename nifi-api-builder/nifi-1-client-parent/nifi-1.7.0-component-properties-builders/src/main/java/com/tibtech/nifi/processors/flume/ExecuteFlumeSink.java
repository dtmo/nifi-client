package com.tibtech.nifi.processors.flume;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteFlumeSink {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.flume.ExecuteFlumeSink";

  /**
   * The component type name for the sink. For some sinks, this is a short, symbolic name (e.g. hdfs). For others, it's the fully-qualified name of the Sink class. See the Flume User Guide for details.
   */
  public static final String SINK_TYPE_PROPERTY = "Sink Type";

  /**
   * The name of the agent used in the Flume sink configuration
   */
  public static final String AGENT_NAME_PROPERTY = "Agent Name";

  /**
   * The name of the sink used in the Flume sink configuration
   */
  public static final String SINK_NAME_PROPERTY = "Sink Name";

  /**
   * The Flume configuration for the sink copied from the flume.properties file
   */
  public static final String FLUME_CONFIGURATION_PROPERTY = "Flume Configuration";

  private final Map<String, String> properties;

  public ExecuteFlumeSink() {
    this.properties = new HashMap<>();
  }

  public ExecuteFlumeSink(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The component type name for the sink. For some sinks, this is a short, symbolic name (e.g. hdfs). For others, it's the fully-qualified name of the Sink class. See the Flume User Guide for details.
   */
  public final String getSinkType() {
    return properties.get(SINK_TYPE_PROPERTY);
  }

  /**
   * The component type name for the sink. For some sinks, this is a short, symbolic name (e.g. hdfs). For others, it's the fully-qualified name of the Sink class. See the Flume User Guide for details.
   */
  public final ExecuteFlumeSink setSinkType(final String sinkType) {
    properties.put(SINK_TYPE_PROPERTY, sinkType);
    return this;
  }

  /**
   * The component type name for the sink. For some sinks, this is a short, symbolic name (e.g. hdfs). For others, it's the fully-qualified name of the Sink class. See the Flume User Guide for details.
   */
  public final ExecuteFlumeSink removeSinkType() {
    properties.remove(SINK_TYPE_PROPERTY);
    return this;
  }

  /**
   * The name of the agent used in the Flume sink configuration
   */
  public final String getAgentName() {
    return properties.get(AGENT_NAME_PROPERTY);
  }

  /**
   * The name of the agent used in the Flume sink configuration
   */
  public final ExecuteFlumeSink setAgentName(final String agentName) {
    properties.put(AGENT_NAME_PROPERTY, agentName);
    return this;
  }

  /**
   * The name of the agent used in the Flume sink configuration
   */
  public final ExecuteFlumeSink removeAgentName() {
    properties.remove(AGENT_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the sink used in the Flume sink configuration
   */
  public final String getSinkName() {
    return properties.get(SINK_NAME_PROPERTY);
  }

  /**
   * The name of the sink used in the Flume sink configuration
   */
  public final ExecuteFlumeSink setSinkName(final String sinkName) {
    properties.put(SINK_NAME_PROPERTY, sinkName);
    return this;
  }

  /**
   * The name of the sink used in the Flume sink configuration
   */
  public final ExecuteFlumeSink removeSinkName() {
    properties.remove(SINK_NAME_PROPERTY);
    return this;
  }

  /**
   * The Flume configuration for the sink copied from the flume.properties file
   */
  public final String getFlumeConfiguration() {
    return properties.get(FLUME_CONFIGURATION_PROPERTY);
  }

  /**
   * The Flume configuration for the sink copied from the flume.properties file
   */
  public final ExecuteFlumeSink setFlumeConfiguration(final String flumeConfiguration) {
    properties.put(FLUME_CONFIGURATION_PROPERTY, flumeConfiguration);
    return this;
  }

  /**
   * The Flume configuration for the sink copied from the flume.properties file
   */
  public final ExecuteFlumeSink removeFlumeConfiguration() {
    properties.remove(FLUME_CONFIGURATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteFlumeSink setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteFlumeSink removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteFlumeSink, ExecuteFlumeSink> configurator) {
    return configurator.apply(new ExecuteFlumeSink()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteFlumeSink.class) final Closure<ExecuteFlumeSink> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.flume.ExecuteFlumeSink> code = closure.rehydrate(c, com.tibtech.nifi.processors.flume.ExecuteFlumeSink.class, com.tibtech.nifi.processors.flume.ExecuteFlumeSink.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteFlumeSink, ExecuteFlumeSink> configurator) {
    return configurator.apply(new ExecuteFlumeSink(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteFlumeSink.class) final Closure<ExecuteFlumeSink> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.flume.ExecuteFlumeSink> code = closure.rehydrate(c, com.tibtech.nifi.processors.flume.ExecuteFlumeSink.class, com.tibtech.nifi.processors.flume.ExecuteFlumeSink.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
