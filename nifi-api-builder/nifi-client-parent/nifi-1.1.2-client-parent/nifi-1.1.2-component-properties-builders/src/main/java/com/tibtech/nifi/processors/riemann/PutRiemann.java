package com.tibtech.nifi.processors.riemann;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutRiemann {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.riemann.PutRiemann";

  /**
   * Hostname of Riemann server
   */
  public static final String RIEMANN_ADDRESS_PROPERTY = "Riemann Address";

  /**
   * Port that Riemann is listening on
   */
  public static final String RIEMANN_PORT_PROPERTY = "Riemann Port";

  /**
   * Transport protocol to speak to Riemann in
   */
  public static final String TRANSPORT_PROTOCOL_PROPERTY = "Transport Protocol";

  /**
   * Timeout in milliseconds when writing events to Riemann
   */
  public static final String TIMEOUT_PROPERTY = "Timeout";

  /**
   * Batch size for incoming FlowFiles
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Description associated to the event
   */
  public static final String DESCRIPTION_PROPERTY = "Description";

  /**
   * Name of service associated to this event (e.g. FTP File Fetched)
   */
  public static final String SERVICE_PROPERTY = "Service";

  /**
   * State of service associated to this event in string form (e.g. ok, warning, foo)
   */
  public static final String STATE_PROPERTY = "State";

  /**
   * Floating point number associated to this event
   */
  public static final String METRIC_PROPERTY = "Metric";

  /**
   * Floating point value in seconds until Riemann considers this event as "expired"
   */
  public static final String TTL_PROPERTY = "TTL";

  /**
   * Comma separated list of tags associated to the event
   */
  public static final String TAGS_PROPERTY = "Tags";

  /**
   * A hostname associated to this event (e.g. nifi-app1)
   */
  public static final String HOST_PROPERTY = "Host";

  /**
   * Time of event in unix epoch seconds (long), default: (current time)
   */
  public static final String TIME_PROPERTY = "Time";

  private final Map<String, String> properties;

  public PutRiemann() {
    this.properties = new HashMap<>();
  }

  public PutRiemann(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Hostname of Riemann server
   */
  public final String getRiemannAddress() {
    return properties.get(RIEMANN_ADDRESS_PROPERTY);
  }

  /**
   * Hostname of Riemann server
   */
  public final PutRiemann setRiemannAddress(final String riemannAddress) {
    properties.put(RIEMANN_ADDRESS_PROPERTY, riemannAddress);
    return this;
  }

  /**
   * Hostname of Riemann server
   */
  public final PutRiemann removeRiemannAddress() {
    properties.remove(RIEMANN_ADDRESS_PROPERTY);
    return this;
  }

  /**
   * Port that Riemann is listening on
   */
  public final String getRiemannPort() {
    return properties.get(RIEMANN_PORT_PROPERTY);
  }

  /**
   * Port that Riemann is listening on
   */
  public final PutRiemann setRiemannPort(final String riemannPort) {
    properties.put(RIEMANN_PORT_PROPERTY, riemannPort);
    return this;
  }

  /**
   * Port that Riemann is listening on
   */
  public final PutRiemann removeRiemannPort() {
    properties.remove(RIEMANN_PORT_PROPERTY);
    return this;
  }

  /**
   * Transport protocol to speak to Riemann in
   */
  public final String getTransportProtocol() {
    return properties.get(TRANSPORT_PROTOCOL_PROPERTY);
  }

  /**
   * Transport protocol to speak to Riemann in
   */
  public final PutRiemann setTransportProtocol(final String transportProtocol) {
    properties.put(TRANSPORT_PROTOCOL_PROPERTY, transportProtocol);
    return this;
  }

  /**
   * Transport protocol to speak to Riemann in
   */
  public final PutRiemann removeTransportProtocol() {
    properties.remove(TRANSPORT_PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * Timeout in milliseconds when writing events to Riemann
   */
  public final String getTimeout() {
    return properties.get(TIMEOUT_PROPERTY);
  }

  /**
   * Timeout in milliseconds when writing events to Riemann
   */
  public final PutRiemann setTimeout(final String timeout) {
    properties.put(TIMEOUT_PROPERTY, timeout);
    return this;
  }

  /**
   * Timeout in milliseconds when writing events to Riemann
   */
  public final PutRiemann removeTimeout() {
    properties.remove(TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Batch size for incoming FlowFiles
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * Batch size for incoming FlowFiles
   */
  public final PutRiemann setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * Batch size for incoming FlowFiles
   */
  public final PutRiemann removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Description associated to the event
   */
  public final String getDescription() {
    return properties.get(DESCRIPTION_PROPERTY);
  }

  /**
   * Description associated to the event
   */
  public final PutRiemann setDescription(final String description) {
    properties.put(DESCRIPTION_PROPERTY, description);
    return this;
  }

  /**
   * Description associated to the event
   */
  public final PutRiemann removeDescription() {
    properties.remove(DESCRIPTION_PROPERTY);
    return this;
  }

  /**
   * Name of service associated to this event (e.g. FTP File Fetched)
   */
  public final String getService() {
    return properties.get(SERVICE_PROPERTY);
  }

  /**
   * Name of service associated to this event (e.g. FTP File Fetched)
   */
  public final PutRiemann setService(final String service) {
    properties.put(SERVICE_PROPERTY, service);
    return this;
  }

  /**
   * Name of service associated to this event (e.g. FTP File Fetched)
   */
  public final PutRiemann removeService() {
    properties.remove(SERVICE_PROPERTY);
    return this;
  }

  /**
   * State of service associated to this event in string form (e.g. ok, warning, foo)
   */
  public final String getState() {
    return properties.get(STATE_PROPERTY);
  }

  /**
   * State of service associated to this event in string form (e.g. ok, warning, foo)
   */
  public final PutRiemann setState(final String state) {
    properties.put(STATE_PROPERTY, state);
    return this;
  }

  /**
   * State of service associated to this event in string form (e.g. ok, warning, foo)
   */
  public final PutRiemann removeState() {
    properties.remove(STATE_PROPERTY);
    return this;
  }

  /**
   * Floating point number associated to this event
   */
  public final String getMetric() {
    return properties.get(METRIC_PROPERTY);
  }

  /**
   * Floating point number associated to this event
   */
  public final PutRiemann setMetric(final String metric) {
    properties.put(METRIC_PROPERTY, metric);
    return this;
  }

  /**
   * Floating point number associated to this event
   */
  public final PutRiemann removeMetric() {
    properties.remove(METRIC_PROPERTY);
    return this;
  }

  /**
   * Floating point value in seconds until Riemann considers this event as "expired"
   */
  public final String getTtl() {
    return properties.get(TTL_PROPERTY);
  }

  /**
   * Floating point value in seconds until Riemann considers this event as "expired"
   */
  public final PutRiemann setTtl(final String ttl) {
    properties.put(TTL_PROPERTY, ttl);
    return this;
  }

  /**
   * Floating point value in seconds until Riemann considers this event as "expired"
   */
  public final PutRiemann removeTtl() {
    properties.remove(TTL_PROPERTY);
    return this;
  }

  /**
   * Comma separated list of tags associated to the event
   */
  public final String getTags() {
    return properties.get(TAGS_PROPERTY);
  }

  /**
   * Comma separated list of tags associated to the event
   */
  public final PutRiemann setTags(final String tags) {
    properties.put(TAGS_PROPERTY, tags);
    return this;
  }

  /**
   * Comma separated list of tags associated to the event
   */
  public final PutRiemann removeTags() {
    properties.remove(TAGS_PROPERTY);
    return this;
  }

  /**
   * A hostname associated to this event (e.g. nifi-app1)
   */
  public final String getHost() {
    return properties.get(HOST_PROPERTY);
  }

  /**
   * A hostname associated to this event (e.g. nifi-app1)
   */
  public final PutRiemann setHost(final String host) {
    properties.put(HOST_PROPERTY, host);
    return this;
  }

  /**
   * A hostname associated to this event (e.g. nifi-app1)
   */
  public final PutRiemann removeHost() {
    properties.remove(HOST_PROPERTY);
    return this;
  }

  /**
   * Time of event in unix epoch seconds (long), default: (current time)
   */
  public final String getTime() {
    return properties.get(TIME_PROPERTY);
  }

  /**
   * Time of event in unix epoch seconds (long), default: (current time)
   */
  public final PutRiemann setTime(final String time) {
    properties.put(TIME_PROPERTY, time);
    return this;
  }

  /**
   * Time of event in unix epoch seconds (long), default: (current time)
   */
  public final PutRiemann removeTime() {
    properties.remove(TIME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutRiemann setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutRiemann removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutRiemann, PutRiemann> configurator) {
    return configurator.apply(new PutRiemann()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutRiemann.class) final Closure<PutRiemann> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.riemann.PutRiemann> code = closure.rehydrate(c, com.tibtech.nifi.processors.riemann.PutRiemann.class, com.tibtech.nifi.processors.riemann.PutRiemann.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutRiemann, PutRiemann> configurator) {
    return configurator.apply(new PutRiemann(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutRiemann.class) final Closure<PutRiemann> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.riemann.PutRiemann> code = closure.rehydrate(c, com.tibtech.nifi.processors.riemann.PutRiemann.class, com.tibtech.nifi.processors.riemann.PutRiemann.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
