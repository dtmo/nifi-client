package com.tibtech.nifi.processors.enrich;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QueryWhois {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.enrich.QueryWhois";

  /**
   * The value that should be used to populate the query
   */
  public static final String QUERY_INPUT_PROPERTY = "QUERY_INPUT";

  /**
   * The Whois query type to be used by the processor (if used)
   */
  public static final String WHOIS_QUERY_TYPE_PROPERTY = "WHOIS_QUERY_TYPE";

  /**
   * The Whois server to be used
   */
  public static final String WHOIS_SERVER_PROPERTY = "WHOIS_SERVER";

  /**
   * The TCP port of the remote Whois server
   */
  public static final String WHOIS_SERVER_PORT_PROPERTY = "WHOIS_SERVER_PORT";

  /**
   * The amount of time to wait until considering a query as failed
   */
  public static final String WHOIS_TIMEOUT_PROPERTY = "WHOIS_TIMEOUT";

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. 
   */
  public static final String BATCH_SIZE_PROPERTY = "BATCH_SIZE";

  /**
   * The protocol used to perform the bulk query. 
   */
  public static final String BULK_PROTOCOL_PROPERTY = "BULK_PROTOCOL";

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
   * When performing a batched lookup, the following RegEx numbered capture group or Column number will be used to match the whois server response with the lookup field
   */
  public static final String KEY_GROUP_PROPERTY = "KEY_GROUP";

  private final Map<String, String> properties;

  public QueryWhois() {
    this.properties = new HashMap<>();
  }

  public QueryWhois(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The value that should be used to populate the query
   */
  public final String getQueryInput() {
    return properties.get(QUERY_INPUT_PROPERTY);
  }

  /**
   * The value that should be used to populate the query
   */
  public final QueryWhois setQueryInput(final String queryInput) {
    properties.put(QUERY_INPUT_PROPERTY, queryInput);
    return this;
  }

  /**
   * The value that should be used to populate the query
   */
  public final QueryWhois removeQueryInput() {
    properties.remove(QUERY_INPUT_PROPERTY);
    return this;
  }

  /**
   * The Whois query type to be used by the processor (if used)
   */
  public final String getWhoisQueryType() {
    return properties.get(WHOIS_QUERY_TYPE_PROPERTY);
  }

  /**
   * The Whois query type to be used by the processor (if used)
   */
  public final QueryWhois setWhoisQueryType(final String whoisQueryType) {
    properties.put(WHOIS_QUERY_TYPE_PROPERTY, whoisQueryType);
    return this;
  }

  /**
   * The Whois query type to be used by the processor (if used)
   */
  public final QueryWhois removeWhoisQueryType() {
    properties.remove(WHOIS_QUERY_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Whois server to be used
   */
  public final String getWhoisServer() {
    return properties.get(WHOIS_SERVER_PROPERTY);
  }

  /**
   * The Whois server to be used
   */
  public final QueryWhois setWhoisServer(final String whoisServer) {
    properties.put(WHOIS_SERVER_PROPERTY, whoisServer);
    return this;
  }

  /**
   * The Whois server to be used
   */
  public final QueryWhois removeWhoisServer() {
    properties.remove(WHOIS_SERVER_PROPERTY);
    return this;
  }

  /**
   * The TCP port of the remote Whois server
   */
  public final String getWhoisServerPort() {
    return properties.get(WHOIS_SERVER_PORT_PROPERTY);
  }

  /**
   * The TCP port of the remote Whois server
   */
  public final QueryWhois setWhoisServerPort(final String whoisServerPort) {
    properties.put(WHOIS_SERVER_PORT_PROPERTY, whoisServerPort);
    return this;
  }

  /**
   * The TCP port of the remote Whois server
   */
  public final QueryWhois removeWhoisServerPort() {
    properties.remove(WHOIS_SERVER_PORT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait until considering a query as failed
   */
  public final String getWhoisTimeout() {
    return properties.get(WHOIS_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait until considering a query as failed
   */
  public final QueryWhois setWhoisTimeout(final String whoisTimeout) {
    properties.put(WHOIS_TIMEOUT_PROPERTY, whoisTimeout);
    return this;
  }

  /**
   * The amount of time to wait until considering a query as failed
   */
  public final QueryWhois removeWhoisTimeout() {
    properties.remove(WHOIS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. 
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. 
   */
  public final QueryWhois setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. 
   */
  public final QueryWhois removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The protocol used to perform the bulk query. 
   */
  public final String getBulkProtocol() {
    return properties.get(BULK_PROTOCOL_PROPERTY);
  }

  /**
   * The protocol used to perform the bulk query. 
   */
  public final QueryWhois setBulkProtocol(final String bulkProtocol) {
    properties.put(BULK_PROTOCOL_PROPERTY, bulkProtocol);
    return this;
  }

  /**
   * The protocol used to perform the bulk query. 
   */
  public final QueryWhois removeBulkProtocol() {
    properties.remove(BULK_PROTOCOL_PROPERTY);
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
  public final QueryWhois setQueryParser(final String queryParser) {
    properties.put(QUERY_PARSER_PROPERTY, queryParser);
    return this;
  }

  /**
   * The method used to slice the results into attribute groups
   */
  public final QueryWhois removeQueryParser() {
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
  public final QueryWhois setQueryParserInput(final String queryParserInput) {
    properties.put(QUERY_PARSER_INPUT_PROPERTY, queryParserInput);
    return this;
  }

  /**
   * Choice between a splitter and regex matcher used to parse the results of the query into attribute groups.
   * NOTE: This is a multiline regular expression, therefore, the DFM should decide how to handle trailing new line characters.
   */
  public final QueryWhois removeQueryParserInput() {
    properties.remove(QUERY_PARSER_INPUT_PROPERTY);
    return this;
  }

  /**
   * When performing a batched lookup, the following RegEx numbered capture group or Column number will be used to match the whois server response with the lookup field
   */
  public final String getKeyGroup() {
    return properties.get(KEY_GROUP_PROPERTY);
  }

  /**
   * When performing a batched lookup, the following RegEx numbered capture group or Column number will be used to match the whois server response with the lookup field
   */
  public final QueryWhois setKeyGroup(final String keyGroup) {
    properties.put(KEY_GROUP_PROPERTY, keyGroup);
    return this;
  }

  /**
   * When performing a batched lookup, the following RegEx numbered capture group or Column number will be used to match the whois server response with the lookup field
   */
  public final QueryWhois removeKeyGroup() {
    properties.remove(KEY_GROUP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QueryWhois setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QueryWhois removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<QueryWhois, QueryWhois> configurator) {
    return configurator.apply(new QueryWhois()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryWhois.class) final Closure<QueryWhois> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.enrich.QueryWhois> code = closure.rehydrate(c, com.tibtech.nifi.processors.enrich.QueryWhois.class, com.tibtech.nifi.processors.enrich.QueryWhois.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<QueryWhois, QueryWhois> configurator) {
    return configurator.apply(new QueryWhois(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryWhois.class) final Closure<QueryWhois> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.enrich.QueryWhois> code = closure.rehydrate(c, com.tibtech.nifi.processors.enrich.QueryWhois.class, com.tibtech.nifi.processors.enrich.QueryWhois.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
