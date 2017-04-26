package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.entity.BulletinBoardEntity;

public final class BulletinBoardEntityBuilder extends AbstractEntityBuilder<BulletinBoardEntityBuilder> {
  public BulletinBoardEntity build() {
    final BulletinBoardEntity bulletinBoardEntity = new BulletinBoardEntity();
    super.setPropertyValues(bulletinBoardEntity);
    return bulletinBoardEntity;
  }

  public static BulletinBoardEntityBuilder of(final BulletinBoardEntity bulletinBoardEntity) {
    final BulletinBoardEntityBuilder bulletinBoardEntityBuilder = new BulletinBoardEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(bulletinBoardEntityBuilder, bulletinBoardEntity);
    return bulletinBoardEntityBuilder;
  }
}
