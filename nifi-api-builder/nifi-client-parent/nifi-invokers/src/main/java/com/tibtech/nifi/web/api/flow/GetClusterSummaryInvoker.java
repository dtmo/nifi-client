package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ClusteSummaryEntity;

public final class GetClusterSummaryInvoker extends AbstractInvoker<ClusteSummaryEntity> {
  public GetClusterSummaryInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final ClusteSummaryEntity invoke() throws InvokerException {
    // /flow/cluster/summary
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("cluster");
    target = target.path("summary");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ClusteSummaryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
