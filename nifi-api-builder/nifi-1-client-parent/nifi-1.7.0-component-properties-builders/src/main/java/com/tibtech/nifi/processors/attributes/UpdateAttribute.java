package com.tibtech.nifi.processors.attributes;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class UpdateAttribute {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.attributes.UpdateAttribute";

  /**
   * Regular expression for attributes to be deleted from FlowFiles.  Existing attributes that match will be deleted regardless of whether they are updated by this processor.
   */
  public static final String DELETE_ATTRIBUTES_EXPRESSION_PROPERTY = "Delete Attributes Expression";

  /**
   * Select whether or not state will be stored. Selecting 'Stateless' will offer the default functionality of purely updating the attributes on a FlowFile in a stateless manner. Selecting a stateful option will not only store the attributes on the FlowFile but also in the Processors state. See the 'Stateful Usage' topic of the 'Additional Details' section of this processor's documentation for more information
   */
  public static final String STORE_STATE_PROPERTY = "Store State";

  /**
   * If using state to set/reference variables then this value is used to set the initial value of the stateful variable. This will only be used in the @OnScheduled method when state does not contain a value for the variable. This is required if running statefully but can be empty if needed.
   */
  public static final String STATEFUL_VARIABLES_INITIAL_VALUE_PROPERTY = "Stateful Variables Initial Value";

  private final Map<String, String> properties;

  public UpdateAttribute() {
    this.properties = new HashMap<>();
  }

  public UpdateAttribute(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Regular expression for attributes to be deleted from FlowFiles.  Existing attributes that match will be deleted regardless of whether they are updated by this processor.
   */
  public final String getDeleteAttributesExpression() {
    return properties.get(DELETE_ATTRIBUTES_EXPRESSION_PROPERTY);
  }

  /**
   * Regular expression for attributes to be deleted from FlowFiles.  Existing attributes that match will be deleted regardless of whether they are updated by this processor.
   */
  public final UpdateAttribute setDeleteAttributesExpression(
      final String deleteAttributesExpression) {
    properties.put(DELETE_ATTRIBUTES_EXPRESSION_PROPERTY, deleteAttributesExpression);
    return this;
  }

  /**
   * Regular expression for attributes to be deleted from FlowFiles.  Existing attributes that match will be deleted regardless of whether they are updated by this processor.
   */
  public final UpdateAttribute removeDeleteAttributesExpression() {
    properties.remove(DELETE_ATTRIBUTES_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * Select whether or not state will be stored. Selecting 'Stateless' will offer the default functionality of purely updating the attributes on a FlowFile in a stateless manner. Selecting a stateful option will not only store the attributes on the FlowFile but also in the Processors state. See the 'Stateful Usage' topic of the 'Additional Details' section of this processor's documentation for more information
   */
  public final String getStoreState() {
    return properties.get(STORE_STATE_PROPERTY);
  }

  /**
   * Select whether or not state will be stored. Selecting 'Stateless' will offer the default functionality of purely updating the attributes on a FlowFile in a stateless manner. Selecting a stateful option will not only store the attributes on the FlowFile but also in the Processors state. See the 'Stateful Usage' topic of the 'Additional Details' section of this processor's documentation for more information
   */
  public final UpdateAttribute setStoreState(final String storeState) {
    properties.put(STORE_STATE_PROPERTY, storeState);
    return this;
  }

  /**
   * Select whether or not state will be stored. Selecting 'Stateless' will offer the default functionality of purely updating the attributes on a FlowFile in a stateless manner. Selecting a stateful option will not only store the attributes on the FlowFile but also in the Processors state. See the 'Stateful Usage' topic of the 'Additional Details' section of this processor's documentation for more information
   */
  public final UpdateAttribute removeStoreState() {
    properties.remove(STORE_STATE_PROPERTY);
    return this;
  }

  /**
   * If using state to set/reference variables then this value is used to set the initial value of the stateful variable. This will only be used in the @OnScheduled method when state does not contain a value for the variable. This is required if running statefully but can be empty if needed.
   */
  public final String getStatefulVariablesInitialValue() {
    return properties.get(STATEFUL_VARIABLES_INITIAL_VALUE_PROPERTY);
  }

  /**
   * If using state to set/reference variables then this value is used to set the initial value of the stateful variable. This will only be used in the @OnScheduled method when state does not contain a value for the variable. This is required if running statefully but can be empty if needed.
   */
  public final UpdateAttribute setStatefulVariablesInitialValue(
      final String statefulVariablesInitialValue) {
    properties.put(STATEFUL_VARIABLES_INITIAL_VALUE_PROPERTY, statefulVariablesInitialValue);
    return this;
  }

  /**
   * If using state to set/reference variables then this value is used to set the initial value of the stateful variable. This will only be used in the @OnScheduled method when state does not contain a value for the variable. This is required if running statefully but can be empty if needed.
   */
  public final UpdateAttribute removeStatefulVariablesInitialValue() {
    properties.remove(STATEFUL_VARIABLES_INITIAL_VALUE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final UpdateAttribute setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final UpdateAttribute removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<UpdateAttribute, UpdateAttribute> configurator) {
    return configurator.apply(new UpdateAttribute()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateAttribute.class) final Closure<UpdateAttribute> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.attributes.UpdateAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.attributes.UpdateAttribute.class, com.tibtech.nifi.processors.attributes.UpdateAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<UpdateAttribute, UpdateAttribute> configurator) {
    return configurator.apply(new UpdateAttribute(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateAttribute.class) final Closure<UpdateAttribute> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.attributes.UpdateAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.attributes.UpdateAttribute.class, com.tibtech.nifi.processors.attributes.UpdateAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
