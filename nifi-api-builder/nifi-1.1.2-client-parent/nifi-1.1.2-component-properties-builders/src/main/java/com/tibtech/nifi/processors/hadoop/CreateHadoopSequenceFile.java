package com.tibtech.nifi.processors.hadoop;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CreateHadoopSequenceFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hadoop.CreateHadoopSequenceFile";

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
   * Type of compression to use when creating Sequence File
   */
  public static final String COMPRESSION_TYPE_PROPERTY = "compression type";

  private final Map<String, String> properties;

  public CreateHadoopSequenceFile() {
    this.properties = new HashMap<>();
  }

  public CreateHadoopSequenceFile(final Map<String, String> properties) {
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
  public final CreateHadoopSequenceFile setHadoopConfigurationResources(final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final CreateHadoopSequenceFile removeHadoopConfigurationResources() {
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
  public final CreateHadoopSequenceFile setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final CreateHadoopSequenceFile removeKerberosPrincipal() {
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
  public final CreateHadoopSequenceFile setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final CreateHadoopSequenceFile removeKerberosKeytab() {
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
  public final CreateHadoopSequenceFile setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final CreateHadoopSequenceFile removeKerberosReloginPeriod() {
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
  public final CreateHadoopSequenceFile setAdditionalClasspathResources(final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final CreateHadoopSequenceFile removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * Type of compression to use when creating Sequence File
   */
  public final String getCompressionType() {
    return properties.get(COMPRESSION_TYPE_PROPERTY);
  }

  /**
   * Type of compression to use when creating Sequence File
   */
  public final CreateHadoopSequenceFile setCompressionType(final String compressionType) {
    properties.put(COMPRESSION_TYPE_PROPERTY, compressionType);
    return this;
  }

  /**
   * Type of compression to use when creating Sequence File
   */
  public final CreateHadoopSequenceFile removeCompressionType() {
    properties.remove(COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CreateHadoopSequenceFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CreateHadoopSequenceFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<CreateHadoopSequenceFile, CreateHadoopSequenceFile> configurator) {
    return configurator.apply(new CreateHadoopSequenceFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CreateHadoopSequenceFile.class) final Closure<CreateHadoopSequenceFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.CreateHadoopSequenceFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.CreateHadoopSequenceFile.class, com.tibtech.nifi.processors.hadoop.CreateHadoopSequenceFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CreateHadoopSequenceFile, CreateHadoopSequenceFile> configurator) {
    return configurator.apply(new CreateHadoopSequenceFile(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CreateHadoopSequenceFile.class) final Closure<CreateHadoopSequenceFile> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.CreateHadoopSequenceFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.CreateHadoopSequenceFile.class, com.tibtech.nifi.processors.hadoop.CreateHadoopSequenceFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
