package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.BundleDTO;
import org.apache.nifi.web.api.dto.ControllerServiceApiDTO;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.apache.nifi.web.api.dto.ExplicitRestrictionDTO;

public final class DocumentedTypeDTOBuilder {
  private BundleDTO bundle;

  private List<ControllerServiceApiDTO> controllerServiceApis;

  private String deprecationReason;

  private String description;

  private Set<ExplicitRestrictionDTO> explicitRestrictions;

  private boolean restricted;

  private Set<String> tags;

  private String type;

  private String usageRestriction;

  /**
   * The details of the artifact that bundled this type.
   */
  public BundleDTO getBundle() {
    return bundle;
  }

  /**
   * The details of the artifact that bundled this type.
   */
  public DocumentedTypeDTOBuilder setBundle(final BundleDTO bundle) {
    this.bundle = bundle;
    return this;
  }

  /**
   * The details of the artifact that bundled this type.
   */
  public DocumentedTypeDTOBuilder setBundle(final Consumer<BundleDTOBuilder> configurator) {
    final BundleDTOBuilder builder = (bundle != null ? BundleDTOBuilder.of(bundle) : new BundleDTOBuilder());
    configurator.accept(builder);
    return setBundle(builder.build());
  }

  /**
   * The details of the artifact that bundled this type.
   */
  public DocumentedTypeDTOBuilder setBundle(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BundleDTOBuilder.class) final Closure<BundleDTOBuilder> closure) {
    return setBundle(c -> {
      final Closure<BundleDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * If this type represents a ControllerService, this lists the APIs it implements.
   */
  public List<ControllerServiceApiDTO> getControllerServiceApis() {
    return controllerServiceApis;
  }

  /**
   * If this type represents a ControllerService, this lists the APIs it implements.
   */
  public DocumentedTypeDTOBuilder setControllerServiceApis(final List<ControllerServiceApiDTO> controllerServiceApis) {
    this.controllerServiceApis = controllerServiceApis;
    return this;
  }

  /**
   * The description of why the usage of this component is restricted.
   */
  public String getDeprecationReason() {
    return deprecationReason;
  }

  /**
   * The description of why the usage of this component is restricted.
   */
  public DocumentedTypeDTOBuilder setDeprecationReason(final String deprecationReason) {
    this.deprecationReason = deprecationReason;
    return this;
  }

  /**
   * The description of the type.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the type.
   */
  public DocumentedTypeDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * An optional collection of explicit restrictions. If specified, these explicit restrictions will be enfored.
   */
  public Set<ExplicitRestrictionDTO> getExplicitRestrictions() {
    return explicitRestrictions;
  }

  /**
   * An optional collection of explicit restrictions. If specified, these explicit restrictions will be enfored.
   */
  public DocumentedTypeDTOBuilder setExplicitRestrictions(final Set<ExplicitRestrictionDTO> explicitRestrictions) {
    this.explicitRestrictions = explicitRestrictions;
    return this;
  }

  /**
   * Whether this type is restricted.
   */
  public boolean getRestricted() {
    return restricted;
  }

  /**
   * Whether this type is restricted.
   */
  public DocumentedTypeDTOBuilder setRestricted(final boolean restricted) {
    this.restricted = restricted;
    return this;
  }

  /**
   * The tags associated with this type.
   */
  public Set<String> getTags() {
    return tags;
  }

  /**
   * The tags associated with this type.
   */
  public DocumentedTypeDTOBuilder setTags(final Set<String> tags) {
    this.tags = tags;
    return this;
  }

  /**
   * The fully qualified name of the type.
   */
  public String getType() {
    return type;
  }

  /**
   * The fully qualified name of the type.
   */
  public DocumentedTypeDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  /**
   * The optional description of why the usage of this component is restricted.
   */
  public String getUsageRestriction() {
    return usageRestriction;
  }

  /**
   * The optional description of why the usage of this component is restricted.
   */
  public DocumentedTypeDTOBuilder setUsageRestriction(final String usageRestriction) {
    this.usageRestriction = usageRestriction;
    return this;
  }

  public DocumentedTypeDTO build() {
    final DocumentedTypeDTO documentedTypeDTO = new DocumentedTypeDTO();
    documentedTypeDTO.setBundle(bundle);
    documentedTypeDTO.setControllerServiceApis(controllerServiceApis);
    documentedTypeDTO.setDeprecationReason(deprecationReason);
    documentedTypeDTO.setDescription(description);
    documentedTypeDTO.setExplicitRestrictions(explicitRestrictions);
    documentedTypeDTO.setRestricted(restricted);
    documentedTypeDTO.setTags(tags);
    documentedTypeDTO.setType(type);
    documentedTypeDTO.setUsageRestriction(usageRestriction);
    return documentedTypeDTO;
  }

  public static DocumentedTypeDTOBuilder of(final DocumentedTypeDTO documentedTypeDTO) {
    final DocumentedTypeDTOBuilder documentedTypeDTOBuilder = new DocumentedTypeDTOBuilder();
    documentedTypeDTOBuilder.setBundle(documentedTypeDTO.getBundle());
    documentedTypeDTOBuilder.setControllerServiceApis(documentedTypeDTO.getControllerServiceApis());
    documentedTypeDTOBuilder.setDeprecationReason(documentedTypeDTO.getDeprecationReason());
    documentedTypeDTOBuilder.setDescription(documentedTypeDTO.getDescription());
    documentedTypeDTOBuilder.setExplicitRestrictions(documentedTypeDTO.getExplicitRestrictions());
    documentedTypeDTOBuilder.setRestricted(documentedTypeDTO.isRestricted());
    documentedTypeDTOBuilder.setTags(documentedTypeDTO.getTags());
    documentedTypeDTOBuilder.setType(documentedTypeDTO.getType());
    documentedTypeDTOBuilder.setUsageRestriction(documentedTypeDTO.getUsageRestriction());
    return documentedTypeDTOBuilder;
  }
}
