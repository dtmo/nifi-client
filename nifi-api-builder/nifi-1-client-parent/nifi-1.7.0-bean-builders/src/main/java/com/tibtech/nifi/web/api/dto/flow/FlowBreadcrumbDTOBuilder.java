package com.tibtech.nifi.web.api.dto.flow;

import com.tibtech.nifi.web.api.dto.VersionControlInformationDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.VersionControlInformationDTO;
import org.apache.nifi.web.api.dto.flow.FlowBreadcrumbDTO;

public final class FlowBreadcrumbDTOBuilder {
  private String id;

  private String name;

  private VersionControlInformationDTO versionControlInformation;

  /**
   * The id of the group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the group.
   */
  public FlowBreadcrumbDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the group.
   */
  public String getName() {
    return name;
  }

  /**
   * The id of the group.
   */
  public FlowBreadcrumbDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The process group version control information or null if not version controlled.
   */
  public VersionControlInformationDTO getVersionControlInformation() {
    return versionControlInformation;
  }

  /**
   * The process group version control information or null if not version controlled.
   */
  public FlowBreadcrumbDTOBuilder setVersionControlInformation(
      final VersionControlInformationDTO versionControlInformation) {
    this.versionControlInformation = versionControlInformation;
    return this;
  }

  /**
   * The process group version control information or null if not version controlled.
   */
  public FlowBreadcrumbDTOBuilder setVersionControlInformation(
      final Consumer<VersionControlInformationDTOBuilder> configurator) {
    final VersionControlInformationDTOBuilder builder = (versionControlInformation != null ? VersionControlInformationDTOBuilder.of(versionControlInformation) : new VersionControlInformationDTOBuilder());
    configurator.accept(builder);
    return setVersionControlInformation(builder.build());
  }

  /**
   * The process group version control information or null if not version controlled.
   */
  public FlowBreadcrumbDTOBuilder setVersionControlInformation(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = VersionControlInformationDTOBuilder.class) final Closure<VersionControlInformationDTOBuilder> closure) {
    return setVersionControlInformation(c -> {
      final Closure<VersionControlInformationDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public FlowBreadcrumbDTO build() {
    final FlowBreadcrumbDTO flowBreadcrumbDTO = new FlowBreadcrumbDTO();
    flowBreadcrumbDTO.setId(id);
    flowBreadcrumbDTO.setName(name);
    flowBreadcrumbDTO.setVersionControlInformation(versionControlInformation);
    return flowBreadcrumbDTO;
  }

  public static FlowBreadcrumbDTOBuilder of(final FlowBreadcrumbDTO flowBreadcrumbDTO) {
    final FlowBreadcrumbDTOBuilder flowBreadcrumbDTOBuilder = new FlowBreadcrumbDTOBuilder();
    flowBreadcrumbDTOBuilder.setId(flowBreadcrumbDTO.getId());
    flowBreadcrumbDTOBuilder.setName(flowBreadcrumbDTO.getName());
    flowBreadcrumbDTOBuilder.setVersionControlInformation(flowBreadcrumbDTO.getVersionControlInformation());
    return flowBreadcrumbDTOBuilder;
  }
}
