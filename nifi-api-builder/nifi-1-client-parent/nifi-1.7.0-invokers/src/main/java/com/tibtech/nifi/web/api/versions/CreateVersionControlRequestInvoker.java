package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.CreateActiveRequestEntity;

/**
 * Create a version control request
 * <p>Creates a request so that a Process Group can be placed under Version Control or have its Version Control configuration changed. Creating this request will prevent any other threads from simultaneously saving local changes to Version Control. It will not, however, actually save the local flow to the Flow Registry. A POST to /versions/process-groups/{id} should be used to initiate saving of the local flow to the Flow Registry. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class CreateVersionControlRequestInvoker extends AbstractInvoker<String> {
  private CreateActiveRequestEntity createActiveRequestEntity;

  public CreateVersionControlRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The versioned flow details. */
  public final CreateActiveRequestEntity getCreateActiveRequestEntity() {
    return createActiveRequestEntity;
  }

  /**
   * The versioned flow details. */
  public final CreateVersionControlRequestInvoker setCreateActiveRequestEntity(
      final CreateActiveRequestEntity createActiveRequestEntity) {
    this.createActiveRequestEntity = createActiveRequestEntity;
    return this;
  }

  public final String invoke() throws InvokerException {
    // nifi-api/versions/active-requests
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("active-requests");
    final Invocation.Builder invocationBuilder = target.request("text/plain");
    final Entity<CreateActiveRequestEntity> entity = Entity.entity(createActiveRequestEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
