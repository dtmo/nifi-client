package com.tibtech.nifi.processors.twitter;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetTwitter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.twitter.GetTwitter";

  /**
   * Specifies which endpoint data should be pulled from
   */
  public static final String TWITTER_ENDPOINT_PROPERTY = "Twitter Endpoint";

  /**
   * The Consumer Key provided by Twitter
   */
  public static final String CONSUMER_KEY_PROPERTY = "Consumer Key";

  /**
   * The Consumer Secret provided by Twitter
   */
  public static final String CONSUMER_SECRET_PROPERTY = "Consumer Secret";

  /**
   * The Access Token provided by Twitter
   */
  public static final String ACCESS_TOKEN_PROPERTY = "Access Token";

  /**
   * The Access Token Secret provided by Twitter
   */
  public static final String ACCESS_TOKEN_SECRET_PROPERTY = "Access Token Secret";

  /**
   * A comma-separated list of languages for which tweets should be fetched
   */
  public static final String LANGUAGES_PROPERTY = "Languages";

  /**
   * A comma-separated list of terms to filter on. Ignored unless Endpoint is set to 'Filter Endpoint'. The filter works such that if any term matches, the status update will be retrieved; multiple terms separated by a space function as an 'AND'. I.e., 'it was, hello' will retrieve status updates that have either 'hello' or both 'it' AND 'was'
   */
  public static final String TERMS_TO_FILTER_ON_PROPERTY = "Terms to Filter On";

  /**
   * A comma-separated list of Twitter User ID's to follow. Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public static final String I_DS_TO_FOLLOW_PROPERTY = "IDs to Follow";

  /**
   * A comma-separated list of coordinates specifying one or more bounding boxes to filter on.Each bounding box is specified by a pair of coordinates in the format: swLon,swLat,neLon,neLat. Multiple bounding boxes can be specified as such: swLon1,swLat1,neLon1,neLat1,swLon2,swLat2,neLon2,neLat2.Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public static final String LOCATIONS_TO_FILTER_ON_PROPERTY = "Locations to Filter On";

  private final Map<String, String> properties;

  public GetTwitter() {
    this.properties = new HashMap<>();
  }

  public GetTwitter(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies which endpoint data should be pulled from
   */
  public final String getTwitterEndpoint() {
    return properties.get(TWITTER_ENDPOINT_PROPERTY);
  }

  /**
   * Specifies which endpoint data should be pulled from
   */
  public final GetTwitter setTwitterEndpoint(final String twitterEndpoint) {
    properties.put(TWITTER_ENDPOINT_PROPERTY, twitterEndpoint);
    return this;
  }

  /**
   * Specifies which endpoint data should be pulled from
   */
  public final GetTwitter removeTwitterEndpoint() {
    properties.remove(TWITTER_ENDPOINT_PROPERTY);
    return this;
  }

  /**
   * The Consumer Key provided by Twitter
   */
  public final String getConsumerKey() {
    return properties.get(CONSUMER_KEY_PROPERTY);
  }

  /**
   * The Consumer Key provided by Twitter
   */
  public final GetTwitter setConsumerKey(final String consumerKey) {
    properties.put(CONSUMER_KEY_PROPERTY, consumerKey);
    return this;
  }

  /**
   * The Consumer Key provided by Twitter
   */
  public final GetTwitter removeConsumerKey() {
    properties.remove(CONSUMER_KEY_PROPERTY);
    return this;
  }

  /**
   * The Consumer Secret provided by Twitter
   */
  public final String getConsumerSecret() {
    return properties.get(CONSUMER_SECRET_PROPERTY);
  }

  /**
   * The Consumer Secret provided by Twitter
   */
  public final GetTwitter setConsumerSecret(final String consumerSecret) {
    properties.put(CONSUMER_SECRET_PROPERTY, consumerSecret);
    return this;
  }

  /**
   * The Consumer Secret provided by Twitter
   */
  public final GetTwitter removeConsumerSecret() {
    properties.remove(CONSUMER_SECRET_PROPERTY);
    return this;
  }

  /**
   * The Access Token provided by Twitter
   */
  public final String getAccessToken() {
    return properties.get(ACCESS_TOKEN_PROPERTY);
  }

  /**
   * The Access Token provided by Twitter
   */
  public final GetTwitter setAccessToken(final String accessToken) {
    properties.put(ACCESS_TOKEN_PROPERTY, accessToken);
    return this;
  }

  /**
   * The Access Token provided by Twitter
   */
  public final GetTwitter removeAccessToken() {
    properties.remove(ACCESS_TOKEN_PROPERTY);
    return this;
  }

  /**
   * The Access Token Secret provided by Twitter
   */
  public final String getAccessTokenSecret() {
    return properties.get(ACCESS_TOKEN_SECRET_PROPERTY);
  }

  /**
   * The Access Token Secret provided by Twitter
   */
  public final GetTwitter setAccessTokenSecret(final String accessTokenSecret) {
    properties.put(ACCESS_TOKEN_SECRET_PROPERTY, accessTokenSecret);
    return this;
  }

  /**
   * The Access Token Secret provided by Twitter
   */
  public final GetTwitter removeAccessTokenSecret() {
    properties.remove(ACCESS_TOKEN_SECRET_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of languages for which tweets should be fetched
   */
  public final String getLanguages() {
    return properties.get(LANGUAGES_PROPERTY);
  }

  /**
   * A comma-separated list of languages for which tweets should be fetched
   */
  public final GetTwitter setLanguages(final String languages) {
    properties.put(LANGUAGES_PROPERTY, languages);
    return this;
  }

  /**
   * A comma-separated list of languages for which tweets should be fetched
   */
  public final GetTwitter removeLanguages() {
    properties.remove(LANGUAGES_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of terms to filter on. Ignored unless Endpoint is set to 'Filter Endpoint'. The filter works such that if any term matches, the status update will be retrieved; multiple terms separated by a space function as an 'AND'. I.e., 'it was, hello' will retrieve status updates that have either 'hello' or both 'it' AND 'was'
   */
  public final String getTermsToFilterOn() {
    return properties.get(TERMS_TO_FILTER_ON_PROPERTY);
  }

  /**
   * A comma-separated list of terms to filter on. Ignored unless Endpoint is set to 'Filter Endpoint'. The filter works such that if any term matches, the status update will be retrieved; multiple terms separated by a space function as an 'AND'. I.e., 'it was, hello' will retrieve status updates that have either 'hello' or both 'it' AND 'was'
   */
  public final GetTwitter setTermsToFilterOn(final String termsToFilterOn) {
    properties.put(TERMS_TO_FILTER_ON_PROPERTY, termsToFilterOn);
    return this;
  }

  /**
   * A comma-separated list of terms to filter on. Ignored unless Endpoint is set to 'Filter Endpoint'. The filter works such that if any term matches, the status update will be retrieved; multiple terms separated by a space function as an 'AND'. I.e., 'it was, hello' will retrieve status updates that have either 'hello' or both 'it' AND 'was'
   */
  public final GetTwitter removeTermsToFilterOn() {
    properties.remove(TERMS_TO_FILTER_ON_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Twitter User ID's to follow. Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public final String getIDsToFollow() {
    return properties.get(I_DS_TO_FOLLOW_PROPERTY);
  }

  /**
   * A comma-separated list of Twitter User ID's to follow. Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public final GetTwitter setIDsToFollow(final String iDsToFollow) {
    properties.put(I_DS_TO_FOLLOW_PROPERTY, iDsToFollow);
    return this;
  }

  /**
   * A comma-separated list of Twitter User ID's to follow. Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public final GetTwitter removeIDsToFollow() {
    properties.remove(I_DS_TO_FOLLOW_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of coordinates specifying one or more bounding boxes to filter on.Each bounding box is specified by a pair of coordinates in the format: swLon,swLat,neLon,neLat. Multiple bounding boxes can be specified as such: swLon1,swLat1,neLon1,neLat1,swLon2,swLat2,neLon2,neLat2.Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public final String getLocationsToFilterOn() {
    return properties.get(LOCATIONS_TO_FILTER_ON_PROPERTY);
  }

  /**
   * A comma-separated list of coordinates specifying one or more bounding boxes to filter on.Each bounding box is specified by a pair of coordinates in the format: swLon,swLat,neLon,neLat. Multiple bounding boxes can be specified as such: swLon1,swLat1,neLon1,neLat1,swLon2,swLat2,neLon2,neLat2.Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public final GetTwitter setLocationsToFilterOn(final String locationsToFilterOn) {
    properties.put(LOCATIONS_TO_FILTER_ON_PROPERTY, locationsToFilterOn);
    return this;
  }

  /**
   * A comma-separated list of coordinates specifying one or more bounding boxes to filter on.Each bounding box is specified by a pair of coordinates in the format: swLon,swLat,neLon,neLat. Multiple bounding boxes can be specified as such: swLon1,swLat1,neLon1,neLat1,swLon2,swLat2,neLon2,neLat2.Ignored unless Endpoint is set to 'Filter Endpoint'.
   */
  public final GetTwitter removeLocationsToFilterOn() {
    properties.remove(LOCATIONS_TO_FILTER_ON_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetTwitter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetTwitter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetTwitter, GetTwitter> configurator) {
    return configurator.apply(new GetTwitter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetTwitter.class) final Closure<GetTwitter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.twitter.GetTwitter> code = closure.rehydrate(c, com.tibtech.nifi.processors.twitter.GetTwitter.class, com.tibtech.nifi.processors.twitter.GetTwitter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetTwitter, GetTwitter> configurator) {
    return configurator.apply(new GetTwitter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetTwitter.class) final Closure<GetTwitter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.twitter.GetTwitter> code = closure.rehydrate(c, com.tibtech.nifi.processors.twitter.GetTwitter.class, com.tibtech.nifi.processors.twitter.GetTwitter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
