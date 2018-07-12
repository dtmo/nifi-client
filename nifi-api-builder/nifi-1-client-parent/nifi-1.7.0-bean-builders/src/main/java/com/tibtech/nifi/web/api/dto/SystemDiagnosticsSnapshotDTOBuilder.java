package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.SystemDiagnosticsSnapshotDTO;

public final class SystemDiagnosticsSnapshotDTOBuilder {
  private Integer availableProcessors;

  private Set<SystemDiagnosticsSnapshotDTO.StorageUsageDTO> contentRepositoryStorageUsage;

  private Integer daemonThreads;

  private SystemDiagnosticsSnapshotDTO.StorageUsageDTO flowFileRepositoryStorageUsage;

  private String freeHeap;

  private Long freeHeapBytes;

  private String freeNonHeap;

  private Long freeNonHeapBytes;

  private Set<SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO> garbageCollection;

  private String heapUtilization;

  private String maxHeap;

  private Long maxHeapBytes;

  private String maxNonHeap;

  private Long maxNonHeapBytes;

  private String nonHeapUtilization;

  private Double processorLoadAverage;

  private Set<SystemDiagnosticsSnapshotDTO.StorageUsageDTO> provenanceRepositoryStorageUsage;

  private Date statsLastRefreshed;

  private String totalHeap;

  private Long totalHeapBytes;

  private String totalNonHeap;

  private Long totalNonHeapBytes;

  private Integer totalThreads;

  private String uptime;

  private String usedHeap;

  private Long usedHeapBytes;

  private String usedNonHeap;

  private Long usedNonHeapBytes;

  private SystemDiagnosticsSnapshotDTO.VersionInfoDTO versionInfo;

  /**
   * Number of available processors if supported by the underlying system.
   */
  public Integer getAvailableProcessors() {
    return availableProcessors;
  }

  /**
   * Number of available processors if supported by the underlying system.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setAvailableProcessors(
      final Integer availableProcessors) {
    this.availableProcessors = availableProcessors;
    return this;
  }

  /**
   * The content repository storage usage.
   */
  public Set<SystemDiagnosticsSnapshotDTO.StorageUsageDTO> getContentRepositoryStorageUsage() {
    return contentRepositoryStorageUsage;
  }

  /**
   * The content repository storage usage.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setContentRepositoryStorageUsage(
      final Set<SystemDiagnosticsSnapshotDTO.StorageUsageDTO> contentRepositoryStorageUsage) {
    this.contentRepositoryStorageUsage = contentRepositoryStorageUsage;
    return this;
  }

  /**
   * Number of daemon threads.
   */
  public Integer getDaemonThreads() {
    return daemonThreads;
  }

  /**
   * Number of daemon threads.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setDaemonThreads(final Integer daemonThreads) {
    this.daemonThreads = daemonThreads;
    return this;
  }

  /**
   * The flowfile repository storage usage.
   */
  public SystemDiagnosticsSnapshotDTO.StorageUsageDTO getFlowFileRepositoryStorageUsage() {
    return flowFileRepositoryStorageUsage;
  }

  /**
   * The flowfile repository storage usage.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFlowFileRepositoryStorageUsage(
      final SystemDiagnosticsSnapshotDTO.StorageUsageDTO flowFileRepositoryStorageUsage) {
    this.flowFileRepositoryStorageUsage = flowFileRepositoryStorageUsage;
    return this;
  }

  /**
   * The flowfile repository storage usage.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFlowFileRepositoryStorageUsage(
      final Consumer<StorageUsageDTOBuilder> configurator) {
    final StorageUsageDTOBuilder builder = (flowFileRepositoryStorageUsage != null ? StorageUsageDTOBuilder.of(flowFileRepositoryStorageUsage) : new StorageUsageDTOBuilder());
    configurator.accept(builder);
    return setFlowFileRepositoryStorageUsage(builder.build());
  }

  /**
   * The flowfile repository storage usage.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFlowFileRepositoryStorageUsage(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StorageUsageDTOBuilder.class) final Closure<StorageUsageDTOBuilder> closure) {
    return setFlowFileRepositoryStorageUsage(c -> {
      final Closure<StorageUsageDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Amount of free heap.
   */
  public String getFreeHeap() {
    return freeHeap;
  }

