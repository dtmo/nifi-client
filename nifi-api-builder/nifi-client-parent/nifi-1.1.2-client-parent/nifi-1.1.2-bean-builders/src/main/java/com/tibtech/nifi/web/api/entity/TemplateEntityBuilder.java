package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.TemplateDTO;
import org.apache.nifi.web.api.entity.TemplateEntity;

public final class TemplateEntityBuilder extends AbstractComponentEntityBuilder<TemplateEntityBuilder> {
  private TemplateDTO template;

  public TemplateDTO getTemplate() {
    return template;
  }

  public TemplateEntityBuilder setTemplate(final TemplateDTO template) {
    this.template = template;
    return this;
  }

  public TemplateEntity build() {
    final TemplateEntity templateEntity = new TemplateEntity();
    super.setPropertyValues(templateEntity);
    templateEntity.setTemplate(template);
    return templateEntity;
  }

  public static TemplateEntityBuilder of(final TemplateEntity templateEntity) {
    final TemplateEntityBuilder templateEntityBuilder = new TemplateEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(templateEntityBuilder, templateEntity);
    templateEntityBuilder.setTemplate(templateEntity.getTemplate());
    return templateEntityBuilder;
  }
}
