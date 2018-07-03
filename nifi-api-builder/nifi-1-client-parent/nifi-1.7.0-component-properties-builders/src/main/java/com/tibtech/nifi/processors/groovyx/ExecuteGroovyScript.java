package com.tibtech.nifi.processors.groovyx;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteGroovyScript {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.groovyx.ExecuteGroovyScript";

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public static final String GROOVYX_SCRIPT_FILE_PROPERTY = "groovyx-script-file";

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public static final String GROOVYX_SCRIPT_BODY_PROPERTY = "groovyx-script-body";

  /**
   * What to do with unhandled exceptions. If you want to manage exception by code then keep the default value `rollback`. If `transfer to failure` selected and unhandled exception occurred then all flowFiles received from incoming queues in this session will be transferred to `failure` relationship with additional attributes set: ERROR_MESSAGE and ERROR_STACKTRACE. If `rollback` selected and unhandled exception occurred then all flowFiles received from incoming queues will be penalized and returned. If the processor has no incoming connections then this parameter has no effect.
   */
  public static final String GROOVYX_FAILURE_STRATEGY_PROPERTY = "groovyx-failure-strategy";

  /**
   * Classpath list separated by semicolon. You can use masks like `*`, `*.jar` in file name.
   */
  public static final String GROOVYX_ADDITIONAL_CLASSPATH_PROPERTY = "groovyx-additional-classpath";

  private final Map<String, String> properties;

  public ExecuteGroovyScript() {
    this.properties = new HashMap<>();
  }

  public ExecuteGroovyScript(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final String getGroovyxScriptFile() {
    return properties.get(GROOVYX_SCRIPT_FILE_PROPERTY);
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteGroovyScript setGroovyxScriptFile(final String groovyxScriptFile) {
    properties.put(GROOVYX_SCRIPT_FILE_PROPERTY, groovyxScriptFile);
    return this;
  }

  /**
   * Path to script file to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteGroovyScript removeGroovyxScriptFile() {
    properties.remove(GROOVYX_SCRIPT_FILE_PROPERTY);
    return this;
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final String getGroovyxScriptBody() {
    return properties.get(GROOVYX_SCRIPT_BODY_PROPERTY);
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteGroovyScript setGroovyxScriptBody(final String groovyxScriptBody) {
    properties.put(GROOVYX_SCRIPT_BODY_PROPERTY, groovyxScriptBody);
    return this;
  }

  /**
   * Body of script to execute. Only one of Script File or Script Body may be used
   */
  public final ExecuteGroovyScript removeGroovyxScriptBody() {
    properties.remove(GROOVYX_SCRIPT_BODY_PROPERTY);
    return this;
  }

  /**
   * What to do with unhandled exceptions. If you want to manage exception by code then keep the default value `rollback`. If `transfer to failure` selected and unhandled exception occurred then all flowFiles received from incoming queues in this session will be transferred to `failure` relationship with additional attributes set: ERROR_MESSAGE and ERROR_STACKTRACE. If `rollback` selected and unhandled exception occurred then all flowFiles received from incoming queues will be penalized and returned. If the processor has no incoming connections then this parameter has no effect.
   */
  public final String getGroovyxFailureStrategy() {
    return properties.get(GROOVYX_FAILURE_STRATEGY_PROPERTY);
  }

  /**
   * What to do with unhandled exceptions. If you want to manage exception by code then keep the default value `rollback`. If `transfer to failure` selected and unhandled exception occurred then all flowFiles received from incoming queues in this session will be transferred to `failure` relationship with additional attributes set: ERROR_MESSAGE and ERROR_STACKTRACE. If `rollback` selected and unhandled exception occurred then all flowFiles received from incoming queues will be penalized and returned. If the processor has no incoming connections then this parameter has no effect.
   */
  public final ExecuteGroovyScript setGroovyxFailureStrategy(final String groovyxFailureStrategy) {
    properties.put(GROOVYX_FAILURE_STRATEGY_PROPERTY, groovyxFailureStrategy);
    return this;
  }

  /**
   * What to do with unhandled exceptions. If you want to manage exception by code then keep the default value `rollback`. If `transfer to failure` selected and unhandled exception occurred then all flowFiles received from incoming queues in this session will be transferred to `failure` relationship with additional attributes set: ERROR_MESSAGE and ERROR_STACKTRACE. If `rollback` selected and unhandled exception occurred then all flowFiles received from incoming queues will be penalized and returned. If the processor has no incoming connections then this parameter has no effect.
   */
  public final ExecuteGroovyScript removeGroovyxFailureStrategy() {
    properties.remove(GROOVYX_FAILURE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Classpath list separated by semicolon. You can use masks like `*`, `*.jar` in file name.
   */
  public final String getGroovyxAdditionalClasspath() {
    return properties.get(GROOVYX_ADDITIONAL_CLASSPATH_PROPERTY);
  }

  /**
   * Classpath list separated by semicolon. You can use masks like `*`, `*.jar` in file name.
   */
  public final ExecuteGroovyScript setGroovyxAdditionalClasspath(
      final String groovyxAdditionalClasspath) {
    properties.put(GROOVYX_ADDITIONAL_CLASSPATH_PROPERTY, groovyxAdditionalClasspath);
    return this;
  }

  /**
   * Classpath list separated by semicolon. You can use masks like `*`, `*.jar` in file name.
   */
  public final ExecuteGroovyScript removeGroovyxAdditionalClasspath() {
    properties.remove(GROOVYX_ADDITIONAL_CLASSPATH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteGroovyScript setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteGroovyScript removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteGroovyScript, ExecuteGroovyScript> configurator) {
    return configurator.apply(new ExecuteGroovyScript()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteGroovyScript.class) final Closure<ExecuteGroovyScript> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.groovyx.ExecuteGroovyScript> code = closure.rehydrate(c, com.tibtech.nifi.processors.groovyx.ExecuteGroovyScript.class, com.tibtech.nifi.processors.groovyx.ExecuteGroovyScript.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteGroovyScript, ExecuteGroovyScript> configurator) {
    return configurator.apply(new ExecuteGroovyScript(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteGroovyScript.class) final Closure<ExecuteGroovyScript> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.groovyx.ExecuteGroovyScript> code = closure.rehydrate(c, com.tibtech.nifi.processors.groovyx.ExecuteGroovyScript.class, com.tibtech.nifi.processors.groovyx.ExecuteGroovyScript.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
