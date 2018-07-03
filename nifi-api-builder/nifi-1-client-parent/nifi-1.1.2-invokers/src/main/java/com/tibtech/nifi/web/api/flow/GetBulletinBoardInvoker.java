package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.BulletinBoardEntity;

/**
 * Gets current bulletins
 */
public final class GetBulletinBoardInvoker extends AbstractInvoker<BulletinBoardEntity> {
  private Long after;

  private String sourceName;

  private String message;

  private String sourceId;

  private String groupId;

  private Integer limit;

  public GetBulletinBoardInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * Includes bulletins with an id after this value. */
  public final Long getAfter() {
    return after;
  }

  /**
   * Includes bulletins with an id after this value. */
  public final GetBulletinBoardInvoker setAfter(final Long after) {
    this.after = after;
    return this;
  }

  /**
   * Includes bulletins originating from this sources whose name match this regular expression. */
  public final String getSourceName() {
    return sourceName;
  }

  /**
   * Includes bulletins originating from this sources whose name match this regular expression. */
  public final GetBulletinBoardInvoker setSourceName(final String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  /**
   * Includes bulletins whose message that match this regular expression. */
  public final String getMessage() {
    return message;
  }

  /**
   * Includes bulletins whose message that match this regular expression. */
  public final GetBulletinBoardInvoker setMessage(final String message) {
    this.message = message;
    return this;
  }

  /**
   * Includes bulletins originating from this sources whose id match this regular expression. */
  public final String getSourceId() {
    return sourceId;
  }

  /**
   * Includes bulletins originating from this sources whose id match this regular expression. */
  public final GetBulletinBoardInvoker setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * Includes bulletins originating from this sources whose group id match this regular expression. */
  public final String getGroupId() {
    return groupId;
  }

  /**
   * Includes bulletins originating from this sources whose group id match this regular expression. */
  public final GetBulletinBoardInvoker setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The number of bulletins to limit the response to. */
  public final Integer getLimit() {
    return limit;
  }

  /**
   * The number of bulletins to limit the response to. */
  public final GetBulletinBoardInvoker setLimit(final Integer limit) {
    this.limit = limit;
    return this;
  }

  public final BulletinBoardEntity invoke() throws InvokerException {
    // nifi-api/flow/bulletin-board
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("bulletin-board");
    target = target.queryParam("after", after);
    target = target.queryParam("sourceName", sourceName);
    target = target.queryParam("message", message);
    target = target.queryParam("sourceId", sourceId);
    target = target.queryParam("groupId", groupId);
    target = target.queryParam("limit", limit);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, BulletinBoardEntity.class);
    }
    finally {
      response.close();
    }
  }
}
