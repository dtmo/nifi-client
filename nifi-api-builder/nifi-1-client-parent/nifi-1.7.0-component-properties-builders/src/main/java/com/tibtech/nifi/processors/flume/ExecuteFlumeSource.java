package com.tibtech.nifi.processors.flume;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteFlumeSource {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.flume.ExecuteFlumeSource";

  /**
   * The component type name for the source. For some sources, this is a short, symbolic name (e.g. spooldir). For others, it's the fully-qualified name of the Source class. See the Flume User Guide for details.
   */
  public static final String SOURCE_TYPE_PROPERTY = "Source Type";

  /**
   * The name of the agent used in the Flume source configuration
   */
  public static final String AGENT_NAME_PROPERTY = "Agent Name";

  /**
   * The name of the source used in the Flume source configuration
   */
  public static final String SOURCE_NAME_PROPERTY = "Source Name";

  /**
   * The Flume configuration for the source copied from the flume.properties file
   */
  public static final String FLUME_CONFIGURATION_PROPERTY = "Flume Configuration";

  private final Map<String, String> properties;

  public ExecuteFlumeSource() {
    this.properties = new HashMap<>();
  }

  public ExecuteFlumeSource(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The component type name for the source. For some sources, this is a short, symbolic name (e.g. spooldir). For others, it's the fully-qualified name of the Source class. See the Flume User Guide for details.
   */
  public final String getSourceType() {
    return properties.get(SOURCE_TYPE_PROPERTY);
  }

  /**
   * The component type name for the source. For some sources, this is a short, symbolic name (e.g. spooldir). For others, it's the fully-qualified name of the Source class. See the Flume User Guide for details.
   */
  public final ExecuteFlumeSource setSourceType(final String sourceType) {
    properties.put(SOURCE_TYPE_PROPERTY, sourceType);
    return this;
  }

  /**
   * The component type name for the source. For some sources, this is a short, symbolic name (e.g. spooldir). For others, it's the fully-qualified name of the Source class. See the Flume User Guide for details.
   */
  public final ExecuteFlumeSource removeSourceType() {
    properties.remove(SOURCE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The name of the agent used in the Flume source configuration
   */
  public final String getAgentName() {
    return properties.get(AGENT_NAME_PROPERTY);
  }

  /**
   * The name of the agent used in the Flume source configuration
   */
  public final ExecuteFlumeSource setAgentName(final String agentName) {
    properties.put(AGENT_NAME_PROPERTY, agentName);
    return this;
  }

  /**
   * The name of the agent used in the Flume source configuration
   */
  public final ExecuteFlumeSource removeAgentName() {
    properties.remove(AGENT_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the source used in the Flume source configuration
   */
  public final String getSourceName() {
    return properties.get(SOURCE_NAME_PROPERTY);
  }

  /**
   * The name of the source used in the Flume source configuration
   */
  public final ExecuteFlumeSource setSourceName(final String sourceName) {
    properties.put(SOURCE_NAME_PROPERTY, sourceName);
    return this;
  }

  /**
   * The name of the source used in the Flume source configuration
   */
  public final ExecuteFlumeSource removeSourceName() {
    properties.remove(SOURCE_NAME_PROPERTY);
    return this;
  }

  /**
   * The Flume configuration for the source copied from the flume.properties file
   */
  public final String getFlumeConfiguration() {
    return properties.get(FLUME_CONFIGURATION_PROPERTY);
  }

  /**
   * The Flume configuration for the source copied from the flume.properties file
   */
  public final ExecuteFlumeSource setFlumeConfiguration(final String flumeConfiguration) {
    properties.put(FLUME_CONFIGURATION_PROPERTY, flumeConfiguration);
    return this;
  }

  /**
   * The Flume configuration for the source copied from the flume.properties file
   */
  public final ExecuteFlumeSource removeFlumeConfiguration() {
    properties.remove(FLUME_CONFIGURATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteFlumeSource setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteFlumeSource removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteFlumeSource, ExecuteFlumeSource> configurator) {
    return configurator.apply(new ExecuteFlumeSource()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteFlumeSource.class) final Closure<ExecuteFlumeSource> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.flume.ExecuteFlumeSource> code = closure.rehydrate(c, com.tibtech.nifi.processors.flume.ExecuteFlumeSource.class, com.tibtech.nifi.processors.flume.ExecuteFlumeSource.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteFlumeSource, ExecuteFlumeSource> configurator) {
    return configurator.apply(new ExecuteFlumeSource(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteFlumeSource.class) final Closure<ExecuteFlumeSource> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.flume.ExecuteFlumeSource> code = closure.rehydrate(c, com.tibtech.nifi.processors.flume.ExecuteFlumeSource.class, com.tibtech.nifi.processors.flume.ExecuteFlumeSource.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
