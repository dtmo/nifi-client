package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractEmailHeaders {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.email.ExtractEmailHeaders";

  /**
   * COLON separated list of additional headers to be extracted from the flowfile content.NOTE the header key is case insensitive and will be matched as lower-case. Values will respect email contents.
   */
  public static final String CAPTURED_HEADERS_PROPERTY = "CAPTURED_HEADERS";

  /**
   * If "strict", strict address format parsing rules are applied to mailbox and mailbox list fields, such as "to" and "from" headers, and FlowFiles with poorly formed addresses will be routed to the failure relationship, similar to messages that fail RFC compliant format validation. If "non-strict", the processor will extract the contents of mailbox list headers as comma-separated values without attempting to parse each value as well-formed Internet mailbox addresses. This is optional and defaults to Strict Address Parsing
   */
  public static final String STRICT_ADDRESS_PARSING_PROPERTY = "STRICT_ADDRESS_PARSING";

  private final Map<String, String> properties;

  public ExtractEmailHeaders() {
    this.properties = new HashMap<>();
  }

  public ExtractEmailHeaders(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * COLON separated list of additional headers to be extracted from the flowfile content.NOTE the header key is case insensitive and will be matched as lower-case. Values will respect email contents.
   */
  public final String getCapturedHeaders() {
    return properties.get(CAPTURED_HEADERS_PROPERTY);
  }

  /**
   * COLON separated list of additional headers to be extracted from the flowfile content.NOTE the header key is case insensitive and will be matched as lower-case. Values will respect email contents.
   */
  public final ExtractEmailHeaders setCapturedHeaders(final String capturedHeaders) {
    properties.put(CAPTURED_HEADERS_PROPERTY, capturedHeaders);
    return this;
  }

  /**
   * COLON separated list of additional headers to be extracted from the flowfile content.NOTE the header key is case insensitive and will be matched as lower-case. Values will respect email contents.
   */
  public final ExtractEmailHeaders removeCapturedHeaders() {
    properties.remove(CAPTURED_HEADERS_PROPERTY);
    return this;
  }

  /**
   * If "strict", strict address format parsing rules are applied to mailbox and mailbox list fields, such as "to" and "from" headers, and FlowFiles with poorly formed addresses will be routed to the failure relationship, similar to messages that fail RFC compliant format validation. If "non-strict", the processor will extract the contents of mailbox list headers as comma-separated values without attempting to parse each value as well-formed Internet mailbox addresses. This is optional and defaults to Strict Address Parsing
   */
  public final String getStrictAddressParsing() {
    return properties.get(STRICT_ADDRESS_PARSING_PROPERTY);
  }

  /**
   * If "strict", strict address format parsing rules are applied to mailbox and mailbox list fields, such as "to" and "from" headers, and FlowFiles with poorly formed addresses will be routed to the failure relationship, similar to messages that fail RFC compliant format validation. If "non-strict", the processor will extract the contents of mailbox list headers as comma-separated values without attempting to parse each value as well-formed Internet mailbox addresses. This is optional and defaults to Strict Address Parsing
   */
  public final ExtractEmailHeaders setStrictAddressParsing(final String strictAddressParsing) {
    properties.put(STRICT_ADDRESS_PARSING_PROPERTY, strictAddressParsing);
    return this;
  }

  /**
   * If "strict", strict address format parsing rules are applied to mailbox and mailbox list fields, such as "to" and "from" headers, and FlowFiles with poorly formed addresses will be routed to the failure relationship, similar to messages that fail RFC compliant format validation. If "non-strict", the processor will extract the contents of mailbox list headers as comma-separated values without attempting to parse each value as well-formed Internet mailbox addresses. This is optional and defaults to Strict Address Parsing
   */
  public final ExtractEmailHeaders removeStrictAddressParsing() {
    properties.remove(STRICT_ADDRESS_PARSING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractEmailHeaders setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractEmailHeaders removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExtractEmailHeaders, ExtractEmailHeaders> configurator) {
    return configurator.apply(new ExtractEmailHeaders()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractEmailHeaders.class) final Closure<ExtractEmailHeaders> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ExtractEmailHeaders> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ExtractEmailHeaders.class, com.tibtech.nifi.processors.email.ExtractEmailHeaders.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractEmailHeaders, ExtractEmailHeaders> configurator) {
    return configurator.apply(new ExtractEmailHeaders(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractEmailHeaders.class) final Closure<ExtractEmailHeaders> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.email.ExtractEmailHeaders> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ExtractEmailHeaders.class, com.tibtech.nifi.processors.email.ExtractEmailHeaders.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
