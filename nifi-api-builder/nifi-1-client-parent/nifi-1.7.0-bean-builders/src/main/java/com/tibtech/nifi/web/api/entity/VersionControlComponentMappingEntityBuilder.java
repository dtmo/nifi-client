package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.VersionControlComponentMappingEntity;

public final class VersionControlComponentMappingEntityBuilder extends AbstractEntityBuilder<VersionControlComponentMappingEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private RevisionDTO processGroupRevision;

  private Map<String, String> versionControlComponentMapping;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public VersionControlComponentMappingEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The revision of the Process Group
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The revision of the Process Group
   */
  public VersionControlComponentMappingEntityBuilder setProcessGroupRevision(final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The mapping of Versioned Component Identifiers to instance ID's
   */
  public Map<String, String> getVersionControlComponentMapping() {
    return versionControlComponentMapping;
  }

  /**
   * The mapping of Versioned Component Identifiers to instance ID's
   */
  public VersionControlComponentMappingEntityBuilder setVersionControlComponentMapping(final Map<String, String> versionControlComponentMapping) {
    this.versionControlComponentMapping = versionControlComponentMapping;
    return this;
  }

  public VersionControlComponentMappingEntity build() {
    final VersionControlComponentMappingEntity versionControlComponentMappingEntity = new VersionControlComponentMappingEntity();
    super.setPropertyValues(versionControlComponentMappingEntity);
    versionControlComponentMappingEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    versionControlComponentMappingEntity.setProcessGroupRevision(processGroupRevision);
    versionControlComponentMappingEntity.setVersionControlComponentMapping(versionControlComponentMapping);
    return versionControlComponentMappingEntity;
  }

  public static VersionControlComponentMappingEntityBuilder of(final VersionControlComponentMappingEntity versionControlComponentMappingEntity) {
    final VersionControlComponentMappingEntityBuilder versionControlComponentMappingEntityBuilder = new VersionControlComponentMappingEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionControlComponentMappingEntityBuilder, versionControlComponentMappingEntity);
    versionControlComponentMappingEntityBuilder.setDisconnectedNodeAcknowledged(versionControlComponentMappingEntity.isDisconnectedNodeAcknowledged());
    versionControlComponentMappingEntityBuilder.setProcessGroupRevision(versionControlComponentMappingEntity.getProcessGroupRevision());
    versionControlComponentMappingEntityBuilder.setVersionControlComponentMapping(versionControlComponentMappingEntity.getVersionControlComponentMapping());
    return versionControlComponentMappingEntityBuilder;
  }
}
