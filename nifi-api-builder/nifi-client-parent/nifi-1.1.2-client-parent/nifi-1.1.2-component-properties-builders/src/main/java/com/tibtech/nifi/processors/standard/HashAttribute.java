package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HashAttribute {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.HashAttribute";

  /**
   * The name of the FlowFile Attribute where the hash value should be stored
   */
  public static final String HASH_VALUE_ATTRIBUTE_KEY_PROPERTY = "Hash Value Attribute Key";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The name of the FlowFile Attribute where the hash value should be stored
   */
  public final String getHashValueAttributeKey() {
    return properties.get(HASH_VALUE_ATTRIBUTE_KEY_PROPERTY);
  }

  /**
   * The name of the FlowFile Attribute where the hash value should be stored
   */
  public final HashAttribute setHashValueAttributeKey(final String hashValueAttributeKey) {
    properties.put(HASH_VALUE_ATTRIBUTE_KEY_PROPERTY, hashValueAttributeKey);
    return this;
  }

  /**
   * The name of the FlowFile Attribute where the hash value should be stored
   */
  public final HashAttribute removeHashValueAttributeKey() {
    properties.remove(HASH_VALUE_ATTRIBUTE_KEY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HashAttribute setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HashAttribute removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<HashAttribute, HashAttribute> configurator) {
    return configurator.apply(new HashAttribute()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HashAttribute.class) final Closure<HashAttribute> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.HashAttribute> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.HashAttribute.class, com.tibtech.nifi.processors.standard.HashAttribute.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
