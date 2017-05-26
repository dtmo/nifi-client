package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.search.SearchResultsDTO;
import org.apache.nifi.web.api.entity.SearchResultsEntity;

public final class SearchResultsEntityBuilder {
  private SearchResultsDTO searchResultsDTO;

  public SearchResultsDTO getSearchResultsDTO() {
    return searchResultsDTO;
  }

  public SearchResultsEntityBuilder setSearchResultsDTO(final SearchResultsDTO searchResultsDTO) {
    this.searchResultsDTO = searchResultsDTO;
    return this;
  }

  public SearchResultsEntity build() {
    final SearchResultsEntity searchResultsEntity = new SearchResultsEntity();
    searchResultsEntity.setSearchResultsDTO(searchResultsDTO);
    return searchResultsEntity;
  }

  public static SearchResultsEntityBuilder of(final SearchResultsEntity searchResultsEntity) {
    final SearchResultsEntityBuilder searchResultsEntityBuilder = new SearchResultsEntityBuilder();
    searchResultsEntityBuilder.setSearchResultsDTO(searchResultsEntity.getSearchResultsDTO());
    return searchResultsEntityBuilder;
  }
}
