package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.BundleDTO;
import org.apache.nifi.web.api.dto.ProcessorConfigDTO;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.RelationshipDTO;

public final class ProcessorDTOBuilder extends AbstractComponentDTOBuilder<ProcessorDTOBuilder> {
  private BundleDTO bundle;

  private ProcessorConfigDTO config;

  private Boolean deprecated;

  private String description;

  private Boolean executionNodeRestricted;

  private String inputRequirement;

  private Boolean multipleVersionsAvailable;

  private String name;

  private Boolean persistsState;

  private List<RelationshipDTO> relationships;

  private Boolean restricted;

  private String state;

  private Map<String, String> style;

  private Boolean supportsBatching;

  private Boolean supportsEventDriven;

  private Boolean supportsParallelProcessing;

  private String type;

  private Collection<String> validationErrors;

  private String validationStatus;

  /**
   * The details of the artifact that bundled this processor type.
   */
  public BundleDTO getBundle() {
    return bundle;
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public ProcessorDTOBuilder setBundle(final BundleDTO bundle) {
    this.bundle = bundle;
    return this;
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public ProcessorDTOBuilder setBundle(final Consumer<BundleDTOBuilder> configurator) {
    final BundleDTOBuilder builder = (bundle != null ? BundleDTOBuilder.of(bundle) : new BundleDTOBuilder());
    configurator.accept(builder);
    return setBundle(builder.build());
  }

  /**
   * The details of the artifact that bundled this processor type.
   */
  public ProcessorDTOBuilder setBundle(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BundleDTOBuilder.class) final Closure<BundleDTOBuilder> closure) {
    return setBundle(c -> {
      final Closure<BundleDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The configuration details for the processor. These details will be included in a response if the verbose flag is included in a request.
   */
  public ProcessorConfigDTO getConfig() {
    return config;
  }

  /**
   * The configuration details for the processor. These details will be included in a response if the verbose flag is included in a request.
   */
  public ProcessorDTOBuilder setConfig(final ProcessorConfigDTO config) {
    this.config = config;
    return this;
  }

  /**
   * The configuration details for the processor. These details will be included in a response if the verbose flag is included in a request.
   */
  public ProcessorDTOBuilder setConfig(final Consumer<ProcessorConfigDTOBuilder> configurator) {
    final ProcessorConfigDTOBuilder builder = (config != null ? ProcessorConfigDTOBuilder.of(config) : new ProcessorConfigDTOBuilder());
    configurator.accept(builder);
    return setConfig(builder.build());
  }

  /**
   * The configuration details for the processor. These details will be included in a response if the verbose flag is included in a request.
   */
  public ProcessorDTOBuilder setConfig(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorConfigDTOBuilder.class) final Closure<ProcessorConfigDTOBuilder> closure) {
    return setConfig(c -> {
      final Closure<ProcessorConfigDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Whether the processor has been deprecated.
   */
  public Boolean getDeprecated() {
    return deprecated;
  }

  /**
   * Whether the processor has been deprecated.
   */
  public ProcessorDTOBuilder setDeprecated(final Boolean deprecated) {
    this.deprecated = deprecated;
    return this;
  }

  /**
   * The description of the processor.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the processor.
   */
  public ProcessorDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * Indicates if the execution node of a processor is restricted to run only on the primary node
   */
  public Boolean getExecutionNodeRestricted() {
    return executionNodeRestricted;
  }

  /**
   * Indicates if the execution node of a processor is restricted to run only on the primary node
   */
  public ProcessorDTOBuilder setExecutionNodeRestricted(final Boolean executionNodeRestricted) {
    this.executionNodeRestricted = executionNodeRestricted;
    return this;
  }

  /**
   * The input requirement for this processor.
   */
  public String getInputRequirement() {
    return inputRequirement;
  }

  /**
   * The input requirement for this processor.
   */
  public ProcessorDTOBuilder setInputRequirement(final String inputRequirement) {
    this.inputRequirement = inputRequirement;
    return this;
  }

  /**
   * Whether the processor has multiple versions available.
   */
  public Boolean getMultipleVersionsAvailable() {
    return multipleVersionsAvailable;
  }

  /**
   * Whether the processor has multiple versions available.
   */
  public ProcessorDTOBuilder setMultipleVersionsAvailable(final Boolean multipleVersionsAvailable) {
    this.multipleVersionsAvailable = multipleVersionsAvailable;
    return this;
  }

  /**
   * The name of the processor.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the processor.
   */
  public ProcessorDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Whether the processor persists state.
   */
  public Boolean getPersistsState() {
    return persistsState;
  }

  /**
   * Whether the processor persists state.
   */
  public ProcessorDTOBuilder setPersistsState(final Boolean persistsState) {
    this.persistsState = persistsState;
    return this;
  }

  /**
   * The available relationships that the processor currently supports.
   */
  public List<RelationshipDTO> getRelationships() {
    return relationships;
  }

  /**
   * The available relationships that the processor currently supports.
   */
  public ProcessorDTOBuilder setRelationships(final List<RelationshipDTO> relationships) {
    this.relationships = relationships;
    return this;
  }

  /**
   * Whether the processor requires elevated privileges.
   */
  public Boolean getRestricted() {
    return restricted;
  }

  /**
   * Whether the processor requires elevated privileges.
   */
  public ProcessorDTOBuilder setRestricted(final Boolean restricted) {
    this.restricted = restricted;
    return this;
  }

  /**
   * The state of the processor
   */
  public String getState() {
    return state;
  }

  /**
   * The state of the processor
   */
  public ProcessorDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * Styles for the processor (background-color : #eee).
   */
  public Map<String, String> getStyle() {
    return style;
  }

  /**
   * Styles for the processor (background-color : #eee).
   */
  public ProcessorDTOBuilder setStyle(final Map<String, String> style) {
    this.style = style;
    return this;
  }

  /**
   * Whether the processor supports batching. This makes the run duration settings available.
   */
  public Boolean getSupportsBatching() {
    return supportsBatching;
  }

  /**
   * Whether the processor supports batching. This makes the run duration settings available.
   */
  public ProcessorDTOBuilder setSupportsBatching(final Boolean supportsBatching) {
    this.supportsBatching = supportsBatching;
    return this;
  }

  /**
   * Whether the processor supports event driven scheduling.
   */
  public Boolean getSupportsEventDriven() {
    return supportsEventDriven;
  }

  /**
   * Whether the processor supports event driven scheduling.
   */
  public ProcessorDTOBuilder setSupportsEventDriven(final Boolean supportsEventDriven) {
    this.supportsEventDriven = supportsEventDriven;
    return this;
  }

  /**
   * Whether the processor supports parallel processing.
   */
  public Boolean getSupportsParallelProcessing() {
    return supportsParallelProcessing;
  }

  /**
   * Whether the processor supports parallel processing.
   */
  public ProcessorDTOBuilder setSupportsParallelProcessing(
      final Boolean supportsParallelProcessing) {
    this.supportsParallelProcessing = supportsParallelProcessing;
    return this;
  }

  /**
   * The type of the processor.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the processor.
   */
  public ProcessorDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  /**
   * The validation errors for the processor. These validation errors represent the problems with the processor that must be resolved before it can be started.
   */
  public Collection<String> getValidationErrors() {
    return validationErrors;
  }

  /**
   * The validation errors for the processor. These validation errors represent the problems with the processor that must be resolved before it can be started.
   */
  public ProcessorDTOBuilder setValidationErrors(final Collection<String> validationErrors) {
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
  public ProcessorDTOBuilder setValidationStatus(final String validationStatus) {
    this.validationStatus = validationStatus;
    return this;
  }

  public ProcessorDTO build() {
    final ProcessorDTO processorDTO = new ProcessorDTO();
    super.setPropertyValues(processorDTO);
    processorDTO.setBundle(bundle);
    processorDTO.setConfig(config);
    processorDTO.setDeprecated(deprecated);
    processorDTO.setDescription(description);
    processorDTO.setExecutionNodeRestricted(executionNodeRestricted);
    processorDTO.setInputRequirement(inputRequirement);
    processorDTO.setMultipleVersionsAvailable(multipleVersionsAvailable);
    processorDTO.setName(name);
    processorDTO.setPersistsState(persistsState);
    processorDTO.setRelationships(relationships);
    processorDTO.setRestricted(restricted);
    processorDTO.setState(state);
    processorDTO.setStyle(style);
    processorDTO.setSupportsBatching(supportsBatching);
    processorDTO.setSupportsEventDriven(supportsEventDriven);
    processorDTO.setSupportsParallelProcessing(supportsParallelProcessing);
    processorDTO.setType(type);
    processorDTO.setValidationErrors(validationErrors);
    processorDTO.setValidationStatus(validationStatus);
    return processorDTO;
  }

  public static ProcessorDTOBuilder of(final ProcessorDTO processorDTO) {
    final ProcessorDTOBuilder processorDTOBuilder = new ProcessorDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(processorDTOBuilder, processorDTO);
    processorDTOBuilder.setBundle(processorDTO.getBundle());
    processorDTOBuilder.setConfig(processorDTO.getConfig());
    processorDTOBuilder.setDeprecated(processorDTO.getDeprecated());
    processorDTOBuilder.setDescription(processorDTO.getDescription());
    processorDTOBuilder.setExecutionNodeRestricted(processorDTO.isExecutionNodeRestricted());
    processorDTOBuilder.setInputRequirement(processorDTO.getInputRequirement());
    processorDTOBuilder.setMultipleVersionsAvailable(processorDTO.getMultipleVersionsAvailable());
    processorDTOBuilder.setName(processorDTO.getName());
    processorDTOBuilder.setPersistsState(processorDTO.getPersistsState());
    processorDTOBuilder.setRelationships(processorDTO.getRelationships());
    processorDTOBuilder.setRestricted(processorDTO.getRestricted());
    processorDTOBuilder.setState(processorDTO.getState());
    processorDTOBuilder.setStyle(processorDTO.getStyle());
    processorDTOBuilder.setSupportsBatching(processorDTO.getSupportsBatching());
    processorDTOBuilder.setSupportsEventDriven(processorDTO.getSupportsEventDriven());
    processorDTOBuilder.setSupportsParallelProcessing(processorDTO.getSupportsParallelProcessing());
    processorDTOBuilder.setType(processorDTO.getType());
    processorDTOBuilder.setValidationErrors(processorDTO.getValidationErrors());
    processorDTOBuilder.setValidationStatus(processorDTO.getValidationStatus());
    return processorDTOBuilder;
  }
}
