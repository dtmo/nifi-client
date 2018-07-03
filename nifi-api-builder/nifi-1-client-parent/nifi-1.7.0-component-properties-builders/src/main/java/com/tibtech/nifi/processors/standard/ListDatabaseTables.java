package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListDatabaseTables {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListDatabaseTables";

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public static final String LIST_DB_TABLES_DB_CONNECTION_PROPERTY = "list-db-tables-db-connection";

  /**
   * The name of a catalog from which to list database tables. The name must match the catalog name as it is stored in the database. If the property is not set, the catalog name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a catalog will be listed.
   */
  public static final String LIST_DB_TABLES_CATALOG_PROPERTY = "list-db-tables-catalog";

  /**
   * A pattern for matching schemas in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the schema name as it is stored in the database. If the property is not set, the schema name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a schema will be listed.
   */
  public static final String LIST_DB_TABLES_SCHEMA_PATTERN_PROPERTY = "list-db-tables-schema-pattern";

  /**
   * A pattern for matching tables in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the table name as it is stored in the database. If the property is not set, all tables will be retrieved.
   */
  public static final String LIST_DB_TABLES_NAME_PATTERN_PROPERTY = "list-db-tables-name-pattern";

  /**
   * A comma-separated list of table types to include. For example, some databases support TABLE and VIEW types. If the property is not set, tables of all types will be returned.
   */
  public static final String LIST_DB_TABLES_TYPES_PROPERTY = "list-db-tables-types";

  /**
   * Whether to include the table's row count as a flow file attribute. This affects performance as a database query will be generated for each table in the retrieved list.
   */
  public static final String LIST_DB_INCLUDE_COUNT_PROPERTY = "list-db-include-count";

  /**
   * The amount of time to elapse before resetting the processor state, thereby causing all current tables to be listed. During this interval, the processor may continue to run, but tables that have already been listed will not be re-listed. However new/added tables will be listed as the processor runs. A value of zero means the state will never be automatically reset, the user must Clear State manually.
   */
  public static final String LIST_DB_REFRESH_INTERVAL_PROPERTY = "list-db-refresh-interval";

  private final Map<String, String> properties;

  public ListDatabaseTables() {
    this.properties = new HashMap<>();
  }

  public ListDatabaseTables(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public final String getListDbTablesDbConnection() {
    return properties.get(LIST_DB_TABLES_DB_CONNECTION_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public final ListDatabaseTables setListDbTablesDbConnection(
      final String listDbTablesDbConnection) {
    properties.put(LIST_DB_TABLES_DB_CONNECTION_PROPERTY, listDbTablesDbConnection);
    return this;
  }

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public final ListDatabaseTables removeListDbTablesDbConnection() {
    properties.remove(LIST_DB_TABLES_DB_CONNECTION_PROPERTY);
    return this;
  }

  /**
   * The name of a catalog from which to list database tables. The name must match the catalog name as it is stored in the database. If the property is not set, the catalog name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a catalog will be listed.
   */
  public final String getListDbTablesCatalog() {
    return properties.get(LIST_DB_TABLES_CATALOG_PROPERTY);
  }

  /**
   * The name of a catalog from which to list database tables. The name must match the catalog name as it is stored in the database. If the property is not set, the catalog name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a catalog will be listed.
   */
  public final ListDatabaseTables setListDbTablesCatalog(final String listDbTablesCatalog) {
    properties.put(LIST_DB_TABLES_CATALOG_PROPERTY, listDbTablesCatalog);
    return this;
  }

  /**
   * The name of a catalog from which to list database tables. The name must match the catalog name as it is stored in the database. If the property is not set, the catalog name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a catalog will be listed.
   */
  public final ListDatabaseTables removeListDbTablesCatalog() {
    properties.remove(LIST_DB_TABLES_CATALOG_PROPERTY);
    return this;
  }

  /**
   * A pattern for matching schemas in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the schema name as it is stored in the database. If the property is not set, the schema name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a schema will be listed.
   */
  public final String getListDbTablesSchemaPattern() {
    return properties.get(LIST_DB_TABLES_SCHEMA_PATTERN_PROPERTY);
  }

  /**
   * A pattern for matching schemas in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the schema name as it is stored in the database. If the property is not set, the schema name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a schema will be listed.
   */
  public final ListDatabaseTables setListDbTablesSchemaPattern(
      final String listDbTablesSchemaPattern) {
    properties.put(LIST_DB_TABLES_SCHEMA_PATTERN_PROPERTY, listDbTablesSchemaPattern);
    return this;
  }

  /**
   * A pattern for matching schemas in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the schema name as it is stored in the database. If the property is not set, the schema name will not be used to narrow the search for tables. If the property is set to an empty string, tables without a schema will be listed.
   */
  public final ListDatabaseTables removeListDbTablesSchemaPattern() {
    properties.remove(LIST_DB_TABLES_SCHEMA_PATTERN_PROPERTY);
    return this;
  }

  /**
   * A pattern for matching tables in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the table name as it is stored in the database. If the property is not set, all tables will be retrieved.
   */
  public final String getListDbTablesNamePattern() {
    return properties.get(LIST_DB_TABLES_NAME_PATTERN_PROPERTY);
  }

  /**
   * A pattern for matching tables in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the table name as it is stored in the database. If the property is not set, all tables will be retrieved.
   */
  public final ListDatabaseTables setListDbTablesNamePattern(final String listDbTablesNamePattern) {
    properties.put(LIST_DB_TABLES_NAME_PATTERN_PROPERTY, listDbTablesNamePattern);
    return this;
  }

  /**
   * A pattern for matching tables in the database. Within a pattern, "%" means match any substring of 0 or more characters, and "_" means match any one character. The pattern must match the table name as it is stored in the database. If the property is not set, all tables will be retrieved.
   */
  public final ListDatabaseTables removeListDbTablesNamePattern() {
    properties.remove(LIST_DB_TABLES_NAME_PATTERN_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of table types to include. For example, some databases support TABLE and VIEW types. If the property is not set, tables of all types will be returned.
   */
  public final String getListDbTablesTypes() {
    return properties.get(LIST_DB_TABLES_TYPES_PROPERTY);
  }

  /**
   * A comma-separated list of table types to include. For example, some databases support TABLE and VIEW types. If the property is not set, tables of all types will be returned.
   */
  public final ListDatabaseTables setListDbTablesTypes(final String listDbTablesTypes) {
    properties.put(LIST_DB_TABLES_TYPES_PROPERTY, listDbTablesTypes);
    return this;
  }

  /**
   * A comma-separated list of table types to include. For example, some databases support TABLE and VIEW types. If the property is not set, tables of all types will be returned.
   */
  public final ListDatabaseTables removeListDbTablesTypes() {
    properties.remove(LIST_DB_TABLES_TYPES_PROPERTY);
    return this;
  }

  /**
   * Whether to include the table's row count as a flow file attribute. This affects performance as a database query will be generated for each table in the retrieved list.
   */
  public final String getListDbIncludeCount() {
    return properties.get(LIST_DB_INCLUDE_COUNT_PROPERTY);
  }

  /**
   * Whether to include the table's row count as a flow file attribute. This affects performance as a database query will be generated for each table in the retrieved list.
   */
  public final ListDatabaseTables setListDbIncludeCount(final String listDbIncludeCount) {
    properties.put(LIST_DB_INCLUDE_COUNT_PROPERTY, listDbIncludeCount);
    return this;
  }

  /**
   * Whether to include the table's row count as a flow file attribute. This affects performance as a database query will be generated for each table in the retrieved list.
   */
  public final ListDatabaseTables removeListDbIncludeCount() {
    properties.remove(LIST_DB_INCLUDE_COUNT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to elapse before resetting the processor state, thereby causing all current tables to be listed. During this interval, the processor may continue to run, but tables that have already been listed will not be re-listed. However new/added tables will be listed as the processor runs. A value of zero means the state will never be automatically reset, the user must Clear State manually.
   */
  public final String getListDbRefreshInterval() {
    return properties.get(LIST_DB_REFRESH_INTERVAL_PROPERTY);
  }

  /**
   * The amount of time to elapse before resetting the processor state, thereby causing all current tables to be listed. During this interval, the processor may continue to run, but tables that have already been listed will not be re-listed. However new/added tables will be listed as the processor runs. A value of zero means the state will never be automatically reset, the user must Clear State manually.
   */
  public final ListDatabaseTables setListDbRefreshInterval(final String listDbRefreshInterval) {
    properties.put(LIST_DB_REFRESH_INTERVAL_PROPERTY, listDbRefreshInterval);
    return this;
  }

  /**
   * The amount of time to elapse before resetting the processor state, thereby causing all current tables to be listed. During this interval, the processor may continue to run, but tables that have already been listed will not be re-listed. However new/added tables will be listed as the processor runs. A value of zero means the state will never be automatically reset, the user must Clear State manually.
   */
  public final ListDatabaseTables removeListDbRefreshInterval() {
    properties.remove(LIST_DB_REFRESH_INTERVAL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListDatabaseTables setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListDatabaseTables removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListDatabaseTables, ListDatabaseTables> configurator) {
    return configurator.apply(new ListDatabaseTables()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListDatabaseTables.class) final Closure<ListDatabaseTables> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListDatabaseTables> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListDatabaseTables.class, com.tibtech.nifi.processors.standard.ListDatabaseTables.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListDatabaseTables, ListDatabaseTables> configurator) {
    return configurator.apply(new ListDatabaseTables(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListDatabaseTables.class) final Closure<ListDatabaseTables> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListDatabaseTables> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListDatabaseTables.class, com.tibtech.nifi.processors.standard.ListDatabaseTables.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
