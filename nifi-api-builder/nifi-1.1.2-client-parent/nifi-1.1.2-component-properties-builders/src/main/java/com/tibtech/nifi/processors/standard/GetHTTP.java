package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetHTTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.GetHTTP";

  /**
   * The URL to pull from
   */
  public static final String URL_PROPERTY = "URL";

  /**
   * The filename to assign to the file when pulled
   */
  public static final String FILENAME_PROPERTY = "Filename";

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Username required to access the URL
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password required to access the URL
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public static final String USER_AGENT_PROPERTY = "User Agent";

  /**
   * If specified, requests will only accept the provided Content-Type
   */
  public static final String ACCEPT_CONTENT_TYPE_PROPERTY = "Accept Content-Type";

  /**
   * If we receive a 3xx HTTP Status Code from the server, indicates whether or not we should follow the redirect that the server specifies
   */
  public static final String FOLLOW_REDIRECTS_PROPERTY = "Follow Redirects";

  /**
   * When a HTTP server responds to a request with a redirect, this is the cookie policy used to copy cookies to the following request.
   */
  public static final String REDIRECT_COOKIE_POLICY_PROPERTY = "redirect-cookie-policy";

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * The port of the proxy server
   */
  public static final String PROXY_PORT_PROPERTY = "Proxy Port";

  private final Map<String, String> properties;

  public GetHTTP() {
    this.properties = new HashMap<>();
  }

  public GetHTTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The URL to pull from
   */
  public final String getUrl() {
    return properties.get(URL_PROPERTY);
  }

  /**
   * The URL to pull from
   */
  public final GetHTTP setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * The URL to pull from
   */
  public final GetHTTP removeUrl() {
    properties.remove(URL_PROPERTY);
    return this;
  }

  /**
   * The filename to assign to the file when pulled
   */
  public final String getFilename() {
    return properties.get(FILENAME_PROPERTY);
  }

  /**
   * The filename to assign to the file when pulled
   */
  public final GetHTTP setFilename(final String filename) {
    properties.put(FILENAME_PROPERTY, filename);
    return this;
  }

  /**
   * The filename to assign to the file when pulled
   */
  public final GetHTTP removeFilename() {
    properties.remove(FILENAME_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final GetHTTP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final GetHTTP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Username required to access the URL
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username required to access the URL
   */
  public final GetHTTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username required to access the URL
   */
  public final GetHTTP removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password required to access the URL
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password required to access the URL
   */
  public final GetHTTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password required to access the URL
   */
  public final GetHTTP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public final GetHTTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public final GetHTTP removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public final String getDataTimeout() {
    return properties.get(DATA_TIMEOUT_PROPERTY);
  }

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public final GetHTTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public final GetHTTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public final String getUserAgent() {
    return properties.get(USER_AGENT_PROPERTY);
  }

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public final GetHTTP setUserAgent(final String userAgent) {
    properties.put(USER_AGENT_PROPERTY, userAgent);
    return this;
  }

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public final GetHTTP removeUserAgent() {
    properties.remove(USER_AGENT_PROPERTY);
    return this;
  }

  /**
   * If specified, requests will only accept the provided Content-Type
   */
  public final String getAcceptContentType() {
    return properties.get(ACCEPT_CONTENT_TYPE_PROPERTY);
  }

  /**
   * If specified, requests will only accept the provided Content-Type
   */
  public final GetHTTP setAcceptContentType(final String acceptContentType) {
    properties.put(ACCEPT_CONTENT_TYPE_PROPERTY, acceptContentType);
    return this;
  }

  /**
   * If specified, requests will only accept the provided Content-Type
   */
  public final GetHTTP removeAcceptContentType() {
    properties.remove(ACCEPT_CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * If we receive a 3xx HTTP Status Code from the server, indicates whether or not we should follow the redirect that the server specifies
   */
  public final String getFollowRedirects() {
    return properties.get(FOLLOW_REDIRECTS_PROPERTY);
  }

  /**
   * If we receive a 3xx HTTP Status Code from the server, indicates whether or not we should follow the redirect that the server specifies
   */
  public final GetHTTP setFollowRedirects(final String followRedirects) {
    properties.put(FOLLOW_REDIRECTS_PROPERTY, followRedirects);
    return this;
  }

  /**
   * If we receive a 3xx HTTP Status Code from the server, indicates whether or not we should follow the redirect that the server specifies
   */
  public final GetHTTP removeFollowRedirects() {
    properties.remove(FOLLOW_REDIRECTS_PROPERTY);
    return this;
  }

  /**
   * When a HTTP server responds to a request with a redirect, this is the cookie policy used to copy cookies to the following request.
   */
  public final String getRedirectCookiePolicy() {
    return properties.get(REDIRECT_COOKIE_POLICY_PROPERTY);
  }

  /**
   * When a HTTP server responds to a request with a redirect, this is the cookie policy used to copy cookies to the following request.
   */
  public final GetHTTP setRedirectCookiePolicy(final String redirectCookiePolicy) {
    properties.put(REDIRECT_COOKIE_POLICY_PROPERTY, redirectCookiePolicy);
    return this;
  }

  /**
   * When a HTTP server responds to a request with a redirect, this is the cookie policy used to copy cookies to the following request.
   */
  public final GetHTTP removeRedirectCookiePolicy() {
    properties.remove(REDIRECT_COOKIE_POLICY_PROPERTY);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final String getProxyHost() {
    return properties.get(PROXY_HOST_PROPERTY);
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final GetHTTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final GetHTTP removeProxyHost() {
    properties.remove(PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final String getProxyPort() {
    return properties.get(PROXY_PORT_PROPERTY);
  }

  /**
   * The port of the proxy server
   */
  public final GetHTTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final GetHTTP removeProxyPort() {
    properties.remove(PROXY_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetHTTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetHTTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetHTTP, GetHTTP> configurator) {
    return configurator.apply(new GetHTTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHTTP.class) final Closure<GetHTTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetHTTP.class, com.tibtech.nifi.processors.standard.GetHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetHTTP, GetHTTP> configurator) {
    return configurator.apply(new GetHTTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHTTP.class) final Closure<GetHTTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetHTTP.class, com.tibtech.nifi.processors.standard.GetHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
