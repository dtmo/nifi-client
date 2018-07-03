package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ValidateRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ValidateRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * If specified, this Controller Service will be used to write out any records that are invalid. If not specified, the writer specified by the "Record Writer" property will be used. This is useful, for example, when the configured Record Writer cannot write data that does not adhere to its schema (as is the case with Avro) or when it is desirable to keep invalid records in their original format while converting valid records to another format.
   */
  public static final String INVALID_RECORD_WRITER_PROPERTY = "invalid-record-writer";

  /**
   * Specifies how to obtain the schema that should be used to validate records
   */
  public static final String SCHEMA_ACCESS_STRATEGY_PROPERTY = "schema-access-strategy";

  /**
   * Specifies the Controller Service to use for the Schema Registry. This is necessary only if the Schema Access Strategy is set to "Use 'Schema Name' Property".
   */
  public static final String SCHEMA_REGISTRY_PROPERTY = "schema-registry";

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public static final String SCHEMA_NAME_PROPERTY = "schema-name";

  /**
   * The text of an Avro-formatted Schema
   */
  public static final String SCHEMA_TEXT_PROPERTY = "schema-text";

  /**
   * If the incoming data has fields that are not present in the schema, this property determines whether or not the Record is valid. If true, the Record is still valid. If false, the Record will be invalid due to the extra fields.
   */
  public static final String ALLOW_EXTRA_FIELDS_PROPERTY = "allow-extra-fields";

  /**
   * If the incoming data has a Record where a field is not of the correct type, this property determine whether how to handle the Record. If true, the Record will still be considered invalid. If false, the Record will be considered valid and the field will be coerced into the correct type (if possible, according to the type coercion supported by the Record Writer).
   */
  public static final String STRICT_TYPE_CHECKING_PROPERTY = "strict-type-checking";

  private final Map<String, String> properties;

  public ValidateRecord() {
    this.properties = new HashMap<>();
  }

  public ValidateRecord(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final ValidateRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final ValidateRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final ValidateRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final ValidateRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * If specified, this Controller Service will be used to write out any records that are invalid. If not specified, the writer specified by the "Record Writer" property will be used. This is useful, for example, when the configured Record Writer cannot write data that does not adhere to its schema (as is the case with Avro) or when it is desirable to keep invalid records in their original format while converting valid records to another format.
   */
  public final String getInvalidRecordWriter() {
    return properties.get(INVALID_RECORD_WRITER_PROPERTY);
  }

  /**
   * If specified, this Controller Service will be used to write out any records that are invalid. If not specified, the writer specified by the "Record Writer" property will be used. This is useful, for example, when the configured Record Writer cannot write data that does not adhere to its schema (as is the case with Avro) or when it is desirable to keep invalid records in their original format while converting valid records to another format.
   */
  public final ValidateRecord setInvalidRecordWriter(final String invalidRecordWriter) {
    properties.put(INVALID_RECORD_WRITER_PROPERTY, invalidRecordWriter);
    return this;
  }

  /**
   * If specified, this Controller Service will be used to write out any records that are invalid. If not specified, the writer specified by the "Record Writer" property will be used. This is useful, for example, when the configured Record Writer cannot write data that does not adhere to its schema (as is the case with Avro) or when it is desirable to keep invalid records in their original format while converting valid records to another format.
   */
  public final ValidateRecord removeInvalidRecordWriter() {
    properties.remove(INVALID_RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Specifies how to obtain the schema that should be used to validate records
   */
  public final String getSchemaAccessStrategy() {
    return properties.get(SCHEMA_ACCESS_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to obtain the schema that should be used to validate records
   */
  public final ValidateRecord setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that should be used to validate records
   */
  public final ValidateRecord removeSchemaAccessStrategy() {
    properties.remove(SCHEMA_ACCESS_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry. This is necessary only if the Schema Access Strategy is set to "Use 'Schema Name' Property".
   */
  public final String getSchemaRegistry() {
    return properties.get(SCHEMA_REGISTRY_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry. This is necessary only if the Schema Access Strategy is set to "Use 'Schema Name' Property".
   */
  public final ValidateRecord setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry. This is necessary only if the Schema Access Strategy is set to "Use 'Schema Name' Property".
   */
  public final ValidateRecord removeSchemaRegistry() {
    properties.remove(SCHEMA_REGISTRY_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final String getSchemaName() {
    return properties.get(SCHEMA_NAME_PROPERTY);
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final ValidateRecord setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final ValidateRecord removeSchemaName() {
    properties.remove(SCHEMA_NAME_PROPERTY);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final String getSchemaText() {
    return properties.get(SCHEMA_TEXT_PROPERTY);
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final ValidateRecord setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final ValidateRecord removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  /**
   * If the incoming data has fields that are not present in the schema, this property determines whether or not the Record is valid. If true, the Record is still valid. If false, the Record will be invalid due to the extra fields.
   */
  public final String getAllowExtraFields() {
    return properties.get(ALLOW_EXTRA_FIELDS_PROPERTY);
  }

  /**
   * If the incoming data has fields that are not present in the schema, this property determines whether or not the Record is valid. If true, the Record is still valid. If false, the Record will be invalid due to the extra fields.
   */
  public final ValidateRecord setAllowExtraFields(final String allowExtraFields) {
    properties.put(ALLOW_EXTRA_FIELDS_PROPERTY, allowExtraFields);
    return this;
  }

  /**
   * If the incoming data has fields that are not present in the schema, this property determines whether or not the Record is valid. If true, the Record is still valid. If false, the Record will be invalid due to the extra fields.
   */
  public final ValidateRecord removeAllowExtraFields() {
    properties.remove(ALLOW_EXTRA_FIELDS_PROPERTY);
    return this;
  }

  /**
   * If the incoming data has a Record where a field is not of the correct type, this property determine whether how to handle the Record. If true, the Record will still be considered invalid. If false, the Record will be considered valid and the field will be coerced into the correct type (if possible, according to the type coercion supported by the Record Writer).
   */
  public final String getStrictTypeChecking() {
    return properties.get(STRICT_TYPE_CHECKING_PROPERTY);
  }

  /**
   * If the incoming data has a Record where a field is not of the correct type, this property determine whether how to handle the Record. If true, the Record will still be considered invalid. If false, the Record will be considered valid and the field will be coerced into the correct type (if possible, according to the type coercion supported by the Record Writer).
   */
  public final ValidateRecord setStrictTypeChecking(final String strictTypeChecking) {
    properties.put(STRICT_TYPE_CHECKING_PROPERTY, strictTypeChecking);
    return this;
  }

  /**
   * If the incoming data has a Record where a field is not of the correct type, this property determine whether how to handle the Record. If true, the Record will still be considered invalid. If false, the Record will be considered valid and the field will be coerced into the correct type (if possible, according to the type coercion supported by the Record Writer).
   */
  public final ValidateRecord removeStrictTypeChecking() {
    properties.remove(STRICT_TYPE_CHECKING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ValidateRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ValidateRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ValidateRecord, ValidateRecord> configurator) {
    return configurator.apply(new ValidateRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ValidateRecord.class) final Closure<ValidateRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ValidateRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ValidateRecord.class, com.tibtech.nifi.processors.standard.ValidateRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ValidateRecord, ValidateRecord> configurator) {
    return configurator.apply(new ValidateRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ValidateRecord.class) final Closure<ValidateRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ValidateRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ValidateRecord.class, com.tibtech.nifi.processors.standard.ValidateRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
