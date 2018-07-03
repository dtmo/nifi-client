package com.tibtech.nifi.processors.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHiveQL {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hive.PutHiveQL";

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public static final String HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Hive Database Connection Pooling Service";

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public static final String HIVE_BATCH_SIZE_PROPERTY = "hive-batch-size";

  /**
   * Specifies the character set of the record data.
   */
  public static final String HIVE_CHARSET_PROPERTY = "hive-charset";

  /**
   * Statement Delimiter used to separate SQL statements in a multiple statement script
   */
  public static final String STATEMENT_DELIMITER_PROPERTY = "statement-delimiter";

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public static final String ROLLBACK_ON_FAILURE_PROPERTY = "rollback-on-failure";

  private final Map<String, String> properties;

  public PutHiveQL() {
    this.properties = new HashMap<>();
  }

  public PutHiveQL(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final String getHiveDatabaseConnectionPoolingService() {
    return properties.get(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final PutHiveQL setHiveDatabaseConnectionPoolingService(
      final String hiveDatabaseConnectionPoolingService) {
    properties.put(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, hiveDatabaseConnectionPoolingService);
    return this;
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final PutHiveQL removeHiveDatabaseConnectionPoolingService() {
    properties.remove(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final String getHiveBatchSize() {
    return properties.get(HIVE_BATCH_SIZE_PROPERTY);
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutHiveQL setHiveBatchSize(final String hiveBatchSize) {
    properties.put(HIVE_BATCH_SIZE_PROPERTY, hiveBatchSize);
    return this;
  }

  /**
   * The preferred number of FlowFiles to put to the database in a single transaction
   */
  public final PutHiveQL removeHiveBatchSize() {
    properties.remove(HIVE_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final String getHiveCharset() {
    return properties.get(HIVE_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the record data.
   */
  public final PutHiveQL setHiveCharset(final String hiveCharset) {
    properties.put(HIVE_CHARSET_PROPERTY, hiveCharset);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final PutHiveQL removeHiveCharset() {
    properties.remove(HIVE_CHARSET_PROPERTY);
    return this;
  }

  /**
   * Statement Delimiter used to separate SQL statements in a multiple statement script
   */
  public final String getStatementDelimiter() {
    return properties.get(STATEMENT_DELIMITER_PROPERTY);
  }

  /**
   * Statement Delimiter used to separate SQL statements in a multiple statement script
   */
  public final PutHiveQL setStatementDelimiter(final String statementDelimiter) {
    properties.put(STATEMENT_DELIMITER_PROPERTY, statementDelimiter);
    return this;
  }

  /**
   * Statement Delimiter used to separate SQL statements in a multiple statement script
   */
  public final PutHiveQL removeStatementDelimiter() {
    properties.remove(STATEMENT_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public final String getRollbackOnFailure() {
    return properties.get(ROLLBACK_ON_FAILURE_PROPERTY);
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public final PutHiveQL setRollbackOnFailure(final String rollbackOnFailure) {
    properties.put(ROLLBACK_ON_FAILURE_PROPERTY, rollbackOnFailure);
    return this;
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.
   */
  public final PutHiveQL removeRollbackOnFailure() {
    properties.remove(ROLLBACK_ON_FAILURE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHiveQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHiveQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutHiveQL, PutHiveQL> configurator) {
    return configurator.apply(new PutHiveQL()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHiveQL.class) final Closure<PutHiveQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hive.PutHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.PutHiveQL.class, com.tibtech.nifi.processors.hive.PutHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHiveQL, PutHiveQL> configurator) {
    return configurator.apply(new PutHiveQL(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHiveQL.class) final Closure<PutHiveQL> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hive.PutHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.PutHiveQL.class, com.tibtech.nifi.processors.hive.PutHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
