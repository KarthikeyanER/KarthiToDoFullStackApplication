package com.gl.todo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.todo.model.ToDo;
import com.gl.todo.repository.ToDoRepository;
import com.gl.todo.service.ToDoService;
@Service
public class ToDoServiceImpl implements ToDoService{
	@Autowired
ToDoRepository toDoRepository;
	@Override
	public ToDo createToDo(ToDo todo) {
		// TODO Auto-generated method stub
		return toDoRepository.save(todo);
	}

	@Override
	public List<ToDo> getAllToDo() {
		// TODO Auto-generated method stub
		return toDoRepository.findAll();
	}

	@Override
	public ToDo getToDoById(int id) {
		// TODO Auto-generated method stub
		return toDoRepository.findById(id).get();
	}

	@Override
	public ToDo updateToDoById(int id, ToDo todo) {
		// TODO Auto-generated method stub
		Optional<ToDo> newToDo=toDoRepository.findById(id);
		
		if(newToDo.isPresent()) {
			ToDo oldToDo=newToDo.get();
			oldToDo.setTitle(todo.getTitle());
			oldToDo.setDescription(todo.getDescription());
			oldToDo.setIsComplete(todo.getIsComplete());
			 toDoRepository.save(oldToDo);
		}
		
		return todo;
	}

	@Override
	public void deleteToDoById(int id) {
		// TODO Auto-generated method stub
		Optional<ToDo> toDo=toDoRepository.findById(id);
		toDoRepository.delete(toDo.get());
	}

	@Override
	public ToDo inCompleteTodo(int id) {
		// TODO Auto-generated method stub
		
		ToDo todo=toDoRepository.findById(id).get();
		if(todo.getIsComplete().equals("Yes")){
			todo.setIsComplete("No");
			
		}
		return toDoRepository.save(todo);
		
		
	}

	@Override
	public ToDo completeTodo(int id) {
		// TODO Auto-generated method stub
		
		ToDo todo=toDoRepository.findById(id).get();
		if(todo.getIsComplete().equals("No")){
			todo.setIsComplete("Yes");
			
		}
		return toDoRepository.save(todo);
	}
	

}
