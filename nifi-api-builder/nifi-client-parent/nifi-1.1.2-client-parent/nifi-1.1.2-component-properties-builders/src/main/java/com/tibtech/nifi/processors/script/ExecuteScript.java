package com.tibtech.nifi.processors.script;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteScript {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.script.ExecuteScript";

  /**
   * The engine to execute scripts
   */
  public static final String SCRIPT_ENGINE_PROPERTY = "Script Engine";

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public static final String SCRIPT_FILE_PROPERTY = "Script File";

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public static final String SCRIPT_BODY_PROPERTY = "Script Body";

  /**
   * Comma-separated list of paths to files and/or directories which contain modules required by the script.
   */
  public static final String MODULE_DIRECTORY_PROPERTY = "Module Directory";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The engine to execute scripts
   */
  public final String getScriptEngine() {
    return properties.get(SCRIPT_ENGINE_PROPERTY);
  }

  /**
   * The engine to execute scripts
   */
  public final ExecuteScript setScriptEngine(final String scriptEngine) {
    properties.put(SCRIPT_ENGINE_PROPERTY, scriptEngine);
    return this;
  }

  /**
   * The engine to execute scripts
   */
  public final ExecuteScript removeScriptEngine() {
    properties.remove(SCRIPT_ENGINE_PROPERTY);
    return this;
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final String getScriptFile() {
    return properties.get(SCRIPT_FILE_PROPERTY);
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteScript setScriptFile(final String scriptFile) {
    properties.put(SCRIPT_FILE_PROPERTY, scriptFile);
    return this;
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteScript removeScriptFile() {
    properties.remove(SCRIPT_FILE_PROPERTY);
    return this;
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final String getScriptBody() {
    return properties.get(SCRIPT_BODY_PROPERTY);
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteScript setScriptBody(final String scriptBody) {
    properties.put(SCRIPT_BODY_PROPERTY, scriptBody);
    return this;
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteScript removeScriptBody() {
    properties.remove(SCRIPT_BODY_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules required by the script.
   */
  public final String getModuleDirectory() {
    return properties.get(MODULE_DIRECTORY_PROPERTY);
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules required by the script.
   */
  public final ExecuteScript setModuleDirectory(final String moduleDirectory) {
    properties.put(MODULE_DIRECTORY_PROPERTY, moduleDirectory);
    return this;
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules required by the script.
   */
  public final ExecuteScript removeModuleDirectory() {
    properties.remove(MODULE_DIRECTORY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteScript setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteScript removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ExecuteScript, ExecuteScript> configurator) {
    return configurator.apply(new ExecuteScript()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteScript.class) final Closure<ExecuteScript> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.script.ExecuteScript> code = closure.rehydrate(c, com.tibtech.nifi.processors.script.ExecuteScript.class, com.tibtech.nifi.processors.script.ExecuteScript.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
