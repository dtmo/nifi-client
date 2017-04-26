package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SegmentContent {
  /**
   * The maximum data size in bytes for each segment
   */
  public static final String SEGMENT_SIZE_PROPERTY = "Segment Size";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The maximum data size in bytes for each segment
   */
  public final String getSegmentSize() {
    return properties.get(SEGMENT_SIZE_PROPERTY);
  }

  /**
   * The maximum data size in bytes for each segment
   */
  public final SegmentContent setSegmentSize(final String segmentSize) {
    properties.put(SEGMENT_SIZE_PROPERTY, segmentSize);
    return this;
  }

  /**
   * The maximum data size in bytes for each segment
   */
  public final SegmentContent removeSegmentSize() {
    properties.remove(SEGMENT_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SegmentContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SegmentContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SegmentContent, SegmentContent> configurator) {
    return configurator.apply(new SegmentContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SegmentContent.class) final Closure<SegmentContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.SegmentContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SegmentContent.class, com.tibtech.nifi.processors.standard.SegmentContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
