package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionControlInformationEntity;

/**
 * Gets the Version Control information for a process group
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetVersionInformationInvoker extends AbstractInvoker<VersionControlInformationEntity> {
  private String id;

  public GetVersionInformationInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetVersionInformationInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final VersionControlInformationEntity invoke() throws InvokerException {
    // nifi-api/versions/process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, VersionControlInformationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
