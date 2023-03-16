package com.virtualcommerce.backend.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcommerce.backend.dto.UserDto;
import com.virtualcommerce.backend.dto.UserLoginDto;
import com.virtualcommerce.backend.repository.AuthorizationRepository;


@CrossOrigin(origins = "*") 
@RestController 
@RequestMapping("/authorization")
public class AuthorizationController {

    Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	
    @Autowired
	private AuthorizationRepository authRepository;
	
	@PostMapping("/register")
	public ResponseEntity<HttpStatus> register(@RequestBody UserDto user) {
	
		try {
			
			if(user.getEmail() == null) return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
			
			Optional<UserDto> userExist = authRepository.findByEmail(user.getEmail());

			
			if(userExist.isPresent()){
				return ResponseEntity.badRequest().body(HttpStatus.ALREADY_REPORTED);
			}
			
			authRepository.save(user);

			return ResponseEntity.ok(HttpStatus.CREATED);
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
		}
		
	
	}
	
	@PostMapping( path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> login(
			@RequestBody UserLoginDto user
		) {
		
		
		if(user.getEmail() == null || user.getPassword() == null) return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
		
		
		try { 
			
			Optional<UserDto> userExist = authRepository.findByEmail(user.getEmail());
			
			if(userExist.isPresent()) {
				if(userExist.get().getEmail().equals(user.getEmail()) && userExist.get().getPassword().equals(user.getPassword())) {
					return ResponseEntity.ok(HttpStatus.OK);
				} else {
					return ResponseEntity.badRequest().body(HttpStatus.UNAUTHORIZED);
				}
			}

			return ResponseEntity.badRequest().body(HttpStatus.UNAUTHORIZED);
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
			
		}
		

	}
}
