package com.series.ratings.webseries.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.series.ratings.webseries.entity.User;
import com.series.ratings.webseries.request.UserRequestDTO;
import com.series.ratings.webseries.response.UserResponseDTO;
import com.series.ratings.webseries.service.IUserService;

@RestController
@RequestMapping("/reviewer/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	public IUserService userService;
	
	public UserController(IUserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable("name") String name) {
		return new ResponseEntity<UserResponseDTO>(userService.getUser(name),HttpStatus.OK);
	}
	
	@GetMapping(path = "/list")
	public ResponseEntity<List<UserResponseDTO>> getUserList(User request) {
		return new ResponseEntity<List<UserResponseDTO>>(userService.getUserList(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO user) {
		return new ResponseEntity<UserResponseDTO>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<User> deleteUser(@RequestParam("name") String name) {
		return new ResponseEntity<User>(userService.deleteUser(name), HttpStatus.OK);
	}

}
