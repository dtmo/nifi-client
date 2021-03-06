package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeIMAP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.email.ConsumeIMAP";

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public static final String HOST_PROPERTY = "host";

  /**
   * Numeric value identifying Port of Email server (e.g., 993)
   */
  public static final String PORT_PROPERTY = "port";

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
   * Specify if messages should be marked as read after retrieval.
   */
  public static final String MARK_MESSAGES_AS_READ_PROPERTY = "Mark Messages as Read";

  /**
   * Specifies if IMAP connection must be obtained via SSL encrypted connection (i.e., IMAPS)
   */
  public static final String USE_SSL_PROPERTY = "Use SSL";

  private final Map<String, String> properties;

  public ConsumeIMAP() {
    this.properties = new HashMap<>();
  }

  public ConsumeIMAP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public final String getHost() {
    return properties.get(HOST_PROPERTY);
  }

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public final ConsumeIMAP setHost(final String host) {
    properties.put(HOST_PROPERTY, host);
    return this;
  }

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public final ConsumeIMAP removeHost() {
    properties.remove(HOST_PROPERTY);
    return this;
  }

  /**
   * Numeric value identifying Port of Email server (e.g., 993)
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * Numeric value identifying Port of Email server (e.g., 993)
   */
  public final ConsumeIMAP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * Numeric value identifying Port of Email server (e.g., 993)
   */
  public final ConsumeIMAP removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
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
  public final ConsumeIMAP setUser(final String user) {
    properties.put(USER_PROPERTY, user);
    return this;
  }

  /**
   * User Name used for authentication and authorization with Email server.
   */
  public final ConsumeIMAP removeUser() {
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
  public final ConsumeIMAP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization with Email server.
   */
  public final ConsumeIMAP removePassword() {
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
  public final ConsumeIMAP setFolder(final String folder) {
    properties.put(FOLDER_PROPERTY, folder);
    return this;
  }

  /**
   * Email folder to retrieve messages from (e.g., INBOX)
   */
  public final ConsumeIMAP removeFolder() {
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
  public final ConsumeIMAP setFetchSize(final String fetchSize) {
    properties.put(FETCH_SIZE_PROPERTY, fetchSize);
    return this;
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final ConsumeIMAP removeFetchSize() {
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
  public final ConsumeIMAP setDeleteMessages(final String deleteMessages) {
    properties.put(DELETE_MESSAGES_PROPERTY, deleteMessages);
    return this;
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final ConsumeIMAP removeDeleteMessages() {
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
  public final ConsumeIMAP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final ConsumeIMAP removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public final String getMarkMessagesAsRead() {
    return properties.get(MARK_MESSAGES_AS_READ_PROPERTY);
  }

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public final ConsumeIMAP setMarkMessagesAsRead(final String markMessagesAsRead) {
    properties.put(MARK_MESSAGES_AS_READ_PROPERTY, markMessagesAsRead);
    return this;
  }

  /**
   * Specify if messages should be marked as read after retrieval.
   */
  public final ConsumeIMAP removeMarkMessagesAsRead() {
    properties.remove(MARK_MESSAGES_AS_READ_PROPERTY);
    return this;
  }

  /**
   * Specifies if IMAP connection must be obtained via SSL encrypted connection (i.e., IMAPS)
   */
  public final String getUseSsl() {
    return properties.get(USE_SSL_PROPERTY);
  }

  /**
   * Specifies if IMAP connection must be obtained via SSL encrypted connection (i.e., IMAPS)
   */
  public final ConsumeIMAP setUseSsl(final String useSsl) {
    properties.put(USE_SSL_PROPERTY, useSsl);
    return this;
  }

  /**
   * Specifies if IMAP connection must be obtained via SSL encrypted connection (i.e., IMAPS)
   */
  public final ConsumeIMAP removeUseSsl() {
    properties.remove(USE_SSL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeIMAP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeIMAP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConsumeIMAP, ConsumeIMAP> configurator) {
    return configurator.apply(new ConsumeIMAP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeIMAP.class) final Closure<ConsumeIMAP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ConsumeIMAP> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ConsumeIMAP.class, com.tibtech.nifi.processors.email.ConsumeIMAP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeIMAP, ConsumeIMAP> configurator) {
    return configurator.apply(new ConsumeIMAP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeIMAP.class) final Closure<ConsumeIMAP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.email.ConsumeIMAP> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ConsumeIMAP.class, com.tibtech.nifi.processors.email.ConsumeIMAP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
