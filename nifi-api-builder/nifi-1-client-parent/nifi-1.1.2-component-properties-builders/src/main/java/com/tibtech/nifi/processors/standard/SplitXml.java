package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SplitXml {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.SplitXml";

  /**
   * Indicates the XML-nesting depth to start splitting XML fragments. A depth of 1 means split the root's children, whereas a depth of 2 means split the root's children's children and so forth.
   */
  public static final String SPLIT_DEPTH_PROPERTY = "Split Depth";

  private final Map<String, String> properties;

  public SplitXml() {
    this.properties = new HashMap<>();
  }

  public SplitXml(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Indicates the XML-nesting depth to start splitting XML fragments. A depth of 1 means split the root's children, whereas a depth of 2 means split the root's children's children and so forth.
   */
  public final String getSplitDepth() {
    return properties.get(SPLIT_DEPTH_PROPERTY);
  }

  /**
   * Indicates the XML-nesting depth to start splitting XML fragments. A depth of 1 means split the root's children, whereas a depth of 2 means split the root's children's children and so forth.
   */
  public final SplitXml setSplitDepth(final String splitDepth) {
    properties.put(SPLIT_DEPTH_PROPERTY, splitDepth);
    return this;
  }

  /**
   * Indicates the XML-nesting depth to start splitting XML fragments. A depth of 1 means split the root's children, whereas a depth of 2 means split the root's children's children and so forth.
   */
  public final SplitXml removeSplitDepth() {
    properties.remove(SPLIT_DEPTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SplitXml setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SplitXml removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SplitXml, SplitXml> configurator) {
    return configurator.apply(new SplitXml()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitXml.class) final Closure<SplitXml> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitXml> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitXml.class, com.tibtech.nifi.processors.standard.SplitXml.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SplitXml, SplitXml> configurator) {
    return configurator.apply(new SplitXml(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitXml.class) final Closure<SplitXml> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitXml> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitXml.class, com.tibtech.nifi.processors.standard.SplitXml.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
