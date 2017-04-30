package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListFile";

  /**
   * The input directory from which files to pull files
   */
  public static final String INPUT_DIRECTORY_PROPERTY = "Input Directory";

  /**
   * Indicates whether to list files from subdirectories of the directory
   */
  public static final String RECURSE_SUBDIRECTORIES_PROPERTY = "Recurse Subdirectories";

  /**
   * Specifies where the Input Directory is located. This is used to determine whether state should be stored locally or across the cluster.
   */
  public static final String INPUT_DIRECTORY_LOCATION_PROPERTY = "Input Directory Location";

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public static final String FILE_FILTER_PROPERTY = "File Filter";

  /**
   * When Recurse Subdirectories is true, then only subdirectories whose path matches the given regular expression will be scanned
   */
  public static final String PATH_FILTER_PROPERTY = "Path Filter";

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

  /**
   * Indicates whether or not hidden files should be ignored
   */
  public static final String IGNORE_HIDDEN_FILES_PROPERTY = "Ignore Hidden Files";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The input directory from which files to pull files
   */
  public final String getInputDirectory() {
    return properties.get(INPUT_DIRECTORY_PROPERTY);
  }

  /**
   * The input directory from which files to pull files
   */
  public final ListFile setInputDirectory(final String inputDirectory) {
    properties.put(INPUT_DIRECTORY_PROPERTY, inputDirectory);
    return this;
  }

  /**
   * The input directory from which files to pull files
   */
  public final ListFile removeInputDirectory() {
    properties.remove(INPUT_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Indicates whether to list files from subdirectories of the directory
   */
  public final String getRecurseSubdirectories() {
    return properties.get(RECURSE_SUBDIRECTORIES_PROPERTY);
  }

  /**
   * Indicates whether to list files from subdirectories of the directory
   */
  public final ListFile setRecurseSubdirectories(final String recurseSubdirectories) {
    properties.put(RECURSE_SUBDIRECTORIES_PROPERTY, recurseSubdirectories);
    return this;
  }

  /**
   * Indicates whether to list files from subdirectories of the directory
   */
  public final ListFile removeRecurseSubdirectories() {
    properties.remove(RECURSE_SUBDIRECTORIES_PROPERTY);
    return this;
  }

  /**
   * Specifies where the Input Directory is located. This is used to determine whether state should be stored locally or across the cluster.
   */
  public final String getInputDirectoryLocation() {
    return properties.get(INPUT_DIRECTORY_LOCATION_PROPERTY);
  }

  /**
   * Specifies where the Input Directory is located. This is used to determine whether state should be stored locally or across the cluster.
   */
  public final ListFile setInputDirectoryLocation(final String inputDirectoryLocation) {
    properties.put(INPUT_DIRECTORY_LOCATION_PROPERTY, inputDirectoryLocation);
    return this;
  }

  /**
   * Specifies where the Input Directory is located. This is used to determine whether state should be stored locally or across the cluster.
   */
  public final ListFile removeInputDirectoryLocation() {
    properties.remove(INPUT_DIRECTORY_LOCATION_PROPERTY);
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
  public final ListFile setFileFilter(final String fileFilter) {
    properties.put(FILE_FILTER_PROPERTY, fileFilter);
    return this;
  }

  /**
   * Only files whose names match the given regular expression will be picked up
   */
  public final ListFile removeFileFilter() {
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
  public final ListFile setPathFilter(final String pathFilter) {
    properties.put(PATH_FILTER_PROPERTY, pathFilter);
    return this;
  }

  /**
   * When Recurse Subdirectories is true, then only subdirectories whose path matches the given regular expression will be scanned
   */
  public final ListFile removePathFilter() {
    properties.remove(PATH_FILTER_PROPERTY);
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
  public final ListFile setMinimumFileAge(final String minimumFileAge) {
    properties.put(MINIMUM_FILE_AGE_PROPERTY, minimumFileAge);
    return this;
  }

  /**
   * The minimum age that a file must be in order to be pulled; any file younger than this amount of time (according to last modification date) will be ignored
   */
  public final ListFile removeMinimumFileAge() {
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
  public final ListFile setMaximumFileAge(final String maximumFileAge) {
    properties.put(MAXIMUM_FILE_AGE_PROPERTY, maximumFileAge);
    return this;
  }

  /**
   * The maximum age that a file must be in order to be pulled; any file older than this amount of time (according to last modification date) will be ignored
   */
  public final ListFile removeMaximumFileAge() {
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
  public final ListFile setMinimumFileSize(final String minimumFileSize) {
    properties.put(MINIMUM_FILE_SIZE_PROPERTY, minimumFileSize);
    return this;
  }

  /**
   * The minimum size that a file must be in order to be pulled
   */
  public final ListFile removeMinimumFileSize() {
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
  public final ListFile setMaximumFileSize(final String maximumFileSize) {
    properties.put(MAXIMUM_FILE_SIZE_PROPERTY, maximumFileSize);
    return this;
  }

  /**
   * The maximum size that a file can be in order to be pulled
   */
  public final ListFile removeMaximumFileSize() {
    properties.remove(MAXIMUM_FILE_SIZE_PROPERTY);
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
  public final ListFile setIgnoreHiddenFiles(final String ignoreHiddenFiles) {
    properties.put(IGNORE_HIDDEN_FILES_PROPERTY, ignoreHiddenFiles);
    return this;
  }

  /**
   * Indicates whether or not hidden files should be ignored
   */
  public final ListFile removeIgnoreHiddenFiles() {
    properties.remove(IGNORE_HIDDEN_FILES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListFile, ListFile> configurator) {
    return configurator.apply(new ListFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListFile.class) final Closure<ListFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListFile.class, com.tibtech.nifi.processors.standard.ListFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
