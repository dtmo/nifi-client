package com.tibtech.nifi.processors.avro;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SplitAvro {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.avro.SplitAvro";

  /**
   * The strategy for splitting the incoming datafile. The Record strategy will read the incoming datafile by de-serializing each record.
   */
  public static final String SPLIT_STRATEGY_PROPERTY = "Split Strategy";

  /**
   * The number of Avro records to include per split file. In cases where the incoming file has less records than the Output Size, or when the total number of records does not divide evenly by the Output Size, it is possible to get a split file with less records.
   */
  public static final String OUTPUT_SIZE_PROPERTY = "Output Size";

  /**
   * Determines the format of the output. Either Avro Datafile, or bare record. Bare record output is only intended for use with systems that already require it, and shouldn't be needed for normal use.
   */
  public static final String OUTPUT_STRATEGY_PROPERTY = "Output Strategy";

  /**
   * Whether or not to transfer metadata from the parent datafile to the children. If the Output Strategy is Bare Record, then the metadata will be stored as FlowFile attributes, otherwise it will be in the Datafile header.
   */
  public static final String TRANSFER_METADATA_PROPERTY = "Transfer Metadata";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The strategy for splitting the incoming datafile. The Record strategy will read the incoming datafile by de-serializing each record.
   */
  public final String getSplitStrategy() {
    return properties.get(SPLIT_STRATEGY_PROPERTY);
  }

  /**
   * The strategy for splitting the incoming datafile. The Record strategy will read the incoming datafile by de-serializing each record.
   */
  public final SplitAvro setSplitStrategy(final String splitStrategy) {
    properties.put(SPLIT_STRATEGY_PROPERTY, splitStrategy);
    return this;
  }

  /**
   * The strategy for splitting the incoming datafile. The Record strategy will read the incoming datafile by de-serializing each record.
   */
  public final SplitAvro removeSplitStrategy() {
    properties.remove(SPLIT_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The number of Avro records to include per split file. In cases where the incoming file has less records than the Output Size, or when the total number of records does not divide evenly by the Output Size, it is possible to get a split file with less records.
   */
  public final String getOutputSize() {
    return properties.get(OUTPUT_SIZE_PROPERTY);
  }

  /**
   * The number of Avro records to include per split file. In cases where the incoming file has less records than the Output Size, or when the total number of records does not divide evenly by the Output Size, it is possible to get a split file with less records.
   */
  public final SplitAvro setOutputSize(final String outputSize) {
    properties.put(OUTPUT_SIZE_PROPERTY, outputSize);
    return this;
  }

  /**
   * The number of Avro records to include per split file. In cases where the incoming file has less records than the Output Size, or when the total number of records does not divide evenly by the Output Size, it is possible to get a split file with less records.
   */
  public final SplitAvro removeOutputSize() {
    properties.remove(OUTPUT_SIZE_PROPERTY);
    return this;
  }

  /**
   * Determines the format of the output. Either Avro Datafile, or bare record. Bare record output is only intended for use with systems that already require it, and shouldn't be needed for normal use.
   */
  public final String getOutputStrategy() {
    return properties.get(OUTPUT_STRATEGY_PROPERTY);
  }

  /**
   * Determines the format of the output. Either Avro Datafile, or bare record. Bare record output is only intended for use with systems that already require it, and shouldn't be needed for normal use.
   */
  public final SplitAvro setOutputStrategy(final String outputStrategy) {
    properties.put(OUTPUT_STRATEGY_PROPERTY, outputStrategy);
    return this;
  }

  /**
   * Determines the format of the output. Either Avro Datafile, or bare record. Bare record output is only intended for use with systems that already require it, and shouldn't be needed for normal use.
   */
  public final SplitAvro removeOutputStrategy() {
    properties.remove(OUTPUT_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Whether or not to transfer metadata from the parent datafile to the children. If the Output Strategy is Bare Record, then the metadata will be stored as FlowFile attributes, otherwise it will be in the Datafile header.
   */
  public final String getTransferMetadata() {
    return properties.get(TRANSFER_METADATA_PROPERTY);
  }

  /**
   * Whether or not to transfer metadata from the parent datafile to the children. If the Output Strategy is Bare Record, then the metadata will be stored as FlowFile attributes, otherwise it will be in the Datafile header.
   */
  public final SplitAvro setTransferMetadata(final String transferMetadata) {
    properties.put(TRANSFER_METADATA_PROPERTY, transferMetadata);
    return this;
  }

  /**
   * Whether or not to transfer metadata from the parent datafile to the children. If the Output Strategy is Bare Record, then the metadata will be stored as FlowFile attributes, otherwise it will be in the Datafile header.
   */
  public final SplitAvro removeTransferMetadata() {
    properties.remove(TRANSFER_METADATA_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SplitAvro setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SplitAvro removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<SplitAvro, SplitAvro> configurator) {
    return configurator.apply(new SplitAvro()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitAvro.class) final Closure<SplitAvro> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.avro.SplitAvro> code = closure.rehydrate(c, com.tibtech.nifi.processors.avro.SplitAvro.class, com.tibtech.nifi.processors.avro.SplitAvro.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
