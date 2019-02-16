package com.tibtech.nifi.web.api.resource;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ResourcesEntity;

/**
 * Gets the available resources that support access/authorization policies
 */
public final class GetResourcesInvoker extends AbstractInvoker<ResourcesEntity> {
  public GetResourcesInvoker(final Transport transport) {
    super(transport);
  }

  public final ResourcesEntity invoke() throws InvokerException {
    // nifi-api/resources
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("resources");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ResourcesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
