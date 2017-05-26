package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LabelEntity;

public final class CreateLabelInvoker extends ComponentEntityInvoker<LabelEntity> {
  private String id;

  private LabelEntity labelEntity;

  public CreateLabelInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateLabelInvoker setId(final String id) {
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
  public final CreateLabelInvoker setLabelEntity(final LabelEntity labelEntity) {
    this.labelEntity = labelEntity;
    return this;
  }

  public final LabelEntity invoke() throws InvokerException {
    // /process-groups/{id}/labels
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("labels");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    labelEntity.setRevision(createRevisionDto());
    final Entity<LabelEntity> entity = Entity.entity(labelEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, LabelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
