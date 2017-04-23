package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceEntity;

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
  public final SubmitProvenanceRequestInvoker setProvenanceEntity(final ProvenanceEntity provenanceEntity) {
    this.provenanceEntity = provenanceEntity;
    return this;
  }

  public final ProvenanceEntity invoke() throws InvokerException {
    // /provenance
    WebTarget target = getBaseWebTarget();
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
