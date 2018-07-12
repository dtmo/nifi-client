package com.tibtech.nifi.web.api.dto;

import java.util.Set;
import org.apache.nifi.web.api.dto.RemoteProcessGroupContentsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

public final class RemoteProcessGroupContentsDTOBuilder {
  private Set<RemoteProcessGroupPortDTO> inputPorts;

  private Set<RemoteProcessGroupPortDTO> outputPorts;

  /**
   * The input ports to which data can be sent.
   */
  public Set<RemoteProcessGroupPortDTO> getInputPorts() {
    return inputPorts;
  }

  /**
   * The input ports to which data can be sent.
   */
  public RemoteProcessGroupContentsDTOBuilder setInputPorts(
      final Set<RemoteProcessGroupPortDTO> inputPorts) {
    this.inputPorts = inputPorts;
    return this;
  }

  /**
   * The output ports from which data can be retrieved.
   */
  public Set<RemoteProcessGroupPortDTO> getOutputPorts() {
    return outputPorts;
  }

  /**
   * The output ports from which data can be retrieved.
   */
  public RemoteProcessGroupContentsDTOBuilder setOutputPorts(
      final Set<RemoteProcessGroupPortDTO> outputPorts) {
    this.outputPorts = outputPorts;
    return this;
  }

  public RemoteProcessGroupContentsDTO build() {
    final RemoteProcessGroupContentsDTO remoteProcessGroupContentsDTO = new RemoteProcessGroupContentsDTO();
    remoteProcessGroupContentsDTO.setInputPorts(inputPorts);
    remoteProcessGroupContentsDTO.setOutputPorts(outputPorts);
    return remoteProcessGroupContentsDTO;
  }

  public static RemoteProcessGroupContentsDTOBuilder of(
      final RemoteProcessGroupContentsDTO remoteProcessGroupContentsDTO) {
    final RemoteProcessGroupContentsDTOBuilder remoteProcessGroupContentsDTOBuilder = new RemoteProcessGroupContentsDTOBuilder();
    remoteProcessGroupContentsDTOBuilder.setInputPorts(remoteProcessGroupContentsDTO.getInputPorts());
    remoteProcessGroupContentsDTOBuilder.setOutputPorts(remoteProcessGroupContentsDTO.getOutputPorts());
    return remoteProcessGroupContentsDTOBuilder;
  }
}
