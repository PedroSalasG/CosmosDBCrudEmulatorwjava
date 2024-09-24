package com.cosmos.cosmos.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties(prefix = "cosmos")
public class ExternalConstant {

  @Value("${COSMOSDB_URL}")
  private String uri;

  @Value("${COSMOSDB_KEY}")
  private String key;

  private boolean queryMetricsEnabled;
}
