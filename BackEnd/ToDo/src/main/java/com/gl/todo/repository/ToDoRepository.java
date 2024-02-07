package com.gl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.todo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}
