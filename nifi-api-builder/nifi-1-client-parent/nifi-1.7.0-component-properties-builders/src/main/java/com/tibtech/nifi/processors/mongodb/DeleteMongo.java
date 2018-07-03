package com.tibtech.nifi.processors.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteMongo {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.mongodb.DeleteMongo";

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
   * Choose between deleting one document by query or many documents by query.
   */
  public static final String DELETE_MONGO_DELETE_MODE_PROPERTY = "delete-mongo-delete-mode";

  /**
   * Determines whether to send the flowfile to the success or failure relationship if nothing is successfully deleted.
   */
  public static final String DELETE_MONGO_FAIL_ON_NO_DELETE_PROPERTY = "delete-mongo-fail-on-no-delete";

  /**
   * The write concern to use
   */
  public static final String WRITE_CONCERN_PROPERTY = "Write Concern";

  private final Map<String, String> properties;

  public DeleteMongo() {
    this.properties = new HashMap<>();
  }

  public DeleteMongo(final Map<String, String> properties) {
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
  public final DeleteMongo setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final DeleteMongo removeMongoUri() {
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
  public final DeleteMongo setMongoDatabaseName(final String mongoDatabaseName) {
    properties.put(MONGO_DATABASE_NAME_PROPERTY, mongoDatabaseName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final DeleteMongo removeMongoDatabaseName() {
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
  public final DeleteMongo setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final DeleteMongo removeMongoCollectionName() {
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
  public final DeleteMongo setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final DeleteMongo removeSslContextService() {
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
  public final DeleteMongo setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final DeleteMongo removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * Choose between deleting one document by query or many documents by query.
   */
  public final String getDeleteMongoDeleteMode() {
    return properties.get(DELETE_MONGO_DELETE_MODE_PROPERTY);
  }

  /**
   * Choose between deleting one document by query or many documents by query.
   */
  public final DeleteMongo setDeleteMongoDeleteMode(final String deleteMongoDeleteMode) {
    properties.put(DELETE_MONGO_DELETE_MODE_PROPERTY, deleteMongoDeleteMode);
    return this;
  }

  /**
   * Choose between deleting one document by query or many documents by query.
   */
  public final DeleteMongo removeDeleteMongoDeleteMode() {
    properties.remove(DELETE_MONGO_DELETE_MODE_PROPERTY);
    return this;
  }

  /**
   * Determines whether to send the flowfile to the success or failure relationship if nothing is successfully deleted.
   */
  public final String getDeleteMongoFailOnNoDelete() {
    return properties.get(DELETE_MONGO_FAIL_ON_NO_DELETE_PROPERTY);
  }

  /**
   * Determines whether to send the flowfile to the success or failure relationship if nothing is successfully deleted.
   */
  public final DeleteMongo setDeleteMongoFailOnNoDelete(final String deleteMongoFailOnNoDelete) {
    properties.put(DELETE_MONGO_FAIL_ON_NO_DELETE_PROPERTY, deleteMongoFailOnNoDelete);
    return this;
  }

  /**
   * Determines whether to send the flowfile to the success or failure relationship if nothing is successfully deleted.
   */
  public final DeleteMongo removeDeleteMongoFailOnNoDelete() {
    properties.remove(DELETE_MONGO_FAIL_ON_NO_DELETE_PROPERTY);
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
  public final DeleteMongo setWriteConcern(final String writeConcern) {
    properties.put(WRITE_CONCERN_PROPERTY, writeConcern);
    return this;
  }

  /**
   * The write concern to use
   */
  public final DeleteMongo removeWriteConcern() {
    properties.remove(WRITE_CONCERN_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteMongo setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteMongo removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DeleteMongo, DeleteMongo> configurator) {
    return configurator.apply(new DeleteMongo()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteMongo.class) final Closure<DeleteMongo> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.DeleteMongo> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.DeleteMongo.class, com.tibtech.nifi.processors.mongodb.DeleteMongo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteMongo, DeleteMongo> configurator) {
    return configurator.apply(new DeleteMongo(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteMongo.class) final Closure<DeleteMongo> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.DeleteMongo> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.DeleteMongo.class, com.tibtech.nifi.processors.mongodb.DeleteMongo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
