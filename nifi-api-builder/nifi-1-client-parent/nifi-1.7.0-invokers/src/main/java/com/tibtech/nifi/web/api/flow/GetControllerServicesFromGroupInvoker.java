package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServicesEntity;

/**
 * Gets all controller services
 */
public final class GetControllerServicesFromGroupInvoker extends AbstractInvoker<ControllerServicesEntity> {
  private String id;

  private boolean includeAncestorGroups;

  private boolean includeDescendantGroups;

  public GetControllerServicesFromGroupInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetControllerServicesFromGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Whether or not to include parent/ancestory process groups */
  public final boolean getIncludeAncestorGroups() {
    return includeAncestorGroups;
  }

  /**
   * Whether or not to include parent/ancestory process groups */
  public final GetControllerServicesFromGroupInvoker setIncludeAncestorGroups(
      final boolean includeAncestorGroups) {
    this.includeAncestorGroups = includeAncestorGroups;
    return this;
  }

  /**
   * Whether or not to include descendant process groups */
  public final boolean getIncludeDescendantGroups() {
    return includeDescendantGroups;
  }

  /**
   * Whether or not to include descendant process groups */
  public final GetControllerServicesFromGroupInvoker setIncludeDescendantGroups(
      final boolean includeDescendantGroups) {
    this.includeDescendantGroups = includeDescendantGroups;
    return this;
  }

  public final ControllerServicesEntity invoke() throws InvokerException {
    // nifi-api/flow/process-groups/{id}/controller-services
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("controller-services");
    target = target.queryParam("includeAncestorGroups", includeAncestorGroups);
    target = target.queryParam("includeDescendantGroups", includeDescendantGroups);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerServicesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
