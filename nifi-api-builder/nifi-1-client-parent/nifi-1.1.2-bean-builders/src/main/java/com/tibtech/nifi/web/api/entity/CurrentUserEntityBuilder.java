package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.entity.CurrentUserEntity;

public final class CurrentUserEntityBuilder extends AbstractEntityBuilder<CurrentUserEntityBuilder> {
  private boolean anonymous;

  private PermissionsDTO controllerPermissions;

  private PermissionsDTO countersPermissions;

  private String identity;

  private PermissionsDTO policiesPermissions;

  private PermissionsDTO provenancePermissions;

  private PermissionsDTO restrictedComponentsPermissions;

  private PermissionsDTO systemPermissions;

  private PermissionsDTO tenantsPermissions;

  /**
   * Whether the current user is anonymous.
   */
  public boolean getAnonymous() {
    return anonymous;
  }

  /**
   * Whether the current user is anonymous.
   */
  public CurrentUserEntityBuilder setAnonymous(final boolean anonymous) {
    this.anonymous = anonymous;
    return this;
  }

  /**
   * Permissions for accessing the controller.
   */
  public PermissionsDTO getControllerPermissions() {
    return controllerPermissions;
  }

  /**
   * Permissions for accessing the controller.
   */
  public CurrentUserEntityBuilder setControllerPermissions(final PermissionsDTO controllerPermissions) {
    this.controllerPermissions = controllerPermissions;
    return this;
  }

  /**
   * Permissions for accessing counters.
   */
  public PermissionsDTO getCountersPermissions() {
    return countersPermissions;
  }

  /**
   * Permissions for accessing counters.
   */
  public CurrentUserEntityBuilder setCountersPermissions(final PermissionsDTO countersPermissions) {
    this.countersPermissions = countersPermissions;
    return this;
  }

  /**
   * The user identity being serialized.
   */
  public String getIdentity() {
    return identity;
  }

  /**
   * The user identity being serialized.
   */
  public CurrentUserEntityBuilder setIdentity(final String identity) {
    this.identity = identity;
    return this;
  }

  /**
   * Permissions for accessing the policies.
   */
  public PermissionsDTO getPoliciesPermissions() {
    return policiesPermissions;
  }

  /**
   * Permissions for accessing the policies.
   */
  public CurrentUserEntityBuilder setPoliciesPermissions(final PermissionsDTO policiesPermissions) {
    this.policiesPermissions = policiesPermissions;
    return this;
  }

  /**
   * Permissions for querying provenance.
   */
  public PermissionsDTO getProvenancePermissions() {
    return provenancePermissions;
  }

  /**
   * Permissions for querying provenance.
   */
  public CurrentUserEntityBuilder setProvenancePermissions(final PermissionsDTO provenancePermissions) {
    this.provenancePermissions = provenancePermissions;
    return this;
  }

  /**
   * Permissions for accessing restricted components. Note: the read permission are not used and will always be false.
   */
  public PermissionsDTO getRestrictedComponentsPermissions() {
    return restrictedComponentsPermissions;
  }

  /**
   * Permissions for accessing restricted components. Note: the read permission are not used and will always be false.
   */
  public CurrentUserEntityBuilder setRestrictedComponentsPermissions(final PermissionsDTO restrictedComponentsPermissions) {
    this.restrictedComponentsPermissions = restrictedComponentsPermissions;
    return this;
  }

  /**
   * Permissions for accessing system.
   */
  public PermissionsDTO getSystemPermissions() {
    return systemPermissions;
  }

  /**
   * Permissions for accessing system.
   */
  public CurrentUserEntityBuilder setSystemPermissions(final PermissionsDTO systemPermissions) {
    this.systemPermissions = systemPermissions;
    return this;
  }

  /**
   * Permissions for accessing tenants.
   */
  public PermissionsDTO getTenantsPermissions() {
    return tenantsPermissions;
  }

  /**
   * Permissions for accessing tenants.
   */
  public CurrentUserEntityBuilder setTenantsPermissions(final PermissionsDTO tenantsPermissions) {
    this.tenantsPermissions = tenantsPermissions;
    return this;
  }

  public CurrentUserEntity build() {
    final CurrentUserEntity currentUserEntity = new CurrentUserEntity();
    super.setPropertyValues(currentUserEntity);
    currentUserEntity.setAnonymous(anonymous);
    currentUserEntity.setControllerPermissions(controllerPermissions);
    currentUserEntity.setCountersPermissions(countersPermissions);
    currentUserEntity.setIdentity(identity);
    currentUserEntity.setPoliciesPermissions(policiesPermissions);
    currentUserEntity.setProvenancePermissions(provenancePermissions);
    currentUserEntity.setRestrictedComponentsPermissions(restrictedComponentsPermissions);
    currentUserEntity.setSystemPermissions(systemPermissions);
    currentUserEntity.setTenantsPermissions(tenantsPermissions);
    return currentUserEntity;
  }

  public static CurrentUserEntityBuilder of(final CurrentUserEntity currentUserEntity) {
    final CurrentUserEntityBuilder currentUserEntityBuilder = new CurrentUserEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(currentUserEntityBuilder, currentUserEntity);
    currentUserEntityBuilder.setAnonymous(currentUserEntity.isAnonymous());
    currentUserEntityBuilder.setControllerPermissions(currentUserEntity.getControllerPermissions());
    currentUserEntityBuilder.setCountersPermissions(currentUserEntity.getCountersPermissions());
    currentUserEntityBuilder.setIdentity(currentUserEntity.getIdentity());
    currentUserEntityBuilder.setPoliciesPermissions(currentUserEntity.getPoliciesPermissions());
    currentUserEntityBuilder.setProvenancePermissions(currentUserEntity.getProvenancePermissions());
    currentUserEntityBuilder.setRestrictedComponentsPermissions(currentUserEntity.getRestrictedComponentsPermissions());
    currentUserEntityBuilder.setSystemPermissions(currentUserEntity.getSystemPermissions());
    currentUserEntityBuilder.setTenantsPermissions(currentUserEntity.getTenantsPermissions());
    return currentUserEntityBuilder;
  }
}
