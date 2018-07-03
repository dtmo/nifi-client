package com.tibtech.nifi.processors.parquet;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutParquet {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.parquet.PutParquet";

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
   * The service for reading records from incoming flow files.
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * The parent directory to which files should be written. Will be created if it doesn't exist.
   */
  public static final String DIRECTORY_PROPERTY = "Directory";

  /**
   * The type of compression for the file being written.
   */
  public static final String COMPRESSION_TYPE_PROPERTY = "compression-type";

  /**
   * Whether or not to overwrite existing files in the same directory with the same name. When set to false, flow files will be routed to failure when a file exists in the same directory with the same name.
   */
  public static final String OVERWRITE_PROPERTY = "overwrite";

  /**
   * A umask represented as an octal number which determines the permissions of files written to HDFS. This overrides the Hadoop Configuration dfs.umaskmode
   */
  public static final String PERMISSIONS_UMASK_PROPERTY = "permissions-umask";

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public static final String REMOTE_GROUP_PROPERTY = "remote-group";

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public static final String REMOTE_OWNER_PROPERTY = "remote-owner";

  /**
   * The row group size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public static final String ROW_GROUP_SIZE_PROPERTY = "row-group-size";

  /**
   * The page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public static final String PAGE_SIZE_PROPERTY = "page-size";

  /**
   * The dictionary page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public static final String DICTIONARY_PAGE_SIZE_PROPERTY = "dictionary-page-size";

  /**
   * The maximum amount of padding that will be used to align row groups with blocks in the underlying filesystem. If the underlying filesystem is not a block filesystem like HDFS, this has no effect. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public static final String MAX_PADDING_SIZE_PROPERTY = "max-padding-size";

  /**
   * Specifies whether dictionary encoding should be enabled for the Parquet writer
   */
  public static final String ENABLE_DICTIONARY_ENCODING_PROPERTY = "enable-dictionary-encoding";

  /**
   * Specifies whether validation should be enabled for the Parquet writer
   */
  public static final String ENABLE_VALIDATION_PROPERTY = "enable-validation";

  /**
   * Specifies the version used by Parquet writer
   */
  public static final String WRITER_VERSION_PROPERTY = "writer-version";

  /**
   * Specifies whether the corresponding CRC file should be deleted upon successfully writing a Parquet file
   */
  public static final String REMOVE_CRC_FILES_PROPERTY = "remove-crc-files";

  private final Map<String, String> properties;

  public PutParquet() {
    this.properties = new HashMap<>();
  }

  public PutParquet(final Map<String, String> properties) {
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
  public final PutParquet setHadoopConfigurationResources(
      final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final PutParquet removeHadoopConfigurationResources() {
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
  public final PutParquet setKerberosCredentialsService(final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PutParquet removeKerberosCredentialsService() {
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
  public final PutParquet setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutParquet removeKerberosPrincipal() {
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
  public final PutParquet setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutParquet removeKerberosKeytab() {
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
  public final PutParquet setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final PutParquet removeKerberosReloginPeriod() {
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
  public final PutParquet setAdditionalClasspathResources(
      final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final PutParquet removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * The service for reading records from incoming flow files.
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * The service for reading records from incoming flow files.
   */
  public final PutParquet setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * The service for reading records from incoming flow files.
   */
  public final PutParquet removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * The parent directory to which files should be written. Will be created if it doesn't exist.
   */
  public final String getDirectory() {
    return properties.get(DIRECTORY_PROPERTY);
  }

  /**
   * The parent directory to which files should be written. Will be created if it doesn't exist.
   */
  public final PutParquet setDirectory(final String directory) {
    properties.put(DIRECTORY_PROPERTY, directory);
    return this;
  }

  /**
   * The parent directory to which files should be written. Will be created if it doesn't exist.
   */
  public final PutParquet removeDirectory() {
    properties.remove(DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * The type of compression for the file being written.
   */
  public final String getCompressionType() {
    return properties.get(COMPRESSION_TYPE_PROPERTY);
  }

  /**
   * The type of compression for the file being written.
   */
  public final PutParquet setCompressionType(final String compressionType) {
    properties.put(COMPRESSION_TYPE_PROPERTY, compressionType);
    return this;
  }

  /**
   * The type of compression for the file being written.
   */
  public final PutParquet removeCompressionType() {
    properties.remove(COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  /**
   * Whether or not to overwrite existing files in the same directory with the same name. When set to false, flow files will be routed to failure when a file exists in the same directory with the same name.
   */
  public final String getOverwrite() {
    return properties.get(OVERWRITE_PROPERTY);
  }

  /**
   * Whether or not to overwrite existing files in the same directory with the same name. When set to false, flow files will be routed to failure when a file exists in the same directory with the same name.
   */
  public final PutParquet setOverwrite(final String overwrite) {
    properties.put(OVERWRITE_PROPERTY, overwrite);
    return this;
  }

  /**
   * Whether or not to overwrite existing files in the same directory with the same name. When set to false, flow files will be routed to failure when a file exists in the same directory with the same name.
   */
  public final PutParquet removeOverwrite() {
    properties.remove(OVERWRITE_PROPERTY);
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
  public final PutParquet setPermissionsUmask(final String permissionsUmask) {
    properties.put(PERMISSIONS_UMASK_PROPERTY, permissionsUmask);
    return this;
  }

  /**
   * A umask represented as an octal number which determines the permissions of files written to HDFS. This overrides the Hadoop Configuration dfs.umaskmode
   */
  public final PutParquet removePermissionsUmask() {
    properties.remove(PERMISSIONS_UMASK_PROPERTY);
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
  public final PutParquet setRemoteGroup(final String remoteGroup) {
    properties.put(REMOTE_GROUP_PROPERTY, remoteGroup);
    return this;
  }

  /**
   * Changes the group of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change group
   */
  public final PutParquet removeRemoteGroup() {
    properties.remove(REMOTE_GROUP_PROPERTY);
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
  public final PutParquet setRemoteOwner(final String remoteOwner) {
    properties.put(REMOTE_OWNER_PROPERTY, remoteOwner);
    return this;
  }

  /**
   * Changes the owner of the HDFS file to this value after it is written. This only works if NiFi is running as a user that has HDFS super user privilege to change owner
   */
  public final PutParquet removeRemoteOwner() {
    properties.remove(REMOTE_OWNER_PROPERTY);
    return this;
  }

  /**
   * The row group size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final String getRowGroupSize() {
    return properties.get(ROW_GROUP_SIZE_PROPERTY);
  }

  /**
   * The row group size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet setRowGroupSize(final String rowGroupSize) {
    properties.put(ROW_GROUP_SIZE_PROPERTY, rowGroupSize);
    return this;
  }

  /**
   * The row group size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet removeRowGroupSize() {
    properties.remove(ROW_GROUP_SIZE_PROPERTY);
    return this;
  }

  /**
   * The page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final String getPageSize() {
    return properties.get(PAGE_SIZE_PROPERTY);
  }

  /**
   * The page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet setPageSize(final String pageSize) {
    properties.put(PAGE_SIZE_PROPERTY, pageSize);
    return this;
  }

  /**
   * The page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet removePageSize() {
    properties.remove(PAGE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The dictionary page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final String getDictionaryPageSize() {
    return properties.get(DICTIONARY_PAGE_SIZE_PROPERTY);
  }

  /**
   * The dictionary page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet setDictionaryPageSize(final String dictionaryPageSize) {
    properties.put(DICTIONARY_PAGE_SIZE_PROPERTY, dictionaryPageSize);
    return this;
  }

  /**
   * The dictionary page size used by the Parquet writer. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet removeDictionaryPageSize() {
    properties.remove(DICTIONARY_PAGE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of padding that will be used to align row groups with blocks in the underlying filesystem. If the underlying filesystem is not a block filesystem like HDFS, this has no effect. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final String getMaxPaddingSize() {
    return properties.get(MAX_PADDING_SIZE_PROPERTY);
  }

  /**
   * The maximum amount of padding that will be used to align row groups with blocks in the underlying filesystem. If the underlying filesystem is not a block filesystem like HDFS, this has no effect. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet setMaxPaddingSize(final String maxPaddingSize) {
    properties.put(MAX_PADDING_SIZE_PROPERTY, maxPaddingSize);
    return this;
  }

  /**
   * The maximum amount of padding that will be used to align row groups with blocks in the underlying filesystem. If the underlying filesystem is not a block filesystem like HDFS, this has no effect. The value is specified in the format of <Data Size> <Data Unit> where Data Unit is one of B, KB, MB, GB, TB.
   */
  public final PutParquet removeMaxPaddingSize() {
    properties.remove(MAX_PADDING_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether dictionary encoding should be enabled for the Parquet writer
   */
  public final String getEnableDictionaryEncoding() {
    return properties.get(ENABLE_DICTIONARY_ENCODING_PROPERTY);
  }

  /**
   * Specifies whether dictionary encoding should be enabled for the Parquet writer
   */
  public final PutParquet setEnableDictionaryEncoding(final String enableDictionaryEncoding) {
    properties.put(ENABLE_DICTIONARY_ENCODING_PROPERTY, enableDictionaryEncoding);
    return this;
  }

  /**
   * Specifies whether dictionary encoding should be enabled for the Parquet writer
   */
  public final PutParquet removeEnableDictionaryEncoding() {
    properties.remove(ENABLE_DICTIONARY_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Specifies whether validation should be enabled for the Parquet writer
   */
  public final String getEnableValidation() {
    return properties.get(ENABLE_VALIDATION_PROPERTY);
  }

  /**
   * Specifies whether validation should be enabled for the Parquet writer
   */
  public final PutParquet setEnableValidation(final String enableValidation) {
    properties.put(ENABLE_VALIDATION_PROPERTY, enableValidation);
    return this;
  }

  /**
   * Specifies whether validation should be enabled for the Parquet writer
   */
  public final PutParquet removeEnableValidation() {
    properties.remove(ENABLE_VALIDATION_PROPERTY);
    return this;
  }

  /**
   * Specifies the version used by Parquet writer
   */
  public final String getWriterVersion() {
    return properties.get(WRITER_VERSION_PROPERTY);
  }

  /**
   * Specifies the version used by Parquet writer
   */
  public final PutParquet setWriterVersion(final String writerVersion) {
    properties.put(WRITER_VERSION_PROPERTY, writerVersion);
    return this;
  }

  /**
   * Specifies the version used by Parquet writer
   */
  public final PutParquet removeWriterVersion() {
    properties.remove(WRITER_VERSION_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the corresponding CRC file should be deleted upon successfully writing a Parquet file
   */
  public final String getRemoveCrcFiles() {
    return properties.get(REMOVE_CRC_FILES_PROPERTY);
  }

  /**
   * Specifies whether the corresponding CRC file should be deleted upon successfully writing a Parquet file
   */
  public final PutParquet setRemoveCrcFiles(final String removeCrcFiles) {
    properties.put(REMOVE_CRC_FILES_PROPERTY, removeCrcFiles);
    return this;
  }

  /**
   * Specifies whether the corresponding CRC file should be deleted upon successfully writing a Parquet file
   */
  public final PutParquet removeRemoveCrcFiles() {
    properties.remove(REMOVE_CRC_FILES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutParquet setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutParquet removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutParquet, PutParquet> configurator) {
    return configurator.apply(new PutParquet()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutParquet.class) final Closure<PutParquet> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.parquet.PutParquet> code = closure.rehydrate(c, com.tibtech.nifi.processors.parquet.PutParquet.class, com.tibtech.nifi.processors.parquet.PutParquet.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutParquet, PutParquet> configurator) {
    return configurator.apply(new PutParquet(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutParquet.class) final Closure<PutParquet> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.parquet.PutParquet> code = closure.rehydrate(c, com.tibtech.nifi.processors.parquet.PutParquet.class, com.tibtech.nifi.processors.parquet.PutParquet.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
