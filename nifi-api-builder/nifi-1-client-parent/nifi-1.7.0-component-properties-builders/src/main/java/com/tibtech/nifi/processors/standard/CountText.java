package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CountText {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.CountText";

  /**
   * If enabled, will count the number of lines present in the incoming text.
   */
  public static final String TEXT_LINE_COUNT_PROPERTY = "text-line-count";

  /**
   * If enabled, will count the number of lines that contain a non-whitespace character present in the incoming text.
   */
  public static final String TEXT_LINE_NONEMPTY_COUNT_PROPERTY = "text-line-nonempty-count";

  /**
   * If enabled, will count the number of words (alphanumeric character groups bounded by whitespace) present in the incoming text. Common logical delimiters [_-.] do not bound a word unless 'Split Words on Symbols' is true.
   */
  public static final String TEXT_WORD_COUNT_PROPERTY = "text-word-count";

  /**
   * If enabled, will count the number of characters (including whitespace and symbols, but not including newlines and carriage returns) present in the incoming text.
   */
  public static final String TEXT_CHARACTER_COUNT_PROPERTY = "text-character-count";

  /**
   * If enabled, the word count will identify strings separated by common logical delimiters [ _ - . ] as independent words (ex. split-words-on-symbols = 4 words).
   */
  public static final String SPLIT_WORDS_ON_SYMBOLS_PROPERTY = "split-words-on-symbols";

  /**
   * Specifies a character encoding to use.
   */
  public static final String CHARACTER_ENCODING_PROPERTY = "character-encoding";

  private final Map<String, String> properties;

  public CountText() {
    this.properties = new HashMap<>();
  }

  public CountText(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * If enabled, will count the number of lines present in the incoming text.
   */
  public final String getTextLineCount() {
    return properties.get(TEXT_LINE_COUNT_PROPERTY);
  }

  /**
   * If enabled, will count the number of lines present in the incoming text.
   */
  public final CountText setTextLineCount(final String textLineCount) {
    properties.put(TEXT_LINE_COUNT_PROPERTY, textLineCount);
    return this;
  }

  /**
   * If enabled, will count the number of lines present in the incoming text.
   */
  public final CountText removeTextLineCount() {
    properties.remove(TEXT_LINE_COUNT_PROPERTY);
    return this;
  }

  /**
   * If enabled, will count the number of lines that contain a non-whitespace character present in the incoming text.
   */
  public final String getTextLineNonemptyCount() {
    return properties.get(TEXT_LINE_NONEMPTY_COUNT_PROPERTY);
  }

  /**
   * If enabled, will count the number of lines that contain a non-whitespace character present in the incoming text.
   */
  public final CountText setTextLineNonemptyCount(final String textLineNonemptyCount) {
    properties.put(TEXT_LINE_NONEMPTY_COUNT_PROPERTY, textLineNonemptyCount);
    return this;
  }

  /**
   * If enabled, will count the number of lines that contain a non-whitespace character present in the incoming text.
   */
  public final CountText removeTextLineNonemptyCount() {
    properties.remove(TEXT_LINE_NONEMPTY_COUNT_PROPERTY);
    return this;
  }

  /**
   * If enabled, will count the number of words (alphanumeric character groups bounded by whitespace) present in the incoming text. Common logical delimiters [_-.] do not bound a word unless 'Split Words on Symbols' is true.
   */
  public final String getTextWordCount() {
    return properties.get(TEXT_WORD_COUNT_PROPERTY);
  }

  /**
   * If enabled, will count the number of words (alphanumeric character groups bounded by whitespace) present in the incoming text. Common logical delimiters [_-.] do not bound a word unless 'Split Words on Symbols' is true.
   */
  public final CountText setTextWordCount(final String textWordCount) {
    properties.put(TEXT_WORD_COUNT_PROPERTY, textWordCount);
    return this;
  }

  /**
   * If enabled, will count the number of words (alphanumeric character groups bounded by whitespace) present in the incoming text. Common logical delimiters [_-.] do not bound a word unless 'Split Words on Symbols' is true.
   */
  public final CountText removeTextWordCount() {
    properties.remove(TEXT_WORD_COUNT_PROPERTY);
    return this;
  }

  /**
   * If enabled, will count the number of characters (including whitespace and symbols, but not including newlines and carriage returns) present in the incoming text.
   */
  public final String getTextCharacterCount() {
    return properties.get(TEXT_CHARACTER_COUNT_PROPERTY);
  }

  /**
   * If enabled, will count the number of characters (including whitespace and symbols, but not including newlines and carriage returns) present in the incoming text.
   */
  public final CountText setTextCharacterCount(final String textCharacterCount) {
    properties.put(TEXT_CHARACTER_COUNT_PROPERTY, textCharacterCount);
    return this;
  }

  /**
   * If enabled, will count the number of characters (including whitespace and symbols, but not including newlines and carriage returns) present in the incoming text.
   */
  public final CountText removeTextCharacterCount() {
    properties.remove(TEXT_CHARACTER_COUNT_PROPERTY);
    return this;
  }

  /**
   * If enabled, the word count will identify strings separated by common logical delimiters [ _ - . ] as independent words (ex. split-words-on-symbols = 4 words).
   */
  public final String getSplitWordsOnSymbols() {
    return properties.get(SPLIT_WORDS_ON_SYMBOLS_PROPERTY);
  }

  /**
   * If enabled, the word count will identify strings separated by common logical delimiters [ _ - . ] as independent words (ex. split-words-on-symbols = 4 words).
   */
  public final CountText setSplitWordsOnSymbols(final String splitWordsOnSymbols) {
    properties.put(SPLIT_WORDS_ON_SYMBOLS_PROPERTY, splitWordsOnSymbols);
    return this;
  }

  /**
   * If enabled, the word count will identify strings separated by common logical delimiters [ _ - . ] as independent words (ex. split-words-on-symbols = 4 words).
   */
  public final CountText removeSplitWordsOnSymbols() {
    properties.remove(SPLIT_WORDS_ON_SYMBOLS_PROPERTY);
    return this;
  }

  /**
   * Specifies a character encoding to use.
   */
  public final String getCharacterEncoding() {
    return properties.get(CHARACTER_ENCODING_PROPERTY);
  }

  /**
   * Specifies a character encoding to use.
   */
  public final CountText setCharacterEncoding(final String characterEncoding) {
    properties.put(CHARACTER_ENCODING_PROPERTY, characterEncoding);
    return this;
  }

  /**
   * Specifies a character encoding to use.
   */
  public final CountText removeCharacterEncoding() {
    properties.remove(CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CountText setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CountText removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<CountText, CountText> configurator) {
    return configurator.apply(new CountText()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CountText.class) final Closure<CountText> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.CountText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.CountText.class, com.tibtech.nifi.processors.standard.CountText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CountText, CountText> configurator) {
    return configurator.apply(new CountText(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CountText.class) final Closure<CountText> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.CountText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.CountText.class, com.tibtech.nifi.processors.standard.CountText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
