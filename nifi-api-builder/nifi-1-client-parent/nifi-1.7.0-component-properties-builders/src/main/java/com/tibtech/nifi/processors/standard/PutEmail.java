package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutEmail {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutEmail";

  /**
   * The hostname of the SMTP host
   */
  public static final String SMTP_HOSTNAME_PROPERTY = "SMTP Hostname";

  /**
   * The Port used for SMTP communications
   */
  public static final String SMTP_PORT_PROPERTY = "SMTP Port";

  /**
   * Username for the SMTP account
   */
  public static final String SMTP_USERNAME_PROPERTY = "SMTP Username";

  /**
   * Password for the SMTP account
   */
  public static final String SMTP_PASSWORD_PROPERTY = "SMTP Password";

  /**
   * Flag indicating whether authentication should be used
   */
  public static final String SMTP_AUTH_PROPERTY = "SMTP Auth";

  /**
   * Flag indicating whether TLS should be enabled
   */
  public static final String SMTP_TLS_PROPERTY = "SMTP TLS";

  /**
   * Socket Factory to use for SMTP Connection
   */
  public static final String SMTP_SOCKET_FACTORY_PROPERTY = "SMTP Socket Factory";

  /**
   * X-Mailer used in the header of the outgoing email
   */
  public static final String SMTP_X_MAILER_HEADER_PROPERTY = "SMTP X-Mailer Header";

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Email messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public static final String ATTRIBUTE_NAME_REGEX_PROPERTY = "attribute-name-regex";

  /**
   * Mime Type used to interpret the contents of the email, such as text/plain or text/html
   */
  public static final String CONTENT_TYPE_PROPERTY = "Content Type";

  /**
   * Specifies the Email address to use as the sender
   */
  public static final String FROM_PROPERTY = "From";

  /**
   * The recipients to include in the To-Line of the email
   */
  public static final String TO_PROPERTY = "To";

  /**
   * The recipients to include in the CC-Line of the email
   */
  public static final String CC_PROPERTY = "CC";

  /**
   * The recipients to include in the BCC-Line of the email
   */
  public static final String BCC_PROPERTY = "BCC";

  /**
   * The email subject
   */
  public static final String SUBJECT_PROPERTY = "Subject";

  /**
   * The body of the email message
   */
  public static final String MESSAGE_PROPERTY = "Message";

  /**
   * Specifies whether or not the FlowFile content should be the message of the email. If true, the 'Message' property is ignored.
   */
  public static final String EMAIL_FF_CONTENT_AS_MESSAGE_PROPERTY = "email-ff-content-as-message";

  /**
   * Specifies whether or not the FlowFile content should be attached to the email
   */
  public static final String ATTACH_FILE_PROPERTY = "Attach File";

  /**
   * Specifies whether or not all FlowFile attributes should be recorded in the body of the email message
   */
  public static final String INCLUDE_ALL_ATTRIBUTES_IN_MESSAGE_PROPERTY = "Include All Attributes In Message";

  private final Map<String, String> properties;

  public PutEmail() {
    this.properties = new HashMap<>();
  }

  public PutEmail(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The hostname of the SMTP host
   */
  public final String getSmtpHostname() {
    return properties.get(SMTP_HOSTNAME_PROPERTY);
  }

  /**
   * The hostname of the SMTP host
   */
  public final PutEmail setSmtpHostname(final String smtpHostname) {
    properties.put(SMTP_HOSTNAME_PROPERTY, smtpHostname);
    return this;
  }

  /**
   * The hostname of the SMTP host
   */
  public final PutEmail removeSmtpHostname() {
    properties.remove(SMTP_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The Port used for SMTP communications
   */
  public final String getSmtpPort() {
    return properties.get(SMTP_PORT_PROPERTY);
  }

  /**
   * The Port used for SMTP communications
   */
  public final PutEmail setSmtpPort(final String smtpPort) {
    properties.put(SMTP_PORT_PROPERTY, smtpPort);
    return this;
  }

  /**
   * The Port used for SMTP communications
   */
  public final PutEmail removeSmtpPort() {
    properties.remove(SMTP_PORT_PROPERTY);
    return this;
  }

  /**
   * Username for the SMTP account
   */
  public final String getSmtpUsername() {
    return properties.get(SMTP_USERNAME_PROPERTY);
  }

  /**
   * Username for the SMTP account
   */
  public final PutEmail setSmtpUsername(final String smtpUsername) {
    properties.put(SMTP_USERNAME_PROPERTY, smtpUsername);
    return this;
  }

  /**
   * Username for the SMTP account
   */
  public final PutEmail removeSmtpUsername() {
    properties.remove(SMTP_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password for the SMTP account
   */
  public final String getSmtpPassword() {
    return properties.get(SMTP_PASSWORD_PROPERTY);
  }

  /**
   * Password for the SMTP account
   */
  public final PutEmail setSmtpPassword(final String smtpPassword) {
    properties.put(SMTP_PASSWORD_PROPERTY, smtpPassword);
    return this;
  }

  /**
   * Password for the SMTP account
   */
  public final PutEmail removeSmtpPassword() {
    properties.remove(SMTP_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Flag indicating whether authentication should be used
   */
  public final String getSmtpAuth() {
    return properties.get(SMTP_AUTH_PROPERTY);
  }

  /**
   * Flag indicating whether authentication should be used
   */
  public final PutEmail setSmtpAuth(final String smtpAuth) {
    properties.put(SMTP_AUTH_PROPERTY, smtpAuth);
    return this;
  }

  /**
   * Flag indicating whether authentication should be used
   */
  public final PutEmail removeSmtpAuth() {
    properties.remove(SMTP_AUTH_PROPERTY);
    return this;
  }

  /**
   * Flag indicating whether TLS should be enabled
   */
  public final String getSmtpTls() {
    return properties.get(SMTP_TLS_PROPERTY);
  }

  /**
   * Flag indicating whether TLS should be enabled
   */
  public final PutEmail setSmtpTls(final String smtpTls) {
    properties.put(SMTP_TLS_PROPERTY, smtpTls);
    return this;
  }

  /**
   * Flag indicating whether TLS should be enabled
   */
  public final PutEmail removeSmtpTls() {
    properties.remove(SMTP_TLS_PROPERTY);
    return this;
  }

  /**
   * Socket Factory to use for SMTP Connection
   */
  public final String getSmtpSocketFactory() {
    return properties.get(SMTP_SOCKET_FACTORY_PROPERTY);
  }

  /**
   * Socket Factory to use for SMTP Connection
   */
  public final PutEmail setSmtpSocketFactory(final String smtpSocketFactory) {
    properties.put(SMTP_SOCKET_FACTORY_PROPERTY, smtpSocketFactory);
    return this;
  }

  /**
   * Socket Factory to use for SMTP Connection
   */
  public final PutEmail removeSmtpSocketFactory() {
    properties.remove(SMTP_SOCKET_FACTORY_PROPERTY);
    return this;
  }

  /**
   * X-Mailer used in the header of the outgoing email
   */
  public final String getSmtpXMailerHeader() {
    return properties.get(SMTP_X_MAILER_HEADER_PROPERTY);
  }

  /**
   * X-Mailer used in the header of the outgoing email
   */
  public final PutEmail setSmtpXMailerHeader(final String smtpXMailerHeader) {
    properties.put(SMTP_X_MAILER_HEADER_PROPERTY, smtpXMailerHeader);
    return this;
  }

  /**
   * X-Mailer used in the header of the outgoing email
   */
  public final PutEmail removeSmtpXMailerHeader() {
    properties.remove(SMTP_X_MAILER_HEADER_PROPERTY);
    return this;
  }

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Email messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public final String getAttributeNameRegex() {
    return properties.get(ATTRIBUTE_NAME_REGEX_PROPERTY);
  }

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Email messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public final PutEmail setAttributeNameRegex(final String attributeNameRegex) {
    properties.put(ATTRIBUTE_NAME_REGEX_PROPERTY, attributeNameRegex);
    return this;
  }

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Email messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public final PutEmail removeAttributeNameRegex() {
    properties.remove(ATTRIBUTE_NAME_REGEX_PROPERTY);
    return this;
  }

  /**
   * Mime Type used to interpret the contents of the email, such as text/plain or text/html
   */
  public final String getContentType() {
    return properties.get(CONTENT_TYPE_PROPERTY);
  }

  /**
   * Mime Type used to interpret the contents of the email, such as text/plain or text/html
   */
  public final PutEmail setContentType(final String contentType) {
    properties.put(CONTENT_TYPE_PROPERTY, contentType);
    return this;
  }

  /**
   * Mime Type used to interpret the contents of the email, such as text/plain or text/html
   */
  public final PutEmail removeContentType() {
    properties.remove(CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * Specifies the Email address to use as the sender
   */
  public final String getFrom() {
    return properties.get(FROM_PROPERTY);
  }

  /**
   * Specifies the Email address to use as the sender
   */
  public final PutEmail setFrom(final String from) {
    properties.put(FROM_PROPERTY, from);
    return this;
  }

  /**
   * Specifies the Email address to use as the sender
   */
  public final PutEmail removeFrom() {
    properties.remove(FROM_PROPERTY);
    return this;
  }

  /**
   * The recipients to include in the To-Line of the email
   */
  public final String getTo() {
    return properties.get(TO_PROPERTY);
  }

  /**
   * The recipients to include in the To-Line of the email
   */
  public final PutEmail setTo(final String to) {
    properties.put(TO_PROPERTY, to);
    return this;
  }

  /**
   * The recipients to include in the To-Line of the email
   */
  public final PutEmail removeTo() {
    properties.remove(TO_PROPERTY);
    return this;
  }

  /**
   * The recipients to include in the CC-Line of the email
   */
  public final String getCc() {
    return properties.get(CC_PROPERTY);
  }

  /**
   * The recipients to include in the CC-Line of the email
   */
  public final PutEmail setCc(final String cc) {
    properties.put(CC_PROPERTY, cc);
    return this;
  }

  /**
   * The recipients to include in the CC-Line of the email
   */
  public final PutEmail removeCc() {
    properties.remove(CC_PROPERTY);
    return this;
  }

  /**
   * The recipients to include in the BCC-Line of the email
   */
  public final String getBcc() {
    return properties.get(BCC_PROPERTY);
  }

  /**
   * The recipients to include in the BCC-Line of the email
   */
  public final PutEmail setBcc(final String bcc) {
    properties.put(BCC_PROPERTY, bcc);
    return this;
  }

  /**
   * The recipients to include in the BCC-Line of the email
   */
  public final PutEmail removeBcc() {
    properties.remove(BCC_PROPERTY);
    return this;
  }

  /**
   * The email subject
   */
  public final String getSubject() {
    return properties.get(SUBJECT_PROPERTY);
  }

  /**
   * The email subject
   */
  public final PutEmail setSubject(final String subject) {
    properties.put(SUBJECT_PROPERTY, subject);
    return this;
  }

  /**
   * The email subject
   */
  public final PutEmail removeSubject() {
    properties.remove(SUBJECT_PROPERTY);
    return this;
  }

  /**
   * The body of the email message
   */
  public final String getMessage() {
    return properties.get(MESSAGE_PROPERTY);
  }

  /**
   * The body of the email message
   */
  public final PutEmail setMessage(final String message) {
    properties.put(MESSAGE_PROPERTY, message);
    return this;
  }

  /**
   * The body of the email message
   */
  public final PutEmail removeMessage() {
    properties.remove(MESSAGE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the FlowFile content should be the message of the email. If true, the 'Message' property is ignored.
   */
  public final String getEmailFfContentAsMessage() {
    return properties.get(EMAIL_FF_CONTENT_AS_MESSAGE_PROPERTY);
  }

  /**
   * Specifies whether or not the FlowFile content should be the message of the email. If true, the 'Message' property is ignored.
   */
  public final PutEmail setEmailFfContentAsMessage(final String emailFfContentAsMessage) {
    properties.put(EMAIL_FF_CONTENT_AS_MESSAGE_PROPERTY, emailFfContentAsMessage);
    return this;
  }

  /**
   * Specifies whether or not the FlowFile content should be the message of the email. If true, the 'Message' property is ignored.
   */
  public final PutEmail removeEmailFfContentAsMessage() {
    properties.remove(EMAIL_FF_CONTENT_AS_MESSAGE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the FlowFile content should be attached to the email
   */
  public final String getAttachFile() {
    return properties.get(ATTACH_FILE_PROPERTY);
  }

  /**
   * Specifies whether or not the FlowFile content should be attached to the email
   */
  public final PutEmail setAttachFile(final String attachFile) {
    properties.put(ATTACH_FILE_PROPERTY, attachFile);
    return this;
  }

  /**
   * Specifies whether or not the FlowFile content should be attached to the email
   */
  public final PutEmail removeAttachFile() {
    properties.remove(ATTACH_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not all FlowFile attributes should be recorded in the body of the email message
   */
  public final String getIncludeAllAttributesInMessage() {
    return properties.get(INCLUDE_ALL_ATTRIBUTES_IN_MESSAGE_PROPERTY);
  }

  /**
   * Specifies whether or not all FlowFile attributes should be recorded in the body of the email message
   */
  public final PutEmail setIncludeAllAttributesInMessage(
      final String includeAllAttributesInMessage) {
    properties.put(INCLUDE_ALL_ATTRIBUTES_IN_MESSAGE_PROPERTY, includeAllAttributesInMessage);
    return this;
  }

  /**
   * Specifies whether or not all FlowFile attributes should be recorded in the body of the email message
   */
  public final PutEmail removeIncludeAllAttributesInMessage() {
    properties.remove(INCLUDE_ALL_ATTRIBUTES_IN_MESSAGE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutEmail setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutEmail removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutEmail, PutEmail> configurator) {
    return configurator.apply(new PutEmail()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutEmail.class) final Closure<PutEmail> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutEmail> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutEmail.class, com.tibtech.nifi.processors.standard.PutEmail.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutEmail, PutEmail> configurator) {
    return configurator.apply(new PutEmail(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutEmail.class) final Closure<PutEmail> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutEmail> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutEmail.class, com.tibtech.nifi.processors.standard.PutEmail.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
