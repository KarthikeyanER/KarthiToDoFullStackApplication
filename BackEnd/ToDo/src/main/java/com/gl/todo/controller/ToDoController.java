package com.gl.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.model.ToDo;
import com.gl.todo.service.ToDoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
@Autowired
ToDoService service;
@PostMapping
	ResponseEntity<ToDoDTO> createToDo(@RequestBody ToDoDTO dto){
		ToDoDTO newToDo=service.createToDo(dto);
		return new ResponseEntity<ToDoDTO>(newToDo, HttpStatus.CREATED);
		
	}
@GetMapping
ResponseEntity<List<ToDoDTO>> getAllToDo(){
	List<ToDoDTO> list=service.getAllToDo();
	return new ResponseEntity(list, HttpStatus.OK);
	
}
@GetMapping("/{id}")
ResponseEntity<ToDoDTO> getToDoById(@PathVariable int id){
	ToDoDTO newToDo=service.getToDoById(id);
	return new ResponseEntity<ToDoDTO>(newToDo, HttpStatus.OK);
	
}
@PutMapping("/{id}")
ResponseEntity<ToDoDTO> createToDo(@PathVariable int id,@RequestBody ToDoDTO todo){
	ToDoDTO newToDo=service.updateToDoById(id, todo);
	return new ResponseEntity<ToDoDTO>(newToDo, HttpStatus.OK);
	
}
@DeleteMapping("/{id}")
ResponseEntity deleteToDoById(@PathVariable int id){
	service.deleteToDoById(id);
	return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
	
}
@GetMapping("complete/{id}")
ResponseEntity<ToDoDTO> completeToDoById(@PathVariable int id){
	ToDoDTO todo=service.completeTodo(id);
	return new ResponseEntity(todo, HttpStatus.OK);
	
}
@GetMapping("incomplete/{id}")
ResponseEntity inCompleteToDoById(@PathVariable int id){
	ToDoDTO todo=service.inCompleteTodo(id);
	return new ResponseEntity(todo, HttpStatus.OK);
	
}
}
