package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceOptionsEntity;

public final class GetSearchOptionsInvoker extends AbstractInvoker<ProvenanceOptionsEntity> {
  public GetSearchOptionsInvoker(final Transport transport) {
    super(transport);
  }

  public final ProvenanceOptionsEntity invoke() throws InvokerException {
    // /provenance/search-options
    WebTarget target = getBaseWebTarget();
    target = target.path("provenance");
    target = target.path("search-options");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProvenanceOptionsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
