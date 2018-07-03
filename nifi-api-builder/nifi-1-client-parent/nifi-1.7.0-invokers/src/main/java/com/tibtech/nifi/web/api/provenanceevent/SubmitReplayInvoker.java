package com.tibtech.nifi.web.api.provenanceevent;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceEventEntity;
import org.apache.nifi.web.api.entity.SubmitReplayRequestEntity;

/**
 * Replays content from a provenance event
 */
public final class SubmitReplayInvoker extends AbstractInvoker<ProvenanceEventEntity> {
  private SubmitReplayRequestEntity submitReplayRequestEntity;

  public SubmitReplayInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The replay request. */
  public final SubmitReplayRequestEntity getSubmitReplayRequestEntity() {
    return submitReplayRequestEntity;
  }

  /**
   * The replay request. */
  public final SubmitReplayInvoker setSubmitReplayRequestEntity(
      final SubmitReplayRequestEntity submitReplayRequestEntity) {
    this.submitReplayRequestEntity = submitReplayRequestEntity;
    return this;
  }

  public final ProvenanceEventEntity invoke() throws InvokerException {
    // nifi-api/provenance-events/replays
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("provenance-events");
    target = target.path("replays");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<SubmitReplayRequestEntity> entity = Entity.entity(submitReplayRequestEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, ProvenanceEventEntity.class);
    }
    finally {
      response.close();
    }
  }
}
