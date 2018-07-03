package com.tibtech.nifi.controller.livy;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class LivySessionController {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.controller.livy.LivySessionController";

  /**
   * The hostname (or IP address) of the Livy server.
   */
  public static final String LIVY_CS_LIVY_HOST_PROPERTY = "livy-cs-livy-host";

  /**
   * The port number for the Livy server.
   */
  public static final String LIVY_CS_LIVY_PORT_PROPERTY = "livy-cs-livy-port";

  /**
   * Number of sessions to keep open
   */
  public static final String LIVY_CS_SESSION_POOL_SIZE_PROPERTY = "livy-cs-session-pool-size";

  /**
   * The type of Spark session to start (spark, pyspark, pyspark3, sparkr, e.g.)
   */
  public static final String LIVY_CS_SESSION_KIND_PROPERTY = "livy-cs-session-kind";

  /**
   * The amount of time to wait between requesting session information updates.
   */
  public static final String LIVY_CS_SESSION_MANAGER_STATUS_INTERVAL_PROPERTY = "livy-cs-session-manager-status-interval";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Max wait time for connection to remote service.
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * JARs to be used in the Spark session.
   */
  public static final String LIVY_CS_SESSION_JARS_PROPERTY = "livy-cs-session-jars";

  /**
   * Files to be used in the Spark session.
   */
  public static final String LIVY_CS_SESSION_FILES_PROPERTY = "livy-cs-session-files";

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public static final String KERBEROS_CREDENTIALS_SERVICE_PROPERTY = "kerberos-credentials-service";

  private final Map<String, String> properties;

  public LivySessionController() {
    this.properties = new HashMap<>();
  }

  public LivySessionController(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The hostname (or IP address) of the Livy server.
   */
  public final String getLivyCsLivyHost() {
    return properties.get(LIVY_CS_LIVY_HOST_PROPERTY);
  }

  /**
   * The hostname (or IP address) of the Livy server.
   */
  public final LivySessionController setLivyCsLivyHost(final String livyCsLivyHost) {
    properties.put(LIVY_CS_LIVY_HOST_PROPERTY, livyCsLivyHost);
    return this;
  }

  /**
   * The hostname (or IP address) of the Livy server.
   */
  public final LivySessionController removeLivyCsLivyHost() {
    properties.remove(LIVY_CS_LIVY_HOST_PROPERTY);
    return this;
  }

  /**
   * The port number for the Livy server.
   */
  public final String getLivyCsLivyPort() {
    return properties.get(LIVY_CS_LIVY_PORT_PROPERTY);
  }

  /**
   * The port number for the Livy server.
   */
  public final LivySessionController setLivyCsLivyPort(final String livyCsLivyPort) {
    properties.put(LIVY_CS_LIVY_PORT_PROPERTY, livyCsLivyPort);
    return this;
  }

  /**
   * The port number for the Livy server.
   */
  public final LivySessionController removeLivyCsLivyPort() {
    properties.remove(LIVY_CS_LIVY_PORT_PROPERTY);
    return this;
  }

  /**
   * Number of sessions to keep open
   */
  public final String getLivyCsSessionPoolSize() {
    return properties.get(LIVY_CS_SESSION_POOL_SIZE_PROPERTY);
  }

  /**
   * Number of sessions to keep open
   */
  public final LivySessionController setLivyCsSessionPoolSize(final String livyCsSessionPoolSize) {
    properties.put(LIVY_CS_SESSION_POOL_SIZE_PROPERTY, livyCsSessionPoolSize);
    return this;
  }

  /**
   * Number of sessions to keep open
   */
  public final LivySessionController removeLivyCsSessionPoolSize() {
    properties.remove(LIVY_CS_SESSION_POOL_SIZE_PROPERTY);
    return this;
  }

  /**
   * The type of Spark session to start (spark, pyspark, pyspark3, sparkr, e.g.)
   */
  public final String getLivyCsSessionKind() {
    return properties.get(LIVY_CS_SESSION_KIND_PROPERTY);
  }

  /**
   * The type of Spark session to start (spark, pyspark, pyspark3, sparkr, e.g.)
   */
  public final LivySessionController setLivyCsSessionKind(final String livyCsSessionKind) {
    properties.put(LIVY_CS_SESSION_KIND_PROPERTY, livyCsSessionKind);
    return this;
  }

  /**
   * The type of Spark session to start (spark, pyspark, pyspark3, sparkr, e.g.)
   */
  public final LivySessionController removeLivyCsSessionKind() {
    properties.remove(LIVY_CS_SESSION_KIND_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait between requesting session information updates.
   */
  public final String getLivyCsSessionManagerStatusInterval() {
    return properties.get(LIVY_CS_SESSION_MANAGER_STATUS_INTERVAL_PROPERTY);
  }

  /**
   * The amount of time to wait between requesting session information updates.
   */
  public final LivySessionController setLivyCsSessionManagerStatusInterval(
      final String livyCsSessionManagerStatusInterval) {
    properties.put(LIVY_CS_SESSION_MANAGER_STATUS_INTERVAL_PROPERTY, livyCsSessionManagerStatusInterval);
    return this;
  }

  /**
   * The amount of time to wait between requesting session information updates.
   */
  public final LivySessionController removeLivyCsSessionManagerStatusInterval() {
    properties.remove(LIVY_CS_SESSION_MANAGER_STATUS_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections.
   */
  public final LivySessionController setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections.
   */
  public final LivySessionController removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Max wait time for connection to remote service.
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * Max wait time for connection to remote service.
   */
  public final LivySessionController setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Max wait time for connection to remote service.
   */
  public final LivySessionController removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * JARs to be used in the Spark session.
   */
  public final String getLivyCsSessionJars() {
    return properties.get(LIVY_CS_SESSION_JARS_PROPERTY);
  }

  /**
   * JARs to be used in the Spark session.
   */
  public final LivySessionController setLivyCsSessionJars(final String livyCsSessionJars) {
    properties.put(LIVY_CS_SESSION_JARS_PROPERTY, livyCsSessionJars);
    return this;
  }

  /**
   * JARs to be used in the Spark session.
   */
  public final LivySessionController removeLivyCsSessionJars() {
    properties.remove(LIVY_CS_SESSION_JARS_PROPERTY);
    return this;
  }

  /**
   * Files to be used in the Spark session.
   */
  public final String getLivyCsSessionFiles() {
    return properties.get(LIVY_CS_SESSION_FILES_PROPERTY);
  }

  /**
   * Files to be used in the Spark session.
   */
  public final LivySessionController setLivyCsSessionFiles(final String livyCsSessionFiles) {
    properties.put(LIVY_CS_SESSION_FILES_PROPERTY, livyCsSessionFiles);
    return this;
  }

  /**
   * Files to be used in the Spark session.
   */
  public final LivySessionController removeLivyCsSessionFiles() {
    properties.remove(LIVY_CS_SESSION_FILES_PROPERTY);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final String getKerberosCredentialsService() {
    return properties.get(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final LivySessionController setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final LivySessionController removeKerberosCredentialsService() {
    properties.remove(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final LivySessionController setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final LivySessionController removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<LivySessionController, LivySessionController> configurator) {
    return configurator.apply(new LivySessionController()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LivySessionController.class) final Closure<LivySessionController> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.controller.livy.LivySessionController> code = closure.rehydrate(c, com.tibtech.nifi.controller.livy.LivySessionController.class, com.tibtech.nifi.controller.livy.LivySessionController.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<LivySessionController, LivySessionController> configurator) {
    return configurator.apply(new LivySessionController(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LivySessionController.class) final Closure<LivySessionController> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.controller.livy.LivySessionController> code = closure.rehydrate(c, com.tibtech.nifi.controller.livy.LivySessionController.class, com.tibtech.nifi.controller.livy.LivySessionController.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
