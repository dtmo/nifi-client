package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class EnforceOrder {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.EnforceOrder";

  /**
   * EnforceOrder is capable of multiple ordering groups. 'Group Identifier' is used to determine which group a FlowFile belongs to. This property will be evaluated with each incoming FlowFile. If evaluated result is empty, the FlowFile will be routed to failure.
   */
  public static final String GROUP_ID_PROPERTY = "group-id";

  /**
   * A name of FlowFile attribute whose value will be used to enforce order of FlowFiles within a group. If a FlowFile does not have this attribute, or its value is not an integer, the FlowFile will be routed to failure.
   */
  public static final String ORDER_ATTRIBUTE_PROPERTY = "order-attribute";

  /**
   * When the first FlowFile of a group arrives, initial target order will be computed and stored in the managed state. After that, target order will start being tracked by EnforceOrder and stored in the state management store. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and initial order will be left unknown until consecutive FlowFiles provide a valid initial order.
   */
  public static final String INITIAL_ORDER_PROPERTY = "initial-order";

  /**
   * If specified, any FlowFiles that have larger order will be routed to failure. This property is computed only once for a given group. After a maximum order is computed, it will be persisted in the state management store and used for other FlowFiles belonging to the same group. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and maximum order will be left unknown until consecutive FlowFiles provide a valid maximum order.
   */
  public static final String MAXIMUM_ORDER_PROPERTY = "maximum-order";

  /**
   * The maximum number of FlowFiles that EnforceOrder can process at an execution.
   */
  public static final String BATCH_COUNT_PROPERTY = "batch-count";

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'overtook' relationship.
   */
  public static final String WAIT_TIMEOUT_PROPERTY = "wait-timeout";

  /**
   * Indicates the duration after which state for an inactive group will be cleared from managed state. Group is determined as inactive if any new incoming FlowFile has not seen for a group for specified duration. Inactive Timeout must be longer than Wait Timeout. If a FlowFile arrives late after its group is already cleared, it will be treated as a brand new group, but will never match the order since expected preceding FlowFiles are already gone. The FlowFile will eventually timeout for waiting and routed to 'overtook'. To avoid this, group states should be kept long enough, however, shorter duration would be helpful for reusing the same group identifier again.
   */
  public static final String INACTIVE_TIMEOUT_PROPERTY = "inactive-timeout";

  private final Map<String, String> properties;

  public EnforceOrder() {
    this.properties = new HashMap<>();
  }

  public EnforceOrder(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * EnforceOrder is capable of multiple ordering groups. 'Group Identifier' is used to determine which group a FlowFile belongs to. This property will be evaluated with each incoming FlowFile. If evaluated result is empty, the FlowFile will be routed to failure.
   */
  public final String getGroupId() {
    return properties.get(GROUP_ID_PROPERTY);
  }

  /**
   * EnforceOrder is capable of multiple ordering groups. 'Group Identifier' is used to determine which group a FlowFile belongs to. This property will be evaluated with each incoming FlowFile. If evaluated result is empty, the FlowFile will be routed to failure.
   */
  public final EnforceOrder setGroupId(final String groupId) {
    properties.put(GROUP_ID_PROPERTY, groupId);
    return this;
  }

  /**
   * EnforceOrder is capable of multiple ordering groups. 'Group Identifier' is used to determine which group a FlowFile belongs to. This property will be evaluated with each incoming FlowFile. If evaluated result is empty, the FlowFile will be routed to failure.
   */
  public final EnforceOrder removeGroupId() {
    properties.remove(GROUP_ID_PROPERTY);
    return this;
  }

  /**
   * A name of FlowFile attribute whose value will be used to enforce order of FlowFiles within a group. If a FlowFile does not have this attribute, or its value is not an integer, the FlowFile will be routed to failure.
   */
  public final String getOrderAttribute() {
    return properties.get(ORDER_ATTRIBUTE_PROPERTY);
  }

  /**
   * A name of FlowFile attribute whose value will be used to enforce order of FlowFiles within a group. If a FlowFile does not have this attribute, or its value is not an integer, the FlowFile will be routed to failure.
   */
  public final EnforceOrder setOrderAttribute(final String orderAttribute) {
    properties.put(ORDER_ATTRIBUTE_PROPERTY, orderAttribute);
    return this;
  }

  /**
   * A name of FlowFile attribute whose value will be used to enforce order of FlowFiles within a group. If a FlowFile does not have this attribute, or its value is not an integer, the FlowFile will be routed to failure.
   */
  public final EnforceOrder removeOrderAttribute() {
    properties.remove(ORDER_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * When the first FlowFile of a group arrives, initial target order will be computed and stored in the managed state. After that, target order will start being tracked by EnforceOrder and stored in the state management store. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and initial order will be left unknown until consecutive FlowFiles provide a valid initial order.
   */
  public final String getInitialOrder() {
    return properties.get(INITIAL_ORDER_PROPERTY);
  }

  /**
   * When the first FlowFile of a group arrives, initial target order will be computed and stored in the managed state. After that, target order will start being tracked by EnforceOrder and stored in the state management store. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and initial order will be left unknown until consecutive FlowFiles provide a valid initial order.
   */
  public final EnforceOrder setInitialOrder(final String initialOrder) {
    properties.put(INITIAL_ORDER_PROPERTY, initialOrder);
    return this;
  }

  /**
   * When the first FlowFile of a group arrives, initial target order will be computed and stored in the managed state. After that, target order will start being tracked by EnforceOrder and stored in the state management store. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and initial order will be left unknown until consecutive FlowFiles provide a valid initial order.
   */
  public final EnforceOrder removeInitialOrder() {
    properties.remove(INITIAL_ORDER_PROPERTY);
    return this;
  }

  /**
   * If specified, any FlowFiles that have larger order will be routed to failure. This property is computed only once for a given group. After a maximum order is computed, it will be persisted in the state management store and used for other FlowFiles belonging to the same group. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and maximum order will be left unknown until consecutive FlowFiles provide a valid maximum order.
   */
  public final String getMaximumOrder() {
    return properties.get(MAXIMUM_ORDER_PROPERTY);
  }

  /**
   * If specified, any FlowFiles that have larger order will be routed to failure. This property is computed only once for a given group. After a maximum order is computed, it will be persisted in the state management store and used for other FlowFiles belonging to the same group. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and maximum order will be left unknown until consecutive FlowFiles provide a valid maximum order.
   */
  public final EnforceOrder setMaximumOrder(final String maximumOrder) {
    properties.put(MAXIMUM_ORDER_PROPERTY, maximumOrder);
    return this;
  }

  /**
   * If specified, any FlowFiles that have larger order will be routed to failure. This property is computed only once for a given group. After a maximum order is computed, it will be persisted in the state management store and used for other FlowFiles belonging to the same group. If Expression Language is used but evaluated result was not an integer, then the FlowFile will be routed to failure, and maximum order will be left unknown until consecutive FlowFiles provide a valid maximum order.
   */
  public final EnforceOrder removeMaximumOrder() {
    properties.remove(MAXIMUM_ORDER_PROPERTY);
    return this;
  }

  /**
   * The maximum number of FlowFiles that EnforceOrder can process at an execution.
   */
  public final String getBatchCount() {
    return properties.get(BATCH_COUNT_PROPERTY);
  }

  /**
   * The maximum number of FlowFiles that EnforceOrder can process at an execution.
   */
  public final EnforceOrder setBatchCount(final String batchCount) {
    properties.put(BATCH_COUNT_PROPERTY, batchCount);
    return this;
  }

  /**
   * The maximum number of FlowFiles that EnforceOrder can process at an execution.
   */
  public final EnforceOrder removeBatchCount() {
    properties.remove(BATCH_COUNT_PROPERTY);
    return this;
  }

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'overtook' relationship.
   */
  public final String getWaitTimeout() {
    return properties.get(WAIT_TIMEOUT_PROPERTY);
  }

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'overtook' relationship.
   */
  public final EnforceOrder setWaitTimeout(final String waitTimeout) {
    properties.put(WAIT_TIMEOUT_PROPERTY, waitTimeout);
    return this;
  }

  /**
   * Indicates the duration after which waiting FlowFiles will be routed to the 'overtook' relationship.
   */
  public final EnforceOrder removeWaitTimeout() {
    properties.remove(WAIT_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Indicates the duration after which state for an inactive group will be cleared from managed state. Group is determined as inactive if any new incoming FlowFile has not seen for a group for specified duration. Inactive Timeout must be longer than Wait Timeout. If a FlowFile arrives late after its group is already cleared, it will be treated as a brand new group, but will never match the order since expected preceding FlowFiles are already gone. The FlowFile will eventually timeout for waiting and routed to 'overtook'. To avoid this, group states should be kept long enough, however, shorter duration would be helpful for reusing the same group identifier again.
   */
  public final String getInactiveTimeout() {
    return properties.get(INACTIVE_TIMEOUT_PROPERTY);
  }

  /**
   * Indicates the duration after which state for an inactive group will be cleared from managed state. Group is determined as inactive if any new incoming FlowFile has not seen for a group for specified duration. Inactive Timeout must be longer than Wait Timeout. If a FlowFile arrives late after its group is already cleared, it will be treated as a brand new group, but will never match the order since expected preceding FlowFiles are already gone. The FlowFile will eventually timeout for waiting and routed to 'overtook'. To avoid this, group states should be kept long enough, however, shorter duration would be helpful for reusing the same group identifier again.
   */
  public final EnforceOrder setInactiveTimeout(final String inactiveTimeout) {
    properties.put(INACTIVE_TIMEOUT_PROPERTY, inactiveTimeout);
    return this;
  }

  /**
   * Indicates the duration after which state for an inactive group will be cleared from managed state. Group is determined as inactive if any new incoming FlowFile has not seen for a group for specified duration. Inactive Timeout must be longer than Wait Timeout. If a FlowFile arrives late after its group is already cleared, it will be treated as a brand new group, but will never match the order since expected preceding FlowFiles are already gone. The FlowFile will eventually timeout for waiting and routed to 'overtook'. To avoid this, group states should be kept long enough, however, shorter duration would be helpful for reusing the same group identifier again.
   */
  public final EnforceOrder removeInactiveTimeout() {
    properties.remove(INACTIVE_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final EnforceOrder setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final EnforceOrder removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<EnforceOrder, EnforceOrder> configurator) {
    return configurator.apply(new EnforceOrder()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EnforceOrder.class) final Closure<EnforceOrder> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.EnforceOrder> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EnforceOrder.class, com.tibtech.nifi.processors.standard.EnforceOrder.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<EnforceOrder, EnforceOrder> configurator) {
    return configurator.apply(new EnforceOrder(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EnforceOrder.class) final Closure<EnforceOrder> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.EnforceOrder> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EnforceOrder.class, com.tibtech.nifi.processors.standard.EnforceOrder.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
