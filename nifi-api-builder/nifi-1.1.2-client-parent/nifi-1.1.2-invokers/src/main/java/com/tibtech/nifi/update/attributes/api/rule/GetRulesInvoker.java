package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.RulesEntity;

public final class GetRulesInvoker extends AbstractInvoker<RulesEntity> {
  private String processorId;

  private Boolean verbose;

  public GetRulesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getProcessorId() {
    return processorId;
  }

  public final GetRulesInvoker setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public final Boolean getVerbose() {
    return verbose;
  }

  public final GetRulesInvoker setVerbose(final Boolean verbose) {
    this.verbose = verbose;
    return this;
  }

  public final RulesEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    target = target.queryParam("processorId", processorId);
    target = target.queryParam("verbose", verbose);
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, RulesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
