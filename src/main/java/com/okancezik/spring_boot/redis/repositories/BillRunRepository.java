package com.okancezik.spring_boot.redis.repositories;

import com.okancezik.spring_boot.redis.entites.BillRun;
import org.springframework.data.repository.CrudRepository;

public interface BillRunRepository extends CrudRepository<BillRun,Long> {
}
