package com.tibtech.nifi.web.api.data.transfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public final class ReceiveFlowFilesInvoker extends AbstractInvoker<String> {
  private String portId;

  private String transactionId;

  public ReceiveFlowFilesInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The input port id. */
  public final String getPortId() {
    return portId;
  }

  /**
   * The input port id. */
  public final ReceiveFlowFilesInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  public final String getTransactionId() {
    return transactionId;
  }

  public final ReceiveFlowFilesInvoker setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  public final String invoke() throws InvokerException {
    // /data-transfer/input-ports/{portId}/transactions/{transactionId}/flow-files
    WebTarget target = getBaseWebTarget();
    target = target.path("data-transfer");
    target = target.path("input-ports");
    target = target.path(portId);
    target = target.path("transactions");
    target = target.path(transactionId);
    target = target.path("flow-files");
    final Invocation.Builder invocationBuilder = target.request("text/plain");
    final Response response = invocationBuilder.method("POST");
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
