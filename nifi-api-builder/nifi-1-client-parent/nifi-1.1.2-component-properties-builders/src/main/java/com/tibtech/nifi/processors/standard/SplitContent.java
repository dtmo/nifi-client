package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SplitContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.SplitContent";

  /**
   * Specifies how the <Byte Sequence> property should be interpreted
   */
  public static final String BYTE_SEQUENCE_FORMAT_PROPERTY = "Byte Sequence Format";

  /**
   * A representation of bytes to look for and upon which to split the source file into separate files
   */
  public static final String BYTE_SEQUENCE_PROPERTY = "Byte Sequence";

  /**
   * Determines whether or not the Byte Sequence should be included with each Split
   */
  public static final String KEEP_BYTE_SEQUENCE_PROPERTY = "Keep Byte Sequence";

  /**
   * If <Keep Byte Sequence> is set to true, specifies whether the byte sequence should be added to the end of the first split or the beginning of the second; if <Keep Byte Sequence> is false, this property is ignored.
   */
  public static final String BYTE_SEQUENCE_LOCATION_PROPERTY = "Byte Sequence Location";

  private final Map<String, String> properties;

  public SplitContent() {
    this.properties = new HashMap<>();
  }

  public SplitContent(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies how the <Byte Sequence> property should be interpreted
   */
  public final String getByteSequenceFormat() {
    return properties.get(BYTE_SEQUENCE_FORMAT_PROPERTY);
  }

  /**
   * Specifies how the <Byte Sequence> property should be interpreted
   */
  public final SplitContent setByteSequenceFormat(final String byteSequenceFormat) {
    properties.put(BYTE_SEQUENCE_FORMAT_PROPERTY, byteSequenceFormat);
    return this;
  }

  /**
   * Specifies how the <Byte Sequence> property should be interpreted
   */
  public final SplitContent removeByteSequenceFormat() {
    properties.remove(BYTE_SEQUENCE_FORMAT_PROPERTY);
    return this;
  }

  /**
   * A representation of bytes to look for and upon which to split the source file into separate files
   */
  public final String getByteSequence() {
    return properties.get(BYTE_SEQUENCE_PROPERTY);
  }

  /**
   * A representation of bytes to look for and upon which to split the source file into separate files
   */
  public final SplitContent setByteSequence(final String byteSequence) {
    properties.put(BYTE_SEQUENCE_PROPERTY, byteSequence);
    return this;
  }

  /**
   * A representation of bytes to look for and upon which to split the source file into separate files
   */
  public final SplitContent removeByteSequence() {
    properties.remove(BYTE_SEQUENCE_PROPERTY);
    return this;
  }

  /**
   * Determines whether or not the Byte Sequence should be included with each Split
   */
  public final String getKeepByteSequence() {
    return properties.get(KEEP_BYTE_SEQUENCE_PROPERTY);
  }

  /**
   * Determines whether or not the Byte Sequence should be included with each Split
   */
  public final SplitContent setKeepByteSequence(final String keepByteSequence) {
    properties.put(KEEP_BYTE_SEQUENCE_PROPERTY, keepByteSequence);
    return this;
  }

  /**
   * Determines whether or not the Byte Sequence should be included with each Split
   */
  public final SplitContent removeKeepByteSequence() {
    properties.remove(KEEP_BYTE_SEQUENCE_PROPERTY);
    return this;
  }

  /**
   * If <Keep Byte Sequence> is set to true, specifies whether the byte sequence should be added to the end of the first split or the beginning of the second; if <Keep Byte Sequence> is false, this property is ignored.
   */
  public final String getByteSequenceLocation() {
    return properties.get(BYTE_SEQUENCE_LOCATION_PROPERTY);
  }

  /**
   * If <Keep Byte Sequence> is set to true, specifies whether the byte sequence should be added to the end of the first split or the beginning of the second; if <Keep Byte Sequence> is false, this property is ignored.
   */
  public final SplitContent setByteSequenceLocation(final String byteSequenceLocation) {
    properties.put(BYTE_SEQUENCE_LOCATION_PROPERTY, byteSequenceLocation);
    return this;
  }

  /**
   * If <Keep Byte Sequence> is set to true, specifies whether the byte sequence should be added to the end of the first split or the beginning of the second; if <Keep Byte Sequence> is false, this property is ignored.
   */
  public final SplitContent removeByteSequenceLocation() {
    properties.remove(BYTE_SEQUENCE_LOCATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SplitContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SplitContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SplitContent, SplitContent> configurator) {
    return configurator.apply(new SplitContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitContent.class) final Closure<SplitContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitContent.class, com.tibtech.nifi.processors.standard.SplitContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SplitContent, SplitContent> configurator) {
    return configurator.apply(new SplitContent(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitContent.class) final Closure<SplitContent> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitContent.class, com.tibtech.nifi.processors.standard.SplitContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
