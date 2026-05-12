package com.iekakmi.eshop_api.apiLayer.controllers;

import com.iekakmi.eshop_api.dataAccessLayer.services.ProductService;
import com.iekakmi.eshop_api.dataAccessLayer.models.ProductDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
	private final ProductService productService;

	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<?> getProducts()
	{
		List<ProductDto> response = productService.getProducts();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id)
	{
		ProductDto response = productService.getProductById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto dto)
	{
		int id = productService.createProduct(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto dto)
	{
		ProductDto updated = productService.updateProduct(dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id)
	{
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
}
