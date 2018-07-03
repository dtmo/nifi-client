package com.tibtech.nifi.web.api.dto.diagnostics;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.diagnostics.GarbageCollectionDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.JVMSystemDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.RepositoryUsageDTO;

public final class JVMSystemDiagnosticsSnapshotDTOBuilder {
  private Set<RepositoryUsageDTO> contentRepositoryStorageUsage;

  private Integer cpuCores;

  private Double cpuLoadAverage;

  private RepositoryUsageDTO flowFileRepositoryStorageUsage;

  private List<GarbageCollectionDiagnosticsDTO> garbageCollectionDiagnostics;

  private String maxHeap;

  private Long maxHeapBytes;

  private Long maxOpenFileDescriptors;

  private Long openFileDescriptors;

  private String physicalMemory;

  private Long physicalMemoryBytes;

  private Set<RepositoryUsageDTO> provenanceRepositoryStorageUsage;

  /**
   * Information about the Content Repository's usage
   */
  public Set<RepositoryUsageDTO> getContentRepositoryStorageUsage() {
    return contentRepositoryStorageUsage;
  }

  /**
   * Information about the Content Repository's usage
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setContentRepositoryStorageUsage(final Set<RepositoryUsageDTO> contentRepositoryStorageUsage) {
    this.contentRepositoryStorageUsage = contentRepositoryStorageUsage;
    return this;
  }

  /**
   * The number of CPU Cores available on the system
   */
  public Integer getCpuCores() {
    return cpuCores;
  }

  /**
   * The number of CPU Cores available on the system
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setCpuCores(final Integer cpuCores) {
    this.cpuCores = cpuCores;
    return this;
  }

  /**
   * The 1-minute CPU Load Average
   */
  public Double getCpuLoadAverage() {
    return cpuLoadAverage;
  }

  /**
   * The 1-minute CPU Load Average
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setCpuLoadAverage(final Double cpuLoadAverage) {
    this.cpuLoadAverage = cpuLoadAverage;
    return this;
  }

  /**
   * Information about the FlowFile Repository's usage
   */
  public RepositoryUsageDTO getFlowFileRepositoryStorageUsage() {
    return flowFileRepositoryStorageUsage;
  }

  /**
   * Information about the FlowFile Repository's usage
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setFlowFileRepositoryStorageUsage(final RepositoryUsageDTO flowFileRepositoryStorageUsage) {
    this.flowFileRepositoryStorageUsage = flowFileRepositoryStorageUsage;
    return this;
  }

  /**
   * Information about the FlowFile Repository's usage
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setFlowFileRepositoryStorageUsage(final Consumer<RepositoryUsageDTOBuilder> configurator) {
    final RepositoryUsageDTOBuilder builder = (flowFileRepositoryStorageUsage != null ? RepositoryUsageDTOBuilder.of(flowFileRepositoryStorageUsage) : new RepositoryUsageDTOBuilder());
    configurator.accept(builder);
    return setFlowFileRepositoryStorageUsage(builder.build());
  }

  /**
   * Information about the FlowFile Repository's usage
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setFlowFileRepositoryStorageUsage(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RepositoryUsageDTOBuilder.class) final Closure<RepositoryUsageDTOBuilder> closure) {
    return setFlowFileRepositoryStorageUsage(c -> {
      final Closure<RepositoryUsageDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Diagnostic information about the JVM's garbage collections
   */
  public List<GarbageCollectionDiagnosticsDTO> getGarbageCollectionDiagnostics() {
    return garbageCollectionDiagnostics;
  }

  /**
   * Diagnostic information about the JVM's garbage collections
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setGarbageCollectionDiagnostics(final List<GarbageCollectionDiagnosticsDTO> garbageCollectionDiagnostics) {
    this.garbageCollectionDiagnostics = garbageCollectionDiagnostics;
    return this;
  }

  /**
   * The maximum number of bytes that the JVM heap is configured to use, as a human-readable value
   */
  public String getMaxHeap() {
    return maxHeap;
  }

  /**
   * The maximum number of bytes that the JVM heap is configured to use, as a human-readable value
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setMaxHeap(final String maxHeap) {
    this.maxHeap = maxHeap;
    return this;
  }

  /**
   * The maximum number of bytes that the JVM heap is configured to use for heap
   */
  public Long getMaxHeapBytes() {
    return maxHeapBytes;
  }

  /**
   * The maximum number of bytes that the JVM heap is configured to use for heap
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setMaxHeapBytes(final Long maxHeapBytes) {
    this.maxHeapBytes = maxHeapBytes;
    return this;
  }

  /**
   * The maximum number of open file descriptors that are available to each process
   */
  public Long getMaxOpenFileDescriptors() {
    return maxOpenFileDescriptors;
  }

  /**
   * The maximum number of open file descriptors that are available to each process
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setMaxOpenFileDescriptors(final Long maxOpenFileDescriptors) {
    this.maxOpenFileDescriptors = maxOpenFileDescriptors;
    return this;
  }

  /**
   * The number of files that are open by the NiFi process
   */
  public Long getOpenFileDescriptors() {
    return openFileDescriptors;
  }

