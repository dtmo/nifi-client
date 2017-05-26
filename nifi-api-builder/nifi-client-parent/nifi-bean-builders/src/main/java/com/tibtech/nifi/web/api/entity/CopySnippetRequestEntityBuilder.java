package com.tibtech.nifi.web.api.entity;

import java.lang.Double;
import java.lang.String;
import org.apache.nifi.web.api.entity.CopySnippetRequestEntity;

public final class CopySnippetRequestEntityBuilder extends AbstractEntityBuilder<CopySnippetRequestEntityBuilder> {
  private Double originX;

  private Double originY;

  private String snippetId;

  /**
   * The x coordinate of the origin of the bounding box where the new components will be placed.
   */
  public Double getOriginX() {
    return originX;
  }

  /**
   * The x coordinate of the origin of the bounding box where the new components will be placed.
   */
  public CopySnippetRequestEntityBuilder setOriginX(final Double originX) {
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
  public CopySnippetRequestEntityBuilder setOriginY(final Double originY) {
    this.originY = originY;
    return this;
  }

  /**
   * The identifier of the snippet.
   */
  public String getSnippetId() {
    return snippetId;
  }

  /**
   * The identifier of the snippet.
   */
  public CopySnippetRequestEntityBuilder setSnippetId(final String snippetId) {
    this.snippetId = snippetId;
    return this;
  }

  public CopySnippetRequestEntity build() {
    final CopySnippetRequestEntity copySnippetRequestEntity = new CopySnippetRequestEntity();
    super.setPropertyValues(copySnippetRequestEntity);
    copySnippetRequestEntity.setOriginX(originX);
    copySnippetRequestEntity.setOriginY(originY);
    copySnippetRequestEntity.setSnippetId(snippetId);
    return copySnippetRequestEntity;
  }

  public static CopySnippetRequestEntityBuilder of(final CopySnippetRequestEntity copySnippetRequestEntity) {
    final CopySnippetRequestEntityBuilder copySnippetRequestEntityBuilder = new CopySnippetRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(copySnippetRequestEntityBuilder, copySnippetRequestEntity);
    copySnippetRequestEntityBuilder.setOriginX(copySnippetRequestEntity.getOriginX());
    copySnippetRequestEntityBuilder.setOriginY(copySnippetRequestEntity.getOriginY());
    copySnippetRequestEntityBuilder.setSnippetId(copySnippetRequestEntity.getSnippetId());
    return copySnippetRequestEntityBuilder;
  }
}
