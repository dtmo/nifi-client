package com.tibtech.nifi.web.api.dto.action.details;

import java.lang.String;
import org.apache.nifi.web.api.dto.action.details.MoveDetailsDTO;

public final class MoveDetailsDTOBuilder extends AbstractActionDetailsDTOBuilder<MoveDetailsDTOBuilder> {
  private String group;

  private String groupId;

  private String previousGroup;

  private String previousGroupId;

  /**
   * The name of the group the components belong to.
   */
  public String getGroup() {
    return group;
  }

  /**
   * The name of the group the components belong to.
   */
  public MoveDetailsDTOBuilder setGroup(final String group) {
    this.group = group;
    return this;
  }

  /**
   * The id of the group that components belong to.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the group that components belong to.
   */
  public MoveDetailsDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The name of the group the components previously belonged to.
   */
  public String getPreviousGroup() {
    return previousGroup;
  }

  /**
   * The name of the group the components previously belonged to.
   */
  public MoveDetailsDTOBuilder setPreviousGroup(final String previousGroup) {
    this.previousGroup = previousGroup;
    return this;
  }

  /**
   * The id of the group the components previously belonged to.
   */
  public String getPreviousGroupId() {
    return previousGroupId;
  }

  /**
   * The id of the group the components previously belonged to.
   */
  public MoveDetailsDTOBuilder setPreviousGroupId(final String previousGroupId) {
    this.previousGroupId = previousGroupId;
    return this;
  }

  public MoveDetailsDTO build() {
    final MoveDetailsDTO moveDetailsDTO = new MoveDetailsDTO();
    super.setPropertyValues(moveDetailsDTO);
    moveDetailsDTO.setGroup(group);
    moveDetailsDTO.setGroupId(groupId);
    moveDetailsDTO.setPreviousGroup(previousGroup);
    moveDetailsDTO.setPreviousGroupId(previousGroupId);
    return moveDetailsDTO;
  }

  public static MoveDetailsDTOBuilder of(final MoveDetailsDTO moveDetailsDTO) {
    final MoveDetailsDTOBuilder moveDetailsDTOBuilder = new MoveDetailsDTOBuilder();
    AbstractActionDetailsDTOBuilder.setBuilderValues(moveDetailsDTOBuilder, moveDetailsDTO);
    moveDetailsDTOBuilder.setGroup(moveDetailsDTO.getGroup());
    moveDetailsDTOBuilder.setGroupId(moveDetailsDTO.getGroupId());
    moveDetailsDTOBuilder.setPreviousGroup(moveDetailsDTO.getPreviousGroup());
    moveDetailsDTOBuilder.setPreviousGroupId(moveDetailsDTO.getPreviousGroupId());
    return moveDetailsDTOBuilder;
  }
}
