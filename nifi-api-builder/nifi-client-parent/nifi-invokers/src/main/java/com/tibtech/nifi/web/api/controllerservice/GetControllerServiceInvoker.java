package com.tibtech.nifi.web.api.controllerservice;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;

/**
 * Gets a controller service
 */
public final class GetControllerServiceInvoker extends ComponentEntityInvoker<ControllerServiceEntity> {
  private String id;

  public GetControllerServiceInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The controller service id. */
  public final String getId() {
    return id;
  }

  /**
   * The controller service id. */
  public final GetControllerServiceInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ControllerServiceEntity invoke() throws InvokerException {
    // /controller-services/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("controller-services");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, ControllerServiceEntity.class);
    }
    finally {
      response.close();
    }
  }
}
