package com.tibtech.nifi.processors.azure.storage.queue;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetAzureQueueStorage {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.azure.storage.queue.GetAzureQueueStorage";

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public static final String STORAGE_ACCOUNT_NAME_PROPERTY = "storage-account-name";

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public static final String STORAGE_ACCOUNT_KEY_PROPERTY = "storage-account-key";

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public static final String STORAGE_SAS_TOKEN_PROPERTY = "storage-sas-token";

  /**
   * Name of the Azure Storage Queue
   */
  public static final String STORAGE_QUEUE_NAME_PROPERTY = "storage-queue-name";

  /**
   * Specifies whether the received message is to be automatically deleted from the queue.
   */
  public static final String AUTO_DELETE_MESSAGES_PROPERTY = "auto-delete-messages";

  /**
   * The number of messages to be retrieved from the queue.
   */
  public static final String BATCH_SIZE_PROPERTY = "batch-size";

  /**
   * The duration during which the retrieved message should be invisible to other consumers.
   */
  public static final String VISIBILITY_TIMEOUT_PROPERTY = "visibility-timeout";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  private final Map<String, String> properties;

  public GetAzureQueueStorage() {
    this.properties = new HashMap<>();
  }

  public GetAzureQueueStorage(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final String getStorageAccountName() {
    return properties.get(STORAGE_ACCOUNT_NAME_PROPERTY);
  }

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final GetAzureQueueStorage setStorageAccountName(final String storageAccountName) {
    properties.put(STORAGE_ACCOUNT_NAME_PROPERTY, storageAccountName);
    return this;
  }

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final GetAzureQueueStorage removeStorageAccountName() {
    properties.remove(STORAGE_ACCOUNT_NAME_PROPERTY);
    return this;
  }

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final String getStorageAccountKey() {
    return properties.get(STORAGE_ACCOUNT_KEY_PROPERTY);
  }

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final GetAzureQueueStorage setStorageAccountKey(final String storageAccountKey) {
    properties.put(STORAGE_ACCOUNT_KEY_PROPERTY, storageAccountKey);
    return this;
  }

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final GetAzureQueueStorage removeStorageAccountKey() {
    properties.remove(STORAGE_ACCOUNT_KEY_PROPERTY);
    return this;
  }

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final String getStorageSasToken() {
    return properties.get(STORAGE_SAS_TOKEN_PROPERTY);
  }

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final GetAzureQueueStorage setStorageSasToken(final String storageSasToken) {
    properties.put(STORAGE_SAS_TOKEN_PROPERTY, storageSasToken);
    return this;
  }

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final GetAzureQueueStorage removeStorageSasToken() {
    properties.remove(STORAGE_SAS_TOKEN_PROPERTY);
    return this;
  }

  /**
   * Name of the Azure Storage Queue
   */
  public final String getStorageQueueName() {
    return properties.get(STORAGE_QUEUE_NAME_PROPERTY);
  }

  /**
   * Name of the Azure Storage Queue
   */
  public final GetAzureQueueStorage setStorageQueueName(final String storageQueueName) {
    properties.put(STORAGE_QUEUE_NAME_PROPERTY, storageQueueName);
    return this;
  }

  /**
   * Name of the Azure Storage Queue
   */
  public final GetAzureQueueStorage removeStorageQueueName() {
    properties.remove(STORAGE_QUEUE_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the received message is to be automatically deleted from the queue.
   */
  public final String getAutoDeleteMessages() {
    return properties.get(AUTO_DELETE_MESSAGES_PROPERTY);
  }

  /**
   * Specifies whether the received message is to be automatically deleted from the queue.
   */
  public final GetAzureQueueStorage setAutoDeleteMessages(final String autoDeleteMessages) {
    properties.put(AUTO_DELETE_MESSAGES_PROPERTY, autoDeleteMessages);
    return this;
  }

  /**
   * Specifies whether the received message is to be automatically deleted from the queue.
   */
  public final GetAzureQueueStorage removeAutoDeleteMessages() {
    properties.remove(AUTO_DELETE_MESSAGES_PROPERTY);
    return this;
  }

  /**
   * The number of messages to be retrieved from the queue.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of messages to be retrieved from the queue.
   */
  public final GetAzureQueueStorage setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of messages to be retrieved from the queue.
   */
  public final GetAzureQueueStorage removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The duration during which the retrieved message should be invisible to other consumers.
   */
  public final String getVisibilityTimeout() {
    return properties.get(VISIBILITY_TIMEOUT_PROPERTY);
  }

  /**
   * The duration during which the retrieved message should be invisible to other consumers.
   */
  public final GetAzureQueueStorage setVisibilityTimeout(final String visibilityTimeout) {
    properties.put(VISIBILITY_TIMEOUT_PROPERTY, visibilityTimeout);
    return this;
  }

  /**
   * The duration during which the retrieved message should be invisible to other consumers.
   */
  public final GetAzureQueueStorage removeVisibilityTimeout() {
    properties.remove(VISIBILITY_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public final GetAzureQueueStorage setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public final GetAzureQueueStorage removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetAzureQueueStorage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetAzureQueueStorage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetAzureQueueStorage, GetAzureQueueStorage> configurator) {
    return configurator.apply(new GetAzureQueueStorage()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetAzureQueueStorage.class) final Closure<GetAzureQueueStorage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.queue.GetAzureQueueStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.queue.GetAzureQueueStorage.class, com.tibtech.nifi.processors.azure.storage.queue.GetAzureQueueStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetAzureQueueStorage, GetAzureQueueStorage> configurator) {
    return configurator.apply(new GetAzureQueueStorage(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetAzureQueueStorage.class) final Closure<GetAzureQueueStorage> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.queue.GetAzureQueueStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.queue.GetAzureQueueStorage.class, com.tibtech.nifi.processors.azure.storage.queue.GetAzureQueueStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
