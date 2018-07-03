package com.tibtech.nifi.processors.avro;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractAvroMetadata {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.avro.ExtractAvroMetadata";

  /**
   * The algorithm used to generate the schema fingerprint. Available choices are based on the Avro recommended practices for fingerprint generation.
   */
  public static final String FINGERPRINT_ALGORITHM_PROPERTY = "Fingerprint Algorithm";

  /**
   * A comma-separated list of keys indicating key/value pairs to extract from the Avro file header. The key 'avro.schema' can be used to extract the full schema in JSON format, and 'avro.codec' can be used to extract the codec name if one exists.
   */
  public static final String METADATA_KEYS_PROPERTY = "Metadata Keys";

  /**
   * If true the number of items in the datafile will be counted and stored in a FlowFile attribute 'item.count'. The counting is done by reading blocks and getting the number of items for each block, thus avoiding de-serializing. The items being counted will be the top-level items in the datafile. For example, with a schema of type record the items will be the records, and for a schema of type Array the items will be the arrays (not the number of entries in each array).
   */
  public static final String COUNT_ITEMS_PROPERTY = "Count Items";

  private final Map<String, String> properties;

  public ExtractAvroMetadata() {
    this.properties = new HashMap<>();
  }

  public ExtractAvroMetadata(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The algorithm used to generate the schema fingerprint. Available choices are based on the Avro recommended practices for fingerprint generation.
   */
  public final String getFingerprintAlgorithm() {
    return properties.get(FINGERPRINT_ALGORITHM_PROPERTY);
  }

  /**
   * The algorithm used to generate the schema fingerprint. Available choices are based on the Avro recommended practices for fingerprint generation.
   */
  public final ExtractAvroMetadata setFingerprintAlgorithm(final String fingerprintAlgorithm) {
    properties.put(FINGERPRINT_ALGORITHM_PROPERTY, fingerprintAlgorithm);
    return this;
  }

  /**
   * The algorithm used to generate the schema fingerprint. Available choices are based on the Avro recommended practices for fingerprint generation.
   */
  public final ExtractAvroMetadata removeFingerprintAlgorithm() {
    properties.remove(FINGERPRINT_ALGORITHM_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of keys indicating key/value pairs to extract from the Avro file header. The key 'avro.schema' can be used to extract the full schema in JSON format, and 'avro.codec' can be used to extract the codec name if one exists.
   */
  public final String getMetadataKeys() {
    return properties.get(METADATA_KEYS_PROPERTY);
  }

  /**
   * A comma-separated list of keys indicating key/value pairs to extract from the Avro file header. The key 'avro.schema' can be used to extract the full schema in JSON format, and 'avro.codec' can be used to extract the codec name if one exists.
   */
  public final ExtractAvroMetadata setMetadataKeys(final String metadataKeys) {
    properties.put(METADATA_KEYS_PROPERTY, metadataKeys);
    return this;
  }

  /**
   * A comma-separated list of keys indicating key/value pairs to extract from the Avro file header. The key 'avro.schema' can be used to extract the full schema in JSON format, and 'avro.codec' can be used to extract the codec name if one exists.
   */
  public final ExtractAvroMetadata removeMetadataKeys() {
    properties.remove(METADATA_KEYS_PROPERTY);
    return this;
  }

  /**
   * If true the number of items in the datafile will be counted and stored in a FlowFile attribute 'item.count'. The counting is done by reading blocks and getting the number of items for each block, thus avoiding de-serializing. The items being counted will be the top-level items in the datafile. For example, with a schema of type record the items will be the records, and for a schema of type Array the items will be the arrays (not the number of entries in each array).
   */
  public final String getCountItems() {
    return properties.get(COUNT_ITEMS_PROPERTY);
  }

  /**
   * If true the number of items in the datafile will be counted and stored in a FlowFile attribute 'item.count'. The counting is done by reading blocks and getting the number of items for each block, thus avoiding de-serializing. The items being counted will be the top-level items in the datafile. For example, with a schema of type record the items will be the records, and for a schema of type Array the items will be the arrays (not the number of entries in each array).
   */
  public final ExtractAvroMetadata setCountItems(final String countItems) {
    properties.put(COUNT_ITEMS_PROPERTY, countItems);
    return this;
  }

  /**
   * If true the number of items in the datafile will be counted and stored in a FlowFile attribute 'item.count'. The counting is done by reading blocks and getting the number of items for each block, thus avoiding de-serializing. The items being counted will be the top-level items in the datafile. For example, with a schema of type record the items will be the records, and for a schema of type Array the items will be the arrays (not the number of entries in each array).
   */
  public final ExtractAvroMetadata removeCountItems() {
    properties.remove(COUNT_ITEMS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractAvroMetadata setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractAvroMetadata removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExtractAvroMetadata, ExtractAvroMetadata> configurator) {
    return configurator.apply(new ExtractAvroMetadata()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractAvroMetadata.class) final Closure<ExtractAvroMetadata> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.avro.ExtractAvroMetadata> code = closure.rehydrate(c, com.tibtech.nifi.processors.avro.ExtractAvroMetadata.class, com.tibtech.nifi.processors.avro.ExtractAvroMetadata.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractAvroMetadata, ExtractAvroMetadata> configurator) {
    return configurator.apply(new ExtractAvroMetadata(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractAvroMetadata.class) final Closure<ExtractAvroMetadata> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.avro.ExtractAvroMetadata> code = closure.rehydrate(c, com.tibtech.nifi.processors.avro.ExtractAvroMetadata.class, com.tibtech.nifi.processors.avro.ExtractAvroMetadata.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
