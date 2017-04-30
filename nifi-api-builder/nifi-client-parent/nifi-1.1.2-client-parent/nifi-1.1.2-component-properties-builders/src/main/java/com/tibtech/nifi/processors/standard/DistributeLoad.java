package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DistributeLoad {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.DistributeLoad";

  /**
   * Determines the number of Relationships to which the load should be distributed
   */
  public static final String NUMBER_OF_RELATIONSHIPS_PROPERTY = "Number of Relationships";

  /**
   * Determines how the load will be distributed. If using Round Robin, will not distribute any FlowFiles unless all destinations can accept FlowFiles; when using Next Available, will distribute FlowFiles as long as at least 1 destination can accept FlowFiles.
   */
  public static final String DISTRIBUTION_STRATEGY_PROPERTY = "Distribution Strategy";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Determines the number of Relationships to which the load should be distributed
   */
  public final String getNumberOfRelationships() {
    return properties.get(NUMBER_OF_RELATIONSHIPS_PROPERTY);
  }

  /**
   * Determines the number of Relationships to which the load should be distributed
   */
  public final DistributeLoad setNumberOfRelationships(final String numberOfRelationships) {
    properties.put(NUMBER_OF_RELATIONSHIPS_PROPERTY, numberOfRelationships);
    return this;
  }

  /**
   * Determines the number of Relationships to which the load should be distributed
   */
  public final DistributeLoad removeNumberOfRelationships() {
    properties.remove(NUMBER_OF_RELATIONSHIPS_PROPERTY);
    return this;
  }

  /**
   * Determines how the load will be distributed. If using Round Robin, will not distribute any FlowFiles unless all destinations can accept FlowFiles; when using Next Available, will distribute FlowFiles as long as at least 1 destination can accept FlowFiles.
   */
  public final String getDistributionStrategy() {
    return properties.get(DISTRIBUTION_STRATEGY_PROPERTY);
  }

  /**
   * Determines how the load will be distributed. If using Round Robin, will not distribute any FlowFiles unless all destinations can accept FlowFiles; when using Next Available, will distribute FlowFiles as long as at least 1 destination can accept FlowFiles.
   */
  public final DistributeLoad setDistributionStrategy(final String distributionStrategy) {
    properties.put(DISTRIBUTION_STRATEGY_PROPERTY, distributionStrategy);
    return this;
  }

  /**
   * Determines how the load will be distributed. If using Round Robin, will not distribute any FlowFiles unless all destinations can accept FlowFiles; when using Next Available, will distribute FlowFiles as long as at least 1 destination can accept FlowFiles.
   */
  public final DistributeLoad removeDistributionStrategy() {
    properties.remove(DISTRIBUTION_STRATEGY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DistributeLoad setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DistributeLoad removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DistributeLoad, DistributeLoad> configurator) {
    return configurator.apply(new DistributeLoad()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributeLoad.class) final Closure<DistributeLoad> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.DistributeLoad> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.DistributeLoad.class, com.tibtech.nifi.processors.standard.DistributeLoad.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
