package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutElasticsearch {
  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public static final String CLUSTER_NAME_PROPERTY = "Cluster Name";

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public static final String ELASTIC_SEARCH_HOSTS_PROPERTY = "ElasticSearch Hosts";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Specifies the path to the JAR for the Elasticsearch Shield plugin. If the Elasticsearch cluster has been secured with the Shield plugin, then the Shield plugin JAR must also be available to this processor. Note: Do NOT place the Shield JAR into NiFi's lib/ directory, doing so will prevent the Shield plugin from being loaded.
   */
  public static final String SHIELD_PLUGIN_FILENAME_PROPERTY = "Shield Plugin Filename";

  /**
   * Username to access the Elasticsearch cluster
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password to access the Elasticsearch cluster
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public static final String ELASTIC_SEARCH_PING_TIMEOUT_PROPERTY = "ElasticSearch Ping Timeout";

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public static final String SAMPLER_INTERVAL_PROPERTY = "Sampler Interval";

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public static final String IDENTIFIER_ATTRIBUTE_PROPERTY = "Identifier Attribute";

  /**
   * The name of the index to insert into
   */
  public static final String INDEX_PROPERTY = "Index";

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public static final String TYPE_PROPERTY = "Type";

  /**
   * Specifies the character set of the document data.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public static final String INDEX_OPERATION_PROPERTY = "Index Operation";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final String getClusterName() {
    return properties.get(CLUSTER_NAME_PROPERTY);
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final PutElasticsearch setClusterName(final String clusterName) {
    properties.put(CLUSTER_NAME_PROPERTY, clusterName);
    return this;
  }

  /**
   * Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'
   */
  public final PutElasticsearch removeClusterName() {
    properties.remove(CLUSTER_NAME_PROPERTY);
    return this;
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final String getElasticSearchHosts() {
    return properties.get(ELASTIC_SEARCH_HOSTS_PROPERTY);
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final PutElasticsearch setElasticSearchHosts(final String elasticSearchHosts) {
    properties.put(ELASTIC_SEARCH_HOSTS_PROPERTY, elasticSearchHosts);
    return this;
  }

  /**
   * ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300. This processor uses the Transport Client to connect to hosts. The default transport client port is 9300.
   */
  public final PutElasticsearch removeElasticSearchHosts() {
    properties.remove(ELASTIC_SEARCH_HOSTS_PROPERTY);
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
  public final PutElasticsearch setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final PutElasticsearch removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies the path to the JAR for the Elasticsearch Shield plugin. If the Elasticsearch cluster has been secured with the Shield plugin, then the Shield plugin JAR must also be available to this processor. Note: Do NOT place the Shield JAR into NiFi's lib/ directory, doing so will prevent the Shield plugin from being loaded.
   */
  public final String getShieldPluginFilename() {
    return properties.get(SHIELD_PLUGIN_FILENAME_PROPERTY);
  }

  /**
   * Specifies the path to the JAR for the Elasticsearch Shield plugin. If the Elasticsearch cluster has been secured with the Shield plugin, then the Shield plugin JAR must also be available to this processor. Note: Do NOT place the Shield JAR into NiFi's lib/ directory, doing so will prevent the Shield plugin from being loaded.
   */
  public final PutElasticsearch setShieldPluginFilename(final String shieldPluginFilename) {
    properties.put(SHIELD_PLUGIN_FILENAME_PROPERTY, shieldPluginFilename);
    return this;
  }

  /**
   * Specifies the path to the JAR for the Elasticsearch Shield plugin. If the Elasticsearch cluster has been secured with the Shield plugin, then the Shield plugin JAR must also be available to this processor. Note: Do NOT place the Shield JAR into NiFi's lib/ directory, doing so will prevent the Shield plugin from being loaded.
   */
  public final PutElasticsearch removeShieldPluginFilename() {
    properties.remove(SHIELD_PLUGIN_FILENAME_PROPERTY);
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
  public final PutElasticsearch setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username to access the Elasticsearch cluster
   */
  public final PutElasticsearch removeUsername() {
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
  public final PutElasticsearch setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password to access the Elasticsearch cluster
   */
  public final PutElasticsearch removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final String getElasticSearchPingTimeout() {
    return properties.get(ELASTIC_SEARCH_PING_TIMEOUT_PROPERTY);
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final PutElasticsearch setElasticSearchPingTimeout(final String elasticSearchPingTimeout) {
    properties.put(ELASTIC_SEARCH_PING_TIMEOUT_PROPERTY, elasticSearchPingTimeout);
    return this;
  }

  /**
   * The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s
   */
  public final PutElasticsearch removeElasticSearchPingTimeout() {
    properties.remove(ELASTIC_SEARCH_PING_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final String getSamplerInterval() {
    return properties.get(SAMPLER_INTERVAL_PROPERTY);
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final PutElasticsearch setSamplerInterval(final String samplerInterval) {
    properties.put(SAMPLER_INTERVAL_PROPERTY, samplerInterval);
    return this;
  }

  /**
   * How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.
   */
  public final PutElasticsearch removeSamplerInterval() {
    properties.remove(SAMPLER_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public final String getIdentifierAttribute() {
    return properties.get(IDENTIFIER_ATTRIBUTE_PROPERTY);
  }

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public final PutElasticsearch setIdentifierAttribute(final String identifierAttribute) {
    properties.put(IDENTIFIER_ATTRIBUTE_PROPERTY, identifierAttribute);
    return this;
  }

  /**
   * The name of the attribute containing the identifier for each FlowFile
   */
  public final PutElasticsearch removeIdentifierAttribute() {
    properties.remove(IDENTIFIER_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The name of the index to insert into
   */
  public final String getIndex() {
    return properties.get(INDEX_PROPERTY);
  }

  /**
   * The name of the index to insert into
   */
  public final PutElasticsearch setIndex(final String index) {
    properties.put(INDEX_PROPERTY, index);
    return this;
  }

  /**
   * The name of the index to insert into
   */
  public final PutElasticsearch removeIndex() {
    properties.remove(INDEX_PROPERTY);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final String getType() {
    return properties.get(TYPE_PROPERTY);
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final PutElasticsearch setType(final String type) {
    properties.put(TYPE_PROPERTY, type);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final PutElasticsearch removeType() {
    properties.remove(TYPE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies the character set of the document data.
   */
  public final PutElasticsearch setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final PutElasticsearch removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutElasticsearch setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutElasticsearch removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public final String getIndexOperation() {
    return properties.get(INDEX_OPERATION_PROPERTY);
  }

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public final PutElasticsearch setIndexOperation(final String indexOperation) {
    properties.put(INDEX_OPERATION_PROPERTY, indexOperation);
    return this;
  }

  /**
   * The type of the operation used to index (index, update, upsert)
   */
  public final PutElasticsearch removeIndexOperation() {
    properties.remove(INDEX_OPERATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutElasticsearch setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutElasticsearch removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutElasticsearch, PutElasticsearch> configurator) {
    return configurator.apply(new PutElasticsearch()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutElasticsearch.class) final Closure<PutElasticsearch> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.PutElasticsearch> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.PutElasticsearch.class, com.tibtech.nifi.processors.elasticsearch.PutElasticsearch.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
