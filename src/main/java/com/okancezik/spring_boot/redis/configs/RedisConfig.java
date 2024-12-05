package com.okancezik.spring_boot.redis.configs;

import com.okancezik.spring_boot.redis.entity.BillRun;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

@Configuration
public class RedisConfig {
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
	}

	@Bean
	public RedisTemplate<String, BillRun> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, BillRun> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		/*
		** KEY,VALUE Serializer setting
		 */
		template.setKeySerializer(new StringRedisSerializer());
		/*
		* Jackson2JsonRedisSerializer Json formatında veriyi cache'e yazar. @class anatasyonu yoktur.
		* */
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(BillRun.class));

		return template;
	}

	@Bean
	public RedisTemplate<String, List<BillRun>> redisListTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, List<BillRun>> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		/*
		 ** KEY,VALUE Serializer setting
		 */
		template.setKeySerializer(new StringRedisSerializer());
		/*
		 * Jackson2JsonRedisSerializer Json formatında veriyi cache'e yazar. @class anatasyonu yoktur.
		 * */
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(List.class));

		return template;
	}

}
