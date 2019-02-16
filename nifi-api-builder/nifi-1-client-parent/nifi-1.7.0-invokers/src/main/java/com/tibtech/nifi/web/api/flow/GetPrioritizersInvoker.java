package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PrioritizerTypesEntity;

/**
 * Retrieves the types of prioritizers that this NiFi supports
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetPrioritizersInvoker extends AbstractInvoker<PrioritizerTypesEntity> {
  public GetPrioritizersInvoker(final Transport transport) {
    super(transport);
  }

  public final PrioritizerTypesEntity invoke() throws InvokerException {
    // nifi-api/flow/prioritizers
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("prioritizers");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, PrioritizerTypesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
