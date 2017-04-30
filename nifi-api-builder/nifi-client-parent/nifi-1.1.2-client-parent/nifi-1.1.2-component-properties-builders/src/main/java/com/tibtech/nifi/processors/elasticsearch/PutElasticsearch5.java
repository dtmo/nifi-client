package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutElasticsearch5 {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.elasticsearch.PutElasticsearch5";

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
   * The name of the attribute containing the identifier for each FlowFile
   */
  public static final String EL_5_PUT_ID_ATTRIBUTE_PROPERTY = "el5-put-id-attribute";

  /**
   * The name of the index to insert into
   */
  public static final String EL_5_PUT_INDEX_PROPERTY = "el5-put-index";

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public static final String EL_5_PUT_TYPE_PROPERTY = "el5-put-type";

  /**
   * Specifies the character set of the document data.
   */
  public static final String EL_5_CHARSET_PROPERTY = "el5-charset";

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public static final String EL_5_PUT_BATCH_SIZE_PROPERTY = "el5-put-batch-size";

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public static final String EL_5_PUT_INDEX_OP_PROPERTY = "el5-put-index-op";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final String getEl5ClusterName() {
    return properties.get(EL_5_CLUSTER_NAME_PROPERTY);
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final PutElasticsearch5 setEl5ClusterName(final String el5ClusterName) {
    properties.put(EL_5_CLUSTER_NAME_PROPERTY, el5ClusterName);
    return this;
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final PutElasticsearch5 removeEl5ClusterName() {
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
  public final PutElasticsearch5 setEl5Hosts(final String el5Hosts) {
    properties.put(EL_5_HOSTS_PROPERTY, el5Hosts);
    return this;
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final PutElasticsearch5 removeEl5Hosts() {
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
  public final PutElasticsearch5 setEl5SslContextService(final String el5SslContextService) {
    properties.put(EL_5_SSL_CONTEXT_SERVICE_PROPERTY, el5SslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final PutElasticsearch5 removeEl5SslContextService() {
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
  public final PutElasticsearch5 setEl5XpackLocation(final String el5XpackLocation) {
    properties.put(EL_5_XPACK_LOCATION_PROPERTY, el5XpackLocation);
    return this;
  }

  /**
   * Specifies the path to the JAR(s) for the Elasticsearch X-Pack Transport feature. If the Elasticsearch cluster has been secured with the X-Pack plugin, then the X-Pack Transport JARs must also be available to this processor. Note: Do NOT place the X-Pack JARs into NiFi's lib/ directory, doing so will prevent the X-Pack Transport JARs from being loaded.
   */
  public final PutElasticsearch5 removeEl5XpackLocation() {
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
  public final PutElasticsearch5 setEl5Username(final String el5Username) {
    properties.put(EL_5_USERNAME_PROPERTY, el5Username);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final PutElasticsearch5 removeEl5Username() {
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
  public final PutElasticsearch5 setEl5Password(final String el5Password) {
    properties.put(EL_5_PASSWORD_PROPERTY, el5Password);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final PutElasticsearch5 removeEl5Password() {
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
  public final PutElasticsearch5 setEl5PingTimeout(final String el5PingTimeout) {
    properties.put(EL_5_PING_TIMEOUT_PROPERTY, el5PingTimeout);
    return this;
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final PutElasticsearch5 removeEl5PingTimeout() {
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
  public final PutElasticsearch5 setEl5SamplerInterval(final String el5SamplerInterval) {
    properties.put(EL_5_SAMPLER_INTERVAL_PROPERTY, el5SamplerInterval);
    return this;
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final PutElasticsearch5 removeEl5SamplerInterval() {
    properties.remove(EL_5_SAMPLER_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public final String getEl5PutIdAttribute() {
    return properties.get(EL_5_PUT_ID_ATTRIBUTE_PROPERTY);
  }

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public final PutElasticsearch5 setEl5PutIdAttribute(final String el5PutIdAttribute) {
    properties.put(EL_5_PUT_ID_ATTRIBUTE_PROPERTY, el5PutIdAttribute);
    return this;
  }

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public final PutElasticsearch5 removeEl5PutIdAttribute() {
    properties.remove(EL_5_PUT_ID_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The name of the index to insert into
   */
  public final String getEl5PutIndex() {
    return properties.get(EL_5_PUT_INDEX_PROPERTY);
  }

  /**
   * The name of the index to insert into
   */
  public final PutElasticsearch5 setEl5PutIndex(final String el5PutIndex) {
    properties.put(EL_5_PUT_INDEX_PROPERTY, el5PutIndex);
    return this;
  }

  /**
   * The name of the index to insert into
   */
  public final PutElasticsearch5 removeEl5PutIndex() {
    properties.remove(EL_5_PUT_INDEX_PROPERTY);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final String getEl5PutType() {
    return properties.get(EL_5_PUT_TYPE_PROPERTY);
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final PutElasticsearch5 setEl5PutType(final String el5PutType) {
    properties.put(EL_5_PUT_TYPE_PROPERTY, el5PutType);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final PutElasticsearch5 removeEl5PutType() {
    properties.remove(EL_5_PUT_TYPE_PROPERTY);
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
  public final PutElasticsearch5 setEl5Charset(final String el5Charset) {
    properties.put(EL_5_CHARSET_PROPERTY, el5Charset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final PutElasticsearch5 removeEl5Charset() {
    properties.remove(EL_5_CHARSET_PROPERTY);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final String getEl5PutBatchSize() {
    return properties.get(EL_5_PUT_BATCH_SIZE_PROPERTY);
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutElasticsearch5 setEl5PutBatchSize(final String el5PutBatchSize) {
    properties.put(EL_5_PUT_BATCH_SIZE_PROPERTY, el5PutBatchSize);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutElasticsearch5 removeEl5PutBatchSize() {
    properties.remove(EL_5_PUT_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public final String getEl5PutIndexOp() {
    return properties.get(EL_5_PUT_INDEX_OP_PROPERTY);
  }

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public final PutElasticsearch5 setEl5PutIndexOp(final String el5PutIndexOp) {
    properties.put(EL_5_PUT_INDEX_OP_PROPERTY, el5PutIndexOp);
    return this;
  }

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public final PutElasticsearch5 removeEl5PutIndexOp() {
    properties.remove(EL_5_PUT_INDEX_OP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutElasticsearch5 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutElasticsearch5 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutElasticsearch5, PutElasticsearch5> configurator) {
    return configurator.apply(new PutElasticsearch5()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutElasticsearch5.class) final Closure<PutElasticsearch5> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.PutElasticsearch5> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.PutElasticsearch5.class, com.tibtech.nifi.processors.elasticsearch.PutElasticsearch5.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
