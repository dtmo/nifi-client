package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceEntity;

/**
 * Submits a provenance query
 * <p>Provenance queries may be long running so this endpoint submits a request. The response will include the current state of the query. If the request is not completed the URI in the response can be used at a later time to get the updated state of the query. Once the query has completed the provenance request should be deleted by the client who originally submitted it.</p>
 */
public final class SubmitProvenanceRequestInvoker extends AbstractInvoker<ProvenanceEntity> {
  private ProvenanceEntity provenanceEntity;

  public SubmitProvenanceRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The provenance query details. */
  public final ProvenanceEntity getProvenanceEntity() {
    return provenanceEntity;
  }

  /**
   * The provenance query details. */
  public final SubmitProvenanceRequestInvoker setProvenanceEntity(
      final ProvenanceEntity provenanceEntity) {
    this.provenanceEntity = provenanceEntity;
    return this;
  }

  public final ProvenanceEntity invoke() throws InvokerException {
    // nifi-api/provenance
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("provenance");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<ProvenanceEntity> entity = Entity.entity(provenanceEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, ProvenanceEntity.class);
    }
    finally {
      response.close();
    }
  }
}
