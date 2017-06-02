package com.tibtech.nifi.web.api.accesspolicy;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;

/**
 * Updates a access policy
 */
public final class UpdateAccessPolicyInvoker extends ComponentEntityInvoker<AccessPolicyEntity> {
  private String id;

  private AccessPolicyEntity accessPolicyEntity;

  public UpdateAccessPolicyInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The access policy id. */
  public final String getId() {
    return id;
  }

  /**
   * The access policy id. */
  public final UpdateAccessPolicyInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The access policy configuration details. */
  public final AccessPolicyEntity getAccessPolicyEntity() {
    return accessPolicyEntity;
  }

  /**
   * The access policy configuration details. */
  public final UpdateAccessPolicyInvoker setAccessPolicyEntity(final AccessPolicyEntity accessPolicyEntity) {
    this.accessPolicyEntity = accessPolicyEntity;
    return this;
  }

  public final AccessPolicyEntity invoke() throws InvokerException {
    // nifi-api/policies/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("policies");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    accessPolicyEntity.setRevision(createRevisionDto());
    final Entity<AccessPolicyEntity> entity = Entity.entity(accessPolicyEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, AccessPolicyEntity.class);
    }
    finally {
      response.close();
    }
  }
}
