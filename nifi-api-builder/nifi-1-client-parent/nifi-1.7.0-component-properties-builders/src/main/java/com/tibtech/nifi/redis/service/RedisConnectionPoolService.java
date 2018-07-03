package com.tibtech.nifi.redis.service;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RedisConnectionPoolService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.redis.service.RedisConnectionPoolService";

  /**
   * The type of Redis being communicated with - standalone, sentinel, or clustered.
   */
  public static final String REDIS_MODE_PROPERTY = "Redis Mode";

  /**
   * The connection string for Redis. In a standalone instance this value will be of the form hostname:port. In a sentinel instance this value will be the comma-separated list of sentinels, such as host1:port1,host2:port2,host3:port3. In a clustered instance this value will be the comma-separated list of cluster masters, such as host1:port,host2:port,host3:port.
   */
  public static final String CONNECTION_STRING_PROPERTY = "Connection String";

  /**
   * The database index to be used by connections created from this connection pool. See the databases property in redis.conf, by default databases 0-15 will be available.
   */
  public static final String DATABASE_INDEX_PROPERTY = "Database Index";

  /**
   * The timeout to use when attempting to communicate with Redis.
   */
  public static final String COMMUNICATION_TIMEOUT_PROPERTY = "Communication Timeout";

  /**
   * The maximum number of redirects that can be performed when clustered.
   */
  public static final String CLUSTER_MAX_REDIRECTS_PROPERTY = "Cluster Max Redirects";

  /**
   * The name of the sentinel master, require when Mode is set to Sentinel
   */
  public static final String SENTINEL_MASTER_PROPERTY = "Sentinel Master";

  /**
   * The password used to authenticate to the Redis server. See the requirepass property in redis.conf.
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The maximum number of connections that can be allocated by the pool (checked out to clients, or idle awaiting checkout). A negative value indicates that there is no limit.
   */
  public static final String POOL_MAX_TOTAL_PROPERTY = "Pool - Max Total";

  /**
   * The maximum number of idle connections that can be held in the pool, or a negative value if there is no limit.
   */
  public static final String POOL_MAX_IDLE_PROPERTY = "Pool - Max Idle";

  /**
   * The target for the minimum number of idle connections to maintain in the pool. If the configured value of Min Idle is greater than the configured value for Max Idle, then the value of Max Idle will be used instead.
   */
  public static final String POOL_MIN_IDLE_PROPERTY = "Pool - Min Idle";

  /**
   * Whether or not clients should block and wait when trying to obtain a connection from the pool when the pool has no available connections. Setting this to false means an error will occur immediately when a client requests a connection and none are available.
   */
  public static final String POOL_BLOCK_WHEN_EXHAUSTED_PROPERTY = "Pool - Block When Exhausted";

  /**
   * The amount of time to wait for an available connection when Block When Exhausted is set to true.
   */
  public static final String POOL_MAX_WAIT_TIME_PROPERTY = "Pool - Max Wait Time";

  /**
   * The minimum amount of time an object may sit idle in the pool before it is eligible for eviction.
   */
  public static final String POOL_MIN_EVICTABLE_IDLE_TIME_PROPERTY = "Pool - Min Evictable Idle Time";

  /**
   * The amount of time between attempting to evict idle connections from the pool.
   */
  public static final String POOL_TIME_BETWEEN_EVICTION_RUNS_PROPERTY = "Pool - Time Between Eviction Runs";

  /**
   * The number of connections to tests per eviction attempt. A negative value indicates to test all connections.
   */
  public static final String POOL_NUM_TESTS_PER_EVICTION_RUN_PROPERTY = "Pool - Num Tests Per Eviction Run";

  /**
   * Whether or not connections should be tested upon creation.
   */
  public static final String POOL_TEST_ON_CREATE_PROPERTY = "Pool - Test On Create";

  /**
   * Whether or not connections should be tested upon borrowing from the pool.
   */
  public static final String POOL_TEST_ON_BORROW_PROPERTY = "Pool - Test On Borrow";

  /**
   * Whether or not connections should be tested upon returning to the pool.
   */
  public static final String POOL_TEST_ON_RETURN_PROPERTY = "Pool - Test On Return";

  /**
   * Whether or not connections should be tested while idle.
   */
  public static final String POOL_TEST_WHILE_IDLE_PROPERTY = "Pool - Test While Idle";

  private final Map<String, String> properties;

  public RedisConnectionPoolService() {
    this.properties = new HashMap<>();
  }

  public RedisConnectionPoolService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The type of Redis being communicated with - standalone, sentinel, or clustered.
   */
  public final String getRedisMode() {
    return properties.get(REDIS_MODE_PROPERTY);
  }

  /**
   * The type of Redis being communicated with - standalone, sentinel, or clustered.
   */
  public final RedisConnectionPoolService setRedisMode(final String redisMode) {
    properties.put(REDIS_MODE_PROPERTY, redisMode);
    return this;
  }

  /**
   * The type of Redis being communicated with - standalone, sentinel, or clustered.
   */
  public final RedisConnectionPoolService removeRedisMode() {
    properties.remove(REDIS_MODE_PROPERTY);
    return this;
  }

  /**
   * The connection string for Redis. In a standalone instance this value will be of the form hostname:port. In a sentinel instance this value will be the comma-separated list of sentinels, such as host1:port1,host2:port2,host3:port3. In a clustered instance this value will be the comma-separated list of cluster masters, such as host1:port,host2:port,host3:port.
   */
  public final String getConnectionString() {
    return properties.get(CONNECTION_STRING_PROPERTY);
  }

  /**
   * The connection string for Redis. In a standalone instance this value will be of the form hostname:port. In a sentinel instance this value will be the comma-separated list of sentinels, such as host1:port1,host2:port2,host3:port3. In a clustered instance this value will be the comma-separated list of cluster masters, such as host1:port,host2:port,host3:port.
   */
  public final RedisConnectionPoolService setConnectionString(final String connectionString) {
    properties.put(CONNECTION_STRING_PROPERTY, connectionString);
    return this;
  }

  /**
   * The connection string for Redis. In a standalone instance this value will be of the form hostname:port. In a sentinel instance this value will be the comma-separated list of sentinels, such as host1:port1,host2:port2,host3:port3. In a clustered instance this value will be the comma-separated list of cluster masters, such as host1:port,host2:port,host3:port.
   */
  public final RedisConnectionPoolService removeConnectionString() {
    properties.remove(CONNECTION_STRING_PROPERTY);
    return this;
  }

  /**
   * The database index to be used by connections created from this connection pool. See the databases property in redis.conf, by default databases 0-15 will be available.
   */
  public final String getDatabaseIndex() {
    return properties.get(DATABASE_INDEX_PROPERTY);
  }

  /**
   * The database index to be used by connections created from this connection pool. See the databases property in redis.conf, by default databases 0-15 will be available.
   */
  public final RedisConnectionPoolService setDatabaseIndex(final String databaseIndex) {
    properties.put(DATABASE_INDEX_PROPERTY, databaseIndex);
    return this;
  }

  /**
   * The database index to be used by connections created from this connection pool. See the databases property in redis.conf, by default databases 0-15 will be available.
   */
  public final RedisConnectionPoolService removeDatabaseIndex() {
    properties.remove(DATABASE_INDEX_PROPERTY);
    return this;
  }

  /**
   * The timeout to use when attempting to communicate with Redis.
   */
  public final String getCommunicationTimeout() {
    return properties.get(COMMUNICATION_TIMEOUT_PROPERTY);
  }

  /**
   * The timeout to use when attempting to communicate with Redis.
   */
  public final RedisConnectionPoolService setCommunicationTimeout(
      final String communicationTimeout) {
    properties.put(COMMUNICATION_TIMEOUT_PROPERTY, communicationTimeout);
    return this;
  }

  /**
   * The timeout to use when attempting to communicate with Redis.
   */
  public final RedisConnectionPoolService removeCommunicationTimeout() {
    properties.remove(COMMUNICATION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of redirects that can be performed when clustered.
   */
  public final String getClusterMaxRedirects() {
    return properties.get(CLUSTER_MAX_REDIRECTS_PROPERTY);
  }

  /**
   * The maximum number of redirects that can be performed when clustered.
   */
  public final RedisConnectionPoolService setClusterMaxRedirects(final String clusterMaxRedirects) {
    properties.put(CLUSTER_MAX_REDIRECTS_PROPERTY, clusterMaxRedirects);
    return this;
  }

  /**
   * The maximum number of redirects that can be performed when clustered.
   */
  public final RedisConnectionPoolService removeClusterMaxRedirects() {
    properties.remove(CLUSTER_MAX_REDIRECTS_PROPERTY);
    return this;
  }

  /**
   * The name of the sentinel master, require when Mode is set to Sentinel
   */
  public final String getSentinelMaster() {
    return properties.get(SENTINEL_MASTER_PROPERTY);
  }

  /**
   * The name of the sentinel master, require when Mode is set to Sentinel
   */
  public final RedisConnectionPoolService setSentinelMaster(final String sentinelMaster) {
    properties.put(SENTINEL_MASTER_PROPERTY, sentinelMaster);
    return this;
  }

  /**
   * The name of the sentinel master, require when Mode is set to Sentinel
   */
  public final RedisConnectionPoolService removeSentinelMaster() {
    properties.remove(SENTINEL_MASTER_PROPERTY);
    return this;
  }

  /**
   * The password used to authenticate to the Redis server. See the requirepass property in redis.conf.
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * The password used to authenticate to the Redis server. See the requirepass property in redis.conf.
   */
  public final RedisConnectionPoolService setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The password used to authenticate to the Redis server. See the requirepass property in redis.conf.
   */
  public final RedisConnectionPoolService removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The maximum number of connections that can be allocated by the pool (checked out to clients, or idle awaiting checkout). A negative value indicates that there is no limit.
   */
  public final String getPoolMaxTotal() {
    return properties.get(POOL_MAX_TOTAL_PROPERTY);
  }

  /**
   * The maximum number of connections that can be allocated by the pool (checked out to clients, or idle awaiting checkout). A negative value indicates that there is no limit.
   */
  public final RedisConnectionPoolService setPoolMaxTotal(final String poolMaxTotal) {
    properties.put(POOL_MAX_TOTAL_PROPERTY, poolMaxTotal);
    return this;
  }

  /**
   * The maximum number of connections that can be allocated by the pool (checked out to clients, or idle awaiting checkout). A negative value indicates that there is no limit.
   */
  public final RedisConnectionPoolService removePoolMaxTotal() {
    properties.remove(POOL_MAX_TOTAL_PROPERTY);
    return this;
  }

  /**
   * The maximum number of idle connections that can be held in the pool, or a negative value if there is no limit.
   */
  public final String getPoolMaxIdle() {
    return properties.get(POOL_MAX_IDLE_PROPERTY);
  }

  /**
   * The maximum number of idle connections that can be held in the pool, or a negative value if there is no limit.
   */
  public final RedisConnectionPoolService setPoolMaxIdle(final String poolMaxIdle) {
    properties.put(POOL_MAX_IDLE_PROPERTY, poolMaxIdle);
    return this;
  }

  /**
   * The maximum number of idle connections that can be held in the pool, or a negative value if there is no limit.
   */
  public final RedisConnectionPoolService removePoolMaxIdle() {
    properties.remove(POOL_MAX_IDLE_PROPERTY);
    return this;
  }

  /**
   * The target for the minimum number of idle connections to maintain in the pool. If the configured value of Min Idle is greater than the configured value for Max Idle, then the value of Max Idle will be used instead.
   */
  public final String getPoolMinIdle() {
    return properties.get(POOL_MIN_IDLE_PROPERTY);
  }

  /**
   * The target for the minimum number of idle connections to maintain in the pool. If the configured value of Min Idle is greater than the configured value for Max Idle, then the value of Max Idle will be used instead.
   */
  public final RedisConnectionPoolService setPoolMinIdle(final String poolMinIdle) {
    properties.put(POOL_MIN_IDLE_PROPERTY, poolMinIdle);
    return this;
  }

  /**
   * The target for the minimum number of idle connections to maintain in the pool. If the configured value of Min Idle is greater than the configured value for Max Idle, then the value of Max Idle will be used instead.
   */
  public final RedisConnectionPoolService removePoolMinIdle() {
    properties.remove(POOL_MIN_IDLE_PROPERTY);
    return this;
  }

  /**
   * Whether or not clients should block and wait when trying to obtain a connection from the pool when the pool has no available connections. Setting this to false means an error will occur immediately when a client requests a connection and none are available.
   */
  public final String getPoolBlockWhenExhausted() {
    return properties.get(POOL_BLOCK_WHEN_EXHAUSTED_PROPERTY);
  }

  /**
   * Whether or not clients should block and wait when trying to obtain a connection from the pool when the pool has no available connections. Setting this to false means an error will occur immediately when a client requests a connection and none are available.
   */
  public final RedisConnectionPoolService setPoolBlockWhenExhausted(
      final String poolBlockWhenExhausted) {
    properties.put(POOL_BLOCK_WHEN_EXHAUSTED_PROPERTY, poolBlockWhenExhausted);
    return this;
  }

  /**
   * Whether or not clients should block and wait when trying to obtain a connection from the pool when the pool has no available connections. Setting this to false means an error will occur immediately when a client requests a connection and none are available.
   */
  public final RedisConnectionPoolService removePoolBlockWhenExhausted() {
    properties.remove(POOL_BLOCK_WHEN_EXHAUSTED_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for an available connection when Block When Exhausted is set to true.
   */
  public final String getPoolMaxWaitTime() {
    return properties.get(POOL_MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The amount of time to wait for an available connection when Block When Exhausted is set to true.
   */
  public final RedisConnectionPoolService setPoolMaxWaitTime(final String poolMaxWaitTime) {
    properties.put(POOL_MAX_WAIT_TIME_PROPERTY, poolMaxWaitTime);
    return this;
  }

  /**
   * The amount of time to wait for an available connection when Block When Exhausted is set to true.
   */
  public final RedisConnectionPoolService removePoolMaxWaitTime() {
    properties.remove(POOL_MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The minimum amount of time an object may sit idle in the pool before it is eligible for eviction.
   */
  public final String getPoolMinEvictableIdleTime() {
    return properties.get(POOL_MIN_EVICTABLE_IDLE_TIME_PROPERTY);
  }

  /**
   * The minimum amount of time an object may sit idle in the pool before it is eligible for eviction.
   */
  public final RedisConnectionPoolService setPoolMinEvictableIdleTime(
      final String poolMinEvictableIdleTime) {
    properties.put(POOL_MIN_EVICTABLE_IDLE_TIME_PROPERTY, poolMinEvictableIdleTime);
    return this;
  }

  /**
   * The minimum amount of time an object may sit idle in the pool before it is eligible for eviction.
   */
  public final RedisConnectionPoolService removePoolMinEvictableIdleTime() {
    properties.remove(POOL_MIN_EVICTABLE_IDLE_TIME_PROPERTY);
    return this;
  }

  /**
   * The amount of time between attempting to evict idle connections from the pool.
   */
  public final String getPoolTimeBetweenEvictionRuns() {
    return properties.get(POOL_TIME_BETWEEN_EVICTION_RUNS_PROPERTY);
  }

  /**
   * The amount of time between attempting to evict idle connections from the pool.
   */
  public final RedisConnectionPoolService setPoolTimeBetweenEvictionRuns(
      final String poolTimeBetweenEvictionRuns) {
    properties.put(POOL_TIME_BETWEEN_EVICTION_RUNS_PROPERTY, poolTimeBetweenEvictionRuns);
    return this;
  }

  /**
   * The amount of time between attempting to evict idle connections from the pool.
   */
  public final RedisConnectionPoolService removePoolTimeBetweenEvictionRuns() {
    properties.remove(POOL_TIME_BETWEEN_EVICTION_RUNS_PROPERTY);
    return this;
  }

  /**
   * The number of connections to tests per eviction attempt. A negative value indicates to test all connections.
   */
  public final String getPoolNumTestsPerEvictionRun() {
    return properties.get(POOL_NUM_TESTS_PER_EVICTION_RUN_PROPERTY);
  }

  /**
   * The number of connections to tests per eviction attempt. A negative value indicates to test all connections.
   */
  public final RedisConnectionPoolService setPoolNumTestsPerEvictionRun(
      final String poolNumTestsPerEvictionRun) {
    properties.put(POOL_NUM_TESTS_PER_EVICTION_RUN_PROPERTY, poolNumTestsPerEvictionRun);
    return this;
  }

  /**
   * The number of connections to tests per eviction attempt. A negative value indicates to test all connections.
   */
  public final RedisConnectionPoolService removePoolNumTestsPerEvictionRun() {
    properties.remove(POOL_NUM_TESTS_PER_EVICTION_RUN_PROPERTY);
    return this;
  }

  /**
   * Whether or not connections should be tested upon creation.
   */
  public final String getPoolTestOnCreate() {
    return properties.get(POOL_TEST_ON_CREATE_PROPERTY);
  }

  /**
   * Whether or not connections should be tested upon creation.
   */
  public final RedisConnectionPoolService setPoolTestOnCreate(final String poolTestOnCreate) {
    properties.put(POOL_TEST_ON_CREATE_PROPERTY, poolTestOnCreate);
    return this;
  }

  /**
   * Whether or not connections should be tested upon creation.
   */
  public final RedisConnectionPoolService removePoolTestOnCreate() {
    properties.remove(POOL_TEST_ON_CREATE_PROPERTY);
    return this;
  }

  /**
   * Whether or not connections should be tested upon borrowing from the pool.
   */
  public final String getPoolTestOnBorrow() {
    return properties.get(POOL_TEST_ON_BORROW_PROPERTY);
  }

  /**
   * Whether or not connections should be tested upon borrowing from the pool.
   */
  public final RedisConnectionPoolService setPoolTestOnBorrow(final String poolTestOnBorrow) {
    properties.put(POOL_TEST_ON_BORROW_PROPERTY, poolTestOnBorrow);
    return this;
  }

  /**
   * Whether or not connections should be tested upon borrowing from the pool.
   */
  public final RedisConnectionPoolService removePoolTestOnBorrow() {
    properties.remove(POOL_TEST_ON_BORROW_PROPERTY);
    return this;
  }

  /**
   * Whether or not connections should be tested upon returning to the pool.
   */
  public final String getPoolTestOnReturn() {
    return properties.get(POOL_TEST_ON_RETURN_PROPERTY);
  }

  /**
   * Whether or not connections should be tested upon returning to the pool.
   */
  public final RedisConnectionPoolService setPoolTestOnReturn(final String poolTestOnReturn) {
    properties.put(POOL_TEST_ON_RETURN_PROPERTY, poolTestOnReturn);
    return this;
  }

  /**
   * Whether or not connections should be tested upon returning to the pool.
   */
  public final RedisConnectionPoolService removePoolTestOnReturn() {
    properties.remove(POOL_TEST_ON_RETURN_PROPERTY);
    return this;
  }

  /**
   * Whether or not connections should be tested while idle.
   */
  public final String getPoolTestWhileIdle() {
    return properties.get(POOL_TEST_WHILE_IDLE_PROPERTY);
  }

  /**
   * Whether or not connections should be tested while idle.
   */
  public final RedisConnectionPoolService setPoolTestWhileIdle(final String poolTestWhileIdle) {
    properties.put(POOL_TEST_WHILE_IDLE_PROPERTY, poolTestWhileIdle);
    return this;
  }

  /**
   * Whether or not connections should be tested while idle.
   */
  public final RedisConnectionPoolService removePoolTestWhileIdle() {
    properties.remove(POOL_TEST_WHILE_IDLE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RedisConnectionPoolService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final RedisConnectionPoolService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<RedisConnectionPoolService, RedisConnectionPoolService> configurator) {
    return configurator.apply(new RedisConnectionPoolService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RedisConnectionPoolService.class) final Closure<RedisConnectionPoolService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.redis.service.RedisConnectionPoolService> code = closure.rehydrate(c, com.tibtech.nifi.redis.service.RedisConnectionPoolService.class, com.tibtech.nifi.redis.service.RedisConnectionPoolService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<RedisConnectionPoolService, RedisConnectionPoolService> configurator) {
    return configurator.apply(new RedisConnectionPoolService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RedisConnectionPoolService.class) final Closure<RedisConnectionPoolService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.redis.service.RedisConnectionPoolService> code = closure.rehydrate(c, com.tibtech.nifi.redis.service.RedisConnectionPoolService.class, com.tibtech.nifi.redis.service.RedisConnectionPoolService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
