package com.okancezik.spring_boot.redis.service.abstracts;

import com.okancezik.spring_boot.redis.entity.BillRun;

import java.util.List;
import java.util.Optional;

public interface BillRunService {
	void save(BillRun billRun);
	Optional<BillRun> getById(long id);
	void delete(long id);
	List<BillRun> getAll();
}
