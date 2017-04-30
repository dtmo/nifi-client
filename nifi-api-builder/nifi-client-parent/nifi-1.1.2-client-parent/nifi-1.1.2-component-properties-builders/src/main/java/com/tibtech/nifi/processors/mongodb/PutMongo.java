package com.tibtech.nifi.processors.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutMongo {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.mongodb.PutMongo";

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public static final String MONGO_URI_PROPERTY = "Mongo URI";

  /**
   * The name of the database to use
   */
  public static final String MONGO_DATABASE_NAME_PROPERTY = "Mongo Database Name";

  /**
   * The name of the collection to use
   */
  public static final String MONGO_COLLECTION_NAME_PROPERTY = "Mongo Collection Name";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl-context-service";

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public static final String SSL_CLIENT_AUTH_PROPERTY = "ssl-client-auth";

  /**
   * Indicates whether the processor should insert or update content
   */
  public static final String MODE_PROPERTY = "Mode";

  /**
   * When true, inserts a document if no document matches the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public static final String UPSERT_PROPERTY = "Upsert";

  /**
   * Key name used to build the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public static final String UPDATE_QUERY_KEY_PROPERTY = "Update Query Key";

  /**
   * The write concern to use
   */
  public static final String WRITE_CONCERN_PROPERTY = "Write Concern";

  /**
   * The Character Set in which the data is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final String getMongoUri() {
    return properties.get(MONGO_URI_PROPERTY);
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final PutMongo setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final PutMongo removeMongoUri() {
    properties.remove(MONGO_URI_PROPERTY);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final String getMongoDatabaseName() {
    return properties.get(MONGO_DATABASE_NAME_PROPERTY);
  }

  /**
   * The name of the database to use
   */
  public final PutMongo setMongoDatabaseName(final String mongoDatabaseName) {
    properties.put(MONGO_DATABASE_NAME_PROPERTY, mongoDatabaseName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final PutMongo removeMongoDatabaseName() {
    properties.remove(MONGO_DATABASE_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final String getMongoCollectionName() {
    return properties.get(MONGO_COLLECTION_NAME_PROPERTY);
  }

  /**
   * The name of the collection to use
   */
  public final PutMongo setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final PutMongo removeMongoCollectionName() {
    properties.remove(MONGO_COLLECTION_NAME_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final PutMongo setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final PutMongo removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final String getSslClientAuth() {
    return properties.get(SSL_CLIENT_AUTH_PROPERTY);
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final PutMongo setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final PutMongo removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * Indicates whether the processor should insert or update content
   */
  public final String getMode() {
    return properties.get(MODE_PROPERTY);
  }

  /**
   * Indicates whether the processor should insert or update content
   */
  public final PutMongo setMode(final String mode) {
    properties.put(MODE_PROPERTY, mode);
    return this;
  }

  /**
   * Indicates whether the processor should insert or update content
   */
  public final PutMongo removeMode() {
    properties.remove(MODE_PROPERTY);
    return this;
  }

  /**
   * When true, inserts a document if no document matches the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public final String getUpsert() {
    return properties.get(UPSERT_PROPERTY);
  }

  /**
   * When true, inserts a document if no document matches the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public final PutMongo setUpsert(final String upsert) {
    properties.put(UPSERT_PROPERTY, upsert);
    return this;
  }

  /**
   * When true, inserts a document if no document matches the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public final PutMongo removeUpsert() {
    properties.remove(UPSERT_PROPERTY);
    return this;
  }

  /**
   * Key name used to build the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public final String getUpdateQueryKey() {
    return properties.get(UPDATE_QUERY_KEY_PROPERTY);
  }

  /**
   * Key name used to build the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public final PutMongo setUpdateQueryKey(final String updateQueryKey) {
    properties.put(UPDATE_QUERY_KEY_PROPERTY, updateQueryKey);
    return this;
  }

  /**
   * Key name used to build the update query criteria; this property is valid only when using update mode, otherwise it is ignored
   */
  public final PutMongo removeUpdateQueryKey() {
    properties.remove(UPDATE_QUERY_KEY_PROPERTY);
    return this;
  }

  /**
   * The write concern to use
   */
  public final String getWriteConcern() {
    return properties.get(WRITE_CONCERN_PROPERTY);
  }

  /**
   * The write concern to use
   */
  public final PutMongo setWriteConcern(final String writeConcern) {
    properties.put(WRITE_CONCERN_PROPERTY, writeConcern);
    return this;
  }

  /**
   * The write concern to use
   */
  public final PutMongo removeWriteConcern() {
    properties.remove(WRITE_CONCERN_PROPERTY);
    return this;
  }

  /**
   * The Character Set in which the data is encoded
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set in which the data is encoded
   */
  public final PutMongo setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the data is encoded
   */
  public final PutMongo removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutMongo setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutMongo removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutMongo, PutMongo> configurator) {
    return configurator.apply(new PutMongo()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutMongo.class) final Closure<PutMongo> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.PutMongo> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.PutMongo.class, com.tibtech.nifi.processors.mongodb.PutMongo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
