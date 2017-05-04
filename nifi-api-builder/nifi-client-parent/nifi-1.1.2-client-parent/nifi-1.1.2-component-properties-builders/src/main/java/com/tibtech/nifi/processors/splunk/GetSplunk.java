package com.tibtech.nifi.processors.splunk;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetSplunk {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.splunk.GetSplunk";

  /**
   * The scheme for connecting to Splunk.
   */
  public static final String SCHEME_PROPERTY = "Scheme";

  /**
   * The ip address or hostname of the Splunk server.
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The port of the Splunk server.
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * The query to execute. Typically beginning with a <search> command followed by a search clause, such as <search source="tcp:7689"> to search for messages received on TCP port 7689.
   */
  public static final String QUERY_PROPERTY = "Query";

  /**
   * Indicates whether to search by the time attached to the event, or by the time the event was indexed in Splunk.
   */
  public static final String TIME_FIELD_STRATEGY_PROPERTY = "Time Field Strategy";

  /**
   * Indicates how to apply time ranges to each execution of the query. Selecting a managed option allows the processor to apply a time range from the last execution time to the current execution time. When using <Managed from Beginning>, an earliest time will not be applied on the first execution, and thus all records searched. When using <Managed from Current> the earliest time of the first execution will be the initial execution time. When using <Provided>, the time range will come from the Earliest Time and Latest Time properties, or no time range will be applied if these properties are left blank.
   */
  public static final String TIME_RANGE_STRATEGY_PROPERTY = "Time Range Strategy";

  /**
   * The value to use for the earliest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public static final String EARLIEST_TIME_PROPERTY = "Earliest Time";

  /**
   * The value to use for the latest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public static final String LATEST_TIME_PROPERTY = "Latest Time";

  /**
   * The Time Zone to use for formatting dates when performing a search. Only used with Managed time strategies.
   */
  public static final String TIME_ZONE_PROPERTY = "Time Zone";

  /**
   * The Splunk Application to query.
   */
  public static final String APPLICATION_PROPERTY = "Application";

  /**
   * The owner to pass to Splunk.
   */
  public static final String OWNER_PROPERTY = "Owner";

  /**
   * The token to pass to Splunk.
   */
  public static final String TOKEN_PROPERTY = "Token";

  /**
   * The username to authenticate to Splunk.
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * The password to authenticate to Splunk.
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The security protocol to use for communicating with Splunk.
   */
  public static final String SECURITY_PROTOCOL_PROPERTY = "Security Protocol";

  /**
   * The output mode for the results.
   */
  public static final String OUTPUT_MODE_PROPERTY = "Output Mode";

  private final Map<String, String> properties;

  public GetSplunk() {
    this.properties = new HashMap<>();
  }

  public GetSplunk(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The scheme for connecting to Splunk.
   */
  public final String getScheme() {
    return properties.get(SCHEME_PROPERTY);
  }

  /**
   * The scheme for connecting to Splunk.
   */
  public final GetSplunk setScheme(final String scheme) {
    properties.put(SCHEME_PROPERTY, scheme);
    return this;
  }

  /**
   * The scheme for connecting to Splunk.
   */
  public final GetSplunk removeScheme() {
    properties.remove(SCHEME_PROPERTY);
    return this;
  }

  /**
   * The ip address or hostname of the Splunk server.
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The ip address or hostname of the Splunk server.
   */
  public final GetSplunk setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The ip address or hostname of the Splunk server.
   */
  public final GetSplunk removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The port of the Splunk server.
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port of the Splunk server.
   */
  public final GetSplunk setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port of the Splunk server.
   */
  public final GetSplunk removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The query to execute. Typically beginning with a <search> command followed by a search clause, such as <search source="tcp:7689"> to search for messages received on TCP port 7689.
   */
  public final String getQuery() {
    return properties.get(QUERY_PROPERTY);
  }

  /**
   * The query to execute. Typically beginning with a <search> command followed by a search clause, such as <search source="tcp:7689"> to search for messages received on TCP port 7689.
   */
  public final GetSplunk setQuery(final String query) {
    properties.put(QUERY_PROPERTY, query);
    return this;
  }

  /**
   * The query to execute. Typically beginning with a <search> command followed by a search clause, such as <search source="tcp:7689"> to search for messages received on TCP port 7689.
   */
  public final GetSplunk removeQuery() {
    properties.remove(QUERY_PROPERTY);
    return this;
  }

  /**
   * Indicates whether to search by the time attached to the event, or by the time the event was indexed in Splunk.
   */
  public final String getTimeFieldStrategy() {
    return properties.get(TIME_FIELD_STRATEGY_PROPERTY);
  }

  /**
   * Indicates whether to search by the time attached to the event, or by the time the event was indexed in Splunk.
   */
  public final GetSplunk setTimeFieldStrategy(final String timeFieldStrategy) {
    properties.put(TIME_FIELD_STRATEGY_PROPERTY, timeFieldStrategy);
    return this;
  }

  /**
   * Indicates whether to search by the time attached to the event, or by the time the event was indexed in Splunk.
   */
  public final GetSplunk removeTimeFieldStrategy() {
    properties.remove(TIME_FIELD_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Indicates how to apply time ranges to each execution of the query. Selecting a managed option allows the processor to apply a time range from the last execution time to the current execution time. When using <Managed from Beginning>, an earliest time will not be applied on the first execution, and thus all records searched. When using <Managed from Current> the earliest time of the first execution will be the initial execution time. When using <Provided>, the time range will come from the Earliest Time and Latest Time properties, or no time range will be applied if these properties are left blank.
   */
  public final String getTimeRangeStrategy() {
    return properties.get(TIME_RANGE_STRATEGY_PROPERTY);
  }

  /**
   * Indicates how to apply time ranges to each execution of the query. Selecting a managed option allows the processor to apply a time range from the last execution time to the current execution time. When using <Managed from Beginning>, an earliest time will not be applied on the first execution, and thus all records searched. When using <Managed from Current> the earliest time of the first execution will be the initial execution time. When using <Provided>, the time range will come from the Earliest Time and Latest Time properties, or no time range will be applied if these properties are left blank.
   */
  public final GetSplunk setTimeRangeStrategy(final String timeRangeStrategy) {
    properties.put(TIME_RANGE_STRATEGY_PROPERTY, timeRangeStrategy);
    return this;
  }

  /**
   * Indicates how to apply time ranges to each execution of the query. Selecting a managed option allows the processor to apply a time range from the last execution time to the current execution time. When using <Managed from Beginning>, an earliest time will not be applied on the first execution, and thus all records searched. When using <Managed from Current> the earliest time of the first execution will be the initial execution time. When using <Provided>, the time range will come from the Earliest Time and Latest Time properties, or no time range will be applied if these properties are left blank.
   */
  public final GetSplunk removeTimeRangeStrategy() {
    properties.remove(TIME_RANGE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The value to use for the earliest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public final String getEarliestTime() {
    return properties.get(EARLIEST_TIME_PROPERTY);
  }

  /**
   * The value to use for the earliest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public final GetSplunk setEarliestTime(final String earliestTime) {
    properties.put(EARLIEST_TIME_PROPERTY, earliestTime);
    return this;
  }

  /**
   * The value to use for the earliest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public final GetSplunk removeEarliestTime() {
    properties.remove(EARLIEST_TIME_PROPERTY);
    return this;
  }

  /**
   * The value to use for the latest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public final String getLatestTime() {
    return properties.get(LATEST_TIME_PROPERTY);
  }

  /**
   * The value to use for the latest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public final GetSplunk setLatestTime(final String latestTime) {
    properties.put(LATEST_TIME_PROPERTY, latestTime);
    return this;
  }

  /**
   * The value to use for the latest time when querying. Only used with a Time Range Strategy of Provided. See Splunk's documentation on Search Time Modifiers for guidance in populating this field.
   */
  public final GetSplunk removeLatestTime() {
    properties.remove(LATEST_TIME_PROPERTY);
    return this;
  }

  /**
   * The Time Zone to use for formatting dates when performing a search. Only used with Managed time strategies.
   */
  public final String getTimeZone() {
    return properties.get(TIME_ZONE_PROPERTY);
  }

  /**
   * The Time Zone to use for formatting dates when performing a search. Only used with Managed time strategies.
   */
  public final GetSplunk setTimeZone(final String timeZone) {
    properties.put(TIME_ZONE_PROPERTY, timeZone);
    return this;
  }

  /**
   * The Time Zone to use for formatting dates when performing a search. Only used with Managed time strategies.
   */
  public final GetSplunk removeTimeZone() {
    properties.remove(TIME_ZONE_PROPERTY);
    return this;
  }

  /**
   * The Splunk Application to query.
   */
  public final String getApplication() {
    return properties.get(APPLICATION_PROPERTY);
  }

  /**
   * The Splunk Application to query.
   */
  public final GetSplunk setApplication(final String application) {
    properties.put(APPLICATION_PROPERTY, application);
    return this;
  }

  /**
   * The Splunk Application to query.
   */
  public final GetSplunk removeApplication() {
    properties.remove(APPLICATION_PROPERTY);
    return this;
  }

  /**
   * The owner to pass to Splunk.
   */
  public final String getOwner() {
    return properties.get(OWNER_PROPERTY);
  }

  /**
   * The owner to pass to Splunk.
   */
  public final GetSplunk setOwner(final String owner) {
    properties.put(OWNER_PROPERTY, owner);
    return this;
  }

  /**
   * The owner to pass to Splunk.
   */
  public final GetSplunk removeOwner() {
    properties.remove(OWNER_PROPERTY);
    return this;
  }

  /**
   * The token to pass to Splunk.
   */
  public final String getToken() {
    return properties.get(TOKEN_PROPERTY);
  }

  /**
   * The token to pass to Splunk.
   */
  public final GetSplunk setToken(final String token) {
    properties.put(TOKEN_PROPERTY, token);
    return this;
  }

  /**
   * The token to pass to Splunk.
   */
  public final GetSplunk removeToken() {
    properties.remove(TOKEN_PROPERTY);
    return this;
  }

  /**
   * The username to authenticate to Splunk.
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * The username to authenticate to Splunk.
   */
  public final GetSplunk setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * The username to authenticate to Splunk.
   */
  public final GetSplunk removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * The password to authenticate to Splunk.
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * The password to authenticate to Splunk.
   */
  public final GetSplunk setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The password to authenticate to Splunk.
   */
  public final GetSplunk removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The security protocol to use for communicating with Splunk.
   */
  public final String getSecurityProtocol() {
    return properties.get(SECURITY_PROTOCOL_PROPERTY);
  }

  /**
   * The security protocol to use for communicating with Splunk.
   */
  public final GetSplunk setSecurityProtocol(final String securityProtocol) {
    properties.put(SECURITY_PROTOCOL_PROPERTY, securityProtocol);
    return this;
  }

  /**
   * The security protocol to use for communicating with Splunk.
   */
  public final GetSplunk removeSecurityProtocol() {
    properties.remove(SECURITY_PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * The output mode for the results.
   */
  public final String getOutputMode() {
    return properties.get(OUTPUT_MODE_PROPERTY);
  }

  /**
   * The output mode for the results.
   */
  public final GetSplunk setOutputMode(final String outputMode) {
    properties.put(OUTPUT_MODE_PROPERTY, outputMode);
    return this;
  }

  /**
   * The output mode for the results.
   */
  public final GetSplunk removeOutputMode() {
    properties.remove(OUTPUT_MODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetSplunk setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetSplunk removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetSplunk, GetSplunk> configurator) {
    return configurator.apply(new GetSplunk()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetSplunk.class) final Closure<GetSplunk> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.splunk.GetSplunk> code = closure.rehydrate(c, com.tibtech.nifi.processors.splunk.GetSplunk.class, com.tibtech.nifi.processors.splunk.GetSplunk.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetSplunk, GetSplunk> configurator) {
    return configurator.apply(new GetSplunk(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetSplunk.class) final Closure<GetSplunk> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.splunk.GetSplunk> code = closure.rehydrate(c, com.tibtech.nifi.processors.splunk.GetSplunk.class, com.tibtech.nifi.processors.splunk.GetSplunk.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
