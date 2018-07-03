package com.tibtech.nifi.web.api.reportingtask;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PropertyDescriptorEntity;

/**
 * Gets a reporting task property descriptor
 */
public final class GetPropertyDescriptorInvoker extends AbstractInvoker<PropertyDescriptorEntity> {
  private String id;

  private String propertyName;

  public GetPropertyDescriptorInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The reporting task id. */
  public final String getId() {
    return id;
  }

  /**
   * The reporting task id. */
  public final GetPropertyDescriptorInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The property name. */
  public final String getPropertyName() {
    return propertyName;
  }

  /**
   * The property name. */
  public final GetPropertyDescriptorInvoker setPropertyName(final String propertyName) {
    this.propertyName = propertyName;
    return this;
  }

  public final PropertyDescriptorEntity invoke() throws InvokerException {
    // nifi-api/reporting-tasks/{id}/descriptors
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("reporting-tasks");
    target = target.path(id);
    target = target.path("descriptors");
    target = target.queryParam("propertyName", propertyName);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, PropertyDescriptorEntity.class);
    }
    finally {
      response.close();
    }
  }
}
