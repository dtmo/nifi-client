package com.tibtech.nifi.web.api.label;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LabelEntity;

/**
 * Gets a label
 */
public final class GetLabelInvoker extends ComponentEntityInvoker<LabelEntity> {
  private String id;

  public GetLabelInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The label id. */
  public final String getId() {
    return id;
  }

  /**
   * The label id. */
  public final GetLabelInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final LabelEntity invoke() throws InvokerException {
    // /labels/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("labels");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, LabelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
