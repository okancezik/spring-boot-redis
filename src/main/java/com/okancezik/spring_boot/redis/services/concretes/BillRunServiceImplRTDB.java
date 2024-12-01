package com.okancezik.spring_boot.redis.services.concretes;

import com.okancezik.spring_boot.redis.core.RedisService;
import com.okancezik.spring_boot.redis.entites.BillRun;
import com.okancezik.spring_boot.redis.repositories.BillRunRepository;
import com.okancezik.spring_boot.redis.services.abstracts.BillRunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
	public BillRun getById(long id) {
		log.info("GetById method has been called, id: {}", id);
		Optional<Object> optionalCachedBillRun = redisService.getCacheValue(id);
		if (optionalCachedBillRun.isPresent()) {
			log.info("Data found in cache, id: {}", id);
			return (BillRun) optionalCachedBillRun.get();
		}
		log.info("Data not found in cache, BillRunRepository has been called");
		Optional<BillRun> optionalBillRun = billRunRepository.findById(id);
		if (optionalBillRun.isPresent()) {
			BillRun billRun = optionalBillRun.get();
			redisService.setCacheValue(billRun.getId(), billRun);
			return billRun;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		log.info("DeleteById method has been called");
		redisService.deleteCacheValue(id);
		billRunRepository.deleteById(id);
	}
}
