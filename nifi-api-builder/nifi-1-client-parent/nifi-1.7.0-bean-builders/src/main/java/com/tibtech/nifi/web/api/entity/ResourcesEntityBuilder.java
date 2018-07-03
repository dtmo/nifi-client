package com.tibtech.nifi.web.api.entity;

import java.util.List;
import org.apache.nifi.web.api.dto.ResourceDTO;
import org.apache.nifi.web.api.entity.ResourcesEntity;

public final class ResourcesEntityBuilder extends AbstractEntityBuilder<ResourcesEntityBuilder> {
  private List<ResourceDTO> resources;

  public List<ResourceDTO> getResources() {
    return resources;
  }

  public ResourcesEntityBuilder setResources(final List<ResourceDTO> resources) {
    this.resources = resources;
    return this;
  }

  public ResourcesEntity build() {
    final ResourcesEntity resourcesEntity = new ResourcesEntity();
    super.setPropertyValues(resourcesEntity);
    resourcesEntity.setResources(resources);
    return resourcesEntity;
  }

  public static ResourcesEntityBuilder of(final ResourcesEntity resourcesEntity) {
    final ResourcesEntityBuilder resourcesEntityBuilder = new ResourcesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(resourcesEntityBuilder, resourcesEntity);
    resourcesEntityBuilder.setResources(resourcesEntity.getResources());
    return resourcesEntityBuilder;
  }
}
