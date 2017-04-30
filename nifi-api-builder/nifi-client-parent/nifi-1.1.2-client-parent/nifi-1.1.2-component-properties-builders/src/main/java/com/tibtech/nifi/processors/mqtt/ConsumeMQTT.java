package com.tibtech.nifi.processors.mqtt;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeMQTT {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.mqtt.ConsumeMQTT";

  /**
   * The URI to use to connect to the MQTT broker (e.g. tcp://localhost:1883). The 'tcp' and 'ssl' schemes are supported. In order to use 'ssl', the SSL Context Service property must be set.
   */
  public static final String BROKER_URI_PROPERTY = "Broker URI";

  /**
   * MQTT client ID to use
   */
  public static final String CLIENT_ID_PROPERTY = "Client ID";

  /**
   * Username to use when connecting to the broker
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password to use when connecting to the broker
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The topic to send the client's Last Will to. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public static final String LAST_WILL_TOPIC_PROPERTY = "Last Will Topic";

  /**
   * The message to send as the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public static final String LAST_WILL_MESSAGE_PROPERTY = "Last Will Message";

  /**
   * Whether to retain the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public static final String LAST_WILL_RETAIN_PROPERTY = "Last Will Retain";

  /**
   * QoS level to be used when publishing the Last Will Message
   */
  public static final String LAST_WILL_QO_S_LEVEL_PROPERTY = "Last Will QoS Level";

  /**
   * Whether to start afresh or resume previous flows. See the allowable value descriptions for more details.
   */
  public static final String SESSION_STATE_PROPERTY = "Session state";

  /**
   * The MQTT specification version when connecting with the broker. See the allowable value descriptions for more details.
   */
  public static final String MQTT_SPECIFICATION_VERSION_PROPERTY = "MQTT Specification Version";

  /**
   * Maximum time interval the client will wait for the network connection to the MQTT server to be established. The default timeout is 30 seconds. A value of 0 disables timeout processing meaning the client will wait until the network connection is made successfully or fails.
   */
  public static final String CONNECTION_TIMEOUT_SECONDS_PROPERTY = "Connection Timeout (seconds)";

  /**
   * Defines the maximum time interval between messages sent or received. It enables the client to detect if the server is no longer available, without having to wait for the TCP/IP timeout. The client will ensure that at least one message travels across the network within each keep alive period. In the absence of a data-related message during the time period, the client sends a very small "ping" message, which the server will acknowledge. A value of 0 disables keepalive processing in the client.
   */
  public static final String KEEP_ALIVE_INTERVAL_SECONDS_PROPERTY = "Keep Alive Interval (seconds)";

  /**
   * The MQTT topic filter to designate the topics to subscribe to.
   */
  public static final String TOPIC_FILTER_PROPERTY = "Topic Filter";

  /**
   * The Quality of Service(QoS) to receive the message with. Accepts values '0', '1' or '2'; '0' for 'at most once', '1' for 'at least once', '2' for 'exactly once'.
   */
  public static final String QUALITY_OF_SERVICE_QO_S_PROPERTY = "Quality of Service(QoS)";

  /**
   * The MQTT messages are always being sent to subscribers on a topic. If the 'Run Schedule' is significantly behind the rate at which the messages are arriving to this processor then a back up can occur. This property specifies the maximum number of messages this processor will hold in memory at one time.
   */
  public static final String MAX_QUEUE_SIZE_PROPERTY = "Max Queue Size";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The URI to use to connect to the MQTT broker (e.g. tcp://localhost:1883). The 'tcp' and 'ssl' schemes are supported. In order to use 'ssl', the SSL Context Service property must be set.
   */
  public final String getBrokerUri() {
    return properties.get(BROKER_URI_PROPERTY);
  }

  /**
   * The URI to use to connect to the MQTT broker (e.g. tcp://localhost:1883). The 'tcp' and 'ssl' schemes are supported. In order to use 'ssl', the SSL Context Service property must be set.
   */
  public final ConsumeMQTT setBrokerUri(final String brokerUri) {
    properties.put(BROKER_URI_PROPERTY, brokerUri);
    return this;
  }

  /**
   * The URI to use to connect to the MQTT broker (e.g. tcp://localhost:1883). The 'tcp' and 'ssl' schemes are supported. In order to use 'ssl', the SSL Context Service property must be set.
   */
  public final ConsumeMQTT removeBrokerUri() {
    properties.remove(BROKER_URI_PROPERTY);
    return this;
  }

  /**
   * MQTT client ID to use
   */
  public final String getClientId() {
    return properties.get(CLIENT_ID_PROPERTY);
  }

  /**
   * MQTT client ID to use
   */
  public final ConsumeMQTT setClientId(final String clientId) {
    properties.put(CLIENT_ID_PROPERTY, clientId);
    return this;
  }

  /**
   * MQTT client ID to use
   */
  public final ConsumeMQTT removeClientId() {
    properties.remove(CLIENT_ID_PROPERTY);
    return this;
  }

  /**
   * Username to use when connecting to the broker
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username to use when connecting to the broker
   */
  public final ConsumeMQTT setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username to use when connecting to the broker
   */
  public final ConsumeMQTT removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password to use when connecting to the broker
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password to use when connecting to the broker
   */
  public final ConsumeMQTT setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password to use when connecting to the broker
   */
  public final ConsumeMQTT removePassword() {
    properties.remove(PASSWORD_PROPERTY);
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
  public final ConsumeMQTT setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final ConsumeMQTT removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The topic to send the client's Last Will to. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final String getLastWillTopic() {
    return properties.get(LAST_WILL_TOPIC_PROPERTY);
  }

  /**
   * The topic to send the client's Last Will to. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final ConsumeMQTT setLastWillTopic(final String lastWillTopic) {
    properties.put(LAST_WILL_TOPIC_PROPERTY, lastWillTopic);
    return this;
  }

  /**
   * The topic to send the client's Last Will to. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final ConsumeMQTT removeLastWillTopic() {
    properties.remove(LAST_WILL_TOPIC_PROPERTY);
    return this;
  }

  /**
   * The message to send as the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final String getLastWillMessage() {
    return properties.get(LAST_WILL_MESSAGE_PROPERTY);
  }

  /**
   * The message to send as the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final ConsumeMQTT setLastWillMessage(final String lastWillMessage) {
    properties.put(LAST_WILL_MESSAGE_PROPERTY, lastWillMessage);
    return this;
  }

  /**
   * The message to send as the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final ConsumeMQTT removeLastWillMessage() {
    properties.remove(LAST_WILL_MESSAGE_PROPERTY);
    return this;
  }

  /**
   * Whether to retain the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final String getLastWillRetain() {
    return properties.get(LAST_WILL_RETAIN_PROPERTY);
  }

  /**
   * Whether to retain the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final ConsumeMQTT setLastWillRetain(final String lastWillRetain) {
    properties.put(LAST_WILL_RETAIN_PROPERTY, lastWillRetain);
    return this;
  }

  /**
   * Whether to retain the client's Last Will. If the Last Will topic and message are not set then a Last Will will not be sent.
   */
  public final ConsumeMQTT removeLastWillRetain() {
    properties.remove(LAST_WILL_RETAIN_PROPERTY);
    return this;
  }

  /**
   * QoS level to be used when publishing the Last Will Message
   */
  public final String getLastWillQoSLevel() {
    return properties.get(LAST_WILL_QO_S_LEVEL_PROPERTY);
  }

  /**
   * QoS level to be used when publishing the Last Will Message
   */
  public final ConsumeMQTT setLastWillQoSLevel(final String lastWillQoSLevel) {
    properties.put(LAST_WILL_QO_S_LEVEL_PROPERTY, lastWillQoSLevel);
    return this;
  }

  /**
   * QoS level to be used when publishing the Last Will Message
   */
  public final ConsumeMQTT removeLastWillQoSLevel() {
    properties.remove(LAST_WILL_QO_S_LEVEL_PROPERTY);
    return this;
  }

  /**
   * Whether to start afresh or resume previous flows. See the allowable value descriptions for more details.
   */
  public final String getSessionState() {
    return properties.get(SESSION_STATE_PROPERTY);
  }

  /**
   * Whether to start afresh or resume previous flows. See the allowable value descriptions for more details.
   */
  public final ConsumeMQTT setSessionState(final String sessionState) {
    properties.put(SESSION_STATE_PROPERTY, sessionState);
    return this;
  }

  /**
   * Whether to start afresh or resume previous flows. See the allowable value descriptions for more details.
   */
  public final ConsumeMQTT removeSessionState() {
    properties.remove(SESSION_STATE_PROPERTY);
    return this;
  }

  /**
   * The MQTT specification version when connecting with the broker. See the allowable value descriptions for more details.
   */
  public final String getMqttSpecificationVersion() {
    return properties.get(MQTT_SPECIFICATION_VERSION_PROPERTY);
  }

  /**
   * The MQTT specification version when connecting with the broker. See the allowable value descriptions for more details.
   */
  public final ConsumeMQTT setMqttSpecificationVersion(final String mqttSpecificationVersion) {
    properties.put(MQTT_SPECIFICATION_VERSION_PROPERTY, mqttSpecificationVersion);
    return this;
  }

  /**
   * The MQTT specification version when connecting with the broker. See the allowable value descriptions for more details.
   */
  public final ConsumeMQTT removeMqttSpecificationVersion() {
    properties.remove(MQTT_SPECIFICATION_VERSION_PROPERTY);
    return this;
  }

  /**
   * Maximum time interval the client will wait for the network connection to the MQTT server to be established. The default timeout is 30 seconds. A value of 0 disables timeout processing meaning the client will wait until the network connection is made successfully or fails.
   */
  public final String getConnectionTimeoutSeconds() {
    return properties.get(CONNECTION_TIMEOUT_SECONDS_PROPERTY);
  }

  /**
   * Maximum time interval the client will wait for the network connection to the MQTT server to be established. The default timeout is 30 seconds. A value of 0 disables timeout processing meaning the client will wait until the network connection is made successfully or fails.
   */
  public final ConsumeMQTT setConnectionTimeoutSeconds(final String connectionTimeoutSeconds) {
    properties.put(CONNECTION_TIMEOUT_SECONDS_PROPERTY, connectionTimeoutSeconds);
    return this;
  }

  /**
   * Maximum time interval the client will wait for the network connection to the MQTT server to be established. The default timeout is 30 seconds. A value of 0 disables timeout processing meaning the client will wait until the network connection is made successfully or fails.
   */
  public final ConsumeMQTT removeConnectionTimeoutSeconds() {
    properties.remove(CONNECTION_TIMEOUT_SECONDS_PROPERTY);
    return this;
  }

  /**
   * Defines the maximum time interval between messages sent or received. It enables the client to detect if the server is no longer available, without having to wait for the TCP/IP timeout. The client will ensure that at least one message travels across the network within each keep alive period. In the absence of a data-related message during the time period, the client sends a very small "ping" message, which the server will acknowledge. A value of 0 disables keepalive processing in the client.
   */
  public final String getKeepAliveIntervalSeconds() {
    return properties.get(KEEP_ALIVE_INTERVAL_SECONDS_PROPERTY);
  }

  /**
   * Defines the maximum time interval between messages sent or received. It enables the client to detect if the server is no longer available, without having to wait for the TCP/IP timeout. The client will ensure that at least one message travels across the network within each keep alive period. In the absence of a data-related message during the time period, the client sends a very small "ping" message, which the server will acknowledge. A value of 0 disables keepalive processing in the client.
   */
  public final ConsumeMQTT setKeepAliveIntervalSeconds(final String keepAliveIntervalSeconds) {
    properties.put(KEEP_ALIVE_INTERVAL_SECONDS_PROPERTY, keepAliveIntervalSeconds);
    return this;
  }

  /**
   * Defines the maximum time interval between messages sent or received. It enables the client to detect if the server is no longer available, without having to wait for the TCP/IP timeout. The client will ensure that at least one message travels across the network within each keep alive period. In the absence of a data-related message during the time period, the client sends a very small "ping" message, which the server will acknowledge. A value of 0 disables keepalive processing in the client.
   */
  public final ConsumeMQTT removeKeepAliveIntervalSeconds() {
    properties.remove(KEEP_ALIVE_INTERVAL_SECONDS_PROPERTY);
    return this;
  }

  /**
   * The MQTT topic filter to designate the topics to subscribe to.
   */
  public final String getTopicFilter() {
    return properties.get(TOPIC_FILTER_PROPERTY);
  }

  /**
   * The MQTT topic filter to designate the topics to subscribe to.
   */
  public final ConsumeMQTT setTopicFilter(final String topicFilter) {
    properties.put(TOPIC_FILTER_PROPERTY, topicFilter);
    return this;
  }

  /**
   * The MQTT topic filter to designate the topics to subscribe to.
   */
  public final ConsumeMQTT removeTopicFilter() {
    properties.remove(TOPIC_FILTER_PROPERTY);
    return this;
  }

  /**
   * The Quality of Service(QoS) to receive the message with. Accepts values '0', '1' or '2'; '0' for 'at most once', '1' for 'at least once', '2' for 'exactly once'.
   */
  public final String getQualityOfServiceQoS() {
    return properties.get(QUALITY_OF_SERVICE_QO_S_PROPERTY);
  }

  /**
   * The Quality of Service(QoS) to receive the message with. Accepts values '0', '1' or '2'; '0' for 'at most once', '1' for 'at least once', '2' for 'exactly once'.
   */
  public final ConsumeMQTT setQualityOfServiceQoS(final String qualityOfServiceQoS) {
    properties.put(QUALITY_OF_SERVICE_QO_S_PROPERTY, qualityOfServiceQoS);
    return this;
  }

  /**
   * The Quality of Service(QoS) to receive the message with. Accepts values '0', '1' or '2'; '0' for 'at most once', '1' for 'at least once', '2' for 'exactly once'.
   */
  public final ConsumeMQTT removeQualityOfServiceQoS() {
    properties.remove(QUALITY_OF_SERVICE_QO_S_PROPERTY);
    return this;
  }

  /**
   * The MQTT messages are always being sent to subscribers on a topic. If the 'Run Schedule' is significantly behind the rate at which the messages are arriving to this processor then a back up can occur. This property specifies the maximum number of messages this processor will hold in memory at one time.
   */
  public final String getMaxQueueSize() {
    return properties.get(MAX_QUEUE_SIZE_PROPERTY);
  }

  /**
   * The MQTT messages are always being sent to subscribers on a topic. If the 'Run Schedule' is significantly behind the rate at which the messages are arriving to this processor then a back up can occur. This property specifies the maximum number of messages this processor will hold in memory at one time.
   */
  public final ConsumeMQTT setMaxQueueSize(final String maxQueueSize) {
    properties.put(MAX_QUEUE_SIZE_PROPERTY, maxQueueSize);
    return this;
  }

  /**
   * The MQTT messages are always being sent to subscribers on a topic. If the 'Run Schedule' is significantly behind the rate at which the messages are arriving to this processor then a back up can occur. This property specifies the maximum number of messages this processor will hold in memory at one time.
   */
  public final ConsumeMQTT removeMaxQueueSize() {
    properties.remove(MAX_QUEUE_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeMQTT setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeMQTT removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConsumeMQTT, ConsumeMQTT> configurator) {
    return configurator.apply(new ConsumeMQTT()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeMQTT.class) final Closure<ConsumeMQTT> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.mqtt.ConsumeMQTT> code = closure.rehydrate(c, com.tibtech.nifi.processors.mqtt.ConsumeMQTT.class, com.tibtech.nifi.processors.mqtt.ConsumeMQTT.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
