package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchElasticsearch5 {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.elasticsearch.FetchElasticsearch5";

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public static final String EL_5_CLUSTER_NAME_PROPERTY = "el5-cluster-name";

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public static final String EL_5_HOSTS_PROPERTY = "el5-hosts";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public static final String EL_5_SSL_CONTEXT_SERVICE_PROPERTY = "el5-ssl-context-service";

  /**
   * Specifies the path to the JAR(s) for the Elasticsearch X-Pack Transport feature. If the Elasticsearch cluster has been secured with the X-Pack plugin, then the X-Pack Transport JARs must also be available to this processor. Note: Do NOT place the X-Pack JARs into NiFi's lib/ directory, doing so will prevent the X-Pack Transport JARs from being loaded.
   */
  public static final String EL_5_XPACK_LOCATION_PROPERTY = "el5-xpack-location";

  /**
   * Username to access the Elasticsearch cluster
   */
  public static final String EL_5_USERNAME_PROPERTY = "el5-username";

  /**
   * Password to access the Elasticsearch cluster
   */
  public static final String EL_5_PASSWORD_PROPERTY = "el5-password";

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public static final String EL_5_PING_TIMEOUT_PROPERTY = "el5-ping-timeout";

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public static final String EL_5_SAMPLER_INTERVAL_PROPERTY = "el5-sampler-interval";

  /**
   * The identifier for the document to be fetched
   */
  public static final String EL_5_FETCH_DOC_ID_PROPERTY = "el5-fetch-doc-id";

  /**
   * The name of the index to read from
   */
  public static final String EL_5_FETCH_INDEX_PROPERTY = "el5-fetch-index";

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public static final String EL_5_FETCH_TYPE_PROPERTY = "el5-fetch-type";

  /**
   * Specifies the character set of the document data.
   */
  public static final String EL_5_CHARSET_PROPERTY = "el5-charset";

  private final Map<String, String> properties;

  public FetchElasticsearch5() {
    this.properties = new HashMap<>();
  }

  public FetchElasticsearch5(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final String getEl5ClusterName() {
    return properties.get(EL_5_CLUSTER_NAME_PROPERTY);
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final FetchElasticsearch5 setEl5ClusterName(final String el5ClusterName) {
    properties.put(EL_5_CLUSTER_NAME_PROPERTY, el5ClusterName);
    return this;
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final FetchElasticsearch5 removeEl5ClusterName() {
    properties.remove(EL_5_CLUSTER_NAME_PROPERTY);
    return this;
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final String getEl5Hosts() {
    return properties.get(EL_5_HOSTS_PROPERTY);
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final FetchElasticsearch5 setEl5Hosts(final String el5Hosts) {
    properties.put(EL_5_HOSTS_PROPERTY, el5Hosts);
    return this;
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final FetchElasticsearch5 removeEl5Hosts() {
    properties.remove(EL_5_HOSTS_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final String getEl5SslContextService() {
    return properties.get(EL_5_SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final FetchElasticsearch5 setEl5SslContextService(final String el5SslContextService) {
    properties.put(EL_5_SSL_CONTEXT_SERVICE_PROPERTY, el5SslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final FetchElasticsearch5 removeEl5SslContextService() {
    properties.remove(EL_5_SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies the path to the JAR(s) for the Elasticsearch X-Pack Transport feature. If the Elasticsearch cluster has been secured with the X-Pack plugin, then the X-Pack Transport JARs must also be available to this processor. Note: Do NOT place the X-Pack JARs into NiFi's lib/ directory, doing so will prevent the X-Pack Transport JARs from being loaded.
   */
  public final String getEl5XpackLocation() {
    return properties.get(EL_5_XPACK_LOCATION_PROPERTY);
  }

  /**
   * Specifies the path to the JAR(s) for the Elasticsearch X-Pack Transport feature. If the Elasticsearch cluster has been secured with the X-Pack plugin, then the X-Pack Transport JARs must also be available to this processor. Note: Do NOT place the X-Pack JARs into NiFi's lib/ directory, doing so will prevent the X-Pack Transport JARs from being loaded.
   */
  public final FetchElasticsearch5 setEl5XpackLocation(final String el5XpackLocation) {
    properties.put(EL_5_XPACK_LOCATION_PROPERTY, el5XpackLocation);
    return this;
  }

  /**
   * Specifies the path to the JAR(s) for the Elasticsearch X-Pack Transport feature. If the Elasticsearch cluster has been secured with the X-Pack plugin, then the X-Pack Transport JARs must also be available to this processor. Note: Do NOT place the X-Pack JARs into NiFi's lib/ directory, doing so will prevent the X-Pack Transport JARs from being loaded.
   */
  public final FetchElasticsearch5 removeEl5XpackLocation() {
    properties.remove(EL_5_XPACK_LOCATION_PROPERTY);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final String getEl5Username() {
    return properties.get(EL_5_USERNAME_PROPERTY);
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final FetchElasticsearch5 setEl5Username(final String el5Username) {
    properties.put(EL_5_USERNAME_PROPERTY, el5Username);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final FetchElasticsearch5 removeEl5Username() {
    properties.remove(EL_5_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final String getEl5Password() {
    return properties.get(EL_5_PASSWORD_PROPERTY);
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final FetchElasticsearch5 setEl5Password(final String el5Password) {
    properties.put(EL_5_PASSWORD_PROPERTY, el5Password);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final FetchElasticsearch5 removeEl5Password() {
    properties.remove(EL_5_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final String getEl5PingTimeout() {
    return properties.get(EL_5_PING_TIMEOUT_PROPERTY);
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final FetchElasticsearch5 setEl5PingTimeout(final String el5PingTimeout) {
    properties.put(EL_5_PING_TIMEOUT_PROPERTY, el5PingTimeout);
    return this;
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final FetchElasticsearch5 removeEl5PingTimeout() {
    properties.remove(EL_5_PING_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final String getEl5SamplerInterval() {
    return properties.get(EL_5_SAMPLER_INTERVAL_PROPERTY);
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final FetchElasticsearch5 setEl5SamplerInterval(final String el5SamplerInterval) {
    properties.put(EL_5_SAMPLER_INTERVAL_PROPERTY, el5SamplerInterval);
    return this;
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final FetchElasticsearch5 removeEl5SamplerInterval() {
    properties.remove(EL_5_SAMPLER_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The identifier for the document to be fetched
   */
  public final String getEl5FetchDocId() {
    return properties.get(EL_5_FETCH_DOC_ID_PROPERTY);
  }

  /**
   * The identifier for the document to be fetched
   */
  public final FetchElasticsearch5 setEl5FetchDocId(final String el5FetchDocId) {
    properties.put(EL_5_FETCH_DOC_ID_PROPERTY, el5FetchDocId);
    return this;
  }

  /**
   * The identifier for the document to be fetched
   */
  public final FetchElasticsearch5 removeEl5FetchDocId() {
    properties.remove(EL_5_FETCH_DOC_ID_PROPERTY);
    return this;
  }

  /**
   * The name of the index to read from
   */
  public final String getEl5FetchIndex() {
    return properties.get(EL_5_FETCH_INDEX_PROPERTY);
  }

  /**
   * The name of the index to read from
   */
  public final FetchElasticsearch5 setEl5FetchIndex(final String el5FetchIndex) {
    properties.put(EL_5_FETCH_INDEX_PROPERTY, el5FetchIndex);
    return this;
  }

  /**
   * The name of the index to read from
   */
  public final FetchElasticsearch5 removeEl5FetchIndex() {
    properties.remove(EL_5_FETCH_INDEX_PROPERTY);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final String getEl5FetchType() {
    return properties.get(EL_5_FETCH_TYPE_PROPERTY);
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final FetchElasticsearch5 setEl5FetchType(final String el5FetchType) {
    properties.put(EL_5_FETCH_TYPE_PROPERTY, el5FetchType);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final FetchElasticsearch5 removeEl5FetchType() {
    properties.remove(EL_5_FETCH_TYPE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final String getEl5Charset() {
    return properties.get(EL_5_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the document data.
   */
  public final FetchElasticsearch5 setEl5Charset(final String el5Charset) {
    properties.put(EL_5_CHARSET_PROPERTY, el5Charset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final FetchElasticsearch5 removeEl5Charset() {
    properties.remove(EL_5_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchElasticsearch5 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchElasticsearch5 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<FetchElasticsearch5, FetchElasticsearch5> configurator) {
    return configurator.apply(new FetchElasticsearch5()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchElasticsearch5.class) final Closure<FetchElasticsearch5> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.FetchElasticsearch5> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearch5.class, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearch5.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchElasticsearch5, FetchElasticsearch5> configurator) {
    return configurator.apply(new FetchElasticsearch5(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchElasticsearch5.class) final Closure<FetchElasticsearch5> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.FetchElasticsearch5> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearch5.class, com.tibtech.nifi.processors.elasticsearch.FetchElasticsearch5.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
