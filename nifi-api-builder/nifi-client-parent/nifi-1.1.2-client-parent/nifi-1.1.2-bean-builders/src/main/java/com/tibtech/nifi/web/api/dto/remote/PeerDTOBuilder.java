package com.tibtech.nifi.web.api.dto.remote;

import java.lang.String;
import org.apache.nifi.web.api.dto.remote.PeerDTO;

public final class PeerDTOBuilder {
  private int flowFileCount;

  private String hostname;

  private int port;

  private boolean secure;

  /**
   * The number of flowFiles this peer holds.
   */
  public int getFlowFileCount() {
    return flowFileCount;
  }

  /**
   * The number of flowFiles this peer holds.
   */
  public PeerDTOBuilder setFlowFileCount(final int flowFileCount) {
    this.flowFileCount = flowFileCount;
    return this;
  }

  /**
   * The hostname of this peer.
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * The hostname of this peer.
   */
  public PeerDTOBuilder setHostname(final String hostname) {
    this.hostname = hostname;
    return this;
  }

  /**
   * The port number of this peer.
   */
  public int getPort() {
    return port;
  }

  /**
   * The port number of this peer.
   */
  public PeerDTOBuilder setPort(final int port) {
    this.port = port;
    return this;
  }

  /**
   * Returns if this peer connection is secure.
   */
  public boolean getSecure() {
    return secure;
  }

  /**
   * Returns if this peer connection is secure.
   */
  public PeerDTOBuilder setSecure(final boolean secure) {
    this.secure = secure;
    return this;
  }

  public PeerDTO build() {
    final PeerDTO peerDTO = new PeerDTO();
    peerDTO.setFlowFileCount(flowFileCount);
    peerDTO.setHostname(hostname);
    peerDTO.setPort(port);
    peerDTO.setSecure(secure);
    return peerDTO;
  }

  public static PeerDTOBuilder of(final PeerDTO peerDTO) {
    final PeerDTOBuilder peerDTOBuilder = new PeerDTOBuilder();
    peerDTOBuilder.setFlowFileCount(peerDTO.getFlowFileCount());
    peerDTOBuilder.setHostname(peerDTO.getHostname());
    peerDTOBuilder.setPort(peerDTO.getPort());
    peerDTOBuilder.setSecure(peerDTO.isSecure());
    return peerDTOBuilder;
  }
}
