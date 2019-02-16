package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.HistoryEntity;

/**
 * Gets configuration history
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class QueryHistoryInvoker extends AbstractInvoker<HistoryEntity> {
  private Integer offset;

  private Integer count;

  private String sortColumn;

  private String sortOrder;

  private Date startDate;

  private Date endDate;

  private String userIdentity;

  private String sourceId;

  public QueryHistoryInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The offset into the result set. */
  public final Integer getOffset() {
    return offset;
  }

  /**
   * The offset into the result set. */
  public final QueryHistoryInvoker setOffset(final Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * The number of actions to return. */
  public final Integer getCount() {
    return count;
  }

  /**
   * The number of actions to return. */
  public final QueryHistoryInvoker setCount(final Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The field to sort on. */
  public final String getSortColumn() {
    return sortColumn;
  }

  /**
   * The field to sort on. */
  public final QueryHistoryInvoker setSortColumn(final String sortColumn) {
    this.sortColumn = sortColumn;
    return this;
  }

  /**
   * The direction to sort. */
  public final String getSortOrder() {
    return sortOrder;
  }

  /**
   * The direction to sort. */
  public final QueryHistoryInvoker setSortOrder(final String sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Include actions after this date. */
  public final Date getStartDate() {
    return startDate;
  }

  /**
   * Include actions after this date. */
  public final QueryHistoryInvoker setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Include actions before this date. */
  public final Date getEndDate() {
    return endDate;
  }

  /**
   * Include actions before this date. */
  public final QueryHistoryInvoker setEndDate(final Date endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Include actions performed by this user. */
  public final String getUserIdentity() {
    return userIdentity;
  }

  /**
   * Include actions performed by this user. */
  public final QueryHistoryInvoker setUserIdentity(final String userIdentity) {
    this.userIdentity = userIdentity;
    return this;
  }

  /**
   * Include actions on this component. */
  public final String getSourceId() {
    return sourceId;
  }

  /**
   * Include actions on this component. */
  public final QueryHistoryInvoker setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  public final HistoryEntity invoke() throws InvokerException {
    // nifi-api/flow/history
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("history");
    target = target.queryParam("offset", offset);
    target = target.queryParam("count", count);
    target = target.queryParam("sortColumn", sortColumn);
    target = target.queryParam("sortOrder", sortOrder);
    target = target.queryParam("startDate", startDate);
    target = target.queryParam("endDate", endDate);
    target = target.queryParam("userIdentity", userIdentity);
    target = target.queryParam("sourceId", sourceId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, HistoryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
