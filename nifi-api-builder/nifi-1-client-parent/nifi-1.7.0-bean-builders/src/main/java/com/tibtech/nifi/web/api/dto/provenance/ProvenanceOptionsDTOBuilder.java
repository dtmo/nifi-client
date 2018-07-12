package com.tibtech.nifi.web.api.dto.provenance;

import java.util.List;
import org.apache.nifi.web.api.dto.provenance.ProvenanceOptionsDTO;
import org.apache.nifi.web.api.dto.provenance.ProvenanceSearchableFieldDTO;

public final class ProvenanceOptionsDTOBuilder {
  private List<ProvenanceSearchableFieldDTO> searchableFields;

  /**
   * The available searchable field for the NiFi.
   */
  public List<ProvenanceSearchableFieldDTO> getSearchableFields() {
    return searchableFields;
  }

  /**
   * The available searchable field for the NiFi.
   */
  public ProvenanceOptionsDTOBuilder setSearchableFields(
      final List<ProvenanceSearchableFieldDTO> searchableFields) {
    this.searchableFields = searchableFields;
    return this;
  }

  public ProvenanceOptionsDTO build() {
    final ProvenanceOptionsDTO provenanceOptionsDTO = new ProvenanceOptionsDTO();
    provenanceOptionsDTO.setSearchableFields(searchableFields);
    return provenanceOptionsDTO;
  }

  public static ProvenanceOptionsDTOBuilder of(final ProvenanceOptionsDTO provenanceOptionsDTO) {
    final ProvenanceOptionsDTOBuilder provenanceOptionsDTOBuilder = new ProvenanceOptionsDTOBuilder();
    provenanceOptionsDTOBuilder.setSearchableFields(provenanceOptionsDTO.getSearchableFields());
    return provenanceOptionsDTOBuilder;
  }
}
