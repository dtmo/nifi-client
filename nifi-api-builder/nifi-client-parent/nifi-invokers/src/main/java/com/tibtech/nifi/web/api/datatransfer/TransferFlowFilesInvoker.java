package com.tibtech.nifi.web.api.datatransfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 * Transfer flow files from the output port
 */
public final class TransferFlowFilesInvoker extends AbstractInvoker<StreamingOutput> {
  private String portId;

  private String transactionId;

  public TransferFlowFilesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The output port id. */
  public final String getPortId() {
    return portId;
  }

  /**
   * The output port id. */
  public final TransferFlowFilesInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  public final String getTransactionId() {
    return transactionId;
  }

  public final TransferFlowFilesInvoker setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  public final StreamingOutput invoke() throws InvokerException {
    // /data-transfer/output-ports/{portId}/transactions/{transactionId}/flow-files
    WebTarget target = getBaseWebTarget();
    target = target.path("data-transfer");
    target = target.path("output-ports");
    target = target.path(portId);
    target = target.path("transactions");
    target = target.path(transactionId);
    target = target.path("flow-files");
    final Invocation.Builder invocationBuilder = target.request("application/octet-stream");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, StreamingOutput.class);
    }
    finally {
      response.close();
    }
  }
}
