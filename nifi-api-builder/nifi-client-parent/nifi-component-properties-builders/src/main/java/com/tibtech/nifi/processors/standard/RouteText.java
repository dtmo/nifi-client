package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RouteText {
  /**
   * Specifies how to determine which Relationship(s) to use when evaluating the lines of incoming text against the 'Matching Strategy' and user-defined properties.
   */
  public static final String ROUTING_STRATEGY_PROPERTY = "Routing Strategy";

  /**
   * Specifies how to evaluate each line of incoming text against the user-defined properties.
   */
  public static final String MATCHING_STRATEGY_PROPERTY = "Matching Strategy";

  /**
   * The Character Set in which the incoming text is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Indicates whether or not the whitespace at the beginning and end of the lines should be ignored when evaluating the line.
   */
  public static final String IGNORE_LEADING_TRAILING_WHITESPACE_PROPERTY = "Ignore Leading/Trailing Whitespace";

  /**
   * If true, capitalization will not be taken into account when comparing values. E.g., matching against 'HELLO' or 'hello' will have the same result. This property is ignored if the 'Matching Strategy' is set to 'Satisfies Expression'.
   */
  public static final String IGNORE_CASE_PROPERTY = "Ignore Case";

  /**
   * Specifies a Regular Expression to evaluate against each line to determine which Group the line should be placed in. The Regular Expression must have at least one Capturing Group that defines the line's Group. If multiple Capturing Groups exist in the Regular Expression, the Group from all Capturing Groups. Two lines will not be placed into the same FlowFile unless the they both have the same value for the Group (or neither line matches the Regular Expression). For example, to group together all lines in a CSV File by the first column, we can set this value to "(.*?),.*". Two lines that have the same Group but different Relationships will never be placed into the same FlowFile.
   */
  public static final String GROUPING_REGULAR_EXPRESSION_PROPERTY = "Grouping Regular Expression";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies how to determine which Relationship(s) to use when evaluating the lines of incoming text against the 'Matching Strategy' and user-defined properties.
   */
  public final String getRoutingStrategy() {
    return properties.get(ROUTING_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to determine which Relationship(s) to use when evaluating the lines of incoming text against the 'Matching Strategy' and user-defined properties.
   */
  public final RouteText setRoutingStrategy(final String routingStrategy) {
    properties.put(ROUTING_STRATEGY_PROPERTY, routingStrategy);
    return this;
  }

  /**
   * Specifies how to determine which Relationship(s) to use when evaluating the lines of incoming text against the 'Matching Strategy' and user-defined properties.
   */
  public final RouteText removeRoutingStrategy() {
    properties.remove(ROUTING_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Specifies how to evaluate each line of incoming text against the user-defined properties.
   */
  public final String getMatchingStrategy() {
    return properties.get(MATCHING_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to evaluate each line of incoming text against the user-defined properties.
   */
  public final RouteText setMatchingStrategy(final String matchingStrategy) {
    properties.put(MATCHING_STRATEGY_PROPERTY, matchingStrategy);
    return this;
  }

  /**
   * Specifies how to evaluate each line of incoming text against the user-defined properties.
   */
  public final RouteText removeMatchingStrategy() {
    properties.remove(MATCHING_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The Character Set in which the incoming text is encoded
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set in which the incoming text is encoded
   */
  public final RouteText setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the incoming text is encoded
   */
  public final RouteText removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not the whitespace at the beginning and end of the lines should be ignored when evaluating the line.
   */
  public final String getIgnoreLeadingTrailingWhitespace() {
    return properties.get(IGNORE_LEADING_TRAILING_WHITESPACE_PROPERTY);
  }

  /**
   * Indicates whether or not the whitespace at the beginning and end of the lines should be ignored when evaluating the line.
   */
  public final RouteText setIgnoreLeadingTrailingWhitespace(final String ignoreLeadingTrailingWhitespace) {
    properties.put(IGNORE_LEADING_TRAILING_WHITESPACE_PROPERTY, ignoreLeadingTrailingWhitespace);
    return this;
  }

  /**
   * Indicates whether or not the whitespace at the beginning and end of the lines should be ignored when evaluating the line.
   */
  public final RouteText removeIgnoreLeadingTrailingWhitespace() {
    properties.remove(IGNORE_LEADING_TRAILING_WHITESPACE_PROPERTY);
    return this;
  }

  /**
   * If true, capitalization will not be taken into account when comparing values. E.g., matching against 'HELLO' or 'hello' will have the same result. This property is ignored if the 'Matching Strategy' is set to 'Satisfies Expression'.
   */
  public final String getIgnoreCase() {
    return properties.get(IGNORE_CASE_PROPERTY);
  }

  /**
   * If true, capitalization will not be taken into account when comparing values. E.g., matching against 'HELLO' or 'hello' will have the same result. This property is ignored if the 'Matching Strategy' is set to 'Satisfies Expression'.
   */
  public final RouteText setIgnoreCase(final String ignoreCase) {
    properties.put(IGNORE_CASE_PROPERTY, ignoreCase);
    return this;
  }

  /**
   * If true, capitalization will not be taken into account when comparing values. E.g., matching against 'HELLO' or 'hello' will have the same result. This property is ignored if the 'Matching Strategy' is set to 'Satisfies Expression'.
   */
  public final RouteText removeIgnoreCase() {
    properties.remove(IGNORE_CASE_PROPERTY);
    return this;
  }

  /**
   * Specifies a Regular Expression to evaluate against each line to determine which Group the line should be placed in. The Regular Expression must have at least one Capturing Group that defines the line's Group. If multiple Capturing Groups exist in the Regular Expression, the Group from all Capturing Groups. Two lines will not be placed into the same FlowFile unless the they both have the same value for the Group (or neither line matches the Regular Expression). For example, to group together all lines in a CSV File by the first column, we can set this value to "(.*?),.*". Two lines that have the same Group but different Relationships will never be placed into the same FlowFile.
   */
  public final String getGroupingRegularExpression() {
    return properties.get(GROUPING_REGULAR_EXPRESSION_PROPERTY);
  }

  /**
   * Specifies a Regular Expression to evaluate against each line to determine which Group the line should be placed in. The Regular Expression must have at least one Capturing Group that defines the line's Group. If multiple Capturing Groups exist in the Regular Expression, the Group from all Capturing Groups. Two lines will not be placed into the same FlowFile unless the they both have the same value for the Group (or neither line matches the Regular Expression). For example, to group together all lines in a CSV File by the first column, we can set this value to "(.*?),.*". Two lines that have the same Group but different Relationships will never be placed into the same FlowFile.
   */
  public final RouteText setGroupingRegularExpression(final String groupingRegularExpression) {
    properties.put(GROUPING_REGULAR_EXPRESSION_PROPERTY, groupingRegularExpression);
    return this;
  }

  /**
   * Specifies a Regular Expression to evaluate against each line to determine which Group the line should be placed in. The Regular Expression must have at least one Capturing Group that defines the line's Group. If multiple Capturing Groups exist in the Regular Expression, the Group from all Capturing Groups. Two lines will not be placed into the same FlowFile unless the they both have the same value for the Group (or neither line matches the Regular Expression). For example, to group together all lines in a CSV File by the first column, we can set this value to "(.*?),.*". Two lines that have the same Group but different Relationships will never be placed into the same FlowFile.
   */
  public final RouteText removeGroupingRegularExpression() {
    properties.remove(GROUPING_REGULAR_EXPRESSION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RouteText setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final RouteText removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<RouteText, RouteText> configurator) {
    return configurator.apply(new RouteText()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RouteText.class) final Closure<RouteText> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.RouteText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.RouteText.class, com.tibtech.nifi.processors.standard.RouteText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
