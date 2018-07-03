package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.entity.Entity;

public abstract class AbstractEntityBuilder<T extends AbstractEntityBuilder<T>> {
  protected void setPropertyValues(final Entity entity) {
  }

  protected static void setBuilderValues(final AbstractEntityBuilder abstractEntityBuilder,
      final Entity entity) {
  }
}
