package com.tibtech.nifi.update.attributes.api.rule;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.update.attributes.entity.RulesEntity;

public final class SearchRulesInvoker extends AbstractInvoker<RulesEntity> {
  private String processorId;

  private String q;

  public SearchRulesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getProcessorId() {
    return processorId;
  }

  public final SearchRulesInvoker setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public final String getQ() {
    return q;
  }

  public final SearchRulesInvoker setQ(final String q) {
    this.q = q;
    return this;
  }

  public final RulesEntity invoke() throws InvokerException {
    // nifi-update-attribute-ui-1.1.2/api/criteria/rules/search-results
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-update-attribute-ui-1.1.2");
    target = target.path("api");
    target = target.path("criteria");
    target = target.path("rules");
    target = target.path("search-results");
    target = target.queryParam("processorId", processorId);
    target = target.queryParam("q", q);
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, RulesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
