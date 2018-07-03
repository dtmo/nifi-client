package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetSFTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.GetSFTP";

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The port that the remote system is listening on for file transfers
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
   * The fully qualified path to the Private Key file
   */
  public static final String PRIVATE_KEY_PATH_PROPERTY = "Private Key Path";

  /**
   * Password for the private key
   */
  public static final String PRIVATE_KEY_PASSPHRASE_PROPERTY = "Private Key Passphrase";

  /**
   * The path on the remote system from which to pull or push files
   */
  public static final String REMOTE_PATH_PROPERTY = "Remote Path";

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public static final String FILE_FILTER_REGEX_PROPERTY = "File Filter Regex";

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public static final String PATH_FILTER_REGEX_PROPERTY = "Path Filter Regex";

  /**
   * Determines how long to wait between fetching the listing for new files
   */
  public static final String POLLING_INTERVAL_PROPERTY = "Polling Interval";

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public static final String SEARCH_RECURSIVELY_PROPERTY = "Search Recursively";

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public static final String IGNORE_DOTTED_FILES_PROPERTY = "Ignore Dotted Files";

  /**
   * Determines whether or not the file is deleted from the remote system after it has been successfully transferred
   */
  public static final String DELETE_ORIGINAL_PROPERTY = "Delete Original";

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public static final String HOST_KEY_FILE_PROPERTY = "Host Key File";

  /**
   * The maximum number of files to pull in a single connection
   */
  public static final String MAX_SELECTS_PROPERTY = "Max Selects";

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public static final String REMOTE_POLL_BATCH_SIZE_PROPERTY = "Remote Poll Batch Size";

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public static final String STRICT_HOST_KEY_CHECKING_PROPERTY = "Strict Host Key Checking";

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public static final String SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY = "Send Keep Alive On Timeout";

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public static final String USE_COMPRESSION_PROPERTY = "Use Compression";

  /**
   * If true, will pull files in the order in which they are naturally listed; otherwise, the order in which the files will be pulled is not defined
   */
  public static final String USE_NATURAL_ORDERING_PROPERTY = "Use Natural Ordering";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS + AuthN
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

  private final Map<String, String> properties;

  public GetSFTP() {
    this.properties = new HashMap<>();
  }

  public GetSFTP(final Map<String, String> properties) {
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
  public final GetSFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final GetSFTP removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The port that the remote system is listening on for file transfers
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port that the remote system is listening on for file transfers
   */
  public final GetSFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port that the remote system is listening on for file transfers
   */
  public final GetSFTP removePort() {
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
  public final GetSFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final GetSFTP removeUsername() {
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
  public final GetSFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final GetSFTP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The fully qualified path to the Private Key file
   */
  public final String getPrivateKeyPath() {
    return properties.get(PRIVATE_KEY_PATH_PROPERTY);
  }

  /**
   * The fully qualified path to the Private Key file
   */
  public final GetSFTP setPrivateKeyPath(final String privateKeyPath) {
    properties.put(PRIVATE_KEY_PATH_PROPERTY, privateKeyPath);
    return this;
  }

  /**
   * The fully qualified path to the Private Key file
   */
  public final GetSFTP removePrivateKeyPath() {
    properties.remove(PRIVATE_KEY_PATH_PROPERTY);
    return this;
  }

  /**
   * Password for the private key
   */
  public final String getPrivateKeyPassphrase() {
    return properties.get(PRIVATE_KEY_PASSPHRASE_PROPERTY);
  }

  /**
   * Password for the private key
   */
  public final GetSFTP setPrivateKeyPassphrase(final String privateKeyPassphrase) {
    properties.put(PRIVATE_KEY_PASSPHRASE_PROPERTY, privateKeyPassphrase);
    return this;
  }

  /**
   * Password for the private key
   */
  public final GetSFTP removePrivateKeyPassphrase() {
    properties.remove(PRIVATE_KEY_PASSPHRASE_PROPERTY);
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
  public final GetSFTP setRemotePath(final String remotePath) {
    properties.put(REMOTE_PATH_PROPERTY, remotePath);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final GetSFTP removeRemotePath() {
    properties.remove(REMOTE_PATH_PROPERTY);
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
  public final GetSFTP setFileFilterRegex(final String fileFilterRegex) {
    properties.put(FILE_FILTER_REGEX_PROPERTY, fileFilterRegex);
    return this;
  }

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public final GetSFTP removeFileFilterRegex() {
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
  public final GetSFTP setPathFilterRegex(final String pathFilterRegex) {
    properties.put(PATH_FILTER_REGEX_PROPERTY, pathFilterRegex);
    return this;
  }

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public final GetSFTP removePathFilterRegex() {
    properties.remove(PATH_FILTER_REGEX_PROPERTY);
    return this;
  }

  /**
   * Determines how long to wait between fetching the listing for new files
   */
  public final String getPollingInterval() {
    return properties.get(POLLING_INTERVAL_PROPERTY);
  }

  /**
   * Determines how long to wait between fetching the listing for new files
   */
  public final GetSFTP setPollingInterval(final String pollingInterval) {
    properties.put(POLLING_INTERVAL_PROPERTY, pollingInterval);
    return this;
  }

  /**
   * Determines how long to wait between fetching the listing for new files
   */
  public final GetSFTP removePollingInterval() {
    properties.remove(POLLING_INTERVAL_PROPERTY);
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
  public final GetSFTP setSearchRecursively(final String searchRecursively) {
    properties.put(SEARCH_RECURSIVELY_PROPERTY, searchRecursively);
    return this;
  }

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public final GetSFTP removeSearchRecursively() {
    properties.remove(SEARCH_RECURSIVELY_PROPERTY);
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
  public final GetSFTP setIgnoreDottedFiles(final String ignoreDottedFiles) {
    properties.put(IGNORE_DOTTED_FILES_PROPERTY, ignoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final GetSFTP removeIgnoreDottedFiles() {
    properties.remove(IGNORE_DOTTED_FILES_PROPERTY);
    return this;
  }

  /**
   * Determines whether or not the file is deleted from the remote system after it has been successfully transferred
   */
  public final String getDeleteOriginal() {
    return properties.get(DELETE_ORIGINAL_PROPERTY);
  }

  /**
   * Determines whether or not the file is deleted from the remote system after it has been successfully transferred
   */
  public final GetSFTP setDeleteOriginal(final String deleteOriginal) {
    properties.put(DELETE_ORIGINAL_PROPERTY, deleteOriginal);
    return this;
  }

  /**
   * Determines whether or not the file is deleted from the remote system after it has been successfully transferred
   */
  public final GetSFTP removeDeleteOriginal() {
    properties.remove(DELETE_ORIGINAL_PROPERTY);
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
  public final GetSFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final GetSFTP removeConnectionTimeout() {
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
  public final GetSFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final GetSFTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public final String getHostKeyFile() {
    return properties.get(HOST_KEY_FILE_PROPERTY);
  }

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public final GetSFTP setHostKeyFile(final String hostKeyFile) {
    properties.put(HOST_KEY_FILE_PROPERTY, hostKeyFile);
    return this;
  }

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public final GetSFTP removeHostKeyFile() {
    properties.remove(HOST_KEY_FILE_PROPERTY);
    return this;
  }

  /**
   * The maximum number of files to pull in a single connection
   */
  public final String getMaxSelects() {
    return properties.get(MAX_SELECTS_PROPERTY);
  }

  /**
   * The maximum number of files to pull in a single connection
   */
  public final GetSFTP setMaxSelects(final String maxSelects) {
    properties.put(MAX_SELECTS_PROPERTY, maxSelects);
    return this;
  }

  /**
   * The maximum number of files to pull in a single connection
   */
  public final GetSFTP removeMaxSelects() {
    properties.remove(MAX_SELECTS_PROPERTY);
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
  public final GetSFTP setRemotePollBatchSize(final String remotePollBatchSize) {
    properties.put(REMOTE_POLL_BATCH_SIZE_PROPERTY, remotePollBatchSize);
    return this;
  }

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public final GetSFTP removeRemotePollBatchSize() {
    properties.remove(REMOTE_POLL_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public final String getStrictHostKeyChecking() {
    return properties.get(STRICT_HOST_KEY_CHECKING_PROPERTY);
  }

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public final GetSFTP setStrictHostKeyChecking(final String strictHostKeyChecking) {
    properties.put(STRICT_HOST_KEY_CHECKING_PROPERTY, strictHostKeyChecking);
    return this;
  }

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public final GetSFTP removeStrictHostKeyChecking() {
    properties.remove(STRICT_HOST_KEY_CHECKING_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public final String getSendKeepAliveOnTimeout() {
    return properties.get(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY);
  }

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public final GetSFTP setSendKeepAliveOnTimeout(final String sendKeepAliveOnTimeout) {
    properties.put(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY, sendKeepAliveOnTimeout);
    return this;
  }

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public final GetSFTP removeSendKeepAliveOnTimeout() {
    properties.remove(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final String getUseCompression() {
    return properties.get(USE_COMPRESSION_PROPERTY);
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final GetSFTP setUseCompression(final String useCompression) {
    properties.put(USE_COMPRESSION_PROPERTY, useCompression);
    return this;
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final GetSFTP removeUseCompression() {
    properties.remove(USE_COMPRESSION_PROPERTY);
    return this;
  }

  /**
   * If true, will pull files in the order in which they are naturally listed; otherwise, the order in which the files will be pulled is not defined
   */
  public final String getUseNaturalOrdering() {
    return properties.get(USE_NATURAL_ORDERING_PROPERTY);
  }

  /**
   * If true, will pull files in the order in which they are naturally listed; otherwise, the order in which the files will be pulled is not defined
   */
  public final GetSFTP setUseNaturalOrdering(final String useNaturalOrdering) {
    properties.put(USE_NATURAL_ORDERING_PROPERTY, useNaturalOrdering);
    return this;
  }

  /**
   * If true, will pull files in the order in which they are naturally listed; otherwise, the order in which the files will be pulled is not defined
   */
  public final GetSFTP removeUseNaturalOrdering() {
    properties.remove(USE_NATURAL_ORDERING_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS + AuthN
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS + AuthN
   */
  public final GetSFTP setProxyConfigurationService(final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS + AuthN
   */
  public final GetSFTP removeProxyConfigurationService() {
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
  public final GetSFTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final GetSFTP removeProxyType() {
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
  public final GetSFTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final GetSFTP removeProxyHost() {
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
  public final GetSFTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final GetSFTP removeProxyPort() {
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
  public final GetSFTP setHttpProxyUsername(final String httpProxyUsername) {
    properties.put(HTTP_PROXY_USERNAME_PROPERTY, httpProxyUsername);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final GetSFTP removeHttpProxyUsername() {
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
  public final GetSFTP setHttpProxyPassword(final String httpProxyPassword) {
    properties.put(HTTP_PROXY_PASSWORD_PROPERTY, httpProxyPassword);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final GetSFTP removeHttpProxyPassword() {
    properties.remove(HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetSFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetSFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetSFTP, GetSFTP> configurator) {
    return configurator.apply(new GetSFTP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetSFTP.class) final Closure<GetSFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetSFTP.class, com.tibtech.nifi.processors.standard.GetSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetSFTP, GetSFTP> configurator) {
    return configurator.apply(new GetSFTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetSFTP.class) final Closure<GetSFTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetSFTP.class, com.tibtech.nifi.processors.standard.GetSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
