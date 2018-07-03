package com.tibtech.nifi.processors.azure.storage.queue;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutAzureQueueStorage {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.azure.storage.queue.PutAzureQueueStorage";

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
   * Maximum time to allow the message to be in the queue. If left empty, the default value of 7 days will be used.
   */
  public static final String TIME_TO_LIVE_PROPERTY = "time-to-live";

  /**
   * Name of the Azure Storage Queue
   */
  public static final String STORAGE_QUEUE_NAME_PROPERTY = "storage-queue-name";

  /**
   * The length of time during which the message will be invisible, starting when it is added to the queue. This value must be greater than or equal to 0 and less than the TTL value.
   */
  public static final String VISIBILITY_DELAY_PROPERTY = "visibility-delay";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  private final Map<String, String> properties;

  public PutAzureQueueStorage() {
    this.properties = new HashMap<>();
  }

  public PutAzureQueueStorage(final Map<String, String> properties) {
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
  public final PutAzureQueueStorage setStorageAccountName(final String storageAccountName) {
    properties.put(STORAGE_ACCOUNT_NAME_PROPERTY, storageAccountName);
    return this;
  }

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final PutAzureQueueStorage removeStorageAccountName() {
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
  public final PutAzureQueueStorage setStorageAccountKey(final String storageAccountKey) {
    properties.put(STORAGE_ACCOUNT_KEY_PROPERTY, storageAccountKey);
    return this;
  }

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final PutAzureQueueStorage removeStorageAccountKey() {
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
  public final PutAzureQueueStorage setStorageSasToken(final String storageSasToken) {
    properties.put(STORAGE_SAS_TOKEN_PROPERTY, storageSasToken);
    return this;
  }

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final PutAzureQueueStorage removeStorageSasToken() {
    properties.remove(STORAGE_SAS_TOKEN_PROPERTY);
    return this;
  }

  /**
   * Maximum time to allow the message to be in the queue. If left empty, the default value of 7 days will be used.
   */
  public final String getTimeToLive() {
    return properties.get(TIME_TO_LIVE_PROPERTY);
  }

  /**
   * Maximum time to allow the message to be in the queue. If left empty, the default value of 7 days will be used.
   */
  public final PutAzureQueueStorage setTimeToLive(final String timeToLive) {
    properties.put(TIME_TO_LIVE_PROPERTY, timeToLive);
    return this;
  }

  /**
   * Maximum time to allow the message to be in the queue. If left empty, the default value of 7 days will be used.
   */
  public final PutAzureQueueStorage removeTimeToLive() {
    properties.remove(TIME_TO_LIVE_PROPERTY);
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
  public final PutAzureQueueStorage setStorageQueueName(final String storageQueueName) {
    properties.put(STORAGE_QUEUE_NAME_PROPERTY, storageQueueName);
    return this;
  }

  /**
   * Name of the Azure Storage Queue
   */
  public final PutAzureQueueStorage removeStorageQueueName() {
    properties.remove(STORAGE_QUEUE_NAME_PROPERTY);
    return this;
  }

  /**
   * The length of time during which the message will be invisible, starting when it is added to the queue. This value must be greater than or equal to 0 and less than the TTL value.
   */
  public final String getVisibilityDelay() {
    return properties.get(VISIBILITY_DELAY_PROPERTY);
  }

  /**
   * The length of time during which the message will be invisible, starting when it is added to the queue. This value must be greater than or equal to 0 and less than the TTL value.
   */
  public final PutAzureQueueStorage setVisibilityDelay(final String visibilityDelay) {
    properties.put(VISIBILITY_DELAY_PROPERTY, visibilityDelay);
    return this;
  }

  /**
   * The length of time during which the message will be invisible, starting when it is added to the queue. This value must be greater than or equal to 0 and less than the TTL value.
   */
  public final PutAzureQueueStorage removeVisibilityDelay() {
    properties.remove(VISIBILITY_DELAY_PROPERTY);
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
  public final PutAzureQueueStorage setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public final PutAzureQueueStorage removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutAzureQueueStorage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutAzureQueueStorage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutAzureQueueStorage, PutAzureQueueStorage> configurator) {
    return configurator.apply(new PutAzureQueueStorage()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutAzureQueueStorage.class) final Closure<PutAzureQueueStorage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.queue.PutAzureQueueStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.queue.PutAzureQueueStorage.class, com.tibtech.nifi.processors.azure.storage.queue.PutAzureQueueStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutAzureQueueStorage, PutAzureQueueStorage> configurator) {
    return configurator.apply(new PutAzureQueueStorage(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutAzureQueueStorage.class) final Closure<PutAzureQueueStorage> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.queue.PutAzureQueueStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.queue.PutAzureQueueStorage.class, com.tibtech.nifi.processors.azure.storage.queue.PutAzureQueueStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
