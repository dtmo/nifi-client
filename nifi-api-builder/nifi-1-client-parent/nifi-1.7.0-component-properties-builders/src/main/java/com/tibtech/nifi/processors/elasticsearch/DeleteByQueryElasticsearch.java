package com.tibtech.nifi.processors.elasticsearch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteByQueryElasticsearch {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.elasticsearch.DeleteByQueryElasticsearch";

  /**
   * A query in JSON syntax, not Lucene syntax. Ex: {"query":{"match":{"somefield":"somevalue"}}}. If this parameter is not set, the query will be read from the flowfile content.
   */
  public static final String EL_REST_QUERY_PROPERTY = "el-rest-query";

  /**
   * If set, the executed query will be set on each result flowfile in the specified attribute.
   */
  public static final String EL_QUERY_ATTRIBUTE_PROPERTY = "el-query-attribute";

  /**
   * The name of the index to use.
   */
  public static final String EL_REST_FETCH_INDEX_PROPERTY = "el-rest-fetch-index";

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public static final String EL_REST_TYPE_PROPERTY = "el-rest-type";

  /**
   * An ElasticSearch client service to use for running queries.
   */
  public static final String EL_REST_CLIENT_SERVICE_PROPERTY = "el-rest-client-service";

  private final Map<String, String> properties;

  public DeleteByQueryElasticsearch() {
    this.properties = new HashMap<>();
  }

  public DeleteByQueryElasticsearch(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A query in JSON syntax, not Lucene syntax. Ex: {"query":{"match":{"somefield":"somevalue"}}}. If this parameter is not set, the query will be read from the flowfile content.
   */
  public final String getElRestQuery() {
    return properties.get(EL_REST_QUERY_PROPERTY);
  }

  /**
   * A query in JSON syntax, not Lucene syntax. Ex: {"query":{"match":{"somefield":"somevalue"}}}. If this parameter is not set, the query will be read from the flowfile content.
   */
  public final DeleteByQueryElasticsearch setElRestQuery(final String elRestQuery) {
    properties.put(EL_REST_QUERY_PROPERTY, elRestQuery);
    return this;
  }

  /**
   * A query in JSON syntax, not Lucene syntax. Ex: {"query":{"match":{"somefield":"somevalue"}}}. If this parameter is not set, the query will be read from the flowfile content.
   */
  public final DeleteByQueryElasticsearch removeElRestQuery() {
    properties.remove(EL_REST_QUERY_PROPERTY);
    return this;
  }

  /**
   * If set, the executed query will be set on each result flowfile in the specified attribute.
   */
  public final String getElQueryAttribute() {
    return properties.get(EL_QUERY_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the executed query will be set on each result flowfile in the specified attribute.
   */
  public final DeleteByQueryElasticsearch setElQueryAttribute(final String elQueryAttribute) {
    properties.put(EL_QUERY_ATTRIBUTE_PROPERTY, elQueryAttribute);
    return this;
  }

  /**
   * If set, the executed query will be set on each result flowfile in the specified attribute.
   */
  public final DeleteByQueryElasticsearch removeElQueryAttribute() {
    properties.remove(EL_QUERY_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The name of the index to use.
   */
  public final String getElRestFetchIndex() {
    return properties.get(EL_REST_FETCH_INDEX_PROPERTY);
  }

  /**
   * The name of the index to use.
   */
  public final DeleteByQueryElasticsearch setElRestFetchIndex(final String elRestFetchIndex) {
    properties.put(EL_REST_FETCH_INDEX_PROPERTY, elRestFetchIndex);
    return this;
  }

  /**
   * The name of the index to use.
   */
  public final DeleteByQueryElasticsearch removeElRestFetchIndex() {
    properties.remove(EL_REST_FETCH_INDEX_PROPERTY);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final String getElRestType() {
    return properties.get(EL_REST_TYPE_PROPERTY);
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final DeleteByQueryElasticsearch setElRestType(final String elRestType) {
    properties.put(EL_REST_TYPE_PROPERTY, elRestType);
    return this;
  }

  /**
   * The type of this document (used by Elasticsearch for indexing and searching)
   */
  public final DeleteByQueryElasticsearch removeElRestType() {
    properties.remove(EL_REST_TYPE_PROPERTY);
    return this;
  }

  /**
   * An ElasticSearch client service to use for running queries.
   */
  public final String getElRestClientService() {
    return properties.get(EL_REST_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * An ElasticSearch client service to use for running queries.
   */
  public final DeleteByQueryElasticsearch setElRestClientService(final String elRestClientService) {
    properties.put(EL_REST_CLIENT_SERVICE_PROPERTY, elRestClientService);
    return this;
  }

  /**
   * An ElasticSearch client service to use for running queries.
   */
  public final DeleteByQueryElasticsearch removeElRestClientService() {
    properties.remove(EL_REST_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteByQueryElasticsearch setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteByQueryElasticsearch removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DeleteByQueryElasticsearch, DeleteByQueryElasticsearch> configurator) {
    return configurator.apply(new DeleteByQueryElasticsearch()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteByQueryElasticsearch.class) final Closure<DeleteByQueryElasticsearch> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.DeleteByQueryElasticsearch> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.DeleteByQueryElasticsearch.class, com.tibtech.nifi.processors.elasticsearch.DeleteByQueryElasticsearch.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteByQueryElasticsearch, DeleteByQueryElasticsearch> configurator) {
    return configurator.apply(new DeleteByQueryElasticsearch(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteByQueryElasticsearch.class) final Closure<DeleteByQueryElasticsearch> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.elasticsearch.DeleteByQueryElasticsearch> code = closure.rehydrate(c, com.tibtech.nifi.processors.elasticsearch.DeleteByQueryElasticsearch.class, com.tibtech.nifi.processors.elasticsearch.DeleteByQueryElasticsearch.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
