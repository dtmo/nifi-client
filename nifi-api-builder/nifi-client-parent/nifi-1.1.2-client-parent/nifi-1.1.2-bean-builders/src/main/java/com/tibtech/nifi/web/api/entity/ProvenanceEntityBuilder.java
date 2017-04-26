package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.provenance.ProvenanceDTO;
import org.apache.nifi.web.api.entity.ProvenanceEntity;

public final class ProvenanceEntityBuilder extends AbstractEntityBuilder<ProvenanceEntityBuilder> {
  private ProvenanceDTO provenance;

  public ProvenanceDTO getProvenance() {
    return provenance;
  }

  public ProvenanceEntityBuilder setProvenance(final ProvenanceDTO provenance) {
    this.provenance = provenance;
    return this;
  }

  public ProvenanceEntity build() {
    final ProvenanceEntity provenanceEntity = new ProvenanceEntity();
    super.setPropertyValues(provenanceEntity);
    provenanceEntity.setProvenance(provenance);
    return provenanceEntity;
  }

  public static ProvenanceEntityBuilder of(final ProvenanceEntity provenanceEntity) {
    final ProvenanceEntityBuilder provenanceEntityBuilder = new ProvenanceEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(provenanceEntityBuilder, provenanceEntity);
    provenanceEntityBuilder.setProvenance(provenanceEntity.getProvenance());
    return provenanceEntityBuilder;
  }
}
