package com.okancezik.spring_boot.redis.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@RedisHash(value = "User", timeToLive = 3600) // 1 saat sonra silinecek
public class BillRun implements Serializable {
	@Serial
	private static final long          serialVersionUID = 1L;
	@Id
	private              long          id;
	private              String        name;
	private              LocalDateTime billDate;
	private              Long          billingAccountId;
}
