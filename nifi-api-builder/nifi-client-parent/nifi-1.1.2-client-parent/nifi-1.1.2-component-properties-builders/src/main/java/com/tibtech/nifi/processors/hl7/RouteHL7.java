package com.tibtech.nifi.processors.hl7;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RouteHL7 {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hl7.RouteHL7";

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public static final String CHARACTER_ENCODING_PROPERTY = "Character Encoding";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public final String getCharacterEncoding() {
    return properties.get(CHARACTER_ENCODING_PROPERTY);
  }

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public final RouteHL7 setCharacterEncoding(final String characterEncoding) {
    properties.put(CHARACTER_ENCODING_PROPERTY, characterEncoding);
    return this;
  }

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public final RouteHL7 removeCharacterEncoding() {
    properties.remove(CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RouteHL7 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final RouteHL7 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<RouteHL7, RouteHL7> configurator) {
    return configurator.apply(new RouteHL7()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RouteHL7.class) final Closure<RouteHL7> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hl7.RouteHL7> code = closure.rehydrate(c, com.tibtech.nifi.processors.hl7.RouteHL7.class, com.tibtech.nifi.processors.hl7.RouteHL7.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
