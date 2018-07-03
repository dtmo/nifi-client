package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.FetchFile";

  /**
   * The fully-qualified filename of the file to fetch from the file system
   */
  public static final String FILE_TO_FETCH_PROPERTY = "File to Fetch";

  /**
   * Specifies what to do with the original file on the file system once it has been pulled into NiFi
   */
  public static final String COMPLETION_STRATEGY_PROPERTY = "Completion Strategy";

  /**
   * The directory to the move the original file to once it has been fetched from the file system. This property is ignored unless the Completion Strategy is set to "Move File". If the directory does not exist, it will be created.
   */
  public static final String MOVE_DESTINATION_DIRECTORY_PROPERTY = "Move Destination Directory";

  /**
   * If Completion Strategy is set to Move File and a file already exists in the destination directory with the same name, this property specifies how that naming conflict should be resolved
   */
  public static final String MOVE_CONFLICT_STRATEGY_PROPERTY = "Move Conflict Strategy";

  /**
   * Log level to use in case the file does not exist when the processor is triggered
   */
  public static final String LOG_LEVEL_WHEN_FILE_NOT_FOUND_PROPERTY = "Log level when file not found";

  /**
   * Log level to use in case user dtmorgan does not have sufficient permissions to read the file
   */
  public static final String LOG_LEVEL_WHEN_PERMISSION_DENIED_PROPERTY = "Log level when permission denied";

  private final Map<String, String> properties;

  public FetchFile() {
    this.properties = new HashMap<>();
  }

  public FetchFile(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The fully-qualified filename of the file to fetch from the file system
   */
  public final String getFileToFetch() {
    return properties.get(FILE_TO_FETCH_PROPERTY);
  }

  /**
   * The fully-qualified filename of the file to fetch from the file system
   */
  public final FetchFile setFileToFetch(final String fileToFetch) {
    properties.put(FILE_TO_FETCH_PROPERTY, fileToFetch);
    return this;
  }

  /**
   * The fully-qualified filename of the file to fetch from the file system
   */
  public final FetchFile removeFileToFetch() {
    properties.remove(FILE_TO_FETCH_PROPERTY);
    return this;
  }

  /**
   * Specifies what to do with the original file on the file system once it has been pulled into NiFi
   */
  public final String getCompletionStrategy() {
    return properties.get(COMPLETION_STRATEGY_PROPERTY);
  }

  /**
   * Specifies what to do with the original file on the file system once it has been pulled into NiFi
   */
  public final FetchFile setCompletionStrategy(final String completionStrategy) {
    properties.put(COMPLETION_STRATEGY_PROPERTY, completionStrategy);
    return this;
  }

  /**
   * Specifies what to do with the original file on the file system once it has been pulled into NiFi
   */
  public final FetchFile removeCompletionStrategy() {
    properties.remove(COMPLETION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The directory to the move the original file to once it has been fetched from the file system. This property is ignored unless the Completion Strategy is set to "Move File". If the directory does not exist, it will be created.
   */
  public final String getMoveDestinationDirectory() {
    return properties.get(MOVE_DESTINATION_DIRECTORY_PROPERTY);
  }

  /**
   * The directory to the move the original file to once it has been fetched from the file system. This property is ignored unless the Completion Strategy is set to "Move File". If the directory does not exist, it will be created.
   */
  public final FetchFile setMoveDestinationDirectory(final String moveDestinationDirectory) {
    properties.put(MOVE_DESTINATION_DIRECTORY_PROPERTY, moveDestinationDirectory);
    return this;
  }

  /**
   * The directory to the move the original file to once it has been fetched from the file system. This property is ignored unless the Completion Strategy is set to "Move File". If the directory does not exist, it will be created.
   */
  public final FetchFile removeMoveDestinationDirectory() {
    properties.remove(MOVE_DESTINATION_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * If Completion Strategy is set to Move File and a file already exists in the destination directory with the same name, this property specifies how that naming conflict should be resolved
   */
  public final String getMoveConflictStrategy() {
    return properties.get(MOVE_CONFLICT_STRATEGY_PROPERTY);
  }

  /**
   * If Completion Strategy is set to Move File and a file already exists in the destination directory with the same name, this property specifies how that naming conflict should be resolved
   */
  public final FetchFile setMoveConflictStrategy(final String moveConflictStrategy) {
    properties.put(MOVE_CONFLICT_STRATEGY_PROPERTY, moveConflictStrategy);
    return this;
  }

  /**
   * If Completion Strategy is set to Move File and a file already exists in the destination directory with the same name, this property specifies how that naming conflict should be resolved
   */
  public final FetchFile removeMoveConflictStrategy() {
    properties.remove(MOVE_CONFLICT_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Log level to use in case the file does not exist when the processor is triggered
   */
  public final String getLogLevelWhenFileNotFound() {
    return properties.get(LOG_LEVEL_WHEN_FILE_NOT_FOUND_PROPERTY);
  }

  /**
   * Log level to use in case the file does not exist when the processor is triggered
   */
  public final FetchFile setLogLevelWhenFileNotFound(final String logLevelWhenFileNotFound) {
    properties.put(LOG_LEVEL_WHEN_FILE_NOT_FOUND_PROPERTY, logLevelWhenFileNotFound);
    return this;
  }

  /**
   * Log level to use in case the file does not exist when the processor is triggered
   */
  public final FetchFile removeLogLevelWhenFileNotFound() {
    properties.remove(LOG_LEVEL_WHEN_FILE_NOT_FOUND_PROPERTY);
    return this;
  }

  /**
   * Log level to use in case user dtmorgan does not have sufficient permissions to read the file
   */
  public final String getLogLevelWhenPermissionDenied() {
    return properties.get(LOG_LEVEL_WHEN_PERMISSION_DENIED_PROPERTY);
  }

  /**
   * Log level to use in case user dtmorgan does not have sufficient permissions to read the file
   */
  public final FetchFile setLogLevelWhenPermissionDenied(
      final String logLevelWhenPermissionDenied) {
    properties.put(LOG_LEVEL_WHEN_PERMISSION_DENIED_PROPERTY, logLevelWhenPermissionDenied);
    return this;
  }

  /**
   * Log level to use in case user dtmorgan does not have sufficient permissions to read the file
   */
  public final FetchFile removeLogLevelWhenPermissionDenied() {
    properties.remove(LOG_LEVEL_WHEN_PERMISSION_DENIED_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<FetchFile, FetchFile> configurator) {
    return configurator.apply(new FetchFile()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchFile.class) final Closure<FetchFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchFile.class, com.tibtech.nifi.processors.standard.FetchFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchFile, FetchFile> configurator) {
    return configurator.apply(new FetchFile(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchFile.class) final Closure<FetchFile> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchFile.class, com.tibtech.nifi.processors.standard.FetchFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
