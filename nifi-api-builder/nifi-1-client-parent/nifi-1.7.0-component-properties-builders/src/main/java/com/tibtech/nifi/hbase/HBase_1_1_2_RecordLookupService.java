package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HBase_1_1_2_RecordLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.HBase_1_1_2_RecordLookupService";

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public static final String HBASE_CLIENT_SERVICE_PROPERTY = "hbase-client-service";

  /**
   * The name of the table where look ups will be run.
   */
  public static final String HB_LU_TABLE_NAME_PROPERTY = "hb-lu-table-name";

  /**
   * The list of authorization tokens to be used with cell visibility if it is enabled. These will be used to override the default authorization list for the user accessing HBase.
   */
  public static final String HB_LU_AUTHORIZATIONS_PROPERTY = "hb-lu-authorizations";

  /**
   * A comma-separated list of \"<colFamily>:<colQualifier>\" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as \"<colFamily1>,<colFamily2>\".
   */
  public static final String HB_LU_RETURN_COLS_PROPERTY = "hb-lu-return-cols";

  /**
   * Specifies the character set used to decode bytes retrieved from HBase.
   */
  public static final String HB_LU_CHARSET_PROPERTY = "hb-lu-charset";

  private final Map<String, String> properties;

  public HBase_1_1_2_RecordLookupService() {
    this.properties = new HashMap<>();
  }

  public HBase_1_1_2_RecordLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public final String getHbaseClientService() {
    return properties.get(HBASE_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public final HBase_1_1_2_RecordLookupService setHbaseClientService(
      final String hbaseClientService) {
    properties.put(HBASE_CLIENT_SERVICE_PROPERTY, hbaseClientService);
    return this;
  }

  /**
   * Specifies the HBase Client Controller Service to use for accessing HBase.
   */
  public final HBase_1_1_2_RecordLookupService removeHbaseClientService() {
    properties.remove(HBASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the table where look ups will be run.
   */
  public final String getHbLuTableName() {
    return properties.get(HB_LU_TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the table where look ups will be run.
   */
  public final HBase_1_1_2_RecordLookupService setHbLuTableName(final String hbLuTableName) {
    properties.put(HB_LU_TABLE_NAME_PROPERTY, hbLuTableName);
    return this;
  }

  /**
   * The name of the table where look ups will be run.
   */
  public final HBase_1_1_2_RecordLookupService removeHbLuTableName() {
    properties.remove(HB_LU_TABLE_NAME_PROPERTY);
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
  public final HBase_1_1_2_RecordLookupService setHbLuAuthorizations(
      final String hbLuAuthorizations) {
    properties.put(HB_LU_AUTHORIZATIONS_PROPERTY, hbLuAuthorizations);
    return this;
  }

  /**
   * The list of authorization tokens to be used with cell visibility if it is enabled. These will be used to override the default authorization list for the user accessing HBase.
   */
  public final HBase_1_1_2_RecordLookupService removeHbLuAuthorizations() {
    properties.remove(HB_LU_AUTHORIZATIONS_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of \"<colFamily>:<colQualifier>\" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as \"<colFamily1>,<colFamily2>\".
   */
  public final String getHbLuReturnCols() {
    return properties.get(HB_LU_RETURN_COLS_PROPERTY);
  }

  /**
   * A comma-separated list of \"<colFamily>:<colQualifier>\" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as \"<colFamily1>,<colFamily2>\".
   */
  public final HBase_1_1_2_RecordLookupService setHbLuReturnCols(final String hbLuReturnCols) {
    properties.put(HB_LU_RETURN_COLS_PROPERTY, hbLuReturnCols);
    return this;
  }

  /**
   * A comma-separated list of \"<colFamily>:<colQualifier>\" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as \"<colFamily1>,<colFamily2>\".
   */
  public final HBase_1_1_2_RecordLookupService removeHbLuReturnCols() {
    properties.remove(HB_LU_RETURN_COLS_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set used to decode bytes retrieved from HBase.
   */
  public final String getHbLuCharset() {
    return properties.get(HB_LU_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set used to decode bytes retrieved from HBase.
   */
  public final HBase_1_1_2_RecordLookupService setHbLuCharset(final String hbLuCharset) {
    properties.put(HB_LU_CHARSET_PROPERTY, hbLuCharset);
    return this;
  }

  /**
   * Specifies the character set used to decode bytes retrieved from HBase.
   */
  public final HBase_1_1_2_RecordLookupService removeHbLuCharset() {
    properties.remove(HB_LU_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HBase_1_1_2_RecordLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final HBase_1_1_2_RecordLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<HBase_1_1_2_RecordLookupService, HBase_1_1_2_RecordLookupService> configurator) {
    return configurator.apply(new HBase_1_1_2_RecordLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HBase_1_1_2_RecordLookupService.class) final Closure<HBase_1_1_2_RecordLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.HBase_1_1_2_RecordLookupService> code = closure.rehydrate(c, com.tibtech.nifi.hbase.HBase_1_1_2_RecordLookupService.class, com.tibtech.nifi.hbase.HBase_1_1_2_RecordLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<HBase_1_1_2_RecordLookupService, HBase_1_1_2_RecordLookupService> configurator) {
    return configurator.apply(new HBase_1_1_2_RecordLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HBase_1_1_2_RecordLookupService.class) final Closure<HBase_1_1_2_RecordLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.HBase_1_1_2_RecordLookupService> code = closure.rehydrate(c, com.tibtech.nifi.hbase.HBase_1_1_2_RecordLookupService.class, com.tibtech.nifi.hbase.HBase_1_1_2_RecordLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
