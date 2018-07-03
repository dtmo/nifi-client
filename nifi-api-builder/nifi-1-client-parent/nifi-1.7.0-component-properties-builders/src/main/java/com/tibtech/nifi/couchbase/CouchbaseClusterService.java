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

  /**
   * The user name to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public static final String USER_NAME_PROPERTY = "user-name";

  /**
   * The user password to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public static final String USER_PASSWORD_PROPERTY = "user-password";

  private final Map<String, String> properties;

  public CouchbaseClusterService() {
    this.properties = new HashMap<>();
  }

  public CouchbaseClusterService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

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

  /**
   * The user name to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public final String getUserName() {
    return properties.get(USER_NAME_PROPERTY);
  }

  /**
   * The user name to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public final CouchbaseClusterService setUserName(final String userName) {
    properties.put(USER_NAME_PROPERTY, userName);
    return this;
  }

  /**
   * The user name to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public final CouchbaseClusterService removeUserName() {
    properties.remove(USER_NAME_PROPERTY);
    return this;
  }

  /**
   * The user password to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public final String getUserPassword() {
    return properties.get(USER_PASSWORD_PROPERTY);
  }

  /**
   * The user password to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public final CouchbaseClusterService setUserPassword(final String userPassword) {
    properties.put(USER_PASSWORD_PROPERTY, userPassword);
    return this;
  }

  /**
   * The user password to authenticate NiFi as a Couchbase client. This configuration can be used against Couchbase Server 5.0 or later supporting Roll-Based Access Control.
   */
  public final CouchbaseClusterService removeUserPassword() {
    properties.remove(USER_PASSWORD_PROPERTY);
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

  public static final Map<String, String> build(
      final Function<CouchbaseClusterService, CouchbaseClusterService> configurator) {
    return configurator.apply(new CouchbaseClusterService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseClusterService.class) final Closure<CouchbaseClusterService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseClusterService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseClusterService.class, com.tibtech.nifi.couchbase.CouchbaseClusterService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CouchbaseClusterService, CouchbaseClusterService> configurator) {
    return configurator.apply(new CouchbaseClusterService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseClusterService.class) final Closure<CouchbaseClusterService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseClusterService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseClusterService.class, com.tibtech.nifi.couchbase.CouchbaseClusterService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
