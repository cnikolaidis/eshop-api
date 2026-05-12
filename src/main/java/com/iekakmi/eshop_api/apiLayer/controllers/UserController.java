package com.iekakmi.eshop_api.apiLayer.controllers;

import com.iekakmi.eshop_api.dataAccessLayer.services.UserService;
import com.iekakmi.eshop_api.dataAccessLayer.models.UserDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
	private final UserService userService;

	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<?> getUsers()
	{
		List<UserDto> response = userService.getUsers();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id)
	{
		UserDto response = userService.getUserById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto dto)
	{
		int id = userService.createUser(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(
			@PathVariable Integer id, @Valid @RequestBody UserDto dto)
	{
		dto.setId(id);
		UserDto updated = userService.updateUser(dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id)
	{
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
}
