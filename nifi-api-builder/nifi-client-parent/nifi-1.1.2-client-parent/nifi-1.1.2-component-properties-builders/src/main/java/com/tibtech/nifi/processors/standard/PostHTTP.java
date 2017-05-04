package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PostHTTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PostHTTP";

  /**
   * The URL to POST to. The first part of the URL must be static. However, the path of the URL may be defined using the Attribute Expression Language. For example, https://${hostname} is not valid, but https://1.1.1.1:8080/files/${nf.file.name} is valid.
   */
  public static final String URL_PROPERTY = "URL";

  /**
   * If the Send as FlowFile property is true, specifies the max data size for a batch of FlowFiles to send in a single HTTP POST. If not specified, each FlowFile will be sent separately. If the Send as FlowFile property is false, this property is ignored
   */
  public static final String MAX_BATCH_SIZE_PROPERTY = "Max Batch Size";

  /**
   * The maximum amount of data to send per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public static final String MAX_DATA_TO_POST_PER_SECOND_PROPERTY = "Max Data to Post per Second";

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Username required to access the URL
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password required to access the URL
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * If true, will package the FlowFile's contents and attributes together and send the FlowFile Package; otherwise, will send only the FlowFile's content
   */
  public static final String SEND_AS_FLOW_FILE_PROPERTY = "Send as FlowFile";

  /**
   * Specifies whether or not to use Chunked Encoding to send the data. This property is ignored in the event the contents are compressed or sent as FlowFiles.
   */
  public static final String USE_CHUNKED_ENCODING_PROPERTY = "Use Chunked Encoding";

  /**
   * Determines the GZIP Compression Level to use when sending the file; the value must be in the range of 0-9. A value of 0 indicates that the file will not be GZIP'ed
   */
  public static final String COMPRESSION_LEVEL_PROPERTY = "Compression Level";

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "Connection Timeout";

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public static final String DATA_TIMEOUT_PROPERTY = "Data Timeout";

  /**
   * Specifies the Regular Expression that determines the names of FlowFile attributes that should be sent as HTTP Headers
   */
  public static final String ATTRIBUTES_TO_SEND_AS_HTTP_HEADERS_REGEX_PROPERTY = "Attributes to Send as HTTP Headers (Regex)";

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public static final String USER_AGENT_PROPERTY = "User Agent";

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * The port of the proxy server
   */
  public static final String PROXY_PORT_PROPERTY = "Proxy Port";

  /**
   * The Content-Type to specify for the content of the FlowFile being POSTed if Send as FlowFile is false. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public static final String CONTENT_TYPE_PROPERTY = "Content-Type";

  private final Map<String, String> properties;

  public PostHTTP() {
    this.properties = new HashMap<>();
  }

  public PostHTTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The URL to POST to. The first part of the URL must be static. However, the path of the URL may be defined using the Attribute Expression Language. For example, https://${hostname} is not valid, but https://1.1.1.1:8080/files/${nf.file.name} is valid.
   */
  public final String getUrl() {
    return properties.get(URL_PROPERTY);
  }

  /**
   * The URL to POST to. The first part of the URL must be static. However, the path of the URL may be defined using the Attribute Expression Language. For example, https://${hostname} is not valid, but https://1.1.1.1:8080/files/${nf.file.name} is valid.
   */
  public final PostHTTP setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * The URL to POST to. The first part of the URL must be static. However, the path of the URL may be defined using the Attribute Expression Language. For example, https://${hostname} is not valid, but https://1.1.1.1:8080/files/${nf.file.name} is valid.
   */
  public final PostHTTP removeUrl() {
    properties.remove(URL_PROPERTY);
    return this;
  }

  /**
   * If the Send as FlowFile property is true, specifies the max data size for a batch of FlowFiles to send in a single HTTP POST. If not specified, each FlowFile will be sent separately. If the Send as FlowFile property is false, this property is ignored
   */
  public final String getMaxBatchSize() {
    return properties.get(MAX_BATCH_SIZE_PROPERTY);
  }

  /**
   * If the Send as FlowFile property is true, specifies the max data size for a batch of FlowFiles to send in a single HTTP POST. If not specified, each FlowFile will be sent separately. If the Send as FlowFile property is false, this property is ignored
   */
  public final PostHTTP setMaxBatchSize(final String maxBatchSize) {
    properties.put(MAX_BATCH_SIZE_PROPERTY, maxBatchSize);
    return this;
  }

  /**
   * If the Send as FlowFile property is true, specifies the max data size for a batch of FlowFiles to send in a single HTTP POST. If not specified, each FlowFile will be sent separately. If the Send as FlowFile property is false, this property is ignored
   */
  public final PostHTTP removeMaxBatchSize() {
    properties.remove(MAX_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of data to send per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public final String getMaxDataToPostPerSecond() {
    return properties.get(MAX_DATA_TO_POST_PER_SECOND_PROPERTY);
  }

  /**
   * The maximum amount of data to send per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public final PostHTTP setMaxDataToPostPerSecond(final String maxDataToPostPerSecond) {
    properties.put(MAX_DATA_TO_POST_PER_SECOND_PROPERTY, maxDataToPostPerSecond);
    return this;
  }

  /**
   * The maximum amount of data to send per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public final PostHTTP removeMaxDataToPostPerSecond() {
    properties.remove(MAX_DATA_TO_POST_PER_SECOND_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final PostHTTP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final PostHTTP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Username required to access the URL
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username required to access the URL
   */
  public final PostHTTP setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username required to access the URL
   */
  public final PostHTTP removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password required to access the URL
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password required to access the URL
   */
  public final PostHTTP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password required to access the URL
   */
  public final PostHTTP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * If true, will package the FlowFile's contents and attributes together and send the FlowFile Package; otherwise, will send only the FlowFile's content
   */
  public final String getSendAsFlowFile() {
    return properties.get(SEND_AS_FLOW_FILE_PROPERTY);
  }

  /**
   * If true, will package the FlowFile's contents and attributes together and send the FlowFile Package; otherwise, will send only the FlowFile's content
   */
  public final PostHTTP setSendAsFlowFile(final String sendAsFlowFile) {
    properties.put(SEND_AS_FLOW_FILE_PROPERTY, sendAsFlowFile);
    return this;
  }

  /**
   * If true, will package the FlowFile's contents and attributes together and send the FlowFile Package; otherwise, will send only the FlowFile's content
   */
  public final PostHTTP removeSendAsFlowFile() {
    properties.remove(SEND_AS_FLOW_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not to use Chunked Encoding to send the data. This property is ignored in the event the contents are compressed or sent as FlowFiles.
   */
  public final String getUseChunkedEncoding() {
    return properties.get(USE_CHUNKED_ENCODING_PROPERTY);
  }

  /**
   * Specifies whether or not to use Chunked Encoding to send the data. This property is ignored in the event the contents are compressed or sent as FlowFiles.
   */
  public final PostHTTP setUseChunkedEncoding(final String useChunkedEncoding) {
    properties.put(USE_CHUNKED_ENCODING_PROPERTY, useChunkedEncoding);
    return this;
  }

  /**
   * Specifies whether or not to use Chunked Encoding to send the data. This property is ignored in the event the contents are compressed or sent as FlowFiles.
   */
  public final PostHTTP removeUseChunkedEncoding() {
    properties.remove(USE_CHUNKED_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Determines the GZIP Compression Level to use when sending the file; the value must be in the range of 0-9. A value of 0 indicates that the file will not be GZIP'ed
   */
  public final String getCompressionLevel() {
    return properties.get(COMPRESSION_LEVEL_PROPERTY);
  }

  /**
   * Determines the GZIP Compression Level to use when sending the file; the value must be in the range of 0-9. A value of 0 indicates that the file will not be GZIP'ed
   */
  public final PostHTTP setCompressionLevel(final String compressionLevel) {
    properties.put(COMPRESSION_LEVEL_PROPERTY, compressionLevel);
    return this;
  }

  /**
   * Determines the GZIP Compression Level to use when sending the file; the value must be in the range of 0-9. A value of 0 indicates that the file will not be GZIP'ed
   */
  public final PostHTTP removeCompressionLevel() {
    properties.remove(COMPRESSION_LEVEL_PROPERTY);
    return this;
  }

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public final PostHTTP setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * How long to wait when attempting to connect to the remote server before giving up
   */
  public final PostHTTP removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public final String getDataTimeout() {
    return properties.get(DATA_TIMEOUT_PROPERTY);
  }

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public final PostHTTP setDataTimeout(final String dataTimeout) {
    properties.put(DATA_TIMEOUT_PROPERTY, dataTimeout);
    return this;
  }

  /**
   * How long to wait between receiving segments of data from the remote server before giving up and discarding the partial file
   */
  public final PostHTTP removeDataTimeout() {
    properties.remove(DATA_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies the Regular Expression that determines the names of FlowFile attributes that should be sent as HTTP Headers
   */
  public final String getAttributesToSendAsHttpHeadersRegex() {
    return properties.get(ATTRIBUTES_TO_SEND_AS_HTTP_HEADERS_REGEX_PROPERTY);
  }

  /**
   * Specifies the Regular Expression that determines the names of FlowFile attributes that should be sent as HTTP Headers
   */
  public final PostHTTP setAttributesToSendAsHttpHeadersRegex(final String attributesToSendAsHttpHeadersRegex) {
    properties.put(ATTRIBUTES_TO_SEND_AS_HTTP_HEADERS_REGEX_PROPERTY, attributesToSendAsHttpHeadersRegex);
    return this;
  }

  /**
   * Specifies the Regular Expression that determines the names of FlowFile attributes that should be sent as HTTP Headers
   */
  public final PostHTTP removeAttributesToSendAsHttpHeadersRegex() {
    properties.remove(ATTRIBUTES_TO_SEND_AS_HTTP_HEADERS_REGEX_PROPERTY);
    return this;
  }

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public final String getUserAgent() {
    return properties.get(USER_AGENT_PROPERTY);
  }

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public final PostHTTP setUserAgent(final String userAgent) {
    properties.put(USER_AGENT_PROPERTY, userAgent);
    return this;
  }

  /**
   * What to report as the User Agent when we connect to the remote server
   */
  public final PostHTTP removeUserAgent() {
    properties.remove(USER_AGENT_PROPERTY);
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
  public final PostHTTP setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * The fully qualified hostname or IP address of the proxy server
   */
  public final PostHTTP removeProxyHost() {
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
  public final PostHTTP setProxyPort(final String proxyPort) {
    properties.put(PROXY_PORT_PROPERTY, proxyPort);
    return this;
  }

  /**
   * The port of the proxy server
   */
  public final PostHTTP removeProxyPort() {
    properties.remove(PROXY_PORT_PROPERTY);
    return this;
  }

  /**
   * The Content-Type to specify for the content of the FlowFile being POSTed if Send as FlowFile is false. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final String getContentType() {
    return properties.get(CONTENT_TYPE_PROPERTY);
  }

  /**
   * The Content-Type to specify for the content of the FlowFile being POSTed if Send as FlowFile is false. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final PostHTTP setContentType(final String contentType) {
    properties.put(CONTENT_TYPE_PROPERTY, contentType);
    return this;
  }

  /**
   * The Content-Type to specify for the content of the FlowFile being POSTed if Send as FlowFile is false. In the case of an empty value after evaluating an expression language expression, Content-Type defaults to application/octet-stream
   */
  public final PostHTTP removeContentType() {
    properties.remove(CONTENT_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PostHTTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PostHTTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PostHTTP, PostHTTP> configurator) {
    return configurator.apply(new PostHTTP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PostHTTP.class) final Closure<PostHTTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PostHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PostHTTP.class, com.tibtech.nifi.processors.standard.PostHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PostHTTP, PostHTTP> configurator) {
    return configurator.apply(new PostHTTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PostHTTP.class) final Closure<PostHTTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PostHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PostHTTP.class, com.tibtech.nifi.processors.standard.PostHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
