package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class TransformXml {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.TransformXml";

  /**
   * Provides the name (including full path) of the XSLT file to apply to the flowfile XML content.
   */
  public static final String XSLT_FILE_NAME_PROPERTY = "XSLT file name";

  /**
   * Whether or not to indent the output.
   */
  public static final String INDENT_OUTPUT_PROPERTY = "indent-output";

  /**
   * Whether or not to mitigate various XML-related attacks like XXE (XML External Entity) attacks.
   */
  public static final String SECURE_PROCESSING_PROPERTY = "secure-processing";

  /**
   * Maximum number of stylesheets to cache. Zero disables the cache.
   */
  public static final String CACHE_SIZE_PROPERTY = "cache-size";

  /**
   * The cache TTL (time-to-live) or how long to keep stylesheets in the cache after last access.
   */
  public static final String CACHE_TTL_AFTER_LAST_ACCESS_PROPERTY = "cache-ttl-after-last-access";

  private final Map<String, String> properties;

  public TransformXml() {
    this.properties = new HashMap<>();
  }

  public TransformXml(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Provides the name (including full path) of the XSLT file to apply to the flowfile XML content.
   */
  public final String getXsltFileName() {
    return properties.get(XSLT_FILE_NAME_PROPERTY);
  }

  /**
   * Provides the name (including full path) of the XSLT file to apply to the flowfile XML content.
   */
  public final TransformXml setXsltFileName(final String xsltFileName) {
    properties.put(XSLT_FILE_NAME_PROPERTY, xsltFileName);
    return this;
  }

  /**
   * Provides the name (including full path) of the XSLT file to apply to the flowfile XML content.
   */
  public final TransformXml removeXsltFileName() {
    properties.remove(XSLT_FILE_NAME_PROPERTY);
    return this;
  }

  /**
   * Whether or not to indent the output.
   */
  public final String getIndentOutput() {
    return properties.get(INDENT_OUTPUT_PROPERTY);
  }

  /**
   * Whether or not to indent the output.
   */
  public final TransformXml setIndentOutput(final String indentOutput) {
    properties.put(INDENT_OUTPUT_PROPERTY, indentOutput);
    return this;
  }

  /**
   * Whether or not to indent the output.
   */
  public final TransformXml removeIndentOutput() {
    properties.remove(INDENT_OUTPUT_PROPERTY);
    return this;
  }

  /**
   * Whether or not to mitigate various XML-related attacks like XXE (XML External Entity) attacks.
   */
  public final String getSecureProcessing() {
    return properties.get(SECURE_PROCESSING_PROPERTY);
  }

  /**
   * Whether or not to mitigate various XML-related attacks like XXE (XML External Entity) attacks.
   */
  public final TransformXml setSecureProcessing(final String secureProcessing) {
    properties.put(SECURE_PROCESSING_PROPERTY, secureProcessing);
    return this;
  }

  /**
   * Whether or not to mitigate various XML-related attacks like XXE (XML External Entity) attacks.
   */
  public final TransformXml removeSecureProcessing() {
    properties.remove(SECURE_PROCESSING_PROPERTY);
    return this;
  }

  /**
   * Maximum number of stylesheets to cache. Zero disables the cache.
   */
  public final String getCacheSize() {
    return properties.get(CACHE_SIZE_PROPERTY);
  }

  /**
   * Maximum number of stylesheets to cache. Zero disables the cache.
   */
  public final TransformXml setCacheSize(final String cacheSize) {
    properties.put(CACHE_SIZE_PROPERTY, cacheSize);
    return this;
  }

  /**
   * Maximum number of stylesheets to cache. Zero disables the cache.
   */
  public final TransformXml removeCacheSize() {
    properties.remove(CACHE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The cache TTL (time-to-live) or how long to keep stylesheets in the cache after last access.
   */
  public final String getCacheTtlAfterLastAccess() {
    return properties.get(CACHE_TTL_AFTER_LAST_ACCESS_PROPERTY);
  }

  /**
   * The cache TTL (time-to-live) or how long to keep stylesheets in the cache after last access.
   */
  public final TransformXml setCacheTtlAfterLastAccess(final String cacheTtlAfterLastAccess) {
    properties.put(CACHE_TTL_AFTER_LAST_ACCESS_PROPERTY, cacheTtlAfterLastAccess);
    return this;
  }

  /**
   * The cache TTL (time-to-live) or how long to keep stylesheets in the cache after last access.
   */
  public final TransformXml removeCacheTtlAfterLastAccess() {
    properties.remove(CACHE_TTL_AFTER_LAST_ACCESS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final TransformXml setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final TransformXml removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<TransformXml, TransformXml> configurator) {
    return configurator.apply(new TransformXml()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = TransformXml.class) final Closure<TransformXml> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.TransformXml> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.TransformXml.class, com.tibtech.nifi.processors.standard.TransformXml.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<TransformXml, TransformXml> configurator) {
    return configurator.apply(new TransformXml(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = TransformXml.class) final Closure<TransformXml> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.TransformXml> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.TransformXml.class, com.tibtech.nifi.processors.standard.TransformXml.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
