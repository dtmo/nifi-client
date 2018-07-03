package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SimpleCsvFileLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.SimpleCsvFileLookupService";

  /**
   * A CSV file.
   */
  public static final String CSV_FILE_PROPERTY = "csv-file";

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public static final String CSV_FORMAT_PROPERTY = "CSV Format";

  /**
   * The Character Encoding that is used to decode the CSV file.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Lookup key column.
   */
  public static final String LOOKUP_KEY_COLUMN_PROPERTY = "lookup-key-column";

  /**
   * Lookup value column.
   */
  public static final String LOOKUP_VALUE_COLUMN_PROPERTY = "lookup-value-column";

  /**
   * Ignore duplicate keys for records in the CSV file.
   */
  public static final String IGNORE_DUPLICATES_PROPERTY = "ignore-duplicates";

  private final Map<String, String> properties;

  public SimpleCsvFileLookupService() {
    this.properties = new HashMap<>();
  }

  public SimpleCsvFileLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A CSV file.
   */
  public final String getCsvFile() {
    return properties.get(CSV_FILE_PROPERTY);
  }

  /**
   * A CSV file.
   */
  public final SimpleCsvFileLookupService setCsvFile(final String csvFile) {
    properties.put(CSV_FILE_PROPERTY, csvFile);
    return this;
  }

  /**
   * A CSV file.
   */
  public final SimpleCsvFileLookupService removeCsvFile() {
    properties.remove(CSV_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final String getCsvFormat() {
    return properties.get(CSV_FORMAT_PROPERTY);
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final SimpleCsvFileLookupService setCsvFormat(final String csvFormat) {
    properties.put(CSV_FORMAT_PROPERTY, csvFormat);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final SimpleCsvFileLookupService removeCsvFormat() {
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
  public final SimpleCsvFileLookupService setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Encoding that is used to decode the CSV file.
   */
  public final SimpleCsvFileLookupService removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Lookup key column.
   */
  public final String getLookupKeyColumn() {
    return properties.get(LOOKUP_KEY_COLUMN_PROPERTY);
  }

  /**
   * Lookup key column.
   */
  public final SimpleCsvFileLookupService setLookupKeyColumn(final String lookupKeyColumn) {
    properties.put(LOOKUP_KEY_COLUMN_PROPERTY, lookupKeyColumn);
    return this;
  }

  /**
   * Lookup key column.
   */
  public final SimpleCsvFileLookupService removeLookupKeyColumn() {
    properties.remove(LOOKUP_KEY_COLUMN_PROPERTY);
    return this;
  }

  /**
   * Lookup value column.
   */
  public final String getLookupValueColumn() {
    return properties.get(LOOKUP_VALUE_COLUMN_PROPERTY);
  }

  /**
   * Lookup value column.
   */
  public final SimpleCsvFileLookupService setLookupValueColumn(final String lookupValueColumn) {
    properties.put(LOOKUP_VALUE_COLUMN_PROPERTY, lookupValueColumn);
    return this;
  }

  /**
   * Lookup value column.
   */
  public final SimpleCsvFileLookupService removeLookupValueColumn() {
    properties.remove(LOOKUP_VALUE_COLUMN_PROPERTY);
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
  public final SimpleCsvFileLookupService setIgnoreDuplicates(final String ignoreDuplicates) {
    properties.put(IGNORE_DUPLICATES_PROPERTY, ignoreDuplicates);
    return this;
  }

  /**
   * Ignore duplicate keys for records in the CSV file.
   */
  public final SimpleCsvFileLookupService removeIgnoreDuplicates() {
    properties.remove(IGNORE_DUPLICATES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SimpleCsvFileLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final SimpleCsvFileLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<SimpleCsvFileLookupService, SimpleCsvFileLookupService> configurator) {
    return configurator.apply(new SimpleCsvFileLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SimpleCsvFileLookupService.class) final Closure<SimpleCsvFileLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.SimpleCsvFileLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.SimpleCsvFileLookupService.class, com.tibtech.nifi.lookup.SimpleCsvFileLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SimpleCsvFileLookupService, SimpleCsvFileLookupService> configurator) {
    return configurator.apply(new SimpleCsvFileLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SimpleCsvFileLookupService.class) final Closure<SimpleCsvFileLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.SimpleCsvFileLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.SimpleCsvFileLookupService.class, com.tibtech.nifi.lookup.SimpleCsvFileLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
