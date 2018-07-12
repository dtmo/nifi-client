package com.tibtech.nifi.web.api.entity;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.flow.FlowBreadcrumbDTO;
import org.apache.nifi.web.api.entity.FlowBreadcrumbEntity;

public final class FlowBreadcrumbEntityBuilder extends AbstractEntityBuilder<FlowBreadcrumbEntityBuilder> {
  private FlowBreadcrumbDTO breadcrumb;

  private String id;

  private FlowBreadcrumbEntity parentBreadcrumb;

  private PermissionsDTO permissions;

  private String versionedFlowState;

  /**
   * This breadcrumb.
   */
  public FlowBreadcrumbDTO getBreadcrumb() {
    return breadcrumb;
  }

  /**
   * This breadcrumb.
   */
  public FlowBreadcrumbEntityBuilder setBreadcrumb(final FlowBreadcrumbDTO breadcrumb) {
    this.breadcrumb = breadcrumb;
    return this;
  }

  /**
   * The id of this ancestor ProcessGroup.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of this ancestor ProcessGroup.
   */
  public FlowBreadcrumbEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The parent breadcrumb for this breadcrumb.
   */
  public FlowBreadcrumbEntity getParentBreadcrumb() {
    return parentBreadcrumb;
  }

  /**
   * The parent breadcrumb for this breadcrumb.
   */
  public FlowBreadcrumbEntityBuilder setParentBreadcrumb(
      final FlowBreadcrumbEntity parentBreadcrumb) {
    this.parentBreadcrumb = parentBreadcrumb;
    return this;
  }

  /**
   * The parent breadcrumb for this breadcrumb.
   */
  public FlowBreadcrumbEntityBuilder setParentBreadcrumb(
      final Consumer<FlowBreadcrumbEntityBuilder> configurator) {
    final FlowBreadcrumbEntityBuilder builder = (parentBreadcrumb != null ? FlowBreadcrumbEntityBuilder.of(parentBreadcrumb) : new FlowBreadcrumbEntityBuilder());
    configurator.accept(builder);
    return setParentBreadcrumb(builder.build());
  }

  /**
   * The parent breadcrumb for this breadcrumb.
   */
  public FlowBreadcrumbEntityBuilder setParentBreadcrumb(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FlowBreadcrumbEntityBuilder.class) final Closure<FlowBreadcrumbEntityBuilder> closure) {
    return setParentBreadcrumb(c -> {
      final Closure<FlowBreadcrumbEntityBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The permissions for this ancestor ProcessGroup.
   */
  public PermissionsDTO getPermissions() {
    return permissions;
  }

  /**
   * The permissions for this ancestor ProcessGroup.
   */
  public FlowBreadcrumbEntityBuilder setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return this;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public String getVersionedFlowState() {
    return versionedFlowState;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public FlowBreadcrumbEntityBuilder setVersionedFlowState(final String versionedFlowState) {
    this.versionedFlowState = versionedFlowState;
    return this;
  }

  public FlowBreadcrumbEntity build() {
    final FlowBreadcrumbEntity flowBreadcrumbEntity = new FlowBreadcrumbEntity();
    super.setPropertyValues(flowBreadcrumbEntity);
    flowBreadcrumbEntity.setBreadcrumb(breadcrumb);
    flowBreadcrumbEntity.setId(id);
    flowBreadcrumbEntity.setParentBreadcrumb(parentBreadcrumb);
    flowBreadcrumbEntity.setPermissions(permissions);
    flowBreadcrumbEntity.setVersionedFlowState(versionedFlowState);
    return flowBreadcrumbEntity;
  }

  public static FlowBreadcrumbEntityBuilder of(final FlowBreadcrumbEntity flowBreadcrumbEntity) {
    final FlowBreadcrumbEntityBuilder flowBreadcrumbEntityBuilder = new FlowBreadcrumbEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(flowBreadcrumbEntityBuilder, flowBreadcrumbEntity);
    flowBreadcrumbEntityBuilder.setBreadcrumb(flowBreadcrumbEntity.getBreadcrumb());
    flowBreadcrumbEntityBuilder.setId(flowBreadcrumbEntity.getId());
    flowBreadcrumbEntityBuilder.setParentBreadcrumb(flowBreadcrumbEntity.getParentBreadcrumb());
    flowBreadcrumbEntityBuilder.setPermissions(flowBreadcrumbEntity.getPermissions());
    flowBreadcrumbEntityBuilder.setVersionedFlowState(flowBreadcrumbEntity.getVersionedFlowState());
    return flowBreadcrumbEntityBuilder;
  }
}
