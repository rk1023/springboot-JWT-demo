package com.rk.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rk.todo.dtos.TodoBasicDetailsDTO;
import com.rk.todo.services.TodoService;

@RestController
@CrossOrigin
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping(value = "/todo/{userName}")
	public ResponseEntity<List<TodoBasicDetailsDTO>> getTodo(@PathVariable String userName) {

		List<TodoBasicDetailsDTO> tododList = todoService.getByUserName(userName);

		return new ResponseEntity<>(tododList, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/todo/{userName}/{todoId}")
	public ResponseEntity<List<TodoBasicDetailsDTO>> deleteTodo(@PathVariable String userName,
			@PathVariable(value="todoId") int todoId) {

		List<TodoBasicDetailsDTO> tododList = todoService.deleteTodo(userName,todoId);

		return new ResponseEntity<>(tododList, HttpStatus.OK);
	}
	
	@PutMapping(value = "/todo/{userName}")
	public ResponseEntity<List<TodoBasicDetailsDTO>> addTodo(@PathVariable String userName,
			@RequestBody TodoBasicDetailsDTO todDto) {

		List<TodoBasicDetailsDTO> tododList = todoService.addTodo(userName, todDto);

		return new ResponseEntity<>(tododList, HttpStatus.OK);
	}

	
	@GetMapping(value = "/todo/welcome/msg")
	public ResponseEntity<TodoBasicDetailsDTO> getWelcomeStr2() {


		return new ResponseEntity<>(new TodoBasicDetailsDTO(1,"Message From SpringBoot App",true), HttpStatus.OK);
	}
	
	@GetMapping(value = "/todo/welcome/msg/{userName}")
	public ResponseEntity<TodoBasicDetailsDTO> getWelcomeStr3(@PathVariable String userName) {


		return new ResponseEntity<>(new TodoBasicDetailsDTO(1,"Message From SpringBoot App",true), HttpStatus.OK);
	}


}
