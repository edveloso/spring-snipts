package br.com.edveloso.snipts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edveloso.snipts.model.User;
import br.com.edveloso.snipts.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping()
	public ResponseEntity<List<User>> listUser(){
		
		List<User> findAll = userRepository.findByAndSort("da Silva",  Sort.by("name"));   
		
		return  ResponseEntity.ok(findAll);
	}
	
	@PostMapping()
	public ResponseEntity<?> addUser(@Valid @RequestBody User user){
		
		User userDB = userRepository.save(user);
		
		return ResponseEntity.ok(userDB);
	}
	
	
}
