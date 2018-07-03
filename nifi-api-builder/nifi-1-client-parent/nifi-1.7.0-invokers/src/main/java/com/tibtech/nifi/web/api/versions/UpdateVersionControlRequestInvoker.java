package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionControlComponentMappingEntity;
import org.apache.nifi.web.api.entity.VersionControlInformationEntity;

/**
 * Updates the request with the given ID
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class UpdateVersionControlRequestInvoker extends AbstractInvoker<VersionControlInformationEntity> {
  private String id;

  private VersionControlComponentMappingEntity versionControlComponentMappingEntity;

  public UpdateVersionControlRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The request ID. */
  public final String getId() {
    return id;
  }

  /**
   * The request ID. */
  public final UpdateVersionControlRequestInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The version control component mapping. */
  public final VersionControlComponentMappingEntity getVersionControlComponentMappingEntity() {
    return versionControlComponentMappingEntity;
  }

  /**
   * The version control component mapping. */
  public final UpdateVersionControlRequestInvoker setVersionControlComponentMappingEntity(
      final VersionControlComponentMappingEntity versionControlComponentMappingEntity) {
    this.versionControlComponentMappingEntity = versionControlComponentMappingEntity;
    return this;
  }

  public final VersionControlInformationEntity invoke() throws InvokerException {
    // nifi-api/versions/active-requests/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("active-requests");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<VersionControlComponentMappingEntity> entity = Entity.entity(versionControlComponentMappingEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, VersionControlInformationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
