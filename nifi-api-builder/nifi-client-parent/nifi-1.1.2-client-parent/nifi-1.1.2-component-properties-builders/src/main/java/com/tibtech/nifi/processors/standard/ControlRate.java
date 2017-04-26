package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ControlRate {
  /**
   * Indicates the criteria that is used to control the throughput rate. Changing this value resets the rate counters.
   */
  public static final String RATE_CONTROL_CRITERIA_PROPERTY = "Rate Control Criteria";

  /**
   * The maximum rate at which data should pass through this processor. The format of this property is expected to be a positive integer, or a Data Size (such as '1 MB') if Rate Control Criteria is set to 'data rate'.
   */
  public static final String MAXIMUM_RATE_PROPERTY = "Maximum Rate";

  /**
   * The name of an attribute whose values build toward the rate limit if Rate Control Criteria is set to 'attribute value'. The value of the attribute referenced by this property must be a positive long, or the FlowFile will be routed to failure. This value is ignored if Rate Control Criteria is not set to 'attribute value'. Changing this value resets the rate counters.
   */
  public static final String RATE_CONTROLLED_ATTRIBUTE_PROPERTY = "Rate Controlled Attribute";

  /**
   * The amount of time to which the Maximum Rate pertains. Changing this value resets the rate counters.
   */
  public static final String TIME_DURATION_PROPERTY = "Time Duration";

  /**
   * By default, a single "throttle" is used for all FlowFiles. If this value is specified, a separate throttle is used for each value specified by the attribute with this name. Changing this value resets the rate counters.
   */
  public static final String GROUPING_ATTRIBUTE_PROPERTY = "Grouping Attribute";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Indicates the criteria that is used to control the throughput rate. Changing this value resets the rate counters.
   */
  public final String getRateControlCriteria() {
    return properties.get(RATE_CONTROL_CRITERIA_PROPERTY);
  }

  /**
   * Indicates the criteria that is used to control the throughput rate. Changing this value resets the rate counters.
   */
  public final ControlRate setRateControlCriteria(final String rateControlCriteria) {
    properties.put(RATE_CONTROL_CRITERIA_PROPERTY, rateControlCriteria);
    return this;
  }

  /**
   * Indicates the criteria that is used to control the throughput rate. Changing this value resets the rate counters.
   */
  public final ControlRate removeRateControlCriteria() {
    properties.remove(RATE_CONTROL_CRITERIA_PROPERTY);
    return this;
  }

  /**
   * The maximum rate at which data should pass through this processor. The format of this property is expected to be a positive integer, or a Data Size (such as '1 MB') if Rate Control Criteria is set to 'data rate'.
   */
  public final String getMaximumRate() {
    return properties.get(MAXIMUM_RATE_PROPERTY);
  }

  /**
   * The maximum rate at which data should pass through this processor. The format of this property is expected to be a positive integer, or a Data Size (such as '1 MB') if Rate Control Criteria is set to 'data rate'.
   */
  public final ControlRate setMaximumRate(final String maximumRate) {
    properties.put(MAXIMUM_RATE_PROPERTY, maximumRate);
    return this;
  }

  /**
   * The maximum rate at which data should pass through this processor. The format of this property is expected to be a positive integer, or a Data Size (such as '1 MB') if Rate Control Criteria is set to 'data rate'.
   */
  public final ControlRate removeMaximumRate() {
    properties.remove(MAXIMUM_RATE_PROPERTY);
    return this;
  }

  /**
   * The name of an attribute whose values build toward the rate limit if Rate Control Criteria is set to 'attribute value'. The value of the attribute referenced by this property must be a positive long, or the FlowFile will be routed to failure. This value is ignored if Rate Control Criteria is not set to 'attribute value'. Changing this value resets the rate counters.
   */
  public final String getRateControlledAttribute() {
    return properties.get(RATE_CONTROLLED_ATTRIBUTE_PROPERTY);
  }

  /**
   * The name of an attribute whose values build toward the rate limit if Rate Control Criteria is set to 'attribute value'. The value of the attribute referenced by this property must be a positive long, or the FlowFile will be routed to failure. This value is ignored if Rate Control Criteria is not set to 'attribute value'. Changing this value resets the rate counters.
   */
  public final ControlRate setRateControlledAttribute(final String rateControlledAttribute) {
    properties.put(RATE_CONTROLLED_ATTRIBUTE_PROPERTY, rateControlledAttribute);
    return this;
  }

  /**
   * The name of an attribute whose values build toward the rate limit if Rate Control Criteria is set to 'attribute value'. The value of the attribute referenced by this property must be a positive long, or the FlowFile will be routed to failure. This value is ignored if Rate Control Criteria is not set to 'attribute value'. Changing this value resets the rate counters.
   */
  public final ControlRate removeRateControlledAttribute() {
    properties.remove(RATE_CONTROLLED_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The amount of time to which the Maximum Rate pertains. Changing this value resets the rate counters.
   */
  public final String getTimeDuration() {
    return properties.get(TIME_DURATION_PROPERTY);
  }

  /**
   * The amount of time to which the Maximum Rate pertains. Changing this value resets the rate counters.
   */
  public final ControlRate setTimeDuration(final String timeDuration) {
    properties.put(TIME_DURATION_PROPERTY, timeDuration);
    return this;
  }

  /**
   * The amount of time to which the Maximum Rate pertains. Changing this value resets the rate counters.
   */
  public final ControlRate removeTimeDuration() {
    properties.remove(TIME_DURATION_PROPERTY);
    return this;
  }

  /**
   * By default, a single "throttle" is used for all FlowFiles. If this value is specified, a separate throttle is used for each value specified by the attribute with this name. Changing this value resets the rate counters.
   */
  public final String getGroupingAttribute() {
    return properties.get(GROUPING_ATTRIBUTE_PROPERTY);
  }

  /**
   * By default, a single "throttle" is used for all FlowFiles. If this value is specified, a separate throttle is used for each value specified by the attribute with this name. Changing this value resets the rate counters.
   */
  public final ControlRate setGroupingAttribute(final String groupingAttribute) {
    properties.put(GROUPING_ATTRIBUTE_PROPERTY, groupingAttribute);
    return this;
  }

  /**
   * By default, a single "throttle" is used for all FlowFiles. If this value is specified, a separate throttle is used for each value specified by the attribute with this name. Changing this value resets the rate counters.
   */
  public final ControlRate removeGroupingAttribute() {
    properties.remove(GROUPING_ATTRIBUTE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ControlRate setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ControlRate removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ControlRate, ControlRate> configurator) {
    return configurator.apply(new ControlRate()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControlRate.class) final Closure<ControlRate> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ControlRate> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ControlRate.class, com.tibtech.nifi.processors.standard.ControlRate.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
