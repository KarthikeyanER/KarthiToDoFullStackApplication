package com.gl.todo.mapper;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.model.ToDo;

public class ToDoMapper {

	public static ToDoDTO  mapToToDoDTO(ToDo toDo) {
		ToDoDTO dto=new ToDoDTO(toDo.getId(), toDo.getTitle(), toDo.getDescription(),toDo.getIsComplete());
		
		return dto;
	}
	public static ToDo mapToToDo(ToDoDTO toDoDTO) {
		ToDo toDo=new ToDo(toDoDTO.getId(), toDoDTO.getTitle(), toDoDTO.getDescription(), toDoDTO.getIsComplete());
		return toDo;
		
	}
}
