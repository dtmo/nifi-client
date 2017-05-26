package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.BannerDTO;
import org.apache.nifi.web.api.entity.BannerEntity;

public final class BannerEntityBuilder extends AbstractEntityBuilder<BannerEntityBuilder> {
  private BannerDTO banners;

  public BannerDTO getBanners() {
    return banners;
  }

  public BannerEntityBuilder setBanners(final BannerDTO banners) {
    this.banners = banners;
    return this;
  }

  public BannerEntity build() {
    final BannerEntity bannerEntity = new BannerEntity();
    super.setPropertyValues(bannerEntity);
    bannerEntity.setBanners(banners);
    return bannerEntity;
  }

  public static BannerEntityBuilder of(final BannerEntity bannerEntity) {
    final BannerEntityBuilder bannerEntityBuilder = new BannerEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(bannerEntityBuilder, bannerEntity);
    bannerEntityBuilder.setBanners(bannerEntity.getBanners());
    return bannerEntityBuilder;
  }
}
