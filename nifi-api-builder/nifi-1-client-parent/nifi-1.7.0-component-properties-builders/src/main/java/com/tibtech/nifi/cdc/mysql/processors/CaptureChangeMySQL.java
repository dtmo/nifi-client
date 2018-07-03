package com.tibtech.nifi.cdc.mysql.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CaptureChangeMySQL {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.cdc.mysql.processors.CaptureChangeMySQL";

  /**
   * A list of hostname/port entries corresponding to nodes in a MySQL cluster. The entries should be comma separated using a colon such as host1:port,host2:port,....  For example mysql.myhost.com:3306. This processor will attempt to connect to the hosts in the list in order. If one node goes down and failover is enabled for the cluster, then the processor will connect to the active node (assuming its host entry is specified in this property.  The default port for MySQL connections is 3306.
   */
  public static final String CAPTURE_CHANGE_MYSQL_HOSTS_PROPERTY = "capture-change-mysql-hosts";

  /**
   * The class name of the MySQL database driver class
   */
  public static final String CAPTURE_CHANGE_MYSQL_DRIVER_CLASS_PROPERTY = "capture-change-mysql-driver-class";

  /**
   * Comma-separated list of files/folders and/or URLs containing the MySQL driver JAR and its dependencies (if any). For example '/var/tmp/mysql-connector-java-5.1.38-bin.jar'
   */
  public static final String CAPTURE_CHANGE_MYSQL_DRIVER_LOCATIONS_PROPERTY = "capture-change-mysql-driver-locations";

  /**
   * Username to access the MySQL cluster
   */
  public static final String CAPTURE_CHANGE_MYSQL_USERNAME_PROPERTY = "capture-change-mysql-username";

  /**
   * Password to access the MySQL cluster
   */
  public static final String CAPTURE_CHANGE_MYSQL_PASSWORD_PROPERTY = "capture-change-mysql-password";

  /**
   * The client connecting to the MySQL replication group is actually a simplified slave (server), and the Server ID value must be unique across the whole replication group (i.e. different from any other Server ID being used by any master or slave). Thus, each instance of CaptureChangeMySQL must have a Server ID unique across the replication group. If the Server ID is not specified, it defaults to 65535.
   */
  public static final String CAPTURE_CHANGE_MYSQL_SERVER_ID_PROPERTY = "capture-change-mysql-server-id";

  /**
   * A regular expression (regex) for matching databases (or schemas, depending on your RDBMS' terminology) against the list of CDC events. The regex must match the database name as it is stored in the RDBMS. If the property is not set, the database name will not be used to filter the CDC events. NOTE: DDL events, even if they affect different databases, are associated with the database used by the session to execute the DDL. This means if a connection is made to one database, but the DDL is issued against another, then the connected database will be the one matched against the specified pattern.
   */
  public static final String CAPTURE_CHANGE_MYSQL_DB_NAME_PATTERN_PROPERTY = "capture-change-mysql-db-name-pattern";

  /**
   * A regular expression (regex) for matching CDC events affecting matching tables. The regex must match the table name as it is stored in the database. If the property is not set, no events will be filtered based on table name.
   */
  public static final String CAPTURE_CHANGE_MYSQL_NAME_PATTERN_PROPERTY = "capture-change-mysql-name-pattern";

  /**
   * The maximum amount of time allowed for a connection to be established, zero means there is effectively no limit.
   */
  public static final String CAPTURE_CHANGE_MYSQL_MAX_WAIT_TIME_PROPERTY = "capture-change-mysql-max-wait-time";

  /**
   * Identifies a Distributed Map Cache Client controller service to be used for keeping information about the various tables, columns, etc. needed by the processor. If a client is not specified, the generated events will not include column type or name information.
   */
  public static final String CAPTURE_CHANGE_MYSQL_DIST_MAP_CACHE_CLIENT_PROPERTY = "capture-change-mysql-dist-map-cache-client";

  /**
   * Specifies whether to get all available CDC events, regardless of the current binlog filename and/or position. If binlog filename and position values are present in the processor's State, this property's value is ignored. This allows for 4 different configurations: 1) If binlog data is available in processor State, that is used to determine the start location and the value of Retrieve All Records is ignored. 2) If no binlog data is in processor State, then Retrieve All Records set to true means start at the beginning of the binlog history. 3) If no binlog data is in processor State and Initial Binlog Filename/Position are not set, then Retrieve All Records set to false means start at the end of the binlog history. 4) If no binlog data is in processor State and Initial Binlog Filename/Position are set, then Retrieve All Records set to false means start at the specified initial binlog file/position. To reset the behavior, clear the processor state (refer to the State Management section of the processor's documentation).
   */
  public static final String CAPTURE_CHANGE_MYSQL_RETRIEVE_ALL_RECORDS_PROPERTY = "capture-change-mysql-retrieve-all-records";

  /**
   * Specifies whether to emit events corresponding to a BEGIN or COMMIT event in the binary log. Set to true if the BEGIN/COMMIT events are necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public static final String CAPTURE_CHANGE_MYSQL_INCLUDE_BEGIN_COMMIT_PROPERTY = "capture-change-mysql-include-begin-commit";

  /**
   * Specifies whether to emit events corresponding to Data Definition Language (DDL) events such as ALTER TABLE, TRUNCATE TABLE, e.g. in the binary log. Set to true if the DDL events are desired/necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public static final String CAPTURE_CHANGE_MYSQL_INCLUDE_DDL_EVENTS_PROPERTY = "capture-change-mysql-include-ddl-events";

  /**
   * Indicates how often to update the processor's state with binlog file/position values. A value of zero means that state will only be updated when the processor is stopped or shutdown. If at some point the processor state does not contain the desired binlog values, the last flow file emitted will contain the last observed values, and the processor can be returned to that state by using the Initial Binlog File, Initial Binlog Position, and Initial Sequence ID properties.
   */
  public static final String CAPTURE_CHANGE_MYSQL_STATE_UPDATE_INTERVAL_PROPERTY = "capture-change-mysql-state-update-interval";

  /**
   * Specifies an initial sequence identifier to use if this processor's State does not have a current sequence identifier. If a sequence identifier is present in the processor's State, this property is ignored. Sequence identifiers are monotonically increasing integers that record the order of flow files generated by the processor. They can be used with the EnforceOrder processor to guarantee ordered delivery of CDC events.
   */
  public static final String CAPTURE_CHANGE_MYSQL_INIT_SEQ_ID_PROPERTY = "capture-change-mysql-init-seq-id";

  /**
   * Specifies an initial binlog filename to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Position to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public static final String CAPTURE_CHANGE_MYSQL_INIT_BINLOG_FILENAME_PROPERTY = "capture-change-mysql-init-binlog-filename";

  /**
   * Specifies an initial offset into a binlog (specified by Initial Binlog Filename) to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Filename to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public static final String CAPTURE_CHANGE_MYSQL_INIT_BINLOG_POSITION_PROPERTY = "capture-change-mysql-init-binlog-position";

  private final Map<String, String> properties;

  public CaptureChangeMySQL() {
    this.properties = new HashMap<>();
  }

  public CaptureChangeMySQL(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A list of hostname/port entries corresponding to nodes in a MySQL cluster. The entries should be comma separated using a colon such as host1:port,host2:port,....  For example mysql.myhost.com:3306. This processor will attempt to connect to the hosts in the list in order. If one node goes down and failover is enabled for the cluster, then the processor will connect to the active node (assuming its host entry is specified in this property.  The default port for MySQL connections is 3306.
   */
  public final String getCaptureChangeMysqlHosts() {
    return properties.get(CAPTURE_CHANGE_MYSQL_HOSTS_PROPERTY);
  }

  /**
   * A list of hostname/port entries corresponding to nodes in a MySQL cluster. The entries should be comma separated using a colon such as host1:port,host2:port,....  For example mysql.myhost.com:3306. This processor will attempt to connect to the hosts in the list in order. If one node goes down and failover is enabled for the cluster, then the processor will connect to the active node (assuming its host entry is specified in this property.  The default port for MySQL connections is 3306.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlHosts(final String captureChangeMysqlHosts) {
    properties.put(CAPTURE_CHANGE_MYSQL_HOSTS_PROPERTY, captureChangeMysqlHosts);
    return this;
  }

  /**
   * A list of hostname/port entries corresponding to nodes in a MySQL cluster. The entries should be comma separated using a colon such as host1:port,host2:port,....  For example mysql.myhost.com:3306. This processor will attempt to connect to the hosts in the list in order. If one node goes down and failover is enabled for the cluster, then the processor will connect to the active node (assuming its host entry is specified in this property.  The default port for MySQL connections is 3306.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlHosts() {
    properties.remove(CAPTURE_CHANGE_MYSQL_HOSTS_PROPERTY);
    return this;
  }

  /**
   * The class name of the MySQL database driver class
   */
  public final String getCaptureChangeMysqlDriverClass() {
    return properties.get(CAPTURE_CHANGE_MYSQL_DRIVER_CLASS_PROPERTY);
  }

  /**
   * The class name of the MySQL database driver class
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlDriverClass(
      final String captureChangeMysqlDriverClass) {
    properties.put(CAPTURE_CHANGE_MYSQL_DRIVER_CLASS_PROPERTY, captureChangeMysqlDriverClass);
    return this;
  }

  /**
   * The class name of the MySQL database driver class
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlDriverClass() {
    properties.remove(CAPTURE_CHANGE_MYSQL_DRIVER_CLASS_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of files/folders and/or URLs containing the MySQL driver JAR and its dependencies (if any). For example '/var/tmp/mysql-connector-java-5.1.38-bin.jar'
   */
  public final String getCaptureChangeMysqlDriverLocations() {
    return properties.get(CAPTURE_CHANGE_MYSQL_DRIVER_LOCATIONS_PROPERTY);
  }

  /**
   * Comma-separated list of files/folders and/or URLs containing the MySQL driver JAR and its dependencies (if any). For example '/var/tmp/mysql-connector-java-5.1.38-bin.jar'
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlDriverLocations(
      final String captureChangeMysqlDriverLocations) {
    properties.put(CAPTURE_CHANGE_MYSQL_DRIVER_LOCATIONS_PROPERTY, captureChangeMysqlDriverLocations);
    return this;
  }

  /**
   * Comma-separated list of files/folders and/or URLs containing the MySQL driver JAR and its dependencies (if any). For example '/var/tmp/mysql-connector-java-5.1.38-bin.jar'
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlDriverLocations() {
    properties.remove(CAPTURE_CHANGE_MYSQL_DRIVER_LOCATIONS_PROPERTY);
    return this;
  }

  /**
   * Username to access the MySQL cluster
   */
  public final String getCaptureChangeMysqlUsername() {
    return properties.get(CAPTURE_CHANGE_MYSQL_USERNAME_PROPERTY);
  }

  /**
   * Username to access the MySQL cluster
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlUsername(
      final String captureChangeMysqlUsername) {
    properties.put(CAPTURE_CHANGE_MYSQL_USERNAME_PROPERTY, captureChangeMysqlUsername);
    return this;
  }

  /**
   * Username to access the MySQL cluster
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlUsername() {
    properties.remove(CAPTURE_CHANGE_MYSQL_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password to access the MySQL cluster
   */
  public final String getCaptureChangeMysqlPassword() {
    return properties.get(CAPTURE_CHANGE_MYSQL_PASSWORD_PROPERTY);
  }

  /**
   * Password to access the MySQL cluster
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlPassword(
      final String captureChangeMysqlPassword) {
    properties.put(CAPTURE_CHANGE_MYSQL_PASSWORD_PROPERTY, captureChangeMysqlPassword);
    return this;
  }

  /**
   * Password to access the MySQL cluster
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlPassword() {
    properties.remove(CAPTURE_CHANGE_MYSQL_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The client connecting to the MySQL replication group is actually a simplified slave (server), and the Server ID value must be unique across the whole replication group (i.e. different from any other Server ID being used by any master or slave). Thus, each instance of CaptureChangeMySQL must have a Server ID unique across the replication group. If the Server ID is not specified, it defaults to 65535.
   */
  public final String getCaptureChangeMysqlServerId() {
    return properties.get(CAPTURE_CHANGE_MYSQL_SERVER_ID_PROPERTY);
  }

  /**
   * The client connecting to the MySQL replication group is actually a simplified slave (server), and the Server ID value must be unique across the whole replication group (i.e. different from any other Server ID being used by any master or slave). Thus, each instance of CaptureChangeMySQL must have a Server ID unique across the replication group. If the Server ID is not specified, it defaults to 65535.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlServerId(
      final String captureChangeMysqlServerId) {
    properties.put(CAPTURE_CHANGE_MYSQL_SERVER_ID_PROPERTY, captureChangeMysqlServerId);
    return this;
  }

  /**
   * The client connecting to the MySQL replication group is actually a simplified slave (server), and the Server ID value must be unique across the whole replication group (i.e. different from any other Server ID being used by any master or slave). Thus, each instance of CaptureChangeMySQL must have a Server ID unique across the replication group. If the Server ID is not specified, it defaults to 65535.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlServerId() {
    properties.remove(CAPTURE_CHANGE_MYSQL_SERVER_ID_PROPERTY);
    return this;
  }

  /**
   * A regular expression (regex) for matching databases (or schemas, depending on your RDBMS' terminology) against the list of CDC events. The regex must match the database name as it is stored in the RDBMS. If the property is not set, the database name will not be used to filter the CDC events. NOTE: DDL events, even if they affect different databases, are associated with the database used by the session to execute the DDL. This means if a connection is made to one database, but the DDL is issued against another, then the connected database will be the one matched against the specified pattern.
   */
  public final String getCaptureChangeMysqlDbNamePattern() {
    return properties.get(CAPTURE_CHANGE_MYSQL_DB_NAME_PATTERN_PROPERTY);
  }

  /**
   * A regular expression (regex) for matching databases (or schemas, depending on your RDBMS' terminology) against the list of CDC events. The regex must match the database name as it is stored in the RDBMS. If the property is not set, the database name will not be used to filter the CDC events. NOTE: DDL events, even if they affect different databases, are associated with the database used by the session to execute the DDL. This means if a connection is made to one database, but the DDL is issued against another, then the connected database will be the one matched against the specified pattern.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlDbNamePattern(
      final String captureChangeMysqlDbNamePattern) {
    properties.put(CAPTURE_CHANGE_MYSQL_DB_NAME_PATTERN_PROPERTY, captureChangeMysqlDbNamePattern);
    return this;
  }

  /**
   * A regular expression (regex) for matching databases (or schemas, depending on your RDBMS' terminology) against the list of CDC events. The regex must match the database name as it is stored in the RDBMS. If the property is not set, the database name will not be used to filter the CDC events. NOTE: DDL events, even if they affect different databases, are associated with the database used by the session to execute the DDL. This means if a connection is made to one database, but the DDL is issued against another, then the connected database will be the one matched against the specified pattern.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlDbNamePattern() {
    properties.remove(CAPTURE_CHANGE_MYSQL_DB_NAME_PATTERN_PROPERTY);
    return this;
  }

  /**
   * A regular expression (regex) for matching CDC events affecting matching tables. The regex must match the table name as it is stored in the database. If the property is not set, no events will be filtered based on table name.
   */
  public final String getCaptureChangeMysqlNamePattern() {
    return properties.get(CAPTURE_CHANGE_MYSQL_NAME_PATTERN_PROPERTY);
  }

  /**
   * A regular expression (regex) for matching CDC events affecting matching tables. The regex must match the table name as it is stored in the database. If the property is not set, no events will be filtered based on table name.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlNamePattern(
      final String captureChangeMysqlNamePattern) {
    properties.put(CAPTURE_CHANGE_MYSQL_NAME_PATTERN_PROPERTY, captureChangeMysqlNamePattern);
    return this;
  }

  /**
   * A regular expression (regex) for matching CDC events affecting matching tables. The regex must match the table name as it is stored in the database. If the property is not set, no events will be filtered based on table name.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlNamePattern() {
    properties.remove(CAPTURE_CHANGE_MYSQL_NAME_PATTERN_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time allowed for a connection to be established, zero means there is effectively no limit.
   */
  public final String getCaptureChangeMysqlMaxWaitTime() {
    return properties.get(CAPTURE_CHANGE_MYSQL_MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time allowed for a connection to be established, zero means there is effectively no limit.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlMaxWaitTime(
      final String captureChangeMysqlMaxWaitTime) {
    properties.put(CAPTURE_CHANGE_MYSQL_MAX_WAIT_TIME_PROPERTY, captureChangeMysqlMaxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time allowed for a connection to be established, zero means there is effectively no limit.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlMaxWaitTime() {
    properties.remove(CAPTURE_CHANGE_MYSQL_MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * Identifies a Distributed Map Cache Client controller service to be used for keeping information about the various tables, columns, etc. needed by the processor. If a client is not specified, the generated events will not include column type or name information.
   */
  public final String getCaptureChangeMysqlDistMapCacheClient() {
    return properties.get(CAPTURE_CHANGE_MYSQL_DIST_MAP_CACHE_CLIENT_PROPERTY);
  }

  /**
   * Identifies a Distributed Map Cache Client controller service to be used for keeping information about the various tables, columns, etc. needed by the processor. If a client is not specified, the generated events will not include column type or name information.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlDistMapCacheClient(
      final String captureChangeMysqlDistMapCacheClient) {
    properties.put(CAPTURE_CHANGE_MYSQL_DIST_MAP_CACHE_CLIENT_PROPERTY, captureChangeMysqlDistMapCacheClient);
    return this;
  }

  /**
   * Identifies a Distributed Map Cache Client controller service to be used for keeping information about the various tables, columns, etc. needed by the processor. If a client is not specified, the generated events will not include column type or name information.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlDistMapCacheClient() {
    properties.remove(CAPTURE_CHANGE_MYSQL_DIST_MAP_CACHE_CLIENT_PROPERTY);
    return this;
  }

  /**
   * Specifies whether to get all available CDC events, regardless of the current binlog filename and/or position. If binlog filename and position values are present in the processor's State, this property's value is ignored. This allows for 4 different configurations: 1) If binlog data is available in processor State, that is used to determine the start location and the value of Retrieve All Records is ignored. 2) If no binlog data is in processor State, then Retrieve All Records set to true means start at the beginning of the binlog history. 3) If no binlog data is in processor State and Initial Binlog Filename/Position are not set, then Retrieve All Records set to false means start at the end of the binlog history. 4) If no binlog data is in processor State and Initial Binlog Filename/Position are set, then Retrieve All Records set to false means start at the specified initial binlog file/position. To reset the behavior, clear the processor state (refer to the State Management section of the processor's documentation).
   */
  public final String getCaptureChangeMysqlRetrieveAllRecords() {
    return properties.get(CAPTURE_CHANGE_MYSQL_RETRIEVE_ALL_RECORDS_PROPERTY);
  }

  /**
   * Specifies whether to get all available CDC events, regardless of the current binlog filename and/or position. If binlog filename and position values are present in the processor's State, this property's value is ignored. This allows for 4 different configurations: 1) If binlog data is available in processor State, that is used to determine the start location and the value of Retrieve All Records is ignored. 2) If no binlog data is in processor State, then Retrieve All Records set to true means start at the beginning of the binlog history. 3) If no binlog data is in processor State and Initial Binlog Filename/Position are not set, then Retrieve All Records set to false means start at the end of the binlog history. 4) If no binlog data is in processor State and Initial Binlog Filename/Position are set, then Retrieve All Records set to false means start at the specified initial binlog file/position. To reset the behavior, clear the processor state (refer to the State Management section of the processor's documentation).
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlRetrieveAllRecords(
      final String captureChangeMysqlRetrieveAllRecords) {
    properties.put(CAPTURE_CHANGE_MYSQL_RETRIEVE_ALL_RECORDS_PROPERTY, captureChangeMysqlRetrieveAllRecords);
    return this;
  }

  /**
   * Specifies whether to get all available CDC events, regardless of the current binlog filename and/or position. If binlog filename and position values are present in the processor's State, this property's value is ignored. This allows for 4 different configurations: 1) If binlog data is available in processor State, that is used to determine the start location and the value of Retrieve All Records is ignored. 2) If no binlog data is in processor State, then Retrieve All Records set to true means start at the beginning of the binlog history. 3) If no binlog data is in processor State and Initial Binlog Filename/Position are not set, then Retrieve All Records set to false means start at the end of the binlog history. 4) If no binlog data is in processor State and Initial Binlog Filename/Position are set, then Retrieve All Records set to false means start at the specified initial binlog file/position. To reset the behavior, clear the processor state (refer to the State Management section of the processor's documentation).
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlRetrieveAllRecords() {
    properties.remove(CAPTURE_CHANGE_MYSQL_RETRIEVE_ALL_RECORDS_PROPERTY);
    return this;
  }

  /**
   * Specifies whether to emit events corresponding to a BEGIN or COMMIT event in the binary log. Set to true if the BEGIN/COMMIT events are necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public final String getCaptureChangeMysqlIncludeBeginCommit() {
    return properties.get(CAPTURE_CHANGE_MYSQL_INCLUDE_BEGIN_COMMIT_PROPERTY);
  }

  /**
   * Specifies whether to emit events corresponding to a BEGIN or COMMIT event in the binary log. Set to true if the BEGIN/COMMIT events are necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlIncludeBeginCommit(
      final String captureChangeMysqlIncludeBeginCommit) {
    properties.put(CAPTURE_CHANGE_MYSQL_INCLUDE_BEGIN_COMMIT_PROPERTY, captureChangeMysqlIncludeBeginCommit);
    return this;
  }

  /**
   * Specifies whether to emit events corresponding to a BEGIN or COMMIT event in the binary log. Set to true if the BEGIN/COMMIT events are necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlIncludeBeginCommit() {
    properties.remove(CAPTURE_CHANGE_MYSQL_INCLUDE_BEGIN_COMMIT_PROPERTY);
    return this;
  }

  /**
   * Specifies whether to emit events corresponding to Data Definition Language (DDL) events such as ALTER TABLE, TRUNCATE TABLE, e.g. in the binary log. Set to true if the DDL events are desired/necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public final String getCaptureChangeMysqlIncludeDdlEvents() {
    return properties.get(CAPTURE_CHANGE_MYSQL_INCLUDE_DDL_EVENTS_PROPERTY);
  }

  /**
   * Specifies whether to emit events corresponding to Data Definition Language (DDL) events such as ALTER TABLE, TRUNCATE TABLE, e.g. in the binary log. Set to true if the DDL events are desired/necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlIncludeDdlEvents(
      final String captureChangeMysqlIncludeDdlEvents) {
    properties.put(CAPTURE_CHANGE_MYSQL_INCLUDE_DDL_EVENTS_PROPERTY, captureChangeMysqlIncludeDdlEvents);
    return this;
  }

  /**
   * Specifies whether to emit events corresponding to Data Definition Language (DDL) events such as ALTER TABLE, TRUNCATE TABLE, e.g. in the binary log. Set to true if the DDL events are desired/necessary in the downstream flow, otherwise set to false, which suppresses generation of these events and can increase flow performance.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlIncludeDdlEvents() {
    properties.remove(CAPTURE_CHANGE_MYSQL_INCLUDE_DDL_EVENTS_PROPERTY);
    return this;
  }

  /**
   * Indicates how often to update the processor's state with binlog file/position values. A value of zero means that state will only be updated when the processor is stopped or shutdown. If at some point the processor state does not contain the desired binlog values, the last flow file emitted will contain the last observed values, and the processor can be returned to that state by using the Initial Binlog File, Initial Binlog Position, and Initial Sequence ID properties.
   */
  public final String getCaptureChangeMysqlStateUpdateInterval() {
    return properties.get(CAPTURE_CHANGE_MYSQL_STATE_UPDATE_INTERVAL_PROPERTY);
  }

  /**
   * Indicates how often to update the processor's state with binlog file/position values. A value of zero means that state will only be updated when the processor is stopped or shutdown. If at some point the processor state does not contain the desired binlog values, the last flow file emitted will contain the last observed values, and the processor can be returned to that state by using the Initial Binlog File, Initial Binlog Position, and Initial Sequence ID properties.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlStateUpdateInterval(
      final String captureChangeMysqlStateUpdateInterval) {
    properties.put(CAPTURE_CHANGE_MYSQL_STATE_UPDATE_INTERVAL_PROPERTY, captureChangeMysqlStateUpdateInterval);
    return this;
  }

  /**
   * Indicates how often to update the processor's state with binlog file/position values. A value of zero means that state will only be updated when the processor is stopped or shutdown. If at some point the processor state does not contain the desired binlog values, the last flow file emitted will contain the last observed values, and the processor can be returned to that state by using the Initial Binlog File, Initial Binlog Position, and Initial Sequence ID properties.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlStateUpdateInterval() {
    properties.remove(CAPTURE_CHANGE_MYSQL_STATE_UPDATE_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * Specifies an initial sequence identifier to use if this processor's State does not have a current sequence identifier. If a sequence identifier is present in the processor's State, this property is ignored. Sequence identifiers are monotonically increasing integers that record the order of flow files generated by the processor. They can be used with the EnforceOrder processor to guarantee ordered delivery of CDC events.
   */
  public final String getCaptureChangeMysqlInitSeqId() {
    return properties.get(CAPTURE_CHANGE_MYSQL_INIT_SEQ_ID_PROPERTY);
  }

  /**
   * Specifies an initial sequence identifier to use if this processor's State does not have a current sequence identifier. If a sequence identifier is present in the processor's State, this property is ignored. Sequence identifiers are monotonically increasing integers that record the order of flow files generated by the processor. They can be used with the EnforceOrder processor to guarantee ordered delivery of CDC events.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlInitSeqId(
      final String captureChangeMysqlInitSeqId) {
    properties.put(CAPTURE_CHANGE_MYSQL_INIT_SEQ_ID_PROPERTY, captureChangeMysqlInitSeqId);
    return this;
  }

  /**
   * Specifies an initial sequence identifier to use if this processor's State does not have a current sequence identifier. If a sequence identifier is present in the processor's State, this property is ignored. Sequence identifiers are monotonically increasing integers that record the order of flow files generated by the processor. They can be used with the EnforceOrder processor to guarantee ordered delivery of CDC events.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlInitSeqId() {
    properties.remove(CAPTURE_CHANGE_MYSQL_INIT_SEQ_ID_PROPERTY);
    return this;
  }

  /**
   * Specifies an initial binlog filename to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Position to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public final String getCaptureChangeMysqlInitBinlogFilename() {
    return properties.get(CAPTURE_CHANGE_MYSQL_INIT_BINLOG_FILENAME_PROPERTY);
  }

  /**
   * Specifies an initial binlog filename to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Position to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlInitBinlogFilename(
      final String captureChangeMysqlInitBinlogFilename) {
    properties.put(CAPTURE_CHANGE_MYSQL_INIT_BINLOG_FILENAME_PROPERTY, captureChangeMysqlInitBinlogFilename);
    return this;
  }

  /**
   * Specifies an initial binlog filename to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Position to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlInitBinlogFilename() {
    properties.remove(CAPTURE_CHANGE_MYSQL_INIT_BINLOG_FILENAME_PROPERTY);
    return this;
  }

  /**
   * Specifies an initial offset into a binlog (specified by Initial Binlog Filename) to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Filename to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public final String getCaptureChangeMysqlInitBinlogPosition() {
    return properties.get(CAPTURE_CHANGE_MYSQL_INIT_BINLOG_POSITION_PROPERTY);
  }

  /**
   * Specifies an initial offset into a binlog (specified by Initial Binlog Filename) to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Filename to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public final CaptureChangeMySQL setCaptureChangeMysqlInitBinlogPosition(
      final String captureChangeMysqlInitBinlogPosition) {
    properties.put(CAPTURE_CHANGE_MYSQL_INIT_BINLOG_POSITION_PROPERTY, captureChangeMysqlInitBinlogPosition);
    return this;
  }

  /**
   * Specifies an initial offset into a binlog (specified by Initial Binlog Filename) to use if this processor's State does not have a current binlog filename. If a filename is present in the processor's State, this property is ignored. This can be used along with Initial Binlog Filename to "skip ahead" if previous events are not desired. Note that NiFi Expression Language is supported, but this property is evaluated when the processor is configured, so FlowFile attributes may not be used. Expression Language is supported to enable the use of the Variable Registry and/or environment properties.
   */
  public final CaptureChangeMySQL removeCaptureChangeMysqlInitBinlogPosition() {
    properties.remove(CAPTURE_CHANGE_MYSQL_INIT_BINLOG_POSITION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CaptureChangeMySQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CaptureChangeMySQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CaptureChangeMySQL, CaptureChangeMySQL> configurator) {
    return configurator.apply(new CaptureChangeMySQL()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CaptureChangeMySQL.class) final Closure<CaptureChangeMySQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.cdc.mysql.processors.CaptureChangeMySQL> code = closure.rehydrate(c, com.tibtech.nifi.cdc.mysql.processors.CaptureChangeMySQL.class, com.tibtech.nifi.cdc.mysql.processors.CaptureChangeMySQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CaptureChangeMySQL, CaptureChangeMySQL> configurator) {
    return configurator.apply(new CaptureChangeMySQL(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CaptureChangeMySQL.class) final Closure<CaptureChangeMySQL> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.cdc.mysql.processors.CaptureChangeMySQL> code = closure.rehydrate(c, com.tibtech.nifi.cdc.mysql.processors.CaptureChangeMySQL.class, com.tibtech.nifi.cdc.mysql.processors.CaptureChangeMySQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
