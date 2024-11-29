package com.okancezik.spring_boot.redis.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
//@RedisHash(value = "User", timeToLive = 3600) // 1 saat sonra silinecek
public class BillRun implements Serializable {
	private static final long          serialVersionUID = 1L; // Versiyon kontrolü için gerekli
	private              long          id;
	private              String        name;
	private              LocalDateTime billDate;
	private              Long          billingAccountId;
}
