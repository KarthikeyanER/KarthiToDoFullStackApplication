package com.gl.todo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.todo.exception.ResourceNotFoundException;
import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.mapper.ToDoMapper;
import com.gl.todo.model.ToDo;
import com.gl.todo.repository.ToDoRepository;
import com.gl.todo.service.ToDoService;
@Service
public class ToDoServiceImpl implements ToDoService{
	@Autowired
ToDoRepository toDoRepository;
	@Override
	public ToDoDTO createToDo(ToDoDTO dto) {
		// TODO Auto-generated method stub
		ToDo todo=ToDoMapper.mapToToDo(dto);
		ToDo toDo=toDoRepository.save(todo);
		return ToDoMapper.mapToToDoDTO(toDo);
	}

	@Override
	public List<ToDoDTO> getAllToDo() {
	
		// TODO Auto-generated method stub
		List<ToDo> list=toDoRepository.findAll();
		return list.stream().map((todo)->ToDoMapper.mapToToDoDTO(todo)).collect(Collectors.toList());
	}

	@Override
	public ToDoDTO getToDoById(int id) {
		ToDo todo=toDoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ToDo with id "+id+" does not exists"));
		return ToDoMapper.mapToToDoDTO(todo);
	}

	@Override
	public ToDoDTO updateToDoById(int id, ToDoDTO todo) {
		// TODO Auto-generated method stub
	ToDo oldToDo=toDoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ToDo is not exists with given id: " +id));
		

			
			oldToDo.setTitle(todo.getTitle());
			oldToDo.setDescription(todo.getDescription());
			oldToDo.setIsComplete(todo.getIsComplete());
			 ToDo newToDo=toDoRepository.save(oldToDo);
		
		return ToDoMapper.mapToToDoDTO(newToDo);
		
	
	}

	@Override
	public void deleteToDoById(int id) {
		// TODO Auto-generated method stub
		ToDo toDo=toDoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ToDo is not exists with id: "+id));
		toDoRepository.delete(toDo);
	}

	@Override
	public ToDoDTO inCompleteTodo(int id) {
		// TODO Auto-generated method stub
		
		ToDo todo=toDoRepository.findById(id).get();
		if(todo.getIsComplete().equals("Yes")){
			todo.setIsComplete("No");
			
		}
	ToDo toDo=toDoRepository.save(todo);
		return ToDoMapper.mapToToDoDTO(toDo);
		
		
	}

	@Override
	public ToDoDTO completeTodo(int id) {
		// TODO Auto-generated method stub
		
		ToDo todo=toDoRepository.findById(id).get();
		if(todo.getIsComplete().equals("No")){
			todo.setIsComplete("Yes");
			
		}
		ToDo toDo= toDoRepository.save(todo);
		return ToDoMapper.mapToToDoDTO(toDo);
	}
	

}
