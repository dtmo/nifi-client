package com.tibtech.nifi.processors.azure.eventhub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutAzureEventHub {
  /**
   * The name of the Azure Event Hub to send to
   */
  public static final String EVENT_HUB_NAME_PROPERTY = "Event Hub Name";

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public static final String EVENT_HUB_NAMESPACE_PROPERTY = "Event Hub Namespace";

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Send permissions.
   */
  public static final String SHARED_ACCESS_POLICY_NAME_PROPERTY = "Shared Access Policy Name";

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public static final String SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY = "Shared Access Policy Primary Key";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The name of the Azure Event Hub to send to
   */
  public final String getEventHubName() {
    return properties.get(EVENT_HUB_NAME_PROPERTY);
  }

  /**
   * The name of the Azure Event Hub to send to
   */
  public final PutAzureEventHub setEventHubName(final String eventHubName) {
    properties.put(EVENT_HUB_NAME_PROPERTY, eventHubName);
    return this;
  }

  /**
   * The name of the Azure Event Hub to send to
   */
  public final PutAzureEventHub removeEventHubName() {
    properties.remove(EVENT_HUB_NAME_PROPERTY);
    return this;
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public final String getEventHubNamespace() {
    return properties.get(EVENT_HUB_NAMESPACE_PROPERTY);
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public final PutAzureEventHub setEventHubNamespace(final String eventHubNamespace) {
    properties.put(EVENT_HUB_NAMESPACE_PROPERTY, eventHubNamespace);
    return this;
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public final PutAzureEventHub removeEventHubNamespace() {
    properties.remove(EVENT_HUB_NAMESPACE_PROPERTY);
    return this;
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Send permissions.
   */
  public final String getSharedAccessPolicyName() {
    return properties.get(SHARED_ACCESS_POLICY_NAME_PROPERTY);
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Send permissions.
   */
  public final PutAzureEventHub setSharedAccessPolicyName(final String sharedAccessPolicyName) {
    properties.put(SHARED_ACCESS_POLICY_NAME_PROPERTY, sharedAccessPolicyName);
    return this;
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Send permissions.
   */
  public final PutAzureEventHub removeSharedAccessPolicyName() {
    properties.remove(SHARED_ACCESS_POLICY_NAME_PROPERTY);
    return this;
  }

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public final String getSharedAccessPolicyPrimaryKey() {
    return properties.get(SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY);
  }

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public final PutAzureEventHub setSharedAccessPolicyPrimaryKey(final String sharedAccessPolicyPrimaryKey) {
    properties.put(SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY, sharedAccessPolicyPrimaryKey);
    return this;
  }

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public final PutAzureEventHub removeSharedAccessPolicyPrimaryKey() {
    properties.remove(SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutAzureEventHub setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutAzureEventHub removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutAzureEventHub, PutAzureEventHub> configurator) {
    return configurator.apply(new PutAzureEventHub()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutAzureEventHub.class) final Closure<PutAzureEventHub> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.eventhub.PutAzureEventHub> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.eventhub.PutAzureEventHub.class, com.tibtech.nifi.processors.azure.eventhub.PutAzureEventHub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
