package com.iekakmi.eshop_api.apiLayer.controllers;

import com.iekakmi.eshop_api.dataAccessLayer.services.OrderService;
import com.iekakmi.eshop_api.dataAccessLayer.models.OrderDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
	private final OrderService orderService;

	public OrderController(OrderService orderService)
	{
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<?> getOrders()
	{
		List<OrderDto> response = orderService.getOrders();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Integer id)
	{
		OrderDto response = orderService.getOrderById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDto dto)
	{
		int id = orderService.createOrder(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateOrder(
			@PathVariable Integer id, @Valid @RequestBody OrderDto dto)
	{
		dto.setId(id);
		OrderDto updated = orderService.updateOrder(dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer id)
	{
		orderService.deleteOrder(id);
		return ResponseEntity.ok().build();
	}
}
