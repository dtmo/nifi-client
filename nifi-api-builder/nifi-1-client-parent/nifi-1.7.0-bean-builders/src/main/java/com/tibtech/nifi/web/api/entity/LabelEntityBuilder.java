package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.DimensionsDTO;
import org.apache.nifi.web.api.dto.LabelDTO;
import org.apache.nifi.web.api.entity.LabelEntity;

public final class LabelEntityBuilder extends AbstractComponentEntityBuilder<LabelEntityBuilder> {
  private LabelDTO component;

  private DimensionsDTO dimensions;

  public LabelDTO getComponent() {
    return component;
  }

  public LabelEntityBuilder setComponent(final LabelDTO component) {
    this.component = component;
    return this;
  }

  public DimensionsDTO getDimensions() {
    return dimensions;
  }

  public LabelEntityBuilder setDimensions(final DimensionsDTO dimensions) {
    this.dimensions = dimensions;
    return this;
  }

  public LabelEntity build() {
    final LabelEntity labelEntity = new LabelEntity();
    super.setPropertyValues(labelEntity);
    labelEntity.setComponent(component);
    labelEntity.setDimensions(dimensions);
    return labelEntity;
  }

  public static LabelEntityBuilder of(final LabelEntity labelEntity) {
    final LabelEntityBuilder labelEntityBuilder = new LabelEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(labelEntityBuilder, labelEntity);
    labelEntityBuilder.setComponent(labelEntity.getComponent());
    labelEntityBuilder.setDimensions(labelEntity.getDimensions());
    return labelEntityBuilder;
  }
}
