package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.LabelEntity;
import org.apache.nifi.web.api.entity.LabelsEntity;

public final class LabelsEntityBuilder extends AbstractEntityBuilder<LabelsEntityBuilder> {
  private Set<LabelEntity> labels;

  public Set<LabelEntity> getLabels() {
    return labels;
  }

  public LabelsEntityBuilder setLabels(final Set<LabelEntity> labels) {
    this.labels = labels;
    return this;
  }

  public LabelsEntity build() {
    final LabelsEntity labelsEntity = new LabelsEntity();
    super.setPropertyValues(labelsEntity);
    labelsEntity.setLabels(labels);
    return labelsEntity;
  }

  public static LabelsEntityBuilder of(final LabelsEntity labelsEntity) {
    final LabelsEntityBuilder labelsEntityBuilder = new LabelsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(labelsEntityBuilder, labelsEntity);
    labelsEntityBuilder.setLabels(labelsEntity.getLabels());
    return labelsEntityBuilder;
  }
}
