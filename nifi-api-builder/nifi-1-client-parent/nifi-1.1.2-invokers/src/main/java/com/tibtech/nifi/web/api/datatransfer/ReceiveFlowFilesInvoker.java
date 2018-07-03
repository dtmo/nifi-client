package com.tibtech.nifi.web.api.datatransfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.io.InputStream;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Transfer flow files to the input port
 */
public final class ReceiveFlowFilesInvoker extends AbstractInvoker<String> {
  private String portId;

  private String transactionId;

  private InputStream inputStream;

  public ReceiveFlowFilesInvoker(final Transport transport, final long version) {
    super(transport, version);
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

  public final InputStream getInputStream() {
    return inputStream;
  }

  public final ReceiveFlowFilesInvoker setInputStream(final InputStream inputStream) {
    this.inputStream = inputStream;
    return this;
  }

  public final String invoke() throws InvokerException {
    // nifi-api/data-transfer/input-ports/{portId}/transactions/{transactionId}/flow-files
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("data-transfer");
    target = target.path("input-ports");
    target = target.path(portId);
    target = target.path("transactions");
    target = target.path(transactionId);
    target = target.path("flow-files");
    final Invocation.Builder invocationBuilder = target.request("text/plain");
    final Entity<InputStream> entity = Entity.entity(inputStream, "application/octet-stream");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
