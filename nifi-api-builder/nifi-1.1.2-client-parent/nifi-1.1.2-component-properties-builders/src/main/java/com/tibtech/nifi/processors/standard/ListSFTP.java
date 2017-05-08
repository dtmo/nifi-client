package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListSFTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListSFTP";

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
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public static final String STRICT_HOST_KEY_CHECKING_PROPERTY = "Strict Host Key Checking";

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public static final String HOST_KEY_FILE_PROPERTY = "Host Key File";

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public static final String SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY = "Send Keep Alive On Timeout";

  private final Map<String, String> properties;

  public ListSFTP() {
    this.properties = new HashMap<>();
  }

  public ListSFTP(final Map<String, String> properties) {
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
  public final ListSFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final ListSFTP removeHostname() {
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
  public final ListSFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public final ListSFTP removePort() {
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
  public final ListSFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final ListSFTP removeUsername() {
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
  public final ListSFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final ListSFTP removePassword() {
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
  public final ListSFTP setPrivateKeyPath(final String privateKeyPath) {
    properties.put(PRIVATE_KEY_PATH_PROPERTY, privateKeyPath);
    return this;
  }

  /**
   * The fully qualified path to the Private Key file
   */
  public final ListSFTP removePrivateKeyPath() {
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
  public final ListSFTP setPrivateKeyPassphrase(final String privateKeyPassphrase) {
    properties.put(PRIVATE_KEY_PASSPHRASE_PROPERTY, privateKeyPassphrase);
    return this;
  }

  /**
   * Password for the private key
   */
  public final ListSFTP removePrivateKeyPassphrase() {
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
  public final ListSFTP setRemotePath(final String remotePath) {
    properties.put(REMOTE_PATH_PROPERTY, remotePath);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final ListSFTP removeRemotePath() {
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
  public final ListSFTP setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from the remote server so that if a new node begins pulling data, it won't duplicate all of the work that has been done. If not specified, the information will not be shared across the cluster. This property does not need to be set for standalone instances of NiFi but should be configured if NiFi is run within a cluster.
   */
  public final ListSFTP removeDistributedCacheService() {
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
  public final ListSFTP setSearchRecursively(final String searchRecursively) {
    properties.put(SEARCH_RECURSIVELY_PROPERTY, searchRecursively);
    return this;
  }

  /**
   * If true, will pull files from arbitrarily nested subdirectories; otherwise, will not traverse subdirectories
   */
  public final ListSFTP removeSearchRecursively() {
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
  public final ListSFTP setFileFilterRegex(final String fileFilterRegex) {
    properties.put(FILE_FILTER_REGEX_PROPERTY, fileFilterRegex);
    return this;
  }

  /**
   * Provides a Java Regular Expression for filtering Filenames; if a filter is supplied, only files whose names match that Regular Expression will be fetched
   */
  public final ListSFTP removeFileFilterRegex() {
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
  public final ListSFTP setPathFilterRegex(final String pathFilterRegex) {
    properties.put(PATH_FILTER_REGEX_PROPERTY, pathFilterRegex);
    return this;
  }

  /**
   * When Search Recursively is true, then only subdirectories whose path matches the given Regular Expression will be scanned
   */
  public final ListSFTP removePathFilterRegex() {
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
  public final ListSFTP setIgnoreDottedFiles(final String ignoreDottedFiles) {
    properties.put(IGNORE_DOTTED_FILES_PROPERTY, ignoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final ListSFTP removeIgnoreDottedFiles() {
    properties.remove(IGNORE_DOTTED_FILES_PROPERTY);
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
  public final ListSFTP setStrictHostKeyChecking(final String strictHostKeyChecking) {
    properties.put(STRICT_HOST_KEY_CHECKING_PROPERTY, strictHostKeyChecking);
    return this;
  }

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public final ListSFTP removeStrictHostKeyChecking() {
    properties.remove(STRICT_HOST_KEY_CHECKING_PROPERTY);
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
  public final ListSFTP setHostKeyFile(final String hostKeyFile) {
    properties.put(HOST_KEY_FILE_PROPERTY, hostKeyFile);
    return this;
  }

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public final ListSFTP removeHostKeyFile() {
    properties.remove(HOST_KEY_FILE_PROPERTY);
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
  public final ListSFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final ListSFTP removeConnectionTimeout() {
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
  public final ListSFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final ListSFTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
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
  public final ListSFTP setSendKeepAliveOnTimeout(final String sendKeepAliveOnTimeout) {
    properties.put(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY, sendKeepAliveOnTimeout);
    return this;
  }

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public final ListSFTP removeSendKeepAliveOnTimeout() {
    properties.remove(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListSFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListSFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListSFTP, ListSFTP> configurator) {
    return configurator.apply(new ListSFTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListSFTP.class) final Closure<ListSFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListSFTP.class, com.tibtech.nifi.processors.standard.ListSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListSFTP, ListSFTP> configurator) {
    return configurator.apply(new ListSFTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListSFTP.class) final Closure<ListSFTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListSFTP.class, com.tibtech.nifi.processors.standard.ListSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
