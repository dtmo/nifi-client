package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MergeContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.MergeContent";

  /**
   * Specifies the algorithm used to merge content. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public static final String MERGE_STRATEGY_PROPERTY = "Merge Strategy";

  /**
   * Determines the format that will be used to merge the content.
   */
  public static final String MERGE_FORMAT_PROPERTY = "Merge Format";

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public static final String ATTRIBUTE_STRATEGY_PROPERTY = "Attribute Strategy";

  /**
   * If specified, like FlowFiles will be binned together, where 'like FlowFiles' means FlowFiles that have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public static final String CORRELATION_ATTRIBUTE_NAME_PROPERTY = "Correlation Attribute Name";

  /**
   * The minimum number of files to include in a bundle
   */
  public static final String MINIMUM_NUMBER_OF_ENTRIES_PROPERTY = "Minimum Number of Entries";

  /**
   * The maximum number of files to include in a bundle. If not specified, there is no maximum.
   */
  public static final String MAXIMUM_NUMBER_OF_ENTRIES_PROPERTY = "Maximum Number of Entries";

  /**
   * The minimum size of for the bundle
   */
  public static final String MINIMUM_GROUP_SIZE_PROPERTY = "Minimum Group Size";

  /**
   * The maximum size for the bundle. If not specified, there is no maximum.
   */
  public static final String MAXIMUM_GROUP_SIZE_PROPERTY = "Maximum Group Size";

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public static final String MAX_BIN_AGE_PROPERTY = "Max Bin Age";

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time
   */
  public static final String MAXIMUM_NUMBER_OF_BINS_PROPERTY = "Maximum number of Bins";

  /**
   * Determines if Header, Footer, and Demarcator should point to files containing the respective content, or if the values of the properties should be used as the content.
   */
  public static final String DELIMITER_STRATEGY_PROPERTY = "Delimiter Strategy";

  /**
   * Filename specifying the header to use. If not specified, no header is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public static final String HEADER_FILE_PROPERTY = "Header File";

  /**
   * Filename specifying the footer to use. If not specified, no footer is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public static final String FOOTER_FILE_PROPERTY = "Footer File";

  /**
   * Filename specifying the demarcator to use. If not specified, no demarcator is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public static final String DEMARCATOR_FILE_PROPERTY = "Demarcator File";

  /**
   * Specifies the compression level to use when using the Zip Merge Format; if not using the Zip Merge Format, this value is ignored
   */
  public static final String COMPRESSION_LEVEL_PROPERTY = "Compression Level";

  /**
   * If using the Zip or Tar Merge Format, specifies whether or not the FlowFiles' paths should be included in their entry names; if using other merge strategy, this value is ignored
   */
  public static final String KEEP_PATH_PROPERTY = "Keep Path";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies the algorithm used to merge content. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public final String getMergeStrategy() {
    return properties.get(MERGE_STRATEGY_PROPERTY);
  }

  /**
   * Specifies the algorithm used to merge content. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public final MergeContent setMergeStrategy(final String mergeStrategy) {
    properties.put(MERGE_STRATEGY_PROPERTY, mergeStrategy);
    return this;
  }

  /**
   * Specifies the algorithm used to merge content. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public final MergeContent removeMergeStrategy() {
    properties.remove(MERGE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Determines the format that will be used to merge the content.
   */
  public final String getMergeFormat() {
    return properties.get(MERGE_FORMAT_PROPERTY);
  }

  /**
   * Determines the format that will be used to merge the content.
   */
  public final MergeContent setMergeFormat(final String mergeFormat) {
    properties.put(MERGE_FORMAT_PROPERTY, mergeFormat);
    return this;
  }

  /**
   * Determines the format that will be used to merge the content.
   */
  public final MergeContent removeMergeFormat() {
    properties.remove(MERGE_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public final String getAttributeStrategy() {
    return properties.get(ATTRIBUTE_STRATEGY_PROPERTY);
  }

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public final MergeContent setAttributeStrategy(final String attributeStrategy) {
    properties.put(ATTRIBUTE_STRATEGY_PROPERTY, attributeStrategy);
    return this;
  }

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public final MergeContent removeAttributeStrategy() {
    properties.remove(ATTRIBUTE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * If specified, like FlowFiles will be binned together, where 'like FlowFiles' means FlowFiles that have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public final String getCorrelationAttributeName() {
    return properties.get(CORRELATION_ATTRIBUTE_NAME_PROPERTY);
  }

  /**
   * If specified, like FlowFiles will be binned together, where 'like FlowFiles' means FlowFiles that have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public final MergeContent setCorrelationAttributeName(final String correlationAttributeName) {
    properties.put(CORRELATION_ATTRIBUTE_NAME_PROPERTY, correlationAttributeName);
    return this;
  }

  /**
   * If specified, like FlowFiles will be binned together, where 'like FlowFiles' means FlowFiles that have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public final MergeContent removeCorrelationAttributeName() {
    properties.remove(CORRELATION_ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  /**
   * The minimum number of files to include in a bundle
   */
  public final String getMinimumNumberOfEntries() {
    return properties.get(MINIMUM_NUMBER_OF_ENTRIES_PROPERTY);
  }

  /**
   * The minimum number of files to include in a bundle
   */
  public final MergeContent setMinimumNumberOfEntries(final String minimumNumberOfEntries) {
    properties.put(MINIMUM_NUMBER_OF_ENTRIES_PROPERTY, minimumNumberOfEntries);
    return this;
  }

  /**
   * The minimum number of files to include in a bundle
   */
  public final MergeContent removeMinimumNumberOfEntries() {
    properties.remove(MINIMUM_NUMBER_OF_ENTRIES_PROPERTY);
    return this;
  }

  /**
   * The maximum number of files to include in a bundle. If not specified, there is no maximum.
   */
  public final String getMaximumNumberOfEntries() {
    return properties.get(MAXIMUM_NUMBER_OF_ENTRIES_PROPERTY);
  }

  /**
   * The maximum number of files to include in a bundle. If not specified, there is no maximum.
   */
  public final MergeContent setMaximumNumberOfEntries(final String maximumNumberOfEntries) {
    properties.put(MAXIMUM_NUMBER_OF_ENTRIES_PROPERTY, maximumNumberOfEntries);
    return this;
  }

  /**
   * The maximum number of files to include in a bundle. If not specified, there is no maximum.
   */
  public final MergeContent removeMaximumNumberOfEntries() {
    properties.remove(MAXIMUM_NUMBER_OF_ENTRIES_PROPERTY);
    return this;
  }

  /**
   * The minimum size of for the bundle
   */
  public final String getMinimumGroupSize() {
    return properties.get(MINIMUM_GROUP_SIZE_PROPERTY);
  }

  /**
   * The minimum size of for the bundle
   */
  public final MergeContent setMinimumGroupSize(final String minimumGroupSize) {
    properties.put(MINIMUM_GROUP_SIZE_PROPERTY, minimumGroupSize);
    return this;
  }

  /**
   * The minimum size of for the bundle
   */
  public final MergeContent removeMinimumGroupSize() {
    properties.remove(MINIMUM_GROUP_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size for the bundle. If not specified, there is no maximum.
   */
  public final String getMaximumGroupSize() {
    return properties.get(MAXIMUM_GROUP_SIZE_PROPERTY);
  }

  /**
   * The maximum size for the bundle. If not specified, there is no maximum.
   */
  public final MergeContent setMaximumGroupSize(final String maximumGroupSize) {
    properties.put(MAXIMUM_GROUP_SIZE_PROPERTY, maximumGroupSize);
    return this;
  }

  /**
   * The maximum size for the bundle. If not specified, there is no maximum.
   */
  public final MergeContent removeMaximumGroupSize() {
    properties.remove(MAXIMUM_GROUP_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public final String getMaxBinAge() {
    return properties.get(MAX_BIN_AGE_PROPERTY);
  }

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public final MergeContent setMaxBinAge(final String maxBinAge) {
    properties.put(MAX_BIN_AGE_PROPERTY, maxBinAge);
    return this;
  }

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public final MergeContent removeMaxBinAge() {
    properties.remove(MAX_BIN_AGE_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time
   */
  public final String getMaximumNumberOfBins() {
    return properties.get(MAXIMUM_NUMBER_OF_BINS_PROPERTY);
  }

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time
   */
  public final MergeContent setMaximumNumberOfBins(final String maximumNumberOfBins) {
    properties.put(MAXIMUM_NUMBER_OF_BINS_PROPERTY, maximumNumberOfBins);
    return this;
  }

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time
   */
  public final MergeContent removeMaximumNumberOfBins() {
    properties.remove(MAXIMUM_NUMBER_OF_BINS_PROPERTY);
    return this;
  }

  /**
   * Determines if Header, Footer, and Demarcator should point to files containing the respective content, or if the values of the properties should be used as the content.
   */
  public final String getDelimiterStrategy() {
    return properties.get(DELIMITER_STRATEGY_PROPERTY);
  }

  /**
   * Determines if Header, Footer, and Demarcator should point to files containing the respective content, or if the values of the properties should be used as the content.
   */
  public final MergeContent setDelimiterStrategy(final String delimiterStrategy) {
    properties.put(DELIMITER_STRATEGY_PROPERTY, delimiterStrategy);
    return this;
  }

  /**
   * Determines if Header, Footer, and Demarcator should point to files containing the respective content, or if the values of the properties should be used as the content.
   */
  public final MergeContent removeDelimiterStrategy() {
    properties.remove(DELIMITER_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Filename specifying the header to use. If not specified, no header is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final String getHeaderFile() {
    return properties.get(HEADER_FILE_PROPERTY);
  }

  /**
   * Filename specifying the header to use. If not specified, no header is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final MergeContent setHeaderFile(final String headerFile) {
    properties.put(HEADER_FILE_PROPERTY, headerFile);
    return this;
  }

  /**
   * Filename specifying the header to use. If not specified, no header is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final MergeContent removeHeaderFile() {
    properties.remove(HEADER_FILE_PROPERTY);
    return this;
  }

  /**
   * Filename specifying the footer to use. If not specified, no footer is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final String getFooterFile() {
    return properties.get(FOOTER_FILE_PROPERTY);
  }

  /**
   * Filename specifying the footer to use. If not specified, no footer is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final MergeContent setFooterFile(final String footerFile) {
    properties.put(FOOTER_FILE_PROPERTY, footerFile);
    return this;
  }

  /**
   * Filename specifying the footer to use. If not specified, no footer is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final MergeContent removeFooterFile() {
    properties.remove(FOOTER_FILE_PROPERTY);
    return this;
  }

  /**
   * Filename specifying the demarcator to use. If not specified, no demarcator is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final String getDemarcatorFile() {
    return properties.get(DEMARCATOR_FILE_PROPERTY);
  }

  /**
   * Filename specifying the demarcator to use. If not specified, no demarcator is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final MergeContent setDemarcatorFile(final String demarcatorFile) {
    properties.put(DEMARCATOR_FILE_PROPERTY, demarcatorFile);
    return this;
  }

  /**
   * Filename specifying the demarcator to use. If not specified, no demarcator is supplied. This property is valid only when using the binary-concatenation merge strategy; otherwise, it is ignored.
   */
  public final MergeContent removeDemarcatorFile() {
    properties.remove(DEMARCATOR_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies the compression level to use when using the Zip Merge Format; if not using the Zip Merge Format, this value is ignored
   */
  public final String getCompressionLevel() {
    return properties.get(COMPRESSION_LEVEL_PROPERTY);
  }

  /**
   * Specifies the compression level to use when using the Zip Merge Format; if not using the Zip Merge Format, this value is ignored
   */
  public final MergeContent setCompressionLevel(final String compressionLevel) {
    properties.put(COMPRESSION_LEVEL_PROPERTY, compressionLevel);
    return this;
  }

  /**
   * Specifies the compression level to use when using the Zip Merge Format; if not using the Zip Merge Format, this value is ignored
   */
  public final MergeContent removeCompressionLevel() {
    properties.remove(COMPRESSION_LEVEL_PROPERTY);
    return this;
  }

  /**
   * If using the Zip or Tar Merge Format, specifies whether or not the FlowFiles' paths should be included in their entry names; if using other merge strategy, this value is ignored
   */
  public final String getKeepPath() {
    return properties.get(KEEP_PATH_PROPERTY);
  }

  /**
   * If using the Zip or Tar Merge Format, specifies whether or not the FlowFiles' paths should be included in their entry names; if using other merge strategy, this value is ignored
   */
  public final MergeContent setKeepPath(final String keepPath) {
    properties.put(KEEP_PATH_PROPERTY, keepPath);
    return this;
  }

  /**
   * If using the Zip or Tar Merge Format, specifies whether or not the FlowFiles' paths should be included in their entry names; if using other merge strategy, this value is ignored
   */
  public final MergeContent removeKeepPath() {
    properties.remove(KEEP_PATH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MergeContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MergeContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<MergeContent, MergeContent> configurator) {
    return configurator.apply(new MergeContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MergeContent.class) final Closure<MergeContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.MergeContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.MergeContent.class, com.tibtech.nifi.processors.standard.MergeContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
