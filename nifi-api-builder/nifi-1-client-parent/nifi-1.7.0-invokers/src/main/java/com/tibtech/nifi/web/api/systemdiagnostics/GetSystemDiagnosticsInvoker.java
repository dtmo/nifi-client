package com.tibtech.nifi.web.api.systemdiagnostics;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.SystemDiagnosticsEntity;

/**
 * Gets the diagnostics for the system NiFi is running on
 */
public final class GetSystemDiagnosticsInvoker extends AbstractInvoker<SystemDiagnosticsEntity> {
  private Boolean nodewise;

  private String clusterNodeId;

  public GetSystemDiagnosticsInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final Boolean getNodewise() {
    return nodewise;
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final GetSystemDiagnosticsInvoker setNodewise(final Boolean nodewise) {
    this.nodewise = nodewise;
    return this;
  }

  /**
   * The id of the node where to get the status. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where to get the status. */
  public final GetSystemDiagnosticsInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final SystemDiagnosticsEntity invoke() throws InvokerException {
    // nifi-api/system-diagnostics
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("system-diagnostics");
    target = target.queryParam("nodewise", nodewise);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, SystemDiagnosticsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
