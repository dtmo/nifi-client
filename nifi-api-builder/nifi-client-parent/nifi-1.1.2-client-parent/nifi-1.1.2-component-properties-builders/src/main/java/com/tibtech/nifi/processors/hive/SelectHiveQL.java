package com.tibtech.nifi.processors.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SelectHiveQL {
  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public static final String HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Hive Database Connection Pooling Service";

  /**
   * HiveQL SELECT query to execute
   */
  public static final String HIVE_QUERY_PROPERTY = "hive-query";

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public static final String HIVE_OUTPUT_FORMAT_PROPERTY = "hive-output-format";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final String getHiveDatabaseConnectionPoolingService() {
    return properties.get(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final SelectHiveQL setHiveDatabaseConnectionPoolingService(final String hiveDatabaseConnectionPoolingService) {
    properties.put(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, hiveDatabaseConnectionPoolingService);
    return this;
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final SelectHiveQL removeHiveDatabaseConnectionPoolingService() {
    properties.remove(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
    return this;
  }

  /**
   * HiveQL SELECT query to execute
   */
  public final String getHiveQuery() {
    return properties.get(HIVE_QUERY_PROPERTY);
  }

  /**
   * HiveQL SELECT query to execute
   */
  public final SelectHiveQL setHiveQuery(final String hiveQuery) {
    properties.put(HIVE_QUERY_PROPERTY, hiveQuery);
    return this;
  }

  /**
   * HiveQL SELECT query to execute
   */
  public final SelectHiveQL removeHiveQuery() {
    properties.remove(HIVE_QUERY_PROPERTY);
    return this;
  }

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public final String getHiveOutputFormat() {
    return properties.get(HIVE_OUTPUT_FORMAT_PROPERTY);
  }

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public final SelectHiveQL setHiveOutputFormat(final String hiveOutputFormat) {
    properties.put(HIVE_OUTPUT_FORMAT_PROPERTY, hiveOutputFormat);
    return this;
  }

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public final SelectHiveQL removeHiveOutputFormat() {
    properties.remove(HIVE_OUTPUT_FORMAT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SelectHiveQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SelectHiveQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SelectHiveQL, SelectHiveQL> configurator) {
    return configurator.apply(new SelectHiveQL()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SelectHiveQL.class) final Closure<SelectHiveQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hive.SelectHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.SelectHiveQL.class, com.tibtech.nifi.processors.hive.SelectHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
