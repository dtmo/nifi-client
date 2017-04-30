package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ValidateXml {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ValidateXml";

  /**
   * The path to the Schema file that is to be used for validation
   */
  public static final String SCHEMA_FILE_PROPERTY = "Schema File";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The path to the Schema file that is to be used for validation
   */
  public final String getSchemaFile() {
    return properties.get(SCHEMA_FILE_PROPERTY);
  }

  /**
   * The path to the Schema file that is to be used for validation
   */
  public final ValidateXml setSchemaFile(final String schemaFile) {
    properties.put(SCHEMA_FILE_PROPERTY, schemaFile);
    return this;
  }

  /**
   * The path to the Schema file that is to be used for validation
   */
  public final ValidateXml removeSchemaFile() {
    properties.remove(SCHEMA_FILE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ValidateXml setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ValidateXml removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ValidateXml, ValidateXml> configurator) {
    return configurator.apply(new ValidateXml()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ValidateXml.class) final Closure<ValidateXml> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ValidateXml> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ValidateXml.class, com.tibtech.nifi.processors.standard.ValidateXml.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
