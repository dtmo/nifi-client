package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.ActionEntity;

public final class CreateActionInvoker extends AbstractInvoker<ActionEntity> {
  private String id;

  private ActionEntity actionEntity;

  public CreateActionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getId() {
    return id;
  }

  public final CreateActionInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ActionEntity getActionEntity() {
    return actionEntity;
  }

  public final CreateActionInvoker setActionEntity(final ActionEntity actionEntity) {
    this.actionEntity = actionEntity;
    return this;
  }

  public final ActionEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules/actions
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    target = target.path("actions");
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Entity<ActionEntity> entity = Entity.entity(actionEntity, "text/plain");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, ActionEntity.class);
    }
    finally {
      response.close();
    }
  }
}
