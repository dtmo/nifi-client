package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class UnpackContent {
  /**
   * The Packaging Format used to create the file
   */
  public static final String PACKAGING_FORMAT_PROPERTY = "Packaging Format";

  /**
   * Only files whose names match the given regular expression will be extracted (tar/zip only)
   */
  public static final String FILE_FILTER_PROPERTY = "File Filter";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Packaging Format used to create the file
   */
  public final String getPackagingFormat() {
    return properties.get(PACKAGING_FORMAT_PROPERTY);
  }

  /**
   * The Packaging Format used to create the file
   */
  public final UnpackContent setPackagingFormat(final String packagingFormat) {
    properties.put(PACKAGING_FORMAT_PROPERTY, packagingFormat);
    return this;
  }

  /**
   * The Packaging Format used to create the file
   */
  public final UnpackContent removePackagingFormat() {
    properties.remove(PACKAGING_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be extracted (tar/zip only)
   */
  public final String getFileFilter() {
    return properties.get(FILE_FILTER_PROPERTY);
  }

  /**
   * Only files whose names match the given regular expression will be extracted (tar/zip only)
   */
  public final UnpackContent setFileFilter(final String fileFilter) {
    properties.put(FILE_FILTER_PROPERTY, fileFilter);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be extracted (tar/zip only)
   */
  public final UnpackContent removeFileFilter() {
    properties.remove(FILE_FILTER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final UnpackContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final UnpackContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<UnpackContent, UnpackContent> configurator) {
    return configurator.apply(new UnpackContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UnpackContent.class) final Closure<UnpackContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.UnpackContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.UnpackContent.class, com.tibtech.nifi.processors.standard.UnpackContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
