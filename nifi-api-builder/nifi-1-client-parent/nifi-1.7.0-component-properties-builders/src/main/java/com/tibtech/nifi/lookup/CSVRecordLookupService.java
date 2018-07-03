package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CSVRecordLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.CSVRecordLookupService";

  /**
   * A CSV file that will serve as the data source.
   */
  public static final String CSV_FILE_PROPERTY = "csv-file";

  /**
   * Specifies which "format" the CSV data is in.
   */
  public static final String CSV_FORMAT_PROPERTY = "csv-format";

  /**
   * The Character Encoding that is used to decode the CSV file.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * The field in the CSV file that will serve as the lookup key. This is the field that will be matched against the property specified in the lookup processor.
   */
  public static final String LOOKUP_KEY_COLUMN_PROPERTY = "lookup-key-column";

  /**
   * Ignore duplicate keys for records in the CSV file.
   */
  public static final String IGNORE_DUPLICATES_PROPERTY = "ignore-duplicates";

  private final Map<String, String> properties;

  public CSVRecordLookupService() {
    this.properties = new HashMap<>();
  }

  public CSVRecordLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A CSV file that will serve as the data source.
   */
  public final String getCsvFile() {
    return properties.get(CSV_FILE_PROPERTY);
  }

  /**
   * A CSV file that will serve as the data source.
   */
  public final CSVRecordLookupService setCsvFile(final String csvFile) {
    properties.put(CSV_FILE_PROPERTY, csvFile);
    return this;
  }

  /**
   * A CSV file that will serve as the data source.
   */
  public final CSVRecordLookupService removeCsvFile() {
    properties.remove(CSV_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in.
   */
  public final String getCsvFormat() {
    return properties.get(CSV_FORMAT_PROPERTY);
  }

  /**
   * Specifies which "format" the CSV data is in.
   */
  public final CSVRecordLookupService setCsvFormat(final String csvFormat) {
    properties.put(CSV_FORMAT_PROPERTY, csvFormat);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in.
   */
  public final CSVRecordLookupService removeCsvFormat() {
    properties.remove(CSV_FORMAT_PROPERTY);
    return this;
  }

  /**
   * The Character Encoding that is used to decode the CSV file.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Encoding that is used to decode the CSV file.
   */
  public final CSVRecordLookupService setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Encoding that is used to decode the CSV file.
   */
  public final CSVRecordLookupService removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The field in the CSV file that will serve as the lookup key. This is the field that will be matched against the property specified in the lookup processor.
   */
  public final String getLookupKeyColumn() {
    return properties.get(LOOKUP_KEY_COLUMN_PROPERTY);
  }

  /**
   * The field in the CSV file that will serve as the lookup key. This is the field that will be matched against the property specified in the lookup processor.
   */
  public final CSVRecordLookupService setLookupKeyColumn(final String lookupKeyColumn) {
    properties.put(LOOKUP_KEY_COLUMN_PROPERTY, lookupKeyColumn);
    return this;
  }

  /**
   * The field in the CSV file that will serve as the lookup key. This is the field that will be matched against the property specified in the lookup processor.
   */
  public final CSVRecordLookupService removeLookupKeyColumn() {
    properties.remove(LOOKUP_KEY_COLUMN_PROPERTY);
    return this;
  }

  /**
   * Ignore duplicate keys for records in the CSV file.
   */
  public final String getIgnoreDuplicates() {
    return properties.get(IGNORE_DUPLICATES_PROPERTY);
  }

  /**
   * Ignore duplicate keys for records in the CSV file.
   */
  public final CSVRecordLookupService setIgnoreDuplicates(final String ignoreDuplicates) {
    properties.put(IGNORE_DUPLICATES_PROPERTY, ignoreDuplicates);
    return this;
  }

  /**
   * Ignore duplicate keys for records in the CSV file.
   */
  public final CSVRecordLookupService removeIgnoreDuplicates() {
    properties.remove(IGNORE_DUPLICATES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CSVRecordLookupService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CSVRecordLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CSVRecordLookupService, CSVRecordLookupService> configurator) {
    return configurator.apply(new CSVRecordLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CSVRecordLookupService.class) final Closure<CSVRecordLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.CSVRecordLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.CSVRecordLookupService.class, com.tibtech.nifi.lookup.CSVRecordLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CSVRecordLookupService, CSVRecordLookupService> configurator) {
    return configurator.apply(new CSVRecordLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CSVRecordLookupService.class) final Closure<CSVRecordLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.CSVRecordLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.CSVRecordLookupService.class, com.tibtech.nifi.lookup.CSVRecordLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
