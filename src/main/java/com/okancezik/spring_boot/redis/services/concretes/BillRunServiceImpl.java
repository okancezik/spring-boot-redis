package com.okancezik.spring_boot.redis.services.concretes;

import com.okancezik.spring_boot.redis.entites.BillRun;
import com.okancezik.spring_boot.redis.repositories.BillRunRepository;
import com.okancezik.spring_boot.redis.services.abstracts.BillRunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
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

	@CacheEvict(value = "billRuns", key = "'allBillRuns'")
	@Override
	public void save(BillRun billRun) {
		log.info("Save method has been called, BillRun data: {}", billRun.toString());
		billRunRepository.save(billRun);
	}

	@Cacheable(value = "billRuns", key = "#id")
	@Override
	public BillRun getById(long id) {
		log.info("GetById method has been called. Database has been called for id: {}", id);
		Optional<BillRun> billRun = billRunRepository.findById(id);
		return billRun.orElse(null);
	}

	@CacheEvict(value = "billRuns",key = "#id")
	@Override
	public boolean deleteById(long id) {
		log.info("Delete method has been called, id: {}", id);
		billRunRepository.deleteById(id);
		return true;
	}

	@Cacheable(value = "billRuns", key = "'allBillRuns'")
	@Override
	public List<BillRun> getAll() {
		log.info("GetAll method has been called.");
		return billRunRepository.findAll();
	}
}
