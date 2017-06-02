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
 * Create a transaction to the specified output port or input port
 */
public final class CreatePortTransactionInvoker extends AbstractInvoker<TransactionResultEntity> {
  private String portType;

  private String portId;

  private InputStream inputStream;

  public CreatePortTransactionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The port type. */
  public final String getPortType() {
    return portType;
  }

  /**
   * The port type. */
  public final CreatePortTransactionInvoker setPortType(final String portType) {
    this.portType = portType;
    return this;
  }

  public final String getPortId() {
    return portId;
  }

  public final CreatePortTransactionInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  public final InputStream getInputStream() {
    return inputStream;
  }

  public final CreatePortTransactionInvoker setInputStream(final InputStream inputStream) {
    this.inputStream = inputStream;
    return this;
  }

  public final TransactionResultEntity invoke() throws InvokerException {
    // nifi-api/data-transfer/{portType}/{portId}/transactions
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("data-transfer");
    target = target.path(portType);
    target = target.path(portId);
    target = target.path("transactions");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<InputStream> entity = Entity.entity(inputStream, "text/plain");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, TransactionResultEntity.class);
    }
    finally {
      response.close();
    }
  }
}
