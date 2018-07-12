package com.tibtech.nifi.web.api.dto.diagnostics;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.diagnostics.ConnectionDiagnosticsDTO;

public final class ConnectionDiagnosticsDTOBuilder {
  private long activeQueueByteCount;

  private int activeQueueFlowFileCount;

  private Boolean allActiveQueueFlowFilesPenalized;

  private Boolean anyActiveQueueFlowFilesPenalized;

  private ConnectionDTO connection;

  private long inFlightByteCount;

  private int inFlightFlowFileCount;

  private long swapByteCount;

  private int swapFiles;

  private int swapFlowFileCount;

  private long totalByteCount;

  private int totalFlowFileCount;

  /**
   * Total number of bytes that make up the content for the FlowFiles that are present in the Connection's Active Queue
   */
  public long getActiveQueueByteCount() {
    return activeQueueByteCount;
  }

  /**
   * Total number of bytes that make up the content for the FlowFiles that are present in the Connection's Active Queue
   */
  public ConnectionDiagnosticsDTOBuilder setActiveQueueByteCount(final long activeQueueByteCount) {
    this.activeQueueByteCount = activeQueueByteCount;
    return this;
  }

  /**
   * Total number of FlowFiles that exist in the Connection's Active Queue, immediately available to be offered up to a component
   */
  public int getActiveQueueFlowFileCount() {
    return activeQueueFlowFileCount;
  }

  /**
   * Total number of FlowFiles that exist in the Connection's Active Queue, immediately available to be offered up to a component
   */
  public ConnectionDiagnosticsDTOBuilder setActiveQueueFlowFileCount(
      final int activeQueueFlowFileCount) {
    this.activeQueueFlowFileCount = activeQueueFlowFileCount;
    return this;
  }

  /**
   * Whether or not all of the FlowFiles in the Active Queue are penalized
   */
  public Boolean getAllActiveQueueFlowFilesPenalized() {
    return allActiveQueueFlowFilesPenalized;
  }

  /**
   * Whether or not all of the FlowFiles in the Active Queue are penalized
   */
  public ConnectionDiagnosticsDTOBuilder setAllActiveQueueFlowFilesPenalized(
      final Boolean allActiveQueueFlowFilesPenalized) {
    this.allActiveQueueFlowFilesPenalized = allActiveQueueFlowFilesPenalized;
    return this;
  }

  /**
   * Whether or not any of the FlowFiles in the Active Queue are penalized
   */
  public Boolean getAnyActiveQueueFlowFilesPenalized() {
    return anyActiveQueueFlowFilesPenalized;
  }

  /**
   * Whether or not any of the FlowFiles in the Active Queue are penalized
   */
  public ConnectionDiagnosticsDTOBuilder setAnyActiveQueueFlowFilesPenalized(
      final Boolean anyActiveQueueFlowFilesPenalized) {
    this.anyActiveQueueFlowFilesPenalized = anyActiveQueueFlowFilesPenalized;
    return this;
  }

  /**
   * Information about the Connection
   */
  public ConnectionDTO getConnection() {
    return connection;
  }

  /**
   * Information about the Connection
   */
  public ConnectionDiagnosticsDTOBuilder setConnection(final ConnectionDTO connection) {
    this.connection = connection;
    return this;
  }

  /**
   * Information about the Connection
   */
  public ConnectionDiagnosticsDTOBuilder setConnection(
      final Consumer<ConnectionDTOBuilder> configurator) {
    final ConnectionDTOBuilder builder = (connection != null ? ConnectionDTOBuilder.of(connection) : new ConnectionDTOBuilder());
    configurator.accept(builder);
    return setConnection(builder.build());
  }

