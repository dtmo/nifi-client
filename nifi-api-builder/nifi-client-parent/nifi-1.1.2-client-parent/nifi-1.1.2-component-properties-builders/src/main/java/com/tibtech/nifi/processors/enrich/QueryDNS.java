package com.tibtech.nifi.processors.enrich;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QueryDNS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.enrich.QueryDNS";

  /**
   * The value that should be used to populate the query
   */
  public static final String QUERY_INPUT_PROPERTY = "QUERY_INPUT";

  /**
   * The method used to slice the results into attribute groups
   */
  public static final String QUERY_PARSER_PROPERTY = "QUERY_PARSER";

  /**
   * Choice between a splitter and regex matcher used to parse the results of the query into attribute groups.
   * NOTE: This is a multiline regular expression, therefore, the DFM should decide how to handle trailing new line characters.
   */
  public static final String QUERY_PARSER_INPUT_PROPERTY = "QUERY_PARSER_INPUT";

  /**
   * The number of attempts before giving up and moving on
   */
  public static final String DNS_RETRIES_PROPERTY = "DNS_RETRIES";

  /**
   * The amount of time to wait until considering a query as failed
   */
  public static final String DNS_TIMEOUT_PROPERTY = "DNS_TIMEOUT";

  /**
   * A comma separated list of  DNS servers to be used. (Defaults to system wide if none is used)
   */
  public static final String DNS_SERVER_PROPERTY = "DNS_SERVER";

  /**
   * The DNS query type to be used by the processor (e.g. TXT, A)
   */
  public static final String DNS_QUERY_TYPE_PROPERTY = "DNS_QUERY_TYPE";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The value that should be used to populate the query
   */
  public final String getQueryInput() {
    return properties.get(QUERY_INPUT_PROPERTY);
  }

  /**
   * The value that should be used to populate the query
   */
  public final QueryDNS setQueryInput(final String queryInput) {
    properties.put(QUERY_INPUT_PROPERTY, queryInput);
    return this;
  }

  /**
   * The value that should be used to populate the query
   */
  public final QueryDNS removeQueryInput() {
    properties.remove(QUERY_INPUT_PROPERTY);
    return this;
  }

  /**
   * The method used to slice the results into attribute groups
   */
  public final String getQueryParser() {
    return properties.get(QUERY_PARSER_PROPERTY);
  }

  /**
   * The method used to slice the results into attribute groups
   */
  public final QueryDNS setQueryParser(final String queryParser) {
    properties.put(QUERY_PARSER_PROPERTY, queryParser);
    return this;
  }

  /**
   * The method used to slice the results into attribute groups
   */
  public final QueryDNS removeQueryParser() {
    properties.remove(QUERY_PARSER_PROPERTY);
    return this;
  }

  /**
   * Choice between a splitter and regex matcher used to parse the results of the query into attribute groups.
   * NOTE: This is a multiline regular expression, therefore, the DFM should decide how to handle trailing new line characters.
   */
  public final String getQueryParserInput() {
    return properties.get(QUERY_PARSER_INPUT_PROPERTY);
  }

  /**
   * Choice between a splitter and regex matcher used to parse the results of the query into attribute groups.
   * NOTE: This is a multiline regular expression, therefore, the DFM should decide how to handle trailing new line characters.
   */
  public final QueryDNS setQueryParserInput(final String queryParserInput) {
    properties.put(QUERY_PARSER_INPUT_PROPERTY, queryParserInput);
    return this;
  }

  /**
   * Choice between a splitter and regex matcher used to parse the results of the query into attribute groups.
   * NOTE: This is a multiline regular expression, therefore, the DFM should decide how to handle trailing new line characters.
   */
  public final QueryDNS removeQueryParserInput() {
    properties.remove(QUERY_PARSER_INPUT_PROPERTY);
    return this;
  }

  /**
   * The number of attempts before giving up and moving on
   */
  public final String getDnsRetries() {
    return properties.get(DNS_RETRIES_PROPERTY);
  }

  /**
   * The number of attempts before giving up and moving on
   */
  public final QueryDNS setDnsRetries(final String dnsRetries) {
    properties.put(DNS_RETRIES_PROPERTY, dnsRetries);
    return this;
  }

  /**
   * The number of attempts before giving up and moving on
   */
  public final QueryDNS removeDnsRetries() {
    properties.remove(DNS_RETRIES_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait until considering a query as failed
   */
  public final String getDnsTimeout() {
    return properties.get(DNS_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait until considering a query as failed
   */
  public final QueryDNS setDnsTimeout(final String dnsTimeout) {
    properties.put(DNS_TIMEOUT_PROPERTY, dnsTimeout);
    return this;
  }

  /**
   * The amount of time to wait until considering a query as failed
   */
  public final QueryDNS removeDnsTimeout() {
    properties.remove(DNS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * A comma separated list of  DNS servers to be used. (Defaults to system wide if none is used)
   */
  public final String getDnsServer() {
    return properties.get(DNS_SERVER_PROPERTY);
  }

  /**
   * A comma separated list of  DNS servers to be used. (Defaults to system wide if none is used)
   */
  public final QueryDNS setDnsServer(final String dnsServer) {
    properties.put(DNS_SERVER_PROPERTY, dnsServer);
    return this;
  }

  /**
   * A comma separated list of  DNS servers to be used. (Defaults to system wide if none is used)
   */
  public final QueryDNS removeDnsServer() {
    properties.remove(DNS_SERVER_PROPERTY);
    return this;
  }

  /**
   * The DNS query type to be used by the processor (e.g. TXT, A)
   */
  public final String getDnsQueryType() {
    return properties.get(DNS_QUERY_TYPE_PROPERTY);
  }

  /**
   * The DNS query type to be used by the processor (e.g. TXT, A)
   */
  public final QueryDNS setDnsQueryType(final String dnsQueryType) {
    properties.put(DNS_QUERY_TYPE_PROPERTY, dnsQueryType);
    return this;
  }

  /**
   * The DNS query type to be used by the processor (e.g. TXT, A)
   */
  public final QueryDNS removeDnsQueryType() {
    properties.remove(DNS_QUERY_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QueryDNS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QueryDNS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<QueryDNS, QueryDNS> configurator) {
    return configurator.apply(new QueryDNS()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryDNS.class) final Closure<QueryDNS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.enrich.QueryDNS> code = closure.rehydrate(c, com.tibtech.nifi.processors.enrich.QueryDNS.class, com.tibtech.nifi.processors.enrich.QueryDNS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
