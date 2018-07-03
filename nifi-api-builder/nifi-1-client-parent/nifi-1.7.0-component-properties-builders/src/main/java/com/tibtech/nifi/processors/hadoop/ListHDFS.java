package com.tibtech.nifi.processors.hadoop;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListHDFS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hadoop.ListHDFS";

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
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HDFS so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "Distributed Cache Service";

  /**
   * The HDFS directory from which files should be read
   */
  public static final String DIRECTORY_PROPERTY = "Directory";

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public static final String RECURSE_SUBDIRECTORIES_PROPERTY = "Recurse Subdirectories";

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public static final String FILE_FILTER_PROPERTY = "File Filter";

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (based on last modification date) will be ignored
   */
  public static final String MINIMUM_FILE_AGE_PROPERTY = "minimum-file-age";

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored. Minimum value is 100ms.
   */
  public static final String MAXIMUM_FILE_AGE_PROPERTY = "maximum-file-age";

  private final Map<String, String> properties;

  public ListHDFS() {
    this.properties = new HashMap<>();
  }

  public ListHDFS(final Map<String, String> properties) {
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
  public final ListHDFS setHadoopConfigurationResources(final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration. To use swebhdfs, see 'Additional Details' section of PutHDFS's documentation.
   */
  public final ListHDFS removeHadoopConfigurationResources() {
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
  public final ListHDFS setKerberosCredentialsService(final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final ListHDFS removeKerberosCredentialsService() {
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
  public final ListHDFS setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final ListHDFS removeKerberosPrincipal() {
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
  public final ListHDFS setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final ListHDFS removeKerberosKeytab() {
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
  public final ListHDFS setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin.
   *
   * This property has been deprecated, and has no effect on processing. Relogins now occur automatically.
   */
  public final ListHDFS removeKerberosReloginPeriod() {
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
  public final ListHDFS setAdditionalClasspathResources(final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final ListHDFS removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HDFS so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HDFS so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public final ListHDFS setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HDFS so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public final ListHDFS removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
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
  public final ListHDFS setDirectory(final String directory) {
    properties.put(DIRECTORY_PROPERTY, directory);
    return this;
  }

  /**
   * The HDFS directory from which files should be read
   */
  public final ListHDFS removeDirectory() {
    properties.remove(DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public final String getRecurseSubdirectories() {
    return properties.get(RECURSE_SUBDIRECTORIES_PROPERTY);
  }

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public final ListHDFS setRecurseSubdirectories(final String recurseSubdirectories) {
    properties.put(RECURSE_SUBDIRECTORIES_PROPERTY, recurseSubdirectories);
    return this;
  }

  /**
   * Indicates whether to list files from subdirectories of the HDFS directory
   */
  public final ListHDFS removeRecurseSubdirectories() {
    properties.remove(RECURSE_SUBDIRECTORIES_PROPERTY);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final String getFileFilter() {
    return properties.get(FILE_FILTER_PROPERTY);
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final ListHDFS setFileFilter(final String fileFilter) {
    properties.put(FILE_FILTER_PROPERTY, fileFilter);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final ListHDFS removeFileFilter() {
    properties.remove(FILE_FILTER_PROPERTY);
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
  public final ListHDFS setMinimumFileAge(final String minimumFileAge) {
    properties.put(MINIMUM_FILE_AGE_PROPERTY, minimumFileAge);
    return this;
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (based on last modification date) will be ignored
   */
  public final ListHDFS removeMinimumFileAge() {
    properties.remove(MINIMUM_FILE_AGE_PROPERTY);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored. Minimum value is 100ms.
   */
  public final String getMaximumFileAge() {
    return properties.get(MAXIMUM_FILE_AGE_PROPERTY);
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored. Minimum value is 100ms.
   */
  public final ListHDFS setMaximumFileAge(final String maximumFileAge) {
    properties.put(MAXIMUM_FILE_AGE_PROPERTY, maximumFileAge);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (based on last modification date) will be ignored. Minimum value is 100ms.
   */
  public final ListHDFS removeMaximumFileAge() {
    properties.remove(MAXIMUM_FILE_AGE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListHDFS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListHDFS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListHDFS, ListHDFS> configurator) {
    return configurator.apply(new ListHDFS()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListHDFS.class) final Closure<ListHDFS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.ListHDFS> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.ListHDFS.class, com.tibtech.nifi.processors.hadoop.ListHDFS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListHDFS, ListHDFS> configurator) {
    return configurator.apply(new ListHDFS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListHDFS.class) final Closure<ListHDFS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.ListHDFS> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.ListHDFS.class, com.tibtech.nifi.processors.hadoop.ListHDFS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
