package com.tibtech.nifi.ssl;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StandardSSLContextService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.ssl.StandardSSLContextService";

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
   * The algorithm to use for this SSL context
   */
  public static final String SSL_PROTOCOL_PROPERTY = "SSL Protocol";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The fully-qualified filename of the Keystore
   */
  public final String getKeystoreFilename() {
    return properties.get(KEYSTORE_FILENAME_PROPERTY);
  }

  /**
   * The fully-qualified filename of the Keystore
   */
  public final StandardSSLContextService setKeystoreFilename(final String keystoreFilename) {
    properties.put(KEYSTORE_FILENAME_PROPERTY, keystoreFilename);
    return this;
  }

  /**
   * The fully-qualified filename of the Keystore
   */
  public final StandardSSLContextService removeKeystoreFilename() {
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
  public final StandardSSLContextService setKeystorePassword(final String keystorePassword) {
    properties.put(KEYSTORE_PASSWORD_PROPERTY, keystorePassword);
    return this;
  }

  /**
   * The password for the Keystore
   */
  public final StandardSSLContextService removeKeystorePassword() {
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
  public final StandardSSLContextService setKeyPassword(final String keyPassword) {
    properties.put(KEY_PASSWORD_PROPERTY, keyPassword);
    return this;
  }

  /**
   * The password for the key. If this is not specified, but the Keystore Filename, Password, and Type are specified, then the Keystore Password will be assumed to be the same as the Key Password.
   */
  public final StandardSSLContextService removeKeyPassword() {
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
  public final StandardSSLContextService setKeystoreType(final String keystoreType) {
    properties.put(KEYSTORE_TYPE_PROPERTY, keystoreType);
    return this;
  }

  /**
   * The Type of the Keystore
   */
  public final StandardSSLContextService removeKeystoreType() {
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
  public final StandardSSLContextService setTruststoreFilename(final String truststoreFilename) {
    properties.put(TRUSTSTORE_FILENAME_PROPERTY, truststoreFilename);
    return this;
  }

  /**
   * The fully-qualified filename of the Truststore
   */
  public final StandardSSLContextService removeTruststoreFilename() {
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
  public final StandardSSLContextService setTruststorePassword(final String truststorePassword) {
    properties.put(TRUSTSTORE_PASSWORD_PROPERTY, truststorePassword);
    return this;
  }

  /**
   * The password for the Truststore
   */
  public final StandardSSLContextService removeTruststorePassword() {
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
  public final StandardSSLContextService setTruststoreType(final String truststoreType) {
    properties.put(TRUSTSTORE_TYPE_PROPERTY, truststoreType);
    return this;
  }

  /**
   * The Type of the Truststore. Either JKS or PKCS12
   */
  public final StandardSSLContextService removeTruststoreType() {
    properties.remove(TRUSTSTORE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The algorithm to use for this SSL context
   */
  public final String getSslProtocol() {
    return properties.get(SSL_PROTOCOL_PROPERTY);
  }

  /**
   * The algorithm to use for this SSL context
   */
  public final StandardSSLContextService setSslProtocol(final String sslProtocol) {
    properties.put(SSL_PROTOCOL_PROPERTY, sslProtocol);
    return this;
  }

  /**
   * The algorithm to use for this SSL context
   */
  public final StandardSSLContextService removeSslProtocol() {
    properties.remove(SSL_PROTOCOL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final StandardSSLContextService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final StandardSSLContextService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<StandardSSLContextService, StandardSSLContextService> configurator) {
    return configurator.apply(new StandardSSLContextService()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardSSLContextService.class) final Closure<StandardSSLContextService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.ssl.StandardSSLContextService> code = closure.rehydrate(c, com.tibtech.nifi.ssl.StandardSSLContextService.class, com.tibtech.nifi.ssl.StandardSSLContextService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
