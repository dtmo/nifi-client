package com.tibtech.nifi.processors.azure.storage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListAzureBlobStorage {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.azure.storage.ListAzureBlobStorage";

  /**
   * Name of the Azure storage container
   */
  public static final String CONTAINER_NAME_PROPERTY = "container-name";

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public static final String STORAGE_SAS_TOKEN_PROPERTY = "storage-sas-token";

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public static final String STORAGE_ACCOUNT_NAME_PROPERTY = "storage-account-name";

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public static final String STORAGE_ACCOUNT_KEY_PROPERTY = "storage-account-key";

  /**
   * Search prefix for listing
   */
  public static final String PREFIX_PROPERTY = "prefix";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  private final Map<String, String> properties;

  public ListAzureBlobStorage() {
    this.properties = new HashMap<>();
  }

  public ListAzureBlobStorage(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Name of the Azure storage container
   */
  public final String getContainerName() {
    return properties.get(CONTAINER_NAME_PROPERTY);
  }

  /**
   * Name of the Azure storage container
   */
  public final ListAzureBlobStorage setContainerName(final String containerName) {
    properties.put(CONTAINER_NAME_PROPERTY, containerName);
    return this;
  }

  /**
   * Name of the Azure storage container
   */
  public final ListAzureBlobStorage removeContainerName() {
    properties.remove(CONTAINER_NAME_PROPERTY);
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
  public final ListAzureBlobStorage setStorageSasToken(final String storageSasToken) {
    properties.put(STORAGE_SAS_TOKEN_PROPERTY, storageSasToken);
    return this;
  }

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final ListAzureBlobStorage removeStorageSasToken() {
    properties.remove(STORAGE_SAS_TOKEN_PROPERTY);
    return this;
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
  public final ListAzureBlobStorage setStorageAccountName(final String storageAccountName) {
    properties.put(STORAGE_ACCOUNT_NAME_PROPERTY, storageAccountName);
    return this;
  }

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final ListAzureBlobStorage removeStorageAccountName() {
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
  public final ListAzureBlobStorage setStorageAccountKey(final String storageAccountKey) {
    properties.put(STORAGE_ACCOUNT_KEY_PROPERTY, storageAccountKey);
    return this;
  }

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final ListAzureBlobStorage removeStorageAccountKey() {
    properties.remove(STORAGE_ACCOUNT_KEY_PROPERTY);
    return this;
  }

  /**
   * Search prefix for listing
   */
  public final String getPrefix() {
    return properties.get(PREFIX_PROPERTY);
  }

  /**
   * Search prefix for listing
   */
  public final ListAzureBlobStorage setPrefix(final String prefix) {
    properties.put(PREFIX_PROPERTY, prefix);
    return this;
  }

  /**
   * Search prefix for listing
   */
  public final ListAzureBlobStorage removePrefix() {
    properties.remove(PREFIX_PROPERTY);
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
  public final ListAzureBlobStorage setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public final ListAzureBlobStorage removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListAzureBlobStorage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListAzureBlobStorage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListAzureBlobStorage, ListAzureBlobStorage> configurator) {
    return configurator.apply(new ListAzureBlobStorage()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListAzureBlobStorage.class) final Closure<ListAzureBlobStorage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.ListAzureBlobStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.ListAzureBlobStorage.class, com.tibtech.nifi.processors.azure.storage.ListAzureBlobStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListAzureBlobStorage, ListAzureBlobStorage> configurator) {
    return configurator.apply(new ListAzureBlobStorage(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListAzureBlobStorage.class) final Closure<ListAzureBlobStorage> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.ListAzureBlobStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.ListAzureBlobStorage.class, com.tibtech.nifi.processors.azure.storage.ListAzureBlobStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
