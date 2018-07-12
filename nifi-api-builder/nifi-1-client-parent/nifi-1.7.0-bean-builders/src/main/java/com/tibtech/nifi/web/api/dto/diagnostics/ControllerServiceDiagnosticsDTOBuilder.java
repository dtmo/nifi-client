package com.tibtech.nifi.web.api.dto.diagnostics;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.diagnostics.ClassLoaderDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.ControllerServiceDiagnosticsDTO;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;

public final class ControllerServiceDiagnosticsDTOBuilder {
  private ClassLoaderDiagnosticsDTO classLoaderDiagnostics;

  private ControllerServiceEntity controllerService;

  /**
   * Information about the Controller Service's Class Loader
   */
  public ClassLoaderDiagnosticsDTO getClassLoaderDiagnostics() {
    return classLoaderDiagnostics;
  }

  /**
   * Information about the Controller Service's Class Loader
   */
  public ControllerServiceDiagnosticsDTOBuilder setClassLoaderDiagnostics(
      final ClassLoaderDiagnosticsDTO classLoaderDiagnostics) {
    this.classLoaderDiagnostics = classLoaderDiagnostics;
    return this;
  }

  /**
   * Information about the Controller Service's Class Loader
   */
  public ControllerServiceDiagnosticsDTOBuilder setClassLoaderDiagnostics(
      final Consumer<ClassLoaderDiagnosticsDTOBuilder> configurator) {
    final ClassLoaderDiagnosticsDTOBuilder builder = (classLoaderDiagnostics != null ? ClassLoaderDiagnosticsDTOBuilder.of(classLoaderDiagnostics) : new ClassLoaderDiagnosticsDTOBuilder());
    configurator.accept(builder);
    return setClassLoaderDiagnostics(builder.build());
  }

  /**
   * Information about the Controller Service's Class Loader
   */
  public ControllerServiceDiagnosticsDTOBuilder setClassLoaderDiagnostics(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ClassLoaderDiagnosticsDTOBuilder.class) final Closure<ClassLoaderDiagnosticsDTOBuilder> closure) {
    return setClassLoaderDiagnostics(c -> {
      final Closure<ClassLoaderDiagnosticsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The Controller Service
   */
  public ControllerServiceEntity getControllerService() {
    return controllerService;
  }

  /**
   * The Controller Service
   */
  public ControllerServiceDiagnosticsDTOBuilder setControllerService(
      final ControllerServiceEntity controllerService) {
    this.controllerService = controllerService;
    return this;
  }

  public ControllerServiceDiagnosticsDTO build() {
    final ControllerServiceDiagnosticsDTO controllerServiceDiagnosticsDTO = new ControllerServiceDiagnosticsDTO();
    controllerServiceDiagnosticsDTO.setClassLoaderDiagnostics(classLoaderDiagnostics);
    controllerServiceDiagnosticsDTO.setControllerService(controllerService);
    return controllerServiceDiagnosticsDTO;
  }

  public static ControllerServiceDiagnosticsDTOBuilder of(
      final ControllerServiceDiagnosticsDTO controllerServiceDiagnosticsDTO) {
    final ControllerServiceDiagnosticsDTOBuilder controllerServiceDiagnosticsDTOBuilder = new ControllerServiceDiagnosticsDTOBuilder();
    controllerServiceDiagnosticsDTOBuilder.setClassLoaderDiagnostics(controllerServiceDiagnosticsDTO.getClassLoaderDiagnostics());
    controllerServiceDiagnosticsDTOBuilder.setControllerService(controllerServiceDiagnosticsDTO.getControllerService());
    return controllerServiceDiagnosticsDTOBuilder;
  }
}
