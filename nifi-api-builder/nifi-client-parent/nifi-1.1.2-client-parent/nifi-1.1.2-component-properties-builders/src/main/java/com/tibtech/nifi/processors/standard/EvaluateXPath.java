package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class EvaluateXPath {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.EvaluateXPath";

  /**
   * Indicates whether the results of the XPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one XPath may be specified, and the property name is ignored.
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * Indicates the desired return type of the Xpath expressions.  Selecting 'auto-detect' will set the return type to 'nodeset' for a Destination of 'flowfile-content', and 'string' for a Destination of 'flowfile-attribute'.
   */
  public static final String RETURN_TYPE_PROPERTY = "Return Type";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Indicates whether the results of the XPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one XPath may be specified, and the property name is ignored.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Indicates whether the results of the XPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one XPath may be specified, and the property name is ignored.
   */
  public final EvaluateXPath setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Indicates whether the results of the XPath evaluation are written to the FlowFile content or a FlowFile attribute; if using attribute, must specify the Attribute Name property. If set to flowfile-content, only one XPath may be specified, and the property name is ignored.
   */
  public final EvaluateXPath removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Indicates the desired return type of the Xpath expressions.  Selecting 'auto-detect' will set the return type to 'nodeset' for a Destination of 'flowfile-content', and 'string' for a Destination of 'flowfile-attribute'.
   */
  public final String getReturnType() {
    return properties.get(RETURN_TYPE_PROPERTY);
  }

  /**
   * Indicates the desired return type of the Xpath expressions.  Selecting 'auto-detect' will set the return type to 'nodeset' for a Destination of 'flowfile-content', and 'string' for a Destination of 'flowfile-attribute'.
   */
  public final EvaluateXPath setReturnType(final String returnType) {
    properties.put(RETURN_TYPE_PROPERTY, returnType);
    return this;
  }

  /**
   * Indicates the desired return type of the Xpath expressions.  Selecting 'auto-detect' will set the return type to 'nodeset' for a Destination of 'flowfile-content', and 'string' for a Destination of 'flowfile-attribute'.
   */
  public final EvaluateXPath removeReturnType() {
    properties.remove(RETURN_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final EvaluateXPath setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final EvaluateXPath removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<EvaluateXPath, EvaluateXPath> configurator) {
    return configurator.apply(new EvaluateXPath()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EvaluateXPath.class) final Closure<EvaluateXPath> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.EvaluateXPath> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EvaluateXPath.class, com.tibtech.nifi.processors.standard.EvaluateXPath.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
