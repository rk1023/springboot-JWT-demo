package com.rk.todo.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.todo.dtos.BasicAuthDTO;

@RestController
@CrossOrigin
public class BasicAuthController {

	@GetMapping(value = "/basicAuth")
	public ResponseEntity<BasicAuthDTO> basicAuth() {



		return new ResponseEntity<>(new BasicAuthDTO("Loggedin Success"), HttpStatus.OK);
	}

}
