package com.okancezik.spring_boot.redis.core;

import com.okancezik.spring_boot.redis.entity.BillRun;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {
	private final RedisTemplate<String, BillRun>       redisTemplate;
	private final RedisTemplate<String, List<BillRun>> redisListTemplate;

	public void setCacheValue(Long key, BillRun value) {
		redisTemplate.opsForValue().set(Constants.HASH_KEY + key, value);
	}

	public Optional<BillRun> getCacheValue(Long key) {
		BillRun billRun = redisTemplate.opsForValue().get(Constants.HASH_KEY + key.toString());
		return Optional.ofNullable(billRun);
	}

	public void deleteCacheValue(Long key) {
		redisTemplate.delete(Constants.HASH_KEY + key);
	}

	public void setCacheList(List<BillRun> list) {
		redisListTemplate.opsForValue().set(Constants.HASH_KEY_ALL_BILL_RUNS, list);
	}

	public Optional<List<BillRun>> getCacheList() {
		List<BillRun> billRuns = redisListTemplate.opsForValue().get(Constants.HASH_KEY_ALL_BILL_RUNS);
		log.info("billRuns : {}", billRuns);
		return billRuns != null ? Optional.of(billRuns) : Optional.empty();
	}
}

