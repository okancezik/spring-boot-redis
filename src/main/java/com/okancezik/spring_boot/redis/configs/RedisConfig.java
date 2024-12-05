package com.okancezik.spring_boot.redis.configs;

import com.okancezik.spring_boot.redis.core.RedisBaseConfig;
import com.okancezik.spring_boot.redis.entity.BillRun;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Configuration
public class RedisConfig {
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
	}

	@Bean
	public RedisTemplate<String, BillRun> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisBaseConfig<String, BillRun> baseConfig = new RedisBaseConfig<>();
		return baseConfig.getRedisTemplate(connectionFactory, BillRun.class);
	}

	@Bean
	public RedisTemplate<String, List<BillRun>> redisListTemplate(RedisConnectionFactory connectionFactory) {
		RedisBaseConfig<String, List<BillRun>> baseConfig = new RedisBaseConfig<>();
		return baseConfig.getRedisListTemplate(connectionFactory);
	}
}
