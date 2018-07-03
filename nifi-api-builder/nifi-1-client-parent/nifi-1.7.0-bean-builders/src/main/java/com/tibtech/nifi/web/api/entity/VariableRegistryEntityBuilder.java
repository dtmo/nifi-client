package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.VariableRegistryDTO;
import org.apache.nifi.web.api.entity.VariableRegistryEntity;

public final class VariableRegistryEntityBuilder extends AbstractEntityBuilder<VariableRegistryEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private RevisionDTO processGroupRevision;

  private VariableRegistryDTO variableRegistry;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public VariableRegistryEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The revision of the Process Group that the Variable Registry belongs to
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The revision of the Process Group that the Variable Registry belongs to
   */
  public VariableRegistryEntityBuilder setProcessGroupRevision(final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The Variable Registry.
   */
  public VariableRegistryDTO getVariableRegistry() {
    return variableRegistry;
  }

  /**
   * The Variable Registry.
   */
  public VariableRegistryEntityBuilder setVariableRegistry(final VariableRegistryDTO variableRegistry) {
    this.variableRegistry = variableRegistry;
    return this;
  }

  public VariableRegistryEntity build() {
    final VariableRegistryEntity variableRegistryEntity = new VariableRegistryEntity();
    super.setPropertyValues(variableRegistryEntity);
    variableRegistryEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    variableRegistryEntity.setProcessGroupRevision(processGroupRevision);
    variableRegistryEntity.setVariableRegistry(variableRegistry);
    return variableRegistryEntity;
  }

  public static VariableRegistryEntityBuilder of(final VariableRegistryEntity variableRegistryEntity) {
    final VariableRegistryEntityBuilder variableRegistryEntityBuilder = new VariableRegistryEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(variableRegistryEntityBuilder, variableRegistryEntity);
    variableRegistryEntityBuilder.setDisconnectedNodeAcknowledged(variableRegistryEntity.isDisconnectedNodeAcknowledged());
    variableRegistryEntityBuilder.setProcessGroupRevision(variableRegistryEntity.getProcessGroupRevision());
    variableRegistryEntityBuilder.setVariableRegistry(variableRegistryEntity.getVariableRegistry());
    return variableRegistryEntityBuilder;
  }
}
