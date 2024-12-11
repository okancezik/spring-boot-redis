package com.okancezik.spring_boot.redis.core;

import com.okancezik.spring_boot.redis.entity.BillRun;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.okancezik.spring_boot.redis.enums.Keys.HASH_KEY;
import static com.okancezik.spring_boot.redis.enums.Keys.HASH_KEY_ALL;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {
	private final RedisTemplate<String, BillRun>       redisTemplate;
	private final RedisTemplate<String, List<BillRun>> redisListTemplate;

	public void setCacheValue(Long key, BillRun value) {
		redisTemplate.opsForValue().set(HASH_KEY.getKey() + key, value);
	}

	public Optional<BillRun> getCacheValue(Long key) {
		BillRun billRun = redisTemplate.opsForValue().get(HASH_KEY.getKey() + key.toString());
		return Optional.ofNullable(billRun);
	}

	public void deleteCacheValue(Long key) {
		redisTemplate.delete(HASH_KEY.getKey() + key);
	}

	public void setCacheList(List<BillRun> list) {
		redisListTemplate.opsForValue().set(HASH_KEY_ALL.getKey(), list);
	}

	public Optional<List<BillRun>> getCacheList() {
		List<BillRun> billRuns = redisListTemplate.opsForValue().get(HASH_KEY_ALL.getKey());
		log.info("billRuns : {}", billRuns);
		return billRuns != null ? Optional.of(billRuns) : Optional.empty();
	}
}

