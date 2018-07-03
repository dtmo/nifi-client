package com.tibtech.nifi.processors.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RunMongoAggregation {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.mongodb.RunMongoAggregation";

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
   * Specifies the character set of the document data.
   */
  public static final String MONGO_CHARSET_PROPERTY = "mongo-charset";

  /**
   * The aggregation query to be executed.
   */
  public static final String MONGO_AGG_QUERY_PROPERTY = "mongo-agg-query";

  /**
   * By default, MongoDB's Java driver returns "extended JSON". Some of the features of this variant of JSON may cause problems for other JSON parsers that expect only standard JSON types and conventions. This configuration setting  controls whether to use extended JSON or provide a clean view that conforms to standard JSON.
   */
  public static final String JSON_TYPE_PROPERTY = "json-type";

  /**
   * If set, the query will be written to a specified attribute on the output flowfiles.
   */
  public static final String MONGO_QUERY_ATTRIBUTE_PROPERTY = "mongo-query-attribute";

  /**
   * The number of elements returned from the server in one batch.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * How many results to put into a flowfile at once. The whole body will be treated as a JSON array of results.
   */
  public static final String RESULTS_PER_FLOWFILE_PROPERTY = "results-per-flowfile";

  private final Map<String, String> properties;

  public RunMongoAggregation() {
    this.properties = new HashMap<>();
  }

  public RunMongoAggregation(final Map<String, String> properties) {
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
  public final RunMongoAggregation setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final RunMongoAggregation removeMongoUri() {
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
  public final RunMongoAggregation setMongoDatabaseName(final String mongoDatabaseName) {
    properties.put(MONGO_DATABASE_NAME_PROPERTY, mongoDatabaseName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final RunMongoAggregation removeMongoDatabaseName() {
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
  public final RunMongoAggregation setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final RunMongoAggregation removeMongoCollectionName() {
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
  public final RunMongoAggregation setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final RunMongoAggregation removeSslContextService() {
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
  public final RunMongoAggregation setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final RunMongoAggregation removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final String getMongoCharset() {
    return properties.get(MONGO_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the document data.
   */
  public final RunMongoAggregation setMongoCharset(final String mongoCharset) {
    properties.put(MONGO_CHARSET_PROPERTY, mongoCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final RunMongoAggregation removeMongoCharset() {
    properties.remove(MONGO_CHARSET_PROPERTY);
    return this;
  }

  /**
   * The aggregation query to be executed.
   */
  public final String getMongoAggQuery() {
    return properties.get(MONGO_AGG_QUERY_PROPERTY);
  }

  /**
   * The aggregation query to be executed.
   */
  public final RunMongoAggregation setMongoAggQuery(final String mongoAggQuery) {
    properties.put(MONGO_AGG_QUERY_PROPERTY, mongoAggQuery);
    return this;
  }

  /**
   * The aggregation query to be executed.
   */
  public final RunMongoAggregation removeMongoAggQuery() {
    properties.remove(MONGO_AGG_QUERY_PROPERTY);
    return this;
  }

  /**
   * By default, MongoDB's Java driver returns "extended JSON". Some of the features of this variant of JSON may cause problems for other JSON parsers that expect only standard JSON types and conventions. This configuration setting  controls whether to use extended JSON or provide a clean view that conforms to standard JSON.
   */
  public final String getJsonType() {
    return properties.get(JSON_TYPE_PROPERTY);
  }

  /**
   * By default, MongoDB's Java driver returns "extended JSON". Some of the features of this variant of JSON may cause problems for other JSON parsers that expect only standard JSON types and conventions. This configuration setting  controls whether to use extended JSON or provide a clean view that conforms to standard JSON.
   */
  public final RunMongoAggregation setJsonType(final String jsonType) {
    properties.put(JSON_TYPE_PROPERTY, jsonType);
    return this;
  }

  /**
   * By default, MongoDB's Java driver returns "extended JSON". Some of the features of this variant of JSON may cause problems for other JSON parsers that expect only standard JSON types and conventions. This configuration setting  controls whether to use extended JSON or provide a clean view that conforms to standard JSON.
   */
  public final RunMongoAggregation removeJsonType() {
    properties.remove(JSON_TYPE_PROPERTY);
    return this;
  }

  /**
   * If set, the query will be written to a specified attribute on the output flowfiles.
   */
  public final String getMongoQueryAttribute() {
    return properties.get(MONGO_QUERY_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the query will be written to a specified attribute on the output flowfiles.
   */
  public final RunMongoAggregation setMongoQueryAttribute(final String mongoQueryAttribute) {
    properties.put(MONGO_QUERY_ATTRIBUTE_PROPERTY, mongoQueryAttribute);
    return this;
  }

  /**
   * If set, the query will be written to a specified attribute on the output flowfiles.
   */
  public final RunMongoAggregation removeMongoQueryAttribute() {
    properties.remove(MONGO_QUERY_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The number of elements returned from the server in one batch.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of elements returned from the server in one batch.
   */
  public final RunMongoAggregation setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of elements returned from the server in one batch.
   */
  public final RunMongoAggregation removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * How many results to put into a flowfile at once. The whole body will be treated as a JSON array of results.
   */
  public final String getResultsPerFlowfile() {
    return properties.get(RESULTS_PER_FLOWFILE_PROPERTY);
  }

  /**
   * How many results to put into a flowfile at once. The whole body will be treated as a JSON array of results.
   */
  public final RunMongoAggregation setResultsPerFlowfile(final String resultsPerFlowfile) {
    properties.put(RESULTS_PER_FLOWFILE_PROPERTY, resultsPerFlowfile);
    return this;
  }

  /**
   * How many results to put into a flowfile at once. The whole body will be treated as a JSON array of results.
   */
  public final RunMongoAggregation removeResultsPerFlowfile() {
    properties.remove(RESULTS_PER_FLOWFILE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RunMongoAggregation setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final RunMongoAggregation removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<RunMongoAggregation, RunMongoAggregation> configurator) {
    return configurator.apply(new RunMongoAggregation()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RunMongoAggregation.class) final Closure<RunMongoAggregation> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.RunMongoAggregation> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.RunMongoAggregation.class, com.tibtech.nifi.processors.mongodb.RunMongoAggregation.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<RunMongoAggregation, RunMongoAggregation> configurator) {
    return configurator.apply(new RunMongoAggregation(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RunMongoAggregation.class) final Closure<RunMongoAggregation> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.RunMongoAggregation> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.RunMongoAggregation.class, com.tibtech.nifi.processors.mongodb.RunMongoAggregation.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
