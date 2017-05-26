package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.RevisionDTO;

public final class RevisionDTOBuilder {
  private String clientId;

  private String lastModifier;

  private Long version;

  /**
   * A client identifier used to make a request. By including a client identifier, the API can allow multiple requests without needing the current revision. Due to the asynchronous nature of requests/responses this was implemented to allow the client to make numerous requests without having to wait for the previous response to come back
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * A client identifier used to make a request. By including a client identifier, the API can allow multiple requests without needing the current revision. Due to the asynchronous nature of requests/responses this was implemented to allow the client to make numerous requests without having to wait for the previous response to come back
   */
  public RevisionDTOBuilder setClientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * The user that last modified the flow.
   */
  public String getLastModifier() {
    return lastModifier;
  }

  /**
   * The user that last modified the flow.
   */
  public RevisionDTOBuilder setLastModifier(final String lastModifier) {
    this.lastModifier = lastModifier;
    return this;
  }

  /**
   * NiFi employs an optimistic locking strategy where the client must include a revision in their request when performing an update. In a response to a mutable flow request, this field represents the updated base version.
   */
  public Long getVersion() {
    return version;
  }

  /**
   * NiFi employs an optimistic locking strategy where the client must include a revision in their request when performing an update. In a response to a mutable flow request, this field represents the updated base version.
   */
  public RevisionDTOBuilder setVersion(final Long version) {
    this.version = version;
    return this;
  }

  public RevisionDTO build() {
    final RevisionDTO revisionDTO = new RevisionDTO();
    revisionDTO.setClientId(clientId);
    revisionDTO.setLastModifier(lastModifier);
    revisionDTO.setVersion(version);
    return revisionDTO;
  }

  public static RevisionDTOBuilder of(final RevisionDTO revisionDTO) {
    final RevisionDTOBuilder revisionDTOBuilder = new RevisionDTOBuilder();
    revisionDTOBuilder.setClientId(revisionDTO.getClientId());
    revisionDTOBuilder.setLastModifier(revisionDTO.getLastModifier());
    revisionDTOBuilder.setVersion(revisionDTO.getVersion());
    return revisionDTOBuilder;
  }
}
