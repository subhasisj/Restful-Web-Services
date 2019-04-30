package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService daoService;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return daoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id ) {
		
		User user = daoService.findOne(id);
		if (user == null) {
			
			throw new UserNotFoundException("id : "+ id);
		}
		
		return user;
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = daoService.deleteById(id);
		
		if (user == null) {
			throw new UserNotFoundException("id : "+ id);
		}
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		
		User savedUser = daoService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
								.path("/{id}")
								.buildAndExpand(savedUser.getId())
								.toUri();
		
		return ResponseEntity.created(location).build();
		
	}

}
