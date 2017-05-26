package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ClusterEntity;

public final class GetClusterInvoker extends AbstractInvoker<ClusterEntity> {
  public GetClusterInvoker(final Transport transport) {
    super(transport);
  }

  public final ClusterEntity invoke() throws InvokerException {
    // /controller/cluster
    WebTarget target = getBaseWebTarget();
    target = target.path("controller");
    target = target.path("cluster");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ClusterEntity.class);
    }
    finally {
      response.close();
    }
  }
}
