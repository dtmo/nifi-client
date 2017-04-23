package com.tibtech.nifi.web.api.processors;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorEntity;

public final class GetProcessorInvoker extends ComponentEntityInvoker<ProcessorEntity> {
  private String id;

  public GetProcessorInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The processor id. */
  public final String getId() {
    return id;
  }

  /**
   * The processor id. */
  public final GetProcessorInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ProcessorEntity invoke() throws InvokerException {
    // /processors/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("processors");
    target = target.path(id);
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
