package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.apache.nifi.web.api.entity.PrioritizerTypesEntity;

public final class PrioritizerTypesEntityBuilder extends AbstractEntityBuilder<PrioritizerTypesEntityBuilder> {
  private Set<DocumentedTypeDTO> prioritizerTypes;

  public Set<DocumentedTypeDTO> getPrioritizerTypes() {
    return prioritizerTypes;
  }

  public PrioritizerTypesEntityBuilder setPrioritizerTypes(final Set<DocumentedTypeDTO> prioritizerTypes) {
    this.prioritizerTypes = prioritizerTypes;
    return this;
  }

  public PrioritizerTypesEntity build() {
    final PrioritizerTypesEntity prioritizerTypesEntity = new PrioritizerTypesEntity();
    super.setPropertyValues(prioritizerTypesEntity);
    prioritizerTypesEntity.setPrioritizerTypes(prioritizerTypes);
    return prioritizerTypesEntity;
  }

  public static PrioritizerTypesEntityBuilder of(final PrioritizerTypesEntity prioritizerTypesEntity) {
    final PrioritizerTypesEntityBuilder prioritizerTypesEntityBuilder = new PrioritizerTypesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(prioritizerTypesEntityBuilder, prioritizerTypesEntity);
    prioritizerTypesEntityBuilder.setPrioritizerTypes(prioritizerTypesEntity.getPrioritizerTypes());
    return prioritizerTypesEntityBuilder;
  }
}
