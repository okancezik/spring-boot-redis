package com.okancezik.spring_boot.redis.service.concretes;

import com.okancezik.spring_boot.redis.entity.BillRun;
import com.okancezik.spring_boot.redis.repository.BillRunRepository;
import com.okancezik.spring_boot.redis.service.abstracts.BillRunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	private final BillRunRepository billRunRepository;

	@Override
	public void save(BillRun billRun) {
		billRunRepository.save(billRun);
	}

	@Override
	public Optional<BillRun> getById(long id) {
		Optional<BillRun> optionalBillRun = billRunRepository.findById(id);
		if (optionalBillRun.isPresent()){
			BillRun billRun = optionalBillRun.get();
			return Optional.of(billRun);
		}

		return Optional.empty();
	}

	@Override
	public void delete(long id) {
		billRunRepository.deleteById(id);
	}

	@Override
	public List<BillRun> getAll() {
		return List.of();
	}
}
