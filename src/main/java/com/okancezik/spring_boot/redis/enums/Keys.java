package com.okancezik.spring_boot.redis.enums;

public enum Keys {
	HASH_KEY("BillRuns::"),
	HASH_KEY_ALL("BillRuns");
	private final String value;

	Keys(String value) {
		this.value = value;
	}

	public String getKey() {
		return value;
	}
}
