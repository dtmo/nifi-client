package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchSFTP {
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

  private final Map<String, String> properties = new HashMap<String, String>();

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
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public final String getMoveDestinationDirectory() {
    return properties.get(MOVE_DESTINATION_DIRECTORY_PROPERTY);
  }

  /**
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public final FetchSFTP setMoveDestinationDirectory(final String moveDestinationDirectory) {
    properties.put(MOVE_DESTINATION_DIRECTORY_PROPERTY, moveDestinationDirectory);
    return this;
  }

  /**
   * The directory on the remote server to the move the original file to once it has been ingested into NiFi. This property is ignored unless the Completion Strategy is set to "Move File". The specified directory must already exist onthe remote system, or the rename will fail.
   */
  public final FetchSFTP removeMoveDestinationDirectory() {
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

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchSFTP.class) final Closure<FetchSFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchSFTP.class, com.tibtech.nifi.processors.standard.FetchSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
