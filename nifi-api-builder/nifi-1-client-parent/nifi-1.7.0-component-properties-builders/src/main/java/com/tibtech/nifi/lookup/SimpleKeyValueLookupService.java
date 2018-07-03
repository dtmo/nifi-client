package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SimpleKeyValueLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.SimpleKeyValueLookupService";

  private final Map<String, String> properties;

  public SimpleKeyValueLookupService() {
    this.properties = new HashMap<>();
  }

  public SimpleKeyValueLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SimpleKeyValueLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final SimpleKeyValueLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<SimpleKeyValueLookupService, SimpleKeyValueLookupService> configurator) {
    return configurator.apply(new SimpleKeyValueLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SimpleKeyValueLookupService.class) final Closure<SimpleKeyValueLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.SimpleKeyValueLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.SimpleKeyValueLookupService.class, com.tibtech.nifi.lookup.SimpleKeyValueLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SimpleKeyValueLookupService, SimpleKeyValueLookupService> configurator) {
    return configurator.apply(new SimpleKeyValueLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SimpleKeyValueLookupService.class) final Closure<SimpleKeyValueLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.SimpleKeyValueLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.SimpleKeyValueLookupService.class, com.tibtech.nifi.lookup.SimpleKeyValueLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
