package com.tibtech.nifi.lookup.script;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ScriptedLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.script.ScriptedLookupService";

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

  private final Map<String, String> properties;

  public ScriptedLookupService() {
    this.properties = new HashMap<>();
  }

  public ScriptedLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The engine to execute scripts
   */
  public final String getScriptEngine() {
    return properties.get(SCRIPT_ENGINE_PROPERTY);
  }

  /**
   * The engine to execute scripts
   */
  public final ScriptedLookupService setScriptEngine(final String scriptEngine) {
    properties.put(SCRIPT_ENGINE_PROPERTY, scriptEngine);
    return this;
  }

  /**
   * The engine to execute scripts
   */
  public final ScriptedLookupService removeScriptEngine() {
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
  public final ScriptedLookupService setScriptFile(final String scriptFile) {
    properties.put(SCRIPT_FILE_PROPERTY, scriptFile);
    return this;
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final ScriptedLookupService removeScriptFile() {
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
  public final ScriptedLookupService setScriptBody(final String scriptBody) {
    properties.put(SCRIPT_BODY_PROPERTY, scriptBody);
    return this;
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final ScriptedLookupService removeScriptBody() {
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
  public final ScriptedLookupService setModuleDirectory(final String moduleDirectory) {
    properties.put(MODULE_DIRECTORY_PROPERTY, moduleDirectory);
    return this;
  }

  /**
   * Comma-separated list of paths to files and/or directories which contain modules required by the script.
   */
  public final ScriptedLookupService removeModuleDirectory() {
    properties.remove(MODULE_DIRECTORY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ScriptedLookupService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ScriptedLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ScriptedLookupService, ScriptedLookupService> configurator) {
    return configurator.apply(new ScriptedLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScriptedLookupService.class) final Closure<ScriptedLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.script.ScriptedLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.script.ScriptedLookupService.class, com.tibtech.nifi.lookup.script.ScriptedLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ScriptedLookupService, ScriptedLookupService> configurator) {
    return configurator.apply(new ScriptedLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScriptedLookupService.class) final Closure<ScriptedLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.script.ScriptedLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.script.ScriptedLookupService.class, com.tibtech.nifi.lookup.script.ScriptedLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
