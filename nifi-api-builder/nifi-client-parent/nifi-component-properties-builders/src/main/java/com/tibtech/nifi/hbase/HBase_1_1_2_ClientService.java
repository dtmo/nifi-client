package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HBase_1_1_2_ClientService {
  /**
   * Comma-separated list of Hadoop Configuration files, such as hbase-site.xml and core-site.xml for kerberos, including full paths to the files.
   */
  public static final String HADOOP_CONFIGURATION_FILES_PROPERTY = "Hadoop Configuration Files";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  /**
   * Comma-separated list of ZooKeeper hosts for HBase. Required if Hadoop Configuration Files are not provided.
   */
  public static final String ZOO_KEEPER_QUORUM_PROPERTY = "ZooKeeper Quorum";

  /**
   * The port on which ZooKeeper is accepting client connections. Required if Hadoop Configuration Files are not provided.
   */
  public static final String ZOO_KEEPER_CLIENT_PORT_PROPERTY = "ZooKeeper Client Port";

  /**
   * The ZooKeeper ZNode Parent value for HBase (example: /hbase). Required if Hadoop Configuration Files are not provided.
   */
  public static final String ZOO_KEEPER_Z_NODE_PARENT_PROPERTY = "ZooKeeper ZNode Parent";

  /**
   * The number of times the HBase client will retry connecting. Required if Hadoop Configuration Files are not provided.
   */
  public static final String H_BASE_CLIENT_RETRIES_PROPERTY = "HBase Client Retries";

  /**
   * The full path to the Phoenix client JAR. Required if Phoenix is installed on top of HBase.
   */
  public static final String PHOENIX_CLIENT_JAR_LOCATION_PROPERTY = "Phoenix Client JAR Location";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Comma-separated list of Hadoop Configuration files, such as hbase-site.xml and core-site.xml for kerberos, including full paths to the files.
   */
  public final String getHadoopConfigurationFiles() {
    return properties.get(HADOOP_CONFIGURATION_FILES_PROPERTY);
  }

  /**
   * Comma-separated list of Hadoop Configuration files, such as hbase-site.xml and core-site.xml for kerberos, including full paths to the files.
   */
  public final HBase_1_1_2_ClientService setHadoopConfigurationFiles(final String hadoopConfigurationFiles) {
    properties.put(HADOOP_CONFIGURATION_FILES_PROPERTY, hadoopConfigurationFiles);
    return this;
  }

  /**
   * Comma-separated list of Hadoop Configuration files, such as hbase-site.xml and core-site.xml for kerberos, including full paths to the files.
   */
  public final HBase_1_1_2_ClientService removeHadoopConfigurationFiles() {
    properties.remove(HADOOP_CONFIGURATION_FILES_PROPERTY);
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
  public final HBase_1_1_2_ClientService setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final HBase_1_1_2_ClientService removeKerberosPrincipal() {
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
  public final HBase_1_1_2_ClientService setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final HBase_1_1_2_ClientService removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of ZooKeeper hosts for HBase. Required if Hadoop Configuration Files are not provided.
   */
  public final String getZooKeeperQuorum() {
    return properties.get(ZOO_KEEPER_QUORUM_PROPERTY);
  }

  /**
   * Comma-separated list of ZooKeeper hosts for HBase. Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService setZooKeeperQuorum(final String zooKeeperQuorum) {
    properties.put(ZOO_KEEPER_QUORUM_PROPERTY, zooKeeperQuorum);
    return this;
  }

  /**
   * Comma-separated list of ZooKeeper hosts for HBase. Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService removeZooKeeperQuorum() {
    properties.remove(ZOO_KEEPER_QUORUM_PROPERTY);
    return this;
  }

  /**
   * The port on which ZooKeeper is accepting client connections. Required if Hadoop Configuration Files are not provided.
   */
  public final String getZooKeeperClientPort() {
    return properties.get(ZOO_KEEPER_CLIENT_PORT_PROPERTY);
  }

  /**
   * The port on which ZooKeeper is accepting client connections. Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService setZooKeeperClientPort(final String zooKeeperClientPort) {
    properties.put(ZOO_KEEPER_CLIENT_PORT_PROPERTY, zooKeeperClientPort);
    return this;
  }

  /**
   * The port on which ZooKeeper is accepting client connections. Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService removeZooKeeperClientPort() {
    properties.remove(ZOO_KEEPER_CLIENT_PORT_PROPERTY);
    return this;
  }

  /**
   * The ZooKeeper ZNode Parent value for HBase (example: /hbase). Required if Hadoop Configuration Files are not provided.
   */
  public final String getZooKeeperZNodeParent() {
    return properties.get(ZOO_KEEPER_Z_NODE_PARENT_PROPERTY);
  }

  /**
   * The ZooKeeper ZNode Parent value for HBase (example: /hbase). Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService setZooKeeperZNodeParent(final String zooKeeperZNodeParent) {
    properties.put(ZOO_KEEPER_Z_NODE_PARENT_PROPERTY, zooKeeperZNodeParent);
    return this;
  }

  /**
   * The ZooKeeper ZNode Parent value for HBase (example: /hbase). Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService removeZooKeeperZNodeParent() {
    properties.remove(ZOO_KEEPER_Z_NODE_PARENT_PROPERTY);
    return this;
  }

  /**
   * The number of times the HBase client will retry connecting. Required if Hadoop Configuration Files are not provided.
   */
  public final String getHBaseClientRetries() {
    return properties.get(H_BASE_CLIENT_RETRIES_PROPERTY);
  }

  /**
   * The number of times the HBase client will retry connecting. Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService setHBaseClientRetries(final String hBaseClientRetries) {
    properties.put(H_BASE_CLIENT_RETRIES_PROPERTY, hBaseClientRetries);
    return this;
  }

  /**
   * The number of times the HBase client will retry connecting. Required if Hadoop Configuration Files are not provided.
   */
  public final HBase_1_1_2_ClientService removeHBaseClientRetries() {
    properties.remove(H_BASE_CLIENT_RETRIES_PROPERTY);
    return this;
  }

  /**
   * The full path to the Phoenix client JAR. Required if Phoenix is installed on top of HBase.
   */
  public final String getPhoenixClientJarLocation() {
    return properties.get(PHOENIX_CLIENT_JAR_LOCATION_PROPERTY);
  }

  /**
   * The full path to the Phoenix client JAR. Required if Phoenix is installed on top of HBase.
   */
  public final HBase_1_1_2_ClientService setPhoenixClientJarLocation(final String phoenixClientJarLocation) {
    properties.put(PHOENIX_CLIENT_JAR_LOCATION_PROPERTY, phoenixClientJarLocation);
    return this;
  }

  /**
   * The full path to the Phoenix client JAR. Required if Phoenix is installed on top of HBase.
   */
  public final HBase_1_1_2_ClientService removePhoenixClientJarLocation() {
    properties.remove(PHOENIX_CLIENT_JAR_LOCATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HBase_1_1_2_ClientService setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HBase_1_1_2_ClientService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<HBase_1_1_2_ClientService, HBase_1_1_2_ClientService> configurator) {
    return configurator.apply(new HBase_1_1_2_ClientService()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HBase_1_1_2_ClientService.class) final Closure<HBase_1_1_2_ClientService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.HBase_1_1_2_ClientService> code = closure.rehydrate(c, com.tibtech.nifi.hbase.HBase_1_1_2_ClientService.class, com.tibtech.nifi.hbase.HBase_1_1_2_ClientService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
