package com.tibtech.nifi.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ElasticSearchClientServiceImpl {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.elasticsearch.ElasticSearchClientServiceImpl";

  /**
   * A comma-separated list of HTTP hosts that host ElasticSearch query nodes.
   */
  public static final String EL_CS_HTTP_HOSTS_PROPERTY = "el-cs-http-hosts";

  /**
   * The username to use with XPack security.
   */
  public static final String EL_CS_USERNAME_PROPERTY = "el-cs-username";

  /**
   * The password to use with XPack security.
   */
  public static final String EL_CS_PASSWORD_PROPERTY = "el-cs-password";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public static final String EL_CS_SSL_CONTEXT_SERVICE_PROPERTY = "el-cs-ssl-context-service";

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when trying to connect.
   */
  public static final String EL_CS_CONNECT_TIMEOUT_PROPERTY = "el-cs-connect-timeout";

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when waiting for a response.
   */
  public static final String EL_CS_SOCKET_TIMEOUT_PROPERTY = "el-cs-socket-timeout";

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when retrying the operation.
   */
  public static final String EL_CS_RETRY_TIMEOUT_PROPERTY = "el-cs-retry-timeout";

  /**
   * The charset to use for interpreting the response from ElasticSearch.
   */
  public static final String EL_CS_CHARSET_PROPERTY = "el-cs-charset";

  private final Map<String, String> properties;

  public ElasticSearchClientServiceImpl() {
    this.properties = new HashMap<>();
  }

  public ElasticSearchClientServiceImpl(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A comma-separated list of HTTP hosts that host ElasticSearch query nodes.
   */
  public final String getElCsHttpHosts() {
    return properties.get(EL_CS_HTTP_HOSTS_PROPERTY);
  }

  /**
   * A comma-separated list of HTTP hosts that host ElasticSearch query nodes.
   */
  public final ElasticSearchClientServiceImpl setElCsHttpHosts(final String elCsHttpHosts) {
    properties.put(EL_CS_HTTP_HOSTS_PROPERTY, elCsHttpHosts);
    return this;
  }

  /**
   * A comma-separated list of HTTP hosts that host ElasticSearch query nodes.
   */
  public final ElasticSearchClientServiceImpl removeElCsHttpHosts() {
    properties.remove(EL_CS_HTTP_HOSTS_PROPERTY);
    return this;
  }

  /**
   * The username to use with XPack security.
   */
  public final String getElCsUsername() {
    return properties.get(EL_CS_USERNAME_PROPERTY);
  }

  /**
   * The username to use with XPack security.
   */
  public final ElasticSearchClientServiceImpl setElCsUsername(final String elCsUsername) {
    properties.put(EL_CS_USERNAME_PROPERTY, elCsUsername);
    return this;
  }

  /**
   * The username to use with XPack security.
   */
  public final ElasticSearchClientServiceImpl removeElCsUsername() {
    properties.remove(EL_CS_USERNAME_PROPERTY);
    return this;
  }

  /**
   * The password to use with XPack security.
   */
  public final String getElCsPassword() {
    return properties.get(EL_CS_PASSWORD_PROPERTY);
  }

  /**
   * The password to use with XPack security.
   */
  public final ElasticSearchClientServiceImpl setElCsPassword(final String elCsPassword) {
    properties.put(EL_CS_PASSWORD_PROPERTY, elCsPassword);
    return this;
  }

  /**
   * The password to use with XPack security.
   */
  public final ElasticSearchClientServiceImpl removeElCsPassword() {
    properties.remove(EL_CS_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final String getElCsSslContextService() {
    return properties.get(EL_CS_SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final ElasticSearchClientServiceImpl setElCsSslContextService(
      final String elCsSslContextService) {
    properties.put(EL_CS_SSL_CONTEXT_SERVICE_PROPERTY, elCsSslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Elasticsearch endpoint(s) have been secured with TLS/SSL.
   */
  public final ElasticSearchClientServiceImpl removeElCsSslContextService() {
    properties.remove(EL_CS_SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when trying to connect.
   */
  public final String getElCsConnectTimeout() {
    return properties.get(EL_CS_CONNECT_TIMEOUT_PROPERTY);
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when trying to connect.
   */
  public final ElasticSearchClientServiceImpl setElCsConnectTimeout(
      final String elCsConnectTimeout) {
    properties.put(EL_CS_CONNECT_TIMEOUT_PROPERTY, elCsConnectTimeout);
    return this;
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when trying to connect.
   */
  public final ElasticSearchClientServiceImpl removeElCsConnectTimeout() {
    properties.remove(EL_CS_CONNECT_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when waiting for a response.
   */
  public final String getElCsSocketTimeout() {
    return properties.get(EL_CS_SOCKET_TIMEOUT_PROPERTY);
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when waiting for a response.
   */
  public final ElasticSearchClientServiceImpl setElCsSocketTimeout(final String elCsSocketTimeout) {
    properties.put(EL_CS_SOCKET_TIMEOUT_PROPERTY, elCsSocketTimeout);
    return this;
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when waiting for a response.
   */
  public final ElasticSearchClientServiceImpl removeElCsSocketTimeout() {
    properties.remove(EL_CS_SOCKET_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when retrying the operation.
   */
  public final String getElCsRetryTimeout() {
    return properties.get(EL_CS_RETRY_TIMEOUT_PROPERTY);
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when retrying the operation.
   */
  public final ElasticSearchClientServiceImpl setElCsRetryTimeout(final String elCsRetryTimeout) {
    properties.put(EL_CS_RETRY_TIMEOUT_PROPERTY, elCsRetryTimeout);
    return this;
  }

  /**
   * Controls the amount of time, in milliseconds, before a timeout occurs when retrying the operation.
   */
  public final ElasticSearchClientServiceImpl removeElCsRetryTimeout() {
    properties.remove(EL_CS_RETRY_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The charset to use for interpreting the response from ElasticSearch.
   */
  public final String getElCsCharset() {
    return properties.get(EL_CS_CHARSET_PROPERTY);
  }

  /**
   * The charset to use for interpreting the response from ElasticSearch.
   */
  public final ElasticSearchClientServiceImpl setElCsCharset(final String elCsCharset) {
    properties.put(EL_CS_CHARSET_PROPERTY, elCsCharset);
    return this;
  }

  /**
   * The charset to use for interpreting the response from ElasticSearch.
   */
  public final ElasticSearchClientServiceImpl removeElCsCharset() {
    properties.remove(EL_CS_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ElasticSearchClientServiceImpl setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final ElasticSearchClientServiceImpl removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ElasticSearchClientServiceImpl, ElasticSearchClientServiceImpl> configurator) {
    return configurator.apply(new ElasticSearchClientServiceImpl()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ElasticSearchClientServiceImpl.class) final Closure<ElasticSearchClientServiceImpl> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.elasticsearch.ElasticSearchClientServiceImpl> code = closure.rehydrate(c, com.tibtech.nifi.elasticsearch.ElasticSearchClientServiceImpl.class, com.tibtech.nifi.elasticsearch.ElasticSearchClientServiceImpl.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ElasticSearchClientServiceImpl, ElasticSearchClientServiceImpl> configurator) {
    return configurator.apply(new ElasticSearchClientServiceImpl(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ElasticSearchClientServiceImpl.class) final Closure<ElasticSearchClientServiceImpl> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.elasticsearch.ElasticSearchClientServiceImpl> code = closure.rehydrate(c, com.tibtech.nifi.elasticsearch.ElasticSearchClientServiceImpl.class, com.tibtech.nifi.elasticsearch.ElasticSearchClientServiceImpl.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
