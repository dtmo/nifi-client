package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.BulletinEntity;

/**
 * Creates a new bulletin
 */
public final class CreateBulletinInvoker extends AbstractInvoker<BulletinEntity> {
  private BulletinEntity bulletinEntity;

  public CreateBulletinInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The reporting task configuration details. */
  public final BulletinEntity getBulletinEntity() {
    return bulletinEntity;
  }

  /**
   * The reporting task configuration details. */
  public final CreateBulletinInvoker setBulletinEntity(final BulletinEntity bulletinEntity) {
    this.bulletinEntity = bulletinEntity;
    return this;
  }

  public final BulletinEntity invoke() throws InvokerException {
    // nifi-api/controller/bulletin
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("bulletin");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<BulletinEntity> entity = Entity.entity(bulletinEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, BulletinEntity.class);
    }
    finally {
      response.close();
    }
  }
}
