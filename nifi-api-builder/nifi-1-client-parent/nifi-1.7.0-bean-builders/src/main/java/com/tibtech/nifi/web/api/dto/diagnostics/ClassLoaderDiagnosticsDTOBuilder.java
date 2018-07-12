package com.tibtech.nifi.web.api.dto.diagnostics;

import com.tibtech.nifi.web.api.dto.BundleDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.BundleDTO;
import org.apache.nifi.web.api.dto.diagnostics.ClassLoaderDiagnosticsDTO;

public final class ClassLoaderDiagnosticsDTOBuilder {
  private BundleDTO bundle;

  private ClassLoaderDiagnosticsDTO parentClassLoader;

  /**
   * Information about the Bundle that the ClassLoader belongs to, if any
   */
  public BundleDTO getBundle() {
    return bundle;
  }

  /**
   * Information about the Bundle that the ClassLoader belongs to, if any
   */
  public ClassLoaderDiagnosticsDTOBuilder setBundle(final BundleDTO bundle) {
    this.bundle = bundle;
    return this;
  }

  /**
   * Information about the Bundle that the ClassLoader belongs to, if any
   */
  public ClassLoaderDiagnosticsDTOBuilder setBundle(final Consumer<BundleDTOBuilder> configurator) {
    final BundleDTOBuilder builder = (bundle != null ? BundleDTOBuilder.of(bundle) : new BundleDTOBuilder());
    configurator.accept(builder);
    return setBundle(builder.build());
  }

  /**
   * Information about the Bundle that the ClassLoader belongs to, if any
   */
  public ClassLoaderDiagnosticsDTOBuilder setBundle(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BundleDTOBuilder.class) final Closure<BundleDTOBuilder> closure) {
    return setBundle(c -> {
      final Closure<BundleDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * A ClassLoaderDiagnosticsDTO that provides information about the parent ClassLoader
   */
  public ClassLoaderDiagnosticsDTO getParentClassLoader() {
    return parentClassLoader;
  }

  /**
   * A ClassLoaderDiagnosticsDTO that provides information about the parent ClassLoader
   */
  public ClassLoaderDiagnosticsDTOBuilder setParentClassLoader(
      final ClassLoaderDiagnosticsDTO parentClassLoader) {
    this.parentClassLoader = parentClassLoader;
    return this;
  }

  /**
   * A ClassLoaderDiagnosticsDTO that provides information about the parent ClassLoader
   */
  public ClassLoaderDiagnosticsDTOBuilder setParentClassLoader(
      final Consumer<ClassLoaderDiagnosticsDTOBuilder> configurator) {
    final ClassLoaderDiagnosticsDTOBuilder builder = (parentClassLoader != null ? ClassLoaderDiagnosticsDTOBuilder.of(parentClassLoader) : new ClassLoaderDiagnosticsDTOBuilder());
    configurator.accept(builder);
    return setParentClassLoader(builder.build());
  }

  /**
   * A ClassLoaderDiagnosticsDTO that provides information about the parent ClassLoader
   */
  public ClassLoaderDiagnosticsDTOBuilder setParentClassLoader(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ClassLoaderDiagnosticsDTOBuilder.class) final Closure<ClassLoaderDiagnosticsDTOBuilder> closure) {
    return setParentClassLoader(c -> {
      final Closure<ClassLoaderDiagnosticsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public ClassLoaderDiagnosticsDTO build() {
    final ClassLoaderDiagnosticsDTO classLoaderDiagnosticsDTO = new ClassLoaderDiagnosticsDTO();
    classLoaderDiagnosticsDTO.setBundle(bundle);
    classLoaderDiagnosticsDTO.setParentClassLoader(parentClassLoader);
    return classLoaderDiagnosticsDTO;
  }

  public static ClassLoaderDiagnosticsDTOBuilder of(
      final ClassLoaderDiagnosticsDTO classLoaderDiagnosticsDTO) {
    final ClassLoaderDiagnosticsDTOBuilder classLoaderDiagnosticsDTOBuilder = new ClassLoaderDiagnosticsDTOBuilder();
    classLoaderDiagnosticsDTOBuilder.setBundle(classLoaderDiagnosticsDTO.getBundle());
    classLoaderDiagnosticsDTOBuilder.setParentClassLoader(classLoaderDiagnosticsDTO.getParentClassLoader());
    return classLoaderDiagnosticsDTOBuilder;
  }
}
