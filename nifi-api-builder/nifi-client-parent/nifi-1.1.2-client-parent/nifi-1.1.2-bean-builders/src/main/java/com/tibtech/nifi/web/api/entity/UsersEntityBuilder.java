package com.tibtech.nifi.web.api.entity;

import java.util.Collection;
import java.util.Date;
import org.apache.nifi.web.api.entity.UserEntity;
import org.apache.nifi.web.api.entity.UsersEntity;

public final class UsersEntityBuilder extends AbstractEntityBuilder<UsersEntityBuilder> {
  private Date generated;

  private Collection<UserEntity> users;

  /**
   * When this content was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * When this content was generated.
   */
  public UsersEntityBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  public Collection<UserEntity> getUsers() {
    return users;
  }

  public UsersEntityBuilder setUsers(final Collection<UserEntity> users) {
    this.users = users;
    return this;
  }

  public UsersEntity build() {
    final UsersEntity usersEntity = new UsersEntity();
    super.setPropertyValues(usersEntity);
    usersEntity.setGenerated(generated);
    usersEntity.setUsers(users);
    return usersEntity;
  }

  public static UsersEntityBuilder of(final UsersEntity usersEntity) {
    final UsersEntityBuilder usersEntityBuilder = new UsersEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(usersEntityBuilder, usersEntity);
    usersEntityBuilder.setGenerated(usersEntity.getGenerated());
    usersEntityBuilder.setUsers(usersEntity.getUsers());
    return usersEntityBuilder;
  }
}
