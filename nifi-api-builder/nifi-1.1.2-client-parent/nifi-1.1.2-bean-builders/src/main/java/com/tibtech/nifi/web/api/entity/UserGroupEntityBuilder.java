package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.UserGroupDTO;
import org.apache.nifi.web.api.entity.UserGroupEntity;

public final class UserGroupEntityBuilder extends AbstractComponentEntityBuilder<UserGroupEntityBuilder> {
  private UserGroupDTO component;

  public UserGroupDTO getComponent() {
    return component;
  }

  public UserGroupEntityBuilder setComponent(final UserGroupDTO component) {
    this.component = component;
    return this;
  }

  public UserGroupEntity build() {
    final UserGroupEntity userGroupEntity = new UserGroupEntity();
    super.setPropertyValues(userGroupEntity);
    userGroupEntity.setComponent(component);
    return userGroupEntity;
  }

  public static UserGroupEntityBuilder of(final UserGroupEntity userGroupEntity) {
    final UserGroupEntityBuilder userGroupEntityBuilder = new UserGroupEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(userGroupEntityBuilder, userGroupEntity);
    userGroupEntityBuilder.setComponent(userGroupEntity.getComponent());
    return userGroupEntityBuilder;
  }
}
