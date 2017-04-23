package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LabelsEntity;

public final class GetLabelsInvoker extends AbstractInvoker<LabelsEntity> {
  private String id;

  public GetLabelsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetLabelsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final LabelsEntity invoke() throws InvokerException {
    // /process-groups/{id}/labels
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("labels");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, LabelsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
