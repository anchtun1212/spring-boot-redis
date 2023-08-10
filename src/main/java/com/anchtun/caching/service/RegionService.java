package com.anchtun.caching.service;

import java.util.List;

import com.anchtun.caching.model.redis.Region;

public interface RegionService {

	List<Region> findAll();

	void saveAll();

	Region getById(Long id);

	Region saveInRedis(Region region);

	void deleteInRedis(Long id);

}
