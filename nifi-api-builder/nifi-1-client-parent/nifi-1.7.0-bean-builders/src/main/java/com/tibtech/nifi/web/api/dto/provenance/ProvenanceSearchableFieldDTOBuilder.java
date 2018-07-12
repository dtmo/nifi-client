package com.tibtech.nifi.web.api.dto.provenance;

import java.lang.String;
import org.apache.nifi.web.api.dto.provenance.ProvenanceSearchableFieldDTO;

public final class ProvenanceSearchableFieldDTOBuilder {
  private String field;

  private String id;

  private String label;

  private String type;

  /**
   * The searchable field.
   */
  public String getField() {
    return field;
  }

  /**
   * The searchable field.
   */
  public ProvenanceSearchableFieldDTOBuilder setField(final String field) {
    this.field = field;
    return this;
  }

  /**
   * The id of the searchable field.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the searchable field.
   */
  public ProvenanceSearchableFieldDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The label for the searchable field.
   */
  public String getLabel() {
    return label;
  }

  /**
   * The label for the searchable field.
   */
  public ProvenanceSearchableFieldDTOBuilder setLabel(final String label) {
    this.label = label;
    return this;
  }

  /**
   * The type of the searchable field.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the searchable field.
   */
  public ProvenanceSearchableFieldDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  public ProvenanceSearchableFieldDTO build() {
    final ProvenanceSearchableFieldDTO provenanceSearchableFieldDTO = new ProvenanceSearchableFieldDTO();
    provenanceSearchableFieldDTO.setField(field);
    provenanceSearchableFieldDTO.setId(id);
    provenanceSearchableFieldDTO.setLabel(label);
    provenanceSearchableFieldDTO.setType(type);
    return provenanceSearchableFieldDTO;
  }

  public static ProvenanceSearchableFieldDTOBuilder of(
      final ProvenanceSearchableFieldDTO provenanceSearchableFieldDTO) {
    final ProvenanceSearchableFieldDTOBuilder provenanceSearchableFieldDTOBuilder = new ProvenanceSearchableFieldDTOBuilder();
    provenanceSearchableFieldDTOBuilder.setField(provenanceSearchableFieldDTO.getField());
    provenanceSearchableFieldDTOBuilder.setId(provenanceSearchableFieldDTO.getId());
    provenanceSearchableFieldDTOBuilder.setLabel(provenanceSearchableFieldDTO.getLabel());
    provenanceSearchableFieldDTOBuilder.setType(provenanceSearchableFieldDTO.getType());
    return provenanceSearchableFieldDTOBuilder;
  }
}
