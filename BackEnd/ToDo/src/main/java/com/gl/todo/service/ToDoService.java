package com.gl.todo.service;

import java.util.List;

import com.gl.todo.model.ToDo;

public interface ToDoService {
	ToDo createToDo(ToDo todo);
	List<ToDo> getAllToDo();
	ToDo getToDoById(int id);
	ToDo updateToDoById(int id,ToDo todo);
	void deleteToDoById(int id);
	public ToDo inCompleteTodo(int id);
	public ToDo completeTodo(int id);
	

}
