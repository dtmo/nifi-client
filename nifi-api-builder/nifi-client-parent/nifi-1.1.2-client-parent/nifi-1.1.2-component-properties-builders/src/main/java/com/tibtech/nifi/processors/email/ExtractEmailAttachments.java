package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractEmailAttachments {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.email.ExtractEmailAttachments";

  private final Map<String, String> properties = new HashMap<String, String>();

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractEmailAttachments setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractEmailAttachments removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ExtractEmailAttachments, ExtractEmailAttachments> configurator) {
    return configurator.apply(new ExtractEmailAttachments()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractEmailAttachments.class) final Closure<ExtractEmailAttachments> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ExtractEmailAttachments> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ExtractEmailAttachments.class, com.tibtech.nifi.processors.email.ExtractEmailAttachments.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
