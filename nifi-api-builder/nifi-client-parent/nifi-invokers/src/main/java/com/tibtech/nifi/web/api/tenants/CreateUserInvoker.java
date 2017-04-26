package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserEntity;

/**
 * Creates a user
 */
public final class CreateUserInvoker extends ComponentEntityInvoker<UserEntity> {
  private UserEntity userEntity;

  public CreateUserInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user configuration details. */
  public final UserEntity getUserEntity() {
    return userEntity;
  }

  /**
   * The user configuration details. */
  public final CreateUserInvoker setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
    return this;
  }

  public final UserEntity invoke() throws InvokerException {
    // tenants/users
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("users");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    userEntity.setRevision(createRevisionDto());
    final Entity<UserEntity> entity = Entity.entity(userEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, UserEntity.class);
    }
    finally {
      response.close();
    }
  }
}
