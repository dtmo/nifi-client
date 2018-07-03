package com.tibtech.nifi.processors.rethinkdb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteRethinkDB {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.rethinkdb.DeleteRethinkDB";

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
   * Return old value which were deleted
   */
  public static final String RETHINKDB_RETURN_RESULT_PROPERTY = "rethinkdb-return-result";

  /**
   * Durability of documents being inserted
   */
  public static final String RETHINKDB_DURABILITY_PROPERTY = "rethinkdb-durability";

  private final Map<String, String> properties;

  public DeleteRethinkDB() {
    this.properties = new HashMap<>();
  }

  public DeleteRethinkDB(final Map<String, String> properties) {
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
  public final DeleteRethinkDB setRethinkdbDbname(final String rethinkdbDbname) {
    properties.put(RETHINKDB_DBNAME_PROPERTY, rethinkdbDbname);
    return this;
  }

  /**
   * RethinkDB database to connect to
   */
  public final DeleteRethinkDB removeRethinkdbDbname() {
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
  public final DeleteRethinkDB setRethinkdbHost(final String rethinkdbHost) {
    properties.put(RETHINKDB_HOST_PROPERTY, rethinkdbHost);
    return this;
  }

  /**
   * RethinkDB hostname
   */
  public final DeleteRethinkDB removeRethinkdbHost() {
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
  public final DeleteRethinkDB setRethinkdbPort(final String rethinkdbPort) {
    properties.put(RETHINKDB_PORT_PROPERTY, rethinkdbPort);
    return this;
  }

  /**
   * RethinkDB database port to connect to
   */
  public final DeleteRethinkDB removeRethinkdbPort() {
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
  public final DeleteRethinkDB setRethinkdbUsername(final String rethinkdbUsername) {
    properties.put(RETHINKDB_USERNAME_PROPERTY, rethinkdbUsername);
    return this;
  }

  /**
   * Username for accessing RethinkDB
   */
  public final DeleteRethinkDB removeRethinkdbUsername() {
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
  public final DeleteRethinkDB setRethinkdbPassword(final String rethinkdbPassword) {
    properties.put(RETHINKDB_PASSWORD_PROPERTY, rethinkdbPassword);
    return this;
  }

  /**
   * Password for user
   */
  public final DeleteRethinkDB removeRethinkdbPassword() {
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
  public final DeleteRethinkDB setRethinkdbTable(final String rethinkdbTable) {
    properties.put(RETHINKDB_TABLE_PROPERTY, rethinkdbTable);
    return this;
  }

  /**
   * RethinkDB table to connect to
   */
  public final DeleteRethinkDB removeRethinkdbTable() {
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
  public final DeleteRethinkDB setRethinkdbCharset(final String rethinkdbCharset) {
    properties.put(RETHINKDB_CHARSET_PROPERTY, rethinkdbCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final DeleteRethinkDB removeRethinkdbCharset() {
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
  public final DeleteRethinkDB setRethinkdbDocumentIdentifier(
      final String rethinkdbDocumentIdentifier) {
    properties.put(RETHINKDB_DOCUMENT_IDENTIFIER_PROPERTY, rethinkdbDocumentIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining RethinkDB key for the Flow File content
   */
  public final DeleteRethinkDB removeRethinkdbDocumentIdentifier() {
    properties.remove(RETHINKDB_DOCUMENT_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * Return old value which were deleted
   */
  public final String getRethinkdbReturnResult() {
    return properties.get(RETHINKDB_RETURN_RESULT_PROPERTY);
  }

  /**
   * Return old value which were deleted
   */
  public final DeleteRethinkDB setRethinkdbReturnResult(final String rethinkdbReturnResult) {
    properties.put(RETHINKDB_RETURN_RESULT_PROPERTY, rethinkdbReturnResult);
    return this;
  }

  /**
   * Return old value which were deleted
   */
  public final DeleteRethinkDB removeRethinkdbReturnResult() {
    properties.remove(RETHINKDB_RETURN_RESULT_PROPERTY);
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
  public final DeleteRethinkDB setRethinkdbDurability(final String rethinkdbDurability) {
    properties.put(RETHINKDB_DURABILITY_PROPERTY, rethinkdbDurability);
    return this;
  }

  /**
   * Durability of documents being inserted
   */
  public final DeleteRethinkDB removeRethinkdbDurability() {
    properties.remove(RETHINKDB_DURABILITY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteRethinkDB setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteRethinkDB removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DeleteRethinkDB, DeleteRethinkDB> configurator) {
    return configurator.apply(new DeleteRethinkDB()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteRethinkDB.class) final Closure<DeleteRethinkDB> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.rethinkdb.DeleteRethinkDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.rethinkdb.DeleteRethinkDB.class, com.tibtech.nifi.processors.rethinkdb.DeleteRethinkDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteRethinkDB, DeleteRethinkDB> configurator) {
    return configurator.apply(new DeleteRethinkDB(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteRethinkDB.class) final Closure<DeleteRethinkDB> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.rethinkdb.DeleteRethinkDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.rethinkdb.DeleteRethinkDB.class, com.tibtech.nifi.processors.rethinkdb.DeleteRethinkDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
