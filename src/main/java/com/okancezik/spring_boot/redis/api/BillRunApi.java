package com.okancezik.spring_boot.redis.api;

import com.okancezik.spring_boot.redis.entites.BillRun;
import com.okancezik.spring_boot.redis.services.concretes.BillRunServiceImplRTDB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		BillRun billRun = billRunService.getById(id);
		if (billRun != null) {
			return ResponseEntity.ok(billRun);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		billRunService.deleteById(id);
		return ResponseEntity.ok(true);
	}
}
