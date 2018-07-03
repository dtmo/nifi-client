package com.tibtech.nifi.processors.yandex;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class YandexTranslate {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.yandex.YandexTranslate";

  /**
   * The API Key that is registered with Yandex
   */
  public static final String YANDEX_API_KEY_PROPERTY = "Yandex API Key";

  /**
   * The language of incoming data. If no language is set, Yandex will attempt to detect the incoming language automatically.
   */
  public static final String INPUT_LANGUAGE_PROPERTY = "Input Language";

  /**
   * The language to translate the text into
   */
  public static final String TARGET_LANGUAGE_PROPERTY = "Target Language";

  /**
   * Specifies whether or not the content should be translated. If false, only the text specified by user-defined properties will be translated.
   */
  public static final String TRANSLATE_CONTENT_PROPERTY = "Translate Content";

  /**
   * Specifies the character set of the data to be translated
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties;

  public YandexTranslate() {
    this.properties = new HashMap<>();
  }

  public YandexTranslate(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The API Key that is registered with Yandex
   */
  public final String getYandexApiKey() {
    return properties.get(YANDEX_API_KEY_PROPERTY);
  }

  /**
   * The API Key that is registered with Yandex
   */
  public final YandexTranslate setYandexApiKey(final String yandexApiKey) {
    properties.put(YANDEX_API_KEY_PROPERTY, yandexApiKey);
    return this;
  }

  /**
   * The API Key that is registered with Yandex
   */
  public final YandexTranslate removeYandexApiKey() {
    properties.remove(YANDEX_API_KEY_PROPERTY);
    return this;
  }

  /**
   * The language of incoming data. If no language is set, Yandex will attempt to detect the incoming language automatically.
   */
  public final String getInputLanguage() {
    return properties.get(INPUT_LANGUAGE_PROPERTY);
  }

  /**
   * The language of incoming data. If no language is set, Yandex will attempt to detect the incoming language automatically.
   */
  public final YandexTranslate setInputLanguage(final String inputLanguage) {
    properties.put(INPUT_LANGUAGE_PROPERTY, inputLanguage);
    return this;
  }

  /**
   * The language of incoming data. If no language is set, Yandex will attempt to detect the incoming language automatically.
   */
  public final YandexTranslate removeInputLanguage() {
    properties.remove(INPUT_LANGUAGE_PROPERTY);
    return this;
  }

  /**
   * The language to translate the text into
   */
  public final String getTargetLanguage() {
    return properties.get(TARGET_LANGUAGE_PROPERTY);
  }

  /**
   * The language to translate the text into
   */
  public final YandexTranslate setTargetLanguage(final String targetLanguage) {
    properties.put(TARGET_LANGUAGE_PROPERTY, targetLanguage);
    return this;
  }

  /**
   * The language to translate the text into
   */
  public final YandexTranslate removeTargetLanguage() {
    properties.remove(TARGET_LANGUAGE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the content should be translated. If false, only the text specified by user-defined properties will be translated.
   */
  public final String getTranslateContent() {
    return properties.get(TRANSLATE_CONTENT_PROPERTY);
  }

  /**
   * Specifies whether or not the content should be translated. If false, only the text specified by user-defined properties will be translated.
   */
  public final YandexTranslate setTranslateContent(final String translateContent) {
    properties.put(TRANSLATE_CONTENT_PROPERTY, translateContent);
    return this;
  }

  /**
   * Specifies whether or not the content should be translated. If false, only the text specified by user-defined properties will be translated.
   */
  public final YandexTranslate removeTranslateContent() {
    properties.remove(TRANSLATE_CONTENT_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the data to be translated
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies the character set of the data to be translated
   */
  public final YandexTranslate setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the data to be translated
   */
  public final YandexTranslate removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final YandexTranslate setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final YandexTranslate removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<YandexTranslate, YandexTranslate> configurator) {
    return configurator.apply(new YandexTranslate()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = YandexTranslate.class) final Closure<YandexTranslate> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.yandex.YandexTranslate> code = closure.rehydrate(c, com.tibtech.nifi.processors.yandex.YandexTranslate.class, com.tibtech.nifi.processors.yandex.YandexTranslate.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<YandexTranslate, YandexTranslate> configurator) {
    return configurator.apply(new YandexTranslate(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = YandexTranslate.class) final Closure<YandexTranslate> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.yandex.YandexTranslate> code = closure.rehydrate(c, com.tibtech.nifi.processors.yandex.YandexTranslate.class, com.tibtech.nifi.processors.yandex.YandexTranslate.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
