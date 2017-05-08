package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.BannerDTO;

public final class BannerDTOBuilder {
  private String footerText;

  private String headerText;

  /**
   * The footer text.
   */
  public String getFooterText() {
    return footerText;
  }

  /**
   * The footer text.
   */
  public BannerDTOBuilder setFooterText(final String footerText) {
    this.footerText = footerText;
    return this;
  }

  /**
   * The header text.
   */
  public String getHeaderText() {
    return headerText;
  }

  /**
   * The header text.
   */
  public BannerDTOBuilder setHeaderText(final String headerText) {
    this.headerText = headerText;
    return this;
  }

  public BannerDTO build() {
    final BannerDTO bannerDTO = new BannerDTO();
    bannerDTO.setFooterText(footerText);
    bannerDTO.setHeaderText(headerText);
    return bannerDTO;
  }

  public static BannerDTOBuilder of(final BannerDTO bannerDTO) {
    final BannerDTOBuilder bannerDTOBuilder = new BannerDTOBuilder();
    bannerDTOBuilder.setFooterText(bannerDTO.getFooterText());
    bannerDTOBuilder.setHeaderText(bannerDTO.getHeaderText());
    return bannerDTOBuilder;
  }
}
