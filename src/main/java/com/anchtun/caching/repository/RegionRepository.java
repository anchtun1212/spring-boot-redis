package com.anchtun.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anchtun.caching.model.entity.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {
}