package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorTypesEntity;

/**
 * Retrieves the types of processors that this NiFi supports
 */
public final class GetProcessorTypesInvoker extends AbstractInvoker<ProcessorTypesEntity> {
  public GetProcessorTypesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final ProcessorTypesEntity invoke() throws InvokerException {
    // /flow/processor-types
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("processor-types");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProcessorTypesEntity.class);
    }
    finally {
      response.close();
    }
  }
}