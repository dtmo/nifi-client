package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AttributesToCSV {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.AttributesToCSV";

  /**
   * Comma separated list of attributes to be included in the resulting CSV. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive and supports attribute names that contain commas. If an attribute specified in the list is not found it will be emitted to the resulting CSV with an empty string or null depending on the 'Null Value' property. If a core attribute is specified in this list and the 'Include Core Attributes' property is false, the core attribute will be included. The attribute list ALWAYS wins.
   */
  public static final String ATTRIBUTE_LIST_PROPERTY = "attribute-list";

  /**
   * Regular expression that will be evaluated against the flow file attributes to select the matching attributes. This property can be used in combination with the attributes list property.  The final output will contain a combination of matches found in the ATTRIBUTE_LIST and ATTRIBUTE_REGEX.
   */
  public static final String ATTRIBUTES_REGEX_PROPERTY = "attributes-regex";

  /**
   * Control if CSV value is written as a new flowfile attribute 'CSVData' or written in the flowfile content.
   */
  public static final String DESTINATION_PROPERTY = "destination";

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes, which are contained in every FlowFile, should be included in the final CSV value generated.  Core attributes will be added to the end of the CSVData and CSVSchema strings.  The Attribute List property overrides this setting.
   */
  public static final String INCLUDE_CORE_ATTRIBUTES_PROPERTY = "include-core-attributes";

  /**
   * If true a non existing or empty attribute will be 'null' in the resulting CSV. If false an empty string will be placed in the CSV
   */
  public static final String NULL_VALUE_PROPERTY = "null-value";

  /**
   * If true the schema (attribute names) will also be converted to a CSV string which will either be applied to a new attribute named 'CSVSchema' or applied at the first row in the content depending on the DESTINATION property setting.
   */
  public static final String INCLUDE_SCHEMA_PROPERTY = "include-schema";

  private final Map<String, String> properties;

  public AttributesToCSV() {
    this.properties = new HashMap<>();
  }

  public AttributesToCSV(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Comma separated list of attributes to be included in the resulting CSV. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive and supports attribute names that contain commas. If an attribute specified in the list is not found it will be emitted to the resulting CSV with an empty string or null depending on the 'Null Value' property. If a core attribute is specified in this list and the 'Include Core Attributes' property is false, the core attribute will be included. The attribute list ALWAYS wins.
   */
  public final String getAttributeList() {
    return properties.get(ATTRIBUTE_LIST_PROPERTY);
  }

  /**
   * Comma separated list of attributes to be included in the resulting CSV. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive and supports attribute names that contain commas. If an attribute specified in the list is not found it will be emitted to the resulting CSV with an empty string or null depending on the 'Null Value' property. If a core attribute is specified in this list and the 'Include Core Attributes' property is false, the core attribute will be included. The attribute list ALWAYS wins.
   */
  public final AttributesToCSV setAttributeList(final String attributeList) {
    properties.put(ATTRIBUTE_LIST_PROPERTY, attributeList);
    return this;
  }

  /**
   * Comma separated list of attributes to be included in the resulting CSV. If this value is left empty then all existing Attributes will be included. This list of attributes is case sensitive and supports attribute names that contain commas. If an attribute specified in the list is not found it will be emitted to the resulting CSV with an empty string or null depending on the 'Null Value' property. If a core attribute is specified in this list and the 'Include Core Attributes' property is false, the core attribute will be included. The attribute list ALWAYS wins.
   */
  public final AttributesToCSV removeAttributeList() {
    properties.remove(ATTRIBUTE_LIST_PROPERTY);
    return this;
  }

  /**
   * Regular expression that will be evaluated against the flow file attributes to select the matching attributes. This property can be used in combination with the attributes list property.  The final output will contain a combination of matches found in the ATTRIBUTE_LIST and ATTRIBUTE_REGEX.
   */
  public final String getAttributesRegex() {
    return properties.get(ATTRIBUTES_REGEX_PROPERTY);
  }

  /**
   * Regular expression that will be evaluated against the flow file attributes to select the matching attributes. This property can be used in combination with the attributes list property.  The final output will contain a combination of matches found in the ATTRIBUTE_LIST and ATTRIBUTE_REGEX.
   */
  public final AttributesToCSV setAttributesRegex(final String attributesRegex) {
    properties.put(ATTRIBUTES_REGEX_PROPERTY, attributesRegex);
    return this;
  }

  /**
   * Regular expression that will be evaluated against the flow file attributes to select the matching attributes. This property can be used in combination with the attributes list property.  The final output will contain a combination of matches found in the ATTRIBUTE_LIST and ATTRIBUTE_REGEX.
   */
  public final AttributesToCSV removeAttributesRegex() {
    properties.remove(ATTRIBUTES_REGEX_PROPERTY);
    return this;
  }

  /**
   * Control if CSV value is written as a new flowfile attribute 'CSVData' or written in the flowfile content.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Control if CSV value is written as a new flowfile attribute 'CSVData' or written in the flowfile content.
   */
  public final AttributesToCSV setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Control if CSV value is written as a new flowfile attribute 'CSVData' or written in the flowfile content.
   */
  public final AttributesToCSV removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes, which are contained in every FlowFile, should be included in the final CSV value generated.  Core attributes will be added to the end of the CSVData and CSVSchema strings.  The Attribute List property overrides this setting.
   */
  public final String getIncludeCoreAttributes() {
    return properties.get(INCLUDE_CORE_ATTRIBUTES_PROPERTY);
  }

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes, which are contained in every FlowFile, should be included in the final CSV value generated.  Core attributes will be added to the end of the CSVData and CSVSchema strings.  The Attribute List property overrides this setting.
   */
  public final AttributesToCSV setIncludeCoreAttributes(final String includeCoreAttributes) {
    properties.put(INCLUDE_CORE_ATTRIBUTES_PROPERTY, includeCoreAttributes);
    return this;
  }

  /**
   * Determines if the FlowFile org.apache.nifi.flowfile.attributes.CoreAttributes, which are contained in every FlowFile, should be included in the final CSV value generated.  Core attributes will be added to the end of the CSVData and CSVSchema strings.  The Attribute List property overrides this setting.
   */
  public final AttributesToCSV removeIncludeCoreAttributes() {
    properties.remove(INCLUDE_CORE_ATTRIBUTES_PROPERTY);
    return this;
  }

  /**
   * If true a non existing or empty attribute will be 'null' in the resulting CSV. If false an empty string will be placed in the CSV
   */
  public final String getNullValue() {
    return properties.get(NULL_VALUE_PROPERTY);
  }

  /**
   * If true a non existing or empty attribute will be 'null' in the resulting CSV. If false an empty string will be placed in the CSV
   */
  public final AttributesToCSV setNullValue(final String nullValue) {
    properties.put(NULL_VALUE_PROPERTY, nullValue);
    return this;
  }

  /**
   * If true a non existing or empty attribute will be 'null' in the resulting CSV. If false an empty string will be placed in the CSV
   */
  public final AttributesToCSV removeNullValue() {
    properties.remove(NULL_VALUE_PROPERTY);
    return this;
  }

  /**
   * If true the schema (attribute names) will also be converted to a CSV string which will either be applied to a new attribute named 'CSVSchema' or applied at the first row in the content depending on the DESTINATION property setting.
   */
  public final String getIncludeSchema() {
    return properties.get(INCLUDE_SCHEMA_PROPERTY);
  }

  /**
   * If true the schema (attribute names) will also be converted to a CSV string which will either be applied to a new attribute named 'CSVSchema' or applied at the first row in the content depending on the DESTINATION property setting.
   */
  public final AttributesToCSV setIncludeSchema(final String includeSchema) {
    properties.put(INCLUDE_SCHEMA_PROPERTY, includeSchema);
    return this;
  }

  /**
   * If true the schema (attribute names) will also be converted to a CSV string which will either be applied to a new attribute named 'CSVSchema' or applied at the first row in the content depending on the DESTINATION property setting.
   */
  public final AttributesToCSV removeIncludeSchema() {
    properties.remove(INCLUDE_SCHEMA_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AttributesToCSV setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AttributesToCSV removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<AttributesToCSV, AttributesToCSV> configurator) {
    return configurator.apply(new AttributesToCSV()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AttributesToCSV.class) final Closure<AttributesToCSV> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.AttributesToCSV> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.AttributesToCSV.class, com.tibtech.nifi.processors.standard.AttributesToCSV.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AttributesToCSV, AttributesToCSV> configurator) {
    return configurator.apply(new AttributesToCSV(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AttributesToCSV.class) final Closure<AttributesToCSV> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.AttributesToCSV> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.AttributesToCSV.class, com.tibtech.nifi.processors.standard.AttributesToCSV.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
