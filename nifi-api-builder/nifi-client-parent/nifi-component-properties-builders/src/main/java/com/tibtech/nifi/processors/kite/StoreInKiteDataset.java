package com.tibtech.nifi.processors.kite;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StoreInKiteDataset {
  /**
   * A comma-separated list of Hadoop configuration files
   */
  public static final String HADOOP_CONFIGURATION_FILES_PROPERTY = "Hadoop configuration files";

  /**
   * URI that identifies a Kite dataset where data will be stored
   */
  public static final String TARGET_DATASET_URI_PROPERTY = "Target dataset URI";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A comma-separated list of Hadoop configuration files
   */
  public final String getHadoopConfigurationFiles() {
    return properties.get(HADOOP_CONFIGURATION_FILES_PROPERTY);
  }

  /**
   * A comma-separated list of Hadoop configuration files
   */
  public final StoreInKiteDataset setHadoopConfigurationFiles(final String hadoopConfigurationFiles) {
    properties.put(HADOOP_CONFIGURATION_FILES_PROPERTY, hadoopConfigurationFiles);
    return this;
  }

  /**
   * A comma-separated list of Hadoop configuration files
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

  public static final Map<String, String> build(final Function<StoreInKiteDataset, StoreInKiteDataset> configurator) {
    return configurator.apply(new StoreInKiteDataset()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StoreInKiteDataset.class) final Closure<StoreInKiteDataset> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kite.StoreInKiteDataset> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.StoreInKiteDataset.class, com.tibtech.nifi.processors.kite.StoreInKiteDataset.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
