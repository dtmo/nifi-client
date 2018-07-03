package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.ConditionEntity;

public final class CreateConditionInvoker extends AbstractInvoker<ConditionEntity> {
  private String id;

  private ConditionEntity conditionEntity;

  public CreateConditionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getId() {
    return id;
  }

  public final CreateConditionInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ConditionEntity getConditionEntity() {
    return conditionEntity;
  }

  public final CreateConditionInvoker setConditionEntity(final ConditionEntity conditionEntity) {
    this.conditionEntity = conditionEntity;
    return this;
  }

  public final ConditionEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules/conditions
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    target = target.path("conditions");
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Entity<ConditionEntity> entity = Entity.entity(conditionEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, ConditionEntity.class);
    }
    finally {
      response.close();
    }
  }
}
