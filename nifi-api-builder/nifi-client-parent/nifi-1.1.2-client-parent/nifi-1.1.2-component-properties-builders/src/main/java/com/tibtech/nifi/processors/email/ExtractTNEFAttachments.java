package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractTNEFAttachments {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.email.ExtractTNEFAttachments";

  private final Map<String, String> properties;

  public ExtractTNEFAttachments() {
    this.properties = new HashMap<>();
  }

  public ExtractTNEFAttachments(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractTNEFAttachments setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractTNEFAttachments removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ExtractTNEFAttachments, ExtractTNEFAttachments> configurator) {
    return configurator.apply(new ExtractTNEFAttachments()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractTNEFAttachments.class) final Closure<ExtractTNEFAttachments> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ExtractTNEFAttachments> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ExtractTNEFAttachments.class, com.tibtech.nifi.processors.email.ExtractTNEFAttachments.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractTNEFAttachments, ExtractTNEFAttachments> configurator) {
    return configurator.apply(new ExtractTNEFAttachments(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractTNEFAttachments.class) final Closure<ExtractTNEFAttachments> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.email.ExtractTNEFAttachments> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ExtractTNEFAttachments.class, com.tibtech.nifi.processors.email.ExtractTNEFAttachments.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
