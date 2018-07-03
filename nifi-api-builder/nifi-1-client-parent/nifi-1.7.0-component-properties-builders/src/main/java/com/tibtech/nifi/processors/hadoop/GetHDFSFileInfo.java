package com.tibtech.nifi.processors.hadoop;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetHDFSFileInfo {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hadoop.GetHDFSFileInfo";

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
   * A directory to start listing from, or a file's full path.
   */
  public static final String GETHDFSFILEINFO_FULL_PATH_PROPERTY = "gethdfsfileinfo-full-path";

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public static final String GETHDFSFILEINFO_RECURSE_SUBDIRS_PROPERTY = "gethdfsfileinfo-recurse-subdirs";

  /**
   * Regex. Only directories whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public static final String GETHDFSFILEINFO_DIR_FILTER_PROPERTY = "gethdfsfileinfo-dir-filter";

  /**
   * Regex. Only files whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public static final String GETHDFSFILEINFO_FILE_FILTER_PROPERTY = "gethdfsfileinfo-file-filter";

  /**
   * Regex. Files whose names match the given regular expression will not be picked up. If not provided, any filter won't be apply (performance considerations).
   */
  public static final String GETHDFSFILEINFO_FILE_EXCLUDE_FILTER_PROPERTY = "gethdfsfileinfo-file-exclude-filter";

  /**
   * If true, directories whose names begin with a dot (".") will be ignored
   */
  public static final String GETHDFSFILEINFO_IGNORE_DOTTED_DIRS_PROPERTY = "gethdfsfileinfo-ignore-dotted-dirs";

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public static final String GETHDFSFILEINFO_IGNORE_DOTTED_FILES_PROPERTY = "gethdfsfileinfo-ignore-dotted-files";

  /**
   * Groups HDFS objects
   */
  public static final String GETHDFSFILEINFO_GROUP_PROPERTY = "gethdfsfileinfo-group";

  /**
   * Sets the destination for the resutls. When set to 'Content', attributes of flowfile won't be used for storing results. 
   */
  public static final String GETHDFSFILEINFO_DESTINATION_PROPERTY = "gethdfsfileinfo-destination";

  private final Map<String, String> properties;

  public GetHDFSFileInfo() {
    this.properties = new HashMap<>();
  }

  public GetHDFSFileInfo(final Map<String, String> properties) {
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
  public final GetHDFSFileInfo setHadoopConfigurationResources(
      final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final GetHDFSFileInfo removeHadoopConfigurationResources() {
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
  public final GetHDFSFileInfo setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final GetHDFSFileInfo removeKerberosCredentialsService() {
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
  public final GetHDFSFileInfo setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSFileInfo removeKerberosPrincipal() {
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
  public final GetHDFSFileInfo setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSFileInfo removeKerberosKeytab() {
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
  public final GetHDFSFileInfo setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final GetHDFSFileInfo removeKerberosReloginPeriod() {
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
  public final GetHDFSFileInfo setAdditionalClasspathResources(
      final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final GetHDFSFileInfo removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * A directory to start listing from, or a file's full path.
   */
  public final String getGethdfsfileinfoFullPath() {
    return properties.get(GETHDFSFILEINFO_FULL_PATH_PROPERTY);
  }

  /**
   * A directory to start listing from, or a file's full path.
   */
  public final GetHDFSFileInfo setGethdfsfileinfoFullPath(final String gethdfsfileinfoFullPath) {
    properties.put(GETHDFSFILEINFO_FULL_PATH_PROPERTY, gethdfsfileinfoFullPath);
    return this;
  }

  /**
   * A directory to start listing from, or a file's full path.
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoFullPath() {
    properties.remove(GETHDFSFILEINFO_FULL_PATH_PROPERTY);
    return this;
  }

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public final String getGethdfsfileinfoRecurseSubdirs() {
    return properties.get(GETHDFSFILEINFO_RECURSE_SUBDIRS_PROPERTY);
  }

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public final GetHDFSFileInfo setGethdfsfileinfoRecurseSubdirs(
      final String gethdfsfileinfoRecurseSubdirs) {
    properties.put(GETHDFSFILEINFO_RECURSE_SUBDIRS_PROPERTY, gethdfsfileinfoRecurseSubdirs);
    return this;
  }

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoRecurseSubdirs() {
    properties.remove(GETHDFSFILEINFO_RECURSE_SUBDIRS_PROPERTY);
    return this;
  }

  /**
   * Regex. Only directories whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public final String getGethdfsfileinfoDirFilter() {
    return properties.get(GETHDFSFILEINFO_DIR_FILTER_PROPERTY);
  }

  /**
   * Regex. Only directories whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public final GetHDFSFileInfo setGethdfsfileinfoDirFilter(final String gethdfsfileinfoDirFilter) {
    properties.put(GETHDFSFILEINFO_DIR_FILTER_PROPERTY, gethdfsfileinfoDirFilter);
    return this;
  }

  /**
   * Regex. Only directories whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoDirFilter() {
    properties.remove(GETHDFSFILEINFO_DIR_FILTER_PROPERTY);
    return this;
  }

  /**
   * Regex. Only files whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public final String getGethdfsfileinfoFileFilter() {
    return properties.get(GETHDFSFILEINFO_FILE_FILTER_PROPERTY);
  }

  /**
   * Regex. Only files whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public final GetHDFSFileInfo setGethdfsfileinfoFileFilter(
      final String gethdfsfileinfoFileFilter) {
    properties.put(GETHDFSFILEINFO_FILE_FILTER_PROPERTY, gethdfsfileinfoFileFilter);
    return this;
  }

  /**
   * Regex. Only files whose names match the given regular expression will be picked up. If not provided, any filter would be apply (performance considerations).
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoFileFilter() {
    properties.remove(GETHDFSFILEINFO_FILE_FILTER_PROPERTY);
    return this;
  }

  /**
   * Regex. Files whose names match the given regular expression will not be picked up. If not provided, any filter won't be apply (performance considerations).
   */
  public final String getGethdfsfileinfoFileExcludeFilter() {
    return properties.get(GETHDFSFILEINFO_FILE_EXCLUDE_FILTER_PROPERTY);
  }

  /**
   * Regex. Files whose names match the given regular expression will not be picked up. If not provided, any filter won't be apply (performance considerations).
   */
  public final GetHDFSFileInfo setGethdfsfileinfoFileExcludeFilter(
      final String gethdfsfileinfoFileExcludeFilter) {
    properties.put(GETHDFSFILEINFO_FILE_EXCLUDE_FILTER_PROPERTY, gethdfsfileinfoFileExcludeFilter);
    return this;
  }

  /**
   * Regex. Files whose names match the given regular expression will not be picked up. If not provided, any filter won't be apply (performance considerations).
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoFileExcludeFilter() {
    properties.remove(GETHDFSFILEINFO_FILE_EXCLUDE_FILTER_PROPERTY);
    return this;
  }

  /**
   * If true, directories whose names begin with a dot (".") will be ignored
   */
  public final String getGethdfsfileinfoIgnoreDottedDirs() {
    return properties.get(GETHDFSFILEINFO_IGNORE_DOTTED_DIRS_PROPERTY);
  }

  /**
   * If true, directories whose names begin with a dot (".") will be ignored
   */
  public final GetHDFSFileInfo setGethdfsfileinfoIgnoreDottedDirs(
      final String gethdfsfileinfoIgnoreDottedDirs) {
    properties.put(GETHDFSFILEINFO_IGNORE_DOTTED_DIRS_PROPERTY, gethdfsfileinfoIgnoreDottedDirs);
    return this;
  }

  /**
   * If true, directories whose names begin with a dot (".") will be ignored
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoIgnoreDottedDirs() {
    properties.remove(GETHDFSFILEINFO_IGNORE_DOTTED_DIRS_PROPERTY);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final String getGethdfsfileinfoIgnoreDottedFiles() {
    return properties.get(GETHDFSFILEINFO_IGNORE_DOTTED_FILES_PROPERTY);
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final GetHDFSFileInfo setGethdfsfileinfoIgnoreDottedFiles(
      final String gethdfsfileinfoIgnoreDottedFiles) {
    properties.put(GETHDFSFILEINFO_IGNORE_DOTTED_FILES_PROPERTY, gethdfsfileinfoIgnoreDottedFiles);
    return this;
  }

  /**
   * If true, files whose names begin with a dot (".") will be ignored
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoIgnoreDottedFiles() {
    properties.remove(GETHDFSFILEINFO_IGNORE_DOTTED_FILES_PROPERTY);
    return this;
  }

  /**
   * Groups HDFS objects
   */
  public final String getGethdfsfileinfoGroup() {
    return properties.get(GETHDFSFILEINFO_GROUP_PROPERTY);
  }

  /**
   * Groups HDFS objects
   */
  public final GetHDFSFileInfo setGethdfsfileinfoGroup(final String gethdfsfileinfoGroup) {
    properties.put(GETHDFSFILEINFO_GROUP_PROPERTY, gethdfsfileinfoGroup);
    return this;
  }

  /**
   * Groups HDFS objects
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoGroup() {
    properties.remove(GETHDFSFILEINFO_GROUP_PROPERTY);
    return this;
  }

  /**
   * Sets the destination for the resutls. When set to 'Content', attributes of flowfile won't be used for storing results. 
   */
  public final String getGethdfsfileinfoDestination() {
    return properties.get(GETHDFSFILEINFO_DESTINATION_PROPERTY);
  }

  /**
   * Sets the destination for the resutls. When set to 'Content', attributes of flowfile won't be used for storing results. 
   */
  public final GetHDFSFileInfo setGethdfsfileinfoDestination(
      final String gethdfsfileinfoDestination) {
    properties.put(GETHDFSFILEINFO_DESTINATION_PROPERTY, gethdfsfileinfoDestination);
    return this;
  }

  /**
   * Sets the destination for the resutls. When set to 'Content', attributes of flowfile won't be used for storing results. 
   */
  public final GetHDFSFileInfo removeGethdfsfileinfoDestination() {
    properties.remove(GETHDFSFILEINFO_DESTINATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetHDFSFileInfo setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetHDFSFileInfo removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetHDFSFileInfo, GetHDFSFileInfo> configurator) {
    return configurator.apply(new GetHDFSFileInfo()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHDFSFileInfo.class) final Closure<GetHDFSFileInfo> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.GetHDFSFileInfo> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.GetHDFSFileInfo.class, com.tibtech.nifi.processors.hadoop.GetHDFSFileInfo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetHDFSFileInfo, GetHDFSFileInfo> configurator) {
    return configurator.apply(new GetHDFSFileInfo(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHDFSFileInfo.class) final Closure<GetHDFSFileInfo> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.GetHDFSFileInfo> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.GetHDFSFileInfo.class, com.tibtech.nifi.processors.hadoop.GetHDFSFileInfo.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
