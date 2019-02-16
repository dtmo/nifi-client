package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserGroupEntity;

/**
 * Updates a user group
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class UpdateUserGroupInvoker extends ComponentEntityInvoker<UserGroupEntity> {
  private String id;

  private UserGroupEntity userGroupEntity;

  public UpdateUserGroupInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The user group id. */
  public final String getId() {
    return id;
  }

  /**
   * The user group id. */
  public final UpdateUserGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The user group configuration details. */
  public final UserGroupEntity getUserGroupEntity() {
    return userGroupEntity;
  }

  /**
   * The user group configuration details. */
  public final UpdateUserGroupInvoker setUserGroupEntity(final UserGroupEntity userGroupEntity) {
    this.userGroupEntity = userGroupEntity;
    return this;
  }

  public final UserGroupEntity invoke() throws InvokerException {
    // nifi-apitenants/user-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-apitenants");
    target = target.path("user-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<UserGroupEntity> entity = Entity.entity(userGroupEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, UserGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
