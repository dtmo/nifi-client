package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DebugFlow {
  /**
   * Number of FlowFiles to forward to success relationship.
   */
  public static final String FLOW_FILE_SUCCESS_ITERATIONS_PROPERTY = "FlowFile Success Iterations";

  /**
   * Number of FlowFiles to forward to failure relationship.
   */
  public static final String FLOW_FILE_FAILURE_ITERATIONS_PROPERTY = "FlowFile Failure Iterations";

  /**
   * Number of FlowFiles to roll back (without penalty).
   */
  public static final String FLOW_FILE_ROLLBACK_ITERATIONS_PROPERTY = "FlowFile Rollback Iterations";

  /**
   * Number of FlowFiles to roll back and yield.
   */
  public static final String FLOW_FILE_ROLLBACK_YIELD_ITERATIONS_PROPERTY = "FlowFile Rollback Yield Iterations";

  /**
   * Number of FlowFiles to roll back with penalty.
   */
  public static final String FLOW_FILE_ROLLBACK_PENALTY_ITERATIONS_PROPERTY = "FlowFile Rollback Penalty Iterations";

  /**
   * Number of FlowFiles to throw exception.
   */
  public static final String FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY = "FlowFile Exception Iterations";

  /**
   * Exception class to be thrown (must extend java.lang.RuntimeException).
   */
  public static final String FLOW_FILE_EXCEPTION_CLASS_PROPERTY = "FlowFile Exception Class";

  /**
   * Number of times to skip onTrigger if no FlowFile.
   */
  public static final String NO_FLOW_FILE_SKIP_ITERATIONS_PROPERTY = "No FlowFile Skip Iterations";

  /**
   * Number of times to throw NPE exception if no FlowFile.
   */
  public static final String NO_FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY = "No FlowFile Exception Iterations";

  /**
   * Number of times to yield if no FlowFile.
   */
  public static final String NO_FLOW_FILE_YIELD_ITERATIONS_PROPERTY = "No FlowFile Yield Iterations";

  /**
   * Exception class to be thrown if no FlowFile (must extend java.lang.RuntimeException).
   */
  public static final String NO_FLOW_FILE_EXCEPTION_CLASS_PROPERTY = "No FlowFile Exception Class";

  /**
   * Number of times to write to the FlowFile
   */
  public static final String WRITE_ITERATIONS_PROPERTY = "Write Iterations";

  /**
   * The number of bytes to write each time that the FlowFile is written to
   */
  public static final String CONTENT_SIZE_PROPERTY = "Content Size";

  /**
   * Specifies how long the processor should sleep in the @OnScheduled method, so that the processor can be forced to take a long time to start up
   */
  public static final String ON_SCHEDULED_PAUSE_TIME_PROPERTY = "@OnScheduled Pause Time";

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnScheduled are called
   */
  public static final String FAIL_WHEN_ON_SCHEDULED_CALLED_PROPERTY = "Fail When @OnScheduled called";

  /**
   * Specifies how long the processor should sleep in the @OnUnscheduled method, so that the processor can be forced to take a long time to respond when user clicks stop
   */
  public static final String ON_UNSCHEDULED_PAUSE_TIME_PROPERTY = "@OnUnscheduled Pause Time";

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnUnscheduled are called
   */
  public static final String FAIL_WHEN_ON_UNSCHEDULED_CALLED_PROPERTY = "Fail When @OnUnscheduled called";

  /**
   * Specifies how long the processor should sleep in the @OnStopped method, so that the processor can be forced to take a long time to shutdown
   */
  public static final String ON_STOPPED_PAUSE_TIME_PROPERTY = "@OnStopped Pause Time";

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnStopped are called
   */
  public static final String FAIL_WHEN_ON_STOPPED_CALLED_PROPERTY = "Fail When @OnStopped called";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Number of FlowFiles to forward to success relationship.
   */
  public final String getFlowFileSuccessIterations() {
    return properties.get(FLOW_FILE_SUCCESS_ITERATIONS_PROPERTY);
  }

  /**
   * Number of FlowFiles to forward to success relationship.
   */
  public final DebugFlow setFlowFileSuccessIterations(final String flowFileSuccessIterations) {
    properties.put(FLOW_FILE_SUCCESS_ITERATIONS_PROPERTY, flowFileSuccessIterations);
    return this;
  }

  /**
   * Number of FlowFiles to forward to success relationship.
   */
  public final DebugFlow removeFlowFileSuccessIterations() {
    properties.remove(FLOW_FILE_SUCCESS_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of FlowFiles to forward to failure relationship.
   */
  public final String getFlowFileFailureIterations() {
    return properties.get(FLOW_FILE_FAILURE_ITERATIONS_PROPERTY);
  }

  /**
   * Number of FlowFiles to forward to failure relationship.
   */
  public final DebugFlow setFlowFileFailureIterations(final String flowFileFailureIterations) {
    properties.put(FLOW_FILE_FAILURE_ITERATIONS_PROPERTY, flowFileFailureIterations);
    return this;
  }

  /**
   * Number of FlowFiles to forward to failure relationship.
   */
  public final DebugFlow removeFlowFileFailureIterations() {
    properties.remove(FLOW_FILE_FAILURE_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of FlowFiles to roll back (without penalty).
   */
  public final String getFlowFileRollbackIterations() {
    return properties.get(FLOW_FILE_ROLLBACK_ITERATIONS_PROPERTY);
  }

  /**
   * Number of FlowFiles to roll back (without penalty).
   */
  public final DebugFlow setFlowFileRollbackIterations(final String flowFileRollbackIterations) {
    properties.put(FLOW_FILE_ROLLBACK_ITERATIONS_PROPERTY, flowFileRollbackIterations);
    return this;
  }

  /**
   * Number of FlowFiles to roll back (without penalty).
   */
  public final DebugFlow removeFlowFileRollbackIterations() {
    properties.remove(FLOW_FILE_ROLLBACK_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of FlowFiles to roll back and yield.
   */
  public final String getFlowFileRollbackYieldIterations() {
    return properties.get(FLOW_FILE_ROLLBACK_YIELD_ITERATIONS_PROPERTY);
  }

  /**
   * Number of FlowFiles to roll back and yield.
   */
  public final DebugFlow setFlowFileRollbackYieldIterations(final String flowFileRollbackYieldIterations) {
    properties.put(FLOW_FILE_ROLLBACK_YIELD_ITERATIONS_PROPERTY, flowFileRollbackYieldIterations);
    return this;
  }

  /**
   * Number of FlowFiles to roll back and yield.
   */
  public final DebugFlow removeFlowFileRollbackYieldIterations() {
    properties.remove(FLOW_FILE_ROLLBACK_YIELD_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of FlowFiles to roll back with penalty.
   */
  public final String getFlowFileRollbackPenaltyIterations() {
    return properties.get(FLOW_FILE_ROLLBACK_PENALTY_ITERATIONS_PROPERTY);
  }

  /**
   * Number of FlowFiles to roll back with penalty.
   */
  public final DebugFlow setFlowFileRollbackPenaltyIterations(final String flowFileRollbackPenaltyIterations) {
    properties.put(FLOW_FILE_ROLLBACK_PENALTY_ITERATIONS_PROPERTY, flowFileRollbackPenaltyIterations);
    return this;
  }

  /**
   * Number of FlowFiles to roll back with penalty.
   */
  public final DebugFlow removeFlowFileRollbackPenaltyIterations() {
    properties.remove(FLOW_FILE_ROLLBACK_PENALTY_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of FlowFiles to throw exception.
   */
  public final String getFlowFileExceptionIterations() {
    return properties.get(FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY);
  }

  /**
   * Number of FlowFiles to throw exception.
   */
  public final DebugFlow setFlowFileExceptionIterations(final String flowFileExceptionIterations) {
    properties.put(FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY, flowFileExceptionIterations);
    return this;
  }

  /**
   * Number of FlowFiles to throw exception.
   */
  public final DebugFlow removeFlowFileExceptionIterations() {
    properties.remove(FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Exception class to be thrown (must extend java.lang.RuntimeException).
   */
  public final String getFlowFileExceptionClass() {
    return properties.get(FLOW_FILE_EXCEPTION_CLASS_PROPERTY);
  }

  /**
   * Exception class to be thrown (must extend java.lang.RuntimeException).
   */
  public final DebugFlow setFlowFileExceptionClass(final String flowFileExceptionClass) {
    properties.put(FLOW_FILE_EXCEPTION_CLASS_PROPERTY, flowFileExceptionClass);
    return this;
  }

  /**
   * Exception class to be thrown (must extend java.lang.RuntimeException).
   */
  public final DebugFlow removeFlowFileExceptionClass() {
    properties.remove(FLOW_FILE_EXCEPTION_CLASS_PROPERTY);
    return this;
  }

  /**
   * Number of times to skip onTrigger if no FlowFile.
   */
  public final String getNoFlowFileSkipIterations() {
    return properties.get(NO_FLOW_FILE_SKIP_ITERATIONS_PROPERTY);
  }

  /**
   * Number of times to skip onTrigger if no FlowFile.
   */
  public final DebugFlow setNoFlowFileSkipIterations(final String noFlowFileSkipIterations) {
    properties.put(NO_FLOW_FILE_SKIP_ITERATIONS_PROPERTY, noFlowFileSkipIterations);
    return this;
  }

  /**
   * Number of times to skip onTrigger if no FlowFile.
   */
  public final DebugFlow removeNoFlowFileSkipIterations() {
    properties.remove(NO_FLOW_FILE_SKIP_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of times to throw NPE exception if no FlowFile.
   */
  public final String getNoFlowFileExceptionIterations() {
    return properties.get(NO_FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY);
  }

  /**
   * Number of times to throw NPE exception if no FlowFile.
   */
  public final DebugFlow setNoFlowFileExceptionIterations(final String noFlowFileExceptionIterations) {
    properties.put(NO_FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY, noFlowFileExceptionIterations);
    return this;
  }

  /**
   * Number of times to throw NPE exception if no FlowFile.
   */
  public final DebugFlow removeNoFlowFileExceptionIterations() {
    properties.remove(NO_FLOW_FILE_EXCEPTION_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Number of times to yield if no FlowFile.
   */
  public final String getNoFlowFileYieldIterations() {
    return properties.get(NO_FLOW_FILE_YIELD_ITERATIONS_PROPERTY);
  }

  /**
   * Number of times to yield if no FlowFile.
   */
  public final DebugFlow setNoFlowFileYieldIterations(final String noFlowFileYieldIterations) {
    properties.put(NO_FLOW_FILE_YIELD_ITERATIONS_PROPERTY, noFlowFileYieldIterations);
    return this;
  }

  /**
   * Number of times to yield if no FlowFile.
   */
  public final DebugFlow removeNoFlowFileYieldIterations() {
    properties.remove(NO_FLOW_FILE_YIELD_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * Exception class to be thrown if no FlowFile (must extend java.lang.RuntimeException).
   */
  public final String getNoFlowFileExceptionClass() {
    return properties.get(NO_FLOW_FILE_EXCEPTION_CLASS_PROPERTY);
  }

  /**
   * Exception class to be thrown if no FlowFile (must extend java.lang.RuntimeException).
   */
  public final DebugFlow setNoFlowFileExceptionClass(final String noFlowFileExceptionClass) {
    properties.put(NO_FLOW_FILE_EXCEPTION_CLASS_PROPERTY, noFlowFileExceptionClass);
    return this;
  }

  /**
   * Exception class to be thrown if no FlowFile (must extend java.lang.RuntimeException).
   */
  public final DebugFlow removeNoFlowFileExceptionClass() {
    properties.remove(NO_FLOW_FILE_EXCEPTION_CLASS_PROPERTY);
    return this;
  }

  /**
   * Number of times to write to the FlowFile
   */
  public final String getWriteIterations() {
    return properties.get(WRITE_ITERATIONS_PROPERTY);
  }

  /**
   * Number of times to write to the FlowFile
   */
  public final DebugFlow setWriteIterations(final String writeIterations) {
    properties.put(WRITE_ITERATIONS_PROPERTY, writeIterations);
    return this;
  }

  /**
   * Number of times to write to the FlowFile
   */
  public final DebugFlow removeWriteIterations() {
    properties.remove(WRITE_ITERATIONS_PROPERTY);
    return this;
  }

  /**
   * The number of bytes to write each time that the FlowFile is written to
   */
  public final String getContentSize() {
    return properties.get(CONTENT_SIZE_PROPERTY);
  }

  /**
   * The number of bytes to write each time that the FlowFile is written to
   */
  public final DebugFlow setContentSize(final String contentSize) {
    properties.put(CONTENT_SIZE_PROPERTY, contentSize);
    return this;
  }

  /**
   * The number of bytes to write each time that the FlowFile is written to
   */
  public final DebugFlow removeContentSize() {
    properties.remove(CONTENT_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies how long the processor should sleep in the @OnScheduled method, so that the processor can be forced to take a long time to start up
   */
  public final String getOnScheduledPauseTime() {
    return properties.get(ON_SCHEDULED_PAUSE_TIME_PROPERTY);
  }

  /**
   * Specifies how long the processor should sleep in the @OnScheduled method, so that the processor can be forced to take a long time to start up
   */
  public final DebugFlow setOnScheduledPauseTime(final String onScheduledPauseTime) {
    properties.put(ON_SCHEDULED_PAUSE_TIME_PROPERTY, onScheduledPauseTime);
    return this;
  }

  /**
   * Specifies how long the processor should sleep in the @OnScheduled method, so that the processor can be forced to take a long time to start up
   */
  public final DebugFlow removeOnScheduledPauseTime() {
    properties.remove(ON_SCHEDULED_PAUSE_TIME_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnScheduled are called
   */
  public final String getFailWhenOnScheduledCalled() {
    return properties.get(FAIL_WHEN_ON_SCHEDULED_CALLED_PROPERTY);
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnScheduled are called
   */
  public final DebugFlow setFailWhenOnScheduledCalled(final String failWhenOnScheduledCalled) {
    properties.put(FAIL_WHEN_ON_SCHEDULED_CALLED_PROPERTY, failWhenOnScheduledCalled);
    return this;
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnScheduled are called
   */
  public final DebugFlow removeFailWhenOnScheduledCalled() {
    properties.remove(FAIL_WHEN_ON_SCHEDULED_CALLED_PROPERTY);
    return this;
  }

  /**
   * Specifies how long the processor should sleep in the @OnUnscheduled method, so that the processor can be forced to take a long time to respond when user clicks stop
   */
  public final String getOnUnscheduledPauseTime() {
    return properties.get(ON_UNSCHEDULED_PAUSE_TIME_PROPERTY);
  }

  /**
   * Specifies how long the processor should sleep in the @OnUnscheduled method, so that the processor can be forced to take a long time to respond when user clicks stop
   */
  public final DebugFlow setOnUnscheduledPauseTime(final String onUnscheduledPauseTime) {
    properties.put(ON_UNSCHEDULED_PAUSE_TIME_PROPERTY, onUnscheduledPauseTime);
    return this;
  }

  /**
   * Specifies how long the processor should sleep in the @OnUnscheduled method, so that the processor can be forced to take a long time to respond when user clicks stop
   */
  public final DebugFlow removeOnUnscheduledPauseTime() {
    properties.remove(ON_UNSCHEDULED_PAUSE_TIME_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnUnscheduled are called
   */
  public final String getFailWhenOnUnscheduledCalled() {
    return properties.get(FAIL_WHEN_ON_UNSCHEDULED_CALLED_PROPERTY);
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnUnscheduled are called
   */
  public final DebugFlow setFailWhenOnUnscheduledCalled(final String failWhenOnUnscheduledCalled) {
    properties.put(FAIL_WHEN_ON_UNSCHEDULED_CALLED_PROPERTY, failWhenOnUnscheduledCalled);
    return this;
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnUnscheduled are called
   */
  public final DebugFlow removeFailWhenOnUnscheduledCalled() {
    properties.remove(FAIL_WHEN_ON_UNSCHEDULED_CALLED_PROPERTY);
    return this;
  }

  /**
   * Specifies how long the processor should sleep in the @OnStopped method, so that the processor can be forced to take a long time to shutdown
   */
  public final String getOnStoppedPauseTime() {
    return properties.get(ON_STOPPED_PAUSE_TIME_PROPERTY);
  }

  /**
   * Specifies how long the processor should sleep in the @OnStopped method, so that the processor can be forced to take a long time to shutdown
   */
  public final DebugFlow setOnStoppedPauseTime(final String onStoppedPauseTime) {
    properties.put(ON_STOPPED_PAUSE_TIME_PROPERTY, onStoppedPauseTime);
    return this;
  }

  /**
   * Specifies how long the processor should sleep in the @OnStopped method, so that the processor can be forced to take a long time to shutdown
   */
  public final DebugFlow removeOnStoppedPauseTime() {
    properties.remove(ON_STOPPED_PAUSE_TIME_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnStopped are called
   */
  public final String getFailWhenOnStoppedCalled() {
    return properties.get(FAIL_WHEN_ON_STOPPED_CALLED_PROPERTY);
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnStopped are called
   */
  public final DebugFlow setFailWhenOnStoppedCalled(final String failWhenOnStoppedCalled) {
    properties.put(FAIL_WHEN_ON_STOPPED_CALLED_PROPERTY, failWhenOnStoppedCalled);
    return this;
  }

  /**
   * Specifies whether or not the Processor should throw an Exception when the methods annotated with @OnStopped are called
   */
  public final DebugFlow removeFailWhenOnStoppedCalled() {
    properties.remove(FAIL_WHEN_ON_STOPPED_CALLED_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DebugFlow setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DebugFlow removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DebugFlow, DebugFlow> configurator) {
    return configurator.apply(new DebugFlow()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DebugFlow.class) final Closure<DebugFlow> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.DebugFlow> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.DebugFlow.class, com.tibtech.nifi.processors.standard.DebugFlow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
