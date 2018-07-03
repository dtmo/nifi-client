package com.tibtech.nifi.processors.kite;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StoreInKiteDataset {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kite.StoreInKiteDataset";

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public static final String HADOOP_CONFIGURATION_FILES_PROPERTY = "Hadoop configuration files";

  /**
   * URI that identifies a Kite dataset where data will be stored
   */
  public static final String TARGET_DATASET_URI_PROPERTY = "Target dataset URI";

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public static final String ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY = "additional-classpath-resources";

  private final Map<String, String> properties;

  public StoreInKiteDataset() {
    this.properties = new HashMap<>();
  }

  public StoreInKiteDataset(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final String getHadoopConfigurationFiles() {
    return properties.get(HADOOP_CONFIGURATION_FILES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final StoreInKiteDataset setHadoopConfigurationFiles(
      final String hadoopConfigurationFiles) {
    properties.put(HADOOP_CONFIGURATION_FILES_PROPERTY, hadoopConfigurationFiles);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final StoreInKiteDataset removeHadoopConfigurationFiles() {
    properties.remove(HADOOP_CONFIGURATION_FILES_PROPERTY);
    return this;
  }

  /**
   * URI that identifies a Kite dataset where data will be stored
   */
  public final String getTargetDatasetUri() {
    return properties.get(TARGET_DATASET_URI_PROPERTY);
  }

  /**
   * URI that identifies a Kite dataset where data will be stored
   */
  public final StoreInKiteDataset setTargetDatasetUri(final String targetDatasetUri) {
    properties.put(TARGET_DATASET_URI_PROPERTY, targetDatasetUri);
    return this;
  }

  /**
   * URI that identifies a Kite dataset where data will be stored
   */
  public final StoreInKiteDataset removeTargetDatasetUri() {
    properties.remove(TARGET_DATASET_URI_PROPERTY);
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
  public final StoreInKiteDataset setAdditionalClasspathResources(
      final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final StoreInKiteDataset removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final StoreInKiteDataset setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final StoreInKiteDataset removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<StoreInKiteDataset, StoreInKiteDataset> configurator) {
    return configurator.apply(new StoreInKiteDataset()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StoreInKiteDataset.class) final Closure<StoreInKiteDataset> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kite.StoreInKiteDataset> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.StoreInKiteDataset.class, com.tibtech.nifi.processors.kite.StoreInKiteDataset.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<StoreInKiteDataset, StoreInKiteDataset> configurator) {
    return configurator.apply(new StoreInKiteDataset(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StoreInKiteDataset.class) final Closure<StoreInKiteDataset> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kite.StoreInKiteDataset> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.StoreInKiteDataset.class, com.tibtech.nifi.processors.kite.StoreInKiteDataset.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
