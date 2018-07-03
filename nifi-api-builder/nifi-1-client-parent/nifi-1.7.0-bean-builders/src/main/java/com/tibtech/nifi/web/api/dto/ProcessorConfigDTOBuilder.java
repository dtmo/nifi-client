package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Map;
import java.util.Set;
import org.apache.nifi.web.api.dto.ProcessorConfigDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;

public final class ProcessorConfigDTOBuilder {
  private String annotationData;

  private Set<String> autoTerminatedRelationships;

  private String bulletinLevel;

  private String comments;

  private Integer concurrentlySchedulableTaskCount;

  private String customUiUrl;

  private Map<String, String> defaultConcurrentTasks;

  private Map<String, String> defaultSchedulingPeriod;

  private Map<String, PropertyDescriptorDTO> descriptors;

  private String executionNode;

  private Boolean lossTolerant;

  private String penaltyDuration;

  private Map<String, String> properties;

  private Long runDurationMillis;

  private String schedulingPeriod;

  private String schedulingStrategy;

  private String yieldDuration;

  /**
   * The annotation data for the processor used to relay configuration between a custom UI and the procesosr.
   */
  public String getAnnotationData() {
    return annotationData;
  }

  /**
   * The annotation data for the processor used to relay configuration between a custom UI and the procesosr.
   */
  public ProcessorConfigDTOBuilder setAnnotationData(final String annotationData) {
    this.annotationData = annotationData;
    return this;
  }

  /**
   * The names of all relationships that cause a flow file to be terminated if the relationship is not connected elsewhere. This property differs from the 'isAutoTerminate' property of the RelationshipDTO in that the RelationshipDTO is meant to depict the current configuration, whereas this property can be set in a DTO when updating a Processor in order to change which Relationships should be auto-terminated.
   */
  public Set<String> getAutoTerminatedRelationships() {
    return autoTerminatedRelationships;
  }

  /**
   * The names of all relationships that cause a flow file to be terminated if the relationship is not connected elsewhere. This property differs from the 'isAutoTerminate' property of the RelationshipDTO in that the RelationshipDTO is meant to depict the current configuration, whereas this property can be set in a DTO when updating a Processor in order to change which Relationships should be auto-terminated.
   */
  public ProcessorConfigDTOBuilder setAutoTerminatedRelationships(final Set<String> autoTerminatedRelationships) {
    this.autoTerminatedRelationships = autoTerminatedRelationships;
    return this;
  }

  /**
   * The level at which the processor will report bulletins.
   */
  public String getBulletinLevel() {
    return bulletinLevel;
  }

  /**
   * The level at which the processor will report bulletins.
   */
  public ProcessorConfigDTOBuilder setBulletinLevel(final String bulletinLevel) {
    this.bulletinLevel = bulletinLevel;
    return this;
  }

  /**
   * The comments for the processor.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the processor.
   */
  public ProcessorConfigDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The number of tasks that should be concurrently schedule for the processor. If the processor doesn't allow parallol processing then any positive input will be ignored.
   */
  public Integer getConcurrentlySchedulableTaskCount() {
    return concurrentlySchedulableTaskCount;
  }

  /**
   * The number of tasks that should be concurrently schedule for the processor. If the processor doesn't allow parallol processing then any positive input will be ignored.
   */
  public ProcessorConfigDTOBuilder setConcurrentlySchedulableTaskCount(final Integer concurrentlySchedulableTaskCount) {
    this.concurrentlySchedulableTaskCount = concurrentlySchedulableTaskCount;
    return this;
  }

  /**
   * The URL for the processor's custom configuration UI if applicable.
   */
  public String getCustomUiUrl() {
    return customUiUrl;
  }

  /**
   * The URL for the processor's custom configuration UI if applicable.
   */
  public ProcessorConfigDTOBuilder setCustomUiUrl(final String customUiUrl) {
    this.customUiUrl = customUiUrl;
    return this;
  }