  /**
   * Amount of free heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFreeHeap(final String freeHeap) {
    this.freeHeap = freeHeap;
    return this;
  }

  /**
   * The number of bytes that are allocated to the JVM heap but not currently being used
   */
  public Long getFreeHeapBytes() {
    return freeHeapBytes;
  }

  /**
   * The number of bytes that are allocated to the JVM heap but not currently being used
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFreeHeapBytes(final Long freeHeapBytes) {
    this.freeHeapBytes = freeHeapBytes;
    return this;
  }

  /**
   * Amount of free non heap.
   */
  public String getFreeNonHeap() {
    return freeNonHeap;
  }

  /**
   * Amount of free non heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFreeNonHeap(final String freeNonHeap) {
    this.freeNonHeap = freeNonHeap;
    return this;
  }

  /**
   * Total number of free non-heap bytes available to the JVM
   */
  public Long getFreeNonHeapBytes() {
    return freeNonHeapBytes;
  }

  /**
   * Total number of free non-heap bytes available to the JVM
   */
  public SystemDiagnosticsSnapshotDTOBuilder setFreeNonHeapBytes(final Long freeNonHeapBytes) {
    this.freeNonHeapBytes = freeNonHeapBytes;
    return this;
  }

  /**
   * The garbage collection details.
   */
  public Set<SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO> getGarbageCollection() {
    return garbageCollection;
  }

  /**
   * The garbage collection details.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setGarbageCollection(
      final Set<SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO> garbageCollection) {
    this.garbageCollection = garbageCollection;
    return this;
  }

  /**
   * Utilization of heap.
   */
  public String getHeapUtilization() {
    return heapUtilization;
  }

  /**
   * Utilization of heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setHeapUtilization(final String heapUtilization) {
    this.heapUtilization = heapUtilization;
    return this;
  }

  /**
   * Maximum size of heap.
   */
  public String getMaxHeap() {
    return maxHeap;
  }

  /**
   * Maximum size of heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setMaxHeap(final String maxHeap) {
    this.maxHeap = maxHeap;
    return this;
  }

  /**
   * The maximum number of bytes that can be used by the JVM
   */
  public Long getMaxHeapBytes() {
    return maxHeapBytes;
  }

  /**
   * The maximum number of bytes that can be used by the JVM
   */
  public SystemDiagnosticsSnapshotDTOBuilder setMaxHeapBytes(final Long maxHeapBytes) {
    this.maxHeapBytes = maxHeapBytes;
    return this;
  }

  /**
   * Maximum size of non heap.
   */
  public String getMaxNonHeap() {
    return maxNonHeap;
  }

  /**
   * Maximum size of non heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setMaxNonHeap(final String maxNonHeap) {
    this.maxNonHeap = maxNonHeap;
    return this;
  }

  /**
   * The maximum number of bytes that the JVM can use for non-heap purposes
   */
  public Long getMaxNonHeapBytes() {
    return maxNonHeapBytes;
  }

  /**
   * The maximum number of bytes that the JVM can use for non-heap purposes
   */
  public SystemDiagnosticsSnapshotDTOBuilder setMaxNonHeapBytes(final Long maxNonHeapBytes) {
    this.maxNonHeapBytes = maxNonHeapBytes;
    return this;
  }

  /**
   * Utilization of non heap.
   */
  public String getNonHeapUtilization() {
    return nonHeapUtilization;
  }

  /**
   * Utilization of non heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setNonHeapUtilization(
      final String nonHeapUtilization) {
    this.nonHeapUtilization = nonHeapUtilization;
    return this;
  }

  /**
   * The processor load average if supported by the underlying system.
   */
  public Double getProcessorLoadAverage() {
    return processorLoadAverage;
  }

  /**
   * The processor load average if supported by the underlying system.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setProcessorLoadAverage(
      final Double processorLoadAverage) {
    this.processorLoadAverage = processorLoadAverage;
    return this;
  }

  /**
   * The provenance repository storage usage.
   */
  public Set<SystemDiagnosticsSnapshotDTO.StorageUsageDTO> getProvenanceRepositoryStorageUsage() {
    return provenanceRepositoryStorageUsage;
  }

