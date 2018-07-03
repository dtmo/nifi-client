package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class XMLFileLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.XMLFileLookupService";

  /**
   * A configuration file
   */
  public static final String CONFIGURATION_FILE_PROPERTY = "configuration-file";

  private final Map<String, String> properties;

  public XMLFileLookupService() {
    this.properties = new HashMap<>();
  }

  public XMLFileLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A configuration file
   */
  public final String getConfigurationFile() {
    return properties.get(CONFIGURATION_FILE_PROPERTY);
  }

  /**
   * A configuration file
   */
  public final XMLFileLookupService setConfigurationFile(final String configurationFile) {
    properties.put(CONFIGURATION_FILE_PROPERTY, configurationFile);
    return this;
  }

  /**
   * A configuration file
   */
  public final XMLFileLookupService removeConfigurationFile() {
    properties.remove(CONFIGURATION_FILE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final XMLFileLookupService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final XMLFileLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<XMLFileLookupService, XMLFileLookupService> configurator) {
    return configurator.apply(new XMLFileLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = XMLFileLookupService.class) final Closure<XMLFileLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.XMLFileLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.XMLFileLookupService.class, com.tibtech.nifi.lookup.XMLFileLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<XMLFileLookupService, XMLFileLookupService> configurator) {
    return configurator.apply(new XMLFileLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = XMLFileLookupService.class) final Closure<XMLFileLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.XMLFileLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.XMLFileLookupService.class, com.tibtech.nifi.lookup.XMLFileLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
