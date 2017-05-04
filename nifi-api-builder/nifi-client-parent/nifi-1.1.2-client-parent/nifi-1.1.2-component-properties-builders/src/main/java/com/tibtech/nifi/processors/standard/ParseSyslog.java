package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ParseSyslog {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ParseSyslog";

  /**
   * Specifies which character set of the Syslog messages
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties;

  public ParseSyslog() {
    this.properties = new HashMap<>();
  }

  public ParseSyslog(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies which character set of the Syslog messages
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies which character set of the Syslog messages
   */
  public final ParseSyslog setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies which character set of the Syslog messages
   */
  public final ParseSyslog removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ParseSyslog setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ParseSyslog removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ParseSyslog, ParseSyslog> configurator) {
    return configurator.apply(new ParseSyslog()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ParseSyslog.class) final Closure<ParseSyslog> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ParseSyslog> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ParseSyslog.class, com.tibtech.nifi.processors.standard.ParseSyslog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ParseSyslog, ParseSyslog> configurator) {
    return configurator.apply(new ParseSyslog(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ParseSyslog.class) final Closure<ParseSyslog> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ParseSyslog> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ParseSyslog.class, com.tibtech.nifi.processors.standard.ParseSyslog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
