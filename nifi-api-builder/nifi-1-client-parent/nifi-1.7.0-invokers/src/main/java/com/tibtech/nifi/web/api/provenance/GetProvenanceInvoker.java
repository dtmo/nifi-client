package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceEntity;

/**
 * Gets a provenance query
 */
public final class GetProvenanceInvoker extends AbstractInvoker<ProvenanceEntity> {
  private String id;

  private String clusterNodeId;

  private Boolean summarize;

  private Boolean incrementalResults;

  public GetProvenanceInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The id of the provenance query. */
  public final String getId() {
    return id;
  }

  /**
   * The id of the provenance query. */
  public final GetProvenanceInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the node where this query exists if clustered. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where this query exists if clustered. */
  public final GetProvenanceInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * Whether or not incremental results are returned. If false, provenance events are only returned once the query completes. This property is true by default. */
  public final Boolean getSummarize() {
    return summarize;
  }

  /**
   * Whether or not incremental results are returned. If false, provenance events are only returned once the query completes. This property is true by default. */
  public final GetProvenanceInvoker setSummarize(final Boolean summarize) {
    this.summarize = summarize;
    return this;
  }

  /**
   * Whether or not to summarize provenance events returned. This property is false by default. */
  public final Boolean getIncrementalResults() {
    return incrementalResults;
  }

  /**
   * Whether or not to summarize provenance events returned. This property is false by default. */
  public final GetProvenanceInvoker setIncrementalResults(final Boolean incrementalResults) {
    this.incrementalResults = incrementalResults;
    return this;
  }

  public final ProvenanceEntity invoke() throws InvokerException {
    // nifi-api/provenance/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("provenance");
    target = target.path(id);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    target = target.queryParam("summarize", summarize);
    target = target.queryParam("incrementalResults", incrementalResults);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProvenanceEntity.class);
    }
    finally {
      response.close();
    }
  }
}
