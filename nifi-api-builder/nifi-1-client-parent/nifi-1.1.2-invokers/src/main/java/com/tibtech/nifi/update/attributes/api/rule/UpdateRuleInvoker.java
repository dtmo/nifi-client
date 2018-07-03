package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.RuleEntity;

public final class UpdateRuleInvoker extends AbstractInvoker<RuleEntity> {
  private String id;

  private RuleEntity ruleEntity;

  public UpdateRuleInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getId() {
    return id;
  }

  public final UpdateRuleInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final RuleEntity getRuleEntity() {
    return ruleEntity;
  }

  public final UpdateRuleInvoker setRuleEntity(final RuleEntity ruleEntity) {
    this.ruleEntity = ruleEntity;
    return this;
  }

  public final RuleEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Entity<RuleEntity> entity = Entity.entity(ruleEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, RuleEntity.class);
    }
    finally {
      response.close();
    }
  }
}
