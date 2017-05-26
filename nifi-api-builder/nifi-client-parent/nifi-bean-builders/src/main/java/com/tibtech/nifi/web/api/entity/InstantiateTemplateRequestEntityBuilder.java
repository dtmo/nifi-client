package com.tibtech.nifi.web.api.entity;

import java.lang.Double;
import java.lang.String;
import org.apache.nifi.web.api.entity.InstantiateTemplateRequestEntity;

public final class InstantiateTemplateRequestEntityBuilder extends AbstractEntityBuilder<InstantiateTemplateRequestEntityBuilder> {
  private Double originX;

  private Double originY;

  private String templateId;

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
    instantiateTemplateRequestEntity.setOriginX(originX);
    instantiateTemplateRequestEntity.setOriginY(originY);
    instantiateTemplateRequestEntity.setTemplateId(templateId);
    return instantiateTemplateRequestEntity;
  }

  public static InstantiateTemplateRequestEntityBuilder of(final InstantiateTemplateRequestEntity instantiateTemplateRequestEntity) {
    final InstantiateTemplateRequestEntityBuilder instantiateTemplateRequestEntityBuilder = new InstantiateTemplateRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(instantiateTemplateRequestEntityBuilder, instantiateTemplateRequestEntity);
    instantiateTemplateRequestEntityBuilder.setOriginX(instantiateTemplateRequestEntity.getOriginX());
    instantiateTemplateRequestEntityBuilder.setOriginY(instantiateTemplateRequestEntity.getOriginY());
    instantiateTemplateRequestEntityBuilder.setTemplateId(instantiateTemplateRequestEntity.getTemplateId());
    return instantiateTemplateRequestEntityBuilder;
  }
}
