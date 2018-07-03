package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ModifyBytes {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ModifyBytes";

  /**
   * Number of bytes removed at the beginning of the file.
   */
  public static final String START_OFFSET_PROPERTY = "Start Offset";

  /**
   * Number of bytes removed at the end of the file.
   */
  public static final String END_OFFSET_PROPERTY = "End Offset";

  /**
   * Remove all content from the FlowFile superseding Start Offset and End Offset properties.
   */
  public static final String REMOVE_ALL_CONTENT_PROPERTY = "Remove All Content";

  private final Map<String, String> properties;

  public ModifyBytes() {
    this.properties = new HashMap<>();
  }

  public ModifyBytes(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Number of bytes removed at the beginning of the file.
   */
  public final String getStartOffset() {
    return properties.get(START_OFFSET_PROPERTY);
  }

  /**
   * Number of bytes removed at the beginning of the file.
   */
  public final ModifyBytes setStartOffset(final String startOffset) {
    properties.put(START_OFFSET_PROPERTY, startOffset);
    return this;
  }

  /**
   * Number of bytes removed at the beginning of the file.
   */
  public final ModifyBytes removeStartOffset() {
    properties.remove(START_OFFSET_PROPERTY);
    return this;
  }

  /**
   * Number of bytes removed at the end of the file.
   */
  public final String getEndOffset() {
    return properties.get(END_OFFSET_PROPERTY);
  }

  /**
   * Number of bytes removed at the end of the file.
   */
  public final ModifyBytes setEndOffset(final String endOffset) {
    properties.put(END_OFFSET_PROPERTY, endOffset);
    return this;
  }

  /**
   * Number of bytes removed at the end of the file.
   */
  public final ModifyBytes removeEndOffset() {
    properties.remove(END_OFFSET_PROPERTY);
    return this;
  }

  /**
   * Remove all content from the FlowFile superseding Start Offset and End Offset properties.
   */
  public final String getRemoveAllContent() {
    return properties.get(REMOVE_ALL_CONTENT_PROPERTY);
  }

  /**
   * Remove all content from the FlowFile superseding Start Offset and End Offset properties.
   */
  public final ModifyBytes setRemoveAllContent(final String removeAllContent) {
    properties.put(REMOVE_ALL_CONTENT_PROPERTY, removeAllContent);
    return this;
  }

  /**
   * Remove all content from the FlowFile superseding Start Offset and End Offset properties.
   */
  public final ModifyBytes removeRemoveAllContent() {
    properties.remove(REMOVE_ALL_CONTENT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ModifyBytes setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ModifyBytes removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ModifyBytes, ModifyBytes> configurator) {
    return configurator.apply(new ModifyBytes()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ModifyBytes.class) final Closure<ModifyBytes> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ModifyBytes> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ModifyBytes.class, com.tibtech.nifi.processors.standard.ModifyBytes.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ModifyBytes, ModifyBytes> configurator) {
    return configurator.apply(new ModifyBytes(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ModifyBytes.class) final Closure<ModifyBytes> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ModifyBytes> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ModifyBytes.class, com.tibtech.nifi.processors.standard.ModifyBytes.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
