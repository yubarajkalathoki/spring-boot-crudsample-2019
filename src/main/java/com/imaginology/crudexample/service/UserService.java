package com.imaginology.crudexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginology.crudexample.dto.UserDto;
import com.imaginology.crudexample.entity.User;
import com.imaginology.crudexample.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> createUser(UserDto userDto) {
		User user = new User();
		user.setGender(userDto.getGender());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		userRepository.save(user);
		List<User> users = userRepository.findAll();
		return users;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public UserDto getUser(Long id) {
		User user = userRepository.getOne(id);
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setGender(user.getGender());
		userDto.setPassword(user.getPassword());
		userDto.setUsername(user.getUsername());
		return userDto;
	}
}
