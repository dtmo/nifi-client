package com.tibtech.nifi.processors.hadoop;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MoveHDFS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hadoop.MoveHDFS";

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public static final String HADOOP_CONFIGURATION_RESOURCES_PROPERTY = "Hadoop Configuration Resources";

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public static final String KERBEROS_CREDENTIALS_SERVICE_PROPERTY = "kerberos-credentials-service";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public static final String KERBEROS_RELOGIN_PERIOD_PROPERTY = "Kerberos Relogin Period";

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public static final String ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY = "Additional Classpath Resources";

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public static final String CONFLICT_RESOLUTION_STRATEGY_PROPERTY = "Conflict Resolution Strategy";

  /**
   * The HDFS directory from which files should be read, or a single file to read.
   */
  public static final String INPUT_DIRECTORY_OR_FILE_PROPERTY = "Input Directory or File";

  /**
   * The HDFS directory where the files will be moved to
   */
  public static final String OUTPUT_DIRECTORY_PROPERTY = "Output Directory";

  /**
   * The operation that will be performed on the source file
   */
  public static final String HDFS_OPERATION_PROPERTY = "HDFS Operation";

  /**
   * A Java Regular Expression for filtering Filenames; if a filter is supplied then only files whose names match that Regular Expression will be fetched, otherwise all files will be fetched
   */
  public static final String FILE_FILTER_REGEX_PROPERTY = "File Filter Regex";

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public static final String IGNORE_DOTTED_FILES_PROPERTY = "Ignore Dotted Files";

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public static final String REMOTE_OWNER_PROPERTY = "Remote Owner";

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public static final String REMOTE_GROUP_PROPERTY = "Remote Group";

  private final Map<String, String> properties;

  public MoveHDFS() {
    this.properties = new HashMap<>();
  }

  public MoveHDFS(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final String getHadoopConfigurationResources() {
    return properties.get(HADOOP_CONFIGURATION_RESOURCES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final MoveHDFS setHadoopConfigurationResources(final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final MoveHDFS removeHadoopConfigurationResources() {
    properties.remove(HADOOP_CONFIGURATION_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final String getKerberosCredentialsService() {
    return properties.get(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final MoveHDFS setKerberosCredentialsService(final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final MoveHDFS removeKerberosCredentialsService() {
    properties.remove(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
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
  public final MoveHDFS setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final MoveHDFS removeKerberosPrincipal() {
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
  public final MoveHDFS setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final MoveHDFS removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final String getKerberosReloginPeriod() {
    return properties.get(KERBEROS_RELOGIN_PERIOD_PROPERTY);
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final MoveHDFS setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final MoveHDFS removeKerberosReloginPeriod() {
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
  public final MoveHDFS setAdditionalClasspathResources(final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final MoveHDFS removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
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
  public final MoveHDFS setConflictResolutionStrategy(final String conflictResolutionStrategy) {
    properties.put(CONFLICT_RESOLUTION_STRATEGY_PROPERTY, conflictResolutionStrategy);
    return this;
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final MoveHDFS removeConflictResolutionStrategy() {
    properties.remove(CONFLICT_RESOLUTION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The HDFS directory from which files should be read, or a single file to read.
   */
  public final String getInputDirectoryOrFile() {
    return properties.get(INPUT_DIRECTORY_OR_FILE_PROPERTY);
  }

  /**
   * The HDFS directory from which files should be read, or a single file to read.
   */
  public final MoveHDFS setInputDirectoryOrFile(final String inputDirectoryOrFile) {
    properties.put(INPUT_DIRECTORY_OR_FILE_PROPERTY, inputDirectoryOrFile);
    return this;
  }

  /**
   * The HDFS directory from which files should be read, or a single file to read.
   */
  public final MoveHDFS removeInputDirectoryOrFile() {
    properties.remove(INPUT_DIRECTORY_OR_FILE_PROPERTY);
    return this;
  }

  /**
   * The HDFS directory where the files will be moved to
   */
  public final String getOutputDirectory() {
    return properties.get(OUTPUT_DIRECTORY_PROPERTY);
  }

  /**
   * The HDFS directory where the files will be moved to
   */
  public final MoveHDFS setOutputDirectory(final String outputDirectory) {
    properties.put(OUTPUT_DIRECTORY_PROPERTY, outputDirectory);
    return this;
  }

  /**
   * The HDFS directory where the files will be moved to
   */
  public final MoveHDFS removeOutputDirectory() {
    properties.remove(OUTPUT_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * The operation that will be performed on the source file
   */
  public final String getHdfsOperation() {
    return properties.get(HDFS_OPERATION_PROPERTY);
  }

  /**
   * The operation that will be performed on the source file
   */
  public final MoveHDFS setHdfsOperation(final String hdfsOperation) {
    properties.put(HDFS_OPERATION_PROPERTY, hdfsOperation);
    return this;
  }

  /**
   * The operation that will be performed on the source file
   */
  public final MoveHDFS removeHdfsOperation() {
    properties.remove(HDFS_OPERATION_PROPERTY);
    return this;
  }

  /**
   * A Java Regular Expression for filtering Filenames; if a filter is supplied then only files whose names match that Regular Expression will be fetched, otherwise all files will be fetched
   */
  public final String getFileFilterRegex() {
    return properties.get(FILE_FILTER_REGEX_PROPERTY);
  }

  /**
   * A Java Regular Expression for filtering Filenames; if a filter is supplied then only files whose names match that Regular Expression will be fetched, otherwise all files will be fetched
   */
  public final MoveHDFS setFileFilterRegex(final String fileFilterRegex) {
    properties.put(FILE_FILTER_REGEX_PROPERTY, fileFilterRegex);
    return this;
  }

  /**
   * A Java Regular Expression for filtering Filenames; if a filter is supplied then only files whose names match that Regular Expression will be fetched, otherwise all files will be fetched
   */
  public final MoveHDFS removeFileFilterRegex() {
    properties.remove(FILE_FILTER_REGEX_PROPERTY);
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
  public final MoveHDFS setIgnoreDottedFiles(final String ignoreDottedFiles) {
    properties.put(IGNORE_DOTTED_FILES_PROPERTY, ignoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final MoveHDFS removeIgnoreDottedFiles() {
    properties.remove(IGNORE_DOTTED_FILES_PROPERTY);
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
  public final MoveHDFS setRemoteOwner(final String remoteOwner) {
    properties.put(REMOTE_OWNER_PROPERTY, remoteOwner);
    return this;
  }

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public final MoveHDFS removeRemoteOwner() {
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
  public final MoveHDFS setRemoteGroup(final String remoteGroup) {
    properties.put(REMOTE_GROUP_PROPERTY, remoteGroup);
    return this;
  }

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public final MoveHDFS removeRemoteGroup() {
    properties.remove(REMOTE_GROUP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MoveHDFS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MoveHDFS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<MoveHDFS, MoveHDFS> configurator) {
    return configurator.apply(new MoveHDFS()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MoveHDFS.class) final Closure<MoveHDFS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.MoveHDFS> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.MoveHDFS.class, com.tibtech.nifi.processors.hadoop.MoveHDFS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<MoveHDFS, MoveHDFS> configurator) {
    return configurator.apply(new MoveHDFS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MoveHDFS.class) final Closure<MoveHDFS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.MoveHDFS> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.MoveHDFS.class, com.tibtech.nifi.processors.hadoop.MoveHDFS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
