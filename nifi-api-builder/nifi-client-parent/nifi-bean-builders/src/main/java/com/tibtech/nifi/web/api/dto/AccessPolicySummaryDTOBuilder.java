package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.AccessPolicySummaryDTO;
import org.apache.nifi.web.api.entity.ComponentReferenceEntity;

public final class AccessPolicySummaryDTOBuilder extends AbstractAccessPolicySummaryDTOBuilder<AccessPolicySummaryDTOBuilder> {
  private String action;

  private ComponentReferenceEntity componentReference;

  private String resource;

  /**
   * The action associated with this access policy.
   */
  public String getAction() {
    return action;
  }

  /**
   * The action associated with this access policy.
   */
  public AccessPolicySummaryDTOBuilder setAction(final String action) {
    this.action = action;
    return this;
  }

  /**
   * Component this policy references if applicable.
   */
  public ComponentReferenceEntity getComponentReference() {
    return componentReference;
  }

  /**
   * Component this policy references if applicable.
   */
  public AccessPolicySummaryDTOBuilder setComponentReference(final ComponentReferenceEntity componentReference) {
    this.componentReference = componentReference;
    return this;
  }

  /**
   * The resource for this access policy.
   */
  public String getResource() {
    return resource;
  }

  /**
   * The resource for this access policy.
   */
  public AccessPolicySummaryDTOBuilder setResource(final String resource) {
    this.resource = resource;
    return this;
  }

  public AccessPolicySummaryDTO build() {
    final AccessPolicySummaryDTO accessPolicySummaryDTO = new AccessPolicySummaryDTO();
    super.setPropertyValues(accessPolicySummaryDTO);
    accessPolicySummaryDTO.setAction(action);
    accessPolicySummaryDTO.setComponentReference(componentReference);
    accessPolicySummaryDTO.setResource(resource);
    return accessPolicySummaryDTO;
  }

  public static AccessPolicySummaryDTOBuilder of(final AccessPolicySummaryDTO accessPolicySummaryDTO) {
    final AccessPolicySummaryDTOBuilder accessPolicySummaryDTOBuilder = new AccessPolicySummaryDTOBuilder();
    AbstractAccessPolicySummaryDTOBuilder.setBuilderValues(accessPolicySummaryDTOBuilder, accessPolicySummaryDTO);
    accessPolicySummaryDTOBuilder.setAction(accessPolicySummaryDTO.getAction());
    accessPolicySummaryDTOBuilder.setComponentReference(accessPolicySummaryDTO.getComponentReference());
    accessPolicySummaryDTOBuilder.setResource(accessPolicySummaryDTO.getResource());
    return accessPolicySummaryDTOBuilder;
  }
}
