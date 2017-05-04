package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SplitText {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.SplitText";

  /**
   * The number of lines that will be added to each split file, excluding header lines. A value of zero requires Maximum Fragment Size to be set, and line count will not be considered in determining splits.
   */
  public static final String LINE_SPLIT_COUNT_PROPERTY = "Line Split Count";

  /**
   * The maximum size of each split file, including header lines. NOTE: in the case where a single line exceeds this property (including headers, if applicable), that line will be output in a split of its own which exceeds this Maximum Fragment Size setting.
   */
  public static final String MAXIMUM_FRAGMENT_SIZE_PROPERTY = "Maximum Fragment Size";

  /**
   * The number of lines that should be considered part of the header; the header lines will be duplicated to all split files
   */
  public static final String HEADER_LINE_COUNT_PROPERTY = "Header Line Count";

  /**
   * The first character(s) on the line of the datafile which signifies a header line. This value is ignored when Header Line Count is non-zero. The first line not containing the Header Line Marker Characters and all subsequent lines are considered non-header
   */
  public static final String HEADER_LINE_MARKER_CHARACTERS_PROPERTY = "Header Line Marker Characters";

  /**
   * Whether to remove newlines at the end of each split file. This should be false if you intend to merge the split files later. If this is set to 'true' and a FlowFile is generated that contains only 'empty lines' (i.e., consists only of  and 
   *  characters), the FlowFile will not be emitted. Note, however, that if header lines are specified, the resultant FlowFile will never be empty as it will consist of the header lines, so a FlowFile may be emitted that contains only the header lines.
   */
  public static final String REMOVE_TRAILING_NEWLINES_PROPERTY = "Remove Trailing Newlines";

  private final Map<String, String> properties;

  public SplitText() {
    this.properties = new HashMap<>();
  }

  public SplitText(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The number of lines that will be added to each split file, excluding header lines. A value of zero requires Maximum Fragment Size to be set, and line count will not be considered in determining splits.
   */
  public final String getLineSplitCount() {
    return properties.get(LINE_SPLIT_COUNT_PROPERTY);
  }

  /**
   * The number of lines that will be added to each split file, excluding header lines. A value of zero requires Maximum Fragment Size to be set, and line count will not be considered in determining splits.
   */
  public final SplitText setLineSplitCount(final String lineSplitCount) {
    properties.put(LINE_SPLIT_COUNT_PROPERTY, lineSplitCount);
    return this;
  }

  /**
   * The number of lines that will be added to each split file, excluding header lines. A value of zero requires Maximum Fragment Size to be set, and line count will not be considered in determining splits.
   */
  public final SplitText removeLineSplitCount() {
    properties.remove(LINE_SPLIT_COUNT_PROPERTY);
    return this;
  }

  /**
   * The maximum size of each split file, including header lines. NOTE: in the case where a single line exceeds this property (including headers, if applicable), that line will be output in a split of its own which exceeds this Maximum Fragment Size setting.
   */
  public final String getMaximumFragmentSize() {
    return properties.get(MAXIMUM_FRAGMENT_SIZE_PROPERTY);
  }

  /**
   * The maximum size of each split file, including header lines. NOTE: in the case where a single line exceeds this property (including headers, if applicable), that line will be output in a split of its own which exceeds this Maximum Fragment Size setting.
   */
  public final SplitText setMaximumFragmentSize(final String maximumFragmentSize) {
    properties.put(MAXIMUM_FRAGMENT_SIZE_PROPERTY, maximumFragmentSize);
    return this;
  }

  /**
   * The maximum size of each split file, including header lines. NOTE: in the case where a single line exceeds this property (including headers, if applicable), that line will be output in a split of its own which exceeds this Maximum Fragment Size setting.
   */
  public final SplitText removeMaximumFragmentSize() {
    properties.remove(MAXIMUM_FRAGMENT_SIZE_PROPERTY);
    return this;
  }

  /**
   * The number of lines that should be considered part of the header; the header lines will be duplicated to all split files
   */
  public final String getHeaderLineCount() {
    return properties.get(HEADER_LINE_COUNT_PROPERTY);
  }

  /**
   * The number of lines that should be considered part of the header; the header lines will be duplicated to all split files
   */
  public final SplitText setHeaderLineCount(final String headerLineCount) {
    properties.put(HEADER_LINE_COUNT_PROPERTY, headerLineCount);
    return this;
  }

  /**
   * The number of lines that should be considered part of the header; the header lines will be duplicated to all split files
   */
  public final SplitText removeHeaderLineCount() {
    properties.remove(HEADER_LINE_COUNT_PROPERTY);
    return this;
  }

  /**
   * The first character(s) on the line of the datafile which signifies a header line. This value is ignored when Header Line Count is non-zero. The first line not containing the Header Line Marker Characters and all subsequent lines are considered non-header
   */
  public final String getHeaderLineMarkerCharacters() {
    return properties.get(HEADER_LINE_MARKER_CHARACTERS_PROPERTY);
  }

  /**
   * The first character(s) on the line of the datafile which signifies a header line. This value is ignored when Header Line Count is non-zero. The first line not containing the Header Line Marker Characters and all subsequent lines are considered non-header
   */
  public final SplitText setHeaderLineMarkerCharacters(final String headerLineMarkerCharacters) {
    properties.put(HEADER_LINE_MARKER_CHARACTERS_PROPERTY, headerLineMarkerCharacters);
    return this;
  }

  /**
   * The first character(s) on the line of the datafile which signifies a header line. This value is ignored when Header Line Count is non-zero. The first line not containing the Header Line Marker Characters and all subsequent lines are considered non-header
   */
  public final SplitText removeHeaderLineMarkerCharacters() {
    properties.remove(HEADER_LINE_MARKER_CHARACTERS_PROPERTY);
    return this;
  }

  /**
   * Whether to remove newlines at the end of each split file. This should be false if you intend to merge the split files later. If this is set to 'true' and a FlowFile is generated that contains only 'empty lines' (i.e., consists only of  and 
   *  characters), the FlowFile will not be emitted. Note, however, that if header lines are specified, the resultant FlowFile will never be empty as it will consist of the header lines, so a FlowFile may be emitted that contains only the header lines.
   */
  public final String getRemoveTrailingNewlines() {
    return properties.get(REMOVE_TRAILING_NEWLINES_PROPERTY);
  }

  /**
   * Whether to remove newlines at the end of each split file. This should be false if you intend to merge the split files later. If this is set to 'true' and a FlowFile is generated that contains only 'empty lines' (i.e., consists only of  and 
   *  characters), the FlowFile will not be emitted. Note, however, that if header lines are specified, the resultant FlowFile will never be empty as it will consist of the header lines, so a FlowFile may be emitted that contains only the header lines.
   */
  public final SplitText setRemoveTrailingNewlines(final String removeTrailingNewlines) {
    properties.put(REMOVE_TRAILING_NEWLINES_PROPERTY, removeTrailingNewlines);
    return this;
  }

  /**
   * Whether to remove newlines at the end of each split file. This should be false if you intend to merge the split files later. If this is set to 'true' and a FlowFile is generated that contains only 'empty lines' (i.e., consists only of  and 
   *  characters), the FlowFile will not be emitted. Note, however, that if header lines are specified, the resultant FlowFile will never be empty as it will consist of the header lines, so a FlowFile may be emitted that contains only the header lines.
   */
  public final SplitText removeRemoveTrailingNewlines() {
    properties.remove(REMOVE_TRAILING_NEWLINES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SplitText setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SplitText removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SplitText, SplitText> configurator) {
    return configurator.apply(new SplitText()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitText.class) final Closure<SplitText> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitText.class, com.tibtech.nifi.processors.standard.SplitText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SplitText, SplitText> configurator) {
    return configurator.apply(new SplitText(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitText.class) final Closure<SplitText> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitText> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitText.class, com.tibtech.nifi.processors.standard.SplitText.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
