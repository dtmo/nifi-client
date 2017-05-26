package com.tibtech.nifi.web.api.dto.provenance.lineage;

import java.lang.String;
import java.util.List;
import java.util.Set;
import org.apache.nifi.web.api.dto.provenance.lineage.LineageResultsDTO;
import org.apache.nifi.web.api.dto.provenance.lineage.ProvenanceLinkDTO;
import org.apache.nifi.web.api.dto.provenance.lineage.ProvenanceNodeDTO;

public final class LineageResultsDTOBuilder {
  private Set<String> errors;

  private List<ProvenanceLinkDTO> links;

  private List<ProvenanceNodeDTO> nodes;

  /**
   * Any errors that occurred while generating the lineage.
   */
  public Set<String> getErrors() {
    return errors;
  }

  /**
   * Any errors that occurred while generating the lineage.
   */
  public LineageResultsDTOBuilder setErrors(final Set<String> errors) {
    this.errors = errors;
    return this;
  }

  /**
   * The links between the nodes in the lineage.
   */
  public List<ProvenanceLinkDTO> getLinks() {
    return links;
  }

  /**
   * The links between the nodes in the lineage.
   */
  public LineageResultsDTOBuilder setLinks(final List<ProvenanceLinkDTO> links) {
    this.links = links;
    return this;
  }

  /**
   * The nodes in the lineage.
   */
  public List<ProvenanceNodeDTO> getNodes() {
    return nodes;
  }

  /**
   * The nodes in the lineage.
   */
  public LineageResultsDTOBuilder setNodes(final List<ProvenanceNodeDTO> nodes) {
    this.nodes = nodes;
    return this;
  }

  public LineageResultsDTO build() {
    final LineageResultsDTO lineageResultsDTO = new LineageResultsDTO();
    lineageResultsDTO.setErrors(errors);
    lineageResultsDTO.setLinks(links);
    lineageResultsDTO.setNodes(nodes);
    return lineageResultsDTO;
  }

  public static LineageResultsDTOBuilder of(final LineageResultsDTO lineageResultsDTO) {
    final LineageResultsDTOBuilder lineageResultsDTOBuilder = new LineageResultsDTOBuilder();
    lineageResultsDTOBuilder.setErrors(lineageResultsDTO.getErrors());
    lineageResultsDTOBuilder.setLinks(lineageResultsDTO.getLinks());
    lineageResultsDTOBuilder.setNodes(lineageResultsDTO.getNodes());
    return lineageResultsDTOBuilder;
  }
}
