package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TenantsEntity;

/**
 * Searches for a tenant with the specified identity
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class SearchClusterInvoker extends AbstractInvoker<TenantsEntity> {
  private String q;

  public SearchClusterInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * Identity to search for. */
  public final String getQ() {
    return q;
  }

  /**
   * Identity to search for. */
  public final SearchClusterInvoker setQ(final String q) {
    this.q = q;
    return this;
  }

  public final TenantsEntity invoke() throws InvokerException {
    // nifi-apitenants/search-results
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-apitenants");
    target = target.path("search-results");
    target = target.queryParam("q", q);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, TenantsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
