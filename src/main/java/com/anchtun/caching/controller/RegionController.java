package com.anchtun.caching.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.caching.model.redis.Region;
import com.anchtun.caching.service.RegionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/region")
public class RegionController {

	private final RegionService regionService;

	@GetMapping("/getAll")
	public List<Region> getAllRegions() {
		return regionService.findAll();
	}

	@PostMapping("/saveAllInRedis")
	public void saveAll() {
		regionService.saveAllInRedis();
	}

}
