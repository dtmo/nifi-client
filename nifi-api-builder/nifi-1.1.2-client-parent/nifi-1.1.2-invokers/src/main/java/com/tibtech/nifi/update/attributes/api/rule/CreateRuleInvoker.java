package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.RuleEntity;

public final class CreateRuleInvoker extends AbstractInvoker<RuleEntity> {
  private RuleEntity ruleEntity;

  public CreateRuleInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final RuleEntity getRuleEntity() {
    return ruleEntity;
  }

  public final CreateRuleInvoker setRuleEntity(final RuleEntity ruleEntity) {
    this.ruleEntity = ruleEntity;
    return this;
  }

  public final RuleEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Entity<RuleEntity> entity = Entity.entity(ruleEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, RuleEntity.class);
    }
    finally {
      response.close();
    }
  }
}
