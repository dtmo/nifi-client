package com.tibtech.nifi.web.api.entity;

import java.util.Collection;
import org.apache.nifi.web.api.entity.UserGroupEntity;
import org.apache.nifi.web.api.entity.UserGroupsEntity;

public final class UserGroupsEntityBuilder extends AbstractEntityBuilder<UserGroupsEntityBuilder> {
  private Collection<UserGroupEntity> userGroups;

  public Collection<UserGroupEntity> getUserGroups() {
    return userGroups;
  }

  public UserGroupsEntityBuilder setUserGroups(final Collection<UserGroupEntity> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  public UserGroupsEntity build() {
    final UserGroupsEntity userGroupsEntity = new UserGroupsEntity();
    super.setPropertyValues(userGroupsEntity);
    userGroupsEntity.setUserGroups(userGroups);
    return userGroupsEntity;
  }

  public static UserGroupsEntityBuilder of(final UserGroupsEntity userGroupsEntity) {
    final UserGroupsEntityBuilder userGroupsEntityBuilder = new UserGroupsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(userGroupsEntityBuilder, userGroupsEntity);
    userGroupsEntityBuilder.setUserGroups(userGroupsEntity.getUserGroups());
    return userGroupsEntityBuilder;
  }
}
