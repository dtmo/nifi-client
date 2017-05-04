package com.tibtech.nifi.processors.aws.s3;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutS3Object {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.s3.PutS3Object";

  /**
   *
   */
  public static final String OBJECT_KEY_PROPERTY = "Object Key";

  /**
   *
   */
  public static final String BUCKET_PROPERTY = "Bucket";

  /**
   * Sets the Content-Type HTTP header indicating the type of content stored in the associated object. The value of this header is a standard MIME type.
   * AWS S3 Java client will attempt to determine the correct content type if one hasn't been set yet. Users are responsible for ensuring a suitable content type is set when uploading streams. If no content type is provided and cannot be determined by the filename, the default content type "application/octet-stream" will be used.
   */
  public static final String CONTENT_TYPE_PROPERTY = "Content Type";

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
  public static final String STORAGE_CLASS_PROPERTY = "Storage Class";

  /**
   *
   */
  public static final String REGION_PROPERTY = "Region";

  /**
   *
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  /**
   *
   */
  public static final String EXPIRATION_TIME_RULE_PROPERTY = "Expiration Time Rule";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public static final String FULL_CONTROL_USER_LIST_PROPERTY = "FullControl User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public static final String READ_PERMISSION_USER_LIST_PROPERTY = "Read Permission User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public static final String WRITE_PERMISSION_USER_LIST_PROPERTY = "Write Permission User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public static final String READ_ACL_USER_LIST_PROPERTY = "Read ACL User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public static final String WRITE_ACL_USER_LIST_PROPERTY = "Write ACL User List";

  /**
   * The Amazon ID to use for the object's owner
   */
  public static final String OWNER_PROPERTY = "Owner";

  /**
   * Amazon Canned ACL for an object, one of: BucketOwnerFullControl, BucketOwnerRead, LogDeliveryWrite, AuthenticatedRead, PublicReadWrite, PublicRead, Private; will be ignored if any other ACL/permission/owner property is specified
   */
  public static final String CANNED_ACL_PROPERTY = "canned-acl";

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public static final String ENDPOINT_OVERRIDE_URL_PROPERTY = "Endpoint Override URL";

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public static final String SIGNER_OVERRIDE_PROPERTY = "Signer Override";

  /**
   * Specifies the file size threshold for switch from the PutS3Object API to the PutS3MultipartUpload API.  Flow files bigger than this limit will be sent using the stateful multipart process.
   * The valid range is 50MB to 5GB.
   */
  public static final String MULTIPART_THRESHOLD_PROPERTY = "Multipart Threshold";

  /**
   * Specifies the part size for use when the PutS3Multipart Upload API is used.
   * Flow files will be broken into chunks of this size for the upload process, but the last part sent can be smaller since it is not padded.
   * The valid range is 50MB to 5GB.
   */
  public static final String MULTIPART_PART_SIZE_PROPERTY = "Multipart Part Size";

  /**
   * Specifies the interval at which existing multipart uploads in AWS S3 will be evaluated for ageoff.  When processor is triggered it will initiate the ageoff evaluation if this interval has been exceeded.
   */
  public static final String MULTIPART_UPLOAD_AGE_OFF_INTERVAL_PROPERTY = "Multipart Upload AgeOff Interval";

  /**
   * Specifies the maximum age for existing multipart uploads in AWS S3.  When the ageoff process occurs, any upload older than this threshold will be aborted.
   */
  public static final String MULTIPART_UPLOAD_MAX_AGE_THRESHOLD_PROPERTY = "Multipart Upload Max Age Threshold";

  /**
   * Specifies the algorithm used for server side encryption.
   */
  public static final String SERVER_SIDE_ENCRYPTION_PROPERTY = "server-side-encryption";

  /**
   * Proxy host name or IP
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * Proxy host port
   */
  public static final String PROXY_HOST_PORT_PROPERTY = "Proxy Host Port";

  private final Map<String, String> properties;

  public PutS3Object() {
    this.properties = new HashMap<>();
  }

  public PutS3Object(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   *
   */
  public final String getObjectKey() {
    return properties.get(OBJECT_KEY_PROPERTY);
  }

  /**
   *
   */
  public final PutS3Object setObjectKey(final String objectKey) {
    properties.put(OBJECT_KEY_PROPERTY, objectKey);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeObjectKey() {
    properties.remove(OBJECT_KEY_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getBucket() {
    return properties.get(BUCKET_PROPERTY);
  }

  /**
   *
   */
  public final PutS3Object setBucket(final String bucket) {
    properties.put(BUCKET_PROPERTY, bucket);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeBucket() {
    properties.remove(BUCKET_PROPERTY);
    return this;
  }

  /**
   * Sets the Content-Type HTTP header indicating the type of content stored in the associated object. The value of this header is a standard MIME type.
   * AWS S3 Java client will attempt to determine the correct content type if one hasn't been set yet. Users are responsible for ensuring a suitable content type is set when uploading streams. If no content type is provided and cannot be determined by the filename, the default content type "application/octet-stream" will be used.
   */
  public final String getContentType() {
    return properties.get(CONTENT_TYPE_PROPERTY);
  }

  /**
   * Sets the Content-Type HTTP header indicating the type of content stored in the associated object. The value of this header is a standard MIME type.
   * AWS S3 Java client will attempt to determine the correct content type if one hasn't been set yet. Users are responsible for ensuring a suitable content type is set when uploading streams. If no content type is provided and cannot be determined by the filename, the default content type "application/octet-stream" will be used.
   */
  public final PutS3Object setContentType(final String contentType) {
    properties.put(CONTENT_TYPE_PROPERTY, contentType);
    return this;
  }

  /**
   * Sets the Content-Type HTTP header indicating the type of content stored in the associated object. The value of this header is a standard MIME type.
   * AWS S3 Java client will attempt to determine the correct content type if one hasn't been set yet. Users are responsible for ensuring a suitable content type is set when uploading streams. If no content type is provided and cannot be determined by the filename, the default content type "application/octet-stream" will be used.
   */
  public final PutS3Object removeContentType() {
    properties.remove(CONTENT_TYPE_PROPERTY);
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
  public final PutS3Object setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeAccessKey() {
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
  public final PutS3Object setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeSecretKey() {
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
  public final PutS3Object setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutS3Object removeCredentialsFile() {
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
  public final PutS3Object setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutS3Object removeAwsCredentialsProviderService() {
    properties.remove(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getStorageClass() {
    return properties.get(STORAGE_CLASS_PROPERTY);
  }

  /**
   *
   */
  public final PutS3Object setStorageClass(final String storageClass) {
    properties.put(STORAGE_CLASS_PROPERTY, storageClass);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeStorageClass() {
    properties.remove(STORAGE_CLASS_PROPERTY);
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
  public final PutS3Object setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeRegion() {
    properties.remove(REGION_PROPERTY);
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
  public final PutS3Object setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getExpirationTimeRule() {
    return properties.get(EXPIRATION_TIME_RULE_PROPERTY);
  }

  /**
   *
   */
  public final PutS3Object setExpirationTimeRule(final String expirationTimeRule) {
    properties.put(EXPIRATION_TIME_RULE_PROPERTY, expirationTimeRule);
    return this;
  }

  /**
   *
   */
  public final PutS3Object removeExpirationTimeRule() {
    properties.remove(EXPIRATION_TIME_RULE_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public final String getFullControlUserList() {
    return properties.get(FULL_CONTROL_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public final PutS3Object setFullControlUserList(final String fullControlUserList) {
    properties.put(FULL_CONTROL_USER_LIST_PROPERTY, fullControlUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public final PutS3Object removeFullControlUserList() {
    properties.remove(FULL_CONTROL_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public final String getReadPermissionUserList() {
    return properties.get(READ_PERMISSION_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public final PutS3Object setReadPermissionUserList(final String readPermissionUserList) {
    properties.put(READ_PERMISSION_USER_LIST_PROPERTY, readPermissionUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public final PutS3Object removeReadPermissionUserList() {
    properties.remove(READ_PERMISSION_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public final String getWritePermissionUserList() {
    return properties.get(WRITE_PERMISSION_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public final PutS3Object setWritePermissionUserList(final String writePermissionUserList) {
    properties.put(WRITE_PERMISSION_USER_LIST_PROPERTY, writePermissionUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public final PutS3Object removeWritePermissionUserList() {
    properties.remove(WRITE_PERMISSION_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public final String getReadAclUserList() {
    return properties.get(READ_ACL_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public final PutS3Object setReadAclUserList(final String readAclUserList) {
    properties.put(READ_ACL_USER_LIST_PROPERTY, readAclUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public final PutS3Object removeReadAclUserList() {
    properties.remove(READ_ACL_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public final String getWriteAclUserList() {
    return properties.get(WRITE_ACL_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public final PutS3Object setWriteAclUserList(final String writeAclUserList) {
    properties.put(WRITE_ACL_USER_LIST_PROPERTY, writeAclUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public final PutS3Object removeWriteAclUserList() {
    properties.remove(WRITE_ACL_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * The Amazon ID to use for the object's owner
   */
  public final String getOwner() {
    return properties.get(OWNER_PROPERTY);
  }

  /**
   * The Amazon ID to use for the object's owner
   */
  public final PutS3Object setOwner(final String owner) {
    properties.put(OWNER_PROPERTY, owner);
    return this;
  }

  /**
   * The Amazon ID to use for the object's owner
   */
  public final PutS3Object removeOwner() {
    properties.remove(OWNER_PROPERTY);
    return this;
  }

  /**
   * Amazon Canned ACL for an object, one of: BucketOwnerFullControl, BucketOwnerRead, LogDeliveryWrite, AuthenticatedRead, PublicReadWrite, PublicRead, Private; will be ignored if any other ACL/permission/owner property is specified
   */
  public final String getCannedAcl() {
    return properties.get(CANNED_ACL_PROPERTY);
  }

  /**
   * Amazon Canned ACL for an object, one of: BucketOwnerFullControl, BucketOwnerRead, LogDeliveryWrite, AuthenticatedRead, PublicReadWrite, PublicRead, Private; will be ignored if any other ACL/permission/owner property is specified
   */
  public final PutS3Object setCannedAcl(final String cannedAcl) {
    properties.put(CANNED_ACL_PROPERTY, cannedAcl);
    return this;
  }

  /**
   * Amazon Canned ACL for an object, one of: BucketOwnerFullControl, BucketOwnerRead, LogDeliveryWrite, AuthenticatedRead, PublicReadWrite, PublicRead, Private; will be ignored if any other ACL/permission/owner property is specified
   */
  public final PutS3Object removeCannedAcl() {
    properties.remove(CANNED_ACL_PROPERTY);
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
  public final PutS3Object setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final PutS3Object removeSslContextService() {
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
  public final PutS3Object setEndpointOverrideUrl(final String endpointOverrideUrl) {
    properties.put(ENDPOINT_OVERRIDE_URL_PROPERTY, endpointOverrideUrl);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final PutS3Object removeEndpointOverrideUrl() {
    properties.remove(ENDPOINT_OVERRIDE_URL_PROPERTY);
    return this;
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final String getSignerOverride() {
    return properties.get(SIGNER_OVERRIDE_PROPERTY);
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final PutS3Object setSignerOverride(final String signerOverride) {
    properties.put(SIGNER_OVERRIDE_PROPERTY, signerOverride);
    return this;
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final PutS3Object removeSignerOverride() {
    properties.remove(SIGNER_OVERRIDE_PROPERTY);
    return this;
  }

  /**
   * Specifies the file size threshold for switch from the PutS3Object API to the PutS3MultipartUpload API.  Flow files bigger than this limit will be sent using the stateful multipart process.
   * The valid range is 50MB to 5GB.
   */
  public final String getMultipartThreshold() {
    return properties.get(MULTIPART_THRESHOLD_PROPERTY);
  }

  /**
   * Specifies the file size threshold for switch from the PutS3Object API to the PutS3MultipartUpload API.  Flow files bigger than this limit will be sent using the stateful multipart process.
   * The valid range is 50MB to 5GB.
   */
  public final PutS3Object setMultipartThreshold(final String multipartThreshold) {
    properties.put(MULTIPART_THRESHOLD_PROPERTY, multipartThreshold);
    return this;
  }

  /**
   * Specifies the file size threshold for switch from the PutS3Object API to the PutS3MultipartUpload API.  Flow files bigger than this limit will be sent using the stateful multipart process.
   * The valid range is 50MB to 5GB.
   */
  public final PutS3Object removeMultipartThreshold() {
    properties.remove(MULTIPART_THRESHOLD_PROPERTY);
    return this;
  }

  /**
   * Specifies the part size for use when the PutS3Multipart Upload API is used.
   * Flow files will be broken into chunks of this size for the upload process, but the last part sent can be smaller since it is not padded.
   * The valid range is 50MB to 5GB.
   */
  public final String getMultipartPartSize() {
    return properties.get(MULTIPART_PART_SIZE_PROPERTY);
  }

  /**
   * Specifies the part size for use when the PutS3Multipart Upload API is used.
   * Flow files will be broken into chunks of this size for the upload process, but the last part sent can be smaller since it is not padded.
   * The valid range is 50MB to 5GB.
   */
  public final PutS3Object setMultipartPartSize(final String multipartPartSize) {
    properties.put(MULTIPART_PART_SIZE_PROPERTY, multipartPartSize);
    return this;
  }

  /**
   * Specifies the part size for use when the PutS3Multipart Upload API is used.
   * Flow files will be broken into chunks of this size for the upload process, but the last part sent can be smaller since it is not padded.
   * The valid range is 50MB to 5GB.
   */
  public final PutS3Object removeMultipartPartSize() {
    properties.remove(MULTIPART_PART_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the interval at which existing multipart uploads in AWS S3 will be evaluated for ageoff.  When processor is triggered it will initiate the ageoff evaluation if this interval has been exceeded.
   */
  public final String getMultipartUploadAgeOffInterval() {
    return properties.get(MULTIPART_UPLOAD_AGE_OFF_INTERVAL_PROPERTY);
  }

  /**
   * Specifies the interval at which existing multipart uploads in AWS S3 will be evaluated for ageoff.  When processor is triggered it will initiate the ageoff evaluation if this interval has been exceeded.
   */
  public final PutS3Object setMultipartUploadAgeOffInterval(final String multipartUploadAgeOffInterval) {
    properties.put(MULTIPART_UPLOAD_AGE_OFF_INTERVAL_PROPERTY, multipartUploadAgeOffInterval);
    return this;
  }

  /**
   * Specifies the interval at which existing multipart uploads in AWS S3 will be evaluated for ageoff.  When processor is triggered it will initiate the ageoff evaluation if this interval has been exceeded.
   */
  public final PutS3Object removeMultipartUploadAgeOffInterval() {
    properties.remove(MULTIPART_UPLOAD_AGE_OFF_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum age for existing multipart uploads in AWS S3.  When the ageoff process occurs, any upload older than this threshold will be aborted.
   */
  public final String getMultipartUploadMaxAgeThreshold() {
    return properties.get(MULTIPART_UPLOAD_MAX_AGE_THRESHOLD_PROPERTY);
  }

  /**
   * Specifies the maximum age for existing multipart uploads in AWS S3.  When the ageoff process occurs, any upload older than this threshold will be aborted.
   */
  public final PutS3Object setMultipartUploadMaxAgeThreshold(final String multipartUploadMaxAgeThreshold) {
    properties.put(MULTIPART_UPLOAD_MAX_AGE_THRESHOLD_PROPERTY, multipartUploadMaxAgeThreshold);
    return this;
  }

  /**
   * Specifies the maximum age for existing multipart uploads in AWS S3.  When the ageoff process occurs, any upload older than this threshold will be aborted.
   */
  public final PutS3Object removeMultipartUploadMaxAgeThreshold() {
    properties.remove(MULTIPART_UPLOAD_MAX_AGE_THRESHOLD_PROPERTY);
    return this;
  }

  /**
   * Specifies the algorithm used for server side encryption.
   */
  public final String getServerSideEncryption() {
    return properties.get(SERVER_SIDE_ENCRYPTION_PROPERTY);
  }

  /**
   * Specifies the algorithm used for server side encryption.
   */
  public final PutS3Object setServerSideEncryption(final String serverSideEncryption) {
    properties.put(SERVER_SIDE_ENCRYPTION_PROPERTY, serverSideEncryption);
    return this;
  }

  /**
   * Specifies the algorithm used for server side encryption.
   */
  public final PutS3Object removeServerSideEncryption() {
    properties.remove(SERVER_SIDE_ENCRYPTION_PROPERTY);
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
  public final PutS3Object setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final PutS3Object removeProxyHost() {
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
  public final PutS3Object setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final PutS3Object removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutS3Object setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutS3Object removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutS3Object, PutS3Object> configurator) {
    return configurator.apply(new PutS3Object()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutS3Object.class) final Closure<PutS3Object> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.s3.PutS3Object> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.s3.PutS3Object.class, com.tibtech.nifi.processors.aws.s3.PutS3Object.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutS3Object, PutS3Object> configurator) {
    return configurator.apply(new PutS3Object(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutS3Object.class) final Closure<PutS3Object> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.s3.PutS3Object> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.s3.PutS3Object.class, com.tibtech.nifi.processors.aws.s3.PutS3Object.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
