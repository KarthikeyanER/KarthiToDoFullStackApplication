package com.gl.todo.service;

import java.util.List;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.model.ToDo;

public interface ToDoService {
	ToDoDTO createToDo(ToDoDTO dto);
	List<ToDoDTO> getAllToDo();
	ToDoDTO getToDoById(int id);
	ToDoDTO updateToDoById(int id,ToDoDTO dto);
	void deleteToDoById(int id);
	public ToDoDTO inCompleteTodo(int id);
	public ToDoDTO completeTodo(int id);
	

}
