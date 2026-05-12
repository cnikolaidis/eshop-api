package com.iekakmi.eshop_api.apiLayer.controllers;

import com.iekakmi.eshop_api.dataAccessLayer.services.OrderItemService;
import com.iekakmi.eshop_api.dataAccessLayer.models.OrderItemDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController
{
	private final OrderItemService orderItemService;

	public OrderItemController(OrderItemService orderItemService)
	{
		this.orderItemService = orderItemService;
	}

	@GetMapping
	public ResponseEntity<?> getOrderItems()
	{
		List<OrderItemDto> response = orderItemService.getOrderItems();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderItemById(@PathVariable Integer id)
	{
		OrderItemDto response = orderItemService.getOrderItemById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> createOrderItem(@RequestBody OrderItemDto dto)
	{
		int id = orderItemService.createOrderItem(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrderItem(@PathVariable Integer id)
	{
		orderItemService.deleteOrderItem(id);
		return ResponseEntity.ok().build();
	}
}
