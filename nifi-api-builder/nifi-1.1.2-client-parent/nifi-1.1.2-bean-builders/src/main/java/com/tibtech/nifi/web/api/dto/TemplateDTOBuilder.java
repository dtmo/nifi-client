package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.TemplateDTO;

public final class TemplateDTOBuilder {
  private String description;

  private String encodingVersion;

  private String groupId;

  private String id;

  private String name;

  private FlowSnippetDTO snippet;

  private Date timestamp;

  private String uri;

  /**
   * The description of the template.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the template.
   */
  public TemplateDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The encoding version of this template.
   */
  public String getEncodingVersion() {
    return encodingVersion;
  }

  /**
   * The encoding version of this template.
   */
  public TemplateDTOBuilder setEncodingVersion(final String encodingVersion) {
    this.encodingVersion = encodingVersion;
    return this;
  }

  /**
   * The id of the Process Group that the template belongs to.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the Process Group that the template belongs to.
   */
  public TemplateDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the template.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the template.
   */
  public TemplateDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the template.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the template.
   */
  public TemplateDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The contents of the template.
   */
  public FlowSnippetDTO getSnippet() {
    return snippet;
  }

  /**
   * The contents of the template.
   */
  public TemplateDTOBuilder setSnippet(final FlowSnippetDTO snippet) {
    this.snippet = snippet;
    return this;
  }

  /**
   * The contents of the template.
   */
  public TemplateDTOBuilder setSnippet(final Function<FlowSnippetDTOBuilder, FlowSnippetDTOBuilder> configurator) {
    return setSnippet(configurator.apply(snippet != null ? FlowSnippetDTOBuilder.of(snippet) : new FlowSnippetDTOBuilder()).build());
  }

  /**
   * The contents of the template.
   */
  public TemplateDTOBuilder setSnippet(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FlowSnippetDTOBuilder.class) final Closure<FlowSnippetDTOBuilder> closure) {
    return setSnippet(c -> {
      final Closure<FlowSnippetDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The timestamp when this template was created.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp when this template was created.
   */
  public TemplateDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The URI for the template.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for the template.
   */
  public TemplateDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public TemplateDTO build() {
    final TemplateDTO templateDTO = new TemplateDTO();
    templateDTO.setDescription(description);
    templateDTO.setEncodingVersion(encodingVersion);
    templateDTO.setGroupId(groupId);
    templateDTO.setId(id);
    templateDTO.setName(name);
    templateDTO.setSnippet(snippet);
    templateDTO.setTimestamp(timestamp);
    templateDTO.setUri(uri);
    return templateDTO;
  }

  public static TemplateDTOBuilder of(final TemplateDTO templateDTO) {
    final TemplateDTOBuilder templateDTOBuilder = new TemplateDTOBuilder();
    templateDTOBuilder.setDescription(templateDTO.getDescription());
    templateDTOBuilder.setEncodingVersion(templateDTO.getEncodingVersion());
    templateDTOBuilder.setGroupId(templateDTO.getGroupId());
    templateDTOBuilder.setId(templateDTO.getId());
    templateDTOBuilder.setName(templateDTO.getName());
    templateDTOBuilder.setSnippet(templateDTO.getSnippet());
    templateDTOBuilder.setTimestamp(templateDTO.getTimestamp());
    templateDTOBuilder.setUri(templateDTO.getUri());
    return templateDTOBuilder;
  }
}
