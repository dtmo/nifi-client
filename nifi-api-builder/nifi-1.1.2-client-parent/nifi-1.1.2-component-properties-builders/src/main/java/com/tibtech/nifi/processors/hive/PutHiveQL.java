package com.tibtech.nifi.processors.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHiveQL {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hive.PutHiveQL";

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public static final String HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Hive Database Connection Pooling Service";

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public static final String HIVE_BATCH_SIZE_PROPERTY = "hive-batch-size";

  /**
   * Specifies the character set of the record data.
   */
  public static final String HIVE_CHARSET_PROPERTY = "hive-charset";

  private final Map<String, String> properties;

  public PutHiveQL() {
    this.properties = new HashMap<>();
  }

  public PutHiveQL(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final String getHiveDatabaseConnectionPoolingService() {
    return properties.get(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final PutHiveQL setHiveDatabaseConnectionPoolingService(final String hiveDatabaseConnectionPoolingService) {
    properties.put(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, hiveDatabaseConnectionPoolingService);
    return this;
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final PutHiveQL removeHiveDatabaseConnectionPoolingService() {
    properties.remove(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final String getHiveBatchSize() {
    return properties.get(HIVE_BATCH_SIZE_PROPERTY);
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutHiveQL setHiveBatchSize(final String hiveBatchSize) {
    properties.put(HIVE_BATCH_SIZE_PROPERTY, hiveBatchSize);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutHiveQL removeHiveBatchSize() {
    properties.remove(HIVE_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final String getHiveCharset() {
    return properties.get(HIVE_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the record data.
   */
  public final PutHiveQL setHiveCharset(final String hiveCharset) {
    properties.put(HIVE_CHARSET_PROPERTY, hiveCharset);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final PutHiveQL removeHiveCharset() {
    properties.remove(HIVE_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHiveQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHiveQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutHiveQL, PutHiveQL> configurator) {
    return configurator.apply(new PutHiveQL()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHiveQL.class) final Closure<PutHiveQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hive.PutHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.PutHiveQL.class, com.tibtech.nifi.processors.hive.PutHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHiveQL, PutHiveQL> configurator) {
    return configurator.apply(new PutHiveQL(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHiveQL.class) final Closure<PutHiveQL> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hive.PutHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.PutHiveQL.class, com.tibtech.nifi.processors.hive.PutHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
