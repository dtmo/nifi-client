package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorsEntity;

/**
 * Gets all processors
 */
public final class GetProcessorsInvoker extends AbstractInvoker<ProcessorsEntity> {
  private String id;

  private boolean includeDescendantGroups;

  public GetProcessorsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetProcessorsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Whether or not to include processors from descendant process groups */
  public final boolean getIncludeDescendantGroups() {
    return includeDescendantGroups;
  }

  /**
   * Whether or not to include processors from descendant process groups */
  public final GetProcessorsInvoker setIncludeDescendantGroups(
      final boolean includeDescendantGroups) {
    this.includeDescendantGroups = includeDescendantGroups;
    return this;
  }

  public final ProcessorsEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/processors
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("processors");
    target = target.queryParam("includeDescendantGroups", includeDescendantGroups);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProcessorsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
