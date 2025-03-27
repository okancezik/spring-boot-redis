package com.okancezik.spring_boot.redis.repository;

import com.okancezik.spring_boot.redis.entity.BillRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRunRepository extends JpaRepository<BillRun,Long> {
}
