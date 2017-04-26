package com.tibtech.nifi.controller;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MonitorDiskUsage {
  /**
   * The threshold at which a bulletin will be generated to indicate that the disk usage of the partition on which the directory found is of concern
   */
  public static final String THRESHOLD_PROPERTY = "Threshold";

  /**
   * The directory path of the partition to be monitored.
   */
  public static final String DIRECTORY_LOCATION_PROPERTY = "Directory Location";

  /**
   * The name to display for the directory in alerts.
   */
  public static final String DIRECTORY_DISPLAY_NAME_PROPERTY = "Directory Display Name";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The threshold at which a bulletin will be generated to indicate that the disk usage of the partition on which the directory found is of concern
   */
  public final String getThreshold() {
    return properties.get(THRESHOLD_PROPERTY);
  }

  /**
   * The threshold at which a bulletin will be generated to indicate that the disk usage of the partition on which the directory found is of concern
   */
  public final MonitorDiskUsage setThreshold(final String threshold) {
    properties.put(THRESHOLD_PROPERTY, threshold);
    return this;
  }

  /**
   * The threshold at which a bulletin will be generated to indicate that the disk usage of the partition on which the directory found is of concern
   */
  public final MonitorDiskUsage removeThreshold() {
    properties.remove(THRESHOLD_PROPERTY);
    return this;
  }

  /**
   * The directory path of the partition to be monitored.
   */
  public final String getDirectoryLocation() {
    return properties.get(DIRECTORY_LOCATION_PROPERTY);
  }

  /**
   * The directory path of the partition to be monitored.
   */
  public final MonitorDiskUsage setDirectoryLocation(final String directoryLocation) {
    properties.put(DIRECTORY_LOCATION_PROPERTY, directoryLocation);
    return this;
  }

  /**
   * The directory path of the partition to be monitored.
   */
  public final MonitorDiskUsage removeDirectoryLocation() {
    properties.remove(DIRECTORY_LOCATION_PROPERTY);
    return this;
  }

  /**
   * The name to display for the directory in alerts.
   */
  public final String getDirectoryDisplayName() {
    return properties.get(DIRECTORY_DISPLAY_NAME_PROPERTY);
  }

  /**
   * The name to display for the directory in alerts.
   */
  public final MonitorDiskUsage setDirectoryDisplayName(final String directoryDisplayName) {
    properties.put(DIRECTORY_DISPLAY_NAME_PROPERTY, directoryDisplayName);
    return this;
  }

  /**
   * The name to display for the directory in alerts.
   */
  public final MonitorDiskUsage removeDirectoryDisplayName() {
    properties.remove(DIRECTORY_DISPLAY_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MonitorDiskUsage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MonitorDiskUsage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<MonitorDiskUsage, MonitorDiskUsage> configurator) {
    return configurator.apply(new MonitorDiskUsage()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MonitorDiskUsage.class) final Closure<MonitorDiskUsage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.controller.MonitorDiskUsage> code = closure.rehydrate(c, com.tibtech.nifi.controller.MonitorDiskUsage.class, com.tibtech.nifi.controller.MonitorDiskUsage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
