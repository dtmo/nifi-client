package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserGroupEntity;

public final class CreateUserGroupInvoker extends ComponentEntityInvoker<UserGroupEntity> {
  private UserGroupEntity userGroupEntity;

  public CreateUserGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user group configuration details. */
  public final UserGroupEntity getUserGroupEntity() {
    return userGroupEntity;
  }

  /**
   * The user group configuration details. */
  public final CreateUserGroupInvoker setUserGroupEntity(final UserGroupEntity userGroupEntity) {
    this.userGroupEntity = userGroupEntity;
    return this;
  }

  public final UserGroupEntity invoke() throws InvokerException {
    // /tenants/user-groups
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("user-groups");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    userGroupEntity.setRevision(createRevisionDto());
    final Entity<UserGroupEntity> entity = Entity.entity(userGroupEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, UserGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
