package com.tibtech.nifi.web.api.dto.diagnostics;

import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.dto.status.ProcessorStatusDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.diagnostics.ClassLoaderDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.ConnectionDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.ControllerServiceDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.JVMDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.ProcessorDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.ThreadDumpDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusDTO;

public final class ProcessorDiagnosticsDTOBuilder {
  private ClassLoaderDiagnosticsDTO classLoaderDiagnostics;

  private Set<ConnectionDiagnosticsDTO> incomingConnections;

  private JVMDiagnosticsDTO jvmDiagnostics;

  private Set<ConnectionDiagnosticsDTO> outgoingConnections;

  private ProcessorDTO processor;

  private ProcessorStatusDTO processorStatus;

  private Set<ControllerServiceDiagnosticsDTO> referencedControllerServices;

  private List<ThreadDumpDTO> threadDumps;

  /**
   * Information about the Controller Service's Class Loader
   */
  public ClassLoaderDiagnosticsDTO getClassLoaderDiagnostics() {
    return classLoaderDiagnostics;
  }

  /**
   * Information about the Controller Service's Class Loader
   */
  public ProcessorDiagnosticsDTOBuilder setClassLoaderDiagnostics(final ClassLoaderDiagnosticsDTO classLoaderDiagnostics) {
    this.classLoaderDiagnostics = classLoaderDiagnostics;
    return this;
  }

  /**
   * Information about the Controller Service's Class Loader
   */
  public ProcessorDiagnosticsDTOBuilder setClassLoaderDiagnostics(final Consumer<ClassLoaderDiagnosticsDTOBuilder> configurator) {
    final ClassLoaderDiagnosticsDTOBuilder builder = (classLoaderDiagnostics != null ? ClassLoaderDiagnosticsDTOBuilder.of(classLoaderDiagnostics) : new ClassLoaderDiagnosticsDTOBuilder());
    configurator.accept(builder);
    return setClassLoaderDiagnostics(builder.build());
  }

