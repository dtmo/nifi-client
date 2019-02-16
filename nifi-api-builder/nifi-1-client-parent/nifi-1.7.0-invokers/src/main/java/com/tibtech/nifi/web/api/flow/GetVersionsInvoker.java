package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionedFlowSnapshotMetadataSetEntity;

/**
 * Gets the flow versions from the specified registry and bucket for the specified flow for the current user
 */
public final class GetVersionsInvoker extends AbstractInvoker<VersionedFlowSnapshotMetadataSetEntity> {
  private String registryId;

  private String bucketId;

  private String flowId;

  public GetVersionsInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The registry id. */
  public final String getRegistryId() {
    return registryId;
  }

  /**
   * The registry id. */
  public final GetVersionsInvoker setRegistryId(final String registryId) {
    this.registryId = registryId;
    return this;
  }

  /**
   * The bucket id. */
  public final String getBucketId() {
    return bucketId;
  }

  /**
   * The bucket id. */
  public final GetVersionsInvoker setBucketId(final String bucketId) {
    this.bucketId = bucketId;
    return this;
  }

  /**
   * The flow id. */
  public final String getFlowId() {
    return flowId;
  }

  /**
   * The flow id. */
  public final GetVersionsInvoker setFlowId(final String flowId) {
    this.flowId = flowId;
    return this;
  }

  public final VersionedFlowSnapshotMetadataSetEntity invoke() throws InvokerException {
    // nifi-api/flow/registries/{registry-id}/buckets/{bucket-id}/flows/{flow-id}/versions
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("registries");
    target = target.path(registryId);
    target = target.path("buckets");
    target = target.path(bucketId);
    target = target.path("flows");
    target = target.path(flowId);
    target = target.path("versions");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, VersionedFlowSnapshotMetadataSetEntity.class);
    }
    finally {
      response.close();
    }
  }
}
