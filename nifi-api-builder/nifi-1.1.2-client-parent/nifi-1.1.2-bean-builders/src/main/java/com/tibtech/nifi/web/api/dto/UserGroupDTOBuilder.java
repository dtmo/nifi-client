package com.tibtech.nifi.web.api.dto;

import java.util.Set;
import org.apache.nifi.web.api.dto.UserGroupDTO;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;
import org.apache.nifi.web.api.entity.TenantEntity;

public final class UserGroupDTOBuilder extends AbstractTenantDTOBuilder<UserGroupDTOBuilder> {
  private Set<AccessPolicyEntity> accessPolicies;

  private Set<TenantEntity> users;

  /**
   * The access policies this user group belongs to. This field was incorrectly defined as an AccessPolicyEntity. For compatibility reasons the field will remain of this type, however only the fields that are present in the AccessPolicySummaryEntity will be populated here.
   */
  public Set<AccessPolicyEntity> getAccessPolicies() {
    return accessPolicies;
  }

  /**
   * The access policies this user group belongs to. This field was incorrectly defined as an AccessPolicyEntity. For compatibility reasons the field will remain of this type, however only the fields that are present in the AccessPolicySummaryEntity will be populated here.
   */
  public UserGroupDTOBuilder setAccessPolicies(final Set<AccessPolicyEntity> accessPolicies) {
    this.accessPolicies = accessPolicies;
    return this;
  }

  /**
   * The users that belong to the user group.
   */
  public Set<TenantEntity> getUsers() {
    return users;
  }

  /**
   * The users that belong to the user group.
   */
  public UserGroupDTOBuilder setUsers(final Set<TenantEntity> users) {
    this.users = users;
    return this;
  }

  public UserGroupDTO build() {
    final UserGroupDTO userGroupDTO = new UserGroupDTO();
    super.setPropertyValues(userGroupDTO);
    userGroupDTO.setAccessPolicies(accessPolicies);
    userGroupDTO.setUsers(users);
    return userGroupDTO;
  }

  public static UserGroupDTOBuilder of(final UserGroupDTO userGroupDTO) {
    final UserGroupDTOBuilder userGroupDTOBuilder = new UserGroupDTOBuilder();
    AbstractTenantDTOBuilder.setBuilderValues(userGroupDTOBuilder, userGroupDTO);
    userGroupDTOBuilder.setAccessPolicies(userGroupDTO.getAccessPolicies());
    userGroupDTOBuilder.setUsers(userGroupDTO.getUsers());
    return userGroupDTOBuilder;
  }
}
