package com.okancezik.spring_boot.redis.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration fiveMinuteTtlExpirationDefaults =
				RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30));
		return RedisCacheManager
				.builder(redisConnectionFactory)
				.cacheDefaults(fiveMinuteTtlExpirationDefaults)
				.build();
	}
}
