package com.tibtech.nifi.web.api.dto.search;

import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.search.ComponentSearchResultDTO;

public final class ComponentSearchResultDTOBuilder {
  private String groupId;

  private String id;

  private List<String> matches;

  private String name;

  /**
   * The group id of the component that matched the search.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The group id of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the component that matched the search.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * What matched the search from the component.
   */
  public List<String> getMatches() {
    return matches;
  }

  /**
   * What matched the search from the component.
   */
  public ComponentSearchResultDTOBuilder setMatches(final List<String> matches) {
    this.matches = matches;
    return this;
  }

  /**
   * The name of the component that matched the search.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public ComponentSearchResultDTO build() {
    final ComponentSearchResultDTO componentSearchResultDTO = new ComponentSearchResultDTO();
    componentSearchResultDTO.setGroupId(groupId);
    componentSearchResultDTO.setId(id);
    componentSearchResultDTO.setMatches(matches);
    componentSearchResultDTO.setName(name);
    return componentSearchResultDTO;
  }

  public static ComponentSearchResultDTOBuilder of(final ComponentSearchResultDTO componentSearchResultDTO) {
    final ComponentSearchResultDTOBuilder componentSearchResultDTOBuilder = new ComponentSearchResultDTOBuilder();
    componentSearchResultDTOBuilder.setGroupId(componentSearchResultDTO.getGroupId());
    componentSearchResultDTOBuilder.setId(componentSearchResultDTO.getId());
    componentSearchResultDTOBuilder.setMatches(componentSearchResultDTO.getMatches());
    componentSearchResultDTOBuilder.setName(componentSearchResultDTO.getName());
    return componentSearchResultDTOBuilder;
  }
}
