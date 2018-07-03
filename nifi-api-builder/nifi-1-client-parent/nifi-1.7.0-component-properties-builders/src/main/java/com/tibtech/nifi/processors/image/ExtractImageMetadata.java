package com.tibtech.nifi.processors.image;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractImageMetadata {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.image.ExtractImageMetadata";

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public static final String MAX_NUMBER_OF_ATTRIBUTES_PROPERTY = "Max Number of Attributes";

  private final Map<String, String> properties;

  public ExtractImageMetadata() {
    this.properties = new HashMap<>();
  }

  public ExtractImageMetadata(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public final String getMaxNumberOfAttributes() {
    return properties.get(MAX_NUMBER_OF_ATTRIBUTES_PROPERTY);
  }

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public final ExtractImageMetadata setMaxNumberOfAttributes(final String maxNumberOfAttributes) {
    properties.put(MAX_NUMBER_OF_ATTRIBUTES_PROPERTY, maxNumberOfAttributes);
    return this;
  }

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public final ExtractImageMetadata removeMaxNumberOfAttributes() {
    properties.remove(MAX_NUMBER_OF_ATTRIBUTES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractImageMetadata setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractImageMetadata removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExtractImageMetadata, ExtractImageMetadata> configurator) {
    return configurator.apply(new ExtractImageMetadata()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractImageMetadata.class) final Closure<ExtractImageMetadata> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.image.ExtractImageMetadata> code = closure.rehydrate(c, com.tibtech.nifi.processors.image.ExtractImageMetadata.class, com.tibtech.nifi.processors.image.ExtractImageMetadata.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractImageMetadata, ExtractImageMetadata> configurator) {
    return configurator.apply(new ExtractImageMetadata(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractImageMetadata.class) final Closure<ExtractImageMetadata> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.image.ExtractImageMetadata> code = closure.rehydrate(c, com.tibtech.nifi.processors.image.ExtractImageMetadata.class, com.tibtech.nifi.processors.image.ExtractImageMetadata.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
