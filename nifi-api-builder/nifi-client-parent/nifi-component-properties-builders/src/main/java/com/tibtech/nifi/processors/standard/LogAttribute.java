package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class LogAttribute {
  /**
   * The Log Level to use when logging the Attributes
   */
  public static final String LOG_LEVEL_PROPERTY = "Log Level";

  /**
   * If true, the FlowFile's payload will be logged, in addition to its attributes; otherwise, just the Attributes will be logged.
   */
  public static final String LOG_PAYLOAD_PROPERTY = "Log Payload";

  /**
   * A comma-separated list of Attributes to Log. If not specified, all attributes will be logged.
   */
  public static final String ATTRIBUTES_TO_LOG_PROPERTY = "Attributes to Log";

  /**
   * A comma-separated list of Attributes to ignore. If not specified, no attributes will be ignored.
   */
  public static final String ATTRIBUTES_TO_IGNORE_PROPERTY = "Attributes to Ignore";

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogAttribute processors.
   */
  public static final String LOG_PREFIX_PROPERTY = "Log prefix";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Log Level to use when logging the Attributes
   */
  public final String getLogLevel() {
    return properties.get(LOG_LEVEL_PROPERTY);
  }

  /**
   * The Log Level to use when logging the Attributes
   */
  public final LogAttribute setLogLevel(final String logLevel) {
    properties.put(LOG_LEVEL_PROPERTY, logLevel);
    return this;
  }

  /**
   * The Log Level to use when logging the Attributes
   */
  public final LogAttribute removeLogLevel() {
    properties.remove(LOG_LEVEL_PROPERTY);
    return this;
  }

  /**
   * If true, the FlowFile's payload will be logged, in addition to its attributes; otherwise, just the Attributes will be logged.
   */
  public final String getLogPayload() {
    return properties.get(LOG_PAYLOAD_PROPERTY);
  }

  /**
   * If true, the FlowFile's payload will be logged, in addition to its attributes; otherwise, just the Attributes will be logged.
   */
  public final LogAttribute setLogPayload(final String logPayload) {
    properties.put(LOG_PAYLOAD_PROPERTY, logPayload);
    return this;
  }

  /**
   * If true, the FlowFile's payload will be logged, in addition to its attributes; otherwise, just the Attributes will be logged.
   */
  public final LogAttribute removeLogPayload() {
    properties.remove(LOG_PAYLOAD_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Attributes to Log. If not specified, all attributes will be logged.
   */
  public final String getAttributesToLog() {
    return properties.get(ATTRIBUTES_TO_LOG_PROPERTY);
  }

  /**
   * A comma-separated list of Attributes to Log. If not specified, all attributes will be logged.
   */
  public final LogAttribute setAttributesToLog(final String attributesToLog) {
    properties.put(ATTRIBUTES_TO_LOG_PROPERTY, attributesToLog);
    return this;
  }

  /**
   * A comma-separated list of Attributes to Log. If not specified, all attributes will be logged.
   */
  public final LogAttribute removeAttributesToLog() {
    properties.remove(ATTRIBUTES_TO_LOG_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Attributes to ignore. If not specified, no attributes will be ignored.
   */
  public final String getAttributesToIgnore() {
    return properties.get(ATTRIBUTES_TO_IGNORE_PROPERTY);
  }

  /**
   * A comma-separated list of Attributes to ignore. If not specified, no attributes will be ignored.
   */
  public final LogAttribute setAttributesToIgnore(final String attributesToIgnore) {
    properties.put(ATTRIBUTES_TO_IGNORE_PROPERTY, attributesToIgnore);
    return this;
  }

  /**
   * A comma-separated list of Attributes to ignore. If not specified, no attributes will be ignored.
   */
  public final LogAttribute removeAttributesToIgnore() {
    properties.remove(ATTRIBUTES_TO_IGNORE_PROPERTY);
    return this;
  }

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogAttribute processors.
   */
  public final String getLogPrefix() {
    return properties.get(LOG_PREFIX_PROPERTY);
  }

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogAttribute processors.
   */
  public final LogAttribute setLogPrefix(final String logPrefix) {
    properties.put(LOG_PREFIX_PROPERTY, logPrefix);
    return this;
  }

  /**
   * Log prefix appended to the log lines. It helps to distinguish the output of multiple LogAttribute processors.
   */
  public final LogAttribute removeLogPrefix() {
    properties.remove(LOG_PREFIX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final LogAttribute setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final LogAttribute removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<LogAttribute, LogAttribute> configurator) {
    return configurator.apply(new LogAttribute()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LogAttribute.class) final Closure<LogAttribute> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.LogAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LogAttribute.class, com.tibtech.nifi.processors.standard.LogAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
