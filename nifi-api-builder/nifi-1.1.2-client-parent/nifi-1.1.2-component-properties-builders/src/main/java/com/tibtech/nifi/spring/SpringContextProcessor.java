package com.tibtech.nifi.spring;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SpringContextProcessor {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.spring.SpringContextProcessor";

  /**
   * The path to the Spring Application Context configuration file relative to the classpath
   */
  public static final String APPLICATION_CONTEXT_CONFIG_PATH_PROPERTY = "Application Context config path";

  /**
   * Path to the directory with resources (i.e., JARs, configuration files etc.) required to be on the classpath of the ApplicationContext.
   */
  public static final String APPLICATION_CONTEXT_CLASS_PATH_PROPERTY = "Application Context class path";

  /**
   * Timeout for sending data to Spring Application Context. Defaults to 0.
   */
  public static final String SEND_TIMEOUT_PROPERTY = "Send Timeout";

  /**
   * Timeout for receiving date from Spring context. Defaults to 0.
   */
  public static final String RECEIVE_TIMEOUT_PROPERTY = "Receive Timeout";

  private final Map<String, String> properties;

  public SpringContextProcessor() {
    this.properties = new HashMap<>();
  }

  public SpringContextProcessor(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The path to the Spring Application Context configuration file relative to the classpath
   */
  public final String getApplicationContextConfigPath() {
    return properties.get(APPLICATION_CONTEXT_CONFIG_PATH_PROPERTY);
  }

  /**
   * The path to the Spring Application Context configuration file relative to the classpath
   */
  public final SpringContextProcessor setApplicationContextConfigPath(final String applicationContextConfigPath) {
    properties.put(APPLICATION_CONTEXT_CONFIG_PATH_PROPERTY, applicationContextConfigPath);
    return this;
  }

  /**
   * The path to the Spring Application Context configuration file relative to the classpath
   */
  public final SpringContextProcessor removeApplicationContextConfigPath() {
    properties.remove(APPLICATION_CONTEXT_CONFIG_PATH_PROPERTY);
    return this;
  }

  /**
   * Path to the directory with resources (i.e., JARs, configuration files etc.) required to be on the classpath of the ApplicationContext.
   */
  public final String getApplicationContextClassPath() {
    return properties.get(APPLICATION_CONTEXT_CLASS_PATH_PROPERTY);
  }

  /**
   * Path to the directory with resources (i.e., JARs, configuration files etc.) required to be on the classpath of the ApplicationContext.
   */
  public final SpringContextProcessor setApplicationContextClassPath(final String applicationContextClassPath) {
    properties.put(APPLICATION_CONTEXT_CLASS_PATH_PROPERTY, applicationContextClassPath);
    return this;
  }

  /**
   * Path to the directory with resources (i.e., JARs, configuration files etc.) required to be on the classpath of the ApplicationContext.
   */
  public final SpringContextProcessor removeApplicationContextClassPath() {
    properties.remove(APPLICATION_CONTEXT_CLASS_PATH_PROPERTY);
    return this;
  }

  /**
   * Timeout for sending data to Spring Application Context. Defaults to 0.
   */
  public final String getSendTimeout() {
    return properties.get(SEND_TIMEOUT_PROPERTY);
  }

  /**
   * Timeout for sending data to Spring Application Context. Defaults to 0.
   */
  public final SpringContextProcessor setSendTimeout(final String sendTimeout) {
    properties.put(SEND_TIMEOUT_PROPERTY, sendTimeout);
    return this;
  }

  /**
   * Timeout for sending data to Spring Application Context. Defaults to 0.
   */
  public final SpringContextProcessor removeSendTimeout() {
    properties.remove(SEND_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Timeout for receiving date from Spring context. Defaults to 0.
   */
  public final String getReceiveTimeout() {
    return properties.get(RECEIVE_TIMEOUT_PROPERTY);
  }

  /**
   * Timeout for receiving date from Spring context. Defaults to 0.
   */
  public final SpringContextProcessor setReceiveTimeout(final String receiveTimeout) {
    properties.put(RECEIVE_TIMEOUT_PROPERTY, receiveTimeout);
    return this;
  }

  /**
   * Timeout for receiving date from Spring context. Defaults to 0.
   */
  public final SpringContextProcessor removeReceiveTimeout() {
    properties.remove(RECEIVE_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SpringContextProcessor setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SpringContextProcessor removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SpringContextProcessor, SpringContextProcessor> configurator) {
    return configurator.apply(new SpringContextProcessor()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SpringContextProcessor.class) final Closure<SpringContextProcessor> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.spring.SpringContextProcessor> code = closure.rehydrate(c, com.tibtech.nifi.spring.SpringContextProcessor.class, com.tibtech.nifi.spring.SpringContextProcessor.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SpringContextProcessor, SpringContextProcessor> configurator) {
    return configurator.apply(new SpringContextProcessor(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SpringContextProcessor.class) final Closure<SpringContextProcessor> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.spring.SpringContextProcessor> code = closure.rehydrate(c, com.tibtech.nifi.spring.SpringContextProcessor.class, com.tibtech.nifi.spring.SpringContextProcessor.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
