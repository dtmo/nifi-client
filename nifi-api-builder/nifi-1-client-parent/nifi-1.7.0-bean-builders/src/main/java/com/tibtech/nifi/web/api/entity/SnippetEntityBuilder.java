package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.SnippetDTO;
import org.apache.nifi.web.api.entity.SnippetEntity;

public final class SnippetEntityBuilder extends AbstractEntityBuilder<SnippetEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private SnippetDTO snippet;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public SnippetEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

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
    snippetEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    snippetEntity.setSnippet(snippet);
    return snippetEntity;
  }

  public static SnippetEntityBuilder of(final SnippetEntity snippetEntity) {
    final SnippetEntityBuilder snippetEntityBuilder = new SnippetEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(snippetEntityBuilder, snippetEntity);
    snippetEntityBuilder.setDisconnectedNodeAcknowledged(snippetEntity.isDisconnectedNodeAcknowledged());
    snippetEntityBuilder.setSnippet(snippetEntity.getSnippet());
    return snippetEntityBuilder;
  }
}
