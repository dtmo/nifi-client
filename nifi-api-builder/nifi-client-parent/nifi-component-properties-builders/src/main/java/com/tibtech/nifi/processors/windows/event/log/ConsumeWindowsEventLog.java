package com.tibtech.nifi.processors.windows.event.log;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeWindowsEventLog {
  /**
   * The Windows Event Log Channel to listen to.
   */
  public static final String CHANNEL_PROPERTY = "channel";

  /**
   * XPath Query to filter events. (See https://msdn.microsoft.com/en-us/library/windows/desktop/dd996910(v=vs.85).aspx for examples.)
   */
  public static final String QUERY_PROPERTY = "query";

  /**
   * The individual Event Log XMLs are rendered to a buffer.  This specifies the maximum size in bytes that the buffer will be allowed to grow to. (Limiting the maximum size of an individual Event XML.)
   */
  public static final String MAX_BUFFER_PROPERTY = "maxBuffer";

  /**
   * Events are received asynchronously and must be output as FlowFiles when the processor is triggered.  This specifies the maximum number of events to queue for transformation into FlowFiles.
   */
  public static final String MAX_QUEUE_PROPERTY = "maxQueue";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Windows Event Log Channel to listen to.
   */
  public final String getChannel() {
    return properties.get(CHANNEL_PROPERTY);
  }

  /**
   * The Windows Event Log Channel to listen to.
   */
  public final ConsumeWindowsEventLog setChannel(final String channel) {
    properties.put(CHANNEL_PROPERTY, channel);
    return this;
  }

  /**
   * The Windows Event Log Channel to listen to.
   */
  public final ConsumeWindowsEventLog removeChannel() {
    properties.remove(CHANNEL_PROPERTY);
    return this;
  }

  /**
   * XPath Query to filter events. (See https://msdn.microsoft.com/en-us/library/windows/desktop/dd996910(v=vs.85).aspx for examples.)
   */
  public final String getQuery() {
    return properties.get(QUERY_PROPERTY);
  }

  /**
   * XPath Query to filter events. (See https://msdn.microsoft.com/en-us/library/windows/desktop/dd996910(v=vs.85).aspx for examples.)
   */
  public final ConsumeWindowsEventLog setQuery(final String query) {
    properties.put(QUERY_PROPERTY, query);
    return this;
  }

  /**
   * XPath Query to filter events. (See https://msdn.microsoft.com/en-us/library/windows/desktop/dd996910(v=vs.85).aspx for examples.)
   */
  public final ConsumeWindowsEventLog removeQuery() {
    properties.remove(QUERY_PROPERTY);
    return this;
  }

  /**
   * The individual Event Log XMLs are rendered to a buffer.  This specifies the maximum size in bytes that the buffer will be allowed to grow to. (Limiting the maximum size of an individual Event XML.)
   */
  public final String getMaxBuffer() {
    return properties.get(MAX_BUFFER_PROPERTY);
  }

  /**
   * The individual Event Log XMLs are rendered to a buffer.  This specifies the maximum size in bytes that the buffer will be allowed to grow to. (Limiting the maximum size of an individual Event XML.)
   */
  public final ConsumeWindowsEventLog setMaxBuffer(final String maxBuffer) {
    properties.put(MAX_BUFFER_PROPERTY, maxBuffer);
    return this;
  }

  /**
   * The individual Event Log XMLs are rendered to a buffer.  This specifies the maximum size in bytes that the buffer will be allowed to grow to. (Limiting the maximum size of an individual Event XML.)
   */
  public final ConsumeWindowsEventLog removeMaxBuffer() {
    properties.remove(MAX_BUFFER_PROPERTY);
    return this;
  }

  /**
   * Events are received asynchronously and must be output as FlowFiles when the processor is triggered.  This specifies the maximum number of events to queue for transformation into FlowFiles.
   */
  public final String getMaxQueue() {
    return properties.get(MAX_QUEUE_PROPERTY);
  }

  /**
   * Events are received asynchronously and must be output as FlowFiles when the processor is triggered.  This specifies the maximum number of events to queue for transformation into FlowFiles.
   */
  public final ConsumeWindowsEventLog setMaxQueue(final String maxQueue) {
    properties.put(MAX_QUEUE_PROPERTY, maxQueue);
    return this;
  }

  /**
   * Events are received asynchronously and must be output as FlowFiles when the processor is triggered.  This specifies the maximum number of events to queue for transformation into FlowFiles.
   */
  public final ConsumeWindowsEventLog removeMaxQueue() {
    properties.remove(MAX_QUEUE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeWindowsEventLog setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeWindowsEventLog removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConsumeWindowsEventLog, ConsumeWindowsEventLog> configurator) {
    return configurator.apply(new ConsumeWindowsEventLog()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeWindowsEventLog.class) final Closure<ConsumeWindowsEventLog> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.windows.event.log.ConsumeWindowsEventLog> code = closure.rehydrate(c, com.tibtech.nifi.processors.windows.event.log.ConsumeWindowsEventLog.class, com.tibtech.nifi.processors.windows.event.log.ConsumeWindowsEventLog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
