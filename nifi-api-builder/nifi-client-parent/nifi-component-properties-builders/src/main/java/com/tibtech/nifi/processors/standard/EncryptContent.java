package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class EncryptContent {
  /**
   * Specifies whether the content should be encrypted or decrypted
   */
  public static final String MODE_PROPERTY = "Mode";

  /**
   * Specifies the key derivation function to generate the key from the password (and salt)
   */
  public static final String KEY_DERIVATION_FUNCTION_PROPERTY = "key-derivation-function";

  /**
   * The Encryption Algorithm to use
   */
  public static final String ENCRYPTION_ALGORITHM_PROPERTY = "Encryption Algorithm";

  /**
   * Overrides the default behavior to prevent unsafe combinations of encryption algorithms and short passwords on JVMs with limited strength cryptographic jurisdiction policies
   */
  public static final String ALLOW_WEAK_CRYPTO_PROPERTY = "allow-weak-crypto";

  /**
   * The Password to use for encrypting or decrypting the data
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * In keyed encryption, this is the raw key, encoded in hexadecimal
   */
  public static final String RAW_KEY_HEX_PROPERTY = "raw-key-hex";

  /**
   * In a PGP encrypt mode, this keyring contains the public key of the recipient
   */
  public static final String PUBLIC_KEYRING_FILE_PROPERTY = "public-keyring-file";

  /**
   * In a PGP encrypt mode, this user id of the recipient
   */
  public static final String PUBLIC_KEY_USER_ID_PROPERTY = "public-key-user-id";

  /**
   * In a PGP decrypt mode, this keyring contains the private key of the recipient
   */
  public static final String PRIVATE_KEYRING_FILE_PROPERTY = "private-keyring-file";

  /**
   * In a PGP decrypt mode, this is the private keyring passphrase
   */
  public static final String PRIVATE_KEYRING_PASSPHRASE_PROPERTY = "private-keyring-passphrase";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies whether the content should be encrypted or decrypted
   */
  public final String getMode() {
    return properties.get(MODE_PROPERTY);
  }

  /**
   * Specifies whether the content should be encrypted or decrypted
   */
  public final EncryptContent setMode(final String mode) {
    properties.put(MODE_PROPERTY, mode);
    return this;
  }

  /**
   * Specifies whether the content should be encrypted or decrypted
   */
  public final EncryptContent removeMode() {
    properties.remove(MODE_PROPERTY);
    return this;
  }

  /**
   * Specifies the key derivation function to generate the key from the password (and salt)
   */
  public final String getKeyDerivationFunction() {
    return properties.get(KEY_DERIVATION_FUNCTION_PROPERTY);
  }

  /**
   * Specifies the key derivation function to generate the key from the password (and salt)
   */
  public final EncryptContent setKeyDerivationFunction(final String keyDerivationFunction) {
    properties.put(KEY_DERIVATION_FUNCTION_PROPERTY, keyDerivationFunction);
    return this;
  }

  /**
   * Specifies the key derivation function to generate the key from the password (and salt)
   */
  public final EncryptContent removeKeyDerivationFunction() {
    properties.remove(KEY_DERIVATION_FUNCTION_PROPERTY);
    return this;
  }

  /**
   * The Encryption Algorithm to use
   */
  public final String getEncryptionAlgorithm() {
    return properties.get(ENCRYPTION_ALGORITHM_PROPERTY);
  }

  /**
   * The Encryption Algorithm to use
   */
  public final EncryptContent setEncryptionAlgorithm(final String encryptionAlgorithm) {
    properties.put(ENCRYPTION_ALGORITHM_PROPERTY, encryptionAlgorithm);
    return this;
  }

  /**
   * The Encryption Algorithm to use
   */
  public final EncryptContent removeEncryptionAlgorithm() {
    properties.remove(ENCRYPTION_ALGORITHM_PROPERTY);
    return this;
  }

  /**
   * Overrides the default behavior to prevent unsafe combinations of encryption algorithms and short passwords on JVMs with limited strength cryptographic jurisdiction policies
   */
  public final String getAllowWeakCrypto() {
    return properties.get(ALLOW_WEAK_CRYPTO_PROPERTY);
  }

  /**
   * Overrides the default behavior to prevent unsafe combinations of encryption algorithms and short passwords on JVMs with limited strength cryptographic jurisdiction policies
   */
  public final EncryptContent setAllowWeakCrypto(final String allowWeakCrypto) {
    properties.put(ALLOW_WEAK_CRYPTO_PROPERTY, allowWeakCrypto);
    return this;
  }

  /**
   * Overrides the default behavior to prevent unsafe combinations of encryption algorithms and short passwords on JVMs with limited strength cryptographic jurisdiction policies
   */
  public final EncryptContent removeAllowWeakCrypto() {
    properties.remove(ALLOW_WEAK_CRYPTO_PROPERTY);
    return this;
  }

  /**
   * The Password to use for encrypting or decrypting the data
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * The Password to use for encrypting or decrypting the data
   */
  public final EncryptContent setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The Password to use for encrypting or decrypting the data
   */
  public final EncryptContent removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * In keyed encryption, this is the raw key, encoded in hexadecimal
   */
  public final String getRawKeyHex() {
    return properties.get(RAW_KEY_HEX_PROPERTY);
  }

  /**
   * In keyed encryption, this is the raw key, encoded in hexadecimal
   */
  public final EncryptContent setRawKeyHex(final String rawKeyHex) {
    properties.put(RAW_KEY_HEX_PROPERTY, rawKeyHex);
    return this;
  }

  /**
   * In keyed encryption, this is the raw key, encoded in hexadecimal
   */
  public final EncryptContent removeRawKeyHex() {
    properties.remove(RAW_KEY_HEX_PROPERTY);
    return this;
  }

  /**
   * In a PGP encrypt mode, this keyring contains the public key of the recipient
   */
  public final String getPublicKeyringFile() {
    return properties.get(PUBLIC_KEYRING_FILE_PROPERTY);
  }

  /**
   * In a PGP encrypt mode, this keyring contains the public key of the recipient
   */
  public final EncryptContent setPublicKeyringFile(final String publicKeyringFile) {
    properties.put(PUBLIC_KEYRING_FILE_PROPERTY, publicKeyringFile);
    return this;
  }

  /**
   * In a PGP encrypt mode, this keyring contains the public key of the recipient
   */
  public final EncryptContent removePublicKeyringFile() {
    properties.remove(PUBLIC_KEYRING_FILE_PROPERTY);
    return this;
  }

  /**
   * In a PGP encrypt mode, this user id of the recipient
   */
  public final String getPublicKeyUserId() {
    return properties.get(PUBLIC_KEY_USER_ID_PROPERTY);
  }

  /**
   * In a PGP encrypt mode, this user id of the recipient
   */
  public final EncryptContent setPublicKeyUserId(final String publicKeyUserId) {
    properties.put(PUBLIC_KEY_USER_ID_PROPERTY, publicKeyUserId);
    return this;
  }

  /**
   * In a PGP encrypt mode, this user id of the recipient
   */
  public final EncryptContent removePublicKeyUserId() {
    properties.remove(PUBLIC_KEY_USER_ID_PROPERTY);
    return this;
  }

  /**
   * In a PGP decrypt mode, this keyring contains the private key of the recipient
   */
  public final String getPrivateKeyringFile() {
    return properties.get(PRIVATE_KEYRING_FILE_PROPERTY);
  }

  /**
   * In a PGP decrypt mode, this keyring contains the private key of the recipient
   */
  public final EncryptContent setPrivateKeyringFile(final String privateKeyringFile) {
    properties.put(PRIVATE_KEYRING_FILE_PROPERTY, privateKeyringFile);
    return this;
  }

  /**
   * In a PGP decrypt mode, this keyring contains the private key of the recipient
   */
  public final EncryptContent removePrivateKeyringFile() {
    properties.remove(PRIVATE_KEYRING_FILE_PROPERTY);
    return this;
  }

  /**
   * In a PGP decrypt mode, this is the private keyring passphrase
   */
  public final String getPrivateKeyringPassphrase() {
    return properties.get(PRIVATE_KEYRING_PASSPHRASE_PROPERTY);
  }

  /**
   * In a PGP decrypt mode, this is the private keyring passphrase
   */
  public final EncryptContent setPrivateKeyringPassphrase(final String privateKeyringPassphrase) {
    properties.put(PRIVATE_KEYRING_PASSPHRASE_PROPERTY, privateKeyringPassphrase);
    return this;
  }

  /**
   * In a PGP decrypt mode, this is the private keyring passphrase
   */
  public final EncryptContent removePrivateKeyringPassphrase() {
    properties.remove(PRIVATE_KEYRING_PASSPHRASE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final EncryptContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final EncryptContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<EncryptContent, EncryptContent> configurator) {
    return configurator.apply(new EncryptContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EncryptContent.class) final Closure<EncryptContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.EncryptContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.EncryptContent.class, com.tibtech.nifi.processors.standard.EncryptContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
