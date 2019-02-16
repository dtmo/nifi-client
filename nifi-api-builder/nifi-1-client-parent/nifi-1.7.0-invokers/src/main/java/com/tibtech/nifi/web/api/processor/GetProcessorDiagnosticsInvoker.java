package com.tibtech.nifi.web.api.processor;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorEntity;

/**
 * Gets diagnostics information about a processor
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetProcessorDiagnosticsInvoker extends ComponentEntityInvoker<ProcessorEntity> {
  private String id;

  public GetProcessorDiagnosticsInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The processor id. */
  public final String getId() {
    return id;
  }

  /**
   * The processor id. */
  public final GetProcessorDiagnosticsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ProcessorEntity invoke() throws InvokerException {
    // nifi-api/processors/{id}/diagnostics
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("processors");
    target = target.path(id);
    target = target.path("diagnostics");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, ProcessorEntity.class);
    }
    finally {
      response.close();
    }
  }
}
