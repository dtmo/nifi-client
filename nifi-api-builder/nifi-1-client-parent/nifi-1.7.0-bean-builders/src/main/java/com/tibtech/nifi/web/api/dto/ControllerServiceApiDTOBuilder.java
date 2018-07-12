package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.BundleDTO;
import org.apache.nifi.web.api.dto.ControllerServiceApiDTO;

public final class ControllerServiceApiDTOBuilder {
  private BundleDTO bundle;

  private String type;

  /**
   * The details of the artifact that bundled this service interface.
   */
  public BundleDTO getBundle() {
    return bundle;
  }

  /**
   * The details of the artifact that bundled this service interface.
   */
  public ControllerServiceApiDTOBuilder setBundle(final BundleDTO bundle) {
    this.bundle = bundle;
    return this;
  }

  /**
   * The details of the artifact that bundled this service interface.
   */
  public ControllerServiceApiDTOBuilder setBundle(final Consumer<BundleDTOBuilder> configurator) {
    final BundleDTOBuilder builder = (bundle != null ? BundleDTOBuilder.of(bundle) : new BundleDTOBuilder());
    configurator.accept(builder);
    return setBundle(builder.build());
  }

  /**
   * The details of the artifact that bundled this service interface.
   */
  public ControllerServiceApiDTOBuilder setBundle(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BundleDTOBuilder.class) final Closure<BundleDTOBuilder> closure) {
    return setBundle(c -> {
      final Closure<BundleDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The fully qualified name of the service interface.
   */
  public String getType() {
    return type;
  }

  /**
   * The fully qualified name of the service interface.
   */
  public ControllerServiceApiDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  public ControllerServiceApiDTO build() {
    final ControllerServiceApiDTO controllerServiceApiDTO = new ControllerServiceApiDTO();
    controllerServiceApiDTO.setBundle(bundle);
    controllerServiceApiDTO.setType(type);
    return controllerServiceApiDTO;
  }

  public static ControllerServiceApiDTOBuilder of(
      final ControllerServiceApiDTO controllerServiceApiDTO) {
    final ControllerServiceApiDTOBuilder controllerServiceApiDTOBuilder = new ControllerServiceApiDTOBuilder();
    controllerServiceApiDTOBuilder.setBundle(controllerServiceApiDTO.getBundle());
    controllerServiceApiDTOBuilder.setType(controllerServiceApiDTO.getType());
    return controllerServiceApiDTOBuilder;
  }
}
