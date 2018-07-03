package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FlowComparisonEntity;

/**
 * Gets a list of local modifications to the Process Group since it was last synchronized with the Flow Registry
 */
public final class GetLocalModificationsInvoker extends AbstractInvoker<FlowComparisonEntity> {
  private String id;

  public GetLocalModificationsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetLocalModificationsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final FlowComparisonEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/local-modifications
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("local-modifications");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, FlowComparisonEntity.class);
    }
    finally {
      response.close();
    }
  }
}
