package com.tibtech.nifi;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ModifyHTMLElement {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.ModifyHTMLElement";

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
   * Controls whether the HTML element is output as HTML,Text or Data
   */
  public static final String OUTPUT_TYPE_PROPERTY = "Output Type";

  /**
   * Value to update the found HTML elements with
   */
  public static final String MODIFIED_VALUE_PROPERTY = "Modified Value";

  /**
   * When modifying the value of an element attribute this value is used as the key to determine which attribute on the selected element will be modified with the new value.
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
  public final ModifyHTMLElement setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * Base URL for the HTML page being parsed.
   */
  public final ModifyHTMLElement removeUrl() {
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
  public final ModifyHTMLElement setCssSelector(final String cssSelector) {
    properties.put(CSS_SELECTOR_PROPERTY, cssSelector);
    return this;
  }

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public final ModifyHTMLElement removeCssSelector() {
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
  public final ModifyHTMLElement setHtmlCharacterEncoding(final String htmlCharacterEncoding) {
    properties.put(HTML_CHARACTER_ENCODING_PROPERTY, htmlCharacterEncoding);
    return this;
  }

  /**
   * Character encoding of the input HTML
   */
  public final ModifyHTMLElement removeHtmlCharacterEncoding() {
    properties.remove(HTML_CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Controls whether the HTML element is output as HTML,Text or Data
   */
  public final String getOutputType() {
    return properties.get(OUTPUT_TYPE_PROPERTY);
  }

  /**
   * Controls whether the HTML element is output as HTML,Text or Data
   */
  public final ModifyHTMLElement setOutputType(final String outputType) {
    properties.put(OUTPUT_TYPE_PROPERTY, outputType);
    return this;
  }

  /**
   * Controls whether the HTML element is output as HTML,Text or Data
   */
  public final ModifyHTMLElement removeOutputType() {
    properties.remove(OUTPUT_TYPE_PROPERTY);
    return this;
  }

  /**
   * Value to update the found HTML elements with
   */
  public final String getModifiedValue() {
    return properties.get(MODIFIED_VALUE_PROPERTY);
  }

  /**
   * Value to update the found HTML elements with
   */
  public final ModifyHTMLElement setModifiedValue(final String modifiedValue) {
    properties.put(MODIFIED_VALUE_PROPERTY, modifiedValue);
    return this;
  }

  /**
   * Value to update the found HTML elements with
   */
  public final ModifyHTMLElement removeModifiedValue() {
    properties.remove(MODIFIED_VALUE_PROPERTY);
    return this;
  }

  /**
   * When modifying the value of an element attribute this value is used as the key to determine which attribute on the selected element will be modified with the new value.
   */
  public final String getAttributeName() {
    return properties.get(ATTRIBUTE_NAME_PROPERTY);
  }

  /**
   * When modifying the value of an element attribute this value is used as the key to determine which attribute on the selected element will be modified with the new value.
   */
  public final ModifyHTMLElement setAttributeName(final String attributeName) {
    properties.put(ATTRIBUTE_NAME_PROPERTY, attributeName);
    return this;
  }

  /**
   * When modifying the value of an element attribute this value is used as the key to determine which attribute on the selected element will be modified with the new value.
   */
  public final ModifyHTMLElement removeAttributeName() {
    properties.remove(ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ModifyHTMLElement setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ModifyHTMLElement removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ModifyHTMLElement, ModifyHTMLElement> configurator) {
    return configurator.apply(new ModifyHTMLElement()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ModifyHTMLElement.class) final Closure<ModifyHTMLElement> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.ModifyHTMLElement> code = closure.rehydrate(c, com.tibtech.nifi.ModifyHTMLElement.class, com.tibtech.nifi.ModifyHTMLElement.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
