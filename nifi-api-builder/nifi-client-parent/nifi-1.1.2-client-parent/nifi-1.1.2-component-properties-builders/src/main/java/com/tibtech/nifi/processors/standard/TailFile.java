package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class TailFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.TailFile";

  /**
   * Mode to use: single file will tail only one file, multiple file will look for a list of file. In Multiple mode the Base directory is required.
   */
  public static final String TAIL_MODE_PROPERTY = "tail-mode";

  /**
   * Path of the file to tail in case of single file mode. If using multifile mode, regular expression to find files to tail in the base directory. In case recursivity is set to true, the regular expression will be used to match the path starting from the base directory (see additional details for examples).
   */
  public static final String FILE_TO_TAIL_PROPERTY = "File to Tail";

  /**
   * If the file to tail "rolls over" as would be the case with log files, this filename pattern will be used to identify files that have rolled over so that if NiFi is restarted, and the file has rolled over, it will be able to pick up where it left off. This pattern supports wildcard characters * and ?, it also supports the notation ${filename} to specify a pattern based on the name of the file (without extension), and will assume that the files that have rolled over live in the same directory as the file being tailed. The same glob pattern will be used for all files.
   */
  public static final String ROLLING_FILENAME_PATTERN_PROPERTY = "Rolling Filename Pattern";

  /**
   * Base directory used to look for files to tail. This property is required when using Multifile mode.
   */
  public static final String TAIL_BASE_DIRECTORY_PROPERTY = "tail-base-directory";

  /**
   * When the Processor first begins to tail data, this property specifies where the Processor should begin reading data. Once data has been ingested from a file, the Processor will continue from the last point from which it has received data.
   */
  public static final String INITIAL_START_POSITION_PROPERTY = "Initial Start Position";

  /**
   * Specifies where the state is located either local or cluster so that state can be stored appropriately in order to ensure that all data is consumed without duplicating data upon restart of NiFi
   */
  public static final String FILE_LOCATION_PROPERTY = "File Location";

  /**
   * When using Multiple files mode, this property defines if files must be listed recursively or not in the base directory.
   */
  public static final String TAILFILE_RECURSIVE_LOOKUP_PROPERTY = "tailfile-recursive-lookup";

  /**
   * Specifies if the files to tail have a fixed name or not.
   */
  public static final String TAILFILE_ROLLING_STRATEGY_PROPERTY = "tailfile-rolling-strategy";

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the minimum duration the processor will wait before listing again the files to tail.
   */
  public static final String TAILFILE_LOOKUP_FREQUENCY_PROPERTY = "tailfile-lookup-frequency";

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the necessary minimum duration to consider that no new messages will be appended in a file regarding its last modification date. This should not be set too low to avoid duplication of data in case new messages are appended at a lower frequency.
   */
  public static final String TAILFILE_MAXIMUM_AGE_PROPERTY = "tailfile-maximum-age";

  private final Map<String, String> properties;

  public TailFile() {
    this.properties = new HashMap<>();
  }

  public TailFile(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Mode to use: single file will tail only one file, multiple file will look for a list of file. In Multiple mode the Base directory is required.
   */
  public final String getTailMode() {
    return properties.get(TAIL_MODE_PROPERTY);
  }

  /**
   * Mode to use: single file will tail only one file, multiple file will look for a list of file. In Multiple mode the Base directory is required.
   */
  public final TailFile setTailMode(final String tailMode) {
    properties.put(TAIL_MODE_PROPERTY, tailMode);
    return this;
  }

  /**
   * Mode to use: single file will tail only one file, multiple file will look for a list of file. In Multiple mode the Base directory is required.
   */
  public final TailFile removeTailMode() {
    properties.remove(TAIL_MODE_PROPERTY);
    return this;
  }

  /**
   * Path of the file to tail in case of single file mode. If using multifile mode, regular expression to find files to tail in the base directory. In case recursivity is set to true, the regular expression will be used to match the path starting from the base directory (see additional details for examples).
   */
  public final String getFileToTail() {
    return properties.get(FILE_TO_TAIL_PROPERTY);
  }

  /**
   * Path of the file to tail in case of single file mode. If using multifile mode, regular expression to find files to tail in the base directory. In case recursivity is set to true, the regular expression will be used to match the path starting from the base directory (see additional details for examples).
   */
  public final TailFile setFileToTail(final String fileToTail) {
    properties.put(FILE_TO_TAIL_PROPERTY, fileToTail);
    return this;
  }

  /**
   * Path of the file to tail in case of single file mode. If using multifile mode, regular expression to find files to tail in the base directory. In case recursivity is set to true, the regular expression will be used to match the path starting from the base directory (see additional details for examples).
   */
  public final TailFile removeFileToTail() {
    properties.remove(FILE_TO_TAIL_PROPERTY);
    return this;
  }

  /**
   * If the file to tail "rolls over" as would be the case with log files, this filename pattern will be used to identify files that have rolled over so that if NiFi is restarted, and the file has rolled over, it will be able to pick up where it left off. This pattern supports wildcard characters * and ?, it also supports the notation ${filename} to specify a pattern based on the name of the file (without extension), and will assume that the files that have rolled over live in the same directory as the file being tailed. The same glob pattern will be used for all files.
   */
  public final String getRollingFilenamePattern() {
    return properties.get(ROLLING_FILENAME_PATTERN_PROPERTY);
  }

  /**
   * If the file to tail "rolls over" as would be the case with log files, this filename pattern will be used to identify files that have rolled over so that if NiFi is restarted, and the file has rolled over, it will be able to pick up where it left off. This pattern supports wildcard characters * and ?, it also supports the notation ${filename} to specify a pattern based on the name of the file (without extension), and will assume that the files that have rolled over live in the same directory as the file being tailed. The same glob pattern will be used for all files.
   */
  public final TailFile setRollingFilenamePattern(final String rollingFilenamePattern) {
    properties.put(ROLLING_FILENAME_PATTERN_PROPERTY, rollingFilenamePattern);
    return this;
  }

  /**
   * If the file to tail "rolls over" as would be the case with log files, this filename pattern will be used to identify files that have rolled over so that if NiFi is restarted, and the file has rolled over, it will be able to pick up where it left off. This pattern supports wildcard characters * and ?, it also supports the notation ${filename} to specify a pattern based on the name of the file (without extension), and will assume that the files that have rolled over live in the same directory as the file being tailed. The same glob pattern will be used for all files.
   */
  public final TailFile removeRollingFilenamePattern() {
    properties.remove(ROLLING_FILENAME_PATTERN_PROPERTY);
    return this;
  }

  /**
   * Base directory used to look for files to tail. This property is required when using Multifile mode.
   */
  public final String getTailBaseDirectory() {
    return properties.get(TAIL_BASE_DIRECTORY_PROPERTY);
  }

  /**
   * Base directory used to look for files to tail. This property is required when using Multifile mode.
   */
  public final TailFile setTailBaseDirectory(final String tailBaseDirectory) {
    properties.put(TAIL_BASE_DIRECTORY_PROPERTY, tailBaseDirectory);
    return this;
  }

  /**
   * Base directory used to look for files to tail. This property is required when using Multifile mode.
   */
  public final TailFile removeTailBaseDirectory() {
    properties.remove(TAIL_BASE_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * When the Processor first begins to tail data, this property specifies where the Processor should begin reading data. Once data has been ingested from a file, the Processor will continue from the last point from which it has received data.
   */
  public final String getInitialStartPosition() {
    return properties.get(INITIAL_START_POSITION_PROPERTY);
  }

  /**
   * When the Processor first begins to tail data, this property specifies where the Processor should begin reading data. Once data has been ingested from a file, the Processor will continue from the last point from which it has received data.
   */
  public final TailFile setInitialStartPosition(final String initialStartPosition) {
    properties.put(INITIAL_START_POSITION_PROPERTY, initialStartPosition);
    return this;
  }

  /**
   * When the Processor first begins to tail data, this property specifies where the Processor should begin reading data. Once data has been ingested from a file, the Processor will continue from the last point from which it has received data.
   */
  public final TailFile removeInitialStartPosition() {
    properties.remove(INITIAL_START_POSITION_PROPERTY);
    return this;
  }

  /**
   * Specifies where the state is located either local or cluster so that state can be stored appropriately in order to ensure that all data is consumed without duplicating data upon restart of NiFi
   */
  public final String getFileLocation() {
    return properties.get(FILE_LOCATION_PROPERTY);
  }

  /**
   * Specifies where the state is located either local or cluster so that state can be stored appropriately in order to ensure that all data is consumed without duplicating data upon restart of NiFi
   */
  public final TailFile setFileLocation(final String fileLocation) {
    properties.put(FILE_LOCATION_PROPERTY, fileLocation);
    return this;
  }

  /**
   * Specifies where the state is located either local or cluster so that state can be stored appropriately in order to ensure that all data is consumed without duplicating data upon restart of NiFi
   */
  public final TailFile removeFileLocation() {
    properties.remove(FILE_LOCATION_PROPERTY);
    return this;
  }

  /**
   * When using Multiple files mode, this property defines if files must be listed recursively or not in the base directory.
   */
  public final String getTailfileRecursiveLookup() {
    return properties.get(TAILFILE_RECURSIVE_LOOKUP_PROPERTY);
  }

  /**
   * When using Multiple files mode, this property defines if files must be listed recursively or not in the base directory.
   */
  public final TailFile setTailfileRecursiveLookup(final String tailfileRecursiveLookup) {
    properties.put(TAILFILE_RECURSIVE_LOOKUP_PROPERTY, tailfileRecursiveLookup);
    return this;
  }

  /**
   * When using Multiple files mode, this property defines if files must be listed recursively or not in the base directory.
   */
  public final TailFile removeTailfileRecursiveLookup() {
    properties.remove(TAILFILE_RECURSIVE_LOOKUP_PROPERTY);
    return this;
  }

  /**
   * Specifies if the files to tail have a fixed name or not.
   */
  public final String getTailfileRollingStrategy() {
    return properties.get(TAILFILE_ROLLING_STRATEGY_PROPERTY);
  }

  /**
   * Specifies if the files to tail have a fixed name or not.
   */
  public final TailFile setTailfileRollingStrategy(final String tailfileRollingStrategy) {
    properties.put(TAILFILE_ROLLING_STRATEGY_PROPERTY, tailfileRollingStrategy);
    return this;
  }

  /**
   * Specifies if the files to tail have a fixed name or not.
   */
  public final TailFile removeTailfileRollingStrategy() {
    properties.remove(TAILFILE_ROLLING_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the minimum duration the processor will wait before listing again the files to tail.
   */
  public final String getTailfileLookupFrequency() {
    return properties.get(TAILFILE_LOOKUP_FREQUENCY_PROPERTY);
  }

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the minimum duration the processor will wait before listing again the files to tail.
   */
  public final TailFile setTailfileLookupFrequency(final String tailfileLookupFrequency) {
    properties.put(TAILFILE_LOOKUP_FREQUENCY_PROPERTY, tailfileLookupFrequency);
    return this;
  }

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the minimum duration the processor will wait before listing again the files to tail.
   */
  public final TailFile removeTailfileLookupFrequency() {
    properties.remove(TAILFILE_LOOKUP_FREQUENCY_PROPERTY);
    return this;
  }

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the necessary minimum duration to consider that no new messages will be appended in a file regarding its last modification date. This should not be set too low to avoid duplication of data in case new messages are appended at a lower frequency.
   */
  public final String getTailfileMaximumAge() {
    return properties.get(TAILFILE_MAXIMUM_AGE_PROPERTY);
  }

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the necessary minimum duration to consider that no new messages will be appended in a file regarding its last modification date. This should not be set too low to avoid duplication of data in case new messages are appended at a lower frequency.
   */
  public final TailFile setTailfileMaximumAge(final String tailfileMaximumAge) {
    properties.put(TAILFILE_MAXIMUM_AGE_PROPERTY, tailfileMaximumAge);
    return this;
  }

  /**
   * Only used in Multiple files mode and Changing name rolling strategy. It specifies the necessary minimum duration to consider that no new messages will be appended in a file regarding its last modification date. This should not be set too low to avoid duplication of data in case new messages are appended at a lower frequency.
   */
  public final TailFile removeTailfileMaximumAge() {
    properties.remove(TAILFILE_MAXIMUM_AGE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final TailFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final TailFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<TailFile, TailFile> configurator) {
    return configurator.apply(new TailFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = TailFile.class) final Closure<TailFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.TailFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.TailFile.class, com.tibtech.nifi.processors.standard.TailFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<TailFile, TailFile> configurator) {
    return configurator.apply(new TailFile(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = TailFile.class) final Closure<TailFile> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.TailFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.TailFile.class, com.tibtech.nifi.processors.standard.TailFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
