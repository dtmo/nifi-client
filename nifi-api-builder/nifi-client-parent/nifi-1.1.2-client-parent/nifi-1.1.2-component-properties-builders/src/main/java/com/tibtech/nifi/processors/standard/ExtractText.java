package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractText {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ExtractText";

  /**
   * The Character Set in which the file is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions.  Files larger than the specified maximum will not be fully evaluated.
   */
  public static final String MAXIMUM_BUFFER_SIZE_PROPERTY = "Maximum Buffer Size";

  /**
   * Specifies the maximum number of characters a given capture group value can have.  Any characters beyond the max will be truncated.
   */
  public static final String MAXIMUM_CAPTURE_GROUP_LENGTH_PROPERTY = "Maximum Capture Group Length";

  /**
   * Indicates that two characters match only when their full canonical decompositions match.
   */
  public static final String ENABLE_CANONICAL_EQUIVALENCE_PROPERTY = "Enable Canonical Equivalence";

  /**
   * Indicates that two characters match even if they are in a different case.  Can also be specified via the embedded flag (?i).
   */
  public static final String ENABLE_CASE_INSENSITIVE_MATCHING_PROPERTY = "Enable Case-insensitive Matching";

  /**
   * In this mode, whitespace is ignored, and embedded comments starting with # are ignored until the end of a line.  Can also be specified via the embedded flag (?x).
   */
  public static final String PERMIT_WHITESPACE_AND_COMMENTS_IN_PATTERN_PROPERTY = "Permit Whitespace and Comments in Pattern";

  /**
   * Indicates that the expression '.' should match any character, including a line terminator.  Can also be specified via the embedded flag (?s).
   */
  public static final String ENABLE_DOTALL_MODE_PROPERTY = "Enable DOTALL Mode";

  /**
   * Indicates that Metacharacters and escape characters should be given no special meaning.
   */
  public static final String ENABLE_LITERAL_PARSING_OF_THE_PATTERN_PROPERTY = "Enable Literal Parsing of the Pattern";

  /**
   * Indicates that '^' and '$' should match just after and just before a line terminator or end of sequence, instead of only the beginning or end of the entire input.  Can also be specified via the embeded flag (?m).
   */
  public static final String ENABLE_MULTILINE_MODE_PROPERTY = "Enable Multiline Mode";

  /**
   * When used with 'Enable Case-insensitive Matching', matches in a manner consistent with the Unicode Standard.  Can also be specified via the embedded flag (?u).
   */
  public static final String ENABLE_UNICODE_AWARE_CASE_FOLDING_PROPERTY = "Enable Unicode-aware Case Folding";

  /**
   * Specifies conformance with the Unicode Technical Standard #18: Unicode Regular Expression Annex C: Compatibility Properties.  Can also be specified via the embedded flag (?U).
   */
  public static final String ENABLE_UNICODE_PREDEFINED_CHARACTER_CLASSES_PROPERTY = "Enable Unicode Predefined Character Classes";

  /**
   * Indicates that only the '
   * ' line terminator is recognized in the behavior of '.', '^', and '$'.  Can also be specified via the embedded flag (?d).
   */
  public static final String ENABLE_UNIX_LINES_MODE_PROPERTY = "Enable Unix Lines Mode";

  /**
   * Indicates that Capture Group 0 should be included as an attribute. Capture Group 0 represents the entirety of the regular expression match, is typically not used, and could have considerable length.
   */
  public static final String INCLUDE_CAPTURE_GROUP_0_PROPERTY = "Include Capture Group 0";

  /**
   * If set to true, every string matching the capture groups will be extracted. Otherwise, if the Regular Expression matches more than once, only the first match will be extracted.
   */
  public static final String EXTRACT_TEXT_ENABLE_REPEATING_CAPTURE_GROUP_PROPERTY = "extract-text-enable-repeating-capture-group";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Character Set in which the file is encoded
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ExtractText setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ExtractText removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions.  Files larger than the specified maximum will not be fully evaluated.
   */
  public final String getMaximumBufferSize() {
    return properties.get(MAXIMUM_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions.  Files larger than the specified maximum will not be fully evaluated.
   */
  public final ExtractText setMaximumBufferSize(final String maximumBufferSize) {
    properties.put(MAXIMUM_BUFFER_SIZE_PROPERTY, maximumBufferSize);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions.  Files larger than the specified maximum will not be fully evaluated.
   */
  public final ExtractText removeMaximumBufferSize() {
    properties.remove(MAXIMUM_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum number of characters a given capture group value can have.  Any characters beyond the max will be truncated.
   */
  public final String getMaximumCaptureGroupLength() {
    return properties.get(MAXIMUM_CAPTURE_GROUP_LENGTH_PROPERTY);
  }

  /**
   * Specifies the maximum number of characters a given capture group value can have.  Any characters beyond the max will be truncated.
   */
  public final ExtractText setMaximumCaptureGroupLength(final String maximumCaptureGroupLength) {
    properties.put(MAXIMUM_CAPTURE_GROUP_LENGTH_PROPERTY, maximumCaptureGroupLength);
    return this;
  }

  /**
   * Specifies the maximum number of characters a given capture group value can have.  Any characters beyond the max will be truncated.
   */
  public final ExtractText removeMaximumCaptureGroupLength() {
    properties.remove(MAXIMUM_CAPTURE_GROUP_LENGTH_PROPERTY);
    return this;
  }

  /**
   * Indicates that two characters match only when their full canonical decompositions match.
   */
  public final String getEnableCanonicalEquivalence() {
    return properties.get(ENABLE_CANONICAL_EQUIVALENCE_PROPERTY);
  }

  /**
   * Indicates that two characters match only when their full canonical decompositions match.
   */
  public final ExtractText setEnableCanonicalEquivalence(final String enableCanonicalEquivalence) {
    properties.put(ENABLE_CANONICAL_EQUIVALENCE_PROPERTY, enableCanonicalEquivalence);
    return this;
  }

  /**
   * Indicates that two characters match only when their full canonical decompositions match.
   */
  public final ExtractText removeEnableCanonicalEquivalence() {
    properties.remove(ENABLE_CANONICAL_EQUIVALENCE_PROPERTY);
    return this;
  }

  /**
   * Indicates that two characters match even if they are in a different case.  Can also be specified via the embedded flag (?i).
   */
  public final String getEnableCaseInsensitiveMatching() {
    return properties.get(ENABLE_CASE_INSENSITIVE_MATCHING_PROPERTY);
  }

  /**
   * Indicates that two characters match even if they are in a different case.  Can also be specified via the embedded flag (?i).
   */
  public final ExtractText setEnableCaseInsensitiveMatching(final String enableCaseInsensitiveMatching) {
    properties.put(ENABLE_CASE_INSENSITIVE_MATCHING_PROPERTY, enableCaseInsensitiveMatching);
    return this;
  }

  /**
   * Indicates that two characters match even if they are in a different case.  Can also be specified via the embedded flag (?i).
   */
  public final ExtractText removeEnableCaseInsensitiveMatching() {
    properties.remove(ENABLE_CASE_INSENSITIVE_MATCHING_PROPERTY);
    return this;
  }

  /**
   * In this mode, whitespace is ignored, and embedded comments starting with # are ignored until the end of a line.  Can also be specified via the embedded flag (?x).
   */
  public final String getPermitWhitespaceAndCommentsInPattern() {
    return properties.get(PERMIT_WHITESPACE_AND_COMMENTS_IN_PATTERN_PROPERTY);
  }

  /**
   * In this mode, whitespace is ignored, and embedded comments starting with # are ignored until the end of a line.  Can also be specified via the embedded flag (?x).
   */
  public final ExtractText setPermitWhitespaceAndCommentsInPattern(final String permitWhitespaceAndCommentsInPattern) {
    properties.put(PERMIT_WHITESPACE_AND_COMMENTS_IN_PATTERN_PROPERTY, permitWhitespaceAndCommentsInPattern);
    return this;
  }

  /**
   * In this mode, whitespace is ignored, and embedded comments starting with # are ignored until the end of a line.  Can also be specified via the embedded flag (?x).
   */
  public final ExtractText removePermitWhitespaceAndCommentsInPattern() {
    properties.remove(PERMIT_WHITESPACE_AND_COMMENTS_IN_PATTERN_PROPERTY);
    return this;
  }

  /**
   * Indicates that the expression '.' should match any character, including a line terminator.  Can also be specified via the embedded flag (?s).
   */
  public final String getEnableDotallMode() {
    return properties.get(ENABLE_DOTALL_MODE_PROPERTY);
  }

  /**
   * Indicates that the expression '.' should match any character, including a line terminator.  Can also be specified via the embedded flag (?s).
   */
  public final ExtractText setEnableDotallMode(final String enableDotallMode) {
    properties.put(ENABLE_DOTALL_MODE_PROPERTY, enableDotallMode);
    return this;
  }

  /**
   * Indicates that the expression '.' should match any character, including a line terminator.  Can also be specified via the embedded flag (?s).
   */
  public final ExtractText removeEnableDotallMode() {
    properties.remove(ENABLE_DOTALL_MODE_PROPERTY);
    return this;
  }

  /**
   * Indicates that Metacharacters and escape characters should be given no special meaning.
   */
  public final String getEnableLiteralParsingOfThePattern() {
    return properties.get(ENABLE_LITERAL_PARSING_OF_THE_PATTERN_PROPERTY);
  }

  /**
   * Indicates that Metacharacters and escape characters should be given no special meaning.
   */
  public final ExtractText setEnableLiteralParsingOfThePattern(final String enableLiteralParsingOfThePattern) {
    properties.put(ENABLE_LITERAL_PARSING_OF_THE_PATTERN_PROPERTY, enableLiteralParsingOfThePattern);
    return this;
  }

  /**
   * Indicates that Metacharacters and escape characters should be given no special meaning.
   */
  public final ExtractText removeEnableLiteralParsingOfThePattern() {
    properties.remove(ENABLE_LITERAL_PARSING_OF_THE_PATTERN_PROPERTY);
    return this;
  }

  /**
   * Indicates that '^' and '$' should match just after and just before a line terminator or end of sequence, instead of only the beginning or end of the entire input.  Can also be specified via the embeded flag (?m).
   */
  public final String getEnableMultilineMode() {
    return properties.get(ENABLE_MULTILINE_MODE_PROPERTY);
  }

  /**
   * Indicates that '^' and '$' should match just after and just before a line terminator or end of sequence, instead of only the beginning or end of the entire input.  Can also be specified via the embeded flag (?m).
   */
  public final ExtractText setEnableMultilineMode(final String enableMultilineMode) {
    properties.put(ENABLE_MULTILINE_MODE_PROPERTY, enableMultilineMode);
    return this;
  }

  /**
   * Indicates that '^' and '$' should match just after and just before a line terminator or end of sequence, instead of only the beginning or end of the entire input.  Can also be specified via the embeded flag (?m).
   */
  public final ExtractText removeEnableMultilineMode() {
    properties.remove(ENABLE_MULTILINE_MODE_PROPERTY);
    return this;
  }

  /**
   * When used with 'Enable Case-insensitive Matching', matches in a manner consistent with the Unicode Standard.  Can also be specified via the embedded flag (?u).
   */
  public final String getEnableUnicodeAwareCaseFolding() {
    return properties.get(ENABLE_UNICODE_AWARE_CASE_FOLDING_PROPERTY);
  }

  /**
   * When used with 'Enable Case-insensitive Matching', matches in a manner consistent with the Unicode Standard.  Can also be specified via the embedded flag (?u).
   */
  public final ExtractText setEnableUnicodeAwareCaseFolding(final String enableUnicodeAwareCaseFolding) {
    properties.put(ENABLE_UNICODE_AWARE_CASE_FOLDING_PROPERTY, enableUnicodeAwareCaseFolding);
    return this;
  }

  /**
   * When used with 'Enable Case-insensitive Matching', matches in a manner consistent with the Unicode Standard.  Can also be specified via the embedded flag (?u).
   */
  public final ExtractText removeEnableUnicodeAwareCaseFolding() {
    properties.remove(ENABLE_UNICODE_AWARE_CASE_FOLDING_PROPERTY);
    return this;
  }

  /**
   * Specifies conformance with the Unicode Technical Standard #18: Unicode Regular Expression Annex C: Compatibility Properties.  Can also be specified via the embedded flag (?U).
   */
  public final String getEnableUnicodePredefinedCharacterClasses() {
    return properties.get(ENABLE_UNICODE_PREDEFINED_CHARACTER_CLASSES_PROPERTY);
  }

  /**
   * Specifies conformance with the Unicode Technical Standard #18: Unicode Regular Expression Annex C: Compatibility Properties.  Can also be specified via the embedded flag (?U).
   */
  public final ExtractText setEnableUnicodePredefinedCharacterClasses(final String enableUnicodePredefinedCharacterClasses) {
    properties.put(ENABLE_UNICODE_PREDEFINED_CHARACTER_CLASSES_PROPERTY, enableUnicodePredefinedCharacterClasses);
    return this;
  }

  /**
   * Specifies conformance with the Unicode Technical Standard #18: Unicode Regular Expression Annex C: Compatibility Properties.  Can also be specified via the embedded flag (?U).
   */
  public final ExtractText removeEnableUnicodePredefinedCharacterClasses() {
    properties.remove(ENABLE_UNICODE_PREDEFINED_CHARACTER_CLASSES_PROPERTY);
    return this;
  }

  /**
   * Indicates that only the '
   * ' line terminator is recognized in the behavior of '.', '^', and '$'.  Can also be specified via the embedded flag (?d).
   */
  public final String getEnableUnixLinesMode() {
    return properties.get(ENABLE_UNIX_LINES_MODE_PROPERTY);
  }

  /**
   * Indicates that only the '
   * ' line terminator is recognized in the behavior of '.', '^', and '$'.  Can also be specified via the embedded flag (?d).
   */
  public final ExtractText setEnableUnixLinesMode(final String enableUnixLinesMode) {
    properties.put(ENABLE_UNIX_LINES_MODE_PROPERTY, enableUnixLinesMode);
    return this;
  }

  /**
   * Indicates that only the '
   * ' line terminator is recognized in the behavior of '.', '^', and '$'.  Can also be specified via the embedded flag (?d).
   */
  public final ExtractText removeEnableUnixLinesMode() {
    properties.remove(ENABLE_UNIX_LINES_MODE_PROPERTY);
    return this;
  }

  /**
   * Indicates that Capture Group 0 should be included as an attribute. Capture Group 0 represents the entirety of the regular expression match, is typically not used, and could have considerable length.
   */
  public final String getIncludeCaptureGroup0() {
    return properties.get(INCLUDE_CAPTURE_GROUP_0_PROPERTY);
  }

  /**
   * Indicates that Capture Group 0 should be included as an attribute. Capture Group 0 represents the entirety of the regular expression match, is typically not used, and could have considerable length.
   */
  public final ExtractText setIncludeCaptureGroup0(final String includeCaptureGroup0) {
    properties.put(INCLUDE_CAPTURE_GROUP_0_PROPERTY, includeCaptureGroup0);
    return this;
  }

  /**
   * Indicates that Capture Group 0 should be included as an attribute. Capture Group 0 represents the entirety of the regular expression match, is typically not used, and could have considerable length.
   */
  public final ExtractText removeIncludeCaptureGroup0() {
    properties.remove(INCLUDE_CAPTURE_GROUP_0_PROPERTY);
    return this;
  }

  /**
   * If set to true, every string matching the capture groups will be extracted. Otherwise, if the Regular Expression matches more than once, only the first match will be extracted.
   */
  public final String getExtractTextEnableRepeatingCaptureGroup() {
    return properties.get(EXTRACT_TEXT_ENABLE_REPEATING_CAPTURE_GROUP_PROPERTY);
  }

  /**
   * If set to true, every string matching the capture groups will be extracted. Otherwise, if the Regular Expression matches more than once, only the first match will be extracted.
   */
  public final ExtractText setExtractTextEnableRepeatingCaptureGroup(final String extractTextEnableRepeatingCaptureGroup) {
    properties.put(EXTRACT_TEXT_ENABLE_REPEATING_CAPTURE_GROUP_PROPERTY, extractTextEnableRepeatingCaptureGroup);
    return this;
  }

  /**
   * If set to true, every string matching the capture groups will be extracted. Otherwise, if the Regular Expression matches more than once, only the first match will be extracted.
   */
  public final ExtractText removeExtractTextEnableRepeatingCaptureGroup() {
    properties.remove(EXTRACT_TEXT_ENABLE_REPEATING_CAPTURE_GROUP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractText setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractText removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ExtractText, ExtractText> configurator) {
    return configurator.apply(new ExtractText()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractText.class) final Closure<ExtractText> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExtractText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExtractText.class, com.tibtech.nifi.processors.standard.ExtractText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
