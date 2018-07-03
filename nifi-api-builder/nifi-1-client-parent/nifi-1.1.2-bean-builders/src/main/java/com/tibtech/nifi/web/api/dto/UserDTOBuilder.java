package com.tibtech.nifi.web.api.dto;

import java.util.Set;
import org.apache.nifi.web.api.dto.UserDTO;
import org.apache.nifi.web.api.entity.AccessPolicySummaryEntity;
import org.apache.nifi.web.api.entity.TenantEntity;

public final class UserDTOBuilder extends AbstractTenantDTOBuilder<UserDTOBuilder> {
  private Set<AccessPolicySummaryEntity> accessPolicies;

  private Set<TenantEntity> userGroups;

  /**
   * The access policies this user belongs to.
   */
  public Set<AccessPolicySummaryEntity> getAccessPolicies() {
    return accessPolicies;
  }

  /**
   * The access policies this user belongs to.
   */
  public UserDTOBuilder setAccessPolicies(final Set<AccessPolicySummaryEntity> accessPolicies) {
    this.accessPolicies = accessPolicies;
    return this;
  }

  /**
   * The groups to which the user belongs. This field is read only and it provided for convenience.
   */
  public Set<TenantEntity> getUserGroups() {
    return userGroups;
  }

  /**
   * The groups to which the user belongs. This field is read only and it provided for convenience.
   */
  public UserDTOBuilder setUserGroups(final Set<TenantEntity> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  public UserDTO build() {
    final UserDTO userDTO = new UserDTO();
    super.setPropertyValues(userDTO);
    userDTO.setAccessPolicies(accessPolicies);
    userDTO.setUserGroups(userGroups);
    return userDTO;
  }

  public static UserDTOBuilder of(final UserDTO userDTO) {
    final UserDTOBuilder userDTOBuilder = new UserDTOBuilder();
    AbstractTenantDTOBuilder.setBuilderValues(userDTOBuilder, userDTO);
    userDTOBuilder.setAccessPolicies(userDTO.getAccessPolicies());
    userDTOBuilder.setUserGroups(userDTO.getUserGroups());
    return userDTOBuilder;
  }
}
