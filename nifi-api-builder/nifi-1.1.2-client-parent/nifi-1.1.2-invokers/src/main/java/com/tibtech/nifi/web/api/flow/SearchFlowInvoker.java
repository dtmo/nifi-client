package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.SearchResultsEntity;

/**
 * Performs a search against this NiFi using the specified search term
 */
public final class SearchFlowInvoker extends AbstractInvoker<SearchResultsEntity> {
  private String q;

  public SearchFlowInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getQ() {
    return q;
  }

  public final SearchFlowInvoker setQ(final String q) {
    this.q = q;
    return this;
  }

  public final SearchResultsEntity invoke() throws InvokerException {
    // /flow/search-results
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("search-results");
    target = target.queryParam("q", q);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, SearchResultsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
