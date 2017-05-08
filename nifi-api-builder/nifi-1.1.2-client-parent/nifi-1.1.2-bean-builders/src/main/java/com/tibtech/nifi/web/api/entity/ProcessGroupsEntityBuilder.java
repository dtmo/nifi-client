package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;
import org.apache.nifi.web.api.entity.ProcessGroupsEntity;

public final class ProcessGroupsEntityBuilder extends AbstractEntityBuilder<ProcessGroupsEntityBuilder> {
  private Set<ProcessGroupEntity> processGroups;

  public Set<ProcessGroupEntity> getProcessGroups() {
    return processGroups;
  }

  public ProcessGroupsEntityBuilder setProcessGroups(final Set<ProcessGroupEntity> processGroups) {
    this.processGroups = processGroups;
    return this;
  }

  public ProcessGroupsEntity build() {
    final ProcessGroupsEntity processGroupsEntity = new ProcessGroupsEntity();
    super.setPropertyValues(processGroupsEntity);
    processGroupsEntity.setProcessGroups(processGroups);
    return processGroupsEntity;
  }

  public static ProcessGroupsEntityBuilder of(final ProcessGroupsEntity processGroupsEntity) {
    final ProcessGroupsEntityBuilder processGroupsEntityBuilder = new ProcessGroupsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processGroupsEntityBuilder, processGroupsEntity);
    processGroupsEntityBuilder.setProcessGroups(processGroupsEntity.getProcessGroups());
    return processGroupsEntityBuilder;
  }
}
