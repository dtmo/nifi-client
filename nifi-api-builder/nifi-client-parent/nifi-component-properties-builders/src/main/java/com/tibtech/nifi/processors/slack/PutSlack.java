package com.tibtech.nifi.processors.slack;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSlack {
  /**
   * The POST URL provided by Slack to send messages into a channel.
   */
  public static final String WEBHOOK_URL_PROPERTY = "webhook-url";

  /**
   * The text sent in the webhook message
   */
  public static final String WEBHOOK_TEXT_PROPERTY = "webhook-text";

  /**
   * A public channel using #channel or direct message using @username. If not specified, the default webhook channel as specified in Slack's Incoming Webhooks web interface is used.
   */
  public static final String CHANNEL_PROPERTY = "channel";

  /**
   * The displayed Slack username
   */
  public static final String USERNAME_PROPERTY = "username";

  /**
   * Icon URL to be used for the message
   */
  public static final String ICON_URL_PROPERTY = "icon-url";

  /**
   * Icon Emoji to be used for the message. Must begin and end with a colon, e.g. :ghost:
   */
  public static final String ICON_EMOJI_PROPERTY = "icon-emoji";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The POST URL provided by Slack to send messages into a channel.
   */
  public final String getWebhookUrl() {
    return properties.get(WEBHOOK_URL_PROPERTY);
  }

  /**
   * The POST URL provided by Slack to send messages into a channel.
   */
  public final PutSlack setWebhookUrl(final String webhookUrl) {
    properties.put(WEBHOOK_URL_PROPERTY, webhookUrl);
    return this;
  }

  /**
   * The POST URL provided by Slack to send messages into a channel.
   */
  public final PutSlack removeWebhookUrl() {
    properties.remove(WEBHOOK_URL_PROPERTY);
    return this;
  }

  /**
   * The text sent in the webhook message
   */
  public final String getWebhookText() {
    return properties.get(WEBHOOK_TEXT_PROPERTY);
  }

  /**
   * The text sent in the webhook message
   */
  public final PutSlack setWebhookText(final String webhookText) {
    properties.put(WEBHOOK_TEXT_PROPERTY, webhookText);
    return this;
  }

  /**
   * The text sent in the webhook message
   */
  public final PutSlack removeWebhookText() {
    properties.remove(WEBHOOK_TEXT_PROPERTY);
    return this;
  }

  /**
   * A public channel using #channel or direct message using @username. If not specified, the default webhook channel as specified in Slack's Incoming Webhooks web interface is used.
   */
  public final String getChannel() {
    return properties.get(CHANNEL_PROPERTY);
  }

  /**
   * A public channel using #channel or direct message using @username. If not specified, the default webhook channel as specified in Slack's Incoming Webhooks web interface is used.
   */
  public final PutSlack setChannel(final String channel) {
    properties.put(CHANNEL_PROPERTY, channel);
    return this;
  }

  /**
   * A public channel using #channel or direct message using @username. If not specified, the default webhook channel as specified in Slack's Incoming Webhooks web interface is used.
   */
  public final PutSlack removeChannel() {
    properties.remove(CHANNEL_PROPERTY);
    return this;
  }

  /**
   * The displayed Slack username
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * The displayed Slack username
   */
  public final PutSlack setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * The displayed Slack username
   */
  public final PutSlack removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Icon URL to be used for the message
   */
  public final String getIconUrl() {
    return properties.get(ICON_URL_PROPERTY);
  }

  /**
   * Icon URL to be used for the message
   */
  public final PutSlack setIconUrl(final String iconUrl) {
    properties.put(ICON_URL_PROPERTY, iconUrl);
    return this;
  }

  /**
   * Icon URL to be used for the message
   */
  public final PutSlack removeIconUrl() {
    properties.remove(ICON_URL_PROPERTY);
    return this;
  }

  /**
   * Icon Emoji to be used for the message. Must begin and end with a colon, e.g. :ghost:
   */
  public final String getIconEmoji() {
    return properties.get(ICON_EMOJI_PROPERTY);
  }

  /**
   * Icon Emoji to be used for the message. Must begin and end with a colon, e.g. :ghost:
   */
  public final PutSlack setIconEmoji(final String iconEmoji) {
    properties.put(ICON_EMOJI_PROPERTY, iconEmoji);
    return this;
  }

  /**
   * Icon Emoji to be used for the message. Must begin and end with a colon, e.g. :ghost:
   */
  public final PutSlack removeIconEmoji() {
    properties.remove(ICON_EMOJI_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSlack setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSlack removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutSlack, PutSlack> configurator) {
    return configurator.apply(new PutSlack()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSlack.class) final Closure<PutSlack> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.slack.PutSlack> code = closure.rehydrate(c, com.tibtech.nifi.processors.slack.PutSlack.class, com.tibtech.nifi.processors.slack.PutSlack.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
