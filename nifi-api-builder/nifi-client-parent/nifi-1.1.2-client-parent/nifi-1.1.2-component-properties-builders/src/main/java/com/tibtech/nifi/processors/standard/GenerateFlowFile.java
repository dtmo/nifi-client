package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GenerateFlowFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.GenerateFlowFile";

  /**
   * The size of the file that will be used
   */
  public static final String FILE_SIZE_PROPERTY = "File Size";

  /**
   * The number of FlowFiles to be transferred in each invocation
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Specifies whether the data should be Text or Binary
   */
  public static final String DATA_FORMAT_PROPERTY = "Data Format";

  /**
   * If true, each FlowFile that is generated will be unique. If false, a random value will be generated and all FlowFiles will get the same content but this offers much higher throughput
   */
  public static final String UNIQUE_FLOW_FILES_PROPERTY = "Unique FlowFiles";

  /**
   * If Data Format is text and if Unique FlowFiles is false, then this custom text will be used as content of the generated FlowFiles and the File Size will be ignored. Finally, if Expression Language is used, evaluation will be performed only once per batch of generated FlowFiles
   */
  public static final String GENERATE_FF_CUSTOM_TEXT_PROPERTY = "generate-ff-custom-text";

  private final Map<String, String> properties;

  public GenerateFlowFile() {
    this.properties = new HashMap<>();
  }

  public GenerateFlowFile(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The size of the file that will be used
   */
  public final String getFileSize() {
    return properties.get(FILE_SIZE_PROPERTY);
  }

  /**
   * The size of the file that will be used
   */
  public final GenerateFlowFile setFileSize(final String fileSize) {
    properties.put(FILE_SIZE_PROPERTY, fileSize);
    return this;
  }

  /**
   * The size of the file that will be used
   */
  public final GenerateFlowFile removeFileSize() {
    properties.remove(FILE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The number of FlowFiles to be transferred in each invocation
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of FlowFiles to be transferred in each invocation
   */
  public final GenerateFlowFile setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of FlowFiles to be transferred in each invocation
   */
  public final GenerateFlowFile removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the data should be Text or Binary
   */
  public final String getDataFormat() {
    return properties.get(DATA_FORMAT_PROPERTY);
  }

  /**
   * Specifies whether the data should be Text or Binary
   */
  public final GenerateFlowFile setDataFormat(final String dataFormat) {
    properties.put(DATA_FORMAT_PROPERTY, dataFormat);
    return this;
  }

  /**
   * Specifies whether the data should be Text or Binary
   */
  public final GenerateFlowFile removeDataFormat() {
    properties.remove(DATA_FORMAT_PROPERTY);
    return this;
  }

  /**
   * If true, each FlowFile that is generated will be unique. If false, a random value will be generated and all FlowFiles will get the same content but this offers much higher throughput
   */
  public final String getUniqueFlowFiles() {
    return properties.get(UNIQUE_FLOW_FILES_PROPERTY);
  }

  /**
   * If true, each FlowFile that is generated will be unique. If false, a random value will be generated and all FlowFiles will get the same content but this offers much higher throughput
   */
  public final GenerateFlowFile setUniqueFlowFiles(final String uniqueFlowFiles) {
    properties.put(UNIQUE_FLOW_FILES_PROPERTY, uniqueFlowFiles);
    return this;
  }

  /**
   * If true, each FlowFile that is generated will be unique. If false, a random value will be generated and all FlowFiles will get the same content but this offers much higher throughput
   */
  public final GenerateFlowFile removeUniqueFlowFiles() {
    properties.remove(UNIQUE_FLOW_FILES_PROPERTY);
    return this;
  }

  /**
   * If Data Format is text and if Unique FlowFiles is false, then this custom text will be used as content of the generated FlowFiles and the File Size will be ignored. Finally, if Expression Language is used, evaluation will be performed only once per batch of generated FlowFiles
   */
  public final String getGenerateFfCustomText() {
    return properties.get(GENERATE_FF_CUSTOM_TEXT_PROPERTY);
  }

  /**
   * If Data Format is text and if Unique FlowFiles is false, then this custom text will be used as content of the generated FlowFiles and the File Size will be ignored. Finally, if Expression Language is used, evaluation will be performed only once per batch of generated FlowFiles
   */
  public final GenerateFlowFile setGenerateFfCustomText(final String generateFfCustomText) {
    properties.put(GENERATE_FF_CUSTOM_TEXT_PROPERTY, generateFfCustomText);
    return this;
  }

  /**
   * If Data Format is text and if Unique FlowFiles is false, then this custom text will be used as content of the generated FlowFiles and the File Size will be ignored. Finally, if Expression Language is used, evaluation will be performed only once per batch of generated FlowFiles
   */
  public final GenerateFlowFile removeGenerateFfCustomText() {
    properties.remove(GENERATE_FF_CUSTOM_TEXT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GenerateFlowFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GenerateFlowFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GenerateFlowFile, GenerateFlowFile> configurator) {
    return configurator.apply(new GenerateFlowFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GenerateFlowFile.class) final Closure<GenerateFlowFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GenerateFlowFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GenerateFlowFile.class, com.tibtech.nifi.processors.standard.GenerateFlowFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GenerateFlowFile, GenerateFlowFile> configurator) {
    return configurator.apply(new GenerateFlowFile(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GenerateFlowFile.class) final Closure<GenerateFlowFile> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.GenerateFlowFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GenerateFlowFile.class, com.tibtech.nifi.processors.standard.GenerateFlowFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
