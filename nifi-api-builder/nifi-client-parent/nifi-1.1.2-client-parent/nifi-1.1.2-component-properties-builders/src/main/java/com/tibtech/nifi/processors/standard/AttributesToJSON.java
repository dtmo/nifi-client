package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AttributesToJSON {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.AttributesToJSON";

  /**
   * Comma separated list of attributes to be included in the resulting JSON. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive. If an attribute specified in the list is not found it will be be emitted to the resulting JSON with an empty string or NULL value.
   */
  public static final String ATTRIBUTES_LIST_PROPERTY = "Attributes List";

  /**
   * Control if JSON value is written as a new flowfile attribute 'JSONAttributes' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes which are contained in every FlowFile should be included in the final JSON value generated.
   */
  public static final String INCLUDE_CORE_ATTRIBUTES_PROPERTY = "Include Core Attributes";

  /**
   * If true a non existing or empty attribute will be NULL in the resulting JSON. If false an empty string will be placed in the JSON
   */
  public static final String NULL_VALUE_PROPERTY = "Null Value";

  private final Map<String, String> properties;

  public AttributesToJSON() {
    this.properties = new HashMap<>();
  }

  public AttributesToJSON(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Comma separated list of attributes to be included in the resulting JSON. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive. If an attribute specified in the list is not found it will be be emitted to the resulting JSON with an empty string or NULL value.
   */
  public final String getAttributesList() {
    return properties.get(ATTRIBUTES_LIST_PROPERTY);
  }

  /**
   * Comma separated list of attributes to be included in the resulting JSON. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive. If an attribute specified in the list is not found it will be be emitted to the resulting JSON with an empty string or NULL value.
   */
  public final AttributesToJSON setAttributesList(final String attributesList) {
    properties.put(ATTRIBUTES_LIST_PROPERTY, attributesList);
    return this;
  }

  /**
   * Comma separated list of attributes to be included in the resulting JSON. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive. If an attribute specified in the list is not found it will be be emitted to the resulting JSON with an empty string or NULL value.
   */
  public final AttributesToJSON removeAttributesList() {
    properties.remove(ATTRIBUTES_LIST_PROPERTY);
    return this;
  }

  /**
   * Control if JSON value is written as a new flowfile attribute 'JSONAttributes' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Control if JSON value is written as a new flowfile attribute 'JSONAttributes' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final AttributesToJSON setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Control if JSON value is written as a new flowfile attribute 'JSONAttributes' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final AttributesToJSON removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes which are contained in every FlowFile should be included in the final JSON value generated.
   */
  public final String getIncludeCoreAttributes() {
    return properties.get(INCLUDE_CORE_ATTRIBUTES_PROPERTY);
  }

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes which are contained in every FlowFile should be included in the final JSON value generated.
   */
  public final AttributesToJSON setIncludeCoreAttributes(final String includeCoreAttributes) {
    properties.put(INCLUDE_CORE_ATTRIBUTES_PROPERTY, includeCoreAttributes);
    return this;
  }

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes which are contained in every FlowFile should be included in the final JSON value generated.
   */
  public final AttributesToJSON removeIncludeCoreAttributes() {
    properties.remove(INCLUDE_CORE_ATTRIBUTES_PROPERTY);
    return this;
  }

  /**
   * If true a non existing or empty attribute will be NULL in the resulting JSON. If false an empty string will be placed in the JSON
   */
  public final String getNullValue() {
    return properties.get(NULL_VALUE_PROPERTY);
  }

  /**
   * If true a non existing or empty attribute will be NULL in the resulting JSON. If false an empty string will be placed in the JSON
   */
  public final AttributesToJSON setNullValue(final String nullValue) {
    properties.put(NULL_VALUE_PROPERTY, nullValue);
    return this;
  }

  /**
   * If true a non existing or empty attribute will be NULL in the resulting JSON. If false an empty string will be placed in the JSON
   */
  public final AttributesToJSON removeNullValue() {
    properties.remove(NULL_VALUE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AttributesToJSON setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AttributesToJSON removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<AttributesToJSON, AttributesToJSON> configurator) {
    return configurator.apply(new AttributesToJSON()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AttributesToJSON.class) final Closure<AttributesToJSON> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.AttributesToJSON> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.AttributesToJSON.class, com.tibtech.nifi.processors.standard.AttributesToJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AttributesToJSON, AttributesToJSON> configurator) {
    return configurator.apply(new AttributesToJSON(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AttributesToJSON.class) final Closure<AttributesToJSON> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.AttributesToJSON> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.AttributesToJSON.class, com.tibtech.nifi.processors.standard.AttributesToJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
