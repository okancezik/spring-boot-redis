package com.okancezik.spring_boot.redis.core;

import com.okancezik.spring_boot.redis.entites.BillRun;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisService {

	private final RedisTemplate<Object, Object> redisTemplate;

	public void setCacheValue(Long key, BillRun value) {
		redisTemplate.opsForValue().set(key, value);  // Object'i JSON formatında kaydeder
	}

	public Optional<Object> getCacheValue(Long key) {
		var result = redisTemplate.opsForValue().get(key);  // Redis'ten Object alır
		if (result != null) {
			return Optional.of(result);
		}
		return Optional.empty();
	}

	public boolean deleteCacheValue(Long key) {
		return Boolean.TRUE.equals(redisTemplate.delete(key));
	}
}

