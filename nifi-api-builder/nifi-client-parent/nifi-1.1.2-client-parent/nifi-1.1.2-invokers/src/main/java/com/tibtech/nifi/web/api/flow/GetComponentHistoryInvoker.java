package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ComponentHistoryEntity;

/**
 * Gets configuration history for a component
 */
public final class GetComponentHistoryInvoker extends AbstractInvoker<ComponentHistoryEntity> {
  private String componentId;

  public GetComponentHistoryInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The component id. */
  public final String getComponentId() {
    return componentId;
  }

  /**
   * The component id. */
  public final GetComponentHistoryInvoker setComponentId(final String componentId) {
    this.componentId = componentId;
    return this;
  }

  public final ComponentHistoryEntity invoke() throws InvokerException {
    // /flow/history/components/{componentId}
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("history");
    target = target.path("components");
    target = target.path(componentId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ComponentHistoryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
