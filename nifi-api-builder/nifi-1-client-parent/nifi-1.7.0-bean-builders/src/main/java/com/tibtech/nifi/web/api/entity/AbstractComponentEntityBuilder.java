package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

public abstract class AbstractComponentEntityBuilder<T extends AbstractComponentEntityBuilder<T>> extends AbstractEntityBuilder<T> {
  private List<BulletinEntity> bulletins;

  private Boolean disconnectedNodeAcknowledged;

  private String id;

  private PermissionsDTO permissions;

  private PositionDTO position;

  private RevisionDTO revision;

  private String uri;

  /**
   * The bulletins for this component.
   */
  public List<BulletinEntity> getBulletins() {
    return bulletins;
  }

  /**
   * The bulletins for this component.
   */
  public T setBulletins(final List<BulletinEntity> bulletins) {
    this.bulletins = bulletins;
    return (T) this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public T setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return (T) this;
  }

  /**
   * The id of the component.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the component.
   */
  public T setId(final String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * The permissions for this component.
   */
  public PermissionsDTO getPermissions() {
    return permissions;
  }

  /**
   * The permissions for this component.
   */
  public T setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return (T) this;
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public PositionDTO getPosition() {
    return position;
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public T setPosition(final PositionDTO position) {
    this.position = position;
    return (T) this;
  }

  /**
   * The revision for this request/response. The revision is required for any mutable flow requests and is included in all responses.
   */
  public RevisionDTO getRevision() {
    return revision;
  }

  /**
   * The revision for this request/response. The revision is required for any mutable flow requests and is included in all responses.
   */
  public T setRevision(final RevisionDTO revision) {
    this.revision = revision;
    return (T) this;
  }

  /**
   * The URI for futures requests to the component.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for futures requests to the component.
   */
  public T setUri(final String uri) {
    this.uri = uri;
    return (T) this;
  }

  protected void setPropertyValues(final ComponentEntity componentEntity) {
    super.setPropertyValues(componentEntity);
    componentEntity.setBulletins(bulletins);
    componentEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    componentEntity.setId(id);
    componentEntity.setPermissions(permissions);
    componentEntity.setPosition(position);
    componentEntity.setRevision(revision);
    componentEntity.setUri(uri);
  }

  protected static void setBuilderValues(final AbstractComponentEntityBuilder abstractComponentEntityBuilder,
      final ComponentEntity componentEntity) {
    AbstractEntityBuilder.setBuilderValues(abstractComponentEntityBuilder, componentEntity);
    abstractComponentEntityBuilder.setBulletins(componentEntity.getBulletins());
    abstractComponentEntityBuilder.setDisconnectedNodeAcknowledged(componentEntity.isDisconnectedNodeAcknowledged());
    abstractComponentEntityBuilder.setId(componentEntity.getId());
    abstractComponentEntityBuilder.setPermissions(componentEntity.getPermissions());
    abstractComponentEntityBuilder.setPosition(componentEntity.getPosition());
    abstractComponentEntityBuilder.setRevision(componentEntity.getRevision());
    abstractComponentEntityBuilder.setUri(componentEntity.getUri());
  }
}
