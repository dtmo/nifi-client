package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class Notify {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.Notify";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the release signal cache key
   */
  public static final String RELEASE_SIGNAL_ID_PROPERTY = "release-signal-id";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. Signal counter name is useful when a corresponding Wait processor needs to know the number of occurrences of different types of events, such as success or failure, or destination data source names, etc.
   */
  public static final String SIGNAL_COUNTER_NAME_PROPERTY = "signal-counter-name";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter delta. Specify how much the counter should increase. For example, if multiple signal events are processed at upstream flow in batch oriented way, the number of events processed can be notified with this property at once. Zero (0) has a special meaning, it clears target count back to 0, which is especially useful when used with Wait Releasable FlowFile Count = Zero (0) mode, to provide 'open-close-gate' type of flow control. One (1) can open a corresponding Wait processor, and Zero (0) can negate it as if closing a gate.
   */
  public static final String SIGNAL_COUNTER_DELTA_PROPERTY = "signal-counter-delta";

  /**
   * Specify the maximum number of incoming flow files that can be buffered until signals are notified to cache service. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping signals by signal identifier when multiple incoming flow files share the same signal identifier.
   */
  public static final String SIGNAL_BUFFER_COUNT_PROPERTY = "signal-buffer-count";

  /**
   * The Controller Service that is used to cache release signals in order to release files queued at a corresponding Wait processor
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "distributed-cache-service";

  /**
   * Any attributes whose names match this regex will be stored in the distributed cache to be copied to any FlowFiles released from a corresponding Wait processor.  Note that the uuid attribute will not be cached regardless of this value.  If blank, no attributes will be cached.
   */
  public static final String ATTRIBUTE_CACHE_REGEX_PROPERTY = "attribute-cache-regex";

  private final Map<String, String> properties;

  public Notify() {
    this.properties = new HashMap<>();
  }

  public Notify(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the release signal cache key
   */
  public final String getReleaseSignalId() {
    return properties.get(RELEASE_SIGNAL_ID_PROPERTY);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the release signal cache key
   */
  public final Notify setReleaseSignalId(final String releaseSignalId) {
    properties.put(RELEASE_SIGNAL_ID_PROPERTY, releaseSignalId);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the release signal cache key
   */
  public final Notify removeReleaseSignalId() {
    properties.remove(RELEASE_SIGNAL_ID_PROPERTY);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. Signal counter name is useful when a corresponding Wait processor needs to know the number of occurrences of different types of events, such as success or failure, or destination data source names, etc.
   */
  public final String getSignalCounterName() {
    return properties.get(SIGNAL_COUNTER_NAME_PROPERTY);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. Signal counter name is useful when a corresponding Wait processor needs to know the number of occurrences of different types of events, such as success or failure, or destination data source names, etc.
   */
  public final Notify setSignalCounterName(final String signalCounterName) {
    properties.put(SIGNAL_COUNTER_NAME_PROPERTY, signalCounterName);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. Signal counter name is useful when a corresponding Wait processor needs to know the number of occurrences of different types of events, such as success or failure, or destination data source names, etc.
   */
  public final Notify removeSignalCounterName() {
    properties.remove(SIGNAL_COUNTER_NAME_PROPERTY);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter delta. Specify how much the counter should increase. For example, if multiple signal events are processed at upstream flow in batch oriented way, the number of events processed can be notified with this property at once. Zero (0) has a special meaning, it clears target count back to 0, which is especially useful when used with Wait Releasable FlowFile Count = Zero (0) mode, to provide 'open-close-gate' type of flow control. One (1) can open a corresponding Wait processor, and Zero (0) can negate it as if closing a gate.
   */
  public final String getSignalCounterDelta() {
    return properties.get(SIGNAL_COUNTER_DELTA_PROPERTY);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter delta. Specify how much the counter should increase. For example, if multiple signal events are processed at upstream flow in batch oriented way, the number of events processed can be notified with this property at once. Zero (0) has a special meaning, it clears target count back to 0, which is especially useful when used with Wait Releasable FlowFile Count = Zero (0) mode, to provide 'open-close-gate' type of flow control. One (1) can open a corresponding Wait processor, and Zero (0) can negate it as if closing a gate.
   */
  public final Notify setSignalCounterDelta(final String signalCounterDelta) {
    properties.put(SIGNAL_COUNTER_DELTA_PROPERTY, signalCounterDelta);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter delta. Specify how much the counter should increase. For example, if multiple signal events are processed at upstream flow in batch oriented way, the number of events processed can be notified with this property at once. Zero (0) has a special meaning, it clears target count back to 0, which is especially useful when used with Wait Releasable FlowFile Count = Zero (0) mode, to provide 'open-close-gate' type of flow control. One (1) can open a corresponding Wait processor, and Zero (0) can negate it as if closing a gate.
   */
  public final Notify removeSignalCounterDelta() {
    properties.remove(SIGNAL_COUNTER_DELTA_PROPERTY);
    return this;
  }

  /**
   * Specify the maximum number of incoming flow files that can be buffered until signals are notified to cache service. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping signals by signal identifier when multiple incoming flow files share the same signal identifier.
   */
  public final String getSignalBufferCount() {
    return properties.get(SIGNAL_BUFFER_COUNT_PROPERTY);
  }

  /**
   * Specify the maximum number of incoming flow files that can be buffered until signals are notified to cache service. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping signals by signal identifier when multiple incoming flow files share the same signal identifier.
   */
  public final Notify setSignalBufferCount(final String signalBufferCount) {
    properties.put(SIGNAL_BUFFER_COUNT_PROPERTY, signalBufferCount);
    return this;
  }

  /**
   * Specify the maximum number of incoming flow files that can be buffered until signals are notified to cache service. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping signals by signal identifier when multiple incoming flow files share the same signal identifier.
   */
  public final Notify removeSignalBufferCount() {
    properties.remove(SIGNAL_BUFFER_COUNT_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to cache release signals in order to release files queued at a corresponding Wait processor
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to cache release signals in order to release files queued at a corresponding Wait processor
   */
  public final Notify setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * The Controller Service that is used to cache release signals in order to release files queued at a corresponding Wait processor
   */
  public final Notify removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Any attributes whose names match this regex will be stored in the distributed cache to be copied to any FlowFiles released from a corresponding Wait processor.  Note that the uuid attribute will not be cached regardless of this value.  If blank, no attributes will be cached.
   */
  public final String getAttributeCacheRegex() {
    return properties.get(ATTRIBUTE_CACHE_REGEX_PROPERTY);
  }

  /**
   * Any attributes whose names match this regex will be stored in the distributed cache to be copied to any FlowFiles released from a corresponding Wait processor.  Note that the uuid attribute will not be cached regardless of this value.  If blank, no attributes will be cached.
   */
  public final Notify setAttributeCacheRegex(final String attributeCacheRegex) {
    properties.put(ATTRIBUTE_CACHE_REGEX_PROPERTY, attributeCacheRegex);
    return this;
  }

  /**
   * Any attributes whose names match this regex will be stored in the distributed cache to be copied to any FlowFiles released from a corresponding Wait processor.  Note that the uuid attribute will not be cached regardless of this value.  If blank, no attributes will be cached.
   */
  public final Notify removeAttributeCacheRegex() {
    properties.remove(ATTRIBUTE_CACHE_REGEX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final Notify setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final Notify removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<Notify, Notify> configurator) {
    return configurator.apply(new Notify()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Notify.class) final Closure<Notify> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.Notify> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.Notify.class, com.tibtech.nifi.processors.standard.Notify.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<Notify, Notify> configurator) {
    return configurator.apply(new Notify(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Notify.class) final Closure<Notify> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.Notify> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.Notify.class, com.tibtech.nifi.processors.standard.Notify.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
