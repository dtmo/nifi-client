package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VariableRegistryEntity;

/**
 * Gets a process group's variable registry
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetVariableRegistryInvoker extends AbstractInvoker<VariableRegistryEntity> {
  private String id;

  private boolean includeAncestorGroups;

  public GetVariableRegistryInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetVariableRegistryInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Whether or not to include ancestor groups */
  public final boolean getIncludeAncestorGroups() {
    return includeAncestorGroups;
  }

  /**
   * Whether or not to include ancestor groups */
  public final GetVariableRegistryInvoker setIncludeAncestorGroups(
      final boolean includeAncestorGroups) {
    this.includeAncestorGroups = includeAncestorGroups;
    return this;
  }

  public final VariableRegistryEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/variable-registry
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("variable-registry");
    target = target.queryParam("includeAncestorGroups", includeAncestorGroups);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, VariableRegistryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
