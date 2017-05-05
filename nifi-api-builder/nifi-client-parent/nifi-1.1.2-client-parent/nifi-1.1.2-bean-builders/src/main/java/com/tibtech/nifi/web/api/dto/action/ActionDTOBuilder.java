package com.tibtech.nifi.web.api.dto.action;

import com.tibtech.nifi.web.api.dto.action.component.details.ComponentDetailsDTOBuilder;
import com.tibtech.nifi.web.api.dto.action.details.ActionDetailsDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.action.ActionDTO;
import org.apache.nifi.web.api.dto.action.component.details.ComponentDetailsDTO;
import org.apache.nifi.web.api.dto.action.details.ActionDetailsDTO;

public final class ActionDTOBuilder {
  private ActionDetailsDTO actionDetails;

  private ComponentDetailsDTO componentDetails;

  private Integer id;

  private String operation;

  private String sourceId;

  private String sourceName;

  private String sourceType;

  private Date timestamp;

  private String userIdentity;

  /**
   * The details of the action.
   */
  public ActionDetailsDTO getActionDetails() {
    return actionDetails;
  }

  /**
   * The details of the action.
   */
  public ActionDTOBuilder setActionDetails(final ActionDetailsDTO actionDetails) {
    this.actionDetails = actionDetails;
    return this;
  }

  /**
   * The details of the action.
   */
  public ActionDTOBuilder setActionDetails(final Function<ActionDetailsDTOBuilder, ActionDetailsDTOBuilder> configurator) {
    return setActionDetails(configurator.apply(actionDetails != null ? ActionDetailsDTOBuilder.of(actionDetails) : new ActionDetailsDTOBuilder()).build());
  }

  /**
   * The details of the action.
   */
  public ActionDTOBuilder setActionDetails(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ActionDetailsDTOBuilder.class) final Closure<ActionDetailsDTOBuilder> closure) {
    return setActionDetails(c -> {
      final Closure<ActionDetailsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The details of the source component.
   */
  public ComponentDetailsDTO getComponentDetails() {
    return componentDetails;
  }

  /**
   * The details of the source component.
   */
  public ActionDTOBuilder setComponentDetails(final ComponentDetailsDTO componentDetails) {
    this.componentDetails = componentDetails;
    return this;
  }

  /**
   * The details of the source component.
   */
  public ActionDTOBuilder setComponentDetails(final Function<ComponentDetailsDTOBuilder, ComponentDetailsDTOBuilder> configurator) {
    return setComponentDetails(configurator.apply(componentDetails != null ? ComponentDetailsDTOBuilder.of(componentDetails) : new ComponentDetailsDTOBuilder()).build());
  }

  /**
   * The details of the source component.
   */
  public ActionDTOBuilder setComponentDetails(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ComponentDetailsDTOBuilder.class) final Closure<ComponentDetailsDTOBuilder> closure) {
    return setComponentDetails(c -> {
      final Closure<ComponentDetailsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The action id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * The action id.
   */
  public ActionDTOBuilder setId(final Integer id) {
    this.id = id;
    return this;
  }

  /**
   * The operation that was performed.
   */
  public String getOperation() {
    return operation;
  }

  /**
   * The operation that was performed.
   */
  public ActionDTOBuilder setOperation(final String operation) {
    this.operation = operation;
    return this;
  }

  /**
   * The id of the source component.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The id of the source component.
   */
  public ActionDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The name of the source component.
   */
  public String getSourceName() {
    return sourceName;
  }

  /**
   * The name of the source component.
   */
  public ActionDTOBuilder setSourceName(final String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  /**
   * The type of the source component.
   */
  public String getSourceType() {
    return sourceType;
  }

  /**
   * The type of the source component.
   */
  public ActionDTOBuilder setSourceType(final String sourceType) {
    this.sourceType = sourceType;
    return this;
  }

  /**
   * The timestamp of the action.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of the action.
   */
  public ActionDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The identity of the user that performed the action.
   */
  public String getUserIdentity() {
    return userIdentity;
  }

  /**
   * The identity of the user that performed the action.
   */
  public ActionDTOBuilder setUserIdentity(final String userIdentity) {
    this.userIdentity = userIdentity;
    return this;
  }

  public ActionDTO build() {
    final ActionDTO actionDTO = new ActionDTO();
    actionDTO.setActionDetails(actionDetails);
    actionDTO.setComponentDetails(componentDetails);
    actionDTO.setId(id);
    actionDTO.setOperation(operation);
    actionDTO.setSourceId(sourceId);
    actionDTO.setSourceName(sourceName);
    actionDTO.setSourceType(sourceType);
    actionDTO.setTimestamp(timestamp);
    actionDTO.setUserIdentity(userIdentity);
    return actionDTO;
  }

  public static ActionDTOBuilder of(final ActionDTO actionDTO) {
    final ActionDTOBuilder actionDTOBuilder = new ActionDTOBuilder();
    actionDTOBuilder.setActionDetails(actionDTO.getActionDetails());
    actionDTOBuilder.setComponentDetails(actionDTO.getComponentDetails());
    actionDTOBuilder.setId(actionDTO.getId());
    actionDTOBuilder.setOperation(actionDTO.getOperation());
    actionDTOBuilder.setSourceId(actionDTO.getSourceId());
    actionDTOBuilder.setSourceName(actionDTO.getSourceName());
    actionDTOBuilder.setSourceType(actionDTO.getSourceType());
    actionDTOBuilder.setTimestamp(actionDTO.getTimestamp());
    actionDTOBuilder.setUserIdentity(actionDTO.getUserIdentity());
    return actionDTOBuilder;
  }
}
