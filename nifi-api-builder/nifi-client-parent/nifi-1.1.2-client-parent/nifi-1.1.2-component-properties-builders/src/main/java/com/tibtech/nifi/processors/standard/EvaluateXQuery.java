package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class EvaluateXQuery {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.EvaluateXQuery";

  /**
   * Indicates whether the results of the XQuery evaluation are written to the FlowFile content or a FlowFile attribute. If set to <flowfile-content>, only one XQuery may be specified and the property name is ignored.  If set to <flowfile-attribute> and the XQuery returns more than one result, multiple attributes will be added to theFlowFile, each named with a '.n' one-up number appended to the specified attribute name
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * Identifies the overall method that should be used for outputting a result tree.
   */
  public static final String OUTPUT_METHOD_PROPERTY = "Output: Method";

  /**
   * Specifies whether the processor should output an XML declaration when transforming a result tree.
   */
  public static final String OUTPUT_OMIT_XML_DECLARATION_PROPERTY = "Output: Omit XML Declaration";

  /**
   * Specifies whether the processor may add additional whitespace when outputting a result tree.
   */
  public static final String OUTPUT_INDENT_PROPERTY = "Output: Indent";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Indicates whether the results of the XQuery evaluation are written to the FlowFile content or a FlowFile attribute. If set to <flowfile-content>, only one XQuery may be specified and the property name is ignored.  If set to <flowfile-attribute> and the XQuery returns more than one result, multiple attributes will be added to theFlowFile, each named with a '.n' one-up number appended to the specified attribute name
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Indicates whether the results of the XQuery evaluation are written to the FlowFile content or a FlowFile attribute. If set to <flowfile-content>, only one XQuery may be specified and the property name is ignored.  If set to <flowfile-attribute> and the XQuery returns more than one result, multiple attributes will be added to theFlowFile, each named with a '.n' one-up number appended to the specified attribute name
   */
  public final EvaluateXQuery setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Indicates whether the results of the XQuery evaluation are written to the FlowFile content or a FlowFile attribute. If set to <flowfile-content>, only one XQuery may be specified and the property name is ignored.  If set to <flowfile-attribute> and the XQuery returns more than one result, multiple attributes will be added to theFlowFile, each named with a '.n' one-up number appended to the specified attribute name
   */
  public final EvaluateXQuery removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Identifies the overall method that should be used for outputting a result tree.
   */
  public final String getOutputMethod() {
    return properties.get(OUTPUT_METHOD_PROPERTY);
  }

  /**
   * Identifies the overall method that should be used for outputting a result tree.
   */
  public final EvaluateXQuery setOutputMethod(final String outputMethod) {
    properties.put(OUTPUT_METHOD_PROPERTY, outputMethod);
    return this;
  }

  /**
   * Identifies the overall method that should be used for outputting a result tree.
   */
  public final EvaluateXQuery removeOutputMethod() {
    properties.remove(OUTPUT_METHOD_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the processor should output an XML declaration when transforming a result tree.
   */
  public final String getOutputOmitXmlDeclaration() {
    return properties.get(OUTPUT_OMIT_XML_DECLARATION_PROPERTY);
  }

  /**
   * Specifies whether the processor should output an XML declaration when transforming a result tree.
   */
  public final EvaluateXQuery setOutputOmitXmlDeclaration(final String outputOmitXmlDeclaration) {
    properties.put(OUTPUT_OMIT_XML_DECLARATION_PROPERTY, outputOmitXmlDeclaration);
    return this;
  }

  /**
   * Specifies whether the processor should output an XML declaration when transforming a result tree.
   */
  public final EvaluateXQuery removeOutputOmitXmlDeclaration() {
    properties.remove(OUTPUT_OMIT_XML_DECLARATION_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the processor may add additional whitespace when outputting a result tree.
   */
  public final String getOutputIndent() {
    return properties.get(OUTPUT_INDENT_PROPERTY);
  }

  /**
   * Specifies whether the processor may add additional whitespace when outputting a result tree.
   */
  public final EvaluateXQuery setOutputIndent(final String outputIndent) {
    properties.put(OUTPUT_INDENT_PROPERTY, outputIndent);
    return this;
  }

  /**
   * Specifies whether the processor may add additional whitespace when outputting a result tree.
   */
  public final EvaluateXQuery removeOutputIndent() {
    properties.remove(OUTPUT_INDENT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final EvaluateXQuery setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final EvaluateXQuery removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<EvaluateXQuery, EvaluateXQuery> configurator) {
    return configurator.apply(new EvaluateXQuery()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EvaluateXQuery.class) final Closure<EvaluateXQuery> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.EvaluateXQuery> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EvaluateXQuery.class, com.tibtech.nifi.processors.standard.EvaluateXQuery.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
