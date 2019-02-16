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
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class CreateUserInvoker extends ComponentEntityInvoker<UserEntity> {
  private UserEntity userEntity;

  public CreateUserInvoker(final Transport transport) {
    super(transport);
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
    // nifi-apitenants/users
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-apitenants");
    target = target.path("users");
    final Invocation.Builder invocationBuilder = target.request("application/json");
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
