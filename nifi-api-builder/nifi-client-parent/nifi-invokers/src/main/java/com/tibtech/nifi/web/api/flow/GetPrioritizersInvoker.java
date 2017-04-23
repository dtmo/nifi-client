package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PrioritizerTypesEntity;

public final class GetPrioritizersInvoker extends AbstractInvoker<PrioritizerTypesEntity> {
  public GetPrioritizersInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final PrioritizerTypesEntity invoke() throws InvokerException {
    // /flow/prioritizers
    WebTarget target = getBaseWebTarget();
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
