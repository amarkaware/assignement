package com.uxpsystems.assignement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignement.model.User;
import com.uxpsystems.assignement.service.UserService;

@RestController
@RequestMapping("/assignement")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers(){
		List<User> list=userService.getAllUserlist();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		User user=userService.getUser(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1=userService.updateUser(user);
		return new ResponseEntity<>(user1,HttpStatus.OK);
	}
	
	
	
	  @PutMapping("/user") 
	  public ResponseEntity<User> updateUser(@RequestBody User user) { 
		  User user1=userService.updateUser(user);
		  return new ResponseEntity<>(user1,HttpStatus.OK);
		  }
	 
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		User user1=userService.DeleteUser(id);
		return new ResponseEntity<>("user is deleted for id "+id,HttpStatus.OK);
	}


}
