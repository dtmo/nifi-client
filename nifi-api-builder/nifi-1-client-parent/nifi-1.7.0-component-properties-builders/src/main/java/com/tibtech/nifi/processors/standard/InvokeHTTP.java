package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class InvokeHTTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.InvokeHTTP";

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS). Arbitrary methods are also supported. Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public static final String HTTP_METHOD_PROPERTY = "HTTP Method";

  /**
   * Remote URL which will be connected to, including scheme, host, port, path.
   */
  public static final String REMOTE_URL_PROPERTY = "Remote URL";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections. It is also used to connect to HTTPS Proxy.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Max wait time for connection to remote service.
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * Max wait time for response from remote service.
   */
  public static final String READ_TIMEOUT_PROPERTY = "Read Timeout";

  /**
   * Include an RFC-2616 Date header in the request.
   */
  public static final String INCLUDE_DATE_HEADER_PROPERTY = "Include Date Header";

  /**
   * Follow HTTP redirects issued by remote server.
   */
  public static final String FOLLOW_REDIRECTS_PROPERTY = "Follow Redirects";

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public static final String ATTRIBUTES_TO_SEND_PROPERTY = "Attributes to Send";

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public static final String BASIC_AUTHENTICATION_USERNAME_PROPERTY = "Basic Authentication Username";

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public static final String BASIC_AUTHENTICATION_PASSWORD_PROPERTY = "Basic Authentication Password";

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * The port of the proxy server
   */
  public static final String PROXY_PORT_PROPERTY = "Proxy Port";

  /**
   * The type of the proxy we are connecting to. Must be either http or https
   */
  public static final String PROXY_TYPE_PROPERTY = "Proxy Type";

  /**
   * Username to set when authenticating against proxy
   */
  public static final String INVOKEHTTP_PROXY_USER_PROPERTY = "invokehttp-proxy-user";

  /**
   * Password to set when authenticating against proxy
   */
  public static final String INVOKEHTTP_PROXY_PASSWORD_PROPERTY = "invokehttp-proxy-password";

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public static final String PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY = "Put Response Body In Attribute";

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public static final String MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY = "Max Length To Put In Attribute";

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public static final String DIGEST_AUTHENTICATION_PROPERTY = "Digest Authentication";

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public static final String ALWAYS_OUTPUT_RESPONSE_PROPERTY = "Always Output Response";

  /**
   * Bypass the normal truststore hostname verifier to allow the specified remote hostname as trusted. Enabling this property has MITM security implications, use wisely. Will still accept other connections based on the normal truststore hostname verifier. Only valid with SSL (HTTPS) connections.
   */
  public static final String TRUSTED_HOSTNAME_PROPERTY = "Trusted Hostname";

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public static final String ADD_RESPONSE_HEADERS_TO_REQUEST_PROPERTY = "Add Response Headers to Request";

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public static final String CONTENT_TYPE_PROPERTY = "Content-Type";

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public static final String SEND_MESSAGE_BODY_PROPERTY = "send-message-body";

  /**
   * When POST'ing, PUT'ing or PATCH'ing content set this property to true in order to not pass the 'Content-length' header and instead send 'Transfer-Encoding' with a value of 'chunked'. This will enable the data transfer mechanism which was introduced in HTTP 1.1 to pass data of unknown lengths in chunks.
   */
  public static final String USE_CHUNKED_ENCODING_PROPERTY = "Use Chunked Encoding";

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public static final String PENALIZE_ON_NO_RETRY_PROPERTY = "Penalize on \"No Retry\"";

  /**
   * Enable HTTP entity tag (ETag) support for HTTP requests.
   */
  public static final String USE_ETAG_PROPERTY = "use-etag";

  /**
   * The maximum size that the ETag cache should be allowed to grow to. The default size is 10MB.
   */
  public static final String ETAG_MAX_CACHE_SIZE_PROPERTY = "etag-max-cache-size";

  private final Map<String, String> properties;

  public InvokeHTTP() {
    this.properties = new HashMap<>();
  }

  public InvokeHTTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS). Arbitrary methods are also supported. Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public final String getHttpMethod() {
    return properties.get(HTTP_METHOD_PROPERTY);
  }

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS). Arbitrary methods are also supported. Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public final InvokeHTTP setHttpMethod(final String httpMethod) {
    properties.put(HTTP_METHOD_PROPERTY, httpMethod);
    return this;
  }

  /**
   * HTTP request method (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS). Arbitrary methods are also supported. Methods other than POST, PUT and PATCH will be sent without a message body.
   */
  public final InvokeHTTP removeHttpMethod() {
    properties.remove(HTTP_METHOD_PROPERTY);
    return this;
  }

  /**
   * Remote URL which will be connected to, including scheme, host, port, path.
   */
  public final String getRemoteUrl() {
    return properties.get(REMOTE_URL_PROPERTY);
  }

  /**
   * Remote URL which will be connected to, including scheme, host, port, path.
   */
  public final InvokeHTTP setRemoteUrl(final String remoteUrl) {
    properties.put(REMOTE_URL_PROPERTY, remoteUrl);
    return this;
  }

  /**
   * Remote URL which will be connected to, including scheme, host, port, path.
   */
  public final InvokeHTTP removeRemoteUrl() {
    properties.remove(REMOTE_URL_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections. It is also used to connect to HTTPS Proxy.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections. It is also used to connect to HTTPS Proxy.
   */
  public final InvokeHTTP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL (https) connections. It is also used to connect to HTTPS Proxy.
   */
  public final InvokeHTTP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Max wait time for connection to remote service.
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * Max wait time for connection to remote service.
   */
  public final InvokeHTTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * Max wait time for connection to remote service.
   */
  public final InvokeHTTP removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Max wait time for response from remote service.
   */
  public final String getReadTimeout() {
    return properties.get(READ_TIMEOUT_PROPERTY);
  }

  /**
   * Max wait time for response from remote service.
   */
  public final InvokeHTTP setReadTimeout(final String readTimeout) {
    properties.put(READ_TIMEOUT_PROPERTY, readTimeout);
    return this;
  }

  /**
   * Max wait time for response from remote service.
   */
  public final InvokeHTTP removeReadTimeout() {
    properties.remove(READ_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Include an RFC-2616 Date header in the request.
   */
  public final String getIncludeDateHeader() {
    return properties.get(INCLUDE_DATE_HEADER_PROPERTY);
  }

  /**
   * Include an RFC-2616 Date header in the request.
   */
  public final InvokeHTTP setIncludeDateHeader(final String includeDateHeader) {
    properties.put(INCLUDE_DATE_HEADER_PROPERTY, includeDateHeader);
    return this;
  }

  /**
   * Include an RFC-2616 Date header in the request.
   */
  public final InvokeHTTP removeIncludeDateHeader() {
    properties.remove(INCLUDE_DATE_HEADER_PROPERTY);
    return this;
  }

  /**
   * Follow HTTP redirects issued by remote server.
   */
  public final String getFollowRedirects() {
    return properties.get(FOLLOW_REDIRECTS_PROPERTY);
  }

  /**
   * Follow HTTP redirects issued by remote server.
   */
  public final InvokeHTTP setFollowRedirects(final String followRedirects) {
    properties.put(FOLLOW_REDIRECTS_PROPERTY, followRedirects);
    return this;
  }

  /**
   * Follow HTTP redirects issued by remote server.
   */
  public final InvokeHTTP removeFollowRedirects() {
    properties.remove(FOLLOW_REDIRECTS_PROPERTY);
    return this;
  }

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public final String getAttributesToSend() {
    return properties.get(ATTRIBUTES_TO_SEND_PROPERTY);
  }

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public final InvokeHTTP setAttributesToSend(final String attributesToSend) {
    properties.put(ATTRIBUTES_TO_SEND_PROPERTY, attributesToSend);
    return this;
  }

  /**
   * Regular expression that defines which attributes to send as HTTP headers in the request. If not defined, no attributes are sent as headers. Also any dynamic properties set will be sent as headers. The dynamic property key will be the header key and the dynamic property value will be interpreted as expression language will be the header value.
   */
  public final InvokeHTTP removeAttributesToSend() {
    properties.remove(ATTRIBUTES_TO_SEND_PROPERTY);
    return this;
  }

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public final String getBasicAuthenticationUsername() {
    return properties.get(BASIC_AUTHENTICATION_USERNAME_PROPERTY);
  }

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public final InvokeHTTP setBasicAuthenticationUsername(final String basicAuthenticationUsername) {
    properties.put(BASIC_AUTHENTICATION_USERNAME_PROPERTY, basicAuthenticationUsername);
    return this;
  }

  /**
   * The username to be used by the client to authenticate against the Remote URL.  Cannot include control characters (0-31), ':', or DEL (127).
   */
  public final InvokeHTTP removeBasicAuthenticationUsername() {
    properties.remove(BASIC_AUTHENTICATION_USERNAME_PROPERTY);
    return this;
  }

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public final String getBasicAuthenticationPassword() {
    return properties.get(BASIC_AUTHENTICATION_PASSWORD_PROPERTY);
  }

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public final InvokeHTTP setBasicAuthenticationPassword(final String basicAuthenticationPassword) {
    properties.put(BASIC_AUTHENTICATION_PASSWORD_PROPERTY, basicAuthenticationPassword);
    return this;
  }

  /**
   * The password to be used by the client to authenticate against the Remote URL.
   */
  public final InvokeHTTP removeBasicAuthenticationPassword() {
    properties.remove(BASIC_AUTHENTICATION_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final InvokeHTTP setProxyConfigurationService(final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN, SOCKS
   */
  public final InvokeHTTP removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final String getProxyHost() {
    return properties.get(PROXY_HOST_PROPERTY);
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final InvokeHTTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final InvokeHTTP removeProxyHost() {
    properties.remove(PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final String getProxyPort() {
    return properties.get(PROXY_PORT_PROPERTY);
  }

  /**
   * The port of the proxy server
   */
  public final InvokeHTTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final InvokeHTTP removeProxyPort() {
    properties.remove(PROXY_PORT_PROPERTY);
    return this;
  }

  /**
   * The type of the proxy we are connecting to. Must be either http or https
   */
  public final String getProxyType() {
    return properties.get(PROXY_TYPE_PROPERTY);
  }

  /**
   * The type of the proxy we are connecting to. Must be either http or https
   */
  public final InvokeHTTP setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * The type of the proxy we are connecting to. Must be either http or https
   */
  public final InvokeHTTP removeProxyType() {
    properties.remove(PROXY_TYPE_PROPERTY);
    return this;
  }

  /**
   * Username to set when authenticating against proxy
   */
  public final String getInvokehttpProxyUser() {
    return properties.get(INVOKEHTTP_PROXY_USER_PROPERTY);
  }

  /**
   * Username to set when authenticating against proxy
   */
  public final InvokeHTTP setInvokehttpProxyUser(final String invokehttpProxyUser) {
    properties.put(INVOKEHTTP_PROXY_USER_PROPERTY, invokehttpProxyUser);
    return this;
  }

  /**
   * Username to set when authenticating against proxy
   */
  public final InvokeHTTP removeInvokehttpProxyUser() {
    properties.remove(INVOKEHTTP_PROXY_USER_PROPERTY);
    return this;
  }

  /**
   * Password to set when authenticating against proxy
   */
  public final String getInvokehttpProxyPassword() {
    return properties.get(INVOKEHTTP_PROXY_PASSWORD_PROPERTY);
  }

  /**
   * Password to set when authenticating against proxy
   */
  public final InvokeHTTP setInvokehttpProxyPassword(final String invokehttpProxyPassword) {
    properties.put(INVOKEHTTP_PROXY_PASSWORD_PROPERTY, invokehttpProxyPassword);
    return this;
  }

  /**
   * Password to set when authenticating against proxy
   */
  public final InvokeHTTP removeInvokehttpProxyPassword() {
    properties.remove(INVOKEHTTP_PROXY_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public final String getPutResponseBodyInAttribute() {
    return properties.get(PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public final InvokeHTTP setPutResponseBodyInAttribute(final String putResponseBodyInAttribute) {
    properties.put(PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY, putResponseBodyInAttribute);
    return this;
  }

  /**
   * If set, the response body received back will be put into an attribute of the original FlowFile instead of a separate FlowFile. The attribute key to put to is determined by evaluating value of this property. 
   */
  public final InvokeHTTP removePutResponseBodyInAttribute() {
    properties.remove(PUT_RESPONSE_BODY_IN_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final String getMaxLengthToPutInAttribute() {
    return properties.get(MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY);
  }

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final InvokeHTTP setMaxLengthToPutInAttribute(final String maxLengthToPutInAttribute) {
    properties.put(MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY, maxLengthToPutInAttribute);
    return this;
  }

  /**
   * If routing the response body to an attribute of the original (by setting the "Put response body in attribute" property or by receiving an error status code), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final InvokeHTTP removeMaxLengthToPutInAttribute() {
    properties.remove(MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public final String getDigestAuthentication() {
    return properties.get(DIGEST_AUTHENTICATION_PROPERTY);
  }

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public final InvokeHTTP setDigestAuthentication(final String digestAuthentication) {
    properties.put(DIGEST_AUTHENTICATION_PROPERTY, digestAuthentication);
    return this;
  }

  /**
   * Whether to communicate with the website using Digest Authentication. 'Basic Authentication Username' and 'Basic Authentication Password' are used for authentication.
   */
  public final InvokeHTTP removeDigestAuthentication() {
    properties.remove(DIGEST_AUTHENTICATION_PROPERTY);
    return this;
  }

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public final String getAlwaysOutputResponse() {
    return properties.get(ALWAYS_OUTPUT_RESPONSE_PROPERTY);
  }

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public final InvokeHTTP setAlwaysOutputResponse(final String alwaysOutputResponse) {
    properties.put(ALWAYS_OUTPUT_RESPONSE_PROPERTY, alwaysOutputResponse);
    return this;
  }

  /**
   * Will force a response FlowFile to be generated and routed to the 'Response' relationship regardless of what the server status code received is or if the processor is configured to put the server response body in the request attribute. In the later configuration a request FlowFile with the response body in the attribute and a typical response FlowFile will be emitted to their respective relationships.
   */
  public final InvokeHTTP removeAlwaysOutputResponse() {
    properties.remove(ALWAYS_OUTPUT_RESPONSE_PROPERTY);
    return this;
  }

  /**
   * Bypass the normal truststore hostname verifier to allow the specified remote hostname as trusted. Enabling this property has MITM security implications, use wisely. Will still accept other connections based on the normal truststore hostname verifier. Only valid with SSL (HTTPS) connections.
   */
  public final String getTrustedHostname() {
    return properties.get(TRUSTED_HOSTNAME_PROPERTY);
  }

  /**
   * Bypass the normal truststore hostname verifier to allow the specified remote hostname as trusted. Enabling this property has MITM security implications, use wisely. Will still accept other connections based on the normal truststore hostname verifier. Only valid with SSL (HTTPS) connections.
   */
  public final InvokeHTTP setTrustedHostname(final String trustedHostname) {
    properties.put(TRUSTED_HOSTNAME_PROPERTY, trustedHostname);
    return this;
  }

  /**
   * Bypass the normal truststore hostname verifier to allow the specified remote hostname as trusted. Enabling this property has MITM security implications, use wisely. Will still accept other connections based on the normal truststore hostname verifier. Only valid with SSL (HTTPS) connections.
   */
  public final InvokeHTTP removeTrustedHostname() {
    properties.remove(TRUSTED_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public final String getAddResponseHeadersToRequest() {
    return properties.get(ADD_RESPONSE_HEADERS_TO_REQUEST_PROPERTY);
  }

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public final InvokeHTTP setAddResponseHeadersToRequest(final String addResponseHeadersToRequest) {
    properties.put(ADD_RESPONSE_HEADERS_TO_REQUEST_PROPERTY, addResponseHeadersToRequest);
    return this;
  }

  /**
   * Enabling this property saves all the response headers to the original request. This may be when the response headers are needed but a response is not generated due to the status code received.
   */
  public final InvokeHTTP removeAddResponseHeadersToRequest() {
    properties.remove(ADD_RESPONSE_HEADERS_TO_REQUEST_PROPERTY);
    return this;
  }

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final String getContentType() {
    return properties.get(CONTENT_TYPE_PROPERTY);
  }

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final InvokeHTTP setContentType(final String contentType) {
    properties.put(CONTENT_TYPE_PROPERTY, contentType);
    return this;
  }

  /**
   * The Content-Type to specify for when content is being transmitted through a PUT, POST or PATCH. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final InvokeHTTP removeContentType() {
    properties.remove(CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public final String getSendMessageBody() {
    return properties.get(SEND_MESSAGE_BODY_PROPERTY);
  }

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public final InvokeHTTP setSendMessageBody(final String sendMessageBody) {
    properties.put(SEND_MESSAGE_BODY_PROPERTY, sendMessageBody);
    return this;
  }

  /**
   * If true, sends the HTTP message body on POST/PUT/PATCH requests (default).  If false, suppresses the message body and content-type header for these requests.
   */
  public final InvokeHTTP removeSendMessageBody() {
    properties.remove(SEND_MESSAGE_BODY_PROPERTY);
    return this;
  }

  /**
   * When POST'ing, PUT'ing or PATCH'ing content set this property to true in order to not pass the 'Content-length' header and instead send 'Transfer-Encoding' with a value of 'chunked'. This will enable the data transfer mechanism which was introduced in HTTP 1.1 to pass data of unknown lengths in chunks.
   */
  public final String getUseChunkedEncoding() {
    return properties.get(USE_CHUNKED_ENCODING_PROPERTY);
  }

  /**
   * When POST'ing, PUT'ing or PATCH'ing content set this property to true in order to not pass the 'Content-length' header and instead send 'Transfer-Encoding' with a value of 'chunked'. This will enable the data transfer mechanism which was introduced in HTTP 1.1 to pass data of unknown lengths in chunks.
   */
  public final InvokeHTTP setUseChunkedEncoding(final String useChunkedEncoding) {
    properties.put(USE_CHUNKED_ENCODING_PROPERTY, useChunkedEncoding);
    return this;
  }

  /**
   * When POST'ing, PUT'ing or PATCH'ing content set this property to true in order to not pass the 'Content-length' header and instead send 'Transfer-Encoding' with a value of 'chunked'. This will enable the data transfer mechanism which was introduced in HTTP 1.1 to pass data of unknown lengths in chunks.
   */
  public final InvokeHTTP removeUseChunkedEncoding() {
    properties.remove(USE_CHUNKED_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public final String getPenalizeOnNoRetry() {
    return properties.get(PENALIZE_ON_NO_RETRY_PROPERTY);
  }

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public final InvokeHTTP setPenalizeOnNoRetry(final String penalizeOnNoRetry) {
    properties.put(PENALIZE_ON_NO_RETRY_PROPERTY, penalizeOnNoRetry);
    return this;
  }

  /**
   * Enabling this property will penalize FlowFiles that are routed to the "No Retry" relationship.
   */
  public final InvokeHTTP removePenalizeOnNoRetry() {
    properties.remove(PENALIZE_ON_NO_RETRY_PROPERTY);
    return this;
  }

  /**
   * Enable HTTP entity tag (ETag) support for HTTP requests.
   */
  public final String getUseEtag() {
    return properties.get(USE_ETAG_PROPERTY);
  }

  /**
   * Enable HTTP entity tag (ETag) support for HTTP requests.
   */
  public final InvokeHTTP setUseEtag(final String useEtag) {
    properties.put(USE_ETAG_PROPERTY, useEtag);
    return this;
  }

  /**
   * Enable HTTP entity tag (ETag) support for HTTP requests.
   */
  public final InvokeHTTP removeUseEtag() {
    properties.remove(USE_ETAG_PROPERTY);
    return this;
  }

  /**
   * The maximum size that the ETag cache should be allowed to grow to. The default size is 10MB.
   */
  public final String getEtagMaxCacheSize() {
    return properties.get(ETAG_MAX_CACHE_SIZE_PROPERTY);
  }

  /**
   * The maximum size that the ETag cache should be allowed to grow to. The default size is 10MB.
   */
  public final InvokeHTTP setEtagMaxCacheSize(final String etagMaxCacheSize) {
    properties.put(ETAG_MAX_CACHE_SIZE_PROPERTY, etagMaxCacheSize);
    return this;
  }

  /**
   * The maximum size that the ETag cache should be allowed to grow to. The default size is 10MB.
   */
  public final InvokeHTTP removeEtagMaxCacheSize() {
    properties.remove(ETAG_MAX_CACHE_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final InvokeHTTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final InvokeHTTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<InvokeHTTP, InvokeHTTP> configurator) {
    return configurator.apply(new InvokeHTTP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InvokeHTTP.class) final Closure<InvokeHTTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.InvokeHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.InvokeHTTP.class, com.tibtech.nifi.processors.standard.InvokeHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<InvokeHTTP, InvokeHTTP> configurator) {
    return configurator.apply(new InvokeHTTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InvokeHTTP.class) final Closure<InvokeHTTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.InvokeHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.InvokeHTTP.class, com.tibtech.nifi.processors.standard.InvokeHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