  /**
   * Information about the Controller Service's Class Loader
   */
  public ProcessorDiagnosticsDTOBuilder setClassLoaderDiagnostics(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ClassLoaderDiagnosticsDTOBuilder.class) final Closure<ClassLoaderDiagnosticsDTOBuilder> closure) {
    return setClassLoaderDiagnostics(c -> {
      final Closure<ClassLoaderDiagnosticsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Diagnostic Information about all incoming Connections
   */
  public Set<ConnectionDiagnosticsDTO> getIncomingConnections() {
    return incomingConnections;
  }

  /**
   * Diagnostic Information about all incoming Connections
   */
  public ProcessorDiagnosticsDTOBuilder setIncomingConnections(final Set<ConnectionDiagnosticsDTO> incomingConnections) {
    this.incomingConnections = incomingConnections;
    return this;
  }

  /**
   * Diagnostic Information about the JVM and system-level diagnostics
   */
  public JVMDiagnosticsDTO getJvmDiagnostics() {
    return jvmDiagnostics;
  }

  /**
   * Diagnostic Information about the JVM and system-level diagnostics
   */
  public ProcessorDiagnosticsDTOBuilder setJvmDiagnostics(final JVMDiagnosticsDTO jvmDiagnostics) {
    this.jvmDiagnostics = jvmDiagnostics;
    return this;
  }

  /**
   * Diagnostic Information about the JVM and system-level diagnostics
   */
  public ProcessorDiagnosticsDTOBuilder setJvmDiagnostics(final Consumer<JVMDiagnosticsDTOBuilder> configurator) {
    final JVMDiagnosticsDTOBuilder builder = (jvmDiagnostics != null ? JVMDiagnosticsDTOBuilder.of(jvmDiagnostics) : new JVMDiagnosticsDTOBuilder());
    configurator.accept(builder);
    return setJvmDiagnostics(builder.build());
  }

  /**
   * Diagnostic Information about the JVM and system-level diagnostics
   */
  public ProcessorDiagnosticsDTOBuilder setJvmDiagnostics(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JVMDiagnosticsDTOBuilder.class) final Closure<JVMDiagnosticsDTOBuilder> closure) {
    return setJvmDiagnostics(c -> {
      final Closure<JVMDiagnosticsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Diagnostic Information about all outgoing Connections
   */
  public Set<ConnectionDiagnosticsDTO> getOutgoingConnections() {
    return outgoingConnections;
  }

  /**
   * Diagnostic Information about all outgoing Connections
   */
  public ProcessorDiagnosticsDTOBuilder setOutgoingConnections(final Set<ConnectionDiagnosticsDTO> outgoingConnections) {
    this.outgoingConnections = outgoingConnections;
    return this;
  }

  /**
   * Information about the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDTO getProcessor() {
    return processor;
  }

  /**
   * Information about the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDiagnosticsDTOBuilder setProcessor(final ProcessorDTO processor) {
    this.processor = processor;
    return this;
  }

  /**
   * Information about the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDiagnosticsDTOBuilder setProcessor(final Consumer<ProcessorDTOBuilder> configurator) {
    final ProcessorDTOBuilder builder = (processor != null ? ProcessorDTOBuilder.of(processor) : new ProcessorDTOBuilder());
    configurator.accept(builder);
    return setProcessor(builder.build());
  }

  /**
   * Information about the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDiagnosticsDTOBuilder setProcessor(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure) {
    return setProcessor(c -> {
      final Closure<ProcessorDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The Status for the Processor for which the Diagnostic Report is generated
   */
  public ProcessorStatusDTO getProcessorStatus() {
    return processorStatus;
  }

  /**
   * The Status for the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDiagnosticsDTOBuilder setProcessorStatus(final ProcessorStatusDTO processorStatus) {
    this.processorStatus = processorStatus;
    return this;
  }

  /**
   * The Status for the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDiagnosticsDTOBuilder setProcessorStatus(final Consumer<ProcessorStatusDTOBuilder> configurator) {
    final ProcessorStatusDTOBuilder builder = (processorStatus != null ? ProcessorStatusDTOBuilder.of(processorStatus) : new ProcessorStatusDTOBuilder());
    configurator.accept(builder);
    return setProcessorStatus(builder.build());
  }

  /**
   * The Status for the Processor for which the Diagnostic Report is generated
   */
  public ProcessorDiagnosticsDTOBuilder setProcessorStatus(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorStatusDTOBuilder.class) final Closure<ProcessorStatusDTOBuilder> closure) {
    return setProcessorStatus(c -> {
      final Closure<ProcessorStatusDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Diagnostic Information about all Controller Services that the Processor is referencing
   */
  public Set<ControllerServiceDiagnosticsDTO> getReferencedControllerServices() {
    return referencedControllerServices;
  }

  /**
   * Diagnostic Information about all Controller Services that the Processor is referencing
   */
  public ProcessorDiagnosticsDTOBuilder setReferencedControllerServices(final Set<ControllerServiceDiagnosticsDTO> referencedControllerServices) {
    this.referencedControllerServices = referencedControllerServices;
    return this;
  }

  /**
   * Thread Dumps that were taken of the threads that are active in the Processor
   */
  public List<ThreadDumpDTO> getThreadDumps() {
    return threadDumps;
  }

  /**
   * Thread Dumps that were taken of the threads that are active in the Processor
   */
  public ProcessorDiagnosticsDTOBuilder setThreadDumps(final List<ThreadDumpDTO> threadDumps) {
    this.threadDumps = threadDumps;
    return this;
  }

  public ProcessorDiagnosticsDTO build() {
    final ProcessorDiagnosticsDTO processorDiagnosticsDTO = new ProcessorDiagnosticsDTO();
    processorDiagnosticsDTO.setClassLoaderDiagnostics(classLoaderDiagnostics);
    processorDiagnosticsDTO.setIncomingConnections(incomingConnections);
    processorDiagnosticsDTO.setJvmDiagnostics(jvmDiagnostics);
    processorDiagnosticsDTO.setOutgoingConnections(outgoingConnections);
    processorDiagnosticsDTO.setProcessor(processor);
    processorDiagnosticsDTO.setProcessorStatus(processorStatus);
    processorDiagnosticsDTO.setReferencedControllerServices(referencedControllerServices);
    processorDiagnosticsDTO.setThreadDumps(threadDumps);
    return processorDiagnosticsDTO;
  }

  public static ProcessorDiagnosticsDTOBuilder of(final ProcessorDiagnosticsDTO processorDiagnosticsDTO) {
    final ProcessorDiagnosticsDTOBuilder processorDiagnosticsDTOBuilder = new ProcessorDiagnosticsDTOBuilder();
    processorDiagnosticsDTOBuilder.setClassLoaderDiagnostics(processorDiagnosticsDTO.getClassLoaderDiagnostics());
    processorDiagnosticsDTOBuilder.setIncomingConnections(processorDiagnosticsDTO.getIncomingConnections());
    processorDiagnosticsDTOBuilder.setJvmDiagnostics(processorDiagnosticsDTO.getJvmDiagnostics());
    processorDiagnosticsDTOBuilder.setOutgoingConnections(processorDiagnosticsDTO.getOutgoingConnections());
    processorDiagnosticsDTOBuilder.setProcessor(processorDiagnosticsDTO.getProcessor());
    processorDiagnosticsDTOBuilder.setProcessorStatus(processorDiagnosticsDTO.getProcessorStatus());
    processorDiagnosticsDTOBuilder.setReferencedControllerServices(processorDiagnosticsDTO.getReferencedControllerServices());
    processorDiagnosticsDTOBuilder.setThreadDumps(processorDiagnosticsDTO.getThreadDumps());
    return processorDiagnosticsDTOBuilder;
  }
}
