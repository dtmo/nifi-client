package com.tibtech.nifi.web.api.dto.action.component.details;

import java.lang.String;
import org.apache.nifi.web.api.dto.action.component.details.RemoteProcessGroupDetailsDTO;

public final class RemoteProcessGroupDetailsDTOBuilder extends AbstractComponentDetailsDTOBuilder<RemoteProcessGroupDetailsDTOBuilder> {
  private String uri;

  /**
   * The uri of the target of the remote process group.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The uri of the target of the remote process group.
   */
  public RemoteProcessGroupDetailsDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public RemoteProcessGroupDetailsDTO build() {
    final RemoteProcessGroupDetailsDTO remoteProcessGroupDetailsDTO = new RemoteProcessGroupDetailsDTO();
    super.setPropertyValues(remoteProcessGroupDetailsDTO);
    remoteProcessGroupDetailsDTO.setUri(uri);
    return remoteProcessGroupDetailsDTO;
  }

  public static RemoteProcessGroupDetailsDTOBuilder of(final RemoteProcessGroupDetailsDTO remoteProcessGroupDetailsDTO) {
    final RemoteProcessGroupDetailsDTOBuilder remoteProcessGroupDetailsDTOBuilder = new RemoteProcessGroupDetailsDTOBuilder();
    AbstractComponentDetailsDTOBuilder.setBuilderValues(remoteProcessGroupDetailsDTOBuilder, remoteProcessGroupDetailsDTO);
    remoteProcessGroupDetailsDTOBuilder.setUri(remoteProcessGroupDetailsDTO.getUri());
    return remoteProcessGroupDetailsDTOBuilder;
  }
}
