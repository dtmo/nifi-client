package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.EvaluationContextEntity;

public final class GetEvaluationContextInvoker extends AbstractInvoker<EvaluationContextEntity> {
  private String processorId;

  public GetEvaluationContextInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getProcessorId() {
    return processorId;
  }

  public final GetEvaluationContextInvoker setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public final EvaluationContextEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/evaluation-context
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("evaluation-context");
    target = target.queryParam("processorId", processorId);
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, EvaluationContextEntity.class);
    }
    finally {
      response.close();
    }
  }
}
