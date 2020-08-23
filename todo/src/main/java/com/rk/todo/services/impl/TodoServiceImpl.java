package com.rk.todo.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.rk.todo.dtos.TodoBasicDetailsDTO;
import com.rk.todo.services.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	
	
	private Map<String ,List<TodoBasicDetailsDTO>> todoMap=new HashMap<>(100);
	

	@Override
	public List<TodoBasicDetailsDTO> getByUserName(String userName) {
		List<TodoBasicDetailsDTO> todoList = new ArrayList<>(1);
	
		todoList=todoMap.get(userName);
		
		if(todoList==null || todoList.isEmpty())
		{
			todoMap.put(userName, getToDoList());
			todoList=todoMap.get(userName);
		}
		
		return todoList;
	}

	@PostConstruct
	private void fillToDoList() {
		todoMap.put("RK0001", getToDoList());
		todoMap.put("RK0002", getToDoList());
		todoMap.put("RK0003", getToDoList());
		todoMap.put("RK0004", getToDoList());
		todoMap.put("RK0005", getToDoList());

	}
	
	private  List<TodoBasicDetailsDTO> getToDoList()
	{
		 List<TodoBasicDetailsDTO> todoList = new ArrayList<>(10);
			todoList.add(new TodoBasicDetailsDTO(1001, "Learn Angualer", false));
			todoList.add(new TodoBasicDetailsDTO(1002, "Learn Docker", false));
			todoList.add(new TodoBasicDetailsDTO(1003, "Learn K8S", false));
			todoList.add(new TodoBasicDetailsDTO(1004, "Read Book", false));
			
			return todoList;
	}

	@Override
	public List<TodoBasicDetailsDTO> deleteTodo(String userName, int todoId) {
		List<TodoBasicDetailsDTO> todoList = new ArrayList<>(1);
		List<TodoBasicDetailsDTO> todoListNew = new ArrayList<>(10);
		todoList=todoMap.get(userName);
		if(todoList==null || todoList.isEmpty())
		{
			new ArrayList<>();
		}
		
		for(TodoBasicDetailsDTO todo:todoList )
		{
			if(todoId==todo.getId())
			{
				continue;
			}
			
			todoListNew.add(todo);
		}
		todoMap.put(userName, todoListNew);
		return todoMap.get(userName);
	}

	@Override
	public List<TodoBasicDetailsDTO> addTodo(String userName, TodoBasicDetailsDTO todoDto) {
		List<TodoBasicDetailsDTO> todoList = new ArrayList<>(1);
		todoList=todoMap.get(userName);
		int maxId=0;

		for(TodoBasicDetailsDTO todo: todoList)
		{
			if(maxId<todo.getId())
			{
				maxId=todo.getId();
			}
		}
		todoDto.setId(maxId+1);
		todoList.add(todoDto);
		todoMap.put(userName, todoList);
		return todoMap.get(userName);
	}

}
