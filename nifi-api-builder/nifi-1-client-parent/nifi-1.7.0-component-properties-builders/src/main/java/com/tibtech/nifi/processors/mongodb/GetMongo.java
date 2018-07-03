package com.tibtech.nifi.processors.mongodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetMongo {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.mongodb.GetMongo";

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
   * By default, MongoDB's Java driver returns "extended JSON". Some of the features of this variant of JSON may cause problems for other JSON parsers that expect only standard JSON types and conventions. This configuration setting  controls whether to use extended JSON or provide a clean view that conforms to standard JSON.
   */
  public static final String JSON_TYPE_PROPERTY = "json-type";

  /**
   * Choose whether or not to pretty print the JSON from the results of the query. Choosing yes can greatly increase the space requirements on disk depending on the complexity of the JSON document
   */
  public static final String USE_PRETTY_PRINTING_PROPERTY = "use-pretty-printing";

  /**
   * Specifies the character set of the document data.
   */
  public static final String MONGO_CHARSET_PROPERTY = "mongo-charset";

  /**
   * The selection criteria to do the lookup. If the field is left blank, it will look for input from an incoming connection from another processor to provide the query as a valid JSON document inside of the flowfile's body. If this field is left blank and a timer is enabled instead of an incoming connection, that will result in a full collection fetch using a "{}" query.
   */
  public static final String QUERY_PROPERTY = "Query";

  /**
   * If set, the query will be written to a specified attribute on the output flowfiles.
   */
  public static final String MONGO_QUERY_ATTRIBUTE_PROPERTY = "mongo-query-attribute";

  /**
   * The fields to be returned from the documents in the result set; must be a valid BSON document
   */
  public static final String PROJECTION_PROPERTY = "Projection";

  /**
   * The fields by which to sort; must be a valid BSON document
   */
  public static final String SORT_PROPERTY = "Sort";

  /**
   * The maximum number of elements to return
   */
  public static final String LIMIT_PROPERTY = "Limit";

  /**
   * The number of elements returned from the server in one batch
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * How many results to put into a flowfile at once. The whole body will be treated as a JSON array of results.
   */
  public static final String RESULTS_PER_FLOWFILE_PROPERTY = "results-per-flowfile";

  private final Map<String, String> properties;

  public GetMongo() {
    this.properties = new HashMap<>();
  }

  public GetMongo(final Map<String, String> properties) {
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
  public final GetMongo setMongoUri(final String mongoUri) {
    properties.put(MONGO_URI_PROPERTY, mongoUri);
    return this;
  }

  /**
   * MongoURI, typically of the form: mongodb://host1[:port1][,host2[:port2],...]
   */
  public final GetMongo removeMongoUri() {
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
  public final GetMongo setMongoDatabaseName(final String mongoDatabaseName) {
    properties.put(MONGO_DATABASE_NAME_PROPERTY, mongoDatabaseName);
    return this;
  }

  /**
   * The name of the database to use
   */
  public final GetMongo removeMongoDatabaseName() {
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
  public final GetMongo setMongoCollectionName(final String mongoCollectionName) {
    properties.put(MONGO_COLLECTION_NAME_PROPERTY, mongoCollectionName);
    return this;
  }

  /**
   * The name of the collection to use
   */
  public final GetMongo removeMongoCollectionName() {
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
  public final GetMongo setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final GetMongo removeSslContextService() {
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
  public final GetMongo setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final GetMongo removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
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
  public final GetMongo setJsonType(final String jsonType) {
    properties.put(JSON_TYPE_PROPERTY, jsonType);
    return this;
  }

  /**
   * By default, MongoDB's Java driver returns "extended JSON". Some of the features of this variant of JSON may cause problems for other JSON parsers that expect only standard JSON types and conventions. This configuration setting  controls whether to use extended JSON or provide a clean view that conforms to standard JSON.
   */
  public final GetMongo removeJsonType() {
    properties.remove(JSON_TYPE_PROPERTY);
    return this;
  }

  /**
   * Choose whether or not to pretty print the JSON from the results of the query. Choosing yes can greatly increase the space requirements on disk depending on the complexity of the JSON document
   */
  public final String getUsePrettyPrinting() {
    return properties.get(USE_PRETTY_PRINTING_PROPERTY);
  }

  /**
   * Choose whether or not to pretty print the JSON from the results of the query. Choosing yes can greatly increase the space requirements on disk depending on the complexity of the JSON document
   */
  public final GetMongo setUsePrettyPrinting(final String usePrettyPrinting) {
    properties.put(USE_PRETTY_PRINTING_PROPERTY, usePrettyPrinting);
    return this;
  }

  /**
   * Choose whether or not to pretty print the JSON from the results of the query. Choosing yes can greatly increase the space requirements on disk depending on the complexity of the JSON document
   */
  public final GetMongo removeUsePrettyPrinting() {
    properties.remove(USE_PRETTY_PRINTING_PROPERTY);
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
  public final GetMongo setMongoCharset(final String mongoCharset) {
    properties.put(MONGO_CHARSET_PROPERTY, mongoCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final GetMongo removeMongoCharset() {
    properties.remove(MONGO_CHARSET_PROPERTY);
    return this;
  }

  /**
   * The selection criteria to do the lookup. If the field is left blank, it will look for input from an incoming connection from another processor to provide the query as a valid JSON document inside of the flowfile's body. If this field is left blank and a timer is enabled instead of an incoming connection, that will result in a full collection fetch using a "{}" query.
   */
  public final String getQuery() {
    return properties.get(QUERY_PROPERTY);
  }

  /**
   * The selection criteria to do the lookup. If the field is left blank, it will look for input from an incoming connection from another processor to provide the query as a valid JSON document inside of the flowfile's body. If this field is left blank and a timer is enabled instead of an incoming connection, that will result in a full collection fetch using a "{}" query.
   */
  public final GetMongo setQuery(final String query) {
    properties.put(QUERY_PROPERTY, query);
    return this;
  }

  /**
   * The selection criteria to do the lookup. If the field is left blank, it will look for input from an incoming connection from another processor to provide the query as a valid JSON document inside of the flowfile's body. If this field is left blank and a timer is enabled instead of an incoming connection, that will result in a full collection fetch using a "{}" query.
   */
  public final GetMongo removeQuery() {
    properties.remove(QUERY_PROPERTY);
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
  public final GetMongo setMongoQueryAttribute(final String mongoQueryAttribute) {
    properties.put(MONGO_QUERY_ATTRIBUTE_PROPERTY, mongoQueryAttribute);
    return this;
  }

  /**
   * If set, the query will be written to a specified attribute on the output flowfiles.
   */
  public final GetMongo removeMongoQueryAttribute() {
    properties.remove(MONGO_QUERY_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The fields to be returned from the documents in the result set; must be a valid BSON document
   */
  public final String getProjection() {
    return properties.get(PROJECTION_PROPERTY);
  }

  /**
   * The fields to be returned from the documents in the result set; must be a valid BSON document
   */
  public final GetMongo setProjection(final String projection) {
    properties.put(PROJECTION_PROPERTY, projection);
    return this;
  }

  /**
   * The fields to be returned from the documents in the result set; must be a valid BSON document
   */
  public final GetMongo removeProjection() {
    properties.remove(PROJECTION_PROPERTY);
    return this;
  }

  /**
   * The fields by which to sort; must be a valid BSON document
   */
  public final String getSort() {
    return properties.get(SORT_PROPERTY);
  }

  /**
   * The fields by which to sort; must be a valid BSON document
   */
  public final GetMongo setSort(final String sort) {
    properties.put(SORT_PROPERTY, sort);
    return this;
  }

  /**
   * The fields by which to sort; must be a valid BSON document
   */
  public final GetMongo removeSort() {
    properties.remove(SORT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of elements to return
   */
  public final String getLimit() {
    return properties.get(LIMIT_PROPERTY);
  }

  /**
   * The maximum number of elements to return
   */
  public final GetMongo setLimit(final String limit) {
    properties.put(LIMIT_PROPERTY, limit);
    return this;
  }

  /**
   * The maximum number of elements to return
   */
  public final GetMongo removeLimit() {
    properties.remove(LIMIT_PROPERTY);
    return this;
  }

  /**
   * The number of elements returned from the server in one batch
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of elements returned from the server in one batch
   */
  public final GetMongo setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of elements returned from the server in one batch
   */
  public final GetMongo removeBatchSize() {
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
  public final GetMongo setResultsPerFlowfile(final String resultsPerFlowfile) {
    properties.put(RESULTS_PER_FLOWFILE_PROPERTY, resultsPerFlowfile);
    return this;
  }

  /**
   * How many results to put into a flowfile at once. The whole body will be treated as a JSON array of results.
   */
  public final GetMongo removeResultsPerFlowfile() {
    properties.remove(RESULTS_PER_FLOWFILE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetMongo setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetMongo removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetMongo, GetMongo> configurator) {
    return configurator.apply(new GetMongo()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetMongo.class) final Closure<GetMongo> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.GetMongo> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.GetMongo.class, com.tibtech.nifi.processors.mongodb.GetMongo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetMongo, GetMongo> configurator) {
    return configurator.apply(new GetMongo(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetMongo.class) final Closure<GetMongo> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.mongodb.GetMongo> code = closure.rehydrate(c, com.tibtech.nifi.processors.mongodb.GetMongo.class, com.tibtech.nifi.processors.mongodb.GetMongo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
