package com.anchtun.caching.service;

import java.util.List;

import com.anchtun.caching.model.redis.Region;

public interface RegionService {

	List<Region> findAll();

	void saveAllInRedis();

}
