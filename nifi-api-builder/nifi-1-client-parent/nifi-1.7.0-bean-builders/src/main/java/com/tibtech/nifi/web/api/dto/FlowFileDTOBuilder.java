package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.FlowFileDTO;

public final class FlowFileDTOBuilder extends AbstractFlowFileSummaryDTOBuilder<FlowFileDTOBuilder> {
  private Map<String, String> attributes;

  private String contentClaimContainer;

  private String contentClaimFileSize;

  private Long contentClaimFileSizeBytes;

  private String contentClaimIdentifier;

  private Long contentClaimOffset;

  private String contentClaimSection;

  /**
   * The FlowFile attributes.
   */
  public Map<String, String> getAttributes() {
    return attributes;
  }

  /**
   * The FlowFile attributes.
   */
  public FlowFileDTOBuilder setAttributes(final Map<String, String> attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * The container in which the content claim lives.
   */
  public String getContentClaimContainer() {
    return contentClaimContainer;
  }

  /**
   * The container in which the content claim lives.
   */
  public FlowFileDTOBuilder setContentClaimContainer(final String contentClaimContainer) {
    this.contentClaimContainer = contentClaimContainer;
    return this;
  }

  /**
   * The file size of the content claim formatted.
   */
  public String getContentClaimFileSize() {
    return contentClaimFileSize;
  }

  /**
   * The file size of the content claim formatted.
   */
  public FlowFileDTOBuilder setContentClaimFileSize(final String contentClaimFileSize) {
    this.contentClaimFileSize = contentClaimFileSize;
    return this;
  }

  /**
   * The file size of the content claim in bytes.
   */
  public Long getContentClaimFileSizeBytes() {
    return contentClaimFileSizeBytes;
  }

  /**
   * The file size of the content claim in bytes.
   */
  public FlowFileDTOBuilder setContentClaimFileSizeBytes(final Long contentClaimFileSizeBytes) {
    this.contentClaimFileSizeBytes = contentClaimFileSizeBytes;
    return this;
  }

  /**
   * The identifier of the content claim.
   */
  public String getContentClaimIdentifier() {
    return contentClaimIdentifier;
  }

  /**
   * The identifier of the content claim.
   */
  public FlowFileDTOBuilder setContentClaimIdentifier(final String contentClaimIdentifier) {
    this.contentClaimIdentifier = contentClaimIdentifier;
    return this;
  }

  /**
   * The offset into the content claim where the flowfile's content begins.
   */
  public Long getContentClaimOffset() {
    return contentClaimOffset;
  }

  /**
   * The offset into the content claim where the flowfile's content begins.
   */
  public FlowFileDTOBuilder setContentClaimOffset(final Long contentClaimOffset) {
    this.contentClaimOffset = contentClaimOffset;
    return this;
  }

  /**
   * The section in which the content claim lives.
   */
  public String getContentClaimSection() {
    return contentClaimSection;
  }

  /**
   * The section in which the content claim lives.
   */
  public FlowFileDTOBuilder setContentClaimSection(final String contentClaimSection) {
    this.contentClaimSection = contentClaimSection;
    return this;
  }

  public FlowFileDTO build() {
    final FlowFileDTO flowFileDTO = new FlowFileDTO();
    super.setPropertyValues(flowFileDTO);
    flowFileDTO.setAttributes(attributes);
    flowFileDTO.setContentClaimContainer(contentClaimContainer);
    flowFileDTO.setContentClaimFileSize(contentClaimFileSize);
    flowFileDTO.setContentClaimFileSizeBytes(contentClaimFileSizeBytes);
    flowFileDTO.setContentClaimIdentifier(contentClaimIdentifier);
    flowFileDTO.setContentClaimOffset(contentClaimOffset);
    flowFileDTO.setContentClaimSection(contentClaimSection);
    return flowFileDTO;
  }

  public static FlowFileDTOBuilder of(final FlowFileDTO flowFileDTO) {
    final FlowFileDTOBuilder flowFileDTOBuilder = new FlowFileDTOBuilder();
    AbstractFlowFileSummaryDTOBuilder.setBuilderValues(flowFileDTOBuilder, flowFileDTO);
    flowFileDTOBuilder.setAttributes(flowFileDTO.getAttributes());
    flowFileDTOBuilder.setContentClaimContainer(flowFileDTO.getContentClaimContainer());
    flowFileDTOBuilder.setContentClaimFileSize(flowFileDTO.getContentClaimFileSize());
    flowFileDTOBuilder.setContentClaimFileSizeBytes(flowFileDTO.getContentClaimFileSizeBytes());
    flowFileDTOBuilder.setContentClaimIdentifier(flowFileDTO.getContentClaimIdentifier());
    flowFileDTOBuilder.setContentClaimOffset(flowFileDTO.getContentClaimOffset());
    flowFileDTOBuilder.setContentClaimSection(flowFileDTO.getContentClaimSection());
    return flowFileDTOBuilder;
  }
}
