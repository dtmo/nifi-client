package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.UserDTO;
import org.apache.nifi.web.api.entity.UserEntity;

public final class UserEntityBuilder extends AbstractComponentEntityBuilder<UserEntityBuilder> {
  private UserDTO component;

  public UserDTO getComponent() {
    return component;
  }

  public UserEntityBuilder setComponent(final UserDTO component) {
    this.component = component;
    return this;
  }

  public UserEntity build() {
    final UserEntity userEntity = new UserEntity();
    super.setPropertyValues(userEntity);
    userEntity.setComponent(component);
    return userEntity;
  }

  public static UserEntityBuilder of(final UserEntity userEntity) {
    final UserEntityBuilder userEntityBuilder = new UserEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(userEntityBuilder, userEntity);
    userEntityBuilder.setComponent(userEntity.getComponent());
    return userEntityBuilder;
  }
}
