package com.tibtech.nifi.processors.image;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ResizeImage {
  /**
   * The desired number of pixels for the image's width
   */
  public static final String IMAGE_WIDTH_IN_PIXELS_PROPERTY = "Image Width (in pixels)";

  /**
   * The desired number of pixels for the image's height
   */
  public static final String IMAGE_HEIGHT_IN_PIXELS_PROPERTY = "Image Height (in pixels)";

  /**
   * Specifies which algorithm should be used to resize the image
   */
  public static final String SCALING_ALGORITHM_PROPERTY = "Scaling Algorithm";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The desired number of pixels for the image's width
   */
  public final String getImageWidthInPixels() {
    return properties.get(IMAGE_WIDTH_IN_PIXELS_PROPERTY);
  }

  /**
   * The desired number of pixels for the image's width
   */
  public final ResizeImage setImageWidthInPixels(final String imageWidthInPixels) {
    properties.put(IMAGE_WIDTH_IN_PIXELS_PROPERTY, imageWidthInPixels);
    return this;
  }

  /**
   * The desired number of pixels for the image's width
   */
  public final ResizeImage removeImageWidthInPixels() {
    properties.remove(IMAGE_WIDTH_IN_PIXELS_PROPERTY);
    return this;
  }

  /**
   * The desired number of pixels for the image's height
   */
  public final String getImageHeightInPixels() {
    return properties.get(IMAGE_HEIGHT_IN_PIXELS_PROPERTY);
  }

  /**
   * The desired number of pixels for the image's height
   */
  public final ResizeImage setImageHeightInPixels(final String imageHeightInPixels) {
    properties.put(IMAGE_HEIGHT_IN_PIXELS_PROPERTY, imageHeightInPixels);
    return this;
  }

  /**
   * The desired number of pixels for the image's height
   */
  public final ResizeImage removeImageHeightInPixels() {
    properties.remove(IMAGE_HEIGHT_IN_PIXELS_PROPERTY);
    return this;
  }

  /**
   * Specifies which algorithm should be used to resize the image
   */
  public final String getScalingAlgorithm() {
    return properties.get(SCALING_ALGORITHM_PROPERTY);
  }

  /**
   * Specifies which algorithm should be used to resize the image
   */
  public final ResizeImage setScalingAlgorithm(final String scalingAlgorithm) {
    properties.put(SCALING_ALGORITHM_PROPERTY, scalingAlgorithm);
    return this;
  }

  /**
   * Specifies which algorithm should be used to resize the image
   */
  public final ResizeImage removeScalingAlgorithm() {
    properties.remove(SCALING_ALGORITHM_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ResizeImage setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ResizeImage removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ResizeImage, ResizeImage> configurator) {
    return configurator.apply(new ResizeImage()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ResizeImage.class) final Closure<ResizeImage> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.image.ResizeImage> code = closure.rehydrate(c, com.tibtech.nifi.processors.image.ResizeImage.class, com.tibtech.nifi.processors.image.ResizeImage.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
