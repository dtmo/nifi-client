package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchHBaseRow {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.FetchHBaseRow";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * The name of the HBase Table to fetch from.
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * The identifier of the row to fetch.
   */
  public static final String ROW_IDENTIFIER_PROPERTY = "Row Identifier";

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public static final String COLUMNS_PROPERTY = "Columns";

  /**
   * The list of authorizations to pass to the scanner. This will be ignored if cell visibility labels are not in use.
   */
  public static final String HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY = "hbase-fetch-row-authorizations";

  /**
   * Indicates whether the row fetched from HBase is written to FlowFile content or FlowFile Attributes.
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public static final String JSON_FORMAT_PROPERTY = "JSON Format";

  /**
   * Specifies how to represent row ids, column families, column qualifiers, and values when stored in FlowFile attributes, or written to JSON.
   */
  public static final String JSON_VALUE_ENCODING_PROPERTY = "JSON Value Encoding";

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public static final String ENCODE_CHARACTER_SET_PROPERTY = "Encode Character Set";

  /**
   * The character set used to decode data from HBase.
   */
  public static final String DECODE_CHARACTER_SET_PROPERTY = "Decode Character Set";

  private final Map<String, String> properties;

  public FetchHBaseRow() {
    this.properties = new HashMap<>();
  }

  public FetchHBaseRow(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final String getHBaseClientService() {
    return properties.get(H_BASE_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final FetchHBaseRow setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final FetchHBaseRow removeHBaseClientService() {
    properties.remove(H_BASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the HBase Table to fetch from.
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the HBase Table to fetch from.
   */
  public final FetchHBaseRow setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table to fetch from.
   */
  public final FetchHBaseRow removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * The identifier of the row to fetch.
   */
  public final String getRowIdentifier() {
    return properties.get(ROW_IDENTIFIER_PROPERTY);
  }

  /**
   * The identifier of the row to fetch.
   */
  public final FetchHBaseRow setRowIdentifier(final String rowIdentifier) {
    properties.put(ROW_IDENTIFIER_PROPERTY, rowIdentifier);
    return this;
  }

  /**
   * The identifier of the row to fetch.
   */
  public final FetchHBaseRow removeRowIdentifier() {
    properties.remove(ROW_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final String getColumns() {
    return properties.get(COLUMNS_PROPERTY);
  }

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final FetchHBaseRow setColumns(final String columns) {
    properties.put(COLUMNS_PROPERTY, columns);
    return this;
  }

  /**
   * An optional comma-separated list of "<colFamily>:<colQualifier>" pairs to fetch. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final FetchHBaseRow removeColumns() {
    properties.remove(COLUMNS_PROPERTY);
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
  public final FetchHBaseRow setHbaseFetchRowAuthorizations(
      final String hbaseFetchRowAuthorizations) {
    properties.put(HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY, hbaseFetchRowAuthorizations);
    return this;
  }

  /**
   * The list of authorizations to pass to the scanner. This will be ignored if cell visibility labels are not in use.
   */
  public final FetchHBaseRow removeHbaseFetchRowAuthorizations() {
    properties.remove(HBASE_FETCH_ROW_AUTHORIZATIONS_PROPERTY);
    return this;
  }

  /**
   * Indicates whether the row fetched from HBase is written to FlowFile content or FlowFile Attributes.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Indicates whether the row fetched from HBase is written to FlowFile content or FlowFile Attributes.
   */
  public final FetchHBaseRow setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Indicates whether the row fetched from HBase is written to FlowFile content or FlowFile Attributes.
   */
  public final FetchHBaseRow removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public final String getJsonFormat() {
    return properties.get(JSON_FORMAT_PROPERTY);
  }

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public final FetchHBaseRow setJsonFormat(final String jsonFormat) {
    properties.put(JSON_FORMAT_PROPERTY, jsonFormat);
    return this;
  }

  /**
   * Specifies how to represent the HBase row as a JSON document.
   */
  public final FetchHBaseRow removeJsonFormat() {
    properties.remove(JSON_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Specifies how to represent row ids, column families, column qualifiers, and values when stored in FlowFile attributes, or written to JSON.
   */
  public final String getJsonValueEncoding() {
    return properties.get(JSON_VALUE_ENCODING_PROPERTY);
  }

  /**
   * Specifies how to represent row ids, column families, column qualifiers, and values when stored in FlowFile attributes, or written to JSON.
   */
  public final FetchHBaseRow setJsonValueEncoding(final String jsonValueEncoding) {
    properties.put(JSON_VALUE_ENCODING_PROPERTY, jsonValueEncoding);
    return this;
  }

  /**
   * Specifies how to represent row ids, column families, column qualifiers, and values when stored in FlowFile attributes, or written to JSON.
   */
  public final FetchHBaseRow removeJsonValueEncoding() {
    properties.remove(JSON_VALUE_ENCODING_PROPERTY);
    return this;
  }

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public final String getEncodeCharacterSet() {
    return properties.get(ENCODE_CHARACTER_SET_PROPERTY);
  }

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public final FetchHBaseRow setEncodeCharacterSet(final String encodeCharacterSet) {
    properties.put(ENCODE_CHARACTER_SET_PROPERTY, encodeCharacterSet);
    return this;
  }

  /**
   * The character set used to encode the JSON representation of the row.
   */
  public final FetchHBaseRow removeEncodeCharacterSet() {
    properties.remove(ENCODE_CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The character set used to decode data from HBase.
   */
  public final String getDecodeCharacterSet() {
    return properties.get(DECODE_CHARACTER_SET_PROPERTY);
  }

  /**
   * The character set used to decode data from HBase.
   */
  public final FetchHBaseRow setDecodeCharacterSet(final String decodeCharacterSet) {
    properties.put(DECODE_CHARACTER_SET_PROPERTY, decodeCharacterSet);
    return this;
  }

  /**
   * The character set used to decode data from HBase.
   */
  public final FetchHBaseRow removeDecodeCharacterSet() {
    properties.remove(DECODE_CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchHBaseRow setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchHBaseRow removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FetchHBaseRow, FetchHBaseRow> configurator) {
    return configurator.apply(new FetchHBaseRow()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchHBaseRow.class) final Closure<FetchHBaseRow> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.FetchHBaseRow> code = closure.rehydrate(c, com.tibtech.nifi.hbase.FetchHBaseRow.class, com.tibtech.nifi.hbase.FetchHBaseRow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchHBaseRow, FetchHBaseRow> configurator) {
    return configurator.apply(new FetchHBaseRow(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchHBaseRow.class) final Closure<FetchHBaseRow> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.FetchHBaseRow> code = closure.rehydrate(c, com.tibtech.nifi.hbase.FetchHBaseRow.class, com.tibtech.nifi.hbase.FetchHBaseRow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
