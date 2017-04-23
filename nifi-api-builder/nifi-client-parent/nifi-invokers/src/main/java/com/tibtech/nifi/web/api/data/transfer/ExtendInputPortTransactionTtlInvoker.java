package com.tibtech.nifi.web.api.data.transfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TransactionResultEntity;

public final class ExtendInputPortTransactionTtlInvoker extends AbstractInvoker<TransactionResultEntity> {
  private String portId;

  private String transactionId;

  public ExtendInputPortTransactionTtlInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getPortId() {
    return portId;
  }

  public final ExtendInputPortTransactionTtlInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  public final String getTransactionId() {
    return transactionId;
  }

  public final ExtendInputPortTransactionTtlInvoker setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  public final TransactionResultEntity invoke() throws InvokerException {
    // /data-transfer/input-ports/{portId}/transactions/{transactionId}
    WebTarget target = getBaseWebTarget();
    target = target.path("data-transfer");
    target = target.path("input-ports");
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
