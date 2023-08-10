package com.anchtun.caching.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.anchtun.caching.mapper.RegionMapper;
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
	public void saveAll() {
		List<RegionEntity> listRegion = regionRepository.findAll();
		if (Objects.nonNull(listRegion) && !listRegion.isEmpty()) {
			listRegion.forEach(r -> {
				Region region = RegionMapper.mapFromRegionEntity(r);
				template.opsForHash().put(HASH_KEY, region.getId(), region);
			});
		}
	}

	@Override
	public Region getById(Long id) {
		return (Region) template.opsForHash().get(HASH_KEY, id);
	}

//	 public Product save(Product product){
//	        template.opsForHash().put(HASH_KEY,product.getId(),product);
//	        return product;
//	    }

}
