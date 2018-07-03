package com.tibtech.nifi.processors.aws.wag;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class InvokeAWSGatewayApi {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.wag.InvokeAWSGatewayApi";

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS).Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public static final String AWS_GATEWAY_HTTP_METHOD_PROPERTY = "aws-gateway-http-method";

  /**
   *
   */
  public static final String AWS_GATEWAY_REGION_PROPERTY = "aws-gateway-region";

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
   * The Name of the Gateway API Resource
   */
  public static final String AWS_GATEWAY_RESOURCE_PROPERTY = "aws-gateway-resource";

  /**
   * The Api Endpoint
   */
  public static final String AWS_GATEWAY_API_ENDPOINT_PROPERTY = "aws-gateway-api-endpoint";

  /**
   * The API Key
   */
  public static final String AWS_GATEWAY_API_KEY_PROPERTY = "aws-gateway-api-key";

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public static final String AWS_GATEWAY_ATTRIBUTES_TO_SEND_PROPERTY = "aws-gateway-attributes-to-send";

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public static final String AWS_GATEWAY_PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY = "aws-gateway-put-response-body-in-attribute";

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public static final String AWS_GATEWAY_CONTENT_TYPE_PROPERTY = "aws-gateway-content-type";

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public static final String AWS_GATEWAY_SEND_MESSAGE_BODY_PROPERTY = "aws-gateway-send-message-body";

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public static final String AWS_GATEWAY_ALWAYS_OUTPUT_RESPONSE_PROPERTY = "aws-gateway-always-output-response";

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public static final String AWS_GATEWAY_PENALIZE_NO_RETRY_PROPERTY = "aws-gateway-penalize-no-retry";

  /**
   * Proxy host name or IP
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * Proxy host port
   */
  public static final String PROXY_HOST_PORT_PROPERTY = "Proxy Host Port";

  /**
   * Proxy username
   */
  public static final String PROXY_USER_NAME_PROPERTY = "proxy-user-name";

  /**
   * Proxy password
   */
  public static final String PROXY_USER_PASSWORD_PROPERTY = "proxy-user-password";

  /**
   * The query parameters for this request in the form of Name=Value separated by &
   */
  public static final String AWS_GATEWAY_QUERY_PARAMETERS_PROPERTY = "aws-gateway-query-parameters";

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public static final String AWS_GATEWAY_MAX_ATTRIBUTE_LENGTH_PROPERTY = "aws-gateway-max-attribute-length";

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public static final String AWS_GATEWAY_ADD_RESPONSE_HEADERS_REQUEST_PROPERTY = "aws-gateway-add-response-headers-request";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  private final Map<String, String> properties;

  public InvokeAWSGatewayApi() {
    this.properties = new HashMap<>();
  }

  public InvokeAWSGatewayApi(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS).Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public final String getAwsGatewayHttpMethod() {
    return properties.get(AWS_GATEWAY_HTTP_METHOD_PROPERTY);
  }

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS).Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public final InvokeAWSGatewayApi setAwsGatewayHttpMethod(final String awsGatewayHttpMethod) {
    properties.put(AWS_GATEWAY_HTTP_METHOD_PROPERTY, awsGatewayHttpMethod);
    return this;
  }

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS).Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public final InvokeAWSGatewayApi removeAwsGatewayHttpMethod() {
    properties.remove(AWS_GATEWAY_HTTP_METHOD_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getAwsGatewayRegion() {
    return properties.get(AWS_GATEWAY_REGION_PROPERTY);
  }

  /**
   *
   */
  public final InvokeAWSGatewayApi setAwsGatewayRegion(final String awsGatewayRegion) {
    properties.put(AWS_GATEWAY_REGION_PROPERTY, awsGatewayRegion);
    return this;
  }

  /**
   *
   */
  public final InvokeAWSGatewayApi removeAwsGatewayRegion() {
    properties.remove(AWS_GATEWAY_REGION_PROPERTY);
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
  public final InvokeAWSGatewayApi setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final InvokeAWSGatewayApi removeAccessKey() {
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
  public final InvokeAWSGatewayApi setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final InvokeAWSGatewayApi removeSecretKey() {
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
  public final InvokeAWSGatewayApi setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final InvokeAWSGatewayApi removeCredentialsFile() {
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
  public final InvokeAWSGatewayApi setAwsCredentialsProviderService(
      final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final InvokeAWSGatewayApi removeAwsCredentialsProviderService() {
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
  public final InvokeAWSGatewayApi setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final InvokeAWSGatewayApi removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Name of the Gateway API Resource
   */
  public final String getAwsGatewayResource() {
    return properties.get(AWS_GATEWAY_RESOURCE_PROPERTY);
  }

  /**
   * The Name of the Gateway API Resource
   */
  public final InvokeAWSGatewayApi setAwsGatewayResource(final String awsGatewayResource) {
    properties.put(AWS_GATEWAY_RESOURCE_PROPERTY, awsGatewayResource);
    return this;
  }

  /**
   * The Name of the Gateway API Resource
   */
  public final InvokeAWSGatewayApi removeAwsGatewayResource() {
    properties.remove(AWS_GATEWAY_RESOURCE_PROPERTY);
    return this;
  }

  /**
   * The Api Endpoint
   */
  public final String getAwsGatewayApiEndpoint() {
    return properties.get(AWS_GATEWAY_API_ENDPOINT_PROPERTY);
  }

  /**
   * The Api Endpoint
   */
  public final InvokeAWSGatewayApi setAwsGatewayApiEndpoint(final String awsGatewayApiEndpoint) {
    properties.put(AWS_GATEWAY_API_ENDPOINT_PROPERTY, awsGatewayApiEndpoint);
    return this;
  }

  /**
   * The Api Endpoint
   */
  public final InvokeAWSGatewayApi removeAwsGatewayApiEndpoint() {
    properties.remove(AWS_GATEWAY_API_ENDPOINT_PROPERTY);
    return this;
  }

  /**
   * The API Key
   */
  public final String getAwsGatewayApiKey() {
    return properties.get(AWS_GATEWAY_API_KEY_PROPERTY);
  }

  /**
   * The API Key
   */
  public final InvokeAWSGatewayApi setAwsGatewayApiKey(final String awsGatewayApiKey) {
    properties.put(AWS_GATEWAY_API_KEY_PROPERTY, awsGatewayApiKey);
    return this;
  }

  /**
   * The API Key
   */
  public final InvokeAWSGatewayApi removeAwsGatewayApiKey() {
    properties.remove(AWS_GATEWAY_API_KEY_PROPERTY);
    return this;
  }

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public final String getAwsGatewayAttributesToSend() {
    return properties.get(AWS_GATEWAY_ATTRIBUTES_TO_SEND_PROPERTY);
  }

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public final InvokeAWSGatewayApi setAwsGatewayAttributesToSend(
      final String awsGatewayAttributesToSend) {
    properties.put(AWS_GATEWAY_ATTRIBUTES_TO_SEND_PROPERTY, awsGatewayAttributesToSend);
    return this;
  }

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public final InvokeAWSGatewayApi removeAwsGatewayAttributesToSend() {
    properties.remove(AWS_GATEWAY_ATTRIBUTES_TO_SEND_PROPERTY);
    return this;
  }

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public final String getAwsGatewayPutResponseBodyInAttribute() {
    return properties.get(AWS_GATEWAY_PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public final InvokeAWSGatewayApi setAwsGatewayPutResponseBodyInAttribute(
      final String awsGatewayPutResponseBodyInAttribute) {
    properties.put(AWS_GATEWAY_PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY, awsGatewayPutResponseBodyInAttribute);
    return this;
  }

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public final InvokeAWSGatewayApi removeAwsGatewayPutResponseBodyInAttribute() {
    properties.remove(AWS_GATEWAY_PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final String getAwsGatewayContentType() {
    return properties.get(AWS_GATEWAY_CONTENT_TYPE_PROPERTY);
  }

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final InvokeAWSGatewayApi setAwsGatewayContentType(final String awsGatewayContentType) {
    properties.put(AWS_GATEWAY_CONTENT_TYPE_PROPERTY, awsGatewayContentType);
    return this;
  }

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final InvokeAWSGatewayApi removeAwsGatewayContentType() {
    properties.remove(AWS_GATEWAY_CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public final String getAwsGatewaySendMessageBody() {
    return properties.get(AWS_GATEWAY_SEND_MESSAGE_BODY_PROPERTY);
  }

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public final InvokeAWSGatewayApi setAwsGatewaySendMessageBody(
      final String awsGatewaySendMessageBody) {
    properties.put(AWS_GATEWAY_SEND_MESSAGE_BODY_PROPERTY, awsGatewaySendMessageBody);
    return this;
  }

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public final InvokeAWSGatewayApi removeAwsGatewaySendMessageBody() {
    properties.remove(AWS_GATEWAY_SEND_MESSAGE_BODY_PROPERTY);
    return this;
  }

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public final String getAwsGatewayAlwaysOutputResponse() {
    return properties.get(AWS_GATEWAY_ALWAYS_OUTPUT_RESPONSE_PROPERTY);
  }

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public final InvokeAWSGatewayApi setAwsGatewayAlwaysOutputResponse(
      final String awsGatewayAlwaysOutputResponse) {
    properties.put(AWS_GATEWAY_ALWAYS_OUTPUT_RESPONSE_PROPERTY, awsGatewayAlwaysOutputResponse);
    return this;
  }

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public final InvokeAWSGatewayApi removeAwsGatewayAlwaysOutputResponse() {
    properties.remove(AWS_GATEWAY_ALWAYS_OUTPUT_RESPONSE_PROPERTY);
    return this;
  }

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public final String getAwsGatewayPenalizeNoRetry() {
    return properties.get(AWS_GATEWAY_PENALIZE_NO_RETRY_PROPERTY);
  }

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public final InvokeAWSGatewayApi setAwsGatewayPenalizeNoRetry(
      final String awsGatewayPenalizeNoRetry) {
    properties.put(AWS_GATEWAY_PENALIZE_NO_RETRY_PROPERTY, awsGatewayPenalizeNoRetry);
    return this;
  }

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public final InvokeAWSGatewayApi removeAwsGatewayPenalizeNoRetry() {
    properties.remove(AWS_GATEWAY_PENALIZE_NO_RETRY_PROPERTY);
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
  public final InvokeAWSGatewayApi setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final InvokeAWSGatewayApi removeProxyHost() {
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
  public final InvokeAWSGatewayApi setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final InvokeAWSGatewayApi removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  /**
   * Proxy username
   */
  public final String getProxyUserName() {
    return properties.get(PROXY_USER_NAME_PROPERTY);
  }

  /**
   * Proxy username
   */
  public final InvokeAWSGatewayApi setProxyUserName(final String proxyUserName) {
    properties.put(PROXY_USER_NAME_PROPERTY, proxyUserName);
    return this;
  }

  /**
   * Proxy username
   */
  public final InvokeAWSGatewayApi removeProxyUserName() {
    properties.remove(PROXY_USER_NAME_PROPERTY);
    return this;
  }

  /**
   * Proxy password
   */
  public final String getProxyUserPassword() {
    return properties.get(PROXY_USER_PASSWORD_PROPERTY);
  }

  /**
   * Proxy password
   */
  public final InvokeAWSGatewayApi setProxyUserPassword(final String proxyUserPassword) {
    properties.put(PROXY_USER_PASSWORD_PROPERTY, proxyUserPassword);
    return this;
  }

  /**
   * Proxy password
   */
  public final InvokeAWSGatewayApi removeProxyUserPassword() {
    properties.remove(PROXY_USER_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The query parameters for this request in the form of Name=Value separated by &
   */
  public final String getAwsGatewayQueryParameters() {
    return properties.get(AWS_GATEWAY_QUERY_PARAMETERS_PROPERTY);
  }

  /**
   * The query parameters for this request in the form of Name=Value separated by &
   */
  public final InvokeAWSGatewayApi setAwsGatewayQueryParameters(
      final String awsGatewayQueryParameters) {
    properties.put(AWS_GATEWAY_QUERY_PARAMETERS_PROPERTY, awsGatewayQueryParameters);
    return this;
  }

  /**
   * The query parameters for this request in the form of Name=Value separated by &
   */
  public final InvokeAWSGatewayApi removeAwsGatewayQueryParameters() {
    properties.remove(AWS_GATEWAY_QUERY_PARAMETERS_PROPERTY);
    return this;
  }

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final String getAwsGatewayMaxAttributeLength() {
    return properties.get(AWS_GATEWAY_MAX_ATTRIBUTE_LENGTH_PROPERTY);
  }

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final InvokeAWSGatewayApi setAwsGatewayMaxAttributeLength(
      final String awsGatewayMaxAttributeLength) {
    properties.put(AWS_GATEWAY_MAX_ATTRIBUTE_LENGTH_PROPERTY, awsGatewayMaxAttributeLength);
    return this;
  }

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final InvokeAWSGatewayApi removeAwsGatewayMaxAttributeLength() {
    properties.remove(AWS_GATEWAY_MAX_ATTRIBUTE_LENGTH_PROPERTY);
    return this;
  }

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public final String getAwsGatewayAddResponseHeadersRequest() {
    return properties.get(AWS_GATEWAY_ADD_RESPONSE_HEADERS_REQUEST_PROPERTY);
  }

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public final InvokeAWSGatewayApi setAwsGatewayAddResponseHeadersRequest(
      final String awsGatewayAddResponseHeadersRequest) {
    properties.put(AWS_GATEWAY_ADD_RESPONSE_HEADERS_REQUEST_PROPERTY, awsGatewayAddResponseHeadersRequest);
    return this;
  }

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public final InvokeAWSGatewayApi removeAwsGatewayAddResponseHeadersRequest() {
    properties.remove(AWS_GATEWAY_ADD_RESPONSE_HEADERS_REQUEST_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final InvokeAWSGatewayApi setProxyConfigurationService(
      final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final InvokeAWSGatewayApi removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final InvokeAWSGatewayApi setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final InvokeAWSGatewayApi removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<InvokeAWSGatewayApi, InvokeAWSGatewayApi> configurator) {
    return configurator.apply(new InvokeAWSGatewayApi()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InvokeAWSGatewayApi.class) final Closure<InvokeAWSGatewayApi> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.wag.InvokeAWSGatewayApi> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.wag.InvokeAWSGatewayApi.class, com.tibtech.nifi.processors.aws.wag.InvokeAWSGatewayApi.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<InvokeAWSGatewayApi, InvokeAWSGatewayApi> configurator) {
    return configurator.apply(new InvokeAWSGatewayApi(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InvokeAWSGatewayApi.class) final Closure<InvokeAWSGatewayApi> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.wag.InvokeAWSGatewayApi> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.wag.InvokeAWSGatewayApi.class, com.tibtech.nifi.processors.aws.wag.InvokeAWSGatewayApi.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
