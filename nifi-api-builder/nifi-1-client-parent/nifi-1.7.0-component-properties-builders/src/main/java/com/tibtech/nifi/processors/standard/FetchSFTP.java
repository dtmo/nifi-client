package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchSFTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.FetchSFTP";

  /**
   * The fully-qualified hostname or IP address of the host to fetch the data from
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
   * The fully qualified filename on the remote system
   */
  public static final String REMOTE_FILE_PROPERTY = "Remote File";

  /**
   * Specifies what to do with the original file on the server once it has been pulled into NiFi. If the Completion Strategy fails, a warning will be logged but the data will still be transferred.
   */
  public static final String COMPLETION_STRATEGY_PROPERTY = "Completion Strategy";

  /**
   * The directory on the remote server to move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to 'Move File'. The specified directory must already exist on the remote system if 'Create Directory' is disabled, or the rename will fail.
   */
  public static final String MOVE_DESTINATION_DIRECTORY_PROPERTY = "Move Destination Directory";

  /**
   * Used when 'Completion Strategy' is 'Move File'. Specifies whether or not the remote directory should be created if it does not exist.
   */
  public static final String CREATE_DIRECTORY_PROPERTY = "Create Directory";

  /**
   * Control how 'Move Destination Directory' is created when 'Completion Strategy' is 'Move File' and 'Create Directory' is enabled. If set to 'true', directory listing is not performed prior to create missing directories. By default, this processor executes a directory listing command to see target directory existence before creating missing directories. However, there are situations that you might need to disable the directory listing such as the following. Directory listing might fail with some permission setups (e.g. chmod 100) on a directory. Also, if any other SFTP client created the directory after this processor performed a listing and before a directory creation request by this processor is finished, then an error is returned because the directory already exists.
   */
  public static final String DISABLE_DIRECTORY_LISTING_PROPERTY = "Disable Directory Listing";

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

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public static final String HOST_KEY_FILE_PROPERTY = "Host Key File";

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public static final String STRICT_HOST_KEY_CHECKING_PROPERTY = "Strict Host Key Checking";

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public static final String USE_COMPRESSION_PROPERTY = "Use Compression";

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

  public FetchSFTP() {
    this.properties = new HashMap<>();
  }

  public FetchSFTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The fully-qualified hostname or IP address of the host to fetch the data from
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The fully-qualified hostname or IP address of the host to fetch the data from
   */
  public final FetchSFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully-qualified hostname or IP address of the host to fetch the data from
   */
  public final FetchSFTP removeHostname() {
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
  public final FetchSFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public final FetchSFTP removePort() {
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
  public final FetchSFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final FetchSFTP removeUsername() {
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
  public final FetchSFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final FetchSFTP removePassword() {
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
  public final FetchSFTP setPrivateKeyPath(final String privateKeyPath) {
    properties.put(PRIVATE_KEY_PATH_PROPERTY, privateKeyPath);
    return this;
  }

  /**
   * The fully qualified path to the Private Key file
   */
  public final FetchSFTP removePrivateKeyPath() {
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
  public final FetchSFTP setPrivateKeyPassphrase(final String privateKeyPassphrase) {
    properties.put(PRIVATE_KEY_PASSPHRASE_PROPERTY, privateKeyPassphrase);
    return this;
  }

  /**
   * Password for the private key
   */
  public final FetchSFTP removePrivateKeyPassphrase() {
    properties.remove(PRIVATE_KEY_PASSPHRASE_PROPERTY);
    return this;
  }

  /**
   * The fully qualified filename on the remote system
   */
  public final String getRemoteFile() {
    return properties.get(REMOTE_FILE_PROPERTY);
  }

  /**
   * The fully qualified filename on the remote system
   */
  public final FetchSFTP setRemoteFile(final String remoteFile) {
    properties.put(REMOTE_FILE_PROPERTY, remoteFile);
    return this;
  }

  /**
   * The fully qualified filename on the remote system
   */
  public final FetchSFTP removeRemoteFile() {
    properties.remove(REMOTE_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies what to do with the original file on the server once it has been pulled into NiFi. If the Completion Strategy fails, a warning will be logged but the data will still be transferred.
   */
  public final String getCompletionStrategy() {
    return properties.get(COMPLETION_STRATEGY_PROPERTY);
  }

  /**
   * Specifies what to do with the original file on the server once it has been pulled into NiFi. If the Completion Strategy fails, a warning will be logged but the data will still be transferred.
   */
  public final FetchSFTP setCompletionStrategy(final String completionStrategy) {
    properties.put(COMPLETION_STRATEGY_PROPERTY, completionStrategy);
    return this;
  }

  /**
   * Specifies what to do with the original file on the server once it has been pulled into NiFi. If the Completion Strategy fails, a warning will be logged but the data will still be transferred.
   */
  public final FetchSFTP removeCompletionStrategy() {
    properties.remove(COMPLETION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The directory on the remote server to move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to 'Move File'. The specified directory must already exist on the remote system if 'Create Directory' is disabled, or the rename will fail.
   */
  public final String getMoveDestinationDirectory() {
    return properties.get(MOVE_DESTINATION_DIRECTORY_PROPERTY);
  }

  /**
   * The directory on the remote server to move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to 'Move File'. The specified directory must already exist on the remote system if 'Create Directory' is disabled, or the rename will fail.
   */
  public final FetchSFTP setMoveDestinationDirectory(final String moveDestinationDirectory) {
    properties.put(MOVE_DESTINATION_DIRECTORY_PROPERTY, moveDestinationDirectory);
    return this;
  }

  /**
   * The directory on the remote server to move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to 'Move File'. The specified directory must already exist on the remote system if 'Create Directory' is disabled, or the rename will fail.
   */
  public final FetchSFTP removeMoveDestinationDirectory() {
    properties.remove(MOVE_DESTINATION_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Used when 'Completion Strategy' is 'Move File'. Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final String getCreateDirectory() {
    return properties.get(CREATE_DIRECTORY_PROPERTY);
  }

  /**
   * Used when 'Completion Strategy' is 'Move File'. Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final FetchSFTP setCreateDirectory(final String createDirectory) {
    properties.put(CREATE_DIRECTORY_PROPERTY, createDirectory);
    return this;
  }

  /**
   * Used when 'Completion Strategy' is 'Move File'. Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final FetchSFTP removeCreateDirectory() {
    properties.remove(CREATE_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Control how 'Move Destination Directory' is created when 'Completion Strategy' is 'Move File' and 'Create Directory' is enabled. If set to 'true', directory listing is not performed prior to create missing directories. By default, this processor executes a directory listing command to see target directory existence before creating missing directories. However, there are situations that you might need to disable the directory listing such as the following. Directory listing might fail with some permission setups (e.g. chmod 100) on a directory. Also, if any other SFTP client created the directory after this processor performed a listing and before a directory creation request by this processor is finished, then an error is returned because the directory already exists.
   */
  public final String getDisableDirectoryListing() {
    return properties.get(DISABLE_DIRECTORY_LISTING_PROPERTY);
  }

  /**
   * Control how 'Move Destination Directory' is created when 'Completion Strategy' is 'Move File' and 'Create Directory' is enabled. If set to 'true', directory listing is not performed prior to create missing directories. By default, this processor executes a directory listing command to see target directory existence before creating missing directories. However, there are situations that you might need to disable the directory listing such as the following. Directory listing might fail with some permission setups (e.g. chmod 100) on a directory. Also, if any other SFTP client created the directory after this processor performed a listing and before a directory creation request by this processor is finished, then an error is returned because the directory already exists.
   */
  public final FetchSFTP setDisableDirectoryListing(final String disableDirectoryListing) {
    properties.put(DISABLE_DIRECTORY_LISTING_PROPERTY, disableDirectoryListing);
    return this;
  }

  /**
   * Control how 'Move Destination Directory' is created when 'Completion Strategy' is 'Move File' and 'Create Directory' is enabled. If set to 'true', directory listing is not performed prior to create missing directories. By default, this processor executes a directory listing command to see target directory existence before creating missing directories. However, there are situations that you might need to disable the directory listing such as the following. Directory listing might fail with some permission setups (e.g. chmod 100) on a directory. Also, if any other SFTP client created the directory after this processor performed a listing and before a directory creation request by this processor is finished, then an error is returned because the directory already exists.
   */
  public final FetchSFTP removeDisableDirectoryListing() {
    properties.remove(DISABLE_DIRECTORY_LISTING_PROPERTY);
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
  public final FetchSFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final FetchSFTP removeConnectionTimeout() {
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
  public final FetchSFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final FetchSFTP removeDataTimeout() {
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
  public final FetchSFTP setSendKeepAliveOnTimeout(final String sendKeepAliveOnTimeout) {
    properties.put(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY, sendKeepAliveOnTimeout);
    return this;
  }

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public final FetchSFTP removeSendKeepAliveOnTimeout() {
    properties.remove(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY);
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
  public final FetchSFTP setHostKeyFile(final String hostKeyFile) {
    properties.put(HOST_KEY_FILE_PROPERTY, hostKeyFile);
    return this;
  }

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public final FetchSFTP removeHostKeyFile() {
    properties.remove(HOST_KEY_FILE_PROPERTY);
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
  public final FetchSFTP setStrictHostKeyChecking(final String strictHostKeyChecking) {
    properties.put(STRICT_HOST_KEY_CHECKING_PROPERTY, strictHostKeyChecking);
    return this;
  }

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public final FetchSFTP removeStrictHostKeyChecking() {
    properties.remove(STRICT_HOST_KEY_CHECKING_PROPERTY);
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
  public final FetchSFTP setUseCompression(final String useCompression) {
    properties.put(USE_COMPRESSION_PROPERTY, useCompression);
    return this;
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final FetchSFTP removeUseCompression() {
    properties.remove(USE_COMPRESSION_PROPERTY);
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
  public final FetchSFTP setProxyConfigurationService(final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS + AuthN
   */
  public final FetchSFTP removeProxyConfigurationService() {
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
  public final FetchSFTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final FetchSFTP removeProxyType() {
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
  public final FetchSFTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final FetchSFTP removeProxyHost() {
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
  public final FetchSFTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final FetchSFTP removeProxyPort() {
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
  public final FetchSFTP setHttpProxyUsername(final String httpProxyUsername) {
    properties.put(HTTP_PROXY_USERNAME_PROPERTY, httpProxyUsername);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final FetchSFTP removeHttpProxyUsername() {
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
  public final FetchSFTP setHttpProxyPassword(final String httpProxyPassword) {
    properties.put(HTTP_PROXY_PASSWORD_PROPERTY, httpProxyPassword);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final FetchSFTP removeHttpProxyPassword() {
    properties.remove(HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchSFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchSFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<FetchSFTP, FetchSFTP> configurator) {
    return configurator.apply(new FetchSFTP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchSFTP.class) final Closure<FetchSFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchSFTP.class, com.tibtech.nifi.processors.standard.FetchSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchSFTP, FetchSFTP> configurator) {
    return configurator.apply(new FetchSFTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchSFTP.class) final Closure<FetchSFTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchSFTP.class, com.tibtech.nifi.processors.standard.FetchSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
