package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListFTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListFTP";

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * Username
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password for the user account
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The path on the remote system from which to pull or push files
   */
  public static final String REMOTE_PATH_PROPERTY = "Remote Path";

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from the remote server so that if a new node begins pulling data, it won't duplicate all of the work that has been done. If not specified, the information will not be shared across the cluster. This property does not need to be set for standalone instances of NiFi but should be configured if NiFi is run within a cluster.
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "Distributed Cache Service";

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public static final String SEARCH_RECURSIVELY_PROPERTY = "Search Recursively";

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public static final String FILE_FILTER_REGEX_PROPERTY = "File Filter Regex";

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public static final String PATH_FILTER_REGEX_PROPERTY = "Path Filter Regex";

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public static final String IGNORE_DOTTED_FILES_PROPERTY = "Ignore Dotted Files";

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public static final String REMOTE_POLL_BATCH_SIZE_PROPERTY = "Remote Poll Batch Size";

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * The FTP Connection Mode
   */
  public static final String CONNECTION_MODE_PROPERTY = "Connection Mode";

  /**
   * The FTP Transfer Mode
   */
  public static final String TRANSFER_MODE_PROPERTY = "Transfer Mode";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  /**
   * Proxy type used for file transfers
   */
  public static final String PROXY_TYPE_PROPERTY = "Proxy Type";

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * The port of the proxy server
   */
  public static final String PROXY_PORT_PROPERTY = "Proxy Port";

  /**
   * Http Proxy Username
   */
  public static final String HTTP_PROXY_USERNAME_PROPERTY = "Http Proxy Username";

  /**
   * Http Proxy Password
   */
  public static final String HTTP_PROXY_PASSWORD_PROPERTY = "Http Proxy Password";

  /**
   * Set the internal buffer size for buffered data streams
   */
  public static final String INTERNAL_BUFFER_SIZE_PROPERTY = "Internal Buffer Size";

  /**
   * Specify timestamp precision at the target system. Since this processor uses timestamp of entities to decide which should be listed, it is crucial to use the right timestamp precision.
   */
  public static final String TARGET_SYSTEM_TIMESTAMP_PRECISION_PROPERTY = "target-system-timestamp-precision";

  private final Map<String, String> properties;

  public ListFTP() {
    this.properties = new HashMap<>();
  }

  public ListFTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final ListFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final ListFTP removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public final ListFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public final ListFTP removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * Username
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username
   */
  public final ListFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final ListFTP removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password for the user account
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password for the user account
   */
  public final ListFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final ListFTP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final String getRemotePath() {
    return properties.get(REMOTE_PATH_PROPERTY);
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final ListFTP setRemotePath(final String remotePath) {
    properties.put(REMOTE_PATH_PROPERTY, remotePath);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final ListFTP removeRemotePath() {
    properties.remove(REMOTE_PATH_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from the remote server so that if a new node begins pulling data, it won't duplicate all of the work that has been done. If not specified, the information will not be shared across the cluster. This property does not need to be set for standalone instances of NiFi but should be configured if NiFi is run within a cluster.
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from the remote server so that if a new node begins pulling data, it won't duplicate all of the work that has been done. If not specified, the information will not be shared across the cluster. This property does not need to be set for standalone instances of NiFi but should be configured if NiFi is run within a cluster.
   */
  public final ListFTP setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from the remote server so that if a new node begins pulling data, it won't duplicate all of the work that has been done. If not specified, the information will not be shared across the cluster. This property does not need to be set for standalone instances of NiFi but should be configured if NiFi is run within a cluster.
   */
  public final ListFTP removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public final String getSearchRecursively() {
    return properties.get(SEARCH_RECURSIVELY_PROPERTY);
  }

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public final ListFTP setSearchRecursively(final String searchRecursively) {
    properties.put(SEARCH_RECURSIVELY_PROPERTY, searchRecursively);
    return this;
  }

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public final ListFTP removeSearchRecursively() {
    properties.remove(SEARCH_RECURSIVELY_PROPERTY);
    return this;
  }

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public final String getFileFilterRegex() {
    return properties.get(FILE_FILTER_REGEX_PROPERTY);
  }

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public final ListFTP setFileFilterRegex(final String fileFilterRegex) {
    properties.put(FILE_FILTER_REGEX_PROPERTY, fileFilterRegex);
    return this;
  }

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public final ListFTP removeFileFilterRegex() {
    properties.remove(FILE_FILTER_REGEX_PROPERTY);
    return this;
  }

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public final String getPathFilterRegex() {
    return properties.get(PATH_FILTER_REGEX_PROPERTY);
  }

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public final ListFTP setPathFilterRegex(final String pathFilterRegex) {
    properties.put(PATH_FILTER_REGEX_PROPERTY, pathFilterRegex);
    return this;
  }

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public final ListFTP removePathFilterRegex() {
    properties.remove(PATH_FILTER_REGEX_PROPERTY);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final String getIgnoreDottedFiles() {
    return properties.get(IGNORE_DOTTED_FILES_PROPERTY);
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final ListFTP setIgnoreDottedFiles(final String ignoreDottedFiles) {
    properties.put(IGNORE_DOTTED_FILES_PROPERTY, ignoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final ListFTP removeIgnoreDottedFiles() {
    properties.remove(IGNORE_DOTTED_FILES_PROPERTY);
    return this;
  }

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public final String getRemotePollBatchSize() {
    return properties.get(REMOTE_POLL_BATCH_SIZE_PROPERTY);
  }

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public final ListFTP setRemotePollBatchSize(final String remotePollBatchSize) {
    properties.put(REMOTE_POLL_BATCH_SIZE_PROPERTY, remotePollBatchSize);
    return this;
  }

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public final ListFTP removeRemotePollBatchSize() {
    properties.remove(REMOTE_POLL_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final ListFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final ListFTP removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final String getDataTimeout() {
    return properties.get(DATA_TIMEOUT_PROPERTY);
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final ListFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final ListFTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The FTP Connection Mode
   */
  public final String getConnectionMode() {
    return properties.get(CONNECTION_MODE_PROPERTY);
  }

  /**
   * The FTP Connection Mode
   */
  public final ListFTP setConnectionMode(final String connectionMode) {
    properties.put(CONNECTION_MODE_PROPERTY, connectionMode);
    return this;
  }

  /**
   * The FTP Connection Mode
   */
  public final ListFTP removeConnectionMode() {
    properties.remove(CONNECTION_MODE_PROPERTY);
    return this;
  }

  /**
   * The FTP Transfer Mode
   */
  public final String getTransferMode() {
    return properties.get(TRANSFER_MODE_PROPERTY);
  }

  /**
   * The FTP Transfer Mode
   */
  public final ListFTP setTransferMode(final String transferMode) {
    properties.put(TRANSFER_MODE_PROPERTY, transferMode);
    return this;
  }

  /**
   * The FTP Transfer Mode
   */
  public final ListFTP removeTransferMode() {
    properties.remove(TRANSFER_MODE_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final ListFTP setProxyConfigurationService(final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final ListFTP removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final String getProxyType() {
    return properties.get(PROXY_TYPE_PROPERTY);
  }

  /**
   * Proxy type used for file transfers
   */
  public final ListFTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final ListFTP removeProxyType() {
    properties.remove(PROXY_TYPE_PROPERTY);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final String getProxyHost() {
    return properties.get(PROXY_HOST_PROPERTY);
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final ListFTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final ListFTP removeProxyHost() {
    properties.remove(PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final String getProxyPort() {
    return properties.get(PROXY_PORT_PROPERTY);
  }

  /**
   * The port of the proxy server
   */
  public final ListFTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final ListFTP removeProxyPort() {
    properties.remove(PROXY_PORT_PROPERTY);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final String getHttpProxyUsername() {
    return properties.get(HTTP_PROXY_USERNAME_PROPERTY);
  }

  /**
   * Http Proxy Username
   */
  public final ListFTP setHttpProxyUsername(final String httpProxyUsername) {
    properties.put(HTTP_PROXY_USERNAME_PROPERTY, httpProxyUsername);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final ListFTP removeHttpProxyUsername() {
    properties.remove(HTTP_PROXY_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final String getHttpProxyPassword() {
    return properties.get(HTTP_PROXY_PASSWORD_PROPERTY);
  }

  /**
   * Http Proxy Password
   */
  public final ListFTP setHttpProxyPassword(final String httpProxyPassword) {
    properties.put(HTTP_PROXY_PASSWORD_PROPERTY, httpProxyPassword);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final ListFTP removeHttpProxyPassword() {
    properties.remove(HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Set the internal buffer size for buffered data streams
   */
  public final String getInternalBufferSize() {
    return properties.get(INTERNAL_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Set the internal buffer size for buffered data streams
   */
  public final ListFTP setInternalBufferSize(final String internalBufferSize) {
    properties.put(INTERNAL_BUFFER_SIZE_PROPERTY, internalBufferSize);
    return this;
  }

  /**
   * Set the internal buffer size for buffered data streams
   */
  public final ListFTP removeInternalBufferSize() {
    properties.remove(INTERNAL_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specify timestamp precision at the target system. Since this processor uses timestamp of entities to decide which should be listed, it is crucial to use the right timestamp precision.
   */
  public final String getTargetSystemTimestampPrecision() {
    return properties.get(TARGET_SYSTEM_TIMESTAMP_PRECISION_PROPERTY);
  }

  /**
   * Specify timestamp precision at the target system. Since this processor uses timestamp of entities to decide which should be listed, it is crucial to use the right timestamp precision.
   */
  public final ListFTP setTargetSystemTimestampPrecision(
      final String targetSystemTimestampPrecision) {
    properties.put(TARGET_SYSTEM_TIMESTAMP_PRECISION_PROPERTY, targetSystemTimestampPrecision);
    return this;
  }

  /**
   * Specify timestamp precision at the target system. Since this processor uses timestamp of entities to decide which should be listed, it is crucial to use the right timestamp precision.
   */
  public final ListFTP removeTargetSystemTimestampPrecision() {
    properties.remove(TARGET_SYSTEM_TIMESTAMP_PRECISION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListFTP, ListFTP> configurator) {
    return configurator.apply(new ListFTP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListFTP.class) final Closure<ListFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListFTP.class, com.tibtech.nifi.processors.standard.ListFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListFTP, ListFTP> configurator) {
    return configurator.apply(new ListFTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListFTP.class) final Closure<ListFTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListFTP.class, com.tibtech.nifi.processors.standard.ListFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
