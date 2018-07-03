package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PropertiesFileLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.PropertiesFileLookupService";

  /**
   * A configuration file
   */
  public static final String CONFIGURATION_FILE_PROPERTY = "configuration-file";

  private final Map<String, String> properties;

  public PropertiesFileLookupService() {
    this.properties = new HashMap<>();
  }

  public PropertiesFileLookupService(final Map<String, String> properties) {
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
  public final PropertiesFileLookupService setConfigurationFile(final String configurationFile) {
    properties.put(CONFIGURATION_FILE_PROPERTY, configurationFile);
    return this;
  }

  /**
   * A configuration file
   */
  public final PropertiesFileLookupService removeConfigurationFile() {
    properties.remove(CONFIGURATION_FILE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PropertiesFileLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final PropertiesFileLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PropertiesFileLookupService, PropertiesFileLookupService> configurator) {
    return configurator.apply(new PropertiesFileLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PropertiesFileLookupService.class) final Closure<PropertiesFileLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.PropertiesFileLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.PropertiesFileLookupService.class, com.tibtech.nifi.lookup.PropertiesFileLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PropertiesFileLookupService, PropertiesFileLookupService> configurator) {
    return configurator.apply(new PropertiesFileLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PropertiesFileLookupService.class) final Closure<PropertiesFileLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.PropertiesFileLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.PropertiesFileLookupService.class, com.tibtech.nifi.lookup.PropertiesFileLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
