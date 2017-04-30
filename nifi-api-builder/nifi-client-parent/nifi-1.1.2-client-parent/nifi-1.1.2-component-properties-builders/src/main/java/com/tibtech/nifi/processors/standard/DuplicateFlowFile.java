package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DuplicateFlowFile {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.DuplicateFlowFile";

  /**
   * Specifies how many copies of each incoming FlowFile will be made
   */
  public static final String NUMBER_OF_COPIES_PROPERTY = "Number of Copies";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies how many copies of each incoming FlowFile will be made
   */
  public final String getNumberOfCopies() {
    return properties.get(NUMBER_OF_COPIES_PROPERTY);
  }

  /**
   * Specifies how many copies of each incoming FlowFile will be made
   */
  public final DuplicateFlowFile setNumberOfCopies(final String numberOfCopies) {
    properties.put(NUMBER_OF_COPIES_PROPERTY, numberOfCopies);
    return this;
  }

  /**
   * Specifies how many copies of each incoming FlowFile will be made
   */
  public final DuplicateFlowFile removeNumberOfCopies() {
    properties.remove(NUMBER_OF_COPIES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DuplicateFlowFile setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DuplicateFlowFile removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DuplicateFlowFile, DuplicateFlowFile> configurator) {
    return configurator.apply(new DuplicateFlowFile()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DuplicateFlowFile.class) final Closure<DuplicateFlowFile> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.DuplicateFlowFile> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.DuplicateFlowFile.class, com.tibtech.nifi.processors.standard.DuplicateFlowFile.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
