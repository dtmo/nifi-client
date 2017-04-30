package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteStreamCommand {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ExecuteStreamCommand";

  /**
   * The arguments to supply to the executable delimited by the ';' character.
   */
  public static final String COMMAND_ARGUMENTS_PROPERTY = "Command Arguments";

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public static final String COMMAND_PATH_PROPERTY = "Command Path";

  /**
   * If true, the contents of the incoming flowfile will not be passed to the executing command
   */
  public static final String IGNORE_STDIN_PROPERTY = "Ignore STDIN";

  /**
   * The directory to use as the current working directory when executing the command
   */
  public static final String WORKING_DIRECTORY_PROPERTY = "Working Directory";

  /**
   * Delimiter to use to separate arguments for a command [default: ;]. Must be a single character
   */
  public static final String ARGUMENT_DELIMITER_PROPERTY = "Argument Delimiter";

  /**
   * If set, the output of the stream command will be put into an attribute of the original FlowFile instead of a separate FlowFile. There will no longer be a relationship for 'output stream'. The value of this property will be the key for the output attribute.
   */
  public static final String OUTPUT_DESTINATION_ATTRIBUTE_PROPERTY = "Output Destination Attribute";

  /**
   * If routing the output of the stream command to an attribute, the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will truncated to fit. Consider making this smaller if able.
   */
  public static final String MAX_ATTRIBUTE_LENGTH_PROPERTY = "Max Attribute Length";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The arguments to supply to the executable delimited by the ';' character.
   */
  public final String getCommandArguments() {
    return properties.get(COMMAND_ARGUMENTS_PROPERTY);
  }

  /**
   * The arguments to supply to the executable delimited by the ';' character.
   */
  public final ExecuteStreamCommand setCommandArguments(final String commandArguments) {
    properties.put(COMMAND_ARGUMENTS_PROPERTY, commandArguments);
    return this;
  }

  /**
   * The arguments to supply to the executable delimited by the ';' character.
   */
  public final ExecuteStreamCommand removeCommandArguments() {
    properties.remove(COMMAND_ARGUMENTS_PROPERTY);
    return this;
  }

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public final String getCommandPath() {
    return properties.get(COMMAND_PATH_PROPERTY);
  }

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public final ExecuteStreamCommand setCommandPath(final String commandPath) {
    properties.put(COMMAND_PATH_PROPERTY, commandPath);
    return this;
  }

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public final ExecuteStreamCommand removeCommandPath() {
    properties.remove(COMMAND_PATH_PROPERTY);
    return this;
  }

  /**
   * If true, the contents of the incoming flowfile will not be passed to the executing command
   */
  public final String getIgnoreStdin() {
    return properties.get(IGNORE_STDIN_PROPERTY);
  }

  /**
   * If true, the contents of the incoming flowfile will not be passed to the executing command
   */
  public final ExecuteStreamCommand setIgnoreStdin(final String ignoreStdin) {
    properties.put(IGNORE_STDIN_PROPERTY, ignoreStdin);
    return this;
  }

  /**
   * If true, the contents of the incoming flowfile will not be passed to the executing command
   */
  public final ExecuteStreamCommand removeIgnoreStdin() {
    properties.remove(IGNORE_STDIN_PROPERTY);
    return this;
  }

  /**
   * The directory to use as the current working directory when executing the command
   */
  public final String getWorkingDirectory() {
    return properties.get(WORKING_DIRECTORY_PROPERTY);
  }

  /**
   * The directory to use as the current working directory when executing the command
   */
  public final ExecuteStreamCommand setWorkingDirectory(final String workingDirectory) {
    properties.put(WORKING_DIRECTORY_PROPERTY, workingDirectory);
    return this;
  }

  /**
   * The directory to use as the current working directory when executing the command
   */
  public final ExecuteStreamCommand removeWorkingDirectory() {
    properties.remove(WORKING_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Delimiter to use to separate arguments for a command [default: ;]. Must be a single character
   */
  public final String getArgumentDelimiter() {
    return properties.get(ARGUMENT_DELIMITER_PROPERTY);
  }

  /**
   * Delimiter to use to separate arguments for a command [default: ;]. Must be a single character
   */
  public final ExecuteStreamCommand setArgumentDelimiter(final String argumentDelimiter) {
    properties.put(ARGUMENT_DELIMITER_PROPERTY, argumentDelimiter);
    return this;
  }

  /**
   * Delimiter to use to separate arguments for a command [default: ;]. Must be a single character
   */
  public final ExecuteStreamCommand removeArgumentDelimiter() {
    properties.remove(ARGUMENT_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * If set, the output of the stream command will be put into an attribute of the original FlowFile instead of a separate FlowFile. There will no longer be a relationship for 'output stream'. The value of this property will be the key for the output attribute.
   */
  public final String getOutputDestinationAttribute() {
    return properties.get(OUTPUT_DESTINATION_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the output of the stream command will be put into an attribute of the original FlowFile instead of a separate FlowFile. There will no longer be a relationship for 'output stream'. The value of this property will be the key for the output attribute.
   */
  public final ExecuteStreamCommand setOutputDestinationAttribute(final String outputDestinationAttribute) {
    properties.put(OUTPUT_DESTINATION_ATTRIBUTE_PROPERTY, outputDestinationAttribute);
    return this;
  }

  /**
   * If set, the output of the stream command will be put into an attribute of the original FlowFile instead of a separate FlowFile. There will no longer be a relationship for 'output stream'. The value of this property will be the key for the output attribute.
   */
  public final ExecuteStreamCommand removeOutputDestinationAttribute() {
    properties.remove(OUTPUT_DESTINATION_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * If routing the output of the stream command to an attribute, the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will truncated to fit. Consider making this smaller if able.
   */
  public final String getMaxAttributeLength() {
    return properties.get(MAX_ATTRIBUTE_LENGTH_PROPERTY);
  }

  /**
   * If routing the output of the stream command to an attribute, the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will truncated to fit. Consider making this smaller if able.
   */
  public final ExecuteStreamCommand setMaxAttributeLength(final String maxAttributeLength) {
    properties.put(MAX_ATTRIBUTE_LENGTH_PROPERTY, maxAttributeLength);
    return this;
  }

  /**
   * If routing the output of the stream command to an attribute, the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will truncated to fit. Consider making this smaller if able.
   */
  public final ExecuteStreamCommand removeMaxAttributeLength() {
    properties.remove(MAX_ATTRIBUTE_LENGTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteStreamCommand setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteStreamCommand removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ExecuteStreamCommand, ExecuteStreamCommand> configurator) {
    return configurator.apply(new ExecuteStreamCommand()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteStreamCommand.class) final Closure<ExecuteStreamCommand> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExecuteStreamCommand> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExecuteStreamCommand.class, com.tibtech.nifi.processors.standard.ExecuteStreamCommand.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
