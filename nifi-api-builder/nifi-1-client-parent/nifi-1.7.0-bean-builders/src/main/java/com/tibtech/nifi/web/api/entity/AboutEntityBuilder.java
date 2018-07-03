package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.AboutDTO;
import org.apache.nifi.web.api.entity.AboutEntity;

public final class AboutEntityBuilder extends AbstractEntityBuilder<AboutEntityBuilder> {
  private AboutDTO about;

  public AboutDTO getAbout() {
    return about;
  }

  public AboutEntityBuilder setAbout(final AboutDTO about) {
    this.about = about;
    return this;
  }

  public AboutEntity build() {
    final AboutEntity aboutEntity = new AboutEntity();
    super.setPropertyValues(aboutEntity);
    aboutEntity.setAbout(about);
    return aboutEntity;
  }

  public static AboutEntityBuilder of(final AboutEntity aboutEntity) {
    final AboutEntityBuilder aboutEntityBuilder = new AboutEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(aboutEntityBuilder, aboutEntity);
    aboutEntityBuilder.setAbout(aboutEntity.getAbout());
    return aboutEntityBuilder;
  }
}
