package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TenantsEntity;

public final class SearchClusterInvoker extends AbstractInvoker<TenantsEntity> {
  private String q;

  public SearchClusterInvoker(final Transport transport) {
    super(transport);
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
    // tenants/search-results
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
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
