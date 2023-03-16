package com.virtualcommerce.backend.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcommerce.backend.dto.CommerceDto;
import com.virtualcommerce.backend.repository.CommerceRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/commerce")
public class CommerceController {

    Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
    
    @Autowired
    private CommerceRepository commerceRepository;
    
    
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody CommerceDto commerce) {
    	
    	try {

    		if(commerce.getName() == null || commerce.getName() == "")
    			return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    		
    		commerceRepository.save(commerce);

    		return ResponseEntity.ok(HttpStatus.CREATED);
    		
    	} catch( Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    	}

    	
    	
    }
    
    @GetMapping("/get")
    public ResponseEntity<Object> getData(@RequestParam Integer id) {
    	
    	try {
    		
    		if(id == null) return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    		
    		Optional<CommerceDto> commerce = commerceRepository.findById(id);
    		
    		if(commerce.isEmpty()) {
    			return ResponseEntity.badRequest().body(HttpStatus.NOT_FOUND);
    		}
    		
    		return ResponseEntity.ok(commerce);
    		
    		
    	} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    		
    	}
    }
	
}