  /**
   * The provenance repository storage usage.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setProvenanceRepositoryStorageUsage(
      final Set<SystemDiagnosticsSnapshotDTO.StorageUsageDTO> provenanceRepositoryStorageUsage) {
    this.provenanceRepositoryStorageUsage = provenanceRepositoryStorageUsage;
    return this;
  }

  /**
   * When the diagnostics were generated.
   */
  public Date getStatsLastRefreshed() {
    return statsLastRefreshed;
  }

  /**
   * When the diagnostics were generated.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setStatsLastRefreshed(final Date statsLastRefreshed) {
    this.statsLastRefreshed = statsLastRefreshed;
    return this;
  }

  /**
   * Total size of heap.
   */
  public String getTotalHeap() {
    return totalHeap;
  }

  /**
   * Total size of heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setTotalHeap(final String totalHeap) {
    this.totalHeap = totalHeap;
    return this;
  }

  /**
   * The total number of bytes that are available for the JVM heap to use
   */
  public Long getTotalHeapBytes() {
    return totalHeapBytes;
  }

  /**
   * The total number of bytes that are available for the JVM heap to use
   */
  public SystemDiagnosticsSnapshotDTOBuilder setTotalHeapBytes(final Long totalHeapBytes) {
    this.totalHeapBytes = totalHeapBytes;
    return this;
  }

  /**
   * Total size of non heap.
   */
  public String getTotalNonHeap() {
    return totalNonHeap;
  }

  /**
   * Total size of non heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setTotalNonHeap(final String totalNonHeap) {
    this.totalNonHeap = totalNonHeap;
    return this;
  }

  /**
   * Total number of bytes allocated to the JVM not used for heap
   */
  public Long getTotalNonHeapBytes() {
    return totalNonHeapBytes;
  }

  /**
   * Total number of bytes allocated to the JVM not used for heap
   */
  public SystemDiagnosticsSnapshotDTOBuilder setTotalNonHeapBytes(final Long totalNonHeapBytes) {
    this.totalNonHeapBytes = totalNonHeapBytes;
    return this;
  }

  /**
   * Total number of threads.
   */
  public Integer getTotalThreads() {
    return totalThreads;
  }

  /**
   * Total number of threads.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setTotalThreads(final Integer totalThreads) {
    this.totalThreads = totalThreads;
    return this;
  }

  /**
   * The uptime of the Java virtual machine
   */
  public String getUptime() {
    return uptime;
  }

  /**
   * The uptime of the Java virtual machine
   */
  public SystemDiagnosticsSnapshotDTOBuilder setUptime(final String uptime) {
    this.uptime = uptime;
    return this;
  }

  /**
   * Amount of used heap.
   */
  public String getUsedHeap() {
    return usedHeap;
  }

  /**
   * Amount of used heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setUsedHeap(final String usedHeap) {
    this.usedHeap = usedHeap;
    return this;
  }

  /**
   * The number of bytes of JVM heap that are currently being used
   */
  public Long getUsedHeapBytes() {
    return usedHeapBytes;
  }

  /**
   * The number of bytes of JVM heap that are currently being used
   */
  public SystemDiagnosticsSnapshotDTOBuilder setUsedHeapBytes(final Long usedHeapBytes) {
    this.usedHeapBytes = usedHeapBytes;
    return this;
  }

  /**
   * Amount of use non heap.
   */
  public String getUsedNonHeap() {
    return usedNonHeap;
  }

  /**
   * Amount of use non heap.
   */
  public SystemDiagnosticsSnapshotDTOBuilder setUsedNonHeap(final String usedNonHeap) {
    this.usedNonHeap = usedNonHeap;
    return this;
  }

  /**
   * Total number of bytes used by the JVM not in the heap space
   */
  public Long getUsedNonHeapBytes() {
    return usedNonHeapBytes;
  }

  /**
   * Total number of bytes used by the JVM not in the heap space
   */
  public SystemDiagnosticsSnapshotDTOBuilder setUsedNonHeapBytes(final Long usedNonHeapBytes) {
    this.usedNonHeapBytes = usedNonHeapBytes;
    return this;
  }

  /**
   * The nifi, os, java, and build version information
   */
  public SystemDiagnosticsSnapshotDTO.VersionInfoDTO getVersionInfo() {
    return versionInfo;
  }

  /**
   * The nifi, os, java, and build version information
   */
  public SystemDiagnosticsSnapshotDTOBuilder setVersionInfo(
      final SystemDiagnosticsSnapshotDTO.VersionInfoDTO versionInfo) {
    this.versionInfo = versionInfo;
    return this;
  }

