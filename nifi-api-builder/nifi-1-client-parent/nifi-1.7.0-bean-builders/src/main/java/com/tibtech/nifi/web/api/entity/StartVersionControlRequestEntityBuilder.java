package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.VersionedFlowDTO;
import org.apache.nifi.web.api.entity.StartVersionControlRequestEntity;

public final class StartVersionControlRequestEntityBuilder extends AbstractEntityBuilder<StartVersionControlRequestEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private RevisionDTO processGroupRevision;

  private VersionedFlowDTO versionedFlow;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public StartVersionControlRequestEntityBuilder setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The Revision of the Process Group under Version Control
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The Revision of the Process Group under Version Control
   */
  public StartVersionControlRequestEntityBuilder setProcessGroupRevision(
      final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The versioned flow
   */
  public VersionedFlowDTO getVersionedFlow() {
    return versionedFlow;
  }

  /**
   * The versioned flow
   */
  public StartVersionControlRequestEntityBuilder setVersionedFlow(
      final VersionedFlowDTO versionedFlow) {
    this.versionedFlow = versionedFlow;
    return this;
  }

  public StartVersionControlRequestEntity build() {
    final StartVersionControlRequestEntity startVersionControlRequestEntity = new StartVersionControlRequestEntity();
    super.setPropertyValues(startVersionControlRequestEntity);
    startVersionControlRequestEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    startVersionControlRequestEntity.setProcessGroupRevision(processGroupRevision);
    startVersionControlRequestEntity.setVersionedFlow(versionedFlow);
    return startVersionControlRequestEntity;
  }

  public static StartVersionControlRequestEntityBuilder of(
      final StartVersionControlRequestEntity startVersionControlRequestEntity) {
    final StartVersionControlRequestEntityBuilder startVersionControlRequestEntityBuilder = new StartVersionControlRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(startVersionControlRequestEntityBuilder, startVersionControlRequestEntity);
    startVersionControlRequestEntityBuilder.setDisconnectedNodeAcknowledged(startVersionControlRequestEntity.isDisconnectedNodeAcknowledged());
    startVersionControlRequestEntityBuilder.setProcessGroupRevision(startVersionControlRequestEntity.getProcessGroupRevision());
    startVersionControlRequestEntityBuilder.setVersionedFlow(startVersionControlRequestEntity.getVersionedFlow());
    return startVersionControlRequestEntityBuilder;
  }
}
