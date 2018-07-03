package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.UpdateControllerServiceReferenceRequestEntity;

public final class UpdateControllerServiceReferenceRequestEntityBuilder extends AbstractEntityBuilder<UpdateControllerServiceReferenceRequestEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private String id;

  private Map<String, RevisionDTO> referencingComponentRevisions;

  private String state;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public UpdateControllerServiceReferenceRequestEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The identifier of the Controller Service.
   */
  public String getId() {
    return id;
  }

  /**
   * The identifier of the Controller Service.
   */
  public UpdateControllerServiceReferenceRequestEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The revisions for all referencing components.
   */
  public Map<String, RevisionDTO> getReferencingComponentRevisions() {
    return referencingComponentRevisions;
  }

  /**
   * The revisions for all referencing components.
   */
  public UpdateControllerServiceReferenceRequestEntityBuilder setReferencingComponentRevisions(final Map<String, RevisionDTO> referencingComponentRevisions) {
    this.referencingComponentRevisions = referencingComponentRevisions;
    return this;
  }

  /**
   * The new state of the references for the controller service.
   */
  public String getState() {
    return state;
  }

  /**
   * The new state of the references for the controller service.
   */
  public UpdateControllerServiceReferenceRequestEntityBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  public UpdateControllerServiceReferenceRequestEntity build() {
    final UpdateControllerServiceReferenceRequestEntity updateControllerServiceReferenceRequestEntity = new UpdateControllerServiceReferenceRequestEntity();
    super.setPropertyValues(updateControllerServiceReferenceRequestEntity);
    updateControllerServiceReferenceRequestEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    updateControllerServiceReferenceRequestEntity.setId(id);
    updateControllerServiceReferenceRequestEntity.setReferencingComponentRevisions(referencingComponentRevisions);
    updateControllerServiceReferenceRequestEntity.setState(state);
    return updateControllerServiceReferenceRequestEntity;
  }

  public static UpdateControllerServiceReferenceRequestEntityBuilder of(final UpdateControllerServiceReferenceRequestEntity updateControllerServiceReferenceRequestEntity) {
    final UpdateControllerServiceReferenceRequestEntityBuilder updateControllerServiceReferenceRequestEntityBuilder = new UpdateControllerServiceReferenceRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(updateControllerServiceReferenceRequestEntityBuilder, updateControllerServiceReferenceRequestEntity);
    updateControllerServiceReferenceRequestEntityBuilder.setDisconnectedNodeAcknowledged(updateControllerServiceReferenceRequestEntity.isDisconnectedNodeAcknowledged());
    updateControllerServiceReferenceRequestEntityBuilder.setId(updateControllerServiceReferenceRequestEntity.getId());
    updateControllerServiceReferenceRequestEntityBuilder.setReferencingComponentRevisions(updateControllerServiceReferenceRequestEntity.getReferencingComponentRevisions());
    updateControllerServiceReferenceRequestEntityBuilder.setState(updateControllerServiceReferenceRequestEntity.getState());
    return updateControllerServiceReferenceRequestEntityBuilder;
  }
}
