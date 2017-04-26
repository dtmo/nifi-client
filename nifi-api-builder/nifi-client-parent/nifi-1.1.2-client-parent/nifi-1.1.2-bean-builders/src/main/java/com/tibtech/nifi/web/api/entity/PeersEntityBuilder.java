package com.tibtech.nifi.web.api.entity;

import java.util.Collection;
import org.apache.nifi.web.api.dto.remote.PeerDTO;
import org.apache.nifi.web.api.entity.PeersEntity;

public final class PeersEntityBuilder extends AbstractEntityBuilder<PeersEntityBuilder> {
  private Collection<PeerDTO> peers;

  public Collection<PeerDTO> getPeers() {
    return peers;
  }

  public PeersEntityBuilder setPeers(final Collection<PeerDTO> peers) {
    this.peers = peers;
    return this;
  }

  public PeersEntity build() {
    final PeersEntity peersEntity = new PeersEntity();
    super.setPropertyValues(peersEntity);
    peersEntity.setPeers(peers);
    return peersEntity;
  }

  public static PeersEntityBuilder of(final PeersEntity peersEntity) {
    final PeersEntityBuilder peersEntityBuilder = new PeersEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(peersEntityBuilder, peersEntity);
    peersEntityBuilder.setPeers(peersEntity.getPeers());
    return peersEntityBuilder;
  }
}
