package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ValidateCsv {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ValidateCsv";

  /**
   * The schema to be used for validation. Is expected a comma-delimited string representing the cell processors to apply. The following cell processors are allowed in the schema definition: [ParseBigDecimal, ParseBool, ParseChar, ParseDate, ParseDouble, ParseInt, ParseLong, Optional, DMinMax, Equals, ForbidSubStr, LMinMax, NotNull, Null, RequireHashCode, RequireSubStr, Strlen, StrMinMax, StrNotNullOrEmpty, StrRegEx, Unique, UniqueHashCode, IsIncludedIn]. Note: cell processors cannot be nested except with Optional.
   */
  public static final String VALIDATE_CSV_SCHEMA_PROPERTY = "validate-csv-schema";

  /**
   * True if the incoming flow file contains a header to ignore, false otherwise.
   */
  public static final String VALIDATE_CSV_HEADER_PROPERTY = "validate-csv-header";

  /**
   * Character used as 'delimiter' in the incoming data. Example: ,
   */
  public static final String VALIDATE_CSV_DELIMITER_PROPERTY = "validate-csv-delimiter";

  /**
   * Character used as 'quote' in the incoming data. Example: "
   */
  public static final String VALIDATE_CSV_QUOTE_PROPERTY = "validate-csv-quote";

  /**
   * Symbols used as 'end of line' in the incoming data. Example: \n
   */
  public static final String VALIDATE_CSV_EOL_PROPERTY = "validate-csv-eol";

  /**
   * Strategy to apply when routing input files to output relationships.
   */
  public static final String VALIDATE_CSV_STRATEGY_PROPERTY = "validate-csv-strategy";

  private final Map<String, String> properties;

  public ValidateCsv() {
    this.properties = new HashMap<>();
  }

  public ValidateCsv(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The schema to be used for validation. Is expected a comma-delimited string representing the cell processors to apply. The following cell processors are allowed in the schema definition: [ParseBigDecimal, ParseBool, ParseChar, ParseDate, ParseDouble, ParseInt, ParseLong, Optional, DMinMax, Equals, ForbidSubStr, LMinMax, NotNull, Null, RequireHashCode, RequireSubStr, Strlen, StrMinMax, StrNotNullOrEmpty, StrRegEx, Unique, UniqueHashCode, IsIncludedIn]. Note: cell processors cannot be nested except with Optional.
   */
  public final String getValidateCsvSchema() {
    return properties.get(VALIDATE_CSV_SCHEMA_PROPERTY);
  }

  /**
   * The schema to be used for validation. Is expected a comma-delimited string representing the cell processors to apply. The following cell processors are allowed in the schema definition: [ParseBigDecimal, ParseBool, ParseChar, ParseDate, ParseDouble, ParseInt, ParseLong, Optional, DMinMax, Equals, ForbidSubStr, LMinMax, NotNull, Null, RequireHashCode, RequireSubStr, Strlen, StrMinMax, StrNotNullOrEmpty, StrRegEx, Unique, UniqueHashCode, IsIncludedIn]. Note: cell processors cannot be nested except with Optional.
   */
  public final ValidateCsv setValidateCsvSchema(final String validateCsvSchema) {
    properties.put(VALIDATE_CSV_SCHEMA_PROPERTY, validateCsvSchema);
    return this;
  }

  /**
   * The schema to be used for validation. Is expected a comma-delimited string representing the cell processors to apply. The following cell processors are allowed in the schema definition: [ParseBigDecimal, ParseBool, ParseChar, ParseDate, ParseDouble, ParseInt, ParseLong, Optional, DMinMax, Equals, ForbidSubStr, LMinMax, NotNull, Null, RequireHashCode, RequireSubStr, Strlen, StrMinMax, StrNotNullOrEmpty, StrRegEx, Unique, UniqueHashCode, IsIncludedIn]. Note: cell processors cannot be nested except with Optional.
   */
  public final ValidateCsv removeValidateCsvSchema() {
    properties.remove(VALIDATE_CSV_SCHEMA_PROPERTY);
    return this;
  }

  /**
   * True if the incoming flow file contains a header to ignore, false otherwise.
   */
  public final String getValidateCsvHeader() {
    return properties.get(VALIDATE_CSV_HEADER_PROPERTY);
  }

  /**
   * True if the incoming flow file contains a header to ignore, false otherwise.
   */
  public final ValidateCsv setValidateCsvHeader(final String validateCsvHeader) {
    properties.put(VALIDATE_CSV_HEADER_PROPERTY, validateCsvHeader);
    return this;
  }

  /**
   * True if the incoming flow file contains a header to ignore, false otherwise.
   */
  public final ValidateCsv removeValidateCsvHeader() {
    properties.remove(VALIDATE_CSV_HEADER_PROPERTY);
    return this;
  }

  /**
   * Character used as 'delimiter' in the incoming data. Example: ,
   */
  public final String getValidateCsvDelimiter() {
    return properties.get(VALIDATE_CSV_DELIMITER_PROPERTY);
  }

  /**
   * Character used as 'delimiter' in the incoming data. Example: ,
   */
  public final ValidateCsv setValidateCsvDelimiter(final String validateCsvDelimiter) {
    properties.put(VALIDATE_CSV_DELIMITER_PROPERTY, validateCsvDelimiter);
    return this;
  }

  /**
   * Character used as 'delimiter' in the incoming data. Example: ,
   */
  public final ValidateCsv removeValidateCsvDelimiter() {
    properties.remove(VALIDATE_CSV_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * Character used as 'quote' in the incoming data. Example: "
   */
  public final String getValidateCsvQuote() {
    return properties.get(VALIDATE_CSV_QUOTE_PROPERTY);
  }

  /**
   * Character used as 'quote' in the incoming data. Example: "
   */
  public final ValidateCsv setValidateCsvQuote(final String validateCsvQuote) {
    properties.put(VALIDATE_CSV_QUOTE_PROPERTY, validateCsvQuote);
    return this;
  }

  /**
   * Character used as 'quote' in the incoming data. Example: "
   */
  public final ValidateCsv removeValidateCsvQuote() {
    properties.remove(VALIDATE_CSV_QUOTE_PROPERTY);
    return this;
  }

  /**
   * Symbols used as 'end of line' in the incoming data. Example: \n
   */
  public final String getValidateCsvEol() {
    return properties.get(VALIDATE_CSV_EOL_PROPERTY);
  }

  /**
   * Symbols used as 'end of line' in the incoming data. Example: \n
   */
  public final ValidateCsv setValidateCsvEol(final String validateCsvEol) {
    properties.put(VALIDATE_CSV_EOL_PROPERTY, validateCsvEol);
    return this;
  }

  /**
   * Symbols used as 'end of line' in the incoming data. Example: \n
   */
  public final ValidateCsv removeValidateCsvEol() {
    properties.remove(VALIDATE_CSV_EOL_PROPERTY);
    return this;
  }

  /**
   * Strategy to apply when routing input files to output relationships.
   */
  public final String getValidateCsvStrategy() {
    return properties.get(VALIDATE_CSV_STRATEGY_PROPERTY);
  }

  /**
   * Strategy to apply when routing input files to output relationships.
   */
  public final ValidateCsv setValidateCsvStrategy(final String validateCsvStrategy) {
    properties.put(VALIDATE_CSV_STRATEGY_PROPERTY, validateCsvStrategy);
    return this;
  }

  /**
   * Strategy to apply when routing input files to output relationships.
   */
  public final ValidateCsv removeValidateCsvStrategy() {
    properties.remove(VALIDATE_CSV_STRATEGY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ValidateCsv setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ValidateCsv removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ValidateCsv, ValidateCsv> configurator) {
    return configurator.apply(new ValidateCsv()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ValidateCsv.class) final Closure<ValidateCsv> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ValidateCsv> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ValidateCsv.class, com.tibtech.nifi.processors.standard.ValidateCsv.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ValidateCsv, ValidateCsv> configurator) {
    return configurator.apply(new ValidateCsv(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ValidateCsv.class) final Closure<ValidateCsv> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ValidateCsv> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ValidateCsv.class, com.tibtech.nifi.processors.standard.ValidateCsv.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
