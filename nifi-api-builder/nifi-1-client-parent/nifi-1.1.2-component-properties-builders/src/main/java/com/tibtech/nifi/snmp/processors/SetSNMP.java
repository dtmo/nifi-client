package com.tibtech.nifi.snmp.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SetSNMP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.snmp.processors.SetSNMP";

  /**
   * Network address of SNMP Agent (e.g., localhost)
   */
  public static final String SNMP_HOSTNAME_PROPERTY = "snmp-hostname";

  /**
   * Numeric value identifying Port of SNMP Agent (e.g., 161)
   */
  public static final String SNMP_PORT_PROPERTY = "snmp-port";

  /**
   * SNMP Version to use
   */
  public static final String SNMP_VERSION_PROPERTY = "snmp-version";

  /**
   * SNMP Community to use (e.g., public)
   */
  public static final String SNMP_COMMUNITY_PROPERTY = "snmp-community";

  /**
   * SNMP Security Level to use
   */
  public static final String SNMP_SECURITY_LEVEL_PROPERTY = "snmp-security-level";

  /**
   * Security name used for SNMP exchanges
   */
  public static final String SNMP_SECURITY_NAME_PROPERTY = "snmp-security-name";

  /**
   * SNMP Authentication Protocol to use
   */
  public static final String SNMP_AUTHENTICATION_PROTOCOL_PROPERTY = "snmp-authentication-protocol";

  /**
   * Pass phrase used for SNMP authentication protocol
   */
  public static final String SNMP_AUTHENTICATION_PASSPHRASE_PROPERTY = "snmp-authentication-passphrase";

  /**
   * SNMP Private Protocol to use
   */
  public static final String SNMP_PRIVATE_PROTOCOL_PROPERTY = "snmp-private-protocol";

  /**
   * Pass phrase used for SNMP private protocol
   */
  public static final String SNMP_PRIVATE_PROTOCOL_PASSPHRASE_PROPERTY = "snmp-private-protocol-passphrase";

  /**
   * Set the number of retries when requesting the SNMP Agent
   */
  public static final String SNMP_RETRIES_PROPERTY = "snmp-retries";

  /**
   * Set the timeout (in milliseconds) when requesting the SNMP Agent
   */
  public static final String SNMP_TIMEOUT_PROPERTY = "snmp-timeout";

  private final Map<String, String> properties;

  public SetSNMP() {
    this.properties = new HashMap<>();
  }

  public SetSNMP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Network address of SNMP Agent (e.g., localhost)
   */
  public final String getSnmpHostname() {
    return properties.get(SNMP_HOSTNAME_PROPERTY);
  }

  /**
   * Network address of SNMP Agent (e.g., localhost)
   */
  public final SetSNMP setSnmpHostname(final String snmpHostname) {
    properties.put(SNMP_HOSTNAME_PROPERTY, snmpHostname);
    return this;
  }

  /**
   * Network address of SNMP Agent (e.g., localhost)
   */
  public final SetSNMP removeSnmpHostname() {
    properties.remove(SNMP_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * Numeric value identifying Port of SNMP Agent (e.g., 161)
   */
  public final String getSnmpPort() {
    return properties.get(SNMP_PORT_PROPERTY);
  }

  /**
   * Numeric value identifying Port of SNMP Agent (e.g., 161)
   */
  public final SetSNMP setSnmpPort(final String snmpPort) {
    properties.put(SNMP_PORT_PROPERTY, snmpPort);
    return this;
  }

  /**
   * Numeric value identifying Port of SNMP Agent (e.g., 161)
   */
  public final SetSNMP removeSnmpPort() {
    properties.remove(SNMP_PORT_PROPERTY);
    return this;
  }

  /**
   * SNMP Version to use
   */
  public final String getSnmpVersion() {
    return properties.get(SNMP_VERSION_PROPERTY);
  }

  /**
   * SNMP Version to use
   */
  public final SetSNMP setSnmpVersion(final String snmpVersion) {
    properties.put(SNMP_VERSION_PROPERTY, snmpVersion);
    return this;
  }

  /**
   * SNMP Version to use
   */
  public final SetSNMP removeSnmpVersion() {
    properties.remove(SNMP_VERSION_PROPERTY);
    return this;
  }

  /**
   * SNMP Community to use (e.g., public)
   */
  public final String getSnmpCommunity() {
    return properties.get(SNMP_COMMUNITY_PROPERTY);
  }

  /**
   * SNMP Community to use (e.g., public)
   */
  public final SetSNMP setSnmpCommunity(final String snmpCommunity) {
    properties.put(SNMP_COMMUNITY_PROPERTY, snmpCommunity);
    return this;
  }

  /**
   * SNMP Community to use (e.g., public)
   */
  public final SetSNMP removeSnmpCommunity() {
    properties.remove(SNMP_COMMUNITY_PROPERTY);
    return this;
  }

  /**
   * SNMP Security Level to use
   */
  public final String getSnmpSecurityLevel() {
    return properties.get(SNMP_SECURITY_LEVEL_PROPERTY);
  }

  /**
   * SNMP Security Level to use
   */
  public final SetSNMP setSnmpSecurityLevel(final String snmpSecurityLevel) {
    properties.put(SNMP_SECURITY_LEVEL_PROPERTY, snmpSecurityLevel);
    return this;
  }

  /**
   * SNMP Security Level to use
   */
  public final SetSNMP removeSnmpSecurityLevel() {
    properties.remove(SNMP_SECURITY_LEVEL_PROPERTY);
    return this;
  }

  /**
   * Security name used for SNMP exchanges
   */
  public final String getSnmpSecurityName() {
    return properties.get(SNMP_SECURITY_NAME_PROPERTY);
  }

  /**
   * Security name used for SNMP exchanges
   */
  public final SetSNMP setSnmpSecurityName(final String snmpSecurityName) {
    properties.put(SNMP_SECURITY_NAME_PROPERTY, snmpSecurityName);
    return this;
  }

  /**
   * Security name used for SNMP exchanges
   */
  public final SetSNMP removeSnmpSecurityName() {
    properties.remove(SNMP_SECURITY_NAME_PROPERTY);
    return this;
  }

  /**
   * SNMP Authentication Protocol to use
   */
  public final String getSnmpAuthenticationProtocol() {
    return properties.get(SNMP_AUTHENTICATION_PROTOCOL_PROPERTY);
  }

  /**
   * SNMP Authentication Protocol to use
   */
  public final SetSNMP setSnmpAuthenticationProtocol(final String snmpAuthenticationProtocol) {
    properties.put(SNMP_AUTHENTICATION_PROTOCOL_PROPERTY, snmpAuthenticationProtocol);
    return this;
  }

  /**
   * SNMP Authentication Protocol to use
   */
  public final SetSNMP removeSnmpAuthenticationProtocol() {
    properties.remove(SNMP_AUTHENTICATION_PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * Pass phrase used for SNMP authentication protocol
   */
  public final String getSnmpAuthenticationPassphrase() {
    return properties.get(SNMP_AUTHENTICATION_PASSPHRASE_PROPERTY);
  }

  /**
   * Pass phrase used for SNMP authentication protocol
   */
  public final SetSNMP setSnmpAuthenticationPassphrase(final String snmpAuthenticationPassphrase) {
    properties.put(SNMP_AUTHENTICATION_PASSPHRASE_PROPERTY, snmpAuthenticationPassphrase);
    return this;
  }

  /**
   * Pass phrase used for SNMP authentication protocol
   */
  public final SetSNMP removeSnmpAuthenticationPassphrase() {
    properties.remove(SNMP_AUTHENTICATION_PASSPHRASE_PROPERTY);
    return this;
  }

  /**
   * SNMP Private Protocol to use
   */
  public final String getSnmpPrivateProtocol() {
    return properties.get(SNMP_PRIVATE_PROTOCOL_PROPERTY);
  }

  /**
   * SNMP Private Protocol to use
   */
  public final SetSNMP setSnmpPrivateProtocol(final String snmpPrivateProtocol) {
    properties.put(SNMP_PRIVATE_PROTOCOL_PROPERTY, snmpPrivateProtocol);
    return this;
  }

  /**
   * SNMP Private Protocol to use
   */
  public final SetSNMP removeSnmpPrivateProtocol() {
    properties.remove(SNMP_PRIVATE_PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * Pass phrase used for SNMP private protocol
   */
  public final String getSnmpPrivateProtocolPassphrase() {
    return properties.get(SNMP_PRIVATE_PROTOCOL_PASSPHRASE_PROPERTY);
  }

  /**
   * Pass phrase used for SNMP private protocol
   */
  public final SetSNMP setSnmpPrivateProtocolPassphrase(final String snmpPrivateProtocolPassphrase) {
    properties.put(SNMP_PRIVATE_PROTOCOL_PASSPHRASE_PROPERTY, snmpPrivateProtocolPassphrase);
    return this;
  }

  /**
   * Pass phrase used for SNMP private protocol
   */
  public final SetSNMP removeSnmpPrivateProtocolPassphrase() {
    properties.remove(SNMP_PRIVATE_PROTOCOL_PASSPHRASE_PROPERTY);
    return this;
  }

  /**
   * Set the number of retries when requesting the SNMP Agent
   */
  public final String getSnmpRetries() {
    return properties.get(SNMP_RETRIES_PROPERTY);
  }

  /**
   * Set the number of retries when requesting the SNMP Agent
   */
  public final SetSNMP setSnmpRetries(final String snmpRetries) {
    properties.put(SNMP_RETRIES_PROPERTY, snmpRetries);
    return this;
  }

  /**
   * Set the number of retries when requesting the SNMP Agent
   */
  public final SetSNMP removeSnmpRetries() {
    properties.remove(SNMP_RETRIES_PROPERTY);
    return this;
  }

  /**
   * Set the timeout (in milliseconds) when requesting the SNMP Agent
   */
  public final String getSnmpTimeout() {
    return properties.get(SNMP_TIMEOUT_PROPERTY);
  }

  /**
   * Set the timeout (in milliseconds) when requesting the SNMP Agent
   */
  public final SetSNMP setSnmpTimeout(final String snmpTimeout) {
    properties.put(SNMP_TIMEOUT_PROPERTY, snmpTimeout);
    return this;
  }

  /**
   * Set the timeout (in milliseconds) when requesting the SNMP Agent
   */
  public final SetSNMP removeSnmpTimeout() {
    properties.remove(SNMP_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SetSNMP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SetSNMP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SetSNMP, SetSNMP> configurator) {
    return configurator.apply(new SetSNMP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SetSNMP.class) final Closure<SetSNMP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.snmp.processors.SetSNMP> code = closure.rehydrate(c, com.tibtech.nifi.snmp.processors.SetSNMP.class, com.tibtech.nifi.snmp.processors.SetSNMP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SetSNMP, SetSNMP> configurator) {
    return configurator.apply(new SetSNMP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SetSNMP.class) final Closure<SetSNMP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.snmp.processors.SetSNMP> code = closure.rehydrate(c, com.tibtech.nifi.snmp.processors.SetSNMP.class, com.tibtech.nifi.snmp.processors.SetSNMP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
