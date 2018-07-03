package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.ExplicitRestrictionDTO;
import org.apache.nifi.web.api.dto.RequiredPermissionDTO;

public final class ExplicitRestrictionDTOBuilder {
  private String explanation;

  private RequiredPermissionDTO requiredPermission;

  /**
   * The description of why the usage of this component is restricted for this required permission.
   */
  public String getExplanation() {
    return explanation;
  }

  /**
   * The description of why the usage of this component is restricted for this required permission.
   */
  public ExplicitRestrictionDTOBuilder setExplanation(final String explanation) {
    this.explanation = explanation;
    return this;
  }

  /**
   * The required permission necessary for this restriction.
   */
  public RequiredPermissionDTO getRequiredPermission() {
    return requiredPermission;
  }

  /**
   * The required permission necessary for this restriction.
   */
  public ExplicitRestrictionDTOBuilder setRequiredPermission(final RequiredPermissionDTO requiredPermission) {
    this.requiredPermission = requiredPermission;
    return this;
  }

  /**
   * The required permission necessary for this restriction.
   */
  public ExplicitRestrictionDTOBuilder setRequiredPermission(final Consumer<RequiredPermissionDTOBuilder> configurator) {
    final RequiredPermissionDTOBuilder builder = (requiredPermission != null ? RequiredPermissionDTOBuilder.of(requiredPermission) : new RequiredPermissionDTOBuilder());
    configurator.accept(builder);
    return setRequiredPermission(builder.build());
  }

  /**
   * The required permission necessary for this restriction.
   */
  public ExplicitRestrictionDTOBuilder setRequiredPermission(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RequiredPermissionDTOBuilder.class) final Closure<RequiredPermissionDTOBuilder> closure) {
    return setRequiredPermission(c -> {
      final Closure<RequiredPermissionDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public ExplicitRestrictionDTO build() {
    final ExplicitRestrictionDTO explicitRestrictionDTO = new ExplicitRestrictionDTO();
    explicitRestrictionDTO.setExplanation(explanation);
    explicitRestrictionDTO.setRequiredPermission(requiredPermission);
    return explicitRestrictionDTO;
  }

  public static ExplicitRestrictionDTOBuilder of(final ExplicitRestrictionDTO explicitRestrictionDTO) {
    final ExplicitRestrictionDTOBuilder explicitRestrictionDTOBuilder = new ExplicitRestrictionDTOBuilder();
    explicitRestrictionDTOBuilder.setExplanation(explicitRestrictionDTO.getExplanation());
    explicitRestrictionDTOBuilder.setRequiredPermission(explicitRestrictionDTO.getRequiredPermission());
    return explicitRestrictionDTOBuilder;
  }
}