  /**
   * Information about the Connection
   */
  public ConnectionDiagnosticsDTOBuilder setConnection(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionDTOBuilder.class) final Closure<ConnectionDTOBuilder> closure) {
    return setConnection(c -> {
      final Closure<ConnectionDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The number bytes that make up the content of the FlowFiles that are In-Flight
   */
  public long getInFlightByteCount() {
    return inFlightByteCount;
  }

  /**
   * The number bytes that make up the content of the FlowFiles that are In-Flight
   */
  public ConnectionDiagnosticsDTOBuilder setInFlightByteCount(final long inFlightByteCount) {
    this.inFlightByteCount = inFlightByteCount;
    return this;
  }

  /**
   * The number of In-Flight FlowFiles for this Connection. These are FlowFiles that belong to the connection but are currently being operated on by a Processor, Port, etc.
   */
  public int getInFlightFlowFileCount() {
    return inFlightFlowFileCount;
  }

  /**
   * The number of In-Flight FlowFiles for this Connection. These are FlowFiles that belong to the connection but are currently being operated on by a Processor, Port, etc.
   */
  public ConnectionDiagnosticsDTOBuilder setInFlightFlowFileCount(final int inFlightFlowFileCount) {
    this.inFlightFlowFileCount = inFlightFlowFileCount;
    return this;
  }

  /**
   * Total number of bytes that make up the content for the FlowFiles that are swapped out to disk for the Connection
   */
  public long getSwapByteCount() {
    return swapByteCount;
  }

  /**
   * Total number of bytes that make up the content for the FlowFiles that are swapped out to disk for the Connection
   */
  public ConnectionDiagnosticsDTOBuilder setSwapByteCount(final long swapByteCount) {
    this.swapByteCount = swapByteCount;
    return this;
  }

  /**
   * The number of Swap Files that exist for this Connection
   */
  public int getSwapFiles() {
    return swapFiles;
  }

  /**
   * The number of Swap Files that exist for this Connection
   */
  public ConnectionDiagnosticsDTOBuilder setSwapFiles(final int swapFiles) {
    this.swapFiles = swapFiles;
    return this;
  }

  /**
   * The total number of FlowFiles that are swapped out for this Connection
   */
  public int getSwapFlowFileCount() {
    return swapFlowFileCount;
  }

  /**
   * The total number of FlowFiles that are swapped out for this Connection
   */
  public ConnectionDiagnosticsDTOBuilder setSwapFlowFileCount(final int swapFlowFileCount) {
    this.swapFlowFileCount = swapFlowFileCount;
    return this;
  }

  /**
   * Total number of bytes that make up the content for the FlowFiles owned by this Connection
   */
  public long getTotalByteCount() {
    return totalByteCount;
  }

  /**
   * Total number of bytes that make up the content for the FlowFiles owned by this Connection
   */
  public ConnectionDiagnosticsDTOBuilder setTotalByteCount(final long totalByteCount) {
    this.totalByteCount = totalByteCount;
    return this;
  }

  /**
   * Total number of FlowFiles owned by the Connection
   */
  public int getTotalFlowFileCount() {
    return totalFlowFileCount;
  }

  /**
   * Total number of FlowFiles owned by the Connection
   */
  public ConnectionDiagnosticsDTOBuilder setTotalFlowFileCount(final int totalFlowFileCount) {
    this.totalFlowFileCount = totalFlowFileCount;
    return this;
  }

  public ConnectionDiagnosticsDTO build() {
    final ConnectionDiagnosticsDTO connectionDiagnosticsDTO = new ConnectionDiagnosticsDTO();
    connectionDiagnosticsDTO.setActiveQueueByteCount(activeQueueByteCount);
    connectionDiagnosticsDTO.setActiveQueueFlowFileCount(activeQueueFlowFileCount);
    connectionDiagnosticsDTO.setAllActiveQueueFlowFilesPenalized(allActiveQueueFlowFilesPenalized);
    connectionDiagnosticsDTO.setAnyActiveQueueFlowFilesPenalized(anyActiveQueueFlowFilesPenalized);
    connectionDiagnosticsDTO.setConnection(connection);
    connectionDiagnosticsDTO.setInFlightByteCount(inFlightByteCount);
    connectionDiagnosticsDTO.setInFlightFlowFileCount(inFlightFlowFileCount);
    connectionDiagnosticsDTO.setSwapByteCount(swapByteCount);
    connectionDiagnosticsDTO.setSwapFiles(swapFiles);
    connectionDiagnosticsDTO.setSwapFlowFileCount(swapFlowFileCount);
    connectionDiagnosticsDTO.setTotalByteCount(totalByteCount);
    connectionDiagnosticsDTO.setTotalFlowFileCount(totalFlowFileCount);
    return connectionDiagnosticsDTO;
  }

  public static ConnectionDiagnosticsDTOBuilder of(
      final ConnectionDiagnosticsDTO connectionDiagnosticsDTO) {
    final ConnectionDiagnosticsDTOBuilder connectionDiagnosticsDTOBuilder = new ConnectionDiagnosticsDTOBuilder();
    connectionDiagnosticsDTOBuilder.setActiveQueueByteCount(connectionDiagnosticsDTO.getActiveQueueByteCount());
    connectionDiagnosticsDTOBuilder.setActiveQueueFlowFileCount(connectionDiagnosticsDTO.getActiveQueueFlowFileCount());
    connectionDiagnosticsDTOBuilder.setAllActiveQueueFlowFilesPenalized(connectionDiagnosticsDTO.getAllActiveQueueFlowFilesPenalized());
    connectionDiagnosticsDTOBuilder.setAnyActiveQueueFlowFilesPenalized(connectionDiagnosticsDTO.getAnyActiveQueueFlowFilesPenalized());
    connectionDiagnosticsDTOBuilder.setConnection(connectionDiagnosticsDTO.getConnection());
    connectionDiagnosticsDTOBuilder.setInFlightByteCount(connectionDiagnosticsDTO.getInFlightByteCount());
    connectionDiagnosticsDTOBuilder.setInFlightFlowFileCount(connectionDiagnosticsDTO.getInFlightFlowFileCount());
    connectionDiagnosticsDTOBuilder.setSwapByteCount(connectionDiagnosticsDTO.getSwapByteCount());
    connectionDiagnosticsDTOBuilder.setSwapFiles(connectionDiagnosticsDTO.getSwapFiles());
    connectionDiagnosticsDTOBuilder.setSwapFlowFileCount(connectionDiagnosticsDTO.getSwapFlowFileCount());
    connectionDiagnosticsDTOBuilder.setTotalByteCount(connectionDiagnosticsDTO.getTotalByteCount());
    connectionDiagnosticsDTOBuilder.setTotalFlowFileCount(connectionDiagnosticsDTO.getTotalFlowFileCount());
    return connectionDiagnosticsDTOBuilder;
  }
}
