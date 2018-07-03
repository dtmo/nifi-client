package com.tibtech.nifi.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MongoDBControllerService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.mongodb.MongoDBControllerService";

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

  private final Map<String, String> properties;

  public MongoDBControllerService() {
    this.properties = new HashMap<>();
  }

  public MongoDBControllerService(final Map<String, String> properties) {
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
  public final MongoDBControllerService setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final MongoDBControllerService removeMongoUri() {
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
  public final MongoDBControllerService setMongoDbName(final String mongoDbName) {
    properties.put(MONGO_DB_NAME_PROPERTY, mongoDbName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final MongoDBControllerService removeMongoDbName() {
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
  public final MongoDBControllerService setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final MongoDBControllerService removeMongoCollectionName() {
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
  public final MongoDBControllerService setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final MongoDBControllerService removeSslContextService() {
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
  public final MongoDBControllerService setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final MongoDBControllerService removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MongoDBControllerService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MongoDBControllerService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<MongoDBControllerService, MongoDBControllerService> configurator) {
    return configurator.apply(new MongoDBControllerService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MongoDBControllerService.class) final Closure<MongoDBControllerService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.mongodb.MongoDBControllerService> code = closure.rehydrate(c, com.tibtech.nifi.mongodb.MongoDBControllerService.class, com.tibtech.nifi.mongodb.MongoDBControllerService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<MongoDBControllerService, MongoDBControllerService> configurator) {
    return configurator.apply(new MongoDBControllerService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MongoDBControllerService.class) final Closure<MongoDBControllerService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.mongodb.MongoDBControllerService> code = closure.rehydrate(c, com.tibtech.nifi.mongodb.MongoDBControllerService.class, com.tibtech.nifi.mongodb.MongoDBControllerService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
