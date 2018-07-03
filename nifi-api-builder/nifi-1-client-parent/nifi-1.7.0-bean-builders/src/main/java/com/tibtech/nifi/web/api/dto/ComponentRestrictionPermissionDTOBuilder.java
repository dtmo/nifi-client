package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.ComponentRestrictionPermissionDTO;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.RequiredPermissionDTO;

public final class ComponentRestrictionPermissionDTOBuilder {
  private PermissionsDTO permissions;

  private RequiredPermissionDTO requiredPermission;

  /**
   * The permissions for this component restriction. Note: the read permission are not used and will always be false.
   */
  public PermissionsDTO getPermissions() {
    return permissions;
  }

  /**
   * The permissions for this component restriction. Note: the read permission are not used and will always be false.
   */
  public ComponentRestrictionPermissionDTOBuilder setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return this;
  }

  /**
   * The permissions for this component restriction. Note: the read permission are not used and will always be false.
   */
  public ComponentRestrictionPermissionDTOBuilder setPermissions(final Consumer<PermissionsDTOBuilder> configurator) {
    final PermissionsDTOBuilder builder = (permissions != null ? PermissionsDTOBuilder.of(permissions) : new PermissionsDTOBuilder());
    configurator.accept(builder);
    return setPermissions(builder.build());
  }

  /**
   * The permissions for this component restriction. Note: the read permission are not used and will always be false.
   */
  public ComponentRestrictionPermissionDTOBuilder setPermissions(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PermissionsDTOBuilder.class) final Closure<PermissionsDTOBuilder> closure) {
    return setPermissions(c -> {
      final Closure<PermissionsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The required permission necessary for this restriction.
   */
  public RequiredPermissionDTO getRequiredPermission() {
    return requiredPermission;
  }

  /**
   * The required permission necessary for this restriction.
   */
  public ComponentRestrictionPermissionDTOBuilder setRequiredPermission(final RequiredPermissionDTO requiredPermission) {
    this.requiredPermission = requiredPermission;
    return this;
  }

  /**
   * The required permission necessary for this restriction.
   */
  public ComponentRestrictionPermissionDTOBuilder setRequiredPermission(final Consumer<RequiredPermissionDTOBuilder> configurator) {
    final RequiredPermissionDTOBuilder builder = (requiredPermission != null ? RequiredPermissionDTOBuilder.of(requiredPermission) : new RequiredPermissionDTOBuilder());
    configurator.accept(builder);
    return setRequiredPermission(builder.build());
  }

  /**
   * The required permission necessary for this restriction.
   */
  public ComponentRestrictionPermissionDTOBuilder setRequiredPermission(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RequiredPermissionDTOBuilder.class) final Closure<RequiredPermissionDTOBuilder> closure) {
    return setRequiredPermission(c -> {
      final Closure<RequiredPermissionDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public ComponentRestrictionPermissionDTO build() {
    final ComponentRestrictionPermissionDTO componentRestrictionPermissionDTO = new ComponentRestrictionPermissionDTO();
    componentRestrictionPermissionDTO.setPermissions(permissions);
    componentRestrictionPermissionDTO.setRequiredPermission(requiredPermission);
    return componentRestrictionPermissionDTO;
  }

  public static ComponentRestrictionPermissionDTOBuilder of(final ComponentRestrictionPermissionDTO componentRestrictionPermissionDTO) {
    final ComponentRestrictionPermissionDTOBuilder componentRestrictionPermissionDTOBuilder = new ComponentRestrictionPermissionDTOBuilder();
    componentRestrictionPermissionDTOBuilder.setPermissions(componentRestrictionPermissionDTO.getPermissions());
    componentRestrictionPermissionDTOBuilder.setRequiredPermission(componentRestrictionPermissionDTO.getRequiredPermission());
    return componentRestrictionPermissionDTOBuilder;
  }
}
