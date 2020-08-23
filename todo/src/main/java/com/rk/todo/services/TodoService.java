package com.rk.todo.services;

import java.util.List;

import com.rk.todo.dtos.TodoBasicDetailsDTO;

public interface TodoService {
	
	List<TodoBasicDetailsDTO> getByUserName(String userName);
	List<TodoBasicDetailsDTO> deleteTodo(String userName, int todoId);
	List<TodoBasicDetailsDTO> addTodo(String userName, TodoBasicDetailsDTO todoDto);


}
