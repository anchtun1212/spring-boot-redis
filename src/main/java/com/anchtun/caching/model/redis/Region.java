package com.anchtun.caching.model.redis;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@RedisHash("Region")
@Getter
@Setter
@Builder
public class Region implements Serializable {

	@Id
	private Long id;

	@Indexed
	@Column(name = "name_ar")
	private String nameAr;

	@Indexed
	@Column(name = "name_en")
	private String nameEn;

}
