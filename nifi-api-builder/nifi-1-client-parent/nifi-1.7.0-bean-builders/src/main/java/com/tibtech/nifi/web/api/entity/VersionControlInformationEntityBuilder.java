package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.VersionControlInformationDTO;
import org.apache.nifi.web.api.entity.VersionControlInformationEntity;

public final class VersionControlInformationEntityBuilder extends AbstractEntityBuilder<VersionControlInformationEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private RevisionDTO processGroupRevision;

  private VersionControlInformationDTO versionControlInformation;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public VersionControlInformationEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The Revision for the Process Group
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The Revision for the Process Group
   */
  public VersionControlInformationEntityBuilder setProcessGroupRevision(final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The Version Control information
   */
  public VersionControlInformationDTO getVersionControlInformation() {
    return versionControlInformation;
  }

  /**
   * The Version Control information
   */
  public VersionControlInformationEntityBuilder setVersionControlInformation(final VersionControlInformationDTO versionControlInformation) {
    this.versionControlInformation = versionControlInformation;
    return this;
  }

  public VersionControlInformationEntity build() {
    final VersionControlInformationEntity versionControlInformationEntity = new VersionControlInformationEntity();
    super.setPropertyValues(versionControlInformationEntity);
    versionControlInformationEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    versionControlInformationEntity.setProcessGroupRevision(processGroupRevision);
    versionControlInformationEntity.setVersionControlInformation(versionControlInformation);
    return versionControlInformationEntity;
  }

  public static VersionControlInformationEntityBuilder of(final VersionControlInformationEntity versionControlInformationEntity) {
    final VersionControlInformationEntityBuilder versionControlInformationEntityBuilder = new VersionControlInformationEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionControlInformationEntityBuilder, versionControlInformationEntity);
    versionControlInformationEntityBuilder.setDisconnectedNodeAcknowledged(versionControlInformationEntity.isDisconnectedNodeAcknowledged());
    versionControlInformationEntityBuilder.setProcessGroupRevision(versionControlInformationEntity.getProcessGroupRevision());
    versionControlInformationEntityBuilder.setVersionControlInformation(versionControlInformationEntity.getVersionControlInformation());
    return versionControlInformationEntityBuilder;
  }
}
