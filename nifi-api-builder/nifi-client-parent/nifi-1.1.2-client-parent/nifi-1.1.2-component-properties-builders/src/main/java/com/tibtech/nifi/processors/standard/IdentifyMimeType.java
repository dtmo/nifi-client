package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class IdentifyMimeType {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.IdentifyMimeType";

  private final Map<String, String> properties = new HashMap<String, String>();

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final IdentifyMimeType setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final IdentifyMimeType removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<IdentifyMimeType, IdentifyMimeType> configurator) {
    return configurator.apply(new IdentifyMimeType()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = IdentifyMimeType.class) final Closure<IdentifyMimeType> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.IdentifyMimeType> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.IdentifyMimeType.class, com.tibtech.nifi.processors.standard.IdentifyMimeType.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