  /**
   * Maps default values for concurrent tasks for each applicable scheduling strategy.
   */
  public Map<String, String> getDefaultConcurrentTasks() {
    return defaultConcurrentTasks;
  }

  /**
   * Maps default values for concurrent tasks for each applicable scheduling strategy.
   */
  public ProcessorConfigDTOBuilder setDefaultConcurrentTasks(final Map<String, String> defaultConcurrentTasks) {
    this.defaultConcurrentTasks = defaultConcurrentTasks;
    return this;
  }

  /**
   * Maps default values for scheduling period for each applicable scheduling strategy.
   */
  public Map<String, String> getDefaultSchedulingPeriod() {
    return defaultSchedulingPeriod;
  }

  /**
   * Maps default values for scheduling period for each applicable scheduling strategy.
   */
  public ProcessorConfigDTOBuilder setDefaultSchedulingPeriod(final Map<String, String> defaultSchedulingPeriod) {
    this.defaultSchedulingPeriod = defaultSchedulingPeriod;
    return this;
  }

  /**
   * Descriptors for the processor's properties.
   */
  public Map<String, PropertyDescriptorDTO> getDescriptors() {
    return descriptors;
  }

  /**
   * Descriptors for the processor's properties.
   */
  public ProcessorConfigDTOBuilder setDescriptors(final Map<String, PropertyDescriptorDTO> descriptors) {
    this.descriptors = descriptors;
    return this;
  }

  /**
   * Indicates the node where the process will execute.
   */
  public String getExecutionNode() {
    return executionNode;
  }

  /**
   * Indicates the node where the process will execute.
   */
  public ProcessorConfigDTOBuilder setExecutionNode(final String executionNode) {
    this.executionNode = executionNode;
    return this;
  }

  /**
   * Whether the processor is loss tolerant.
   */
  public Boolean getLossTolerant() {
    return lossTolerant;
  }

  /**
   * Whether the processor is loss tolerant.
   */
  public ProcessorConfigDTOBuilder setLossTolerant(final Boolean lossTolerant) {
    this.lossTolerant = lossTolerant;
    return this;
  }

  /**
   * The amount of time that is used when the process penalizes a flowfile.
   */
  public String getPenaltyDuration() {
    return penaltyDuration;
  }

  /**
   * The amount of time that is used when the process penalizes a flowfile.
   */
  public ProcessorConfigDTOBuilder setPenaltyDuration(final String penaltyDuration) {
    this.penaltyDuration = penaltyDuration;
    return this;
  }

