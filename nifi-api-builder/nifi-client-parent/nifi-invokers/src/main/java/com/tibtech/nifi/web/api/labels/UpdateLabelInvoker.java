package com.tibtech.nifi.web.api.labels;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LabelEntity;

public final class UpdateLabelInvoker extends ComponentEntityInvoker<LabelEntity> {
  private String id;

  private LabelEntity labelEntity;

  public UpdateLabelInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The label id. */
  public final String getId() {
    return id;
  }

  /**
   * The label id. */
  public final UpdateLabelInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The label configuration details. */
  public final LabelEntity getLabelEntity() {
    return labelEntity;
  }

  /**
   * The label configuration details. */
  public final UpdateLabelInvoker setLabelEntity(final LabelEntity labelEntity) {
    this.labelEntity = labelEntity;
    return this;
  }

  public final LabelEntity invoke() throws InvokerException {
    // /labels/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("labels");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    labelEntity.setRevision(createRevisionDto());
    final Entity<LabelEntity> entity = Entity.entity(labelEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, LabelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
