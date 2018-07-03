package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class EvaluateJsonPath {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.EvaluateJsonPath";

  /**
   * Indicates whether the results of the JsonPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one JsonPath may be specified, and the property name is ignored.
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * Indicates the desired return type of the JSON Path expressions.  Selecting 'auto-detect' will set the return type to 'json' for a Destination of 'flowfile-content', and 'scalar' for a Destination of 'flowfile-attribute'.
   */
  public static final String RETURN_TYPE_PROPERTY = "Return Type";

  /**
   * Indicates how to handle missing JSON path expressions when destination is set to 'flowfile-attribute'. Selecting 'warn' will generate a warning when a JSON path expression is not found.
   */
  public static final String PATH_NOT_FOUND_BEHAVIOR_PROPERTY = "Path Not Found Behavior";

  /**
   * Indicates the desired representation of JSON Path expressions resulting in a null value.
   */
  public static final String NULL_VALUE_REPRESENTATION_PROPERTY = "Null Value Representation";

  private final Map<String, String> properties;

  public EvaluateJsonPath() {
    this.properties = new HashMap<>();
  }

  public EvaluateJsonPath(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Indicates whether the results of the JsonPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one JsonPath may be specified, and the property name is ignored.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Indicates whether the results of the JsonPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one JsonPath may be specified, and the property name is ignored.
   */
  public final EvaluateJsonPath setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Indicates whether the results of the JsonPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one JsonPath may be specified, and the property name is ignored.
   */
  public final EvaluateJsonPath removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Indicates the desired return type of the JSON Path expressions.  Selecting 'auto-detect' will set the return type to 'json' for a Destination of 'flowfile-content', and 'scalar' for a Destination of 'flowfile-attribute'.
   */
  public final String getReturnType() {
    return properties.get(RETURN_TYPE_PROPERTY);
  }

  /**
   * Indicates the desired return type of the JSON Path expressions.  Selecting 'auto-detect' will set the return type to 'json' for a Destination of 'flowfile-content', and 'scalar' for a Destination of 'flowfile-attribute'.
   */
  public final EvaluateJsonPath setReturnType(final String returnType) {
    properties.put(RETURN_TYPE_PROPERTY, returnType);
    return this;
  }

  /**
   * Indicates the desired return type of the JSON Path expressions.  Selecting 'auto-detect' will set the return type to 'json' for a Destination of 'flowfile-content', and 'scalar' for a Destination of 'flowfile-attribute'.
   */
  public final EvaluateJsonPath removeReturnType() {
    properties.remove(RETURN_TYPE_PROPERTY);
    return this;
  }

  /**
   * Indicates how to handle missing JSON path expressions when destination is set to 'flowfile-attribute'. Selecting 'warn' will generate a warning when a JSON path expression is not found.
   */
  public final String getPathNotFoundBehavior() {
    return properties.get(PATH_NOT_FOUND_BEHAVIOR_PROPERTY);
  }

  /**
   * Indicates how to handle missing JSON path expressions when destination is set to 'flowfile-attribute'. Selecting 'warn' will generate a warning when a JSON path expression is not found.
   */
  public final EvaluateJsonPath setPathNotFoundBehavior(final String pathNotFoundBehavior) {
    properties.put(PATH_NOT_FOUND_BEHAVIOR_PROPERTY, pathNotFoundBehavior);
    return this;
  }

  /**
   * Indicates how to handle missing JSON path expressions when destination is set to 'flowfile-attribute'. Selecting 'warn' will generate a warning when a JSON path expression is not found.
   */
  public final EvaluateJsonPath removePathNotFoundBehavior() {
    properties.remove(PATH_NOT_FOUND_BEHAVIOR_PROPERTY);
    return this;
  }

  /**
   * Indicates the desired representation of JSON Path expressions resulting in a null value.
   */
  public final String getNullValueRepresentation() {
    return properties.get(NULL_VALUE_REPRESENTATION_PROPERTY);
  }

  /**
   * Indicates the desired representation of JSON Path expressions resulting in a null value.
   */
  public final EvaluateJsonPath setNullValueRepresentation(final String nullValueRepresentation) {
    properties.put(NULL_VALUE_REPRESENTATION_PROPERTY, nullValueRepresentation);
    return this;
  }

  /**
   * Indicates the desired representation of JSON Path expressions resulting in a null value.
   */
  public final EvaluateJsonPath removeNullValueRepresentation() {
    properties.remove(NULL_VALUE_REPRESENTATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final EvaluateJsonPath setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final EvaluateJsonPath removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<EvaluateJsonPath, EvaluateJsonPath> configurator) {
    return configurator.apply(new EvaluateJsonPath()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EvaluateJsonPath.class) final Closure<EvaluateJsonPath> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.EvaluateJsonPath> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EvaluateJsonPath.class, com.tibtech.nifi.processors.standard.EvaluateJsonPath.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<EvaluateJsonPath, EvaluateJsonPath> configurator) {
    return configurator.apply(new EvaluateJsonPath(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EvaluateJsonPath.class) final Closure<EvaluateJsonPath> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.EvaluateJsonPath> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EvaluateJsonPath.class, com.tibtech.nifi.processors.standard.EvaluateJsonPath.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
