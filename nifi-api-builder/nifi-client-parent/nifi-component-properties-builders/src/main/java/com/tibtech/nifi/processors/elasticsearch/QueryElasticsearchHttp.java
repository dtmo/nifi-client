package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QueryElasticsearchHttp {
  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public static final String ELASTICSEARCH_HTTP_URL_PROPERTY = "elasticsearch-http-url";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Username to access the Elasticsearch cluster
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password to access the Elasticsearch cluster
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * Max wait time for the connection to the Elasticsearch REST API.
   */
  public static final String ELASTICSEARCH_HTTP_CONNECT_TIMEOUT_PROPERTY = "elasticsearch-http-connect-timeout";

  /**
   * Max wait time for a response from the Elasticsearch REST API.
   */
  public static final String ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY = "elasticsearch-http-response-timeout";

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public static final String QUERY_ES_QUERY_PROPERTY = "query-es-query";

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public static final String QUERY_ES_SIZE_PROPERTY = "query-es-size";

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public static final String QUERY_ES_INDEX_PROPERTY = "query-es-index";

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public static final String QUERY_ES_TYPE_PROPERTY = "query-es-type";

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public static final String QUERY_ES_FIELDS_PROPERTY = "query-es-fields";

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public static final String QUERY_ES_SORT_PROPERTY = "query-es-sort";

  /**
   * If set, limits the number of results that will be returned.
   */
  public static final String QUERY_ES_LIMIT_PROPERTY = "query-es-limit";

  /**
   * Indicates where the results should be placed.  In the case of 'Flow file content', the JSON response will be written as the content of the flow file.  In the case of 'Flow file attributes', the original flow file (if applicable) will be cloned for each result, and all return fields will be placed in a flow file attribute of the same name, but prefixed by 'es.result.'
   */
  public static final String QUERY_ES_TARGET_PROPERTY = "query-es-target";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final String getElasticsearchHttpUrl() {
    return properties.get(ELASTICSEARCH_HTTP_URL_PROPERTY);
  }

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final QueryElasticsearchHttp setElasticsearchHttpUrl(final String elasticsearchHttpUrl) {
    properties.put(ELASTICSEARCH_HTTP_URL_PROPERTY, elasticsearchHttpUrl);
    return this;
  }

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final QueryElasticsearchHttp removeElasticsearchHttpUrl() {
    properties.remove(ELASTICSEARCH_HTTP_URL_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final QueryElasticsearchHttp setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final QueryElasticsearchHttp removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final QueryElasticsearchHttp setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final QueryElasticsearchHttp removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final QueryElasticsearchHttp setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final QueryElasticsearchHttp removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Max wait time for the connection to the Elasticsearch REST API.
   */
  public final String getElasticsearchHttpConnectTimeout() {
    return properties.get(ELASTICSEARCH_HTTP_CONNECT_TIMEOUT_PROPERTY);
  }

  /**
   * Max wait time for the connection to the Elasticsearch REST API.
   */
  public final QueryElasticsearchHttp setElasticsearchHttpConnectTimeout(final String elasticsearchHttpConnectTimeout) {
    properties.put(ELASTICSEARCH_HTTP_CONNECT_TIMEOUT_PROPERTY, elasticsearchHttpConnectTimeout);
    return this;
  }

  /**
   * Max wait time for the connection to the Elasticsearch REST API.
   */
  public final QueryElasticsearchHttp removeElasticsearchHttpConnectTimeout() {
    properties.remove(ELASTICSEARCH_HTTP_CONNECT_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Max wait time for a response from the Elasticsearch REST API.
   */
  public final String getElasticsearchHttpResponseTimeout() {
    return properties.get(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY);
  }

  /**
   * Max wait time for a response from the Elasticsearch REST API.
   */
  public final QueryElasticsearchHttp setElasticsearchHttpResponseTimeout(final String elasticsearchHttpResponseTimeout) {
    properties.put(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY, elasticsearchHttpResponseTimeout);
    return this;
  }

  /**
   * Max wait time for a response from the Elasticsearch REST API.
   */
  public final QueryElasticsearchHttp removeElasticsearchHttpResponseTimeout() {
    properties.remove(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public final String getQueryEsQuery() {
    return properties.get(QUERY_ES_QUERY_PROPERTY);
  }

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public final QueryElasticsearchHttp setQueryEsQuery(final String queryEsQuery) {
    properties.put(QUERY_ES_QUERY_PROPERTY, queryEsQuery);
    return this;
  }

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public final QueryElasticsearchHttp removeQueryEsQuery() {
    properties.remove(QUERY_ES_QUERY_PROPERTY);
    return this;
  }

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public final String getQueryEsSize() {
    return properties.get(QUERY_ES_SIZE_PROPERTY);
  }

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public final QueryElasticsearchHttp setQueryEsSize(final String queryEsSize) {
    properties.put(QUERY_ES_SIZE_PROPERTY, queryEsSize);
    return this;
  }

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public final QueryElasticsearchHttp removeQueryEsSize() {
    properties.remove(QUERY_ES_SIZE_PROPERTY);
    return this;
  }

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public final String getQueryEsIndex() {
    return properties.get(QUERY_ES_INDEX_PROPERTY);
  }

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public final QueryElasticsearchHttp setQueryEsIndex(final String queryEsIndex) {
    properties.put(QUERY_ES_INDEX_PROPERTY, queryEsIndex);
    return this;
  }

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public final QueryElasticsearchHttp removeQueryEsIndex() {
    properties.remove(QUERY_ES_INDEX_PROPERTY);
    return this;
  }

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public final String getQueryEsType() {
    return properties.get(QUERY_ES_TYPE_PROPERTY);
  }

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public final QueryElasticsearchHttp setQueryEsType(final String queryEsType) {
    properties.put(QUERY_ES_TYPE_PROPERTY, queryEsType);
    return this;
  }

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public final QueryElasticsearchHttp removeQueryEsType() {
    properties.remove(QUERY_ES_TYPE_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final String getQueryEsFields() {
    return properties.get(QUERY_ES_FIELDS_PROPERTY);
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final QueryElasticsearchHttp setQueryEsFields(final String queryEsFields) {
    properties.put(QUERY_ES_FIELDS_PROPERTY, queryEsFields);
    return this;
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final QueryElasticsearchHttp removeQueryEsFields() {
    properties.remove(QUERY_ES_FIELDS_PROPERTY);
    return this;
  }

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public final String getQueryEsSort() {
    return properties.get(QUERY_ES_SORT_PROPERTY);
  }

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public final QueryElasticsearchHttp setQueryEsSort(final String queryEsSort) {
    properties.put(QUERY_ES_SORT_PROPERTY, queryEsSort);
    return this;
  }

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public final QueryElasticsearchHttp removeQueryEsSort() {
    properties.remove(QUERY_ES_SORT_PROPERTY);
    return this;
  }

  /**
   * If set, limits the number of results that will be returned.
   */
  public final String getQueryEsLimit() {
    return properties.get(QUERY_ES_LIMIT_PROPERTY);
  }

  /**
   * If set, limits the number of results that will be returned.
   */
  public final QueryElasticsearchHttp setQueryEsLimit(final String queryEsLimit) {
    properties.put(QUERY_ES_LIMIT_PROPERTY, queryEsLimit);
    return this;
  }

  /**
   * If set, limits the number of results that will be returned.
   */
  public final QueryElasticsearchHttp removeQueryEsLimit() {
    properties.remove(QUERY_ES_LIMIT_PROPERTY);
    return this;
  }

  /**
   * Indicates where the results should be placed.  In the case of 'Flow file content', the JSON response will be written as the content of the flow file.  In the case of 'Flow file attributes', the original flow file (if applicable) will be cloned for each result, and all return fields will be placed in a flow file attribute of the same name, but prefixed by 'es.result.'
   */
  public final String getQueryEsTarget() {
    return properties.get(QUERY_ES_TARGET_PROPERTY);
  }

  /**
   * Indicates where the results should be placed.  In the case of 'Flow file content', the JSON response will be written as the content of the flow file.  In the case of 'Flow file attributes', the original flow file (if applicable) will be cloned for each result, and all return fields will be placed in a flow file attribute of the same name, but prefixed by 'es.result.'
   */
  public final QueryElasticsearchHttp setQueryEsTarget(final String queryEsTarget) {
    properties.put(QUERY_ES_TARGET_PROPERTY, queryEsTarget);
    return this;
  }

  /**
   * Indicates where the results should be placed.  In the case of 'Flow file content', the JSON response will be written as the content of the flow file.  In the case of 'Flow file attributes', the original flow file (if applicable) will be cloned for each result, and all return fields will be placed in a flow file attribute of the same name, but prefixed by 'es.result.'
   */
  public final QueryElasticsearchHttp removeQueryEsTarget() {
    properties.remove(QUERY_ES_TARGET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QueryElasticsearchHttp setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QueryElasticsearchHttp removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<QueryElasticsearchHttp, QueryElasticsearchHttp> configurator) {
    return configurator.apply(new QueryElasticsearchHttp()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryElasticsearchHttp.class) final Closure<QueryElasticsearchHttp> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.QueryElasticsearchHttp> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.QueryElasticsearchHttp.class, com.tibtech.nifi.processors.elasticsearch.QueryElasticsearchHttp.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
