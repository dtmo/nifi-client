package com.tibtech.nifi.web.api.counters;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.CounterEntity;

/**
 * Updates the specified counter. This will reset the counter value to 0
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class UpdateCounterInvoker extends AbstractInvoker<CounterEntity> {
  private String id;

  public UpdateCounterInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The id of the counter. */
  public final String getId() {
    return id;
  }

  /**
   * The id of the counter. */
  public final UpdateCounterInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final CounterEntity invoke() throws InvokerException {
    // /counters/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("counters");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("PUT");
    try {
      return handleResponse(response, CounterEntity.class);
    }
    finally {
      response.close();
    }
  }
}
