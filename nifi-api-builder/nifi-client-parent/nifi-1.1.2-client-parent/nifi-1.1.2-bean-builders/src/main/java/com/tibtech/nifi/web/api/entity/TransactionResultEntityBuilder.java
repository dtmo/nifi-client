package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.entity.TransactionResultEntity;

public final class TransactionResultEntityBuilder extends AbstractEntityBuilder<TransactionResultEntityBuilder> {
  private int flowFileSent;

  private String message;

  private int responseCode;

  public int getFlowFileSent() {
    return flowFileSent;
  }

  public TransactionResultEntityBuilder setFlowFileSent(final int flowFileSent) {
    this.flowFileSent = flowFileSent;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public TransactionResultEntityBuilder setMessage(final String message) {
    this.message = message;
    return this;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public TransactionResultEntityBuilder setResponseCode(final int responseCode) {
    this.responseCode = responseCode;
    return this;
  }

  public TransactionResultEntity build() {
    final TransactionResultEntity transactionResultEntity = new TransactionResultEntity();
    super.setPropertyValues(transactionResultEntity);
    transactionResultEntity.setFlowFileSent(flowFileSent);
    transactionResultEntity.setMessage(message);
    transactionResultEntity.setResponseCode(responseCode);
    return transactionResultEntity;
  }

  public static TransactionResultEntityBuilder of(final TransactionResultEntity transactionResultEntity) {
    final TransactionResultEntityBuilder transactionResultEntityBuilder = new TransactionResultEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(transactionResultEntityBuilder, transactionResultEntity);
    transactionResultEntityBuilder.setFlowFileSent(transactionResultEntity.getFlowFileSent());
    transactionResultEntityBuilder.setMessage(transactionResultEntity.getMessage());
    transactionResultEntityBuilder.setResponseCode(transactionResultEntity.getResponseCode());
    return transactionResultEntityBuilder;
  }
}
