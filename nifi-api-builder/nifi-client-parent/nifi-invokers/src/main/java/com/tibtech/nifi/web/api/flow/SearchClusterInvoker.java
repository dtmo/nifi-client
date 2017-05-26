package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ClusterSearchResultsEntity;

public final class SearchClusterInvoker extends AbstractInvoker<ClusterSearchResultsEntity> {
  private String q;

  public SearchClusterInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * Node address to search for. */
  public final String getQ() {
    return q;
  }

  /**
   * Node address to search for. */
  public final SearchClusterInvoker setQ(final String q) {
    this.q = q;
    return this;
  }

  public final ClusterSearchResultsEntity invoke() throws InvokerException {
    // /flow/cluster/search-results
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("cluster");
    target = target.path("search-results");
    target = target.queryParam("q", q);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ClusterSearchResultsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
