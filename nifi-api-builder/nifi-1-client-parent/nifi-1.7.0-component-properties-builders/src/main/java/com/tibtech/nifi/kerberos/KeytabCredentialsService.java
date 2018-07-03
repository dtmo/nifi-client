package com.tibtech.nifi.kerberos;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class KeytabCredentialsService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.kerberos.KeytabCredentialsService";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  private final Map<String, String> properties;

  public KeytabCredentialsService() {
    this.properties = new HashMap<>();
  }

  public KeytabCredentialsService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosKeytab() {
    return properties.get(KERBEROS_KEYTAB_PROPERTY);
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final KeytabCredentialsService setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final KeytabCredentialsService removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosPrincipal() {
    return properties.get(KERBEROS_PRINCIPAL_PROPERTY);
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final KeytabCredentialsService setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final KeytabCredentialsService removeKerberosPrincipal() {
    properties.remove(KERBEROS_PRINCIPAL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final KeytabCredentialsService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final KeytabCredentialsService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<KeytabCredentialsService, KeytabCredentialsService> configurator) {
    return configurator.apply(new KeytabCredentialsService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = KeytabCredentialsService.class) final Closure<KeytabCredentialsService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.kerberos.KeytabCredentialsService> code = closure.rehydrate(c, com.tibtech.nifi.kerberos.KeytabCredentialsService.class, com.tibtech.nifi.kerberos.KeytabCredentialsService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<KeytabCredentialsService, KeytabCredentialsService> configurator) {
    return configurator.apply(new KeytabCredentialsService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = KeytabCredentialsService.class) final Closure<KeytabCredentialsService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.kerberos.KeytabCredentialsService> code = closure.rehydrate(c, com.tibtech.nifi.kerberos.KeytabCredentialsService.class, com.tibtech.nifi.kerberos.KeytabCredentialsService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
