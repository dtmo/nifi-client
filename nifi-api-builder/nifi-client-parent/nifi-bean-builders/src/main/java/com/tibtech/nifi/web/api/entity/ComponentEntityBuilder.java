package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ComponentEntity;

public final class ComponentEntityBuilder extends AbstractComponentEntityBuilder<ComponentEntityBuilder> {
  private List<BulletinEntity> bulletins;

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
  public ComponentEntityBuilder setBulletins(final List<BulletinEntity> bulletins) {
    this.bulletins = bulletins;
    return this;
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
  public ComponentEntityBuilder setId(final String id) {
    this.id = id;
    return this;
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
  public ComponentEntityBuilder setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return this;
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
  public ComponentEntityBuilder setPosition(final PositionDTO position) {
    this.position = position;
    return this;
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
  public ComponentEntityBuilder setRevision(final RevisionDTO revision) {
    this.revision = revision;
    return this;
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
  public ComponentEntityBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public ComponentEntity build() {
    final ComponentEntity componentEntity = new ComponentEntity();
    super.setPropertyValues(componentEntity);
    componentEntity.setBulletins(bulletins);
    componentEntity.setId(id);
    componentEntity.setPermissions(permissions);
    componentEntity.setPosition(position);
    componentEntity.setRevision(revision);
    componentEntity.setUri(uri);
    return componentEntity;
  }

  public static ComponentEntityBuilder of(final ComponentEntity componentEntity) {
    final ComponentEntityBuilder componentEntityBuilder = new ComponentEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(componentEntityBuilder, componentEntity);
    componentEntityBuilder.setBulletins(componentEntity.getBulletins());
    componentEntityBuilder.setId(componentEntity.getId());
    componentEntityBuilder.setPermissions(componentEntity.getPermissions());
    componentEntityBuilder.setPosition(componentEntity.getPosition());
    componentEntityBuilder.setRevision(componentEntity.getRevision());
    componentEntityBuilder.setUri(componentEntity.getUri());
    return componentEntityBuilder;
  }
}
