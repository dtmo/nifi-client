package com.tibtech.nifi.web.api.dto;

import java.util.Date;
import java.util.List;
import org.apache.nifi.web.api.dto.BulletinBoardDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;

public final class BulletinBoardDTOBuilder {
  private List<BulletinEntity> bulletins;

  private Date generated;

  /**
   * The bulletins in the bulletin board, that matches the supplied request.
   */
  public List<BulletinEntity> getBulletins() {
    return bulletins;
  }

  /**
   * The bulletins in the bulletin board, that matches the supplied request.
   */
  public BulletinBoardDTOBuilder setBulletins(final List<BulletinEntity> bulletins) {
    this.bulletins = bulletins;
    return this;
  }

  /**
   * The timestamp when this report was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * The timestamp when this report was generated.
   */
  public BulletinBoardDTOBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  public BulletinBoardDTO build() {
    final BulletinBoardDTO bulletinBoardDTO = new BulletinBoardDTO();
    bulletinBoardDTO.setBulletins(bulletins);
    bulletinBoardDTO.setGenerated(generated);
    return bulletinBoardDTO;
  }

  public static BulletinBoardDTOBuilder of(final BulletinBoardDTO bulletinBoardDTO) {
    final BulletinBoardDTOBuilder bulletinBoardDTOBuilder = new BulletinBoardDTOBuilder();
    bulletinBoardDTOBuilder.setBulletins(bulletinBoardDTO.getBulletins());
    bulletinBoardDTOBuilder.setGenerated(bulletinBoardDTO.getGenerated());
    return bulletinBoardDTOBuilder;
  }
}
