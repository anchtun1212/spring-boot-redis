package com.anchtun.caching.controller.redis;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.caching.model.redis.Region;
import com.anchtun.caching.service.RegionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/redis/region")
public class RegionRedisController {

	private final RegionService regionService;

	@GetMapping("/getAll")
	public List<Region> getAllRegions() {
		return regionService.findAll();
	}

	@PostMapping("/saveAll")
	public void saveAll() {
		regionService.saveAll();
	}
	
	@GetMapping("/{id}")
	public Region getById(@PathVariable Long id) {
		return regionService.getById(id);
	}

}