  /**
   * The properties for the processor. Properties whose value is not set will only contain the property name.
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * The properties for the processor. Properties whose value is not set will only contain the property name.
   */
  public ProcessorConfigDTOBuilder setProperties(final Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  /**
   * The run duration for the processor in milliseconds.
   */
  public Long getRunDurationMillis() {
    return runDurationMillis;
  }

  /**
   * The run duration for the processor in milliseconds.
   */
  public ProcessorConfigDTOBuilder setRunDurationMillis(final Long runDurationMillis) {
    this.runDurationMillis = runDurationMillis;
    return this;
  }

  /**
   * The frequency with which to schedule the processor. The format of the value will depend on th value of schedulingStrategy.
   */
  public String getSchedulingPeriod() {
    return schedulingPeriod;
  }

  /**
   * The frequency with which to schedule the processor. The format of the value will depend on th value of schedulingStrategy.
   */
  public ProcessorConfigDTOBuilder setSchedulingPeriod(final String schedulingPeriod) {
    this.schedulingPeriod = schedulingPeriod;
    return this;
  }

  /**
   * Indcates whether the prcessor should be scheduled to run in event or timer driven mode.
   */
  public String getSchedulingStrategy() {
    return schedulingStrategy;
  }

  /**
   * Indcates whether the prcessor should be scheduled to run in event or timer driven mode.
   */
  public ProcessorConfigDTOBuilder setSchedulingStrategy(final String schedulingStrategy) {
    this.schedulingStrategy = schedulingStrategy;
    return this;
  }

  /**
   * The amount of time that must elapse before this processor is scheduled again after yielding.
   */
  public String getYieldDuration() {
    return yieldDuration;
  }

  /**
   * The amount of time that must elapse before this processor is scheduled again after yielding.
   */
  public ProcessorConfigDTOBuilder setYieldDuration(final String yieldDuration) {
    this.yieldDuration = yieldDuration;
    return this;
  }

  public ProcessorConfigDTO build() {
    final ProcessorConfigDTO processorConfigDTO = new ProcessorConfigDTO();
    processorConfigDTO.setAnnotationData(annotationData);
    processorConfigDTO.setAutoTerminatedRelationships(autoTerminatedRelationships);
    processorConfigDTO.setBulletinLevel(bulletinLevel);
    processorConfigDTO.setComments(comments);
    processorConfigDTO.setConcurrentlySchedulableTaskCount(concurrentlySchedulableTaskCount);
    processorConfigDTO.setCustomUiUrl(customUiUrl);
    processorConfigDTO.setDefaultConcurrentTasks(defaultConcurrentTasks);
    processorConfigDTO.setDefaultSchedulingPeriod(defaultSchedulingPeriod);
    processorConfigDTO.setDescriptors(descriptors);
    processorConfigDTO.setExecutionNode(executionNode);
    processorConfigDTO.setLossTolerant(lossTolerant);
    processorConfigDTO.setPenaltyDuration(penaltyDuration);
    processorConfigDTO.setProperties(properties);
    processorConfigDTO.setRunDurationMillis(runDurationMillis);
    processorConfigDTO.setSchedulingPeriod(schedulingPeriod);
    processorConfigDTO.setSchedulingStrategy(schedulingStrategy);
    processorConfigDTO.setYieldDuration(yieldDuration);
    return processorConfigDTO;
  }

  public static ProcessorConfigDTOBuilder of(final ProcessorConfigDTO processorConfigDTO) {
    final ProcessorConfigDTOBuilder processorConfigDTOBuilder = new ProcessorConfigDTOBuilder();
    processorConfigDTOBuilder.setAnnotationData(processorConfigDTO.getAnnotationData());
    processorConfigDTOBuilder.setAutoTerminatedRelationships(processorConfigDTO.getAutoTerminatedRelationships());
    processorConfigDTOBuilder.setBulletinLevel(processorConfigDTO.getBulletinLevel());
    processorConfigDTOBuilder.setComments(processorConfigDTO.getComments());
    processorConfigDTOBuilder.setConcurrentlySchedulableTaskCount(processorConfigDTO.getConcurrentlySchedulableTaskCount());
    processorConfigDTOBuilder.setCustomUiUrl(processorConfigDTO.getCustomUiUrl());
    processorConfigDTOBuilder.setDefaultConcurrentTasks(processorConfigDTO.getDefaultConcurrentTasks());
    processorConfigDTOBuilder.setDefaultSchedulingPeriod(processorConfigDTO.getDefaultSchedulingPeriod());
    processorConfigDTOBuilder.setDescriptors(processorConfigDTO.getDescriptors());
    processorConfigDTOBuilder.setExecutionNode(processorConfigDTO.getExecutionNode());
    processorConfigDTOBuilder.setLossTolerant(processorConfigDTO.isLossTolerant());
    processorConfigDTOBuilder.setPenaltyDuration(processorConfigDTO.getPenaltyDuration());
    processorConfigDTOBuilder.setProperties(processorConfigDTO.getProperties());
    processorConfigDTOBuilder.setRunDurationMillis(processorConfigDTO.getRunDurationMillis());
    processorConfigDTOBuilder.setSchedulingPeriod(processorConfigDTO.getSchedulingPeriod());
    processorConfigDTOBuilder.setSchedulingStrategy(processorConfigDTO.getSchedulingStrategy());
    processorConfigDTOBuilder.setYieldDuration(processorConfigDTO.getYieldDuration());
    return processorConfigDTOBuilder;
  }
}
