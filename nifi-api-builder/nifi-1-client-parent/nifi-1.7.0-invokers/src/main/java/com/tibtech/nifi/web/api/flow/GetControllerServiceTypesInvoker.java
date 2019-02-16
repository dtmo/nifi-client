package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServiceTypesEntity;

/**
 * Retrieves the types of controller services that this NiFi supports
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetControllerServiceTypesInvoker extends AbstractInvoker<ControllerServiceTypesEntity> {
  private String serviceType;

  private String serviceBundleGroup;

  private String serviceBundleArtifact;

  private String serviceBundleVersion;

  private String bundleGroupFilter;

  private String bundleArtifactFilter;

  private String typeFilter;

  public GetControllerServiceTypesInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * If specified, will only return controller services that are compatible with this type of service. */
  public final String getServiceType() {
    return serviceType;
  }

  /**
   * If specified, will only return controller services that are compatible with this type of service. */
  public final GetControllerServiceTypesInvoker setServiceType(final String serviceType) {
    this.serviceType = serviceType;
    return this;
  }

  /**
   * If serviceType specified, is the bundle group of the serviceType. */
  public final String getServiceBundleGroup() {
    return serviceBundleGroup;
  }

  /**
   * If serviceType specified, is the bundle group of the serviceType. */
  public final GetControllerServiceTypesInvoker setServiceBundleGroup(
      final String serviceBundleGroup) {
    this.serviceBundleGroup = serviceBundleGroup;
    return this;
  }

  /**
   * If serviceType specified, is the bundle artifact of the serviceType. */
  public final String getServiceBundleArtifact() {
    return serviceBundleArtifact;
  }

  /**
   * If serviceType specified, is the bundle artifact of the serviceType. */
  public final GetControllerServiceTypesInvoker setServiceBundleArtifact(
      final String serviceBundleArtifact) {
    this.serviceBundleArtifact = serviceBundleArtifact;
    return this;
  }

  /**
   * If serviceType specified, is the bundle version of the serviceType. */
  public final String getServiceBundleVersion() {
    return serviceBundleVersion;
  }

  /**
   * If serviceType specified, is the bundle version of the serviceType. */
  public final GetControllerServiceTypesInvoker setServiceBundleVersion(
      final String serviceBundleVersion) {
    this.serviceBundleVersion = serviceBundleVersion;
    return this;
  }

  /**
   * If specified, will only return types that are a member of this bundle group. */
  public final String getBundleGroupFilter() {
    return bundleGroupFilter;
  }

  /**
   * If specified, will only return types that are a member of this bundle group. */
  public final GetControllerServiceTypesInvoker setBundleGroupFilter(
      final String bundleGroupFilter) {
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
  public final GetControllerServiceTypesInvoker setBundleArtifactFilter(
      final String bundleArtifactFilter) {
    this.bundleArtifactFilter = bundleArtifactFilter;
    return this;
  }

  /**
   * If specified, will only return types whose fully qualified classname matches. */
  public final String getTypeFilter() {
    return typeFilter;
  }

  /**
   * If specified, will only return types whose fully qualified classname matches. */
  public final GetControllerServiceTypesInvoker setTypeFilter(final String typeFilter) {
    this.typeFilter = typeFilter;
    return this;
  }

  public final ControllerServiceTypesEntity invoke() throws InvokerException {
    // nifi-api/flow/controller-service-types
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("controller-service-types");
    target = target.queryParam("serviceType", serviceType);
    target = target.queryParam("serviceBundleGroup", serviceBundleGroup);
    target = target.queryParam("serviceBundleArtifact", serviceBundleArtifact);
    target = target.queryParam("serviceBundleVersion", serviceBundleVersion);
    target = target.queryParam("bundleGroupFilter", bundleGroupFilter);
    target = target.queryParam("bundleArtifactFilter", bundleArtifactFilter);
    target = target.queryParam("typeFilter", typeFilter);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerServiceTypesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
