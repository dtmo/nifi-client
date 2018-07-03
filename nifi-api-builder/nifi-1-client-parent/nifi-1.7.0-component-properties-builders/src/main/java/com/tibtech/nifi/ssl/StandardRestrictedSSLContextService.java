package com.tibtech.nifi.ssl;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StandardRestrictedSSLContextService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.ssl.StandardRestrictedSSLContextService";

  /**
   * The fully-qualified filename of the Keystore
   */
  public static final String KEYSTORE_FILENAME_PROPERTY = "Keystore Filename";

  /**
   * The password for the Keystore
   */
  public static final String KEYSTORE_PASSWORD_PROPERTY = "Keystore Password";

  /**
   * The password for the key. If this is not specified, but the Keystore Filename, Password, and Type are specified, then the Keystore Password will be assumed to be the same as the Key Password.
   */
  public static final String KEY_PASSWORD_PROPERTY = "key-password";

  /**
   * The Type of the Keystore
   */
  public static final String KEYSTORE_TYPE_PROPERTY = "Keystore Type";

  /**
   * The fully-qualified filename of the Truststore
   */
  public static final String TRUSTSTORE_FILENAME_PROPERTY = "Truststore Filename";

  /**
   * The password for the Truststore
   */
  public static final String TRUSTSTORE_PASSWORD_PROPERTY = "Truststore Password";

  /**
   * The Type of the Truststore. Either JKS or PKCS12
   */
  public static final String TRUSTSTORE_TYPE_PROPERTY = "Truststore Type";

  /**
   * The algorithm to use for this SSL context. By default, this will choose the highest supported TLS protocol version.
   */
  public static final String SSL_PROTOCOL_PROPERTY = "SSL Protocol";

  private final Map<String, String> properties;

  public StandardRestrictedSSLContextService() {
    this.properties = new HashMap<>();
  }

  public StandardRestrictedSSLContextService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The fully-qualified filename of the Keystore
   */
  public final String getKeystoreFilename() {
    return properties.get(KEYSTORE_FILENAME_PROPERTY);
  }

  /**
   * The fully-qualified filename of the Keystore
   */
  public final StandardRestrictedSSLContextService setKeystoreFilename(
      final String keystoreFilename) {
    properties.put(KEYSTORE_FILENAME_PROPERTY, keystoreFilename);
    return this;
  }

  /**
   * The fully-qualified filename of the Keystore
   */
  public final StandardRestrictedSSLContextService removeKeystoreFilename() {
    properties.remove(KEYSTORE_FILENAME_PROPERTY);
    return this;
  }

  /**
   * The password for the Keystore
   */
  public final String getKeystorePassword() {
    return properties.get(KEYSTORE_PASSWORD_PROPERTY);
  }

  /**
   * The password for the Keystore
   */
  public final StandardRestrictedSSLContextService setKeystorePassword(
      final String keystorePassword) {
    properties.put(KEYSTORE_PASSWORD_PROPERTY, keystorePassword);
    return this;
  }

  /**
   * The password for the Keystore
   */
  public final StandardRestrictedSSLContextService removeKeystorePassword() {
    properties.remove(KEYSTORE_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The password for the key. If this is not specified, but the Keystore Filename, Password, and Type are specified, then the Keystore Password will be assumed to be the same as the Key Password.
   */
  public final String getKeyPassword() {
    return properties.get(KEY_PASSWORD_PROPERTY);
  }

  /**
   * The password for the key. If this is not specified, but the Keystore Filename, Password, and Type are specified, then the Keystore Password will be assumed to be the same as the Key Password.
   */
  public final StandardRestrictedSSLContextService setKeyPassword(final String keyPassword) {
    properties.put(KEY_PASSWORD_PROPERTY, keyPassword);
    return this;
  }

  /**
   * The password for the key. If this is not specified, but the Keystore Filename, Password, and Type are specified, then the Keystore Password will be assumed to be the same as the Key Password.
   */
  public final StandardRestrictedSSLContextService removeKeyPassword() {
    properties.remove(KEY_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The Type of the Keystore
   */
  public final String getKeystoreType() {
    return properties.get(KEYSTORE_TYPE_PROPERTY);
  }

  /**
   * The Type of the Keystore
   */
  public final StandardRestrictedSSLContextService setKeystoreType(final String keystoreType) {
    properties.put(KEYSTORE_TYPE_PROPERTY, keystoreType);
    return this;
  }

  /**
   * The Type of the Keystore
   */
  public final StandardRestrictedSSLContextService removeKeystoreType() {
    properties.remove(KEYSTORE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The fully-qualified filename of the Truststore
   */
  public final String getTruststoreFilename() {
    return properties.get(TRUSTSTORE_FILENAME_PROPERTY);
  }

  /**
   * The fully-qualified filename of the Truststore
   */
  public final StandardRestrictedSSLContextService setTruststoreFilename(
      final String truststoreFilename) {
    properties.put(TRUSTSTORE_FILENAME_PROPERTY, truststoreFilename);
    return this;
  }

  /**
   * The fully-qualified filename of the Truststore
   */
  public final StandardRestrictedSSLContextService removeTruststoreFilename() {
    properties.remove(TRUSTSTORE_FILENAME_PROPERTY);
    return this;
  }

  /**
   * The password for the Truststore
   */
  public final String getTruststorePassword() {
    return properties.get(TRUSTSTORE_PASSWORD_PROPERTY);
  }

  /**
   * The password for the Truststore
   */
  public final StandardRestrictedSSLContextService setTruststorePassword(
      final String truststorePassword) {
    properties.put(TRUSTSTORE_PASSWORD_PROPERTY, truststorePassword);
    return this;
  }

  /**
   * The password for the Truststore
   */
  public final StandardRestrictedSSLContextService removeTruststorePassword() {
    properties.remove(TRUSTSTORE_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The Type of the Truststore. Either JKS or PKCS12
   */
  public final String getTruststoreType() {
    return properties.get(TRUSTSTORE_TYPE_PROPERTY);
  }

  /**
   * The Type of the Truststore. Either JKS or PKCS12
   */
  public final StandardRestrictedSSLContextService setTruststoreType(final String truststoreType) {
    properties.put(TRUSTSTORE_TYPE_PROPERTY, truststoreType);
    return this;
  }

  /**
   * The Type of the Truststore. Either JKS or PKCS12
   */
  public final StandardRestrictedSSLContextService removeTruststoreType() {
    properties.remove(TRUSTSTORE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The algorithm to use for this SSL context. By default, this will choose the highest supported TLS protocol version.
   */
  public final String getSslProtocol() {
    return properties.get(SSL_PROTOCOL_PROPERTY);
  }

  /**
   * The algorithm to use for this SSL context. By default, this will choose the highest supported TLS protocol version.
   */
  public final StandardRestrictedSSLContextService setSslProtocol(final String sslProtocol) {
    properties.put(SSL_PROTOCOL_PROPERTY, sslProtocol);
    return this;
  }

  /**
   * The algorithm to use for this SSL context. By default, this will choose the highest supported TLS protocol version.
   */
  public final StandardRestrictedSSLContextService removeSslProtocol() {
    properties.remove(SSL_PROTOCOL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final StandardRestrictedSSLContextService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final StandardRestrictedSSLContextService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<StandardRestrictedSSLContextService, StandardRestrictedSSLContextService> configurator) {
    return configurator.apply(new StandardRestrictedSSLContextService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardRestrictedSSLContextService.class) final Closure<StandardRestrictedSSLContextService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.ssl.StandardRestrictedSSLContextService> code = closure.rehydrate(c, com.tibtech.nifi.ssl.StandardRestrictedSSLContextService.class, com.tibtech.nifi.ssl.StandardRestrictedSSLContextService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<StandardRestrictedSSLContextService, StandardRestrictedSSLContextService> configurator) {
    return configurator.apply(new StandardRestrictedSSLContextService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardRestrictedSSLContextService.class) final Closure<StandardRestrictedSSLContextService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.ssl.StandardRestrictedSSLContextService> code = closure.rehydrate(c, com.tibtech.nifi.ssl.StandardRestrictedSSLContextService.class, com.tibtech.nifi.ssl.StandardRestrictedSSLContextService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
