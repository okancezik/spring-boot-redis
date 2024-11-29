package com.okancezik.spring_boot.redis.services.concretes;

import com.okancezik.spring_boot.redis.entites.BillRun;
import com.okancezik.spring_boot.redis.repositories.BillRunRepository;
import com.okancezik.spring_boot.redis.services.abstracts.BillRunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillRunServiceImpl implements BillRunService {

//	private final RedisService redisService;
//
//	@Override
//	public void save(BillRun billRun) {
//		redisService.setCacheValue(billRun.getId(),billRun);
//	}
//
//	@Override
//	public BillRun getById(long id) {
//		Object object = redisService.getCacheValue(id);
//		if(object instanceof BillRun){
//			return (BillRun) object;
//		}
//		return null;
//	}
//
//	@Override
//	public boolean deleteById(long id) {
//		return redisService.deleteCacheValue(id);
//	}

	//private final BillRunRepository billRunRepository;

	private final BillRunRepository billRunRepository;

	@Override
	public void save(BillRun billRun) {
		billRunRepository.save(billRun);
	}

	@Cacheable(value = "billRuns", key = "#id")
	@Override
	public BillRun getById(long id) {
		log.info("Database called for id: "+id);
		Optional<BillRun> billRun = billRunRepository.findById(id);
		return billRun.orElse(null);
	}

	@Override
	public boolean deleteById(long id) {
		billRunRepository.deleteById(id);
		return true;
	}
}
