package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RestLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.RestLookupService";

  /**
   * The URL for the REST endpoint. Expression language is evaluated against the lookup key/value pairs, not flowfile attributes.
   */
  public static final String REST_LOOKUP_URL_PROPERTY = "rest-lookup-url";

  /**
   * The record reader to use for loading the payload and handling it as a record set.
   */
  public static final String REST_LOOKUP_RECORD_READER_PROPERTY = "rest-lookup-record-reader";

  /**
   * An optional record path that can be used to define where in a record to get the real data to merge into the record set to be enriched. See documentation for examples of when this might be useful.
   */
  public static final String REST_LOOKUP_RECORD_PATH_PROPERTY = "rest-lookup-record-path";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String REST_LOOKUP_SSL_CONTEXT_SERVICE_PROPERTY = "rest-lookup-ssl-context-service";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public static final String REST_LOOKUP_BASIC_AUTH_USERNAME_PROPERTY = "rest-lookup-basic-auth-username";

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public static final String REST_LOOKUP_BASIC_AUTH_PASSWORD_PROPERTY = "rest-lookup-basic-auth-password";

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public static final String REST_LOOKUP_DIGEST_AUTH_PROPERTY = "rest-lookup-digest-auth";

  private final Map<String, String> properties;

  public RestLookupService() {
    this.properties = new HashMap<>();
  }

  public RestLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The URL for the REST endpoint. Expression language is evaluated against the lookup key/value pairs, not flowfile attributes.
   */
  public final String getRestLookupUrl() {
    return properties.get(REST_LOOKUP_URL_PROPERTY);
  }

  /**
   * The URL for the REST endpoint. Expression language is evaluated against the lookup key/value pairs, not flowfile attributes.
   */
  public final RestLookupService setRestLookupUrl(final String restLookupUrl) {
    properties.put(REST_LOOKUP_URL_PROPERTY, restLookupUrl);
    return this;
  }

  /**
   * The URL for the REST endpoint. Expression language is evaluated against the lookup key/value pairs, not flowfile attributes.
   */
  public final RestLookupService removeRestLookupUrl() {
    properties.remove(REST_LOOKUP_URL_PROPERTY);
    return this;
  }

  /**
   * The record reader to use for loading the payload and handling it as a record set.
   */
  public final String getRestLookupRecordReader() {
    return properties.get(REST_LOOKUP_RECORD_READER_PROPERTY);
  }

  /**
   * The record reader to use for loading the payload and handling it as a record set.
   */
  public final RestLookupService setRestLookupRecordReader(final String restLookupRecordReader) {
    properties.put(REST_LOOKUP_RECORD_READER_PROPERTY, restLookupRecordReader);
    return this;
  }

  /**
   * The record reader to use for loading the payload and handling it as a record set.
   */
  public final RestLookupService removeRestLookupRecordReader() {
    properties.remove(REST_LOOKUP_RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * An optional record path that can be used to define where in a record to get the real data to merge into the record set to be enriched. See documentation for examples of when this might be useful.
   */
  public final String getRestLookupRecordPath() {
    return properties.get(REST_LOOKUP_RECORD_PATH_PROPERTY);
  }

  /**
   * An optional record path that can be used to define where in a record to get the real data to merge into the record set to be enriched. See documentation for examples of when this might be useful.
   */
  public final RestLookupService setRestLookupRecordPath(final String restLookupRecordPath) {
    properties.put(REST_LOOKUP_RECORD_PATH_PROPERTY, restLookupRecordPath);
    return this;
  }

  /**
   * An optional record path that can be used to define where in a record to get the real data to merge into the record set to be enriched. See documentation for examples of when this might be useful.
   */
  public final RestLookupService removeRestLookupRecordPath() {
    properties.remove(REST_LOOKUP_RECORD_PATH_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final String getRestLookupSslContextService() {
    return properties.get(REST_LOOKUP_SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final RestLookupService setRestLookupSslContextService(
      final String restLookupSslContextService) {
    properties.put(REST_LOOKUP_SSL_CONTEXT_SERVICE_PROPERTY, restLookupSslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final RestLookupService removeRestLookupSslContextService() {
    properties.remove(REST_LOOKUP_SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final RestLookupService setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final RestLookupService removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public final String getRestLookupBasicAuthUsername() {
    return properties.get(REST_LOOKUP_BASIC_AUTH_USERNAME_PROPERTY);
  }

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public final RestLookupService setRestLookupBasicAuthUsername(
      final String restLookupBasicAuthUsername) {
    properties.put(REST_LOOKUP_BASIC_AUTH_USERNAME_PROPERTY, restLookupBasicAuthUsername);
    return this;
  }

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public final RestLookupService removeRestLookupBasicAuthUsername() {
    properties.remove(REST_LOOKUP_BASIC_AUTH_USERNAME_PROPERTY);
    return this;
  }

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public final String getRestLookupBasicAuthPassword() {
    return properties.get(REST_LOOKUP_BASIC_AUTH_PASSWORD_PROPERTY);
  }

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public final RestLookupService setRestLookupBasicAuthPassword(
      final String restLookupBasicAuthPassword) {
    properties.put(REST_LOOKUP_BASIC_AUTH_PASSWORD_PROPERTY, restLookupBasicAuthPassword);
    return this;
  }

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public final RestLookupService removeRestLookupBasicAuthPassword() {
    properties.remove(REST_LOOKUP_BASIC_AUTH_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public final String getRestLookupDigestAuth() {
    return properties.get(REST_LOOKUP_DIGEST_AUTH_PROPERTY);
  }

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public final RestLookupService setRestLookupDigestAuth(final String restLookupDigestAuth) {
    properties.put(REST_LOOKUP_DIGEST_AUTH_PROPERTY, restLookupDigestAuth);
    return this;
  }

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public final RestLookupService removeRestLookupDigestAuth() {
    properties.remove(REST_LOOKUP_DIGEST_AUTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RestLookupService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final RestLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<RestLookupService, RestLookupService> configurator) {
    return configurator.apply(new RestLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RestLookupService.class) final Closure<RestLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.RestLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.RestLookupService.class, com.tibtech.nifi.lookup.RestLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<RestLookupService, RestLookupService> configurator) {
    return configurator.apply(new RestLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RestLookupService.class) final Closure<RestLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.RestLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.RestLookupService.class, com.tibtech.nifi.lookup.RestLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
