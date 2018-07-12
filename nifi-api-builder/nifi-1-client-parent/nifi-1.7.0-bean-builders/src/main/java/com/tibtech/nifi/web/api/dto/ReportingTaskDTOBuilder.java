package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.BundleDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.dto.ReportingTaskDTO;

public final class ReportingTaskDTOBuilder extends AbstractComponentDTOBuilder<ReportingTaskDTOBuilder> {
  private Integer activeThreadCount;

  private String annotationData;

  private BundleDTO bundle;

  private String comments;

  private String customUiUrl;

  private Map<String, String> defaultSchedulingPeriod;

  private Boolean deprecated;

  private Map<String, PropertyDescriptorDTO> descriptors;

  private Boolean multipleVersionsAvailable;

  private String name;

  private Boolean persistsState;

  private Map<String, String> properties;

  private Boolean restricted;

  private String schedulingPeriod;

  private String schedulingStrategy;

  private String state;

  private String type;

  private Collection<String> validationErrors;

  private String validationStatus;

  /**
   * The number of active threads for the reporting task.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The number of active threads for the reporting task.
   */
  public ReportingTaskDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The annotation data for the repoting task. This is how the custom UI relays configuration to the reporting task.
   */
  public String getAnnotationData() {
    return annotationData;
  }

  /**
   * The annotation data for the repoting task. This is how the custom UI relays configuration to the reporting task.
   */
  public ReportingTaskDTOBuilder setAnnotationData(final String annotationData) {
    this.annotationData = annotationData;
    return this;
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public BundleDTO getBundle() {
    return bundle;
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public ReportingTaskDTOBuilder setBundle(final BundleDTO bundle) {
    this.bundle = bundle;
    return this;
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public ReportingTaskDTOBuilder setBundle(final Consumer<BundleDTOBuilder> configurator) {
    final BundleDTOBuilder builder = (bundle != null ? BundleDTOBuilder.of(bundle) : new BundleDTOBuilder());
    configurator.accept(builder);
    return setBundle(builder.build());
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public ReportingTaskDTOBuilder setBundle(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BundleDTOBuilder.class) final Closure<BundleDTOBuilder> closure) {
    return setBundle(c -> {
      final Closure<BundleDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The comments of the reporting task.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments of the reporting task.
   */
  public ReportingTaskDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The URL for the custom configuration UI for the reporting task.
   */
  public String getCustomUiUrl() {
    return customUiUrl;
  }

  /**
   * The URL for the custom configuration UI for the reporting task.
   */
  public ReportingTaskDTOBuilder setCustomUiUrl(final String customUiUrl) {
    this.customUiUrl = customUiUrl;
    return this;
  }

  /**
   * The default scheduling period for the different scheduling strategies.
   */
  public Map<String, String> getDefaultSchedulingPeriod() {
    return defaultSchedulingPeriod;
  }

  /**
   * The default scheduling period for the different scheduling strategies.
   */
  public ReportingTaskDTOBuilder setDefaultSchedulingPeriod(
      final Map<String, String> defaultSchedulingPeriod) {
    this.defaultSchedulingPeriod = defaultSchedulingPeriod;
    return this;
  }

  /**
   * Whether the reporting task has been deprecated.
   */
  public Boolean getDeprecated() {
    return deprecated;
  }

  /**
   * Whether the reporting task has been deprecated.
   */
  public ReportingTaskDTOBuilder setDeprecated(final Boolean deprecated) {
    this.deprecated = deprecated;
    return this;
  }

  /**
   * The descriptors for the reporting tasks properties.
   */
  public Map<String, PropertyDescriptorDTO> getDescriptors() {
    return descriptors;
  }

  /**
   * The descriptors for the reporting tasks properties.
   */
  public ReportingTaskDTOBuilder setDescriptors(
      final Map<String, PropertyDescriptorDTO> descriptors) {
    this.descriptors = descriptors;
    return this;
  }

  /**
   * Whether the reporting task has multiple versions available.
   */
  public Boolean getMultipleVersionsAvailable() {
    return multipleVersionsAvailable;
  }

  /**
   * Whether the reporting task has multiple versions available.
   */
  public ReportingTaskDTOBuilder setMultipleVersionsAvailable(
      final Boolean multipleVersionsAvailable) {
    this.multipleVersionsAvailable = multipleVersionsAvailable;
    return this;
  }

  /**
   * The name of the reporting task.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the reporting task.
   */
  public ReportingTaskDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Whether the reporting task persists state.
   */
  public Boolean getPersistsState() {
    return persistsState;
  }

  /**
   * Whether the reporting task persists state.
   */
  public ReportingTaskDTOBuilder setPersistsState(final Boolean persistsState) {
    this.persistsState = persistsState;
    return this;
  }

  /**
   * The properties of the reporting task.
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * The properties of the reporting task.
   */
  public ReportingTaskDTOBuilder setProperties(final Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Whether the reporting task requires elevated privileges.
   */
  public Boolean getRestricted() {
    return restricted;
  }

  /**
   * Whether the reporting task requires elevated privileges.
   */
  public ReportingTaskDTOBuilder setRestricted(final Boolean restricted) {
    this.restricted = restricted;
    return this;
  }

  /**
   * The frequency with which to schedule the reporting task. The format of the value willd epend on the valud of the schedulingStrategy.
   */
  public String getSchedulingPeriod() {
    return schedulingPeriod;
  }

  /**
   * The frequency with which to schedule the reporting task. The format of the value willd epend on the valud of the schedulingStrategy.
   */
  public ReportingTaskDTOBuilder setSchedulingPeriod(final String schedulingPeriod) {
    this.schedulingPeriod = schedulingPeriod;
    return this;
  }

  /**
   * The scheduling strategy that determines how the schedulingPeriod value should be interpreted.
   */
  public String getSchedulingStrategy() {
    return schedulingStrategy;
  }

  /**
   * The scheduling strategy that determines how the schedulingPeriod value should be interpreted.
   */
  public ReportingTaskDTOBuilder setSchedulingStrategy(final String schedulingStrategy) {
    this.schedulingStrategy = schedulingStrategy;
    return this;
  }

  /**
   * The state of the reporting task.
   */
  public String getState() {
    return state;
  }

  /**
   * The state of the reporting task.
   */
  public ReportingTaskDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * The fully qualified type of the reporting task.
   */
  public String getType() {
    return type;
  }

  /**
   * The fully qualified type of the reporting task.
   */
  public ReportingTaskDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  /**
   * Gets the validation errors from the reporting task. These validation errors represent the problems with the reporting task that must be resolved before it can be scheduled to run.
   */
  public Collection<String> getValidationErrors() {
    return validationErrors;
  }

  /**
   * Gets the validation errors from the reporting task. These validation errors represent the problems with the reporting task that must be resolved before it can be scheduled to run.
   */
  public ReportingTaskDTOBuilder setValidationErrors(final Collection<String> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  /**
   * Indicates whether the Processor is valid, invalid, or still in the process of validating (i.e., it is unknown whether or not the Processor is valid)
   */
  public String getValidationStatus() {
    return validationStatus;
  }

  /**
   * Indicates whether the Processor is valid, invalid, or still in the process of validating (i.e., it is unknown whether or not the Processor is valid)
   */
  public ReportingTaskDTOBuilder setValidationStatus(final String validationStatus) {
    this.validationStatus = validationStatus;
    return this;
  }

  public ReportingTaskDTO build() {
    final ReportingTaskDTO reportingTaskDTO = new ReportingTaskDTO();
    super.setPropertyValues(reportingTaskDTO);
    reportingTaskDTO.setActiveThreadCount(activeThreadCount);
    reportingTaskDTO.setAnnotationData(annotationData);
    reportingTaskDTO.setBundle(bundle);
    reportingTaskDTO.setComments(comments);
    reportingTaskDTO.setCustomUiUrl(customUiUrl);
    reportingTaskDTO.setDefaultSchedulingPeriod(defaultSchedulingPeriod);
    reportingTaskDTO.setDeprecated(deprecated);
    reportingTaskDTO.setDescriptors(descriptors);
    reportingTaskDTO.setMultipleVersionsAvailable(multipleVersionsAvailable);
    reportingTaskDTO.setName(name);
    reportingTaskDTO.setPersistsState(persistsState);
    reportingTaskDTO.setProperties(properties);
    reportingTaskDTO.setRestricted(restricted);
    reportingTaskDTO.setSchedulingPeriod(schedulingPeriod);
    reportingTaskDTO.setSchedulingStrategy(schedulingStrategy);
    reportingTaskDTO.setState(state);
    reportingTaskDTO.setType(type);
    reportingTaskDTO.setValidationErrors(validationErrors);
    reportingTaskDTO.setValidationStatus(validationStatus);
    return reportingTaskDTO;
  }

  public static ReportingTaskDTOBuilder of(final ReportingTaskDTO reportingTaskDTO) {
    final ReportingTaskDTOBuilder reportingTaskDTOBuilder = new ReportingTaskDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(reportingTaskDTOBuilder, reportingTaskDTO);
    reportingTaskDTOBuilder.setActiveThreadCount(reportingTaskDTO.getActiveThreadCount());
    reportingTaskDTOBuilder.setAnnotationData(reportingTaskDTO.getAnnotationData());
    reportingTaskDTOBuilder.setBundle(reportingTaskDTO.getBundle());
    reportingTaskDTOBuilder.setComments(reportingTaskDTO.getComments());
    reportingTaskDTOBuilder.setCustomUiUrl(reportingTaskDTO.getCustomUiUrl());
    reportingTaskDTOBuilder.setDefaultSchedulingPeriod(reportingTaskDTO.getDefaultSchedulingPeriod());
    reportingTaskDTOBuilder.setDeprecated(reportingTaskDTO.getDeprecated());
    reportingTaskDTOBuilder.setDescriptors(reportingTaskDTO.getDescriptors());
    reportingTaskDTOBuilder.setMultipleVersionsAvailable(reportingTaskDTO.getMultipleVersionsAvailable());
    reportingTaskDTOBuilder.setName(reportingTaskDTO.getName());
    reportingTaskDTOBuilder.setPersistsState(reportingTaskDTO.getPersistsState());
    reportingTaskDTOBuilder.setProperties(reportingTaskDTO.getProperties());
    reportingTaskDTOBuilder.setRestricted(reportingTaskDTO.getRestricted());
    reportingTaskDTOBuilder.setSchedulingPeriod(reportingTaskDTO.getSchedulingPeriod());
    reportingTaskDTOBuilder.setSchedulingStrategy(reportingTaskDTO.getSchedulingStrategy());
    reportingTaskDTOBuilder.setState(reportingTaskDTO.getState());
    reportingTaskDTOBuilder.setType(reportingTaskDTO.getType());
    reportingTaskDTOBuilder.setValidationErrors(reportingTaskDTO.getValidationErrors());
    reportingTaskDTOBuilder.setValidationStatus(reportingTaskDTO.getValidationStatus());
    return reportingTaskDTOBuilder;
  }
}
