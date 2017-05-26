package com.tibtech.nifi.web.api.funnels;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FunnelEntity;

public final class UpdateFunnelInvoker extends ComponentEntityInvoker<FunnelEntity> {
  private String id;

  private FunnelEntity funnelEntity;

  public UpdateFunnelInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The funnel id. */
  public final String getId() {
    return id;
  }

  /**
   * The funnel id. */
  public final UpdateFunnelInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The funnel configuration details. */
  public final FunnelEntity getFunnelEntity() {
    return funnelEntity;
  }

  /**
   * The funnel configuration details. */
  public final UpdateFunnelInvoker setFunnelEntity(final FunnelEntity funnelEntity) {
    this.funnelEntity = funnelEntity;
    return this;
  }

  public final FunnelEntity invoke() throws InvokerException {
    // /funnels/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("funnels");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    funnelEntity.setRevision(createRevisionDto());
    final Entity<FunnelEntity> entity = Entity.entity(funnelEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, FunnelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
