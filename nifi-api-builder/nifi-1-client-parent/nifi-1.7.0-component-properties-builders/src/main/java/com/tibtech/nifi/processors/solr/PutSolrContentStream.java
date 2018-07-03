package com.tibtech.nifi.processors.solr;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSolrContentStream {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.solr.PutSolrContentStream";

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public static final String SOLR_TYPE_PROPERTY = "Solr Type";

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public static final String SOLR_LOCATION_PROPERTY = "Solr Location";

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public static final String COLLECTION_PROPERTY = "Collection";

  /**
   * The path in Solr to post the ContentStream
   */
  public static final String CONTENT_STREAM_PATH_PROPERTY = "Content Stream Path";

  /**
   * Content-Type being sent to Solr
   */
  public static final String CONTENT_TYPE_PROPERTY = "Content-Type";

  /**
   * The number of milliseconds before the given update is committed
   */
  public static final String COMMIT_WITHIN_PROPERTY = "Commit Within";

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public static final String KERBEROS_CREDENTIALS_SERVICE_PROPERTY = "kerberos-credentials-service";

  /**
   * The username to use when Solr is configured with basic authentication.
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * The password to use when Solr is configured with basic authentication.
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public static final String SOLR_SOCKET_TIMEOUT_PROPERTY = "Solr Socket Timeout";

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public static final String SOLR_CONNECTION_TIMEOUT_PROPERTY = "Solr Connection Timeout";

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public static final String SOLR_MAXIMUM_CONNECTIONS_PROPERTY = "Solr Maximum Connections";

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public static final String SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY = "Solr Maximum Connections Per Host";

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public static final String ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY = "ZooKeeper Client Timeout";

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public static final String ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY = "ZooKeeper Connection Timeout";

  private final Map<String, String> properties;

  public PutSolrContentStream() {
    this.properties = new HashMap<>();
  }

  public PutSolrContentStream(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final String getSolrType() {
    return properties.get(SOLR_TYPE_PROPERTY);
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final PutSolrContentStream setSolrType(final String solrType) {
    properties.put(SOLR_TYPE_PROPERTY, solrType);
    return this;
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final PutSolrContentStream removeSolrType() {
    properties.remove(SOLR_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final String getSolrLocation() {
    return properties.get(SOLR_LOCATION_PROPERTY);
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final PutSolrContentStream setSolrLocation(final String solrLocation) {
    properties.put(SOLR_LOCATION_PROPERTY, solrLocation);
    return this;
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final PutSolrContentStream removeSolrLocation() {
    properties.remove(SOLR_LOCATION_PROPERTY);
    return this;
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final String getCollection() {
    return properties.get(COLLECTION_PROPERTY);
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final PutSolrContentStream setCollection(final String collection) {
    properties.put(COLLECTION_PROPERTY, collection);
    return this;
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final PutSolrContentStream removeCollection() {
    properties.remove(COLLECTION_PROPERTY);
    return this;
  }

  /**
   * The path in Solr to post the ContentStream
   */
  public final String getContentStreamPath() {
    return properties.get(CONTENT_STREAM_PATH_PROPERTY);
  }

  /**
   * The path in Solr to post the ContentStream
   */
  public final PutSolrContentStream setContentStreamPath(final String contentStreamPath) {
    properties.put(CONTENT_STREAM_PATH_PROPERTY, contentStreamPath);
    return this;
  }

  /**
   * The path in Solr to post the ContentStream
   */
  public final PutSolrContentStream removeContentStreamPath() {
    properties.remove(CONTENT_STREAM_PATH_PROPERTY);
    return this;
  }

  /**
   * Content-Type being sent to Solr
   */
  public final String getContentType() {
    return properties.get(CONTENT_TYPE_PROPERTY);
  }

  /**
   * Content-Type being sent to Solr
   */
  public final PutSolrContentStream setContentType(final String contentType) {
    properties.put(CONTENT_TYPE_PROPERTY, contentType);
    return this;
  }

  /**
   * Content-Type being sent to Solr
   */
  public final PutSolrContentStream removeContentType() {
    properties.remove(CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * The number of milliseconds before the given update is committed
   */
  public final String getCommitWithin() {
    return properties.get(COMMIT_WITHIN_PROPERTY);
  }

  /**
   * The number of milliseconds before the given update is committed
   */
  public final PutSolrContentStream setCommitWithin(final String commitWithin) {
    properties.put(COMMIT_WITHIN_PROPERTY, commitWithin);
    return this;
  }

  /**
   * The number of milliseconds before the given update is committed
   */
  public final PutSolrContentStream removeCommitWithin() {
    properties.remove(COMMIT_WITHIN_PROPERTY);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final String getKerberosCredentialsService() {
    return properties.get(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PutSolrContentStream setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PutSolrContentStream removeKerberosCredentialsService() {
    properties.remove(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The username to use when Solr is configured with basic authentication.
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * The username to use when Solr is configured with basic authentication.
   */
  public final PutSolrContentStream setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * The username to use when Solr is configured with basic authentication.
   */
  public final PutSolrContentStream removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * The password to use when Solr is configured with basic authentication.
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * The password to use when Solr is configured with basic authentication.
   */
  public final PutSolrContentStream setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The password to use when Solr is configured with basic authentication.
   */
  public final PutSolrContentStream removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final PutSolrContentStream setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final PutSolrContentStream removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final String getSolrSocketTimeout() {
    return properties.get(SOLR_SOCKET_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final PutSolrContentStream setSolrSocketTimeout(final String solrSocketTimeout) {
    properties.put(SOLR_SOCKET_TIMEOUT_PROPERTY, solrSocketTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final PutSolrContentStream removeSolrSocketTimeout() {
    properties.remove(SOLR_SOCKET_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final String getSolrConnectionTimeout() {
    return properties.get(SOLR_CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final PutSolrContentStream setSolrConnectionTimeout(final String solrConnectionTimeout) {
    properties.put(SOLR_CONNECTION_TIMEOUT_PROPERTY, solrConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final PutSolrContentStream removeSolrConnectionTimeout() {
    properties.remove(SOLR_CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final String getSolrMaximumConnections() {
    return properties.get(SOLR_MAXIMUM_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final PutSolrContentStream setSolrMaximumConnections(final String solrMaximumConnections) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PROPERTY, solrMaximumConnections);
    return this;
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final PutSolrContentStream removeSolrMaximumConnections() {
    properties.remove(SOLR_MAXIMUM_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final String getSolrMaximumConnectionsPerHost() {
    return properties.get(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY);
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final PutSolrContentStream setSolrMaximumConnectionsPerHost(
      final String solrMaximumConnectionsPerHost) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY, solrMaximumConnectionsPerHost);
    return this;
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final PutSolrContentStream removeSolrMaximumConnectionsPerHost() {
    properties.remove(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final String getZooKeeperClientTimeout() {
    return properties.get(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final PutSolrContentStream setZooKeeperClientTimeout(final String zooKeeperClientTimeout) {
    properties.put(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY, zooKeeperClientTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final PutSolrContentStream removeZooKeeperClientTimeout() {
    properties.remove(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final String getZooKeeperConnectionTimeout() {
    return properties.get(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final PutSolrContentStream setZooKeeperConnectionTimeout(
      final String zooKeeperConnectionTimeout) {
    properties.put(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY, zooKeeperConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final PutSolrContentStream removeZooKeeperConnectionTimeout() {
    properties.remove(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSolrContentStream setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSolrContentStream removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutSolrContentStream, PutSolrContentStream> configurator) {
    return configurator.apply(new PutSolrContentStream()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSolrContentStream.class) final Closure<PutSolrContentStream> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.solr.PutSolrContentStream> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.PutSolrContentStream.class, com.tibtech.nifi.processors.solr.PutSolrContentStream.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutSolrContentStream, PutSolrContentStream> configurator) {
    return configurator.apply(new PutSolrContentStream(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSolrContentStream.class) final Closure<PutSolrContentStream> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.solr.PutSolrContentStream> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.PutSolrContentStream.class, com.tibtech.nifi.processors.solr.PutSolrContentStream.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
