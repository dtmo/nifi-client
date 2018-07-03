package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ListingRequestDTO;
import org.apache.nifi.web.api.entity.ListingRequestEntity;

public final class ListingRequestEntityBuilder extends AbstractEntityBuilder<ListingRequestEntityBuilder> {
  private ListingRequestDTO listingRequest;

  public ListingRequestDTO getListingRequest() {
    return listingRequest;
  }

  public ListingRequestEntityBuilder setListingRequest(final ListingRequestDTO listingRequest) {
    this.listingRequest = listingRequest;
    return this;
  }

  public ListingRequestEntity build() {
    final ListingRequestEntity listingRequestEntity = new ListingRequestEntity();
    super.setPropertyValues(listingRequestEntity);
    listingRequestEntity.setListingRequest(listingRequest);
    return listingRequestEntity;
  }

  public static ListingRequestEntityBuilder of(final ListingRequestEntity listingRequestEntity) {
    final ListingRequestEntityBuilder listingRequestEntityBuilder = new ListingRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(listingRequestEntityBuilder, listingRequestEntity);
    listingRequestEntityBuilder.setListingRequest(listingRequestEntity.getListingRequest());
    return listingRequestEntityBuilder;
  }
}
