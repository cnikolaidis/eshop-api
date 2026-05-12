package com.iekakmi.eshop_api.apiLayer.controllers;

import com.iekakmi.eshop_api.dataAccessLayer.services.CityService;
import com.iekakmi.eshop_api.dataAccessLayer.models.CityDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController
{
	private final CityService cityService;

	public CityController(CityService cityService)
	{
		this.cityService = cityService;
	}

	@GetMapping
	public ResponseEntity<?> getCities()
	{
		List<CityDto> response = cityService.getCities();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCityById(@PathVariable Integer id)
	{
		CityDto response = cityService.getCityById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> createCity(@Valid @RequestBody CityDto dto)
	{
		int id = cityService.createCity(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateCity(@Valid @RequestBody CityDto dto)
	{
		CityDto updated = cityService.updateCity(dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCity(@PathVariable Integer id)
	{
		cityService.deleteCity(id);
		return ResponseEntity.ok().build();
	}
}
