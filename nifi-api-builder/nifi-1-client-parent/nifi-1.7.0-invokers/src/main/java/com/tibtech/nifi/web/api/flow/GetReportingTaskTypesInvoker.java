package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskTypesEntity;

/**
 * Retrieves the types of reporting tasks that this NiFi supports
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetReportingTaskTypesInvoker extends AbstractInvoker<ReportingTaskTypesEntity> {
  private String bundleGroupFilter;

  private String bundleArtifactFilter;

  private String type;

  public GetReportingTaskTypesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * If specified, will only return types that are a member of this bundle group. */
  public final String getBundleGroupFilter() {
    return bundleGroupFilter;
  }

  /**
   * If specified, will only return types that are a member of this bundle group. */
  public final GetReportingTaskTypesInvoker setBundleGroupFilter(final String bundleGroupFilter) {
    this.bundleGroupFilter = bundleGroupFilter;
    return this;
  }

  /**
   * If specified, will only return types that are a member of this bundle artifact. */
  public final String getBundleArtifactFilter() {
    return bundleArtifactFilter;
  }

  /**
   * If specified, will only return types that are a member of this bundle artifact. */
  public final GetReportingTaskTypesInvoker setBundleArtifactFilter(
      final String bundleArtifactFilter) {
    this.bundleArtifactFilter = bundleArtifactFilter;
    return this;
  }

  /**
   * If specified, will only return types whose fully qualified classname matches. */
  public final String getType() {
    return type;
  }

  /**
   * If specified, will only return types whose fully qualified classname matches. */
  public final GetReportingTaskTypesInvoker setType(final String type) {
    this.type = type;
    return this;
  }

  public final ReportingTaskTypesEntity invoke() throws InvokerException {
    // nifi-api/flow/reporting-task-types
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("reporting-task-types");
    target = target.queryParam("bundleGroupFilter", bundleGroupFilter);
    target = target.queryParam("bundleArtifactFilter", bundleArtifactFilter);
    target = target.queryParam("type", type);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ReportingTaskTypesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
