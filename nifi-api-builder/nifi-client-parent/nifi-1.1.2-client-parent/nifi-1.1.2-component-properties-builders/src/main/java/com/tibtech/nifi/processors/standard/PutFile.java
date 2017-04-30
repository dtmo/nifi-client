package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutFile";

  /**
   * The directory to which files should be written. You may use expression language such as /aa/bb/${path}
   */
  public static final String DIRECTORY_PROPERTY = "Directory";

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public static final String CONFLICT_RESOLUTION_STRATEGY_PROPERTY = "Conflict Resolution Strategy";

  /**
   * If true, then missing destination directories will be created. If false, flowfiles are penalized and sent to failure.
   */
  public static final String CREATE_MISSING_DIRECTORIES_PROPERTY = "Create Missing Directories";

  /**
   * Specifies the maximum number of files that can exist in the output directory
   */
  public static final String MAXIMUM_FILE_COUNT_PROPERTY = "Maximum File Count";

  /**
   * Sets the lastModifiedTime on the output file to the value of this attribute.  Format must be yyyy-MM-dd'T'HH:mm:ssZ.  You may also use expression language such as ${file.lastModifiedTime}.
   */
  public static final String LAST_MODIFIED_TIME_PROPERTY = "Last Modified Time";

  /**
   * Sets the permissions on the output file to the value of this attribute.  Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644).  You may also use expression language such as ${file.permissions}.
   */
  public static final String PERMISSIONS_PROPERTY = "Permissions";

  /**
   * Sets the owner on the output file to the value of this attribute.  You may also use expression language such as ${file.owner}.
   */
  public static final String OWNER_PROPERTY = "Owner";

  /**
   * Sets the group on the output file to the value of this attribute.  You may also use expression language such as ${file.group}.
   */
  public static final String GROUP_PROPERTY = "Group";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The directory to which files should be written. You may use expression language such as /aa/bb/${path}
   */
  public final String getDirectory() {
    return properties.get(DIRECTORY_PROPERTY);
  }

  /**
   * The directory to which files should be written. You may use expression language such as /aa/bb/${path}
   */
  public final PutFile setDirectory(final String directory) {
    properties.put(DIRECTORY_PROPERTY, directory);
    return this;
  }

  /**
   * The directory to which files should be written. You may use expression language such as /aa/bb/${path}
   */
  public final PutFile removeDirectory() {
    properties.remove(DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final String getConflictResolutionStrategy() {
    return properties.get(CONFLICT_RESOLUTION_STRATEGY_PROPERTY);
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final PutFile setConflictResolutionStrategy(final String conflictResolutionStrategy) {
    properties.put(CONFLICT_RESOLUTION_STRATEGY_PROPERTY, conflictResolutionStrategy);
    return this;
  }

  /**
   * Indicates what should happen when a file with the same name already exists in the output directory
   */
  public final PutFile removeConflictResolutionStrategy() {
    properties.remove(CONFLICT_RESOLUTION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * If true, then missing destination directories will be created. If false, flowfiles are penalized and sent to failure.
   */
  public final String getCreateMissingDirectories() {
    return properties.get(CREATE_MISSING_DIRECTORIES_PROPERTY);
  }

  /**
   * If true, then missing destination directories will be created. If false, flowfiles are penalized and sent to failure.
   */
  public final PutFile setCreateMissingDirectories(final String createMissingDirectories) {
    properties.put(CREATE_MISSING_DIRECTORIES_PROPERTY, createMissingDirectories);
    return this;
  }

  /**
   * If true, then missing destination directories will be created. If false, flowfiles are penalized and sent to failure.
   */
  public final PutFile removeCreateMissingDirectories() {
    properties.remove(CREATE_MISSING_DIRECTORIES_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum number of files that can exist in the output directory
   */
  public final String getMaximumFileCount() {
    return properties.get(MAXIMUM_FILE_COUNT_PROPERTY);
  }

  /**
   * Specifies the maximum number of files that can exist in the output directory
   */
  public final PutFile setMaximumFileCount(final String maximumFileCount) {
    properties.put(MAXIMUM_FILE_COUNT_PROPERTY, maximumFileCount);
    return this;
  }

  /**
   * Specifies the maximum number of files that can exist in the output directory
   */
  public final PutFile removeMaximumFileCount() {
    properties.remove(MAXIMUM_FILE_COUNT_PROPERTY);
    return this;
  }

  /**
   * Sets the lastModifiedTime on the output file to the value of this attribute.  Format must be yyyy-MM-dd'T'HH:mm:ssZ.  You may also use expression language such as ${file.lastModifiedTime}.
   */
  public final String getLastModifiedTime() {
    return properties.get(LAST_MODIFIED_TIME_PROPERTY);
  }

  /**
   * Sets the lastModifiedTime on the output file to the value of this attribute.  Format must be yyyy-MM-dd'T'HH:mm:ssZ.  You may also use expression language such as ${file.lastModifiedTime}.
   */
  public final PutFile setLastModifiedTime(final String lastModifiedTime) {
    properties.put(LAST_MODIFIED_TIME_PROPERTY, lastModifiedTime);
    return this;
  }

  /**
   * Sets the lastModifiedTime on the output file to the value of this attribute.  Format must be yyyy-MM-dd'T'HH:mm:ssZ.  You may also use expression language such as ${file.lastModifiedTime}.
   */
  public final PutFile removeLastModifiedTime() {
    properties.remove(LAST_MODIFIED_TIME_PROPERTY);
    return this;
  }

  /**
   * Sets the permissions on the output file to the value of this attribute.  Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644).  You may also use expression language such as ${file.permissions}.
   */
  public final String getPermissions() {
    return properties.get(PERMISSIONS_PROPERTY);
  }

  /**
   * Sets the permissions on the output file to the value of this attribute.  Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644).  You may also use expression language such as ${file.permissions}.
   */
  public final PutFile setPermissions(final String permissions) {
    properties.put(PERMISSIONS_PROPERTY, permissions);
    return this;
  }

  /**
   * Sets the permissions on the output file to the value of this attribute.  Format must be either UNIX rwxrwxrwx with a - in place of denied permissions (e.g. rw-r--r--) or an octal number (e.g. 644).  You may also use expression language such as ${file.permissions}.
   */
  public final PutFile removePermissions() {
    properties.remove(PERMISSIONS_PROPERTY);
    return this;
  }

  /**
   * Sets the owner on the output file to the value of this attribute.  You may also use expression language such as ${file.owner}.
   */
  public final String getOwner() {
    return properties.get(OWNER_PROPERTY);
  }

  /**
   * Sets the owner on the output file to the value of this attribute.  You may also use expression language such as ${file.owner}.
   */
  public final PutFile setOwner(final String owner) {
    properties.put(OWNER_PROPERTY, owner);
    return this;
  }

  /**
   * Sets the owner on the output file to the value of this attribute.  You may also use expression language such as ${file.owner}.
   */
  public final PutFile removeOwner() {
    properties.remove(OWNER_PROPERTY);
    return this;
  }

  /**
   * Sets the group on the output file to the value of this attribute.  You may also use expression language such as ${file.group}.
   */
  public final String getGroup() {
    return properties.get(GROUP_PROPERTY);
  }

  /**
   * Sets the group on the output file to the value of this attribute.  You may also use expression language such as ${file.group}.
   */
  public final PutFile setGroup(final String group) {
    properties.put(GROUP_PROPERTY, group);
    return this;
  }

  /**
   * Sets the group on the output file to the value of this attribute.  You may also use expression language such as ${file.group}.
   */
  public final PutFile removeGroup() {
    properties.remove(GROUP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutFile, PutFile> configurator) {
    return configurator.apply(new PutFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutFile.class) final Closure<PutFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutFile.class, com.tibtech.nifi.processors.standard.PutFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
