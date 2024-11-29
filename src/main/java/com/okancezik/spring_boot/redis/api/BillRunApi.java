package com.okancezik.spring_boot.redis.api;

import com.okancezik.spring_boot.redis.entites.BillRun;
import com.okancezik.spring_boot.redis.services.abstracts.BillRunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bill-run")
public class BillRunApi {
	private final BillRunService billRunService;

	@PostMapping
	public ResponseEntity<BillRun> save(@RequestBody BillRun billRun) {
		log.info("Save method has been called, BillRun data: {}", billRun.toString());
		billRunService.save(billRun);
		return ResponseEntity.ok(billRun);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BillRun> getById(@PathVariable long id) {
		log.info("GetById method has been called, id: "+id);
		BillRun billRun = billRunService.getById(id);
		if (billRun != null) {
			return ResponseEntity.ok(billRun);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		log.info("Delete method has been called, id: "+id);
		boolean isDeleted = billRunService.deleteById(id);
		if (isDeleted) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<BillRun>> getAll() {
		List<BillRun> billRuns = billRunService.getAll();
		return ResponseEntity.ok(billRuns);
	}

}
