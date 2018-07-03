package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class LookupAttribute {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.LookupAttribute";

  /**
   * The lookup service to use for attribute lookups
   */
  public static final String LOOKUP_SERVICE_PROPERTY = "lookup-service";

  /**
   * Include null or blank values for keys that are null or blank
   */
  public static final String INCLUDE_EMPTY_VALUES_PROPERTY = "include-empty-values";

  private final Map<String, String> properties;

  public LookupAttribute() {
    this.properties = new HashMap<>();
  }

  public LookupAttribute(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The lookup service to use for attribute lookups
   */
  public final String getLookupService() {
    return properties.get(LOOKUP_SERVICE_PROPERTY);
  }

  /**
   * The lookup service to use for attribute lookups
   */
  public final LookupAttribute setLookupService(final String lookupService) {
    properties.put(LOOKUP_SERVICE_PROPERTY, lookupService);
    return this;
  }

  /**
   * The lookup service to use for attribute lookups
   */
  public final LookupAttribute removeLookupService() {
    properties.remove(LOOKUP_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Include null or blank values for keys that are null or blank
   */
  public final String getIncludeEmptyValues() {
    return properties.get(INCLUDE_EMPTY_VALUES_PROPERTY);
  }

  /**
   * Include null or blank values for keys that are null or blank
   */
  public final LookupAttribute setIncludeEmptyValues(final String includeEmptyValues) {
    properties.put(INCLUDE_EMPTY_VALUES_PROPERTY, includeEmptyValues);
    return this;
  }

  /**
   * Include null or blank values for keys that are null or blank
   */
  public final LookupAttribute removeIncludeEmptyValues() {
    properties.remove(INCLUDE_EMPTY_VALUES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final LookupAttribute setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final LookupAttribute removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<LookupAttribute, LookupAttribute> configurator) {
    return configurator.apply(new LookupAttribute()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LookupAttribute.class) final Closure<LookupAttribute> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.LookupAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LookupAttribute.class, com.tibtech.nifi.processors.standard.LookupAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<LookupAttribute, LookupAttribute> configurator) {
    return configurator.apply(new LookupAttribute(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LookupAttribute.class) final Closure<LookupAttribute> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.LookupAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LookupAttribute.class, com.tibtech.nifi.processors.standard.LookupAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
