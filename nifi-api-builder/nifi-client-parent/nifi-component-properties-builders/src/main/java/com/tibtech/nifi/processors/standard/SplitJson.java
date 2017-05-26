package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SplitJson {
  /**
   * A JsonPath expression that indicates the array element to split into JSON/scalar fragments.
   */
  public static final String JSON_PATH_EXPRESSION_PROPERTY = "JsonPath Expression";

  /**
   * Indicates the desired representation of JSON Path expressions resulting in a null value.
   */
  public static final String NULL_VALUE_REPRESENTATION_PROPERTY = "Null Value Representation";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A JsonPath expression that indicates the array element to split into JSON/scalar fragments.
   */
  public final String getJsonPathExpression() {
    return properties.get(JSON_PATH_EXPRESSION_PROPERTY);
  }

  /**
   * A JsonPath expression that indicates the array element to split into JSON/scalar fragments.
   */
  public final SplitJson setJsonPathExpression(final String jsonPathExpression) {
    properties.put(JSON_PATH_EXPRESSION_PROPERTY, jsonPathExpression);
    return this;
  }

  /**
   * A JsonPath expression that indicates the array element to split into JSON/scalar fragments.
   */
  public final SplitJson removeJsonPathExpression() {
    properties.remove(JSON_PATH_EXPRESSION_PROPERTY);
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
  public final SplitJson setNullValueRepresentation(final String nullValueRepresentation) {
    properties.put(NULL_VALUE_REPRESENTATION_PROPERTY, nullValueRepresentation);
    return this;
  }

  /**
   * Indicates the desired representation of JSON Path expressions resulting in a null value.
   */
  public final SplitJson removeNullValueRepresentation() {
    properties.remove(NULL_VALUE_REPRESENTATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SplitJson setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SplitJson removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SplitJson, SplitJson> configurator) {
    return configurator.apply(new SplitJson()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitJson.class) final Closure<SplitJson> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitJson> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitJson.class, com.tibtech.nifi.processors.standard.SplitJson.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
