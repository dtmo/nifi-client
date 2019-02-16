package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.util.Date;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.HistoryEntity;

/**
 * Purges history
 */
public final class DeleteHistoryInvoker extends AbstractInvoker<HistoryEntity> {
  private Date endDate;

  public DeleteHistoryInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * Purge actions before this date/time. */
  public final Date getEndDate() {
    return endDate;
  }

  /**
   * Purge actions before this date/time. */
  public final DeleteHistoryInvoker setEndDate(final Date endDate) {
    this.endDate = endDate;
    return this;
  }

  public final HistoryEntity invoke() throws InvokerException {
    // nifi-api/controller/history
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("history");
    target = target.queryParam("endDate", endDate);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, HistoryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
