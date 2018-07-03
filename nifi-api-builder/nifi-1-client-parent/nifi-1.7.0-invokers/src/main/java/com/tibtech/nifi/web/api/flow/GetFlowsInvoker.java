package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionedFlowsEntity;

/**
 * Gets the flows from the specified registry and bucket for the current user
 */
public final class GetFlowsInvoker extends AbstractInvoker<VersionedFlowsEntity> {
  private String registryId;

  private String bucketId;

  public GetFlowsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The registry id. */
  public final String getRegistryId() {
    return registryId;
  }

  /**
   * The registry id. */
  public final GetFlowsInvoker setRegistryId(final String registryId) {
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
  public final GetFlowsInvoker setBucketId(final String bucketId) {
    this.bucketId = bucketId;
    return this;
  }

  public final VersionedFlowsEntity invoke() throws InvokerException {
    // nifi-api/flow/registries/{registry-id}/buckets/{bucket-id}/flows
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("registries");
    target = target.path(registryId);
    target = target.path("buckets");
    target = target.path(bucketId);
    target = target.path("flows");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, VersionedFlowsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
