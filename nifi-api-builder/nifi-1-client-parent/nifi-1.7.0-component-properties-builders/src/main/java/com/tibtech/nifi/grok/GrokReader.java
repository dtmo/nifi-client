package com.tibtech.nifi.grok;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GrokReader {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.grok.GrokReader";

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public static final String SCHEMA_ACCESS_STRATEGY_PROPERTY = "schema-access-strategy";

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public static final String SCHEMA_REGISTRY_PROPERTY = "schema-registry";

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public static final String SCHEMA_NAME_PROPERTY = "schema-name";

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public static final String SCHEMA_VERSION_PROPERTY = "schema-version";

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public static final String SCHEMA_BRANCH_PROPERTY = "schema-branch";

  /**
   * The text of an Avro-formatted Schema
   */
  public static final String SCHEMA_TEXT_PROPERTY = "schema-text";

  /**
   * Path to a file that contains Grok Patterns to use for parsing logs. If not specified, a built-in default Pattern file will be used. If specified, all patterns in the given pattern file will override the default patterns. See the Controller Service's Additional Details for a list of pre-defined patterns.
   */
  public static final String GROK_PATTERN_FILE_PROPERTY = "Grok Pattern File";

  /**
   * Specifies the format of a log line in Grok format. This allows the Record Reader to understand how to parse each log line. If a line in the log file does not match this pattern, the line will be assumed to belong to the previous log message.If other Grok expressions are referenced by this expression, they need to be supplied in the Grok Pattern File
   */
  public static final String GROK_EXPRESSION_PROPERTY = "Grok Expression";

  /**
   * If a line of text is encountered and it does not match the given Grok Expression, and it is not part of a stack trace, this property specifies how the text should be processed.
   */
  public static final String NO_MATCH_BEHAVIOR_PROPERTY = "no-match-behavior";

  private final Map<String, String> properties;

  public GrokReader() {
    this.properties = new HashMap<>();
  }

  public GrokReader(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final String getSchemaAccessStrategy() {
    return properties.get(SCHEMA_ACCESS_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final GrokReader setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final GrokReader removeSchemaAccessStrategy() {
    properties.remove(SCHEMA_ACCESS_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final String getSchemaRegistry() {
    return properties.get(SCHEMA_REGISTRY_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final GrokReader setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final GrokReader removeSchemaRegistry() {
    properties.remove(SCHEMA_REGISTRY_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final String getSchemaName() {
    return properties.get(SCHEMA_NAME_PROPERTY);
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final GrokReader setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final GrokReader removeSchemaName() {
    properties.remove(SCHEMA_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final String getSchemaVersion() {
    return properties.get(SCHEMA_VERSION_PROPERTY);
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final GrokReader setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final GrokReader removeSchemaVersion() {
    properties.remove(SCHEMA_VERSION_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final String getSchemaBranch() {
    return properties.get(SCHEMA_BRANCH_PROPERTY);
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final GrokReader setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final GrokReader removeSchemaBranch() {
    properties.remove(SCHEMA_BRANCH_PROPERTY);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final String getSchemaText() {
    return properties.get(SCHEMA_TEXT_PROPERTY);
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final GrokReader setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final GrokReader removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  /**
   * Path to a file that contains Grok Patterns to use for parsing logs. If not specified, a built-in default Pattern file will be used. If specified, all patterns in the given pattern file will override the default patterns. See the Controller Service's Additional Details for a list of pre-defined patterns.
   */
  public final String getGrokPatternFile() {
    return properties.get(GROK_PATTERN_FILE_PROPERTY);
  }

  /**
   * Path to a file that contains Grok Patterns to use for parsing logs. If not specified, a built-in default Pattern file will be used. If specified, all patterns in the given pattern file will override the default patterns. See the Controller Service's Additional Details for a list of pre-defined patterns.
   */
  public final GrokReader setGrokPatternFile(final String grokPatternFile) {
    properties.put(GROK_PATTERN_FILE_PROPERTY, grokPatternFile);
    return this;
  }

  /**
   * Path to a file that contains Grok Patterns to use for parsing logs. If not specified, a built-in default Pattern file will be used. If specified, all patterns in the given pattern file will override the default patterns. See the Controller Service's Additional Details for a list of pre-defined patterns.
   */
  public final GrokReader removeGrokPatternFile() {
    properties.remove(GROK_PATTERN_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies the format of a log line in Grok format. This allows the Record Reader to understand how to parse each log line. If a line in the log file does not match this pattern, the line will be assumed to belong to the previous log message.If other Grok expressions are referenced by this expression, they need to be supplied in the Grok Pattern File
   */
  public final String getGrokExpression() {
    return properties.get(GROK_EXPRESSION_PROPERTY);
  }

  /**
   * Specifies the format of a log line in Grok format. This allows the Record Reader to understand how to parse each log line. If a line in the log file does not match this pattern, the line will be assumed to belong to the previous log message.If other Grok expressions are referenced by this expression, they need to be supplied in the Grok Pattern File
   */
  public final GrokReader setGrokExpression(final String grokExpression) {
    properties.put(GROK_EXPRESSION_PROPERTY, grokExpression);
    return this;
  }

  /**
   * Specifies the format of a log line in Grok format. This allows the Record Reader to understand how to parse each log line. If a line in the log file does not match this pattern, the line will be assumed to belong to the previous log message.If other Grok expressions are referenced by this expression, they need to be supplied in the Grok Pattern File
   */
  public final GrokReader removeGrokExpression() {
    properties.remove(GROK_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * If a line of text is encountered and it does not match the given Grok Expression, and it is not part of a stack trace, this property specifies how the text should be processed.
   */
  public final String getNoMatchBehavior() {
    return properties.get(NO_MATCH_BEHAVIOR_PROPERTY);
  }

  /**
   * If a line of text is encountered and it does not match the given Grok Expression, and it is not part of a stack trace, this property specifies how the text should be processed.
   */
  public final GrokReader setNoMatchBehavior(final String noMatchBehavior) {
    properties.put(NO_MATCH_BEHAVIOR_PROPERTY, noMatchBehavior);
    return this;
  }

  /**
   * If a line of text is encountered and it does not match the given Grok Expression, and it is not part of a stack trace, this property specifies how the text should be processed.
   */
  public final GrokReader removeNoMatchBehavior() {
    properties.remove(NO_MATCH_BEHAVIOR_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GrokReader setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GrokReader removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GrokReader, GrokReader> configurator) {
    return configurator.apply(new GrokReader()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GrokReader.class) final Closure<GrokReader> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.grok.GrokReader> code = closure.rehydrate(c, com.tibtech.nifi.grok.GrokReader.class, com.tibtech.nifi.grok.GrokReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GrokReader, GrokReader> configurator) {
    return configurator.apply(new GrokReader(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GrokReader.class) final Closure<GrokReader> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.grok.GrokReader> code = closure.rehydrate(c, com.tibtech.nifi.grok.GrokReader.class, com.tibtech.nifi.grok.GrokReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
