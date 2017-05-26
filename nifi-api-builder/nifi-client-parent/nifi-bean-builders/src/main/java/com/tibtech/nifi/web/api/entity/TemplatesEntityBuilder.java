package com.tibtech.nifi.web.api.entity;

import java.util.Date;
import java.util.Set;
import org.apache.nifi.web.api.entity.TemplateEntity;
import org.apache.nifi.web.api.entity.TemplatesEntity;

public final class TemplatesEntityBuilder extends AbstractEntityBuilder<TemplatesEntityBuilder> {
  private Date generated;

  private Set<TemplateEntity> templates;

  /**
   * When this content was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * When this content was generated.
   */
  public TemplatesEntityBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  public Set<TemplateEntity> getTemplates() {
    return templates;
  }

  public TemplatesEntityBuilder setTemplates(final Set<TemplateEntity> templates) {
    this.templates = templates;
    return this;
  }

  public TemplatesEntity build() {
    final TemplatesEntity templatesEntity = new TemplatesEntity();
    super.setPropertyValues(templatesEntity);
    templatesEntity.setGenerated(generated);
    templatesEntity.setTemplates(templates);
    return templatesEntity;
  }

  public static TemplatesEntityBuilder of(final TemplatesEntity templatesEntity) {
    final TemplatesEntityBuilder templatesEntityBuilder = new TemplatesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(templatesEntityBuilder, templatesEntity);
    templatesEntityBuilder.setGenerated(templatesEntity.getGenerated());
    templatesEntityBuilder.setTemplates(templatesEntity.getTemplates());
    return templatesEntityBuilder;
  }
}
