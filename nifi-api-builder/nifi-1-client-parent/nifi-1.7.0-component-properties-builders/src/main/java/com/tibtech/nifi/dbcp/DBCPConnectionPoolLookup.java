package com.tibtech.nifi.dbcp;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DBCPConnectionPoolLookup {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.dbcp.DBCPConnectionPoolLookup";

  private final Map<String, String> properties;

  public DBCPConnectionPoolLookup() {
    this.properties = new HashMap<>();
  }

  public DBCPConnectionPoolLookup(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DBCPConnectionPoolLookup setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DBCPConnectionPoolLookup removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DBCPConnectionPoolLookup, DBCPConnectionPoolLookup> configurator) {
    return configurator.apply(new DBCPConnectionPoolLookup()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DBCPConnectionPoolLookup.class) final Closure<DBCPConnectionPoolLookup> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.dbcp.DBCPConnectionPoolLookup> code = closure.rehydrate(c, com.tibtech.nifi.dbcp.DBCPConnectionPoolLookup.class, com.tibtech.nifi.dbcp.DBCPConnectionPoolLookup.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DBCPConnectionPoolLookup, DBCPConnectionPoolLookup> configurator) {
    return configurator.apply(new DBCPConnectionPoolLookup(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DBCPConnectionPoolLookup.class) final Closure<DBCPConnectionPoolLookup> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.dbcp.DBCPConnectionPoolLookup> code = closure.rehydrate(c, com.tibtech.nifi.dbcp.DBCPConnectionPoolLookup.class, com.tibtech.nifi.dbcp.DBCPConnectionPoolLookup.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
