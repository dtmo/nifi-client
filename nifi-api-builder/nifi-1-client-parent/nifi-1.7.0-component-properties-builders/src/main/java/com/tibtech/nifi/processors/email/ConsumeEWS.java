package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeEWS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.email.ConsumeEWS";

  /**
   * User Name used for authentication and authorization with Email server.
   */
  public static final String USER_PROPERTY = "user";

  /**
   * Password used for authentication and authorization with Email server.
   */
  public static final String PASSWORD_PROPERTY = "password";

  /**
   * Email folder to retrieve messages from (e.g., INBOX)
   */
  public static final String FOLDER_PROPERTY = "folder";

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public static final String FETCH_SIZE_PROPERTY = "fetch.size";

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public static final String DELETE_MESSAGES_PROPERTY = "delete.messages";

  /**
   * The amount of time to wait to connect to Email server
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "connection.timeout";

  /**
   * What version of Exchange Server the server is running.
   */
  public static final String MAIL_EWS_VERSION_PROPERTY = "mail-ews-version";

  /**
   * URL of the EWS Endpoint. Required if Autodiscover is false.
   */
  public static final String EWS_URL_PROPERTY = "ews-url";

  /**
   * Whether or not to use the Exchange email address to Autodiscover the EWS endpoint URL.
   */
  public static final String EWS_AUTODISCOVER_PROPERTY = "ews-autodiscover";

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public static final String EWS_MARK_AS_READ_PROPERTY = "ews-mark-as-read";

  /**
   * Comma delimited list specifying which headers from the original message to include in the exported email message. Blank means copy all headers. Some headers can cause problems with message parsing, specifically the 'Content-Type' header.
   */
  public static final String EWS_INCLUDE_HEADERS_PROPERTY = "ews-include-headers";

  /**
   * Comma delimited list specifying which headers from the original message to exclude in the exported email message. Blank means don't exclude any headers.
   */
  public static final String EWS_EXCLUDE_HEADERS_PROPERTY = "ews-exclude-headers";

  private final Map<String, String> properties;

  public ConsumeEWS() {
    this.properties = new HashMap<>();
  }

  public ConsumeEWS(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * User Name used for authentication and authorization with Email server.
   */
  public final String getUser() {
    return properties.get(USER_PROPERTY);
  }

  /**
   * User Name used for authentication and authorization with Email server.
   */
  public final ConsumeEWS setUser(final String user) {
    properties.put(USER_PROPERTY, user);
    return this;
  }

  /**
   * User Name used for authentication and authorization with Email server.
   */
  public final ConsumeEWS removeUser() {
    properties.remove(USER_PROPERTY);
    return this;
  }

  /**
   * Password used for authentication and authorization with Email server.
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password used for authentication and authorization with Email server.
   */
  public final ConsumeEWS setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization with Email server.
   */
  public final ConsumeEWS removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Email folder to retrieve messages from (e.g., INBOX)
   */
  public final String getFolder() {
    return properties.get(FOLDER_PROPERTY);
  }

  /**
   * Email folder to retrieve messages from (e.g., INBOX)
   */
  public final ConsumeEWS setFolder(final String folder) {
    properties.put(FOLDER_PROPERTY, folder);
    return this;
  }

  /**
   * Email folder to retrieve messages from (e.g., INBOX)
   */
  public final ConsumeEWS removeFolder() {
    properties.remove(FOLDER_PROPERTY);
    return this;
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final String getFetchSize() {
    return properties.get(FETCH_SIZE_PROPERTY);
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final ConsumeEWS setFetchSize(final String fetchSize) {
    properties.put(FETCH_SIZE_PROPERTY, fetchSize);
    return this;
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final ConsumeEWS removeFetchSize() {
    properties.remove(FETCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final String getDeleteMessages() {
    return properties.get(DELETE_MESSAGES_PROPERTY);
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final ConsumeEWS setDeleteMessages(final String deleteMessages) {
    properties.put(DELETE_MESSAGES_PROPERTY, deleteMessages);
    return this;
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final ConsumeEWS removeDeleteMessages() {
    properties.remove(DELETE_MESSAGES_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final ConsumeEWS setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final ConsumeEWS removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * What version of Exchange Server the server is running.
   */
  public final String getMailEwsVersion() {
    return properties.get(MAIL_EWS_VERSION_PROPERTY);
  }

  /**
   * What version of Exchange Server the server is running.
   */
  public final ConsumeEWS setMailEwsVersion(final String mailEwsVersion) {
    properties.put(MAIL_EWS_VERSION_PROPERTY, mailEwsVersion);
    return this;
  }

  /**
   * What version of Exchange Server the server is running.
   */
  public final ConsumeEWS removeMailEwsVersion() {
    properties.remove(MAIL_EWS_VERSION_PROPERTY);
    return this;
  }

  /**
   * URL of the EWS Endpoint. Required if Autodiscover is false.
   */
  public final String getEwsUrl() {
    return properties.get(EWS_URL_PROPERTY);
  }

  /**
   * URL of the EWS Endpoint. Required if Autodiscover is false.
   */
  public final ConsumeEWS setEwsUrl(final String ewsUrl) {
    properties.put(EWS_URL_PROPERTY, ewsUrl);
    return this;
  }

  /**
   * URL of the EWS Endpoint. Required if Autodiscover is false.
   */
  public final ConsumeEWS removeEwsUrl() {
    properties.remove(EWS_URL_PROPERTY);
    return this;
  }

  /**
   * Whether or not to use the Exchange email address to Autodiscover the EWS endpoint URL.
   */
  public final String getEwsAutodiscover() {
    return properties.get(EWS_AUTODISCOVER_PROPERTY);
  }

  /**
   * Whether or not to use the Exchange email address to Autodiscover the EWS endpoint URL.
   */
  public final ConsumeEWS setEwsAutodiscover(final String ewsAutodiscover) {
    properties.put(EWS_AUTODISCOVER_PROPERTY, ewsAutodiscover);
    return this;
  }

  /**
   * Whether or not to use the Exchange email address to Autodiscover the EWS endpoint URL.
   */
  public final ConsumeEWS removeEwsAutodiscover() {
    properties.remove(EWS_AUTODISCOVER_PROPERTY);
    return this;
  }

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public final String getEwsMarkAsRead() {
    return properties.get(EWS_MARK_AS_READ_PROPERTY);
  }

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public final ConsumeEWS setEwsMarkAsRead(final String ewsMarkAsRead) {
    properties.put(EWS_MARK_AS_READ_PROPERTY, ewsMarkAsRead);
    return this;
  }

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public final ConsumeEWS removeEwsMarkAsRead() {
    properties.remove(EWS_MARK_AS_READ_PROPERTY);
    return this;
  }

  /**
   * Comma delimited list specifying which headers from the original message to include in the exported email message. Blank means copy all headers. Some headers can cause problems with message parsing, specifically the 'Content-Type' header.
   */
  public final String getEwsIncludeHeaders() {
    return properties.get(EWS_INCLUDE_HEADERS_PROPERTY);
  }

  /**
   * Comma delimited list specifying which headers from the original message to include in the exported email message. Blank means copy all headers. Some headers can cause problems with message parsing, specifically the 'Content-Type' header.
   */
  public final ConsumeEWS setEwsIncludeHeaders(final String ewsIncludeHeaders) {
    properties.put(EWS_INCLUDE_HEADERS_PROPERTY, ewsIncludeHeaders);
    return this;
  }

  /**
   * Comma delimited list specifying which headers from the original message to include in the exported email message. Blank means copy all headers. Some headers can cause problems with message parsing, specifically the 'Content-Type' header.
   */
  public final ConsumeEWS removeEwsIncludeHeaders() {
    properties.remove(EWS_INCLUDE_HEADERS_PROPERTY);
    return this;
  }

  /**
   * Comma delimited list specifying which headers from the original message to exclude in the exported email message. Blank means don't exclude any headers.
   */
  public final String getEwsExcludeHeaders() {
    return properties.get(EWS_EXCLUDE_HEADERS_PROPERTY);
  }

  /**
   * Comma delimited list specifying which headers from the original message to exclude in the exported email message. Blank means don't exclude any headers.
   */
  public final ConsumeEWS setEwsExcludeHeaders(final String ewsExcludeHeaders) {
    properties.put(EWS_EXCLUDE_HEADERS_PROPERTY, ewsExcludeHeaders);
    return this;
  }

  /**
   * Comma delimited list specifying which headers from the original message to exclude in the exported email message. Blank means don't exclude any headers.
   */
  public final ConsumeEWS removeEwsExcludeHeaders() {
    properties.remove(EWS_EXCLUDE_HEADERS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeEWS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeEWS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConsumeEWS, ConsumeEWS> configurator) {
    return configurator.apply(new ConsumeEWS()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeEWS.class) final Closure<ConsumeEWS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ConsumeEWS> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ConsumeEWS.class, com.tibtech.nifi.processors.email.ConsumeEWS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeEWS, ConsumeEWS> configurator) {
    return configurator.apply(new ConsumeEWS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeEWS.class) final Closure<ConsumeEWS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.email.ConsumeEWS> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ConsumeEWS.class, com.tibtech.nifi.processors.email.ConsumeEWS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
