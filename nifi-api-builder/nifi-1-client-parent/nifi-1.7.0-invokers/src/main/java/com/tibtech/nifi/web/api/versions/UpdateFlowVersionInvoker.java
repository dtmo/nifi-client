package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionControlInformationEntity;
import org.apache.nifi.web.api.entity.VersionedFlowSnapshotEntity;

/**
 * Update the version of a Process Group with the given ID
 * <p>For a Process Group that is already under Version Control, this will update the version of the flow to a different version. This endpoint expects that the given snapshot will not modify any Processor that is currently running or any Controller Service that is enabled. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class UpdateFlowVersionInvoker extends AbstractInvoker<VersionControlInformationEntity> {
  private String id;

  private VersionedFlowSnapshotEntity versionedFlowSnapshotEntity;

  public UpdateFlowVersionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final UpdateFlowVersionInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The controller service configuration details. */
  public final VersionedFlowSnapshotEntity getVersionedFlowSnapshotEntity() {
    return versionedFlowSnapshotEntity;
  }

  /**
   * The controller service configuration details. */
  public final UpdateFlowVersionInvoker setVersionedFlowSnapshotEntity(
      final VersionedFlowSnapshotEntity versionedFlowSnapshotEntity) {
    this.versionedFlowSnapshotEntity = versionedFlowSnapshotEntity;
    return this;
  }

  public final VersionControlInformationEntity invoke() throws InvokerException {
    // nifi-api/versions/process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<VersionedFlowSnapshotEntity> entity = Entity.entity(versionedFlowSnapshotEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, VersionControlInformationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
