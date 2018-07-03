package com.tibtech.nifi.processors.hadoop;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHDFS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hadoop.PutHDFS";

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public static final String HADOOP_CONFIGURATION_RESOURCES_PROPERTY = "Hadoop Configuration Resources";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public static final String KERBEROS_RELOGIN_PERIOD_PROPERTY = "Kerberos Relogin Period";

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public static final String ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY = "Additional Classpath Resources";

  /**
   * The parent HDFS directory to which files should be written
   */
  public static final String DIRECTORY_PROPERTY = "Directory";

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public static final String CONFLICT_RESOLUTION_STRATEGY_PROPERTY = "Conflict Resolution Strategy";

  /**
   * Size of each block as written to HDFS. This overrides the Hadoop Configuration
   */
  public static final String BLOCK_SIZE_PROPERTY = "Block Size";

  /**
   * Amount of memory to use to buffer file contents during IO. This overrides the Hadoop Configuration
   */
  public static final String IO_BUFFER_SIZE_PROPERTY = "IO Buffer Size";

  /**
   * Number of times that HDFS will replicate each file. This overrides the Hadoop Configuration
   */
  public static final String REPLICATION_PROPERTY = "Replication";

  /**
   * A umask represented as an octal number which determines the permissions of files written to HDFS. This overrides the Hadoop Configuration dfs.umaskmode
   */
  public static final String PERMISSIONS_UMASK_PROPERTY = "Permissions umask";

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public static final String REMOTE_OWNER_PROPERTY = "Remote Owner";

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public static final String REMOTE_GROUP_PROPERTY = "Remote Group";

  /**
   *
   */
  public static final String COMPRESSION_CODEC_PROPERTY = "Compression codec";

  private final Map<String, String> properties;

  public PutHDFS() {
    this.properties = new HashMap<>();
  }

  public PutHDFS(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final String getHadoopConfigurationResources() {
    return properties.get(HADOOP_CONFIGURATION_RESOURCES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final PutHDFS setHadoopConfigurationResources(final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final PutHDFS removeHadoopConfigurationResources() {
    properties.remove(HADOOP_CONFIGURATION_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosPrincipal() {
    return properties.get(KERBEROS_PRINCIPAL_PROPERTY);
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHDFS setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHDFS removeKerberosPrincipal() {
    properties.remove(KERBEROS_PRINCIPAL_PROPERTY);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosKeytab() {
    return properties.get(KERBEROS_KEYTAB_PROPERTY);
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHDFS setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHDFS removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final String getKerberosReloginPeriod() {
    return properties.get(KERBEROS_RELOGIN_PERIOD_PROPERTY);
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final PutHDFS setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final PutHDFS removeKerberosReloginPeriod() {
    properties.remove(KERBEROS_RELOGIN_PERIOD_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final String getAdditionalClasspathResources() {
    return properties.get(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final PutHDFS setAdditionalClasspathResources(final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final PutHDFS removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * The parent HDFS directory to which files should be written
   */
  public final String getDirectory() {
    return properties.get(DIRECTORY_PROPERTY);
  }

  /**
   * The parent HDFS directory to which files should be written
   */
  public final PutHDFS setDirectory(final String directory) {
    properties.put(DIRECTORY_PROPERTY, directory);
    return this;
  }

  /**
   * The parent HDFS directory to which files should be written
   */
  public final PutHDFS removeDirectory() {
    properties.remove(DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final String getConflictResolutionStrategy() {
    return properties.get(CONFLICT_RESOLUTION_STRATEGY_PROPERTY);
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final PutHDFS setConflictResolutionStrategy(final String conflictResolutionStrategy) {
    properties.put(CONFLICT_RESOLUTION_STRATEGY_PROPERTY, conflictResolutionStrategy);
    return this;
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final PutHDFS removeConflictResolutionStrategy() {
    properties.remove(CONFLICT_RESOLUTION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Size of each block as written to HDFS. This overrides the Hadoop Configuration
   */
  public final String getBlockSize() {
    return properties.get(BLOCK_SIZE_PROPERTY);
  }

  /**
   * Size of each block as written to HDFS. This overrides the Hadoop Configuration
   */
  public final PutHDFS setBlockSize(final String blockSize) {
    properties.put(BLOCK_SIZE_PROPERTY, blockSize);
    return this;
  }

  /**
   * Size of each block as written to HDFS. This overrides the Hadoop Configuration
   */
  public final PutHDFS removeBlockSize() {
    properties.remove(BLOCK_SIZE_PROPERTY);
    return this;
  }

  /**
   * Amount of memory to use to buffer file contents during IO. This overrides the Hadoop Configuration
   */
  public final String getIoBufferSize() {
    return properties.get(IO_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Amount of memory to use to buffer file contents during IO. This overrides the Hadoop Configuration
   */
  public final PutHDFS setIoBufferSize(final String ioBufferSize) {
    properties.put(IO_BUFFER_SIZE_PROPERTY, ioBufferSize);
    return this;
  }

  /**
   * Amount of memory to use to buffer file contents during IO. This overrides the Hadoop Configuration
   */
  public final PutHDFS removeIoBufferSize() {
    properties.remove(IO_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * Number of times that HDFS will replicate each file. This overrides the Hadoop Configuration
   */
  public final String getReplication() {
    return properties.get(REPLICATION_PROPERTY);
  }

  /**
   * Number of times that HDFS will replicate each file. This overrides the Hadoop Configuration
   */
  public final PutHDFS setReplication(final String replication) {
    properties.put(REPLICATION_PROPERTY, replication);
    return this;
  }

  /**
   * Number of times that HDFS will replicate each file. This overrides the Hadoop Configuration
   */
  public final PutHDFS removeReplication() {
    properties.remove(REPLICATION_PROPERTY);
    return this;
  }

  /**
   * A umask represented as an octal number which determines the permissions of files written to HDFS. This overrides the Hadoop Configuration dfs.umaskmode
   */
  public final String getPermissionsUmask() {
    return properties.get(PERMISSIONS_UMASK_PROPERTY);
  }

  /**
   * A umask represented as an octal number which determines the permissions of files written to HDFS. This overrides the Hadoop Configuration dfs.umaskmode
   */
  public final PutHDFS setPermissionsUmask(final String permissionsUmask) {
    properties.put(PERMISSIONS_UMASK_PROPERTY, permissionsUmask);
    return this;
  }

  /**
   * A umask represented as an octal number which determines the permissions of files written to HDFS. This overrides the Hadoop Configuration dfs.umaskmode
   */
  public final PutHDFS removePermissionsUmask() {
    properties.remove(PERMISSIONS_UMASK_PROPERTY);
    return this;
  }

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public final String getRemoteOwner() {
    return properties.get(REMOTE_OWNER_PROPERTY);
  }

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public final PutHDFS setRemoteOwner(final String remoteOwner) {
    properties.put(REMOTE_OWNER_PROPERTY, remoteOwner);
    return this;
  }

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public final PutHDFS removeRemoteOwner() {
    properties.remove(REMOTE_OWNER_PROPERTY);
    return this;
  }

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public final String getRemoteGroup() {
    return properties.get(REMOTE_GROUP_PROPERTY);
  }

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public final PutHDFS setRemoteGroup(final String remoteGroup) {
    properties.put(REMOTE_GROUP_PROPERTY, remoteGroup);
    return this;
  }

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public final PutHDFS removeRemoteGroup() {
    properties.remove(REMOTE_GROUP_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getCompressionCodec() {
    return properties.get(COMPRESSION_CODEC_PROPERTY);
  }

  /**
   *
   */
  public final PutHDFS setCompressionCodec(final String compressionCodec) {
    properties.put(COMPRESSION_CODEC_PROPERTY, compressionCodec);
    return this;
  }

  /**
   *
   */
  public final PutHDFS removeCompressionCodec() {
    properties.remove(COMPRESSION_CODEC_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHDFS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHDFS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutHDFS, PutHDFS> configurator) {
    return configurator.apply(new PutHDFS()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHDFS.class) final Closure<PutHDFS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.PutHDFS> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.PutHDFS.class, com.tibtech.nifi.processors.hadoop.PutHDFS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHDFS, PutHDFS> configurator) {
    return configurator.apply(new PutHDFS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHDFS.class) final Closure<PutHDFS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.PutHDFS> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.PutHDFS.class, com.tibtech.nifi.processors.hadoop.PutHDFS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
