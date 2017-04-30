package com.tibtech.nifi;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetHTMLElement {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.GetHTMLElement";

  /**
   * Base URL for the HTML page being parsed.
   */
  public static final String URL_PROPERTY = "URL";

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public static final String CSS_SELECTOR_PROPERTY = "CSS Selector";

  /**
   * Character encoding of the input HTML
   */
  public static final String HTML_CHARACTER_ENCODING_PROPERTY = "HTML Character Encoding";

  /**
   * Controls the type of DOM value that is retrieved from the HTML element.
   */
  public static final String OUTPUT_TYPE_PROPERTY = "Output Type";

  /**
   * Control if element extracted is written as a flowfile attribute or as flowfile content.
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * Prepends the specified value to the resulting Element
   */
  public static final String PREPEND_ELEMENT_VALUE_PROPERTY = "Prepend Element Value";

  /**
   * Appends the specified value to the resulting Element
   */
  public static final String APPEND_ELEMENT_VALUE_PROPERTY = "Append Element Value";

  /**
   * When getting the value of a HTML element attribute this value is used as the key to determine which attribute on the selected element should be retrieved. This value is used when the "Output Type" is set to "Attribute"
   */
  public static final String ATTRIBUTE_NAME_PROPERTY = "Attribute Name";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Base URL for the HTML page being parsed.
   */
  public final String getUrl() {
    return properties.get(URL_PROPERTY);
  }

  /**
   * Base URL for the HTML page being parsed.
   */
  public final GetHTMLElement setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * Base URL for the HTML page being parsed.
   */
  public final GetHTMLElement removeUrl() {
    properties.remove(URL_PROPERTY);
    return this;
  }

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public final String getCssSelector() {
    return properties.get(CSS_SELECTOR_PROPERTY);
  }

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public final GetHTMLElement setCssSelector(final String cssSelector) {
    properties.put(CSS_SELECTOR_PROPERTY, cssSelector);
    return this;
  }

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public final GetHTMLElement removeCssSelector() {
    properties.remove(CSS_SELECTOR_PROPERTY);
    return this;
  }

  /**
   * Character encoding of the input HTML
   */
  public final String getHtmlCharacterEncoding() {
    return properties.get(HTML_CHARACTER_ENCODING_PROPERTY);
  }

  /**
   * Character encoding of the input HTML
   */
  public final GetHTMLElement setHtmlCharacterEncoding(final String htmlCharacterEncoding) {
    properties.put(HTML_CHARACTER_ENCODING_PROPERTY, htmlCharacterEncoding);
    return this;
  }

  /**
   * Character encoding of the input HTML
   */
  public final GetHTMLElement removeHtmlCharacterEncoding() {
    properties.remove(HTML_CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Controls the type of DOM value that is retrieved from the HTML element.
   */
  public final String getOutputType() {
    return properties.get(OUTPUT_TYPE_PROPERTY);
  }

  /**
   * Controls the type of DOM value that is retrieved from the HTML element.
   */
  public final GetHTMLElement setOutputType(final String outputType) {
    properties.put(OUTPUT_TYPE_PROPERTY, outputType);
    return this;
  }

  /**
   * Controls the type of DOM value that is retrieved from the HTML element.
   */
  public final GetHTMLElement removeOutputType() {
    properties.remove(OUTPUT_TYPE_PROPERTY);
    return this;
  }

  /**
   * Control if element extracted is written as a flowfile attribute or as flowfile content.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Control if element extracted is written as a flowfile attribute or as flowfile content.
   */
  public final GetHTMLElement setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Control if element extracted is written as a flowfile attribute or as flowfile content.
   */
  public final GetHTMLElement removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Prepends the specified value to the resulting Element
   */
  public final String getPrependElementValue() {
    return properties.get(PREPEND_ELEMENT_VALUE_PROPERTY);
  }

  /**
   * Prepends the specified value to the resulting Element
   */
  public final GetHTMLElement setPrependElementValue(final String prependElementValue) {
    properties.put(PREPEND_ELEMENT_VALUE_PROPERTY, prependElementValue);
    return this;
  }

  /**
   * Prepends the specified value to the resulting Element
   */
  public final GetHTMLElement removePrependElementValue() {
    properties.remove(PREPEND_ELEMENT_VALUE_PROPERTY);
    return this;
  }

  /**
   * Appends the specified value to the resulting Element
   */
  public final String getAppendElementValue() {
    return properties.get(APPEND_ELEMENT_VALUE_PROPERTY);
  }

  /**
   * Appends the specified value to the resulting Element
   */
  public final GetHTMLElement setAppendElementValue(final String appendElementValue) {
    properties.put(APPEND_ELEMENT_VALUE_PROPERTY, appendElementValue);
    return this;
  }

  /**
   * Appends the specified value to the resulting Element
   */
  public final GetHTMLElement removeAppendElementValue() {
    properties.remove(APPEND_ELEMENT_VALUE_PROPERTY);
    return this;
  }

  /**
   * When getting the value of a HTML element attribute this value is used as the key to determine which attribute on the selected element should be retrieved. This value is used when the "Output Type" is set to "Attribute"
   */
  public final String getAttributeName() {
    return properties.get(ATTRIBUTE_NAME_PROPERTY);
  }

  /**
   * When getting the value of a HTML element attribute this value is used as the key to determine which attribute on the selected element should be retrieved. This value is used when the "Output Type" is set to "Attribute"
   */
  public final GetHTMLElement setAttributeName(final String attributeName) {
    properties.put(ATTRIBUTE_NAME_PROPERTY, attributeName);
    return this;
  }

  /**
   * When getting the value of a HTML element attribute this value is used as the key to determine which attribute on the selected element should be retrieved. This value is used when the "Output Type" is set to "Attribute"
   */
  public final GetHTMLElement removeAttributeName() {
    properties.remove(ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetHTMLElement setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetHTMLElement removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetHTMLElement, GetHTMLElement> configurator) {
    return configurator.apply(new GetHTMLElement()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHTMLElement.class) final Closure<GetHTMLElement> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.GetHTMLElement> code = closure.rehydrate(c, com.tibtech.nifi.GetHTMLElement.class, com.tibtech.nifi.GetHTMLElement.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
