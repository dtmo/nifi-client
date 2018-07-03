package com.tibtech.nifi.processors.hadoop;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetHDFSSequenceFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hadoop.GetHDFSSequenceFile";

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
   * The HDFS directory from which files should be read
   */
  public static final String DIRECTORY_PROPERTY = "Directory";

  /**
   * Indicates whether to pull files from subdirectories of the HDFS directory
   */
  public static final String RECURSE_SUBDIRECTORIES_PROPERTY = "Recurse Subdirectories";

  /**
   * Determines whether to delete the file from HDFS after it has been successfully transferred. If true, the file will be fetched repeatedly. This is intended for testing only.
   */
  public static final String KEEP_SOURCE_FILE_PROPERTY = "Keep Source File";

  /**
   * A Java Regular Expression for filtering Filenames; if a filter is supplied then only files whose names match that Regular Expression will be fetched, otherwise all files will be fetched
   */
  public static final String FILE_FILTER_REGEX_PROPERTY = "File Filter Regex";

  /**
   * If true then File Filter Regex will match on just the filename, otherwise subdirectory names will be included with filename in the regex comparison
   */
  public static final String FILTER_MATCH_NAME_ONLY_PROPERTY = "Filter Match Name Only";

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public static final String IGNORE_DOTTED_FILES_PROPERTY = "Ignore Dotted Files";

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (based on last modification date) will be ignored
   */
  public static final String MINIMUM_FILE_AGE_PROPERTY = "Minimum File Age";

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored
   */
  public static final String MAXIMUM_FILE_AGE_PROPERTY = "Maximum File Age";

  /**
   * Indicates how long to wait between performing directory listings
   */
  public static final String POLLING_INTERVAL_PROPERTY = "Polling Interval";

  /**
   * The maximum number of files to pull in each iteration, based on run schedule.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Amount of memory to use to buffer file contents during IO. This overrides the Hadoop Configuration
   */
  public static final String IO_BUFFER_SIZE_PROPERTY = "IO Buffer Size";

  /**
   *
   */
  public static final String COMPRESSION_CODEC_PROPERTY = "Compression codec";

  /**
   * Indicate if the content is to be both the key and value of the Sequence File, or just the value.
   */
  public static final String FLOW_FILE_CONTENT_PROPERTY = "FlowFile Content";

  private final Map<String, String> properties;

  public GetHDFSSequenceFile() {
    this.properties = new HashMap<>();
  }

  public GetHDFSSequenceFile(final Map<String, String> properties) {
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
  public final GetHDFSSequenceFile setHadoopConfigurationResources(
      final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final GetHDFSSequenceFile removeHadoopConfigurationResources() {
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
  public final GetHDFSSequenceFile setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final GetHDFSSequenceFile removeKerberosCredentialsService() {
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
  public final GetHDFSSequenceFile setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSSequenceFile removeKerberosPrincipal() {
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
  public final GetHDFSSequenceFile setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSSequenceFile removeKerberosKeytab() {
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
  public final GetHDFSSequenceFile setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final GetHDFSSequenceFile removeKerberosReloginPeriod() {
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
  public final GetHDFSSequenceFile setAdditionalClasspathResources(
      final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final GetHDFSSequenceFile removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * The HDFS directory from which files should be read
   */
  public final String getDirectory() {
    return properties.get(DIRECTORY_PROPERTY);
  }

  /**
   * The HDFS directory from which files should be read
   */
  public final GetHDFSSequenceFile setDirectory(final String directory) {
    properties.put(DIRECTORY_PROPERTY, directory);
    return this;
  }

  /**
   * The HDFS directory from which files should be read
   */
  public final GetHDFSSequenceFile removeDirectory() {
    properties.remove(DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Indicates whether to pull files from subdirectories of the HDFS directory
   */
  public final String getRecurseSubdirectories() {
    return properties.get(RECURSE_SUBDIRECTORIES_PROPERTY);
  }

  /**
   * Indicates whether to pull files from subdirectories of the HDFS directory
   */
  public final GetHDFSSequenceFile setRecurseSubdirectories(final String recurseSubdirectories) {
    properties.put(RECURSE_SUBDIRECTORIES_PROPERTY, recurseSubdirectories);
    return this;
  }

  /**
   * Indicates whether to pull files from subdirectories of the HDFS directory
   */
  public final GetHDFSSequenceFile removeRecurseSubdirectories() {
    properties.remove(RECURSE_SUBDIRECTORIES_PROPERTY);
    return this;
  }

  /**
   * Determines whether to delete the file from HDFS after it has been successfully transferred. If true, the file will be fetched repeatedly. This is intended for testing only.
   */
  public final String getKeepSourceFile() {
    return properties.get(KEEP_SOURCE_FILE_PROPERTY);
  }

  /**
   * Determines whether to delete the file from HDFS after it has been successfully transferred. If true, the file will be fetched repeatedly. This is intended for testing only.
   */
  public final GetHDFSSequenceFile setKeepSourceFile(final String keepSourceFile) {
    properties.put(KEEP_SOURCE_FILE_PROPERTY, keepSourceFile);
    return this;
  }

  /**
   * Determines whether to delete the file from HDFS after it has been successfully transferred. If true, the file will be fetched repeatedly. This is intended for testing only.
   */
  public final GetHDFSSequenceFile removeKeepSourceFile() {
    properties.remove(KEEP_SOURCE_FILE_PROPERTY);
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
  public final GetHDFSSequenceFile setFileFilterRegex(final String fileFilterRegex) {
    properties.put(FILE_FILTER_REGEX_PROPERTY, fileFilterRegex);
    return this;
  }

  /**
   * A Java Regular Expression for filtering Filenames; if a filter is supplied then only files whose names match that Regular Expression will be fetched, otherwise all files will be fetched
   */
  public final GetHDFSSequenceFile removeFileFilterRegex() {
    properties.remove(FILE_FILTER_REGEX_PROPERTY);
    return this;
  }

  /**
   * If true then File Filter Regex will match on just the filename, otherwise subdirectory names will be included with filename in the regex comparison
   */
  public final String getFilterMatchNameOnly() {
    return properties.get(FILTER_MATCH_NAME_ONLY_PROPERTY);
  }

  /**
   * If true then File Filter Regex will match on just the filename, otherwise subdirectory names will be included with filename in the regex comparison
   */
  public final GetHDFSSequenceFile setFilterMatchNameOnly(final String filterMatchNameOnly) {
    properties.put(FILTER_MATCH_NAME_ONLY_PROPERTY, filterMatchNameOnly);
    return this;
  }

  /**
   * If true then File Filter Regex will match on just the filename, otherwise subdirectory names will be included with filename in the regex comparison
   */
  public final GetHDFSSequenceFile removeFilterMatchNameOnly() {
    properties.remove(FILTER_MATCH_NAME_ONLY_PROPERTY);
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
  public final GetHDFSSequenceFile setIgnoreDottedFiles(final String ignoreDottedFiles) {
    properties.put(IGNORE_DOTTED_FILES_PROPERTY, ignoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final GetHDFSSequenceFile removeIgnoreDottedFiles() {
    properties.remove(IGNORE_DOTTED_FILES_PROPERTY);
    return this;
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (based on last modification date) will be ignored
   */
  public final String getMinimumFileAge() {
    return properties.get(MINIMUM_FILE_AGE_PROPERTY);
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (based on last modification date) will be ignored
   */
  public final GetHDFSSequenceFile setMinimumFileAge(final String minimumFileAge) {
    properties.put(MINIMUM_FILE_AGE_PROPERTY, minimumFileAge);
    return this;
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (based on last modification date) will be ignored
   */
  public final GetHDFSSequenceFile removeMinimumFileAge() {
    properties.remove(MINIMUM_FILE_AGE_PROPERTY);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored
   */
  public final String getMaximumFileAge() {
    return properties.get(MAXIMUM_FILE_AGE_PROPERTY);
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored
   */
  public final GetHDFSSequenceFile setMaximumFileAge(final String maximumFileAge) {
    properties.put(MAXIMUM_FILE_AGE_PROPERTY, maximumFileAge);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored
   */
  public final GetHDFSSequenceFile removeMaximumFileAge() {
    properties.remove(MAXIMUM_FILE_AGE_PROPERTY);
    return this;
  }

  /**
   * Indicates how long to wait between performing directory listings
   */
  public final String getPollingInterval() {
    return properties.get(POLLING_INTERVAL_PROPERTY);
  }

  /**
   * Indicates how long to wait between performing directory listings
   */
  public final GetHDFSSequenceFile setPollingInterval(final String pollingInterval) {
    properties.put(POLLING_INTERVAL_PROPERTY, pollingInterval);
    return this;
  }

  /**
   * Indicates how long to wait between performing directory listings
   */
  public final GetHDFSSequenceFile removePollingInterval() {
    properties.remove(POLLING_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The maximum number of files to pull in each iteration, based on run schedule.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of files to pull in each iteration, based on run schedule.
   */
  public final GetHDFSSequenceFile setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of files to pull in each iteration, based on run schedule.
   */
  public final GetHDFSSequenceFile removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
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
  public final GetHDFSSequenceFile setIoBufferSize(final String ioBufferSize) {
    properties.put(IO_BUFFER_SIZE_PROPERTY, ioBufferSize);
    return this;
  }

  /**
   * Amount of memory to use to buffer file contents during IO. This overrides the Hadoop Configuration
   */
  public final GetHDFSSequenceFile removeIoBufferSize() {
    properties.remove(IO_BUFFER_SIZE_PROPERTY);
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
  public final GetHDFSSequenceFile setCompressionCodec(final String compressionCodec) {
    properties.put(COMPRESSION_CODEC_PROPERTY, compressionCodec);
    return this;
  }

  /**
   *
   */
  public final GetHDFSSequenceFile removeCompressionCodec() {
    properties.remove(COMPRESSION_CODEC_PROPERTY);
    return this;
  }

  /**
   * Indicate if the content is to be both the key and value of the Sequence File, or just the value.
   */
  public final String getFlowFileContent() {
    return properties.get(FLOW_FILE_CONTENT_PROPERTY);
  }

  /**
   * Indicate if the content is to be both the key and value of the Sequence File, or just the value.
   */
  public final GetHDFSSequenceFile setFlowFileContent(final String flowFileContent) {
    properties.put(FLOW_FILE_CONTENT_PROPERTY, flowFileContent);
    return this;
  }

  /**
   * Indicate if the content is to be both the key and value of the Sequence File, or just the value.
   */
  public final GetHDFSSequenceFile removeFlowFileContent() {
    properties.remove(FLOW_FILE_CONTENT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetHDFSSequenceFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetHDFSSequenceFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetHDFSSequenceFile, GetHDFSSequenceFile> configurator) {
    return configurator.apply(new GetHDFSSequenceFile()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHDFSSequenceFile.class) final Closure<GetHDFSSequenceFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.GetHDFSSequenceFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.GetHDFSSequenceFile.class, com.tibtech.nifi.processors.hadoop.GetHDFSSequenceFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetHDFSSequenceFile, GetHDFSSequenceFile> configurator) {
    return configurator.apply(new GetHDFSSequenceFile(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHDFSSequenceFile.class) final Closure<GetHDFSSequenceFile> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.GetHDFSSequenceFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.GetHDFSSequenceFile.class, com.tibtech.nifi.processors.hadoop.GetHDFSSequenceFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
