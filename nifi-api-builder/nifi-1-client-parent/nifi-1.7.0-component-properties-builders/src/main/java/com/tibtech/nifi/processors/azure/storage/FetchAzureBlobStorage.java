package com.tibtech.nifi.processors.azure.storage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchAzureBlobStorage {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.azure.storage.FetchAzureBlobStorage";

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
   * The filename of the blob
   */
  public static final String BLOB_PROPERTY = "blob";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  private final Map<String, String> properties;

  public FetchAzureBlobStorage() {
    this.properties = new HashMap<>();
  }

  public FetchAzureBlobStorage(final Map<String, String> properties) {
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
  public final FetchAzureBlobStorage setContainerName(final String containerName) {
    properties.put(CONTAINER_NAME_PROPERTY, containerName);
    return this;
  }

  /**
   * Name of the Azure storage container
   */
  public final FetchAzureBlobStorage removeContainerName() {
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
  public final FetchAzureBlobStorage setStorageSasToken(final String storageSasToken) {
    properties.put(STORAGE_SAS_TOKEN_PROPERTY, storageSasToken);
    return this;
  }

  /**
   * Shared Access Signature token, including the leading '?'. Specify either SAS Token (recommended) or Account Key. There are certain risks in allowing the SAS token to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final FetchAzureBlobStorage removeStorageSasToken() {
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
  public final FetchAzureBlobStorage setStorageAccountName(final String storageAccountName) {
    properties.put(STORAGE_ACCOUNT_NAME_PROPERTY, storageAccountName);
    return this;
  }

  /**
   * The storage account name.  There are certain risks in allowing the account name to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account name to be fetched dynamically from a flowfile attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final FetchAzureBlobStorage removeStorageAccountName() {
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
  public final FetchAzureBlobStorage setStorageAccountKey(final String storageAccountKey) {
    properties.put(STORAGE_ACCOUNT_KEY_PROPERTY, storageAccountKey);
    return this;
  }

  /**
   * The storage account key. This is an admin-like password providing access to every container in this account. It is recommended one uses Shared Access Signature (SAS) token instead for fine-grained control with policies. There are certain risks in allowing the account key to be stored as a flowfile attribute. While it does provide for a more flexible flow by allowing the account key to be fetched dynamically from a flow file attribute, care must be taken to restrict access to the event provenance data (e.g. by strictly controlling the policies governing provenance for this Processor). In addition, the provenance repositories may be put on encrypted disk partitions.
   */
  public final FetchAzureBlobStorage removeStorageAccountKey() {
    properties.remove(STORAGE_ACCOUNT_KEY_PROPERTY);
    return this;
  }

  /**
   * The filename of the blob
   */
  public final String getBlob() {
    return properties.get(BLOB_PROPERTY);
  }

  /**
   * The filename of the blob
   */
  public final FetchAzureBlobStorage setBlob(final String blob) {
    properties.put(BLOB_PROPERTY, blob);
    return this;
  }

  /**
   * The filename of the blob
   */
  public final FetchAzureBlobStorage removeBlob() {
    properties.remove(BLOB_PROPERTY);
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
  public final FetchAzureBlobStorage setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. Supported proxies: HTTP, SOCKS
   */
  public final FetchAzureBlobStorage removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchAzureBlobStorage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchAzureBlobStorage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FetchAzureBlobStorage, FetchAzureBlobStorage> configurator) {
    return configurator.apply(new FetchAzureBlobStorage()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchAzureBlobStorage.class) final Closure<FetchAzureBlobStorage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.FetchAzureBlobStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.FetchAzureBlobStorage.class, com.tibtech.nifi.processors.azure.storage.FetchAzureBlobStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchAzureBlobStorage, FetchAzureBlobStorage> configurator) {
    return configurator.apply(new FetchAzureBlobStorage(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchAzureBlobStorage.class) final Closure<FetchAzureBlobStorage> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.azure.storage.FetchAzureBlobStorage> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.storage.FetchAzureBlobStorage.class, com.tibtech.nifi.processors.azure.storage.FetchAzureBlobStorage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
