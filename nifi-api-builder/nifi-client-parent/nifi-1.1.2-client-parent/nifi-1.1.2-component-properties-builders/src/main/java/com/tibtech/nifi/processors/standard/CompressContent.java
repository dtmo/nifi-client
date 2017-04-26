package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CompressContent {
  /**
   * Indicates whether the processor should compress content or decompress content. Must be either 'compress' or 'decompress'
   */
  public static final String MODE_PROPERTY = "Mode";

  /**
   * The compression format to use. Valid values are: GZIP, BZIP2, XZ-LZMA2, LZMA, Snappy, and Snappy Framed
   */
  public static final String COMPRESSION_FORMAT_PROPERTY = "Compression Format";

  /**
   * The compression level to use; this is valid only when using GZIP compression. A lower value results in faster processing but less compression; a value of 0 indicates no compression but simply archiving
   */
  public static final String COMPRESSION_LEVEL_PROPERTY = "Compression Level";

  /**
   * If true, will remove the filename extension when decompressing data (only if the extension indicates the appropriate compression format) and add the appropriate extension when compressing data
   */
  public static final String UPDATE_FILENAME_PROPERTY = "Update Filename";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Indicates whether the processor should compress content or decompress content. Must be either 'compress' or 'decompress'
   */
  public final String getMode() {
    return properties.get(MODE_PROPERTY);
  }

  /**
   * Indicates whether the processor should compress content or decompress content. Must be either 'compress' or 'decompress'
   */
  public final CompressContent setMode(final String mode) {
    properties.put(MODE_PROPERTY, mode);
    return this;
  }

  /**
   * Indicates whether the processor should compress content or decompress content. Must be either 'compress' or 'decompress'
   */
  public final CompressContent removeMode() {
    properties.remove(MODE_PROPERTY);
    return this;
  }

  /**
   * The compression format to use. Valid values are: GZIP, BZIP2, XZ-LZMA2, LZMA, Snappy, and Snappy Framed
   */
  public final String getCompressionFormat() {
    return properties.get(COMPRESSION_FORMAT_PROPERTY);
  }

  /**
   * The compression format to use. Valid values are: GZIP, BZIP2, XZ-LZMA2, LZMA, Snappy, and Snappy Framed
   */
  public final CompressContent setCompressionFormat(final String compressionFormat) {
    properties.put(COMPRESSION_FORMAT_PROPERTY, compressionFormat);
    return this;
  }

  /**
   * The compression format to use. Valid values are: GZIP, BZIP2, XZ-LZMA2, LZMA, Snappy, and Snappy Framed
   */
  public final CompressContent removeCompressionFormat() {
    properties.remove(COMPRESSION_FORMAT_PROPERTY);
    return this;
  }

  /**
   * The compression level to use; this is valid only when using GZIP compression. A lower value results in faster processing but less compression; a value of 0 indicates no compression but simply archiving
   */
  public final String getCompressionLevel() {
    return properties.get(COMPRESSION_LEVEL_PROPERTY);
  }

  /**
   * The compression level to use; this is valid only when using GZIP compression. A lower value results in faster processing but less compression; a value of 0 indicates no compression but simply archiving
   */
  public final CompressContent setCompressionLevel(final String compressionLevel) {
    properties.put(COMPRESSION_LEVEL_PROPERTY, compressionLevel);
    return this;
  }

  /**
   * The compression level to use; this is valid only when using GZIP compression. A lower value results in faster processing but less compression; a value of 0 indicates no compression but simply archiving
   */
  public final CompressContent removeCompressionLevel() {
    properties.remove(COMPRESSION_LEVEL_PROPERTY);
    return this;
  }

  /**
   * If true, will remove the filename extension when decompressing data (only if the extension indicates the appropriate compression format) and add the appropriate extension when compressing data
   */
  public final String getUpdateFilename() {
    return properties.get(UPDATE_FILENAME_PROPERTY);
  }

  /**
   * If true, will remove the filename extension when decompressing data (only if the extension indicates the appropriate compression format) and add the appropriate extension when compressing data
   */
  public final CompressContent setUpdateFilename(final String updateFilename) {
    properties.put(UPDATE_FILENAME_PROPERTY, updateFilename);
    return this;
  }

  /**
   * If true, will remove the filename extension when decompressing data (only if the extension indicates the appropriate compression format) and add the appropriate extension when compressing data
   */
  public final CompressContent removeUpdateFilename() {
    properties.remove(UPDATE_FILENAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CompressContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CompressContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<CompressContent, CompressContent> configurator) {
    return configurator.apply(new CompressContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CompressContent.class) final Closure<CompressContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.CompressContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.CompressContent.class, com.tibtech.nifi.processors.standard.CompressContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
