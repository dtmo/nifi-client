package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.SnippetDTO;
import org.apache.nifi.web.api.entity.SnippetEntity;

public final class SnippetEntityBuilder extends AbstractEntityBuilder<SnippetEntityBuilder> {
  private SnippetDTO snippet;

  /**
   * The snippet.
   */
  public SnippetDTO getSnippet() {
    return snippet;
  }

  /**
   * The snippet.
   */
  public SnippetEntityBuilder setSnippet(final SnippetDTO snippet) {
    this.snippet = snippet;
    return this;
  }

  public SnippetEntity build() {
    final SnippetEntity snippetEntity = new SnippetEntity();
    super.setPropertyValues(snippetEntity);
    snippetEntity.setSnippet(snippet);
    return snippetEntity;
  }

  public static SnippetEntityBuilder of(final SnippetEntity snippetEntity) {
    final SnippetEntityBuilder snippetEntityBuilder = new SnippetEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(snippetEntityBuilder, snippetEntity);
    snippetEntityBuilder.setSnippet(snippetEntity.getSnippet());
    return snippetEntityBuilder;
  }
}
