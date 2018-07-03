package com.tibtech.nifi.web.api.entity;

import java.util.Collection;
import org.apache.nifi.web.api.entity.TenantEntity;
import org.apache.nifi.web.api.entity.TenantsEntity;

public final class TenantsEntityBuilder extends AbstractEntityBuilder<TenantsEntityBuilder> {
  private Collection<TenantEntity> userGroups;

  private Collection<TenantEntity> users;

  public Collection<TenantEntity> getUserGroups() {
    return userGroups;
  }

  public TenantsEntityBuilder setUserGroups(final Collection<TenantEntity> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  public Collection<TenantEntity> getUsers() {
    return users;
  }

  public TenantsEntityBuilder setUsers(final Collection<TenantEntity> users) {
    this.users = users;
    return this;
  }

  public TenantsEntity build() {
    final TenantsEntity tenantsEntity = new TenantsEntity();
    super.setPropertyValues(tenantsEntity);
    tenantsEntity.setUserGroups(userGroups);
    tenantsEntity.setUsers(users);
    return tenantsEntity;
  }

  public static TenantsEntityBuilder of(final TenantsEntity tenantsEntity) {
    final TenantsEntityBuilder tenantsEntityBuilder = new TenantsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(tenantsEntityBuilder, tenantsEntity);
    tenantsEntityBuilder.setUserGroups(tenantsEntity.getUserGroups());
    tenantsEntityBuilder.setUsers(tenantsEntity.getUsers());
    return tenantsEntityBuilder;
  }
}
