package com.tibtech.nifi.couchbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CouchbaseClusterService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.couchbase.CouchbaseClusterService";

  /**
   * The hostnames or ip addresses of the bootstraping nodes and optional parameters. Syntax) couchbase://node1,node2,nodeN?param1=value1&param2=value2&paramN=valueN
   */
  public static final String CONNECTION_STRING_PROPERTY = "Connection String";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The hostnames or ip addresses of the bootstraping nodes and optional parameters. Syntax) couchbase://node1,node2,nodeN?param1=value1&param2=value2&paramN=valueN
   */
  public final String getConnectionString() {
    return properties.get(CONNECTION_STRING_PROPERTY);
  }

  /**
   * The hostnames or ip addresses of the bootstraping nodes and optional parameters. Syntax) couchbase://node1,node2,nodeN?param1=value1&param2=value2&paramN=valueN
   */
  public final CouchbaseClusterService setConnectionString(final String connectionString) {
    properties.put(CONNECTION_STRING_PROPERTY, connectionString);
    return this;
  }

  /**
   * The hostnames or ip addresses of the bootstraping nodes and optional parameters. Syntax) couchbase://node1,node2,nodeN?param1=value1&param2=value2&paramN=valueN
   */
  public final CouchbaseClusterService removeConnectionString() {
    properties.remove(CONNECTION_STRING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CouchbaseClusterService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CouchbaseClusterService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<CouchbaseClusterService, CouchbaseClusterService> configurator) {
    return configurator.apply(new CouchbaseClusterService()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseClusterService.class) final Closure<CouchbaseClusterService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseClusterService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseClusterService.class, com.tibtech.nifi.couchbase.CouchbaseClusterService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
