package com.tibtech.nifi.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GeoEnrichIP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.GeoEnrichIP";

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public static final String GEO_DATABASE_FILE_PROPERTY = "Geo Database File";

  /**
   * The name of an attribute whose value is a dotted decimal IP address for which enrichment should occur
   */
  public static final String IP_ADDRESS_ATTRIBUTE_PROPERTY = "IP Address Attribute";

  private final Map<String, String> properties;

  public GeoEnrichIP() {
    this.properties = new HashMap<>();
  }

  public GeoEnrichIP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public final String getGeoDatabaseFile() {
    return properties.get(GEO_DATABASE_FILE_PROPERTY);
  }

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public final GeoEnrichIP setGeoDatabaseFile(final String geoDatabaseFile) {
    properties.put(GEO_DATABASE_FILE_PROPERTY, geoDatabaseFile);
    return this;
  }

  /**
   * Path to Maxmind IP Enrichment Database File
   */
  public final GeoEnrichIP removeGeoDatabaseFile() {
    properties.remove(GEO_DATABASE_FILE_PROPERTY);
    return this;
  }

  /**
   * The name of an attribute whose value is a dotted decimal IP address for which enrichment should occur
   */
  public final String getIpAddressAttribute() {
    return properties.get(IP_ADDRESS_ATTRIBUTE_PROPERTY);
  }

  /**
   * The name of an attribute whose value is a dotted decimal IP address for which enrichment should occur
   */
  public final GeoEnrichIP setIpAddressAttribute(final String ipAddressAttribute) {
    properties.put(IP_ADDRESS_ATTRIBUTE_PROPERTY, ipAddressAttribute);
    return this;
  }

  /**
   * The name of an attribute whose value is a dotted decimal IP address for which enrichment should occur
   */
  public final GeoEnrichIP removeIpAddressAttribute() {
    properties.remove(IP_ADDRESS_ATTRIBUTE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GeoEnrichIP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GeoEnrichIP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GeoEnrichIP, GeoEnrichIP> configurator) {
    return configurator.apply(new GeoEnrichIP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GeoEnrichIP.class) final Closure<GeoEnrichIP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.GeoEnrichIP> code = closure.rehydrate(c, com.tibtech.nifi.processors.GeoEnrichIP.class, com.tibtech.nifi.processors.GeoEnrichIP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GeoEnrichIP, GeoEnrichIP> configurator) {
    return configurator.apply(new GeoEnrichIP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GeoEnrichIP.class) final Closure<GeoEnrichIP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.GeoEnrichIP> code = closure.rehydrate(c, com.tibtech.nifi.processors.GeoEnrichIP.class, com.tibtech.nifi.processors.GeoEnrichIP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
