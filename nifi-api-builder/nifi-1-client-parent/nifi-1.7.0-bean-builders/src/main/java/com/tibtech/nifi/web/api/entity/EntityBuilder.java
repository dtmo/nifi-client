package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.entity.Entity;

public final class EntityBuilder extends AbstractEntityBuilder<EntityBuilder> {
  public Entity build() {
    final Entity entity = new Entity();
    super.setPropertyValues(entity);
    return entity;
  }

  public static EntityBuilder of(final Entity entity) {
    final EntityBuilder entityBuilder = new EntityBuilder();
    AbstractEntityBuilder.setBuilderValues(entityBuilder, entity);
    return entityBuilder;
  }
}
