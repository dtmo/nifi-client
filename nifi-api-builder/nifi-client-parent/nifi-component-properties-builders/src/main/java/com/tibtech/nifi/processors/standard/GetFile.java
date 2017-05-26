package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetFile {
  /**
   * The input directory from which to pull files
   */
  public static final String INPUT_DIRECTORY_PROPERTY = "Input Directory";

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public static final String FILE_FILTER_PROPERTY = "File Filter";

  /**
   * When Recurse Subdirectories is true, then only subdirectories whose path matches the given regular expression will be scanned
   */
  public static final String PATH_FILTER_PROPERTY = "Path Filter";

  /**
   * The maximum number of files to pull in each iteration
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * If true, the file is not deleted after it has been copied to the Content Repository; this causes the file to be picked up continually and is useful for testing purposes.  If not keeping original NiFi will need write permissions on the directory it is pulling from otherwise it will ignore the file.
   */
  public static final String KEEP_SOURCE_FILE_PROPERTY = "Keep Source File";

  /**
   * Indicates whether or not to pull files from subdirectories
   */
  public static final String RECURSE_SUBDIRECTORIES_PROPERTY = "Recurse Subdirectories";

  /**
   * Indicates how long to wait before performing a directory listing
   */
  public static final String POLLING_INTERVAL_PROPERTY = "Polling Interval";

  /**
   * Indicates whether or not hidden files should be ignored
   */
  public static final String IGNORE_HIDDEN_FILES_PROPERTY = "Ignore Hidden Files";

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (according to last modification date) will be ignored
   */
  public static final String MINIMUM_FILE_AGE_PROPERTY = "Minimum File Age";

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (according to last modification date) will be ignored
   */
  public static final String MAXIMUM_FILE_AGE_PROPERTY = "Maximum File Age";

  /**
   * The minimum size that a file must be in order to be pulled
   */
  public static final String MINIMUM_FILE_SIZE_PROPERTY = "Minimum File Size";

  /**
   * The maximum size that a file can be in order to be pulled
   */
  public static final String MAXIMUM_FILE_SIZE_PROPERTY = "Maximum File Size";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The input directory from which to pull files
   */
  public final String getInputDirectory() {
    return properties.get(INPUT_DIRECTORY_PROPERTY);
  }

  /**
   * The input directory from which to pull files
   */
  public final GetFile setInputDirectory(final String inputDirectory) {
    properties.put(INPUT_DIRECTORY_PROPERTY, inputDirectory);
    return this;
  }

  /**
   * The input directory from which to pull files
   */
  public final GetFile removeInputDirectory() {
    properties.remove(INPUT_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final String getFileFilter() {
    return properties.get(FILE_FILTER_PROPERTY);
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final GetFile setFileFilter(final String fileFilter) {
    properties.put(FILE_FILTER_PROPERTY, fileFilter);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final GetFile removeFileFilter() {
    properties.remove(FILE_FILTER_PROPERTY);
    return this;
  }

  /**
   * When Recurse Subdirectories is true, then only subdirectories whose path matches the given regular expression will be scanned
   */
  public final String getPathFilter() {
    return properties.get(PATH_FILTER_PROPERTY);
  }

  /**
   * When Recurse Subdirectories is true, then only subdirectories whose path matches the given regular expression will be scanned
   */
  public final GetFile setPathFilter(final String pathFilter) {
    properties.put(PATH_FILTER_PROPERTY, pathFilter);
    return this;
  }

  /**
   * When Recurse Subdirectories is true, then only subdirectories whose path matches the given regular expression will be scanned
   */
  public final GetFile removePathFilter() {
    properties.remove(PATH_FILTER_PROPERTY);
    return this;
  }

  /**
   * The maximum number of files to pull in each iteration
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of files to pull in each iteration
   */
  public final GetFile setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of files to pull in each iteration
   */
  public final GetFile removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * If true, the file is not deleted after it has been copied to the Content Repository; this causes the file to be picked up continually and is useful for testing purposes.  If not keeping original NiFi will need write permissions on the directory it is pulling from otherwise it will ignore the file.
   */
  public final String getKeepSourceFile() {
    return properties.get(KEEP_SOURCE_FILE_PROPERTY);
  }

  /**
   * If true, the file is not deleted after it has been copied to the Content Repository; this causes the file to be picked up continually and is useful for testing purposes.  If not keeping original NiFi will need write permissions on the directory it is pulling from otherwise it will ignore the file.
   */
  public final GetFile setKeepSourceFile(final String keepSourceFile) {
    properties.put(KEEP_SOURCE_FILE_PROPERTY, keepSourceFile);
    return this;
  }

  /**
   * If true, the file is not deleted after it has been copied to the Content Repository; this causes the file to be picked up continually and is useful for testing purposes.  If not keeping original NiFi will need write permissions on the directory it is pulling from otherwise it will ignore the file.
   */
  public final GetFile removeKeepSourceFile() {
    properties.remove(KEEP_SOURCE_FILE_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not to pull files from subdirectories
   */
  public final String getRecurseSubdirectories() {
    return properties.get(RECURSE_SUBDIRECTORIES_PROPERTY);
  }

  /**
   * Indicates whether or not to pull files from subdirectories
   */
  public final GetFile setRecurseSubdirectories(final String recurseSubdirectories) {
    properties.put(RECURSE_SUBDIRECTORIES_PROPERTY, recurseSubdirectories);
    return this;
  }

  /**
   * Indicates whether or not to pull files from subdirectories
   */
  public final GetFile removeRecurseSubdirectories() {
    properties.remove(RECURSE_SUBDIRECTORIES_PROPERTY);
    return this;
  }

  /**
   * Indicates how long to wait before performing a directory listing
   */
  public final String getPollingInterval() {
    return properties.get(POLLING_INTERVAL_PROPERTY);
  }

  /**
   * Indicates how long to wait before performing a directory listing
   */
  public final GetFile setPollingInterval(final String pollingInterval) {
    properties.put(POLLING_INTERVAL_PROPERTY, pollingInterval);
    return this;
  }

  /**
   * Indicates how long to wait before performing a directory listing
   */
  public final GetFile removePollingInterval() {
    properties.remove(POLLING_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * Indicates whether or not hidden files should be ignored
   */
  public final String getIgnoreHiddenFiles() {
    return properties.get(IGNORE_HIDDEN_FILES_PROPERTY);
  }

  /**
   * Indicates whether or not hidden files should be ignored
   */
  public final GetFile setIgnoreHiddenFiles(final String ignoreHiddenFiles) {
    properties.put(IGNORE_HIDDEN_FILES_PROPERTY, ignoreHiddenFiles);
    return this;
  }

  /**
   * Indicates whether or not hidden files should be ignored
   */
  public final GetFile removeIgnoreHiddenFiles() {
    properties.remove(IGNORE_HIDDEN_FILES_PROPERTY);
    return this;
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (according to last modification date) will be ignored
   */
  public final String getMinimumFileAge() {
    return properties.get(MINIMUM_FILE_AGE_PROPERTY);
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (according to last modification date) will be ignored
   */
  public final GetFile setMinimumFileAge(final String minimumFileAge) {
    properties.put(MINIMUM_FILE_AGE_PROPERTY, minimumFileAge);
    return this;
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (according to last modification date) will be ignored
   */
  public final GetFile removeMinimumFileAge() {
    properties.remove(MINIMUM_FILE_AGE_PROPERTY);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (according to last modification date) will be ignored
   */
  public final String getMaximumFileAge() {
    return properties.get(MAXIMUM_FILE_AGE_PROPERTY);
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (according to last modification date) will be ignored
   */
  public final GetFile setMaximumFileAge(final String maximumFileAge) {
    properties.put(MAXIMUM_FILE_AGE_PROPERTY, maximumFileAge);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (according to last modification date) will be ignored
   */
  public final GetFile removeMaximumFileAge() {
    properties.remove(MAXIMUM_FILE_AGE_PROPERTY);
    return this;
  }

  /**
   * The minimum size that a file must be in order to be pulled
   */
  public final String getMinimumFileSize() {
    return properties.get(MINIMUM_FILE_SIZE_PROPERTY);
  }

  /**
   * The minimum size that a file must be in order to be pulled
   */
  public final GetFile setMinimumFileSize(final String minimumFileSize) {
    properties.put(MINIMUM_FILE_SIZE_PROPERTY, minimumFileSize);
    return this;
  }

  /**
   * The minimum size that a file must be in order to be pulled
   */
  public final GetFile removeMinimumFileSize() {
    properties.remove(MINIMUM_FILE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size that a file can be in order to be pulled
   */
  public final String getMaximumFileSize() {
    return properties.get(MAXIMUM_FILE_SIZE_PROPERTY);
  }

  /**
   * The maximum size that a file can be in order to be pulled
   */
  public final GetFile setMaximumFileSize(final String maximumFileSize) {
    properties.put(MAXIMUM_FILE_SIZE_PROPERTY, maximumFileSize);
    return this;
  }

  /**
   * The maximum size that a file can be in order to be pulled
   */
  public final GetFile removeMaximumFileSize() {
    properties.remove(MAXIMUM_FILE_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetFile, GetFile> configurator) {
    return configurator.apply(new GetFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetFile.class) final Closure<GetFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetFile.class, com.tibtech.nifi.processors.standard.GetFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
