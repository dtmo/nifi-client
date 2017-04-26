package com.tibtech.nifi.web.api.dto.flow;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.flow.FlowDTO;
import org.apache.nifi.web.api.dto.flow.ProcessGroupFlowDTO;
import org.apache.nifi.web.api.entity.FlowBreadcrumbEntity;

public final class ProcessGroupFlowDTOBuilder {
  private FlowBreadcrumbEntity breadcrumb;

  private FlowDTO flow;

  private String id;

  private Date lastRefreshed;

  private String parentGroupId;

  private String uri;

  /**
   * The breadcrumb of the process group.
   */
  public FlowBreadcrumbEntity getBreadcrumb() {
    return breadcrumb;
  }

  /**
   * The breadcrumb of the process group.
   */
  public ProcessGroupFlowDTOBuilder setBreadcrumb(final FlowBreadcrumbEntity breadcrumb) {
    this.breadcrumb = breadcrumb;
    return this;
  }

  /**
   * The flow structure starting at this Process Group.
   */
  public FlowDTO getFlow() {
    return flow;
  }

  /**
   * The flow structure starting at this Process Group.
   */
  public ProcessGroupFlowDTOBuilder setFlow(final FlowDTO flow) {
    this.flow = flow;
    return this;
  }

  /**
   * The flow structure starting at this Process Group.
   */
  public ProcessGroupFlowDTOBuilder setFlow(final Function<FlowDTOBuilder, FlowDTOBuilder> configurator) {
    return setFlow(configurator.apply(new FlowDTOBuilder()).build());
  }

  /**
   * The flow structure starting at this Process Group.
   */
  public ProcessGroupFlowDTOBuilder setFlow(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FlowDTOBuilder.class) final Closure<FlowDTOBuilder> closure) {
    return setFlow(c -> {
      final Closure<FlowDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The id of the component.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the component.
   */
  public ProcessGroupFlowDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The time the flow for the process group was last refreshed.
   */
  public Date getLastRefreshed() {
    return lastRefreshed;
  }

  /**
   * The time the flow for the process group was last refreshed.
   */
  public ProcessGroupFlowDTOBuilder setLastRefreshed(final Date lastRefreshed) {
    this.lastRefreshed = lastRefreshed;
    return this;
  }

  /**
   * The id of parent process group of this component if applicable.
   */
  public String getParentGroupId() {
    return parentGroupId;
  }

  /**
   * The id of parent process group of this component if applicable.
   */
  public ProcessGroupFlowDTOBuilder setParentGroupId(final String parentGroupId) {
    this.parentGroupId = parentGroupId;
    return this;
  }

  /**
   * The URI for futures requests to the component.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for futures requests to the component.
   */
  public ProcessGroupFlowDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public ProcessGroupFlowDTO build() {
    final ProcessGroupFlowDTO processGroupFlowDTO = new ProcessGroupFlowDTO();
    processGroupFlowDTO.setBreadcrumb(breadcrumb);
    processGroupFlowDTO.setFlow(flow);
    processGroupFlowDTO.setId(id);
    processGroupFlowDTO.setLastRefreshed(lastRefreshed);
    processGroupFlowDTO.setParentGroupId(parentGroupId);
    processGroupFlowDTO.setUri(uri);
    return processGroupFlowDTO;
  }

  public static ProcessGroupFlowDTOBuilder of(final ProcessGroupFlowDTO processGroupFlowDTO) {
    final ProcessGroupFlowDTOBuilder processGroupFlowDTOBuilder = new ProcessGroupFlowDTOBuilder();
    processGroupFlowDTOBuilder.setBreadcrumb(processGroupFlowDTO.getBreadcrumb());
    processGroupFlowDTOBuilder.setFlow(processGroupFlowDTO.getFlow());
    processGroupFlowDTOBuilder.setId(processGroupFlowDTO.getId());
    processGroupFlowDTOBuilder.setLastRefreshed(processGroupFlowDTO.getLastRefreshed());
    processGroupFlowDTOBuilder.setParentGroupId(processGroupFlowDTO.getParentGroupId());
    processGroupFlowDTOBuilder.setUri(processGroupFlowDTO.getUri());
    return processGroupFlowDTOBuilder;
  }
}
