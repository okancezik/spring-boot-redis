package com.okancezik.spring_boot.redis.repositories;

import com.okancezik.spring_boot.redis.entites.BillRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRunRepository extends JpaRepository<BillRun,Long> {
}
