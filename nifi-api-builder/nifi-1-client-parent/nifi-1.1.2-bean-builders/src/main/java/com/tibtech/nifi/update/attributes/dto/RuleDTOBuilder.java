package com.tibtech.nifi.update.attributes.dto;

import java.lang.String;
import java.util.Set;
import org.apache.nifi.update.attributes.dto.ActionDTO;
import org.apache.nifi.update.attributes.dto.ConditionDTO;
import org.apache.nifi.update.attributes.dto.RuleDTO;

public final class RuleDTOBuilder {
  private Set<ActionDTO> actions;

  private Set<ConditionDTO> conditions;

  private String id;

  private String name;

  public Set<ActionDTO> getActions() {
    return actions;
  }

  public RuleDTOBuilder setActions(final Set<ActionDTO> actions) {
    this.actions = actions;
    return this;
  }

  public Set<ConditionDTO> getConditions() {
    return conditions;
  }

  public RuleDTOBuilder setConditions(final Set<ConditionDTO> conditions) {
    this.conditions = conditions;
    return this;
  }

  public String getId() {
    return id;
  }

  public RuleDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public RuleDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public RuleDTO build() {
    final RuleDTO ruleDTO = new RuleDTO();
    ruleDTO.setActions(actions);
    ruleDTO.setConditions(conditions);
    ruleDTO.setId(id);
    ruleDTO.setName(name);
    return ruleDTO;
  }

  public static RuleDTOBuilder of(final RuleDTO ruleDTO) {
    final RuleDTOBuilder ruleDTOBuilder = new RuleDTOBuilder();
    ruleDTOBuilder.setActions(ruleDTO.getActions());
    ruleDTOBuilder.setConditions(ruleDTO.getConditions());
    ruleDTOBuilder.setId(ruleDTO.getId());
    ruleDTOBuilder.setName(ruleDTO.getName());
    return ruleDTOBuilder;
  }
}
