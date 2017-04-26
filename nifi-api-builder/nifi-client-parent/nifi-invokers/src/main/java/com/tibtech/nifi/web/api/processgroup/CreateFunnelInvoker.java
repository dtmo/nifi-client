package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FunnelEntity;

/**
 * Creates a funnel
 */
public final class CreateFunnelInvoker extends ComponentEntityInvoker<FunnelEntity> {
  private String id;

  private FunnelEntity funnelEntity;

  public CreateFunnelInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateFunnelInvoker setId(final String id) {
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
  public final CreateFunnelInvoker setFunnelEntity(final FunnelEntity funnelEntity) {
    this.funnelEntity = funnelEntity;
    return this;
  }

  public final FunnelEntity invoke() throws InvokerException {
    // /process-groups/{id}/funnels
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("funnels");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    funnelEntity.setRevision(createRevisionDto());
    final Entity<FunnelEntity> entity = Entity.entity(funnelEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, FunnelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
