package com.tibtech.nifi.processors.hadoop.inotify;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetHDFSEvents {
  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public static final String HADOOP_CONFIGURATION_RESOURCES_PROPERTY = "Hadoop Configuration Resources";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public static final String KERBEROS_RELOGIN_PERIOD_PROPERTY = "Kerberos Relogin Period";

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public static final String ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY = "Additional Classpath Resources";

  /**
   * The time before the polling method returns with the next batch of events if they exist. It may exceed this amount of time by up to the time required for an RPC to the NameNode.
   */
  public static final String POLL_DURATION_PROPERTY = "Poll Duration";

  /**
   * The HDFS path to get event notifications for. This property accepts both expression language and regular expressions. This will be evaluated during the OnScheduled phase.
   */
  public static final String HDFS_PATH_TO_WATCH_PROPERTY = "HDFS Path to Watch";

  /**
   * If true and the final component of the path associated with a given event starts with a '.' then that event will not be processed.
   */
  public static final String IGNORE_HIDDEN_FILES_PROPERTY = "Ignore Hidden Files";

  /**
   * A comma-separated list of event types to process. Valid event types are: append, close, create, metadata, rename, and unlink. Case does not matter.
   */
  public static final String EVENT_TYPES_TO_FILTER_ON_PROPERTY = "Event Types to Filter On";

  /**
   * According to the HDFS admin API for event polling it is good to retry at least a few times. This number defines how many times the poll will be retried if it throws an IOException.
   */
  public static final String IO_EXCEPTION_RETRIES_DURING_EVENT_POLLING_PROPERTY = "IOException Retries During Event Polling";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final String getHadoopConfigurationResources() {
    return properties.get(HADOOP_CONFIGURATION_RESOURCES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final GetHDFSEvents setHadoopConfigurationResources(final String hadoopConfigurationResources) {
    properties.put(HADOOP_CONFIGURATION_RESOURCES_PROPERTY, hadoopConfigurationResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final GetHDFSEvents removeHadoopConfigurationResources() {
    properties.remove(HADOOP_CONFIGURATION_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosPrincipal() {
    return properties.get(KERBEROS_PRINCIPAL_PROPERTY);
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSEvents setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSEvents removeKerberosPrincipal() {
    properties.remove(KERBEROS_PRINCIPAL_PROPERTY);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosKeytab() {
    return properties.get(KERBEROS_KEYTAB_PROPERTY);
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSEvents setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final GetHDFSEvents removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final String getKerberosReloginPeriod() {
    return properties.get(KERBEROS_RELOGIN_PERIOD_PROPERTY);
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final GetHDFSEvents setKerberosReloginPeriod(final String kerberosReloginPeriod) {
    properties.put(KERBEROS_RELOGIN_PERIOD_PROPERTY, kerberosReloginPeriod);
    return this;
  }

  /**
   * Period of time which should pass before attempting a kerberos relogin
   */
  public final GetHDFSEvents removeKerberosReloginPeriod() {
    properties.remove(KERBEROS_RELOGIN_PERIOD_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final String getAdditionalClasspathResources() {
    return properties.get(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final GetHDFSEvents setAdditionalClasspathResources(final String additionalClasspathResources) {
    properties.put(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY, additionalClasspathResources);
    return this;
  }

  /**
   * A comma-separated list of paths to files and/or directories that will be added to the classpath. When specifying a directory, all files with in the directory will be added to the classpath, but further sub-directories will not be included.
   */
  public final GetHDFSEvents removeAdditionalClasspathResources() {
    properties.remove(ADDITIONAL_CLASSPATH_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * The time before the polling method returns with the next batch of events if they exist. It may exceed this amount of time by up to the time required for an RPC to the NameNode.
   */
  public final String getPollDuration() {
    return properties.get(POLL_DURATION_PROPERTY);
  }

  /**
   * The time before the polling method returns with the next batch of events if they exist. It may exceed this amount of time by up to the time required for an RPC to the NameNode.
   */
  public final GetHDFSEvents setPollDuration(final String pollDuration) {
    properties.put(POLL_DURATION_PROPERTY, pollDuration);
    return this;
  }

  /**
   * The time before the polling method returns with the next batch of events if they exist. It may exceed this amount of time by up to the time required for an RPC to the NameNode.
   */
  public final GetHDFSEvents removePollDuration() {
    properties.remove(POLL_DURATION_PROPERTY);
    return this;
  }

  /**
   * The HDFS path to get event notifications for. This property accepts both expression language and regular expressions. This will be evaluated during the OnScheduled phase.
   */
  public final String getHdfsPathToWatch() {
    return properties.get(HDFS_PATH_TO_WATCH_PROPERTY);
  }

  /**
   * The HDFS path to get event notifications for. This property accepts both expression language and regular expressions. This will be evaluated during the OnScheduled phase.
   */
  public final GetHDFSEvents setHdfsPathToWatch(final String hdfsPathToWatch) {
    properties.put(HDFS_PATH_TO_WATCH_PROPERTY, hdfsPathToWatch);
    return this;
  }

  /**
   * The HDFS path to get event notifications for. This property accepts both expression language and regular expressions. This will be evaluated during the OnScheduled phase.
   */
  public final GetHDFSEvents removeHdfsPathToWatch() {
    properties.remove(HDFS_PATH_TO_WATCH_PROPERTY);
    return this;
  }

  /**
   * If true and the final component of the path associated with a given event starts with a '.' then that event will not be processed.
   */
  public final String getIgnoreHiddenFiles() {
    return properties.get(IGNORE_HIDDEN_FILES_PROPERTY);
  }

  /**
   * If true and the final component of the path associated with a given event starts with a '.' then that event will not be processed.
   */
  public final GetHDFSEvents setIgnoreHiddenFiles(final String ignoreHiddenFiles) {
    properties.put(IGNORE_HIDDEN_FILES_PROPERTY, ignoreHiddenFiles);
    return this;
  }

  /**
   * If true and the final component of the path associated with a given event starts with a '.' then that event will not be processed.
   */
  public final GetHDFSEvents removeIgnoreHiddenFiles() {
    properties.remove(IGNORE_HIDDEN_FILES_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of event types to process. Valid event types are: append, close, create, metadata, rename, and unlink. Case does not matter.
   */
  public final String getEventTypesToFilterOn() {
    return properties.get(EVENT_TYPES_TO_FILTER_ON_PROPERTY);
  }

  /**
   * A comma-separated list of event types to process. Valid event types are: append, close, create, metadata, rename, and unlink. Case does not matter.
   */
  public final GetHDFSEvents setEventTypesToFilterOn(final String eventTypesToFilterOn) {
    properties.put(EVENT_TYPES_TO_FILTER_ON_PROPERTY, eventTypesToFilterOn);
    return this;
  }

  /**
   * A comma-separated list of event types to process. Valid event types are: append, close, create, metadata, rename, and unlink. Case does not matter.
   */
  public final GetHDFSEvents removeEventTypesToFilterOn() {
    properties.remove(EVENT_TYPES_TO_FILTER_ON_PROPERTY);
    return this;
  }

  /**
   * According to the HDFS admin API for event polling it is good to retry at least a few times. This number defines how many times the poll will be retried if it throws an IOException.
   */
  public final String getIoExceptionRetriesDuringEventPolling() {
    return properties.get(IO_EXCEPTION_RETRIES_DURING_EVENT_POLLING_PROPERTY);
  }

  /**
   * According to the HDFS admin API for event polling it is good to retry at least a few times. This number defines how many times the poll will be retried if it throws an IOException.
   */
  public final GetHDFSEvents setIoExceptionRetriesDuringEventPolling(final String ioExceptionRetriesDuringEventPolling) {
    properties.put(IO_EXCEPTION_RETRIES_DURING_EVENT_POLLING_PROPERTY, ioExceptionRetriesDuringEventPolling);
    return this;
  }

  /**
   * According to the HDFS admin API for event polling it is good to retry at least a few times. This number defines how many times the poll will be retried if it throws an IOException.
   */
  public final GetHDFSEvents removeIoExceptionRetriesDuringEventPolling() {
    properties.remove(IO_EXCEPTION_RETRIES_DURING_EVENT_POLLING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetHDFSEvents setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetHDFSEvents removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetHDFSEvents, GetHDFSEvents> configurator) {
    return configurator.apply(new GetHDFSEvents()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHDFSEvents.class) final Closure<GetHDFSEvents> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hadoop.inotify.GetHDFSEvents> code = closure.rehydrate(c, com.tibtech.nifi.processors.hadoop.inotify.GetHDFSEvents.class, com.tibtech.nifi.processors.hadoop.inotify.GetHDFSEvents.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