  /**
   * The number of files that are open by the NiFi process
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setOpenFileDescriptors(final Long openFileDescriptors) {
    this.openFileDescriptors = openFileDescriptors;
    return this;
  }

  /**
   * The number of bytes of RAM available on the system as a human-readable value
   */
  public String getPhysicalMemory() {
    return physicalMemory;
  }

  /**
   * The number of bytes of RAM available on the system as a human-readable value
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setPhysicalMemory(final String physicalMemory) {
    this.physicalMemory = physicalMemory;
    return this;
  }

  /**
   * The number of bytes of RAM available on the system
   */
  public Long getPhysicalMemoryBytes() {
    return physicalMemoryBytes;
  }

  /**
   * The number of bytes of RAM available on the system
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setPhysicalMemoryBytes(final Long physicalMemoryBytes) {
    this.physicalMemoryBytes = physicalMemoryBytes;
    return this;
  }

  /**
   * Information about the Provenance Repository's usage
   */
  public Set<RepositoryUsageDTO> getProvenanceRepositoryStorageUsage() {
    return provenanceRepositoryStorageUsage;
  }

  /**
   * Information about the Provenance Repository's usage
   */
  public JVMSystemDiagnosticsSnapshotDTOBuilder setProvenanceRepositoryStorageUsage(final Set<RepositoryUsageDTO> provenanceRepositoryStorageUsage) {
    this.provenanceRepositoryStorageUsage = provenanceRepositoryStorageUsage;
    return this;
  }

  public JVMSystemDiagnosticsSnapshotDTO build() {
    final JVMSystemDiagnosticsSnapshotDTO jVMSystemDiagnosticsSnapshotDTO = new JVMSystemDiagnosticsSnapshotDTO();
    jVMSystemDiagnosticsSnapshotDTO.setContentRepositoryStorageUsage(contentRepositoryStorageUsage);
    jVMSystemDiagnosticsSnapshotDTO.setCpuCores(cpuCores);
    jVMSystemDiagnosticsSnapshotDTO.setCpuLoadAverage(cpuLoadAverage);
    jVMSystemDiagnosticsSnapshotDTO.setFlowFileRepositoryStorageUsage(flowFileRepositoryStorageUsage);
    jVMSystemDiagnosticsSnapshotDTO.setGarbageCollectionDiagnostics(garbageCollectionDiagnostics);
    jVMSystemDiagnosticsSnapshotDTO.setMaxHeap(maxHeap);
    jVMSystemDiagnosticsSnapshotDTO.setMaxHeapBytes(maxHeapBytes);
    jVMSystemDiagnosticsSnapshotDTO.setMaxOpenFileDescriptors(maxOpenFileDescriptors);
    jVMSystemDiagnosticsSnapshotDTO.setOpenFileDescriptors(openFileDescriptors);
    jVMSystemDiagnosticsSnapshotDTO.setPhysicalMemory(physicalMemory);
    jVMSystemDiagnosticsSnapshotDTO.setPhysicalMemoryBytes(physicalMemoryBytes);
    jVMSystemDiagnosticsSnapshotDTO.setProvenanceRepositoryStorageUsage(provenanceRepositoryStorageUsage);
    return jVMSystemDiagnosticsSnapshotDTO;
  }

  public static JVMSystemDiagnosticsSnapshotDTOBuilder of(final JVMSystemDiagnosticsSnapshotDTO jVMSystemDiagnosticsSnapshotDTO) {
    final JVMSystemDiagnosticsSnapshotDTOBuilder jVMSystemDiagnosticsSnapshotDTOBuilder = new JVMSystemDiagnosticsSnapshotDTOBuilder();
    jVMSystemDiagnosticsSnapshotDTOBuilder.setContentRepositoryStorageUsage(jVMSystemDiagnosticsSnapshotDTO.getContentRepositoryStorageUsage());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setCpuCores(jVMSystemDiagnosticsSnapshotDTO.getCpuCores());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setCpuLoadAverage(jVMSystemDiagnosticsSnapshotDTO.getCpuLoadAverage());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setFlowFileRepositoryStorageUsage(jVMSystemDiagnosticsSnapshotDTO.getFlowFileRepositoryStorageUsage());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setGarbageCollectionDiagnostics(jVMSystemDiagnosticsSnapshotDTO.getGarbageCollectionDiagnostics());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setMaxHeap(jVMSystemDiagnosticsSnapshotDTO.getMaxHeap());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setMaxHeapBytes(jVMSystemDiagnosticsSnapshotDTO.getMaxHeapBytes());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setMaxOpenFileDescriptors(jVMSystemDiagnosticsSnapshotDTO.getMaxOpenFileDescriptors());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setOpenFileDescriptors(jVMSystemDiagnosticsSnapshotDTO.getOpenFileDescriptors());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setPhysicalMemory(jVMSystemDiagnosticsSnapshotDTO.getPhysicalMemory());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setPhysicalMemoryBytes(jVMSystemDiagnosticsSnapshotDTO.getPhysicalMemoryBytes());
    jVMSystemDiagnosticsSnapshotDTOBuilder.setProvenanceRepositoryStorageUsage(jVMSystemDiagnosticsSnapshotDTO.getProvenanceRepositoryStorageUsage());
    return jVMSystemDiagnosticsSnapshotDTOBuilder;
  }
}
