package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetFTP {
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
   * The FTP Connection Mode
   */
  public static final String CONNECTION_MODE_PROPERTY = "Connection Mode";

  /**
   * The FTP Transfer Mode
   */
  public static final String TRANSFER_MODE_PROPERTY = "Transfer Mode";

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
   * The maximum number of files to pull in a single connection
   */
  public static final String MAX_SELECTS_PROPERTY = "Max Selects";

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public static final String REMOTE_POLL_BATCH_SIZE_PROPERTY = "Remote Poll Batch Size";

  /**
   * If true, will pull files in the order in which they are naturally listed; otherwise, the order in which the files will be pulled is not defined
   */
  public static final String USE_NATURAL_ORDERING_PROPERTY = "Use Natural Ordering";

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

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final GetFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final GetFTP removeHostname() {
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
  public final GetFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port that the remote system is listening on for file transfers
   */
  public final GetFTP removePort() {
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
  public final GetFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final GetFTP removeUsername() {
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
  public final GetFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final GetFTP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
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
  public final GetFTP setConnectionMode(final String connectionMode) {
    properties.put(CONNECTION_MODE_PROPERTY, connectionMode);
    return this;
  }

  /**
   * The FTP Connection Mode
   */
  public final GetFTP removeConnectionMode() {
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
  public final GetFTP setTransferMode(final String transferMode) {
    properties.put(TRANSFER_MODE_PROPERTY, transferMode);
    return this;
  }

  /**
   * The FTP Transfer Mode
   */
  public final GetFTP removeTransferMode() {
    properties.remove(TRANSFER_MODE_PROPERTY);
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
  public final GetFTP setRemotePath(final String remotePath) {
    properties.put(REMOTE_PATH_PROPERTY, remotePath);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final GetFTP removeRemotePath() {
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
  public final GetFTP setFileFilterRegex(final String fileFilterRegex) {
    properties.put(FILE_FILTER_REGEX_PROPERTY, fileFilterRegex);
    return this;
  }

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public final GetFTP removeFileFilterRegex() {
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
  public final GetFTP setPathFilterRegex(final String pathFilterRegex) {
    properties.put(PATH_FILTER_REGEX_PROPERTY, pathFilterRegex);
    return this;
  }

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public final GetFTP removePathFilterRegex() {
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
  public final GetFTP setPollingInterval(final String pollingInterval) {
    properties.put(POLLING_INTERVAL_PROPERTY, pollingInterval);
    return this;
  }

  /**
   * Determines how long to wait between fetching the listing for new files
   */
  public final GetFTP removePollingInterval() {
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
  public final GetFTP setSearchRecursively(final String searchRecursively) {
    properties.put(SEARCH_RECURSIVELY_PROPERTY, searchRecursively);
    return this;
  }

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public final GetFTP removeSearchRecursively() {
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
  public final GetFTP setIgnoreDottedFiles(final String ignoreDottedFiles) {
    properties.put(IGNORE_DOTTED_FILES_PROPERTY, ignoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final GetFTP removeIgnoreDottedFiles() {
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
  public final GetFTP setDeleteOriginal(final String deleteOriginal) {
    properties.put(DELETE_ORIGINAL_PROPERTY, deleteOriginal);
    return this;
  }

  /**
   * Determines whether or not the file is deleted from the remote system after it has been successfully transferred
   */
  public final GetFTP removeDeleteOriginal() {
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
  public final GetFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final GetFTP removeConnectionTimeout() {
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
  public final GetFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final GetFTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
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
  public final GetFTP setMaxSelects(final String maxSelects) {
    properties.put(MAX_SELECTS_PROPERTY, maxSelects);
    return this;
  }

  /**
   * The maximum number of files to pull in a single connection
   */
  public final GetFTP removeMaxSelects() {
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
  public final GetFTP setRemotePollBatchSize(final String remotePollBatchSize) {
    properties.put(REMOTE_POLL_BATCH_SIZE_PROPERTY, remotePollBatchSize);
    return this;
  }

  /**
   * The value specifies how many file paths to find in a given directory on the remote system when doing a file listing. This value in general should not need to be modified but when polling against a remote system with a tremendous number of files this value can be critical.  Setting this value too high can result very poor performance and setting it too low can cause the flow to be slower than normal.
   */
  public final GetFTP removeRemotePollBatchSize() {
    properties.remove(REMOTE_POLL_BATCH_SIZE_PROPERTY);
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
  public final GetFTP setUseNaturalOrdering(final String useNaturalOrdering) {
    properties.put(USE_NATURAL_ORDERING_PROPERTY, useNaturalOrdering);
    return this;
  }

  /**
   * If true, will pull files in the order in which they are naturally listed; otherwise, the order in which the files will be pulled is not defined
   */
  public final GetFTP removeUseNaturalOrdering() {
    properties.remove(USE_NATURAL_ORDERING_PROPERTY);
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
  public final GetFTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final GetFTP removeProxyType() {
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
  public final GetFTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final GetFTP removeProxyHost() {
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
  public final GetFTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final GetFTP removeProxyPort() {
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
  public final GetFTP setHttpProxyUsername(final String httpProxyUsername) {
    properties.put(HTTP_PROXY_USERNAME_PROPERTY, httpProxyUsername);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final GetFTP removeHttpProxyUsername() {
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
  public final GetFTP setHttpProxyPassword(final String httpProxyPassword) {
    properties.put(HTTP_PROXY_PASSWORD_PROPERTY, httpProxyPassword);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final GetFTP removeHttpProxyPassword() {
    properties.remove(HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetFTP, GetFTP> configurator) {
    return configurator.apply(new GetFTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetFTP.class) final Closure<GetFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetFTP.class, com.tibtech.nifi.processors.standard.GetFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
