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

import com.gl.todo.model.ToDo;
import com.gl.todo.service.ToDoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
@Autowired
ToDoService service;
@PostMapping
	ResponseEntity<ToDo> createToDo(@RequestBody ToDo todo){
		ToDo newToDo=service.createToDo(todo);
		return new ResponseEntity<ToDo>(newToDo, HttpStatus.CREATED);
		
	}
@GetMapping
ResponseEntity<List<ToDo>> getAllToDo(){
	List<ToDo> list=service.getAllToDo();
	return new ResponseEntity(list, HttpStatus.OK);
	
}
@GetMapping("/{id}")
ResponseEntity<ToDo> getToDoById(@PathVariable int id){
	ToDo newToDo=service.getToDoById(id);
	return new ResponseEntity<ToDo>(newToDo, HttpStatus.OK);
	
}
@PutMapping("/{id}")
ResponseEntity<ToDo> createToDo(@PathVariable int id,@RequestBody ToDo todo){
	ToDo newToDo=service.updateToDoById(id, todo);
	return new ResponseEntity<ToDo>(newToDo, HttpStatus.OK);
	
}
@DeleteMapping("/{id}")
ResponseEntity deleteToDoById(@PathVariable int id){
	service.deleteToDoById(id);
	return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
	
}
@GetMapping("complete/{id}")
ResponseEntity<ToDo> completeToDoById(@PathVariable int id){
	ToDo todo=service.completeTodo(id);
	return new ResponseEntity(todo, HttpStatus.OK);
	
}
@GetMapping("incomplete/{id}")
ResponseEntity inCompleteToDoById(@PathVariable int id){
	ToDo todo=service.inCompleteTodo(id);
	return new ResponseEntity(todo, HttpStatus.OK);
	
}
}
