package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSFTP {
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
   * Determines whether or not Zero-byte files should be rejected without attempting to transfer
   */
  public static final String REJECT_ZERO_BYTE_FILES_PROPERTY = "Reject Zero-Byte Files";

  /**
   * If true, then the filename of the sent file is prepended with a "." and then renamed back to the original once the file is completely sent. Otherwise, there is no rename. This property is ignored if the Temporary Filename property is set.
   */
  public static final String DOT_RENAME_PROPERTY = "Dot Rename";

  /**
   * If set, the filename of the sent file will be equal to the value specified during the transfer and after successful completion will be renamed to the original filename. If this value is set, the Dot Rename property is ignored.
   */
  public static final String TEMPORARY_FILENAME_PROPERTY = "Temporary Filename";

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public static final String HOST_KEY_FILE_PROPERTY = "Host Key File";

  /**
   * The lastModifiedTime to assign to the file after transferring it. If not set, the lastModifiedTime will not be changed. Format must be yyyy-MM-dd'T'HH:mm:ssZ. You may also use expression language such as ${file.lastModifiedTime}. If the value is invalid, the processor will not be invalid but will fail to change lastModifiedTime of the file.
   */
  public static final String LAST_MODIFIED_TIME_PROPERTY = "Last Modified Time";

  /**
   * The permissions to assign to the file after transferring it. Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644). If not set, the permissions will not be changed. You may also use expression language such as ${file.permissions}. If the value is invalid, the processor will not be invalid but will fail to change permissions of the file.
   */
  public static final String PERMISSIONS_PROPERTY = "Permissions";

  /**
   * Integer value representing the User ID to set on the file after transferring it. If not set, the owner will not be set. You may also use expression language such as ${file.owner}. If the value is invalid, the processor will not be invalid but will fail to change the owner of the file.
   */
  public static final String REMOTE_OWNER_PROPERTY = "Remote Owner";

  /**
   * Integer value representing the Group ID to set on the file after transferring it. If not set, the group will not be set. You may also use expression language such as ${file.group}. If the value is invalid, the processor will not be invalid but will fail to change the group of the file.
   */
  public static final String REMOTE_GROUP_PROPERTY = "Remote Group";

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
  public final PutSFTP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the remote system
   */
  public final PutSFTP removeHostname() {
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
  public final PutSFTP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port that the remote system is listening on for file transfers
   */
  public final PutSFTP removePort() {
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
  public final PutSFTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username
   */
  public final PutSFTP removeUsername() {
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
  public final PutSFTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password for the user account
   */
  public final PutSFTP removePassword() {
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
  public final PutSFTP setPrivateKeyPath(final String privateKeyPath) {
    properties.put(PRIVATE_KEY_PATH_PROPERTY, privateKeyPath);
    return this;
  }

  /**
   * The fully qualified path to the Private Key file
   */
  public final PutSFTP removePrivateKeyPath() {
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
  public final PutSFTP setPrivateKeyPassphrase(final String privateKeyPassphrase) {
    properties.put(PRIVATE_KEY_PASSPHRASE_PROPERTY, privateKeyPassphrase);
    return this;
  }

  /**
   * Password for the private key
   */
  public final PutSFTP removePrivateKeyPassphrase() {
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
  public final PutSFTP setRemotePath(final String remotePath) {
    properties.put(REMOTE_PATH_PROPERTY, remotePath);
    return this;
  }

  /**
   * The path on the remote system from which to pull or push files
   */
  public final PutSFTP removeRemotePath() {
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
  public final PutSFTP setCreateDirectory(final String createDirectory) {
    properties.put(CREATE_DIRECTORY_PROPERTY, createDirectory);
    return this;
  }

  /**
   * Specifies whether or not the remote directory should be created if it does not exist.
   */
  public final PutSFTP removeCreateDirectory() {
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
  public final PutSFTP setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of FlowFiles to send in a single connection
   */
  public final PutSFTP removeBatchSize() {
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
  public final PutSFTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Amount of time to wait before timing out while creating a connection
   */
  public final PutSFTP removeConnectionTimeout() {
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
  public final PutSFTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * When transferring a file between the local and remote system, this value specifies how long is allowed to elapse without any data being transferred between systems
   */
  public final PutSFTP removeDataTimeout() {
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
  public final PutSFTP setConflictResolution(final String conflictResolution) {
    properties.put(CONFLICT_RESOLUTION_PROPERTY, conflictResolution);
    return this;
  }

  /**
   * Determines how to handle the problem of filename collisions
   */
  public final PutSFTP removeConflictResolution() {
    properties.remove(CONFLICT_RESOLUTION_PROPERTY);
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
  public final PutSFTP setRejectZeroByteFiles(final String rejectZeroByteFiles) {
    properties.put(REJECT_ZERO_BYTE_FILES_PROPERTY, rejectZeroByteFiles);
    return this;
  }

  /**
   * Determines whether or not Zero-byte files should be rejected without attempting to transfer
   */
  public final PutSFTP removeRejectZeroByteFiles() {
    properties.remove(REJECT_ZERO_BYTE_FILES_PROPERTY);
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
  public final PutSFTP setDotRename(final String dotRename) {
    properties.put(DOT_RENAME_PROPERTY, dotRename);
    return this;
  }

  /**
   * If true, then the filename of the sent file is prepended with a "." and then renamed back to the original once the file is completely sent. Otherwise, there is no rename. This property is ignored if the Temporary Filename property is set.
   */
  public final PutSFTP removeDotRename() {
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
  public final PutSFTP setTemporaryFilename(final String temporaryFilename) {
    properties.put(TEMPORARY_FILENAME_PROPERTY, temporaryFilename);
    return this;
  }

  /**
   * If set, the filename of the sent file will be equal to the value specified during the transfer and after successful completion will be renamed to the original filename. If this value is set, the Dot Rename property is ignored.
   */
  public final PutSFTP removeTemporaryFilename() {
    properties.remove(TEMPORARY_FILENAME_PROPERTY);
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
  public final PutSFTP setHostKeyFile(final String hostKeyFile) {
    properties.put(HOST_KEY_FILE_PROPERTY, hostKeyFile);
    return this;
  }

  /**
   * If supplied, the given file will be used as the Host Key; otherwise, no use host key file will be used
   */
  public final PutSFTP removeHostKeyFile() {
    properties.remove(HOST_KEY_FILE_PROPERTY);
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
  public final PutSFTP setLastModifiedTime(final String lastModifiedTime) {
    properties.put(LAST_MODIFIED_TIME_PROPERTY, lastModifiedTime);
    return this;
  }

  /**
   * The lastModifiedTime to assign to the file after transferring it. If not set, the lastModifiedTime will not be changed. Format must be yyyy-MM-dd'T'HH:mm:ssZ. You may also use expression language such as ${file.lastModifiedTime}. If the value is invalid, the processor will not be invalid but will fail to change lastModifiedTime of the file.
   */
  public final PutSFTP removeLastModifiedTime() {
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
  public final PutSFTP setPermissions(final String permissions) {
    properties.put(PERMISSIONS_PROPERTY, permissions);
    return this;
  }

  /**
   * The permissions to assign to the file after transferring it. Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644). If not set, the permissions will not be changed. You may also use expression language such as ${file.permissions}. If the value is invalid, the processor will not be invalid but will fail to change permissions of the file.
   */
  public final PutSFTP removePermissions() {
    properties.remove(PERMISSIONS_PROPERTY);
    return this;
  }

  /**
   * Integer value representing the User ID to set on the file after transferring it. If not set, the owner will not be set. You may also use expression language such as ${file.owner}. If the value is invalid, the processor will not be invalid but will fail to change the owner of the file.
   */
  public final String getRemoteOwner() {
    return properties.get(REMOTE_OWNER_PROPERTY);
  }

  /**
   * Integer value representing the User ID to set on the file after transferring it. If not set, the owner will not be set. You may also use expression language such as ${file.owner}. If the value is invalid, the processor will not be invalid but will fail to change the owner of the file.
   */
  public final PutSFTP setRemoteOwner(final String remoteOwner) {
    properties.put(REMOTE_OWNER_PROPERTY, remoteOwner);
    return this;
  }

  /**
   * Integer value representing the User ID to set on the file after transferring it. If not set, the owner will not be set. You may also use expression language such as ${file.owner}. If the value is invalid, the processor will not be invalid but will fail to change the owner of the file.
   */
  public final PutSFTP removeRemoteOwner() {
    properties.remove(REMOTE_OWNER_PROPERTY);
    return this;
  }

  /**
   * Integer value representing the Group ID to set on the file after transferring it. If not set, the group will not be set. You may also use expression language such as ${file.group}. If the value is invalid, the processor will not be invalid but will fail to change the group of the file.
   */
  public final String getRemoteGroup() {
    return properties.get(REMOTE_GROUP_PROPERTY);
  }

  /**
   * Integer value representing the Group ID to set on the file after transferring it. If not set, the group will not be set. You may also use expression language such as ${file.group}. If the value is invalid, the processor will not be invalid but will fail to change the group of the file.
   */
  public final PutSFTP setRemoteGroup(final String remoteGroup) {
    properties.put(REMOTE_GROUP_PROPERTY, remoteGroup);
    return this;
  }

  /**
   * Integer value representing the Group ID to set on the file after transferring it. If not set, the group will not be set. You may also use expression language such as ${file.group}. If the value is invalid, the processor will not be invalid but will fail to change the group of the file.
   */
  public final PutSFTP removeRemoteGroup() {
    properties.remove(REMOTE_GROUP_PROPERTY);
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
  public final PutSFTP setStrictHostKeyChecking(final String strictHostKeyChecking) {
    properties.put(STRICT_HOST_KEY_CHECKING_PROPERTY, strictHostKeyChecking);
    return this;
  }

  /**
   * Indicates whether or not strict enforcement of hosts keys should be applied
   */
  public final PutSFTP removeStrictHostKeyChecking() {
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
  public final PutSFTP setSendKeepAliveOnTimeout(final String sendKeepAliveOnTimeout) {
    properties.put(SEND_KEEP_ALIVE_ON_TIMEOUT_PROPERTY, sendKeepAliveOnTimeout);
    return this;
  }

  /**
   * Indicates whether or not to send a single Keep Alive message when SSH socket times out
   */
  public final PutSFTP removeSendKeepAliveOnTimeout() {
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
  public final PutSFTP setUseCompression(final String useCompression) {
    properties.put(USE_COMPRESSION_PROPERTY, useCompression);
    return this;
  }

  /**
   * Indicates whether or not ZLIB compression should be used when transferring files
   */
  public final PutSFTP removeUseCompression() {
    properties.remove(USE_COMPRESSION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSFTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSFTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutSFTP, PutSFTP> configurator) {
    return configurator.apply(new PutSFTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSFTP.class) final Closure<PutSFTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutSFTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutSFTP.class, com.tibtech.nifi.processors.standard.PutSFTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
