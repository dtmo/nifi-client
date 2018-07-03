package com.tibtech.nifi.update.attributes.dto;

import java.lang.String;
import org.apache.nifi.update.attributes.dto.ConditionDTO;

public final class ConditionDTOBuilder {
  private String expression;

  private String id;

  public String getExpression() {
    return expression;
  }

  public ConditionDTOBuilder setExpression(final String expression) {
    this.expression = expression;
    return this;
  }

  public String getId() {
    return id;
  }

  public ConditionDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public ConditionDTO build() {
    final ConditionDTO conditionDTO = new ConditionDTO();
    conditionDTO.setExpression(expression);
    conditionDTO.setId(id);
    return conditionDTO;
  }

  public static ConditionDTOBuilder of(final ConditionDTO conditionDTO) {
    final ConditionDTOBuilder conditionDTOBuilder = new ConditionDTOBuilder();
    conditionDTOBuilder.setExpression(conditionDTO.getExpression());
    conditionDTOBuilder.setId(conditionDTO.getId());
    return conditionDTOBuilder;
  }
}
