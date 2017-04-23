package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServiceTypesEntity;

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
    // /flow/controller-service-types
    WebTarget target = getBaseWebTarget();
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
