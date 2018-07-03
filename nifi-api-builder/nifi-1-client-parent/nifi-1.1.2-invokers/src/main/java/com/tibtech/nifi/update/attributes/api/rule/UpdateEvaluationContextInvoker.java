package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.EvaluationContextEntity;

public final class UpdateEvaluationContextInvoker extends AbstractInvoker<EvaluationContextEntity> {
  private EvaluationContextEntity evaluationContextEntity;

  public UpdateEvaluationContextInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final EvaluationContextEntity getEvaluationContextEntity() {
    return evaluationContextEntity;
  }

  public final UpdateEvaluationContextInvoker setEvaluationContextEntity(final EvaluationContextEntity evaluationContextEntity) {
    this.evaluationContextEntity = evaluationContextEntity;
    return this;
  }

  public final EvaluationContextEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/evaluation-context
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("evaluation-context");
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Entity<EvaluationContextEntity> entity = Entity.entity(evaluationContextEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, EvaluationContextEntity.class);
    }
    finally {
      response.close();
    }
  }
}
