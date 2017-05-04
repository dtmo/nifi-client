package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchFTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.FetchFTP";

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
   * The fully qualified filename on the remote system
   */
  public static final String REMOTE_FILE_PROPERTY = "Remote File";

  /**
   * Specifies what to do with the original file on the server once it has been pulled into NiFi. If the Completion Strategy fails, a warning will be logged but the data will still be transferred.
   */
  public static final String COMPLETION_STRATEGY_PROPERTY = "Completion Strategy";

  /**
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public static final String MOVE_DESTINATION_DIRECTORY_PROPERTY = "Move Destination Directory";

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public static final String USE_COMPRESSION_PROPERTY = "Use Compression";

  /**
   * The FTP Connection Mode
   */
  public static final String CONNECTION_MODE_PROPERTY = "Connection Mode";

  /**
   * The FTP Transfer Mode
   */
  public static final String TRANSFER_MODE_PROPERTY = "Transfer Mode";

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

  public FetchFTP() {
    this.properties = new HashMap<>();
  }

  public FetchFTP(final Map<String, String> properties) {
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
  public final FetchFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully-qualified hostname or IP address of the host to fetch the data from
   */
  public final FetchFTP removeHostname() {
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
  public final FetchFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to connect to on the remote host to fetch the data from
   */
  public final FetchFTP removePort() {
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
  public final FetchFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final FetchFTP removeUsername() {
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
  public final FetchFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final FetchFTP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
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
  public final FetchFTP setRemoteFile(final String remoteFile) {
    properties.put(REMOTE_FILE_PROPERTY, remoteFile);
    return this;
  }

  /**
   * The fully qualified filename on the remote system
   */
  public final FetchFTP removeRemoteFile() {
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
  public final FetchFTP setCompletionStrategy(final String completionStrategy) {
    properties.put(COMPLETION_STRATEGY_PROPERTY, completionStrategy);
    return this;
  }

  /**
   * Specifies what to do with the original file on the server once it has been pulled into NiFi. If the Completion Strategy fails, a warning will be logged but the data will still be transferred.
   */
  public final FetchFTP removeCompletionStrategy() {
    properties.remove(COMPLETION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public final String getMoveDestinationDirectory() {
    return properties.get(MOVE_DESTINATION_DIRECTORY_PROPERTY);
  }

  /**
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public final FetchFTP setMoveDestinationDirectory(final String moveDestinationDirectory) {
    properties.put(MOVE_DESTINATION_DIRECTORY_PROPERTY, moveDestinationDirectory);
    return this;
  }

  /**
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public final FetchFTP removeMoveDestinationDirectory() {
    properties.remove(MOVE_DESTINATION_DIRECTORY_PROPERTY);
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
  public final FetchFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final FetchFTP removeConnectionTimeout() {
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
  public final FetchFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final FetchFTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
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
  public final FetchFTP setUseCompression(final String useCompression) {
    properties.put(USE_COMPRESSION_PROPERTY, useCompression);
    return this;
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final FetchFTP removeUseCompression() {
    properties.remove(USE_COMPRESSION_PROPERTY);
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
  public final FetchFTP setConnectionMode(final String connectionMode) {
    properties.put(CONNECTION_MODE_PROPERTY, connectionMode);
    return this;
  }

  /**
   * The FTP Connection Mode
   */
  public final FetchFTP removeConnectionMode() {
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
  public final FetchFTP setTransferMode(final String transferMode) {
    properties.put(TRANSFER_MODE_PROPERTY, transferMode);
    return this;
  }

  /**
   * The FTP Transfer Mode
   */
  public final FetchFTP removeTransferMode() {
    properties.remove(TRANSFER_MODE_PROPERTY);
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
  public final FetchFTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final FetchFTP removeProxyType() {
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
  public final FetchFTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final FetchFTP removeProxyHost() {
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
  public final FetchFTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final FetchFTP removeProxyPort() {
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
  public final FetchFTP setHttpProxyUsername(final String httpProxyUsername) {
    properties.put(HTTP_PROXY_USERNAME_PROPERTY, httpProxyUsername);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final FetchFTP removeHttpProxyUsername() {
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
  public final FetchFTP setHttpProxyPassword(final String httpProxyPassword) {
    properties.put(HTTP_PROXY_PASSWORD_PROPERTY, httpProxyPassword);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final FetchFTP removeHttpProxyPassword() {
    properties.remove(HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<FetchFTP, FetchFTP> configurator) {
    return configurator.apply(new FetchFTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchFTP.class) final Closure<FetchFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchFTP.class, com.tibtech.nifi.processors.standard.FetchFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchFTP, FetchFTP> configurator) {
    return configurator.apply(new FetchFTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchFTP.class) final Closure<FetchFTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchFTP.class, com.tibtech.nifi.processors.standard.FetchFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
