package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MonitorActivity {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.MonitorActivity";

  /**
   * Determines how much time must elapse before considering the flow to be inactive
   */
  public static final String THRESHOLD_DURATION_PROPERTY = "Threshold Duration";

  /**
   * If true, will send inactivity indicator continually every Threshold Duration amount of time until activity is restored; if false, will send an indicator only when the flow first becomes inactive
   */
  public static final String CONTINUALLY_SEND_MESSAGES_PROPERTY = "Continually Send Messages";

  /**
   * The message that will be the content of FlowFiles that are sent to the 'inactive' relationship
   */
  public static final String INACTIVITY_MESSAGE_PROPERTY = "Inactivity Message";

  /**
   * The message that will be the content of FlowFiles that are sent to 'activity.restored' relationship
   */
  public static final String ACTIVITY_RESTORED_MESSAGE_PROPERTY = "Activity Restored Message";

  /**
   * If true, will copy all flow file attributes from the flow file that resumed activity to the newly created indicator flow file
   */
  public static final String COPY_ATTRIBUTES_PROPERTY = "Copy Attributes";

  /**
   * Specify how to determine activeness of the flow. 'node' means that activeness is examined at individual node separately. It can be useful if DFM expects each node should receive flow files in a distributed manner. With 'cluster', it defines the flow is active while at least one node receives flow files actively. If NiFi is running as standalone mode, this should be set as 'node', if it's 'cluster', NiFi logs a warning message and act as 'node' scope.
   */
  public static final String MONITORING_SCOPE_PROPERTY = "Monitoring Scope";

  /**
   * Specify which node should send notification flow-files to inactive and activity.restored relationships. With 'all', every node in this cluster send notification flow-files. 'primary' means flow-files will be sent only from a primary node. If NiFi is running as standalone mode, this should be set as 'all', even if it's 'primary', NiFi act as 'all'.
   */
  public static final String REPORTING_NODE_PROPERTY = "Reporting Node";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Determines how much time must elapse before considering the flow to be inactive
   */
  public final String getThresholdDuration() {
    return properties.get(THRESHOLD_DURATION_PROPERTY);
  }

  /**
   * Determines how much time must elapse before considering the flow to be inactive
   */
  public final MonitorActivity setThresholdDuration(final String thresholdDuration) {
    properties.put(THRESHOLD_DURATION_PROPERTY, thresholdDuration);
    return this;
  }

  /**
   * Determines how much time must elapse before considering the flow to be inactive
   */
  public final MonitorActivity removeThresholdDuration() {
    properties.remove(THRESHOLD_DURATION_PROPERTY);
    return this;
  }

  /**
   * If true, will send inactivity indicator continually every Threshold Duration amount of time until activity is restored; if false, will send an indicator only when the flow first becomes inactive
   */
  public final String getContinuallySendMessages() {
    return properties.get(CONTINUALLY_SEND_MESSAGES_PROPERTY);
  }

  /**
   * If true, will send inactivity indicator continually every Threshold Duration amount of time until activity is restored; if false, will send an indicator only when the flow first becomes inactive
   */
  public final MonitorActivity setContinuallySendMessages(final String continuallySendMessages) {
    properties.put(CONTINUALLY_SEND_MESSAGES_PROPERTY, continuallySendMessages);
    return this;
  }

  /**
   * If true, will send inactivity indicator continually every Threshold Duration amount of time until activity is restored; if false, will send an indicator only when the flow first becomes inactive
   */
  public final MonitorActivity removeContinuallySendMessages() {
    properties.remove(CONTINUALLY_SEND_MESSAGES_PROPERTY);
    return this;
  }

  /**
   * The message that will be the content of FlowFiles that are sent to the 'inactive' relationship
   */
  public final String getInactivityMessage() {
    return properties.get(INACTIVITY_MESSAGE_PROPERTY);
  }

  /**
   * The message that will be the content of FlowFiles that are sent to the 'inactive' relationship
   */
  public final MonitorActivity setInactivityMessage(final String inactivityMessage) {
    properties.put(INACTIVITY_MESSAGE_PROPERTY, inactivityMessage);
    return this;
  }

  /**
   * The message that will be the content of FlowFiles that are sent to the 'inactive' relationship
   */
  public final MonitorActivity removeInactivityMessage() {
    properties.remove(INACTIVITY_MESSAGE_PROPERTY);
    return this;
  }

  /**
   * The message that will be the content of FlowFiles that are sent to 'activity.restored' relationship
   */
  public final String getActivityRestoredMessage() {
    return properties.get(ACTIVITY_RESTORED_MESSAGE_PROPERTY);
  }

  /**
   * The message that will be the content of FlowFiles that are sent to 'activity.restored' relationship
   */
  public final MonitorActivity setActivityRestoredMessage(final String activityRestoredMessage) {
    properties.put(ACTIVITY_RESTORED_MESSAGE_PROPERTY, activityRestoredMessage);
    return this;
  }

  /**
   * The message that will be the content of FlowFiles that are sent to 'activity.restored' relationship
   */
  public final MonitorActivity removeActivityRestoredMessage() {
    properties.remove(ACTIVITY_RESTORED_MESSAGE_PROPERTY);
    return this;
  }

  /**
   * If true, will copy all flow file attributes from the flow file that resumed activity to the newly created indicator flow file
   */
  public final String getCopyAttributes() {
    return properties.get(COPY_ATTRIBUTES_PROPERTY);
  }

  /**
   * If true, will copy all flow file attributes from the flow file that resumed activity to the newly created indicator flow file
   */
  public final MonitorActivity setCopyAttributes(final String copyAttributes) {
    properties.put(COPY_ATTRIBUTES_PROPERTY, copyAttributes);
    return this;
  }

  /**
   * If true, will copy all flow file attributes from the flow file that resumed activity to the newly created indicator flow file
   */
  public final MonitorActivity removeCopyAttributes() {
    properties.remove(COPY_ATTRIBUTES_PROPERTY);
    return this;
  }

  /**
   * Specify how to determine activeness of the flow. 'node' means that activeness is examined at individual node separately. It can be useful if DFM expects each node should receive flow files in a distributed manner. With 'cluster', it defines the flow is active while at least one node receives flow files actively. If NiFi is running as standalone mode, this should be set as 'node', if it's 'cluster', NiFi logs a warning message and act as 'node' scope.
   */
  public final String getMonitoringScope() {
    return properties.get(MONITORING_SCOPE_PROPERTY);
  }

  /**
   * Specify how to determine activeness of the flow. 'node' means that activeness is examined at individual node separately. It can be useful if DFM expects each node should receive flow files in a distributed manner. With 'cluster', it defines the flow is active while at least one node receives flow files actively. If NiFi is running as standalone mode, this should be set as 'node', if it's 'cluster', NiFi logs a warning message and act as 'node' scope.
   */
  public final MonitorActivity setMonitoringScope(final String monitoringScope) {
    properties.put(MONITORING_SCOPE_PROPERTY, monitoringScope);
    return this;
  }

  /**
   * Specify how to determine activeness of the flow. 'node' means that activeness is examined at individual node separately. It can be useful if DFM expects each node should receive flow files in a distributed manner. With 'cluster', it defines the flow is active while at least one node receives flow files actively. If NiFi is running as standalone mode, this should be set as 'node', if it's 'cluster', NiFi logs a warning message and act as 'node' scope.
   */
  public final MonitorActivity removeMonitoringScope() {
    properties.remove(MONITORING_SCOPE_PROPERTY);
    return this;
  }

  /**
   * Specify which node should send notification flow-files to inactive and activity.restored relationships. With 'all', every node in this cluster send notification flow-files. 'primary' means flow-files will be sent only from a primary node. If NiFi is running as standalone mode, this should be set as 'all', even if it's 'primary', NiFi act as 'all'.
   */
  public final String getReportingNode() {
    return properties.get(REPORTING_NODE_PROPERTY);
  }

  /**
   * Specify which node should send notification flow-files to inactive and activity.restored relationships. With 'all', every node in this cluster send notification flow-files. 'primary' means flow-files will be sent only from a primary node. If NiFi is running as standalone mode, this should be set as 'all', even if it's 'primary', NiFi act as 'all'.
   */
  public final MonitorActivity setReportingNode(final String reportingNode) {
    properties.put(REPORTING_NODE_PROPERTY, reportingNode);
    return this;
  }

  /**
   * Specify which node should send notification flow-files to inactive and activity.restored relationships. With 'all', every node in this cluster send notification flow-files. 'primary' means flow-files will be sent only from a primary node. If NiFi is running as standalone mode, this should be set as 'all', even if it's 'primary', NiFi act as 'all'.
   */
  public final MonitorActivity removeReportingNode() {
    properties.remove(REPORTING_NODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MonitorActivity setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MonitorActivity removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<MonitorActivity, MonitorActivity> configurator) {
    return configurator.apply(new MonitorActivity()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MonitorActivity.class) final Closure<MonitorActivity> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.MonitorActivity> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.MonitorActivity.class, com.tibtech.nifi.processors.standard.MonitorActivity.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
