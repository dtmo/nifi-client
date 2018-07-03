package com.tibtech.nifi.web.api.dto;

import java.lang.Double;
import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.LabelDTO;

public final class LabelDTOBuilder extends AbstractComponentDTOBuilder<LabelDTOBuilder> {
  private Double height;

  private String label;

  private Map<String, String> style;

  private Double width;

  /**
   * The height of the label in pixels when at a 1:1 scale.
   */
  public Double getHeight() {
    return height;
  }

  /**
   * The height of the label in pixels when at a 1:1 scale.
   */
  public LabelDTOBuilder setHeight(final Double height) {
    this.height = height;
    return this;
  }

  /**
   * The text that appears in the label.
   */
  public String getLabel() {
    return label;
  }

  /**
   * The text that appears in the label.
   */
  public LabelDTOBuilder setLabel(final String label) {
    this.label = label;
    return this;
  }

  /**
   * The styles for this label (font-size => 12px, background-color => #eee, etc).
   */
  public Map<String, String> getStyle() {
    return style;
  }

  /**
   * The styles for this label (font-size => 12px, background-color => #eee, etc).
   */
  public LabelDTOBuilder setStyle(final Map<String, String> style) {
    this.style = style;
    return this;
  }

  /**
   * The width of the label in pixels when at a 1:1 scale.
   */
  public Double getWidth() {
    return width;
  }

  /**
   * The width of the label in pixels when at a 1:1 scale.
   */
  public LabelDTOBuilder setWidth(final Double width) {
    this.width = width;
    return this;
  }

  public LabelDTO build() {
    final LabelDTO labelDTO = new LabelDTO();
    super.setPropertyValues(labelDTO);
    labelDTO.setHeight(height);
    labelDTO.setLabel(label);
    labelDTO.setStyle(style);
    labelDTO.setWidth(width);
    return labelDTO;
  }

  public static LabelDTOBuilder of(final LabelDTO labelDTO) {
    final LabelDTOBuilder labelDTOBuilder = new LabelDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(labelDTOBuilder, labelDTO);
    labelDTOBuilder.setHeight(labelDTO.getHeight());
    labelDTOBuilder.setLabel(labelDTO.getLabel());
    labelDTOBuilder.setStyle(labelDTO.getStyle());
    labelDTOBuilder.setWidth(labelDTO.getWidth());
    return labelDTOBuilder;
  }
}
