package com.tibtech.nifi;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHTMLElement {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.PutHTMLElement";

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public static final String CSS_SELECTOR_PROPERTY = "CSS Selector";

  /**
   * Character encoding of the input HTML
   */
  public static final String HTML_CHARACTER_ENCODING_PROPERTY = "HTML Character Encoding";

  /**
   * Controls whether the new element is prepended or appended to the children of the Element located by the CSS selector. EX: prepended value '<b>Hi</b>' inside of Element (using CSS Selector 'p') '<p>There</p>' would result in '<p><b>Hi</b>There</p>'. Appending the value would result in '<p>There<b>Hi</b></p>'
   */
  public static final String ELEMENT_INSERT_LOCATION_TYPE_PROPERTY = "Element Insert Location Type";

  /**
   * Value used when creating the new Element. Value should be a valid HTML element. The text should be supplied unencoded: characters like '<', '>', etc will be properly HTML encoded in the resulting output.
   */
  public static final String PUT_VALUE_PROPERTY = "Put Value";

  private final Map<String, String> properties;

  public PutHTMLElement() {
    this.properties = new HashMap<>();
  }

  public PutHTMLElement(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
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
  public final PutHTMLElement setCssSelector(final String cssSelector) {
    properties.put(CSS_SELECTOR_PROPERTY, cssSelector);
    return this;
  }

  /**
   * CSS selector syntax string used to extract the desired HTML element(s).
   */
  public final PutHTMLElement removeCssSelector() {
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
  public final PutHTMLElement setHtmlCharacterEncoding(final String htmlCharacterEncoding) {
    properties.put(HTML_CHARACTER_ENCODING_PROPERTY, htmlCharacterEncoding);
    return this;
  }

  /**
   * Character encoding of the input HTML
   */
  public final PutHTMLElement removeHtmlCharacterEncoding() {
    properties.remove(HTML_CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Controls whether the new element is prepended or appended to the children of the Element located by the CSS selector. EX: prepended value '<b>Hi</b>' inside of Element (using CSS Selector 'p') '<p>There</p>' would result in '<p><b>Hi</b>There</p>'. Appending the value would result in '<p>There<b>Hi</b></p>'
   */
  public final String getElementInsertLocationType() {
    return properties.get(ELEMENT_INSERT_LOCATION_TYPE_PROPERTY);
  }

  /**
   * Controls whether the new element is prepended or appended to the children of the Element located by the CSS selector. EX: prepended value '<b>Hi</b>' inside of Element (using CSS Selector 'p') '<p>There</p>' would result in '<p><b>Hi</b>There</p>'. Appending the value would result in '<p>There<b>Hi</b></p>'
   */
  public final PutHTMLElement setElementInsertLocationType(final String elementInsertLocationType) {
    properties.put(ELEMENT_INSERT_LOCATION_TYPE_PROPERTY, elementInsertLocationType);
    return this;
  }

  /**
   * Controls whether the new element is prepended or appended to the children of the Element located by the CSS selector. EX: prepended value '<b>Hi</b>' inside of Element (using CSS Selector 'p') '<p>There</p>' would result in '<p><b>Hi</b>There</p>'. Appending the value would result in '<p>There<b>Hi</b></p>'
   */
  public final PutHTMLElement removeElementInsertLocationType() {
    properties.remove(ELEMENT_INSERT_LOCATION_TYPE_PROPERTY);
    return this;
  }

  /**
   * Value used when creating the new Element. Value should be a valid HTML element. The text should be supplied unencoded: characters like '<', '>', etc will be properly HTML encoded in the resulting output.
   */
  public final String getPutValue() {
    return properties.get(PUT_VALUE_PROPERTY);
  }

  /**
   * Value used when creating the new Element. Value should be a valid HTML element. The text should be supplied unencoded: characters like '<', '>', etc will be properly HTML encoded in the resulting output.
   */
  public final PutHTMLElement setPutValue(final String putValue) {
    properties.put(PUT_VALUE_PROPERTY, putValue);
    return this;
  }

  /**
   * Value used when creating the new Element. Value should be a valid HTML element. The text should be supplied unencoded: characters like '<', '>', etc will be properly HTML encoded in the resulting output.
   */
  public final PutHTMLElement removePutValue() {
    properties.remove(PUT_VALUE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHTMLElement setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHTMLElement removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutHTMLElement, PutHTMLElement> configurator) {
    return configurator.apply(new PutHTMLElement()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHTMLElement.class) final Closure<PutHTMLElement> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.PutHTMLElement> code = closure.rehydrate(c, com.tibtech.nifi.PutHTMLElement.class, com.tibtech.nifi.PutHTMLElement.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHTMLElement, PutHTMLElement> configurator) {
    return configurator.apply(new PutHTMLElement(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHTMLElement.class) final Closure<PutHTMLElement> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.PutHTMLElement> code = closure.rehydrate(c, com.tibtech.nifi.PutHTMLElement.class, com.tibtech.nifi.PutHTMLElement.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
