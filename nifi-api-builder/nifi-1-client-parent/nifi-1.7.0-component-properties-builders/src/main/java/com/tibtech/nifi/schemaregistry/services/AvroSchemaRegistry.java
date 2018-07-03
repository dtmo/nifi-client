package com.tibtech.nifi.schemaregistry.services;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AvroSchemaRegistry {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.schemaregistry.services.AvroSchemaRegistry";

  /**
   * Whether or not to validate the field names in the Avro schema based on Avro naming rules. If set to true, all field names must be valid Avro names, which must begin with [A-Za-z_], and subsequently contain only [A-Za-z0-9_]. If set to false, no validation will be performed on the field names.
   */
  public static final String AVRO_REG_VALIDATED_FIELD_NAMES_PROPERTY = "avro-reg-validated-field-names";

  private final Map<String, String> properties;

  public AvroSchemaRegistry() {
    this.properties = new HashMap<>();
  }

  public AvroSchemaRegistry(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Whether or not to validate the field names in the Avro schema based on Avro naming rules. If set to true, all field names must be valid Avro names, which must begin with [A-Za-z_], and subsequently contain only [A-Za-z0-9_]. If set to false, no validation will be performed on the field names.
   */
  public final String getAvroRegValidatedFieldNames() {
    return properties.get(AVRO_REG_VALIDATED_FIELD_NAMES_PROPERTY);
  }

  /**
   * Whether or not to validate the field names in the Avro schema based on Avro naming rules. If set to true, all field names must be valid Avro names, which must begin with [A-Za-z_], and subsequently contain only [A-Za-z0-9_]. If set to false, no validation will be performed on the field names.
   */
  public final AvroSchemaRegistry setAvroRegValidatedFieldNames(
      final String avroRegValidatedFieldNames) {
    properties.put(AVRO_REG_VALIDATED_FIELD_NAMES_PROPERTY, avroRegValidatedFieldNames);
    return this;
  }

  /**
   * Whether or not to validate the field names in the Avro schema based on Avro naming rules. If set to true, all field names must be valid Avro names, which must begin with [A-Za-z_], and subsequently contain only [A-Za-z0-9_]. If set to false, no validation will be performed on the field names.
   */
  public final AvroSchemaRegistry removeAvroRegValidatedFieldNames() {
    properties.remove(AVRO_REG_VALIDATED_FIELD_NAMES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AvroSchemaRegistry setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AvroSchemaRegistry removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<AvroSchemaRegistry, AvroSchemaRegistry> configurator) {
    return configurator.apply(new AvroSchemaRegistry()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AvroSchemaRegistry.class) final Closure<AvroSchemaRegistry> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.schemaregistry.services.AvroSchemaRegistry> code = closure.rehydrate(c, com.tibtech.nifi.schemaregistry.services.AvroSchemaRegistry.class, com.tibtech.nifi.schemaregistry.services.AvroSchemaRegistry.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AvroSchemaRegistry, AvroSchemaRegistry> configurator) {
    return configurator.apply(new AvroSchemaRegistry(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AvroSchemaRegistry.class) final Closure<AvroSchemaRegistry> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.schemaregistry.services.AvroSchemaRegistry> code = closure.rehydrate(c, com.tibtech.nifi.schemaregistry.services.AvroSchemaRegistry.class, com.tibtech.nifi.schemaregistry.services.AvroSchemaRegistry.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
