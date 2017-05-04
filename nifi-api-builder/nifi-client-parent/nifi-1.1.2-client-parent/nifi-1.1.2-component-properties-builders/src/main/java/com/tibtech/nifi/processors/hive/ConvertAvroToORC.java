package com.tibtech.nifi.processors.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertAvroToORC {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hive.ConvertAvroToORC";

  /**
   * A file or comma separated list of files which contains the ORC configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Please see the ORC documentation for more details.
   */
  public static final String ORC_CONFIG_RESOURCES_PROPERTY = "orc-config-resources";

  /**
   * The size of the memory buffer (in bytes) for writing stripes to an ORC file
   */
  public static final String ORC_STRIPE_SIZE_PROPERTY = "orc-stripe-size";

  /**
   * The maximum size of the memory buffers (in bytes) used for compressing and storing a stripe in memory. This is a hint to the ORC writer, which may choose to use a smaller buffer size based on stripe size and number of columns for efficient stripe writing and memory utilization.
   */
  public static final String ORC_BUFFER_SIZE_PROPERTY = "orc-buffer-size";

  /**
   *
   */
  public static final String ORC_COMPRESSION_TYPE_PROPERTY = "orc-compression-type";

  /**
   * An optional table name to insert into the hive.ddl attribute. The generated DDL can be used by a PutHiveQL processor (presumably after a PutHDFS processor) to create a table backed by the converted ORC file. If this property is not provided, the full name (including namespace) of the incoming Avro record will be normalized and used as the table name.
   */
  public static final String ORC_HIVE_TABLE_NAME_PROPERTY = "orc-hive-table-name";

  private final Map<String, String> properties;

  public ConvertAvroToORC() {
    this.properties = new HashMap<>();
  }

  public ConvertAvroToORC(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A file or comma separated list of files which contains the ORC configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Please see the ORC documentation for more details.
   */
  public final String getOrcConfigResources() {
    return properties.get(ORC_CONFIG_RESOURCES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the ORC configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Please see the ORC documentation for more details.
   */
  public final ConvertAvroToORC setOrcConfigResources(final String orcConfigResources) {
    properties.put(ORC_CONFIG_RESOURCES_PROPERTY, orcConfigResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the ORC configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Please see the ORC documentation for more details.
   */
  public final ConvertAvroToORC removeOrcConfigResources() {
    properties.remove(ORC_CONFIG_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * The size of the memory buffer (in bytes) for writing stripes to an ORC file
   */
  public final String getOrcStripeSize() {
    return properties.get(ORC_STRIPE_SIZE_PROPERTY);
  }

  /**
   * The size of the memory buffer (in bytes) for writing stripes to an ORC file
   */
  public final ConvertAvroToORC setOrcStripeSize(final String orcStripeSize) {
    properties.put(ORC_STRIPE_SIZE_PROPERTY, orcStripeSize);
    return this;
  }

  /**
   * The size of the memory buffer (in bytes) for writing stripes to an ORC file
   */
  public final ConvertAvroToORC removeOrcStripeSize() {
    properties.remove(ORC_STRIPE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size of the memory buffers (in bytes) used for compressing and storing a stripe in memory. This is a hint to the ORC writer, which may choose to use a smaller buffer size based on stripe size and number of columns for efficient stripe writing and memory utilization.
   */
  public final String getOrcBufferSize() {
    return properties.get(ORC_BUFFER_SIZE_PROPERTY);
  }

  /**
   * The maximum size of the memory buffers (in bytes) used for compressing and storing a stripe in memory. This is a hint to the ORC writer, which may choose to use a smaller buffer size based on stripe size and number of columns for efficient stripe writing and memory utilization.
   */
  public final ConvertAvroToORC setOrcBufferSize(final String orcBufferSize) {
    properties.put(ORC_BUFFER_SIZE_PROPERTY, orcBufferSize);
    return this;
  }

  /**
   * The maximum size of the memory buffers (in bytes) used for compressing and storing a stripe in memory. This is a hint to the ORC writer, which may choose to use a smaller buffer size based on stripe size and number of columns for efficient stripe writing and memory utilization.
   */
  public final ConvertAvroToORC removeOrcBufferSize() {
    properties.remove(ORC_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getOrcCompressionType() {
    return properties.get(ORC_COMPRESSION_TYPE_PROPERTY);
  }

  /**
   *
   */
  public final ConvertAvroToORC setOrcCompressionType(final String orcCompressionType) {
    properties.put(ORC_COMPRESSION_TYPE_PROPERTY, orcCompressionType);
    return this;
  }

  /**
   *
   */
  public final ConvertAvroToORC removeOrcCompressionType() {
    properties.remove(ORC_COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  /**
   * An optional table name to insert into the hive.ddl attribute. The generated DDL can be used by a PutHiveQL processor (presumably after a PutHDFS processor) to create a table backed by the converted ORC file. If this property is not provided, the full name (including namespace) of the incoming Avro record will be normalized and used as the table name.
   */
  public final String getOrcHiveTableName() {
    return properties.get(ORC_HIVE_TABLE_NAME_PROPERTY);
  }

  /**
   * An optional table name to insert into the hive.ddl attribute. The generated DDL can be used by a PutHiveQL processor (presumably after a PutHDFS processor) to create a table backed by the converted ORC file. If this property is not provided, the full name (including namespace) of the incoming Avro record will be normalized and used as the table name.
   */
  public final ConvertAvroToORC setOrcHiveTableName(final String orcHiveTableName) {
    properties.put(ORC_HIVE_TABLE_NAME_PROPERTY, orcHiveTableName);
    return this;
  }

  /**
   * An optional table name to insert into the hive.ddl attribute. The generated DDL can be used by a PutHiveQL processor (presumably after a PutHDFS processor) to create a table backed by the converted ORC file. If this property is not provided, the full name (including namespace) of the incoming Avro record will be normalized and used as the table name.
   */
  public final ConvertAvroToORC removeOrcHiveTableName() {
    properties.remove(ORC_HIVE_TABLE_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertAvroToORC setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertAvroToORC removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConvertAvroToORC, ConvertAvroToORC> configurator) {
    return configurator.apply(new ConvertAvroToORC()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertAvroToORC.class) final Closure<ConvertAvroToORC> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hive.ConvertAvroToORC> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.ConvertAvroToORC.class, com.tibtech.nifi.processors.hive.ConvertAvroToORC.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertAvroToORC, ConvertAvroToORC> configurator) {
    return configurator.apply(new ConvertAvroToORC(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertAvroToORC.class) final Closure<ConvertAvroToORC> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hive.ConvertAvroToORC> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.ConvertAvroToORC.class, com.tibtech.nifi.processors.hive.ConvertAvroToORC.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
