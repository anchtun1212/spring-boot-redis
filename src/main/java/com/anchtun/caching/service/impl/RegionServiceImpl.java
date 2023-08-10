package com.anchtun.caching.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.anchtun.caching.model.entity.RegionEntity;
import com.anchtun.caching.model.redis.Region;
import com.anchtun.caching.repository.RegionRepository;
//import com.anchtun.caching.repository.RegionRepository;
import com.anchtun.caching.service.RegionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegionServiceImpl implements RegionService {

	public static final String HASH_KEY = "Region";

	private final RedisTemplate template;
	private final RegionRepository regionRepository;

	@Override
	public List<Region> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	@Override
	public void saveAllInRedis() {
		List<RegionEntity> listRegion = regionRepository.findAll();
		if (Objects.nonNull(listRegion) && !listRegion.isEmpty()) {
			listRegion.forEach(r -> {
				template.opsForHash().put(HASH_KEY, r.getId(), r);
			});
		}

	}

//	 public Product save(Product product){
//	        template.opsForHash().put(HASH_KEY,product.getId(),product);
//	        return product;
//	    }

}
