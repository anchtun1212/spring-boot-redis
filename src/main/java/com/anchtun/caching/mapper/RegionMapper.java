package com.anchtun.caching.mapper;

import java.util.Objects;

import com.anchtun.caching.model.entity.RegionEntity;
import com.anchtun.caching.model.redis.Region;

public class RegionMapper {

	public static Region mapFromRegionEntity(RegionEntity regionEntity) {
		Region region = null;
		if (Objects.nonNull(regionEntity)) {
			region = Region.builder()
					.id(regionEntity.getId())
					.nameAr(regionEntity.getNameAr())
					.nameEn(regionEntity.getNameEn())
					.build();
		}
		return region;
	}

}
