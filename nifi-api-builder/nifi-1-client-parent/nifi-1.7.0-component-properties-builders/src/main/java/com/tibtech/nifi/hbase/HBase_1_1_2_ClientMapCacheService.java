package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HBase_1_1_2_ClientMapCacheService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.HBase_1_1_2_ClientMapCacheService";

  /**
   * Name of the table on HBase to use for the cache.
   */
  public static final String H_BASE_CACHE_TABLE_NAME_PROPERTY = "HBase Cache Table Name";

  /**
   * The list of authorization tokens to be used with cell visibility if it is enabled. These will be used to override the default authorization list for the user accessing HBase.
   */
  public static final String HB_LU_AUTHORIZATIONS_PROPERTY = "hb-lu-authorizations";

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * Name of the column family on HBase to use for the cache.
   */
  public static final String H_BASE_COLUMN_FAMILY_PROPERTY = "HBase Column Family";

  /**
   * Name of the column qualifier on HBase to use for the cache
   */
  public static final String H_BASE_COLUMN_QUALIFIER_PROPERTY = "HBase Column Qualifier";

  private final Map<String, String> properties;

  public HBase_1_1_2_ClientMapCacheService() {
    this.properties = new HashMap<>();
  }

  public HBase_1_1_2_ClientMapCacheService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Name of the table on HBase to use for the cache.
   */
  public final String getHBaseCacheTableName() {
    return properties.get(H_BASE_CACHE_TABLE_NAME_PROPERTY);
  }

  /**
   * Name of the table on HBase to use for the cache.
   */
  public final HBase_1_1_2_ClientMapCacheService setHBaseCacheTableName(
      final String hBaseCacheTableName) {
    properties.put(H_BASE_CACHE_TABLE_NAME_PROPERTY, hBaseCacheTableName);
    return this;
  }

  /**
   * Name of the table on HBase to use for the cache.
   */
  public final HBase_1_1_2_ClientMapCacheService removeHBaseCacheTableName() {
    properties.remove(H_BASE_CACHE_TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * The list of authorization tokens to be used with cell visibility if it is enabled. These will be used to override the default authorization list for the user accessing HBase.
   */
  public final String getHbLuAuthorizations() {
    return properties.get(HB_LU_AUTHORIZATIONS_PROPERTY);
  }

  /**
   * The list of authorization tokens to be used with cell visibility if it is enabled. These will be used to override the default authorization list for the user accessing HBase.
   */
  public final HBase_1_1_2_ClientMapCacheService setHbLuAuthorizations(
      final String hbLuAuthorizations) {
    properties.put(HB_LU_AUTHORIZATIONS_PROPERTY, hbLuAuthorizations);
    return this;
  }

  /**
   * The list of authorization tokens to be used with cell visibility if it is enabled. These will be used to override the default authorization list for the user accessing HBase.
   */
  public final HBase_1_1_2_ClientMapCacheService removeHbLuAuthorizations() {
    properties.remove(HB_LU_AUTHORIZATIONS_PROPERTY);
    return this;
  }

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public final String getHBaseClientService() {
    return properties.get(H_BASE_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public final HBase_1_1_2_ClientMapCacheService setHBaseClientService(
      final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public final HBase_1_1_2_ClientMapCacheService removeHBaseClientService() {
    properties.remove(H_BASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Name of the column family on HBase to use for the cache.
   */
  public final String getHBaseColumnFamily() {
    return properties.get(H_BASE_COLUMN_FAMILY_PROPERTY);
  }

  /**
   * Name of the column family on HBase to use for the cache.
   */
  public final HBase_1_1_2_ClientMapCacheService setHBaseColumnFamily(
      final String hBaseColumnFamily) {
    properties.put(H_BASE_COLUMN_FAMILY_PROPERTY, hBaseColumnFamily);
    return this;
  }

  /**
   * Name of the column family on HBase to use for the cache.
   */
  public final HBase_1_1_2_ClientMapCacheService removeHBaseColumnFamily() {
    properties.remove(H_BASE_COLUMN_FAMILY_PROPERTY);
    return this;
  }

  /**
   * Name of the column qualifier on HBase to use for the cache
   */
  public final String getHBaseColumnQualifier() {
    return properties.get(H_BASE_COLUMN_QUALIFIER_PROPERTY);
  }

  /**
   * Name of the column qualifier on HBase to use for the cache
   */
  public final HBase_1_1_2_ClientMapCacheService setHBaseColumnQualifier(
      final String hBaseColumnQualifier) {
    properties.put(H_BASE_COLUMN_QUALIFIER_PROPERTY, hBaseColumnQualifier);
    return this;
  }

  /**
   * Name of the column qualifier on HBase to use for the cache
   */
  public final HBase_1_1_2_ClientMapCacheService removeHBaseColumnQualifier() {
    properties.remove(H_BASE_COLUMN_QUALIFIER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HBase_1_1_2_ClientMapCacheService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final HBase_1_1_2_ClientMapCacheService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<HBase_1_1_2_ClientMapCacheService, HBase_1_1_2_ClientMapCacheService> configurator) {
    return configurator.apply(new HBase_1_1_2_ClientMapCacheService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HBase_1_1_2_ClientMapCacheService.class) final Closure<HBase_1_1_2_ClientMapCacheService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.HBase_1_1_2_ClientMapCacheService> code = closure.rehydrate(c, com.tibtech.nifi.hbase.HBase_1_1_2_ClientMapCacheService.class, com.tibtech.nifi.hbase.HBase_1_1_2_ClientMapCacheService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<HBase_1_1_2_ClientMapCacheService, HBase_1_1_2_ClientMapCacheService> configurator) {
    return configurator.apply(new HBase_1_1_2_ClientMapCacheService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HBase_1_1_2_ClientMapCacheService.class) final Closure<HBase_1_1_2_ClientMapCacheService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.HBase_1_1_2_ClientMapCacheService> code = closure.rehydrate(c, com.tibtech.nifi.hbase.HBase_1_1_2_ClientMapCacheService.class, com.tibtech.nifi.hbase.HBase_1_1_2_ClientMapCacheService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
