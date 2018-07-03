package com.tibtech.nifi.reporting;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SiteToSiteStatusReportingTask {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.reporting.SiteToSiteStatusReportingTask";

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
   * The value to use for the platform field in each status record.
   */
  public static final String PLATFORM_PROPERTY = "Platform";

  /**
   * A regex specifying which component types to report.  Any component type matching this regex will be included.  Component types are: Processor, RootProcessGroup, ProcessGroup, RemoteProcessGroup, Connection, InputPort, OutputPort
   */
  public static final String COMPONENT_TYPE_FILTER_REGEX_PROPERTY = "Component Type Filter Regex";

  /**
   * A regex specifying which component names to report.  Any component name matching this regex will be included.
   */
  public static final String COMPONENT_NAME_FILTER_REGEX_PROPERTY = "Component Name Filter Regex";

  private final Map<String, String> properties;

  public SiteToSiteStatusReportingTask() {
    this.properties = new HashMap<>();
  }

  public SiteToSiteStatusReportingTask(final Map<String, String> properties) {
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
  public final SiteToSiteStatusReportingTask setDestinationUrl(final String destinationUrl) {
    properties.put(DESTINATION_URL_PROPERTY, destinationUrl);
    return this;
  }

  /**
   * The URL of the destination NiFi instance to send data to, should be a comma-separated list of address in the format of http(s)://host:port/nifi.
   */
  public final SiteToSiteStatusReportingTask removeDestinationUrl() {
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
  public final SiteToSiteStatusReportingTask setInputPortName(final String inputPortName) {
    properties.put(INPUT_PORT_NAME_PROPERTY, inputPortName);
    return this;
  }

  /**
   * The name of the Input Port to deliver data to.
   */
  public final SiteToSiteStatusReportingTask removeInputPortName() {
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
  public final SiteToSiteStatusReportingTask setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service to use when communicating with the destination. If not specified, communications will not be secure.
   */
  public final SiteToSiteStatusReportingTask removeSslContextService() {
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
  public final SiteToSiteStatusReportingTask setInstanceUrl(final String instanceUrl) {
    properties.put(INSTANCE_URL_PROPERTY, instanceUrl);
    return this;
  }

  /**
   * The URL of this instance to use in the Content URI of each event.
   */
  public final SiteToSiteStatusReportingTask removeInstanceUrl() {
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
  public final SiteToSiteStatusReportingTask setCompressEvents(final String compressEvents) {
    properties.put(COMPRESS_EVENTS_PROPERTY, compressEvents);
    return this;
  }

  /**
   * Indicates whether or not to compress the data being sent.
   */
  public final SiteToSiteStatusReportingTask removeCompressEvents() {
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
  public final SiteToSiteStatusReportingTask setCommunicationsTimeout(
      final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   * Specifies how long to wait to a response from the destination before deciding that an error has occurred and canceling the transaction
   */
  public final SiteToSiteStatusReportingTask removeCommunicationsTimeout() {
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
  public final SiteToSiteStatusReportingTask setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * Specifies how many records to send in a single batch, at most.
   */
  public final SiteToSiteStatusReportingTask removeBatchSize() {
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
  public final SiteToSiteStatusReportingTask setS2STransportProtocol(
      final String s2STransportProtocol) {
    properties.put(S_2_S_TRANSPORT_PROTOCOL_PROPERTY, s2STransportProtocol);
    return this;
  }

  /**
   * Specifies which transport protocol to use for Site-to-Site communication.
   */
  public final SiteToSiteStatusReportingTask removeS2STransportProtocol() {
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
  public final SiteToSiteStatusReportingTask setS2SHttpProxyHostname(
      final String s2SHttpProxyHostname) {
    properties.put(S_2_S_HTTP_PROXY_HOSTNAME_PROPERTY, s2SHttpProxyHostname);
    return this;
  }

  /**
   * Specify the proxy server's hostname to use. If not specified, HTTP traffics are sent directly to the target NiFi instance.
   */
  public final SiteToSiteStatusReportingTask removeS2SHttpProxyHostname() {
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
  public final SiteToSiteStatusReportingTask setS2SHttpProxyPort(final String s2SHttpProxyPort) {
    properties.put(S_2_S_HTTP_PROXY_PORT_PROPERTY, s2SHttpProxyPort);
    return this;
  }

  /**
   * Specify the proxy server's port number, optional. If not specified, default port 80 will be used.
   */
  public final SiteToSiteStatusReportingTask removeS2SHttpProxyPort() {
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
  public final SiteToSiteStatusReportingTask setS2SHttpProxyUsername(
      final String s2SHttpProxyUsername) {
    properties.put(S_2_S_HTTP_PROXY_USERNAME_PROPERTY, s2SHttpProxyUsername);
    return this;
  }

  /**
   * Specify an user name to connect to the proxy server, optional.
   */
  public final SiteToSiteStatusReportingTask removeS2SHttpProxyUsername() {
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
  public final SiteToSiteStatusReportingTask setS2SHttpProxyPassword(
      final String s2SHttpProxyPassword) {
    properties.put(S_2_S_HTTP_PROXY_PASSWORD_PROPERTY, s2SHttpProxyPassword);
    return this;
  }

  /**
   * Specify an user password to connect to the proxy server, optional.
   */
  public final SiteToSiteStatusReportingTask removeS2SHttpProxyPassword() {
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
  public final SiteToSiteStatusReportingTask setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records.
   */
  public final SiteToSiteStatusReportingTask removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * The value to use for the platform field in each status record.
   */
  public final String getPlatform() {
    return properties.get(PLATFORM_PROPERTY);
  }

  /**
   * The value to use for the platform field in each status record.
   */
  public final SiteToSiteStatusReportingTask setPlatform(final String platform) {
    properties.put(PLATFORM_PROPERTY, platform);
    return this;
  }

  /**
   * The value to use for the platform field in each status record.
   */
  public final SiteToSiteStatusReportingTask removePlatform() {
    properties.remove(PLATFORM_PROPERTY);
    return this;
  }

  /**
   * A regex specifying which component types to report.  Any component type matching this regex will be included.  Component types are: Processor, RootProcessGroup, ProcessGroup, RemoteProcessGroup, Connection, InputPort, OutputPort
   */
  public final String getComponentTypeFilterRegex() {
    return properties.get(COMPONENT_TYPE_FILTER_REGEX_PROPERTY);
  }

  /**
   * A regex specifying which component types to report.  Any component type matching this regex will be included.  Component types are: Processor, RootProcessGroup, ProcessGroup, RemoteProcessGroup, Connection, InputPort, OutputPort
   */
  public final SiteToSiteStatusReportingTask setComponentTypeFilterRegex(
      final String componentTypeFilterRegex) {
    properties.put(COMPONENT_TYPE_FILTER_REGEX_PROPERTY, componentTypeFilterRegex);
    return this;
  }

  /**
   * A regex specifying which component types to report.  Any component type matching this regex will be included.  Component types are: Processor, RootProcessGroup, ProcessGroup, RemoteProcessGroup, Connection, InputPort, OutputPort
   */
  public final SiteToSiteStatusReportingTask removeComponentTypeFilterRegex() {
    properties.remove(COMPONENT_TYPE_FILTER_REGEX_PROPERTY);
    return this;
  }

  /**
   * A regex specifying which component names to report.  Any component name matching this regex will be included.
   */
  public final String getComponentNameFilterRegex() {
    return properties.get(COMPONENT_NAME_FILTER_REGEX_PROPERTY);
  }

  /**
   * A regex specifying which component names to report.  Any component name matching this regex will be included.
   */
  public final SiteToSiteStatusReportingTask setComponentNameFilterRegex(
      final String componentNameFilterRegex) {
    properties.put(COMPONENT_NAME_FILTER_REGEX_PROPERTY, componentNameFilterRegex);
    return this;
  }

  /**
   * A regex specifying which component names to report.  Any component name matching this regex will be included.
   */
  public final SiteToSiteStatusReportingTask removeComponentNameFilterRegex() {
    properties.remove(COMPONENT_NAME_FILTER_REGEX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SiteToSiteStatusReportingTask setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final SiteToSiteStatusReportingTask removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<SiteToSiteStatusReportingTask, SiteToSiteStatusReportingTask> configurator) {
    return configurator.apply(new SiteToSiteStatusReportingTask()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SiteToSiteStatusReportingTask.class) final Closure<SiteToSiteStatusReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.reporting.SiteToSiteStatusReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.SiteToSiteStatusReportingTask.class, com.tibtech.nifi.reporting.SiteToSiteStatusReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SiteToSiteStatusReportingTask, SiteToSiteStatusReportingTask> configurator) {
    return configurator.apply(new SiteToSiteStatusReportingTask(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SiteToSiteStatusReportingTask.class) final Closure<SiteToSiteStatusReportingTask> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.reporting.SiteToSiteStatusReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.SiteToSiteStatusReportingTask.class, com.tibtech.nifi.reporting.SiteToSiteStatusReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
