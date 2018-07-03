package com.tibtech.nifi.processors.livy;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteSparkInteractive {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.livy.ExecuteSparkInteractive";

  /**
   * The controller service to use for Livy-managed session(s).
   */
  public static final String EXEC_SPARK_IACTIVE_LIVY_CONTROLLER_SERVICE_PROPERTY = "exec-spark-iactive-livy-controller-service";

  /**
   * The code to execute in the session. This property can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain valid code to be issued by the processor to the session. Note that Expression Language is not evaluated for flow file contents.
   */
  public static final String EXEC_SPARK_IACTIVE_CODE_PROPERTY = "exec-spark-iactive-code";

  /**
   * The character set encoding for the incoming flow file.
   */
  public static final String EXEC_SPARK_IACTIVE_CHARSET_PROPERTY = "exec-spark-iactive-charset";

  /**
   * The amount of time to wait between checking the status of an operation.
   */
  public static final String EXEC_SPARK_IACTIVE_STATUS_CHECK_INTERVAL_PROPERTY = "exec-spark-iactive-status-check-interval";

  private final Map<String, String> properties;

  public ExecuteSparkInteractive() {
    this.properties = new HashMap<>();
  }

  public ExecuteSparkInteractive(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The controller service to use for Livy-managed session(s).
   */
  public final String getExecSparkIactiveLivyControllerService() {
    return properties.get(EXEC_SPARK_IACTIVE_LIVY_CONTROLLER_SERVICE_PROPERTY);
  }

  /**
   * The controller service to use for Livy-managed session(s).
   */
  public final ExecuteSparkInteractive setExecSparkIactiveLivyControllerService(
      final String execSparkIactiveLivyControllerService) {
    properties.put(EXEC_SPARK_IACTIVE_LIVY_CONTROLLER_SERVICE_PROPERTY, execSparkIactiveLivyControllerService);
    return this;
  }

  /**
   * The controller service to use for Livy-managed session(s).
   */
  public final ExecuteSparkInteractive removeExecSparkIactiveLivyControllerService() {
    properties.remove(EXEC_SPARK_IACTIVE_LIVY_CONTROLLER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The code to execute in the session. This property can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain valid code to be issued by the processor to the session. Note that Expression Language is not evaluated for flow file contents.
   */
  public final String getExecSparkIactiveCode() {
    return properties.get(EXEC_SPARK_IACTIVE_CODE_PROPERTY);
  }

  /**
   * The code to execute in the session. This property can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain valid code to be issued by the processor to the session. Note that Expression Language is not evaluated for flow file contents.
   */
  public final ExecuteSparkInteractive setExecSparkIactiveCode(final String execSparkIactiveCode) {
    properties.put(EXEC_SPARK_IACTIVE_CODE_PROPERTY, execSparkIactiveCode);
    return this;
  }

  /**
   * The code to execute in the session. This property can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain valid code to be issued by the processor to the session. Note that Expression Language is not evaluated for flow file contents.
   */
  public final ExecuteSparkInteractive removeExecSparkIactiveCode() {
    properties.remove(EXEC_SPARK_IACTIVE_CODE_PROPERTY);
    return this;
  }

  /**
   * The character set encoding for the incoming flow file.
   */
  public final String getExecSparkIactiveCharset() {
    return properties.get(EXEC_SPARK_IACTIVE_CHARSET_PROPERTY);
  }

  /**
   * The character set encoding for the incoming flow file.
   */
  public final ExecuteSparkInteractive setExecSparkIactiveCharset(
      final String execSparkIactiveCharset) {
    properties.put(EXEC_SPARK_IACTIVE_CHARSET_PROPERTY, execSparkIactiveCharset);
    return this;
  }

  /**
   * The character set encoding for the incoming flow file.
   */
  public final ExecuteSparkInteractive removeExecSparkIactiveCharset() {
    properties.remove(EXEC_SPARK_IACTIVE_CHARSET_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait between checking the status of an operation.
   */
  public final String getExecSparkIactiveStatusCheckInterval() {
    return properties.get(EXEC_SPARK_IACTIVE_STATUS_CHECK_INTERVAL_PROPERTY);
  }

  /**
   * The amount of time to wait between checking the status of an operation.
   */
  public final ExecuteSparkInteractive setExecSparkIactiveStatusCheckInterval(
      final String execSparkIactiveStatusCheckInterval) {
    properties.put(EXEC_SPARK_IACTIVE_STATUS_CHECK_INTERVAL_PROPERTY, execSparkIactiveStatusCheckInterval);
    return this;
  }

  /**
   * The amount of time to wait between checking the status of an operation.
   */
  public final ExecuteSparkInteractive removeExecSparkIactiveStatusCheckInterval() {
    properties.remove(EXEC_SPARK_IACTIVE_STATUS_CHECK_INTERVAL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteSparkInteractive setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteSparkInteractive removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteSparkInteractive, ExecuteSparkInteractive> configurator) {
    return configurator.apply(new ExecuteSparkInteractive()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteSparkInteractive.class) final Closure<ExecuteSparkInteractive> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.livy.ExecuteSparkInteractive> code = closure.rehydrate(c, com.tibtech.nifi.processors.livy.ExecuteSparkInteractive.class, com.tibtech.nifi.processors.livy.ExecuteSparkInteractive.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteSparkInteractive, ExecuteSparkInteractive> configurator) {
    return configurator.apply(new ExecuteSparkInteractive(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteSparkInteractive.class) final Closure<ExecuteSparkInteractive> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.livy.ExecuteSparkInteractive> code = closure.rehydrate(c, com.tibtech.nifi.processors.livy.ExecuteSparkInteractive.class, com.tibtech.nifi.processors.livy.ExecuteSparkInteractive.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
