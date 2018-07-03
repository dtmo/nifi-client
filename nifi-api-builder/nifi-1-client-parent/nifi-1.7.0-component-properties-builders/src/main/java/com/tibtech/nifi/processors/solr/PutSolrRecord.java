package com.tibtech.nifi.processors.solr;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSolrRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.solr.PutSolrRecord";

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
   * The path in Solr to post the Flowfile Records
   */
  public static final String SOLR_UPDATE_PATH_PROPERTY = "Solr Update Path";

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public static final String PUT_SOLR_RECORD_RECORD_READER_PROPERTY = "put-solr-record-record-reader";

  /**
   * Comma-separated list of field names to write
   */
  public static final String FIELDS_TO_INDEX_PROPERTY = "Fields To Index";

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

  /**
   * The number of solr documents to index per batch
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  private final Map<String, String> properties;

  public PutSolrRecord() {
    this.properties = new HashMap<>();
  }

  public PutSolrRecord(final Map<String, String> properties) {
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
  public final PutSolrRecord setSolrType(final String solrType) {
    properties.put(SOLR_TYPE_PROPERTY, solrType);
    return this;
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final PutSolrRecord removeSolrType() {
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
  public final PutSolrRecord setSolrLocation(final String solrLocation) {
    properties.put(SOLR_LOCATION_PROPERTY, solrLocation);
    return this;
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final PutSolrRecord removeSolrLocation() {
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
  public final PutSolrRecord setCollection(final String collection) {
    properties.put(COLLECTION_PROPERTY, collection);
    return this;
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final PutSolrRecord removeCollection() {
    properties.remove(COLLECTION_PROPERTY);
    return this;
  }

  /**
   * The path in Solr to post the Flowfile Records
   */
  public final String getSolrUpdatePath() {
    return properties.get(SOLR_UPDATE_PATH_PROPERTY);
  }

  /**
   * The path in Solr to post the Flowfile Records
   */
  public final PutSolrRecord setSolrUpdatePath(final String solrUpdatePath) {
    properties.put(SOLR_UPDATE_PATH_PROPERTY, solrUpdatePath);
    return this;
  }

  /**
   * The path in Solr to post the Flowfile Records
   */
  public final PutSolrRecord removeSolrUpdatePath() {
    properties.remove(SOLR_UPDATE_PATH_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final String getPutSolrRecordRecordReader() {
    return properties.get(PUT_SOLR_RECORD_RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final PutSolrRecord setPutSolrRecordRecordReader(final String putSolrRecordRecordReader) {
    properties.put(PUT_SOLR_RECORD_RECORD_READER_PROPERTY, putSolrRecordRecordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final PutSolrRecord removePutSolrRecordRecordReader() {
    properties.remove(PUT_SOLR_RECORD_RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of field names to write
   */
  public final String getFieldsToIndex() {
    return properties.get(FIELDS_TO_INDEX_PROPERTY);
  }

  /**
   * Comma-separated list of field names to write
   */
  public final PutSolrRecord setFieldsToIndex(final String fieldsToIndex) {
    properties.put(FIELDS_TO_INDEX_PROPERTY, fieldsToIndex);
    return this;
  }

  /**
   * Comma-separated list of field names to write
   */
  public final PutSolrRecord removeFieldsToIndex() {
    properties.remove(FIELDS_TO_INDEX_PROPERTY);
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
  public final PutSolrRecord setCommitWithin(final String commitWithin) {
    properties.put(COMMIT_WITHIN_PROPERTY, commitWithin);
    return this;
  }

  /**
   * The number of milliseconds before the given update is committed
   */
  public final PutSolrRecord removeCommitWithin() {
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
  public final PutSolrRecord setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PutSolrRecord removeKerberosCredentialsService() {
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
  public final PutSolrRecord setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * The username to use when Solr is configured with basic authentication.
   */
  public final PutSolrRecord removeUsername() {
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
  public final PutSolrRecord setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The password to use when Solr is configured with basic authentication.
   */
  public final PutSolrRecord removePassword() {
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
  public final PutSolrRecord setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final PutSolrRecord removeSslContextService() {
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
  public final PutSolrRecord setSolrSocketTimeout(final String solrSocketTimeout) {
    properties.put(SOLR_SOCKET_TIMEOUT_PROPERTY, solrSocketTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final PutSolrRecord removeSolrSocketTimeout() {
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
  public final PutSolrRecord setSolrConnectionTimeout(final String solrConnectionTimeout) {
    properties.put(SOLR_CONNECTION_TIMEOUT_PROPERTY, solrConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final PutSolrRecord removeSolrConnectionTimeout() {
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
  public final PutSolrRecord setSolrMaximumConnections(final String solrMaximumConnections) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PROPERTY, solrMaximumConnections);
    return this;
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final PutSolrRecord removeSolrMaximumConnections() {
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
  public final PutSolrRecord setSolrMaximumConnectionsPerHost(
      final String solrMaximumConnectionsPerHost) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY, solrMaximumConnectionsPerHost);
    return this;
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final PutSolrRecord removeSolrMaximumConnectionsPerHost() {
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
  public final PutSolrRecord setZooKeeperClientTimeout(final String zooKeeperClientTimeout) {
    properties.put(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY, zooKeeperClientTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final PutSolrRecord removeZooKeeperClientTimeout() {
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
  public final PutSolrRecord setZooKeeperConnectionTimeout(
      final String zooKeeperConnectionTimeout) {
    properties.put(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY, zooKeeperConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final PutSolrRecord removeZooKeeperConnectionTimeout() {
    properties.remove(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The number of solr documents to index per batch
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of solr documents to index per batch
   */
  public final PutSolrRecord setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of solr documents to index per batch
   */
  public final PutSolrRecord removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSolrRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSolrRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutSolrRecord, PutSolrRecord> configurator) {
    return configurator.apply(new PutSolrRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSolrRecord.class) final Closure<PutSolrRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.solr.PutSolrRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.PutSolrRecord.class, com.tibtech.nifi.processors.solr.PutSolrRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutSolrRecord, PutSolrRecord> configurator) {
    return configurator.apply(new PutSolrRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSolrRecord.class) final Closure<PutSolrRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.solr.PutSolrRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.PutSolrRecord.class, com.tibtech.nifi.processors.solr.PutSolrRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
