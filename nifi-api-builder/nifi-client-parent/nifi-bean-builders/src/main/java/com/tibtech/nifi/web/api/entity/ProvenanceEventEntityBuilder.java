package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.provenance.ProvenanceEventDTO;
import org.apache.nifi.web.api.entity.ProvenanceEventEntity;

public final class ProvenanceEventEntityBuilder extends AbstractEntityBuilder<ProvenanceEventEntityBuilder> {
  private ProvenanceEventDTO provenanceEvent;

  public ProvenanceEventDTO getProvenanceEvent() {
    return provenanceEvent;
  }

  public ProvenanceEventEntityBuilder setProvenanceEvent(final ProvenanceEventDTO provenanceEvent) {
    this.provenanceEvent = provenanceEvent;
    return this;
  }

  public ProvenanceEventEntity build() {
    final ProvenanceEventEntity provenanceEventEntity = new ProvenanceEventEntity();
    super.setPropertyValues(provenanceEventEntity);
    provenanceEventEntity.setProvenanceEvent(provenanceEvent);
    return provenanceEventEntity;
  }

  public static ProvenanceEventEntityBuilder of(final ProvenanceEventEntity provenanceEventEntity) {
    final ProvenanceEventEntityBuilder provenanceEventEntityBuilder = new ProvenanceEventEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(provenanceEventEntityBuilder, provenanceEventEntity);
    provenanceEventEntityBuilder.setProvenanceEvent(provenanceEventEntity.getProvenanceEvent());
    return provenanceEventEntityBuilder;
  }
}
