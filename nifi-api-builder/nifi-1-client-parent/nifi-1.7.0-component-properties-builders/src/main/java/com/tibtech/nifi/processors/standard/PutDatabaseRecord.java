package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutDatabaseRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutDatabaseRecord";

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public static final String PUT_DB_RECORD_RECORD_READER_PROPERTY = "put-db-record-record-reader";

  /**
   * Specifies the type of SQL Statement to generate. If 'Use statement.type Attribute' is chosen, then the value is taken from the statement.type attribute in the FlowFile. The 'Use statement.type Attribute' option is the only one that allows the 'SQL' statement type. If 'SQL' is specified, the value of the field specified by the 'Field Containing SQL' property is expected to be a valid SQL statement on the target database, and will be executed as-is.
   */
  public static final String PUT_DB_RECORD_STATEMENT_TYPE_PROPERTY = "put-db-record-statement-type";

  /**
   * The Controller Service that is used to obtain a connection to the database for sending records.
   */
  public static final String PUT_DB_RECORD_DCBP_SERVICE_PROPERTY = "put-db-record-dcbp-service";

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public static final String PUT_DB_RECORD_CATALOG_NAME_PROPERTY = "put-db-record-catalog-name";

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public static final String PUT_DB_RECORD_SCHEMA_NAME_PROPERTY = "put-db-record-schema-name";

  /**
   * The name of the table that the statement should affect.
   */
  public static final String PUT_DB_RECORD_TABLE_NAME_PROPERTY = "put-db-record-table-name";

  /**
   * If true, the Processor will attempt to translate field names into the appropriate column names for the table specified. If false, the field names must match the column names exactly, or the column will not be updated
   */
  public static final String PUT_DB_RECORD_TRANSLATE_FIELD_NAMES_PROPERTY = "put-db-record-translate-field-names";

  /**
   * If an incoming record has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public static final String PUT_DB_RECORD_UNMATCHED_FIELD_BEHAVIOR_PROPERTY = "put-db-record-unmatched-field-behavior";

  /**
   * If an incoming record does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public static final String PUT_DB_RECORD_UNMATCHED_COLUMN_BEHAVIOR_PROPERTY = "put-db-record-unmatched-column-behavior";

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public static final String PUT_DB_RECORD_UPDATE_KEYS_PROPERTY = "put-db-record-update-keys";

  /**
   * If the Statement Type is 'SQL' (as set in the statement.type attribute), this field indicates which field in the record(s) contains the SQL statement to execute. The value of the field must be a single SQL statement. If the Statement Type is not 'SQL', this field is ignored.
   */
  public static final String PUT_DB_RECORD_FIELD_CONTAINING_SQL_PROPERTY = "put-db-record-field-containing-sql";

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public static final String PUT_DB_RECORD_QUOTED_IDENTIFIERS_PROPERTY = "put-db-record-quoted-identifiers";

  /**
   * Enabling this option will cause the table name to be quoted to support the use of special characters in the table name.
   */
  public static final String PUT_DB_RECORD_QUOTED_TABLE_IDENTIFIERS_PROPERTY = "put-db-record-quoted-table-identifiers";

  /**
   * The maximum amount of time allowed for a running SQL statement , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public static final String PUT_DB_RECORD_QUERY_TIMEOUT_PROPERTY = "put-db-record-query-timeout";

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public static final String ROLLBACK_ON_FAILURE_PROPERTY = "rollback-on-failure";

  private final Map<String, String> properties;

  public PutDatabaseRecord() {
    this.properties = new HashMap<>();
  }

  public PutDatabaseRecord(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final String getPutDbRecordRecordReader() {
    return properties.get(PUT_DB_RECORD_RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final PutDatabaseRecord setPutDbRecordRecordReader(final String putDbRecordRecordReader) {
    properties.put(PUT_DB_RECORD_RECORD_READER_PROPERTY, putDbRecordRecordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final PutDatabaseRecord removePutDbRecordRecordReader() {
    properties.remove(PUT_DB_RECORD_RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Specifies the type of SQL Statement to generate. If 'Use statement.type Attribute' is chosen, then the value is taken from the statement.type attribute in the FlowFile. The 'Use statement.type Attribute' option is the only one that allows the 'SQL' statement type. If 'SQL' is specified, the value of the field specified by the 'Field Containing SQL' property is expected to be a valid SQL statement on the target database, and will be executed as-is.
   */
  public final String getPutDbRecordStatementType() {
    return properties.get(PUT_DB_RECORD_STATEMENT_TYPE_PROPERTY);
  }

  /**
   * Specifies the type of SQL Statement to generate. If 'Use statement.type Attribute' is chosen, then the value is taken from the statement.type attribute in the FlowFile. The 'Use statement.type Attribute' option is the only one that allows the 'SQL' statement type. If 'SQL' is specified, the value of the field specified by the 'Field Containing SQL' property is expected to be a valid SQL statement on the target database, and will be executed as-is.
   */
  public final PutDatabaseRecord setPutDbRecordStatementType(
      final String putDbRecordStatementType) {
    properties.put(PUT_DB_RECORD_STATEMENT_TYPE_PROPERTY, putDbRecordStatementType);
    return this;
  }

  /**
   * Specifies the type of SQL Statement to generate. If 'Use statement.type Attribute' is chosen, then the value is taken from the statement.type attribute in the FlowFile. The 'Use statement.type Attribute' option is the only one that allows the 'SQL' statement type. If 'SQL' is specified, the value of the field specified by the 'Field Containing SQL' property is expected to be a valid SQL statement on the target database, and will be executed as-is.
   */
  public final PutDatabaseRecord removePutDbRecordStatementType() {
    properties.remove(PUT_DB_RECORD_STATEMENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to obtain a connection to the database for sending records.
   */
  public final String getPutDbRecordDcbpService() {
    return properties.get(PUT_DB_RECORD_DCBP_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain a connection to the database for sending records.
   */
  public final PutDatabaseRecord setPutDbRecordDcbpService(final String putDbRecordDcbpService) {
    properties.put(PUT_DB_RECORD_DCBP_SERVICE_PROPERTY, putDbRecordDcbpService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain a connection to the database for sending records.
   */
  public final PutDatabaseRecord removePutDbRecordDcbpService() {
    properties.remove(PUT_DB_RECORD_DCBP_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final String getPutDbRecordCatalogName() {
    return properties.get(PUT_DB_RECORD_CATALOG_NAME_PROPERTY);
  }

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final PutDatabaseRecord setPutDbRecordCatalogName(final String putDbRecordCatalogName) {
    properties.put(PUT_DB_RECORD_CATALOG_NAME_PROPERTY, putDbRecordCatalogName);
    return this;
  }

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final PutDatabaseRecord removePutDbRecordCatalogName() {
    properties.remove(PUT_DB_RECORD_CATALOG_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final String getPutDbRecordSchemaName() {
    return properties.get(PUT_DB_RECORD_SCHEMA_NAME_PROPERTY);
  }

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final PutDatabaseRecord setPutDbRecordSchemaName(final String putDbRecordSchemaName) {
    properties.put(PUT_DB_RECORD_SCHEMA_NAME_PROPERTY, putDbRecordSchemaName);
    return this;
  }

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final PutDatabaseRecord removePutDbRecordSchemaName() {
    properties.remove(PUT_DB_RECORD_SCHEMA_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the table that the statement should affect.
   */
  public final String getPutDbRecordTableName() {
    return properties.get(PUT_DB_RECORD_TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the table that the statement should affect.
   */
  public final PutDatabaseRecord setPutDbRecordTableName(final String putDbRecordTableName) {
    properties.put(PUT_DB_RECORD_TABLE_NAME_PROPERTY, putDbRecordTableName);
    return this;
  }

  /**
   * The name of the table that the statement should affect.
   */
  public final PutDatabaseRecord removePutDbRecordTableName() {
    properties.remove(PUT_DB_RECORD_TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * If true, the Processor will attempt to translate field names into the appropriate column names for the table specified. If false, the field names must match the column names exactly, or the column will not be updated
   */
  public final String getPutDbRecordTranslateFieldNames() {
    return properties.get(PUT_DB_RECORD_TRANSLATE_FIELD_NAMES_PROPERTY);
  }

  /**
   * If true, the Processor will attempt to translate field names into the appropriate column names for the table specified. If false, the field names must match the column names exactly, or the column will not be updated
   */
  public final PutDatabaseRecord setPutDbRecordTranslateFieldNames(
      final String putDbRecordTranslateFieldNames) {
    properties.put(PUT_DB_RECORD_TRANSLATE_FIELD_NAMES_PROPERTY, putDbRecordTranslateFieldNames);
    return this;
  }

  /**
   * If true, the Processor will attempt to translate field names into the appropriate column names for the table specified. If false, the field names must match the column names exactly, or the column will not be updated
   */
  public final PutDatabaseRecord removePutDbRecordTranslateFieldNames() {
    properties.remove(PUT_DB_RECORD_TRANSLATE_FIELD_NAMES_PROPERTY);
    return this;
  }

  /**
   * If an incoming record has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public final String getPutDbRecordUnmatchedFieldBehavior() {
    return properties.get(PUT_DB_RECORD_UNMATCHED_FIELD_BEHAVIOR_PROPERTY);
  }

  /**
   * If an incoming record has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public final PutDatabaseRecord setPutDbRecordUnmatchedFieldBehavior(
      final String putDbRecordUnmatchedFieldBehavior) {
    properties.put(PUT_DB_RECORD_UNMATCHED_FIELD_BEHAVIOR_PROPERTY, putDbRecordUnmatchedFieldBehavior);
    return this;
  }

  /**
   * If an incoming record has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public final PutDatabaseRecord removePutDbRecordUnmatchedFieldBehavior() {
    properties.remove(PUT_DB_RECORD_UNMATCHED_FIELD_BEHAVIOR_PROPERTY);
    return this;
  }

  /**
   * If an incoming record does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public final String getPutDbRecordUnmatchedColumnBehavior() {
    return properties.get(PUT_DB_RECORD_UNMATCHED_COLUMN_BEHAVIOR_PROPERTY);
  }

  /**
   * If an incoming record does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public final PutDatabaseRecord setPutDbRecordUnmatchedColumnBehavior(
      final String putDbRecordUnmatchedColumnBehavior) {
    properties.put(PUT_DB_RECORD_UNMATCHED_COLUMN_BEHAVIOR_PROPERTY, putDbRecordUnmatchedColumnBehavior);
    return this;
  }

  /**
   * If an incoming record does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public final PutDatabaseRecord removePutDbRecordUnmatchedColumnBehavior() {
    properties.remove(PUT_DB_RECORD_UNMATCHED_COLUMN_BEHAVIOR_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public final String getPutDbRecordUpdateKeys() {
    return properties.get(PUT_DB_RECORD_UPDATE_KEYS_PROPERTY);
  }

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public final PutDatabaseRecord setPutDbRecordUpdateKeys(final String putDbRecordUpdateKeys) {
    properties.put(PUT_DB_RECORD_UPDATE_KEYS_PROPERTY, putDbRecordUpdateKeys);
    return this;
  }

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public final PutDatabaseRecord removePutDbRecordUpdateKeys() {
    properties.remove(PUT_DB_RECORD_UPDATE_KEYS_PROPERTY);
    return this;
  }

  /**
   * If the Statement Type is 'SQL' (as set in the statement.type attribute), this field indicates which field in the record(s) contains the SQL statement to execute. The value of the field must be a single SQL statement. If the Statement Type is not 'SQL', this field is ignored.
   */
  public final String getPutDbRecordFieldContainingSql() {
    return properties.get(PUT_DB_RECORD_FIELD_CONTAINING_SQL_PROPERTY);
  }

  /**
   * If the Statement Type is 'SQL' (as set in the statement.type attribute), this field indicates which field in the record(s) contains the SQL statement to execute. The value of the field must be a single SQL statement. If the Statement Type is not 'SQL', this field is ignored.
   */
  public final PutDatabaseRecord setPutDbRecordFieldContainingSql(
      final String putDbRecordFieldContainingSql) {
    properties.put(PUT_DB_RECORD_FIELD_CONTAINING_SQL_PROPERTY, putDbRecordFieldContainingSql);
    return this;
  }

  /**
   * If the Statement Type is 'SQL' (as set in the statement.type attribute), this field indicates which field in the record(s) contains the SQL statement to execute. The value of the field must be a single SQL statement. If the Statement Type is not 'SQL', this field is ignored.
   */
  public final PutDatabaseRecord removePutDbRecordFieldContainingSql() {
    properties.remove(PUT_DB_RECORD_FIELD_CONTAINING_SQL_PROPERTY);
    return this;
  }

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public final String getPutDbRecordQuotedIdentifiers() {
    return properties.get(PUT_DB_RECORD_QUOTED_IDENTIFIERS_PROPERTY);
  }

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public final PutDatabaseRecord setPutDbRecordQuotedIdentifiers(
      final String putDbRecordQuotedIdentifiers) {
    properties.put(PUT_DB_RECORD_QUOTED_IDENTIFIERS_PROPERTY, putDbRecordQuotedIdentifiers);
    return this;
  }

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public final PutDatabaseRecord removePutDbRecordQuotedIdentifiers() {
    properties.remove(PUT_DB_RECORD_QUOTED_IDENTIFIERS_PROPERTY);
    return this;
  }

  /**
   * Enabling this option will cause the table name to be quoted to support the use of special characters in the table name.
   */
  public final String getPutDbRecordQuotedTableIdentifiers() {
    return properties.get(PUT_DB_RECORD_QUOTED_TABLE_IDENTIFIERS_PROPERTY);
  }

  /**
   * Enabling this option will cause the table name to be quoted to support the use of special characters in the table name.
   */
  public final PutDatabaseRecord setPutDbRecordQuotedTableIdentifiers(
      final String putDbRecordQuotedTableIdentifiers) {
    properties.put(PUT_DB_RECORD_QUOTED_TABLE_IDENTIFIERS_PROPERTY, putDbRecordQuotedTableIdentifiers);
    return this;
  }

  /**
   * Enabling this option will cause the table name to be quoted to support the use of special characters in the table name.
   */
  public final PutDatabaseRecord removePutDbRecordQuotedTableIdentifiers() {
    properties.remove(PUT_DB_RECORD_QUOTED_TABLE_IDENTIFIERS_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL statement , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final String getPutDbRecordQueryTimeout() {
    return properties.get(PUT_DB_RECORD_QUERY_TIMEOUT_PROPERTY);
  }

  /**
   * The maximum amount of time allowed for a running SQL statement , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final PutDatabaseRecord setPutDbRecordQueryTimeout(final String putDbRecordQueryTimeout) {
    properties.put(PUT_DB_RECORD_QUERY_TIMEOUT_PROPERTY, putDbRecordQueryTimeout);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL statement , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final PutDatabaseRecord removePutDbRecordQueryTimeout() {
    properties.remove(PUT_DB_RECORD_QUERY_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public final String getRollbackOnFailure() {
    return properties.get(ROLLBACK_ON_FAILURE_PROPERTY);
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public final PutDatabaseRecord setRollbackOnFailure(final String rollbackOnFailure) {
    properties.put(ROLLBACK_ON_FAILURE_PROPERTY, rollbackOnFailure);
    return this;
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public final PutDatabaseRecord removeRollbackOnFailure() {
    properties.remove(ROLLBACK_ON_FAILURE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutDatabaseRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutDatabaseRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutDatabaseRecord, PutDatabaseRecord> configurator) {
    return configurator.apply(new PutDatabaseRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutDatabaseRecord.class) final Closure<PutDatabaseRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutDatabaseRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutDatabaseRecord.class, com.tibtech.nifi.processors.standard.PutDatabaseRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutDatabaseRecord, PutDatabaseRecord> configurator) {
    return configurator.apply(new PutDatabaseRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutDatabaseRecord.class) final Closure<PutDatabaseRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutDatabaseRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutDatabaseRecord.class, com.tibtech.nifi.processors.standard.PutDatabaseRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
