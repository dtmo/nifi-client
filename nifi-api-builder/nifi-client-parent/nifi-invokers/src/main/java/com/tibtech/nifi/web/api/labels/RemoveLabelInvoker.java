package com.tibtech.nifi.web.api.labels;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LabelEntity;

public final class RemoveLabelInvoker extends ComponentEntityInvoker<LabelEntity> {
  private String id;

  public RemoveLabelInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The label id. */
  public final String getId() {
    return id;
  }

  /**
   * The label id. */
  public final RemoveLabelInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final LabelEntity invoke() throws InvokerException {
    // /labels/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("labels");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, LabelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
