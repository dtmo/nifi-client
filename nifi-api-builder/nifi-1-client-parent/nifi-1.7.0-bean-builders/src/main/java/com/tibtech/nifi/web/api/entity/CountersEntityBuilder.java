package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.CountersDTO;
import org.apache.nifi.web.api.entity.CountersEntity;

public final class CountersEntityBuilder extends AbstractEntityBuilder<CountersEntityBuilder> {
  private CountersDTO counters;

  public CountersDTO getCounters() {
    return counters;
  }

  public CountersEntityBuilder setCounters(final CountersDTO counters) {
    this.counters = counters;
    return this;
  }

  public CountersEntity build() {
    final CountersEntity countersEntity = new CountersEntity();
    super.setPropertyValues(countersEntity);
    countersEntity.setCounters(counters);
    return countersEntity;
  }

  public static CountersEntityBuilder of(final CountersEntity countersEntity) {
    final CountersEntityBuilder countersEntityBuilder = new CountersEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(countersEntityBuilder, countersEntity);
    countersEntityBuilder.setCounters(countersEntity.getCounters());
    return countersEntityBuilder;
  }
}
