package com.tibtech.nifi.web.api.dto.search;

import java.lang.String;
import org.apache.nifi.web.api.dto.search.NodeSearchResultDTO;

public final class NodeSearchResultDTOBuilder {
  private String address;

  private String id;

  /**
   * The address of the node that matched the search.
   */
  public String getAddress() {
    return address;
  }

  /**
   * The address of the node that matched the search.
   */
  public NodeSearchResultDTOBuilder setAddress(final String address) {
    this.address = address;
    return this;
  }

  /**
   * The id of the node that matched the search.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the node that matched the search.
   */
  public NodeSearchResultDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public NodeSearchResultDTO build() {
    final NodeSearchResultDTO nodeSearchResultDTO = new NodeSearchResultDTO();
    nodeSearchResultDTO.setAddress(address);
    nodeSearchResultDTO.setId(id);
    return nodeSearchResultDTO;
  }

  public static NodeSearchResultDTOBuilder of(final NodeSearchResultDTO nodeSearchResultDTO) {
    final NodeSearchResultDTOBuilder nodeSearchResultDTOBuilder = new NodeSearchResultDTOBuilder();
    nodeSearchResultDTOBuilder.setAddress(nodeSearchResultDTO.getAddress());
    nodeSearchResultDTOBuilder.setId(nodeSearchResultDTO.getId());
    return nodeSearchResultDTOBuilder;
  }
}
