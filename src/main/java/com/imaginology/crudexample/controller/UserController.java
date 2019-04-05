package com.imaginology.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imaginology.crudexample.dto.UserDto;
import com.imaginology.crudexample.entity.User;
import com.imaginology.crudexample.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getalluser", method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public UserDto getUser(@PathVariable("userId") Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public List<User> createUser(@RequestBody UserDto user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(value="/userdata", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public List<User> createUserData(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
}
