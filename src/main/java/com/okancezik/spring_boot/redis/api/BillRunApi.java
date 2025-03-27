package com.okancezik.spring_boot.redis.api;

import com.okancezik.spring_boot.redis.entity.BillRun;
import com.okancezik.spring_boot.redis.service.concretes.BillRunServiceImplRTDB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bill-run")
public class BillRunApi {
	private final BillRunServiceImplRTDB billRunService;

	@PostMapping
	public ResponseEntity<BillRun> save(@RequestBody BillRun billRun) {
		billRunService.save(billRun);
		return ResponseEntity.ok(billRun);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BillRun> getById(@PathVariable long id) {
		Optional<BillRun> billRun = billRunService.getById(id);
		return billRun.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		billRunService.delete(id);
		return ResponseEntity.ok(true);
	}

	@GetMapping
	public ResponseEntity<List<BillRun>> getAll() {
		List<BillRun> billRuns = billRunService.getAll();
		return ResponseEntity.ok(billRuns);
	}
}
