package com.tibtech.nifi.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MongoDBLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.mongodb.MongoDBLookupService";

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public static final String MONGO_URI_PROPERTY = "mongo-uri";

  /**
   * The name of the database to use
   */
  public static final String MONGO_DB_NAME_PROPERTY = "mongo-db-name";

  /**
   * The name of the collection to use
   */
  public static final String MONGO_COLLECTION_NAME_PROPERTY = "mongo-collection-name";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl-context-service";

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public static final String SSL_CLIENT_AUTH_PROPERTY = "ssl-client-auth";

  /**
   * The field whose value will be returned when the lookup key(s) match a record. If not specified then the entire MongoDB result document minus the _id field will be returned as a record.
   */
  public static final String MONGO_LOOKUP_VALUE_FIELD_PROPERTY = "mongo-lookup-value-field";

  private final Map<String, String> properties;

  public MongoDBLookupService() {
    this.properties = new HashMap<>();
  }

  public MongoDBLookupService(final Map<String, String> properties) {
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
  public final MongoDBLookupService setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final MongoDBLookupService removeMongoUri() {
    properties.remove(MONGO_URI_PROPERTY);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final String getMongoDbName() {
    return properties.get(MONGO_DB_NAME_PROPERTY);
  }

  /**
   * The name of the database to use
   */
  public final MongoDBLookupService setMongoDbName(final String mongoDbName) {
    properties.put(MONGO_DB_NAME_PROPERTY, mongoDbName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final MongoDBLookupService removeMongoDbName() {
    properties.remove(MONGO_DB_NAME_PROPERTY);
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
  public final MongoDBLookupService setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final MongoDBLookupService removeMongoCollectionName() {
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
  public final MongoDBLookupService setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final MongoDBLookupService removeSslContextService() {
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
  public final MongoDBLookupService setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final MongoDBLookupService removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * The field whose value will be returned when the lookup key(s) match a record. If not specified then the entire MongoDB result document minus the _id field will be returned as a record.
   */
  public final String getMongoLookupValueField() {
    return properties.get(MONGO_LOOKUP_VALUE_FIELD_PROPERTY);
  }

  /**
   * The field whose value will be returned when the lookup key(s) match a record. If not specified then the entire MongoDB result document minus the _id field will be returned as a record.
   */
  public final MongoDBLookupService setMongoLookupValueField(final String mongoLookupValueField) {
    properties.put(MONGO_LOOKUP_VALUE_FIELD_PROPERTY, mongoLookupValueField);
    return this;
  }

  /**
   * The field whose value will be returned when the lookup key(s) match a record. If not specified then the entire MongoDB result document minus the _id field will be returned as a record.
   */
  public final MongoDBLookupService removeMongoLookupValueField() {
    properties.remove(MONGO_LOOKUP_VALUE_FIELD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MongoDBLookupService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MongoDBLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<MongoDBLookupService, MongoDBLookupService> configurator) {
    return configurator.apply(new MongoDBLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MongoDBLookupService.class) final Closure<MongoDBLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.mongodb.MongoDBLookupService> code = closure.rehydrate(c, com.tibtech.nifi.mongodb.MongoDBLookupService.class, com.tibtech.nifi.mongodb.MongoDBLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<MongoDBLookupService, MongoDBLookupService> configurator) {
    return configurator.apply(new MongoDBLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MongoDBLookupService.class) final Closure<MongoDBLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.mongodb.MongoDBLookupService> code = closure.rehydrate(c, com.tibtech.nifi.mongodb.MongoDBLookupService.class, com.tibtech.nifi.mongodb.MongoDBLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
