package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class LogMessage {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.LogMessage";

  /**
   * The Log Level to use when logging the message
   */
  public static final String LOG_LEVEL_PROPERTY = "log-level";

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogMessage processors.
   */
  public static final String LOG_PREFIX_PROPERTY = "log-prefix";

  /**
   * The log message to emit
   */
  public static final String LOG_MESSAGE_PROPERTY = "log-message";

  private final Map<String, String> properties;

  public LogMessage() {
    this.properties = new HashMap<>();
  }

  public LogMessage(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Log Level to use when logging the message
   */
  public final String getLogLevel() {
    return properties.get(LOG_LEVEL_PROPERTY);
  }

  /**
   * The Log Level to use when logging the message
   */
  public final LogMessage setLogLevel(final String logLevel) {
    properties.put(LOG_LEVEL_PROPERTY, logLevel);
    return this;
  }

  /**
   * The Log Level to use when logging the message
   */
  public final LogMessage removeLogLevel() {
    properties.remove(LOG_LEVEL_PROPERTY);
    return this;
  }

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogMessage processors.
   */
  public final String getLogPrefix() {
    return properties.get(LOG_PREFIX_PROPERTY);
  }

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogMessage processors.
   */
  public final LogMessage setLogPrefix(final String logPrefix) {
    properties.put(LOG_PREFIX_PROPERTY, logPrefix);
    return this;
  }

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogMessage processors.
   */
  public final LogMessage removeLogPrefix() {
    properties.remove(LOG_PREFIX_PROPERTY);
    return this;
  }

  /**
   * The log message to emit
   */
  public final String getLogMessage() {
    return properties.get(LOG_MESSAGE_PROPERTY);
  }

  /**
   * The log message to emit
   */
  public final LogMessage setLogMessage(final String logMessage) {
    properties.put(LOG_MESSAGE_PROPERTY, logMessage);
    return this;
  }

  /**
   * The log message to emit
   */
  public final LogMessage removeLogMessage() {
    properties.remove(LOG_MESSAGE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final LogMessage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final LogMessage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<LogMessage, LogMessage> configurator) {
    return configurator.apply(new LogMessage()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LogMessage.class) final Closure<LogMessage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.LogMessage> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LogMessage.class, com.tibtech.nifi.processors.standard.LogMessage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<LogMessage, LogMessage> configurator) {
    return configurator.apply(new LogMessage(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LogMessage.class) final Closure<LogMessage> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.LogMessage> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LogMessage.class, com.tibtech.nifi.processors.standard.LogMessage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
