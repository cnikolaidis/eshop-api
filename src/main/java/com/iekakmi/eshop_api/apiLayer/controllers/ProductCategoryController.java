package com.iekakmi.eshop_api.apiLayer.controllers;

import com.iekakmi.eshop_api.dataAccessLayer.services.ProductCategoryService;
import com.iekakmi.eshop_api.dataAccessLayer.models.ProductCategoryDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController
{
	private final ProductCategoryService productCategoryService;

	public ProductCategoryController(ProductCategoryService productCategoryService)
	{
		this.productCategoryService = productCategoryService;
	}

	@GetMapping
	public ResponseEntity<?> getProductCategories()
	{
		List<ProductCategoryDto> response = productCategoryService.getProductCategories();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductCategoryById(@PathVariable Integer id)
	{
		ProductCategoryDto response = productCategoryService.getProductCategoryById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> createProductCategory(@Valid @RequestBody ProductCategoryDto dto)
	{
		int id = productCategoryService.createProductCategory(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateProductCategory(@Valid @RequestBody ProductCategoryDto dto)
	{
		ProductCategoryDto updated = productCategoryService.updateProductCategory(dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductCategory(@PathVariable Integer id)
	{
		productCategoryService.deleteProductCategory(id);
		return ResponseEntity.ok().build();
	}
}
