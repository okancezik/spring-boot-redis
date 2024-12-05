package com.okancezik.spring_boot.redis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillRun implements Serializable {
	@Serial
	private static final long   serialVersionUID = 1L;
	@Id
	private              long   id;
	private              String name;
	private              String billDate;
	private              Long   billingAccountId;
}
