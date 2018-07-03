package com.tibtech.nifi.processors.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutMongoRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.mongodb.PutMongoRecord";

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
   * The write concern to use
   */
  public static final String WRITE_CONCERN_PROPERTY = "Write Concern";

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * The number of records to group together for one single insert operation against MongoDB.
   */
  public static final String INSERT_COUNT_PROPERTY = "insert_count";

  private final Map<String, String> properties;

  public PutMongoRecord() {
    this.properties = new HashMap<>();
  }

  public PutMongoRecord(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final String getMongoUri() {
    return properties.get(MONGO_URI_PROPERTY);
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final PutMongoRecord setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final PutMongoRecord removeMongoUri() {
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
  public final PutMongoRecord setMongoDatabaseName(final String mongoDatabaseName) {
    properties.put(MONGO_DATABASE_NAME_PROPERTY, mongoDatabaseName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final PutMongoRecord removeMongoDatabaseName() {
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
  public final PutMongoRecord setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final PutMongoRecord removeMongoCollectionName() {
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
  public final PutMongoRecord setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final PutMongoRecord removeSslContextService() {
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
  public final PutMongoRecord setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final PutMongoRecord removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
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
  public final PutMongoRecord setWriteConcern(final String writeConcern) {
    properties.put(WRITE_CONCERN_PROPERTY, writeConcern);
    return this;
  }

  /**
   * The write concern to use
   */
  public final PutMongoRecord removeWriteConcern() {
    properties.remove(WRITE_CONCERN_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final PutMongoRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final PutMongoRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * The number of records to group together for one single insert operation against MongoDB.
   */
  public final String getInsertCount() {
    return properties.get(INSERT_COUNT_PROPERTY);
  }

  /**
   * The number of records to group together for one single insert operation against MongoDB.
   */
  public final PutMongoRecord setInsertCount(final String insertCount) {
    properties.put(INSERT_COUNT_PROPERTY, insertCount);
    return this;
  }

  /**
   * The number of records to group together for one single insert operation against MongoDB.
   */
  public final PutMongoRecord removeInsertCount() {
    properties.remove(INSERT_COUNT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutMongoRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutMongoRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutMongoRecord, PutMongoRecord> configurator) {
    return configurator.apply(new PutMongoRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutMongoRecord.class) final Closure<PutMongoRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.PutMongoRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.PutMongoRecord.class, com.tibtech.nifi.processors.mongodb.PutMongoRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutMongoRecord, PutMongoRecord> configurator) {
    return configurator.apply(new PutMongoRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutMongoRecord.class) final Closure<PutMongoRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.PutMongoRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.PutMongoRecord.class, com.tibtech.nifi.processors.mongodb.PutMongoRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
