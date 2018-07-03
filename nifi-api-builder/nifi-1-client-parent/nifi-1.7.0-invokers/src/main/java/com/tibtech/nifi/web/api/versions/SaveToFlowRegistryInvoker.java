package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.StartVersionControlRequestEntity;
import org.apache.nifi.web.api.entity.VersionControlInformationEntity;

/**
 * Save the Process Group with the given ID
 * <p>Begins version controlling the Process Group with the given ID or commits changes to the Versioned Flow, depending on if the provided VersionControlInformation includes a flowId. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class SaveToFlowRegistryInvoker extends AbstractInvoker<VersionControlInformationEntity> {
  private String id;

  private StartVersionControlRequestEntity startVersionControlRequestEntity;

  public SaveToFlowRegistryInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final SaveToFlowRegistryInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The versioned flow details. */
  public final StartVersionControlRequestEntity getStartVersionControlRequestEntity() {
    return startVersionControlRequestEntity;
  }

  /**
   * The versioned flow details. */
  public final SaveToFlowRegistryInvoker setStartVersionControlRequestEntity(
      final StartVersionControlRequestEntity startVersionControlRequestEntity) {
    this.startVersionControlRequestEntity = startVersionControlRequestEntity;
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
    final Entity<StartVersionControlRequestEntity> entity = Entity.entity(startVersionControlRequestEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, VersionControlInformationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
