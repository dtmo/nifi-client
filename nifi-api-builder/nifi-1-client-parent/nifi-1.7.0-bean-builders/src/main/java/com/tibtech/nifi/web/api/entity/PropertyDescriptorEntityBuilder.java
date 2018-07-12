package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.PropertyDescriptorEntity;

public final class PropertyDescriptorEntityBuilder extends AbstractEntityBuilder<PropertyDescriptorEntityBuilder> {
  private PropertyDescriptorDTO propertyDescriptor;

  public PropertyDescriptorDTO getPropertyDescriptor() {
    return propertyDescriptor;
  }

  public PropertyDescriptorEntityBuilder setPropertyDescriptor(
      final PropertyDescriptorDTO propertyDescriptor) {
    this.propertyDescriptor = propertyDescriptor;
    return this;
  }

  public PropertyDescriptorEntity build() {
    final PropertyDescriptorEntity propertyDescriptorEntity = new PropertyDescriptorEntity();
    super.setPropertyValues(propertyDescriptorEntity);
    propertyDescriptorEntity.setPropertyDescriptor(propertyDescriptor);
    return propertyDescriptorEntity;
  }

  public static PropertyDescriptorEntityBuilder of(
      final PropertyDescriptorEntity propertyDescriptorEntity) {
    final PropertyDescriptorEntityBuilder propertyDescriptorEntityBuilder = new PropertyDescriptorEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(propertyDescriptorEntityBuilder, propertyDescriptorEntity);
    propertyDescriptorEntityBuilder.setPropertyDescriptor(propertyDescriptorEntity.getPropertyDescriptor());
    return propertyDescriptorEntityBuilder;
  }
}
