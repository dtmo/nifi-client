package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.RulesEntity;

public final class DeleteRuleInvoker extends AbstractInvoker<RulesEntity> {
  private String id;

  private String processorId;

  private Long revision;

  public DeleteRuleInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getId() {
    return id;
  }

  public final DeleteRuleInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final String getProcessorId() {
    return processorId;
  }

  public final DeleteRuleInvoker setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public final Long getRevision() {
    return revision;
  }

  public final DeleteRuleInvoker setRevision(final Long revision) {
    this.revision = revision;
    return this;
  }

  public final RulesEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    target = target.path(id);
    target = target.queryParam("processorId", processorId);
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("revision", revision);
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, RulesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
