package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class Wait {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.Wait";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the release signal cache key
   */
  public static final String RELEASE_SIGNAL_ID_PROPERTY = "release-signal-id";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the target signal count. This processor checks whether the signal count has reached this number. If Signal Counter Name is specified, this processor checks a particular counter, otherwise checks against total count in a signal.
   */
  public static final String TARGET_SIGNAL_COUNT_PROPERTY = "target-signal-count";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. If not specified, this processor checks the total count in a signal.
   */
  public static final String SIGNAL_COUNTER_NAME_PROPERTY = "signal-counter-name";

  /**
   * Specify the maximum number of incoming FlowFiles that can be buffered to check whether it can move forward. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping FlowFiles by signal identifier. Only a signal identifier can be processed at a processor execution.
   */
  public static final String WAIT_BUFFER_COUNT_PROPERTY = "wait-buffer-count";

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the releasable FlowFile count. This specifies how many FlowFiles can be released when a target count reaches target signal count. Zero (0) has a special meaning, any number of FlowFiles can be released as long as signal count matches target.
   */
  public static final String RELEASABLE_FLOWFILE_COUNT_PROPERTY = "releasable-flowfile-count";

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'expired' relationship
   */
  public static final String EXPIRATION_DURATION_PROPERTY = "expiration-duration";

  /**
   * The Controller Service that is used to check for release signals from a corresponding Notify processor
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "distributed-cache-service";

  /**
   * Specifies how to handle attributes copied from FlowFiles entering the Notify processor
   */
  public static final String ATTRIBUTE_COPY_MODE_PROPERTY = "attribute-copy-mode";

  /**
   * Specifies how to handle a FlowFile waiting for a notify signal
   */
  public static final String WAIT_MODE_PROPERTY = "wait-mode";

  private final Map<String, String> properties;

  public Wait() {
    this.properties = new HashMap<>();
  }

  public Wait(final Map<String, String> properties) {
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
  public final Wait setReleaseSignalId(final String releaseSignalId) {
    properties.put(RELEASE_SIGNAL_ID_PROPERTY, releaseSignalId);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the release signal cache key
   */
  public final Wait removeReleaseSignalId() {
    properties.remove(RELEASE_SIGNAL_ID_PROPERTY);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the target signal count. This processor checks whether the signal count has reached this number. If Signal Counter Name is specified, this processor checks a particular counter, otherwise checks against total count in a signal.
   */
  public final String getTargetSignalCount() {
    return properties.get(TARGET_SIGNAL_COUNT_PROPERTY);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the target signal count. This processor checks whether the signal count has reached this number. If Signal Counter Name is specified, this processor checks a particular counter, otherwise checks against total count in a signal.
   */
  public final Wait setTargetSignalCount(final String targetSignalCount) {
    properties.put(TARGET_SIGNAL_COUNT_PROPERTY, targetSignalCount);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the target signal count. This processor checks whether the signal count has reached this number. If Signal Counter Name is specified, this processor checks a particular counter, otherwise checks against total count in a signal.
   */
  public final Wait removeTargetSignalCount() {
    properties.remove(TARGET_SIGNAL_COUNT_PROPERTY);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. If not specified, this processor checks the total count in a signal.
   */
  public final String getSignalCounterName() {
    return properties.get(SIGNAL_COUNTER_NAME_PROPERTY);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. If not specified, this processor checks the total count in a signal.
   */
  public final Wait setSignalCounterName(final String signalCounterName) {
    properties.put(SIGNAL_COUNTER_NAME_PROPERTY, signalCounterName);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the signal counter name. If not specified, this processor checks the total count in a signal.
   */
  public final Wait removeSignalCounterName() {
    properties.remove(SIGNAL_COUNTER_NAME_PROPERTY);
    return this;
  }

  /**
   * Specify the maximum number of incoming FlowFiles that can be buffered to check whether it can move forward. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping FlowFiles by signal identifier. Only a signal identifier can be processed at a processor execution.
   */
  public final String getWaitBufferCount() {
    return properties.get(WAIT_BUFFER_COUNT_PROPERTY);
  }

  /**
   * Specify the maximum number of incoming FlowFiles that can be buffered to check whether it can move forward. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping FlowFiles by signal identifier. Only a signal identifier can be processed at a processor execution.
   */
  public final Wait setWaitBufferCount(final String waitBufferCount) {
    properties.put(WAIT_BUFFER_COUNT_PROPERTY, waitBufferCount);
    return this;
  }

  /**
   * Specify the maximum number of incoming FlowFiles that can be buffered to check whether it can move forward. The more buffer can provide the better performance, as it reduces the number of interactions with cache service by grouping FlowFiles by signal identifier. Only a signal identifier can be processed at a processor execution.
   */
  public final Wait removeWaitBufferCount() {
    properties.remove(WAIT_BUFFER_COUNT_PROPERTY);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the releasable FlowFile count. This specifies how many FlowFiles can be released when a target count reaches target signal count. Zero (0) has a special meaning, any number of FlowFiles can be released as long as signal count matches target.
   */
  public final String getReleasableFlowfileCount() {
    return properties.get(RELEASABLE_FLOWFILE_COUNT_PROPERTY);
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the releasable FlowFile count. This specifies how many FlowFiles can be released when a target count reaches target signal count. Zero (0) has a special meaning, any number of FlowFiles can be released as long as signal count matches target.
   */
  public final Wait setReleasableFlowfileCount(final String releasableFlowfileCount) {
    properties.put(RELEASABLE_FLOWFILE_COUNT_PROPERTY, releasableFlowfileCount);
    return this;
  }

  /**
   * A value, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the releasable FlowFile count. This specifies how many FlowFiles can be released when a target count reaches target signal count. Zero (0) has a special meaning, any number of FlowFiles can be released as long as signal count matches target.
   */
  public final Wait removeReleasableFlowfileCount() {
    properties.remove(RELEASABLE_FLOWFILE_COUNT_PROPERTY);
    return this;
  }

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'expired' relationship
   */
  public final String getExpirationDuration() {
    return properties.get(EXPIRATION_DURATION_PROPERTY);
  }

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'expired' relationship
   */
  public final Wait setExpirationDuration(final String expirationDuration) {
    properties.put(EXPIRATION_DURATION_PROPERTY, expirationDuration);
    return this;
  }

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'expired' relationship
   */
  public final Wait removeExpirationDuration() {
    properties.remove(EXPIRATION_DURATION_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to check for release signals from a corresponding Notify processor
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to check for release signals from a corresponding Notify processor
   */
  public final Wait setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * The Controller Service that is used to check for release signals from a corresponding Notify processor
   */
  public final Wait removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies how to handle attributes copied from FlowFiles entering the Notify processor
   */
  public final String getAttributeCopyMode() {
    return properties.get(ATTRIBUTE_COPY_MODE_PROPERTY);
  }

  /**
   * Specifies how to handle attributes copied from FlowFiles entering the Notify processor
   */
  public final Wait setAttributeCopyMode(final String attributeCopyMode) {
    properties.put(ATTRIBUTE_COPY_MODE_PROPERTY, attributeCopyMode);
    return this;
  }

  /**
   * Specifies how to handle attributes copied from FlowFiles entering the Notify processor
   */
  public final Wait removeAttributeCopyMode() {
    properties.remove(ATTRIBUTE_COPY_MODE_PROPERTY);
    return this;
  }

  /**
   * Specifies how to handle a FlowFile waiting for a notify signal
   */
  public final String getWaitMode() {
    return properties.get(WAIT_MODE_PROPERTY);
  }

  /**
   * Specifies how to handle a FlowFile waiting for a notify signal
   */
  public final Wait setWaitMode(final String waitMode) {
    properties.put(WAIT_MODE_PROPERTY, waitMode);
    return this;
  }

  /**
   * Specifies how to handle a FlowFile waiting for a notify signal
   */
  public final Wait removeWaitMode() {
    properties.remove(WAIT_MODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final Wait setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final Wait removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<Wait, Wait> configurator) {
    return configurator.apply(new Wait()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Wait.class) final Closure<Wait> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.Wait> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.Wait.class, com.tibtech.nifi.processors.standard.Wait.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<Wait, Wait> configurator) {
    return configurator.apply(new Wait(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Wait.class) final Closure<Wait> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.Wait> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.Wait.class, com.tibtech.nifi.processors.standard.Wait.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
