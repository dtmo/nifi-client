package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.RuleEntity;

public final class GetRuleInvoker extends AbstractInvoker<RuleEntity> {
  private String id;

  private String processorId;

  private Boolean verbose;

  public GetRuleInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getId() {
    return id;
  }

  public final GetRuleInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final String getProcessorId() {
    return processorId;
  }

  public final GetRuleInvoker setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public final Boolean getVerbose() {
    return verbose;
  }

  public final GetRuleInvoker setVerbose(final Boolean verbose) {
    this.verbose = verbose;
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
    target = target.queryParam("processorId", processorId);
    target = target.queryParam("verbose", verbose);
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, RuleEntity.class);
    }
    finally {
      response.close();
    }
  }
}
