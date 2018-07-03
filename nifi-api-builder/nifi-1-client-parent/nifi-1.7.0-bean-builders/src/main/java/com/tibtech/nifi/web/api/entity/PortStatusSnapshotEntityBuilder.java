package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.PortStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.PortStatusSnapshotEntity;

public final class PortStatusSnapshotEntityBuilder extends AbstractEntityBuilder<PortStatusSnapshotEntityBuilder> {
  private Boolean canRead;

  private String id;

  private PortStatusSnapshotDTO portStatusSnapshot;

  public Boolean getCanRead() {
    return canRead;
  }

  public PortStatusSnapshotEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  /**
   * The id of the port.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the port.
   */
  public PortStatusSnapshotEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public PortStatusSnapshotDTO getPortStatusSnapshot() {
    return portStatusSnapshot;
  }

  public PortStatusSnapshotEntityBuilder setPortStatusSnapshot(final PortStatusSnapshotDTO portStatusSnapshot) {
    this.portStatusSnapshot = portStatusSnapshot;
    return this;
  }

  public PortStatusSnapshotEntity build() {
    final PortStatusSnapshotEntity portStatusSnapshotEntity = new PortStatusSnapshotEntity();
    super.setPropertyValues(portStatusSnapshotEntity);
    portStatusSnapshotEntity.setCanRead(canRead);
    portStatusSnapshotEntity.setId(id);
    portStatusSnapshotEntity.setPortStatusSnapshot(portStatusSnapshot);
    return portStatusSnapshotEntity;
  }

  public static PortStatusSnapshotEntityBuilder of(final PortStatusSnapshotEntity portStatusSnapshotEntity) {
    final PortStatusSnapshotEntityBuilder portStatusSnapshotEntityBuilder = new PortStatusSnapshotEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(portStatusSnapshotEntityBuilder, portStatusSnapshotEntity);
    portStatusSnapshotEntityBuilder.setCanRead(portStatusSnapshotEntity.getCanRead());
    portStatusSnapshotEntityBuilder.setId(portStatusSnapshotEntity.getId());
    portStatusSnapshotEntityBuilder.setPortStatusSnapshot(portStatusSnapshotEntity.getPortStatusSnapshot());
    return portStatusSnapshotEntityBuilder;
  }
}
