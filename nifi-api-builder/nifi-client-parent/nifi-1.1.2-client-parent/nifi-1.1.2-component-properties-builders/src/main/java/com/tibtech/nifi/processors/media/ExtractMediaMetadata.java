package com.tibtech.nifi.processors.media;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractMediaMetadata {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.media.ExtractMediaMetadata";

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public static final String MAX_NUMBER_OF_ATTRIBUTES_PROPERTY = "Max Number of Attributes";

  /**
   * Specifies the maximum length of a single attribute value.  When a metadata item has multiple values, they will be merged until this length is reached and then ", ..." will be added as an indicator that additional values where dropped.  If a single value is longer than this, it will be truncated and "(truncated)" appended to indicate that truncation occurred.
   */
  public static final String MAX_ATTRIBUTE_LENGTH_PROPERTY = "Max Attribute Length";

  /**
   * A regular expression identifying which metadata keys received from the parser should be added to the flowfile attributes.  If left blank, all metadata keys parsed will be added to the flowfile attributes.
   */
  public static final String METADATA_KEY_FILTER_PROPERTY = "Metadata Key Filter";

  /**
   * Text to be prefixed to metadata keys as the are added to the flowfile attributes.  It is recommended to end with with a separator character like '.' or '-', this is not automatically  added by the processor.
   */
  public static final String METADATA_KEY_PREFIX_PROPERTY = "Metadata Key Prefix";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public final String getMaxNumberOfAttributes() {
    return properties.get(MAX_NUMBER_OF_ATTRIBUTES_PROPERTY);
  }

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public final ExtractMediaMetadata setMaxNumberOfAttributes(final String maxNumberOfAttributes) {
    properties.put(MAX_NUMBER_OF_ATTRIBUTES_PROPERTY, maxNumberOfAttributes);
    return this;
  }

  /**
   * Specify the max number of attributes to add to the flowfile. There is no guarantee in what order the tags will be processed. By default it will process all of them.
   */
  public final ExtractMediaMetadata removeMaxNumberOfAttributes() {
    properties.remove(MAX_NUMBER_OF_ATTRIBUTES_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum length of a single attribute value.  When a metadata item has multiple values, they will be merged until this length is reached and then ", ..." will be added as an indicator that additional values where dropped.  If a single value is longer than this, it will be truncated and "(truncated)" appended to indicate that truncation occurred.
   */
  public final String getMaxAttributeLength() {
    return properties.get(MAX_ATTRIBUTE_LENGTH_PROPERTY);
  }

  /**
   * Specifies the maximum length of a single attribute value.  When a metadata item has multiple values, they will be merged until this length is reached and then ", ..." will be added as an indicator that additional values where dropped.  If a single value is longer than this, it will be truncated and "(truncated)" appended to indicate that truncation occurred.
   */
  public final ExtractMediaMetadata setMaxAttributeLength(final String maxAttributeLength) {
    properties.put(MAX_ATTRIBUTE_LENGTH_PROPERTY, maxAttributeLength);
    return this;
  }

  /**
   * Specifies the maximum length of a single attribute value.  When a metadata item has multiple values, they will be merged until this length is reached and then ", ..." will be added as an indicator that additional values where dropped.  If a single value is longer than this, it will be truncated and "(truncated)" appended to indicate that truncation occurred.
   */
  public final ExtractMediaMetadata removeMaxAttributeLength() {
    properties.remove(MAX_ATTRIBUTE_LENGTH_PROPERTY);
    return this;
  }

  /**
   * A regular expression identifying which metadata keys received from the parser should be added to the flowfile attributes.  If left blank, all metadata keys parsed will be added to the flowfile attributes.
   */
  public final String getMetadataKeyFilter() {
    return properties.get(METADATA_KEY_FILTER_PROPERTY);
  }

  /**
   * A regular expression identifying which metadata keys received from the parser should be added to the flowfile attributes.  If left blank, all metadata keys parsed will be added to the flowfile attributes.
   */
  public final ExtractMediaMetadata setMetadataKeyFilter(final String metadataKeyFilter) {
    properties.put(METADATA_KEY_FILTER_PROPERTY, metadataKeyFilter);
    return this;
  }

  /**
   * A regular expression identifying which metadata keys received from the parser should be added to the flowfile attributes.  If left blank, all metadata keys parsed will be added to the flowfile attributes.
   */
  public final ExtractMediaMetadata removeMetadataKeyFilter() {
    properties.remove(METADATA_KEY_FILTER_PROPERTY);
    return this;
  }

  /**
   * Text to be prefixed to metadata keys as the are added to the flowfile attributes.  It is recommended to end with with a separator character like '.' or '-', this is not automatically  added by the processor.
   */
  public final String getMetadataKeyPrefix() {
    return properties.get(METADATA_KEY_PREFIX_PROPERTY);
  }

  /**
   * Text to be prefixed to metadata keys as the are added to the flowfile attributes.  It is recommended to end with with a separator character like '.' or '-', this is not automatically  added by the processor.
   */
  public final ExtractMediaMetadata setMetadataKeyPrefix(final String metadataKeyPrefix) {
    properties.put(METADATA_KEY_PREFIX_PROPERTY, metadataKeyPrefix);
    return this;
  }

  /**
   * Text to be prefixed to metadata keys as the are added to the flowfile attributes.  It is recommended to end with with a separator character like '.' or '-', this is not automatically  added by the processor.
   */
  public final ExtractMediaMetadata removeMetadataKeyPrefix() {
    properties.remove(METADATA_KEY_PREFIX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractMediaMetadata setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractMediaMetadata removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ExtractMediaMetadata, ExtractMediaMetadata> configurator) {
    return configurator.apply(new ExtractMediaMetadata()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractMediaMetadata.class) final Closure<ExtractMediaMetadata> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.media.ExtractMediaMetadata> code = closure.rehydrate(c, com.tibtech.nifi.processors.media.ExtractMediaMetadata.class, com.tibtech.nifi.processors.media.ExtractMediaMetadata.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
