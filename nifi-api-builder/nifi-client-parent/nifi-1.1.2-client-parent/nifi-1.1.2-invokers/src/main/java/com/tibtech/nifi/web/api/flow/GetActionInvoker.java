package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Integer;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ActionEntity;

/**
 * Gets an action
 */
public final class GetActionInvoker extends AbstractInvoker<ActionEntity> {
  private Integer id;

  public GetActionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The action id. */
  public final Integer getId() {
    return id;
  }

  /**
   * The action id. */
  public final GetActionInvoker setId(final Integer id) {
    this.id = id;
    return this;
  }

  public final ActionEntity invoke() throws InvokerException {
    // /flow/history/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("history");
    target = target.path(String.valueOf(id));
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ActionEntity.class);
    }
    finally {
      response.close();
    }
  }
}
