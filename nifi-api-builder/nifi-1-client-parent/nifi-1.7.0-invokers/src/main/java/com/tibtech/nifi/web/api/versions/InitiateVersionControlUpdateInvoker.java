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
import org.apache.nifi.web.api.entity.VersionedFlowUpdateRequestEntity;

/**
 * Initiate the Update Request of a Process Group with the given ID
 * <p>For a Process Group that is already under Version Control, this will initiate the action of changing from a specific version of the flow in the Flow Registry to a different version of the flow. This can be a lengthy process, as it will stop any Processors and disable any Controller Services necessary to perform the action and then restart them. As a result, the endpoint will immediately return a VersionedFlowUpdateRequestEntity, and the process of updating the flow will occur asynchronously in the background. The client may then periodically poll the status of the request by issuing a GET request to /versions/update-requests/{requestId}. Once the request is completed, the client is expected to issue a DELETE request to /versions/update-requests/{requestId}. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class InitiateVersionControlUpdateInvoker extends AbstractInvoker<VersionedFlowUpdateRequestEntity> {
  private String id;

  private VersionControlInformationEntity versionControlInformationEntity;

  public InitiateVersionControlUpdateInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final InitiateVersionControlUpdateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The controller service configuration details. */
  public final VersionControlInformationEntity getVersionControlInformationEntity() {
    return versionControlInformationEntity;
  }

  /**
   * The controller service configuration details. */
  public final InitiateVersionControlUpdateInvoker setVersionControlInformationEntity(
      final VersionControlInformationEntity versionControlInformationEntity) {
    this.versionControlInformationEntity = versionControlInformationEntity;
    return this;
  }

  public final VersionedFlowUpdateRequestEntity invoke() throws InvokerException {
    // nifi-api/versions/update-requests/process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("update-requests");
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<VersionControlInformationEntity> entity = Entity.entity(versionControlInformationEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, VersionedFlowUpdateRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
