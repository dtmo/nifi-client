package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ScanAttribute {
  /**
   * A new-line-delimited text file that includes the terms that should trigger a match. Empty lines are ignored.
   */
  public static final String DICTIONARY_FILE_PROPERTY = "Dictionary File";

  /**
   * Regular Expression that specifies the names of attributes whose values will be matched against the terms in the dictionary
   */
  public static final String ATTRIBUTE_PATTERN_PROPERTY = "Attribute Pattern";

  /**
   * If set to All Must Match, then FlowFiles will be routed to 'matched' only if all specified attributes' values are found in the dictionary. If set to At Least 1 Must Match, FlowFiles will be routed to 'matched' if any attribute specified is found in the dictionary
   */
  public static final String MATCH_CRITERIA_PROPERTY = "Match Criteria";

  /**
   * A Regular Expression that will be applied to each line in the dictionary file. If the regular expression does not match the line, the line will not be included in the list of terms to search for. If a Matching Group is specified, only the portion of the term that matches that Matching Group will be used instead of the entire term. If not specified, all terms in the dictionary will be used and each term will consist of the text of the entire line in the file
   */
  public static final String DICTIONARY_FILTER_PATTERN_PROPERTY = "Dictionary Filter Pattern";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A new-line-delimited text file that includes the terms that should trigger a match. Empty lines are ignored.
   */
  public final String getDictionaryFile() {
    return properties.get(DICTIONARY_FILE_PROPERTY);
  }

  /**
   * A new-line-delimited text file that includes the terms that should trigger a match. Empty lines are ignored.
   */
  public final ScanAttribute setDictionaryFile(final String dictionaryFile) {
    properties.put(DICTIONARY_FILE_PROPERTY, dictionaryFile);
    return this;
  }

  /**
   * A new-line-delimited text file that includes the terms that should trigger a match. Empty lines are ignored.
   */
  public final ScanAttribute removeDictionaryFile() {
    properties.remove(DICTIONARY_FILE_PROPERTY);
    return this;
  }

  /**
   * Regular Expression that specifies the names of attributes whose values will be matched against the terms in the dictionary
   */
  public final String getAttributePattern() {
    return properties.get(ATTRIBUTE_PATTERN_PROPERTY);
  }

  /**
   * Regular Expression that specifies the names of attributes whose values will be matched against the terms in the dictionary
   */
  public final ScanAttribute setAttributePattern(final String attributePattern) {
    properties.put(ATTRIBUTE_PATTERN_PROPERTY, attributePattern);
    return this;
  }

  /**
   * Regular Expression that specifies the names of attributes whose values will be matched against the terms in the dictionary
   */
  public final ScanAttribute removeAttributePattern() {
    properties.remove(ATTRIBUTE_PATTERN_PROPERTY);
    return this;
  }

  /**
   * If set to All Must Match, then FlowFiles will be routed to 'matched' only if all specified attributes' values are found in the dictionary. If set to At Least 1 Must Match, FlowFiles will be routed to 'matched' if any attribute specified is found in the dictionary
   */
  public final String getMatchCriteria() {
    return properties.get(MATCH_CRITERIA_PROPERTY);
  }

  /**
   * If set to All Must Match, then FlowFiles will be routed to 'matched' only if all specified attributes' values are found in the dictionary. If set to At Least 1 Must Match, FlowFiles will be routed to 'matched' if any attribute specified is found in the dictionary
   */
  public final ScanAttribute setMatchCriteria(final String matchCriteria) {
    properties.put(MATCH_CRITERIA_PROPERTY, matchCriteria);
    return this;
  }

  /**
   * If set to All Must Match, then FlowFiles will be routed to 'matched' only if all specified attributes' values are found in the dictionary. If set to At Least 1 Must Match, FlowFiles will be routed to 'matched' if any attribute specified is found in the dictionary
   */
  public final ScanAttribute removeMatchCriteria() {
    properties.remove(MATCH_CRITERIA_PROPERTY);
    return this;
  }

  /**
   * A Regular Expression that will be applied to each line in the dictionary file. If the regular expression does not match the line, the line will not be included in the list of terms to search for. If a Matching Group is specified, only the portion of the term that matches that Matching Group will be used instead of the entire term. If not specified, all terms in the dictionary will be used and each term will consist of the text of the entire line in the file
   */
  public final String getDictionaryFilterPattern() {
    return properties.get(DICTIONARY_FILTER_PATTERN_PROPERTY);
  }

  /**
   * A Regular Expression that will be applied to each line in the dictionary file. If the regular expression does not match the line, the line will not be included in the list of terms to search for. If a Matching Group is specified, only the portion of the term that matches that Matching Group will be used instead of the entire term. If not specified, all terms in the dictionary will be used and each term will consist of the text of the entire line in the file
   */
  public final ScanAttribute setDictionaryFilterPattern(final String dictionaryFilterPattern) {
    properties.put(DICTIONARY_FILTER_PATTERN_PROPERTY, dictionaryFilterPattern);
    return this;
  }

  /**
   * A Regular Expression that will be applied to each line in the dictionary file. If the regular expression does not match the line, the line will not be included in the list of terms to search for. If a Matching Group is specified, only the portion of the term that matches that Matching Group will be used instead of the entire term. If not specified, all terms in the dictionary will be used and each term will consist of the text of the entire line in the file
   */
  public final ScanAttribute removeDictionaryFilterPattern() {
    properties.remove(DICTIONARY_FILTER_PATTERN_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ScanAttribute setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ScanAttribute removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ScanAttribute, ScanAttribute> configurator) {
    return configurator.apply(new ScanAttribute()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScanAttribute.class) final Closure<ScanAttribute> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ScanAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ScanAttribute.class, com.tibtech.nifi.processors.standard.ScanAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
