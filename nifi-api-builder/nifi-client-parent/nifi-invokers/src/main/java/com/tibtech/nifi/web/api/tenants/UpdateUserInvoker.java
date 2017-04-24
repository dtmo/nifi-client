package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserEntity;

public final class UpdateUserInvoker extends ComponentEntityInvoker<UserEntity> {
  private String id;

  private UserEntity userEntity;

  public UpdateUserInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user id. */
  public final String getId() {
    return id;
  }

  /**
   * The user id. */
  public final UpdateUserInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The user configuration details. */
  public final UserEntity getUserEntity() {
    return userEntity;
  }

  /**
   * The user configuration details. */
  public final UpdateUserInvoker setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
    return this;
  }

  public final UserEntity invoke() throws InvokerException {
    // /tenants/users/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("users");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    userEntity.setRevision(createRevisionDto());
    final Entity<UserEntity> entity = Entity.entity(userEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, UserEntity.class);
    }
    finally {
      response.close();
    }
  }
}
