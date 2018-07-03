package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ScanHBase {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.ScanHBase";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String SCANHBASE_CLIENT_SERVICE_PROPERTY = "scanhbase-client-service";

  /**
   * The name of the HBase Table to fetch from.
   */
  public static final String SCANHBASE_TABLE_NAME_PROPERTY = "scanhbase-table-name";

  /**
   * The list of authorizations to pass to the scanner. This will be ignored if cell visibility labels are not in use.
   */
  public static final String HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY = "hbase-fetch-row-authorizations";

  /**
   * The rowkey to start scan from.
   */
  public static final String SCANHBASE_START_ROWKEY_PROPERTY = "scanhbase-start-rowkey";

  /**
   * The row key to end scan by.
   */
  public static final String SCANHBASE_END_ROWKEY_PROPERTY = "scanhbase-end-rowkey";

  /**
   * Time range min value. Both min and max values for time range should be either blank or provided.
   */
  public static final String SCANHBASE_TIME_RANGE_MIN_PROPERTY = "scanhbase-time-range-min";

  /**
   * Time range max value. Both min and max values for time range should be either blank or provided.
   */
  public static final String SCANHBASE_TIME_RANGE_MAX_PROPERTY = "scanhbase-time-range-max";

  /**
   * Limit number of rows retrieved by scan.
   */
  public static final String SCANHBASE_LIMIT_PROPERTY = "scanhbase-limit";

  /**
   * Set whether this scan is a reversed one. This is false by default which means forward(normal) scan.
   */
  public static final String SCANHBASE_REVERSED_ORDER_PROPERTY = "scanhbase-reversed-order";

  /**
   * Limits number of rows in single flow file content. Set to 0 to avoid multiple flow files.
   */
  public static final String SCANHBASE_BULK_SIZE_PROPERTY = "scanhbase-bulk-size";

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property. Example: "ValueFilter( =, 'binaryprefix:commit' )"
   */
  public static final String SCANHBASE_FILTER_EXPRESSION_PROPERTY = "scanhbase-filter-expression";

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public static final String SCANHBASE_COLUMNS_PROPERTY = "scanhbase-columns";

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public static final String SCANHBASE_JSON_FORMAT_PROPERTY = "scanhbase-json-format";

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public static final String SCANHBASE_ENCODE_CHARSET_PROPERTY = "scanhbase-encode-charset";

  /**
   * The character set used to decode data from HBase.
   */
  public static final String SCANHBASE_DECODE_CHARSET_PROPERTY = "scanhbase-decode-charset";

  private final Map<String, String> properties;

  public ScanHBase() {
    this.properties = new HashMap<>();
  }

  public ScanHBase(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final String getScanhbaseClientService() {
    return properties.get(SCANHBASE_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final ScanHBase setScanhbaseClientService(final String scanhbaseClientService) {
    properties.put(SCANHBASE_CLIENT_SERVICE_PROPERTY, scanhbaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final ScanHBase removeScanhbaseClientService() {
    properties.remove(SCANHBASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the HBase Table to fetch from.
   */
  public final String getScanhbaseTableName() {
    return properties.get(SCANHBASE_TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the HBase Table to fetch from.
   */
  public final ScanHBase setScanhbaseTableName(final String scanhbaseTableName) {
    properties.put(SCANHBASE_TABLE_NAME_PROPERTY, scanhbaseTableName);
    return this;
  }

  /**
   * The name of the HBase Table to fetch from.
   */
  public final ScanHBase removeScanhbaseTableName() {
    properties.remove(SCANHBASE_TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * The list of authorizations to pass to the scanner. This will be ignored if cell visibility labels are not in use.
   */
  public final String getHbaseFetchRowAuthorizations() {
    return properties.get(HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY);
  }

  /**
   * The list of authorizations to pass to the scanner. This will be ignored if cell visibility labels are not in use.
   */
  public final ScanHBase setHbaseFetchRowAuthorizations(final String hbaseFetchRowAuthorizations) {
    properties.put(HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY, hbaseFetchRowAuthorizations);
    return this;
  }

  /**
   * The list of authorizations to pass to the scanner. This will be ignored if cell visibility labels are not in use.
   */
  public final ScanHBase removeHbaseFetchRowAuthorizations() {
    properties.remove(HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY);
    return this;
  }

  /**
   * The rowkey to start scan from.
   */
  public final String getScanhbaseStartRowkey() {
    return properties.get(SCANHBASE_START_ROWKEY_PROPERTY);
  }

  /**
   * The rowkey to start scan from.
   */
  public final ScanHBase setScanhbaseStartRowkey(final String scanhbaseStartRowkey) {
    properties.put(SCANHBASE_START_ROWKEY_PROPERTY, scanhbaseStartRowkey);
    return this;
  }

  /**
   * The rowkey to start scan from.
   */
  public final ScanHBase removeScanhbaseStartRowkey() {
    properties.remove(SCANHBASE_START_ROWKEY_PROPERTY);
    return this;
  }

  /**
   * The row key to end scan by.
   */
  public final String getScanhbaseEndRowkey() {
    return properties.get(SCANHBASE_END_ROWKEY_PROPERTY);
  }

  /**
   * The row key to end scan by.
   */
  public final ScanHBase setScanhbaseEndRowkey(final String scanhbaseEndRowkey) {
    properties.put(SCANHBASE_END_ROWKEY_PROPERTY, scanhbaseEndRowkey);
    return this;
  }

  /**
   * The row key to end scan by.
   */
  public final ScanHBase removeScanhbaseEndRowkey() {
    properties.remove(SCANHBASE_END_ROWKEY_PROPERTY);
    return this;
  }

  /**
   * Time range min value. Both min and max values for time range should be either blank or provided.
   */
  public final String getScanhbaseTimeRangeMin() {
    return properties.get(SCANHBASE_TIME_RANGE_MIN_PROPERTY);
  }

  /**
   * Time range min value. Both min and max values for time range should be either blank or provided.
   */
  public final ScanHBase setScanhbaseTimeRangeMin(final String scanhbaseTimeRangeMin) {
    properties.put(SCANHBASE_TIME_RANGE_MIN_PROPERTY, scanhbaseTimeRangeMin);
    return this;
  }

  /**
   * Time range min value. Both min and max values for time range should be either blank or provided.
   */
  public final ScanHBase removeScanhbaseTimeRangeMin() {
    properties.remove(SCANHBASE_TIME_RANGE_MIN_PROPERTY);
    return this;
  }

  /**
   * Time range max value. Both min and max values for time range should be either blank or provided.
   */
  public final String getScanhbaseTimeRangeMax() {
    return properties.get(SCANHBASE_TIME_RANGE_MAX_PROPERTY);
  }

  /**
   * Time range max value. Both min and max values for time range should be either blank or provided.
   */
  public final ScanHBase setScanhbaseTimeRangeMax(final String scanhbaseTimeRangeMax) {
    properties.put(SCANHBASE_TIME_RANGE_MAX_PROPERTY, scanhbaseTimeRangeMax);
    return this;
  }

  /**
   * Time range max value. Both min and max values for time range should be either blank or provided.
   */
  public final ScanHBase removeScanhbaseTimeRangeMax() {
    properties.remove(SCANHBASE_TIME_RANGE_MAX_PROPERTY);
    return this;
  }

  /**
   * Limit number of rows retrieved by scan.
   */
  public final String getScanhbaseLimit() {
    return properties.get(SCANHBASE_LIMIT_PROPERTY);
  }

  /**
   * Limit number of rows retrieved by scan.
   */
  public final ScanHBase setScanhbaseLimit(final String scanhbaseLimit) {
    properties.put(SCANHBASE_LIMIT_PROPERTY, scanhbaseLimit);
    return this;
  }

  /**
   * Limit number of rows retrieved by scan.
   */
  public final ScanHBase removeScanhbaseLimit() {
    properties.remove(SCANHBASE_LIMIT_PROPERTY);
    return this;
  }

  /**
   * Set whether this scan is a reversed one. This is false by default which means forward(normal) scan.
   */
  public final String getScanhbaseReversedOrder() {
    return properties.get(SCANHBASE_REVERSED_ORDER_PROPERTY);
  }

  /**
   * Set whether this scan is a reversed one. This is false by default which means forward(normal) scan.
   */
  public final ScanHBase setScanhbaseReversedOrder(final String scanhbaseReversedOrder) {
    properties.put(SCANHBASE_REVERSED_ORDER_PROPERTY, scanhbaseReversedOrder);
    return this;
  }

  /**
   * Set whether this scan is a reversed one. This is false by default which means forward(normal) scan.
   */
  public final ScanHBase removeScanhbaseReversedOrder() {
    properties.remove(SCANHBASE_REVERSED_ORDER_PROPERTY);
    return this;
  }

  /**
   * Limits number of rows in single flow file content. Set to 0 to avoid multiple flow files.
   */
  public final String getScanhbaseBulkSize() {
    return properties.get(SCANHBASE_BULK_SIZE_PROPERTY);
  }

  /**
   * Limits number of rows in single flow file content. Set to 0 to avoid multiple flow files.
   */
  public final ScanHBase setScanhbaseBulkSize(final String scanhbaseBulkSize) {
    properties.put(SCANHBASE_BULK_SIZE_PROPERTY, scanhbaseBulkSize);
    return this;
  }

  /**
   * Limits number of rows in single flow file content. Set to 0 to avoid multiple flow files.
   */
  public final ScanHBase removeScanhbaseBulkSize() {
    properties.remove(SCANHBASE_BULK_SIZE_PROPERTY);
    return this;
  }

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property. Example: "ValueFilter( =, 'binaryprefix:commit' )"
   */
  public final String getScanhbaseFilterExpression() {
    return properties.get(SCANHBASE_FILTER_EXPRESSION_PROPERTY);
  }

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property. Example: "ValueFilter( =, 'binaryprefix:commit' )"
   */
  public final ScanHBase setScanhbaseFilterExpression(final String scanhbaseFilterExpression) {
    properties.put(SCANHBASE_FILTER_EXPRESSION_PROPERTY, scanhbaseFilterExpression);
    return this;
  }

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property. Example: "ValueFilter( =, 'binaryprefix:commit' )"
   */
  public final ScanHBase removeScanhbaseFilterExpression() {
    properties.remove(SCANHBASE_FILTER_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final String getScanhbaseColumns() {
    return properties.get(SCANHBASE_COLUMNS_PROPERTY);
  }

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final ScanHBase setScanhbaseColumns(final String scanhbaseColumns) {
    properties.put(SCANHBASE_COLUMNS_PROPERTY, scanhbaseColumns);
    return this;
  }

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final ScanHBase removeScanhbaseColumns() {
    properties.remove(SCANHBASE_COLUMNS_PROPERTY);
    return this;
  }

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public final String getScanhbaseJsonFormat() {
    return properties.get(SCANHBASE_JSON_FORMAT_PROPERTY);
  }

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public final ScanHBase setScanhbaseJsonFormat(final String scanhbaseJsonFormat) {
    properties.put(SCANHBASE_JSON_FORMAT_PROPERTY, scanhbaseJsonFormat);
    return this;
  }

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public final ScanHBase removeScanhbaseJsonFormat() {
    properties.remove(SCANHBASE_JSON_FORMAT_PROPERTY);
    return this;
  }

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public final String getScanhbaseEncodeCharset() {
    return properties.get(SCANHBASE_ENCODE_CHARSET_PROPERTY);
  }

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public final ScanHBase setScanhbaseEncodeCharset(final String scanhbaseEncodeCharset) {
    properties.put(SCANHBASE_ENCODE_CHARSET_PROPERTY, scanhbaseEncodeCharset);
    return this;
  }

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public final ScanHBase removeScanhbaseEncodeCharset() {
    properties.remove(SCANHBASE_ENCODE_CHARSET_PROPERTY);
    return this;
  }

  /**
   * The character set used to decode data from HBase.
   */
  public final String getScanhbaseDecodeCharset() {
    return properties.get(SCANHBASE_DECODE_CHARSET_PROPERTY);
  }

  /**
   * The character set used to decode data from HBase.
   */
  public final ScanHBase setScanhbaseDecodeCharset(final String scanhbaseDecodeCharset) {
    properties.put(SCANHBASE_DECODE_CHARSET_PROPERTY, scanhbaseDecodeCharset);
    return this;
  }

  /**
   * The character set used to decode data from HBase.
   */
  public final ScanHBase removeScanhbaseDecodeCharset() {
    properties.remove(SCANHBASE_DECODE_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ScanHBase setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ScanHBase removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ScanHBase, ScanHBase> configurator) {
    return configurator.apply(new ScanHBase()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScanHBase.class) final Closure<ScanHBase> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.ScanHBase> code = closure.rehydrate(c, com.tibtech.nifi.hbase.ScanHBase.class, com.tibtech.nifi.hbase.ScanHBase.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ScanHBase, ScanHBase> configurator) {
    return configurator.apply(new ScanHBase(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScanHBase.class) final Closure<ScanHBase> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.ScanHBase> code = closure.rehydrate(c, com.tibtech.nifi.hbase.ScanHBase.class, com.tibtech.nifi.hbase.ScanHBase.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
