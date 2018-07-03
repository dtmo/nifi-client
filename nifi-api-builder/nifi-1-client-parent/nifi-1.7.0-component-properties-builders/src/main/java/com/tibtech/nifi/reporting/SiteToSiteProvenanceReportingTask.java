package com.tibtech.nifi.reporting;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SiteToSiteProvenanceReportingTask {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.reporting.SiteToSiteProvenanceReportingTask";

  /**
   * The URL of the destination NiFi instance to send data to, should be a comma-separated list of address in the format of http(s)://host:port/nifi.
   */
  public static final String DESTINATION_URL_PROPERTY = "Destination URL";

  /**
   * The name of the Input Port to deliver data to.
   */
  public static final String INPUT_PORT_NAME_PROPERTY = "Input Port Name";

  /**
   * The SSL Context Service to use when communicating with the destination. If not specified, communications will not be secure.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The URL of this instance to use in the Content URI of each event.
   */
  public static final String INSTANCE_URL_PROPERTY = "Instance URL";

  /**
   * Indicates whether or not to compress the data being sent.
   */
  public static final String COMPRESS_EVENTS_PROPERTY = "Compress Events";

  /**
   * Specifies how long to wait to a response from the destination before deciding that an error has occurred and canceling the transaction
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  /**
   * Specifies how many records to send in a single batch, at most.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Specifies which transport protocol to use for Site-to-Site communication.
   */
  public static final String S_2_S_TRANSPORT_PROTOCOL_PROPERTY = "s2s-transport-protocol";

  /**
   * Specify the proxy server's hostname to use. If not specified, HTTP traffics are sent directly to the target NiFi instance.
   */
  public static final String S_2_S_HTTP_PROXY_HOSTNAME_PROPERTY = "s2s-http-proxy-hostname";

  /**
   * Specify the proxy server's port number, optional. If not specified, default port 80 will be used.
   */
  public static final String S_2_S_HTTP_PROXY_PORT_PROPERTY = "s2s-http-proxy-port";

  /**
   * Specify an user name to connect to the proxy server, optional.
   */
  public static final String S_2_S_HTTP_PROXY_USERNAME_PROPERTY = "s2s-http-proxy-username";

  /**
   * Specify an user password to connect to the proxy server, optional.
   */
  public static final String S_2_S_HTTP_PROXY_PASSWORD_PROPERTY = "s2s-http-proxy-password";

  /**
   * Specifies the Controller Service to use for writing out the records.
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * The value to use for the platform field in each provenance event.
   */
  public static final String PLATFORM_PROPERTY = "Platform";

  /**
   * Comma-separated list of event types that will be used to filter the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public static final String S_2_S_PROV_TASK_EVENT_FILTER_PROPERTY = "s2s-prov-task-event-filter";

  /**
   * Comma-separated list of event types that will be used to exclude the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If an event type is included in Event Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public static final String S_2_S_PROV_TASK_EVENT_FILTER_EXCLUDE_PROPERTY = "s2s-prov-task-event-filter-exclude";

  /**
   * Regular expression to filter the provenance events based on the component type. Only the events matching the regular expression will be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public static final String S_2_S_PROV_TASK_TYPE_FILTER_PROPERTY = "s2s-prov-task-type-filter";

  /**
   * Regular expression to exclude the provenance events based on the component type. The events matching the regular expression will not be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component type is included in Component Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public static final String S_2_S_PROV_TASK_TYPE_FILTER_EXCLUDE_PROPERTY = "s2s-prov-task-type-filter-exclude";

  /**
   * Comma-separated list of component UUID that will be used to filter the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public static final String S_2_S_PROV_TASK_ID_FILTER_PROPERTY = "s2s-prov-task-id-filter";

  /**
   * Comma-separated list of component UUID that will be used to exclude the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component UUID is included in Component ID to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public static final String S_2_S_PROV_TASK_ID_FILTER_EXCLUDE_PROPERTY = "s2s-prov-task-id-filter-exclude";

  /**
   * If the Reporting Task has never been run, or if its state has been reset by a user, specifies where in the stream of Provenance Events the Reporting Task should start
   */
  public static final String START_POSITION_PROPERTY = "start-position";

  private final Map<String, String> properties;

  public SiteToSiteProvenanceReportingTask() {
    this.properties = new HashMap<>();
  }

  public SiteToSiteProvenanceReportingTask(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The URL of the destination NiFi instance to send data to, should be a comma-separated list of address in the format of http(s)://host:port/nifi.
   */
  public final String getDestinationUrl() {
    return properties.get(DESTINATION_URL_PROPERTY);
  }

  /**
   * The URL of the destination NiFi instance to send data to, should be a comma-separated list of address in the format of http(s)://host:port/nifi.
   */
  public final SiteToSiteProvenanceReportingTask setDestinationUrl(final String destinationUrl) {
    properties.put(DESTINATION_URL_PROPERTY, destinationUrl);
    return this;
  }

  /**
   * The URL of the destination NiFi instance to send data to, should be a comma-separated list of address in the format of http(s)://host:port/nifi.
   */
  public final SiteToSiteProvenanceReportingTask removeDestinationUrl() {
    properties.remove(DESTINATION_URL_PROPERTY);
    return this;
  }

  /**
   * The name of the Input Port to deliver data to.
   */
  public final String getInputPortName() {
    return properties.get(INPUT_PORT_NAME_PROPERTY);
  }

  /**
   * The name of the Input Port to deliver data to.
   */
  public final SiteToSiteProvenanceReportingTask setInputPortName(final String inputPortName) {
    properties.put(INPUT_PORT_NAME_PROPERTY, inputPortName);
    return this;
  }

  /**
   * The name of the Input Port to deliver data to.
   */
  public final SiteToSiteProvenanceReportingTask removeInputPortName() {
    properties.remove(INPUT_PORT_NAME_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service to use when communicating with the destination. If not specified, communications will not be secure.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service to use when communicating with the destination. If not specified, communications will not be secure.
   */
  public final SiteToSiteProvenanceReportingTask setSslContextService(
      final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service to use when communicating with the destination. If not specified, communications will not be secure.
   */
  public final SiteToSiteProvenanceReportingTask removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The URL of this instance to use in the Content URI of each event.
   */
  public final String getInstanceUrl() {
    return properties.get(INSTANCE_URL_PROPERTY);
  }

  /**
   * The URL of this instance to use in the Content URI of each event.
   */
  public final SiteToSiteProvenanceReportingTask setInstanceUrl(final String instanceUrl) {
    properties.put(INSTANCE_URL_PROPERTY, instanceUrl);
    return this;
  }

  /**
   * The URL of this instance to use in the Content URI of each event.
   */
  public final SiteToSiteProvenanceReportingTask removeInstanceUrl() {
    properties.remove(INSTANCE_URL_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not to compress the data being sent.
   */
  public final String getCompressEvents() {
    return properties.get(COMPRESS_EVENTS_PROPERTY);
  }

  /**
   * Indicates whether or not to compress the data being sent.
   */
  public final SiteToSiteProvenanceReportingTask setCompressEvents(final String compressEvents) {
    properties.put(COMPRESS_EVENTS_PROPERTY, compressEvents);
    return this;
  }

  /**
   * Indicates whether or not to compress the data being sent.
   */
  public final SiteToSiteProvenanceReportingTask removeCompressEvents() {
    properties.remove(COMPRESS_EVENTS_PROPERTY);
    return this;
  }

  /**
   * Specifies how long to wait to a response from the destination before deciding that an error has occurred and canceling the transaction
   */
  public final String getCommunicationsTimeout() {
    return properties.get(COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   * Specifies how long to wait to a response from the destination before deciding that an error has occurred and canceling the transaction
   */
  public final SiteToSiteProvenanceReportingTask setCommunicationsTimeout(
      final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   * Specifies how long to wait to a response from the destination before deciding that an error has occurred and canceling the transaction
   */
  public final SiteToSiteProvenanceReportingTask removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies how many records to send in a single batch, at most.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * Specifies how many records to send in a single batch, at most.
   */
  public final SiteToSiteProvenanceReportingTask setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * Specifies how many records to send in a single batch, at most.
   */
  public final SiteToSiteProvenanceReportingTask removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies which transport protocol to use for Site-to-Site communication.
   */
  public final String getS2STransportProtocol() {
    return properties.get(S_2_S_TRANSPORT_PROTOCOL_PROPERTY);
  }

  /**
   * Specifies which transport protocol to use for Site-to-Site communication.
   */
  public final SiteToSiteProvenanceReportingTask setS2STransportProtocol(
      final String s2STransportProtocol) {
    properties.put(S_2_S_TRANSPORT_PROTOCOL_PROPERTY, s2STransportProtocol);
    return this;
  }

  /**
   * Specifies which transport protocol to use for Site-to-Site communication.
   */
  public final SiteToSiteProvenanceReportingTask removeS2STransportProtocol() {
    properties.remove(S_2_S_TRANSPORT_PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * Specify the proxy server's hostname to use. If not specified, HTTP traffics are sent directly to the target NiFi instance.
   */
  public final String getS2SHttpProxyHostname() {
    return properties.get(S_2_S_HTTP_PROXY_HOSTNAME_PROPERTY);
  }

  /**
   * Specify the proxy server's hostname to use. If not specified, HTTP traffics are sent directly to the target NiFi instance.
   */
  public final SiteToSiteProvenanceReportingTask setS2SHttpProxyHostname(
      final String s2SHttpProxyHostname) {
    properties.put(S_2_S_HTTP_PROXY_HOSTNAME_PROPERTY, s2SHttpProxyHostname);
    return this;
  }

  /**
   * Specify the proxy server's hostname to use. If not specified, HTTP traffics are sent directly to the target NiFi instance.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SHttpProxyHostname() {
    properties.remove(S_2_S_HTTP_PROXY_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * Specify the proxy server's port number, optional. If not specified, default port 80 will be used.
   */
  public final String getS2SHttpProxyPort() {
    return properties.get(S_2_S_HTTP_PROXY_PORT_PROPERTY);
  }

  /**
   * Specify the proxy server's port number, optional. If not specified, default port 80 will be used.
   */
  public final SiteToSiteProvenanceReportingTask setS2SHttpProxyPort(
      final String s2SHttpProxyPort) {
    properties.put(S_2_S_HTTP_PROXY_PORT_PROPERTY, s2SHttpProxyPort);
    return this;
  }

  /**
   * Specify the proxy server's port number, optional. If not specified, default port 80 will be used.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SHttpProxyPort() {
    properties.remove(S_2_S_HTTP_PROXY_PORT_PROPERTY);
    return this;
  }

  /**
   * Specify an user name to connect to the proxy server, optional.
   */
  public final String getS2SHttpProxyUsername() {
    return properties.get(S_2_S_HTTP_PROXY_USERNAME_PROPERTY);
  }

  /**
   * Specify an user name to connect to the proxy server, optional.
   */
  public final SiteToSiteProvenanceReportingTask setS2SHttpProxyUsername(
      final String s2SHttpProxyUsername) {
    properties.put(S_2_S_HTTP_PROXY_USERNAME_PROPERTY, s2SHttpProxyUsername);
    return this;
  }

  /**
   * Specify an user name to connect to the proxy server, optional.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SHttpProxyUsername() {
    properties.remove(S_2_S_HTTP_PROXY_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Specify an user password to connect to the proxy server, optional.
   */
  public final String getS2SHttpProxyPassword() {
    return properties.get(S_2_S_HTTP_PROXY_PASSWORD_PROPERTY);
  }

  /**
   * Specify an user password to connect to the proxy server, optional.
   */
  public final SiteToSiteProvenanceReportingTask setS2SHttpProxyPassword(
      final String s2SHttpProxyPassword) {
    properties.put(S_2_S_HTTP_PROXY_PASSWORD_PROPERTY, s2SHttpProxyPassword);
    return this;
  }

  /**
   * Specify an user password to connect to the proxy server, optional.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SHttpProxyPassword() {
    properties.remove(S_2_S_HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records.
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for writing out the records.
   */
  public final SiteToSiteProvenanceReportingTask setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records.
   */
  public final SiteToSiteProvenanceReportingTask removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * The value to use for the platform field in each provenance event.
   */
  public final String getPlatform() {
    return properties.get(PLATFORM_PROPERTY);
  }

  /**
   * The value to use for the platform field in each provenance event.
   */
  public final SiteToSiteProvenanceReportingTask setPlatform(final String platform) {
    properties.put(PLATFORM_PROPERTY, platform);
    return this;
  }

  /**
   * The value to use for the platform field in each provenance event.
   */
  public final SiteToSiteProvenanceReportingTask removePlatform() {
    properties.remove(PLATFORM_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of event types that will be used to filter the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final String getS2SProvTaskEventFilter() {
    return properties.get(S_2_S_PROV_TASK_EVENT_FILTER_PROPERTY);
  }

  /**
   * Comma-separated list of event types that will be used to filter the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final SiteToSiteProvenanceReportingTask setS2SProvTaskEventFilter(
      final String s2SProvTaskEventFilter) {
    properties.put(S_2_S_PROV_TASK_EVENT_FILTER_PROPERTY, s2SProvTaskEventFilter);
    return this;
  }

  /**
   * Comma-separated list of event types that will be used to filter the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SProvTaskEventFilter() {
    properties.remove(S_2_S_PROV_TASK_EVENT_FILTER_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of event types that will be used to exclude the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If an event type is included in Event Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final String getS2SProvTaskEventFilterExclude() {
    return properties.get(S_2_S_PROV_TASK_EVENT_FILTER_EXCLUDE_PROPERTY);
  }

  /**
   * Comma-separated list of event types that will be used to exclude the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If an event type is included in Event Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final SiteToSiteProvenanceReportingTask setS2SProvTaskEventFilterExclude(
      final String s2SProvTaskEventFilterExclude) {
    properties.put(S_2_S_PROV_TASK_EVENT_FILTER_EXCLUDE_PROPERTY, s2SProvTaskEventFilterExclude);
    return this;
  }

  /**
   * Comma-separated list of event types that will be used to exclude the provenance events sent by the reporting task. Available event types are [CREATE, RECEIVE, FETCH, SEND, REMOTE_INVOCATION, DOWNLOAD, DROP, EXPIRE, FORK, JOIN, CLONE, CONTENT_MODIFIED, ATTRIBUTES_MODIFIED, ROUTE, ADDINFO, REPLAY, UNKNOWN]. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If an event type is included in Event Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SProvTaskEventFilterExclude() {
    properties.remove(S_2_S_PROV_TASK_EVENT_FILTER_EXCLUDE_PROPERTY);
    return this;
  }

  /**
   * Regular expression to filter the provenance events based on the component type. Only the events matching the regular expression will be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final String getS2SProvTaskTypeFilter() {
    return properties.get(S_2_S_PROV_TASK_TYPE_FILTER_PROPERTY);
  }

  /**
   * Regular expression to filter the provenance events based on the component type. Only the events matching the regular expression will be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final SiteToSiteProvenanceReportingTask setS2SProvTaskTypeFilter(
      final String s2SProvTaskTypeFilter) {
    properties.put(S_2_S_PROV_TASK_TYPE_FILTER_PROPERTY, s2SProvTaskTypeFilter);
    return this;
  }

  /**
   * Regular expression to filter the provenance events based on the component type. Only the events matching the regular expression will be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SProvTaskTypeFilter() {
    properties.remove(S_2_S_PROV_TASK_TYPE_FILTER_PROPERTY);
    return this;
  }

  /**
   * Regular expression to exclude the provenance events based on the component type. The events matching the regular expression will not be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component type is included in Component Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final String getS2SProvTaskTypeFilterExclude() {
    return properties.get(S_2_S_PROV_TASK_TYPE_FILTER_EXCLUDE_PROPERTY);
  }

  /**
   * Regular expression to exclude the provenance events based on the component type. The events matching the regular expression will not be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component type is included in Component Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final SiteToSiteProvenanceReportingTask setS2SProvTaskTypeFilterExclude(
      final String s2SProvTaskTypeFilterExclude) {
    properties.put(S_2_S_PROV_TASK_TYPE_FILTER_EXCLUDE_PROPERTY, s2SProvTaskTypeFilterExclude);
    return this;
  }

  /**
   * Regular expression to exclude the provenance events based on the component type. The events matching the regular expression will not be sent. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component type is included in Component Type to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SProvTaskTypeFilterExclude() {
    properties.remove(S_2_S_PROV_TASK_TYPE_FILTER_EXCLUDE_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of component UUID that will be used to filter the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final String getS2SProvTaskIdFilter() {
    return properties.get(S_2_S_PROV_TASK_ID_FILTER_PROPERTY);
  }

  /**
   * Comma-separated list of component UUID that will be used to filter the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final SiteToSiteProvenanceReportingTask setS2SProvTaskIdFilter(
      final String s2SProvTaskIdFilter) {
    properties.put(S_2_S_PROV_TASK_ID_FILTER_PROPERTY, s2SProvTaskIdFilter);
    return this;
  }

  /**
   * Comma-separated list of component UUID that will be used to filter the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SProvTaskIdFilter() {
    properties.remove(S_2_S_PROV_TASK_ID_FILTER_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of component UUID that will be used to exclude the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component UUID is included in Component ID to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final String getS2SProvTaskIdFilterExclude() {
    return properties.get(S_2_S_PROV_TASK_ID_FILTER_EXCLUDE_PROPERTY);
  }

  /**
   * Comma-separated list of component UUID that will be used to exclude the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component UUID is included in Component ID to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final SiteToSiteProvenanceReportingTask setS2SProvTaskIdFilterExclude(
      final String s2SProvTaskIdFilterExclude) {
    properties.put(S_2_S_PROV_TASK_ID_FILTER_EXCLUDE_PROPERTY, s2SProvTaskIdFilterExclude);
    return this;
  }

  /**
   * Comma-separated list of component UUID that will be used to exclude the provenance events sent by the reporting task. If no filter is set, all the events are sent. If multiple filters are set, the filters are cumulative. If a component UUID is included in Component ID to Include and excluded here, then the exclusion takes precedence and the event will not be sent.
   */
  public final SiteToSiteProvenanceReportingTask removeS2SProvTaskIdFilterExclude() {
    properties.remove(S_2_S_PROV_TASK_ID_FILTER_EXCLUDE_PROPERTY);
    return this;
  }

  /**
   * If the Reporting Task has never been run, or if its state has been reset by a user, specifies where in the stream of Provenance Events the Reporting Task should start
   */
  public final String getStartPosition() {
    return properties.get(START_POSITION_PROPERTY);
  }

  /**
   * If the Reporting Task has never been run, or if its state has been reset by a user, specifies where in the stream of Provenance Events the Reporting Task should start
   */
  public final SiteToSiteProvenanceReportingTask setStartPosition(final String startPosition) {
    properties.put(START_POSITION_PROPERTY, startPosition);
    return this;
  }

  /**
   * If the Reporting Task has never been run, or if its state has been reset by a user, specifies where in the stream of Provenance Events the Reporting Task should start
   */
  public final SiteToSiteProvenanceReportingTask removeStartPosition() {
    properties.remove(START_POSITION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SiteToSiteProvenanceReportingTask setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final SiteToSiteProvenanceReportingTask removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<SiteToSiteProvenanceReportingTask, SiteToSiteProvenanceReportingTask> configurator) {
    return configurator.apply(new SiteToSiteProvenanceReportingTask()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SiteToSiteProvenanceReportingTask.class) final Closure<SiteToSiteProvenanceReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask.class, com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SiteToSiteProvenanceReportingTask, SiteToSiteProvenanceReportingTask> configurator) {
    return configurator.apply(new SiteToSiteProvenanceReportingTask(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SiteToSiteProvenanceReportingTask.class) final Closure<SiteToSiteProvenanceReportingTask> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask.class, com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
