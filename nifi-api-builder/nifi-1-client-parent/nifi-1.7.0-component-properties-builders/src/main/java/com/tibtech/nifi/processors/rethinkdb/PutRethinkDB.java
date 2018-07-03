package com.tibtech.nifi.processors.rethinkdb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutRethinkDB {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.rethinkdb.PutRethinkDB";

  /**
   * RethinkDB database to connect to
   */
  public static final String RETHINKDB_DBNAME_PROPERTY = "rethinkdb-dbname";

  /**
   * RethinkDB hostname
   */
  public static final String RETHINKDB_HOST_PROPERTY = "rethinkdb-host";

  /**
   * RethinkDB database port to connect to
   */
  public static final String RETHINKDB_PORT_PROPERTY = "rethinkdb-port";

  /**
   * Username for accessing RethinkDB
   */
  public static final String RETHINKDB_USERNAME_PROPERTY = "rethinkdb-username";

  /**
   * Password for user
   */
  public static final String RETHINKDB_PASSWORD_PROPERTY = "rethinkdb-password";

  /**
   * RethinkDB table to connect to
   */
  public static final String RETHINKDB_TABLE_PROPERTY = "rethinkdb-table";

  /**
   * Specifies the character set of the document data.
   */
  public static final String RETHINKDB_CHARSET_PROPERTY = "rethinkdb-charset";

  /**
   * Conflict strategy to be used in case of inserting existing document.
   */
  public static final String RETHINKDB_CONFLICT_STRATEGY_PROPERTY = "rethinkdb-conflict-strategy";

  /**
   * Durability of documents being inserted
   */
  public static final String RETHINKDB_DURABILITY_PROPERTY = "rethinkdb-durability";

  /**
   * Maximum size of documents allowed to be posted in one batch
   */
  public static final String RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY = "rethinkdb-max-document-size";

  private final Map<String, String> properties;

  public PutRethinkDB() {
    this.properties = new HashMap<>();
  }

  public PutRethinkDB(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * RethinkDB database to connect to
   */
  public final String getRethinkdbDbname() {
    return properties.get(RETHINKDB_DBNAME_PROPERTY);
  }

  /**
   * RethinkDB database to connect to
   */
  public final PutRethinkDB setRethinkdbDbname(final String rethinkdbDbname) {
    properties.put(RETHINKDB_DBNAME_PROPERTY, rethinkdbDbname);
    return this;
  }

  /**
   * RethinkDB database to connect to
   */
  public final PutRethinkDB removeRethinkdbDbname() {
    properties.remove(RETHINKDB_DBNAME_PROPERTY);
    return this;
  }

  /**
   * RethinkDB hostname
   */
  public final String getRethinkdbHost() {
    return properties.get(RETHINKDB_HOST_PROPERTY);
  }

  /**
   * RethinkDB hostname
   */
  public final PutRethinkDB setRethinkdbHost(final String rethinkdbHost) {
    properties.put(RETHINKDB_HOST_PROPERTY, rethinkdbHost);
    return this;
  }

  /**
   * RethinkDB hostname
   */
  public final PutRethinkDB removeRethinkdbHost() {
    properties.remove(RETHINKDB_HOST_PROPERTY);
    return this;
  }

  /**
   * RethinkDB database port to connect to
   */
  public final String getRethinkdbPort() {
    return properties.get(RETHINKDB_PORT_PROPERTY);
  }

  /**
   * RethinkDB database port to connect to
   */
  public final PutRethinkDB setRethinkdbPort(final String rethinkdbPort) {
    properties.put(RETHINKDB_PORT_PROPERTY, rethinkdbPort);
    return this;
  }

  /**
   * RethinkDB database port to connect to
   */
  public final PutRethinkDB removeRethinkdbPort() {
    properties.remove(RETHINKDB_PORT_PROPERTY);
    return this;
  }

  /**
   * Username for accessing RethinkDB
   */
  public final String getRethinkdbUsername() {
    return properties.get(RETHINKDB_USERNAME_PROPERTY);
  }

  /**
   * Username for accessing RethinkDB
   */
  public final PutRethinkDB setRethinkdbUsername(final String rethinkdbUsername) {
    properties.put(RETHINKDB_USERNAME_PROPERTY, rethinkdbUsername);
    return this;
  }

  /**
   * Username for accessing RethinkDB
   */
  public final PutRethinkDB removeRethinkdbUsername() {
    properties.remove(RETHINKDB_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password for user
   */
  public final String getRethinkdbPassword() {
    return properties.get(RETHINKDB_PASSWORD_PROPERTY);
  }

  /**
   * Password for user
   */
  public final PutRethinkDB setRethinkdbPassword(final String rethinkdbPassword) {
    properties.put(RETHINKDB_PASSWORD_PROPERTY, rethinkdbPassword);
    return this;
  }

  /**
   * Password for user
   */
  public final PutRethinkDB removeRethinkdbPassword() {
    properties.remove(RETHINKDB_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * RethinkDB table to connect to
   */
  public final String getRethinkdbTable() {
    return properties.get(RETHINKDB_TABLE_PROPERTY);
  }

  /**
   * RethinkDB table to connect to
   */
  public final PutRethinkDB setRethinkdbTable(final String rethinkdbTable) {
    properties.put(RETHINKDB_TABLE_PROPERTY, rethinkdbTable);
    return this;
  }

  /**
   * RethinkDB table to connect to
   */
  public final PutRethinkDB removeRethinkdbTable() {
    properties.remove(RETHINKDB_TABLE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final String getRethinkdbCharset() {
    return properties.get(RETHINKDB_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the document data.
   */
  public final PutRethinkDB setRethinkdbCharset(final String rethinkdbCharset) {
    properties.put(RETHINKDB_CHARSET_PROPERTY, rethinkdbCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final PutRethinkDB removeRethinkdbCharset() {
    properties.remove(RETHINKDB_CHARSET_PROPERTY);
    return this;
  }

  /**
   * Conflict strategy to be used in case of inserting existing document.
   */
  public final String getRethinkdbConflictStrategy() {
    return properties.get(RETHINKDB_CONFLICT_STRATEGY_PROPERTY);
  }

  /**
   * Conflict strategy to be used in case of inserting existing document.
   */
  public final PutRethinkDB setRethinkdbConflictStrategy(final String rethinkdbConflictStrategy) {
    properties.put(RETHINKDB_CONFLICT_STRATEGY_PROPERTY, rethinkdbConflictStrategy);
    return this;
  }

  /**
   * Conflict strategy to be used in case of inserting existing document.
   */
  public final PutRethinkDB removeRethinkdbConflictStrategy() {
    properties.remove(RETHINKDB_CONFLICT_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Durability of documents being inserted
   */
  public final String getRethinkdbDurability() {
    return properties.get(RETHINKDB_DURABILITY_PROPERTY);
  }

  /**
   * Durability of documents being inserted
   */
  public final PutRethinkDB setRethinkdbDurability(final String rethinkdbDurability) {
    properties.put(RETHINKDB_DURABILITY_PROPERTY, rethinkdbDurability);
    return this;
  }

  /**
   * Durability of documents being inserted
   */
  public final PutRethinkDB removeRethinkdbDurability() {
    properties.remove(RETHINKDB_DURABILITY_PROPERTY);
    return this;
  }

  /**
   * Maximum size of documents allowed to be posted in one batch
   */
  public final String getRethinkdbMaxDocumentSize() {
    return properties.get(RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY);
  }

  /**
   * Maximum size of documents allowed to be posted in one batch
   */
  public final PutRethinkDB setRethinkdbMaxDocumentSize(final String rethinkdbMaxDocumentSize) {
    properties.put(RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY, rethinkdbMaxDocumentSize);
    return this;
  }

  /**
   * Maximum size of documents allowed to be posted in one batch
   */
  public final PutRethinkDB removeRethinkdbMaxDocumentSize() {
    properties.remove(RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutRethinkDB setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutRethinkDB removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutRethinkDB, PutRethinkDB> configurator) {
    return configurator.apply(new PutRethinkDB()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutRethinkDB.class) final Closure<PutRethinkDB> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.rethinkdb.PutRethinkDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.rethinkdb.PutRethinkDB.class, com.tibtech.nifi.processors.rethinkdb.PutRethinkDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutRethinkDB, PutRethinkDB> configurator) {
    return configurator.apply(new PutRethinkDB(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutRethinkDB.class) final Closure<PutRethinkDB> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.rethinkdb.PutRethinkDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.rethinkdb.PutRethinkDB.class, com.tibtech.nifi.processors.rethinkdb.PutRethinkDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
