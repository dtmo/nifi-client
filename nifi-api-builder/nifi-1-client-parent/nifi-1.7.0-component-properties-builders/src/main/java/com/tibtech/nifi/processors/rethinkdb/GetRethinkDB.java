package com.tibtech.nifi.processors.rethinkdb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetRethinkDB {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.rethinkdb.GetRethinkDB";

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
   * A FlowFile attribute, or attribute expression used for determining RethinkDB key for the Flow File content
   */
  public static final String RETHINKDB_DOCUMENT_IDENTIFIER_PROPERTY = "rethinkdb-document-identifier";

  /**
   * Read mode used for consistency
   */
  public static final String RETHINKDB_READ_MODE_PROPERTY = "rethinkdb-read-mode";

  /**
   * Maximum size of documents allowed to be posted in one batch
   */
  public static final String RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY = "rethinkdb-max-document-size";

  private final Map<String, String> properties;

  public GetRethinkDB() {
    this.properties = new HashMap<>();
  }

  public GetRethinkDB(final Map<String, String> properties) {
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
  public final GetRethinkDB setRethinkdbDbname(final String rethinkdbDbname) {
    properties.put(RETHINKDB_DBNAME_PROPERTY, rethinkdbDbname);
    return this;
  }

  /**
   * RethinkDB database to connect to
   */
  public final GetRethinkDB removeRethinkdbDbname() {
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
  public final GetRethinkDB setRethinkdbHost(final String rethinkdbHost) {
    properties.put(RETHINKDB_HOST_PROPERTY, rethinkdbHost);
    return this;
  }

  /**
   * RethinkDB hostname
   */
  public final GetRethinkDB removeRethinkdbHost() {
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
  public final GetRethinkDB setRethinkdbPort(final String rethinkdbPort) {
    properties.put(RETHINKDB_PORT_PROPERTY, rethinkdbPort);
    return this;
  }

  /**
   * RethinkDB database port to connect to
   */
  public final GetRethinkDB removeRethinkdbPort() {
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
  public final GetRethinkDB setRethinkdbUsername(final String rethinkdbUsername) {
    properties.put(RETHINKDB_USERNAME_PROPERTY, rethinkdbUsername);
    return this;
  }

  /**
   * Username for accessing RethinkDB
   */
  public final GetRethinkDB removeRethinkdbUsername() {
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
  public final GetRethinkDB setRethinkdbPassword(final String rethinkdbPassword) {
    properties.put(RETHINKDB_PASSWORD_PROPERTY, rethinkdbPassword);
    return this;
  }

  /**
   * Password for user
   */
  public final GetRethinkDB removeRethinkdbPassword() {
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
  public final GetRethinkDB setRethinkdbTable(final String rethinkdbTable) {
    properties.put(RETHINKDB_TABLE_PROPERTY, rethinkdbTable);
    return this;
  }

  /**
   * RethinkDB table to connect to
   */
  public final GetRethinkDB removeRethinkdbTable() {
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
  public final GetRethinkDB setRethinkdbCharset(final String rethinkdbCharset) {
    properties.put(RETHINKDB_CHARSET_PROPERTY, rethinkdbCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final GetRethinkDB removeRethinkdbCharset() {
    properties.remove(RETHINKDB_CHARSET_PROPERTY);
    return this;
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining RethinkDB key for the Flow File content
   */
  public final String getRethinkdbDocumentIdentifier() {
    return properties.get(RETHINKDB_DOCUMENT_IDENTIFIER_PROPERTY);
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining RethinkDB key for the Flow File content
   */
  public final GetRethinkDB setRethinkdbDocumentIdentifier(
      final String rethinkdbDocumentIdentifier) {
    properties.put(RETHINKDB_DOCUMENT_IDENTIFIER_PROPERTY, rethinkdbDocumentIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining RethinkDB key for the Flow File content
   */
  public final GetRethinkDB removeRethinkdbDocumentIdentifier() {
    properties.remove(RETHINKDB_DOCUMENT_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * Read mode used for consistency
   */
  public final String getRethinkdbReadMode() {
    return properties.get(RETHINKDB_READ_MODE_PROPERTY);
  }

  /**
   * Read mode used for consistency
   */
  public final GetRethinkDB setRethinkdbReadMode(final String rethinkdbReadMode) {
    properties.put(RETHINKDB_READ_MODE_PROPERTY, rethinkdbReadMode);
    return this;
  }

  /**
   * Read mode used for consistency
   */
  public final GetRethinkDB removeRethinkdbReadMode() {
    properties.remove(RETHINKDB_READ_MODE_PROPERTY);
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
  public final GetRethinkDB setRethinkdbMaxDocumentSize(final String rethinkdbMaxDocumentSize) {
    properties.put(RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY, rethinkdbMaxDocumentSize);
    return this;
  }

  /**
   * Maximum size of documents allowed to be posted in one batch
   */
  public final GetRethinkDB removeRethinkdbMaxDocumentSize() {
    properties.remove(RETHINKDB_MAX_DOCUMENT_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetRethinkDB setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetRethinkDB removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetRethinkDB, GetRethinkDB> configurator) {
    return configurator.apply(new GetRethinkDB()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetRethinkDB.class) final Closure<GetRethinkDB> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.rethinkdb.GetRethinkDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.rethinkdb.GetRethinkDB.class, com.tibtech.nifi.processors.rethinkdb.GetRethinkDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetRethinkDB, GetRethinkDB> configurator) {
    return configurator.apply(new GetRethinkDB(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetRethinkDB.class) final Closure<GetRethinkDB> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.rethinkdb.GetRethinkDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.rethinkdb.GetRethinkDB.class, com.tibtech.nifi.processors.rethinkdb.GetRethinkDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
