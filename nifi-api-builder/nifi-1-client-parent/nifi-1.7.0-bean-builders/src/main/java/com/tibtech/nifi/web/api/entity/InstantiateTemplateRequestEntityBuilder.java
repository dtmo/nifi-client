package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.entity.InstantiateTemplateRequestEntity;

public final class InstantiateTemplateRequestEntityBuilder extends AbstractEntityBuilder<InstantiateTemplateRequestEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private String encodingVersion;

  private Double originX;

  private Double originY;

  private FlowSnippetDTO snippet;

  private String templateId;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public InstantiateTemplateRequestEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The encoding version of the flow snippet. If not specified, this is automatically populated by the node receiving the user request. If the snippet is specified, the version will be the latest. If the snippet is not specified, the version will come from the underlying template. These details need to be replicated throughout the cluster to ensure consistency.
   */
  public String getEncodingVersion() {
    return encodingVersion;
  }

  /**
   * The encoding version of the flow snippet. If not specified, this is automatically populated by the node receiving the user request. If the snippet is specified, the version will be the latest. If the snippet is not specified, the version will come from the underlying template. These details need to be replicated throughout the cluster to ensure consistency.
   */
  public InstantiateTemplateRequestEntityBuilder setEncodingVersion(final String encodingVersion) {
    this.encodingVersion = encodingVersion;
    return this;
  }

  /**
   * The x coordinate of the origin of the bounding box where the new components will be placed.
   */
  public Double getOriginX() {
    return originX;
  }

  /**
   * The x coordinate of the origin of the bounding box where the new components will be placed.
   */
  public InstantiateTemplateRequestEntityBuilder setOriginX(final Double originX) {
    this.originX = originX;
    return this;
  }

  /**
   * The y coordinate of the origin of the bounding box where the new components will be placed.
   */
  public Double getOriginY() {
    return originY;
  }

  /**
   * The y coordinate of the origin of the bounding box where the new components will be placed.
   */
  public InstantiateTemplateRequestEntityBuilder setOriginY(final Double originY) {
    this.originY = originY;
    return this;
  }

  /**
   * A flow snippet of the template contents. If not specified, this is automatically populated by the node receiving the user request. These details need to be replicated throughout the cluster to ensure consistency.
   */
  public FlowSnippetDTO getSnippet() {
    return snippet;
  }

  /**
   * A flow snippet of the template contents. If not specified, this is automatically populated by the node receiving the user request. These details need to be replicated throughout the cluster to ensure consistency.
   */
  public InstantiateTemplateRequestEntityBuilder setSnippet(final FlowSnippetDTO snippet) {
    this.snippet = snippet;
    return this;
  }

  /**
   * The identifier of the template.
   */
  public String getTemplateId() {
    return templateId;
  }

  /**
   * The identifier of the template.
   */
  public InstantiateTemplateRequestEntityBuilder setTemplateId(final String templateId) {
    this.templateId = templateId;
    return this;
  }

  public InstantiateTemplateRequestEntity build() {
    final InstantiateTemplateRequestEntity instantiateTemplateRequestEntity = new InstantiateTemplateRequestEntity();
    super.setPropertyValues(instantiateTemplateRequestEntity);
    instantiateTemplateRequestEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    instantiateTemplateRequestEntity.setEncodingVersion(encodingVersion);
    instantiateTemplateRequestEntity.setOriginX(originX);
    instantiateTemplateRequestEntity.setOriginY(originY);
    instantiateTemplateRequestEntity.setSnippet(snippet);
    instantiateTemplateRequestEntity.setTemplateId(templateId);
    return instantiateTemplateRequestEntity;
  }

  public static InstantiateTemplateRequestEntityBuilder of(final InstantiateTemplateRequestEntity instantiateTemplateRequestEntity) {
    final InstantiateTemplateRequestEntityBuilder instantiateTemplateRequestEntityBuilder = new InstantiateTemplateRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(instantiateTemplateRequestEntityBuilder, instantiateTemplateRequestEntity);
    instantiateTemplateRequestEntityBuilder.setDisconnectedNodeAcknowledged(instantiateTemplateRequestEntity.isDisconnectedNodeAcknowledged());
    instantiateTemplateRequestEntityBuilder.setEncodingVersion(instantiateTemplateRequestEntity.getEncodingVersion());
    instantiateTemplateRequestEntityBuilder.setOriginX(instantiateTemplateRequestEntity.getOriginX());
    instantiateTemplateRequestEntityBuilder.setOriginY(instantiateTemplateRequestEntity.getOriginY());
    instantiateTemplateRequestEntityBuilder.setSnippet(instantiateTemplateRequestEntity.getSnippet());
    instantiateTemplateRequestEntityBuilder.setTemplateId(instantiateTemplateRequestEntity.getTemplateId());
    return instantiateTemplateRequestEntityBuilder;
  }
}
