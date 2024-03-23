package com.todoist.todolist.service;

import com.todoist.todolist.controller.TodoRepository;
import com.todoist.todolist.entity.Todo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list(){
        Sort.by("prioridades").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll();
    }
    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    };
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    };

}
