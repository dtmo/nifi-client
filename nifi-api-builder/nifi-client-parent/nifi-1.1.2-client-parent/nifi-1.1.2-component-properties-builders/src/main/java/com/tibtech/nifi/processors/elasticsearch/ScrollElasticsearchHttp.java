package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ScrollElasticsearchHttp {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.elasticsearch.ScrollElasticsearchHttp";

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
  public static final String SCROLL_ES_QUERY_PROPERTY = "scroll-es-query";

  /**
   * The scroll duration is how long each search context is kept in memory.
   */
  public static final String SCROLL_ES_SCROLL_PROPERTY = "scroll-es-scroll";

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public static final String SCROLL_ES_SIZE_PROPERTY = "scroll-es-size";

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public static final String SCROLL_ES_INDEX_PROPERTY = "scroll-es-index";

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public static final String SCROLL_ES_TYPE_PROPERTY = "scroll-es-type";

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public static final String SCROLL_ES_FIELDS_PROPERTY = "scroll-es-fields";

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public static final String SCROLL_ES_SORT_PROPERTY = "scroll-es-sort";

  private final Map<String, String> properties;

  public ScrollElasticsearchHttp() {
    this.properties = new HashMap<>();
  }

  public ScrollElasticsearchHttp(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final String getElasticsearchHttpUrl() {
    return properties.get(ELASTICSEARCH_HTTP_URL_PROPERTY);
  }

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final ScrollElasticsearchHttp setElasticsearchHttpUrl(final String elasticsearchHttpUrl) {
    properties.put(ELASTICSEARCH_HTTP_URL_PROPERTY, elasticsearchHttpUrl);
    return this;
  }

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final ScrollElasticsearchHttp removeElasticsearchHttpUrl() {
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
  public final ScrollElasticsearchHttp setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final ScrollElasticsearchHttp removeSslContextService() {
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
  public final ScrollElasticsearchHttp setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final ScrollElasticsearchHttp removeUsername() {
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
  public final ScrollElasticsearchHttp setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final ScrollElasticsearchHttp removePassword() {
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
  public final ScrollElasticsearchHttp setElasticsearchHttpConnectTimeout(final String elasticsearchHttpConnectTimeout) {
    properties.put(ELASTICSEARCH_HTTP_CONNECT_TIMEOUT_PROPERTY, elasticsearchHttpConnectTimeout);
    return this;
  }

  /**
   * Max wait time for the connection to the Elasticsearch REST API.
   */
  public final ScrollElasticsearchHttp removeElasticsearchHttpConnectTimeout() {
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
  public final ScrollElasticsearchHttp setElasticsearchHttpResponseTimeout(final String elasticsearchHttpResponseTimeout) {
    properties.put(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY, elasticsearchHttpResponseTimeout);
    return this;
  }

  /**
   * Max wait time for a response from the Elasticsearch REST API.
   */
  public final ScrollElasticsearchHttp removeElasticsearchHttpResponseTimeout() {
    properties.remove(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public final String getScrollEsQuery() {
    return properties.get(SCROLL_ES_QUERY_PROPERTY);
  }

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public final ScrollElasticsearchHttp setScrollEsQuery(final String scrollEsQuery) {
    properties.put(SCROLL_ES_QUERY_PROPERTY, scrollEsQuery);
    return this;
  }

  /**
   * The Lucene-style query to run against ElasticSearch (e.g., genre:blues AND -artist:muddy)
   */
  public final ScrollElasticsearchHttp removeScrollEsQuery() {
    properties.remove(SCROLL_ES_QUERY_PROPERTY);
    return this;
  }

  /**
   * The scroll duration is how long each search context is kept in memory.
   */
  public final String getScrollEsScroll() {
    return properties.get(SCROLL_ES_SCROLL_PROPERTY);
  }

  /**
   * The scroll duration is how long each search context is kept in memory.
   */
  public final ScrollElasticsearchHttp setScrollEsScroll(final String scrollEsScroll) {
    properties.put(SCROLL_ES_SCROLL_PROPERTY, scrollEsScroll);
    return this;
  }

  /**
   * The scroll duration is how long each search context is kept in memory.
   */
  public final ScrollElasticsearchHttp removeScrollEsScroll() {
    properties.remove(SCROLL_ES_SCROLL_PROPERTY);
    return this;
  }

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public final String getScrollEsSize() {
    return properties.get(SCROLL_ES_SIZE_PROPERTY);
  }

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public final ScrollElasticsearchHttp setScrollEsSize(final String scrollEsSize) {
    properties.put(SCROLL_ES_SIZE_PROPERTY, scrollEsSize);
    return this;
  }

  /**
   * Determines how many documents to return per page during scrolling.
   */
  public final ScrollElasticsearchHttp removeScrollEsSize() {
    properties.remove(SCROLL_ES_SIZE_PROPERTY);
    return this;
  }

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public final String getScrollEsIndex() {
    return properties.get(SCROLL_ES_INDEX_PROPERTY);
  }

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public final ScrollElasticsearchHttp setScrollEsIndex(final String scrollEsIndex) {
    properties.put(SCROLL_ES_INDEX_PROPERTY, scrollEsIndex);
    return this;
  }

  /**
   * The name of the index to read from. If the property is set to _all, the query will match across all indexes.
   */
  public final ScrollElasticsearchHttp removeScrollEsIndex() {
    properties.remove(SCROLL_ES_INDEX_PROPERTY);
    return this;
  }

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public final String getScrollEsType() {
    return properties.get(SCROLL_ES_TYPE_PROPERTY);
  }

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public final ScrollElasticsearchHttp setScrollEsType(final String scrollEsType) {
    properties.put(SCROLL_ES_TYPE_PROPERTY, scrollEsType);
    return this;
  }

  /**
   * The (optional) type of this query, used by Elasticsearch for indexing and searching. If the property is empty, the the query will match across all types.
   */
  public final ScrollElasticsearchHttp removeScrollEsType() {
    properties.remove(SCROLL_ES_TYPE_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final String getScrollEsFields() {
    return properties.get(SCROLL_ES_FIELDS_PROPERTY);
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final ScrollElasticsearchHttp setScrollEsFields(final String scrollEsFields) {
    properties.put(SCROLL_ES_FIELDS_PROPERTY, scrollEsFields);
    return this;
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final ScrollElasticsearchHttp removeScrollEsFields() {
    properties.remove(SCROLL_ES_FIELDS_PROPERTY);
    return this;
  }

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public final String getScrollEsSort() {
    return properties.get(SCROLL_ES_SORT_PROPERTY);
  }

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public final ScrollElasticsearchHttp setScrollEsSort(final String scrollEsSort) {
    properties.put(SCROLL_ES_SORT_PROPERTY, scrollEsSort);
    return this;
  }

  /**
   * A sort parameter (e.g., timestamp:asc). If the Sort property is left blank, then the results will be retrieved in document order.
   */
  public final ScrollElasticsearchHttp removeScrollEsSort() {
    properties.remove(SCROLL_ES_SORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ScrollElasticsearchHttp setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ScrollElasticsearchHttp removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ScrollElasticsearchHttp, ScrollElasticsearchHttp> configurator) {
    return configurator.apply(new ScrollElasticsearchHttp()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScrollElasticsearchHttp.class) final Closure<ScrollElasticsearchHttp> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.ScrollElasticsearchHttp> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.ScrollElasticsearchHttp.class, com.tibtech.nifi.processors.elasticsearch.ScrollElasticsearchHttp.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ScrollElasticsearchHttp, ScrollElasticsearchHttp> configurator) {
    return configurator.apply(new ScrollElasticsearchHttp(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScrollElasticsearchHttp.class) final Closure<ScrollElasticsearchHttp> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.ScrollElasticsearchHttp> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.ScrollElasticsearchHttp.class, com.tibtech.nifi.processors.elasticsearch.ScrollElasticsearchHttp.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
