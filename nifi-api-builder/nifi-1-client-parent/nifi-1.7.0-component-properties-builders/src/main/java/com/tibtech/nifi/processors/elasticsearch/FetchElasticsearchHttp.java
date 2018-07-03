package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchElasticsearchHttp {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.elasticsearch.FetchElasticsearchHttp";

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
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public static final String ELASTICSEARCH_HTTP_PROXY_HOST_PROPERTY = "elasticsearch-http-proxy-host";

  /**
   * The port of the proxy server
   */
  public static final String ELASTICSEARCH_HTTP_PROXY_PORT_PROPERTY = "elasticsearch-http-proxy-port";

  /**
   * Proxy Username
   */
  public static final String PROXY_USERNAME_PROPERTY = "proxy-username";

  /**
   * Proxy Password
   */
  public static final String PROXY_PASSWORD_PROPERTY = "proxy-password";

  /**
   * The identifier of the document to be fetched
   */
  public static final String FETCH_ES_DOC_ID_PROPERTY = "fetch-es-doc-id";

  /**
   * The name of the index to read from.
   */
  public static final String FETCH_ES_INDEX_PROPERTY = "fetch-es-index";

  /**
   * The (optional) type of this document, used by Elasticsearch for indexing and searching. If the property is empty, the first document matching the identifier across all types will be retrieved.
   */
  public static final String FETCH_ES_TYPE_PROPERTY = "fetch-es-type";

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public static final String FETCH_ES_FIELDS_PROPERTY = "fetch-es-fields";

  private final Map<String, String> properties;

  public FetchElasticsearchHttp() {
    this.properties = new HashMap<>();
  }

  public FetchElasticsearchHttp(final Map<String, String> properties) {
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
  public final FetchElasticsearchHttp setElasticsearchHttpUrl(final String elasticsearchHttpUrl) {
    properties.put(ELASTICSEARCH_HTTP_URL_PROPERTY, elasticsearchHttpUrl);
    return this;
  }

  /**
   * Elasticsearch URL which will be connected to, including scheme (http, e.g.), host, and port. The default port for the REST API is 9200.
   */
  public final FetchElasticsearchHttp removeElasticsearchHttpUrl() {
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
  public final FetchElasticsearchHttp setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final FetchElasticsearchHttp removeSslContextService() {
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
  public final FetchElasticsearchHttp setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final FetchElasticsearchHttp removeUsername() {
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
  public final FetchElasticsearchHttp setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final FetchElasticsearchHttp removePassword() {
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
  public final FetchElasticsearchHttp setElasticsearchHttpConnectTimeout(
      final String elasticsearchHttpConnectTimeout) {
    properties.put(ELASTICSEARCH_HTTP_CONNECT_TIMEOUT_PROPERTY, elasticsearchHttpConnectTimeout);
    return this;
  }

  /**
   * Max wait time for the connection to the Elasticsearch REST API.
   */
  public final FetchElasticsearchHttp removeElasticsearchHttpConnectTimeout() {
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
  public final FetchElasticsearchHttp setElasticsearchHttpResponseTimeout(
      final String elasticsearchHttpResponseTimeout) {
    properties.put(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY, elasticsearchHttpResponseTimeout);
    return this;
  }

  /**
   * Max wait time for a response from the Elasticsearch REST API.
   */
  public final FetchElasticsearchHttp removeElasticsearchHttpResponseTimeout() {
    properties.remove(ELASTICSEARCH_HTTP_RESPONSE_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final FetchElasticsearchHttp setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final FetchElasticsearchHttp removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final String getElasticsearchHttpProxyHost() {
    return properties.get(ELASTICSEARCH_HTTP_PROXY_HOST_PROPERTY);
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final FetchElasticsearchHttp setElasticsearchHttpProxyHost(
      final String elasticsearchHttpProxyHost) {
    properties.put(ELASTICSEARCH_HTTP_PROXY_HOST_PROPERTY, elasticsearchHttpProxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final FetchElasticsearchHttp removeElasticsearchHttpProxyHost() {
    properties.remove(ELASTICSEARCH_HTTP_PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final String getElasticsearchHttpProxyPort() {
    return properties.get(ELASTICSEARCH_HTTP_PROXY_PORT_PROPERTY);
  }

  /**
   * The port of the proxy server
   */
  public final FetchElasticsearchHttp setElasticsearchHttpProxyPort(
      final String elasticsearchHttpProxyPort) {
    properties.put(ELASTICSEARCH_HTTP_PROXY_PORT_PROPERTY, elasticsearchHttpProxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final FetchElasticsearchHttp removeElasticsearchHttpProxyPort() {
    properties.remove(ELASTICSEARCH_HTTP_PROXY_PORT_PROPERTY);
    return this;
  }

  /**
   * Proxy Username
   */
  public final String getProxyUsername() {
    return properties.get(PROXY_USERNAME_PROPERTY);
  }

  /**
   * Proxy Username
   */
  public final FetchElasticsearchHttp setProxyUsername(final String proxyUsername) {
    properties.put(PROXY_USERNAME_PROPERTY, proxyUsername);
    return this;
  }

  /**
   * Proxy Username
   */
  public final FetchElasticsearchHttp removeProxyUsername() {
    properties.remove(PROXY_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Proxy Password
   */
  public final String getProxyPassword() {
    return properties.get(PROXY_PASSWORD_PROPERTY);
  }

  /**
   * Proxy Password
   */
  public final FetchElasticsearchHttp setProxyPassword(final String proxyPassword) {
    properties.put(PROXY_PASSWORD_PROPERTY, proxyPassword);
    return this;
  }

  /**
   * Proxy Password
   */
  public final FetchElasticsearchHttp removeProxyPassword() {
    properties.remove(PROXY_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The identifier of the document to be fetched
   */
  public final String getFetchEsDocId() {
    return properties.get(FETCH_ES_DOC_ID_PROPERTY);
  }

  /**
   * The identifier of the document to be fetched
   */
  public final FetchElasticsearchHttp setFetchEsDocId(final String fetchEsDocId) {
    properties.put(FETCH_ES_DOC_ID_PROPERTY, fetchEsDocId);
    return this;
  }

  /**
   * The identifier of the document to be fetched
   */
  public final FetchElasticsearchHttp removeFetchEsDocId() {
    properties.remove(FETCH_ES_DOC_ID_PROPERTY);
    return this;
  }

  /**
   * The name of the index to read from.
   */
  public final String getFetchEsIndex() {
    return properties.get(FETCH_ES_INDEX_PROPERTY);
  }

  /**
   * The name of the index to read from.
   */
  public final FetchElasticsearchHttp setFetchEsIndex(final String fetchEsIndex) {
    properties.put(FETCH_ES_INDEX_PROPERTY, fetchEsIndex);
    return this;
  }

  /**
   * The name of the index to read from.
   */
  public final FetchElasticsearchHttp removeFetchEsIndex() {
    properties.remove(FETCH_ES_INDEX_PROPERTY);
    return this;
  }

  /**
   * The (optional) type of this document, used by Elasticsearch for indexing and searching. If the property is empty, the first document matching the identifier across all types will be retrieved.
   */
  public final String getFetchEsType() {
    return properties.get(FETCH_ES_TYPE_PROPERTY);
  }

  /**
   * The (optional) type of this document, used by Elasticsearch for indexing and searching. If the property is empty, the first document matching the identifier across all types will be retrieved.
   */
  public final FetchElasticsearchHttp setFetchEsType(final String fetchEsType) {
    properties.put(FETCH_ES_TYPE_PROPERTY, fetchEsType);
    return this;
  }

  /**
   * The (optional) type of this document, used by Elasticsearch for indexing and searching. If the property is empty, the first document matching the identifier across all types will be retrieved.
   */
  public final FetchElasticsearchHttp removeFetchEsType() {
    properties.remove(FETCH_ES_TYPE_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final String getFetchEsFields() {
    return properties.get(FETCH_ES_FIELDS_PROPERTY);
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final FetchElasticsearchHttp setFetchEsFields(final String fetchEsFields) {
    properties.put(FETCH_ES_FIELDS_PROPERTY, fetchEsFields);
    return this;
  }

  /**
   * A comma-separated list of fields to retrieve from the document. If the Fields property is left blank, then the entire document's source will be retrieved.
   */
  public final FetchElasticsearchHttp removeFetchEsFields() {
    properties.remove(FETCH_ES_FIELDS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchElasticsearchHttp setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchElasticsearchHttp removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FetchElasticsearchHttp, FetchElasticsearchHttp> configurator) {
    return configurator.apply(new FetchElasticsearchHttp()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchElasticsearchHttp.class) final Closure<FetchElasticsearchHttp> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.FetchElasticsearchHttp> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearchHttp.class, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearchHttp.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchElasticsearchHttp, FetchElasticsearchHttp> configurator) {
    return configurator.apply(new FetchElasticsearchHttp(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchElasticsearchHttp.class) final Closure<FetchElasticsearchHttp> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.FetchElasticsearchHttp> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearchHttp.class, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearchHttp.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
