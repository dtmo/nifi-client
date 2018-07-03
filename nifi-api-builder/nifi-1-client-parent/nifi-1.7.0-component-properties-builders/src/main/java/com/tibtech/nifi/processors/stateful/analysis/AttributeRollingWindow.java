package com.tibtech.nifi.processors.stateful.analysis;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AttributeRollingWindow {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.stateful.analysis.AttributeRollingWindow";

  /**
   * The expression on which to evaluate each FlowFile. The result of the expression will be added to the rolling window value.
   */
  public static final String VALUE_TO_TRACK_PROPERTY = "Value to track";

  /**
   * The time window on which to calculate the rolling window.
   */
  public static final String TIME_WINDOW_PROPERTY = "Time window";

  /**
   * When set, values will be batched into sub-windows of the set length. This allows for much larger length total windows to be set but sacrifices some precision. If this is not set (or is 0) then each value is stored in state with the timestamp of when it was received. After the length of time stated in Time window elaspes the value will be removed. If this is set, values will be batched together every X amount of time (where X is the time period set for this property) and removed all at once.
   */
  public static final String SUB_WINDOW_LENGTH_PROPERTY = "Sub-window length";

  private final Map<String, String> properties;

  public AttributeRollingWindow() {
    this.properties = new HashMap<>();
  }

  public AttributeRollingWindow(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The expression on which to evaluate each FlowFile. The result of the expression will be added to the rolling window value.
   */
  public final String getValueToTrack() {
    return properties.get(VALUE_TO_TRACK_PROPERTY);
  }

  /**
   * The expression on which to evaluate each FlowFile. The result of the expression will be added to the rolling window value.
   */
  public final AttributeRollingWindow setValueToTrack(final String valueToTrack) {
    properties.put(VALUE_TO_TRACK_PROPERTY, valueToTrack);
    return this;
  }

  /**
   * The expression on which to evaluate each FlowFile. The result of the expression will be added to the rolling window value.
   */
  public final AttributeRollingWindow removeValueToTrack() {
    properties.remove(VALUE_TO_TRACK_PROPERTY);
    return this;
  }

  /**
   * The time window on which to calculate the rolling window.
   */
  public final String getTimeWindow() {
    return properties.get(TIME_WINDOW_PROPERTY);
  }

  /**
   * The time window on which to calculate the rolling window.
   */
  public final AttributeRollingWindow setTimeWindow(final String timeWindow) {
    properties.put(TIME_WINDOW_PROPERTY, timeWindow);
    return this;
  }

  /**
   * The time window on which to calculate the rolling window.
   */
  public final AttributeRollingWindow removeTimeWindow() {
    properties.remove(TIME_WINDOW_PROPERTY);
    return this;
  }

  /**
   * When set, values will be batched into sub-windows of the set length. This allows for much larger length total windows to be set but sacrifices some precision. If this is not set (or is 0) then each value is stored in state with the timestamp of when it was received. After the length of time stated in Time window elaspes the value will be removed. If this is set, values will be batched together every X amount of time (where X is the time period set for this property) and removed all at once.
   */
  public final String getSubWindowLength() {
    return properties.get(SUB_WINDOW_LENGTH_PROPERTY);
  }

  /**
   * When set, values will be batched into sub-windows of the set length. This allows for much larger length total windows to be set but sacrifices some precision. If this is not set (or is 0) then each value is stored in state with the timestamp of when it was received. After the length of time stated in Time window elaspes the value will be removed. If this is set, values will be batched together every X amount of time (where X is the time period set for this property) and removed all at once.
   */
  public final AttributeRollingWindow setSubWindowLength(final String subWindowLength) {
    properties.put(SUB_WINDOW_LENGTH_PROPERTY, subWindowLength);
    return this;
  }

  /**
   * When set, values will be batched into sub-windows of the set length. This allows for much larger length total windows to be set but sacrifices some precision. If this is not set (or is 0) then each value is stored in state with the timestamp of when it was received. After the length of time stated in Time window elaspes the value will be removed. If this is set, values will be batched together every X amount of time (where X is the time period set for this property) and removed all at once.
   */
  public final AttributeRollingWindow removeSubWindowLength() {
    properties.remove(SUB_WINDOW_LENGTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AttributeRollingWindow setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AttributeRollingWindow removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<AttributeRollingWindow, AttributeRollingWindow> configurator) {
    return configurator.apply(new AttributeRollingWindow()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AttributeRollingWindow.class) final Closure<AttributeRollingWindow> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.stateful.analysis.AttributeRollingWindow> code = closure.rehydrate(c, com.tibtech.nifi.processors.stateful.analysis.AttributeRollingWindow.class, com.tibtech.nifi.processors.stateful.analysis.AttributeRollingWindow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AttributeRollingWindow, AttributeRollingWindow> configurator) {
    return configurator.apply(new AttributeRollingWindow(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AttributeRollingWindow.class) final Closure<AttributeRollingWindow> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.stateful.analysis.AttributeRollingWindow> code = closure.rehydrate(c, com.tibtech.nifi.processors.stateful.analysis.AttributeRollingWindow.class, com.tibtech.nifi.processors.stateful.analysis.AttributeRollingWindow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
