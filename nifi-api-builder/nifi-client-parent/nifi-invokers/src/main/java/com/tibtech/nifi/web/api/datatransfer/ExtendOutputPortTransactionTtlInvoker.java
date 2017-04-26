package com.tibtech.nifi.web.api.datatransfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TransactionResultEntity;

/**
 * Extend transaction TTL
 */
public final class ExtendOutputPortTransactionTtlInvoker extends AbstractInvoker<TransactionResultEntity> {
  private String portId;

  private String transactionId;

  public ExtendOutputPortTransactionTtlInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getPortId() {
    return portId;
  }

  public final ExtendOutputPortTransactionTtlInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  public final String getTransactionId() {
    return transactionId;
  }

  public final ExtendOutputPortTransactionTtlInvoker setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  public final TransactionResultEntity invoke() throws InvokerException {
    // /data-transfer/output-ports/{portId}/transactions/{transactionId}
    WebTarget target = getBaseWebTarget();
    target = target.path("data-transfer");
    target = target.path("output-ports");
    target = target.path(portId);
    target = target.path("transactions");
    target = target.path(transactionId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("PUT");
    try {
      return handleResponse(response, TransactionResultEntity.class);
    }
    finally {
      response.close();
    }
  }
}
