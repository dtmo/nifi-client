package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FlowConfigurationEntity;

/**
 * Retrieves the configuration for this NiFi flow
 */
public final class GetFlowConfigInvoker extends AbstractInvoker<FlowConfigurationEntity> {
  public GetFlowConfigInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final FlowConfigurationEntity invoke() throws InvokerException {
    // nifi-api/flow/config
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("config");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, FlowConfigurationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
