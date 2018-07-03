package com.tibtech.nifi.lookup.maxmind;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class IPLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.maxmind.IPLookupService";

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public static final String DATABASE_FILE_PROPERTY = "database-file";

  /**
   * Specifies whether or not information about the geographic information, such as cities, corresponding to the IP address should be returned
   */
  public static final String LOOKUP_CITY_PROPERTY = "lookup-city";

  /**
   * Specifies whether or not information about the Information Service Provider corresponding to the IP address should be returned
   */
  public static final String LOOKUP_ISP_PROPERTY = "lookup-isp";

  /**
   * Specifies whether or not information about the Domain Name corresponding to the IP address should be returned. If true, the lookup will contain second-level domain information, such as foo.com but will not contain bar.foo.com
   */
  public static final String LOOKUP_DOMAIN_PROPERTY = "lookup-domain";

  /**
   * Specifies whether or not information about the Connection Type corresponding to the IP address should be returned. If true, the lookup will contain a 'connectionType' field that (if populated) will contain a value of 'Dialup', 'Cable/DSL', 'Corporate', or 'Cellular'
   */
  public static final String LOOKUP_CONNECTION_TYPE_PROPERTY = "lookup-connection-type";

  /**
   * Specifies whether or not information about whether or not the IP address belongs to an anonymous network should be returned.
   */
  public static final String LOOKUP_ANONYMOUS_IP_PROPERTY = "lookup-anonymous-ip";

  private final Map<String, String> properties;

  public IPLookupService() {
    this.properties = new HashMap<>();
  }

  public IPLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public final String getDatabaseFile() {
    return properties.get(DATABASE_FILE_PROPERTY);
  }

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public final IPLookupService setDatabaseFile(final String databaseFile) {
    properties.put(DATABASE_FILE_PROPERTY, databaseFile);
    return this;
  }

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public final IPLookupService removeDatabaseFile() {
    properties.remove(DATABASE_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not information about the geographic information, such as cities, corresponding to the IP address should be returned
   */
  public final String getLookupCity() {
    return properties.get(LOOKUP_CITY_PROPERTY);
  }

  /**
   * Specifies whether or not information about the geographic information, such as cities, corresponding to the IP address should be returned
   */
  public final IPLookupService setLookupCity(final String lookupCity) {
    properties.put(LOOKUP_CITY_PROPERTY, lookupCity);
    return this;
  }

  /**
   * Specifies whether or not information about the geographic information, such as cities, corresponding to the IP address should be returned
   */
  public final IPLookupService removeLookupCity() {
    properties.remove(LOOKUP_CITY_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not information about the Information Service Provider corresponding to the IP address should be returned
   */
  public final String getLookupIsp() {
    return properties.get(LOOKUP_ISP_PROPERTY);
  }

  /**
   * Specifies whether or not information about the Information Service Provider corresponding to the IP address should be returned
   */
  public final IPLookupService setLookupIsp(final String lookupIsp) {
    properties.put(LOOKUP_ISP_PROPERTY, lookupIsp);
    return this;
  }

  /**
   * Specifies whether or not information about the Information Service Provider corresponding to the IP address should be returned
   */
  public final IPLookupService removeLookupIsp() {
    properties.remove(LOOKUP_ISP_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not information about the Domain Name corresponding to the IP address should be returned. If true, the lookup will contain second-level domain information, such as foo.com but will not contain bar.foo.com
   */
  public final String getLookupDomain() {
    return properties.get(LOOKUP_DOMAIN_PROPERTY);
  }

  /**
   * Specifies whether or not information about the Domain Name corresponding to the IP address should be returned. If true, the lookup will contain second-level domain information, such as foo.com but will not contain bar.foo.com
   */
  public final IPLookupService setLookupDomain(final String lookupDomain) {
    properties.put(LOOKUP_DOMAIN_PROPERTY, lookupDomain);
    return this;
  }

  /**
   * Specifies whether or not information about the Domain Name corresponding to the IP address should be returned. If true, the lookup will contain second-level domain information, such as foo.com but will not contain bar.foo.com
   */
  public final IPLookupService removeLookupDomain() {
    properties.remove(LOOKUP_DOMAIN_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not information about the Connection Type corresponding to the IP address should be returned. If true, the lookup will contain a 'connectionType' field that (if populated) will contain a value of 'Dialup', 'Cable/DSL', 'Corporate', or 'Cellular'
   */
  public final String getLookupConnectionType() {
    return properties.get(LOOKUP_CONNECTION_TYPE_PROPERTY);
  }

  /**
   * Specifies whether or not information about the Connection Type corresponding to the IP address should be returned. If true, the lookup will contain a 'connectionType' field that (if populated) will contain a value of 'Dialup', 'Cable/DSL', 'Corporate', or 'Cellular'
   */
  public final IPLookupService setLookupConnectionType(final String lookupConnectionType) {
    properties.put(LOOKUP_CONNECTION_TYPE_PROPERTY, lookupConnectionType);
    return this;
  }

  /**
   * Specifies whether or not information about the Connection Type corresponding to the IP address should be returned. If true, the lookup will contain a 'connectionType' field that (if populated) will contain a value of 'Dialup', 'Cable/DSL', 'Corporate', or 'Cellular'
   */
  public final IPLookupService removeLookupConnectionType() {
    properties.remove(LOOKUP_CONNECTION_TYPE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not information about whether or not the IP address belongs to an anonymous network should be returned.
   */
  public final String getLookupAnonymousIp() {
    return properties.get(LOOKUP_ANONYMOUS_IP_PROPERTY);
  }

  /**
   * Specifies whether or not information about whether or not the IP address belongs to an anonymous network should be returned.
   */
  public final IPLookupService setLookupAnonymousIp(final String lookupAnonymousIp) {
    properties.put(LOOKUP_ANONYMOUS_IP_PROPERTY, lookupAnonymousIp);
    return this;
  }

  /**
   * Specifies whether or not information about whether or not the IP address belongs to an anonymous network should be returned.
   */
  public final IPLookupService removeLookupAnonymousIp() {
    properties.remove(LOOKUP_ANONYMOUS_IP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final IPLookupService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final IPLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<IPLookupService, IPLookupService> configurator) {
    return configurator.apply(new IPLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = IPLookupService.class) final Closure<IPLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.maxmind.IPLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.maxmind.IPLookupService.class, com.tibtech.nifi.lookup.maxmind.IPLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<IPLookupService, IPLookupService> configurator) {
    return configurator.apply(new IPLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = IPLookupService.class) final Closure<IPLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.maxmind.IPLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.maxmind.IPLookupService.class, com.tibtech.nifi.lookup.maxmind.IPLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
