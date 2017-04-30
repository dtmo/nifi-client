package com.tibtech.nifi.processors.evtx;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ParseEvtx {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.evtx.ParseEvtx";

  /**
   * Output flow file for each Record, Chunk, or File encountered in the event log
   */
  public static final String GRANULARITY_PROPERTY = "granularity";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Output flow file for each Record, Chunk, or File encountered in the event log
   */
  public final String getGranularity() {
    return properties.get(GRANULARITY_PROPERTY);
  }

  /**
   * Output flow file for each Record, Chunk, or File encountered in the event log
   */
  public final ParseEvtx setGranularity(final String granularity) {
    properties.put(GRANULARITY_PROPERTY, granularity);
    return this;
  }

  /**
   * Output flow file for each Record, Chunk, or File encountered in the event log
   */
  public final ParseEvtx removeGranularity() {
    properties.remove(GRANULARITY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ParseEvtx setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ParseEvtx removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ParseEvtx, ParseEvtx> configurator) {
    return configurator.apply(new ParseEvtx()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ParseEvtx.class) final Closure<ParseEvtx> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.evtx.ParseEvtx> code = closure.rehydrate(c, com.tibtech.nifi.processors.evtx.ParseEvtx.class, com.tibtech.nifi.processors.evtx.ParseEvtx.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
