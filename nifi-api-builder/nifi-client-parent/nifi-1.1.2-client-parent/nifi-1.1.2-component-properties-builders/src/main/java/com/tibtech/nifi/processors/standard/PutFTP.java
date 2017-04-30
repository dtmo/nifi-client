package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutFTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutFTP";

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
   * The path on the remote system from which to pull or push files
   */
  public static final String REMOTE_PATH_PROPERTY = "Remote Path";

  /**
   * Specifies whether or not the remote directory should be created if it does not exist.
   */
  public static final String CREATE_DIRECTORY_PROPERTY = "Create Directory";

  /**
   * The maximum number of FlowFiles to send in a single connection
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * Determines how to handle the problem of filename collisions
   */
  public static final String CONFLICT_RESOLUTION_PROPERTY = "Conflict Resolution";

  /**
   * If true, then the filename of the sent file is prepended with a "." and then renamed back to the original once the file is completely sent. Otherwise, there is no rename. This property is ignored if the Temporary Filename property is set.
   */
  public static final String DOT_RENAME_PROPERTY = "Dot Rename";

  /**
   * If set, the filename of the sent file will be equal to the value specified during the transfer and after successful completion will be renamed to the original filename. If this value is set, the Dot Rename property is ignored.
   */
  public static final String TEMPORARY_FILENAME_PROPERTY = "Temporary Filename";

  /**
   * The FTP Transfer Mode
   */
  public static final String TRANSFER_MODE_PROPERTY = "Transfer Mode";

  /**
   * The FTP Connection Mode
   */
  public static final String CONNECTION_MODE_PROPERTY = "Connection Mode";

  /**
   * Determines whether or not Zero-byte files should be rejected without attempting to transfer
   */
  public static final String REJECT_ZERO_BYTE_FILES_PROPERTY = "Reject Zero-Byte Files";

  /**
   * The lastModifiedTime to assign to the file after transferring it. If not set, the lastModifiedTime will not be changed. Format must be yyyy-MM-dd'T'HH:mm:ssZ. You may also use expression language such as ${file.lastModifiedTime}. If the value is invalid, the processor will not be invalid but will fail to change lastModifiedTime of the file.
   */
  public static final String LAST_MODIFIED_TIME_PROPERTY = "Last Modified Time";

  /**
   * The permissions to assign to the file after transferring it. Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644). If not set, the permissions will not be changed. You may also use expression language such as ${file.permissions}. If the value is invalid, the processor will not be invalid but will fail to change permissions of the file.
   */
  public static final String PERMISSIONS_PROPERTY = "Permissions";

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public static final String USE_COMPRESSION_PROPERTY = "Use Compression";

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
  public final PutFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final PutFTP removeHostname() {
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
  public final PutFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port that the remote system is listening on for file transfers
   */
  public final PutFTP removePort() {
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
  public final PutFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final PutFTP removeUsername() {
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
  public final PutFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final PutFTP removePassword() {
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
  public final PutFTP setRemotePath(final String remotePath) {
    properties.put(REMOTE_PATH_PROPERTY, remotePath);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final PutFTP removeRemotePath() {
    properties.remove(REMOTE_PATH_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final String getCreateDirectory() {
    return properties.get(CREATE_DIRECTORY_PROPERTY);
  }

  /**
   * Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final PutFTP setCreateDirectory(final String createDirectory) {
    properties.put(CREATE_DIRECTORY_PROPERTY, createDirectory);
    return this;
  }

  /**
   * Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final PutFTP removeCreateDirectory() {
    properties.remove(CREATE_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * The maximum number of FlowFiles to send in a single connection
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of FlowFiles to send in a single connection
   */
  public final PutFTP setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of FlowFiles to send in a single connection
   */
  public final PutFTP removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
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
  public final PutFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final PutFTP removeConnectionTimeout() {
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
  public final PutFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final PutFTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Determines how to handle the problem of filename collisions
   */
  public final String getConflictResolution() {
    return properties.get(CONFLICT_RESOLUTION_PROPERTY);
  }

  /**
   * Determines how to handle the problem of filename collisions
   */
  public final PutFTP setConflictResolution(final String conflictResolution) {
    properties.put(CONFLICT_RESOLUTION_PROPERTY, conflictResolution);
    return this;
  }

  /**
   * Determines how to handle the problem of filename collisions
   */
  public final PutFTP removeConflictResolution() {
    properties.remove(CONFLICT_RESOLUTION_PROPERTY);
    return this;
  }

  /**
   * If true, then the filename of the sent file is prepended with a "." and then renamed back to the original once the file is completely sent. Otherwise, there is no rename. This property is ignored if the Temporary Filename property is set.
   */
  public final String getDotRename() {
    return properties.get(DOT_RENAME_PROPERTY);
  }

  /**
   * If true, then the filename of the sent file is prepended with a "." and then renamed back to the original once the file is completely sent. Otherwise, there is no rename. This property is ignored if the Temporary Filename property is set.
   */
  public final PutFTP setDotRename(final String dotRename) {
    properties.put(DOT_RENAME_PROPERTY, dotRename);
    return this;
  }

  /**
   * If true, then the filename of the sent file is prepended with a "." and then renamed back to the original once the file is completely sent. Otherwise, there is no rename. This property is ignored if the Temporary Filename property is set.
   */
  public final PutFTP removeDotRename() {
    properties.remove(DOT_RENAME_PROPERTY);
    return this;
  }

  /**
   * If set, the filename of the sent file will be equal to the value specified during the transfer and after successful completion will be renamed to the original filename. If this value is set, the Dot Rename property is ignored.
   */
  public final String getTemporaryFilename() {
    return properties.get(TEMPORARY_FILENAME_PROPERTY);
  }

  /**
   * If set, the filename of the sent file will be equal to the value specified during the transfer and after successful completion will be renamed to the original filename. If this value is set, the Dot Rename property is ignored.
   */
  public final PutFTP setTemporaryFilename(final String temporaryFilename) {
    properties.put(TEMPORARY_FILENAME_PROPERTY, temporaryFilename);
    return this;
  }

  /**
   * If set, the filename of the sent file will be equal to the value specified during the transfer and after successful completion will be renamed to the original filename. If this value is set, the Dot Rename property is ignored.
   */
  public final PutFTP removeTemporaryFilename() {
    properties.remove(TEMPORARY_FILENAME_PROPERTY);
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
  public final PutFTP setTransferMode(final String transferMode) {
    properties.put(TRANSFER_MODE_PROPERTY, transferMode);
    return this;
  }

  /**
   * The FTP Transfer Mode
   */
  public final PutFTP removeTransferMode() {
    properties.remove(TRANSFER_MODE_PROPERTY);
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
  public final PutFTP setConnectionMode(final String connectionMode) {
    properties.put(CONNECTION_MODE_PROPERTY, connectionMode);
    return this;
  }

  /**
   * The FTP Connection Mode
   */
  public final PutFTP removeConnectionMode() {
    properties.remove(CONNECTION_MODE_PROPERTY);
    return this;
  }

  /**
   * Determines whether or not Zero-byte files should be rejected without attempting to transfer
   */
  public final String getRejectZeroByteFiles() {
    return properties.get(REJECT_ZERO_BYTE_FILES_PROPERTY);
  }

  /**
   * Determines whether or not Zero-byte files should be rejected without attempting to transfer
   */
  public final PutFTP setRejectZeroByteFiles(final String rejectZeroByteFiles) {
    properties.put(REJECT_ZERO_BYTE_FILES_PROPERTY, rejectZeroByteFiles);
    return this;
  }

  /**
   * Determines whether or not Zero-byte files should be rejected without attempting to transfer
   */
  public final PutFTP removeRejectZeroByteFiles() {
    properties.remove(REJECT_ZERO_BYTE_FILES_PROPERTY);
    return this;
  }

  /**
   * The lastModifiedTime to assign to the file after transferring it. If not set, the lastModifiedTime will not be changed. Format must be yyyy-MM-dd'T'HH:mm:ssZ. You may also use expression language such as ${file.lastModifiedTime}. If the value is invalid, the processor will not be invalid but will fail to change lastModifiedTime of the file.
   */
  public final String getLastModifiedTime() {
    return properties.get(LAST_MODIFIED_TIME_PROPERTY);
  }

  /**
   * The lastModifiedTime to assign to the file after transferring it. If not set, the lastModifiedTime will not be changed. Format must be yyyy-MM-dd'T'HH:mm:ssZ. You may also use expression language such as ${file.lastModifiedTime}. If the value is invalid, the processor will not be invalid but will fail to change lastModifiedTime of the file.
   */
  public final PutFTP setLastModifiedTime(final String lastModifiedTime) {
    properties.put(LAST_MODIFIED_TIME_PROPERTY, lastModifiedTime);
    return this;
  }

  /**
   * The lastModifiedTime to assign to the file after transferring it. If not set, the lastModifiedTime will not be changed. Format must be yyyy-MM-dd'T'HH:mm:ssZ. You may also use expression language such as ${file.lastModifiedTime}. If the value is invalid, the processor will not be invalid but will fail to change lastModifiedTime of the file.
   */
  public final PutFTP removeLastModifiedTime() {
    properties.remove(LAST_MODIFIED_TIME_PROPERTY);
    return this;
  }

  /**
   * The permissions to assign to the file after transferring it. Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644). If not set, the permissions will not be changed. You may also use expression language such as ${file.permissions}. If the value is invalid, the processor will not be invalid but will fail to change permissions of the file.
   */
  public final String getPermissions() {
    return properties.get(PERMISSIONS_PROPERTY);
  }

  /**
   * The permissions to assign to the file after transferring it. Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644). If not set, the permissions will not be changed. You may also use expression language such as ${file.permissions}. If the value is invalid, the processor will not be invalid but will fail to change permissions of the file.
   */
  public final PutFTP setPermissions(final String permissions) {
    properties.put(PERMISSIONS_PROPERTY, permissions);
    return this;
  }

  /**
   * The permissions to assign to the file after transferring it. Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644). If not set, the permissions will not be changed. You may also use expression language such as ${file.permissions}. If the value is invalid, the processor will not be invalid but will fail to change permissions of the file.
   */
  public final PutFTP removePermissions() {
    properties.remove(PERMISSIONS_PROPERTY);
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
  public final PutFTP setUseCompression(final String useCompression) {
    properties.put(USE_COMPRESSION_PROPERTY, useCompression);
    return this;
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final PutFTP removeUseCompression() {
    properties.remove(USE_COMPRESSION_PROPERTY);
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
  public final PutFTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type used for file transfers
   */
  public final PutFTP removeProxyType() {
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
  public final PutFTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final PutFTP removeProxyHost() {
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
  public final PutFTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final PutFTP removeProxyPort() {
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
  public final PutFTP setHttpProxyUsername(final String httpProxyUsername) {
    properties.put(HTTP_PROXY_USERNAME_PROPERTY, httpProxyUsername);
    return this;
  }

  /**
   * Http Proxy Username
   */
  public final PutFTP removeHttpProxyUsername() {
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
  public final PutFTP setHttpProxyPassword(final String httpProxyPassword) {
    properties.put(HTTP_PROXY_PASSWORD_PROPERTY, httpProxyPassword);
    return this;
  }

  /**
   * Http Proxy Password
   */
  public final PutFTP removeHttpProxyPassword() {
    properties.remove(HTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutFTP, PutFTP> configurator) {
    return configurator.apply(new PutFTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutFTP.class) final Closure<PutFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutFTP.class, com.tibtech.nifi.processors.standard.PutFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
