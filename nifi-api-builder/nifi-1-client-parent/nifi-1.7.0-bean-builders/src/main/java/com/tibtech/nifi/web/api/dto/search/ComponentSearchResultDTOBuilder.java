package com.tibtech.nifi.web.api.dto.search;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.search.ComponentSearchResultDTO;
import org.apache.nifi.web.api.dto.search.SearchResultGroupDTO;

public final class ComponentSearchResultDTOBuilder {
  private String groupId;

  private String id;

  private List<String> matches;

  private String name;

  private SearchResultGroupDTO parentGroup;

  private SearchResultGroupDTO versionedGroup;

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

  /**
   * The parent group of the component that matched the search.
   */
  public SearchResultGroupDTO getParentGroup() {
    return parentGroup;
  }

  /**
   * The parent group of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setParentGroup(final SearchResultGroupDTO parentGroup) {
    this.parentGroup = parentGroup;
    return this;
  }

  /**
   * The parent group of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setParentGroup(final Consumer<SearchResultGroupDTOBuilder> configurator) {
    final SearchResultGroupDTOBuilder builder = (parentGroup != null ? SearchResultGroupDTOBuilder.of(parentGroup) : new SearchResultGroupDTOBuilder());
    configurator.accept(builder);
    return setParentGroup(builder.build());
  }

  /**
   * The parent group of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setParentGroup(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SearchResultGroupDTOBuilder.class) final Closure<SearchResultGroupDTOBuilder> closure) {
    return setParentGroup(c -> {
      final Closure<SearchResultGroupDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The nearest versioned ancestor group of the component that matched the search.
   */
  public SearchResultGroupDTO getVersionedGroup() {
    return versionedGroup;
  }

  /**
   * The nearest versioned ancestor group of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setVersionedGroup(final SearchResultGroupDTO versionedGroup) {
    this.versionedGroup = versionedGroup;
    return this;
  }

  /**
   * The nearest versioned ancestor group of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setVersionedGroup(final Consumer<SearchResultGroupDTOBuilder> configurator) {
    final SearchResultGroupDTOBuilder builder = (versionedGroup != null ? SearchResultGroupDTOBuilder.of(versionedGroup) : new SearchResultGroupDTOBuilder());
    configurator.accept(builder);
    return setVersionedGroup(builder.build());
  }

  /**
   * The nearest versioned ancestor group of the component that matched the search.
   */
  public ComponentSearchResultDTOBuilder setVersionedGroup(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SearchResultGroupDTOBuilder.class) final Closure<SearchResultGroupDTOBuilder> closure) {
    return setVersionedGroup(c -> {
      final Closure<SearchResultGroupDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public ComponentSearchResultDTO build() {
    final ComponentSearchResultDTO componentSearchResultDTO = new ComponentSearchResultDTO();
    componentSearchResultDTO.setGroupId(groupId);
    componentSearchResultDTO.setId(id);
    componentSearchResultDTO.setMatches(matches);
    componentSearchResultDTO.setName(name);
    componentSearchResultDTO.setParentGroup(parentGroup);
    componentSearchResultDTO.setVersionedGroup(versionedGroup);
    return componentSearchResultDTO;
  }

  public static ComponentSearchResultDTOBuilder of(final ComponentSearchResultDTO componentSearchResultDTO) {
    final ComponentSearchResultDTOBuilder componentSearchResultDTOBuilder = new ComponentSearchResultDTOBuilder();
    componentSearchResultDTOBuilder.setGroupId(componentSearchResultDTO.getGroupId());
    componentSearchResultDTOBuilder.setId(componentSearchResultDTO.getId());
    componentSearchResultDTOBuilder.setMatches(componentSearchResultDTO.getMatches());
    componentSearchResultDTOBuilder.setName(componentSearchResultDTO.getName());
    componentSearchResultDTOBuilder.setParentGroup(componentSearchResultDTO.getParentGroup());
    componentSearchResultDTOBuilder.setVersionedGroup(componentSearchResultDTO.getVersionedGroup());
    return componentSearchResultDTOBuilder;
  }
}
