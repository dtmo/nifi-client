package com.tibtech.nifi.web.api.dto.search;

import java.util.List;
import org.apache.nifi.web.api.dto.search.ComponentSearchResultDTO;
import org.apache.nifi.web.api.dto.search.SearchResultsDTO;

public final class SearchResultsDTOBuilder {
  private List<ComponentSearchResultDTO> connectionResults;

  private List<ComponentSearchResultDTO> funnelResults;

  private List<ComponentSearchResultDTO> inputPortResults;

  private List<ComponentSearchResultDTO> outputPortResults;

  private List<ComponentSearchResultDTO> processGroupResults;

  private List<ComponentSearchResultDTO> processorResults;

  private List<ComponentSearchResultDTO> remoteProcessGroupResults;

  /**
   * The connections that matched the search.
   */
  public List<ComponentSearchResultDTO> getConnectionResults() {
    return connectionResults;
  }

  /**
   * The connections that matched the search.
   */
  public SearchResultsDTOBuilder setConnectionResults(final List<ComponentSearchResultDTO> connectionResults) {
    this.connectionResults = connectionResults;
    return this;
  }

  /**
   * The funnels that matched the search.
   */
  public List<ComponentSearchResultDTO> getFunnelResults() {
    return funnelResults;
  }

  /**
   * The funnels that matched the search.
   */
  public SearchResultsDTOBuilder setFunnelResults(final List<ComponentSearchResultDTO> funnelResults) {
    this.funnelResults = funnelResults;
    return this;
  }

  /**
   * The input ports that matched the search.
   */
  public List<ComponentSearchResultDTO> getInputPortResults() {
    return inputPortResults;
  }

  /**
   * The input ports that matched the search.
   */
  public SearchResultsDTOBuilder setInputPortResults(final List<ComponentSearchResultDTO> inputPortResults) {
    this.inputPortResults = inputPortResults;
    return this;
  }

  /**
   * The output ports that matched the search.
   */
  public List<ComponentSearchResultDTO> getOutputPortResults() {
    return outputPortResults;
  }

  /**
   * The output ports that matched the search.
   */
  public SearchResultsDTOBuilder setOutputPortResults(final List<ComponentSearchResultDTO> outputPortResults) {
    this.outputPortResults = outputPortResults;
    return this;
  }

  /**
   * The process groups that matched the search.
   */
  public List<ComponentSearchResultDTO> getProcessGroupResults() {
    return processGroupResults;
  }

  /**
   * The process groups that matched the search.
   */
  public SearchResultsDTOBuilder setProcessGroupResults(final List<ComponentSearchResultDTO> processGroupResults) {
    this.processGroupResults = processGroupResults;
    return this;
  }

  /**
   * The processors that matched the search.
   */
  public List<ComponentSearchResultDTO> getProcessorResults() {
    return processorResults;
  }

  /**
   * The processors that matched the search.
   */
  public SearchResultsDTOBuilder setProcessorResults(final List<ComponentSearchResultDTO> processorResults) {
    this.processorResults = processorResults;
    return this;
  }

  /**
   * The remote process groups that matched the search.
   */
  public List<ComponentSearchResultDTO> getRemoteProcessGroupResults() {
    return remoteProcessGroupResults;
  }

  /**
   * The remote process groups that matched the search.
   */
  public SearchResultsDTOBuilder setRemoteProcessGroupResults(final List<ComponentSearchResultDTO> remoteProcessGroupResults) {
    this.remoteProcessGroupResults = remoteProcessGroupResults;
    return this;
  }

  public SearchResultsDTO build() {
    final SearchResultsDTO searchResultsDTO = new SearchResultsDTO();
    searchResultsDTO.setConnectionResults(connectionResults);
    searchResultsDTO.setFunnelResults(funnelResults);
    searchResultsDTO.setInputPortResults(inputPortResults);
    searchResultsDTO.setOutputPortResults(outputPortResults);
    searchResultsDTO.setProcessGroupResults(processGroupResults);
    searchResultsDTO.setProcessorResults(processorResults);
    searchResultsDTO.setRemoteProcessGroupResults(remoteProcessGroupResults);
    return searchResultsDTO;
  }

  public static SearchResultsDTOBuilder of(final SearchResultsDTO searchResultsDTO) {
    final SearchResultsDTOBuilder searchResultsDTOBuilder = new SearchResultsDTOBuilder();
    searchResultsDTOBuilder.setConnectionResults(searchResultsDTO.getConnectionResults());
    searchResultsDTOBuilder.setFunnelResults(searchResultsDTO.getFunnelResults());
    searchResultsDTOBuilder.setInputPortResults(searchResultsDTO.getInputPortResults());
    searchResultsDTOBuilder.setOutputPortResults(searchResultsDTO.getOutputPortResults());
    searchResultsDTOBuilder.setProcessGroupResults(searchResultsDTO.getProcessGroupResults());
    searchResultsDTOBuilder.setProcessorResults(searchResultsDTO.getProcessorResults());
    searchResultsDTOBuilder.setRemoteProcessGroupResults(searchResultsDTO.getRemoteProcessGroupResults());
    return searchResultsDTOBuilder;
  }
}
