package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.entity.CreateTemplateRequestEntity;

public final class CreateTemplateRequestEntityBuilder extends AbstractEntityBuilder<CreateTemplateRequestEntityBuilder> {
  private String description;

  private String name;

  private String snippetId;

  /**
   * The description of the template.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the template.
   */
  public CreateTemplateRequestEntityBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The name of the template.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the template.
   */
  public CreateTemplateRequestEntityBuilder setName(final String name) {
    this.name = name;
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
  public CreateTemplateRequestEntityBuilder setSnippetId(final String snippetId) {
    this.snippetId = snippetId;
    return this;
  }

  public CreateTemplateRequestEntity build() {
    final CreateTemplateRequestEntity createTemplateRequestEntity = new CreateTemplateRequestEntity();
    super.setPropertyValues(createTemplateRequestEntity);
    createTemplateRequestEntity.setDescription(description);
    createTemplateRequestEntity.setName(name);
    createTemplateRequestEntity.setSnippetId(snippetId);
    return createTemplateRequestEntity;
  }

  public static CreateTemplateRequestEntityBuilder of(final CreateTemplateRequestEntity createTemplateRequestEntity) {
    final CreateTemplateRequestEntityBuilder createTemplateRequestEntityBuilder = new CreateTemplateRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(createTemplateRequestEntityBuilder, createTemplateRequestEntity);
    createTemplateRequestEntityBuilder.setDescription(createTemplateRequestEntity.getDescription());
    createTemplateRequestEntityBuilder.setName(createTemplateRequestEntity.getName());
    createTemplateRequestEntityBuilder.setSnippetId(createTemplateRequestEntity.getSnippetId());
    return createTemplateRequestEntityBuilder;
  }
}
