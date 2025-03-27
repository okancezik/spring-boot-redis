package com.okancezik.spring_boot.redis.core;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

public class RedisBaseConfig<K, V> {
	@Bean
	public RedisTemplate<K, V> getRedisTemplate(RedisConnectionFactory connectionFactory, Class<V> type) {
		RedisTemplate<K, V> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		/*
		 ** KEY,VALUE Serializer setting
		 */
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(type));
		return template;
	}

	@Bean
	public RedisTemplate<K, V> getRedisListTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<K, V> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(List.class));
		return template;
	}
}
