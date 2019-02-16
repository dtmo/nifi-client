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
import org.apache.nifi.web.api.entity.TransactionResultEntity;

/**
 * Extend transaction TTL
 */
public final class ExtendInputPortTransactionTtlInvoker extends AbstractInvoker<TransactionResultEntity> {
  private String portId;

  private String transactionId;

  private InputStream inputStream;

  public ExtendInputPortTransactionTtlInvoker(final Transport transport) {
    super(transport);
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

  public final InputStream getInputStream() {
    return inputStream;
  }

  public final ExtendInputPortTransactionTtlInvoker setInputStream(final InputStream inputStream) {
    this.inputStream = inputStream;
    return this;
  }

  public final TransactionResultEntity invoke() throws InvokerException {
    // nifi-api/data-transfer/input-ports/{portId}/transactions/{transactionId}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("data-transfer");
    target = target.path("input-ports");
    target = target.path(portId);
    target = target.path("transactions");
    target = target.path(transactionId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<InputStream> entity = Entity.entity(inputStream, "*/*");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, TransactionResultEntity.class);
    }
    finally {
      response.close();
    }
  }
}
