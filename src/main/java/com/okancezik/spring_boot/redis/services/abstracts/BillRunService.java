package com.okancezik.spring_boot.redis.services.abstracts;

import com.okancezik.spring_boot.redis.entites.BillRun;

public interface BillRunService {
	void save(BillRun billRun);
	BillRun getById(long id);
	boolean deleteById(long id);
}
