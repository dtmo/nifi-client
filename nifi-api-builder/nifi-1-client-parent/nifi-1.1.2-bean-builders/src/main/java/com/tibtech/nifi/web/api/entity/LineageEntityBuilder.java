package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.provenance.lineage.LineageDTO;
import org.apache.nifi.web.api.entity.LineageEntity;

public final class LineageEntityBuilder extends AbstractEntityBuilder<LineageEntityBuilder> {
  private LineageDTO lineage;

  public LineageDTO getLineage() {
    return lineage;
  }

  public LineageEntityBuilder setLineage(final LineageDTO lineage) {
    this.lineage = lineage;
    return this;
  }

  public LineageEntity build() {
    final LineageEntity lineageEntity = new LineageEntity();
    super.setPropertyValues(lineageEntity);
    lineageEntity.setLineage(lineage);
    return lineageEntity;
  }

  public static LineageEntityBuilder of(final LineageEntity lineageEntity) {
    final LineageEntityBuilder lineageEntityBuilder = new LineageEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(lineageEntityBuilder, lineageEntity);
    lineageEntityBuilder.setLineage(lineageEntity.getLineage());
    return lineageEntityBuilder;
  }
}
