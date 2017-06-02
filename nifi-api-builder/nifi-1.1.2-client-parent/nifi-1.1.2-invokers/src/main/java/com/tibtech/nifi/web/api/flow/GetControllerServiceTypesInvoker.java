package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServiceTypesEntity;

/**
 * Retrieves the types of controller services that this NiFi supports
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetControllerServiceTypesInvoker extends AbstractInvoker<ControllerServiceTypesEntity> {
  private String serviceType;

  public GetControllerServiceTypesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * If specified, will only return controller services of this type. */
  public final String getServiceType() {
    return serviceType;
  }

  /**
   * If specified, will only return controller services of this type. */
  public final GetControllerServiceTypesInvoker setServiceType(final String serviceType) {
    this.serviceType = serviceType;
    return this;
  }

  public final ControllerServiceTypesEntity invoke() throws InvokerException {
    // nifi-api/flow/controller-service-types
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("controller-service-types");
    target = target.queryParam("serviceType", serviceType);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerServiceTypesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
