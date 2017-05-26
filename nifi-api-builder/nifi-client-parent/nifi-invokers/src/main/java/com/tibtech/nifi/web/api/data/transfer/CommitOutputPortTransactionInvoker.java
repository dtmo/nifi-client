package com.tibtech.nifi.web.api.data.transfer;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Integer;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TransactionResultEntity;

public final class CommitOutputPortTransactionInvoker extends AbstractInvoker<TransactionResultEntity> {
  private String portId;

  private String transactionId;

  private Integer responseCode;

  private String checksum;

  public CommitOutputPortTransactionInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The output port id. */
  public final String getPortId() {
    return portId;
  }

  /**
   * The output port id. */
  public final CommitOutputPortTransactionInvoker setPortId(final String portId) {
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
  public final CommitOutputPortTransactionInvoker setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * The response code. Available values are CONFIRM_TRANSACTION(12) or CANCEL_TRANSACTION(15). */
  public final Integer getResponseCode() {
    return responseCode;
  }

  /**
   * The response code. Available values are CONFIRM_TRANSACTION(12) or CANCEL_TRANSACTION(15). */
  public final CommitOutputPortTransactionInvoker setResponseCode(final Integer responseCode) {
    this.responseCode = responseCode;
    return this;
  }

  /**
   * A checksum calculated at client side using CRC32 to check flow file content integrity. It must match with the value calculated at server side. */
  public final String getChecksum() {
    return checksum;
  }

  /**
   * A checksum calculated at client side using CRC32 to check flow file content integrity. It must match with the value calculated at server side. */
  public final CommitOutputPortTransactionInvoker setChecksum(final String checksum) {
    this.checksum = checksum;
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
    target = target.queryParam("responseCode", responseCode);
    target = target.queryParam("checksum", checksum);
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
