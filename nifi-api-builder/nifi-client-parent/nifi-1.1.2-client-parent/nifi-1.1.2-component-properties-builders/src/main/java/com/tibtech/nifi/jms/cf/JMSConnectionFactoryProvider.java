package com.tibtech.nifi.jms.cf;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class JMSConnectionFactoryProvider {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.jms.cf.JMSConnectionFactoryProvider";

  /**
   * A fully qualified name of the JMS ConnectionFactory implementation class (i.e., org.apache.activemq.ActiveMQConnectionFactory)
   */
  public static final String CF_PROPERTY = "cf";

  /**
   * Path to the directory with additional resources (i.e., JARs, configuration files etc.) to be added to the classpath. Such resources typically represent target MQ client libraries for the ConnectionFactory implementation.
   */
  public static final String CFLIB_PROPERTY = "cflib";

  /**
   * URI pointing to the network location of the JMS Message broker. For example, 'tcp://myhost:61616' for ActiveMQ or 'myhost:1414' for IBM MQ
   */
  public static final String BROKER_PROPERTY = "broker";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  private final Map<String, String> properties;

  public JMSConnectionFactoryProvider() {
    this.properties = new HashMap<>();
  }

  public JMSConnectionFactoryProvider(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A fully qualified name of the JMS ConnectionFactory implementation class (i.e., org.apache.activemq.ActiveMQConnectionFactory)
   */
  public final String getCf() {
    return properties.get(CF_PROPERTY);
  }

  /**
   * A fully qualified name of the JMS ConnectionFactory implementation class (i.e., org.apache.activemq.ActiveMQConnectionFactory)
   */
  public final JMSConnectionFactoryProvider setCf(final String cf) {
    properties.put(CF_PROPERTY, cf);
    return this;
  }

  /**
   * A fully qualified name of the JMS ConnectionFactory implementation class (i.e., org.apache.activemq.ActiveMQConnectionFactory)
   */
  public final JMSConnectionFactoryProvider removeCf() {
    properties.remove(CF_PROPERTY);
    return this;
  }

  /**
   * Path to the directory with additional resources (i.e., JARs, configuration files etc.) to be added to the classpath. Such resources typically represent target MQ client libraries for the ConnectionFactory implementation.
   */
  public final String getCflib() {
    return properties.get(CFLIB_PROPERTY);
  }

  /**
   * Path to the directory with additional resources (i.e., JARs, configuration files etc.) to be added to the classpath. Such resources typically represent target MQ client libraries for the ConnectionFactory implementation.
   */
  public final JMSConnectionFactoryProvider setCflib(final String cflib) {
    properties.put(CFLIB_PROPERTY, cflib);
    return this;
  }

  /**
   * Path to the directory with additional resources (i.e., JARs, configuration files etc.) to be added to the classpath. Such resources typically represent target MQ client libraries for the ConnectionFactory implementation.
   */
  public final JMSConnectionFactoryProvider removeCflib() {
    properties.remove(CFLIB_PROPERTY);
    return this;
  }

  /**
   * URI pointing to the network location of the JMS Message broker. For example, 'tcp://myhost:61616' for ActiveMQ or 'myhost:1414' for IBM MQ
   */
  public final String getBroker() {
    return properties.get(BROKER_PROPERTY);
  }

  /**
   * URI pointing to the network location of the JMS Message broker. For example, 'tcp://myhost:61616' for ActiveMQ or 'myhost:1414' for IBM MQ
   */
  public final JMSConnectionFactoryProvider setBroker(final String broker) {
    properties.put(BROKER_PROPERTY, broker);
    return this;
  }

  /**
   * URI pointing to the network location of the JMS Message broker. For example, 'tcp://myhost:61616' for ActiveMQ or 'myhost:1414' for IBM MQ
   */
  public final JMSConnectionFactoryProvider removeBroker() {
    properties.remove(BROKER_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final JMSConnectionFactoryProvider setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final JMSConnectionFactoryProvider removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final JMSConnectionFactoryProvider setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final JMSConnectionFactoryProvider removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<JMSConnectionFactoryProvider, JMSConnectionFactoryProvider> configurator) {
    return configurator.apply(new JMSConnectionFactoryProvider()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JMSConnectionFactoryProvider.class) final Closure<JMSConnectionFactoryProvider> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.jms.cf.JMSConnectionFactoryProvider> code = closure.rehydrate(c, com.tibtech.nifi.jms.cf.JMSConnectionFactoryProvider.class, com.tibtech.nifi.jms.cf.JMSConnectionFactoryProvider.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<JMSConnectionFactoryProvider, JMSConnectionFactoryProvider> configurator) {
    return configurator.apply(new JMSConnectionFactoryProvider(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JMSConnectionFactoryProvider.class) final Closure<JMSConnectionFactoryProvider> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.jms.cf.JMSConnectionFactoryProvider> code = closure.rehydrate(c, com.tibtech.nifi.jms.cf.JMSConnectionFactoryProvider.class, com.tibtech.nifi.jms.cf.JMSConnectionFactoryProvider.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
