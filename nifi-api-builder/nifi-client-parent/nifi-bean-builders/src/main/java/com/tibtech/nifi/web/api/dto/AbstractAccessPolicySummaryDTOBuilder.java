package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.AccessPolicySummaryDTO;
import org.apache.nifi.web.api.entity.ComponentReferenceEntity;

public abstract class AbstractAccessPolicySummaryDTOBuilder<T extends AbstractAccessPolicySummaryDTOBuilder<T>> extends AbstractComponentDTOBuilder<T> {
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
  public T setAction(final String action) {
    this.action = action;
    return (T) this;
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
  public T setComponentReference(final ComponentReferenceEntity componentReference) {
    this.componentReference = componentReference;
    return (T) this;
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
  public T setResource(final String resource) {
    this.resource = resource;
    return (T) this;
  }

  protected void setPropertyValues(final AccessPolicySummaryDTO accessPolicySummaryDTO) {
    super.setPropertyValues(accessPolicySummaryDTO);
    accessPolicySummaryDTO.setAction(action);
    accessPolicySummaryDTO.setComponentReference(componentReference);
    accessPolicySummaryDTO.setResource(resource);
  }

  protected static void setBuilderValues(final AbstractAccessPolicySummaryDTOBuilder abstractAccessPolicySummaryDTOBuilder,
      final AccessPolicySummaryDTO accessPolicySummaryDTO) {
    AbstractComponentDTOBuilder.setBuilderValues(abstractAccessPolicySummaryDTOBuilder, accessPolicySummaryDTO);
    abstractAccessPolicySummaryDTOBuilder.setAction(accessPolicySummaryDTO.getAction());
    abstractAccessPolicySummaryDTOBuilder.setComponentReference(accessPolicySummaryDTO.getComponentReference());
    abstractAccessPolicySummaryDTOBuilder.setResource(accessPolicySummaryDTO.getResource());
  }
}
