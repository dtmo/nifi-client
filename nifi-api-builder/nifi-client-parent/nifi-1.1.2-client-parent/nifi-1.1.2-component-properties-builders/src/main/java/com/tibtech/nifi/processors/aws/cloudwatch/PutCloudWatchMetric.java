package com.tibtech.nifi.processors.aws.cloudwatch;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutCloudWatchMetric {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.cloudwatch.PutCloudWatchMetric";

  /**
   * The namespace for the metric data for CloudWatch
   */
  public static final String NAMESPACE_PROPERTY = "Namespace";

  /**
   * The name of the metric
   */
  public static final String METRIC_NAME_PROPERTY = "MetricName";

  /**
   * The value for the metric. Must be a double
   */
  public static final String VALUE_PROPERTY = "Value";

  /**
   * A point in time expressed as the number of milliseconds since Jan 1, 1970 00:00:00 UTC. If not specified, the default value is set to the time the metric data was received
   */
  public static final String TIMESTAMP_PROPERTY = "Timestamp";

  /**
   * The unit of the metric. (e.g Seconds, Bytes, Megabytes, Percent, Count,  Kilobytes/Second, Terabits/Second, Count/Second) For details see http://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
   */
  public static final String UNIT_PROPERTY = "Unit";

  /**
   *
   */
  public static final String REGION_PROPERTY = "Region";

  /**
   *
   */
  public static final String ACCESS_KEY_PROPERTY = "Access Key";

  /**
   *
   */
  public static final String SECRET_KEY_PROPERTY = "Secret Key";

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public static final String CREDENTIALS_FILE_PROPERTY = "Credentials File";

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public static final String AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY = "AWS Credentials Provider service";

  /**
   *
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public static final String ENDPOINT_OVERRIDE_URL_PROPERTY = "Endpoint Override URL";

  /**
   * Proxy host name or IP
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * Proxy host port
   */
  public static final String PROXY_HOST_PORT_PROPERTY = "Proxy Host Port";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The namespace for the metric data for CloudWatch
   */
  public final String getNamespace() {
    return properties.get(NAMESPACE_PROPERTY);
  }

  /**
   * The namespace for the metric data for CloudWatch
   */
  public final PutCloudWatchMetric setNamespace(final String namespace) {
    properties.put(NAMESPACE_PROPERTY, namespace);
    return this;
  }

  /**
   * The namespace for the metric data for CloudWatch
   */
  public final PutCloudWatchMetric removeNamespace() {
    properties.remove(NAMESPACE_PROPERTY);
    return this;
  }

  /**
   * The name of the metric
   */
  public final String getMetricName() {
    return properties.get(METRIC_NAME_PROPERTY);
  }

  /**
   * The name of the metric
   */
  public final PutCloudWatchMetric setMetricName(final String metricName) {
    properties.put(METRIC_NAME_PROPERTY, metricName);
    return this;
  }

  /**
   * The name of the metric
   */
  public final PutCloudWatchMetric removeMetricName() {
    properties.remove(METRIC_NAME_PROPERTY);
    return this;
  }

  /**
   * The value for the metric. Must be a double
   */
  public final String getValue() {
    return properties.get(VALUE_PROPERTY);
  }

  /**
   * The value for the metric. Must be a double
   */
  public final PutCloudWatchMetric setValue(final String value) {
    properties.put(VALUE_PROPERTY, value);
    return this;
  }

  /**
   * The value for the metric. Must be a double
   */
  public final PutCloudWatchMetric removeValue() {
    properties.remove(VALUE_PROPERTY);
    return this;
  }

  /**
   * A point in time expressed as the number of milliseconds since Jan 1, 1970 00:00:00 UTC. If not specified, the default value is set to the time the metric data was received
   */
  public final String getTimestamp() {
    return properties.get(TIMESTAMP_PROPERTY);
  }

  /**
   * A point in time expressed as the number of milliseconds since Jan 1, 1970 00:00:00 UTC. If not specified, the default value is set to the time the metric data was received
   */
  public final PutCloudWatchMetric setTimestamp(final String timestamp) {
    properties.put(TIMESTAMP_PROPERTY, timestamp);
    return this;
  }

  /**
   * A point in time expressed as the number of milliseconds since Jan 1, 1970 00:00:00 UTC. If not specified, the default value is set to the time the metric data was received
   */
  public final PutCloudWatchMetric removeTimestamp() {
    properties.remove(TIMESTAMP_PROPERTY);
    return this;
  }

  /**
   * The unit of the metric. (e.g Seconds, Bytes, Megabytes, Percent, Count,  Kilobytes/Second, Terabits/Second, Count/Second) For details see http://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
   */
  public final String getUnit() {
    return properties.get(UNIT_PROPERTY);
  }

  /**
   * The unit of the metric. (e.g Seconds, Bytes, Megabytes, Percent, Count,  Kilobytes/Second, Terabits/Second, Count/Second) For details see http://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
   */
  public final PutCloudWatchMetric setUnit(final String unit) {
    properties.put(UNIT_PROPERTY, unit);
    return this;
  }

  /**
   * The unit of the metric. (e.g Seconds, Bytes, Megabytes, Percent, Count,  Kilobytes/Second, Terabits/Second, Count/Second) For details see http://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_MetricDatum.html
   */
  public final PutCloudWatchMetric removeUnit() {
    properties.remove(UNIT_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getRegion() {
    return properties.get(REGION_PROPERTY);
  }

  /**
   *
   */
  public final PutCloudWatchMetric setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final PutCloudWatchMetric removeRegion() {
    properties.remove(REGION_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getAccessKey() {
    return properties.get(ACCESS_KEY_PROPERTY);
  }

  /**
   *
   */
  public final PutCloudWatchMetric setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final PutCloudWatchMetric removeAccessKey() {
    properties.remove(ACCESS_KEY_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getSecretKey() {
    return properties.get(SECRET_KEY_PROPERTY);
  }

  /**
   *
   */
  public final PutCloudWatchMetric setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final PutCloudWatchMetric removeSecretKey() {
    properties.remove(SECRET_KEY_PROPERTY);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final String getCredentialsFile() {
    return properties.get(CREDENTIALS_FILE_PROPERTY);
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutCloudWatchMetric setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutCloudWatchMetric removeCredentialsFile() {
    properties.remove(CREDENTIALS_FILE_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final String getAwsCredentialsProviderService() {
    return properties.get(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutCloudWatchMetric setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutCloudWatchMetric removeAwsCredentialsProviderService() {
    properties.remove(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getCommunicationsTimeout() {
    return properties.get(COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   *
   */
  public final PutCloudWatchMetric setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final PutCloudWatchMetric removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final PutCloudWatchMetric setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final PutCloudWatchMetric removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final String getEndpointOverrideUrl() {
    return properties.get(ENDPOINT_OVERRIDE_URL_PROPERTY);
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final PutCloudWatchMetric setEndpointOverrideUrl(final String endpointOverrideUrl) {
    properties.put(ENDPOINT_OVERRIDE_URL_PROPERTY, endpointOverrideUrl);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final PutCloudWatchMetric removeEndpointOverrideUrl() {
    properties.remove(ENDPOINT_OVERRIDE_URL_PROPERTY);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final String getProxyHost() {
    return properties.get(PROXY_HOST_PROPERTY);
  }

  /**
   * Proxy host name or IP
   */
  public final PutCloudWatchMetric setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final PutCloudWatchMetric removeProxyHost() {
    properties.remove(PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * Proxy host port
   */
  public final String getProxyHostPort() {
    return properties.get(PROXY_HOST_PORT_PROPERTY);
  }

  /**
   * Proxy host port
   */
  public final PutCloudWatchMetric setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final PutCloudWatchMetric removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutCloudWatchMetric setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutCloudWatchMetric removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutCloudWatchMetric, PutCloudWatchMetric> configurator) {
    return configurator.apply(new PutCloudWatchMetric()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutCloudWatchMetric.class) final Closure<PutCloudWatchMetric> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.cloudwatch.PutCloudWatchMetric> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.cloudwatch.PutCloudWatchMetric.class, com.tibtech.nifi.processors.aws.cloudwatch.PutCloudWatchMetric.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
