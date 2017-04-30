package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class Base64EncodeContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.Base64EncodeContent";

  /**
   * Specifies whether the content should be encoded or decoded
   */
  public static final String MODE_PROPERTY = "Mode";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies whether the content should be encoded or decoded
   */
  public final String getMode() {
    return properties.get(MODE_PROPERTY);
  }

  /**
   * Specifies whether the content should be encoded or decoded
   */
  public final Base64EncodeContent setMode(final String mode) {
    properties.put(MODE_PROPERTY, mode);
    return this;
  }

  /**
   * Specifies whether the content should be encoded or decoded
   */
  public final Base64EncodeContent removeMode() {
    properties.remove(MODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final Base64EncodeContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final Base64EncodeContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<Base64EncodeContent, Base64EncodeContent> configurator) {
    return configurator.apply(new Base64EncodeContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Base64EncodeContent.class) final Closure<Base64EncodeContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.Base64EncodeContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.Base64EncodeContent.class, com.tibtech.nifi.processors.standard.Base64EncodeContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
