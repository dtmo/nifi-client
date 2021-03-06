package com.tibtech.nifi.processors.gcp.pubsub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PublishGCPubSub {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.gcp.pubsub.PublishGCPubSub";

  /**
   * Google Cloud Project ID
   */
  public static final String GCP_PROJECT_ID_PROPERTY = "gcp-project-id";

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public static final String GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY = "GCP Credentials Provider Service";

  /**
   * Name of the Google Cloud PubSub Topic
   */
  public static final String GCP_PUBSUB_TOPIC_PROPERTY = "gcp-pubsub-topic";

  /**
   * Indicates the number of messages the cloud service should bundle together in a batch. If not set and left empty, only one message will be used in a batch
   */
  public static final String GCP_PUBSUB_PUBLISH_BATCH_SIZE_PROPERTY = "gcp-pubsub-publish-batch-size";

  private final Map<String, String> properties;

  public PublishGCPubSub() {
    this.properties = new HashMap<>();
  }

  public PublishGCPubSub(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Google Cloud Project ID
   */
  public final String getGcpProjectId() {
    return properties.get(GCP_PROJECT_ID_PROPERTY);
  }

  /**
   * Google Cloud Project ID
   */
  public final PublishGCPubSub setGcpProjectId(final String gcpProjectId) {
    properties.put(GCP_PROJECT_ID_PROPERTY, gcpProjectId);
    return this;
  }

  /**
   * Google Cloud Project ID
   */
  public final PublishGCPubSub removeGcpProjectId() {
    properties.remove(GCP_PROJECT_ID_PROPERTY);
    return this;
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final String getGcpCredentialsProviderService() {
    return properties.get(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final PublishGCPubSub setGcpCredentialsProviderService(
      final String gcpCredentialsProviderService) {
    properties.put(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, gcpCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final PublishGCPubSub removeGcpCredentialsProviderService() {
    properties.remove(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Name of the Google Cloud PubSub Topic
   */
  public final String getGcpPubsubTopic() {
    return properties.get(GCP_PUBSUB_TOPIC_PROPERTY);
  }

  /**
   * Name of the Google Cloud PubSub Topic
   */
  public final PublishGCPubSub setGcpPubsubTopic(final String gcpPubsubTopic) {
    properties.put(GCP_PUBSUB_TOPIC_PROPERTY, gcpPubsubTopic);
    return this;
  }

  /**
   * Name of the Google Cloud PubSub Topic
   */
  public final PublishGCPubSub removeGcpPubsubTopic() {
    properties.remove(GCP_PUBSUB_TOPIC_PROPERTY);
    return this;
  }

  /**
   * Indicates the number of messages the cloud service should bundle together in a batch. If not set and left empty, only one message will be used in a batch
   */
  public final String getGcpPubsubPublishBatchSize() {
    return properties.get(GCP_PUBSUB_PUBLISH_BATCH_SIZE_PROPERTY);
  }

  /**
   * Indicates the number of messages the cloud service should bundle together in a batch. If not set and left empty, only one message will be used in a batch
   */
  public final PublishGCPubSub setGcpPubsubPublishBatchSize(
      final String gcpPubsubPublishBatchSize) {
    properties.put(GCP_PUBSUB_PUBLISH_BATCH_SIZE_PROPERTY, gcpPubsubPublishBatchSize);
    return this;
  }

  /**
   * Indicates the number of messages the cloud service should bundle together in a batch. If not set and left empty, only one message will be used in a batch
   */
  public final PublishGCPubSub removeGcpPubsubPublishBatchSize() {
    properties.remove(GCP_PUBSUB_PUBLISH_BATCH_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PublishGCPubSub setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PublishGCPubSub removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PublishGCPubSub, PublishGCPubSub> configurator) {
    return configurator.apply(new PublishGCPubSub()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishGCPubSub.class) final Closure<PublishGCPubSub> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.gcp.pubsub.PublishGCPubSub> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.pubsub.PublishGCPubSub.class, com.tibtech.nifi.processors.gcp.pubsub.PublishGCPubSub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PublishGCPubSub, PublishGCPubSub> configurator) {
    return configurator.apply(new PublishGCPubSub(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishGCPubSub.class) final Closure<PublishGCPubSub> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.gcp.pubsub.PublishGCPubSub> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.pubsub.PublishGCPubSub.class, com.tibtech.nifi.processors.gcp.pubsub.PublishGCPubSub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
