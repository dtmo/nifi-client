package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumePOP3 {
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
  public static final String FETCHSIZE_PROPERTY = "fetch.size";

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public static final String DELETEMESSAGES_PROPERTY = "delete.messages";

  /**
   * The amount of time to wait to connect to Email server
   */
  public static final String CONNECTIONTIMEOUT_PROPERTY = "connection.timeout";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public final String getHost() {
    return properties.get(HOST_PROPERTY);
  }

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public final ConsumePOP3 setHost(final String host) {
    properties.put(HOST_PROPERTY, host);
    return this;
  }

  /**
   * Network address of Email server (e.g., pop.gmail.com, imap.gmail.com . . .)
   */
  public final ConsumePOP3 removeHost() {
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
  public final ConsumePOP3 setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * Numeric value identifying Port of Email server (e.g., 993)
   */
  public final ConsumePOP3 removePort() {
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
  public final ConsumePOP3 setUser(final String user) {
    properties.put(USER_PROPERTY, user);
    return this;
  }

  /**
   * User Name used for authentication and authorization with Email server.
   */
  public final ConsumePOP3 removeUser() {
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
  public final ConsumePOP3 setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization with Email server.
   */
  public final ConsumePOP3 removePassword() {
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
  public final ConsumePOP3 setFolder(final String folder) {
    properties.put(FOLDER_PROPERTY, folder);
    return this;
  }

  /**
   * Email folder to retrieve messages from (e.g., INBOX)
   */
  public final ConsumePOP3 removeFolder() {
    properties.remove(FOLDER_PROPERTY);
    return this;
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final String getFetchsize() {
    return properties.get(FETCHSIZE_PROPERTY);
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final ConsumePOP3 setFetchsize(final String fetchsize) {
    properties.put(FETCHSIZE_PROPERTY, fetchsize);
    return this;
  }

  /**
   * Specify the maximum number of Messages to fetch per call to Email Server.
   */
  public final ConsumePOP3 removeFetchsize() {
    properties.remove(FETCHSIZE_PROPERTY);
    return this;
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final String getDeletemessages() {
    return properties.get(DELETEMESSAGES_PROPERTY);
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final ConsumePOP3 setDeletemessages(final String deletemessages) {
    properties.put(DELETEMESSAGES_PROPERTY, deletemessages);
    return this;
  }

  /**
   * Specify whether mail messages should be deleted after retrieval.
   */
  public final ConsumePOP3 removeDeletemessages() {
    properties.remove(DELETEMESSAGES_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final String getConnectiontimeout() {
    return properties.get(CONNECTIONTIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final ConsumePOP3 setConnectiontimeout(final String connectiontimeout) {
    properties.put(CONNECTIONTIMEOUT_PROPERTY, connectiontimeout);
    return this;
  }

  /**
   * The amount of time to wait to connect to Email server
   */
  public final ConsumePOP3 removeConnectiontimeout() {
    properties.remove(CONNECTIONTIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumePOP3 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumePOP3 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConsumePOP3, ConsumePOP3> configurator) {
    return configurator.apply(new ConsumePOP3()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumePOP3.class) final Closure<ConsumePOP3> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ConsumePOP3> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ConsumePOP3.class, com.tibtech.nifi.processors.email.ConsumePOP3.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}