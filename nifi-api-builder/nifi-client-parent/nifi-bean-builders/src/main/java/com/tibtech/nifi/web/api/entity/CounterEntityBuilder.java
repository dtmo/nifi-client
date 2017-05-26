package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.CounterDTO;
import org.apache.nifi.web.api.entity.CounterEntity;

public final class CounterEntityBuilder extends AbstractEntityBuilder<CounterEntityBuilder> {
  private CounterDTO counter;

  public CounterDTO getCounter() {
    return counter;
  }

  public CounterEntityBuilder setCounter(final CounterDTO counter) {
    this.counter = counter;
    return this;
  }

  public CounterEntity build() {
    final CounterEntity counterEntity = new CounterEntity();
    super.setPropertyValues(counterEntity);
    counterEntity.setCounter(counter);
    return counterEntity;
  }

  public static CounterEntityBuilder of(final CounterEntity counterEntity) {
    final CounterEntityBuilder counterEntityBuilder = new CounterEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(counterEntityBuilder, counterEntity);
    counterEntityBuilder.setCounter(counterEntity.getCounter());
    return counterEntityBuilder;
  }
}
