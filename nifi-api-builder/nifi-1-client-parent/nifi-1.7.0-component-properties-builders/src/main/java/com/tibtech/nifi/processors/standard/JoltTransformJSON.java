package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class JoltTransformJSON {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.JoltTransformJSON";

  /**
   * Specifies the Jolt Transformation that should be used with the provided specification.
   */
  public static final String JOLT_TRANSFORM_PROPERTY = "jolt-transform";

  /**
   * Fully Qualified Class Name for Custom Transformation
   */
  public static final String JOLT_CUSTOM_CLASS_PROPERTY = "jolt-custom-class";

  /**
   * Comma-separated list of paths to files and/or directories which contain modules containing custom transformations (that are not included on NiFi's classpath).
   */
  public static final String JOLT_CUSTOM_MODULES_PROPERTY = "jolt-custom-modules";

  /**
   * Jolt Specification for transform of JSON data. This value is ignored if the Jolt Sort Transformation is selected.
   */
  public static final String JOLT_SPEC_PROPERTY = "jolt-spec";

  /**
   * Compiling a Jolt Transform can be fairly expensive. Ideally, this will be done only once. However, if the Expression Language is used in the transform, we may need a new Transform for each FlowFile. This value controls how many of those Transforms we cache in memory in order to avoid having to compile the Transform each time.
   */
  public static final String TRANSFORM_CACHE_SIZE_PROPERTY = "Transform Cache Size";

  private final Map<String, String> properties;

  public JoltTransformJSON() {
    this.properties = new HashMap<>();
  }

  public JoltTransformJSON(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Jolt Transformation that should be used with the provided specification.
   */
  public final String getJoltTransform() {
    return properties.get(JOLT_TRANSFORM_PROPERTY);
  }

  /**
   * Specifies the Jolt Transformation that should be used with the provided specification.
   */
  public final JoltTransformJSON setJoltTransform(final String joltTransform) {
    properties.put(JOLT_TRANSFORM_PROPERTY, joltTransform);
    return this;
  }

  /**
   * Specifies the Jolt Transformation that should be used with the provided specification.
   */
  public final JoltTransformJSON removeJoltTransform() {
    properties.remove(JOLT_TRANSFORM_PROPERTY);
    return this;
  }

  /**
   * Fully Qualified Class Name for Custom Transformation
   */
  public final String getJoltCustomClass() {
    return properties.get(JOLT_CUSTOM_CLASS_PROPERTY);
  }

  /**
   * Fully Qualified Class Name for Custom Transformation
   */
  public final JoltTransformJSON setJoltCustomClass(final String joltCustomClass) {
    properties.put(JOLT_CUSTOM_CLASS_PROPERTY, joltCustomClass);
    return this;
  }

  /**
   * Fully Qualified Class Name for Custom Transformation
   */
  public final JoltTransformJSON removeJoltCustomClass() {
    properties.remove(JOLT_CUSTOM_CLASS_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules containing custom transformations (that are not included on NiFi's classpath).
   */
  public final String getJoltCustomModules() {
    return properties.get(JOLT_CUSTOM_MODULES_PROPERTY);
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules containing custom transformations (that are not included on NiFi's classpath).
   */
  public final JoltTransformJSON setJoltCustomModules(final String joltCustomModules) {
    properties.put(JOLT_CUSTOM_MODULES_PROPERTY, joltCustomModules);
    return this;
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules containing custom transformations (that are not included on NiFi's classpath).
   */
  public final JoltTransformJSON removeJoltCustomModules() {
    properties.remove(JOLT_CUSTOM_MODULES_PROPERTY);
    return this;
  }

  /**
   * Jolt Specification for transform of JSON data. This value is ignored if the Jolt Sort Transformation is selected.
   */
  public final String getJoltSpec() {
    return properties.get(JOLT_SPEC_PROPERTY);
  }

  /**
   * Jolt Specification for transform of JSON data. This value is ignored if the Jolt Sort Transformation is selected.
   */
  public final JoltTransformJSON setJoltSpec(final String joltSpec) {
    properties.put(JOLT_SPEC_PROPERTY, joltSpec);
    return this;
  }

  /**
   * Jolt Specification for transform of JSON data. This value is ignored if the Jolt Sort Transformation is selected.
   */
  public final JoltTransformJSON removeJoltSpec() {
    properties.remove(JOLT_SPEC_PROPERTY);
    return this;
  }

  /**
   * Compiling a Jolt Transform can be fairly expensive. Ideally, this will be done only once. However, if the Expression Language is used in the transform, we may need a new Transform for each FlowFile. This value controls how many of those Transforms we cache in memory in order to avoid having to compile the Transform each time.
   */
  public final String getTransformCacheSize() {
    return properties.get(TRANSFORM_CACHE_SIZE_PROPERTY);
  }

  /**
   * Compiling a Jolt Transform can be fairly expensive. Ideally, this will be done only once. However, if the Expression Language is used in the transform, we may need a new Transform for each FlowFile. This value controls how many of those Transforms we cache in memory in order to avoid having to compile the Transform each time.
   */
  public final JoltTransformJSON setTransformCacheSize(final String transformCacheSize) {
    properties.put(TRANSFORM_CACHE_SIZE_PROPERTY, transformCacheSize);
    return this;
  }

  /**
   * Compiling a Jolt Transform can be fairly expensive. Ideally, this will be done only once. However, if the Expression Language is used in the transform, we may need a new Transform for each FlowFile. This value controls how many of those Transforms we cache in memory in order to avoid having to compile the Transform each time.
   */
  public final JoltTransformJSON removeTransformCacheSize() {
    properties.remove(TRANSFORM_CACHE_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final JoltTransformJSON setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final JoltTransformJSON removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<JoltTransformJSON, JoltTransformJSON> configurator) {
    return configurator.apply(new JoltTransformJSON()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JoltTransformJSON.class) final Closure<JoltTransformJSON> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.JoltTransformJSON> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.JoltTransformJSON.class, com.tibtech.nifi.processors.standard.JoltTransformJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<JoltTransformJSON, JoltTransformJSON> configurator) {
    return configurator.apply(new JoltTransformJSON(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JoltTransformJSON.class) final Closure<JoltTransformJSON> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.JoltTransformJSON> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.JoltTransformJSON.class, com.tibtech.nifi.processors.standard.JoltTransformJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
