package com.tibtech.nifi.reporting;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SiteToSiteProvenanceReportingTask {
  /**
   * The URL of the destination NiFi instance to send the Provenance Events to, should be in the format http(s)://host:port/nifi.
   */
  public static final String DESTINATION_URL_PROPERTY = "Destination URL";

  /**
   * The name of the Input Port to delivery Provenance Events to.
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
   * Indicates whether or not to compress the events when being sent.
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
   * The value to use for the platform field in each provenance event.
   */
  public static final String PLATFORM_PROPERTY = "Platform";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The URL of the destination NiFi instance to send the Provenance Events to, should be in the format http(s)://host:port/nifi.
   */
  public final String getDestinationUrl() {
    return properties.get(DESTINATION_URL_PROPERTY);
  }

  /**
   * The URL of the destination NiFi instance to send the Provenance Events to, should be in the format http(s)://host:port/nifi.
   */
  public final SiteToSiteProvenanceReportingTask setDestinationUrl(final String destinationUrl) {
    properties.put(DESTINATION_URL_PROPERTY, destinationUrl);
    return this;
  }

  /**
   * The URL of the destination NiFi instance to send the Provenance Events to, should be in the format http(s)://host:port/nifi.
   */
  public final SiteToSiteProvenanceReportingTask removeDestinationUrl() {
    properties.remove(DESTINATION_URL_PROPERTY);
    return this;
  }

  /**
   * The name of the Input Port to delivery Provenance Events to.
   */
  public final String getInputPortName() {
    return properties.get(INPUT_PORT_NAME_PROPERTY);
  }

  /**
   * The name of the Input Port to delivery Provenance Events to.
   */
  public final SiteToSiteProvenanceReportingTask setInputPortName(final String inputPortName) {
    properties.put(INPUT_PORT_NAME_PROPERTY, inputPortName);
    return this;
  }

  /**
   * The name of the Input Port to delivery Provenance Events to.
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
  public final SiteToSiteProvenanceReportingTask setSslContextService(final String sslContextService) {
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
   * Indicates whether or not to compress the events when being sent.
   */
  public final String getCompressEvents() {
    return properties.get(COMPRESS_EVENTS_PROPERTY);
  }

  /**
   * Indicates whether or not to compress the events when being sent.
   */
  public final SiteToSiteProvenanceReportingTask setCompressEvents(final String compressEvents) {
    properties.put(COMPRESS_EVENTS_PROPERTY, compressEvents);
    return this;
  }

  /**
   * Indicates whether or not to compress the events when being sent.
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
  public final SiteToSiteProvenanceReportingTask setCommunicationsTimeout(final String communicationsTimeout) {
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

  public static final Map<String, String> build(final Function<SiteToSiteProvenanceReportingTask, SiteToSiteProvenanceReportingTask> configurator) {
    return configurator.apply(new SiteToSiteProvenanceReportingTask()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SiteToSiteProvenanceReportingTask.class) final Closure<SiteToSiteProvenanceReportingTask> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask> code = closure.rehydrate(c, com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask.class, com.tibtech.nifi.reporting.SiteToSiteProvenanceReportingTask.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
