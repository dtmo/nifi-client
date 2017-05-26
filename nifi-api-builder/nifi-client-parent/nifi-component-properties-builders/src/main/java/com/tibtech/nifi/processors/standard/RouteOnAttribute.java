package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RouteOnAttribute {
  /**
   * Specifies how to determine which relationship to use when evaluating the Expression Language
   */
  public static final String ROUTING_STRATEGY_PROPERTY = "Routing Strategy";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies how to determine which relationship to use when evaluating the Expression Language
   */
  public final String getRoutingStrategy() {
    return properties.get(ROUTING_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to determine which relationship to use when evaluating the Expression Language
   */
  public final RouteOnAttribute setRoutingStrategy(final String routingStrategy) {
    properties.put(ROUTING_STRATEGY_PROPERTY, routingStrategy);
    return this;
  }

  /**
   * Specifies how to determine which relationship to use when evaluating the Expression Language
   */
  public final RouteOnAttribute removeRoutingStrategy() {
    properties.remove(ROUTING_STRATEGY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RouteOnAttribute setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final RouteOnAttribute removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<RouteOnAttribute, RouteOnAttribute> configurator) {
    return configurator.apply(new RouteOnAttribute()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RouteOnAttribute.class) final Closure<RouteOnAttribute> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.RouteOnAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.RouteOnAttribute.class, com.tibtech.nifi.processors.standard.RouteOnAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
