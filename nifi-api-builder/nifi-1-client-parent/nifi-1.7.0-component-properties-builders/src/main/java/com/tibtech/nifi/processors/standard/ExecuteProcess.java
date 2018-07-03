package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteProcess {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ExecuteProcess";

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public static final String COMMAND_PROPERTY = "Command";

  /**
   * The arguments to supply to the executable delimited by white space. White space can be escaped by enclosing it in double-quotes.
   */
  public static final String COMMAND_ARGUMENTS_PROPERTY = "Command Arguments";

  /**
   * If the process is expected to be long-running and produce textual output, a batch duration can be specified so that the output will be captured for this amount of time and a FlowFile will then be sent out with the results and a new FlowFile will be started, rather than waiting for the process to finish before sending out the results
   */
  public static final String BATCH_DURATION_PROPERTY = "Batch Duration";

  /**
   * If true will redirect any error stream output of the process to the output stream. This is particularly helpful for processes which write extensively to the error stream or for troubleshooting.
   */
  public static final String REDIRECT_ERROR_STREAM_PROPERTY = "Redirect Error Stream";

  /**
   * The directory to use as the current working directory when executing the command
   */
  public static final String WORKING_DIRECTORY_PROPERTY = "Working Directory";

  /**
   * Delimiter to use to separate arguments for a command [default: space]. Must be a single character.
   */
  public static final String ARGUMENT_DELIMITER_PROPERTY = "Argument Delimiter";

  private final Map<String, String> properties;

  public ExecuteProcess() {
    this.properties = new HashMap<>();
  }

  public ExecuteProcess(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public final String getCommand() {
    return properties.get(COMMAND_PROPERTY);
  }

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public final ExecuteProcess setCommand(final String command) {
    properties.put(COMMAND_PROPERTY, command);
    return this;
  }

  /**
   * Specifies the command to be executed; if just the name of an executable is provided, it must be in the user's environment PATH.
   */
  public final ExecuteProcess removeCommand() {
    properties.remove(COMMAND_PROPERTY);
    return this;
  }

  /**
   * The arguments to supply to the executable delimited by white space. White space can be escaped by enclosing it in double-quotes.
   */
  public final String getCommandArguments() {
    return properties.get(COMMAND_ARGUMENTS_PROPERTY);
  }

  /**
   * The arguments to supply to the executable delimited by white space. White space can be escaped by enclosing it in double-quotes.
   */
  public final ExecuteProcess setCommandArguments(final String commandArguments) {
    properties.put(COMMAND_ARGUMENTS_PROPERTY, commandArguments);
    return this;
  }

  /**
   * The arguments to supply to the executable delimited by white space. White space can be escaped by enclosing it in double-quotes.
   */
  public final ExecuteProcess removeCommandArguments() {
    properties.remove(COMMAND_ARGUMENTS_PROPERTY);
    return this;
  }

  /**
   * If the process is expected to be long-running and produce textual output, a batch duration can be specified so that the output will be captured for this amount of time and a FlowFile will then be sent out with the results and a new FlowFile will be started, rather than waiting for the process to finish before sending out the results
   */
  public final String getBatchDuration() {
    return properties.get(BATCH_DURATION_PROPERTY);
  }

  /**
   * If the process is expected to be long-running and produce textual output, a batch duration can be specified so that the output will be captured for this amount of time and a FlowFile will then be sent out with the results and a new FlowFile will be started, rather than waiting for the process to finish before sending out the results
   */
  public final ExecuteProcess setBatchDuration(final String batchDuration) {
    properties.put(BATCH_DURATION_PROPERTY, batchDuration);
    return this;
  }

  /**
   * If the process is expected to be long-running and produce textual output, a batch duration can be specified so that the output will be captured for this amount of time and a FlowFile will then be sent out with the results and a new FlowFile will be started, rather than waiting for the process to finish before sending out the results
   */
  public final ExecuteProcess removeBatchDuration() {
    properties.remove(BATCH_DURATION_PROPERTY);
    return this;
  }

  /**
   * If true will redirect any error stream output of the process to the output stream. This is particularly helpful for processes which write extensively to the error stream or for troubleshooting.
   */
  public final String getRedirectErrorStream() {
    return properties.get(REDIRECT_ERROR_STREAM_PROPERTY);
  }

  /**
   * If true will redirect any error stream output of the process to the output stream. This is particularly helpful for processes which write extensively to the error stream or for troubleshooting.
   */
  public final ExecuteProcess setRedirectErrorStream(final String redirectErrorStream) {
    properties.put(REDIRECT_ERROR_STREAM_PROPERTY, redirectErrorStream);
    return this;
  }

  /**
   * If true will redirect any error stream output of the process to the output stream. This is particularly helpful for processes which write extensively to the error stream or for troubleshooting.
   */
  public final ExecuteProcess removeRedirectErrorStream() {
    properties.remove(REDIRECT_ERROR_STREAM_PROPERTY);
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
  public final ExecuteProcess setWorkingDirectory(final String workingDirectory) {
    properties.put(WORKING_DIRECTORY_PROPERTY, workingDirectory);
    return this;
  }

  /**
   * The directory to use as the current working directory when executing the command
   */
  public final ExecuteProcess removeWorkingDirectory() {
    properties.remove(WORKING_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * Delimiter to use to separate arguments for a command [default: space]. Must be a single character.
   */
  public final String getArgumentDelimiter() {
    return properties.get(ARGUMENT_DELIMITER_PROPERTY);
  }

  /**
   * Delimiter to use to separate arguments for a command [default: space]. Must be a single character.
   */
  public final ExecuteProcess setArgumentDelimiter(final String argumentDelimiter) {
    properties.put(ARGUMENT_DELIMITER_PROPERTY, argumentDelimiter);
    return this;
  }

  /**
   * Delimiter to use to separate arguments for a command [default: space]. Must be a single character.
   */
  public final ExecuteProcess removeArgumentDelimiter() {
    properties.remove(ARGUMENT_DELIMITER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteProcess setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteProcess removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteProcess, ExecuteProcess> configurator) {
    return configurator.apply(new ExecuteProcess()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteProcess.class) final Closure<ExecuteProcess> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExecuteProcess> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExecuteProcess.class, com.tibtech.nifi.processors.standard.ExecuteProcess.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteProcess, ExecuteProcess> configurator) {
    return configurator.apply(new ExecuteProcess(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteProcess.class) final Closure<ExecuteProcess> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExecuteProcess> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExecuteProcess.class, com.tibtech.nifi.processors.standard.ExecuteProcess.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
