package com.tibtech.nifi.processors.kudu;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutKudu {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kudu.PutKudu";

  /**
   * List all kudu masters's ip with port (e.g. 7051), comma separated
   */
  public static final String KUDU_MASTERS_PROPERTY = "Kudu Masters";

  /**
   * The name of the Kudu Table to put data into
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * Deprecated. Used to ignore header lines, but this should be handled by a RecordReader (e.g. "Treat First Line as Header" property of CSVReader)
   */
  public static final String SKIP_HEAD_LINE_PROPERTY = "Skip head line";

  /**
   * The service for reading records from incoming flow files.
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specify operationType for this processor. Insert-Ignore will ignore duplicated rows
   */
  public static final String INSERT_OPERATION_PROPERTY = "Insert Operation";

  /**
   * Set the new flush mode for a kudu session.
   * AUTO_FLUSH_SYNC: the call returns when the operation is persisted, else it throws an exception.
   * AUTO_FLUSH_BACKGROUND: the call returns when the operation has been added to the buffer. This call should normally perform only fast in-memory operations but it may have to wait when the buffer is full and there's another buffer being flushed.
   * MANUAL_FLUSH: the call returns when the operation has been added to the buffer, else it throws a KuduException if the buffer is full.
   */
  public static final String FLUSH_MODE_PROPERTY = "Flush Mode";

  /**
   * The maximum number of FlowFiles to process in a single execution, between 1 - 100000. Depending on your memory size, and data size per row set an appropriate batch size. Gradually increase this number to find out the best one for best performances.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  private final Map<String, String> properties;

  public PutKudu() {
    this.properties = new HashMap<>();
  }

  public PutKudu(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * List all kudu masters's ip with port (e.g. 7051), comma separated
   */
  public final String getKuduMasters() {
    return properties.get(KUDU_MASTERS_PROPERTY);
  }

  /**
   * List all kudu masters's ip with port (e.g. 7051), comma separated
   */
  public final PutKudu setKuduMasters(final String kuduMasters) {
    properties.put(KUDU_MASTERS_PROPERTY, kuduMasters);
    return this;
  }

  /**
   * List all kudu masters's ip with port (e.g. 7051), comma separated
   */
  public final PutKudu removeKuduMasters() {
    properties.remove(KUDU_MASTERS_PROPERTY);
    return this;
  }

  /**
   * The name of the Kudu Table to put data into
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the Kudu Table to put data into
   */
  public final PutKudu setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the Kudu Table to put data into
   */
  public final PutKudu removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * Deprecated. Used to ignore header lines, but this should be handled by a RecordReader (e.g. "Treat First Line as Header" property of CSVReader)
   */
  public final String getSkipHeadLine() {
    return properties.get(SKIP_HEAD_LINE_PROPERTY);
  }

  /**
   * Deprecated. Used to ignore header lines, but this should be handled by a RecordReader (e.g. "Treat First Line as Header" property of CSVReader)
   */
  public final PutKudu setSkipHeadLine(final String skipHeadLine) {
    properties.put(SKIP_HEAD_LINE_PROPERTY, skipHeadLine);
    return this;
  }

  /**
   * Deprecated. Used to ignore header lines, but this should be handled by a RecordReader (e.g. "Treat First Line as Header" property of CSVReader)
   */
  public final PutKudu removeSkipHeadLine() {
    properties.remove(SKIP_HEAD_LINE_PROPERTY);
    return this;
  }

  /**
   * The service for reading records from incoming flow files.
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * The service for reading records from incoming flow files.
   */
  public final PutKudu setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * The service for reading records from incoming flow files.
   */
  public final PutKudu removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Specify operationType for this processor. Insert-Ignore will ignore duplicated rows
   */
  public final String getInsertOperation() {
    return properties.get(INSERT_OPERATION_PROPERTY);
  }

  /**
   * Specify operationType for this processor. Insert-Ignore will ignore duplicated rows
   */
  public final PutKudu setInsertOperation(final String insertOperation) {
    properties.put(INSERT_OPERATION_PROPERTY, insertOperation);
    return this;
  }

  /**
   * Specify operationType for this processor. Insert-Ignore will ignore duplicated rows
   */
  public final PutKudu removeInsertOperation() {
    properties.remove(INSERT_OPERATION_PROPERTY);
    return this;
  }

  /**
   * Set the new flush mode for a kudu session.
   * AUTO_FLUSH_SYNC: the call returns when the operation is persisted, else it throws an exception.
   * AUTO_FLUSH_BACKGROUND: the call returns when the operation has been added to the buffer. This call should normally perform only fast in-memory operations but it may have to wait when the buffer is full and there's another buffer being flushed.
   * MANUAL_FLUSH: the call returns when the operation has been added to the buffer, else it throws a KuduException if the buffer is full.
   */
  public final String getFlushMode() {
    return properties.get(FLUSH_MODE_PROPERTY);
  }

  /**
   * Set the new flush mode for a kudu session.
   * AUTO_FLUSH_SYNC: the call returns when the operation is persisted, else it throws an exception.
   * AUTO_FLUSH_BACKGROUND: the call returns when the operation has been added to the buffer. This call should normally perform only fast in-memory operations but it may have to wait when the buffer is full and there's another buffer being flushed.
   * MANUAL_FLUSH: the call returns when the operation has been added to the buffer, else it throws a KuduException if the buffer is full.
   */
  public final PutKudu setFlushMode(final String flushMode) {
    properties.put(FLUSH_MODE_PROPERTY, flushMode);
    return this;
  }

  /**
   * Set the new flush mode for a kudu session.
   * AUTO_FLUSH_SYNC: the call returns when the operation is persisted, else it throws an exception.
   * AUTO_FLUSH_BACKGROUND: the call returns when the operation has been added to the buffer. This call should normally perform only fast in-memory operations but it may have to wait when the buffer is full and there's another buffer being flushed.
   * MANUAL_FLUSH: the call returns when the operation has been added to the buffer, else it throws a KuduException if the buffer is full.
   */
  public final PutKudu removeFlushMode() {
    properties.remove(FLUSH_MODE_PROPERTY);
    return this;
  }

  /**
   * The maximum number of FlowFiles to process in a single execution, between 1 - 100000. Depending on your memory size, and data size per row set an appropriate batch size. Gradually increase this number to find out the best one for best performances.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of FlowFiles to process in a single execution, between 1 - 100000. Depending on your memory size, and data size per row set an appropriate batch size. Gradually increase this number to find out the best one for best performances.
   */
  public final PutKudu setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of FlowFiles to process in a single execution, between 1 - 100000. Depending on your memory size, and data size per row set an appropriate batch size. Gradually increase this number to find out the best one for best performances.
   */
  public final PutKudu removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutKudu setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutKudu removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutKudu, PutKudu> configurator) {
    return configurator.apply(new PutKudu()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutKudu.class) final Closure<PutKudu> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kudu.PutKudu> code = closure.rehydrate(c, com.tibtech.nifi.processors.kudu.PutKudu.class, com.tibtech.nifi.processors.kudu.PutKudu.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutKudu, PutKudu> configurator) {
    return configurator.apply(new PutKudu(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutKudu.class) final Closure<PutKudu> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kudu.PutKudu> code = closure.rehydrate(c, com.tibtech.nifi.processors.kudu.PutKudu.class, com.tibtech.nifi.processors.kudu.PutKudu.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
