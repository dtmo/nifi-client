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
   * Regular expression for attributes to be deleted from flowfiles.
   */
  public static final String DELETE_ATTRIBUTES_EXPRESSION_PROPERTY = "Delete Attributes Expression";

  private final Map<String, String> properties;

  public UpdateAttribute() {
    this.properties = new HashMap<>();
  }

  public UpdateAttribute(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Regular expression for attributes to be deleted from flowfiles.
   */
  public final String getDeleteAttributesExpression() {
    return properties.get(DELETE_ATTRIBUTES_EXPRESSION_PROPERTY);
  }

  /**
   * Regular expression for attributes to be deleted from flowfiles.
   */
  public final UpdateAttribute setDeleteAttributesExpression(final String deleteAttributesExpression) {
    properties.put(DELETE_ATTRIBUTES_EXPRESSION_PROPERTY, deleteAttributesExpression);
    return this;
  }

  /**
   * Regular expression for attributes to be deleted from flowfiles.
   */
  public final UpdateAttribute removeDeleteAttributesExpression() {
    properties.remove(DELETE_ATTRIBUTES_EXPRESSION_PROPERTY);
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

  public static final Map<String, String> build(final Function<UpdateAttribute, UpdateAttribute> configurator) {
    return configurator.apply(new UpdateAttribute()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateAttribute.class) final Closure<UpdateAttribute> closure) {
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
