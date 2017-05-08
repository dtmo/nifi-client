package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertJSONToSQL {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ConvertJSONToSQL";

  /**
   * Specifies the JDBC Connection Pool to use in order to convert the JSON message to a SQL statement. The Connection Pool is necessary in order to determine the appropriate database column types.
   */
  public static final String JDBC_CONNECTION_POOL_PROPERTY = "JDBC Connection Pool";

  /**
   * Specifies the type of SQL Statement to generate
   */
  public static final String STATEMENT_TYPE_PROPERTY = "Statement Type";

  /**
   * The name of the table that the statement should update
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public static final String CATALOG_NAME_PROPERTY = "Catalog Name";

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public static final String SCHEMA_NAME_PROPERTY = "Schema Name";

  /**
   * If true, the Processor will attempt to translate JSON field names into the appropriate column names for the table specified. If false, the JSON field names must match the column names exactly, or the column will not be updated
   */
  public static final String TRANSLATE_FIELD_NAMES_PROPERTY = "Translate Field Names";

  /**
   * If an incoming JSON element has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public static final String UNMATCHED_FIELD_BEHAVIOR_PROPERTY = "Unmatched Field Behavior";

  /**
   * If an incoming JSON element does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public static final String UNMATCHED_COLUMN_BEHAVIOR_PROPERTY = "Unmatched Column Behavior";

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public static final String UPDATE_KEYS_PROPERTY = "Update Keys";

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public static final String JTS_QUOTED_IDENTIFIERS_PROPERTY = "jts-quoted-identifiers";

  private final Map<String, String> properties;

  public ConvertJSONToSQL() {
    this.properties = new HashMap<>();
  }

  public ConvertJSONToSQL(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the JDBC Connection Pool to use in order to convert the JSON message to a SQL statement. The Connection Pool is necessary in order to determine the appropriate database column types.
   */
  public final String getJdbcConnectionPool() {
    return properties.get(JDBC_CONNECTION_POOL_PROPERTY);
  }

  /**
   * Specifies the JDBC Connection Pool to use in order to convert the JSON message to a SQL statement. The Connection Pool is necessary in order to determine the appropriate database column types.
   */
  public final ConvertJSONToSQL setJdbcConnectionPool(final String jdbcConnectionPool) {
    properties.put(JDBC_CONNECTION_POOL_PROPERTY, jdbcConnectionPool);
    return this;
  }

  /**
   * Specifies the JDBC Connection Pool to use in order to convert the JSON message to a SQL statement. The Connection Pool is necessary in order to determine the appropriate database column types.
   */
  public final ConvertJSONToSQL removeJdbcConnectionPool() {
    properties.remove(JDBC_CONNECTION_POOL_PROPERTY);
    return this;
  }

  /**
   * Specifies the type of SQL Statement to generate
   */
  public final String getStatementType() {
    return properties.get(STATEMENT_TYPE_PROPERTY);
  }

  /**
   * Specifies the type of SQL Statement to generate
   */
  public final ConvertJSONToSQL setStatementType(final String statementType) {
    properties.put(STATEMENT_TYPE_PROPERTY, statementType);
    return this;
  }

  /**
   * Specifies the type of SQL Statement to generate
   */
  public final ConvertJSONToSQL removeStatementType() {
    properties.remove(STATEMENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * The name of the table that the statement should update
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the table that the statement should update
   */
  public final ConvertJSONToSQL setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the table that the statement should update
   */
  public final ConvertJSONToSQL removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final String getCatalogName() {
    return properties.get(CATALOG_NAME_PROPERTY);
  }

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final ConvertJSONToSQL setCatalogName(final String catalogName) {
    properties.put(CATALOG_NAME_PROPERTY, catalogName);
    return this;
  }

  /**
   * The name of the catalog that the statement should update. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final ConvertJSONToSQL removeCatalogName() {
    properties.remove(CATALOG_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final String getSchemaName() {
    return properties.get(SCHEMA_NAME_PROPERTY);
  }

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final ConvertJSONToSQL setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * The name of the schema that the table belongs to. This may not apply for the database that you are updating. In this case, leave the field empty
   */
  public final ConvertJSONToSQL removeSchemaName() {
    properties.remove(SCHEMA_NAME_PROPERTY);
    return this;
  }

  /**
   * If true, the Processor will attempt to translate JSON field names into the appropriate column names for the table specified. If false, the JSON field names must match the column names exactly, or the column will not be updated
   */
  public final String getTranslateFieldNames() {
    return properties.get(TRANSLATE_FIELD_NAMES_PROPERTY);
  }

  /**
   * If true, the Processor will attempt to translate JSON field names into the appropriate column names for the table specified. If false, the JSON field names must match the column names exactly, or the column will not be updated
   */
  public final ConvertJSONToSQL setTranslateFieldNames(final String translateFieldNames) {
    properties.put(TRANSLATE_FIELD_NAMES_PROPERTY, translateFieldNames);
    return this;
  }

  /**
   * If true, the Processor will attempt to translate JSON field names into the appropriate column names for the table specified. If false, the JSON field names must match the column names exactly, or the column will not be updated
   */
  public final ConvertJSONToSQL removeTranslateFieldNames() {
    properties.remove(TRANSLATE_FIELD_NAMES_PROPERTY);
    return this;
  }

  /**
   * If an incoming JSON element has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public final String getUnmatchedFieldBehavior() {
    return properties.get(UNMATCHED_FIELD_BEHAVIOR_PROPERTY);
  }

  /**
   * If an incoming JSON element has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public final ConvertJSONToSQL setUnmatchedFieldBehavior(final String unmatchedFieldBehavior) {
    properties.put(UNMATCHED_FIELD_BEHAVIOR_PROPERTY, unmatchedFieldBehavior);
    return this;
  }

  /**
   * If an incoming JSON element has a field that does not map to any of the database table's columns, this property specifies how to handle the situation
   */
  public final ConvertJSONToSQL removeUnmatchedFieldBehavior() {
    properties.remove(UNMATCHED_FIELD_BEHAVIOR_PROPERTY);
    return this;
  }

  /**
   * If an incoming JSON element does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public final String getUnmatchedColumnBehavior() {
    return properties.get(UNMATCHED_COLUMN_BEHAVIOR_PROPERTY);
  }

  /**
   * If an incoming JSON element does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public final ConvertJSONToSQL setUnmatchedColumnBehavior(final String unmatchedColumnBehavior) {
    properties.put(UNMATCHED_COLUMN_BEHAVIOR_PROPERTY, unmatchedColumnBehavior);
    return this;
  }

  /**
   * If an incoming JSON element does not have a field mapping for all of the database table's columns, this property specifies how to handle the situation
   */
  public final ConvertJSONToSQL removeUnmatchedColumnBehavior() {
    properties.remove(UNMATCHED_COLUMN_BEHAVIOR_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public final String getUpdateKeys() {
    return properties.get(UPDATE_KEYS_PROPERTY);
  }

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public final ConvertJSONToSQL setUpdateKeys(final String updateKeys) {
    properties.put(UPDATE_KEYS_PROPERTY, updateKeys);
    return this;
  }

  /**
   * A comma-separated list of column names that uniquely identifies a row in the database for UPDATE statements. If the Statement Type is UPDATE and this property is not set, the table's Primary Keys are used. In this case, if no Primary Key exists, the conversion to SQL will fail if Unmatched Column Behaviour is set to FAIL. This property is ignored if the Statement Type is INSERT
   */
  public final ConvertJSONToSQL removeUpdateKeys() {
    properties.remove(UPDATE_KEYS_PROPERTY);
    return this;
  }

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public final String getJtsQuotedIdentifiers() {
    return properties.get(JTS_QUOTED_IDENTIFIERS_PROPERTY);
  }

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public final ConvertJSONToSQL setJtsQuotedIdentifiers(final String jtsQuotedIdentifiers) {
    properties.put(JTS_QUOTED_IDENTIFIERS_PROPERTY, jtsQuotedIdentifiers);
    return this;
  }

  /**
   * Enabling this option will cause all column names to be quoted, allowing you to use reserved words as column names in your tables.
   */
  public final ConvertJSONToSQL removeJtsQuotedIdentifiers() {
    properties.remove(JTS_QUOTED_IDENTIFIERS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertJSONToSQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertJSONToSQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConvertJSONToSQL, ConvertJSONToSQL> configurator) {
    return configurator.apply(new ConvertJSONToSQL()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertJSONToSQL.class) final Closure<ConvertJSONToSQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ConvertJSONToSQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ConvertJSONToSQL.class, com.tibtech.nifi.processors.standard.ConvertJSONToSQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertJSONToSQL, ConvertJSONToSQL> configurator) {
    return configurator.apply(new ConvertJSONToSQL(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertJSONToSQL.class) final Closure<ConvertJSONToSQL> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ConvertJSONToSQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ConvertJSONToSQL.class, com.tibtech.nifi.processors.standard.ConvertJSONToSQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
