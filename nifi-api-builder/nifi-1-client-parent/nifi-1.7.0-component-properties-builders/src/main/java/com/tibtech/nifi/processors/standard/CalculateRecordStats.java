package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CalculateRecordStats {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.CalculateRecordStats";

  /**
   * A record reader to use for reading the records.
   */
  public static final String RECORD_STATS_READER_PROPERTY = "record-stats-reader";

  /**
   * Limit the number of individual stats that are returned for each record path to the top N results.
   */
  public static final String RECORD_STATS_LIMIT_PROPERTY = "record-stats-limit";

  private final Map<String, String> properties;

  public CalculateRecordStats() {
    this.properties = new HashMap<>();
  }

  public CalculateRecordStats(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A record reader to use for reading the records.
   */
  public final String getRecordStatsReader() {
    return properties.get(RECORD_STATS_READER_PROPERTY);
  }

  /**
   * A record reader to use for reading the records.
   */
  public final CalculateRecordStats setRecordStatsReader(final String recordStatsReader) {
    properties.put(RECORD_STATS_READER_PROPERTY, recordStatsReader);
    return this;
  }

  /**
   * A record reader to use for reading the records.
   */
  public final CalculateRecordStats removeRecordStatsReader() {
    properties.remove(RECORD_STATS_READER_PROPERTY);
    return this;
  }

  /**
   * Limit the number of individual stats that are returned for each record path to the top N results.
   */
  public final String getRecordStatsLimit() {
    return properties.get(RECORD_STATS_LIMIT_PROPERTY);
  }

  /**
   * Limit the number of individual stats that are returned for each record path to the top N results.
   */
  public final CalculateRecordStats setRecordStatsLimit(final String recordStatsLimit) {
    properties.put(RECORD_STATS_LIMIT_PROPERTY, recordStatsLimit);
    return this;
  }

  /**
   * Limit the number of individual stats that are returned for each record path to the top N results.
   */
  public final CalculateRecordStats removeRecordStatsLimit() {
    properties.remove(RECORD_STATS_LIMIT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CalculateRecordStats setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CalculateRecordStats removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CalculateRecordStats, CalculateRecordStats> configurator) {
    return configurator.apply(new CalculateRecordStats()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CalculateRecordStats.class) final Closure<CalculateRecordStats> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.CalculateRecordStats> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.CalculateRecordStats.class, com.tibtech.nifi.processors.standard.CalculateRecordStats.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CalculateRecordStats, CalculateRecordStats> configurator) {
    return configurator.apply(new CalculateRecordStats(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CalculateRecordStats.class) final Closure<CalculateRecordStats> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.CalculateRecordStats> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.CalculateRecordStats.class, com.tibtech.nifi.processors.standard.CalculateRecordStats.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
