package com.tibtech.nifi.web.api.datatransfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Integer;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TransactionResultEntity;

/**
 * Commit or cancel the specified transaction
 */
public final class CommitInputPortTransactionInvoker extends AbstractInvoker<TransactionResultEntity> {
  private String portId;

  private String transactionId;

  private Integer responseCode;

  public CommitInputPortTransactionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The input port id. */
  public final String getPortId() {
    return portId;
  }

  /**
   * The input port id. */
  public final CommitInputPortTransactionInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  /**
   * The transaction id. */
  public final String getTransactionId() {
    return transactionId;
  }

  /**
   * The transaction id. */
  public final CommitInputPortTransactionInvoker setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * The response code. Available values are BAD_CHECKSUM(19), CONFIRM_TRANSACTION(12) or CANCEL_TRANSACTION(15). */
  public final Integer getResponseCode() {
    return responseCode;
  }

  /**
   * The response code. Available values are BAD_CHECKSUM(19), CONFIRM_TRANSACTION(12) or CANCEL_TRANSACTION(15). */
  public final CommitInputPortTransactionInvoker setResponseCode(final Integer responseCode) {
    this.responseCode = responseCode;
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
    target = target.queryParam("responseCode", responseCode);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, TransactionResultEntity.class);
    }
    finally {
      response.close();
    }
  }
}
