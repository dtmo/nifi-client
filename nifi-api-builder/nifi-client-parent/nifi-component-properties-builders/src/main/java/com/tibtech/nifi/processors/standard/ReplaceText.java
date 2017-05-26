package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ReplaceText {
  /**
   * The Search Value to search for in the FlowFile content. Only used for 'Literal Replace' and 'Regex Replace' matching strategies
   */
  public static final String REGULAR_EXPRESSION_PROPERTY = "Regular Expression";

  /**
   * The value to insert using the 'Replacement Strategy'. Using "Regex Replace" back-references to Regular Expression capturing groups are supported, but back-references that reference capturing groups that do not exist in the regular expression will be treated as literal value. Back References may also be referenced using the Expression Language, as '$1', '$2', etc. The single-tick marks MUST be included, as these variables are not "Standard" attribute names (attribute names must be quoted unless they contain only numbers, letters, and _).
   */
  public static final String REPLACEMENT_VALUE_PROPERTY = "Replacement Value";

  /**
   * The Character Set in which the file is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Specifies the maximum amount of data to buffer (per file or per line, depending on the Evaluation Mode) in order to apply the replacement. If 'Entire Text' (in Evaluation Mode) is selected and the FlowFile is larger than this value, the FlowFile will be routed to 'failure'. In 'Line-by-Line' Mode, if a single line is larger than this value, the FlowFile will be routed to 'failure'. A default value of 1 MB is provided, primarily for 'Entire Text' mode. In 'Line-by-Line' Mode, a value such as 8 KB or 16 KB is suggested. This value is ignored if the <Replacement Strategy> property is set to one of: Append, Prepend, Always Replace
   */
  public static final String MAXIMUM_BUFFER_SIZE_PROPERTY = "Maximum Buffer Size";

  /**
   * The strategy for how and what to replace within the FlowFile's text content.
   */
  public static final String REPLACEMENT_STRATEGY_PROPERTY = "Replacement Strategy";

  /**
   * Run the 'Replacement Strategy' against each line separately (Line-by-Line) or buffer the entire file into memory (Entire Text) and run against that.
   */
  public static final String EVALUATION_MODE_PROPERTY = "Evaluation Mode";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Search Value to search for in the FlowFile content. Only used for 'Literal Replace' and 'Regex Replace' matching strategies
   */
  public final String getRegularExpression() {
    return properties.get(REGULAR_EXPRESSION_PROPERTY);
  }

  /**
   * The Search Value to search for in the FlowFile content. Only used for 'Literal Replace' and 'Regex Replace' matching strategies
   */
  public final ReplaceText setRegularExpression(final String regularExpression) {
    properties.put(REGULAR_EXPRESSION_PROPERTY, regularExpression);
    return this;
  }

  /**
   * The Search Value to search for in the FlowFile content. Only used for 'Literal Replace' and 'Regex Replace' matching strategies
   */
  public final ReplaceText removeRegularExpression() {
    properties.remove(REGULAR_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * The value to insert using the 'Replacement Strategy'. Using "Regex Replace" back-references to Regular Expression capturing groups are supported, but back-references that reference capturing groups that do not exist in the regular expression will be treated as literal value. Back References may also be referenced using the Expression Language, as '$1', '$2', etc. The single-tick marks MUST be included, as these variables are not "Standard" attribute names (attribute names must be quoted unless they contain only numbers, letters, and _).
   */
  public final String getReplacementValue() {
    return properties.get(REPLACEMENT_VALUE_PROPERTY);
  }

  /**
   * The value to insert using the 'Replacement Strategy'. Using "Regex Replace" back-references to Regular Expression capturing groups are supported, but back-references that reference capturing groups that do not exist in the regular expression will be treated as literal value. Back References may also be referenced using the Expression Language, as '$1', '$2', etc. The single-tick marks MUST be included, as these variables are not "Standard" attribute names (attribute names must be quoted unless they contain only numbers, letters, and _).
   */
  public final ReplaceText setReplacementValue(final String replacementValue) {
    properties.put(REPLACEMENT_VALUE_PROPERTY, replacementValue);
    return this;
  }

  /**
   * The value to insert using the 'Replacement Strategy'. Using "Regex Replace" back-references to Regular Expression capturing groups are supported, but back-references that reference capturing groups that do not exist in the regular expression will be treated as literal value. Back References may also be referenced using the Expression Language, as '$1', '$2', etc. The single-tick marks MUST be included, as these variables are not "Standard" attribute names (attribute names must be quoted unless they contain only numbers, letters, and _).
   */
  public final ReplaceText removeReplacementValue() {
    properties.remove(REPLACEMENT_VALUE_PROPERTY);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ReplaceText setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ReplaceText removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file or per line, depending on the Evaluation Mode) in order to apply the replacement. If 'Entire Text' (in Evaluation Mode) is selected and the FlowFile is larger than this value, the FlowFile will be routed to 'failure'. In 'Line-by-Line' Mode, if a single line is larger than this value, the FlowFile will be routed to 'failure'. A default value of 1 MB is provided, primarily for 'Entire Text' mode. In 'Line-by-Line' Mode, a value such as 8 KB or 16 KB is suggested. This value is ignored if the <Replacement Strategy> property is set to one of: Append, Prepend, Always Replace
   */
  public final String getMaximumBufferSize() {
    return properties.get(MAXIMUM_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Specifies the maximum amount of data to buffer (per file or per line, depending on the Evaluation Mode) in order to apply the replacement. If 'Entire Text' (in Evaluation Mode) is selected and the FlowFile is larger than this value, the FlowFile will be routed to 'failure'. In 'Line-by-Line' Mode, if a single line is larger than this value, the FlowFile will be routed to 'failure'. A default value of 1 MB is provided, primarily for 'Entire Text' mode. In 'Line-by-Line' Mode, a value such as 8 KB or 16 KB is suggested. This value is ignored if the <Replacement Strategy> property is set to one of: Append, Prepend, Always Replace
   */
  public final ReplaceText setMaximumBufferSize(final String maximumBufferSize) {
    properties.put(MAXIMUM_BUFFER_SIZE_PROPERTY, maximumBufferSize);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file or per line, depending on the Evaluation Mode) in order to apply the replacement. If 'Entire Text' (in Evaluation Mode) is selected and the FlowFile is larger than this value, the FlowFile will be routed to 'failure'. In 'Line-by-Line' Mode, if a single line is larger than this value, the FlowFile will be routed to 'failure'. A default value of 1 MB is provided, primarily for 'Entire Text' mode. In 'Line-by-Line' Mode, a value such as 8 KB or 16 KB is suggested. This value is ignored if the <Replacement Strategy> property is set to one of: Append, Prepend, Always Replace
   */
  public final ReplaceText removeMaximumBufferSize() {
    properties.remove(MAXIMUM_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * The strategy for how and what to replace within the FlowFile's text content.
   */
  public final String getReplacementStrategy() {
    return properties.get(REPLACEMENT_STRATEGY_PROPERTY);
  }

  /**
   * The strategy for how and what to replace within the FlowFile's text content.
   */
  public final ReplaceText setReplacementStrategy(final String replacementStrategy) {
    properties.put(REPLACEMENT_STRATEGY_PROPERTY, replacementStrategy);
    return this;
  }

  /**
   * The strategy for how and what to replace within the FlowFile's text content.
   */
  public final ReplaceText removeReplacementStrategy() {
    properties.remove(REPLACEMENT_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Run the 'Replacement Strategy' against each line separately (Line-by-Line) or buffer the entire file into memory (Entire Text) and run against that.
   */
  public final String getEvaluationMode() {
    return properties.get(EVALUATION_MODE_PROPERTY);
  }

  /**
   * Run the 'Replacement Strategy' against each line separately (Line-by-Line) or buffer the entire file into memory (Entire Text) and run against that.
   */
  public final ReplaceText setEvaluationMode(final String evaluationMode) {
    properties.put(EVALUATION_MODE_PROPERTY, evaluationMode);
    return this;
  }

  /**
   * Run the 'Replacement Strategy' against each line separately (Line-by-Line) or buffer the entire file into memory (Entire Text) and run against that.
   */
  public final ReplaceText removeEvaluationMode() {
    properties.remove(EVALUATION_MODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ReplaceText setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ReplaceText removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ReplaceText, ReplaceText> configurator) {
    return configurator.apply(new ReplaceText()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReplaceText.class) final Closure<ReplaceText> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ReplaceText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ReplaceText.class, com.tibtech.nifi.processors.standard.ReplaceText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
