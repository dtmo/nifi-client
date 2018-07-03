package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.CounterDTO;

public final class CounterDTOBuilder {
  private String context;

  private String id;

  private String name;

  private String value;

  private Long valueCount;

  /**
   * The context of the counter.
   */
  public String getContext() {
    return context;
  }

  /**
   * The context of the counter.
   */
  public CounterDTOBuilder setContext(final String context) {
    this.context = context;
    return this;
  }

  /**
   * The id of the counter.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the counter.
   */
  public CounterDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the counter.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the counter.
   */
  public CounterDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The value of the counter.
   */
  public String getValue() {
    return value;
  }

  /**
   * The value of the counter.
   */
  public CounterDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  /**
   * The value count.
   */
  public Long getValueCount() {
    return valueCount;
  }

  /**
   * The value count.
   */
  public CounterDTOBuilder setValueCount(final Long valueCount) {
    this.valueCount = valueCount;
    return this;
  }

  public CounterDTO build() {
    final CounterDTO counterDTO = new CounterDTO();
    counterDTO.setContext(context);
    counterDTO.setId(id);
    counterDTO.setName(name);
    counterDTO.setValue(value);
    counterDTO.setValueCount(valueCount);
    return counterDTO;
  }

  public static CounterDTOBuilder of(final CounterDTO counterDTO) {
    final CounterDTOBuilder counterDTOBuilder = new CounterDTOBuilder();
    counterDTOBuilder.setContext(counterDTO.getContext());
    counterDTOBuilder.setId(counterDTO.getId());
    counterDTOBuilder.setName(counterDTO.getName());
    counterDTOBuilder.setValue(counterDTO.getValue());
    counterDTOBuilder.setValueCount(counterDTO.getValueCount());
    return counterDTOBuilder;
  }
}
