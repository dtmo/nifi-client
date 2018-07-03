package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class IdentifyMimeType {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.IdentifyMimeType";

  /**
   * If true will pass the filename to Tika to aid in detection.
   */
  public static final String USE_FILENAME_IN_DETECTION_PROPERTY = "use-filename-in-detection";

  private final Map<String, String> properties;

  public IdentifyMimeType() {
    this.properties = new HashMap<>();
  }

  public IdentifyMimeType(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * If true will pass the filename to Tika to aid in detection.
   */
  public final String getUseFilenameInDetection() {
    return properties.get(USE_FILENAME_IN_DETECTION_PROPERTY);
  }

  /**
   * If true will pass the filename to Tika to aid in detection.
   */
  public final IdentifyMimeType setUseFilenameInDetection(final String useFilenameInDetection) {
    properties.put(USE_FILENAME_IN_DETECTION_PROPERTY, useFilenameInDetection);
    return this;
  }

  /**
   * If true will pass the filename to Tika to aid in detection.
   */
  public final IdentifyMimeType removeUseFilenameInDetection() {
    properties.remove(USE_FILENAME_IN_DETECTION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final IdentifyMimeType setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final IdentifyMimeType removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<IdentifyMimeType, IdentifyMimeType> configurator) {
    return configurator.apply(new IdentifyMimeType()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = IdentifyMimeType.class) final Closure<IdentifyMimeType> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.IdentifyMimeType> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.IdentifyMimeType.class, com.tibtech.nifi.processors.standard.IdentifyMimeType.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<IdentifyMimeType, IdentifyMimeType> configurator) {
    return configurator.apply(new IdentifyMimeType(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = IdentifyMimeType.class) final Closure<IdentifyMimeType> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.IdentifyMimeType> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.IdentifyMimeType.class, com.tibtech.nifi.processors.standard.IdentifyMimeType.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
