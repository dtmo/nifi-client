package com.tibtech.nifi.web.api.dto;

import java.util.Set;
import org.apache.nifi.web.api.dto.AccessPolicyDTO;
import org.apache.nifi.web.api.entity.TenantEntity;

public final class AccessPolicyDTOBuilder extends AbstractAccessPolicySummaryDTOBuilder<AccessPolicyDTOBuilder> {
  private Set<TenantEntity> userGroups;

  private Set<TenantEntity> users;

  /**
   * The set of user group IDs associated with this access policy.
   */
  public Set<TenantEntity> getUserGroups() {
    return userGroups;
  }

  /**
   * The set of user group IDs associated with this access policy.
   */
  public AccessPolicyDTOBuilder setUserGroups(final Set<TenantEntity> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  /**
   * The set of user IDs associated with this access policy.
   */
  public Set<TenantEntity> getUsers() {
    return users;
  }

  /**
   * The set of user IDs associated with this access policy.
   */
  public AccessPolicyDTOBuilder setUsers(final Set<TenantEntity> users) {
    this.users = users;
    return this;
  }

  public AccessPolicyDTO build() {
    final AccessPolicyDTO accessPolicyDTO = new AccessPolicyDTO();
    super.setPropertyValues(accessPolicyDTO);
    accessPolicyDTO.setUserGroups(userGroups);
    accessPolicyDTO.setUsers(users);
    return accessPolicyDTO;
  }

  public static AccessPolicyDTOBuilder of(final AccessPolicyDTO accessPolicyDTO) {
    final AccessPolicyDTOBuilder accessPolicyDTOBuilder = new AccessPolicyDTOBuilder();
    AbstractAccessPolicySummaryDTOBuilder.setBuilderValues(accessPolicyDTOBuilder, accessPolicyDTO);
    accessPolicyDTOBuilder.setUserGroups(accessPolicyDTO.getUserGroups());
    accessPolicyDTOBuilder.setUsers(accessPolicyDTO.getUsers());
    return accessPolicyDTOBuilder;
  }
}