  /**
   * The nifi, os, java, and build version information
   */
  public SystemDiagnosticsSnapshotDTOBuilder setVersionInfo(
      final Consumer<VersionInfoDTOBuilder> configurator) {
    final VersionInfoDTOBuilder builder = (versionInfo != null ? VersionInfoDTOBuilder.of(versionInfo) : new VersionInfoDTOBuilder());
    configurator.accept(builder);
    return setVersionInfo(builder.build());
  }

  /**
   * The nifi, os, java, and build version information
   */
  public SystemDiagnosticsSnapshotDTOBuilder setVersionInfo(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = VersionInfoDTOBuilder.class) final Closure<VersionInfoDTOBuilder> closure) {
    return setVersionInfo(c -> {
      final Closure<VersionInfoDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public SystemDiagnosticsSnapshotDTO build() {
    final SystemDiagnosticsSnapshotDTO systemDiagnosticsSnapshotDTO = new SystemDiagnosticsSnapshotDTO();
    systemDiagnosticsSnapshotDTO.setAvailableProcessors(availableProcessors);
    systemDiagnosticsSnapshotDTO.setContentRepositoryStorageUsage(contentRepositoryStorageUsage);
    systemDiagnosticsSnapshotDTO.setDaemonThreads(daemonThreads);
    systemDiagnosticsSnapshotDTO.setFlowFileRepositoryStorageUsage(flowFileRepositoryStorageUsage);
    systemDiagnosticsSnapshotDTO.setFreeHeap(freeHeap);
    systemDiagnosticsSnapshotDTO.setFreeHeapBytes(freeHeapBytes);
    systemDiagnosticsSnapshotDTO.setFreeNonHeap(freeNonHeap);
    systemDiagnosticsSnapshotDTO.setFreeNonHeapBytes(freeNonHeapBytes);
    systemDiagnosticsSnapshotDTO.setGarbageCollection(garbageCollection);
    systemDiagnosticsSnapshotDTO.setHeapUtilization(heapUtilization);
    systemDiagnosticsSnapshotDTO.setMaxHeap(maxHeap);
    systemDiagnosticsSnapshotDTO.setMaxHeapBytes(maxHeapBytes);
    systemDiagnosticsSnapshotDTO.setMaxNonHeap(maxNonHeap);
    systemDiagnosticsSnapshotDTO.setMaxNonHeapBytes(maxNonHeapBytes);
    systemDiagnosticsSnapshotDTO.setNonHeapUtilization(nonHeapUtilization);
    systemDiagnosticsSnapshotDTO.setProcessorLoadAverage(processorLoadAverage);
    systemDiagnosticsSnapshotDTO.setProvenanceRepositoryStorageUsage(provenanceRepositoryStorageUsage);
    systemDiagnosticsSnapshotDTO.setStatsLastRefreshed(statsLastRefreshed);
    systemDiagnosticsSnapshotDTO.setTotalHeap(totalHeap);
    systemDiagnosticsSnapshotDTO.setTotalHeapBytes(totalHeapBytes);
    systemDiagnosticsSnapshotDTO.setTotalNonHeap(totalNonHeap);
    systemDiagnosticsSnapshotDTO.setTotalNonHeapBytes(totalNonHeapBytes);
    systemDiagnosticsSnapshotDTO.setTotalThreads(totalThreads);
    systemDiagnosticsSnapshotDTO.setUptime(uptime);
    systemDiagnosticsSnapshotDTO.setUsedHeap(usedHeap);
    systemDiagnosticsSnapshotDTO.setUsedHeapBytes(usedHeapBytes);
    systemDiagnosticsSnapshotDTO.setUsedNonHeap(usedNonHeap);
    systemDiagnosticsSnapshotDTO.setUsedNonHeapBytes(usedNonHeapBytes);
    systemDiagnosticsSnapshotDTO.setVersionInfo(versionInfo);
    return systemDiagnosticsSnapshotDTO;
  }

  public static SystemDiagnosticsSnapshotDTOBuilder of(
      final SystemDiagnosticsSnapshotDTO systemDiagnosticsSnapshotDTO) {
    final SystemDiagnosticsSnapshotDTOBuilder systemDiagnosticsSnapshotDTOBuilder = new SystemDiagnosticsSnapshotDTOBuilder();
    systemDiagnosticsSnapshotDTOBuilder.setAvailableProcessors(systemDiagnosticsSnapshotDTO.getAvailableProcessors());
    systemDiagnosticsSnapshotDTOBuilder.setContentRepositoryStorageUsage(systemDiagnosticsSnapshotDTO.getContentRepositoryStorageUsage());
    systemDiagnosticsSnapshotDTOBuilder.setDaemonThreads(systemDiagnosticsSnapshotDTO.getDaemonThreads());
    systemDiagnosticsSnapshotDTOBuilder.setFlowFileRepositoryStorageUsage(systemDiagnosticsSnapshotDTO.getFlowFileRepositoryStorageUsage());
    systemDiagnosticsSnapshotDTOBuilder.setFreeHeap(systemDiagnosticsSnapshotDTO.getFreeHeap());
    systemDiagnosticsSnapshotDTOBuilder.setFreeHeapBytes(systemDiagnosticsSnapshotDTO.getFreeHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setFreeNonHeap(systemDiagnosticsSnapshotDTO.getFreeNonHeap());
    systemDiagnosticsSnapshotDTOBuilder.setFreeNonHeapBytes(systemDiagnosticsSnapshotDTO.getFreeNonHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setGarbageCollection(systemDiagnosticsSnapshotDTO.getGarbageCollection());
    systemDiagnosticsSnapshotDTOBuilder.setHeapUtilization(systemDiagnosticsSnapshotDTO.getHeapUtilization());
    systemDiagnosticsSnapshotDTOBuilder.setMaxHeap(systemDiagnosticsSnapshotDTO.getMaxHeap());
    systemDiagnosticsSnapshotDTOBuilder.setMaxHeapBytes(systemDiagnosticsSnapshotDTO.getMaxHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setMaxNonHeap(systemDiagnosticsSnapshotDTO.getMaxNonHeap());
    systemDiagnosticsSnapshotDTOBuilder.setMaxNonHeapBytes(systemDiagnosticsSnapshotDTO.getMaxNonHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setNonHeapUtilization(systemDiagnosticsSnapshotDTO.getNonHeapUtilization());
    systemDiagnosticsSnapshotDTOBuilder.setProcessorLoadAverage(systemDiagnosticsSnapshotDTO.getProcessorLoadAverage());
    systemDiagnosticsSnapshotDTOBuilder.setProvenanceRepositoryStorageUsage(systemDiagnosticsSnapshotDTO.getProvenanceRepositoryStorageUsage());
    systemDiagnosticsSnapshotDTOBuilder.setStatsLastRefreshed(systemDiagnosticsSnapshotDTO.getStatsLastRefreshed());
    systemDiagnosticsSnapshotDTOBuilder.setTotalHeap(systemDiagnosticsSnapshotDTO.getTotalHeap());
    systemDiagnosticsSnapshotDTOBuilder.setTotalHeapBytes(systemDiagnosticsSnapshotDTO.getTotalHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setTotalNonHeap(systemDiagnosticsSnapshotDTO.getTotalNonHeap());
    systemDiagnosticsSnapshotDTOBuilder.setTotalNonHeapBytes(systemDiagnosticsSnapshotDTO.getTotalNonHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setTotalThreads(systemDiagnosticsSnapshotDTO.getTotalThreads());
    systemDiagnosticsSnapshotDTOBuilder.setUptime(systemDiagnosticsSnapshotDTO.getUptime());
    systemDiagnosticsSnapshotDTOBuilder.setUsedHeap(systemDiagnosticsSnapshotDTO.getUsedHeap());
    systemDiagnosticsSnapshotDTOBuilder.setUsedHeapBytes(systemDiagnosticsSnapshotDTO.getUsedHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setUsedNonHeap(systemDiagnosticsSnapshotDTO.getUsedNonHeap());
    systemDiagnosticsSnapshotDTOBuilder.setUsedNonHeapBytes(systemDiagnosticsSnapshotDTO.getUsedNonHeapBytes());
    systemDiagnosticsSnapshotDTOBuilder.setVersionInfo(systemDiagnosticsSnapshotDTO.getVersionInfo());
    return systemDiagnosticsSnapshotDTOBuilder;
  }
}
