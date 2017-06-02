package com.tibtech.nifi.web.api.accesspolicy;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;

/**
 * Creates an access policy
 */
public final class CreateAccessPolicyInvoker extends ComponentEntityInvoker<AccessPolicyEntity> {
  private AccessPolicyEntity accessPolicyEntity;

  public CreateAccessPolicyInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The access policy configuration details. */
  public final AccessPolicyEntity getAccessPolicyEntity() {
    return accessPolicyEntity;
  }

  /**
   * The access policy configuration details. */
  public final CreateAccessPolicyInvoker setAccessPolicyEntity(final AccessPolicyEntity accessPolicyEntity) {
    this.accessPolicyEntity = accessPolicyEntity;
    return this;
  }

  public final AccessPolicyEntity invoke() throws InvokerException {
    // nifi-api/policies
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("policies");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    accessPolicyEntity.setRevision(createRevisionDto());
    final Entity<AccessPolicyEntity> entity = Entity.entity(accessPolicyEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, AccessPolicyEntity.class);
    }
    finally {
      response.close();
    }
  }
}
