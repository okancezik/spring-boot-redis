package com.okancezik.spring_boot.redis.service.concretes;

import com.okancezik.spring_boot.redis.core.RedisService;
import com.okancezik.spring_boot.redis.entity.BillRun;
import com.okancezik.spring_boot.redis.repository.BillRunRepository;
import com.okancezik.spring_boot.redis.service.abstracts.BillRunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillRunServiceImplRTDB implements BillRunService {
	private final BillRunRepository billRunRepository;
	private final RedisService      redisService;

	@Override
	public void save(BillRun billRun) {
		log.info("Save method has been called");
		billRunRepository.save(billRun);
		redisService.setCacheValue(billRun.getId(), billRun);
	}

	@Override
	public Optional<BillRun> getById(long id) {
		log.info("GetById method has been called, id: {}", id);
		Optional<BillRun> optionalCachedBillRun = redisService.getCacheValue(id);
		if (optionalCachedBillRun.isPresent()) {
			log.info("Data found in cache, id: {}", id);
			BillRun billRun = optionalCachedBillRun.get();
			return Optional.of(billRun);
		}
		log.info("Data not found in cache, BillRunRepository has been called");
		Optional<BillRun> optionalBillRun = billRunRepository.findById(id);
		if (optionalBillRun.isPresent()) {
			BillRun billRun = optionalBillRun.get();
			redisService.setCacheValue(billRun.getId(), billRun);
			return Optional.of(billRun);
		}
		return Optional.empty();
	}

	@Override
	public void delete(long id) {
		log.info("DeleteById method has been called");
		redisService.deleteCacheValue(id);
		billRunRepository.deleteById(id);
	}

	@Override
	public List<BillRun> getAll() {
		Optional<List<BillRun>> optionalData = redisService.getCacheList();
		if (optionalData.isPresent()) {
			log.info("Data found in cache.");
			return optionalData.get();
		}
		log.info("Data not found in cache. BillRunRepository has been called");
		List<BillRun> billRuns = billRunRepository.findAll();
		if (!billRuns.isEmpty()) {
			redisService.setCacheList(billRuns);
		}
		return billRuns;
	}
}
