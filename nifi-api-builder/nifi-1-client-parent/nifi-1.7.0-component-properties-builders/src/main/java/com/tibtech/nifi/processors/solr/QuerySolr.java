package com.tibtech.nifi.processors.solr;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QuerySolr {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.solr.QuerySolr";

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
   * Output format of Solr results. Write Solr documents to FlowFiles as XML or using a Record Writer
   */
  public static final String RETURN_TYPE_PROPERTY = "return_type";

  /**
   * The Record Writer to use in order to write Solr documents to FlowFiles. Must be set if "Records" is used as return type.
   */
  public static final String RECORD_WRITER_PROPERTY = "Record Writer";

  /**
   * Solr Query, e. g. field:value
   */
  public static final String SOLR_PARAM_QUERY_PROPERTY = "solr_param_query";

  /**
   * Define a request handler here, e. g. /query
   */
  public static final String SOLR_PARAM_REQUEST_HANDLER_PROPERTY = "solr_param_request_handler";

  /**
   * Comma separated list of fields to be included into results, e. g. field1,field2
   */
  public static final String SOLR_PARAM_FIELD_LIST_PROPERTY = "solr_param_field_list";

  /**
   * Comma separated sort clauses to define the sorting of results, e. g. field1 asc, field2 desc
   */
  public static final String SOLR_PARAM_SORT_PROPERTY = "solr_param_sort";

  /**
   * Offset of result set
   */
  public static final String SOLR_PARAM_START_PROPERTY = "solr_param_start";

  /**
   * Number of results to be returned for a single request
   */
  public static final String SOLR_PARAM_ROWS_PROPERTY = "solr_param_rows";

  /**
   * Total amount of Solr documents to be returned. If this property is set to "Only top results", only single requests will be sent to Solr and the results will be written into single FlowFiles. If it is set to "Entire results", all results matching to the query are retrieved via multiple Solr requests and returned in multiple FlowFiles. For both options, the number of Solr documents to be returned in a FlowFile depends on the configuration of the "Rows" property
   */
  public static final String AMOUNT_DOCUMENTS_TO_RETURN_PROPERTY = "amount_documents_to_return";

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

  public QuerySolr() {
    this.properties = new HashMap<>();
  }

  public QuerySolr(final Map<String, String> properties) {
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
  public final QuerySolr setSolrType(final String solrType) {
    properties.put(SOLR_TYPE_PROPERTY, solrType);
    return this;
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final QuerySolr removeSolrType() {
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
  public final QuerySolr setSolrLocation(final String solrLocation) {
    properties.put(SOLR_LOCATION_PROPERTY, solrLocation);
    return this;
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final QuerySolr removeSolrLocation() {
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
  public final QuerySolr setCollection(final String collection) {
    properties.put(COLLECTION_PROPERTY, collection);
    return this;
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final QuerySolr removeCollection() {
    properties.remove(COLLECTION_PROPERTY);
    return this;
  }

  /**
   * Output format of Solr results. Write Solr documents to FlowFiles as XML or using a Record Writer
   */
  public final String getReturnType() {
    return properties.get(RETURN_TYPE_PROPERTY);
  }

  /**
   * Output format of Solr results. Write Solr documents to FlowFiles as XML or using a Record Writer
   */
  public final QuerySolr setReturnType(final String returnType) {
    properties.put(RETURN_TYPE_PROPERTY, returnType);
    return this;
  }

  /**
   * Output format of Solr results. Write Solr documents to FlowFiles as XML or using a Record Writer
   */
  public final QuerySolr removeReturnType() {
    properties.remove(RETURN_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Record Writer to use in order to write Solr documents to FlowFiles. Must be set if "Records" is used as return type.
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * The Record Writer to use in order to write Solr documents to FlowFiles. Must be set if "Records" is used as return type.
   */
  public final QuerySolr setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * The Record Writer to use in order to write Solr documents to FlowFiles. Must be set if "Records" is used as return type.
   */
  public final QuerySolr removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Solr Query, e. g. field:value
   */
  public final String getSolrParamQuery() {
    return properties.get(SOLR_PARAM_QUERY_PROPERTY);
  }

  /**
   * Solr Query, e. g. field:value
   */
  public final QuerySolr setSolrParamQuery(final String solrParamQuery) {
    properties.put(SOLR_PARAM_QUERY_PROPERTY, solrParamQuery);
    return this;
  }

  /**
   * Solr Query, e. g. field:value
   */
  public final QuerySolr removeSolrParamQuery() {
    properties.remove(SOLR_PARAM_QUERY_PROPERTY);
    return this;
  }

  /**
   * Define a request handler here, e. g. /query
   */
  public final String getSolrParamRequestHandler() {
    return properties.get(SOLR_PARAM_REQUEST_HANDLER_PROPERTY);
  }

  /**
   * Define a request handler here, e. g. /query
   */
  public final QuerySolr setSolrParamRequestHandler(final String solrParamRequestHandler) {
    properties.put(SOLR_PARAM_REQUEST_HANDLER_PROPERTY, solrParamRequestHandler);
    return this;
  }

  /**
   * Define a request handler here, e. g. /query
   */
  public final QuerySolr removeSolrParamRequestHandler() {
    properties.remove(SOLR_PARAM_REQUEST_HANDLER_PROPERTY);
    return this;
  }

  /**
   * Comma separated list of fields to be included into results, e. g. field1,field2
   */
  public final String getSolrParamFieldList() {
    return properties.get(SOLR_PARAM_FIELD_LIST_PROPERTY);
  }

  /**
   * Comma separated list of fields to be included into results, e. g. field1,field2
   */
  public final QuerySolr setSolrParamFieldList(final String solrParamFieldList) {
    properties.put(SOLR_PARAM_FIELD_LIST_PROPERTY, solrParamFieldList);
    return this;
  }

  /**
   * Comma separated list of fields to be included into results, e. g. field1,field2
   */
  public final QuerySolr removeSolrParamFieldList() {
    properties.remove(SOLR_PARAM_FIELD_LIST_PROPERTY);
    return this;
  }

  /**
   * Comma separated sort clauses to define the sorting of results, e. g. field1 asc, field2 desc
   */
  public final String getSolrParamSort() {
    return properties.get(SOLR_PARAM_SORT_PROPERTY);
  }

  /**
   * Comma separated sort clauses to define the sorting of results, e. g. field1 asc, field2 desc
   */
  public final QuerySolr setSolrParamSort(final String solrParamSort) {
    properties.put(SOLR_PARAM_SORT_PROPERTY, solrParamSort);
    return this;
  }

  /**
   * Comma separated sort clauses to define the sorting of results, e. g. field1 asc, field2 desc
   */
  public final QuerySolr removeSolrParamSort() {
    properties.remove(SOLR_PARAM_SORT_PROPERTY);
    return this;
  }

  /**
   * Offset of result set
   */
  public final String getSolrParamStart() {
    return properties.get(SOLR_PARAM_START_PROPERTY);
  }

  /**
   * Offset of result set
   */
  public final QuerySolr setSolrParamStart(final String solrParamStart) {
    properties.put(SOLR_PARAM_START_PROPERTY, solrParamStart);
    return this;
  }

  /**
   * Offset of result set
   */
  public final QuerySolr removeSolrParamStart() {
    properties.remove(SOLR_PARAM_START_PROPERTY);
    return this;
  }

  /**
   * Number of results to be returned for a single request
   */
  public final String getSolrParamRows() {
    return properties.get(SOLR_PARAM_ROWS_PROPERTY);
  }

  /**
   * Number of results to be returned for a single request
   */
  public final QuerySolr setSolrParamRows(final String solrParamRows) {
    properties.put(SOLR_PARAM_ROWS_PROPERTY, solrParamRows);
    return this;
  }

  /**
   * Number of results to be returned for a single request
   */
  public final QuerySolr removeSolrParamRows() {
    properties.remove(SOLR_PARAM_ROWS_PROPERTY);
    return this;
  }

  /**
   * Total amount of Solr documents to be returned. If this property is set to "Only top results", only single requests will be sent to Solr and the results will be written into single FlowFiles. If it is set to "Entire results", all results matching to the query are retrieved via multiple Solr requests and returned in multiple FlowFiles. For both options, the number of Solr documents to be returned in a FlowFile depends on the configuration of the "Rows" property
   */
  public final String getAmountDocumentsToReturn() {
    return properties.get(AMOUNT_DOCUMENTS_TO_RETURN_PROPERTY);
  }

  /**
   * Total amount of Solr documents to be returned. If this property is set to "Only top results", only single requests will be sent to Solr and the results will be written into single FlowFiles. If it is set to "Entire results", all results matching to the query are retrieved via multiple Solr requests and returned in multiple FlowFiles. For both options, the number of Solr documents to be returned in a FlowFile depends on the configuration of the "Rows" property
   */
  public final QuerySolr setAmountDocumentsToReturn(final String amountDocumentsToReturn) {
    properties.put(AMOUNT_DOCUMENTS_TO_RETURN_PROPERTY, amountDocumentsToReturn);
    return this;
  }

  /**
   * Total amount of Solr documents to be returned. If this property is set to "Only top results", only single requests will be sent to Solr and the results will be written into single FlowFiles. If it is set to "Entire results", all results matching to the query are retrieved via multiple Solr requests and returned in multiple FlowFiles. For both options, the number of Solr documents to be returned in a FlowFile depends on the configuration of the "Rows" property
   */
  public final QuerySolr removeAmountDocumentsToReturn() {
    properties.remove(AMOUNT_DOCUMENTS_TO_RETURN_PROPERTY);
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
  public final QuerySolr setKerberosCredentialsService(final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final QuerySolr removeKerberosCredentialsService() {
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
  public final QuerySolr setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * The username to use when Solr is configured with basic authentication.
   */
  public final QuerySolr removeUsername() {
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
  public final QuerySolr setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The password to use when Solr is configured with basic authentication.
   */
  public final QuerySolr removePassword() {
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
  public final QuerySolr setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final QuerySolr removeSslContextService() {
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
  public final QuerySolr setSolrSocketTimeout(final String solrSocketTimeout) {
    properties.put(SOLR_SOCKET_TIMEOUT_PROPERTY, solrSocketTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final QuerySolr removeSolrSocketTimeout() {
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
  public final QuerySolr setSolrConnectionTimeout(final String solrConnectionTimeout) {
    properties.put(SOLR_CONNECTION_TIMEOUT_PROPERTY, solrConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final QuerySolr removeSolrConnectionTimeout() {
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
  public final QuerySolr setSolrMaximumConnections(final String solrMaximumConnections) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PROPERTY, solrMaximumConnections);
    return this;
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final QuerySolr removeSolrMaximumConnections() {
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
  public final QuerySolr setSolrMaximumConnectionsPerHost(
      final String solrMaximumConnectionsPerHost) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY, solrMaximumConnectionsPerHost);
    return this;
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final QuerySolr removeSolrMaximumConnectionsPerHost() {
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
  public final QuerySolr setZooKeeperClientTimeout(final String zooKeeperClientTimeout) {
    properties.put(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY, zooKeeperClientTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final QuerySolr removeZooKeeperClientTimeout() {
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
  public final QuerySolr setZooKeeperConnectionTimeout(final String zooKeeperConnectionTimeout) {
    properties.put(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY, zooKeeperConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final QuerySolr removeZooKeeperConnectionTimeout() {
    properties.remove(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QuerySolr setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QuerySolr removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<QuerySolr, QuerySolr> configurator) {
    return configurator.apply(new QuerySolr()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QuerySolr.class) final Closure<QuerySolr> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.solr.QuerySolr> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.QuerySolr.class, com.tibtech.nifi.processors.solr.QuerySolr.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<QuerySolr, QuerySolr> configurator) {
    return configurator.apply(new QuerySolr(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QuerySolr.class) final Closure<QuerySolr> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.solr.QuerySolr> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.QuerySolr.class, com.tibtech.nifi.processors.solr.QuerySolr.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
