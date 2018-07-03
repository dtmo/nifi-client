package com.tibtech.nifi.web.api.dto.search;

import java.lang.String;
import org.apache.nifi.web.api.dto.search.SearchResultGroupDTO;

public final class SearchResultGroupDTOBuilder {
  private String id;

  private String name;

  /**
   * The id of the group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the group.
   */
  public SearchResultGroupDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the group.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the group.
   */
  public SearchResultGroupDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public SearchResultGroupDTO build() {
    final SearchResultGroupDTO searchResultGroupDTO = new SearchResultGroupDTO();
    searchResultGroupDTO.setId(id);
    searchResultGroupDTO.setName(name);
    return searchResultGroupDTO;
  }

  public static SearchResultGroupDTOBuilder of(final SearchResultGroupDTO searchResultGroupDTO) {
    final SearchResultGroupDTOBuilder searchResultGroupDTOBuilder = new SearchResultGroupDTOBuilder();
    searchResultGroupDTOBuilder.setId(searchResultGroupDTO.getId());
    searchResultGroupDTOBuilder.setName(searchResultGroupDTO.getName());
    return searchResultGroupDTOBuilder;
  }
}
