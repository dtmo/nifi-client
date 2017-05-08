package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.provenance.ProvenanceOptionsDTO;
import org.apache.nifi.web.api.entity.ProvenanceOptionsEntity;

public final class ProvenanceOptionsEntityBuilder extends AbstractEntityBuilder<ProvenanceOptionsEntityBuilder> {
  private ProvenanceOptionsDTO provenanceOptions;

  public ProvenanceOptionsDTO getProvenanceOptions() {
    return provenanceOptions;
  }

  public ProvenanceOptionsEntityBuilder setProvenanceOptions(final ProvenanceOptionsDTO provenanceOptions) {
    this.provenanceOptions = provenanceOptions;
    return this;
  }

  public ProvenanceOptionsEntity build() {
    final ProvenanceOptionsEntity provenanceOptionsEntity = new ProvenanceOptionsEntity();
    super.setPropertyValues(provenanceOptionsEntity);
    provenanceOptionsEntity.setProvenanceOptions(provenanceOptions);
    return provenanceOptionsEntity;
  }

  public static ProvenanceOptionsEntityBuilder of(final ProvenanceOptionsEntity provenanceOptionsEntity) {
    final ProvenanceOptionsEntityBuilder provenanceOptionsEntityBuilder = new ProvenanceOptionsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(provenanceOptionsEntityBuilder, provenanceOptionsEntity);
    provenanceOptionsEntityBuilder.setProvenanceOptions(provenanceOptionsEntity.getProvenanceOptions());
    return provenanceOptionsEntityBuilder;
  }
}
