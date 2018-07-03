package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.entity.FlowSnippetEntity;

public final class FlowSnippetEntityBuilder extends AbstractEntityBuilder<FlowSnippetEntityBuilder> {
  private FlowSnippetDTO contents;

  public FlowSnippetDTO getContents() {
    return contents;
  }

  public FlowSnippetEntityBuilder setContents(final FlowSnippetDTO contents) {
    this.contents = contents;
    return this;
  }

  public FlowSnippetEntity build() {
    final FlowSnippetEntity flowSnippetEntity = new FlowSnippetEntity();
    super.setPropertyValues(flowSnippetEntity);
    flowSnippetEntity.setContents(contents);
    return flowSnippetEntity;
  }

  public static FlowSnippetEntityBuilder of(final FlowSnippetEntity flowSnippetEntity) {
    final FlowSnippetEntityBuilder flowSnippetEntityBuilder = new FlowSnippetEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(flowSnippetEntityBuilder, flowSnippetEntity);
    flowSnippetEntityBuilder.setContents(flowSnippetEntity.getContents());
    return flowSnippetEntityBuilder;
  }
}
